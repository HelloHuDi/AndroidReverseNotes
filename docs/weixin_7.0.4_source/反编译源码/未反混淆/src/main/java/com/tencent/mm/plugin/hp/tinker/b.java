package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.u;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b extends a {
    private final int nuc;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(90628);
        this.nuc = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.nuc, new Object[0]);
        AppMethodBeat.o(90628);
    }

    public final int eI(String str, String str2) {
        String property;
        boolean z = false;
        AppMethodBeat.i(90629);
        File file = new File(str);
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.ar(file)));
        int eI = super.eI(str, str2);
        if (eI == 0) {
            eI = this.nuc < 45 ? -23 : !c.bGz() ? -21 : 0;
        }
        if (eI == 0) {
            com.tencent.tinker.lib.e.a.iX(this.context);
            if (eI == 0) {
                Properties S = ShareTinkerInternals.S(file);
                if (S == null) {
                    eI = -24;
                } else {
                    property = S.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:".concat(String.valueOf(property)), new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(com.tencent.mm.loader.j.a.CLIENT_VERSION)) {
                        eI = -25;
                    }
                }
            }
        }
        if (eI == 0 && ShareTinkerInternals.dSp() && u.b(new Throwable().getStackTrace())) {
            eI = -26;
        }
        Properties S2 = c.S(file);
        if (S2 != null) {
            int i;
            property = f.CLIENT_VERSION;
            String property2 = S2.getProperty("patch.client.ver");
            String property3 = S2.getProperty("NEW_TINKER_ID");
            int i2 = com.tencent.mm.plugin.hp.b.b.b.SCENE_CHECK.value;
            if (eI == 0) {
                i = com.tencent.mm.plugin.hp.b.b.a.SUCCESS.value;
            } else {
                i = com.tencent.mm.plugin.hp.b.b.a.FAILED.value;
            }
            com.tencent.mm.plugin.hp.b.b.e(property, property2, property3, i2, i);
        } else {
            ab.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
        }
        if (eI == 0) {
            z = true;
        }
        com.tencent.mm.plugin.hp.b.b.ie(z);
        AppMethodBeat.o(90629);
        return eI;
    }
}
