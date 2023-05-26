package BeatBox;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class FrequencyAnalysis {
    public static void mainEvent() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    FrequencyAnalysis.class.getResourceAsStream("../Resources/Avicii-Levels.wav"));

            // 오디오 포맷 정보 가져오기
            AudioFormat format = audioInputStream.getFormat();

            // WAV 파일의 샘플 수 계산
            int sampleSize = (int) audioInputStream.getFrameLength() * format.getFrameSize();

            // WAV 파일의 오디오 데이터 읽기
            byte[] audioData = new byte[sampleSize];
            audioInputStream.read(audioData);

            // 주파수 분석을 위한 FFT 객체 생성
            FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);

            // 오디오 데이터를 복소수 형태로 변환
            Complex[] complexData = new Complex[sampleSize / 2];
            for (int i = 0; i < sampleSize / 2; i++) {
                double real = (double) audioData[2 * i] / 32768.0; // 정규화
                double imaginary = (double) audioData[2 * i + 1] / 32768.0; // 정규화
                complexData[i] = new Complex(real, imaginary);
            }
            int inputSize = complexData.length;
            int fftSize = 1;
            while (fftSize < inputSize) {
                fftSize *= 2;
            }

            // 입력 데이터를 패딩하여 크기를 2의 제곱수로 조정합니다.
            Complex[] paddedData = new Complex[fftSize];
            System.arraycopy(complexData, 0, paddedData, 0, inputSize);
            for (int i = inputSize; i < fftSize; i++) {
                paddedData[i] = Complex.ZERO;
            }
            // 주파수 영역 변환 (FFT)
            Complex[] frequencies = transformer.transform(paddedData, TransformType.FORWARD);
            double sampleRate = 44100; // 샘플 레이트 설정 (예: 44.1kHz)
            double timeIncrement = 1.0 / sampleRate;
            double[] time = new double[fftSize];
            for (int i = 0; i < fftSize; i++) {
                time[i] = i * timeIncrement;
            }

            // 결과 출력
            for (int i = 0; i < frequencies.length; i++) {
                double frequency = i * sampleRate / fftSize;
                System.out.println("Time: " + time[i] + " s, Frequency: " + frequency + " Hz, Magnitude: " + frequencies[i].abs());
            }
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}