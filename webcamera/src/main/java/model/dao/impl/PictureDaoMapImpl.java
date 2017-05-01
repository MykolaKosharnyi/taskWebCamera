package model.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.dao.PictureDAO;
import model.entity.Picture;

public class PictureDaoMapImpl implements PictureDAO {

	private Map<Long, List<Picture>> results = new HashMap<>();
	
	@Override
	public void add(Picture picture) {
		Long cameraId = picture.getCameraId();
		List<Picture> listPictures = null;
		if(results.containsKey(cameraId)){
			listPictures = results.get(cameraId);
			listPictures.add(picture);
		} else {
			listPictures = new LinkedList<Picture>();
			listPictures.add(picture);
			results.put(cameraId, listPictures);
		}
	}

	@Override
	public void update(Picture picture) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Picture> all() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(long pictureId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Picture getById(long pictureId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Picture getLastPictureByCameraId(long cameraId) {
		if (results.containsKey(new Long(cameraId))) {
			return ((LinkedList<Picture>) results.get(new Long(cameraId))).getLast();
		} else {
			return new Picture.Builder().setCameraId(cameraId).build();
		}
	}

}
