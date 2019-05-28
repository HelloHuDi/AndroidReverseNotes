package com.tencent.xweb;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.xweb.p */
public abstract class C36589p {

    /* renamed from: com.tencent.xweb.p$a */
    public enum C6033a {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        int value;

        static {
            AppMethodBeat.m2505o(3836);
        }

        private C6033a(int i) {
            this.value = i;
        }
    }

    public abstract void dUa();

    public abstract void dUb();

    @Deprecated
    public abstract void dUc();

    public abstract void dUd();

    public abstract void dUe();

    @Deprecated
    public abstract void dUf();

    public abstract void dUg();

    public abstract void dUh();

    public abstract void dUi();

    public abstract void dUj();

    public abstract boolean getBlockNetworkImage();

    public abstract String getUserAgentString();

    public abstract void setAppCachePath(String str);

    public abstract void setBlockNetworkImage(boolean z);

    public abstract void setBuiltInZoomControls(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultTextEncodingName(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setPluginsEnabled(boolean z);

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public abstract void setSupportZoom(boolean z);

    public abstract void setTextZoom(int i);

    public abstract void setUseWideViewPort(boolean z);

    public abstract void setUserAgentString(String str);

    public abstract void setUsingForAppBrand(int i);

    /* renamed from: a */
    public synchronized void mo58389a(C6033a c6033a) {
        setTextZoom(c6033a.value);
    }
}
