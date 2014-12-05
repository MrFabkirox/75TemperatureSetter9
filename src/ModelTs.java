import java.util.ArrayList;
import java.util.List;


public class ModelTs {

	List<Observer> observers = new ArrayList();
	double temperature;
	
	public void registerObserver(Observer obs) {
		observers.add(obs);
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double value) {
		this.temperature = value;
		notifyObserver();
	}

	private void notifyObserver() {
		for(Observer obs: observers) {
			obs.update();
		}
	}

	public void downTemperature() {
		setTemperature(--temperature);
	}

	public void upTemperature() {
		setTemperature(++temperature);
	}

}
