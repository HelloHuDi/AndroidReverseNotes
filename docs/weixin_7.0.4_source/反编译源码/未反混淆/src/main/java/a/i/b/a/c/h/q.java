package a.i.b.a.c.h;

import a.f.b.j;
import a.i.b.a.c.f.c;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class q {
    public static final String y(f fVar) {
        AppMethodBeat.i(121914);
        j.p(fVar, "receiver$0");
        String stringBuilder;
        if (z(fVar)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str = fVar.name;
            j.o(str, "asString()");
            stringBuilder = stringBuilder2.append("`".concat(String.valueOf(str))).append('`').toString();
            AppMethodBeat.o(121914);
            return stringBuilder;
        }
        stringBuilder = fVar.name;
        j.o(stringBuilder, "asString()");
        AppMethodBeat.o(121914);
        return stringBuilder;
    }

    public static final String g(c cVar) {
        AppMethodBeat.i(121916);
        j.p(cVar, "receiver$0");
        List ehM = cVar.ehM();
        j.o(ehM, "pathSegments()");
        String fZ = fZ(ehM);
        AppMethodBeat.o(121916);
        return fZ;
    }

    public static final String fZ(List<f> list) {
        AppMethodBeat.i(121917);
        j.p(list, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(y(fVar));
        }
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(121917);
        return stringBuilder2;
    }

    private static final boolean z(f fVar) {
        AppMethodBeat.i(121915);
        if (fVar.ByZ) {
            AppMethodBeat.o(121915);
            return false;
        }
        String str = fVar.name;
        j.o(str, "asString()");
        if (!l.BDt.contains(str)) {
            boolean z;
            CharSequence charSequence = str;
            for (int i = 0; i < charSequence.length(); i++) {
                boolean z2;
                char charAt = charSequence.charAt(i);
                if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                AppMethodBeat.o(121915);
                return false;
            }
        }
        AppMethodBeat.o(121915);
        return true;
    }
}
