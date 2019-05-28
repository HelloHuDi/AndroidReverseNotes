package p000a.p010i.p011b.p012a.p015c.p047m.p1360a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C31820v;

/* renamed from: a.i.b.a.c.m.a.a */
public final class C31775a {

    /* renamed from: a.i.b.a.c.m.a.a$b */
    static final class C24625b extends C25053k implements C17126b<String, String> {
        final /* synthetic */ boolean BMJ = true;

        C24625b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122908);
            String awu = awu((String) obj);
            AppMethodBeat.m2505o(122908);
            return awu;
        }

        public final String awu(String str) {
            AppMethodBeat.m2504i(122909);
            C25052j.m39376p(str, "string");
            String awt;
            if (this.BMJ) {
                awt = C31775a.awt(str);
                AppMethodBeat.m2505o(122909);
                return awt;
            }
            awt = str.toLowerCase();
            C25052j.m39375o(awt, "(this as java.lang.String).toLowerCase()");
            AppMethodBeat.m2505o(122909);
            return awt;
        }
    }

    /* renamed from: a.i.b.a.c.m.a.a$a */
    static final class C31236a extends C25053k implements C17126b<Integer, Boolean> {
        final /* synthetic */ String BMI;
        final /* synthetic */ boolean BMJ = true;

        C31236a(String str) {
            this.BMI = str;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(122906);
            Boolean valueOf = Boolean.valueOf(mo51194UO(((Number) obj).intValue()));
            AppMethodBeat.m2505o(122906);
            return valueOf;
        }

        /* renamed from: UO */
        public final boolean mo51194UO(int i) {
            AppMethodBeat.m2504i(122907);
            char charAt = this.BMI.charAt(i);
            if (!this.BMJ) {
                boolean isUpperCase = Character.isUpperCase(charAt);
                AppMethodBeat.m2505o(122907);
                return isUpperCase;
            } else if ('A' <= charAt && 'Z' >= charAt) {
                AppMethodBeat.m2505o(122907);
                return true;
            } else {
                AppMethodBeat.m2505o(122907);
                return false;
            }
        }
    }

    public static final String awr(String str) {
        int i;
        AppMethodBeat.m2504i(122910);
        C25052j.m39376p(str, "receiver$0");
        C31236a c31236a = new C31236a(str);
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0 || !c31236a.mo51194UO(0)) {
            AppMethodBeat.m2505o(122910);
            return str;
        } else if (str.length() == 1 || !c31236a.mo51194UO(1)) {
            C25052j.m39376p(str, "receiver$0");
            if ((((CharSequence) str).length() == 0 ? 1 : 0) == 0) {
                char charAt = str.charAt(0);
                if ('A' <= charAt && 'Z' >= charAt) {
                    charAt = Character.toLowerCase(charAt);
                    String substring = str.substring(1);
                    C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
                    str = String.valueOf(charAt) + substring;
                    AppMethodBeat.m2505o(122910);
                    return str;
                }
            }
            AppMethodBeat.m2505o(122910);
            return str;
        } else {
            Object obj;
            C24625b c24625b = new C24625b();
            for (Object next : C31820v.m51529as(str)) {
                if (c31236a.mo51194UO(((Number) next).intValue())) {
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
                C25052j.m39375o(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuilder = stringBuilder.append(c24625b.awu(substring2));
                String substring3 = str.substring(i);
                C25052j.m39375o(substring3, "(this as java.lang.String).substring(startIndex)");
                str = stringBuilder.append(substring3).toString();
                AppMethodBeat.m2505o(122910);
                return str;
            }
            str = c24625b.awu(str);
            AppMethodBeat.m2505o(122910);
            return str;
        }
    }

    public static final String aws(String str) {
        int i;
        AppMethodBeat.m2504i(122911);
        C25052j.m39376p(str, "receiver$0");
        if (str.length() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            AppMethodBeat.m2505o(122911);
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && 'z' >= charAt) {
            charAt = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            C25052j.m39375o(substring, "(this as java.lang.String).substring(startIndex)");
            str = String.valueOf(charAt) + substring;
            AppMethodBeat.m2505o(122911);
            return str;
        }
        AppMethodBeat.m2505o(122911);
        return str;
    }

    public static final String awt(String str) {
        AppMethodBeat.m2504i(122912);
        C25052j.m39376p(str, "receiver$0");
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
        C25052j.m39375o(stringBuilder2, "builder.toString()");
        AppMethodBeat.m2505o(122912);
        return stringBuilder2;
    }
}
