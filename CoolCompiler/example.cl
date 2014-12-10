

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
  		}	
	 };
};

class A inherits IO {
	a : Int;

	io : IO <- new IO;	
	
	a() : Int { {
		a <- 0;
		a++;
		6-a;
		} 
	};
	
	b() : Bool { false };
	
    out_b() : Object { io.out_string(". Programming Assignment ") };
	out_c() : Object { io.out_int(a()) };
	out_d() : Object { io.out_string(" Completed!\n\n") };
	out_a() : Object {
		if b() then io.out_int(1) else io.out_int(0) fi
		};
};