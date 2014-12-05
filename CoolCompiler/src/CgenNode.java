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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.Enumeration;


class CgenNode extends class_ {
    /** The parent of this node in the inheritance tree */
    private CgenNode parent;

    /** The children of this node in the inheritance tree */
    private Vector children;

    /** Indicates a basic class */
    final static int Basic = 0;

    /** Indicates a class that came from a Cool program */
    final static int NotBasic = 1;
    
    /** Does this node correspond to a basic class? */
    private int basic_status;
    
    /** Class index within the class table   */
    private int classIndex;
    
    /** A Hash of all its methods. It is used to determine at what offset
     * a particular method is within the dispatch table
     */
    private HashMap<AbstractSymbol, Integer> methods;
  
   
    /** Constructs a new CgenNode to represent class "c".
     * @param c the class
     * @param basic_status is this class basic or not
     * @param table the class table
     * */
    CgenNode(ClassAbstract c, int basic_status, CgenClassTable table) {
	super(0, c.getName(), c.getParent(), c.getFeatures(), c.getFilename());
	this.parent = null;
	this.children = new Vector();
	this.basic_status = basic_status;
	this.methods = new HashMap<AbstractSymbol, Integer>();
	AbstractTable.stringtable.addString(name.getString());
    }

    void addChild(CgenNode child) {
	children.addElement(child);
    }

    /** Gets the children of this class
     * @return the children
     * */
    Enumeration getChildren() {
	return children.elements(); 
    }

    /** Sets the parent of this class.
     * @param parent the parent
     * */
    void setParentNd(CgenNode parent) {
	if (this.parent != null) {
	    Utilities.fatalError("parent already set in CgenNode.setParent()");
	}
	if (parent == null) {
	    Utilities.fatalError("null parent in CgenNode.setParent()");
	}
	this.parent = parent;
    }    
	

    /** Gets the parent of this class
     * @return the parent
     * */
    CgenNode getParentNd() {
	return parent; 
    }

    /** Returns true is this is a basic class.
     * @return true or false
     * */
    boolean basic() { 
	return basic_status == Basic; 
    }
    
    /** Returns true if the CgenNodes are equal
     * @return true or false
     * */
    public boolean equals(CgenNode otherNode)
    {
        return (otherNode.toString().equals(this.toString()));
    }

    /** Sets the index that the class holds within the class table.
     * @param index
     * */
    public void setClassIndex(int index)
    {
        this.classIndex = index;
    }

    /** Gets the index that the class holds within the class table.
     * @return int
     * */
    public int getClassIndex()
    {
        return this.classIndex;
    }
    
/*
 * *************************************
 * 
 *	 DISPATCH!!!!
 * 
 * *************************************
 */
    /** Gets the index that a method holds within the dispatch table
     * @param method The method to be dispatched
     * @return index The index within the dispatch table
     * 
     */
    public int getDispatchIndex(AbstractSymbol name) {
    	int x=0;
    	if(this.methods.get(name) == null){
    		x =0;
    	} 
    	else 
    	if(name != null){
    		x= this.methods.get(name);
    	}
        return x;
        
    }
    
    /** Calls generates assembly code for the class dispatch table.
     * 
     * @param str
     * */
    public void codeDispatchTable(PrintStream str){
        str.print(this.getName().getString()+CgenSupport.DISPTAB_SUFFIX + CgenSupport.LABEL);
        codeDispatchTableAux(str, this);   
    }
    /** Recursive auxiliary method that generates the class dispatch table. It
     * is called by codeDispatchTable()
     * 
     * @param str
     * @param cl The class object
     * */
    private void codeDispatchTableAux(PrintStream str, CgenNode cl){
        try{
           codeDispatchTableAux(str, cl.getParentNd());
        }
        catch(Exception e){}

       ArrayList<method> ms = cl.getClassMethods();

       for(method m : ms) {
           str.println(CgenSupport.WORD + cl.getName().toString() + "." + m.getName().getString() );
           int index = this.methods.size();
           this.methods.put(m.name, index);
       }      
    }

/*
 * ************************************
 * PROTOTYPE OBJECTS
 * ************************************
 */
    public int getAttrSize(CgenNode cl){
    	int count =0;
    	
    	while(!cl.getName().getString().equals("Object")){
    	
    		count = count + cl.getAttributeCount();
    		cl = cl.getParentNd();
    	}
    	return count;
    }

