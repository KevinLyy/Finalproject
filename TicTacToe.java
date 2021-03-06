import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener,MouseListener{
    private Container pane;
    private JButton c;
    private JPanel mousepanel;
    char[][] fullboard;
    char[][] bigBoard;
    private int whoWon;
    private ArrayList<Point> points;


    //check winner 1-9,1-9
    public String checkWinner(int w1,int w2){
	//check for player 1
	if(//diagonal
	   (fullboard[w1][w2] & fullboard[w1+1][w2+1]&
	    fullboard[w1+2][w2+2])== 1 ||
	   (fullboard[w1+2][w2]& fullboard[w1+1][w2+1]&
	    fullboard[w1][w2+2])== 1||
	   //vertical
	   (fullboard[w1][w2] & fullboard[w1][w2+1]&
	    fullboard[w1][w2+2])== 1 ||
	   (fullboard[w1+1][w2] & fullboard[w1+1][w2+1]&
	    fullboard[w1+1][w2+2])== 1 ||
	   (fullboard[w1+2][w2] & fullboard[w1+2][w2+1]&
	    fullboard[w1+2][w2+2])== 1 ||
	   //horizontal
	   (fullboard[w1][w2] & fullboard[w1+1][w2]&
	    fullboard[w1+2][w2])== 1 ||
	   (fullboard[w1][w2+1] & fullboard[w1+1][w2+1]&
	    fullboard[w1+2][w2+1])== 1 ||
	   (fullboard[w1][w2+2] & fullboard[w1+1][w2+2]&
	    fullboard[w1+2][w2+2])== 1 ){
	    return "p1";
	}
	//check for player 2
	else
	if(//diagonal
	   (fullboard[w1][w2] & fullboard[w1+1][w2+1]&
	    fullboard[w1+2][w2+2])== 2 ||
	   (fullboard[w1+2][w2]& fullboard[w1+1][w2+1]&
	    fullboard[w1][w2+2])== 2||
	   //vertical
	   (fullboard[w1][w2] & fullboard[w1][w2+1]&
	    fullboard[w1][w2+2])== 2 ||
	   (fullboard[w1+1][w2] & fullboard[w1+1][w2+1]&
	    fullboard[w1+1][w2+2])== 2 ||
	   (fullboard[w1+2][w2] & fullboard[w1+2][w2+1]&
	    fullboard[w1+2][w2+2])== 2 ||
	   //horizontal
	   (fullboard[w1][w2] & fullboard[w1+1][w2]&
	    fullboard[w1+2][w2])== 2 ||
	   (fullboard[w1][w2+1] & fullboard[w1+1][w2+1]&
	    fullboard[w1+2][w2+1])== 2 ||
	   (fullboard[w1][w2+2] & fullboard[w1+1][w2+2]&
	    fullboard[w1+2][w2+2])== 2 ){
	    return "p2";
	}
	return "p0";
    }

    //clear
    public void clearBoard(){
	for (int c = 0; c < 9; c++){
	    for (int i = 0;i < 9; i++){
		fullboard[c][i] = 0;
	    }
	}
    }

    //GUI
    public TicTacToe(){
	this.setTitle("Ultimate TicTacToe");
	this.setSize(900,900);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
      	this.setBackground(Color.white);
	points = new ArrayList<Point>();

	//create board
	fullboard = new char[9][9];
	for (int c = 0; c < 9; c++){
	    for (int i = 0;i < 9; i++){
		fullboard[c][i] = 0;
	    }
	}
	bigBoard = new char[9][9];
	for (int c = 0; c < 9; c++){
	    for (int i = 0;i < 9; i++){
		bigBoard[c][i] = 0;
	    }
	}

	pane = this.getContentPane();
       	pane.setLayout(new FlowLayout());

       	c = new JButton("Clear All");
	//   	pane.add(c);

	mousepanel = new JPanel();
	pane.add(mousepanel);
    }
    public void mousePressed(MouseEvent e){};
    public void mouseReleased(MouseEvent e){};
    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};

    public void mouseClicked(MouseEvent e){
	int x = getX();
	int y = getY();
	int inbx = x/100;
	int inby = y/100;
	//check the placement of the last piece
	fullboard[inbx][inby] = 1;
	points.add(new Point(x,y));
	repaint();


	//check winner of the larger board

	if(inbx < 3 & inby < 3){
	    if (checkWinner(0,0).equals("p1")){
		    bigBoard[0][0] = 1;
		}
	    else if(checkWinner(0,0).equals("p2")){
		    bigBoard[0][0] = 2;
		}
	}
	if(inbx < 6  & inby < 3){
	    if (checkWinner(3,0).equals("p1")){
		    bigBoard[1][0] = 1;
		}
	    else if(checkWinner(3,0).equals("p2")){
		    bigBoard[1][0] = 2;
		}
	}
	if(inby < 3){
	    if (checkWinner(6,0).equals("p1")){
		    bigBoard[2][0] = 1;
		}
	    else if(checkWinner(6,0).equals("p2")){
		    bigBoard[2][0] = 2;
		}
	}
	if(inbx < 3 & inby < 6){
	    if (checkWinner(0,3).equals("p1")){
		    bigBoard[0][1] = 1;
		}
	    else if(checkWinner(0,3).equals("p2")){
		    bigBoard[0][1] = 2;
		}
	}
	if(inbx < 3 & inby < 6){
	    if (checkWinner(3,3).equals("p1")){
		    bigBoard[1][1] = 1;
		}
	    else if(checkWinner(3,3).equals("p2")){
		    bigBoard[1][1] = 2;
		}
	}

	if(inby < 6){
	    if (checkWinner(6,3).equals("p1")){
		    bigBoard[2][1] = 1;
		}
	    else if(checkWinner(6,3).equals("p2")){
		    bigBoard[2][1] = 1;
		}
	}
	if(inbx < 3){
	    if (checkWinner(0,6).equals("p1")){
		    bigBoard[0][2] = 1;
		}
	    else if(checkWinner(0,6).equals("p2")){
		    bigBoard[0][2] = 2;
		}
	}
	if(inbx < 6 & inby < 9){
	    if (checkWinner(3,6).equals("p1")){
		    bigBoard[1][2] = 1;
		}
	    else if(checkWinner(3,6).equals("p2")){
		    bigBoard[1][2] = 2;
		}
	}

	if(inby < 9){
	    if (checkWinner(6,6).equals("p1")){
		    bigBoard[2][2] = 1;
		}
	    else if(checkWinner(6,6).equals("p2")){
		    bigBoard[2][2] = 2;
		}
	}

    }

    public void paintComponent(Graphics g){
	//	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setColor(Color.red);
	for (Point point : points){
	    g2.fillOval(point.x,point.y,20,20);
	}
    }




    public void paint(Graphics g){
	//board 1-3
	g.drawLine(0,900/9,900,900/9);
	g.drawLine(0,1800/9,900,1800/9);
	g.drawLine(900/9,0,900/9,900);
	g.drawLine(1800/9,0,1800/9,900);
	//board 4-6
	g.drawLine(0,3600/9,900,3600/9);
	g.drawLine(0,4500/9,900,4500/9);
	g.drawLine(3600/9,0,3600/9,900);
	g.drawLine(4500/9,0,4500/9,900);
	//board 7-9
	g.drawLine(0,6300/9,900,6300/9);
	g.drawLine(0,7200/9,900,7200/9);
	g.drawLine(6300/9,0,6300/9,900);
	g.drawLine(7200/9,0,7200/9,900);
	//large board
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(3));
	g.drawLine(0,900/3,900,900/3);
	g.drawLine(0,1800/3,900,1800/3);
	g.drawLine(300,0,300,900);
	g.drawLine(600,0,600,900);

    }
    //clickable
    // return clicked mouse AND x/100 * 100 && y/100 * 100
    // draw the x or o on that and set x/100,y/100 coordinate of the array to 1 or 2


    // actions
    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);

    }
    public static void main(String[] args){
        TicTacToe b = new TicTacToe();
       	b.setVisible(true);
	//	System.out.println(b.check());
    }
}
