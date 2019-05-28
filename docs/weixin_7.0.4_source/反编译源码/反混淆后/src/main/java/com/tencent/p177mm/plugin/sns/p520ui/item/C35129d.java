package com.tencent.p177mm.plugin.sns.p520ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C22067aq;
import com.tencent.p177mm.plugin.sns.p520ui.C29190ao;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.PhotosContent;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44222az;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.d */
public final class C35129d extends BaseTimeLineItem {
    private int rqj = 103;

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40147);
        baseViewHolder.rHM.setImageResource(C25738R.drawable.f6812rl);
        baseViewHolder.rHw.setTextColor(-2730427);
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(2130970763);
            if (!baseViewHolder.rHD) {
                baseViewHolder.rHT = (PhotosContent) baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else {
            baseViewHolder.rHT = (PhotosContent) baseViewHolder.mRR.findViewById(2131827765);
            baseViewHolder.rHD = true;
        }
        C4990ab.m7416i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.klY);
        TagImageView tagImageView = (TagImageView) baseViewHolder.rHT.findViewById(C22067aq.rur[0]);
        baseViewHolder.rHT.mo8756a(tagImageView);
        tagImageView.setOnClickListener(this.qPr.qOL.rjy);
        AppMethodBeat.m2505o(40147);
    }

    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40148);
        String str = c13633av.riA;
        if (baseViewHolder.rIy != null) {
            if (!c13633av.rAJ || baseViewHolder.qCX.xaE == null || baseViewHolder.qCX.xaE.xbg <= 0) {
                baseViewHolder.rIy.setBackgroundResource(C25738R.drawable.b6_);
            } else {
                baseViewHolder.rIy.setBackgroundResource(C25738R.drawable.b6a);
            }
        }
        TagImageView DT = baseViewHolder.rHT.mo8755DT(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(DT);
        C29190ao c29190ao = new C29190ao();
        c29190ao.czD = str;
        c29190ao.index = 0;
        c29190ao.rsl = arrayList;
        c29190ao.rps = this.rps;
        if (DT != null) {
            DT.setTag(c29190ao);
        }
        bav bav = c13633av.rBj;
        baseViewHolder.rfi = bav;
        C22067aq c22067aq;
        PhotosContent photosContent;
        String str2;
        int hashCode;
        boolean z;
        C44222az dtg;
        if (bav == null) {
            C4990ab.m7412e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + c13633av.riA);
            AppMethodBeat.m2505o(40148);
        } else if (C1853r.m3846Yz().equals(timeLineObject.jBB)) {
            baseViewHolder.rHT.setVisibility(0);
            c22067aq = c46251au.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = c13633av.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = C44222az.dtg();
            dtg.oyB = timeLineObject.pcX;
            c22067aq.mo37628a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, true);
            AppMethodBeat.m2505o(40148);
        } else if (c13633av.rAM) {
            baseViewHolder.rHT.setVisibility(0);
            c22067aq = c46251au.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = c13633av.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = C44222az.dtg();
            dtg.oyB = timeLineObject.pcX;
            c22067aq.mo37628a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, false);
            AppMethodBeat.m2505o(40148);
        } else if (bav.cRU == 0) {
            baseViewHolder.rHT.setVisibility(0);
            c22067aq = c46251au.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = c13633av.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = C44222az.dtg();
            dtg.oyB = timeLineObject.pcX;
            c22067aq.mo37628a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, true);
            AppMethodBeat.m2505o(40148);
        } else {
            C4990ab.m7412e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + bav.cRU);
            AppMethodBeat.m2505o(40148);
        }
    }
}
