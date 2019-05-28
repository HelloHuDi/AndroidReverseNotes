package com.tencent.p124c.p125a.p126a;

import android.content.Context;

/* renamed from: com.tencent.c.a.a.q */
public abstract class C25595q {
    protected Context context = null;

    /* renamed from: a */
    public abstract void mo19816a(C25593a c25593a);

    public abstract String read();

    public abstract void write(String str);

    /* renamed from: zO */
    public abstract boolean mo19819zO();

    /* renamed from: zP */
    public abstract C25593a mo19820zP();

    protected C25595q(Context context) {
        this.context = context;
    }

    /* renamed from: zV */
    public final C37314g mo43323zV() {
        String decode;
        if (mo19819zO()) {
            decode = C0916s.decode(read());
        } else {
            decode = null;
        }
        if (decode != null) {
            return C37314g.m62714cn(decode);
        }
        return null;
    }

    /* renamed from: b */
    public final void mo43322b(C37314g c37314g) {
        if (c37314g != null) {
            String c37314g2 = c37314g.toString();
            if (mo19819zO()) {
                write(C0916s.encode(c37314g2));
            }
        }
    }

    /* renamed from: zW */
    public final C25593a mo43324zW() {
        if (mo19819zO()) {
            return mo19820zP();
        }
        return null;
    }

    /* renamed from: b */
    public final void mo43321b(C25593a c25593a) {
        if (c25593a != null && mo19819zO()) {
            mo19816a(c25593a);
        }
    }
}
