package a.i.b.a.c.d.a;

import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.f;
import a.i.b.a.c.b.h;
import a.i.b.a.c.c.a.c;
import a.i.b.a.c.l.c.a;
import a.i.b.a.c.l.w;
import a.k.s;
import a.k.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public final class u {
    /* JADX WARNING: Missing block: B:68:0x017d, code skipped:
            if (a.i.b.a.c.a.g.E(r1) == false) goto L_0x017f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final l a(w wVar, String str) {
        AppMethodBeat.i(119743);
        j.p(wVar, "receiver$0");
        j.p(str, "value");
        h dYs = wVar.ejw().dYs();
        l hVar;
        if ((dYs instanceof e) && ((e) dYs).dYc() == f.ENUM_CLASS) {
            a.i.b.a.c.i.e.h dZk = ((e) dYs).dZk();
            a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(str);
            j.o(avX, "Name.identifier(value)");
            dYs = dZk.c(avX, c.FROM_BACKEND);
            if ((dYs instanceof e) && ((e) dYs).dYc() == f.ENUM_ENTRY) {
                hVar = new h((e) dYs);
                AppMethodBeat.o(119743);
                return hVar;
            }
            AppMethodBeat.o(119743);
            return null;
        }
        String substring;
        a.i.b.a.c.n.f fVar;
        Object str2;
        w aA = a.aA(wVar);
        j.p(str2, "value");
        if (a.k.u.jb(str2, "0x") || a.k.u.jb(str2, "0X")) {
            substring = str2.substring(2);
            j.o(substring, "(this as java.lang.String).substring(startIndex)");
            fVar = new a.i.b.a.c.n.f(substring, 16);
        } else if (a.k.u.jb(str2, "0b") || a.k.u.jb(str2, "0B")) {
            substring = str2.substring(2);
            j.o(substring, "(this as java.lang.String).substring(startIndex)");
            fVar = new a.i.b.a.c.n.f(substring, 2);
        } else {
            fVar = new a.i.b.a.c.n.f(str2, 10);
        }
        substring = fVar.tTc;
        int i = fVar.BNi;
        try {
            if (g.q(aA)) {
                str2 = Boolean.valueOf(Boolean.parseBoolean(str2));
            } else if (g.r(aA)) {
                CharSequence charSequence = str2;
                j.p(charSequence, "receiver$0");
                str2 = charSequence.length() == 1 ? Character.valueOf(charSequence.charAt(0)) : null;
            } else {
                Integer eX;
                if (g.t(aA)) {
                    j.p(substring, "receiver$0");
                    eX = t.eX(substring, i);
                    if (eX != null) {
                        i = eX.intValue();
                        str2 = (i < -128 || i > d.MIC_SketchMark) ? null : Byte.valueOf((byte) i);
                    }
                } else if (g.v(aA)) {
                    j.p(substring, "receiver$0");
                    eX = t.eX(substring, i);
                    if (eX != null) {
                        i = eX.intValue();
                        str2 = (i < -32768 || i > 32767) ? null : Short.valueOf((short) i);
                    }
                } else if (g.s(aA)) {
                    str2 = t.eX(substring, i);
                } else if (g.u(aA)) {
                    str2 = t.eY(substring, i);
                } else if (g.w(aA)) {
                    str2 = s.aww(str2);
                } else if (g.x(aA)) {
                    str2 = s.awx(str2);
                }
                str2 = null;
            }
        } catch (IllegalArgumentException e) {
            str2 = null;
        }
        if (str2 != null) {
            hVar = new f(str2);
            AppMethodBeat.o(119743);
            return hVar;
        }
        AppMethodBeat.o(119743);
        return null;
    }
}
