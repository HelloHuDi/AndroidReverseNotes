package com.google.p114b;

import com.google.p114b.p115c.C37297a;
import com.google.p114b.p1162a.C17700a;
import com.google.p114b.p117d.C0897b;
import com.google.p114b.p117d.C0900d;
import com.google.p114b.p117d.C25573k;
import com.google.p114b.p117d.C25574m;
import com.google.p114b.p117d.C25575t;
import com.google.p114b.p117d.C32083h;
import com.google.p114b.p117d.C32084j;
import com.google.p114b.p117d.C41639p;
import com.google.p114b.p117d.C46872f;
import com.google.p114b.p118e.C8736a;
import com.google.p114b.p120f.C31250a;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.e */
public final class C31249e implements C25577g {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        C25577g c25573k;
        AppMethodBeat.m2504i(57220);
        switch (c37292a) {
            case EAN_8:
                c25573k = new C25573k();
                break;
            case UPC_E:
                c25573k = new C25575t();
                break;
            case EAN_13:
                c25573k = new C32084j();
                break;
            case UPC_A:
                c25573k = new C41639p();
                break;
            case QR_CODE:
                c25573k = new C31250a();
                break;
            case CODE_39:
                c25573k = new C46872f();
                break;
            case CODE_93:
                c25573k = new C32083h();
                break;
            case CODE_128:
                c25573k = new C0900d();
                break;
            case ITF:
                c25573k = new C25574m();
                break;
            case PDF_417:
                c25573k = new C8736a();
                break;
            case CODABAR:
                c25573k = new C0897b();
                break;
            case DATA_MATRIX:
                c25573k = new C37297a();
                break;
            case AZTEC:
                c25573k = new C17700a();
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(c37292a)));
                AppMethodBeat.m2505o(57220);
                throw illegalArgumentException;
        }
        C45061b a = c25573k.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57220);
        return a;
    }
}
