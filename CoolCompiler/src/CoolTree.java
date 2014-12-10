// -*- mode: java -*- 
//
// file: cool-tree.m4
//
// This file defines the AST
//
//////////////////////////////////////////////////////////



import java.util.ArrayList;
import java.util.Enumeration;


































       












































import java.util.List;
import java.io.PrintStream;
import java.util.Vector;



/** Defines simple phylum Program */
abstract class ProgramAbstract extends TreeNode {
    protected ProgramAbstract(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void semant(); 
    public abstract void cgen(PrintStream s);

}


/** Defines simple phylum Class_ */
abstract class ClassAbstract extends TreeNode {
    protected ClassAbstract(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract AbstractSymbol getName();
    public abstract AbstractSymbol getParent();
    public abstract AbstractSymbol getFilename();
    public abstract Features getFeatures();
   
    public abstract void type_check(SymbolTable o, ClassTable mc);

}


/** Defines list phylum Classes
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Classes extends ListNode {
    public final static Class elementClass = ClassAbstract.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Classes(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Classes" list */
    public Classes(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Class_" element to this list */
    public Classes appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Classes(lineNumber, copyElements());
    }
}


/** Defines simple phylum Feature */
abstract class Feature extends TreeNode {
    protected Feature(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void type_check(SymbolTable o, ClassTable mc);
    /*ADDED*/
    public abstract void code(PrintStream s, SymbolTable symbolTable, int letCount);

}


/** Defines list phylum Features
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Features extends ListNode {
    public final static Class elementClass = Feature.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Features(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Features" list */
    public Features(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Feature" element to this list */
    public Features appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Features(lineNumber, copyElements());
    }
}


/** Defines simple phylum Formal */
abstract class FormalAbstract extends TreeNode {
    protected FormalAbstract(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void type_check(SymbolTable o, ClassTable mc);
}


/** Defines list phylum Formals
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Formals extends ListNode {
    public final static Class elementClass = FormalAbstract.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Formals(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Formals" list */
    public Formals(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Formal" element to this list */
    public Formals appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Formals(lineNumber, copyElements());
    }
}


/** Defines simple phylum Expression */
abstract class Expression extends TreeNode {
    protected Expression(int lineNumber) {
        super(lineNumber);
    }
    private AbstractSymbol type = null;                                 
    public AbstractSymbol get_type() { return type; }           
    public Expression set_type(AbstractSymbol s) { type = s; return this; } 
    public abstract void dump_with_types(PrintStream out, int n);
    public void dump_type(PrintStream out, int n) {
        if (type != null)
            { out.println(Utilities.pad(n) + ": " + type.getString()); }
        else
            { out.println(Utilities.pad(n) + ": _no_type"); }
    }
    /*  public abstract void code(PrintStream s);  
    public abstract void code(PrintStream s, CgenClassTable context);
    /*ADDED*/
    public abstract void code(PrintStream s, SymbolTable symbolTable, int letCount); 
    public abstract AbstractSymbol type_check(SymbolTable o, ClassTable mc);

}


/** Defines list phylum Expressions
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Expressions extends ListNode {
    public final static Class elementClass = Expression.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Expressions(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Expressions" list */
    public Expressions(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Expression" element to this list */
    public Expressions appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Expressions(lineNumber, copyElements());
    }
    public List<AbstractSymbol> getTypes() {
    	List<AbstractSymbol> res = new ArrayList<AbstractSymbol>();
    	for (Enumeration e = this.getElements(); e.hasMoreElements();) {
    		res.add(((Expression) e.nextElement()).get_type());
    	}
    	return res;
    }
}


/** Defines simple phylum Case */
abstract class Case extends TreeNode {
    protected Case(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    
    public abstract void type_check(SymbolTable o, ClassTable mc);
}


/** Defines list phylum Cases
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Cases extends ListNode {
    public final static Class elementClass = Case.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Cases(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Cases" list */
    public Cases(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Case" element to this list */
    public Cases appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Cases(lineNumber, copyElements());
    }
}


/** Defines AST constructor 'program'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class program extends ProgramAbstract {
    protected Classes classes;
    
 /*ADDED*/
    public static CgenClassTable codegen_classtable;
    /** Creates "program" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for classes
      */
    public program(int lineNumber, Classes a1) {
        super(lineNumber);
        classes = a1;
    }
    public TreeNode copy() {
        return new program(lineNumber, (Classes)classes.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "program\n");
        classes.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_program");
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); ) {
            // (sm: as best I can tell, this used to say 'n + 1' because
            // the C++ code had a bug with this effect, and someone wanted
            // the C++ and Java output to match (understandably); since
            // I fixed the C++ bug, I am putting this back to what it
            // presumably was originally: 'n + 2')
	    ((ClassAbstract)e.nextElement()).dump_with_types(out, n + 2);
        }
    }
    /** This method is the entry point to the semantic checker.  You will
        need to complete it in programming assignment 4.
	<p>
        Your checker should do the following two things:
	<ol>
	<li>Check that the program is semantically correct
	<li>Decorate the abstract syntax tree with type information
        by setting the type field in each Expression node.
        (see tree.h)
	</ol>
	<p>
	You are free to first do (1) and make sure you catch all semantic
    	errors. Part (2) can be done in a second stage when you want
	to test the complete compiler.
    */
    public void semant() {
	/* ClassTable constructor may do some semantic analysis */
	ClassTable classTable = new ClassTable(classes);
	
	/* some semantic analysis code may go here */
	
	SymbolTable o = new SymbolTable();
	
	
	for (Enumeration e = classes.getElements(); e.hasMoreElements();) {
			((ClassAbstract) e.nextElement()).type_check(o, classTable);
	}
	
	if (classTable.errors()) {
	    System.err.println("Compilation halted due to static semantic errors.");
	    System.exit(1);
	}
	
    }
    /** This method is the entry point to the code generator.  All of the work
      * of the code generator takes place within CgenClassTable constructor.
      * @param s the output stream 
      * @see CgenClassTable
      * */
    public void cgen(PrintStream s) {
//HERE!!!!!!!!!!!!!
    	s.print("# start of generated code\n");
    	//CgenClassTable codegen_classtable = new CgenClassTable(classes, s);
    	  codegen_classtable = new CgenClassTable(classes, s);
          codegen_classtable.code();
    	s.print("\n# end of generated code\n");
//HERE!!!!!!!!!!!!
    	
    }

}


/** Defines AST constructor 'class_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class class_ extends ClassAbstract {
    protected AbstractSymbol name;
    protected AbstractSymbol parent;
    protected Features features;
    protected AbstractSymbol filename;  
    private static int labelCounter;
    
    public static class_ lastClass;

    /** Creates "class_" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for parent
      * @param a2 initial value for features
      * @param a3 initial value for filename
      */
    public class_(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Features a3, AbstractSymbol a4) {
        super(lineNumber);
        name = a1;
        parent = a2;
        features = a3;
        filename = a4;
    }
    public TreeNode copy() {
        return new class_(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(parent), (Features)features.copy(), copy_AbstractSymbol(filename));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "class_\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, parent);
        features.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, filename);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_class");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, parent);
        out.print(Utilities.pad(n + 2) + "\"");
        Utilities.printEscapedString(out, filename.getString());
        out.println("\"\n" + Utilities.pad(n + 2) + "(");
        for (Enumeration e = features.getElements(); e.hasMoreElements();) {
	    ((Feature)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
    }
    public AbstractSymbol getName()     { return name; }
    public AbstractSymbol getParent()   { return parent; }
    public AbstractSymbol getFilename() { return filename; }
    public Features getFeatures()       { return features; }
    
    public void type_check(SymbolTable o, ClassTable mc) {
    	o.enterScope();
    	mc.setCurrClass((class_) copy());
    	for (Enumeration e = features.getElements(); e.hasMoreElements();) {
    		((Feature)e.nextElement()).type_check(o, mc);
    	}
    	o.exitScope();
    	}
    
    public static int getLabelCounter(){
        labelCounter++;
        return labelCounter;
    }
    public ArrayList<method> getClassMethods()
    {
        ArrayList<method> methods = new ArrayList<method>();

        Enumeration e = this.features.getElements();
        while(e.hasMoreElements())
        {
            Feature f = (Feature) e.nextElement();
            if( f instanceof method )
            {
                methods.add((method)f);
            }
        }
        return methods;
    }

    public int getMethodCount(){
        return this.getClassMethods().size();
    }
    

    //Returns an ArrayList of attributes of the class_ object
    public ArrayList<attr> getClassAttributes(){
        ArrayList<attr> attrs = new ArrayList<attr>();

        Enumeration e = this.features.getElements();
        while(e.hasMoreElements()){
            Feature f = (Feature) e.nextElement();
            if( f instanceof attr ){
                attrs.add((attr) f);
            }
        }
        return attrs;
    }

    public int getAttributeCount(){
        return this.getClassAttributes().size();
    }
   /*
    public void code(PrintStream s, CgenClassTable context) {
    
    }*/
}


