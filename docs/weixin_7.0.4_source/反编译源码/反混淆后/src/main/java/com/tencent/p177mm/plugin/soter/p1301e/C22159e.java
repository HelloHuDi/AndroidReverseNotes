package com.tencent.p177mm.plugin.soter.p1301e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.p663a.p1107c.C16167a;
import com.tencent.soter.p663a.p664g.C30960j;
import com.tencent.soter.p663a.p664g.C44471e;

/* renamed from: com.tencent.mm.plugin.soter.e.e */
public final class C22159e extends C30960j {
    public C22159e(Context context, C44471e c44471e) {
        super(context, c44471e);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: b */
    public final void mo37724b(String str, int[] iArr) {
        AppMethodBeat.m2504i(59361);
        C4990ab.m7418v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
        for (int i : iArr) {
            Object cvT;
            if (i == 1 && C1720g.m3534RN().mo5161QY()) {
                cvT = C4104m.cvT();
            } else {
                cvT = String.format("SoterAuthKey_salt%s_scene%d", new Object[]{C24321g.nullAsNil(str), Integer.valueOf(i)});
            }
            C4990ab.m7417i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", Integer.valueOf(i), cvT);
            C16167a.dRe().dRg().put(i, cvT);
        }
        AppMethodBeat.m2505o(59361);
    }
}
