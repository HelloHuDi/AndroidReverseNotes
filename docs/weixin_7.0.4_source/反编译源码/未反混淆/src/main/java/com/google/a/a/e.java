package com.google.a.a;

import java.io.IOException;

public abstract class e {
    protected volatile int bxt = -1;

    public abstract e a(a aVar);

    public final int vp() {
        if (this.bxt < 0) {
            vq();
        }
        return this.bxt;
    }

    public final int vq() {
        int vr = vr();
        this.bxt = vr;
        return vr;
    }

    /* Access modifiers changed, original: protected */
    public int vr() {
        return 0;
    }

    public void a(b bVar) {
    }

    public static final byte[] b(e eVar) {
        byte[] bArr = new byte[eVar.vq()];
        try {
            b bVar = new b(bArr, bArr.length);
            eVar.a(bVar);
            if (bVar.limit - bVar.position == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return f.c(this);
    }

    public static <T extends e> T a(T t, byte[] bArr, int i) {
        try {
            a aVar = new a(bArr, i);
            t.a(aVar);
            aVar.fm(0);
            return t;
        } catch (d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
}
