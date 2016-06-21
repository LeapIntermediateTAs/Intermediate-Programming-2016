public class Pen extends WritingUtensil {
	private int amountOfInk = 5;
	
	void setColor(String newColor) {
		color = newColor;
	}
	String getColor() {
		return color;
	}
	
	void setBrand(String newBrand) {
		brand = newBrand;
	}
	String getBrand() {
		return brand;
	}
	
	public int getInk() {
		return amountOfInk;
	}
	
	public void setInk(int ink) {
		amountOfInk = ink;
	}
	
	public void use() {
		if(amountOfInk<1) {
			System.out.println("No more ink");
		} else {
			amountOfInk--;
		}
	}
}