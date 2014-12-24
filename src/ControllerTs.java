
public class ControllerTs {

	ModelTs m;
	ViewTs v;
	
	public ControllerTs(ModelTs m) {
		
		this.m = m;
		v = new ViewTs(m, this);
		
	}

	public void setValue() {
		double value = 0;
		try {
			value = Double.valueOf(v.getEntry());
			m.setTemperature(value);
		} catch(Exception e) {
			v.displayError("Set number here");
		}
	}

	public void upValue() {
		m.upTemperature();
	}
	public void downValue() {
		m.downTemperature();
	}
}
