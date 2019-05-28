package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class am extends ak {
    private static byte[] k = null;
    private static Map<String, String> l = null;
    public short a = (short) 3;
    public int b = 0;
    public String c = null;
    public String d = null;
    public byte[] e;
    private byte f = (byte) 0;
    private int g = 0;
    private int h = 0;
    private Map<String, String> i;
    private Map<String, String> j;

    public final void a(aj ajVar) {
        AppMethodBeat.i(98472);
        ajVar.a(this.a, 1);
        ajVar.a(this.f, 2);
        ajVar.a(this.g, 3);
        ajVar.a(this.b, 4);
        ajVar.a(this.c, 5);
        ajVar.a(this.d, 6);
        ajVar.a(this.e, 7);
        ajVar.a(this.h, 8);
        ajVar.a(this.i, 9);
        ajVar.a(this.j, 10);
        AppMethodBeat.o(98472);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98473);
        try {
            HashMap hashMap;
            this.a = aiVar.a(this.a, 1, true);
            this.f = aiVar.a(this.f, 2, true);
            this.g = aiVar.a(this.g, 3, true);
            this.b = aiVar.a(this.b, 4, true);
            this.c = aiVar.a(5, true);
            this.d = aiVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.e = aiVar.b(7, true);
            this.h = aiVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) aiVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) aiVar.a(l, 10, true);
            AppMethodBeat.o(98473);
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(98473);
            throw runtimeException;
        }
    }
}
