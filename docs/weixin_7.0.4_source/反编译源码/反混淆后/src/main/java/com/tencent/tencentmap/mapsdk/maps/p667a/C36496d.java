package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.d */
public class C36496d extends C24358c {
    /* renamed from: e */
    protected HashMap<String, byte[]> f15323e = null;
    /* renamed from: f */
    C31070k f15324f = new C31070k();
    /* renamed from: g */
    private HashMap<String, Object> f15325g = new HashMap();

    public C36496d() {
        AppMethodBeat.m2504i(98688);
        AppMethodBeat.m2505o(98688);
    }

    /* renamed from: a */
    public <T> void mo40542a(String str, T t) {
        AppMethodBeat.m2504i(98689);
        IllegalArgumentException illegalArgumentException;
        if (this.f15323e == null) {
            super.mo40542a(str, (Object) t);
            AppMethodBeat.m2505o(98689);
        } else if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.m2505o(98689);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.m2505o(98689);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.m2505o(98689);
            throw illegalArgumentException;
        } else {
            C24398l c24398l = new C24398l();
            c24398l.mo40662a(this.f4648c);
            c24398l.mo40671a((Object) t, 0);
            this.f15323e.put(str, C41080n.m71485a(c24398l.mo40663a()));
            AppMethodBeat.m2505o(98689);
        }
    }

    /* renamed from: b */
    public <T> T mo57718b(String str) {
        AppMethodBeat.m2504i(98690);
        Object a = mo40540a(str, true, null);
        AppMethodBeat.m2505o(98690);
        return a;
    }

    /* renamed from: a */
    public <T> T mo40540a(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.m2504i(98691);
        if (this.f15323e != null) {
            RuntimeException runtimeException = new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
            AppMethodBeat.m2505o(98691);
            throw runtimeException;
        }
        Object a = super.mo40540a(str, z, classLoader);
        AppMethodBeat.m2505o(98691);
        return a;
    }

    /* renamed from: a */
    public byte[] mo40544a() {
        AppMethodBeat.m2504i(98692);
        byte[] a;
        if (this.f15323e != null) {
            C24398l c24398l = new C24398l(0);
            c24398l.mo40662a(this.f4648c);
            c24398l.mo40674a(this.f15323e, 0);
            a = C41080n.m71485a(c24398l.mo40663a());
            AppMethodBeat.m2505o(98692);
            return a;
        }
        a = super.mo40544a();
        AppMethodBeat.m2505o(98692);
        return a;
    }

    /* renamed from: a */
    public void mo40543a(byte[] bArr) {
        AppMethodBeat.m2504i(98693);
        try {
            super.mo40543a(bArr);
            AppMethodBeat.m2505o(98693);
        } catch (Exception e) {
            this.f15324f.mo50514a(bArr);
            this.f15324f.mo50504a(this.f4648c);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f15323e = this.f15324f.mo50509a(hashMap, 0, false);
            AppMethodBeat.m2505o(98693);
        }
    }
}
