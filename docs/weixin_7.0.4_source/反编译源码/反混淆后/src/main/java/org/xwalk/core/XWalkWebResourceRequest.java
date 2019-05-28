package org.xwalk.core;

import android.net.Uri;
import java.util.Map;

public interface XWalkWebResourceRequest {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();
}
