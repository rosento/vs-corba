import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NameComponent;

public class CalcImpl extends CalcPOA {
  public int add (int x, int y) {
	  return x + y;
  }
  public int subtr (int x, int y) {
	  return x - y;
  }
  public int mult (int x, int y) {
	  return x * y;
  }
  public int div (int x, int y) throws DivByZero {
	  try {
		  return x / y;
	  } catch (ArithmeticException e) {
		  throw new DivByZero(x);
	  }
  }

  // boilerplate code essentially copied from CORBA java HelloWorld
  public static void main(String args[]) {
	  try {
		// intialize Object Request Broker
		ORB orb = ORB.init(args, null);

		// resolve Portable Object Adapter
		// policies for persistency
		POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootPOA.the_POAManager().activate();

		org.omg.CORBA.Object ref = rootPOA.servant_to_reference(new CalcImpl());
		Calc calcRef = CalcHelper.narrow(ref);

		// get the root naming context
      		// NameService invokes the name service
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

		// Use NamingContextExt which is part of the Interoperable
		// Naming Service (INS) specification.
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		// bind the Object Reference in Naming
		NameComponent path[] = ncRef.to_name("Calc");
		ncRef.rebind(path, calcRef);

		// print out stringified reference
		System.out.println(orb.object_to_string(calcRef));

		// wait for invocations from clients
		orb.run();
	  } catch (Exception e) {
		  e.printStackTrace();
		  System.exit(1);
	  }
  }
}
