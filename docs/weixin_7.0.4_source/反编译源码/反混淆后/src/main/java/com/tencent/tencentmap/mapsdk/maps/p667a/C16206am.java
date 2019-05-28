package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.am */
public final class C16206am extends C41029ak {
    /* renamed from: k */
    private static byte[] f3127k = null;
    /* renamed from: l */
    private static Map<String, String> f3128l = null;
    /* renamed from: a */
    public short f3129a = (short) 3;
    /* renamed from: b */
    public int f3130b = 0;
    /* renamed from: c */
    public String f3131c = null;
    /* renamed from: d */
    public String f3132d = null;
    /* renamed from: e */
    public byte[] f3133e;
    /* renamed from: f */
    private byte f3134f = (byte) 0;
    /* renamed from: g */
    private int f3135g = 0;
    /* renamed from: h */
    private int f3136h = 0;
    /* renamed from: i */
    private Map<String, String> f3137i;
    /* renamed from: j */
    private Map<String, String> f3138j;

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98472);
        c46767aj.mo75332a(this.f3129a, 1);
        c46767aj.mo75325a(this.f3134f, 2);
        c46767aj.mo75326a(this.f3135g, 3);
        c46767aj.mo75326a(this.f3130b, 4);
        c46767aj.mo75329a(this.f3131c, 5);
        c46767aj.mo75329a(this.f3132d, 6);
        c46767aj.mo75334a(this.f3133e, 7);
        c46767aj.mo75326a(this.f3136h, 8);
        c46767aj.mo75331a(this.f3137i, 9);
        c46767aj.mo75331a(this.f3138j, 10);
        AppMethodBeat.m2505o(98472);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98473);
        try {
            HashMap hashMap;
            this.f3129a = c41028ai.mo65107a(this.f3129a, 1, true);
            this.f3134f = c41028ai.mo65100a(this.f3134f, 2, true);
            this.f3135g = c41028ai.mo65101a(this.f3135g, 3, true);
            this.f3130b = c41028ai.mo65101a(this.f3130b, 4, true);
            this.f3131c = c41028ai.mo65105a(5, true);
            this.f3132d = c41028ai.mo65105a(6, true);
            if (f3127k == null) {
                f3127k = new byte[]{(byte) 0};
            }
            this.f3133e = c41028ai.mo65109b(7, true);
            this.f3136h = c41028ai.mo65101a(this.f3136h, 8, true);
            if (f3128l == null) {
                hashMap = new HashMap();
                f3128l = hashMap;
                hashMap.put("", "");
            }
            this.f3137i = (Map) c41028ai.mo65104a(f3128l, 9, true);
            if (f3128l == null) {
                hashMap = new HashMap();
                f3128l = hashMap;
                hashMap.put("", "");
            }
            this.f3138j = (Map) c41028ai.mo65104a(f3128l, 10, true);
            AppMethodBeat.m2505o(98473);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(98473);
            throw runtimeException;
        }
    }
}
