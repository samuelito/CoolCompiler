

(*  Example cool program testing as many aspects of the code generator
    as possible.
 *)

class Main inherits A {
  		main(): Object { 
   		{	out_a();
  			out_b();
  			out_c();	
  		}	
	 };
};

class A inherits IO {
	a : Int <- 1;

	io : IO <- new IO;	
	
	a() : Int { 10-5 };

    out_a() : Object { io.out_string("Programming Assignment ") };
	out_b() : Object { io.out_int(a()) };
	out_c() : Object { io.out_string(" Completed!\n\n") };
};








