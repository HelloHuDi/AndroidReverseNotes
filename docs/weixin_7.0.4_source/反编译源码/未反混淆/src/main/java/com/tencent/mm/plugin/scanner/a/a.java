package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public int cIZ;
    public int cJa;
    public LinkedList<a> fPL = new LinkedList();
    public String iconUrl;
    public int pZh;
    public String pZi;
    public boolean pZj;
    public String title;
    public int type = 1;

    public static class a {
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

        public a(int i) {
            this.type = i;
        }
    }

    public a() {
        AppMethodBeat.i(80821);
        AppMethodBeat.o(80821);
    }

    public static LinkedList<a> l(Map<String, String> map, String str) {
        AppMethodBeat.i(80822);
        LinkedList<a> linkedList = new LinkedList();
        Object obj = null;
        int i = 0;
        while (i < 1000) {
            Object obj2;
            a aVar = new a();
            String str2 = str + ".actionlist" + (i > 0 ? Integer.valueOf(i) : "");
            if (!bo.isNullOrNil((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = bo.nullAsNil((String) map.get(str2 + ".$title"));
            aVar.iconUrl = bo.nullAsNil((String) map.get(str2 + ".$iconurl"));
            aVar.cIZ = bo.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.cJa = bo.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.pZi = bo.nullAsNil((String) map.get(str2 + ".$referkey"));
            aVar.pZh = bo.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            int i2 = 0;
            while (i2 < 1000) {
                String str3 = str2 + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                if (!bo.isNullOrNil((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    obj = null;
                    a m = m(map, str3);
                    if (m != null) {
                        linkedList2.add(m);
                        if (!l.a(m)) {
                            z2 = true;
                            i2++;
                            z = z2;
                        }
                    }
                    z2 = z;
                    i2++;
                    z = z2;
                } else if (obj != null) {
                    AppMethodBeat.o(80822);
                    return linkedList;
                } else {
                    obj2 = 1;
                    aVar.fPL = linkedList2;
                    aVar.pZj = z;
                    linkedList.add(aVar);
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            aVar.pZj = z;
            linkedList.add(aVar);
            i++;
            obj = obj2;
        }
        AppMethodBeat.o(80822);
        return linkedList;
    }

    public static a m(Map<String, String> map, String str) {
        a aVar;
        AppMethodBeat.i(80823);
        int i = bo.getInt((String) map.get(str + ".$type"), 0);
        a aVar2 = new a(i);
        aVar2.type = i;
        aVar2.pZo = bo.nullAsNil((String) map.get(str + ".statid"));
        aVar2.name = bo.nullAsNil((String) map.get(str + ".name"));
        aVar2.desc = bo.nullAsNil((String) map.get(str + ".desc"));
        aVar2.fjz = bo.nullAsNil((String) map.get(str + ".digest"));
        aVar2.showType = bo.getInt((String) map.get(str + ".showtype"), 0);
        aVar2.image = bo.nullAsNil((String) map.get(str + ".image"));
        aVar2.key = bo.nullAsNil((String) map.get(str + ".$key"));
        aVar2.iconUrl = bo.nullAsNil((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar2.link = bo.nullAsNil((String) map.get(str + ".link"));
            aVar = aVar2;
        } else if (i == 2) {
            aVar2.username = bo.nullAsNil((String) map.get(str + ".username"));
            aVar2.nickname = bo.nullAsNil((String) map.get(str + ".nickname"));
            aVar2.pZs = bo.nullAsNil((String) map.get(str + ".strbeforefollow"));
            aVar2.pZt = bo.nullAsNil((String) map.get(str + ".strafterfollow"));
            aVar = aVar2;
        } else if (i == 3) {
            aVar2.thumburl = bo.nullAsNil((String) map.get(str + ".thumburl"));
            aVar2.link = bo.nullAsNil((String) map.get(str + ".link"));
            aVar = aVar2;
        } else if (i == 4) {
            aVar2.thumburl = bo.nullAsNil((String) map.get(str + ".thumburl"));
            aVar2.username = bo.nullAsNil((String) map.get(str + ".username"));
            aVar2.nickname = bo.nullAsNil((String) map.get(str + ".nickname"));
            aVar = aVar2;
        } else {
            if (i == 5) {
                aVar2.pZl = bo.nullAsNil((String) map.get(str + ".wifiurl"));
                aVar2.pZm = bo.nullAsNil((String) map.get(str + ".wapurl"));
                aVar2.pZn = bo.nullAsNil((String) map.get(str + ".weburl"));
                if (bo.isNullOrNil(aVar2.pZl) && bo.isNullOrNil(aVar2.pZm) && bo.isNullOrNil(aVar2.pZn)) {
                    aVar = null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar2.thumburl = bo.nullAsNil((String) map.get(str + ".thumburl"));
                    aVar2.pZk = bo.nullAsNil((String) map.get(str + ".playurl"));
                    aVar = aVar2;
                } else if (i == 9) {
                    aVar2.pZp = bo.nullAsNil((String) map.get(str + ".productid"));
                    aVar = aVar2;
                } else if (i == 8) {
                    aVar2.pZq = bo.nullAsNil((String) map.get(str + ".cardext"));
                    aVar2.pZr = bo.nullAsNil((String) map.get(str + ".cardid"));
                    aVar = aVar2;
                } else if (i == 10) {
                    aVar2.pZp = bo.nullAsNil((String) map.get(str + ".id"));
                    aVar = aVar2;
                } else if (i == 12) {
                    aVar2.thumburl = bo.nullAsNil((String) map.get(str + ".image"));
                    aVar2.link = bo.nullAsNil((String) map.get(str + ".link"));
                    aVar = aVar2;
                } else if (i == 22) {
                    aVar2.content = bo.nullAsNil((String) map.get(str + ".content"));
                    aVar2.link = bo.nullAsNil((String) map.get(str + ".link"));
                    aVar2.nickname = bo.nullAsNil((String) map.get(str + ".nickname"));
                    aVar2.thumburl = bo.nullAsNil((String) map.get(str + ".image"));
                    aVar = aVar2;
                } else if (i == 21) {
                    aVar2.pZi = bo.nullAsNil((String) map.get(str + ".referkey"));
                    aVar = aVar2;
                } else {
                    aVar2.link = bo.nullAsNil((String) map.get(str + ".link"));
                }
            }
            aVar = aVar2;
        }
        AppMethodBeat.o(80823);
        return aVar;
    }
}
