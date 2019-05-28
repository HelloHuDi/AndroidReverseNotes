package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class n {
    protected static int azs = 0;
    protected static String host = "";
    protected static String pua = "";
    protected static String userAgent = "weixin/android";

    public interface a {
        void ccp();
    }

    public static class b {
        int pub;
        Map<String, String> puc;
        Map<String, String> pud;
        d pue;

        public b(int i, Map<String, String> map, Map<String, String> map2, d dVar) {
            this.pub = i;
            this.puc = map;
            this.pud = map2;
            this.pue = dVar;
        }

        public final String toString() {
            AppMethodBeat.i(67958);
            String str = "Request method:" + this.pub + ", params:" + (this.puc != null ? this.puc : "") + ", cookie:" + (this.pud != null ? this.pud : "");
            AppMethodBeat.o(67958);
            return str;
        }
    }

    public static class d {
        String cBy;
        String filePath;

        public d(String str, String str2) {
            this.cBy = str;
            this.filePath = str2;
        }
    }

    public static class c {
        String content;
        Map<String, String> pud;
        int status = 0;

        public c(int i, Map<String, String> map, String str) {
            this.status = i;
            this.pud = map;
            this.content = str;
        }

        public final String toString() {
            AppMethodBeat.i(67959);
            String str = "Response status:" + this.status + ", cookie:" + (this.pud != null ? this.pud : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.o(67959);
            return str;
        }
    }

    public abstract c a(String str, String str2, b bVar, a aVar);

    public abstract void cancel();

    public static void setHost(String str) {
        af.host = str;
    }

    public static void setUserAgent(String str) {
        af.userAgent = str;
    }

    public static void Vg(String str) {
        pua = str;
    }

    protected static String f(String str, String str2, Map<String, String> map) {
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
            stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str3, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bo.nullAsNil((String) map.get(str3)), ProtocolPackage.ServerEncoding));
            obj = null;
        }
    }

    protected static String W(Map<String, String> map) {
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

    protected static Map<String, String> Vh(String str) {
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
