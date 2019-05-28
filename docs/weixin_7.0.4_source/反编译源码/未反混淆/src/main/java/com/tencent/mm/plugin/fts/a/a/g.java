package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private static final a mEd = new a() {
        public final String[] split(String str) {
            AppMethodBeat.i(114252);
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mCE.split(str);
            AppMethodBeat.o(114252);
            return split;
        }

        public final String[] Nh(String str) {
            AppMethodBeat.i(114253);
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mCE.split(str, 2);
            AppMethodBeat.o(114253);
            return split;
        }
    };
    public String mDY;
    public String mDZ;
    public String[] mEa;
    public String[] mEb;
    public List<c> mEc = new ArrayList();

    public enum d {
        FullPY,
        ShortPY,
        OTHER;

        static {
            AppMethodBeat.o(114259);
        }
    }

    public static class c {
        public List<b> mEg = new ArrayList();

        public c() {
            AppMethodBeat.i(114254);
            AppMethodBeat.o(114254);
        }

        private List<String> bAm() {
            AppMethodBeat.i(114255);
            ArrayList arrayList = new ArrayList();
            for (b bVar : this.mEg) {
                if (!arrayList.contains(bVar.content)) {
                    arrayList.add(bVar.content);
                }
            }
            AppMethodBeat.o(114255);
            return arrayList;
        }

        public final String bAn() {
            AppMethodBeat.i(114256);
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
                    if (com.tencent.mm.plugin.fts.a.g.u(charAt) || com.tencent.mm.plugin.fts.a.g.v(charAt)) {
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
                    AppMethodBeat.o(114256);
                    return str;
                }
            }
        }
    }

    public static class b {
        public String content;
        public d mEe;
        public List<String> mEf;
    }

    public interface a {
        String[] Nh(String str);

        String[] split(String str);
    }

    private g() {
        AppMethodBeat.i(114260);
        AppMethodBeat.o(114260);
    }

    public final String bAl() {
        AppMethodBeat.i(114261);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mEc.size()) {
                stringBuffer.append("(");
                stringBuffer.append(((c) this.mEc.get(i2)).bAn());
                stringBuffer.append(")");
                if (i2 != this.mEc.size() - 1) {
                    stringBuffer.append(" AND ");
                }
                i = i2 + 1;
            } else {
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(114261);
                return stringBuffer2;
            }
        }
    }

    private static c aN(String str, boolean z) {
        int i = 0;
        AppMethodBeat.i(114262);
        if (z) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!com.tencent.mm.plugin.fts.a.g.u(str.charAt(i2))) {
                    z = false;
                    break;
                }
            }
        }
        c cVar = new c();
        b bVar;
        if (z) {
            com.tencent.mm.plugin.fts.a.b.b bVar2 = com.tencent.mm.plugin.fts.a.g.mDm;
            List arrayList = new ArrayList();
            char[] toCharArray = str.toLowerCase().toCharArray();
            while (i < toCharArray.length) {
                if (bVar2.mER.mES[toCharArray[i] - 97] == null) {
                    arrayList.clear();
                    break;
                }
                arrayList.add(String.valueOf(toCharArray[i]));
                i++;
            }
            if (arrayList.size() > 0) {
                bVar = new b();
                bVar.mEe = d.ShortPY;
                bVar.content = bo.c(arrayList, "​");
                bVar.mEf = arrayList;
                cVar.mEg.add(bVar);
            }
            List<List> Nj = com.tencent.mm.plugin.fts.a.g.mDm.Nj(str);
            if (Nj.size() > 0) {
                for (List list : Nj) {
                    if (list.size() > 0) {
                        b bVar3 = new b();
                        bVar3.mEe = d.FullPY;
                        bVar3.content = bo.c(list, "​");
                        bVar3.mEf = list;
                        cVar.mEg.add(bVar3);
                    }
                }
            }
            bVar = new b();
            bVar.mEe = d.OTHER;
            bVar.content = str;
            cVar.mEg.add(bVar);
        } else {
            bVar = new b();
            bVar.mEe = d.OTHER;
            bVar.content = str;
            cVar.mEg.add(bVar);
        }
        AppMethodBeat.o(114262);
        return cVar;
    }

    public static g aO(String str, boolean z) {
        AppMethodBeat.i(114263);
        g a = a(str, z, mEd);
        AppMethodBeat.o(114263);
        return a;
    }

    public static g a(String str, boolean z, a aVar) {
        AppMethodBeat.i(114264);
        g gVar = new g();
        gVar.mDY = str;
        gVar.mDZ = com.tencent.mm.plugin.fts.a.d.Nb(str);
        gVar.mEa = aVar.split(gVar.mDZ);
        gVar.mEb = aVar.Nh(gVar.mDZ);
        for (String aN : gVar.mEa) {
            gVar.mEc.add(aN(aN, z));
        }
        AppMethodBeat.o(114264);
        return gVar;
    }

    static {
        AppMethodBeat.i(114265);
        AppMethodBeat.o(114265);
    }
}
