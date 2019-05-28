package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.IOException;

public final class y {
    x puW;

    public y() {
        AppMethodBeat.i(68027);
        String str = (String) g.RP().Ry().get(282625, (Object) "");
        try {
            this.puW = new x();
            this.puW.parseFrom(Base64.decode(str, 0));
            AppMethodBeat.o(68027);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            ab.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.puW = new x();
            AppMethodBeat.o(68027);
        }
    }

    public final void Vl(String str) {
        AppMethodBeat.i(68028);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            AppMethodBeat.o(68028);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.puW.oof.size()) {
                break;
            } else if (((w) this.puW.oof.get(i2)).ptN.equals(str)) {
                this.puW.oof.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        save();
        AppMethodBeat.o(68028);
    }

    static void Vm(String str) {
        AppMethodBeat.i(68029);
        bi biVar = new bi();
        biVar.ju("qqmail");
        biVar.eJ(bf.oC("qqmail"));
        biVar.hO(0);
        biVar.setContent(String.format(ah.getContext().getString(R.string.e3_), new Object[]{str}));
        biVar.setType(1);
        biVar.setStatus(3);
        ab.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", Long.valueOf(((j) g.K(j.class)).bOr().Z(biVar)));
        AppMethodBeat.o(68029);
    }

    /* Access modifiers changed, original: final */
    public final void save() {
        AppMethodBeat.i(68030);
        try {
            ab.d("MicroMsg.ShareMailInfoMgr", "save %s", Base64.encodeToString(this.puW.toByteArray(), 0));
            g.RP().Ry().set(282625, r0);
            AppMethodBeat.o(68030);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            ab.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
            AppMethodBeat.o(68030);
        }
    }
}
