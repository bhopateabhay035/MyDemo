package interfacing;

public class I1I2Diamond implements I1,I2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I1I2Diamond i = new I1I2Diamond();
		i.disp();
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		I1.super.disp();
		//or
		I2.super.disp();
	}

}
