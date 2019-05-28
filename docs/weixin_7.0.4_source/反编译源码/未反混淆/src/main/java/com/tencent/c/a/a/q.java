package com.tencent.c.a.a;

import android.content.Context;

public abstract class q {
    protected Context context = null;

    public abstract void a(a aVar);

    public abstract String read();

    public abstract void write(String str);

    public abstract boolean zO();

    public abstract a zP();

    protected q(Context context) {
        this.context = context;
    }

    public final g zV() {
        String decode;
        if (zO()) {
            decode = s.decode(read());
        } else {
            decode = null;
        }
        if (decode != null) {
            return g.cn(decode);
        }
        return null;
    }

    public final void b(g gVar) {
        if (gVar != null) {
            String gVar2 = gVar.toString();
            if (zO()) {
                write(s.encode(gVar2));
            }
        }
    }

    public final a zW() {
        if (zO()) {
            return zP();
        }
        return null;
    }

    public final void b(a aVar) {
        if (aVar != null && zO()) {
            a(aVar);
        }
    }
}
