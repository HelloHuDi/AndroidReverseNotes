package com.tencent.mm.z.b;

import android.webkit.ValueCallback;

public interface d {
    void cleanup();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void pause();

    void resume();
}
