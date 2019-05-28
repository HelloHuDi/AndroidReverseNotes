package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class k {
    Set<String> kVY;
    Set<String> kVZ;
    Set<String> kWa;
    c kWb = new c<vh>() {
        {
            AppMethodBeat.i(53078);
            this.xxI = vh.class.getName().hashCode();
            AppMethodBeat.o(53078);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53079);
            vh vhVar = (vh) bVar;
            switch (vhVar.cSo.cuy) {
                case 1:
                    k.this.kVY.addAll(bo.P(vhVar.cSo.cSp));
                    k.this.kVZ.addAll(k.this.kVY);
                    k.this.bkp();
                    break;
            }
            AppMethodBeat.o(53079);
            return false;
        }
    };
    c kWc = new c<cx>() {
        {
            AppMethodBeat.i(53080);
            this.xxI = cx.class.getName().hashCode();
            AppMethodBeat.o(53080);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53081);
            cx cxVar = (cx) bVar;
            if (k.this.kVY.contains(cxVar.cvY.cvZ)) {
                k.this.kWa.remove(cxVar.cvY.cvZ);
                if (cxVar.cvY.success) {
                    ab.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", cxVar.cvY.cvZ);
                    j.getEmojiStorageMgr().xYo.aqd(cxVar.cvY.cvZ);
                    g.RO().eJo.a(new q(cxVar.cvY.cvZ, 2), 0);
                } else {
                    ab.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", cxVar.cvY.cvZ);
                }
                k.this.bkp();
            }
            AppMethodBeat.o(53081);
            return false;
        }
    };

    public k() {
        AppMethodBeat.i(53082);
        a.xxA.c(this.kWb);
        a.xxA.c(this.kWc);
        this.kVY = Collections.synchronizedSet(new HashSet());
        this.kVZ = Collections.synchronizedSet(new HashSet());
        this.kWa = Collections.synchronizedSet(new HashSet());
        AppMethodBeat.o(53082);
    }

    /* Access modifiers changed, original: final */
    public final void bkp() {
        AppMethodBeat.i(53083);
        while (!this.kVZ.isEmpty()) {
            if (this.kWa.isEmpty()) {
                Iterator it = this.kVZ.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.kVZ.remove(str);
                    EmojiGroupInfo bZ = j.getEmojiStorageMgr().xYo.bZ(str, true);
                    if (bZ == null || (bZ.field_flag & 256) <= 0) {
                        ab.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", str);
                        this.kWa.add(str);
                        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.g(str, ""), 0);
                    } else {
                        ab.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", str);
                    }
                }
                AppMethodBeat.o(53083);
                return;
            }
            ab.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", this.kWa.toString());
            AppMethodBeat.o(53083);
            return;
        }
        ab.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
        AppMethodBeat.o(53083);
    }
}
