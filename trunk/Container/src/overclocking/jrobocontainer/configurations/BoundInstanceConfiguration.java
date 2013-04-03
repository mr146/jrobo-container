package overclocking.jrobocontainer.configurations;

import overclocking.jrobocontainer.exceptions.JroboContainerException;
import overclocking.jrobocontainer.injectioncontext.IInjectionContext;
import overclocking.jrobocontainer.storages.ClassNode;
import overclocking.jrobocontainer.storages.IClassNodesStorage;
import overclocking.jrobocontainer.storages.IStorage;

public class BoundInstanceConfiguration extends AbstractConfiguration {
    private final Object instance;

    public BoundInstanceConfiguration(IStorage storage, IClassNodesStorage classNodesStorage, String abstractionId, Object instance) {
        super(storage, classNodesStorage);
        this.abstractionId = abstractionId;
        this.instance = instance;
    }

    public <T> T innerGet(IInjectionContext injectionContext, ClassLoader classloader){
        ClassNode abstraction = classNodesStorage.getClassNodeById(abstractionId);
        injectionContext.reuse(abstraction);
        return (T)instance;
    }

    public <T> T innerCreate(IInjectionContext injectionContext, ClassLoader classLoader) throws JroboContainerException {
        try {
            String resolvedClass = resolveClass(abstractionId, storage.getImplementations(abstractionId), classNodesStorage);
            return (T)getInstance(resolvedClass, injectionContext, classLoader);
        } catch (JroboContainerException ex) {
            throw ex;
        } catch (Exception ex) {
            ClassNode abstraction = classNodesStorage.getClassNodeById(abstractionId);
            throw new JroboContainerException("Failed to create " + abstraction.getClassName(), injectionContext, ex);
        }
    }
}