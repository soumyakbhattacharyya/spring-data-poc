package com.example.gof;

public class Adapter {

	static interface TwoPlugPoint {
		void chargeViaTwoPin();
	}

	static class TwoPlugPointImpl implements TwoPlugPoint {

		@Override
		public void chargeViaTwoPin() {
			System.out.println("charging via two pin");

		}

	}

	static class ThreePlugPointImpl implements ThreePlugPoint {

		@Override
		public void chargeViaThreePin() {
			System.out.println("charging via three pin");

		}

	}

	static interface ThreePlugPoint {
		void chargeViaThreePin();
	}

	static class PlugAdapter implements TwoPlugPoint {

		private ThreePlugPoint threePlugPoint;

		public PlugAdapter(ThreePlugPoint threePlugPoint) {
			this.threePlugPoint = threePlugPoint;
		}

		@Override
		public void chargeViaTwoPin() {
			this.threePlugPoint.chargeViaThreePin();

		}

	}

	static class Device {

		public Device(TwoPlugPoint twoPlugPoint) {
			this.twoPlugPoint = twoPlugPoint;
		}

		private TwoPlugPoint twoPlugPoint;

		public void recharge() {
			System.out.println("supposed to be chaging via two pins");
			twoPlugPoint.chargeViaTwoPin();
		}
	}

	public static void main(String[] args) {

		Device device = new Device(new PlugAdapter(new ThreePlugPointImpl()));
		device.recharge();

	}

}
