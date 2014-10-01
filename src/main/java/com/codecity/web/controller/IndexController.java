package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;
import io.pallas.core.asset.AssetManager;
import io.pallas.core.asset.InlineAssetContent;
import io.pallas.core.controller.BaseController;
import io.pallas.core.view.AbstractView;
import io.pallas.core.view.View;

import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

import com.codecity.web.view.index.IndexPage;

@Controller
public class IndexController extends BaseController {

    @Inject
    private AssetManager assetManager;

    @Inject
    private IndexPage indexPage;

    public View index() {

        final InputStream jsStream = getClass().getResourceAsStream("index.js");
        final InlineAssetContent inlineContent = new InlineAssetContent(getClass().getName(), "index-inline.js", "application/javascript", jsStream);
        final String indexJs = assetManager.publishRelativeContent(inlineContent);

        return view().set("indexJs", indexJs);

        //return indexPage;
    }

    public String api(@QueryParam("foo") final String foo) {
        return "api: " + foo;
    }

    @POST
    public AbstractView login(@QueryParam("user") final String userName) {

        return view().set("user", userName);
    }

}
