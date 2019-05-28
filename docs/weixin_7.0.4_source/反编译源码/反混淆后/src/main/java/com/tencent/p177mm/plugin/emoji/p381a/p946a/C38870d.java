package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44221ar;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.d */
public final class C38870d extends C45842c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public C38870d(C20383f c20383f) {
        super(c20383f);
    }

    public final void clear() {
        AppMethodBeat.m2504i(52796);
        super.clear();
        AppMethodBeat.m2505o(52796);
    }

    public final void bjD() {
    }

    public final synchronized void notifyDataSetChanged() {
        AppMethodBeat.m2504i(52795);
        ArrayList<EmojiGroupInfo> duM = C42952j.getEmojiStorageMgr().xYo.duM();
        boolean blE = C2932a.blE();
        this.mItemList = new ArrayList();
        C4990ab.m7418v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo duw : duM) {
            EmotionSummary duw2 = duw.duw();
            C11546f c11546f = new C11546f(duw2);
            if (C2932a.m5218g(duw2) && blE) {
                this.kSX.put(duw2.ProductID, new C44221ar(duw2.ProductID));
            }
            c11546f.setStatus(9);
            this.mItemList.add(c11546f);
        }
        AppMethodBeat.m2505o(52795);
    }
}