	public void codeObjectPrototype(PrintStream str, Integer cltag)
    {
        str.println(CgenSupport.WORD + "-1"); 
        str.print(this.getName().getString()+CgenSupport.PROTOBJ_SUFFIX + CgenSupport.LABEL);

        //class index
        str.println( CgenSupport.WORD + cltag);
        
        int attrcount=0;
        
        //class Attr and Inherited Attr
        attrcount = getAttrSize(this);
        
        int numberOfAttributes = attrcount;
        //class size
        str.println(CgenSupport.WORD + (3 + numberOfAttributes));
        //class dispatch table tab
        str.println(CgenSupport.WORD + this.getName().getString() +CgenSupport.DISPTAB_SUFFIX);
        //default values of the class attributes

        //IntSymbol voidConst =(IntSymbol) AbstractTable.inttable.lookup("0");
       
      
        installAllAttrs(str, this);
        
   	
    }// end of codeObjectPrototype()
    
	public void installAllAttrs(PrintStream str, CgenNode cl){
		try {
			installAllAttrs(str, cl.getParentNd());
		}
	    catch(Exception e){}
		
		IntSymbol voidConst =(IntSymbol) AbstractTable.inttable.lookup("0");
	       
		for(attr a : cl.getClassAttributes()){
     		
	            if( !cl.basic() )
	            {
	                //class is not one of the basic classes
	                str.print(CgenSupport.WORD); 
	                voidConst.codeRef(str); 
	                str.print("\n");
	                
	            }
	            else
	            {
	                //class is one of the basic classes
	                if( cl.toString().equals("Int") )
	                {
	                    str.println(CgenSupport.WORD + 0);

	                }

	                if( cl.toString().equals("Bool") )
	                {
	                    str.println(CgenSupport.WORD + 0);
	                
	                }

	                if( cl.toString().equals("Str") )
	                {
	                    if( a.name.toString().equals("val") )
	                    {
	                        str.print(CgenSupport.WORD); voidConst.codeRef(str);
	                        str.print("\n");
	                    }

	                    if( a.name.toString().equals("str_field") )
	                    {
	                        str.println(CgenSupport.WORD + 0);
	                    }   
	                }
	                
	            } // if( !this.basic() )
	            
	        }
	}
	
	
	 /** Generates assembly code for the class initialization.
     * 
     * @param str
     * */
    public void codeClassInitialization(PrintStream str, SymbolTable symbolTable)
    {
    	
        str.print(this.getName().getString() + CgenSupport.CLASSINIT_SUFFIX + CgenSupport.LABEL);
        pushStackFrame(str);

        if( !this.getName().toString().equals("Object") )
        {
            jalToParentInit(str);
        }
        
        ArrayList<attr> attributes = this.getClassAttributes();
        
        int offset = 3;
        for(attr a : attributes)
        {
        	//program.debugCode("# start attribute "+a.name, str);
        	
        	if(a.init.get_type()!=null)
        	{
	        	a.init.code(str, symbolTable,0);
	        	System.out.println("#"+a.init.get_type());
	        	CgenSupport.emitStore(CgenSupport.ACC, offset, CgenSupport.SELF, str);
        	}
        	
        	//program.debugCode("# end attribute "+a.name, str);
        	
        	offset++;
        }
        
        popStackFrame(str);
        
    }
    
    /////////////////////////////////////
    // Useful code generation "macros" //
    /////////////////////////////////////

