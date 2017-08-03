package userinput;


//Class for checking whether the input is a number
public class TextFieldCheck {
   
	public int NumCheck(String check)
	{   int flag=0;
		try {
		     Integer.parseInt(check);
		     
		     flag=1;
		}
		catch (NumberFormatException f) {
			flag=-1;
		}
		return flag;
	}
	
	public int NumericCheck(String check)
	{
		int flag=0;
		try {
		     Double.parseDouble(check);
		     
		     flag=1;
		}
		catch (NumberFormatException f) {
			flag=-1;
		}
		return flag;
	}
   
}
