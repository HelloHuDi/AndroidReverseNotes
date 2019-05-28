package com.tencent.luggage.webview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.C25684s;
import com.tencent.luggage.p146d.C32186k;
import java.util.Map;

/* renamed from: com.tencent.luggage.webview.a */
public interface C37407a extends C25684s {

    /* renamed from: com.tencent.luggage.webview.a$a */
    public interface C32193a {
        /* renamed from: a */
        WebResourceResponse mo52838a(WebResourceRequest webResourceRequest, Bundle bundle);

        /* renamed from: bD */
        boolean mo52839bD(String str);

        /* renamed from: bE */
        void mo52840bE(String str);

        /* renamed from: bF */
        void mo52841bF(String str);

        /* renamed from: bG */
        WebResourceResponse mo52842bG(String str);

        /* renamed from: bH */
        String mo52843bH(String str);

        /* renamed from: bI */
        void mo52844bI(String str);
    }

    /* renamed from: a */
    void mo7543a(C32193a c32193a);

    boolean canGoBack();

    void destroy();

    View getView();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void setContext(Context context);

    void setWebCore(C32186k c32186k);

    void stopLoading();
}
