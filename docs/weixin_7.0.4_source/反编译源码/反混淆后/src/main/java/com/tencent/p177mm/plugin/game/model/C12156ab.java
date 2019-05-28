package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.game.p731d.C20948bi;
import com.tencent.p177mm.plugin.game.p731d.C28199p;
import com.tencent.p177mm.plugin.game.p731d.C39187at;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.game.model.ab */
public final class C12156ab extends C39216x {
    private C20948bi mXT;

    public C12156ab(C1331a c1331a) {
        AppMethodBeat.m2504i(111370);
        if (c1331a == null) {
            this.mXT = new C20948bi();
            AppMethodBeat.m2505o(111370);
            return;
        }
        this.mXT = (C20948bi) c1331a;
        AppMethodBeat.m2505o(111370);
    }

    public C12156ab(byte[] bArr) {
        AppMethodBeat.m2504i(111371);
        this.mXT = new C20948bi();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(111371);
            return;
        }
        try {
            this.mXT.parseFrom(bArr);
            AppMethodBeat.m2505o(111371);
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", e.getMessage());
            AppMethodBeat.m2505o(111371);
        }
    }

    public final C28199p bEJ() {
        return this.mXT != null ? this.mXT.nch : null;
    }

    public final C39187at bEK() {
        return this.mXT != null ? this.mXT.nci : null;
    }
}
