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
        setSize(900, 600);  
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
        
        bgLabel = new JLabel(new ImageIcon(getClass().getResource("../images/MainWallpaper.png")));
        add(bgLabel);

        
        bgLabel.setBounds(0, 0, getWidth(), getHeight());


        Image logoImage = new ImageIcon(getClass().getResource("../images/logoImage.png")).getImage();
        logoLabel = new JLabel(new ImageIcon(logoImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(300, 50, 300, 150);
        bgLabel.add(logoLabel);


        bgList = new JLabel(new ImageIcon(getClass().getResource("../images/introBackground.jpg")));
        //add(bgList);


        //bgList.setVisible(false);



      

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
        
        // 설정 버튼 추가
        
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
        
        if (e.getSource() == startButton) {
            //System.exit(0);
            SetListWindows(true);
        } else if (e.getSource() == settingButton) {
            
        } else if (e.getSource() == rankButton) {
            
        } else if (e.getSource() == quitButton) {
            
            System.exit(0);
        }
    }
}
