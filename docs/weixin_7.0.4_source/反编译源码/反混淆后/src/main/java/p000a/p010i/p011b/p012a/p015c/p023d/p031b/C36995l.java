package p000a.p010i.p011b.p012a.p015c.p023d.p031b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import p000a.C31824m;
import p000a.C44847aa;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C17232c;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C31681b;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C31680j.C31682a;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C41436b;
import p000a.p051k.C25272c;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.d.b.l */
final class C36995l implements C44896k<C31680j> {
    public static final C36995l BrF = new C36995l();

    static {
        AppMethodBeat.m2504i(120283);
        AppMethodBeat.m2505o(120283);
    }

    private C36995l() {
    }

    public final /* synthetic */ Object avM(String str) {
        AppMethodBeat.m2504i(120277);
        C31680j avO = avO(str);
        AppMethodBeat.m2505o(120277);
        return avO;
    }

    public final /* synthetic */ Object avN(String str) {
        AppMethodBeat.m2504i(120279);
        C31681b avP = C36995l.avP(str);
        AppMethodBeat.m2505o(120279);
        return avP;
    }

    /* renamed from: dJ */
    public final /* synthetic */ Object mo59006dJ(Object obj) {
        AppMethodBeat.m2504i(120275);
        C31680j c31680j = (C31680j) obj;
        C25052j.m39376p(c31680j, "possiblyPrimitiveType");
        if (!(c31680j instanceof C17232c) || ((C17232c) c31680j).BrE == null) {
            AppMethodBeat.m2505o(120275);
            return c31680j;
        }
        C41436b o = C41436b.m72291o(((C17232c) c31680j).BrE.BFr);
        C25052j.m39375o(o, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        String str = o.BrD;
        C25052j.m39375o(str, "JvmClassName.byFqNameWit…apperFqName).internalName");
        C31680j avP = C36995l.avP(str);
        AppMethodBeat.m2505o(120275);
        return avP;
    }

    public final /* synthetic */ String toString(Object obj) {
        AppMethodBeat.m2504i(120281);
        String a = mo59003a((C31680j) obj);
        AppMethodBeat.m2505o(120281);
        return a;
    }

    private C31680j avO(String str) {
        int i = 0;
        AppMethodBeat.m2504i(120276);
        C25052j.m39376p(str, "representation");
        int i2 = str.length() > 0 ? 1 : 0;
        Throwable assertionError;
        if (C44847aa.AUz && i2 == 0) {
            assertionError = new AssertionError("empty string as JvmType");
            AppMethodBeat.m2505o(120276);
            throw assertionError;
        }
        C25176c c25176c;
        char charAt = str.charAt(0);
        for (C25176c c25176c2 : C25176c.values()) {
            int i3;
            if (c25176c2.desc.charAt(0) == charAt) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                c25176c = c25176c2;
                break;
            }
        }
        c25176c = null;
        C31680j c17232c;
        if (c25176c != null) {
            c17232c = new C17232c(c25176c);
            AppMethodBeat.m2505o(120276);
            return c17232c;
        }
        switch (charAt) {
            case 'V':
                c17232c = new C17232c(null);
                AppMethodBeat.m2505o(120276);
                return c17232c;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                String substring = str.substring(1);
                C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
                c17232c = new C31682a(avO(substring));
                AppMethodBeat.m2505o(120276);
                return c17232c;
            default:
                if (charAt == 'L') {
                    CharSequence charSequence = str;
                    C25052j.m39376p(charSequence, "receiver$0");
                    if (charSequence.length() <= 0 || !C25272c.m39838a(charSequence.charAt(C31820v.m51530at(charSequence)), ';', false)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        i = 1;
                    }
                }
                if (C44847aa.AUz && i == 0) {
                    assertionError = new AssertionError("Type that is not primitive nor array should be Object, but '" + str + "' was found");
                    AppMethodBeat.m2505o(120276);
                    throw assertionError;
                }
                String substring2 = str.substring(1, str.length() - 1);
                C25052j.m39375o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                c17232c = new C31681b(substring2);
                AppMethodBeat.m2505o(120276);
                return c17232c;
        }
    }

    private static C31681b avP(String str) {
        AppMethodBeat.m2504i(120278);
        C25052j.m39376p(str, "internalName");
        C31681b c31681b = new C31681b(str);
        AppMethodBeat.m2505o(120278);
        return c31681b;
    }

    /* renamed from: a */
    public final String mo59003a(C31680j c31680j) {
        AppMethodBeat.m2504i(120280);
        C25052j.m39376p(c31680j, "type");
        String str;
        if (c31680j instanceof C31682a) {
            str = "[" + mo59003a(((C31682a) c31680j).BrC);
            AppMethodBeat.m2505o(120280);
            return str;
        } else if (c31680j instanceof C17232c) {
            C25176c c25176c = ((C17232c) c31680j).BrE;
            if (c25176c != null) {
                str = c25176c.desc;
                if (str != null) {
                    AppMethodBeat.m2505o(120280);
                    return str;
                }
            }
            str = "V";
            AppMethodBeat.m2505o(120280);
            return str;
        } else if (c31680j instanceof C31681b) {
            str = "L" + ((C31681b) c31680j).BrD + ";";
            AppMethodBeat.m2505o(120280);
            return str;
        } else {
            C31824m c31824m = new C31824m();
            AppMethodBeat.m2505o(120280);
            throw c31824m;
        }
    }

    public final /* synthetic */ Object ecu() {
        AppMethodBeat.m2504i(120282);
        C31680j avP = C36995l.avP("java/lang/Class");
        AppMethodBeat.m2505o(120282);
        return avP;
    }
}
