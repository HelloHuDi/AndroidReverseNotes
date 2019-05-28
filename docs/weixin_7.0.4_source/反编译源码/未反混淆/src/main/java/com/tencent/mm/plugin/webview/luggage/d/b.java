package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b implements WebResourceRequest {
    private String bOr;
    private boolean mIsRedirect = false;
    private Uri mUri;
    private boolean ulB;
    private boolean ulC;
    private Map<String, String> ulD;

    public b(Uri uri, boolean z, boolean z2, String str, Map<String, String> map) {
        this.mUri = uri;
        this.ulB = z;
        this.ulC = z2;
        this.bOr = str;
        this.ulD = map;
    }

    public final Uri getUrl() {
        return this.mUri;
    }

    public final boolean isForMainFrame() {
        return this.ulB;
    }

    public final boolean isRedirect() {
        return this.mIsRedirect;
    }

    public final boolean hasGesture() {
        return this.ulC;
    }

    public final String getMethod() {
        return this.bOr;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.ulD;
    }
}