/** Defines AST constructor 'method'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class method extends Feature {
    protected AbstractSymbol name;
    protected Formals formals;
    protected AbstractSymbol return_type;
    protected Expression expr;
    /** Creates "method" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for formals
      * @param a2 initial value for return_type
      * @param a3 initial value for expr
      */
    public method(int lineNumber, AbstractSymbol a1, Formals a2, AbstractSymbol a3, Expression a4) {
        super(lineNumber);
        name = a1;
        formals = a2;
        return_type = a3;
        expr = a4;
    }
    public TreeNode copy() {
        return new method(lineNumber, copy_AbstractSymbol(name), (Formals)formals.copy(), copy_AbstractSymbol(return_type), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "method\n");
        dump_AbstractSymbol(out, n+2, name);
        formals.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, return_type);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_method");
        dump_AbstractSymbol(out, n + 2, name);
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
	    ((FormalAbstract)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_AbstractSymbol(out, n + 2, return_type);
        expr.dump_with_types(out, n + 2);
    }
    
    public void type_check(SymbolTable o, ClassTable mc) {
    	o.enterScope();
    		for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
    			((FormalAbstract) e.nextElement()).type_check(o, mc);
    		}
    		expr.type_check(o, mc);
    	o.exitScope();
    }
    
    public void code(PrintStream s, SymbolTable symbolTable, int letCount)
    {
        
     	int offset = 3;
//         
//         // addiu $sp $sp -#
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, -offset*4, s);
 //
//         //sw   $fp #($sp)  
         CgenSupport.emitStore(CgenSupport.FP, offset, CgenSupport.SP, s);
 //
         offset= offset -1;
//         //sw    $s0 #($sp)
         CgenSupport.emitStore(CgenSupport.SELF, offset, CgenSupport.SP, s);
 //
         offset= offset -1;
//         //sw  $ra #($sp)  
        CgenSupport.emitStore(CgenSupport.RA, offset, CgenSupport.SP, s);

//         //addiu    $fp $sp 4
         CgenSupport.emitAddiu(CgenSupport.FP, CgenSupport.SP, 4, s);
/*
        CgenSupport.emitPush(CgenSupport.FP,s); //push $ra
        CgenSupport.emitPush(CgenSupport.SELF,s); //push $ra
        CgenSupport.emitPush(CgenSupport.RA,s); //push $ra
        CgenSupport.emitMove(CgenSupport.FP,CgenSupport.SP, s); // move $fp $sp
    */    
        CgenSupport.emitMove(CgenSupport.SELF, CgenSupport.ACC,s);
        int numOfFormals = 0;
        Enumeration fs = formals.getElements();

        //we add the method parameter variables to the scope and associate an
        //offset with them.
        while( fs.hasMoreElements() )
        {
            formal f =(formal) fs.nextElement();
            AbstractSymbol name = f.name;
            
            int[] variableInfo = new int[2];
            
            //variableInfo[0] = 1  for a method parameter
            //variableInfo[1] = the parameter offset
            
            variableInfo[0] =1;
            variableInfo[1] =numOfFormals+1;
            symbolTable.addId(name, variableInfo);
            numOfFormals++;
            
            
        }

        expr.code(s, symbolTable, letCount);  // cgen(e);

        CgenSupport.emitLoad(CgenSupport.RA, 1, CgenSupport.SP, s);//$ra <- top
        CgenSupport.emitLoad(CgenSupport.SELF, 2, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.FP, 3, CgenSupport.SP, s);

        int z = 4*numOfFormals + 12;
        //pop the arguments
        CgenSupport.emitAddiu(CgenSupport.SP,CgenSupport.SP, z ,s);
         
        
        s.println(CgenSupport.RET); //jr $ra

    }
    
	public void code(PrintStream s, CgenClassTable context) {
	
	}
    
    public List<AbstractSymbol> getParamTypes() {
    	List<AbstractSymbol> res = new ArrayList<AbstractSymbol>();
    	for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
    		formal f = (formal)e.nextElement();
    		res.add(f.getType());
    	}
    	return res;
    	}
    
	public AbstractSymbol getName() {
		// TODO Auto-generated method stub
		return name;
	}
}


/** Defines AST constructor 'attr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class attr extends Feature {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression init;
    /** Creates "attr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      */
    public attr(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        init = a3;
    }
    public TreeNode copy() {
        return new attr(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)init.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "attr\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_attr");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
        init.dump_with_types(out, n + 2);
    }

    public void type_check(SymbolTable o, ClassTable mc) {
    		
    		o.addId(name, type_decl);
    		init.type_check(o, mc);
    		
    }
    
	public AbstractSymbol getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	 public void code(PrintStream s, SymbolTable symbolTable, int letCount)
	    {
	  
	        init.code(s,symbolTable, letCount);
	        
	        CgenSupport.emitStore(CgenSupport.ACC, 3,CgenSupport.SELF, s);


	    }
}


/** Defines AST constructor 'formal'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class formal extends FormalAbstract {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    /** Creates "formal" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      */
    public formal(int lineNumber, AbstractSymbol a1, AbstractSymbol a2) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
    }
    
    public AbstractSymbol getName() {
    	return name;
    }
    public AbstractSymbol getType() {
    	return type_decl;
    	}
    public TreeNode copy() {
        return new formal(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "formal\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_formal");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
    }
    
    public void type_check(SymbolTable o, ClassTable mc) {
    		o.addId(name, type_decl);
    	}

}


/** Defines AST constructor 'branch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class branch extends Case {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression expr;
    /** Creates "branch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for expr
      */
    public branch(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        expr = a3;
    }
    public TreeNode copy() {
        return new branch(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "branch\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_branch");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
	expr.dump_with_types(out, n + 2);
    }
	@Override
	public void type_check(SymbolTable o, ClassTable mc)
	{	
		AbstractSymbol a =	(AbstractSymbol) o.lookup(type_decl);
		if (a == null){
			type_decl = TreeConstants.No_type;
		}
		if(type_decl.equals(TreeConstants.SELF_TYPE)){
			type_decl = TreeConstants.No_type;
		}
		
		o.enterScope();
		o.addId(name, type_decl);
		expr.type_check(o, mc);
		o.exitScope();
	}
   
}


