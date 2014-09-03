package com.codecity.web.core;

import io.pallas.core.execution.Request;

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

    @Inject
    private Request request;

    private final DataMap model = new DataMap();

    protected String render(final String view) {

        //        cdiWiidgetFactory.getWiidgetContext()// clear
        cdiWiidgetFactory.getWiidgetContext().setAll(model());

        // TODO put to config
        final String realPath = context.getRealPath("/WEB-INF/view/" + view + ".wdgt");

        try {
            final InputStream inputStream = new FileInputStream(realPath);
            return Renderer.create(cdiWiidgetFactory).render(inputStream);
        } catch (final FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    protected Request request() {
        return request;
    }

    protected DataMap model() {
        return model;
    }

}
