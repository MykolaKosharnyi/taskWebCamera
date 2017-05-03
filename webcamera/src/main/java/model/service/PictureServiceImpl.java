package model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.dao.PictureDAO;
import model.entity.Picture;

/**
 * 
 * @author  Nikolay Kosharnyi
 * 
 * Realization of service for operation Picture.
 *
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
	
	/**
	 * Inject concrete DAO realization.
	 */
	private PictureDAO pictureDAO;

	public void setPictureDAO(PictureDAO pictureDAO) {
		this.pictureDAO = pictureDAO;
	}

	@Override
	public void add(Picture picture) {
		pictureDAO.add(picture);
	}

	@Override
	public void update(Picture picture) {
		pictureDAO.update(picture);
	}

	@Override
	public List<Picture> all() {
		return pictureDAO.all();
	}

	@Override
	public void delete(long pictureId) {
		pictureDAO.delete(pictureId);
	}

	@Override
	public Picture getById(long pictureId) {
		return pictureDAO.getById(pictureId);
	}

	@Override
	public Picture getLastPictureByCameraId(long cameraId) {
		return pictureDAO.getLastPictureByCameraId(cameraId);
	}

}
