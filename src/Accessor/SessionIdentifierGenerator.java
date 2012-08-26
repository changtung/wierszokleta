/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

/**
 *
 * @author Grzegorz
 */
import java.security.SecureRandom;
import java.math.BigInteger;

public final class SessionIdentifierGenerator
{

  private SecureRandom random = new SecureRandom();

  public String nextSessionId()
  {
    return new BigInteger(130, random).toString(32);
  }

}
