package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author  Nikolay Kosharnyi
 * 
 * Entity for Picture.
 *
 */
@Entity
@Table(name="Picture")
public class Picture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="cameraId")
	private long cameraId;
	
	/**
	 * Actually here saving date of getting picture.
	 */
	@Column(name="info")
	private String info;
	
	public static class Builder{
		private long id = 0;
		private long cameraId = 0;
		private String info = "(no picture)";
		
		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setCameraId(long cameraId) {
			this.cameraId = cameraId;
			return this;
		}

		public Builder setInfo(String info) {
			this.info = info;
			return this;
		}

		public Picture build(){
			Picture picture = new Picture();
			picture.setId(id);
			picture.setCameraId(cameraId);
			picture.setInfo(info);
			return picture;
		}
	}
	
	public long getId() {
		return id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public long getCameraId() {
		return cameraId;
	}
	public void setCameraId(long cameraId) {
		this.cameraId = cameraId;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", cameraId=" + cameraId + ", info=" + info + "]";
	}
	
}
