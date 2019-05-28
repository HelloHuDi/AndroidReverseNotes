package com.tencent.mm.plugin.sns.ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;

public final class e extends BaseTimeLineItem {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40150);
        String str = avVar.riA;
        if (timeLineObject.xfI.wbK.isEmpty()) {
            baseViewHolder.rvR.setVisibility(8);
            AppMethodBeat.o(40150);
            return;
        }
        Object obj;
        baseViewHolder.rHF.setPosition(i);
        baseViewHolder.rvR.setVisibility(0);
        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
        g cnC = af.cnC();
        View view = baseViewHolder.rHF;
        int hashCode = this.mActivity.hashCode();
        az dtg = az.dtg();
        dtg.oyB = timeLineObject.pcX;
        cnC.a(bau, view, (int) R.raw.app_attach_file_icon_music, hashCode, dtg);
        baseViewHolder.rhd.setPressed(false);
        String str2 = timeLineObject.Id;
        if (a.aie()) {
            com.tencent.mm.aw.e aih = a.aih();
            if (aih != null && a.d(aih) && str2.equals(aih.fJU)) {
                obj = 1;
                if (obj == null) {
                    baseViewHolder.rhd.setImageResource(R.drawable.vq);
                } else {
                    baseViewHolder.rhd.setImageResource(R.drawable.vs);
                }
                baseViewHolder.rHF.setTag(new q(timeLineObject, str));
                baseViewHolder.rHF.setOnClickListener(auVar.rqg.rDA);
                baseViewHolder.rvR.setTag(new q(timeLineObject, str));
                auVar.jMO.c(baseViewHolder.rvR, auVar.qOL.rJW, auVar.qOL.rJH);
                baseViewHolder.rvR.setOnClickListener(auVar.rqg.rvD);
                str2 = bau.Desc;
                if (bo.isNullOrNil(str2)) {
                    baseViewHolder.rHG.setVisibility(0);
                    baseViewHolder.rHG.setText(str2);
                } else {
                    baseViewHolder.rHG.setVisibility(4);
                }
                str2 = bau.Title;
                if (bo.isNullOrNil(str2)) {
                    baseViewHolder.gne.setVisibility(0);
                    baseViewHolder.gne.setText(new SpannableString(str2), BufferType.SPANNABLE);
                    AppMethodBeat.o(40150);
                    return;
                }
                baseViewHolder.gne.setVisibility(8);
                AppMethodBeat.o(40150);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
        baseViewHolder.rHF.setTag(new q(timeLineObject, str));
        baseViewHolder.rHF.setOnClickListener(auVar.rqg.rDA);
        baseViewHolder.rvR.setTag(new q(timeLineObject, str));
        auVar.jMO.c(baseViewHolder.rvR, auVar.qOL.rJW, auVar.qOL.rJH);
        baseViewHolder.rvR.setOnClickListener(auVar.rqg.rvD);
        str2 = bau.Desc;
        if (bo.isNullOrNil(str2)) {
        }
        str2 = bau.Title;
        if (bo.isNullOrNil(str2)) {
        }
    }

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40149);
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(R.layout.avr);
            baseViewHolder.rIl = (ViewStub) baseViewHolder.mRR.findViewById(R.id.ehw);
            if (!(baseViewHolder.rIm || baseViewHolder.rIl == null)) {
                baseViewHolder.rIn = baseViewHolder.rIl.inflate();
                baseViewHolder.rIm = true;
            }
        } else {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(R.id.ek3);
            baseViewHolder.rIm = true;
        }
        baseViewHolder.rvR = baseViewHolder.rIn;
        baseViewHolder.rvR.findViewById(R.id.c9m).setOnTouchListener(this.qPr.riQ);
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rvR.findViewById(R.id.d11);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rvR.findViewById(R.id.c9m);
        baseViewHolder.rHG = (TextView) baseViewHolder.rvR.findViewById(R.id.d14);
        baseViewHolder.gne = (TextView) baseViewHolder.rvR.findViewById(R.id.d13);
        baseViewHolder.gne.setTextColor(this.mActivity.getResources().getColor(R.color.a0k));
        baseViewHolder.gne.setMaxLines(1);
        i.b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.o(40149);
    }
}
