package p000a.p010i.p011b.p012a.p015c.p037i.p038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2encoder;
import java.util.Arrays;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p018b.C25093y;
import p000a.p010i.p011b.p012a.p015c.p045l.C46867w;
import p000a.p010i.p011b.p012a.p015c.p045l.C8235ad;

/* renamed from: a.i.b.a.c.i.b.e */
public final class C44835e extends C44638m<Character> {
    public C44835e(char c) {
        super(Character.valueOf(c));
        AppMethodBeat.m2504i(122077);
        AppMethodBeat.m2505o(122077);
    }

    /* renamed from: b */
    public final /* synthetic */ C46867w mo18011b(C25093y c25093y) {
        AppMethodBeat.m2504i(122075);
        C25052j.m39376p(c25093y, "module");
        C8235ad a = c25093y.dZD().mo51607a(C31622h.CHAR);
        C25052j.m39375o(a, "module.builtIns.charType");
        C46867w c46867w = a;
        AppMethodBeat.m2505o(122075);
        return c46867w;
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.m2504i(122076);
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
                C25052j.m39375o(obj, "if (isPrintableUnicode(c…cter.toString(c) else \"?\"");
                break;
        }
        objArr[1] = obj;
        String format = String.format(str, Arrays.copyOf(objArr, 2));
        C25052j.m39375o(format, "java.lang.String.format(this, *args)");
        AppMethodBeat.m2505o(122076);
        return format;
    }
}
