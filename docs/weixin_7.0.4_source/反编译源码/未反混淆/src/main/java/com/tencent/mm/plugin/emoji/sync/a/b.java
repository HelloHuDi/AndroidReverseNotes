package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.i;
import java.io.IOException;

public final class b extends c {
    private boolean kWV = false;
    private String kWz;
    private d kXJ;
    private g kXT;

    public b(String str) {
        AppMethodBeat.i(53202);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kWz = str;
        AppMethodBeat.o(53202);
    }

    public b(String str, byte b) {
        AppMethodBeat.i(53203);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.kWz = str;
        this.kWV = true;
        AppMethodBeat.o(53203);
    }

    public final void run() {
        AppMethodBeat.i(53204);
        if (this.kXJ != null) {
            this.kXJ.JH(getKey());
        } else {
            ab.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo bZ = j.getEmojiStorageMgr().xYo.bZ(getKey(), true);
        if (this.kWV || bZ == null || bZ.field_sync != 2 || bZ.field_status != 7) {
            this.kXT = new g(this.kWz);
            com.tencent.mm.kernel.g.RO().eJo.a(this.kXT, 0);
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            i aqp = j.getEmojiStorageMgr().xYr.aqp(this.kWz);
            if (!(aqp == null || aqp.field_content == null)) {
                try {
                    getEmotionDetailResponse.parseFrom(aqp.field_content);
                } catch (IOException e) {
                    ab.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", bo.l(e));
                }
            }
            if (getEmotionDetailResponse.EmotionDetail == null) {
                com.tencent.mm.kernel.g.RO().eJo.a(new l(this.kWz, 15), 0);
            }
            AppMethodBeat.o(53204);
            return;
        }
        cx cxVar = new cx();
        cxVar.cvY.cvZ = getKey();
        cxVar.cvY.cuy = 2;
        cxVar.cvY.success = true;
        a.xxA.m(cxVar);
        AppMethodBeat.o(53204);
    }

    public final String getKey() {
        return this.kWz == null ? "" : this.kWz;
    }

    public final void a(d dVar) {
        this.kXJ = dVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(53205);
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(bo.isNullOrNil(this.kWz) || bo.isNullOrNil(bVar.getKey()) || !this.kWz.equals(bVar.getKey()))) {
                AppMethodBeat.o(53205);
                return true;
            }
        }
        AppMethodBeat.o(53205);
        return false;
    }

    public final void cancel() {
        AppMethodBeat.i(53206);
        if (this.kXT == null || bo.isNullOrNil(this.kXT.fFa)) {
            ab.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            AppMethodBeat.o(53206);
            return;
        }
        f.afx().rO(this.kXT.fFa);
        ab.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", this.kXT.fFa);
        AppMethodBeat.o(53206);
    }
}
