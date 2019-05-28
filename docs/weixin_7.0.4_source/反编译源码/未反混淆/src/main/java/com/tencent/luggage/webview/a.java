package com.tencent.luggage.webview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.bridge.s;
import com.tencent.luggage.d.k;
import java.util.Map;

public interface a extends s {

    public interface a {
        WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle);

        boolean bD(String str);

        void bE(String str);

        void bF(String str);

        WebResourceResponse bG(String str);

        String bH(String str);

        void bI(String str);
    }

    void a(a aVar);

    boolean canGoBack();

    void destroy();

    View getView();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    void setContext(Context context);

    void setWebCore(k kVar);

    void stopLoading();
}
