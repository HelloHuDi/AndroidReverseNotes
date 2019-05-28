package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;

public final class f extends p {
    WebView AQf;
    String AQg = "";

    public f(WebView webView) {
        AppMethodBeat.i(84746);
        this.AQf = webView;
        getUserAgentString();
        AppMethodBeat.o(84746);
    }

    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(84747);
        this.AQf.getSettings().setSupportZoom(z);
        AppMethodBeat.o(84747);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(84748);
        if (VERSION.SDK_INT >= 17) {
            this.AQf.getSettings().setMediaPlaybackRequiresUserGesture(z);
        }
        AppMethodBeat.o(84748);
    }

    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(84749);
        this.AQf.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(84749);
    }

    public final void dUa() {
        AppMethodBeat.i(84750);
        this.AQf.getSettings().setDisplayZoomControls(false);
        AppMethodBeat.o(84750);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(84751);
        this.AQf.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(84751);
    }

    public final void dUb() {
        AppMethodBeat.i(84752);
        this.AQf.getSettings().setSaveFormData(false);
        AppMethodBeat.o(84752);
    }

    public final void dUc() {
        AppMethodBeat.i(84753);
        this.AQf.getSettings().setSavePassword(false);
        AppMethodBeat.o(84753);
    }

    public final void setTextZoom(int i) {
        AppMethodBeat.i(84754);
        this.AQf.getSettings().setTextZoom(i);
        AppMethodBeat.o(84754);
    }

    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(84755);
        this.AQf.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(84755);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(84756);
        this.AQf.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        AppMethodBeat.o(84756);
    }

    public final void dUd() {
        AppMethodBeat.i(84757);
        this.AQf.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(84757);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(84758);
        this.AQf.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(84758);
    }

    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(84759);
        this.AQf.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(84759);
    }

    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(84760);
        boolean blockNetworkImage = this.AQf.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(84760);
        return blockNetworkImage;
    }

    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(84761);
        this.AQf.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(84761);
    }

    public final void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(84762);
        e.c(this.AQf.getSettings(), "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(84762);
    }

    public final void setDatabasePath(String str) {
        AppMethodBeat.i(84763);
        this.AQf.getSettings().setDatabasePath(str);
        AppMethodBeat.o(84763);
    }

    public final void dUe() {
        AppMethodBeat.i(84764);
        this.AQf.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(84764);
    }

    public final void setAppCachePath(String str) {
        AppMethodBeat.i(84765);
        this.AQf.getSettings().setAppCachePath(str);
        AppMethodBeat.o(84765);
    }

    public final void dUf() {
        AppMethodBeat.i(84766);
        this.AQf.getSettings().setAppCacheMaxSize(10485760);
        AppMethodBeat.o(84766);
    }

    public final void dUg() {
        AppMethodBeat.i(84767);
        this.AQf.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(84767);
    }

    public final void dUh() {
        AppMethodBeat.i(84768);
        this.AQf.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(84768);
    }

    public final void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(84769);
        this.AQf.getSettings().setGeolocationEnabled(z);
        AppMethodBeat.o(84769);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(84770);
        this.AQf.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(84770);
    }

    public final void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(84771);
        this.AQf.getSettings().setDefaultTextEncodingName(str);
        AppMethodBeat.o(84771);
    }

    public final void setUserAgentString(String str) {
        AppMethodBeat.i(84772);
        this.AQg = str;
        this.AQf.getSettings().setUserAgentString(str);
        AppMethodBeat.o(84772);
    }

    public final String getUserAgentString() {
        AppMethodBeat.i(84773);
        if (this.AQg == null || this.AQg.isEmpty()) {
            try {
                this.AQg = this.AQf.getSettings().getUserAgentString();
            } catch (Exception e) {
            }
        }
        String str = this.AQg;
        AppMethodBeat.o(84773);
        return str;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.i(84774);
        this.AQf.getSettings().setRenderPriority(renderPriority);
        AppMethodBeat.o(84774);
    }

    public final void dUi() {
        AppMethodBeat.i(84775);
        this.AQf.getSettings().setCacheMode(-1);
        AppMethodBeat.o(84775);
    }

    public final void dUj() {
        AppMethodBeat.i(84776);
        if (VERSION.SDK_INT >= 21) {
            this.AQf.getSettings().setMixedContentMode(0);
        }
        AppMethodBeat.o(84776);
    }

    public final void setUsingForAppBrand(int i) {
    }
}
