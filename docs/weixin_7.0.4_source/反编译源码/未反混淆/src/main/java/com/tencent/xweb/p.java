package com.tencent.xweb;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class p {

    public enum a {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        int value;

        static {
            AppMethodBeat.o(3836);
        }

        private a(int i) {
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

    public synchronized void a(a aVar) {
        setTextZoom(aVar.value);
    }
}
