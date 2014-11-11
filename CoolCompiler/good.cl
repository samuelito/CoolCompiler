class A inherits C {
	x : Int <- 3;
	z : A <- (new C);
	b : Bool <- true;
	h : Int <- 1;
	
	a() : Int { 4 };
	cond() : Int { if b then 1 else 0 fi };
	doh() : Int { (let i : Int <- h in { h <- h + 2; i; } ) };
};

Class BB__ inherits A {
	z : String <- "Samuel";
	b() : String { z <- "foo" };
	
	isNil() : Bool { false };
	f() : Int {
		case 0 of
			i : Int => 5;
			j : String => "j";
			k : Bool => false;
		esac
	};
};

class Main {
	main():C {
	  (new C).init(1,2)
	};
	
	w : Int <- 0;
	wm() : Object {
		while w <= 100 loop w = w + 1 pool
	};
};

class C  {
	a : Int;
	b : Bool <- true;
	init(x : Int, y : Bool) : C {
           {
		a <- x;
		b <- y;
		self;
           }
	};
};

class Try_let {

	s() : SELF_TYPE {
        (let position : Int <- 0 in
        (let num : Int <- 5 in
        (let temp : String in
            { while position < num loop
                    {	 temp <- "temp";
                        position <- position + 1;
                    }
                pool;
                temp;
                self;
            }
        ) ) )
    };
};

