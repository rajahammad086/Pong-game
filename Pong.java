import java.awt.Color;

public class Pong {

	public static void main ( String[] args ) {

		Paint.buildWindow("pong",100,100,300,200,Color.WHITE);

		PongTable table = new PongTable(300,200);

		PaintAnimator animator = new PaintAnimator(20);
		animator.animate(table);
		

		for ( ; true ; ) {
			char ch = Paint.getChar();
			table.handleChar(ch);
			
		}

	}

}
