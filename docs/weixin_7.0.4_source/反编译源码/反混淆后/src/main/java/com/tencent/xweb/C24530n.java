package com.tencent.xweb;

import android.net.Uri;
import java.util.Map;

/* renamed from: com.tencent.xweb.n */
public interface C24530n {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();
}
