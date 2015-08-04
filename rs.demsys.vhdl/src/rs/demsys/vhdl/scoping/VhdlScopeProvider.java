package rs.demsys.vhdl.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.MultimapBasedScope;

import rs.demsys.vhdl.vhdl.Architecture;
import rs.demsys.vhdl.vhdl.Entity;

public class VhdlScopeProvider extends AbstractDeclarativeScopeProvider {
	
	IScope scope_ExpressionVariable_value(Architecture context, EReference reference) {
		if (context == null)
			return IScope.NULLSCOPE;
		IScope ctxScope = delegateGetScope(context, reference);
		IScope inhScope = delegateGetScope(context.getEntity(), reference);
		return MultimapBasedScope.createScope(ctxScope, inhScope.getAllElements(), false);
	}

	private IScope getOuterAttrScope(final Entity parent) {
		System.out.println(parent);
		if (parent == null) {
			return IScope.NULLSCOPE;
		} else {
			return Scopes.scopeFor(parent.getInterface_declaration());
		}
	}
	
	IScope scope_Expression_value(Architecture context, EReference reference) {
		//System.out.println("GET_SCOPE: " + context + " - " + reference);
//		if (context == null)
//			return IScope.NULLSCOPE;
//		IScope ctxScope = delegateGetScope(context, reference);
//		IScope inhScope = scope_EvaluableIDRef_ref(context.getSuper(), reference);  // resolve inheritance scoping
//		return MultimapBasedScope.createScope(ctxScope, inhScope.getAllElements(), false);
		return IScope.NULLSCOPE;
	}	
	
	public IScope scope_Architecture( Architecture arch, EReference ref ) {
		return null;
	}
	

}
