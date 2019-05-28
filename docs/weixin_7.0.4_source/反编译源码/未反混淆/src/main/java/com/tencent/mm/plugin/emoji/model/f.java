package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int kVp;
    public List<com.tencent.mm.plugin.emoji.a.a.f> kVq;
    public EmotionBanner kVr;
    public List<EmotionBanner> kVs;
    public List<EmotionBannerSet> kVt;
    public List<EmotionBannerSet> kVu;

    public final void ue(int i) {
        this.kVp += i;
    }

    public final void bke() {
        AppMethodBeat.i(53047);
        if (this.kVu == null) {
            AppMethodBeat.o(53047);
        } else if (this.kVu.isEmpty()) {
            AppMethodBeat.o(53047);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kVu);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.kVq.add(0, new com.tencent.mm.plugin.emoji.a.a.f((EmotionBannerSet) arrayList.get(size)));
                this.kVp++;
                this.kVu.remove(arrayList.get(size));
            }
            AppMethodBeat.o(53047);
        }
    }

    public final void br(List<com.tencent.mm.plugin.emoji.a.a.f> list) {
        AppMethodBeat.i(53048);
        if (this.kVq == null) {
            this.kVq = new ArrayList();
        } else {
            int size = this.kVq.size() - 1;
            if (size >= 0 && size < this.kVq.size()) {
                com.tencent.mm.plugin.emoji.a.a.f fVar = (com.tencent.mm.plugin.emoji.a.a.f) this.kVq.get(size);
                if (!(fVar == null || fVar.kTb == null || bo.isNullOrNil(fVar.kTb.ProductID) || !fVar.kTb.ProductID.equals(EmojiGroupInfo.yar))) {
                    this.kVq.remove(fVar);
                }
            }
        }
        this.kVq.addAll(list);
        AppMethodBeat.o(53048);
    }
}
