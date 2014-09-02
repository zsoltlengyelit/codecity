package com.codecity.web.core.view;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import com.landasource.wiidget.context.DefaultWiidgetContext;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class CdiWiidgetContext extends DefaultWiidgetContext {

    @Inject
    private BeanManager beanManager;

    @Override
    public Object get(final String variable) {

        final Object object = super.get(variable);

        if (object == null) {
            return getBeanByName(variable);
        }

        return object;
    }

    public Object getBeanByName(final String name) // eg. name=availableCountryDao
    {

        final Bean<?> bean = beanManager.getBeans(name).iterator().next();
        final CreationalContext<?> ctx = beanManager.createCreationalContext(bean); // could be inlined below
        final Object o = beanManager.getReference(bean, bean.getClass(), ctx); // could be inlined with return
        return o;
    }
}
