package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;
import java.util.ArrayList;

public final class d extends BaseTimeLineItem {
    private int rqj = 103;

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40147);
        baseViewHolder.rHM.setImageResource(R.drawable.rl);
        baseViewHolder.rHw.setTextColor(-2730427);
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(R.layout.ava);
            if (!baseViewHolder.rHD) {
                baseViewHolder.rHT = (PhotosContent) baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        } else {
            baseViewHolder.rHT = (PhotosContent) baseViewHolder.mRR.findViewById(R.id.ej7);
            baseViewHolder.rHD = true;
        }
        ab.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.klY);
        TagImageView tagImageView = (TagImageView) baseViewHolder.rHT.findViewById(aq.rur[0]);
        baseViewHolder.rHT.a(tagImageView);
        tagImageView.setOnClickListener(this.qPr.qOL.rjy);
        AppMethodBeat.o(40147);
    }

    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40148);
        String str = avVar.riA;
        if (baseViewHolder.rIy != null) {
            if (!avVar.rAJ || baseViewHolder.qCX.xaE == null || baseViewHolder.qCX.xaE.xbg <= 0) {
                baseViewHolder.rIy.setBackgroundResource(R.drawable.b6_);
            } else {
                baseViewHolder.rIy.setBackgroundResource(R.drawable.b6a);
            }
        }
        TagImageView DT = baseViewHolder.rHT.DT(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(DT);
        ao aoVar = new ao();
        aoVar.czD = str;
        aoVar.index = 0;
        aoVar.rsl = arrayList;
        aoVar.rps = this.rps;
        if (DT != null) {
            DT.setTag(aoVar);
        }
        bav bav = avVar.rBj;
        baseViewHolder.rfi = bav;
        aq aqVar;
        PhotosContent photosContent;
        String str2;
        int hashCode;
        boolean z;
        az dtg;
        if (bav == null) {
            ab.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + avVar.riA);
            AppMethodBeat.o(40148);
        } else if (r.Yz().equals(timeLineObject.jBB)) {
            baseViewHolder.rHT.setVisibility(0);
            aqVar = auVar.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = avVar.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = az.dtg();
            dtg.oyB = timeLineObject.pcX;
            aqVar.a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, true);
            AppMethodBeat.o(40148);
        } else if (avVar.rAM) {
            baseViewHolder.rHT.setVisibility(0);
            aqVar = auVar.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = avVar.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = az.dtg();
            dtg.oyB = timeLineObject.pcX;
            aqVar.a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, false);
            AppMethodBeat.o(40148);
        } else if (bav.cRU == 0) {
            baseViewHolder.rHT.setVisibility(0);
            aqVar = auVar.rpY;
            photosContent = baseViewHolder.rHT;
            str2 = avVar.riA;
            hashCode = this.mActivity.hashCode();
            z = this.rps;
            dtg = az.dtg();
            dtg.oyB = timeLineObject.pcX;
            aqVar.a(photosContent, timeLineObject, str2, hashCode, i2, i, z, dtg, true);
            AppMethodBeat.o(40148);
        } else {
            ab.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + bav.cRU);
            AppMethodBeat.o(40148);
        }
    }
}
