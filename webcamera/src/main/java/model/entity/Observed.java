package model.entity;

/**
 * 
 * @author  Nikolay Kosharnyi
 * 
 * Interface for Observed camera.
 *
 */
public interface Observed {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
