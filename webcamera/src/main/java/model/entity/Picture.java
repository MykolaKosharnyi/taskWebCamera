package model.entity;

public class Picture {
	private long id;
	private long cameraId;
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