/** Defines AST constructor 'assign'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class assign extends Expression {
    protected AbstractSymbol name;
    protected Expression expr;
    /** Creates "assign" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for expr
      */
    public assign(int lineNumber, AbstractSymbol a1, Expression a2) {
        super(lineNumber);
        name = a1;
        expr = a2;
    }
    public TreeNode copy() {
        return new assign(lineNumber, copy_AbstractSymbol(name), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "assign\n");
        dump_AbstractSymbol(out, n+2, name);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_assign");
        dump_AbstractSymbol(out, n + 2, name);
        expr.dump_with_types(out, n + 2);
        dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = (AbstractSymbol) o.lookup(name);
    	AbstractSymbol b = expr.type_check(o, mc);
    	
    		if(	(b != null) && mc.subtype(b, a)){
    			set_type(b);
    		} 
    		else {
    			set_type(TreeConstants.No_type);
    			//mc.semantError(mc.getCurrClass());
    			System.out.println("Type " + b.getString()
    					+ " of assigned expression does not conform to declared type "
    					+ a.getString()
    					+ " of identifier " + name.getString()
    					+ ".");
    		}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
      
    	int[] variableInfo = (int[]) symbolTable.lookup(name);
        int offset=variableInfo[1];
        int variableType = variableInfo[0];
        
        if(name.toString().equals("self"))
        {
        	CgenSupport.emitMove(CgenSupport.ACC ,CgenSupport.SELF,s );
        }
        else
        {
	  
	        expr.code(s,symbolTable, letCount);
	        
	        if(variableType==1)
	        {
	        	// we add 3 places for the stored FP, RA and SELF
	        	
	        	offset = offset + 3;
	        	CgenSupport.emitStore(CgenSupport.ACC,offset,CgenSupport.FP,s);
	        	CgenSupport.emitLoad("$s1", offset, CgenSupport.SELF, s);
	        	
	        }
	        else if(variableType==0)
	        {
	        	offset = offset + 3;
	        	CgenSupport.emitStore(CgenSupport.ACC, offset, CgenSupport.SELF, s);
	        	CgenSupport.emitLoad("$s1", offset, CgenSupport.SELF, s);
	        	
	        	
	        }
	        else if(variableType==2)
	        {
	        	//variable is a let variable
	        	
	        	offset = offset-1;
	        	CgenSupport.emitStore(CgenSupport.ACC, offset*(-1), CgenSupport.FP, s);
	        	CgenSupport.emitLoad("$s1", offset, CgenSupport.SELF, s);
	        	
	        }
	        	
	     }
    }



}


/** Defines AST constructor 'static_dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class static_dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol type_name;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "static_dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for type_name
      * @param a2 initial value for name
      * @param a3 initial value for actual
      */
    public static_dispatch(int lineNumber, Expression a1, AbstractSymbol a2, AbstractSymbol a3, Expressions a4) {
        super(lineNumber);
        expr = a1;
        type_name = a2;
        name = a3;
        actual = a4;
    }
    public TreeNode copy() {
        return new static_dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(type_name), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "static_dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, type_name);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_static_dispatch");
	expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, type_name);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = expr.type_check(o, mc);
    	AbstractSymbol b = a;
    	
    	set_type(type_name);
    
    	/*new*/
    	if(b.equals(TreeConstants.SELF_TYPE)){
    		b = mc.getCurrClass().getName();
    		set_type(b);
    	}
    	
    	if(type_name.equals(TreeConstants.SELF_TYPE)){
    		set_type(TreeConstants.No_type);
    		//mc.semantError(mc.getCurrClass());
			System.out.println("Error: "+type_name.getString()+" invalid static type");
    	}
    	/* Invalid object type */
    	if (a.equals(TreeConstants.No_type)){
    		set_type(TreeConstants.No_type);
    		//mc.semantError(mc.getCurrClass());
			System.out.println(""+a.getString()+" invalid type");
    		 // can return, since method signature won't be found
    	}
    	
    	for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
    		((Expression) e.nextElement()).type_check(o, mc);
    	}
    	
    	return get_type();
  
    }
    
    private void pushArguments(PrintStream s, Enumeration es, SymbolTable symbolTable, int letCount)
    {
        Expression e = (Expression) es.nextElement();
        
        if(es.hasMoreElements())
        {
            pushArguments(s, es, symbolTable, letCount);
        }
        e.code(s, symbolTable, letCount);
        CgenSupport.emitPush(CgenSupport.ACC, s);
        
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        AbstractSymbol type = type_name;
        if( type.toString().equals("SELF_TYPE") )
        {
            type = class_.lastClass.name;

        }
        
        CgenNode cl = (CgenNode)program.codegen_classtable.probe(type);
        
        System.out.print(cl.getName().toString());
        int dispatchIndex = cl.getDispatchIndex(name);

        Enumeration es = actual.getElements();
        

        //save arguments
        if(es.hasMoreElements())
        {
            pushArguments(s, es, symbolTable, letCount);
        }

        //load dispatch table into into $t1

        
        CgenSupport.emitPartialLoadAddress(CgenSupport.T1, s);
        CgenSupport.emitDispTableRef(cl.name,s); s.print("\n");
        CgenSupport.emitLoad(CgenSupport.T1, dispatchIndex, CgenSupport.T1, s);
        CgenSupport.emitJalr(CgenSupport.T1, s);

    }


}


/** Defines AST constructor 'dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for name
      * @param a2 initial value for actual
      */
    public dispatch(int lineNumber, Expression a1, AbstractSymbol a2, Expressions a3) {
        super(lineNumber);
        expr = a1;
        name = a2;
        actual = a3;
    }
    public TreeNode copy() {
        return new dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_dispatch");
        expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = expr.type_check(o, mc);
    	AbstractSymbol b = a;
    	
    	set_type(a);
    	/*new*/
    	if(b.equals(TreeConstants.SELF_TYPE)){
    		b = mc.getCurrClass().getName();
    		set_type(b);
    	}
    	
    	/* Invalid object type */
    	if (a.equals(TreeConstants.No_type)){
    		set_type(TreeConstants.No_type);
    		//mc.semantError(mc.getCurrClass());
			System.out.println(""+a.getString()+" invalid type");
    		 // can return, since method signature won't be found
    	}
    	
    	for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
    		((Expression) e.nextElement()).type_check(o, mc);
    	}
    	
    	return get_type();
    
    }
    
    private void pushArguments(PrintStream s, Enumeration es, SymbolTable symbolTable, int letCount)
    {
        Expression e = (Expression) es.nextElement();
        
        if(es.hasMoreElements())
        {
            pushArguments(s, es, symbolTable, letCount);
        }
        e.code(s, symbolTable, letCount);
        CgenSupport.emitPush(CgenSupport.ACC, s);
      //  System.out.println("# argument: "+e.get_type());
        
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {


        AbstractSymbol type = expr.get_type();
        if( type == null || type.equals(TreeConstants.SELF_TYPE) ){
            type = class_.lastClass.name;
        }
        
    	CgenNode cl = (CgenNode)program.codegen_classtable.probe(type);
        int dispatchIndex = cl.getDispatchIndex(name);

        Enumeration es = actual.getElements();
        

        //save arguments
        if(es.hasMoreElements())
        {
            pushArguments(s, es, symbolTable, letCount);
        }

        //load dispatch table into into $t1

       
        //self!
        expr.code(s,symbolTable, letCount);
        
       
        CgenSupport.emitPartialLoadAddress(CgenSupport.T1, s);
        CgenSupport.emitDispTableRef(cl.name,s); s.print("\n");
        CgenSupport.emitLoad(CgenSupport.T1, dispatchIndex, CgenSupport.T1, s);
        CgenSupport.emitJalr(CgenSupport.T1, s);
        }


}


