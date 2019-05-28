package com.tencent.qqmusic.mediaplayer;

public interface ILog {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void e(String str, String str2, Object... objArr);

    void e(String str, Throwable th);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th);

    void w(String str, String str2);
}
