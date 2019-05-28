package com.tencent.p177mm.plugin.p930c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C36003g;
import java.util.HashMap;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.c.a */
public final class C20118a implements C1669a, C1673e, C6617c {
    private static final HashMap<Integer, C1366d> eaA;
    private static C20118a gLq;
    private C36003g gLr;

    /* renamed from: com.tencent.mm.plugin.c.a$1 */
    static class C112671 implements C1366d {
        C112671() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C36003g.fnj;
        }
    }

    private C20118a() {
    }

    public static synchronized C20118a ask() {
        C20118a c20118a;
        synchronized (C20118a.class) {
            AppMethodBeat.m2504i(79047);
            if (gLq == null) {
                gLq = new C20118a();
            }
            c20118a = gLq;
            AppMethodBeat.m2505o(79047);
        }
        return c20118a;
    }

    /* renamed from: Yn */
    public final C36003g mo35364Yn() {
        AppMethodBeat.m2504i(79048);
        C1720g.m3534RN().mo5159QU();
        C36003g c36003g = this.gLr;
        AppMethodBeat.m2505o(79048);
        return c36003g;
    }

    /* renamed from: x */
    public static boolean m31114x(CharSequence charSequence) {
        AppMethodBeat.m2504i(79049);
        if (C5046bo.m7519ac(charSequence) || !C1720g.m3534RN().eJb) {
            AppMethodBeat.m2505o(79049);
            return false;
        }
        try {
            String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ClipProtectPattern");
            if (!C5046bo.isNullOrNil(value)) {
                String str = new String(Base64.decode(value, 0));
                if (!C5046bo.isNullOrNil(str) && Pattern.compile(str).matcher(charSequence).matches()) {
                    AppMethodBeat.m2505o(79049);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(79049);
        return false;
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(79050);
        this.gLr = new C36003g(c7480h);
        AppMethodBeat.m2505o(79050);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }

    static {
        AppMethodBeat.m2504i(79051);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("AddContactAntispamTicket".hashCode()), new C112671());
        AppMethodBeat.m2505o(79051);
    }
}
