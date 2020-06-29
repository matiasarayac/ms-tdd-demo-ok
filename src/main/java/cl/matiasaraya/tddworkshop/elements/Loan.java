package cl.matiasaraya.tddworkshop.elements;

public class Loan {
	
	private String type;
	private String clientName;
	private int clientRut;
	private int daysPastDue;
			
	public Loan(String type, String clientName, int clientRut, int daysPastDue) {
		super();
		this.type = type;
		this.clientName = clientName;
		this.clientRut = clientRut;
		this.daysPastDue = daysPastDue;
	}
	
	public Loan() {
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getClientRut() {
		return clientRut;
	}
	public void setClientRut(int clientRut) {
		this.clientRut = clientRut;
	}
	public int getDaysPastDue() {
		return daysPastDue;
	}
	public void setDaysPastDue(int daysPastDue) {
		this.daysPastDue = daysPastDue;
	}
	
	
}
