package org.xwalk.core;

import java.util.List;

public abstract class WebViewExtensionListener {
    public abstract int getHostByName(String str, List<String> list);

    public abstract Object onMiscCallBack(String str, Object... objArr);
}
