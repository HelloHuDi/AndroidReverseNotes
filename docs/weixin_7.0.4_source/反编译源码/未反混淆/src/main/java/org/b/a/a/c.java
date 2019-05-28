package org.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.d.i;

public class c extends b {

    public static class a extends c {
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

    public final String b(i iVar) {
        AppMethodBeat.i(77234);
        String format = String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[]{iVar.token});
        AppMethodBeat.o(77234);
        return format;
    }
}
