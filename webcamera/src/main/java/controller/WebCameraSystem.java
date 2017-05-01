package controller;

import model.entity.Observer;
import model.entity.Picture;
import model.service.PictureService;

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
