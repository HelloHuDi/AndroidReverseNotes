package com.google.b.c;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.c.a.e;
import com.google.b.c.a.i;
import com.google.b.c.a.j;
import com.google.b.c.a.k;
import com.google.b.c.a.l;
import com.google.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class a implements g {
    public final b a(String str, com.google.b.a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57274);
        IllegalArgumentException illegalArgumentException;
        if (str.isEmpty()) {
            illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.o(57274);
            throw illegalArgumentException;
        } else if (aVar != com.google.b.a.DATA_MATRIX) {
            illegalArgumentException = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57274);
            throw illegalArgumentException;
        } else if (i < 0 || i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            AppMethodBeat.o(57274);
            throw illegalArgumentException;
        } else {
            com.google.b.b bVar;
            com.google.b.b bVar2;
            l lVar = l.FORCE_NONE;
            if (map != null) {
                l lVar2 = (l) map.get(c.DATA_MATRIX_SHAPE);
                if (lVar2 != null) {
                    lVar = lVar2;
                }
                bVar = (com.google.b.b) map.get(c.MIN_SIZE);
                if (bVar != null) {
                    bVar2 = bVar;
                } else {
                    bVar2 = null;
                }
                bVar = (com.google.b.b) map.get(c.MAX_SIZE);
                if (bVar == null) {
                    bVar = null;
                }
            } else {
                bVar = null;
                bVar2 = null;
            }
            String a = j.a(str, lVar, bVar2, bVar);
            k a2 = k.a(a.length(), lVar, bVar2, bVar);
            e eVar = new e(i.a(a, a2), a2.vE(), a2.vF());
            eVar.vw();
            b a3 = a(eVar, a2);
            AppMethodBeat.o(57274);
            return a3;
        }
    }

    private static b a(e eVar, k kVar) {
        int i;
        int i2;
        int i3;
        AppMethodBeat.i(57275);
        int vE = kVar.vE();
        int vF = kVar.vF();
        com.google.b.f.b.b bVar = new com.google.b.f.b.b(kVar.vG(), kVar.vH());
        int i4 = 0;
        int i5 = 0;
        while (i4 < vF) {
            boolean z;
            if (i4 % kVar.bzZ == 0) {
                i = 0;
                for (i2 = 0; i2 < kVar.vG(); i2++) {
                    if (i2 % 2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.set(i, i5, z);
                    i++;
                }
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i = 0;
            for (i5 = 0; i5 < vE; i5++) {
                if (i5 % kVar.bzY == 0) {
                    bVar.set(i, i2, true);
                    i++;
                }
                if (eVar.bzG[(eVar.bzF * i4) + i5] == (byte) 1) {
                    z = true;
                } else {
                    z = false;
                }
                bVar.set(i, i2, z);
                i3 = i + 1;
                if (i5 % kVar.bzY == kVar.bzY - 1) {
                    bVar.set(i3, i2, i4 % 2 == 0);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
            }
            i3 = i2 + 1;
            if (i4 % kVar.bzZ == kVar.bzZ - 1) {
                i = 0;
                for (i2 = 0; i2 < kVar.vG(); i2++) {
                    bVar.set(i, i3, true);
                    i++;
                }
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i4++;
            i5 = i2;
        }
        i3 = bVar.width;
        i5 = bVar.height;
        b bVar2 = new b(i3, i5);
        bVar2.clear();
        for (i = 0; i < i3; i++) {
            for (i2 = 0; i2 < i5; i2++) {
                if (bVar.bH(i, i2) == (byte) 1) {
                    bVar2.set(i, i2);
                }
            }
        }
        AppMethodBeat.o(57275);
        return bVar2;
    }
}
