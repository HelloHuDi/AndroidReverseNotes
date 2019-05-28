package com.tencent.p177mm.plugin.p436hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1269u;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.plugin.p436hp.p1273d.C21071c;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C12240b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C46027a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tinker.lib.p1577b.C46816a;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.hp.tinker.b */
public final class C43215b extends C46816a {
    private final int nuc;

    public C43215b(Context context) {
        super(context);
        AppMethodBeat.m2504i(90628);
        this.nuc = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        C5952a.m9284i("Tinker.TinkerPatchListener", "application maxMemory:" + this.nuc, new Object[0]);
        AppMethodBeat.m2505o(90628);
    }

    /* renamed from: eI */
    public final int mo65729eI(String str, String str2) {
        String property;
        boolean z = false;
        AppMethodBeat.m2504i(90629);
        File file = new File(str);
        C5952a.m9284i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.m9372ar(file)));
        int eI = super.mo65729eI(str, str2);
        if (eI == 0) {
            eI = this.nuc < 45 ? -23 : !C21071c.bGz() ? -21 : 0;
        }
        if (eI == 0) {
            C31097a.m50180iX(this.context);
            if (eI == 0) {
                Properties S = ShareTinkerInternals.m9408S(file);
                if (S == null) {
                    eI = -24;
                } else {
                    property = S.getProperty("patch.basepack.client.ver");
                    C5952a.m9284i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:".concat(String.valueOf(property)), new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(C1760a.CLIENT_VERSION)) {
                        eI = -25;
                    }
                }
            }
        }
        if (eI == 0 && ShareTinkerInternals.dSp() && C1269u.m2727b(new Throwable().getStackTrace())) {
            eI = -26;
        }
        Properties S2 = C21071c.m32376S(file);
        if (S2 != null) {
            int i;
            property = C5058f.CLIENT_VERSION;
            String property2 = S2.getProperty("patch.client.ver");
            String property3 = S2.getProperty("NEW_TINKER_ID");
            int i2 = C12240b.SCENE_CHECK.value;
            if (eI == 0) {
                i = C46027a.SUCCESS.value;
            } else {
                i = C46027a.FAILED.value;
            }
            C46028b.m85596e(property, property2, property3, i2, i);
        } else {
            C4990ab.m7416i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
        }
        if (eI == 0) {
            z = true;
        }
        C46028b.m85599ie(z);
        AppMethodBeat.m2505o(90629);
        return eI;
    }
}
