package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import model.entity.Observer;
import model.entity.Picture;
import model.service.PictureService;

public class WebCameraSystem implements Observer{
	
//	private Map<Long, List<Picture>> results = new HashMap<>();
	
	private PictureService pictureService;
	
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	public Picture getLastPicture(long idCamera){
		return pictureService.getLastPictureByCameraId(idCamera);
		
//		if(results.containsKey(new Long(idCamera))){
//			return ((LinkedList<Picture>)results.get(new Long(idCamera))).getLast();
//		} else {
//			return new Picture.Builder().setCameraId(idCamera).build();
//		}
			
	}

	@Override
	public void handleEvent(Picture picture) {
		pictureService.add(picture);
		
//		Long cameraId = picture.getCameraId();
//		List<Picture> listPictures = null;
//		if(results.containsKey(cameraId)){
//			listPictures = results.get(cameraId);
//			listPictures.add(picture);
//		} else {
//			listPictures = new LinkedList<Picture>();
//			listPictures.add(picture);
//			results.put(cameraId, listPictures);
//		}
	}

//	public Map<Long, List<Picture>> getResults() {
//		return results;
//	}
//
//	public void setResults(Map<Long, List<Picture>> results) {
//		this.results = results;
//	}
	
	
}
