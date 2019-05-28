package com.google.b;

import com.google.b.b.b;
import com.google.b.d.d;
import com.google.b.d.f;
import com.google.b.d.h;
import com.google.b.d.j;
import com.google.b.d.k;
import com.google.b.d.m;
import com.google.b.d.p;
import com.google.b.d.t;
import com.google.b.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e implements g {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        g kVar;
        AppMethodBeat.i(57220);
        switch (aVar) {
            case EAN_8:
                kVar = new k();
                break;
            case UPC_E:
                kVar = new t();
                break;
            case EAN_13:
                kVar = new j();
                break;
            case UPC_A:
                kVar = new p();
                break;
            case QR_CODE:
                kVar = new a();
                break;
            case CODE_39:
                kVar = new f();
                break;
            case CODE_93:
                kVar = new h();
                break;
            case CODE_128:
                kVar = new d();
                break;
            case ITF:
                kVar = new m();
                break;
            case PDF_417:
                kVar = new com.google.b.e.a();
                break;
            case CODABAR:
                kVar = new com.google.b.d.b();
                break;
            case DATA_MATRIX:
                kVar = new com.google.b.c.a();
                break;
            case AZTEC:
                kVar = new com.google.b.a.a();
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
                AppMethodBeat.o(57220);
                throw illegalArgumentException;
        }
        b a = kVar.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57220);
        return a;
    }
}
