import java.util.Scanner;
public class Razlomak {

	private int x; //brojilac
	private int y; //imenilac
	
	public Razlomak() {
		this(0,1);
	}
	
	public Razlomak(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
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

	public static Razlomak saberi (Razlomak a, Razlomak b) {
		Razlomak r = new Razlomak ();
		r.setX(a.getX()*b.getY()+a.getY()*b.getX());
		r.setY(a.getY()*b.getY());
		r.skrati();
		return r;
	}
	public static Razlomak oduzmi (Razlomak a, Razlomak b) {
		Razlomak r = new Razlomak ();
		r.setX(a.getX()*b.getY()-a.getY()*b.getX());
		r.setY(a.getY()*b.getY());
		r.skrati();
		return r;

	}
	public static Razlomak pomnozi (Razlomak a, Razlomak b) {
		Razlomak r = new Razlomak ();
		r.setX(a.getX()*b.getX());
		r.setY(a.getY()*b.getY());
		r.skrati();
		return r;
	}
	public static Razlomak podijeli (Razlomak a, Razlomak b) {
		Razlomak r = new Razlomak ();
		r.setX(a.getX()*b.getY());
		r.setY(a.getY()*b.getX());
		r.skrati();
		return r;
	}
	
	public void skrati() {
		for(int i=2;i<=Math.min(this.x, this.y);i++)
			while(this.x%i==0 && this.y%i==0) {
				this.x/=i;
				this.y/=i;
			}
	}
	
	@Override
	public String toString() {
		return x + "/" + y;
	}


	
}