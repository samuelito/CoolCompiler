/*
Copyright (c) 2000 The Regents of the University of California.
All rights reserved.

Permission to use, copy, modify, and distribute this software for any
purpose, without fee, and without written agreement is hereby granted,
provided that the above copyright notice and the following two
paragraphs appear in all copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

// This is a project skeleton file

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

/** This class may be used to contain the semantic information such as
 * the inheritance graph.  You may use it or not as you like: it is only
 * here to provide a container for the supplied methods.  */
class ClassTable {
    private int semantErrors;
    private PrintStream errorStream;
    
    
  //  private class_ obj_const;
    private ArrayList<class_> class_map = new ArrayList();
    private HashMap<AbstractSymbol, ArrayList<AbstractSymbol>> inheritance;
    private ArrayList<AbstractSymbol> basics = new ArrayList();
  //  private int curr_class = -1;
  //  private class_ currentClass = null;

    /** Creates data structures representing basic Cool classes (Object,
     * IO, Int, Bool, String).  Please note: as is this method does not
     * do anything useful; you will need to edit it to make if do what
     * you want.
     * */
    void installBasicClasses() {
	
    AbstractSymbol filename 
	    = AbstractTable.stringtable.addString("<basic class>");
	
	// The following demonstrates how to create dummy parse trees to
	// refer to basic Cool classes.  There's no need for method
	// bodies -- these are already built into the runtime system.

	// IMPORTANT: The results of the following expressions are
	// stored in local variables.  You will want to do something
	// with those variables at the end of this method to make this
	// code meaningful.

	// The Object class has no parent class. Its methods are
	//        cool_abort() : Object    aborts the program
	//        type_name() : Str        returns a string representation 
	//                                 of class name
	//        copy() : SELF_TYPE       returns a copy of the object

	class_ Object_class = 
	    new class_(0, 
		       TreeConstants.Object_, 
		       TreeConstants.No_class,
		       new Features(0)
			   .appendElement(new method(0, 
					      TreeConstants.cool_abort, 
					      new Formals(0), 
					      TreeConstants.Object_, 
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.type_name,
					      new Formals(0),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.copy,
					      new Formals(0),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0))),
		       filename);
	
	// The IO class inherits from Object. Its methods are
	//        out_string(Str) : SELF_TYPE  writes a string to the output
	//        out_int(Int) : SELF_TYPE      "    an int    "  "     "
	//        in_string() : Str            reads a string from the input
	//        in_int() : Int                "   an int     "  "     "

