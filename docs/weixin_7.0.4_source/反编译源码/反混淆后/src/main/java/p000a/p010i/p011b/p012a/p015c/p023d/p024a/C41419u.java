package p000a.p010i.p011b.p012a.p015c.p023d.p024a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31619g;
import p000a.p010i.p011b.p012a.p015c.p018b.C0036h;
import p000a.p010i.p011b.p012a.p015c.p018b.C36964f;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p021c.p022a.C0039c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.p1583c.C41448a;
import p000a.p010i.p011b.p012a.p015c.p048n.C8263f;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p051k.C0218t;
import p000a.p051k.C16500s;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.d.a.u */
public final class C41419u {
    /* JADX WARNING: Missing block: B:68:0x017d, code skipped:
            if (p000a.p010i.p011b.p012a.p015c.p016a.C31619g.m51098E(r1) == false) goto L_0x017f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final C36988l m72237a(C46867w c46867w, String str) {
        AppMethodBeat.m2504i(119743);
        C25052j.m39376p(c46867w, "receiver$0");
        C25052j.m39376p(str, "value");
        C0036h dYs = c46867w.ejw().dYs();
        C36988l c0067h;
        if ((dYs instanceof C46865e) && ((C46865e) dYs).dYc() == C36964f.ENUM_CLASS) {
            C31746h dZk = ((C46865e) dYs).dZk();
            C37022f avX = C37022f.avX(str);
            C25052j.m39375o(avX, "Name.identifier(value)");
            dYs = dZk.mo222c(avX, C0039c.FROM_BACKEND);
            if ((dYs instanceof C46865e) && ((C46865e) dYs).dYc() == C36964f.ENUM_ENTRY) {
                c0067h = new C0067h((C46865e) dYs);
                AppMethodBeat.m2505o(119743);
                return c0067h;
            }
            AppMethodBeat.m2505o(119743);
            return null;
        }
        String substring;
        C8263f c8263f;
        Object str2;
        C46867w aA = C41448a.m72312aA(c46867w);
        C25052j.m39376p(str2, "value");
        if (C6163u.m9839jb(str2, "0x") || C6163u.m9839jb(str2, "0X")) {
            substring = str2.substring(2);
            C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
            c8263f = new C8263f(substring, 16);
        } else if (C6163u.m9839jb(str2, "0b") || C6163u.m9839jb(str2, "0B")) {
            substring = str2.substring(2);
            C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
            c8263f = new C8263f(substring, 2);
        } else {
            c8263f = new C8263f(str2, 10);
        }
        substring = c8263f.tTc;
        int i = c8263f.BNi;
        try {
            if (C31619g.m51126q(aA)) {
                str2 = Boolean.valueOf(Boolean.parseBoolean(str2));
            } else if (C31619g.m51127r(aA)) {
                CharSequence charSequence = str2;
                C25052j.m39376p(charSequence, "receiver$0");
                str2 = charSequence.length() == 1 ? Character.valueOf(charSequence.charAt(0)) : null;
            } else {
                Integer eX;
                if (C31619g.m51129t(aA)) {
                    C25052j.m39376p(substring, "receiver$0");
                    eX = C0218t.m309eX(substring, i);
                    if (eX != null) {
                        i = eX.intValue();
                        str2 = (i < -128 || i > C31128d.MIC_SketchMark) ? null : Byte.valueOf((byte) i);
                    }
                } else if (C31619g.m51131v(aA)) {
                    C25052j.m39376p(substring, "receiver$0");
                    eX = C0218t.m309eX(substring, i);
                    if (eX != null) {
                        i = eX.intValue();
                        str2 = (i < -32768 || i > 32767) ? null : Short.valueOf((short) i);
                    }
                } else if (C31619g.m51128s(aA)) {
                    str2 = C0218t.m309eX(substring, i);
                } else if (C31619g.m51130u(aA)) {
                    str2 = C0218t.m310eY(substring, i);
                } else if (C31619g.m51132w(aA)) {
                    str2 = C16500s.aww(str2);
                } else if (C31619g.m51133x(aA)) {
                    str2 = C16500s.awx(str2);
                }
                str2 = null;
            }
        } catch (IllegalArgumentException e) {
            str2 = null;
        }
        if (str2 != null) {
            c0067h = new C31677f(str2);
            AppMethodBeat.m2505o(119743);
            return c0067h;
        }
        AppMethodBeat.m2505o(119743);
        return null;
    }
}
