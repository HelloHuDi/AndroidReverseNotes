package a.i.b.a.c.m.a;

import a.f.b.j;
import a.f.b.k;
import a.k.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    static final class b extends k implements a.f.a.b<String, String> {
        final /* synthetic */ boolean BMJ = true;

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122908);
            String awu = awu((String) obj);
            AppMethodBeat.o(122908);
            return awu;
        }

        public final String awu(String str) {
            AppMethodBeat.i(122909);
            j.p(str, "string");
            String awt;
            if (this.BMJ) {
                awt = a.awt(str);
                AppMethodBeat.o(122909);
                return awt;
            }
            awt = str.toLowerCase();
            j.o(awt, "(this as java.lang.String).toLowerCase()");
            AppMethodBeat.o(122909);
            return awt;
        }
    }

    static final class a extends k implements a.f.a.b<Integer, Boolean> {
        final /* synthetic */ String BMI;
        final /* synthetic */ boolean BMJ = true;

        a(String str) {
            this.BMI = str;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(122906);
            Boolean valueOf = Boolean.valueOf(UO(((Number) obj).intValue()));
            AppMethodBeat.o(122906);
            return valueOf;
        }

        public final boolean UO(int i) {
            AppMethodBeat.i(122907);
            char charAt = this.BMI.charAt(i);
            if (!this.BMJ) {
                boolean isUpperCase = Character.isUpperCase(charAt);
                AppMethodBeat.o(122907);
                return isUpperCase;
            } else if ('A' <= charAt && 'Z' >= charAt) {
                AppMethodBeat.o(122907);
                return true;
            } else {
                AppMethodBeat.o(122907);
                return false;
            }
        }
    }

    public static final String awr(String str) {
        int i;
        AppMethodBeat.i(122910);
        j.p(str, "receiver$0");
        a aVar = new a(str);
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0 || !aVar.UO(0)) {
            AppMethodBeat.o(122910);
            return str;
        } else if (str.length() == 1 || !aVar.UO(1)) {
            j.p(str, "receiver$0");
            if ((((CharSequence) str).length() == 0 ? 1 : 0) == 0) {
                char charAt = str.charAt(0);
                if ('A' <= charAt && 'Z' >= charAt) {
                    charAt = Character.toLowerCase(charAt);
                    String substring = str.substring(1);
                    j.o(substring, "(this as java.lang.String).substring(startIndex)");
                    str = String.valueOf(charAt) + substring;
                    AppMethodBeat.o(122910);
                    return str;
                }
            }
            AppMethodBeat.o(122910);
            return str;
        } else {
            Object obj;
            b bVar = new b();
            for (Object next : v.as(str)) {
                if (aVar.UO(((Number) next).intValue())) {
                    i = 0;
                    continue;
                } else {
                    i = 1;
                    continue;
                }
                if (i != 0) {
                    obj = next;
                    break;
                }
            }
            obj = null;
            Integer num = (Integer) obj;
            if (num != null) {
                i = num.intValue() - 1;
                StringBuilder stringBuilder = new StringBuilder();
                String substring2 = str.substring(0, i);
                j.o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuilder = stringBuilder.append(bVar.awu(substring2));
                String substring3 = str.substring(i);
                j.o(substring3, "(this as java.lang.String).substring(startIndex)");
                str = stringBuilder.append(substring3).toString();
                AppMethodBeat.o(122910);
                return str;
            }
            str = bVar.awu(str);
            AppMethodBeat.o(122910);
            return str;
        }
    }

    public static final String aws(String str) {
        int i;
        AppMethodBeat.i(122911);
        j.p(str, "receiver$0");
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            AppMethodBeat.o(122911);
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && 'z' >= charAt) {
            charAt = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            j.o(substring, "(this as java.lang.String).substring(startIndex)");
            str = String.valueOf(charAt) + substring;
            AppMethodBeat.o(122911);
            return str;
        }
        AppMethodBeat.o(122911);
        return str;
    }

    public static final String awt(String str) {
        AppMethodBeat.i(122912);
        j.p(str, "receiver$0");
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && 'Z' >= charAt) {
                charAt = Character.toLowerCase(charAt);
            }
            stringBuilder.append(charAt);
        }
        String stringBuilder2 = stringBuilder.toString();
        j.o(stringBuilder2, "builder.toString()");
        AppMethodBeat.o(122912);
        return stringBuilder2;
    }
}
