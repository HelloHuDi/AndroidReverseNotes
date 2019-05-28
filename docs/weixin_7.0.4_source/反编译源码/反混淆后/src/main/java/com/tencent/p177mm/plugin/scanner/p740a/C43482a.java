package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.a.a */
public final class C43482a {
    public int cIZ;
    public int cJa;
    public LinkedList<C34833a> fPL = new LinkedList();
    public String iconUrl;
    public int pZh;
    public String pZi;
    public boolean pZj;
    public String title;
    public int type = 1;

    /* renamed from: com.tencent.mm.plugin.scanner.a.a$a */
    public static class C34833a {
        public String content;
        public String desc = "";
        public String fjz = "";
        public String iconUrl = "";
        public String image = "";
        public String key;
        public String link = "";
        public String name = "";
        public String nickname = "";
        public String pZi;
        public String pZk = "";
        public String pZl = "";
        public String pZm = "";
        public String pZn = "";
        public String pZo = "";
        public String pZp = "";
        public String pZq = "";
        public String pZr = "";
        public String pZs;
        public String pZt;
        public int showType;
        public String thumburl = "";
        public int type;
        public String username = "";

        public C34833a(int i) {
            this.type = i;
        }
    }

    public C43482a() {
        AppMethodBeat.m2504i(80821);
        AppMethodBeat.m2505o(80821);
    }

