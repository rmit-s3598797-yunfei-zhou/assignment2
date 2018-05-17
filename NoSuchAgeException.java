//developer: YunFei Zhou s3598797
package exceptions;

public class NoSuchAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "the age can not be negative or over 150";		
	}
}
