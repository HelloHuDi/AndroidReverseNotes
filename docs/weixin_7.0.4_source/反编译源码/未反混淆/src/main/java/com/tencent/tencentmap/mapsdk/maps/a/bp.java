package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class bp implements bl {
    public String a;
    public byte[] b;
    public Map<String, String> c;
    public boolean d = false;
    public boolean e = true;
    public int f = -1;
    public String g = "";
    public bj h;
    public ci i;
    public volatile boolean j = false;
    public int k = 0;
    public boolean l = true;
    public volatile boolean m = false;
    public long n;
    public String o;
    private Object p;
    private int q = 0;
    private cv r;
    private CountDownLatch s = new CountDownLatch(1);

    public bp(String str, byte[] bArr) {
        AppMethodBeat.i(98572);
        this.a = str;
        this.b = bArr;
        this.g = eu.d();
        AppMethodBeat.o(98572);
    }

    public final void a(int i) {
        this.f = i;
    }

    public final synchronized void a(cv cvVar) {
        this.r = cvVar;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98573);
        if (this.c == null) {
            this.c = new HashMap();
        }
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            this.c.put(str, str2);
        }
        AppMethodBeat.o(98573);
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final boolean a() {
        AppMethodBeat.i(98570);
        try {
            boolean await = this.s.await((long) this.k, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(98570);
            return await;
        } catch (InterruptedException e) {
            AppMethodBeat.o(98570);
            return true;
        }
    }

    public final void b() {
        AppMethodBeat.i(98571);
        this.s.countDown();
        AppMethodBeat.o(98571);
    }

    public final void b(int i) {
        if (i >= 0) {
            this.k = i;
        }
    }

    public final void b(boolean z) {
        this.l = z;
    }

    public final synchronized cv c() {
        return this.r;
    }

    public final String toString() {
        AppMethodBeat.i(98574);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url:" + this.a);
        stringBuilder.append(",body:" + eu.b(this.b));
        stringBuilder.append(",isGet:" + this.d);
        stringBuilder.append(",timeout:" + this.f);
        stringBuilder.append(",tag:" + this.p);
        stringBuilder.append(",httpCallback:" + this.h);
        stringBuilder.append(",testMode:" + this.q);
        stringBuilder.append(",httpCallback:" + this.h);
        stringBuilder.append(",testMode:" + this.q);
        stringBuilder.append(",followRedirects:" + this.e);
        stringBuilder.append(",isAbort:" + this.j);
        stringBuilder.append(",headers:" + this.c);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(98574);
        return stringBuilder2;
    }
}
