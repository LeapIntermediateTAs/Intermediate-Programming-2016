
public class WritingUtensilDriver {
	public static void main(String[] args) {
		Pen pen = new Pen();
		System.out.println(pen.getColor());
		pen.setColor("green");
		System.out.println(pen.getColor());
		pen.use();
		System.out.println(pen.getInk());
		for(int i=0; i<6; i++) {
			pen.use();
		}
		System.out.println(pen.getInk());
	}
}
