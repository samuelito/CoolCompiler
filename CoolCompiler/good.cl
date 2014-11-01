class A inherits C {
	x : Int <- 3;
	y : Int <- 2;
	a() : Int { 4 };
	x : A <- (new C);
};

Class BB__ inherits A {
	z : String <- "Samuel";
	b() : String { z <- "foo" };
};

class Main {
	main():C {
	  (new C).init(1,2)
	};
};

class C  {
	a : Int;
	b : Bool;
	init(x : Int, y : Bool) : C {
           {
		a <- x;
		b <- y;
		self;
           }
	};
};

