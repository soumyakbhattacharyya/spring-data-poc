package com.example.gof;

// Allows you to create different flavors of an object while avoiding constructor pollution. 
// Useful when there could be several flavors of an object. Or when there are a lot of steps involved in creation of an object.
public class Sandwich {

	public Sandwich(Builder builder) {
		this.bread = builder.bread;
		this.filler = builder.filler;
		this.sauce = builder.sauce;
		this.seasoning = builder.seasoning;
		this.extracheese = true;
		this.extraVeggied = true;
	}

	private String bread;
	private String filler;
	private String sauce;
	private String seasoning;
	private boolean extracheese;
	private boolean extraVeggied;
	
	

	@Override
	public String toString() {
		return "Sandwich [bread=" + bread + ", filler=" + filler + ", sauce=" + sauce + ", seasoning=" + seasoning
				+ ", extracheese=" + extracheese + ", extraVeggied=" + extraVeggied + "]";
	}

	public static class Builder {
		private String bread;
		private String filler;
		private String sauce;
		private String seasoning;
		private boolean extracheese;
		private boolean extraVeggied;

		public Builder withBread(String breadVariant) {
			this.bread = breadVariant;
			return this;
		}

		public Builder withFiller(String fillerVariant) {
			this.filler = fillerVariant;
			return this;
		}

		public Builder withSauce(String sauce) {
			this.sauce = sauce;
			return this;
		}

		// ... others

		public Sandwich build() {
			return new Sandwich(this);
		}
	}

	public static void main(String[] args) {
		Sandwich machine = new Builder().withBread("permeasan-oregano")
				                               .withFiller("meat")
				                               .withSauce("sweet")
				                               .build();
	
	    System.out.println(machine);
	}

}
