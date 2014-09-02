package com.codecity.web.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import com.codecity.web.core.view.CdiWiidgetFactory;
import com.landasource.wiidget.Renderer;
import com.landasource.wiidget.util.DataMap;

public class BaseController {

    @Inject
    private CdiWiidgetFactory cdiWiidgetFactory;

    @Inject
    private ServletContext context;

    protected String render(final String view, final DataMap data) {

        //        cdiWiidgetFactory.getWiidgetContext()// clear
        cdiWiidgetFactory.getWiidgetContext().setAll(data);

        final String realPath = context.getRealPath("/WEB-INF/view/" + view + ".wdgt");

        try {
            final InputStream inputStream = new FileInputStream(realPath);
            return Renderer.create(cdiWiidgetFactory).render(inputStream);
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    protected String render(final String view) {

        return render(view, new DataMap());
    }

}
