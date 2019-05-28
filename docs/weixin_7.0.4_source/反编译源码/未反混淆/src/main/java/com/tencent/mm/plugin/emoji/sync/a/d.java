package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class d extends c {
    private com.tencent.mm.plugin.emoji.sync.d kXJ;
    private m kXU;
    private EmojiInfo kXV;
    private String mKey;

    public d(String str) {
        AppMethodBeat.i(53210);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.mKey = str;
        this.kXV = j.getEmojiStorageMgr().xYn.aqi(this.mKey);
        AppMethodBeat.o(53210);
    }

    public final void run() {
        AppMethodBeat.i(53211);
        if (this.kXJ != null) {
            this.kXJ.JH(this.mKey);
        } else {
            ab.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.kXV == null) {
            this.kXJ.m(this.mKey, 1, false);
            AppMethodBeat.o(53211);
            return;
        }
        this.kXU = new f(this.kXV);
        g.RO().eJo.a(this.kXU, 0);
        AppMethodBeat.o(53211);
    }

    public final String getKey() {
        return this.mKey;
    }

    public final void a(com.tencent.mm.plugin.emoji.sync.d dVar) {
        this.kXJ = dVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(53212);
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(bo.isNullOrNil(this.mKey) || bo.isNullOrNil(dVar.mKey) || !this.mKey.equals(dVar.mKey))) {
                AppMethodBeat.o(53212);
                return true;
            }
        }
        AppMethodBeat.o(53212);
        return false;
    }

    public final void cancel() {
    }
}
