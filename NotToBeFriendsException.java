//developer: YunFei Zhou s3598797
package exceptions;

public class NotToBeFriendsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "can not make an adult and a child friend or connect two children with an age gap larger than 3";		
	}
}
