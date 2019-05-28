package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.C34205g;
import com.tencent.p177mm.plugin.fts.p419a.p1550b.C39130b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.a.g */
public final class C20840g {
    private static final C20843a mEd = new C31531();
    public String mDY;
    public String mDZ;
    public String[] mEa;
    public String[] mEb;
    public List<C20841c> mEc = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.fts.a.a.g$1 */
    static class C31531 implements C20843a {
        C31531() {
        }

        public final String[] split(String str) {
            AppMethodBeat.m2504i(114252);
            String[] split = C28110a.mCE.split(str);
            AppMethodBeat.m2505o(114252);
            return split;
        }

        /* renamed from: Nh */
        public final String[] mo7410Nh(String str) {
            AppMethodBeat.m2504i(114253);
            String[] split = C28110a.mCE.split(str, 2);
            AppMethodBeat.m2505o(114253);
            return split;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.g$d */
    public enum C20839d {
        FullPY,
        ShortPY,
        OTHER;

        static {
            AppMethodBeat.m2505o(114259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.g$c */
    public static class C20841c {
        public List<C20842b> mEg = new ArrayList();

        public C20841c() {
            AppMethodBeat.m2504i(114254);
            AppMethodBeat.m2505o(114254);
        }

        private List<String> bAm() {
            AppMethodBeat.m2504i(114255);
            ArrayList arrayList = new ArrayList();
            for (C20842b c20842b : this.mEg) {
                if (!arrayList.contains(c20842b.content)) {
                    arrayList.add(c20842b.content);
                }
            }
            AppMethodBeat.m2505o(114255);
            return arrayList;
        }

        public final String bAn() {
            AppMethodBeat.m2504i(114256);
            List bAm = bAm();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                String str;
                if (i2 < bAm.size()) {
                    str = (String) bAm.get(i2);
                    stringBuilder.append("\"");
                    stringBuilder.append(str);
                    char charAt = str.charAt(str.length() - 1);
                    if (C34205g.m56098u(charAt) || C34205g.m56099v(charAt)) {
                        stringBuilder.append("\"*");
                    } else {
                        stringBuilder.append("\"");
                    }
                    if (i2 != bAm.size() - 1) {
                        stringBuilder.append(" OR ");
                    }
                    i = i2 + 1;
                } else {
                    str = stringBuilder.toString();
                    AppMethodBeat.m2505o(114256);
                    return str;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.g$b */
    public static class C20842b {
        public String content;
        public C20839d mEe;
        public List<String> mEf;
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.a.g$a */
    public interface C20843a {
        /* renamed from: Nh */
        String[] mo7410Nh(String str);

        String[] split(String str);
    }

    private C20840g() {
        AppMethodBeat.m2504i(114260);
        AppMethodBeat.m2505o(114260);
    }

    public final String bAl() {
        AppMethodBeat.m2504i(114261);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mEc.size()) {
                stringBuffer.append("(");
                stringBuffer.append(((C20841c) this.mEc.get(i2)).bAn());
                stringBuffer.append(")");
                if (i2 != this.mEc.size() - 1) {
                    stringBuffer.append(" AND ");
                }
                i = i2 + 1;
            } else {
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.m2505o(114261);
                return stringBuffer2;
            }
        }
    }

    /* renamed from: aN */
    private static C20841c m32051aN(String str, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(114262);
        if (z) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!C34205g.m56098u(str.charAt(i2))) {
                    z = false;
                    break;
                }
            }
        }
        C20841c c20841c = new C20841c();
        C20842b c20842b;
        if (z) {
            C39130b c39130b = C34205g.mDm;
            List arrayList = new ArrayList();
            char[] toCharArray = str.toLowerCase().toCharArray();
            while (i < toCharArray.length) {
                if (c39130b.mER.mES[toCharArray[i] - 97] == null) {
                    arrayList.clear();
                    break;
                }
                arrayList.add(String.valueOf(toCharArray[i]));
                i++;
            }
            if (arrayList.size() > 0) {
                c20842b = new C20842b();
                c20842b.mEe = C20839d.ShortPY;
                c20842b.content = C5046bo.m7536c(arrayList, "​");
                c20842b.mEf = arrayList;
                c20841c.mEg.add(c20842b);
            }
            List<List> Nj = C34205g.mDm.mo62034Nj(str);
            if (Nj.size() > 0) {
                for (List list : Nj) {
                    if (list.size() > 0) {
                        C20842b c20842b2 = new C20842b();
                        c20842b2.mEe = C20839d.FullPY;
                        c20842b2.content = C5046bo.m7536c(list, "​");
                        c20842b2.mEf = list;
                        c20841c.mEg.add(c20842b2);
                    }
                }
            }
            c20842b = new C20842b();
            c20842b.mEe = C20839d.OTHER;
            c20842b.content = str;
            c20841c.mEg.add(c20842b);
        } else {
            c20842b = new C20842b();
            c20842b.mEe = C20839d.OTHER;
            c20842b.content = str;
            c20841c.mEg.add(c20842b);
        }
        AppMethodBeat.m2505o(114262);
        return c20841c;
    }

    /* renamed from: aO */
    public static C20840g m32052aO(String str, boolean z) {
        AppMethodBeat.m2504i(114263);
        C20840g a = C20840g.m32050a(str, z, mEd);
        AppMethodBeat.m2505o(114263);
        return a;
    }

    /* renamed from: a */
    public static C20840g m32050a(String str, boolean z, C20843a c20843a) {
        AppMethodBeat.m2504i(114264);
        C20840g c20840g = new C20840g();
        c20840g.mDY = str;
        c20840g.mDZ = C3161d.m5404Nb(str);
        c20840g.mEa = c20843a.split(c20840g.mDZ);
        c20840g.mEb = c20843a.mo7410Nh(c20840g.mDZ);
        for (String aN : c20840g.mEa) {
            c20840g.mEc.add(C20840g.m32051aN(aN, z));
        }
        AppMethodBeat.m2505o(114264);
        return c20840g;
    }

    static {
        AppMethodBeat.m2504i(114265);
        AppMethodBeat.m2505o(114265);
    }
}
