package com.tencent.soter.p663a.p1106b;

import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C44478f;

/* renamed from: com.tencent.soter.a.b.e */
public abstract class C46744e<T> extends C44478f {
    public T AvM;

    C46744e() {
        super(-1);
        this.AvM = null;
    }

    protected C46744e(int i, String str) {
        this(i, str, null);
    }

    protected C46744e(int i, String str, T t) {
        super(i, str);
        this.AvM = null;
        switch (i) {
            case 8:
                this.aIm = "get support soter failed remotely";
                break;
            case 9:
                this.aIm = "upload app secure key";
                break;
            case 10:
                this.aIm = "upload auth key failed";
                break;
            case 14:
                this.aIm = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
                break;
            case 17:
                this.aIm = "context instance already released. should not happen normally, you can try to call again";
                break;
            case 18:
                this.aIm = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
                break;
            case 19:
                this.aIm = "get challenge failed";
                break;
            case 23:
                this.aIm = "upload or verify signature in server side failed";
                break;
        }
        if (!C24321g.isNullOrNil(str)) {
            this.aIm = str;
        }
        this.AvM = t;
    }

    protected C46744e(int i) {
        this(i, "", null);
    }

    protected C46744e(T t) {
        this(0, "", t);
    }

    public String toString() {
        if (this.AvM == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", new Object[]{super.toString(), this.AvM.toString()});
    }
}
