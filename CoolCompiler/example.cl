

(*  Example cool program testing as many aspects of the code generator
    as possible.
 *)

class Main inherits A {
  		main(): Object { 
   		{	
   			out_a();
  			out_b();
  			out_c();
  			out_d();
  			out_e();	
  		}	
	 };
};

class A inherits IO {

	
	io : IO <- new IO;	

	and1() : String { 
		if true or true and false then "true" else "false" fi
	};
		
	or1() : String { 
	
		if (true or true) and false then "true" else "false" fi
		 
	};
	
    out_a() : Object { io.out_string(" T or T and F -> ") };
	out_b() : Object { io.out_string(and1()) };
	out_c() : Object { io.out_string("\n\n(T or T) and F -> ") };
	out_d() : Object { io.out_string(or1()) };
	out_e() : Object { io.out_string("\n\n ") };

};