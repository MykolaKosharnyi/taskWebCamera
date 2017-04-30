package ua.webcamera;

import controller.WebCameraSystem;
import model.entity.Camera;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ){
    	final WebCameraSystem cameraSystem = new WebCameraSystem();
    	
    	Camera c1 = new Camera(1, 1);
    	c1.addObserver(cameraSystem);	
    	Camera c2 = new Camera(2, 2);
    	c2.addObserver(cameraSystem);
    	Camera c3 = new Camera(3, 3);
    	c3.addObserver(cameraSystem);
    	
    	new Thread(c1).start();
    	new Thread(c2).start();
    	new Thread(c3).start();
    	
    	new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                    	System.out.println(cameraSystem.getLastPicture(1));
                    	System.out.println(cameraSystem.getLastPicture(2));
                    	System.out.println(cameraSystem.getLastPicture(3));
                    	System.out.println("Amount cameras in container: " + cameraSystem.getResults().size());
                    	
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
