package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C36589p;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

/* renamed from: com.tencent.xweb.xwalk.k */
public final class C24569k extends C36589p {
    XWalkView ASC;

    public C24569k(XWalkView xWalkView) {
        this.ASC = xWalkView;
    }

    public final void setSupportZoom(boolean z) {
        AppMethodBeat.m2504i(85347);
        this.ASC.getSettings().setSupportZoom(z);
        AppMethodBeat.m2505o(85347);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.m2504i(85348);
        this.ASC.getSettings().setMediaPlaybackRequiresUserGesture(z);
        AppMethodBeat.m2505o(85348);
    }

    public final void setUsingForAppBrand(int i) {
        AppMethodBeat.m2504i(85349);
        this.ASC.getSettings().setUsingForAppBrand(i);
        AppMethodBeat.m2505o(85349);
    }

    public final void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.m2504i(85350);
        this.ASC.getSettings().setBuiltInZoomControls(z);
        AppMethodBeat.m2505o(85350);
    }

    public final void dUa() {
    }

    public final void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.m2504i(85351);
        this.ASC.getSettings().setLoadWithOverviewMode(z);
        AppMethodBeat.m2505o(85351);
    }

    public final void dUb() {
        AppMethodBeat.m2504i(85352);
        this.ASC.getSettings().setSaveFormData(false);
        AppMethodBeat.m2505o(85352);
    }

    public final void dUc() {
    }

    public final void setTextZoom(int i) {
        AppMethodBeat.m2504i(85353);
        this.ASC.getSettings().setTextZoom(i);
        AppMethodBeat.m2505o(85353);
    }

    public final void setUseWideViewPort(boolean z) {
        AppMethodBeat.m2504i(85354);
        this.ASC.getSettings().setUseWideViewPort(z);
        AppMethodBeat.m2505o(85354);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.m2504i(85355);
        this.ASC.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
        AppMethodBeat.m2505o(85355);
    }

    public final void dUd() {
        AppMethodBeat.m2504i(85356);
        this.ASC.getSettings().setDefaultFontSize(8);
        AppMethodBeat.m2505o(85356);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.m2504i(85357);
        this.ASC.getSettings().setLoadsImagesAutomatically(z);
        AppMethodBeat.m2505o(85357);
    }

    public final void setBlockNetworkImage(boolean z) {
        AppMethodBeat.m2504i(85358);
        this.ASC.getSettings().setBlockNetworkImage(z);
        AppMethodBeat.m2505o(85358);
    }

    public final boolean getBlockNetworkImage() {
        AppMethodBeat.m2504i(85359);
        boolean blockNetworkImage = this.ASC.getSettings().getBlockNetworkImage();
        AppMethodBeat.m2505o(85359);
        return blockNetworkImage;
    }

    public final void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.m2504i(85360);
        this.ASC.getSettings().setJavaScriptEnabled(z);
        AppMethodBeat.m2505o(85360);
    }

    public final void setPluginsEnabled(boolean z) {
    }

    public final void setDatabasePath(String str) {
    }

    public final void dUe() {
        AppMethodBeat.m2504i(85361);
        this.ASC.getSettings().setAppCacheEnabled(true);
        AppMethodBeat.m2505o(85361);
    }

    public final void setAppCachePath(String str) {
        AppMethodBeat.m2504i(85362);
        this.ASC.getSettings().setAppCachePath(str);
        AppMethodBeat.m2505o(85362);
    }

    public final void dUf() {
    }

    public final void dUg() {
        AppMethodBeat.m2504i(85363);
        this.ASC.getSettings().setDatabaseEnabled(true);
        AppMethodBeat.m2505o(85363);
    }

    public final void dUh() {
        AppMethodBeat.m2504i(85364);
        this.ASC.getSettings().setDomStorageEnabled(true);
        AppMethodBeat.m2505o(85364);
    }

    public final void setGeolocationEnabled(boolean z) {
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.m2504i(85365);
        this.ASC.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        AppMethodBeat.m2505o(85365);
    }

    public final void setDefaultTextEncodingName(String str) {
    }

    public final void setUserAgentString(String str) {
        AppMethodBeat.m2504i(85366);
        this.ASC.getSettings().setUserAgentString(str);
        AppMethodBeat.m2505o(85366);
    }

    public final String getUserAgentString() {
        AppMethodBeat.m2504i(85367);
        String userAgentString = this.ASC.getUserAgentString();
        AppMethodBeat.m2505o(85367);
        return userAgentString;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
    }

    public final void dUi() {
        AppMethodBeat.m2504i(85368);
        this.ASC.getSettings().setCacheMode(-1);
        AppMethodBeat.m2505o(85368);
    }

    public final void dUj() {
    }
}
