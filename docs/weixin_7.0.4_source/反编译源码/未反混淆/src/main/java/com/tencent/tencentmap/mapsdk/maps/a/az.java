package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.a.c;
import com.tencent.tencentmap.mapsdk.a.e;

public abstract class az {
    protected final int a;
    protected final int b;
    protected Context c;
    protected String d;

    public abstract aa a();

    public abstract void b(boolean z);

    public az(Context context, int i, int i2) {
        this.c = context;
        this.a = i2;
        this.b = i;
    }

    public final int c() {
        return this.a;
    }

    public final synchronized String d() {
        return this.d;
    }

    public final String e() {
        try {
            if (this.b == 0) {
                return t.a(this.c).e().b();
            }
            return t.a(this.c).e().b(this.b).b();
        } catch (Throwable th) {
            ag.c("imposiable comStrategy error:%s", th.toString());
            ag.a(th);
            return null;
        }
    }

    public static aa a(int i, byte[] bArr) {
        try {
            return e.a(i, c.m(), bArr, 2, 3);
        } catch (Throwable th) {
            ag.c("imposiable comStrategy error:%s", th.toString());
            ag.a(th);
            return null;
        }
    }

    public void b() {
        ag.c("encode failed, clear db data", new Object[0]);
    }
}
