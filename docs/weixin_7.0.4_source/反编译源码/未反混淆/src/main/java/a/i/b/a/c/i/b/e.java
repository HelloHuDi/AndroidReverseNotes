package a.i.b.a.c.i.b;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.b.y;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2encoder;
import java.util.Arrays;

public final class e extends m<Character> {
    public e(char c) {
        super(Character.valueOf(c));
        AppMethodBeat.i(122077);
        AppMethodBeat.o(122077);
    }

    public final /* synthetic */ w b(y yVar) {
        AppMethodBeat.i(122075);
        j.p(yVar, "module");
        ad a = yVar.dZD().a(h.CHAR);
        j.o(a, "module.builtIns.charType");
        w wVar = a;
        AppMethodBeat.o(122075);
        return wVar;
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.i(122076);
        String str = "\\u%04X ('%s')";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(((Character) getValue()).charValue());
        char charValue = ((Character) getValue()).charValue();
        switch (charValue) {
            case 8:
                obj = "\\b";
                break;
            case 9:
                obj = "\\t";
                break;
            case 10:
                obj = "\\n";
                break;
            case 12:
                obj = "\\f";
                break;
            case 13:
                obj = "\\r";
                break;
            default:
                int i;
                byte type = (byte) Character.getType(charValue);
                if (type == (byte) 0 || type == (byte) 13 || type == (byte) 14 || type == (byte) 15 || type == v2encoder.enumCODEC_vcodec2 || type == (byte) 18 || type == (byte) 19) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    obj = Character.toString(charValue);
                } else {
                    obj = "?";
                }
                j.o(obj, "if (isPrintableUnicode(c…cter.toString(c) else \"?\"");
                break;
        }
        objArr[1] = obj;
        String format = String.format(str, Arrays.copyOf(objArr, 2));
        j.o(format, "java.lang.String.format(this, *args)");
        AppMethodBeat.o(122076);
        return format;
    }
}
