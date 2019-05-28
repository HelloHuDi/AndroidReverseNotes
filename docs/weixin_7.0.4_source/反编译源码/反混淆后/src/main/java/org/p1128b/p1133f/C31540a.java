package org.p1128b.p1133f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.p1128b.p1130b.C46857d;
import org.p1128b.p1134g.C16477a;
import org.p1128b.p1134g.C36644c;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.f.a */
public final class C31540a implements C31208b {
    /* renamed from: aL */
    public final String mo50990aL(String str, String str2, String str3) {
        AppMethodBeat.m2504i(77300);
        try {
            C46862d.m89099jn(str, "Base string cant be null or empty string");
            C46862d.m89099jn(str2, "Api secret cant be null or empty string");
            SecretKeySpec secretKeySpec = new SecretKeySpec((C36644c.encode(str2) + '&' + C36644c.encode(str3)).getBytes("UTF-8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            String replace = new String(C16477a.m25283cQ(instance.doFinal(str.getBytes("UTF-8")))).replace(IOUtils.LINE_SEPARATOR_WINDOWS, "");
            AppMethodBeat.m2505o(77300);
            return replace;
        } catch (Exception e) {
            C46857d c46857d = new C46857d(str, e);
            AppMethodBeat.m2505o(77300);
            throw c46857d;
        }
    }

    public final String enl() {
        return "HMAC-SHA1";
    }
}
