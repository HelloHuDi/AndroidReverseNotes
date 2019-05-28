package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bp */
public final class C16211bp implements C36486bl {
    /* renamed from: a */
    public String f3149a;
    /* renamed from: b */
    public byte[] f3150b;
    /* renamed from: c */
    public Map<String, String> f3151c;
    /* renamed from: d */
    public boolean f3152d = false;
    /* renamed from: e */
    public boolean f3153e = true;
    /* renamed from: f */
    public int f3154f = -1;
    /* renamed from: g */
    public String f3155g = "";
    /* renamed from: h */
    public C5858bj f3156h;
    /* renamed from: i */
    public C44501ci f3157i;
    /* renamed from: j */
    public volatile boolean f3158j = false;
    /* renamed from: k */
    public int f3159k = 0;
    /* renamed from: l */
    public boolean f3160l = true;
    /* renamed from: m */
    public volatile boolean f3161m = false;
    /* renamed from: n */
    public long f3162n;
    /* renamed from: o */
    public String f3163o;
    /* renamed from: p */
    private Object f3164p;
    /* renamed from: q */
    private int f3165q = 0;
    /* renamed from: r */
    private C5862cv f3166r;
    /* renamed from: s */
    private CountDownLatch f3167s = new CountDownLatch(1);

    public C16211bp(String str, byte[] bArr) {
        AppMethodBeat.m2504i(98572);
        this.f3149a = str;
        this.f3150b = bArr;
        this.f3155g = C24373eu.m37745d();
        AppMethodBeat.m2505o(98572);
    }

    /* renamed from: a */
    public final void mo29252a(int i) {
        this.f3154f = i;
    }

    /* renamed from: a */
    public final synchronized void mo29253a(C5862cv c5862cv) {
        this.f3166r = c5862cv;
    }

    /* renamed from: a */
    public final void mo29254a(String str, String str2) {
        AppMethodBeat.m2504i(98573);
        if (this.f3151c == null) {
            this.f3151c = new HashMap();
        }
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            this.f3151c.put(str, str2);
        }
        AppMethodBeat.m2505o(98573);
    }

    /* renamed from: a */
    public final void mo29255a(boolean z) {
        this.f3152d = z;
    }

    /* renamed from: a */
    public final boolean mo29256a() {
        AppMethodBeat.m2504i(98570);
        try {
            boolean await = this.f3167s.await((long) this.f3159k, TimeUnit.MILLISECONDS);
            AppMethodBeat.m2505o(98570);
            return await;
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(98570);
            return true;
        }
    }

    /* renamed from: b */
    public final void mo29257b() {
        AppMethodBeat.m2504i(98571);
        this.f3167s.countDown();
        AppMethodBeat.m2505o(98571);
    }

    /* renamed from: b */
    public final void mo29258b(int i) {
        if (i >= 0) {
            this.f3159k = i;
        }
    }

    /* renamed from: b */
    public final void mo29259b(boolean z) {
        this.f3160l = z;
    }

    /* renamed from: c */
    public final synchronized C5862cv mo29260c() {
        return this.f3166r;
    }

    public final String toString() {
        AppMethodBeat.m2504i(98574);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url:" + this.f3149a);
        stringBuilder.append(",body:" + C24373eu.m37742b(this.f3150b));
        stringBuilder.append(",isGet:" + this.f3152d);
        stringBuilder.append(",timeout:" + this.f3154f);
        stringBuilder.append(",tag:" + this.f3164p);
        stringBuilder.append(",httpCallback:" + this.f3156h);
        stringBuilder.append(",testMode:" + this.f3165q);
        stringBuilder.append(",httpCallback:" + this.f3156h);
        stringBuilder.append(",testMode:" + this.f3165q);
        stringBuilder.append(",followRedirects:" + this.f3153e);
        stringBuilder.append(",isAbort:" + this.f3158j);
        stringBuilder.append(",headers:" + this.f3151c);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98574);
        return stringBuilder2;
    }
}
