package com.tencent.p177mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;
import com.tencent.p177mm.protocal.protobuf.EmotionBanner;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.model.f */
public final class C20383f {
    public int kVp;
    public List<C11546f> kVq;
    public EmotionBanner kVr;
    public List<EmotionBanner> kVs;
    public List<EmotionBannerSet> kVt;
    public List<EmotionBannerSet> kVu;

    /* renamed from: ue */
    public final void mo35681ue(int i) {
        this.kVp += i;
    }

    public final void bke() {
        AppMethodBeat.m2504i(53047);
        if (this.kVu == null) {
            AppMethodBeat.m2505o(53047);
        } else if (this.kVu.isEmpty()) {
            AppMethodBeat.m2505o(53047);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kVu);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.kVq.add(0, new C11546f((EmotionBannerSet) arrayList.get(size)));
                this.kVp++;
                this.kVu.remove(arrayList.get(size));
            }
            AppMethodBeat.m2505o(53047);
        }
    }

    /* renamed from: br */
    public final void mo35680br(List<C11546f> list) {
        AppMethodBeat.m2504i(53048);
        if (this.kVq == null) {
            this.kVq = new ArrayList();
        } else {
            int size = this.kVq.size() - 1;
            if (size >= 0 && size < this.kVq.size()) {
                C11546f c11546f = (C11546f) this.kVq.get(size);
                if (!(c11546f == null || c11546f.kTb == null || C5046bo.isNullOrNil(c11546f.kTb.ProductID) || !c11546f.kTb.ProductID.equals(EmojiGroupInfo.yar))) {
                    this.kVq.remove(c11546f);
                }
            }
        }
        this.kVq.addAll(list);
        AppMethodBeat.m2505o(53048);
    }
}
