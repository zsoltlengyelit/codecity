package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;
import io.pallas.core.asset.AssetManager;
import io.pallas.core.asset.InlineAssetContent;
import io.pallas.core.controller.BaseController;
import io.pallas.core.view.View;

import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

@Controller
public class IndexController extends BaseController {

    @Inject
    private AssetManager assetManager;

    public View index() {

        final InputStream jsStream = getClass().getResourceAsStream("index.js");
        InlineAssetContent inlineContent = new InlineAssetContent(getClass().getName(), "index-inline.js", "application/javascript", jsStream);
        final String indexJs = assetManager.publishRelativeContent(inlineContent);

        return view().set("indexJs", indexJs);
    }

    public View login(@QueryParam("user") final String userName) {

        final HttpServletRequest request = request();

        request.getRequestURI();

        return view().set("user", userName);
    }

}
