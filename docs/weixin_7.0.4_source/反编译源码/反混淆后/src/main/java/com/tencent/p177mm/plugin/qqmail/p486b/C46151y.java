package com.tencent.p177mm.plugin.qqmail.p486b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.qqmail.b.y */
public final class C46151y {
    C39543x puW;

    public C46151y() {
        AppMethodBeat.m2504i(68027);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(282625, (Object) "");
        try {
            this.puW = new C39543x();
            this.puW.parseFrom(Base64.decode(str, 0));
            AppMethodBeat.m2505o(68027);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.puW = new C39543x();
            AppMethodBeat.m2505o(68027);
        }
    }

    /* renamed from: Vl */
    public final void mo74103Vl(String str) {
        AppMethodBeat.m2504i(68028);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ShareMailInfoMgr", "remove info fail, info is null");
            AppMethodBeat.m2505o(68028);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.puW.oof.size()) {
                break;
            } else if (((C46150w) this.puW.oof.get(i2)).ptN.equals(str)) {
                this.puW.oof.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        save();
        AppMethodBeat.m2505o(68028);
    }

    /* renamed from: Vm */
    static void m86146Vm(String str) {
        AppMethodBeat.m2504i(68029);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju("qqmail");
        c7620bi.mo14775eJ(C1829bf.m3756oC("qqmail"));
        c7620bi.mo14781hO(0);
        c7620bi.setContent(String.format(C4996ah.getContext().getString(C25738R.string.e3_), new Object[]{str}));
        c7620bi.setType(1);
        c7620bi.setStatus(3);
        C4990ab.m7411d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", Long.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi)));
        AppMethodBeat.m2505o(68029);
    }

    /* Access modifiers changed, original: final */
    public final void save() {
        AppMethodBeat.m2504i(68030);
        try {
            C4990ab.m7411d("MicroMsg.ShareMailInfoMgr", "save %s", Base64.encodeToString(this.puW.toByteArray(), 0));
            C1720g.m3536RP().mo5239Ry().set(282625, r0);
            AppMethodBeat.m2505o(68030);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.ShareMailInfoMgr", "save to config fail");
            AppMethodBeat.m2505o(68030);
        }
    }
}
