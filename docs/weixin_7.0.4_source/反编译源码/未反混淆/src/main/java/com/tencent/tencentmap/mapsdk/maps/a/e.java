package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class e extends d {
    static HashMap<String, byte[]> h = null;
    static HashMap<String, HashMap<String, byte[]>> i = null;
    protected f g = new f();
    private int j = 0;
    private int k = 0;

    public e() {
        AppMethodBeat.i(98751);
        AppMethodBeat.o(98751);
    }

    public <T> void a(String str, T t) {
        AppMethodBeat.i(98752);
        if (str.startsWith(".")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
            AppMethodBeat.o(98752);
            throw illegalArgumentException;
        }
        super.a(str, t);
        AppMethodBeat.o(98752);
    }

    public byte[] a() {
        AppMethodBeat.i(98753);
        IllegalArgumentException illegalArgumentException;
        if (this.g.a != (short) 2) {
            if (this.g.e == null) {
                this.g.e = "";
            }
            if (this.g.f == null) {
                this.g.f = "";
            }
        } else if (this.g.e == null || this.g.e.equals("")) {
            illegalArgumentException = new IllegalArgumentException("servantName can not is null");
            AppMethodBeat.o(98753);
            throw illegalArgumentException;
        } else if (this.g.f == null || this.g.f.equals("")) {
            illegalArgumentException = new IllegalArgumentException("funcName can not is null");
            AppMethodBeat.o(98753);
            throw illegalArgumentException;
        }
        l lVar = new l(0);
        lVar.a(this.c);
        if (this.g.a == (short) 2 || this.g.a == (short) 1) {
            lVar.a(this.a, 0);
        } else {
            lVar.a(this.e, 0);
        }
        this.g.g = n.a(lVar.a());
        lVar = new l(0);
        lVar.a(this.c);
        this.g.writeTo(lVar);
        byte[] a = n.a(lVar.a());
        int length = a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(a).flip();
        a = allocate.array();
        AppMethodBeat.o(98753);
        return a;
    }

    private void b() {
        AppMethodBeat.i(98754);
        k kVar = new k(this.g.g);
        kVar.a(this.c);
        if (h == null) {
            HashMap hashMap = new HashMap();
            h = hashMap;
            hashMap.put("", new byte[0]);
        }
        this.e = kVar.a(h, 0, false);
        AppMethodBeat.o(98754);
    }

    private void c() {
        AppMethodBeat.i(98755);
        k kVar = new k(this.g.g);
        kVar.a(this.c);
        if (i == null) {
            i = new HashMap();
            HashMap hashMap = new HashMap();
            hashMap.put("", new byte[0]);
            i.put("", hashMap);
        }
        this.a = kVar.a(i, 0, false);
        this.b = new HashMap();
        AppMethodBeat.o(98755);
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(98756);
        if (bArr.length < 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("decode package must include size head");
            AppMethodBeat.o(98756);
            throw illegalArgumentException;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        allocate.put(bArr2).flip();
        this.j = allocate.getInt();
        try {
            k kVar = new k(bArr, 4);
            kVar.a(this.c);
            this.g.readFrom(kVar);
            if (this.g.a == (short) 3) {
                b();
                AppMethodBeat.o(98756);
                return;
            }
            this.e = null;
            c();
            AppMethodBeat.o(98756);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(98756);
            throw runtimeException;
        }
    }

    public void c(String str) {
        this.g.e = str;
    }

    public void d(String str) {
        this.g.f = str;
    }
}
