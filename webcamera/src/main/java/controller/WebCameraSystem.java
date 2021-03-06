package controller;

import model.entity.Observer;
import model.entity.Picture;
import model.service.PictureService;

/**
 * @author  Nikolay Kosharnyi
 * 
 * This class plays role controller of this application.
 * Here cameras save their results and user can take information what they need.
 */
public class WebCameraSystem implements Observer{
	
	private PictureService pictureService;
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Picture getLastPicture(long idCamera){
		return pictureService.getLastPictureByCameraId(idCamera);		
	}

	@Override
	public void handleEvent(Picture picture) {
		pictureService.add(picture);
	}

}
