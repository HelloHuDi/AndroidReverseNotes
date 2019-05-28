package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.h.i;

public interface aj extends i, ar {
    void H(Runnable runnable);

    void aAM();

    boolean aAN();

    boolean aAO();

    boolean aAP();

    void bU(String str, String str2);

    void cE(Context context);

    void destroy();

    int getContentHeight();

    View getContentView();

    int getHeight();

    String getUserAgentString();

    int getWebScrollX();

    int getWebScrollY();

    int getWidth();

    View getWrapperView();

    void setFullscreenImpl(c cVar);

    void setOnScrollChangedListener(af afVar);

    void setOnTrimListener(ae aeVar);

    void setTitle(String str);

    void setVerticalScrollBarEnabled(boolean z);

    void setWebViewLayoutListener(ad adVar);

    void wU();

    void wW();

    void z(int i, long j);
}
