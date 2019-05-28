package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.c.i */
public final class C41914i {
    public String cdu;
    private Map<String, C32431a> cdv = new HashMap();
    public int versionCode;

    /* renamed from: com.tencent.mm.c.i$a */
    public static class C32431a {
        String cdw;
        public String cdx;
        public String cdy;
        public int size;
        public String url;

        public C32431a(String str, String str2, String str3, String str4, int i) {
            this.cdw = str;
            this.cdx = str2;
            this.cdy = str3;
            this.size = i;
            this.url = str4;
        }
    }

    public C41914i(String str, int i) {
        AppMethodBeat.m2504i(125693);
        if (str == null) {
            this.cdu = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.cdu = str;
        }
        this.versionCode = i;
        AppMethodBeat.m2505o(125693);
    }

    /* renamed from: a */
    public final void mo67557a(C32431a c32431a) {
        AppMethodBeat.m2504i(125694);
        this.cdv.put(c32431a.cdw, c32431a);
        AppMethodBeat.m2505o(125694);
    }

    /* renamed from: cN */
    public final C32431a mo67558cN(String str) {
        AppMethodBeat.m2504i(125695);
        C32431a c32431a = (C32431a) this.cdv.get(str);
        AppMethodBeat.m2505o(125695);
        return c32431a;
    }

    /* renamed from: AM */
    public final String mo67556AM() {
        AppMethodBeat.m2504i(125696);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.cdu, Integer.valueOf(this.cdv.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.cdv.entrySet()) {
            C32431a c32431a = (C32431a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{c32431a.cdw, c32431a.cdx, c32431a.cdy, c32431a.url, Integer.valueOf(c32431a.size)}));
        }
        stringBuilder.append("</patchupdate>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(125696);
        return stringBuilder2;
    }

    /* renamed from: cO */
    public static C41914i m74023cO(String str) {
        AppMethodBeat.m2504i(125697);
        Map z = C9210f.m16718z(str, "patchupdate");
        if (z == null) {
            AppMethodBeat.m2505o(125697);
            return null;
        }
        C41914i c41914i = new C41914i((String) z.get(".patchupdate.$base"), C41915j.getInt((String) z.get(".patchupdate.$versioncode"), 0));
        int i = C41915j.getInt((String) z.get(".patchupdate.$count"), 0);
        int i2 = 0;
        while (i2 < i) {
            int i3;
            String str2 = ".patchupdate.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            C32431a c32431a = new C32431a((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) z.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), C41915j.getInt((String) z.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString()), 0));
            if (c32431a.cdw == null || c32431a.cdx == null || c32431a.cdy == null || c32431a.url == null) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                c41914i.cdv.put(c32431a.cdw, c32431a);
            }
            i2++;
        }
        AppMethodBeat.m2505o(125697);
        return c41914i;
    }
}