	class_ IO_class = 
	    new class_(0,
		       TreeConstants.IO,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new method(0,
					      TreeConstants.out_string,
					      new Formals(0)
						  .appendElement(new formal(0,
								     TreeConstants.arg,
								     TreeConstants.Str)),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.out_int,
					      new Formals(0)
						  .appendElement(new formal(0,
								     TreeConstants.arg,
								     TreeConstants.Int)),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.in_string,
					      new Formals(0),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.in_int,
					      new Formals(0),
					      TreeConstants.Int,
					      new no_expr(0))),
		       filename);

	// The Int class has no methods and only a single attribute, the
	// "val" for the integer.

	class_ Int_class = 
	    new class_(0,
		       TreeConstants.Int,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	// Bool also has only the "val" slot.
	class_ Bool_class = 
	    new class_(0,
		       TreeConstants.Bool,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	// The class Str has a number of slots and operations:
	//       val                              the length of the string
	//       str_field                        the string itself
	//       length() : Int                   returns length of the string
	//       concat(arg: Str) : Str           performs string concatenation
	//       substr(arg: Int, arg2: Int): Str substring selection

	class_ Str_class =
	    new class_(0,
		       TreeConstants.Str,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.Int,
					    new no_expr(0)))
			   .appendElement(new attr(0,
					    TreeConstants.str_field,
					    TreeConstants.prim_slot,
					    new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.length,
					      new Formals(0),
					      TreeConstants.Int,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.concat,
					      new Formals(0)
						  .appendElement(new formal(0,
								     TreeConstants.arg, 
								     TreeConstants.Str)),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.substr,
					      new Formals(0)
						  .appendElement(new formal(0,
								     TreeConstants.arg,
								     TreeConstants.Int))
						  .appendElement(new formal(0,
								     TreeConstants.arg2,
								     TreeConstants.Int)),
					      TreeConstants.Str,
					      new no_expr(0))),
		       filename);

	/* Do somethind with Object_class, IO_class, Int_class,
           Bool_class, and Str_class here */
	
	class_map.add(Object_class);
	class_map.add(IO_class);
	class_map.add(Int_class);
	class_map.add(Bool_class);
	class_map.add(Str_class);
	
	basics.add(IO_class.getName());
	basics.add(Int_class.getName());
	basics.add(Bool_class.getName());
	basics.add(Str_class.getName());
	
	inheritance.put(Object_class.getName(), basics);
	
    }
	
    
  
    public ClassTable(Classes cls) {
	semantErrors = 0;
	errorStream = System.err;
	
	/* fill this in */
	
	
	installBasicClasses();
	class_ classcopy;
	
		/*Adds copy of classes to the class map*/
		for(int i=0; i < cls.getLength(); i++){
				classcopy = (class_) cls.getNth(i).copy();
			
				basic_inherit(classcopy, class_map);
				basic_redefine(classcopy, class_map);
				previously_defined(classcopy, class_map);
			
				class_map.add(classcopy);
		}
		
		/*Checks if Main is defined*/
		if (!class_map.contains(TreeConstants.Main)){
				errorStream.print("Class Main is not defined");
				semantError();
		}
		
		/*Checks if a class inherits from an undefined class*/
		for (int i=0; i < cls.getLength();i++){
			classcopy = (class_) cls.getNth(i).copy();
			correct_inherits(classcopy, class_map);
		}
		
		/*
		 * TODO: Inheritance Graph
		 * 
		 *  Builds the graph 
		 */
		
		inheritance_graph(class_map);
		check_cycle();
	/*ClassTable END*/
    }
    
    public void inheritance_graph(ArrayList<class_> cm){
    	class_ classcopy;
    	for(int i=0; i< cm.size(); i++){
    			classcopy = cm.get(i);
    			if (!inheritance.containsKey(classcopy.getParent())){
    					inheritance.put(classcopy.getParent(), new ArrayList<AbstractSymbol>());
    			}	
    			inheritance.get(classcopy.getParent()).add(classcopy.getName());
    			
    	}
    }
    public void check_cycle(){
    	/*TODO*/
    }
    
    /*Checks if class inherits from Int, String or Bool*/
    public void basic_inherit(class_ c, ArrayList<class_> cm)	{
		for(int i=2; i<5; i++){
			if(c.getParent() == cm.get(i).getName() || c.getParent() == TreeConstants.SELF_TYPE ){
						semantError(c);
						System.out.println("Cannot inherit from class Int, String, Bool or SELF_TYPE");
				}
		}
		
	}
    
    /*Verifies if any basic class is being redefined*/
    public void basic_redefine(class_ c, ArrayList<class_> cm){
    	for(int i=2; i<5; i++){
    		if(c.getName() == cm.get(i).getName()){
 					semantError(c);
 					System.out.println("Cannot redefine basic classes: Object, IO, String, Int or Bool");
 			}
    	}
    }
    /*Verifies if the remaining classes to add were defined more than once*/
    public void previously_defined(class_ c, ArrayList<class_> cm){
    	for(int i = 5; i < cm.size(); i++){
			if(c.getName() == cm.get(i).getName()){
					semantError(c);
					System.out.println("Class was already defined: " + cm.get(i).getName().getString());
			}
		}
    }
    
    /*------VERIFICAR!!!!!!!!!!!!*/
    /*Class inherits from undefined class*/
    public void correct_inherits(class_ c, ArrayList<class_> cm){
    			if(!cm.contains(c.getParent())){
    /*CHECK!!!*/	cm.remove(c);    
    				semantError(c);
    				System.out.println("Class " + c.getName().getString() + " inherits from undefined class");
    			}
    }

    /** Prints line number and file name of the given class.
     *
     * Also increments semantic error countc.
     *
     * @param c the class
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError(class_ c) {
	return semantError(c.getFilename(), c);
    }

    /** Prints the file name and the line number of the given tree node.
     *
     * Also increments semantic error count.
     *
     * @param filename the file name
     * @param t the tree node
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError(AbstractSymbol filename, TreeNode t) {
	errorStream.print(filename + ":" + t.getLineNumber() + ": ");
	return semantError();
    }

    /** Increments semantic error count and returns the print stream for
     * error messages.
     *
     * @return a print stream to which the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError() {
	semantErrors++;
	return errorStream;
    }

    /** Returns true if there are any static semantic errors. */
    public boolean errors() {
	return semantErrors != 0;
    }

    // NOT TO BE INCLUDED IN SKELETON
   /* public static void main(String[] args) {
	new ClassTable(null).installBasicClasses();
    }*/
}
			  
    
