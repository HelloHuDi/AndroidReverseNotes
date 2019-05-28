package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    public String cdu;
    private Map<String, a> cdv = new HashMap();
    public int versionCode;

    public static class a {
        String cdw;
        public String cdx;
        public String cdy;
        public int size;
        public String url;

        public a(String str, String str2, String str3, String str4, int i) {
            this.cdw = str;
            this.cdx = str2;
            this.cdy = str3;
            this.size = i;
            this.url = str4;
        }
    }

    public i(String str, int i) {
        AppMethodBeat.i(125693);
        if (str == null) {
            this.cdu = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.cdu = str;
        }
        this.versionCode = i;
        AppMethodBeat.o(125693);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125694);
        this.cdv.put(aVar.cdw, aVar);
        AppMethodBeat.o(125694);
    }

    public final a cN(String str) {
        AppMethodBeat.i(125695);
        a aVar = (a) this.cdv.get(str);
        AppMethodBeat.o(125695);
        return aVar;
    }

    public final String AM() {
        AppMethodBeat.i(125696);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.cdu, Integer.valueOf(this.cdv.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.cdv.entrySet()) {
            a aVar = (a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{aVar.cdw, aVar.cdx, aVar.cdy, aVar.url, Integer.valueOf(aVar.size)}));
        }
        stringBuilder.append("</patchupdate>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(125696);
        return stringBuilder2;
    }

    public static i cO(String str) {
        AppMethodBeat.i(125697);
        Map z = f.z(str, "patchupdate");
        if (z == null) {
            AppMethodBeat.o(125697);
            return null;
        }
        i iVar = new i((String) z.get(".patchupdate.$base"), j.getInt((String) z.get(".patchupdate.$versioncode"), 0));
        int i = j.getInt((String) z.get(".patchupdate.$count"), 0);
        int i2 = 0;
        while (i2 < i) {
            int i3;
            String str2 = ".patchupdate.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            a aVar = new a((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.getInt((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString()), 0));
            if (aVar.cdw == null || aVar.cdx == null || aVar.cdy == null || aVar.url == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                iVar.cdv.put(aVar.cdw, aVar);
            }
            i2++;
        }
        AppMethodBeat.o(125697);
        return iVar;
    }
}
