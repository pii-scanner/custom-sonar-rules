[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=org.sonarsource.samples%3Ajava-custom-rules&metric=alert_status)](https://sonarcloud.io/dashboard?id=org.sonarsource.samples%3Ajava-custom-rules)

This example demonstrates how to write **Custom Rules** for SonarJava.



Sample



package org.sonar.samples.java.checks;
import java.util.ArrayList;
import java.util.List;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodReferenceTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import com.google.common.collect.ImmutableList;
 
@Rule(key = "MyFirstCustomRule")
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {
	private static final String TEST_ANNOTATION_PATH = "com.citi.cpb.annotations.NPII";
  @Override
  public List<Kind> nodesToVisit() {
	  List<Kind> kindList=new ArrayList<Kind>();
	  for(Kind k:Kind.values()) {
		  kindList.add(k);
	  }
//	  return kindList;
    return ImmutableList.of(Kind.MEMBER_SELECT);
    
  }
  static List logMethods ;
  static {
	   logMethods = new ArrayList();
	  logMethods.add("warn");
	  logMethods.add("info");
	  logMethods.add("debug");
	  
  }
  
  public void visitNode(Tree tree) {
	  
//	  if (tree.is(Tree.Kind.ANNOTATION)) {
//		  AnnotationTree mit = (AnnotationTree) tree;
//	  
//		  Stream<ExpressionTree> methodValues = mit.arguments().stream();
//		 
//		  
//		// String xyz = mit.annotationType().symbolType().name();
//		 
//		  System.out.println("Full String  "+ xyz );
//	  
//	  }
	  try {
	  //System.out.println(tree.kind()+ " - " +tree.firstToken().text()+" || "+tree.lastToken().text());
	  }
	  catch (Exception e) {
		// TODO: handle exception
		 // e.printStackTrace();
	}
	  if (tree.is(Tree.Kind.MEMBER_SELECT)) {
	    	
	      MemberSelectExpressionTree mit = (MemberSelectExpressionTree) tree;
	     
	      
	      
	      
	     if( logMethods.contains(mit.lastToken().text()) )
	     {
	    	   System.out.println(mit.firstToken().text()+"."+mit.lastToken().text());
	    	   System.out.println(mit.lastToken().kind()+" || "+mit.lastToken().kind());
//	    	 System.out.println("First Token LOGGER "+mit.identifier().firstToken());
//	    	 System.out.println("Last Token LOGGER "+mit.identifier().lastToken());
	     }
	    
	      
//	      Arguments arguments = mit.arguments();
////	      String xyz = arguments.toString();
////	      System.out.println("Full String  "+ xyz );
//	      
//          if (!arguments.isEmpty()) {
//              for (int i = 0; i < arguments.size(); i++) {
//                  String parameter = arguments.get(i).firstToken().text();
//                  String parameterValue = arguments.get(i).lastToken().text();
//                  
//            
//                  System.out.println("Argument "+i+"st token  "+ parameter );
//                  System.out.println("Argument "+ i +"st token  "+ parameterValue );
//              }
//          }
//	      
//              String mname = mit.symbol().name();
//              Symbol.MethodSymbol methodSymbol = (Symbol.MethodSymbol) mit.symbol();
//                  System.out.println("Invoked Method  "+ mname );
//                  
                  
                  
	  }
	  
	  
	  
	  
  }
  
  
  
  
  
}
  
