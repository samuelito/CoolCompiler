class A {
	x : Int <- 3;
	y : Int <- 2;
	a() : Int { x + y };
};

Class BB__ inherits A {
	z : String <- "Samuel";
	b() : String { z };
};
