package rs.demsys.vhdl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.common.base.Predicate;

public class VhdlImportedNamespaceAwareLocalScopeProvider extends
        ImportedNamespaceAwareLocalScopeProvider {

    @Override
    public String getWildCard() {
        return "all";
    }
    
    @Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(
			EObject context, boolean ignoreCase) {
		List<ImportNormalizer> result = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
		result.add(createImportedNamespaceResolver("work.all", false));
		return result;
	}
    
    /*
        @Override
        protected IScope getGlobalScope(final Resource context, final EReference reference, final Predicate<IEObjectDescription> filter) {
            if (context != reference.eResource())
            {
                return IScope.NULLSCOPE;
            }
            else
            {
                return super.getGlobalScope(context, reference, filter);
            }
        }
        */
}
