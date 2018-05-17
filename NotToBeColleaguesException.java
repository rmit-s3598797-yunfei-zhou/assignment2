//developer: YunFei Zhou s3598797
package exceptions;

public class NotToBeColleaguesException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "can not connect a child in a colleague relation";		
	}
}
