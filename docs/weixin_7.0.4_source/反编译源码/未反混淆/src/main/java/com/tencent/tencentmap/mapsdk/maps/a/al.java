package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class al {
    private static HashMap<String, byte[]> e = null;
    private HashMap<String, byte[]> a = new HashMap();
    private ai b = new ai();
    private String c = "GBK";
    private am d = new am();

    public al() {
        AppMethodBeat.i(98467);
        AppMethodBeat.o(98467);
    }

    public final void a() {
        this.d.b = 1;
    }

    public final void a(String str) {
        this.d.d = str;
    }

    public final void b(String str) {
        this.d.c = str;
    }

    public final <T> void a(String str, T t) {
        AppMethodBeat.i(98468);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.o(98468);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.o(98468);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.o(98468);
            throw illegalArgumentException;
        } else {
            aj ajVar = new aj();
            ajVar.a(this.c);
            ajVar.a((Object) t, 0);
            ByteBuffer a = ajVar.a();
            byte[] bArr = new byte[a.position()];
            System.arraycopy(a.array(), 0, bArr, 0, bArr.length);
            this.a.put(str, bArr);
            AppMethodBeat.o(98468);
        }
    }

    public final byte[] b() {
        AppMethodBeat.i(98469);
        aj ajVar = new aj(0);
        ajVar.a(this.c);
        ajVar.a(this.a, 0);
        this.d.a = (short) 3;
        am amVar = this.d;
        ByteBuffer a = ajVar.a();
        byte[] bArr = new byte[a.position()];
        System.arraycopy(a.array(), 0, bArr, 0, bArr.length);
        amVar.e = bArr;
        ajVar = new aj(0);
        ajVar.a(this.c);
        this.d.a(ajVar);
        a = ajVar.a();
        byte[] bArr2 = new byte[a.position()];
        System.arraycopy(a.array(), 0, bArr2, 0, bArr2.length);
        int length = bArr2.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(bArr2).flip();
        byte[] array = allocate.array();
        AppMethodBeat.o(98469);
        return array;
    }

    public final void a(byte[] bArr) {
        AppMethodBeat.i(98470);
        if (bArr.length < 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("decode package must include size head");
            AppMethodBeat.o(98470);
            throw illegalArgumentException;
        }
        try {
            ai aiVar = new ai(bArr, (byte) 0);
            aiVar.a(this.c);
            this.d.a(aiVar);
            aiVar = new ai(this.d.e);
            aiVar.a(this.c);
            if (e == null) {
                HashMap hashMap = new HashMap();
                e = hashMap;
                hashMap.put("", new byte[0]);
            }
            this.a = aiVar.a(e);
            AppMethodBeat.o(98470);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(98470);
            throw runtimeException;
        }
    }

    public final <T> T b(String str, T t) {
        AppMethodBeat.i(98471);
        if (this.a.containsKey(str)) {
            try {
                this.b.a((byte[]) this.a.get(str));
                this.b.a(this.c);
                T a = this.b.a((Object) t, 0, true);
                AppMethodBeat.o(98471);
                return a;
            } catch (Exception e) {
                Exception exception = new Exception(e);
                AppMethodBeat.o(98471);
                throw exception;
            }
        }
        AppMethodBeat.o(98471);
        return null;
    }
}
