package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.e */
public class C36893e extends C36496d {
    /* renamed from: h */
    static HashMap<String, byte[]> f15479h = null;
    /* renamed from: i */
    static HashMap<String, HashMap<String, byte[]>> f15480i = null;
    /* renamed from: g */
    protected C36501f f15481g = new C36501f();
    /* renamed from: j */
    private int f15482j = 0;
    /* renamed from: k */
    private int f15483k = 0;

    public C36893e() {
        AppMethodBeat.m2504i(98751);
        AppMethodBeat.m2505o(98751);
    }

    /* renamed from: a */
    public <T> void mo40542a(String str, T t) {
        AppMethodBeat.m2504i(98752);
        if (str.startsWith(".")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(98752);
            throw illegalArgumentException;
        }
        super.mo40542a(str, t);
        AppMethodBeat.m2505o(98752);
    }

    /* renamed from: a */
    public byte[] mo40544a() {
        AppMethodBeat.m2504i(98753);
        IllegalArgumentException illegalArgumentException;
        if (this.f15481g.f15332a != (short) 2) {
            if (this.f15481g.f15336e == null) {
                this.f15481g.f15336e = "";
            }
            if (this.f15481g.f15337f == null) {
                this.f15481g.f15337f = "";
            }
        } else if (this.f15481g.f15336e == null || this.f15481g.f15336e.equals("")) {
            illegalArgumentException = new IllegalArgumentException("servantName can not is null");
            AppMethodBeat.m2505o(98753);
            throw illegalArgumentException;
        } else if (this.f15481g.f15337f == null || this.f15481g.f15337f.equals("")) {
            illegalArgumentException = new IllegalArgumentException("funcName can not is null");
            AppMethodBeat.m2505o(98753);
            throw illegalArgumentException;
        }
        C24398l c24398l = new C24398l(0);
        c24398l.mo40662a(this.f4648c);
        if (this.f15481g.f15332a == (short) 2 || this.f15481g.f15332a == (short) 1) {
            c24398l.mo40674a(this.f4646a, 0);
        } else {
            c24398l.mo40674a(this.f15323e, 0);
        }
        this.f15481g.f15338g = C41080n.m71485a(c24398l.mo40663a());
        c24398l = new C24398l(0);
        c24398l.mo40662a(this.f4648c);
        this.f15481g.writeTo(c24398l);
        byte[] a = C41080n.m71485a(c24398l.mo40663a());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        a = allocate.array();
        AppMethodBeat.m2505o(98753);
        return a;
    }

    /* renamed from: b */
    private void m61412b() {
        AppMethodBeat.m2504i(98754);
        C31070k c31070k = new C31070k(this.f15481g.f15338g);
        c31070k.mo50504a(this.f4648c);
        if (f15479h == null) {
            HashMap hashMap = new HashMap();
            f15479h = hashMap;
            hashMap.put("", new byte[0]);
        }
        this.f15323e = c31070k.mo50509a(f15479h, 0, false);
        AppMethodBeat.m2505o(98754);
    }

    /* renamed from: c */
    private void m61413c() {
        AppMethodBeat.m2504i(98755);
        C31070k c31070k = new C31070k(this.f15481g.f15338g);
        c31070k.mo50504a(this.f4648c);
        if (f15480i == null) {
            f15480i = new HashMap();
            HashMap hashMap = new HashMap();
            hashMap.put("", new byte[0]);
            f15480i.put("", hashMap);
        }
        this.f4646a = c31070k.mo50509a(f15480i, 0, false);
        this.f4647b = new HashMap();
        AppMethodBeat.m2505o(98755);
    }

    /* renamed from: a */
    public void mo40543a(byte[] bArr) {
        AppMethodBeat.m2504i(98756);
        if (bArr.length < 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("decode package must include size head");
            AppMethodBeat.m2505o(98756);
            throw illegalArgumentException;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        allocate.put(bArr2).flip();
        this.f15482j = allocate.getInt();
        try {
            C31070k c31070k = new C31070k(bArr, 4);
            c31070k.mo50504a(this.f4648c);
            this.f15481g.readFrom(c31070k);
            if (this.f15481g.f15332a == (short) 3) {
                m61412b();
                AppMethodBeat.m2505o(98756);
                return;
            }
            this.f15323e = null;
            m61413c();
            AppMethodBeat.m2505o(98756);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(98756);
            throw runtimeException;
        }
    }

    /* renamed from: c */
    public void mo58776c(String str) {
        this.f15481g.f15336e = str;
    }

    /* renamed from: d */
    public void mo58777d(String str) {
        this.f15481g.f15337f = str;
    }
}
