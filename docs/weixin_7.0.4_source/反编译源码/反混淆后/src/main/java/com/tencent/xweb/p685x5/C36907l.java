package com.tencent.xweb.p685x5;

import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36589p.C6033a;
import org.p1430a.C41166a;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.l */
public final class C36907l extends C36589p {
    WebView AQT;
    private int AQU = 0;

    public C36907l(WebView webView) {
        this.AQT = webView;
    }

    public final void setSupportZoom(boolean z) {
        AppMethodBeat.m2504i(84962);
        this.AQT.getSettings().setSupportZoom(z);
        AppMethodBeat.m2505o(84962);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.m2504i(84963);
        this.AQT.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.m2505o(84963);
    }

    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.m2504i(84964);
        this.AQT.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.m2505o(84964);
    }

    public final void dUa() {
        AppMethodBeat.m2504i(84965);
        this.AQT.getSettings().setDisplayZoomControls(false);
        AppMethodBeat.m2505o(84965);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.m2504i(84966);
        this.AQT.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.m2505o(84966);
    }

    public final void dUb() {
        AppMethodBeat.m2504i(84967);
        this.AQT.getSettings().setSaveFormData(false);
        AppMethodBeat.m2505o(84967);
    }

    public final void dUc() {
        AppMethodBeat.m2504i(84968);
        this.AQT.getSettings().setSavePassword(false);
        AppMethodBeat.m2505o(84968);
    }

    public final void setTextZoom(int i) {
        AppMethodBeat.m2504i(84969);
        this.AQT.getSettings().setTextZoom(i);
        AppMethodBeat.m2505o(84969);
    }

    /* renamed from: a */
    public final synchronized void mo58389a(C6033a c6033a) {
        AppMethodBeat.m2504i(84970);
        this.AQT.getSettings().setTextSize(TextSize.valueOf(c6033a.name()));
        AppMethodBeat.m2505o(84970);
    }

    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.m2504i(84971);
        this.AQT.getSettings().setUseWideViewPort(z);
        AppMethodBeat.m2505o(84971);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.m2504i(84972);
        this.AQT.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.m2505o(84972);
    }

    public final void dUd() {
        AppMethodBeat.m2504i(84973);
        this.AQT.getSettings().setDefaultFontSize(8);
        AppMethodBeat.m2505o(84973);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.m2504i(84974);
        this.AQT.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.m2505o(84974);
    }

    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.m2504i(84975);
        this.AQT.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.m2505o(84975);
    }

    public final boolean getBlockNetworkImage() {
        AppMethodBeat.m2504i(84976);
        boolean blockNetworkImage = this.AQT.getSettings().getBlockNetworkImage();
        AppMethodBeat.m2505o(84976);
        return blockNetworkImage;
    }

    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.m2504i(84977);
        this.AQT.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.m2505o(84977);
    }

    public final void setPluginsEnabled(boolean z) {
        AppMethodBeat.m2504i(84978);
        this.AQT.getSettings().setPluginsEnabled(z);
        AppMethodBeat.m2505o(84978);
    }

    public final void setDatabasePath(String str) {
        AppMethodBeat.m2504i(84979);
        this.AQT.getSettings().setDatabasePath(str);
        AppMethodBeat.m2505o(84979);
    }

    public final void dUe() {
        AppMethodBeat.m2504i(84980);
        this.AQT.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.m2505o(84980);
    }

    public final void setAppCachePath(String str) {
        AppMethodBeat.m2504i(84981);
        this.AQT.getSettings().setAppCachePath(str);
        AppMethodBeat.m2505o(84981);
    }

    public final void dUf() {
        AppMethodBeat.m2504i(84982);
        this.AQT.getSettings().setAppCacheMaxSize(10485760);
        AppMethodBeat.m2505o(84982);
    }

    public final void dUg() {
        AppMethodBeat.m2504i(84983);
        this.AQT.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.m2505o(84983);
    }

    public final void dUh() {
        AppMethodBeat.m2504i(84984);
        this.AQT.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.m2505o(84984);
    }

    public final void setGeolocationEnabled(boolean z) {
        AppMethodBeat.m2504i(84985);
        this.AQT.getSettings().setGeolocationEnabled(z);
        AppMethodBeat.m2505o(84985);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.m2504i(84986);
        this.AQT.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.m2505o(84986);
    }

    public final void setDefaultTextEncodingName(String str) {
        AppMethodBeat.m2504i(84987);
        this.AQT.getSettings().setDefaultTextEncodingName(str);
        AppMethodBeat.m2505o(84987);
    }

    public final void setUserAgentString(String str) {
        AppMethodBeat.m2504i(84988);
        this.AQT.getSettings().setUserAgentString(str);
        AppMethodBeat.m2505o(84988);
    }

    public final String getUserAgentString() {
        AppMethodBeat.m2504i(84989);
        String userAgentString = this.AQT.getSettings().getUserAgentString();
        AppMethodBeat.m2505o(84989);
        return userAgentString;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.m2504i(84990);
        this.AQT.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
        AppMethodBeat.m2505o(84990);
    }

    public final void dUi() {
        AppMethodBeat.m2504i(84991);
        this.AQT.getSettings().setCacheMode(-1);
        AppMethodBeat.m2505o(84991);
    }

    public final void dUj() {
        AppMethodBeat.m2504i(84992);
        this.AQT.getSettings().setMixedContentMode(0);
        AppMethodBeat.m2505o(84992);
    }

    public final void setUsingForAppBrand(int i) {
        AppMethodBeat.m2504i(84993);
        this.AQU = i;
        if (this.AQT.getX5WebViewExtension() == null) {
            AppMethodBeat.m2505o(84993);
            return;
        }
        Bundle bundle;
        switch (this.AQU) {
            case 1:
                bundle = new Bundle(1);
                bundle.putInt("flag", 1);
                this.AQT.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle);
                try {
                    C41166a.m71622ep(this.AQT.getX5WebViewExtension()).mo65761u("setEnableAutoPageDiscarding", Boolean.FALSE);
                    C41166a.m71622ep(this.AQT.getX5WebViewExtension()).mo65761u("setEnableAutoPageRestoration", Boolean.FALSE);
                    AppMethodBeat.m2505o(84993);
                    return;
                } catch (Exception e) {
                    Log.m81046e("XWEB.X5WebViewSettings", "DisableAutoPageDiscarding error ".concat(String.valueOf(e)));
                    AppMethodBeat.m2505o(84993);
                    return;
                }
            case 2:
                bundle = new Bundle(1);
                bundle.putInt("flag", 2);
                this.AQT.getX5WebViewExtension().invokeMiscMethod("setMiniProgramFlag", bundle);
                break;
        }
        AppMethodBeat.m2505o(84993);
    }
}