/** Defines AST constructor 'cond'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class cond extends Expression {
    protected Expression pred;
    protected Expression then_exp;
    protected Expression else_exp;
    /** Creates "cond" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for then_exp
      * @param a2 initial value for else_exp
      */
    public cond(int lineNumber, Expression a1, Expression a2, Expression a3) {
        super(lineNumber);
        pred = a1;
        then_exp = a2;
        else_exp = a3;
    }
    public TreeNode copy() {
        return new cond(lineNumber, (Expression)pred.copy(), (Expression)then_exp.copy(), (Expression)else_exp.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "cond\n");
        pred.dump(out, n+2);
        then_exp.dump(out, n+2);
        else_exp.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_cond");
	pred.dump_with_types(out, n + 2);
	then_exp.dump_with_types(out, n + 2);
	else_exp.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = pred.type_check(o, mc);
    	AbstractSymbol b = then_exp.type_check(o, mc);
    	AbstractSymbol c = else_exp.type_check(o, mc);
    	
    	if(b.equals(c)){
    		set_type(b);
    	}
    	
 	
    	/*If pred is not a condition, then is not a valid if */
    	if(!(a.equals(TreeConstants.Bool))){
    			set_type(b);
    			//mc.semantError(mc.getCurrClass());
    			System.out.println("Predicate of 'if' does not have type Bool.");
    	}
    	
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        int trueBranchInt = class_.getLabelCounter();
        int falseBranchInt  = class_.getLabelCounter();
        int endIfInt = class_.getLabelCounter();

        pred.code(s, symbolTable, letCount);//cgen(e1)

        //load false boolean constant in T1
        CgenSupport.emitLoadAddress(CgenSupport.T1, CgenSupport.BOOLCONST_PREFIX+"1", s);

        //go to false branch if predicate is false
      /*  CgenSupport.emitBeq(CgenSupport.ACC,
                             CgenSupport.T1,
                             falseBranchInt, s);
        then_exp.code(s, symbolTable, letCount);  // cgen(e);

        //go to end_if
        CgenSupport.emitBranch(endIfInt, s);

        //else expression
        CgenSupport.emitLabelDef(falseBranchInt, s);
        else_exp.code(s, symbolTable, letCount);  // cgen(e);

        //end_if branch
        CgenSupport.emitLabelDef(endIfInt, s);*/

        CgenSupport.emitBeq(CgenSupport.ACC,CgenSupport.T1,trueBranchInt,s);//beq $a0 $t1 true_branch
        CgenSupport.emitLabelDef(falseBranchInt,s);//false_branch:
        else_exp.code(s, symbolTable, letCount);// cgen(e)
        CgenSupport.emitJal("label"+endIfInt,s);// b end_if
        CgenSupport.emitLabelDef(trueBranchInt,s);//true_branch:
        then_exp.code(s, symbolTable, letCount);// cgen(e)
        CgenSupport.emitLabelDef(endIfInt,s);//end_if:

        
    }

}


/** Defines AST constructor 'loop'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class loop extends Expression {
    protected Expression pred;
    protected Expression body;
    /** Creates "loop" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for body
      */
    public loop(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        pred = a1;
        body = a2;
    }
    public TreeNode copy() {
        return new loop(lineNumber, (Expression)pred.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "loop\n");
        pred.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_loop");
	pred.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {

    	if(pred.type_check(o, mc).equals(TreeConstants.Bool)){
    		set_type(TreeConstants.Object_);
    	} else {
    		set_type(TreeConstants.Object_);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("Loop condition does not have type Bool");
    	}
    	body.type_check(o, mc);
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        int startInt = class_.getLabelCounter();
        int endInt = class_.getLabelCounter();

        CgenSupport.emitLabelDef(startInt, s);
        
        pred.code(s, symbolTable, letCount);// load predicate in $a0


        //load false boolean constant in T1
        CgenSupport.emitLoadAddress(CgenSupport.T1, CgenSupport.BOOLCONST_PREFIX+"0", s);

        //go to end if predicate is false
        CgenSupport.emitBeq(CgenSupport.ACC,
                             CgenSupport.T1,
                             endInt, s);

        //body
        body.code(s, symbolTable, letCount);  // cgen(body);

        //go to start
        CgenSupport.emitBranch(startInt, s);

        //end branch
        CgenSupport.emitLabelDef(endInt, s);

    }

}


/** Defines AST constructor 'typcase'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class typcase extends Expression {
    protected Expression expr;
    protected Cases cases;
    /** Creates "typcase" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for cases
      */
    public typcase(int lineNumber, Expression a1, Cases a2) {
        super(lineNumber);
        expr = a1;
        cases = a2;
    }
    public TreeNode copy() {
        return new typcase(lineNumber, (Expression)expr.copy(), (Cases)cases.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "typcase\n");
        expr.dump(out, n+2);
        cases.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_typcase");
        expr.dump_with_types(out, n + 2);
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
        	((Case)e.nextElement()).dump_with_types(out, n + 2);
        }
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {	
    		
    		expr.type_check(o, mc);
    		//set_type(TreeConstants.No_type);
    		
    		for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
    			((branch) e.nextElement()).type_check(o, mc);
    		}
    		
    		set_type(TreeConstants.Object_);
    		return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        

  		int caseLabel = class_.getLabelCounter();
 
  		expr.code(s,symbolTable,letCount);

  		CgenSupport.emitMove("$t2", "$a0",s);
  		CgenSupport.emitLoad("$a0", 0, "$a0", s);
  		CgenSupport.emitAddu("$t5","$a0","$a0",s); 
  		CgenSupport.emitAddu("$t5","$t5","$t5",s);
  		CgenSupport.emitAddu("$t8", "$t8", "$t5",s); 
  		CgenSupport.emitLoad("$t5", 0, "$t8", s);
  		CgenSupport.emitLoadImm("$t9",0,s);
		int startLabel = class_.getLabelCounter();
		CgenSupport.emitLabelDef(startLabel,s);
		CgenSupport.emitAddu("$t6", "$t5", "$t9",s);    	
  		CgenSupport.emitLoad("$t6", 0, "$t6",s);
  		CgenSupport.emitLoadImm("$t7", -2, s);
  		int noMatchingCases = class_.getLabelCounter();
  		CgenSupport.emitBeq("$t6", "$t7", noMatchingCases, s);	
  		int count1 = 0;
  		for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
	    	branch br = (branch)((Case)e.nextElement());
	    	int branchClassTag = 0;
	    	CgenSupport.emitLoadImm("$t4", branchClassTag,s);
       	int matchFailed =class_.getLabelCounter();
       	CgenSupport.emitBne("$t6", "$t4", matchFailed, s);
			s.println("\tb\texpr"+count1+"_"+caseLabel);
			CgenSupport.emitLabelDef(matchFailed,s);
			count1++;
		}
  		CgenSupport.emitAddiu("$t9", "$t9", 4, s);
  		CgenSupport.emitBranch(startLabel,s);
  		CgenSupport.emitLabelDef(noMatchingCases,s);
  		CgenSupport.emitMove(CgenSupport.ACC, "$t2", s);  
		CgenSupport.emitLoadImm(CgenSupport.T1, expr.getLineNumber(),s);
		CgenSupport.emitJal("_case_abort",s);						 			
   	
   	int endLabel = class_.getLabelCounter();
   	int count2 = 0;
   	for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
   		 branch br = (branch)((Case)e.nextElement());
   		 s.println("expr"+count2+"_"+caseLabel+":");
   		symbolTable.enterScope();
			ArrayList info = new ArrayList();
			info.add(2); 
			info.add(letCount+1);  		
			CgenSupport.emitStore(CgenSupport.T2, -(letCount+1), CgenSupport.FP,s);
			CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, -4,s);
			symbolTable.addId(br.name, info);		
			CgenSupport.emitPush("$t2",s);
			CgenSupport.emitPush("$t3",s);
			CgenSupport.emitPush("$t4",s);
			CgenSupport.emitPush("$t5",s);
			CgenSupport.emitPush("$t6",s);
			CgenSupport.emitPush("$t7",s);
			CgenSupport.emitPush("$t8",s);
			CgenSupport.emitPush("$t9",s);		
			br.expr.code(s,symbolTable,letCount+1);
			CgenSupport.emitTop("$t9",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t8",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t7",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t6",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t5",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t4",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t3",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitTop("$t2",s);
			CgenSupport.emitPop(s);
			CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4,s);
			symbolTable.exitScope();	
			count2++;
			CgenSupport.emitBranch(endLabel,s);
		}
   	
   		CgenSupport.emitLabelDef(endLabel,s);
  }

}


