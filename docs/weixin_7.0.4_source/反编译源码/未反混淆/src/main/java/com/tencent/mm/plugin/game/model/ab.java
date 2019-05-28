package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.game.d.at;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.p;
import java.io.IOException;

public final class ab extends x {
    private bi mXT;

    public ab(a aVar) {
        AppMethodBeat.i(111370);
        if (aVar == null) {
            this.mXT = new bi();
            AppMethodBeat.o(111370);
            return;
        }
        this.mXT = (bi) aVar;
        AppMethodBeat.o(111370);
    }

    public ab(byte[] bArr) {
        AppMethodBeat.i(111371);
        this.mXT = new bi();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111371);
            return;
        }
        try {
            this.mXT.parseFrom(bArr);
            AppMethodBeat.o(111371);
        } catch (IOException e) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", e.getMessage());
            AppMethodBeat.o(111371);
        }
    }

    public final p bEJ() {
        return this.mXT != null ? this.mXT.nch : null;
    }

    public final at bEK() {
        return this.mXT != null ? this.mXT.nci : null;
    }
}
