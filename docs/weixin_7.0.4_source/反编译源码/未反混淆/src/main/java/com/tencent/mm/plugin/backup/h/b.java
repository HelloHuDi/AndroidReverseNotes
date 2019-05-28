package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.cd.h;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;

public final class b {
    private String eJM;
    public h eJN = null;
    private z jym;
    private bd jyn;
    private com.tencent.mm.plugin.messenger.foundation.a.a.h jyo;
    private be jyp;
    private g jyq;
    private d jyr;
    public k jys;
    private t jyt;
    private ag jyu;
    public com.tencent.mm.pluginsdk.model.app.k jyv;
    public i jyw;
    private c jyx;
    com.tencent.mm.plugin.messenger.foundation.a.a.c jyy;
    public int uin = 0;

    public final void bF(String str, int i) {
        AppMethodBeat.i(17687);
        ab.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", str, Integer.valueOf(i), bo.dpG());
        this.uin = i;
        this.eJM = str;
        aw.ZK();
        this.eJN = com.tencent.mm.model.c.Ru();
        aw.ZK();
        this.jym = com.tencent.mm.model.c.Ry();
        aw.ZK();
        this.jyn = com.tencent.mm.model.c.XM();
        aw.ZK();
        this.jyp = com.tencent.mm.model.c.XR();
        aw.ZK();
        this.jyo = com.tencent.mm.model.c.XO();
        aw.ZK();
        this.jys = com.tencent.mm.model.c.XU();
        this.jyq = o.ahl();
        this.jyr = j.getEmojiStorageMgr().xYn;
        this.jyu = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV();
        this.jyt = com.tencent.mm.modelvideo.o.all();
        this.jyv = a.bYK();
        this.jyw = a.bYJ();
        this.jyx = a.aUq();
        aw.ZK();
        this.jyy = com.tencent.mm.model.c.Yo();
        AppMethodBeat.o(17687);
    }

    public final z Ry() {
        AppMethodBeat.i(17688);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17688);
            throw bVar;
        }
        z zVar = this.jym;
        AppMethodBeat.o(17688);
        return zVar;
    }

    public final bd XM() {
        AppMethodBeat.i(17689);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17689);
            throw bVar;
        }
        bd bdVar = this.jyn;
        AppMethodBeat.o(17689);
        return bdVar;
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.h XO() {
        AppMethodBeat.i(17690);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17690);
            throw bVar;
        }
        com.tencent.mm.plugin.messenger.foundation.a.a.h hVar = this.jyo;
        AppMethodBeat.o(17690);
        return hVar;
    }

    public final be XR() {
        AppMethodBeat.i(17691);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17691);
            throw bVar;
        }
        be beVar = this.jyp;
        AppMethodBeat.o(17691);
        return beVar;
    }

    public final g aUo() {
        AppMethodBeat.i(17692);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17692);
            throw bVar;
        }
        g gVar = this.jyq;
        AppMethodBeat.o(17692);
        return gVar;
    }

    public final d aUp() {
        AppMethodBeat.i(17693);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17693);
            throw bVar;
        }
        d dVar = this.jyr;
        AppMethodBeat.o(17693);
        return dVar;
    }

    public final ag XV() {
        AppMethodBeat.i(17694);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17694);
            throw bVar;
        }
        ag agVar = this.jyu;
        AppMethodBeat.o(17694);
        return agVar;
    }

    public final t all() {
        AppMethodBeat.i(17695);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17695);
            throw bVar;
        }
        t tVar = this.jyt;
        AppMethodBeat.o(17695);
        return tVar;
    }

    public final String amg() {
        AppMethodBeat.i(17696);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17696);
            throw bVar;
        }
        String str = this.eJM + "voice/";
        AppMethodBeat.o(17696);
        return str;
    }

    public final String XY() {
        AppMethodBeat.i(17697);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17697);
            throw bVar;
        }
        String str = this.eJM + "voice2/";
        AppMethodBeat.o(17697);
        return str;
    }

    public final String Yb() {
        AppMethodBeat.i(17698);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17698);
            throw bVar;
        }
        String str = this.eJM + "emoji/";
        AppMethodBeat.o(17698);
        return str;
    }

    public final c aUq() {
        AppMethodBeat.i(17699);
        if (this.uin == 0) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(17699);
            throw bVar;
        }
        c cVar = this.jyx;
        AppMethodBeat.o(17699);
        return cVar;
    }
}
