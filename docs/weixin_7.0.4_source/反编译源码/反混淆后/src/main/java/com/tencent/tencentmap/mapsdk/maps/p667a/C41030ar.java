package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ar */
public final class C41030ar {
    /* renamed from: a */
    public String f16429a;
    /* renamed from: b */
    public boolean f16430b;
    /* renamed from: c */
    public long f16431c;
    /* renamed from: d */
    public long f16432d;
    /* renamed from: e */
    public Map<String, String> f16433e;
    /* renamed from: f */
    boolean f16434f;

    public C41030ar(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.m2504i(98501);
        this.f16429a = str;
        this.f16430b = z;
        this.f16431c = j;
        this.f16432d = j2;
        if (map != null) {
            this.f16433e = new HashMap();
            this.f16433e.putAll(map);
        }
        this.f16434f = z2;
        AppMethodBeat.m2505o(98501);
    }
}
