/**
 * 
 */
package com.qa.base;

/**
 * @author ashish k
 *
 */
public class TestUtilities extends BaseTestClass {
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			
		}
	}

}
