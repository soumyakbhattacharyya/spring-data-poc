package com.example.gof;

// Abstract factory implementation
public class AbstractFactory {

	// A factory of factories; a factory that groups the individual but
	// related/dependent factories together
	// without specifying their concrete classes.

	// let's assume a kingdom comprises of Castle, King and Army
	// a KingdomFactory implementation create a kingdom leveraging a concrete
	// castle, king and army creation factory
	
	// therefore a KingdomFactory behaves as Abstract Factory

	public interface Castle {
		String getDescription();
	}

	public interface King {
		String getDescription();
	}

	public interface Army {
		String getDescription();
	}

	public interface KingdomFactory {

		Castle createCastle();

		King createKing();

		Army createArmy();

	}

	public static void main(String[] args) {

	}

}
