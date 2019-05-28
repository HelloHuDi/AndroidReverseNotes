package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.f */
public final class C36501f extends C46803m {
    /* renamed from: k */
    static byte[] f15329k = null;
    /* renamed from: l */
    static Map<String, String> f15330l = null;
    /* renamed from: m */
    static final /* synthetic */ boolean f15331m;
    /* renamed from: a */
    public short f15332a = (short) 0;
    /* renamed from: b */
    public byte f15333b = (byte) 0;
    /* renamed from: c */
    public int f15334c = 0;
    /* renamed from: d */
    public int f15335d = 0;
    /* renamed from: e */
    public String f15336e = null;
    /* renamed from: f */
    public String f15337f = null;
    /* renamed from: g */
    public byte[] f15338g;
    /* renamed from: h */
    public int f15339h = 0;
    /* renamed from: i */
    public Map<String, String> f15340i;
    /* renamed from: j */
    public Map<String, String> f15341j;

    static {
        boolean z;
        AppMethodBeat.m2504i(98857);
        if (C36501f.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f15331m = z;
        AppMethodBeat.m2505o(98857);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(98852);
        C36501f c36501f = (C36501f) obj;
        if (C41080n.m71482a(1, c36501f.f15332a) && C41080n.m71482a(1, c36501f.f15333b) && C41080n.m71482a(1, c36501f.f15334c) && C41080n.m71482a(1, c36501f.f15335d) && C41080n.m71483a(Integer.valueOf(1), c36501f.f15336e) && C41080n.m71483a(Integer.valueOf(1), c36501f.f15337f) && C41080n.m71483a(Integer.valueOf(1), c36501f.f15338g) && C41080n.m71482a(1, c36501f.f15339h) && C41080n.m71483a(Integer.valueOf(1), c36501f.f15340i) && C41080n.m71483a(Integer.valueOf(1), c36501f.f15341j)) {
            AppMethodBeat.m2505o(98852);
            return true;
        }
        AppMethodBeat.m2505o(98852);
        return false;
    }

    public final Object clone() {
        AppMethodBeat.m2504i(98853);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!f15331m) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(98853);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(98853);
        return obj;
    }

    public final void writeTo(C24398l c24398l) {
        AppMethodBeat.m2504i(98854);
        c24398l.mo40675a(this.f15332a, 1);
        c24398l.mo40684b(this.f15333b, 2);
        c24398l.mo40668a(this.f15334c, 3);
        c24398l.mo40668a(this.f15335d, 4);
        c24398l.mo40672a(this.f15336e, 5);
        c24398l.mo40672a(this.f15337f, 6);
        c24398l.mo40677a(this.f15338g, 7);
        c24398l.mo40668a(this.f15339h, 8);
        c24398l.mo40674a(this.f15340i, 9);
        c24398l.mo40674a(this.f15341j, 10);
        AppMethodBeat.m2505o(98854);
    }

    public final void readFrom(C31070k c31070k) {
        AppMethodBeat.m2504i(98855);
        try {
            HashMap hashMap;
            this.f15332a = c31070k.mo50511a(this.f15332a, 1, true);
            this.f15333b = c31070k.mo50500a(this.f15333b, 2, true);
            this.f15334c = c31070k.mo50503a(this.f15334c, 3, true);
            this.f15335d = c31070k.mo50503a(this.f15335d, 4, true);
            this.f15336e = c31070k.mo50508a(5, true);
            this.f15337f = c31070k.mo50508a(6, true);
            if (f15329k == null) {
                f15329k = new byte[]{(byte) 0};
            }
            this.f15338g = c31070k.mo50517a(f15329k, 7, true);
            this.f15339h = c31070k.mo50503a(this.f15339h, 8, true);
            if (f15330l == null) {
                hashMap = new HashMap();
                f15330l = hashMap;
                hashMap.put("", "");
            }
            this.f15340i = (Map) c31070k.mo50507a(f15330l, 9, true);
            if (f15330l == null) {
                hashMap = new HashMap();
                f15330l = hashMap;
                hashMap.put("", "");
            }
            this.f15341j = (Map) c31070k.mo50507a(f15330l, 10, true);
            AppMethodBeat.m2505o(98855);
        } catch (Exception e) {
            System.out.println("RequestPacket decode error " + C36511g.m60418a(this.f15338g));
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(98855);
            throw runtimeException;
        }
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(98856);
        C16278i c16278i = new C16278i(stringBuilder, i);
        c16278i.mo29483a(this.f15332a, "iVersion");
        c16278i.mo29462a(this.f15333b, "cPacketType");
        c16278i.mo29469a(this.f15334c, "iMessageType");
        c16278i.mo29469a(this.f15335d, "iRequestId");
        c16278i.mo29477a(this.f15336e, "sServantName");
        c16278i.mo29477a(this.f15337f, "sFuncName");
        c16278i.mo29487a(this.f15338g, "sBuffer");
        c16278i.mo29469a(this.f15339h, "iTimeout");
        c16278i.mo29481a(this.f15340i, "context");
        c16278i.mo29481a(this.f15341j, "status");
        AppMethodBeat.m2505o(98856);
    }
}