    public static void pushStackFrame(PrintStream s)
    {
        
    	int offset = 3;
//        
//        // addiu $sp $sp -#
       CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, -offset*4, s);
//
//        //sw   $fp #($sp)  
        CgenSupport.emitStore(CgenSupport.FP, offset, CgenSupport.SP, s);
//
        offset= offset -1;
//        //sw    $s0 #($sp)
        CgenSupport.emitStore(CgenSupport.SELF, offset, CgenSupport.SP, s);
//
        offset= offset -1;
//        //sw  $ra #($sp)  
       CgenSupport.emitStore(CgenSupport.RA, offset, CgenSupport.SP, s);

//        //addiu    $fp $sp 4
        CgenSupport.emitAddiu(CgenSupport.FP, CgenSupport.SP, 4, s);

        //move  $s0 $a0
       // CgenSupport.emitMove(CgenSupport.SELF, CgenSupport.ACC, s);
    	
    	//CgenSupport.emitPush(CgenSupport.FP,s); //push $ra
        //CgenSupport.emitPush(CgenSupport.SELF,s); //push $ra
        //CgenSupport.emitPush(CgenSupport.RA,s); //push $ra
        //CgenSupport.emitMove(CgenSupport.FP,CgenSupport.SP, s); // move $fp $sp
        
        CgenSupport.emitMove(CgenSupport.SELF, CgenSupport.ACC, s);
        
    }
    
    public static void popStackFrame(PrintStream str)
    {
        
        int offset = 3;

        //move  $a0 $s0
        CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.SELF, str);

        //lw  $fp #($sp)
        CgenSupport.emitLoad(CgenSupport.FP, offset, CgenSupport.SP, str);
        offset= offset -1;

        //lw    $s0  #($sp)
        CgenSupport.emitLoad(CgenSupport.SELF, offset, CgenSupport.SP, str); 
        offset= offset -1;
        
        //lw  $ra #($sp)
        CgenSupport.emitLoad(CgenSupport.RA, offset, CgenSupport.SP, str);

        offset = 3;
        //addiu $sp $sp #
        CgenSupport.emitAddiu(CgenSupport.SP, CgenSupport.SP, offset*4, str);

        //jr   $ra
        CgenSupport.emitReturn(str);
    }

    public void jalToParentInit(PrintStream str)
    {
    	
    
    	String parentString = this.parent.getName().getString();//this.getParentNd().toString();
    	String destination = parentString + CgenSupport.CLASSINIT_SUFFIX;
        
        CgenSupport.emitJal(destination, str);
        //this.parent.getName().getString();
    }
    
    
    public void code(PrintStream s, SymbolTable symbolTable)
    {
        lastClass = this;
        int idCounter = 0;
        ArrayList<attr> attributes = this.getClassAttributes();
        
        //we enter a new scope for the class attributes
        symbolTable.enterScope();
        
        for(attr at : attributes)
        {

        	int[] variableInfo = new int[2];
        	
        	//variableInfo[0] = 0 for class attributes
        	variableInfo[0] = 0;
        	
        	//variableInfo[1] = the attribute offset
        	variableInfo[1] = idCounter;
        	
        	
            symbolTable.addId(at.name,variableInfo);
            //at.code(s,symbolTable);
            idCounter++; // to identify the offsets of the class attributes
        }
        
        codeClassInitialization(s, symbolTable);
        
        idCounter = 1; // now we use it to identify the offsets of method parameters.
        
        ArrayList<method> methods =  this.getClassMethods();
        
        for(method m : methods)
        {
        	symbolTable.enterScope();
        	s.print(name + CgenSupport.METHOD_SEP + m.getName().getString() + CgenSupport.LABEL);  
        	
        	m.code(s,symbolTable,0);
            symbolTable.exitScope();
            
        }
        
        
        symbolTable.exitScope();
       
    }
   
	
}



