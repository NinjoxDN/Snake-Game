import java.util.ArrayList;
import java.util.List;

public class Tete {
	
	private int x;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public List<Corps> getSnake() {
		return snake;
	}

	public void setSnake(ArrayList<Corps> snake) {
		this.snake = snake;
	}

	private int y;
	
	private int i = 0;
	private int j = 1;
	
	private List<Corps> snake;
	
	public Tete(int x, int y, List<Corps> snake) {
		this.x = x;
		this.y = y;
		this.snake = snake;
		
	}

	
	
}
