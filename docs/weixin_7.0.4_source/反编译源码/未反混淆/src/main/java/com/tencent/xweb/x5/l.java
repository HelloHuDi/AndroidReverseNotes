package com.tencent.xweb.x5;

import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.p;
import com.tencent.xweb.p.a;
import org.xwalk.core.Log;

public final class l extends p {
    WebView AQT;
    private int AQU = 0;

    public l(WebView webView) {
        this.AQT = webView;
    }

    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(84962);
        this.AQT.getSettings().setSupportZoom(z);
        AppMethodBeat.o(84962);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(84963);
        this.AQT.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(84963);
    }

    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(84964);
        this.AQT.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(84964);
    }

    public final void dUa() {
        AppMethodBeat.i(84965);
        this.AQT.getSettings().setDisplayZoomControls(false);
        AppMethodBeat.o(84965);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(84966);
        this.AQT.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(84966);
    }

    public final void dUb() {
        AppMethodBeat.i(84967);
        this.AQT.getSettings().setSaveFormData(false);
        AppMethodBeat.o(84967);
    }

    public final void dUc() {
        AppMethodBeat.i(84968);
        this.AQT.getSettings().setSavePassword(false);
        AppMethodBeat.o(84968);
    }

    public final void setTextZoom(int i) {
        AppMethodBeat.i(84969);
        this.AQT.getSettings().setTextZoom(i);
        AppMethodBeat.o(84969);
    }

    public final synchronized void a(a aVar) {
        AppMethodBeat.i(84970);
        this.AQT.getSettings().setTextSize(TextSize.valueOf(aVar.name()));
        AppMethodBeat.o(84970);
    }

    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(84971);
        this.AQT.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(84971);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(84972);
        this.AQT.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.o(84972);
    }

    public final void dUd() {
        AppMethodBeat.i(84973);
        this.AQT.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(84973);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(84974);
        this.AQT.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(84974);
    }

    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(84975);
        this.AQT.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(84975);
    }

    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(84976);
        boolean blockNetworkImage = this.AQT.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(84976);
        return blockNetworkImage;
    }

    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(84977);
        this.AQT.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(84977);
    }

    public final void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(84978);
        this.AQT.getSettings().setPluginsEnabled(z);
        AppMethodBeat.o(84978);
    }

    public final void setDatabasePath(String str) {
        AppMethodBeat.i(84979);
        this.AQT.getSettings().setDatabasePath(str);
        AppMethodBeat.o(84979);
    }

    public final void dUe() {
        AppMethodBeat.i(84980);
        this.AQT.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(84980);
    }

    public final void setAppCachePath(String str) {
        AppMethodBeat.i(84981);
        this.AQT.getSettings().setAppCachePath(str);
        AppMethodBeat.o(84981);
    }

    public final void dUf() {
        AppMethodBeat.i(84982);
        this.AQT.getSettings().setAppCacheMaxSize(10485760);
        AppMethodBeat.o(84982);
    }

    public final void dUg() {
        AppMethodBeat.i(84983);
        this.AQT.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(84983);
    }

    public final void dUh() {
        AppMethodBeat.i(84984);
        this.AQT.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(84984);
    }

    public final void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(84985);
        this.AQT.getSettings().setGeolocationEnabled(z);
        AppMethodBeat.o(84985);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(84986);
        this.AQT.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(84986);
    }

    public final void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(84987);
        this.AQT.getSettings().setDefaultTextEncodingName(str);
        AppMethodBeat.o(84987);
    }

    public final void setUserAgentString(String str) {
        AppMethodBeat.i(84988);
        this.AQT.getSettings().setUserAgentString(str);
        AppMethodBeat.o(84988);
    }

    public final String getUserAgentString() {
        AppMethodBeat.i(84989);
        String userAgentString = this.AQT.getSettings().getUserAgentString();
        AppMethodBeat.o(84989);
        return userAgentString;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.i(84990);
        this.AQT.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
        AppMethodBeat.o(84990);
    }

    public final void dUi() {
        AppMethodBeat.i(84991);
        this.AQT.getSettings().setCacheMode(-1);
        AppMethodBeat.o(84991);
    }

    public final void dUj() {
        AppMethodBeat.i(84992);
        this.AQT.getSettings().setMixedContentMode(0);
        AppMethodBeat.o(84992);
    }

    public final void setUsingForAppBrand(int i) {
        AppMethodBeat.i(84993);
        this.AQU = i;
        if (this.AQT.getX5WebViewExtension() == null) {
            AppMethodBeat.o(84993);
            return;
        }
        Bundle bundle;
        switch (this.AQU) {
            case 1:
                bundle = new Bundle(1);
                bundle.putInt("flag", 1);
                this.AQT.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle);
                try {
                    org.a.a.ep(this.AQT.getX5WebViewExtension()).u("setEnableAutoPageDiscarding", Boolean.FALSE);
                    org.a.a.ep(this.AQT.getX5WebViewExtension()).u("setEnableAutoPageRestoration", Boolean.FALSE);
                    AppMethodBeat.o(84993);
                    return;
                } catch (Exception e) {
                    Log.e("XWEB.X5WebViewSettings", "DisableAutoPageDiscarding error ".concat(String.valueOf(e)));
                    AppMethodBeat.o(84993);
                    return;
                }
            case 2:
                bundle = new Bundle(1);
                bundle.putInt("flag", 2);
                this.AQT.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle);
                break;
        }
        AppMethodBeat.o(84993);
    }
}
