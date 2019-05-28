package org.xwalk.core;

public interface XWalkHttpAuth {
    void cancel();

    boolean isFirstAttempt();

    void proceed(String str, String str2);
}
