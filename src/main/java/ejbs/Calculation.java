package ejbs;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Stateless
@Entity


public class Calculation {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long id;
	int number1;
	int number2;
	String operation;
	
	
	
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getNumber1() {
		return number1;
	}
	public int getNumber2() {
		return number2;
	}
	public String getOperation() {
		return operation;
	}
	public int performCalculation(int number1, int number2, String operation ) {
		int result;
		switch (operation) {
		case "+" :
			result = number1 + number2;
			break;
		case "-" :
			result = number1 - number2;
			break;
		case "*" :
			result = number1 * number2;
			break;
		case "/" :
			result = number1 / number2;
			break;
		default :
			throw new IllegalArgumentException("Invalid operation");
		}
		return result;
	}
	

}
