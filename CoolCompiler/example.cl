

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

	and1() : Int { 
		if true or true and false then 1 else 0 fi
	};
		
	or1() : Int { 
	
		if (true or true) and false then 1 else 0 fi
		 
	};
	
    out_a() : Object { io.out_string(" T or T and F ") };
	out_b() : Object { io.out_int(and1()) };
	out_c() : Object { io.out_string(" (T or T) and F ") };
	out_d() : Object { io.out_int(or1()) };
	out_e() : Object { io.out_string("\n\n ") };
	
	--a : Int;
	--a() : Int { {
	--	a <- 0;
	--	a++;
	--	6-a;	
	--	} 
	--};
	--b() : Bool { false };
	--out_a() : Object {
	--	if b() then io.out_int(1) else io.out_int(0) fi
	--	};
};





