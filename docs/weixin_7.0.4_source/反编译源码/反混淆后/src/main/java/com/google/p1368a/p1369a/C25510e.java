package com.google.p1368a.p1369a;

import java.io.IOException;

/* renamed from: com.google.a.a.e */
public abstract class C25510e {
    protected volatile int bxt = -1;

    /* renamed from: a */
    public abstract C25510e mo11877a(C37224a c37224a);

    /* renamed from: vp */
    public final int mo42768vp() {
        if (this.bxt < 0) {
            mo42769vq();
        }
        return this.bxt;
    }

    /* renamed from: vq */
    public final int mo42769vq() {
        int vr = mo11879vr();
        this.bxt = vr;
        return vr;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: vr */
    public int mo11879vr() {
        return 0;
    }

    /* renamed from: a */
    public void mo11878a(C25507b c25507b) {
    }

    /* renamed from: b */
    public static final byte[] m40293b(C25510e c25510e) {
        byte[] bArr = new byte[c25510e.mo42769vq()];
        try {
            C25507b c25507b = new C25507b(bArr, bArr.length);
            c25510e.mo11878a(c25507b);
            if (c25507b.limit - c25507b.position == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return C41590f.m72805c(this);
    }

    /* renamed from: a */
    public static <T extends C25510e> T m40292a(T t, byte[] bArr, int i) {
        try {
            C37224a c37224a = new C37224a(bArr, i);
            t.mo11877a(c37224a);
            c37224a.mo59445fm(0);
            return t;
        } catch (C25509d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
}
