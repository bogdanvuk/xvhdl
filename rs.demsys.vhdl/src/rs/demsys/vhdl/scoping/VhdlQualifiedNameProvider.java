package rs.demsys.vhdl.scoping;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import rs.demsys.vhdl.vhdl.Entity;
import rs.demsys.vhdl.vhdl.Package;

public class VhdlQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider{
 
    QualifiedName qualifiedName(Entity e) {
    	QualifiedName qn;
    	if (e.eResource().getURI().lastSegment().equals("unisim_VCOMP.vhd")) {
    		qn = QualifiedName.create("unisim", e.getName());
    	} else {
    		qn = QualifiedName.create("work", e.getName());
    	}
    	
    	System.out.println(qn);
    	return qn;
    }
    
    QualifiedName qualifiedName(Package e) {
    	QualifiedName qn;
    	if (e.eResource().getURI().lastSegment().equals("unisim_VCOMP.vhd")) {
    		qn = QualifiedName.create("unisim", e.getName());
    	} else {
    		qn = QualifiedName.create("work", e.getName());
    	}
    	
    	System.out.println(qn);
    	return qn;
    }
 
}