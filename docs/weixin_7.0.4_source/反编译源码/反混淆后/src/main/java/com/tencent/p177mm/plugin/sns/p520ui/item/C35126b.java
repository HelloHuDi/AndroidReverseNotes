package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C13707q;
import com.tencent.p177mm.plugin.sns.p520ui.C29190ao;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.storage.C44222az;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.b */
public final class C35126b extends BaseTimeLineItem {
    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40133);
        int cnN = C13373af.cnN();
        if (baseViewHolder.rHC == null) {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(2131827793);
            baseViewHolder.rIm = true;
        } else if (!baseViewHolder.rIm) {
            baseViewHolder.rHC.setLayoutResource(2130970776);
            baseViewHolder.rIn = baseViewHolder.rHC.inflate();
            baseViewHolder.rIm = true;
        }
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rIn.findViewById(2131827794);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rIn.findViewById(2131824637);
        baseViewHolder.gne = (TextView) baseViewHolder.rIn.findViewById(2131827796);
        View view = baseViewHolder.rIn;
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = cnN;
        layoutParams.width = cnN;
        view.setLayoutParams(layoutParams);
        C29036i.m46100b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.m2505o(40133);
    }

    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40134);
        baseViewHolder.rHF.setPosition(i);
        String str = c13633av.riA;
        if (timeLineObject.xfI.wbK.size() > 0) {
            bau bau = (bau) timeLineObject.xfI.wbK.get(0);
            C21925g cnC;
            switch (timeLineObject.xfI.wbJ) {
                case 1:
                    baseViewHolder.rHF.setOnClickListener(c46251au.qOL.rjy);
                    C29190ao c29190ao = new C29190ao();
                    c29190ao.czD = str;
                    c29190ao.index = 0;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(baseViewHolder.rHF);
                    c29190ao.rsl = arrayList;
                    c29190ao.rps = this.rps;
                    c29190ao.position = i;
                    baseViewHolder.rHF.setTag(c29190ao);
                    baseViewHolder.rHF.setVisibility(0);
                    cnC = C13373af.cnC();
                    TagImageView tagImageView = baseViewHolder.rHF;
                    int hashCode = this.mActivity.hashCode();
                    C44222az dtg = C44222az.dtg();
                    dtg.oyB = timeLineObject.pcX;
                    cnC.mo37455b(bau, tagImageView, hashCode, dtg);
                    baseViewHolder.rhd.setVisibility(8);
                    baseViewHolder.gne.setText(this.mActivity.getString(C25738R.string.enh, new Object[]{Integer.valueOf(r2)}));
                    baseViewHolder.gne.setVisibility(0);
                    break;
                case 15:
                    baseViewHolder.rHF.setTag(new C13707q(timeLineObject, str));
                    baseViewHolder.rHF.setOnClickListener(c46251au.qOL.rKf);
                    baseViewHolder.rhd.setImageResource(C1318a.sns_collapse_video_play);
                    baseViewHolder.rhd.setVisibility(0);
                    baseViewHolder.gne.setVisibility(8);
                    cnC = C13373af.cnC();
                    TagImageView tagImageView2 = baseViewHolder.rHF;
                    int hashCode2 = this.mActivity.hashCode();
                    C44222az dtg2 = C44222az.dtg();
                    dtg2.oyB = timeLineObject.pcX;
                    cnC.mo37455b(bau, tagImageView2, hashCode2, dtg2);
                    break;
            }
        }
        c46251au.jMO.mo39887c(baseViewHolder.rHF, c46251au.qOL.rJY, c46251au.qOL.rJH);
        AppMethodBeat.m2505o(40134);
    }
}