    /* renamed from: l */
    public static LinkedList<C43482a> m77679l(Map<String, String> map, String str) {
        AppMethodBeat.m2504i(80822);
        LinkedList<C43482a> linkedList = new LinkedList();
        Object obj = null;
        int i = 0;
        while (i < 1000) {
            Object obj2;
            C43482a c43482a = new C43482a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            if (!C5046bo.isNullOrNil((String) map.get(str2 + ".$type"))) {
                c43482a.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            c43482a.title = C5046bo.nullAsNil((String) map.get(str2 + ".$title"));
            c43482a.iconUrl = C5046bo.nullAsNil((String) map.get(str2 + ".$iconurl"));
            c43482a.cIZ = C5046bo.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            c43482a.cJa = C5046bo.getInt((String) map.get(str2 + ".$iconheight"), 34);
            c43482a.pZi = C5046bo.nullAsNil((String) map.get(str2 + ".$referkey"));
            c43482a.pZh = C5046bo.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!C5046bo.isNullOrNil((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    obj = null;
                    C34833a m = C43482a.m77680m(map, str3);
                    if (m != null) {
                        linkedList2.add(m);
                        if (!C28889l.m45903a(m)) {
                            z2 = true;
                            i2++;
                            z = z2;
                        }
                    }
                    z2 = z;
                    i2++;
                    z = z2;
                } else if (obj != null) {
                    AppMethodBeat.m2505o(80822);
                    return linkedList;
                } else {
                    obj2 = 1;
                    c43482a.fPL = linkedList2;
                    c43482a.pZj = z;
                    linkedList.add(c43482a);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            c43482a.pZj = z;
            linkedList.add(c43482a);
            i++;
            obj = obj2;
        }
        AppMethodBeat.m2505o(80822);
        return linkedList;
    }

    /* renamed from: m */
    public static C34833a m77680m(Map<String, String> map, String str) {
        C34833a c34833a;
        AppMethodBeat.m2504i(80823);
        int i = C5046bo.getInt((String) map.get(str + ".$type"), 0);
        C34833a c34833a2 = new C34833a(i);
        c34833a2.type = i;
        c34833a2.pZo = C5046bo.nullAsNil((String) map.get(str + ".statid"));
        c34833a2.name = C5046bo.nullAsNil((String) map.get(str + ".name"));
        c34833a2.desc = C5046bo.nullAsNil((String) map.get(str + ".desc"));
        c34833a2.fjz = C5046bo.nullAsNil((String) map.get(str + ".digest"));
        c34833a2.showType = C5046bo.getInt((String) map.get(str + ".showtype"), 0);
        c34833a2.image = C5046bo.nullAsNil((String) map.get(str + ".image"));
        c34833a2.key = C5046bo.nullAsNil((String) map.get(str + ".$key"));
        c34833a2.iconUrl = C5046bo.nullAsNil((String) map.get(str + ".iconurl"));
        if (i == 1) {
            c34833a2.link = C5046bo.nullAsNil((String) map.get(str + ".link"));
            c34833a = c34833a2;
        } else if (i == 2) {
            c34833a2.username = C5046bo.nullAsNil((String) map.get(str + ".username"));
            c34833a2.nickname = C5046bo.nullAsNil((String) map.get(str + ".nickname"));
            c34833a2.pZs = C5046bo.nullAsNil((String) map.get(str + ".strbeforefollow"));
            c34833a2.pZt = C5046bo.nullAsNil((String) map.get(str + ".strafterfollow"));
            c34833a = c34833a2;
        } else if (i == 3) {
            c34833a2.thumburl = C5046bo.nullAsNil((String) map.get(str + ".thumburl"));
            c34833a2.link = C5046bo.nullAsNil((String) map.get(str + ".link"));
            c34833a = c34833a2;
        } else if (i == 4) {
            c34833a2.thumburl = C5046bo.nullAsNil((String) map.get(str + ".thumburl"));
            c34833a2.username = C5046bo.nullAsNil((String) map.get(str + ".username"));
            c34833a2.nickname = C5046bo.nullAsNil((String) map.get(str + ".nickname"));
            c34833a = c34833a2;
        } else {
            if (i == 5) {
                c34833a2.pZl = C5046bo.nullAsNil((String) map.get(str + ".wifiurl"));
                c34833a2.pZm = C5046bo.nullAsNil((String) map.get(str + ".wapurl"));
                c34833a2.pZn = C5046bo.nullAsNil((String) map.get(str + ".weburl"));
                if (C5046bo.isNullOrNil(c34833a2.pZl) && C5046bo.isNullOrNil(c34833a2.pZm) && C5046bo.isNullOrNil(c34833a2.pZn)) {
                    c34833a = null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    c34833a2.thumburl = C5046bo.nullAsNil((String) map.get(str + ".thumburl"));
                    c34833a2.pZk = C5046bo.nullAsNil((String) map.get(str + ".playurl"));
                    c34833a = c34833a2;
                } else if (i == 9) {
                    c34833a2.pZp = C5046bo.nullAsNil((String) map.get(str + ".productid"));
                    c34833a = c34833a2;
                } else if (i == 8) {
                    c34833a2.pZq = C5046bo.nullAsNil((String) map.get(str + ".cardext"));
                    c34833a2.pZr = C5046bo.nullAsNil((String) map.get(str + ".cardid"));
                    c34833a = c34833a2;
                } else if (i == 10) {
                    c34833a2.pZp = C5046bo.nullAsNil((String) map.get(str + ".id"));
                    c34833a = c34833a2;
                } else if (i == 12) {
                    c34833a2.thumburl = C5046bo.nullAsNil((String) map.get(str + ".image"));
                    c34833a2.link = C5046bo.nullAsNil((String) map.get(str + ".link"));
                    c34833a = c34833a2;
                } else if (i == 22) {
                    c34833a2.content = C5046bo.nullAsNil((String) map.get(str + ".content"));
                    c34833a2.link = C5046bo.nullAsNil((String) map.get(str + ".link"));
                    c34833a2.nickname = C5046bo.nullAsNil((String) map.get(str + ".nickname"));
                    c34833a2.thumburl = C5046bo.nullAsNil((String) map.get(str + ".image"));
                    c34833a = c34833a2;
                } else if (i == 21) {
                    c34833a2.pZi = C5046bo.nullAsNil((String) map.get(str + ".referkey"));
                    c34833a = c34833a2;
                } else {
                    c34833a2.link = C5046bo.nullAsNil((String) map.get(str + ".link"));
                }
            }
            c34833a = c34833a2;
        }
        AppMethodBeat.m2505o(80823);
        return c34833a;
    }
}