/** Defines AST constructor 'block'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class block extends Expression {
    protected Expressions body;
    /** Creates "block" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for body
      */
    public block(int lineNumber, Expressions a1) {
        super(lineNumber);
        body = a1;
    }
    public TreeNode copy() {
        return new block(lineNumber, (Expressions)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "block\n");
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_block");
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	for (Enumeration e = body.getElements(); e.hasMoreElements();) {
    		set_type(((Expression) e.nextElement()).type_check(o, mc));
    	}	
    	/*set_type to the final expression in the body*/
    	
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
        ((Expression)e.nextElement()).code(s, symbolTable, letCount);
        
        }     
    }


}


/** Defines AST constructor 'let'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class let extends Expression {
    protected AbstractSymbol identifier;
    protected AbstractSymbol type_decl;
    protected Expression init;
    protected Expression body;
    /** Creates "let" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for identifier
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      * @param a3 initial value for body
      */
    public let(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3, Expression a4) {
        super(lineNumber);
        identifier = a1;
        type_decl = a2;
        init = a3;
        body = a4;
    }
    public TreeNode copy() {
        return new let(lineNumber, copy_AbstractSymbol(identifier), copy_AbstractSymbol(type_decl), (Expression)init.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "let\n");
        dump_AbstractSymbol(out, n+2, identifier);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_let");
	dump_AbstractSymbol(out, n + 2, identifier);
	dump_AbstractSymbol(out, n + 2, type_decl);
	init.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	o.enterScope();
    	AbstractSymbol a = init.type_check(o, mc);
    	
    	o.addId(identifier, type_decl);
    	AbstractSymbol b = body.type_check(o, mc);

    	if(a == null){
    		
    		if(b!=null){
    			set_type(b);
    			}
    		
    		
    	} else if(mc.subtype(a, type_decl)){
    	
    		set_type(b);
    		
    	} 
    	
    	/*CHECK*/
    	else if(b.equals(TreeConstants.SELF_TYPE)){
    		
    		set_type(b);
    		
    	} else {
    		
    		set_type(TreeConstants.No_type);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println(" Type "+a+" of assigned expression does not conform to declared type "+type_decl+" of identifier "+identifier+".");
    		
    	}
    	
    	o.exitScope();
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        
    	
        
        ++letCount;
        
         
        int[] variableInfo = new int[2];
        variableInfo[0]=2; //variable is a let variable
        variableInfo[1]=letCount;
        
        symbolTable.enterScope();
        symbolTable.addId(identifier,variableInfo );
         
        init.code(s,symbolTable, letCount);
        CgenSupport.emitPush(CgenSupport.ACC, s);

        
        body.code(s,symbolTable, letCount);
        
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);
        
        --letCount;
        symbolTable.exitScope();
        
        
         
     }


}

/** Defines AST constructor 'plus'.
<p>
See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class plus_one extends Expression {
//protected Expression e1;
protected AbstractSymbol e1;
//protected Expression e2;
/** Creates "plus" AST node. 
  *
  * @param lineNumber the line in the source file from which this node came.
  * @param a0 initial value for e1
  * @param a1 initial value for e2
  */
public plus_one(int lineNumber, AbstractSymbol a1) {
    super(lineNumber);
    e1 = a1;
    
}
public TreeNode copy() {
    return new plus_one(lineNumber, copy_AbstractSymbol(e1));
}
public void dump(PrintStream out, int n) {
    out.print(Utilities.pad(n) + "plus_one\n");
   // e1.dump(out, n+2);
}


public void dump_with_types(PrintStream out, int n) {
    dump_line(out, n);
    out.println(Utilities.pad(n) + "_plus_one");
//e1.dump_with_types(out, n + 2);

dump_type(out, n);
}

public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
	AbstractSymbol a; //= e1.type_check(o, mc);
	
	
	if(e1.equals(TreeConstants.Int)){
		set_type(TreeConstants.Int);
	} 
	else {
		set_type(TreeConstants.Int);
		//mc.semantError(mc.getCurrClass());
		System.out.println("non-Int arguments");
	}
	return get_type();
}
/** Generates code for this expression.  This method is to be completed 
  * in programming assignment 5.  (You may or add remove parameters as
  * you wish.)
  * @param s the output stream 
  * */
public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

	/*
	 * REAL COMPILER
		la	$a0 int_const0
		jal	Object.copy
		lw	$t2 12($a0)
		lw	$t1 12($s1)
		add	$t1 $t1 $t2
		sw	$t1 12($a0)
		sw	$a0 12($s0)
	*/
	// IntSymbol variableInfo =  (IntSymbol) symbolTable.lookup(e1);
	
	int[] variableInfo = (int[]) symbolTable.lookup(e1);  
	int offset=variableInfo[1];
    int variableType = variableInfo[0];
    
    if(variableType==0)
    {
    	offset = offset + 3;
    	//CgenSupport.emitStore(CgenSupport.ACC, offset, CgenSupport.SELF, s);
    	CgenSupport.emitLoad(CgenSupport.ACC, offset, CgenSupport.SELF, s);
    }
	CgenSupport.emitJal("Object.copy", s);
	CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.ACC, s);
	CgenSupport.emitAddiu(CgenSupport.T1, CgenSupport.T1, 1, s);
	CgenSupport.emitStore(CgenSupport.T1, 3, CgenSupport.ACC, s);
	CgenSupport.emitStore(CgenSupport.ACC, 3, "$s0", s);
    
}

}

/** Defines AST constructor 'sub'.
<p>
See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class and extends Expression {
protected Expression e1;
protected Expression e2;
/** Creates "sub" AST node. 
  *
  * @param lineNumber the line in the source file from which this node came.
  * @param a0 initial value for e1
  * @param a1 initial value for e2
  */
public and(int lineNumber, Expression a1, Expression a2) {
    super(lineNumber);
    e1 = a1;
    e2 = a2;
}
public TreeNode copy() {
    return new and(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
}
public void dump(PrintStream out, int n) {
    out.print(Utilities.pad(n) + "and\n");
    e1.dump(out, n+2);
    e2.dump(out, n+2);
}


public void dump_with_types(PrintStream out, int n) {
    dump_line(out, n);
    out.println(Utilities.pad(n) + "_and");
e1.dump_with_types(out, n + 2);
e2.dump_with_types(out, n + 2);
dump_type(out, n);
}

public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
	AbstractSymbol a = e1.type_check(o, mc);
	AbstractSymbol b = e2.type_check(o, mc);
	if((a.equals(TreeConstants.Bool)) && (b.equals(TreeConstants.Bool))){
		set_type(TreeConstants.Bool);
	} 
	else {
		set_type(TreeConstants.Bool);
	//mc.semantError(mc.getCurrClass());
		System.out.println("non-BOOL arguments");
	}
	return get_type();
	}
/** Generates code for this expression.  This method is to be completed 
  * in programming assignment 5.  (You may or add remove parameters as
  * you wish.)
  * @param s the output stream 
  * */
