import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<applet code="Puzzle.class" width=120 height=120> </applet>*/

public class Puzzle extends Applet {
	
	Image      OffImage;
	Graphics   OffScreen;
	Image      panel[] = new Image[16];
	Font       wfont;
	
	public void init() {
		wfont    = new Font("‚l‚r ‚oƒSƒVƒbƒN",Font.PLAIN | Font.BOLD,20);
		OffImage = createImage(120,120);
		OffScreen = OffImage.getGraphics();
		
		for(int i = 0;i<16;i++){
			panel[i] = getImage(getDocumentBase(),i+".jpg");
		}
		
	}

	
	public void paint(Graphics OnScreen) {
		
		OnScreen.setFont(wfont);
		
		int x,y,w=0;
		for(int i = 1;i<=4;i++){
			y = (i-1)*30;
			for(int j = 1;j<=4;j++){
				x = (j-1)*30;
				System.out.println(i);
				OffScreen.drawImage(panel[w++],x,y,this);
			}
		}
	
		OnScreen.drawImage(OffImage,0,0,this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
}