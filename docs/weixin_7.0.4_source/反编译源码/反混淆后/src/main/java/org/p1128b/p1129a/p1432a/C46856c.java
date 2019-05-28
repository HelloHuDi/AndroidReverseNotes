package org.p1128b.p1129a.p1432a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.p1128b.p1132d.C41173i;

/* renamed from: org.b.a.a.c */
public class C46856c extends C41170b {

    /* renamed from: org.b.a.a.c$a */
    public static class C31204a extends C46856c {
        public final String emW() {
            return "https://api.twitter.com/oauth/access_token";
        }

        public final String emV() {
            return "https://api.twitter.com/oauth/request_token";
        }
    }

    public String emW() {
        return "http://api.twitter.com/oauth/access_token";
    }

    public String emV() {
        return "http://api.twitter.com/oauth/request_token";
    }

    /* renamed from: b */
    public final String mo65770b(C41173i c41173i) {
        AppMethodBeat.m2504i(77234);
        String format = String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[]{c41173i.token});
        AppMethodBeat.m2505o(77234);
        return format;
    }
}
