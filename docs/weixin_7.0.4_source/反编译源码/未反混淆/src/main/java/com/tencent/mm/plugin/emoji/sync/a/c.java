package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c extends com.tencent.mm.plugin.emoji.sync.c {
    private String kWz;
    private d kXJ;

    public c(String str) {
        AppMethodBeat.i(53207);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.kWz = str;
        AppMethodBeat.o(53207);
    }

    public final void run() {
        AppMethodBeat.i(53208);
        if (this.kXJ != null) {
            this.kXJ.JH(getKey());
        } else {
            ab.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        EmojiGroupInfo bZ = j.getEmojiStorageMgr().xYo.bZ(EmojiGroupInfo.yar, false);
        bZ.field_flag = 0;
        j.getEmojiStorageMgr().xYo.a(bZ);
        if (this.kXJ != null) {
            this.kXJ.m(getKey(), 2, true);
        }
        AppMethodBeat.o(53208);
    }

    public final String getKey() {
        return this.kWz == null ? "" : this.kWz;
    }

    public final void a(d dVar) {
        this.kXJ = dVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(53209);
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(bo.isNullOrNil(this.kWz) || bo.isNullOrNil(cVar.getKey()) || !this.kWz.equals(cVar.getKey()))) {
                AppMethodBeat.o(53209);
                return true;
            }
        }
        AppMethodBeat.o(53209);
        return false;
    }

    public final void cancel() {
    }
}
