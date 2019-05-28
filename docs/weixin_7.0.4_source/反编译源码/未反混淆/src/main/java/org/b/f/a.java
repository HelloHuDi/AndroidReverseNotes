package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.b.g.c;
import org.b.g.d;

public final class a implements b {
    public final String aL(String str, String str2, String str3) {
        AppMethodBeat.i(77300);
        try {
            d.jn(str, "Base string cant be null or empty string");
            d.jn(str2, "Api secret cant be null or empty string");
            SecretKeySpec secretKeySpec = new SecretKeySpec((c.encode(str2) + '&' + c.encode(str3)).getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            String replace = new String(org.b.g.a.cQ(instance.doFinal(str.getBytes("UTF-8")))).replace(IOUtils.LINE_SEPARATOR_WINDOWS, "");
            AppMethodBeat.o(77300);
            return replace;
        } catch (Exception e) {
            org.b.b.d dVar = new org.b.b.d(str, e);
            AppMethodBeat.o(77300);
            throw dVar;
        }
    }

    public final String enl() {
        return "HMAC-SHA1";
    }
}
