//developer: YunFei Zhou s3598797
package exceptions;

public class NoParentException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "can not make a child or young child has no parent or has only one parent or the parents are not couple";		
	}
}
