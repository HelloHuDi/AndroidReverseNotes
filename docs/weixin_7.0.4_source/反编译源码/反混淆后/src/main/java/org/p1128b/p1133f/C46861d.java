package org.p1128b.p1133f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

/* renamed from: org.b.f.d */
public final class C46861d implements C16476c {
    private C44627a BZm = new C44627a();

    /* renamed from: org.b.f.d$a */
    static class C44627a {
        C44627a() {
        }
    }

    public C46861d() {
        AppMethodBeat.m2504i(77301);
        AppMethodBeat.m2505o(77301);
    }

    public final String getNonce() {
        AppMethodBeat.m2504i(77302);
        String valueOf = String.valueOf(C46861d.enn().longValue() + ((long) new Random().nextInt()));
        AppMethodBeat.m2505o(77302);
        return valueOf;
    }

    public final String enm() {
        AppMethodBeat.m2504i(77303);
        String valueOf = String.valueOf(C46861d.enn());
        AppMethodBeat.m2505o(77303);
        return valueOf;
    }

    private static Long enn() {
        AppMethodBeat.m2504i(77304);
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        AppMethodBeat.m2505o(77304);
        return valueOf;
    }
}
