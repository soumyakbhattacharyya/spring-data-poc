package com.example.gof;

public class Bridge {

	// motivation: Decouple an abstraction from its implementation so that the two
	// can vary independently

	interface Color {
		void applyColor();
	}

	interface Shape {
		void create();
	}

	// implementation - 1
	public static class Red implements Color {

		@Override
		public void applyColor() {
			System.out.println("paiting with red color");
		}

	}

	// implementation - 2 
	public static class Triangle implements Shape {

		Color color;

		public Triangle(Color color) {
			this.color = color;
		}

		@Override
		public void create() {
			System.out.println("creating a triangle");
			color.applyColor();
		}

	}
	
	public static void main(String[] args) {
		
		// as we see here, shape and color implementations vary independently following bridge pattern
		Shape triangle = new Triangle(new Red());
		triangle.create();
	}

}
