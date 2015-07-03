#include <cstdio>

#include "Calc.hh"

int main(int argc, char **argv) {
	CORBA::ORB_ptr orb = CORBA::ORB_init(argc, argv, "omniORB4"); 
	CORBA::Object_var obj = orb->resolve_initial_references("RootPOA");

	try {
		CORBA::Object_var obj = orb->string_to_object(argv[1]);
		Calc_var calcRef = Calc::_narrow(obj);

		if (CORBA::is_nil(calcRef)) {
			puts("calcRef is nil or wrong type\n");
			return 1;
		}

		long operand1, operand2, result;
		char op;
		while (scanf("%ld %1[+-*/] %ld\n", &operand1, &op, &operand2)) {
			switch (op) {
				case '+':
					result = calcRef->add(operand1, operand2);
					break;
				case '-':
					result = calcRef->subtr(operand1, operand2);
					break;
				case '*':
					result = calcRef->mult(operand1, operand2);
					break;
				case '/':
					try {
						result = calcRef->div(operand1, operand2);
					} catch (...) {
						puts("div by null\n");
					}
					break;
			}
			printf("%ld\n", result);
			fflush(stdout);
		}

//	} catch (CORBA::TRANSIENT&) {
	} catch (...) {
		//TODO
	}

	orb->destroy();
	return 0;
}
