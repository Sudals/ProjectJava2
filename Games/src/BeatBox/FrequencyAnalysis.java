package BeatBox;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.util.ArrayList;
import java.util.List;

public class FrequencyAnalysis {
    public  List<Double> onsets= new ArrayList<Double>();
    public List<Double> times= new ArrayList<Double>();
    public void mainEvent() {
        try {
            onsets.clear();
            times.clear();
            System.out.println(BeatClass.nName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource(BeatClass.nName));
            AudioFormat format = audioInputStream.getFormat();
            int numChannels = format.getChannels();
            float sampleRate = format.getSampleRate();

            byte[] buffer = new byte[4096];
            int bytesRead;
            int totalSamples = 0;

            long totalFrames = audioInputStream.getFrameLength(); // 총 프레임 수
            float frameRate = format.getFrameRate(); // 프레임 속도
            float durationInSeconds = totalFrames / frameRate; // 재생 시간 (초)
            System.out.println("재생 시간: " + durationInSeconds + "초");

            double threshold = 0.99999; // 에너지 임계값
            List<Double> tonsets= new ArrayList<Double>();
             List<Double> ttimes= new ArrayList<Double>();
            int sa=0;
            while ((bytesRead = audioInputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i += numChannels * 2) {
                    int sample = getSample(buffer, i, format.isBigEndian());
                    double amplitude = calculateAmplitude(sample);
                    double currentTime = (double) totalSamples / sampleRate;
                    ttimes.add(currentTime);
                    totalSamples++;
                    tonsets.add(amplitude);

                }
            }
            for(int i =1;i<tonsets.stream().count();i++){
                if ( tonsets.get(i) > threshold&&tonsets.get(i+1)<tonsets.get(i)&&tonsets.get(i-1)<tonsets.get(i)) {
                    sa++;
                    times.add(ttimes.get(i));
                    onsets.add(tonsets.get(i));
                    //System.out.println(sa+" Onset detected at " + ttimes.get(i) + " seconds"+" f : "+tonsets.get(i));
                }
            }
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getSample(byte[] buffer, int offset, boolean bigEndian) {
        int low = buffer[offset];
        int high = buffer[offset + 1];
        if (bigEndian) {
            return (high << 8) | (low & 0xFF);
        } else {
            return (low << 8) | (high & 0xFF);
        }
    }

    private static double calculateAmplitude(int sample) {
        double normalizedSample = sample / 32768.0; // 샘플 값을 [-1, 1] 범위로 정규화합니다.
        double amplitude = Math.abs(normalizedSample); // 샘플 값의 절댓값을 계산합니다.
        return amplitude;
    }
}