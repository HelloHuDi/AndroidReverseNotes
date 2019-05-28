package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(f fVar) {
        super(fVar);
    }

    public final void clear() {
        AppMethodBeat.i(52796);
        super.clear();
        AppMethodBeat.o(52796);
    }

    public final void bjD() {
    }

    public final synchronized void notifyDataSetChanged() {
        AppMethodBeat.i(52795);
        ArrayList<EmojiGroupInfo> duM = j.getEmojiStorageMgr().xYo.duM();
        boolean blE = a.blE();
        this.mItemList = new ArrayList();
        ab.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo duw : duM) {
            EmotionSummary duw2 = duw.duw();
            f fVar = new f(duw2);
            if (a.g(duw2) && blE) {
                this.kSX.put(duw2.ProductID, new ar(duw2.ProductID));
            }
            fVar.setStatus(9);
            this.mItemList.add(fVar);
        }
        AppMethodBeat.o(52795);
    }
}
