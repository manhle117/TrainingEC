package training.bai13.model;

public class Certificate {
	private int certiId;
	private String certiName;
	private String certiRank;
	private String certificatedDate;
	
	public Certificate(int certiId, String certiName, String certiRank, String certificatedDate) {
		super();
		this.certiId = certiId;
		this.certiName = certiName;
		this.certiRank = certiRank;
		this.certificatedDate = certificatedDate;
	}

	public int getCertiId() {
		return certiId;
	}

	public void setCertiId(int certiId) {
		this.certiId = certiId;
	}

	public String getCertiName() {
		return certiName;
	}

	public void setCertiName(String certiName) {
		this.certiName = certiName;
	}

	public String getCertiRank() {
		return certiRank;
	}

	public void setCertiRank(String certiRank) {
		this.certiRank = certiRank;
	}

	public String getCertificatedDate() {
		return certificatedDate;
	}

	public void setCertificatedDate(String certificatedDate) {
		this.certificatedDate = certificatedDate;
	}

	@Override
	public String toString() {
		return "Certificate [certiId=" + certiId + ", certiName=" + certiName + ", certiRank=" + certiRank
				+ ", certificatedDate=" + certificatedDate + "]";
	}
	
	
	
}
