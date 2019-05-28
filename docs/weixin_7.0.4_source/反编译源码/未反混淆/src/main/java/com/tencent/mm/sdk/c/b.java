package com.tencent.mm.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class b {
    protected final String userAgent = "weixin/android";

    public static class b {
        public int azs;
        public String host;
        public int pub = 0;
        public Map<String, String> puc = null;
        public Map<String, String> pud = null;
        public String uri;
        public String xxO;
        public a xxP = null;

        public final String getUrl() {
            AppMethodBeat.i(51969);
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
                stringBuilder.append(this.xxO + this.host);
            }
            stringBuilder.append(this.uri);
            String stringBuilder2;
            if (this.puc == null) {
                stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(51969);
                return stringBuilder2;
            }
            stringBuilder.append('?');
            Object obj = 1;
            Iterator it = this.puc.keySet().iterator();
            while (true) {
                Object obj2 = obj;
                if (it.hasNext()) {
                    stringBuilder2 = (String) it.next();
                    stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(stringBuilder2, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(bo.nullAsNil((String) this.puc.get(stringBuilder2)), ProtocolPackage.ServerEncoding));
                    obj = null;
                } else {
                    stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.o(51969);
                    return stringBuilder2;
                }
            }
        }

        public final String toString() {
            AppMethodBeat.i(51970);
            String url;
            try {
                url = getUrl();
                AppMethodBeat.o(51970);
                return url;
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
                url = "";
                AppMethodBeat.o(51970);
                return url;
            }
        }
    }

    public static class a {
        public String filePath;
    }

    public static class c {
        public String content;
        public Map<String, String> pud;
        public int status;
        public a xxP;

        public c(String str) {
            this.status = 0;
            this.status = 0;
            this.pud = null;
            this.content = str;
        }

        public String toString() {
            AppMethodBeat.i(51971);
            String str = "Response status:" + this.status + ", cookie:" + (this.pud != null ? this.pud : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.o(51971);
            return str;
        }

        public void onComplete() {
        }
    }

    public abstract void a(b bVar, c cVar);

    public final void a(final b bVar, final c cVar, final ak akVar) {
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(51968);
                b.this.a(bVar, cVar);
                if (akVar != null) {
                    akVar.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(51967);
                            cVar.onComplete();
                            AppMethodBeat.o(51967);
                        }
                    });
                    AppMethodBeat.o(51968);
                    return;
                }
                cVar.onComplete();
                AppMethodBeat.o(51968);
            }
        }, getClass().getName());
    }

    public static Map<String, String> Vh(String str) {
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
