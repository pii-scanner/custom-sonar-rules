package org.sonar.samples.java.checks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.ImmutableList;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.Arguments;
import org.sonar.plugins.java.api.tree.ExpressionStatementTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.InstanceOfTree;
import org.sonar.plugins.java.api.tree.LabeledStatementTree;
import org.sonar.plugins.java.api.tree.ListTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.MethodReferenceTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.ParameterizedTypeTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
 
@Rule(key = "MyFirstCustomRule")
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {
	private static final String TEST_ANNOTATION_PATH = "com.citi.cpb.annotations.NPII";
  @Override
  public List<Kind> nodesToVisit() {
    return ImmutableList.of(Kind.OTHER);
    
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
	  
	  System.out.println(tree.firstToken().text()+" || "+tree.lastToken().text()+" || "+tree.kind());
	 
	  if (tree.is(Tree.Kind.OTHER)) {
	    	
	      MethodReferenceTree mit = (MethodReferenceTree) tree;
	     
	      System.out.println("CLass"+mit.firstToken().getClass());
	      
	      
	     if( mit.firstToken().getClass().getName().equals("org.slf4j.Logger") )
	     {
	    	 System.out.println("First Token LOGGER"+mit.firstToken().text());
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
  