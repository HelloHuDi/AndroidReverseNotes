package org.xwalk.core;

public interface XWalkJavascriptResult {
    void cancel();

    void confirm();

    void confirmWithResult(String str);
}
