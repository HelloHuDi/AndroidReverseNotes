package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class d extends c {
    protected HashMap<String, byte[]> e = null;
    k f = new k();
    private HashMap<String, Object> g = new HashMap();

    public d() {
        AppMethodBeat.i(98688);
        AppMethodBeat.o(98688);
    }

    public <T> void a(String str, T t) {
        AppMethodBeat.i(98689);
        IllegalArgumentException illegalArgumentException;
        if (this.e == null) {
            super.a(str, (Object) t);
            AppMethodBeat.o(98689);
        } else if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.o(98689);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.o(98689);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.o(98689);
            throw illegalArgumentException;
        } else {
            l lVar = new l();
            lVar.a(this.c);
            lVar.a((Object) t, 0);
            this.e.put(str, n.a(lVar.a()));
            AppMethodBeat.o(98689);
        }
    }

    public <T> T b(String str) {
        AppMethodBeat.i(98690);
        Object a = a(str, true, null);
        AppMethodBeat.o(98690);
        return a;
    }

    public <T> T a(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.i(98691);
        if (this.e != null) {
            RuntimeException runtimeException = new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
            AppMethodBeat.o(98691);
            throw runtimeException;
        }
        Object a = super.a(str, z, classLoader);
        AppMethodBeat.o(98691);
        return a;
    }

    public byte[] a() {
        AppMethodBeat.i(98692);
        byte[] a;
        if (this.e != null) {
            l lVar = new l(0);
            lVar.a(this.c);
            lVar.a(this.e, 0);
            a = n.a(lVar.a());
            AppMethodBeat.o(98692);
            return a;
        }
        a = super.a();
        AppMethodBeat.o(98692);
        return a;
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(98693);
        try {
            super.a(bArr);
            AppMethodBeat.o(98693);
        } catch (Exception e) {
            this.f.a(bArr);
            this.f.a(this.c);
            Map hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.e = this.f.a(hashMap, 0, false);
            AppMethodBeat.o(98693);
        }
    }
}
