package ua.webcamera;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.WebCameraSystem;
import model.entity.Camera;

/**
 * @author  Nikolay Kosharnyi
 *
 */
public class Main { 
    private static ApplicationContext context;

	public static void main( String[] args ){
		
    	/* Initialize web camera system */
		context = new ClassPathXmlApplicationContext("spring-configuration.xml");
		final WebCameraSystem CAMERA_SYSTEM = (WebCameraSystem) context.getBean("webCameraSystem");
    	
		createCamerasAndObserveThem(CAMERA_SYSTEM);
		
    	/* This block of code for getting result */
		new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                    	System.out.println(CAMERA_SYSTEM.getLastPicture(1));
                    	System.out.println(CAMERA_SYSTEM.getLastPicture(2));
                    	System.out.println(CAMERA_SYSTEM.getLastPicture(3));
                    	System.out.println("-------------------------------");
                    	
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
	
	/**
	 * Creating cameras and observe them in our web camera system
	 * @param CAMERA_SYSTEM
	 */
	private static void createCamerasAndObserveThem(WebCameraSystem CAMERA_SYSTEM){
		Camera c1 = new Camera(1, 1);
    	c1.addObserver(CAMERA_SYSTEM);	
    	Camera c2 = new Camera(2, 2);
    	c2.addObserver(CAMERA_SYSTEM);
    	Camera c3 = new Camera(3, 3);
    	c3.addObserver(CAMERA_SYSTEM);
    	
    	new Thread(c1).start();
    	new Thread(c2).start();
    	new Thread(c3).start();
	}
}
