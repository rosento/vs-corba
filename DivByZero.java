
/**
* DivByZero.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calc.idl
* Freitag, 3. Juli 2015 10:31 Uhr MESZ
*/

public final class DivByZero extends org.omg.CORBA.UserException
{
  public int dividend = (int)0;

  public DivByZero ()
  {
    super(DivByZeroHelper.id());
  } // ctor

  public DivByZero (int _dividend)
  {
    super(DivByZeroHelper.id());
    dividend = _dividend;
  } // ctor


  public DivByZero (String $reason, int _dividend)
  {
    super(DivByZeroHelper.id() + "  " + $reason);
    dividend = _dividend;
  } // ctor

} // class DivByZero