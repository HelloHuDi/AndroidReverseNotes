package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.qqmail.b.n */
public abstract class C43403n {
    protected static int azs = 0;
    protected static String host = "";
    protected static String pua = "";
    protected static String userAgent = "weixin/android";

    /* renamed from: com.tencent.mm.plugin.qqmail.b.n$a */
    public interface C28742a {
        void ccp();
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.n$b */
    public static class C39538b {
        int pub;
        Map<String, String> puc;
        Map<String, String> pud;
        C39539d pue;

        public C39538b(int i, Map<String, String> map, Map<String, String> map2, C39539d c39539d) {
            this.pub = i;
            this.puc = map;
            this.pud = map2;
            this.pue = c39539d;
        }

        public final String toString() {
            AppMethodBeat.m2504i(67958);
            String str = "Request method:" + this.pub + ", params:" + (this.puc != null ? this.puc : "") + ", cookie:" + (this.pud != null ? this.pud : "");
            AppMethodBeat.m2505o(67958);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.n$d */
    public static class C39539d {
        String cBy;
        String filePath;

        public C39539d(String str, String str2) {
            this.cBy = str;
            this.filePath = str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.b.n$c */
    public static class C43402c {
        String content;
        Map<String, String> pud;
        int status = 0;

        public C43402c(int i, Map<String, String> map, String str) {
            this.status = i;
            this.pud = map;
            this.content = str;
        }

        public final String toString() {
            AppMethodBeat.m2504i(67959);
            String str = "Response status:" + this.status + ", cookie:" + (this.pud != null ? this.pud : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.m2505o(67959);
            return str;
        }
    }

    /* renamed from: a */
    public abstract C43402c mo36997a(String str, String str2, C39538b c39538b, C28742a c28742a);

    public abstract void cancel();

    public static void setHost(String str) {
        C46146af.host = str;
    }

    public static void setUserAgent(String str) {
        C46146af.userAgent = str;
    }

    /* renamed from: Vg */
    public static void m77460Vg(String str) {
        pua = str;
    }

    /* renamed from: f */
    protected static String m77463f(String str, String str2, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(str2.startsWith("http://") || str2.startsWith("https://"))) {
            stringBuilder.append(str + host);
        }
        stringBuilder.append(str2);
        if (map == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        Iterator it = map.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str3 = (String) it.next();
            stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(C5046bo.nullAsNil((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
    }

    /* renamed from: W */
    protected static String m77462W(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        Iterator it = map.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str = (String) it.next();
            stringBuilder.append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode((String) map.get(str), ProtocolPackage.ServerEncoding));
            i = i2 + 1;
            if (map.size() > i) {
                stringBuilder.append("; ");
            }
        }
    }

    /* renamed from: Vh */
    protected static Map<String, String> m77461Vh(String str) {
        HashMap hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
