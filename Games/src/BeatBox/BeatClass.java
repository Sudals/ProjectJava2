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
    JLabel bgLabel2;
    JButton bgList;
    JButton leftList;
    JButton rightList;
    JLabel logoLabel;
    JPanel contentPanel;
    CardLayout cardLayout;
    public  BeatClass(){
        JFrame frame = new JFrame("Image Scaling Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Game");
        frame.setSize(900, 600);  // ȭ�� ũ�� ����
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(900,600);
        JPanel mainPanel = new JPanel(new BorderLayout());
        cardLayout = new CardLayout();
        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);
        frame.add(contentPanel);
        introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        // ��� �̹��� �߰�
        bgLabel = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        bgLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        bgLabel2 = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        bgLabel2.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        // ��� �̹��� ũ�� ����
        bgLabel.setBounds(0, 0, getWidth(), getHeight());
        bgLabel2.setBounds(0, 0, getWidth(), getHeight());
        Image logoImage = new ImageIcon(getClass().getResource("../images/logoImage.png")).getImage();
        logoLabel = new JLabel(new ImageIcon(logoImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(300, 50, 300, 150);
        //bgLabel.add(logoLabel);
        logoLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        contentPanel.add(panel,"selectWindows");
        //mainPanel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        contentPanel.add(mainPanel,"mainWindows");
        //add(bgList);
        mainPanel.add(bgLabel);



        //bgList.setVisible(false);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Image centerImage = new ImageIcon(getClass().getResource("../images/꼬부기.png")).getImage();
        bgList = new JButton(new ImageIcon(centerImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

        bgList.setBorder(BorderFactory.createLineBorder(Color.RED));
        bgList.setBounds(300, 150, 300, 300);
        // JLabel 추가
        panel.add(bgLabel2);
        bgLabel2.add(bgList);
        bgLabel.add(logoLabel);

        //cardLayout.next(contentPanel);
        //cardLayout.show(contentPanel,"mainWindows");
        Image leftImage = new ImageIcon(getClass().getResource("../images/꼬부기.png")).getImage();
        leftList = new JButton(new ImageIcon(leftImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        leftList.setVerticalAlignment(JLabel.CENTER);
        leftList.setHorizontalAlignment(JLabel.CENTER);
       leftList.setBounds(50,270,150,150);
        // JLabel 추가
        bgLabel2.add(leftList);
        Image rightImage = new ImageIcon(getClass().getResource("../images/꼬부기.png")).getImage();
        rightList = new JButton(new ImageIcon(rightImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        rightList.setVerticalAlignment(JLabel.CENTER);
        rightList.setHorizontalAlignment(JLabel.CENTER);
        rightList.setBounds(700,270,150,150);
        // JLabel 추가
        bgLabel2.add(rightList);
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

        frame.setVisible(true);

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
