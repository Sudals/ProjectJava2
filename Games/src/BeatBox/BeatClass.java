package BeatBox;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class BeatClass extends JFrame implements ActionListener {



    private ImageIcon homeImage;
    private ImageIcon rankhomeImage;
    private JButton soundButton;
    private ImageIcon soundImage;
    private ImageIcon noSoundImage;
    private boolean isSoundOn;



    private JLabel loadingLabel;
    public int Score=0;
    private static final int LOADING_TIME = 10000;

    JButton menuButton, logoButton, startButton, settingButton, rankButton, quitButton, pause_ExitButton,pause_MenuButton, homeButton, rankhomeButton, gameBackbutton;
    JLabel escLabel;
    boolean gamePanelActive = false; // gamePanel이 켜져 있는지 여부를 저장
    private boolean escPressed = false; // ESC 키 눌림 여부를 저장
    public void setEscPressed(boolean pressed){
        escPressed = pressed;
    }



    private void showLoadingScreen() {
        ImageIcon loadingIcon = new ImageIcon(getClass().getResource("images/loading2.gif"));
        loadingLabel = new JLabel(loadingIcon);
        loadingLabel.setBackground(Color.BLACK);
        loadingLabel.setOpaque(true);
        loadingLabel.setBounds(0, 0, loadingIcon.getIconWidth(), loadingIcon.getIconHeight());

       //이미지 중앙배치
        int loadingX = (getWidth() - loadingIcon.getIconWidth()) / 2;
        int loadingY = (getHeight() - loadingIcon.getIconHeight()) / 2;

        loadingLabel.setBounds(loadingX, loadingY, loadingIcon.getIconWidth(), loadingIcon.getIconHeight());
        contentPanel.add(loadingLabel, "loadingScreen");
        cardLayout.show(contentPanel, "loadingScreen");
        Timer timer = new Timer(LOADING_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "gameWindows");
                GameStart(MusicList.get(selNum).name.split("\\.")[0], "T", MusicList.get(selNum).name);
                introMusic.close();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }



    public boolean isGamePanelActive() {
        return gamePanelActive;
    }

    public boolean isEscPressed() {
        return escPressed;
    }

    public JLabel getEscLabel() {
        return escLabel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }


    private BeatClass beatClass;

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
    public static Game game;
    JLabel scorenumberLabel;
    JLabel settingLabel;
    JLabel rankLabel;
    JLabel bgLabel;
    JLabel bgLabel2;
    JButton bgList;
    JButton leftList;
    JButton rightList;
    JLabel logoLabel;
    JPanel contentPanel;
    CardLayout cardLayout;
    JPanel gamePanel;

    JLabel gameLabel;
    JLabel gifBackGround;

    JLabel mtextLabel;
    JLabel ltextLabel;
    JLabel rtextLabel;
    public ArrayList<JLabel> effect=new ArrayList<JLabel>();
    ArrayList<JLabel> effectPanel=new ArrayList<JLabel>();
    ArrayList<JLabel> safePanel=new ArrayList<JLabel>();
    JLabel gamePanel2;
    JLabel gamePanel3;
    JLabel gamePanel4;
    JLabel gamePanel5;
    JLabel gamePanel6;
    ArrayList<SoundPack> MusicList = new ArrayList<SoundPack>();
    int selNum;
    int endNum;
    int startNum;
    JPanel mainPanel;
    JPanel settingPanel;
    JPanel rankPanel;

    Music introMusic;

    java.util.List<Note> noteList1 = new CopyOnWriteArrayList<>();
    java.util.List<Note> noteList2 = new CopyOnWriteArrayList<>();
    java.util.List<Note> noteList3 = new CopyOnWriteArrayList<>();
    java.util.List<Note> noteList4 = new CopyOnWriteArrayList<>();
    java.util.List<Note> noteList5 = new CopyOnWriteArrayList<>();
    java.util.List<Note> noteList6 = new CopyOnWriteArrayList<>();

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }



    public class SoundPlayer {
        public static void playSound(String filePath) {
            try {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource(filePath));
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }



    private KeyListener keyListener;
    public  BeatClass(){







        gamePanelActive = false;

        escLabel = new JLabel("");
        escLabel.setBounds(300, 250, 300, 100);
        escLabel.setVisible(false);
        escLabel.setOpaque(true);

        JLabel backgroundImageLabel = new JLabel(new ImageIcon(getClass().getResource("images/gameWallpaperEdit.png")));
        backgroundImageLabel.setBounds(0, 0, 900, 600);
        backgroundImageLabel.setVisible(true);
        escLabel.add(backgroundImageLabel);


        Image Exitbutton = new ImageIcon(getClass().getResource("images/exitButton.png")).getImage();
        pause_ExitButton = new JButton(new ImageIcon(Exitbutton.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
        pause_ExitButton.addActionListener(this);
        pause_ExitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pause_ExitButton.setBorder(BorderFactory.createEmptyBorder());
        pause_ExitButton.setBounds(500, 250, 150, 100);
        pause_ExitButton.setOpaque(true);
        pause_ExitButton.setContentAreaFilled(false);
        pause_ExitButton.setBorderPainted(false);
        pause_ExitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pause_ExitButton.setBounds(500, 250, 150, 100);
                Image hoverExitButton = new ImageIcon(getClass().getResource("images/exitButton.png")).getImage();
                pause_ExitButton.setIcon(new ImageIcon(hoverExitButton.getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
                SoundPlayer.playSound("Resources/button.wav");

            }

            public void mouseExited(MouseEvent e) {
                pause_ExitButton.setBounds(500, 250, 150, 100);
                Image ExitButton = new ImageIcon(getClass().getResource("images/exitButton.png")).getImage();
                pause_ExitButton.setIcon(new ImageIcon(ExitButton.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
            }

        });


        Image Pause_MenuButton = new ImageIcon(getClass().getResource("images/pause_MenuButton.png")).getImage();
        pause_MenuButton = new JButton(new ImageIcon(Pause_MenuButton.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
        pause_MenuButton.addActionListener(this);
        pause_MenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pause_MenuButton.setBorder(BorderFactory.createEmptyBorder());
        pause_MenuButton.setBounds(250, 250, 150, 100);
        pause_MenuButton.setOpaque(true);
        pause_MenuButton.setContentAreaFilled(false);
        pause_MenuButton.setBorderPainted(false);
        pause_MenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pause_MenuButton.setBounds(250, 250, 150, 100);
                Image hoverMenuButton = new ImageIcon(getClass().getResource("images/pressed_Pause_MenuButton.png")).getImage();
                pause_MenuButton.setIcon(new ImageIcon(hoverMenuButton.getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
                SoundPlayer.playSound("Resources/button.wav");

            }

            public void mouseExited(MouseEvent e) {
                pause_MenuButton.setBounds(250, 250, 150, 100);
                Image MenuButton = new ImageIcon(getClass().getResource("images/pause_MenuButton.png")).getImage();
                pause_MenuButton.setIcon(new ImageIcon(MenuButton.getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
            }

        });

        backgroundImageLabel.add(pause_ExitButton);
        backgroundImageLabel.add(pause_MenuButton);









        MusicList.add(new SoundPack("Avicii - Levels.mp3","s_Levels.jpg"));
        MusicList.add(new SoundPack("Avicii - The Nights.mp3","s_TheNights.jpg"));
        MusicList.add(new SoundPack("David Guetta - Without You.mp3","s_Without You.jpg"));
        MusicList.add(new SoundPack("르세라핌 - Unforgiven.mp3","s_Unforgiven.jpg"));
        selNum=MusicList.size()/2;
        endNum = MusicList.size()-1;
        startNum=0;
        JFrame frame = new JFrame("Image Scaling Example");
        keyListener = new KeyListener(this);
        frame.addKeyListener(keyListener);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Game");
        frame.setSize(900, 600);  // 
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(900,600);
        settingPanel = new JPanel((new BorderLayout()));
        mainPanel = new JPanel(new BorderLayout());
        gamePanel = new JPanel(new BorderLayout());
        rankPanel = new JPanel(new BorderLayout());
        settingPanel.setSize(900,600);;
        rankPanel.setSize(900,600);;
        gamePanel.setSize(900,600);;
        frame.addKeyListener(new KeyListener(beatClass));
        frame.setFocusable(true);
        frame.requestFocus();
        cardLayout = new CardLayout();
        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);
        frame.add(contentPanel);
        introBackground = new ImageIcon(Main.class.getResource("images/introBackground.jpg")).getImage();
        // 
        Image tm = LoadImage("GameBackGround1.jpg").getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        //Image tm= Toolkit.getDefaultToolkit().createImage("../image/sibe.gif");
        ImageIcon im = new ImageIcon();
        im.setImage(tm);

        gifBackGround=new JLabel();

        ImageIcon sd =new ImageIcon(this.getClass().getResource("images/v1.gif"));

        gifBackGround.setIcon(sd);
        ImageIcon icon = new ImageIcon("../images/MainWallpaper.png");




        gameLabel=new JLabel();
        gameLabel.setIcon(im);
        for(int i = 0;i<6;i++){
            Image lo = new ImageIcon(getClass().getResource("images/effectPanel.png")).getImage();
            effectPanel.add(new JLabel(new ImageIcon(lo.getScaledInstance(100,500,Image.SCALE_SMOOTH))));
            effectPanel.get(i).setBounds(230+(i*99),0,100,500);
            safePanel.add(new JLabel(new ImageIcon(lo.getScaledInstance(100,40,Image.SCALE_SMOOTH))));
            safePanel.get(i).setBounds(0,410,100,40);
            safePanel.get(i).setBorder(BorderFactory.createLineBorder(Color.BLUE));
            Image lo2 = new ImageIcon(getClass().getResource("images/effect1.png")).getImage();
            effect.add(new JLabel(new ImageIcon(lo2.getScaledInstance(100,500,Image.SCALE_SMOOTH))));
            effect.get(i).setBounds(0,0,100,500);
            //effect.get(i).setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        rankPanel = new JPanel(null);
        rankLabel = new JLabel(new ImageIcon(getClass().getResource("images/MainWallpaper.png")));
        rankLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        rankLabel.setBounds(0, 0, 900, 560);
        rankPanel.add(rankLabel);
        ImageIcon rankhomeImage = new ImageIcon(getClass().getResource("images/homebutton.png"));
        Image homeimage = rankhomeImage.getImage();
        Image homescaledImage = homeimage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        rankhomeImage = new ImageIcon(homescaledImage);

        rankhomeButton = new JButton(rankhomeImage);
        rankhomeButton.setBounds(10, 10, 70, 70);
        rankhomeButton.setContentAreaFilled(false);
        rankhomeButton.addActionListener(this);
        rankhomeButton.setBorderPainted(false);
        rankLabel.add(rankhomeButton);
        rankhomeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedhomebutton.png")).getImage();
                rankhomeButton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                rankhomeButton.setIcon(new ImageIcon(menubutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                rankhomeButton.setBounds(10, 10, 70, 70);
                Image hovermainbutton = new ImageIcon(getClass().getResource("images/pressedhomebutton.png")).getImage();
                rankhomeButton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rankhomeButton.setBounds(10, 10, 70, 70);
                Image homebutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                rankhomeButton.setIcon(new ImageIcon(homebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
        });






        ImageIcon leftArrowIcon = new ImageIcon(getClass().getResource("images/leftArrow.png"));
        Image leftArrowImage = leftArrowIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedLeftArrowIcon = new ImageIcon(leftArrowImage);
        JButton prevButton = new JButton(resizedLeftArrowIcon);
        prevButton.setBounds(50, 250, 70, 70);
        prevButton.setContentAreaFilled(false); // 이미지 배경 없애기
        prevButton.setBorder(null);
        rankLabel.add(prevButton);
        prevButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedleftArrow.png")).getImage();
                prevButton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/leftArrow.png")).getImage();
                prevButton.setIcon(new ImageIcon(menubutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                prevButton.setBounds(50, 250, 70, 70);
                Image hovermainbutton = new ImageIcon(getClass().getResource("images/pressedleftArrow.png")).getImage();
                prevButton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                prevButton.setBounds(50, 250, 70, 70);
                Image homebutton = new ImageIcon(getClass().getResource("images/leftArrow.png")).getImage();
                prevButton.setIcon(new ImageIcon(homebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
        });



        ImageIcon rightArrowIcon = new ImageIcon(getClass().getResource("images/rightArrow.png"));
        Image rightArrowImage = rightArrowIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedRightArrowIcon = new ImageIcon(rightArrowImage);
        JButton nextButton = new JButton(resizedRightArrowIcon);
        nextButton.setBounds(770, 250, 70, 70);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorder(null);
        rankLabel.add(nextButton);
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedrightArrow.png")).getImage();
                nextButton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/rightArrow.png")).getImage();
                nextButton.setIcon(new ImageIcon(menubutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");

                Image hovermainbutton = new ImageIcon(getClass().getResource("images/pressedrightArrow.png")).getImage();
                nextButton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {

                Image homebutton = new ImageIcon(getClass().getResource("images/rightArrow.png")).getImage();
                nextButton.setIcon(new ImageIcon(homebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
        });


        // 텍스트 라벨 생성
        JLabel songLabel = new JLabel("[노래이름]");
        songLabel.setBounds(400, 60, 200, 30);

        songLabel.setForeground(Color.WHITE);
        Font songLabelFont = songLabel.getFont();
        songLabel.setFont(songLabelFont.deriveFont(20f));
        rankLabel.add(songLabel);

        int startX = 400;
        int startY = 150;
        int labelWidth = 200;
        int labelHeight = 30;
        int labelGap = 40; // 간격


        JLabel rankLabel1 = new JLabel("1. 이름 - 점수");
        rankLabel1.setBounds(400, 150, labelWidth, labelHeight);
        rankLabel1.setForeground(Color.WHITE);
        Font rankLabel1Font = rankLabel1.getFont();
        rankLabel1.setFont(rankLabel1Font.deriveFont(15f));
        rankLabel.add(rankLabel1);

        JLabel rankLabel2 = new JLabel("2. 이름 - 점수");
        rankLabel2.setBounds(400, 190, labelWidth, labelHeight);
        rankLabel2.setForeground(Color.WHITE);
        Font rankLabel2Font = rankLabel2.getFont();
        rankLabel2.setFont(rankLabel2Font.deriveFont(15f));
        rankLabel.add(rankLabel2);

        JLabel rankLabel3 = new JLabel("3. 이름 - 점수");
        rankLabel3.setBounds(400, 230, labelWidth, labelHeight);
        rankLabel3.setForeground(Color.WHITE);
        Font rankLabel3Font = rankLabel3.getFont();
        rankLabel3.setFont(rankLabel3Font.deriveFont(15f));
        rankLabel.add(rankLabel3);

        JLabel rankLabel4 = new JLabel("4. 이름 - 점수");
        rankLabel4.setBounds(400, 270, labelWidth, labelHeight);
        rankLabel4.setForeground(Color.WHITE);
        Font rankLabel4Font = rankLabel4.getFont();
        rankLabel4.setFont(rankLabel4Font.deriveFont(15f));
        rankLabel.add(rankLabel4);

        JLabel rankLabel5 = new JLabel("5. 이름 - 점수");
        rankLabel5.setBounds(400, 310, labelWidth, labelHeight);
        rankLabel5.setForeground(Color.WHITE);
        Font rankLabel5Font = rankLabel5.getFont();
        rankLabel5.setFont(rankLabel5Font.deriveFont(15f));
        rankLabel.add(rankLabel5);

        JLabel rankLabel6 = new JLabel("6. 이름 - 점수");
        rankLabel6.setBounds(400, 350, labelWidth, labelHeight);
        rankLabel6.setForeground(Color.WHITE);
        Font rankLabel6Font = rankLabel6.getFont();
        rankLabel6.setFont(rankLabel6Font.deriveFont(15f));
        rankLabel.add(rankLabel6);

        JLabel rankLabel7 = new JLabel("7. 이름 - 점수");
        rankLabel7.setBounds(400, 390, labelWidth, labelHeight);
        rankLabel7.setForeground(Color.WHITE);
        Font rankLabel7Font = rankLabel7.getFont();
        rankLabel7.setFont(rankLabel7Font.deriveFont(15f));
        rankLabel.add(rankLabel7);

        JLabel rankLabel8 = new JLabel("8. 이름 - 점수");
        rankLabel8.setBounds(400, 430, labelWidth, labelHeight);
        rankLabel8.setForeground(Color.WHITE);
        Font rankLabel8Font = rankLabel8.getFont();
        rankLabel8.setFont(rankLabel8Font.deriveFont(15f));
        rankLabel.add(rankLabel8);

        JLabel rankLabel9 = new JLabel("9. 이름 - 점수");
        rankLabel9.setBounds(400, 470, labelWidth, labelHeight);
        rankLabel9.setForeground(Color.WHITE);
        Font rankLabel9Font = rankLabel9.getFont();
        rankLabel9.setFont(rankLabel9Font.deriveFont(15f));
        rankLabel.add(rankLabel9);

        JLabel rankLabel10 = new JLabel("10. 이름 - 점수");
        rankLabel10.setBounds(400, 510, labelWidth, labelHeight);
        rankLabel10.setForeground(Color.WHITE);
        Font rankLabel10Font = rankLabel10.getFont();
        rankLabel10.setFont(rankLabel10Font.deriveFont(15f));
        rankLabel.add(rankLabel10);







        settingPanel = new JPanel(null);
        settingLabel = new JLabel(new ImageIcon(getClass().getResource("images/MainWallpaper.png")));
        settingLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        settingLabel.setBounds(0, 0, 900, 560);
        settingPanel.add(settingLabel);

        ImageIcon homeImage = new ImageIcon(getClass().getResource("images/homebutton.png"));
        Image image = homeImage.getImage();
        Image scaledImage = image.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        homeImage = new ImageIcon(scaledImage);

        homeButton = new JButton(homeImage);
        homeButton.setBounds(10, 10, 70, 70);
        homeButton.setContentAreaFilled(false);
        homeButton.addActionListener(this);
        homeButton.setBorderPainted(false);
        homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedhomebutton.png")).getImage();
                homeButton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                homeButton.setIcon(new ImageIcon(menubutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");

                Image hovermainbutton = new ImageIcon(getClass().getResource("images/pressedhomebutton.png")).getImage();
                homeButton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {

                Image homebutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                homeButton.setIcon(new ImageIcon(homebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
        });
        soundImage = new ImageIcon(getClass().getResource("images/unMute.png"));
        noSoundImage = new ImageIcon(getClass().getResource("images/mute.png"));
        isSoundOn = true;
        soundButton = new JButton(soundImage);
        int buttonSize = 150;
        soundButton.setBounds(50, 200, buttonSize, buttonSize); // 버튼 위치와 크기를 직접 지정

// 이미지 크기 조정
        Image soundImageScaled = soundImage.getImage().getScaledInstance(buttonSize, buttonSize, Image.SCALE_SMOOTH);
        ImageIcon resizedSoundImage = new ImageIcon(soundImageScaled);
        soundButton.setIcon(resizedSoundImage);
        soundButton.setBorder(null);
        soundButton.setContentAreaFilled(false); // 버튼 배경 투명으로 설정
        soundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSound();
            }
        });
        JLabel soundButtonLabel = new JLabel("INTRO MUSIC ON/OFF");
        soundButtonLabel.setBounds(50, 160, 150, 30);
        soundButtonLabel.setForeground(Color.WHITE);
        settingLabel.add(soundButtonLabel);
        settingLabel.add(soundButton);
        settingLabel.add(homeButton);

        String[] comboBoxLabels = {"KEY 1 SETTING", "KEY 2 SETTING", "KEY 3 SETTING", "KEY 4 SETTING", "KEY 5 SETTING", "KEY 6 SETTING"};

        JComboBox<String> comboBox1 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox1.setBounds(350, 150, 200, 30);
        settingLabel.add(comboBox1);
        JLabel comboBoxLabel1 = new JLabel(comboBoxLabels[0]);
        comboBoxLabel1.setBounds(350, 120, 200, 30);
        comboBoxLabel1.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel1);

        JComboBox<String> comboBox2 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox2.setBounds(350, 210, 200, 30);
        settingLabel.add(comboBox2);
        JLabel comboBoxLabel2 = new JLabel(comboBoxLabels[1]);
        comboBoxLabel2.setBounds(350, 180, 200, 30);
        comboBoxLabel2.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel2);

        JComboBox<String> comboBox3 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox3.setBounds(350, 270, 200, 30);
        settingLabel.add(comboBox3);
        JLabel comboBoxLabel3 = new JLabel(comboBoxLabels[2]);
        comboBoxLabel3.setBounds(350, 240, 200, 30);
        comboBoxLabel3.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel3);

        JComboBox<String> comboBox4 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox4.setBounds(350, 330, 200, 30);
        settingLabel.add(comboBox4);
        JLabel comboBoxLabel4 = new JLabel(comboBoxLabels[3]);
        comboBoxLabel4.setBounds(350, 300, 200, 30);
        comboBoxLabel4.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel4);

        JComboBox<String> comboBox5 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox5.setBounds(350, 390, 200, 30);
        settingLabel.add(comboBox5);
        JLabel comboBoxLabel5 = new JLabel(comboBoxLabels[4]);
        comboBoxLabel5.setBounds(350, 360, 200, 30);
        comboBoxLabel5.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel5);

        JComboBox<String> comboBox6 = new JComboBox<>(new String[]{"Key 1", "Key 2", "Key 3", "Key 4", "Key 5", "Key 6"});
        comboBox6.setBounds(350, 450, 200, 30);
        settingLabel.add(comboBox6);
        JLabel comboBoxLabel6 = new JLabel(comboBoxLabels[5]);
        comboBoxLabel6.setBounds(350, 420, 200, 30);
        comboBoxLabel6.setForeground(Color.WHITE);
        settingLabel.add(comboBoxLabel6);

        JButton applyButton = new JButton("APPLY");
        applyButton.setBounds(750, 500, 80, 30);
        settingLabel.add(applyButton);

        String[] effectOptions = {"EFFECT 1", "EFFECT 2", "EFFECT 3", "EFFECT 4", "EFFECT 5", "EFFECT 6"};
        JComboBox<String> effectComboBox = new JComboBox<>(effectOptions);
        effectComboBox.setBounds(650, 250, 150, 30);
        settingLabel.add(effectComboBox);
        JLabel effectComboBoxLabel = new JLabel("NOTEPAD SOUND");
        effectComboBoxLabel.setBounds(650, 220, 150, 30);
        effectComboBoxLabel.setForeground(Color.WHITE);
        settingLabel.add(effectComboBoxLabel);

        JLabel settingnameLabel = new JLabel("SETTING PAGE");
        Font font3 = settingnameLabel.getFont();
        Font boldFont3 = new Font(font3.getFontName(), Font.BOLD, font3.getSize() + 20);
        settingnameLabel.setFont(boldFont3);
        settingnameLabel.setBounds(330, 10, 300, 30);
        settingnameLabel.setForeground(Color.WHITE);
        settingLabel.add(settingnameLabel);



        bgLabel = new JLabel(new ImageIcon(getClass().getResource("images/main.gif")));
        bgLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        bgLabel2 = new JLabel(new ImageIcon(getClass().getResource("images/MainWallpaper.png")));
        bgLabel2.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        // 
        gifBackGround.setBounds(0,0,getWidth(),getHeight());
        gameLabel.setBounds(0,0,getWidth(),getHeight());
        bgLabel.setBounds(0, 0, getWidth(), getHeight());
        bgLabel2.setBounds(0, 0, getWidth(), getHeight());

        Image logoImage = new ImageIcon(getClass().getResource("images/logoImage.png")).getImage();
        logoLabel = new JLabel(new ImageIcon(logoImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(300, 50, 300, 150);
        //bgLabel.add(logoLabel);
        //logoLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        contentPanel.add(panel,"selectWindows");
        contentPanel.add(settingPanel,"settingWindows");
        contentPanel.add(rankPanel,"rankWindows" );
        //mainPanel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        contentPanel.add(mainPanel,"mainWindows");
        contentPanel.add(gamePanel,"gameWindows");
        //add(bgList);

        mainPanel.add(bgLabel);
        gamePanel.add(gifBackGround);
        //gamePanel.add(gameLabel);
        for(int i =0;i<effectPanel.size();i++){
             gifBackGround.add(effectPanel.get(i));
             effectPanel.get(i).add(safePanel.get(i));
             effectPanel.get(i).add(effect.get(i));
             effect.get(i).setVisible(false);
            System.out.println(effectPanel.get(i).getBounds());
        }

        ImageIcon gameWallpapersideimg = new ImageIcon(getClass().getResource("images/gameWallpapersideEdit.png"));
        JLabel gameWallpaperside = new JLabel(gameWallpapersideimg);
        int imageWidth = gameWallpapersideimg.getIconWidth();
        int imageHeight = gameWallpapersideimg.getIconHeight();
        gameWallpaperside.setBounds(0, 0, imageWidth, imageHeight); // 이미지 라벨 위치와 크기를 지정
        gifBackGround.add(gameWallpaperside);

        Image gameBackbuttonimg = new ImageIcon(getClass().getResource("images/gameBackbutton.png")).getImage();
        gameBackbutton = new JButton(new ImageIcon(gameBackbuttonimg.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        gameBackbutton.addActionListener(this);
        gameBackbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gameBackbutton.setBorder(BorderFactory.createEmptyBorder());
        gameBackbutton.setBounds(15, 30, 50, 50);
        gameBackbutton.setContentAreaFilled(false);
        gameWallpaperside.add(gameBackbutton);
        gameBackbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedgameBackbutton.png")).getImage();
                gameBackbutton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/gameBackbutton.png")).getImage();
                gameBackbutton.setIcon(new ImageIcon(menubutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                gameBackbutton.setBounds(15, 30, 50, 50);
                Image hovermainbutton = new ImageIcon(getClass().getResource("images/pressedgameBackbutton.png")).getImage();
                gameBackbutton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                gameBackbutton.setBounds(15, 30, 50, 50);
                Image homebutton = new ImageIcon(getClass().getResource("images/gameBackbutton.png")).getImage();
                gameBackbutton.setIcon(new ImageIcon(homebutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }
        });

        ImageIcon scoreImg = new ImageIcon(getClass().getResource("images/score.png"));
        JLabel scoreLabel = new JLabel(scoreImg);

        Image scorescaledImage = scoreImg.getImage().getScaledInstance(170, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scorescaledImage);
        scoreLabel.setIcon(scaledIcon);
        scoreLabel.setBounds(35, 150, 170, 80);
        gameWallpaperside.add(scoreLabel);



// 폰트를 적용한 새로운 JLabel 생성
        scorenumberLabel = new JLabel(Integer.toString(Score));
        scorenumberLabel.setBounds(18, 250, labelWidth, 40); // 텍스트 라벨 위치와 크기 지정
        scorenumberLabel.setForeground(Color.WHITE); // 글자 색상을 흰색으로 설정
        Font font2 = scorenumberLabel.getFont();
        Font boldFont2 = font2.deriveFont(font2.getSize() + 30f);
        scorenumberLabel.setFont(boldFont2);
        scorenumberLabel.setText(Integer.toString(Score));
        scorenumberLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 폰트 설정

// 다른 라벨에 텍스트 라벨 추가
        gameWallpaperside.add(scorenumberLabel);





        //gamePanel.add(logoLabel);
        //bgList.setVisible(false);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Image centerImage =LoadImage(MusicList.get(selNum).image).getImage();
        bgList = new JButton(new ImageIcon(centerImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        bgList.addActionListener(this);
        //bgList.setBorder(BorderFactory.createLineBorder(Color.RED));
        bgList.setBounds(300, 150, 300, 300);
        // JLabel 
        panel.add(bgLabel2);
        bgLabel2.add(bgList);
        bgLabel.add(logoLabel);


        mtextLabel = new JLabel();
        ltextLabel = new JLabel();
        rtextLabel = new JLabel();
        mtextLabel.setForeground(Color.WHITE);
        ltextLabel.setForeground(Color.WHITE);
        rtextLabel.setForeground(Color.WHITE);

        int mlabelWidth = 400;
        int mlabelHeight = 200;
        int mlabelX = 250;
        int mlabelY = 0;
        mtextLabel.setBounds(mlabelX, mlabelY, mlabelWidth, mlabelHeight);
        mtextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int llabelWidth = 300;
        int llabelHeight = 200;
        int llabelX = -25;
        int llabelY = 150;
        ltextLabel.setBounds(llabelX, llabelY, llabelWidth, llabelHeight);
        ltextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        int rlabelWidth = 300;
        int rlabelHeight = 200;
        int rlabelX = 620;
        int rlabelY = 150;
        rtextLabel.setBounds(rlabelX, rlabelY, rlabelWidth, rlabelHeight);
        rtextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = mtextLabel.getFont();
        float fontSize = font.getSize() + 12; // 가운데 텍스트 크기 조절
        Font largerFont = font.deriveFont(fontSize);
        mtextLabel.setFont(largerFont);

        String leftName = MusicList.get(selNum-1).name;
        String centerName = MusicList.get(selNum).name;
        String rightName = MusicList.get(selNum+1).name;
        ltextLabel.setText(leftName);
        mtextLabel.setText(centerName);
        rtextLabel.setText(rightName);

        //폰트 적용 시도, 실패함
       /* try {
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream("../Resources/ka1.ttf"));

            Font newfont = Font.createFont(Font.TRUETYPE_FONT, inputStream);

            mtextLabel.setFont(newfont.deriveFont(Font.BOLD, 12f));

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
*/
        bgLabel2.add(mtextLabel);
        bgLabel2.add(ltextLabel);
        bgLabel2.add(rtextLabel);


        Image MenuButton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
        menuButton = new JButton(new ImageIcon(MenuButton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        menuButton.addActionListener(this);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setBorder(BorderFactory.createEmptyBorder());
        menuButton.setBounds(15, 30, 50, 50);
        menuButton.setContentAreaFilled(false);
        bgLabel2.add(menuButton);
        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedhomebutton = new ImageIcon(getClass().getResource("images/pressedhomebutton.png")).getImage();
                menuButton.setIcon(new ImageIcon(pressedhomebutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image menubutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                menuButton.setIcon(new ImageIcon(menubutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                menuButton.setBounds(15, 30, 50, 50);
                Image hovermainbutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                menuButton.setIcon(new ImageIcon(hovermainbutton.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                menuButton.setBounds(15, 30, 50, 50);
                Image homebutton = new ImageIcon(getClass().getResource("images/homebutton.png")).getImage();
                menuButton.setIcon(new ImageIcon(homebutton.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            }
        });



        //cardLayout.next(contentPanel);
        cardLayout.show(contentPanel,"mainWindows");
        Image leftImage = LoadImage(MusicList.get(selNum-1).image).getImage();
        leftList = new JButton(new ImageIcon(leftImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        leftList.setVerticalAlignment(JLabel.CENTER);
        leftList.addActionListener(this);
        leftList.setHorizontalAlignment(JLabel.CENTER);
       leftList.setBounds(50,270,150,150);
        // JLabel 
        bgLabel2.add(leftList);
        Image rightImage = LoadImage(MusicList.get(selNum+1).image).getImage();
        rightList = new JButton(new ImageIcon(rightImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        rightList.setVerticalAlignment(JLabel.CENTER);
        rightList.addActionListener(this);
        rightList.setHorizontalAlignment(JLabel.CENTER);
        rightList.setBounds(700,270,150,150);
        // JLabel 
        bgLabel2.add(rightList);
        //

        Image teamLogo = new ImageIcon(getClass().getResource("images/Teamlogo.png")).getImage();
        logoButton = new JButton(new ImageIcon(teamLogo.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
        logoButton.addActionListener(this);
        logoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoButton.setBorder(BorderFactory.createEmptyBorder());
        logoButton.setBounds(0, 500, 170, 50);
        logoButton.setContentAreaFilled(false);
        bgLabel.add(logoButton);



        Image startImage = new ImageIcon(getClass().getResource("images/startButtonImage.png")).getImage();
        startButton = new JButton(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
        startButton.addActionListener(this);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setBounds(360, 240, 170, 50);
        startButton.setContentAreaFilled(false);
        bgLabel.add(startButton);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {


                Image pressedStartImage = new ImageIcon(getClass().getResource("images/pressedStartButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(pressedStartImage.getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image startImage = new ImageIcon(getClass().getResource("images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                startButton.setBounds(360, 240, 170, 50);
                Image hoverStartImage = new ImageIcon(getClass().getResource("images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(hoverStartImage.getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBounds(360, 240, 170, 50);
                Image startImage = new ImageIcon(getClass().getResource("images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
            }
        });

        Image settingImage = new ImageIcon(getClass().getResource("images/settingButtonImage.png")).getImage();
        settingButton = new JButton(new ImageIcon(settingImage.getScaledInstance(120, 40, Image.SCALE_SMOOTH)));
        settingButton.addActionListener(this);
        settingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        settingButton.setBorder(BorderFactory.createEmptyBorder());
        settingButton.setBounds(385, 290, 120, 40);
        settingButton.setContentAreaFilled(false);
        bgLabel.add(settingButton);

        settingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedSettingImage = new ImageIcon(getClass().getResource("images/pressedSettingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(pressedSettingImage.getScaledInstance(130, 50, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image settingImage = new ImageIcon(getClass().getResource("images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(settingImage.getScaledInstance(120, 40, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                settingButton.setBounds(385, 290, 120, 40);
                Image hoverSettingImage = new ImageIcon(getClass().getResource("images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(hoverSettingImage.getScaledInstance(130, 50, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                settingButton.setBounds(385, 290, 120, 40);
                Image settingImage = new ImageIcon(getClass().getResource("images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(settingImage.getScaledInstance(120, 40, Image.SCALE_SMOOTH)));
            }
        });


        Image rankImage = new ImageIcon(getClass().getResource("images/rankButtonImage.png")).getImage();
        rankButton = new JButton(new ImageIcon(rankImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
        rankButton.addActionListener(this);
        rankButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankButton.setBorder(BorderFactory.createEmptyBorder());
        rankButton.setBounds(393, 335, 100, 35);
        rankButton.setContentAreaFilled(false);
        bgLabel.add(rankButton);

        rankButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedRankImage = new ImageIcon(getClass().getResource("images/pressedRankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(pressedRankImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image rankImage = new ImageIcon(getClass().getResource("images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(rankImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
                rankButton.setBounds(393, 335, 100, 35);
                Image hoverRankImage = new ImageIcon(getClass().getResource("images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(hoverRankImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rankButton.setBounds(393, 335, 100, 35);
                Image rankImage = new ImageIcon(getClass().getResource("images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(rankImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
        });

        Image quitImage = new ImageIcon(getClass().getResource("images/quitButtonImage.png")).getImage();
        quitButton = new JButton(new ImageIcon(quitImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
        quitButton.addActionListener(this);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setBorder(BorderFactory.createEmptyBorder());
        quitButton.setBounds(395, 440, 100, 35);
        quitButton.setContentAreaFilled(false);
        bgLabel.add(quitButton);

        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedQuitImage = new ImageIcon(getClass().getResource("images/pressedQuitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(pressedQuitImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Image quitImage = new ImageIcon(getClass().getResource("images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(quitImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                SoundPlayer.playSound("Resources/button.wav");
            	quitButton.setBounds(395, 440, 100, 35);
                Image hoverQuitImage = new ImageIcon(getClass().getResource("images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(hoverQuitImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	quitButton.setBounds(395, 440, 100, 35);
                Image quitImage = new ImageIcon(getClass().getResource("images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(quitImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
        });

        frame.setVisible(true);

        introMusic = new Music("mus1.mp3",true);
        introMusic.start();
    }



    private void toggleSound() {
        isSoundOn = !isSoundOn;
        if (isSoundOn) {
            Image soundImageScaled = soundImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon resizedSoundImage = new ImageIcon(soundImageScaled);
            soundButton.setBorder(null);
            soundButton.setIcon(resizedSoundImage);
        } else {
            Image noSoundImageScaled = noSoundImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon resizedNoSoundImage = new ImageIcon(noSoundImageScaled);
            soundButton.setBorder(null);
            soundButton.setIcon(resizedNoSoundImage);
        }
    }



    public ImageIcon LoadImage(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("images/"+name));
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();
        int max = Math.max(width, height);
        double scale = 100.0 / max;
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance((int)(width * scale), (int)(height * scale), Image.SCALE_SMOOTH);
        return icon;
    }
    public void SetListWindows(boolean active){
    	logoButton.setVisible(!active);
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
    public void SelectWindowsImageSetting(int left, int center, int right){
        if(right>endNum){
            rightList.setVisible(false);
            rtextLabel.setVisible(false);
        }else {
            rtextLabel.setVisible(true);
            rightList.setVisible(true);
            rtextLabel.setText(MusicList.get(right).name);
            Image image = LoadImage(MusicList.get(right).image).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon();
            icon.setImage(image);
            rightList.setIcon(icon);
        }
        if(left<0) {
            leftList.setVisible(false);
            ltextLabel.setVisible(false);
        }else{
            leftList.setVisible(true);
            ltextLabel.setVisible(true);
            ltextLabel.setText(MusicList.get(left).name);
            Image image2 = LoadImage(MusicList.get(left).image).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon();
            icon2.setImage(image2);
            leftList.setIcon(icon2);
        }

        Image image3 =LoadImage(MusicList.get(center).image).getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon icon3 = new ImageIcon();
        icon3.setImage(image3);
        mtextLabel.setText(MusicList.get(center).name);
        bgList.setIcon(icon3);

    }

    public void PressJMT(int i){
        Note nt=null;
        switch(i){
            case 0:
                java.util.List<Note> copy = new ArrayList<>(noteList1);
                for(Note n :noteList1){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
            case 1:
                for(Note n :noteList2){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
            case 2:
                for(Note n :noteList3){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
            case 3:
                for(Note n :noteList4){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
            case 4:
                for(Note n :noteList5){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
            case 5:
                for(Note n :noteList6){
                    if(n.set==1) {
                        Score+=50;
                        RemoveNote(i,n);
                    }else if(n.set ==2){
                        Score+=100;
                        RemoveNote(i,n);
                    }
                }
                break;
        }
        System.out.println(Score);
        scorenumberLabel.setText(Integer.toString(Score));
    }
    public Note slot1(){
        Note note = (new Note(this,1,0,0,1,0));
        note.start();
        noteList1.add(note);
        effectPanel.get(0).add(note.note);
        return note;
    }
    public void RemoveNote(int i,Note n){
        Note nt=null;
        //System.out.println(i);
        switch(i){
            case 0:
                nt= noteList1.get(noteList1.indexOf(n));
                noteList1.remove(nt);
                //System.out.println(i);
                break;
            case 1:
                nt= noteList2.get(noteList2.indexOf(n));
                noteList2.remove(nt);
                //System.out.println(i);
                break;
            case 2:
                nt= noteList3.get(noteList3.indexOf(n));
                noteList3.remove(nt);
                //System.out.println(i);
                break;
            case 3:
                nt= noteList4.get(noteList4.indexOf(n));
                noteList4.remove(nt);
                //System.out.println(i);
                break;
            case 4:
                nt= noteList5.get(noteList5.indexOf(n));
                noteList5.remove(nt);
                //System.out.println(i);
                break;
            case 5:
                nt= noteList6.get(noteList6.indexOf(n));
                noteList6.remove(nt);
                //System.out.println(i);
                break;
        }


        effectPanel.get(i).remove(nt.note);
        effectPanel.get(i).revalidate();
        effectPanel.get(i).repaint();
    }
    public Note slot2(){
        Note note = (new Note(this,1,0,0,1,1));
        note.start();
        noteList2.add(note);
        effectPanel.get(1).add(note.note);
        return note;
    }public Note slot3(){
        Note note = (new Note(this,1,0,0,1,2));
        note.start();
        noteList3.add(note);
        effectPanel.get(2).add(note.note);
        return note;
    }
    public Note slot4(){
        Note note = (new Note(this,1,0,0,1,3));
        note.start();
        noteList4.add(note);
        effectPanel.get(3).add(note.note);
        return note;
    }
    public Note slot5(){
        Note note = (new Note(this,1,0,0,1,4));
        note.start();
        noteList5.add(note);
        effectPanel.get(4).add(note.note);
        return note;
    }
    public Note slot6(){
        Note note = (new Note(this,1,0,0,1,5));
        note.start();
        noteList6.add(note);
        effectPanel.get(5).add(note.note);
        return note;
    }

    public void GameStart(String tn, String di, String mn){
        game = new Game(tn,di,mn);
        game.bc=this;
        System.out.println(tn+"/"+mn);
        game.start();

        gamePanelActive = true; // gamePanel이 켜진 상태로 설정
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            //System.exit(0);
            cardLayout.show(contentPanel,"selectWindows");
        } else if (e.getSource() == settingButton) {
            cardLayout.show(contentPanel, "settingWindows");
        } else if (e.getSource() == rankButton) {
            cardLayout.show(contentPanel, "rankWindows");
        } else if (e.getSource() == quitButton) {
            // Quit
            System.exit(0);
        }else if(e.getSource() == pause_ExitButton){
            System.exit(0);
        }else if(e.getSource() == pause_MenuButton){
            cardLayout.show(contentPanel,"selectWindows");
        }else if(e.getSource() == homeButton){
            cardLayout.show(contentPanel,"mainWindows");
        }
        else if(e.getSource() == rankhomeButton){
            cardLayout.show(contentPanel,"mainWindows");
        }else if(e.getSource() == gameBackbutton){
            cardLayout.show(contentPanel,"selectWindows");
        }

        else if(e.getSource() == menuButton){
            cardLayout.show(contentPanel,"mainWindows");

        }else if(e.getSource() == rightList){
            selNum++;
            SelectWindowsImageSetting(selNum-1,selNum,selNum+1);
        }else if(e.getSource() == leftList){
            selNum--;
            SelectWindowsImageSetting(selNum-1,selNum,selNum+1);
        }else if(e.getSource()==bgList){
            showLoadingScreen();
        }
        }
    }




