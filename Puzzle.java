import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code="Puzzle.class" width=400 height=400> </applet>*/

public class Puzzle extends Applet implements ActionListener {
	
	Image      OffImage;
	Graphics   OffScreen;
	Image      panel[] = new Image[16];
	Font       wfont;
	Label      msglabel;
	Button     startbutton,ansbutton;
	int        ctable[][] = new int[6][6];
	int        wtable[][] = new int[6][6];
	int        stable[][] = new int[6][6];
	
	public void init() {
		wfont    = new Font("ＭＳ Ｐゴシック",Font.PLAIN | Font.BOLD,20);
		OffImage = createImage(120,120);
		OffScreen = OffImage.getGraphics();
		
		msglabel = new Label("");  //ラベルオブジェクト作成
		add(msglabel);             //ラベルの追加
		setLayout(null);           //規定レイアウト使用しない
		msglabel.setAlignment(Label.CENTER);  //センタリング
		msglabel.setBounds(130,20,100,20);    //X,Y,W,H座標指定
		
		startbutton  = new Button("スタート");
		add(startbutton);
		setLayout(null);
		startbutton.setBounds(130,45,100,30);
		startbutton.addActionListener(this);
		
		ansbutton = new Button("正解");
		add(ansbutton);
		setLayout(null);
		ansbutton.setBounds(130,75,100,30);
		ansbutton.addActionListener(this);
		
		for(int i = 0;i<16;i++){
			//panel[i] = getImage(getDocumentBase(),"Image/"+i+".jpg");
			panel[i] = getImage(getDocumentBase(),"Image2/firefox_"+i+".jpg");
		}
		
	}
	
	public void setData(){//配列初期化用のメソッド
	
		int cnt = 0;
		for(int i = 0; i<6;i++){
			for(int J=0;J<6; J++){
				if(i == 0 || i == 5 || j == 0 || j == 5){
					ctable[i][j] = -1;
					wtable[i][j] = -1;
				}else{
					ctable[i][j] = cnt;
					wtable[i][j] = cnt;
					cnt++;
				}
			}
		}
	}

	public void Shuffle() {
		final int MOVESU = 30;
		
		int i = 1,J = 1,cnt,x;
		
		cnt = 0;
		while(cnt < MOVESU){
			int w = (int)(Math.random()*4);
			switch(w){
				case 0: if(wtable[i - 1][j] != -1){
							x = wtable[i][j];
							wtable[i][j] = wtable[i-1][j];
							wtable[i-1][j] = x;
							i--;
						}
						break;
				case 1: if(wtable[i + 1][j] != -1){
							x = wtable[i][j];
							wtable[i][j] = wtable[i+1][j];
							wtable[i+1][j] = x;
							i++;
						}
						break;
				case 2: if(wtable[i][j+1] != -1){
							x = wtable[i][j];
							wtable[i][j] = wtable[i][j+1];
							wtable[i][j+1] = x;
							j++;
						}
						break;
				case 3: if(wtable[i][j-1] != -1){
							x = wtable[i][j];
							wtable[i][j] = wtable[i][j-1];
							wtable[i][j-1] = x;
							j--;
						}
						break;
			}
		}
	}
	
	public void paint(Graphics OnScreen) {
		
		OnScreen.setFont(wfont);
		
		int x,y,w=0;
		for(int i = 1;i<=4;i++){
			y = (i-1)*30;
			for(int j = 1;j<=4;j++){
				x = (j-1)*30;
				System.out.println(w);
				OffScreen.drawImage(panel[w++],x,y,this);
			}
		}
	
		OnScreen.drawImage(OffImage,0,0,this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("button pushed");
		msglabel.setText("button pushed");
	}
}