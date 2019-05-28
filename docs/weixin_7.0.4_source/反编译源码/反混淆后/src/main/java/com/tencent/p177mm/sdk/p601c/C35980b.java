package com.tencent.p177mm.sdk.p601c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.sdk.c.b */
public abstract class C35980b {
    protected final String userAgent = "weixin/android";

    /* renamed from: com.tencent.mm.sdk.c.b$b */
    public static class C35981b {
        public int azs;
        public String host;
        public int pub = 0;
        public Map<String, String> puc = null;
        public Map<String, String> pud = null;
        public String uri;
        public String xxO;
        public C35982a xxP = null;

        public final String getUrl() {
            AppMethodBeat.m2504i(51969);
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
                stringBuilder.append(this.xxO + this.host);
            }
            stringBuilder.append(this.uri);
            String stringBuilder2;
            if (this.puc == null) {
                stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.m2505o(51969);
                return stringBuilder2;
            }
            stringBuilder.append('?');
            Object obj = 1;
            Iterator it = this.puc.keySet().iterator();
            while (true) {
                Object obj2 = obj;
                if (it.hasNext()) {
                    stringBuilder2 = (String) it.next();
                    stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(stringBuilder2, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(C5046bo.nullAsNil((String) this.puc.get(stringBuilder2)), ProtocolPackage.ServerEncoding));
                    obj = null;
                } else {
                    stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(51969);
                    return stringBuilder2;
                }
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(51970);
            String url;
            try {
                url = getUrl();
                AppMethodBeat.m2505o(51970);
                return url;
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
                url = "";
                AppMethodBeat.m2505o(51970);
                return url;
            }
        }
    }

    /* renamed from: com.tencent.mm.sdk.c.b$a */
    public static class C35982a {
        public String filePath;
    }

    /* renamed from: com.tencent.mm.sdk.c.b$c */
    public static class C35983c {
        public String content;
        public Map<String, String> pud;
        public int status;
        public C35982a xxP;

        public C35983c(String str) {
            this.status = 0;
            this.status = 0;
            this.pud = null;
            this.content = str;
        }

        public String toString() {
            AppMethodBeat.m2504i(51971);
            String str = "Response status:" + this.status + ", cookie:" + (this.pud != null ? this.pud : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
            AppMethodBeat.m2505o(51971);
            return str;
        }

        public void onComplete() {
        }
    }

    /* renamed from: a */
    public abstract void mo56715a(C35981b c35981b, C35983c c35983c);

    /* renamed from: a */
    public final void mo56716a(final C35981b c35981b, final C35983c c35983c, final C7306ak c7306ak) {
        C7305d.post(new Runnable() {

            /* renamed from: com.tencent.mm.sdk.c.b$1$1 */
            class C48851 implements Runnable {
                C48851() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(51967);
                    c35983c.onComplete();
                    AppMethodBeat.m2505o(51967);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(51968);
                C35980b.this.mo56715a(c35981b, c35983c);
                if (c7306ak != null) {
                    c7306ak.post(new C48851());
                    AppMethodBeat.m2505o(51968);
                    return;
                }
                c35983c.onComplete();
                AppMethodBeat.m2505o(51968);
            }
        }, getClass().getName());
    }

    /* renamed from: Vh */
    public static Map<String, String> m59186Vh(String str) {
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
