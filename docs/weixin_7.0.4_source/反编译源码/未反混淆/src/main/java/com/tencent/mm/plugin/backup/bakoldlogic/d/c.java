package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;

public final class c {
    String eJM;
    public h eJN = null;
    bs jBd;
    g jBe = null;
    Boolean jBf = null;
    z jym;
    bd jyn;
    com.tencent.mm.plugin.messenger.foundation.a.a.h jyo;
    be jyp;
    com.tencent.mm.at.g jyq;
    d jyr;
    public k jys;
    t jyt;
    ag jyu;
    public com.tencent.mm.pluginsdk.model.app.k jyv;
    public i jyw;
    com.tencent.mm.pluginsdk.model.app.c jyx;
    public int uin = 0;

    public final z Ry() {
        AppMethodBeat.i(18025);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18025);
            throw bVar;
        }
        z zVar = this.jym;
        AppMethodBeat.o(18025);
        return zVar;
    }

    public final bd XM() {
        AppMethodBeat.i(18026);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18026);
            throw bVar;
        }
        bd bdVar = this.jyn;
        AppMethodBeat.o(18026);
        return bdVar;
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.h XO() {
        AppMethodBeat.i(18027);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18027);
            throw bVar;
        }
        com.tencent.mm.plugin.messenger.foundation.a.a.h hVar = this.jyo;
        AppMethodBeat.o(18027);
        return hVar;
    }

    public final be XR() {
        AppMethodBeat.i(18028);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18028);
            throw bVar;
        }
        be beVar = this.jyp;
        AppMethodBeat.o(18028);
        return beVar;
    }

    public final com.tencent.mm.at.g aUo() {
        AppMethodBeat.i(18029);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18029);
            throw bVar;
        }
        com.tencent.mm.at.g gVar = this.jyq;
        AppMethodBeat.o(18029);
        return gVar;
    }

    public final d aUp() {
        AppMethodBeat.i(18030);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18030);
            throw bVar;
        }
        d dVar = this.jyr;
        AppMethodBeat.o(18030);
        return dVar;
    }

    public final ag XV() {
        AppMethodBeat.i(18031);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18031);
            throw bVar;
        }
        ag agVar = this.jyu;
        AppMethodBeat.o(18031);
        return agVar;
    }

    public final t all() {
        AppMethodBeat.i(18032);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18032);
            throw bVar;
        }
        t tVar = this.jyt;
        AppMethodBeat.o(18032);
        return tVar;
    }

    public final String amg() {
        AppMethodBeat.i(18033);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18033);
            throw bVar;
        }
        String str = this.eJM + "voice/";
        AppMethodBeat.o(18033);
        return str;
    }

    public final String XY() {
        AppMethodBeat.i(18034);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18034);
            throw bVar;
        }
        String str = this.eJM + "voice2/";
        AppMethodBeat.o(18034);
        return str;
    }

    public final String Yb() {
        AppMethodBeat.i(18035);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18035);
            throw bVar;
        }
        String str = this.eJM + "emoji/";
        AppMethodBeat.o(18035);
        return str;
    }

    public final com.tencent.mm.pluginsdk.model.app.c aUq() {
        AppMethodBeat.i(18036);
        if (this.uin == 0) {
            b bVar = new b();
            AppMethodBeat.o(18036);
            throw bVar;
        }
        com.tencent.mm.pluginsdk.model.app.c cVar = this.jyx;
        AppMethodBeat.o(18036);
        return cVar;
    }

    public final void aVf() {
        AppMethodBeat.i(18037);
        ab.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", this.jBf, this.eJN, this.jBe, bo.dpG());
        if (this.jBf == null || this.jBf.booleanValue()) {
            if (this.eJN != null) {
                ab.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", this.eJN);
                this.eJN.closeDB();
                this.eJN = null;
            }
            if (this.jBe != null) {
                this.jBe.closeDB();
                this.jBe = null;
            }
            this.jBf = null;
            AppMethodBeat.o(18037);
            return;
        }
        this.jBf = null;
        AppMethodBeat.o(18037);
    }
}
