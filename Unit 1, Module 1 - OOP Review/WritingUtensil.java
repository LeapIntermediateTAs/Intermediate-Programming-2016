
abstract class WritingUtensil {
	String color = "blue";
	String brand;
	
	abstract void setColor(String newColor);
	abstract String getColor();
	
	abstract void setBrand(String newBrand);
	abstract String getBrand();
}