public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

    /*
    e1.code(s, symbolTable, letCount);//cgen(e1) 
    CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
    e2.code(s, symbolTable, letCount);//cgen(e2)

    // extract the value out of the int objects
    CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

    //get e1 out of the stack and extract the value
    CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
    CgenSupport.emitLoad("$s2", 3,"$s2",s);
    
    CgenSupport.emitJal("Object.copy",s);
    
    CgenSupport.emitSub("$s1", "$s2", "$s1", s);
    CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
    CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop
    */
	
	 int iszero = class_.getLabelCounter();
	    // int notzero  = class_.getLabelCounter();
	     int endsub = class_.getLabelCounter();


		e1.code(s, symbolTable, letCount);//cgen(e1) 
	    CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
	    e2.code(s, symbolTable, letCount);//cgen(e2)

	    // extract the value out of the int objects
	    CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

	    //get e1 out of the stack and extract the value
	    CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
	    CgenSupport.emitLoad("$s2", 3, "$s2",s);
	    
	    CgenSupport.emitJal("Object.copy",s);
	    
	    CgenSupport.emitAnd("$s3", "$s2", "$s1", s);
	    
	    CgenSupport.emitBeqz("$s3", iszero, s);
	    CgenSupport.emitLoadBool(CgenSupport.ACC,BoolConst.truebool,s); 
	    CgenSupport.emitBranch(endsub, s);
	    CgenSupport.emitLabelDef(iszero, s);
	    CgenSupport.emitLoadBool(CgenSupport.ACC,BoolConst.falsebool,s); 
	    CgenSupport.emitLabelDef(endsub,s);
	    
	   // CgenSupport.emitStore("$s3", 3, CgenSupport.ACC, s);
	    
	    CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s); 
}

}

/** Defines AST constructor 'sub'.
<p>
See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class or extends Expression {
protected Expression e1;
protected Expression e2;
/** Creates "sub" AST node. 
  *
  * @param lineNumber the line in the source file from which this node came.
  * @param a0 initial value for e1
  * @param a1 initial value for e2
  */
public or(int lineNumber, Expression a1, Expression a2) {
    super(lineNumber);
    e1 = a1;
    e2 = a2;
}
public TreeNode copy() {
    return new or(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
}
public void dump(PrintStream out, int n) {
    out.print(Utilities.pad(n) + "or\n");
    e1.dump(out, n+2);
    e2.dump(out, n+2);
}


public void dump_with_types(PrintStream out, int n) {
    dump_line(out, n);
    out.println(Utilities.pad(n) + "_or");
e1.dump_with_types(out, n + 2);
e2.dump_with_types(out, n + 2);
dump_type(out, n);
}

public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
	AbstractSymbol a = e1.type_check(o, mc);
	AbstractSymbol b = e2.type_check(o, mc);
	if((a.equals(TreeConstants.Bool)) && (b.equals(TreeConstants.Bool))){
		set_type(TreeConstants.Bool);
	} 
	else {
		set_type(TreeConstants.Bool);
	//mc.semantError(mc.getCurrClass());
	System.out.println("non-Bool arguments");
	}
	return get_type();
	}
/** Generates code for this expression.  This method is to be completed 
  * in programming assignment 5.  (You may or add remove parameters as
  * you wish.)
  * @param s the output stream 
  * */
public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

    /*
    e1.code(s, symbolTable, letCount);//cgen(e1) 
    CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
    e2.code(s, symbolTable, letCount);//cgen(e2)

    // extract the value out of the int objects
    CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

    //get e1 out of the stack and extract the value
    CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
    CgenSupport.emitLoad("$s2", 3,"$s2",s);
    
    CgenSupport.emitJal("Object.copy",s);
    
    CgenSupport.emitSub("$s1", "$s2", "$s1", s);
    CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
    CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s); 
    */           // pop
//---------------------------------------------------------------------
	 int iszero = class_.getLabelCounter();
    // int notzero  = class_.getLabelCounter();
     int endsub = class_.getLabelCounter();


	e1.code(s, symbolTable, letCount);//cgen(e1) 
    CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
    e2.code(s, symbolTable, letCount);//cgen(e2)

    // extract the value out of the int objects
    CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

    //get e1 out of the stack and extract the value
    CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
    CgenSupport.emitLoad("$s2", 3, "$s2",s);
    
    CgenSupport.emitJal("Object.copy",s);
    
    CgenSupport.emitOr("$s3", "$s2", "$s1", s);
    
    CgenSupport.emitBeqz("$s3", iszero, s);
    CgenSupport.emitLoadBool(CgenSupport.ACC,BoolConst.truebool,s); 
    CgenSupport.emitBranch(endsub, s);
    CgenSupport.emitLabelDef(iszero, s);
    CgenSupport.emitLoadBool(CgenSupport.ACC,BoolConst.falsebool,s); 
    CgenSupport.emitLabelDef(endsub,s);
    
   // CgenSupport.emitStore("$s3", 3, CgenSupport.ACC, s);
    
    CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s); 
   
}

}


/** Defines AST constructor 'plus'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class plus extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "plus" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public plus(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new plus(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "plus\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_plus");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	
    	if((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))){
    		set_type(TreeConstants.Int);
    	} 
    	else {
    		set_type(TreeConstants.Int);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Int arguments");
    	}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        
        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        e2.code(s, symbolTable, letCount);//cgen(e2)

        // extract the value out of the int objects
        CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

        //get e1 out of the stack and extract the value
        CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
        CgenSupport.emitLoad("$s2", 3,"$s2",s);
        
        CgenSupport.emitJal("Object.copy",s);
        
        CgenSupport.emitAdd("$s1", "$s1", "$s2", s);
        CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop

        

    }
   /* public void code(PrintStream s, CgenClassTable context) {
    	 s.println("# start of plus");
    	 
    	 e1.code(s,context);
    	 CgenSupport.emitPush(CgenSupport.ACC, s);	/*PUSH ACC*/
    /*	 e2.code(s,context);
    	 CgenSupport.emitPush(CgenSupport.ACC, s);  /*PUSH ACC*/
    	 
    	 //New Integer Copy in ACC
    /*	 new_ newInt = new new_(this.getLineNumber(), TreeConstants.Int);
    	 newInt.code(s,context);
    	 
    	 /* *
    	  * 	T2 = e2 (TOP to Reg T2 and POP)
    	  * 	T1 = e1 (TOP to Reg T1 and POP)
    	  * 	T3 = T1+T2
    	  * 	T3 -> ACC
    	  * */
    /*	 CgenSupport.emitPop(CgenSupport.T2, s);
    	 CgenSupport.emitPop(CgenSupport.T1, s);
    	 CgenSupport.emitAdd(CgenSupport.T3, CgenSupport.T1, CgenSupport.T2, s);
    	 //Store in ACC the new Integer value. 
    	 CgenSupport.emitStore(CgenSupport.T3, 0, CgenSupport.ACC, s);
    	 
    	 s.println("# end of plus");
    }*/


}


/** Defines AST constructor 'sub'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class sub extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "sub" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public sub(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new sub(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "sub\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_sub");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	if((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))){
    		set_type(TreeConstants.Int);
    	} 
    	else {
    		set_type(TreeConstants.Int);
    	//mc.semantError(mc.getCurrClass());
    	System.out.println("non-Int arguments");
    	}
    	return get_type();
    	}
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        
        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        e2.code(s, symbolTable, letCount);//cgen(e2)

        // extract the value out of the int objects
        CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

        //get e1 out of the stack and extract the value
        CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
        CgenSupport.emitLoad("$s2", 3,"$s2",s);
        
        CgenSupport.emitJal("Object.copy",s);
        
        CgenSupport.emitSub("$s1", "$s2", "$s1", s);
        CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop

    }
    
}


/** Defines AST constructor 'mul'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class mul extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "mul" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public mul(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new mul(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "mul\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_mul");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	if((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))){
    		set_type(TreeConstants.Int);
    	} 
    	else {
    		set_type(TreeConstants.Int);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Int arguments");
    	}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        e2.code(s, symbolTable, letCount);//cgen(e2)

        // extract the value out of the int objects
        CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

        //get e1 out of the stack and extract the value
        CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
        CgenSupport.emitLoad("$s2", 3,"$s2",s);
        
        CgenSupport.emitJal("Object.copy",s);
        
        CgenSupport.emitMul("$s1", "$s2", "$s1", s);
        CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop

    }
  


}


/** Defines AST constructor 'divide'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class divide extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "divide" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public divide(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new divide(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "divide\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_divide");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	if((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))){
    		set_type(TreeConstants.Int);
    	} 
    	else {
    		set_type(TreeConstants.Int);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Int arguments");
    	}
    	return get_type();
    	}
   
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        
        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        e2.code(s, symbolTable, letCount);//cgen(e2)

        // extract the value out of the int objects
        CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

        //get e1 out of the stack and extract the value
        CgenSupport.emitLoad("$s2", 1,CgenSupport.SP,s);
        CgenSupport.emitLoad("$s2", 3,"$s2",s);
        
        CgenSupport.emitJal("Object.copy",s);
        
        CgenSupport.emitDiv("$s1", "$s2", "$s1", s);
        CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);

    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */


}


