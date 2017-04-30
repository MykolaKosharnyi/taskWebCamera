package model.service;

import java.util.List;

import model.entity.Picture;

public interface PictureService {
	void add(Picture picture);
	void update(Picture picture);
	List<Picture> all();
	void delete(long pictureId);
	Picture getById(long pictureId);
	Picture getLastPictureByCameraId(long cameraId);
}