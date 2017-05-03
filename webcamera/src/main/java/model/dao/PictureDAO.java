package model.dao;

import java.util.List;

import model.entity.Picture;

/**
 * 
 * @author  Nikolay Kosharnyi
 *
 * This interface for CRUD operation with picture
 */
public interface PictureDAO {
	void add(Picture picture);
	void update(Picture picture);
	List<Picture> all();
	void delete(long pictureId);
	Picture getById(long pictureId);
	Picture getLastPictureByCameraId(long cameraId);
}