/** Defines AST constructor 'neg'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class neg extends Expression {
    protected Expression e1;
    /** Creates "neg" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public neg(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new neg(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "neg\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_neg");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = e1.type_check(o, mc);
  
    	
    	if(a.equals(TreeConstants.Int)){
    	
    		set_type(TreeConstants.Int);
    		
    	} else {
    		set_type(TreeConstants.Int);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("Argument of '~' has type "+ a +" instead of Int.");
    	}
    	return get_type();
    	}
    
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        
        
        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
      
        // extract the value out of the variable
        CgenSupport.emitLoad("$s1", 3,CgenSupport.ACC,s);

        CgenSupport.emitJal("Object.copy",s);
        CgenSupport.emitNeg("$s1","$s1",s);
        CgenSupport.emitStore("$s1", 3, CgenSupport.ACC, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop

       /* 
        e1.code(s, symbolTable, letCount);//cgen(e1) 
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        CgenSupport.emitMove(CgenSupport.T1,CgenSupport.FP,s); //$t1 Ã top, asumi que el top de el stack es FP, maybe wrong!!!
        CgenSupport.emitNeg(CgenSupport.ACC,CgenSupport.T1,s);//neg $a0 $t1
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 4, s);            // pop
	  */
    }



}


/** Defines AST constructor 'lt'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class lt extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "lt" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public lt(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new lt(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "lt\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_lt");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	
    	if ((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))) {
    	
    		set_type(TreeConstants.Bool);
    		
    	} else {
    		set_type(TreeConstants.Bool);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Int arguments: "+ a.getString() + " - "+ b.getString());
    	}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        int trueBranchInt = class_.getLabelCounter();
        int falseBranchInt  = class_.getLabelCounter();
        int endInt = class_.getLabelCounter();


        e2.code(s, symbolTable, letCount);//cgen(e2)
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        
        e1.code(s, symbolTable, letCount);//cgen(e1)
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0

        CgenSupport.emitLoad(CgenSupport.T1, 1, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.T1, s);
        CgenSupport.emitLoad(CgenSupport.T2, 2, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T2, 3, CgenSupport.T2, s);

        //go to true branch if true
        CgenSupport.emitBlt(CgenSupport.T1,
                             CgenSupport.T2,
                             trueBranchInt, s);

        //load false into $a0
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"0", s);

        //go to end tag
        CgenSupport.emitBranch(endInt, s);

        //load true into $a0
        CgenSupport.emitLabelDef(trueBranchInt, s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"1", s);


        //end_if branch
        CgenSupport.emitLabelDef(endInt, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 8, s);            // pop
    }


}


/** Defines AST constructor 'eq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class eq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "eq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public eq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new eq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "eq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_eq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	
    	
    	if ((a.equals(TreeConstants.Int) || a.equals(TreeConstants.Str) || a.equals(TreeConstants.Bool)) 
    		&& (b.equals(TreeConstants.Int) || b.equals(TreeConstants.Str) || b.equals(TreeConstants.Bool))) {
    	
    		if (a.equals(b)) {
    			
    			set_type(TreeConstants.Bool);
    			
    		}else{
    			set_type(TreeConstants.Bool);
    			//mc.semantError(mc.getCurrClass());
    			System.out.println("Illegal comparison with a basic type");
    			
    		}
    	}
    	return get_type();
    	
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        int trueBranchInt = class_.getLabelCounter();
        int falseBranchInt  = class_.getLabelCounter();
        int endInt = class_.getLabelCounter();

        e2.code(s, symbolTable, letCount);//cgen(e2)
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        
        e1.code(s, symbolTable, letCount);//cgen(e1)
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0

        CgenSupport.emitLoad(CgenSupport.T1, 1, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.T1, s);
        CgenSupport.emitLoad(CgenSupport.T2, 2, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T2, 3, CgenSupport.T2, s);

        //go to true branch if true
        CgenSupport.emitBeq(CgenSupport.T1,
                             CgenSupport.T2,
                             trueBranchInt, s);

        //load false into $a0
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"0", s);

        //go to end tag
        CgenSupport.emitBranch(endInt, s);

        //load true into $a0
        CgenSupport.emitLabelDef(trueBranchInt, s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"1", s);


        //end_if branch
        CgenSupport.emitLabelDef(endInt, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 8, s);            // pop

    }

}


/** Defines AST constructor 'leq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class leq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "leq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public leq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new leq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "leq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_leq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	AbstractSymbol a = e1.type_check(o, mc);
    	AbstractSymbol b = e2.type_check(o, mc);
    	
    	/* If both constants are from the basic type Int */
    	if ((a.equals(TreeConstants.Int)) && (b.equals(TreeConstants.Int))) {
    	
    		set_type(TreeConstants.Bool);
    		
    	} else {
    		
    		set_type(TreeConstants.Bool);
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Int arguments: "+ a.getString() + " + "+ b.getString());
    	
    	}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        int trueBranchInt = class_.getLabelCounter();
        int falseBranchInt  = class_.getLabelCounter();
        int endInt = class_.getLabelCounter();

        e2.code(s, symbolTable, letCount);//cgen(e2)
        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0
        
        e1.code(s, symbolTable, letCount);//cgen(e1)

        CgenSupport.emitPush(CgenSupport.ACC,s);// push $a0

        CgenSupport.emitLoad(CgenSupport.T1, 1, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.T1, s);
        CgenSupport.emitLoad(CgenSupport.T2, 2, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.T2, 3, CgenSupport.T2, s);

        //go to true branch if true
        CgenSupport.emitBleq(CgenSupport.T1,
                             CgenSupport.T2,
                             trueBranchInt, s);

        //load false into $a0
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"0", s);

        //go to end tag
        CgenSupport.emitBranch(endInt, s);

        //load true into $a0
        CgenSupport.emitLabelDef(trueBranchInt, s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC, CgenSupport.BOOLCONST_PREFIX+"1", s);


        //end_if branch
        CgenSupport.emitLabelDef(endInt, s);
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, 8, s);            // pop
    }


}


/** Defines AST constructor 'comp'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class comp extends Expression {
    protected Expression e1;
    /** Creates "comp" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public comp(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new comp(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "comp\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_comp");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	AbstractSymbol a = e1.type_check(o, mc);
    	
    	if (a.equals(TreeConstants.Bool)) {
    	
    		set_type(TreeConstants.Bool);
    	
    	} else {
    	
    		//mc.semantError(mc.getCurrClass());
    		System.out.println("non-Bool argument: "+ a.getString());
    		set_type(TreeConstants.Bool);
    	}
    	
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        
        
        int return_true = class_.getLabelCounter();
        int return_false = class_.getLabelCounter();
        e1.code(s,symbolTable, letCount);
           
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.ACC,s);
        CgenSupport.emitLoadBool(CgenSupport.T2,BoolConst.falsebool,s); 
        CgenSupport.emitLoad(CgenSupport.T2,3,CgenSupport.T2,s);
        CgenSupport.emitBeq(CgenSupport.T1, CgenSupport.T2, return_true, s);
        CgenSupport.emitLoadBool(CgenSupport.ACC, BoolConst.falsebool,s);    
        CgenSupport.emitBranch(return_false,s); 
        CgenSupport.emitLabelDef(return_true,s);
        CgenSupport.emitLoadBool(CgenSupport.ACC, BoolConst.truebool,s);    
        CgenSupport.emitLabelDef(return_false,s);

     }


}


/** Defines AST constructor 'int_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class int_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "int_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public int_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new int_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "int_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_int");
	dump_AbstractSymbol(out, n + 2, token);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	set_type(TreeConstants.Int);
    	return get_type();
    }
    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream 
      * */
    
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        CgenSupport.emitLoadInt(CgenSupport.ACC,
                            (IntSymbol)AbstractTable.inttable.lookup(token.getString()), s);
    }
 

}


