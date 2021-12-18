
public class ProductDTO {
	private String no;
	private String name;
	private String price;
	private String amount;
	private String temp;
	private String indate;
	private String note;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String no, String name, String price, String amount, String temp, String indate, String note) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.temp = temp;
		this.indate = indate;
		this.note = note;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
