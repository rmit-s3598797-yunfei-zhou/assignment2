//developer: YunFei Zhou s3598797
package exceptions;

public class NotToBeCoupledException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "can not make a couple when at least one member is not an adult";		
	}
}
