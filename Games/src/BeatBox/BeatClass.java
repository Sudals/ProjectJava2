package BeatBox;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

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
    public static Game game;
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

    Music introMusic;
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    public  BeatClass(){
        MusicList.add(new SoundPack("Avicii - Levels.mp3","s_Levels.jpg"));
        MusicList.add(new SoundPack("Avicii - The Nights.mp3","s_TheNights.jpg"));
        MusicList.add(new SoundPack("David Guetta - Without You.mp3","s_Without You.jpg"));
        MusicList.add(new SoundPack("르세라핌 - Unforgiven.mp3","s_Unforgiven.jpg"));
        selNum=MusicList.size()/2;
        endNum = MusicList.size()-1;
        startNum=0;
        JFrame frame = new JFrame("Image Scaling Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Game");
        frame.setSize(900, 600);  // 
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(900,600);
        mainPanel = new JPanel(new BorderLayout());
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(900,600);;
        frame.addKeyListener(new KeyListener());
        frame.setFocusable(true);
        frame.requestFocus();
        cardLayout = new CardLayout();
        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);
        frame.add(contentPanel);
        introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        // 
        Image tm = LoadImage("GameBackGround1.jpg").getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        //Image tm= Toolkit.getDefaultToolkit().createImage("../image/sibe.gif");
        ImageIcon im = new ImageIcon();
        im.setImage(tm);

        gifBackGround=new JLabel();

        ImageIcon sd =new ImageIcon(this.getClass().getResource("../images/v1.gif"));

        gifBackGround.setIcon(sd);
        ImageIcon icon = new ImageIcon("../images/MainWallpaper.png");


        gameLabel=new JLabel();
        gameLabel.setIcon(im);
        for(int i = 0;i<6;i++){
            Image lo = new ImageIcon(getClass().getResource("../images/effectPanel.png")).getImage();
            effectPanel.add(new JLabel(new ImageIcon(lo.getScaledInstance(100,500,Image.SCALE_SMOOTH))));
            effectPanel.get(i).setBounds(230+(i*99),0,100,500);
            safePanel.add(new JLabel(new ImageIcon(lo.getScaledInstance(100,40,Image.SCALE_SMOOTH))));
            safePanel.get(i).setBounds(0,410,100,40);
            safePanel.get(i).setBorder(BorderFactory.createLineBorder(Color.BLUE));
            Image lo2 = new ImageIcon(getClass().getResource("../images/effect.png")).getImage();
            effect.add(new JLabel(new ImageIcon(lo2.getScaledInstance(100,500,Image.SCALE_SMOOTH))));
            effect.get(i).setBounds(0,0,100,500);
            //effect.get(i).setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        
        bgLabel = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        bgLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        bgLabel2 = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        bgLabel2.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        // 
        gifBackGround.setBounds(0,0,getWidth(),getHeight());
        gameLabel.setBounds(0,0,getWidth(),getHeight());
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

        Image startImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
        startButton = new JButton(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
        startButton.addActionListener(this);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setBounds(360, 240, 170, 50); // startButton의 위치와 크기 수정
        startButton.setContentAreaFilled(false);
        bgLabel.add(startButton);
        
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Image pressedStartImage = new ImageIcon(getClass().getResource("../images/pressedStartButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(pressedStartImage.getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                Image startImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setBounds(360, 240, 180, 60);
                Image hoverStartImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(hoverStartImage.getScaledInstance(180, 60, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setBounds(360, 240, 170, 50);
                Image startImage = new ImageIcon(getClass().getResource("../images/startButtonImage.png")).getImage();
                startButton.setIcon(new ImageIcon(startImage.getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
            }
        });
        
        Image settingImage = new ImageIcon(getClass().getResource("../images/settingButtonImage.png")).getImage();
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
                Image pressedSettingImage = new ImageIcon(getClass().getResource("../images/pressedSettingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(pressedSettingImage.getScaledInstance(130, 50, Image.SCALE_SMOOTH)));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                Image settingImage = new ImageIcon(getClass().getResource("../images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(settingImage.getScaledInstance(120, 40, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                settingButton.setBounds(385, 290, 130, 50);
                Image hoverSettingImage = new ImageIcon(getClass().getResource("../images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(hoverSettingImage.getScaledInstance(130, 50, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                settingButton.setBounds(385, 290, 120, 40);
                Image settingImage = new ImageIcon(getClass().getResource("../images/settingButtonImage.png")).getImage();
                settingButton.setIcon(new ImageIcon(settingImage.getScaledInstance(120, 40, Image.SCALE_SMOOTH)));
            }
        });

       
        Image rankImage = new ImageIcon(getClass().getResource("../images/rankButtonImage.png")).getImage();
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
                Image pressedRankImage = new ImageIcon(getClass().getResource("../images/pressedRankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(pressedRankImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                Image rankImage = new ImageIcon(getClass().getResource("../images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(rankImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
                rankButton.setBounds(393, 335, 110, 45);
                Image hoverRankImage = new ImageIcon(getClass().getResource("../images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(hoverRankImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rankButton.setBounds(393, 335, 100, 35);
                Image rankImage = new ImageIcon(getClass().getResource("../images/rankButtonImage.png")).getImage();
                rankButton.setIcon(new ImageIcon(rankImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
        });
      
        Image quitImage = new ImageIcon(getClass().getResource("../images/quitButtonImage.png")).getImage();
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
                Image pressedQuitImage = new ImageIcon(getClass().getResource("../images/pressedQuitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(pressedQuitImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                Image quitImage = new ImageIcon(getClass().getResource("../images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(quitImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
            public void mouseEntered(MouseEvent e) {
            	quitButton.setBounds(395, 440, 110, 45);
                Image hoverQuitImage = new ImageIcon(getClass().getResource("../images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(hoverQuitImage.getScaledInstance(110, 45, Image.SCALE_SMOOTH)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	quitButton.setBounds(395, 440, 100, 35);
                Image quitImage = new ImageIcon(getClass().getResource("../images/quitButtonImage.png")).getImage();
                quitButton.setIcon(new ImageIcon(quitImage.getScaledInstance(100, 35, Image.SCALE_SMOOTH)));
            }
        });

        frame.setVisible(true);

        introMusic = new Music("mus1.mp3",true);
        introMusic.start();
    }
    public ImageIcon LoadImage(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource("../images/"+name));
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();
        int max = Math.max(width, height);
        double scale = 100.0 / max;
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance((int)(width * scale), (int)(height * scale), Image.SCALE_SMOOTH);
        return icon;
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
    public void SelectWindowsImageSetting(int left, int center, int right){
        if(right>endNum){
            rightList.setVisible(false);
        }else {
            rightList.setVisible(true);
            Image image = LoadImage(MusicList.get(right).image).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon();
            icon.setImage(image);
            rightList.setIcon(icon);
        }
        if(left<0) {
            leftList.setVisible(false);
        }else{
            leftList.setVisible(true);
            Image image2 = LoadImage(MusicList.get(left).image).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon icon2 = new ImageIcon();
            icon2.setImage(image2);
            leftList.setIcon(icon2);
        }

        Image image3 =LoadImage(MusicList.get(center).image).getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
        ImageIcon icon3 = new ImageIcon();
        icon3.setImage(image3);
        bgList.setIcon(icon3);

    }
    public void GameStart(String tn, String di, String mn){
        game = new Game(tn,di,mn);
        game.bc=this;
        System.out.println(tn+"/"+mn);
    }
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == startButton) {
            //System.exit(0);
            cardLayout.show(contentPanel,"selectWindows");
        } else if (e.getSource() == settingButton) {
            // Setting
        } else if (e.getSource() == rankButton) {
            // Rank
        } else if (e.getSource() == quitButton) {
            // Quit
            System.exit(0);
        }else if(e.getSource() == rightList){
            selNum++;
            SelectWindowsImageSetting(selNum-1,selNum,selNum+1);
        }else if(e.getSource() == leftList){
            selNum--;
            SelectWindowsImageSetting(selNum-1,selNum,selNum+1);
        }else if(e.getSource()==bgList){
            cardLayout.show(contentPanel,"gameWindows");
            GameStart(MusicList.get(selNum).name.split("\\.")[0],"T",MusicList.get(selNum).name);
            introMusic.close();
        }
    }



}
