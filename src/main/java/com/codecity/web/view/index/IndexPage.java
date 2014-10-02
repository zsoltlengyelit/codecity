package com.codecity.web.view.index;

import io.pallas.core.view.ViewFactory;
import io.pallas.core.view.wiidget.WiidgetPage;

import javax.inject.Inject;

/**
 * @author lzsolt
 */
public class IndexPage extends WiidgetPage {

    @Inject
    private ViewFactory viewFactory;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public void run() {
        write("Index hello: ");
    }

}
