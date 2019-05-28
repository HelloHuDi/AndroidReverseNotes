package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.storage.az;
import java.util.ArrayList;

public final class b extends BaseTimeLineItem {
    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40133);
        int cnN = af.cnN();
        if (baseViewHolder.rHC == null) {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(R.id.ejy);
            baseViewHolder.rIm = true;
        } else if (!baseViewHolder.rIm) {
            baseViewHolder.rHC.setLayoutResource(R.layout.avn);
            baseViewHolder.rIn = baseViewHolder.rHC.inflate();
            baseViewHolder.rIm = true;
        }
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rIn.findViewById(R.id.ejz);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rIn.findViewById(R.id.c9m);
        baseViewHolder.gne = (TextView) baseViewHolder.rIn.findViewById(R.id.ek1);
        View view = baseViewHolder.rIn;
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = cnN;
        layoutParams.width = cnN;
        view.setLayoutParams(layoutParams);
        i.b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.o(40133);
    }

    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40134);
        baseViewHolder.rHF.setPosition(i);
        String str = avVar.riA;
        if (timeLineObject.xfI.wbK.size() > 0) {
            bau bau = (bau) timeLineObject.xfI.wbK.get(0);
            g cnC;
            switch (timeLineObject.xfI.wbJ) {
                case 1:
                    baseViewHolder.rHF.setOnClickListener(auVar.qOL.rjy);
                    ao aoVar = new ao();
                    aoVar.czD = str;
                    aoVar.index = 0;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(baseViewHolder.rHF);
                    aoVar.rsl = arrayList;
                    aoVar.rps = this.rps;
                    aoVar.position = i;
                    baseViewHolder.rHF.setTag(aoVar);
                    baseViewHolder.rHF.setVisibility(0);
                    cnC = af.cnC();
                    TagImageView tagImageView = baseViewHolder.rHF;
                    int hashCode = this.mActivity.hashCode();
                    az dtg = az.dtg();
                    dtg.oyB = timeLineObject.pcX;
                    cnC.b(bau, tagImageView, hashCode, dtg);
                    baseViewHolder.rhd.setVisibility(8);
                    baseViewHolder.gne.setText(this.mActivity.getString(R.string.enh, new Object[]{Integer.valueOf(r2)}));
                    baseViewHolder.gne.setVisibility(0);
                    break;
                case 15:
                    baseViewHolder.rHF.setTag(new q(timeLineObject, str));
                    baseViewHolder.rHF.setOnClickListener(auVar.qOL.rKf);
                    baseViewHolder.rhd.setImageResource(R.raw.sns_collapse_video_play);
                    baseViewHolder.rhd.setVisibility(0);
                    baseViewHolder.gne.setVisibility(8);
                    cnC = af.cnC();
                    TagImageView tagImageView2 = baseViewHolder.rHF;
                    int hashCode2 = this.mActivity.hashCode();
                    az dtg2 = az.dtg();
                    dtg2.oyB = timeLineObject.pcX;
                    cnC.b(bau, tagImageView2, hashCode2, dtg2);
                    break;
            }
        }
        auVar.jMO.c(baseViewHolder.rHF, auVar.qOL.rJY, auVar.qOL.rJH);
        AppMethodBeat.o(40134);
    }
}
