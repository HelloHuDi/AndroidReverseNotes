package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f extends m {
    static byte[] k = null;
    static Map<String, String> l = null;
    static final /* synthetic */ boolean m;
    public short a = (short) 0;
    public byte b = (byte) 0;
    public int c = 0;
    public int d = 0;
    public String e = null;
    public String f = null;
    public byte[] g;
    public int h = 0;
    public Map<String, String> i;
    public Map<String, String> j;

    static {
        boolean z;
        AppMethodBeat.i(98857);
        if (f.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        m = z;
        AppMethodBeat.o(98857);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(98852);
        f fVar = (f) obj;
        if (n.a(1, fVar.a) && n.a(1, fVar.b) && n.a(1, fVar.c) && n.a(1, fVar.d) && n.a(Integer.valueOf(1), fVar.e) && n.a(Integer.valueOf(1), fVar.f) && n.a(Integer.valueOf(1), fVar.g) && n.a(1, fVar.h) && n.a(Integer.valueOf(1), fVar.i) && n.a(Integer.valueOf(1), fVar.j)) {
            AppMethodBeat.o(98852);
            return true;
        }
        AppMethodBeat.o(98852);
        return false;
    }

    public final Object clone() {
        AppMethodBeat.i(98853);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!m) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(98853);
                throw assertionError;
            }
        }
        AppMethodBeat.o(98853);
        return obj;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(98854);
        lVar.a(this.a, 1);
        lVar.b(this.b, 2);
        lVar.a(this.c, 3);
        lVar.a(this.d, 4);
        lVar.a(this.e, 5);
        lVar.a(this.f, 6);
        lVar.a(this.g, 7);
        lVar.a(this.h, 8);
        lVar.a(this.i, 9);
        lVar.a(this.j, 10);
        AppMethodBeat.o(98854);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(98855);
        try {
            HashMap hashMap;
            this.a = kVar.a(this.a, 1, true);
            this.b = kVar.a(this.b, 2, true);
            this.c = kVar.a(this.c, 3, true);
            this.d = kVar.a(this.d, 4, true);
            this.e = kVar.a(5, true);
            this.f = kVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.g = kVar.a(k, 7, true);
            this.h = kVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) kVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) kVar.a(l, 10, true);
            AppMethodBeat.o(98855);
        } catch (Exception e) {
            System.out.println("RequestPacket decode error " + g.a(this.g));
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(98855);
            throw runtimeException;
        }
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(98856);
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "iVersion");
        iVar.a(this.b, "cPacketType");
        iVar.a(this.c, "iMessageType");
        iVar.a(this.d, "iRequestId");
        iVar.a(this.e, "sServantName");
        iVar.a(this.f, "sFuncName");
        iVar.a(this.g, "sBuffer");
        iVar.a(this.h, "iTimeout");
        iVar.a(this.i, "context");
        iVar.a(this.j, "status");
        AppMethodBeat.o(98856);
    }
}
