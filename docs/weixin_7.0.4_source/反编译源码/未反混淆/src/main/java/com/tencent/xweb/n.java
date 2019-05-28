package com.tencent.xweb;

import android.net.Uri;
import java.util.Map;

public interface n {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();
}