/** Defines AST constructor 'bool_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class bool_const extends Expression {
    protected Boolean val;
    /** Creates "bool_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for val
      */
    public bool_const(int lineNumber, Boolean a1) {
        super(lineNumber);
        val = a1;
    }
    public TreeNode copy() {
        return new bool_const(lineNumber, copy_Boolean(val));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "bool_const\n");
        dump_Boolean(out, n+2, val);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_bool");
	dump_Boolean(out, n + 2, val);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	set_type(TreeConstants.Bool);
    	return get_type();
    }
    
    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream 
      * */
    
    public void code(PrintStream s,  SymbolTable symbolTable, int letCount) {

        CgenSupport.emitLoadBool(CgenSupport.ACC, new BoolConst(val), s);

    }

}


/** Defines AST constructor 'string_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class string_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "string_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public string_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new string_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "string_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_string");
	out.print(Utilities.pad(n + 2) + "\"");
	Utilities.printEscapedString(out, token.getString());
	out.println("\"");
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	set_type(TreeConstants.Str);
    	return get_type();
    }
    
    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {

        CgenSupport.emitLoadString(CgenSupport.ACC,
                                       (StringSymbol)AbstractTable.stringtable.lookup(token.getString()), s);
        }

}


/** Defines AST constructor 'new_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class new_ extends Expression {
    protected AbstractSymbol type_name;
    /** Creates "new_" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for type_name
      */
    public new_(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        type_name = a1;
    }
    public TreeNode copy() {
        return new new_(lineNumber, copy_AbstractSymbol(type_name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "new_\n");
        dump_AbstractSymbol(out, n+2, type_name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_new");
	dump_AbstractSymbol(out, n + 2, type_name);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	set_type(type_name);
    	
    	return get_type();
    }
    
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        
        CgenSupport.emitPush(CgenSupport.FP,s); //push $ra
        CgenSupport.emitPush(CgenSupport.SELF,s); //push $ra
        CgenSupport.emitPush(CgenSupport.RA,s); //push $ra
        CgenSupport.emitMove(CgenSupport.FP,CgenSupport.SP, s); // move $fp $sp

        

        CgenSupport.emitLoadAddress(CgenSupport.ACC, type_name.toString()+"_protObj",s); //lw $a0 <t1>_protObj      
        CgenSupport.emitJal("Object.copy",s);//Object.copy
        CgenSupport.emitMove(CgenSupport.SELF, CgenSupport.ACC, s);
        //CgenSupport.emitStore("$s1", 0, CgenSupport.FP,s) ; //sw	$s1 0($fp)
        CgenSupport.emitJal(type_name.toString()+"_init",s);//jal <t1>_init
        
        
         
        CgenSupport.emitLoad(CgenSupport.RA, 1, CgenSupport.SP, s);//$ra <- top
        CgenSupport.emitLoad(CgenSupport.SELF, 2, CgenSupport.SP, s);
        CgenSupport.emitLoad(CgenSupport.FP, 3, CgenSupport.SP, s);
        CgenSupport.emitAddiu(CgenSupport.SP,CgenSupport.SP, 12 ,s);
        
        
    }
    
   


}


/** Defines AST constructor 'isvoid'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class isvoid extends Expression {
    protected Expression e1;
    /** Creates "isvoid" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public isvoid(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new isvoid(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "isvoid\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_isvoid");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	if(!(e1.type_check(o, mc) == null)) {
    		set_type(TreeConstants.Bool);
    	}
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        
    	
        int true_label = class_.getLabelCounter();
        int end_label = class_.getLabelCounter();
        e1.code(s,symbolTable, letCount); 
        CgenSupport.emitMove(CgenSupport.T1,CgenSupport.ZERO,s); 
        CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, true_label,s);
        CgenSupport.emitLoadBool(CgenSupport.ACC, BoolConst.falsebool, s);
        CgenSupport.emitBranch(end_label, s);
        CgenSupport.emitLabelDef(true_label,s);
        CgenSupport.emitLoadBool(CgenSupport.ACC, BoolConst.truebool, s);
        CgenSupport.emitLabelDef(end_label,s);
     }

}


/** Defines AST constructor 'no_expr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class no_expr extends Expression {
    /** Creates "no_expr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      */
    public no_expr(int lineNumber) {
        super(lineNumber);
    }
    public TreeNode copy() {
        return new no_expr(lineNumber);
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "no_expr\n");
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_no_expr");
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	set_type(TreeConstants.No_type);
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {
        CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.ZERO, s);
    }


}


/** Defines AST constructor 'object'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class object extends Expression {
    protected AbstractSymbol name;
    /** Creates "object" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      */
    public object(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        name = a1;
    }
    public TreeNode copy() {
        return new object(lineNumber, copy_AbstractSymbol(name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "object\n");
        dump_AbstractSymbol(out, n+2, name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_object");
	dump_AbstractSymbol(out, n + 2, name);
	dump_type(out, n);
    }
    
    public AbstractSymbol type_check(SymbolTable o, ClassTable mc) {
    	
    	if(name.equals(TreeConstants.self)){
    		
    		set_type(TreeConstants.SELF_TYPE);	 
    	} 
    	else {
    		
    		AbstractSymbol x = (AbstractSymbol) o.lookup(name);
    		if(x == null){
    			set_type(TreeConstants.No_type);
    			//mc.semantError(mc.getCurrClass());
    			System.out.println("Undeclared identifier "+ name.getString());
    		}
    		else {
    			set_type(x);
    		}
    	}
    	
    	return get_type();
    }
    /** Generates code for this expression.  This method is to be completed 
      * in programming assignment 5.  (You may or add remove parameters as
      * you wish.)
      * @param s the output stream 
      * */
    public void code(PrintStream s, SymbolTable symbolTable, int letCount) {


        if(name.toString().equals("self"))
        {
        	CgenSupport.emitMove(CgenSupport.ACC ,CgenSupport.SELF,s );
        }
        
        
        else
        {
        	
        	int[] variableInfo = (int[]) symbolTable.lookup(name);
        	int offset = variableInfo[1];
        	int variableType = variableInfo[0];
        	
            
	
	        if(variableType==1)
	        {
	        	//variable is a method parameter
	        	
	        	// we add 3 places for the stored FP, RA and SELF
	        	
	        	offset = offset + 3;
	        	CgenSupport.emitLoad(CgenSupport.ACC, offset, CgenSupport.FP, s);
	        
	        }
	        else if(variableType==0)
	        {
	        	// variable is a class attribute
	        	
	        	//we add 3 places to skip other values within the object.
	        	offset = offset + 3;
	        	CgenSupport.emitLoad(CgenSupport.ACC, offset, CgenSupport.SELF, s);
	        	
	        	
	        }
	        else if(variableType==2)
	        {
	        	offset = offset-1;
	        	//variable is a let variable

	        	CgenSupport.emitLoad(CgenSupport.ACC, offset*(-1), CgenSupport.FP, s);
	        	
	        }
	        	
	     }
    }




}

