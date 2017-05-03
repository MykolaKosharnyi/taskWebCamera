package model.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author  Nikolay Kosharnyi
 * 
 * Class which run like Thread and observe Observer every TIME_TO_DELAY seconds to save result in
 * the store.
 *
 */
public class Camera implements Observed, Runnable{
	
	private long idCamera;	
	
	/**
	 * Period in seconds after which observe Observer
	 */
	private final int TIME_TO_DELAY;
	
	/**
	 * All Observers to this camera
	 */
	private List<Observer> observers = new ArrayList<>();
	
	public Camera(long idCamera){
		this.idCamera = idCamera;
		TIME_TO_DELAY = 10;
	}
	
	public Camera(long idCamera, int timeToDelay){
		this.idCamera = idCamera;
		TIME_TO_DELAY = timeToDelay;
	}

	public long getIdCamera() {
		return idCamera;
	}

	public void setIdCamera(long idCamera) {
		this.idCamera = idCamera;
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);	
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer observer : observers){
			observer.handleEvent(getPicture());
		}
	}
	
	@Override
	public void run() {
        while(true){
            try {           	
            	notifyObservers();           	
                Thread.sleep(TIME_TO_DELAY * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	private Picture getPicture(){
		return new Picture.Builder().setCameraId(idCamera).setInfo(createPictureInfo()).build();
	}
	
	private String createPictureInfo(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date()).toString();
	}
	
}
