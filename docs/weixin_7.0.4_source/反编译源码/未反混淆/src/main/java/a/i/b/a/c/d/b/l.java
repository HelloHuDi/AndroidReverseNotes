package a.i.b.a.c.d.b;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.d.b.j.a;
import a.i.b.a.c.d.b.j.b;
import a.i.b.a.c.d.b.j.c;
import a.k.v;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;

final class l implements k<j> {
    public static final l BrF = new l();

    static {
        AppMethodBeat.i(120283);
        AppMethodBeat.o(120283);
    }

    private l() {
    }

    public final /* synthetic */ Object avM(String str) {
        AppMethodBeat.i(120277);
        j avO = avO(str);
        AppMethodBeat.o(120277);
        return avO;
    }

    public final /* synthetic */ Object avN(String str) {
        AppMethodBeat.i(120279);
        b avP = avP(str);
        AppMethodBeat.o(120279);
        return avP;
    }

    public final /* synthetic */ Object dJ(Object obj) {
        AppMethodBeat.i(120275);
        j jVar = (j) obj;
        j.p(jVar, "possiblyPrimitiveType");
        if (!(jVar instanceof c) || ((c) jVar).BrE == null) {
            AppMethodBeat.o(120275);
            return jVar;
        }
        a.i.b.a.c.i.d.b o = a.i.b.a.c.i.d.b.o(((c) jVar).BrE.BFr);
        j.o(o, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        String str = o.BrD;
        j.o(str, "JvmClassName.byFqNameWit…apperFqName).internalName");
        j avP = avP(str);
        AppMethodBeat.o(120275);
        return avP;
    }

    public final /* synthetic */ String toString(Object obj) {
        AppMethodBeat.i(120281);
        String a = a((j) obj);
        AppMethodBeat.o(120281);
        return a;
    }

    private j avO(String str) {
        int i = 0;
        AppMethodBeat.i(120276);
        j.p(str, "representation");
        int i2 = str.length() > 0 ? 1 : 0;
        Throwable assertionError;
        if (aa.AUz && i2 == 0) {
            assertionError = new AssertionError("empty string as JvmType");
            AppMethodBeat.o(120276);
            throw assertionError;
        }
        a.i.b.a.c.i.d.c cVar;
        char charAt = str.charAt(0);
        for (a.i.b.a.c.i.d.c cVar2 : a.i.b.a.c.i.d.c.values()) {
            int i3;
            if (cVar2.desc.charAt(0) == charAt) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                cVar = cVar2;
                break;
            }
        }
        cVar = null;
        j cVar3;
        if (cVar != null) {
            cVar3 = new c(cVar);
            AppMethodBeat.o(120276);
            return cVar3;
        }
        switch (charAt) {
            case 'V':
                cVar3 = new c(null);
                AppMethodBeat.o(120276);
                return cVar3;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                String substring = str.substring(1);
                j.o(substring, "(this as java.lang.String).substring(startIndex)");
                cVar3 = new a(avO(substring));
                AppMethodBeat.o(120276);
                return cVar3;
            default:
                if (charAt == 'L') {
                    CharSequence charSequence = str;
                    j.p(charSequence, "receiver$0");
                    if (charSequence.length() <= 0 || !a.k.c.a(charSequence.charAt(v.at(charSequence)), ';', false)) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        i = 1;
                    }
                }
                if (aa.AUz && i == 0) {
                    assertionError = new AssertionError("Type that is not primitive nor array should be Object, but '" + str + "' was found");
                    AppMethodBeat.o(120276);
                    throw assertionError;
                }
                String substring2 = str.substring(1, str.length() - 1);
                j.o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                cVar3 = new b(substring2);
                AppMethodBeat.o(120276);
                return cVar3;
        }
    }

    private static b avP(String str) {
        AppMethodBeat.i(120278);
        j.p(str, "internalName");
        b bVar = new b(str);
        AppMethodBeat.o(120278);
        return bVar;
    }

    public final String a(j jVar) {
        AppMethodBeat.i(120280);
        j.p(jVar, "type");
        String str;
        if (jVar instanceof a) {
            str = "[" + a(((a) jVar).BrC);
            AppMethodBeat.o(120280);
            return str;
        } else if (jVar instanceof c) {
            a.i.b.a.c.i.d.c cVar = ((c) jVar).BrE;
            if (cVar != null) {
                str = cVar.desc;
                if (str != null) {
                    AppMethodBeat.o(120280);
                    return str;
                }
            }
            str = "V";
            AppMethodBeat.o(120280);
            return str;
        } else if (jVar instanceof b) {
            str = "L" + ((b) jVar).BrD + ";";
            AppMethodBeat.o(120280);
            return str;
        } else {
            m mVar = new m();
            AppMethodBeat.o(120280);
            throw mVar;
        }
    }

    public final /* synthetic */ Object ecu() {
        AppMethodBeat.i(120282);
        j avP = avP("java/lang/Class");
        AppMethodBeat.o(120282);
        return avP;
    }
}
