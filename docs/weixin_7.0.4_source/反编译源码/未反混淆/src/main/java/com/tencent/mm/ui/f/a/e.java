package com.tencent.mm.ui.f.a;

public final class e extends Throwable {
    public int mErrorCode = 0;
    public String zxP;

    public e(String str) {
        super(str);
    }

    public e(String str, String str2, int i) {
        super(str);
        this.zxP = str2;
        this.mErrorCode = i;
    }
}
