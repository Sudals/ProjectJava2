package BeatBox;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class BeatClass extends JFrame implements ActionListener {
    JButton startButton, settingButton, rankButton, quitButton;
    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;
    public void Paint(Graphics e){
        screenImage = createImage(900,600);
        screenGraphic =screenImage.getGraphics();
        screenDraw(screenGraphic);
        e.drawImage(screenImage,0,0,null);
    }
    public void screenDraw(Graphics e){
        e.drawImage(introBackground,0,0,null);
        this.repaint();
    }
    JLabel bgLabel;
    JLabel bgList;
    JLabel logoLabel;
    public  BeatClass(){
        setTitle("My Game");
        setSize(900, 600);  // ȭ�� ũ�� ����
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        // ��� �̹��� �߰�
        bgLabel = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        add(bgLabel);

        // ��� �̹��� ũ�� ����
        bgLabel.setBounds(0, 0, getWidth(), getHeight());


        Image logoImage = new ImageIcon(getClass().getResource("../images/logoImage.png")).getImage();
        logoLabel = new JLabel(new ImageIcon(logoImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(300, 50, 300, 150);
        bgLabel.add(logoLabel);


        bgList = new JLabel(new ImageIcon(getClass().getResource("../images/introBackground.jpg")));
        //add(bgList);


        //bgList.setVisible(false);



        // ���� ���� ��ư �߰�

        Image startImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
        startButton = new JButton(new ImageIcon(startImage.getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
        startButton.addActionListener(this);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setBounds(375, 200, 150, 40); // startButton�� ��ġ�� ũ�� ����
        startButton.setContentAreaFilled(false);
       bgLabel.add(startButton);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedStartImage = new ImageIcon(getClass().getResource("../images/pressedStartButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(pressedStartImage.getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image startImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(startImage.getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
            }
        });

        // ���� ��ư �߰�
        settingButton = new JButton("Setting");
        settingButton.addActionListener(this);
        settingButton.setBounds(400, 260, 100, 30);
        settingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bgLabel.add(settingButton);

        // ��ũ ��ư �߰�
        rankButton = new JButton("Rank");
        rankButton.addActionListener(this);
        rankButton.setBounds(400, 320, 100, 30);
        rankButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bgLabel.add(rankButton);

        // ���� ��ư �߰�
        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        quitButton.setBounds(400, 440, 100, 30); // ��ư ��ġ ����
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bgLabel.add(quitButton);

        startButton.setBounds(375, 250, 150, 40);
        settingButton.setBounds(400, 310, 100, 30);
        rankButton.setBounds(400, 370, 100, 30);
        quitButton.setBounds(400, 490, 100, 30);

        setVisible(true);

        Music introMusic = new Music("mus1.mp3",true);
        introMusic.start();
    }

    public void SetListWindows(boolean active){
        startButton.setVisible(!active);
        settingButton.setVisible(!active);
        rankButton.setVisible(!active);
        quitButton.setVisible(!active);
        logoLabel.setVisible(!active);
        //bgLabel.setVisible(!active);
        if(active){

        }else{

        }
        //bgLabel = new JLabel(new ImageIcon(getClass().getResource("../images/introBackground.jpg")));

    }
    public void actionPerformed(ActionEvent e) {
        // ��ư�� ������ �� ����� �ڵ� �߰�
        if (e.getSource() == startButton) {
            //System.exit(0);
            SetListWindows(true);
        } else if (e.getSource() == settingButton) {
            // Setting ��ư�� ������ �� ����� �ڵ� �߰�
        } else if (e.getSource() == rankButton) {
            // Rank ��ư�� ������ �� ����� �ڵ� �߰�
        } else if (e.getSource() == quitButton) {
            // Quit ��ư�� ������ �� ����� �ڵ� �߰�
            System.exit(0);
        }
    }
}
