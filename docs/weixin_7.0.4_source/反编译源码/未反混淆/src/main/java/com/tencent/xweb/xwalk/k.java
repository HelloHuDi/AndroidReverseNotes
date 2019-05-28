package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class k extends p {
    XWalkView ASC;

    public k(XWalkView xWalkView) {
        this.ASC = xWalkView;
    }

    public final void setSupportZoom(boolean z) {
        AppMethodBeat.i(85347);
        this.ASC.getSettings().setSupportZoom(z);
        AppMethodBeat.o(85347);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(85348);
        this.ASC.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.o(85348);
    }

    public final void setUsingForAppBrand(int i) {
        AppMethodBeat.i(85349);
        this.ASC.getSettings().setUsingForAppBrand(i);
        AppMethodBeat.o(85349);
    }

    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(85350);
        this.ASC.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.o(85350);
    }

    public final void dUa() {
    }

    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(85351);
        this.ASC.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.o(85351);
    }

    public final void dUb() {
        AppMethodBeat.i(85352);
        this.ASC.getSettings().setSaveFormData(false);
        AppMethodBeat.o(85352);
    }

    public final void dUc() {
    }

    public final void setTextZoom(int i) {
        AppMethodBeat.i(85353);
        this.ASC.getSettings().setTextZoom(i);
        AppMethodBeat.o(85353);
    }

    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(85354);
        this.ASC.getSettings().setUseWideViewPort(z);
        AppMethodBeat.o(85354);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(85355);
        this.ASC.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.o(85355);
    }

    public final void dUd() {
        AppMethodBeat.i(85356);
        this.ASC.getSettings().setDefaultFontSize(8);
        AppMethodBeat.o(85356);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(85357);
        this.ASC.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.o(85357);
    }

    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(85358);
        this.ASC.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.o(85358);
    }

    public final boolean getBlockNetworkImage() {
        AppMethodBeat.i(85359);
        boolean blockNetworkImage = this.ASC.getSettings().getBlockNetworkImage();
        AppMethodBeat.o(85359);
        return blockNetworkImage;
    }

    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(85360);
        this.ASC.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.o(85360);
    }

    public final void setPluginsEnabled(boolean z) {
    }

    public final void setDatabasePath(String str) {
    }

    public final void dUe() {
        AppMethodBeat.i(85361);
        this.ASC.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.o(85361);
    }

    public final void setAppCachePath(String str) {
        AppMethodBeat.i(85362);
        this.ASC.getSettings().setAppCachePath(str);
        AppMethodBeat.o(85362);
    }

    public final void dUf() {
    }

    public final void dUg() {
        AppMethodBeat.i(85363);
        this.ASC.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.o(85363);
    }

    public final void dUh() {
        AppMethodBeat.i(85364);
        this.ASC.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.o(85364);
    }

    public final void setGeolocationEnabled(boolean z) {
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(85365);
        this.ASC.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.o(85365);
    }

    public final void setDefaultTextEncodingName(String str) {
    }

    public final void setUserAgentString(String str) {
        AppMethodBeat.i(85366);
        this.ASC.getSettings().setUserAgentString(str);
        AppMethodBeat.o(85366);
    }

    public final String getUserAgentString() {
        AppMethodBeat.i(85367);
        String userAgentString = this.ASC.getUserAgentString();
        AppMethodBeat.o(85367);
        return userAgentString;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
    }

    public final void dUi() {
        AppMethodBeat.i(85368);
        this.ASC.getSettings().setCacheMode(-1);
        AppMethodBeat.o(85368);
    }

    public final void dUj() {
    }
}
