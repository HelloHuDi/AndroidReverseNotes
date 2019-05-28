package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.p685x5.sdk.C24544d.C24545a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.xweb.x5.sdk.a */
public interface C44593a {
    /* renamed from: a */
    void mo41293a(Context context, C24545a c24545a);

    /* renamed from: a */
    void mo41294a(Context context, String str, ValueCallback<Boolean> valueCallback);

    /* renamed from: a */
    void mo41295a(C46837h c46837h);

    /* renamed from: a */
    boolean mo41296a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);

    boolean canOpenWebPlus(Context context);

    void closeFileReader(Context context);

    void forceSysWebView();

    boolean getTBSInstalling();

    int getTbsVersion(Context context);

    void initTbsSettings(Map<String, Object> map);

    boolean isTbsCoreInited();

    void reset(Context context);

    void setUploadCode(Context context, int i);

    int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback);
}
