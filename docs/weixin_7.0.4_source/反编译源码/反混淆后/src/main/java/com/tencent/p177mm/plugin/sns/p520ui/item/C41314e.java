package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C13707q;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.e */
public final class C41314e extends BaseTimeLineItem {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40150);
        String str = c13633av.riA;
        if (timeLineObject.xfI.wbK.isEmpty()) {
            baseViewHolder.rvR.setVisibility(8);
            AppMethodBeat.m2505o(40150);
            return;
        }
        Object obj;
        baseViewHolder.rHF.setPosition(i);
        baseViewHolder.rvR.setVisibility(0);
        bau bau = (bau) timeLineObject.xfI.wbK.get(0);
        C21925g cnC = C13373af.cnC();
        View view = baseViewHolder.rHF;
        int hashCode = this.mActivity.hashCode();
        C44222az dtg = C44222az.dtg();
        dtg.oyB = timeLineObject.pcX;
        cnC.mo37440a(bau, view, (int) C1318a.app_attach_file_icon_music, hashCode, dtg);
        baseViewHolder.rhd.setPressed(false);
        String str2 = timeLineObject.f15074Id;
        if (C37494a.aie()) {
            C9058e aih = C37494a.aih();
            if (aih != null && C37494a.m63282d(aih) && str2.equals(aih.fJU)) {
                obj = 1;
                if (obj == null) {
                    baseViewHolder.rhd.setImageResource(C25738R.drawable.f6930vq);
                } else {
                    baseViewHolder.rhd.setImageResource(C25738R.drawable.f6932vs);
                }
                baseViewHolder.rHF.setTag(new C13707q(timeLineObject, str));
                baseViewHolder.rHF.setOnClickListener(c46251au.rqg.rDA);
                baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str));
                c46251au.jMO.mo39887c(baseViewHolder.rvR, c46251au.qOL.rJW, c46251au.qOL.rJH);
                baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rvD);
                str2 = bau.Desc;
                if (C5046bo.isNullOrNil(str2)) {
                    baseViewHolder.rHG.setVisibility(0);
                    baseViewHolder.rHG.setText(str2);
                } else {
                    baseViewHolder.rHG.setVisibility(4);
                }
                str2 = bau.Title;
                if (C5046bo.isNullOrNil(str2)) {
                    baseViewHolder.gne.setVisibility(0);
                    baseViewHolder.gne.setText(new SpannableString(str2), BufferType.SPANNABLE);
                    AppMethodBeat.m2505o(40150);
                    return;
                }
                baseViewHolder.gne.setVisibility(8);
                AppMethodBeat.m2505o(40150);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
        baseViewHolder.rHF.setTag(new C13707q(timeLineObject, str));
        baseViewHolder.rHF.setOnClickListener(c46251au.rqg.rDA);
        baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str));
        c46251au.jMO.mo39887c(baseViewHolder.rvR, c46251au.qOL.rJW, c46251au.qOL.rJH);
        baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rvD);
        str2 = bau.Desc;
        if (C5046bo.isNullOrNil(str2)) {
        }
        str2 = bau.Title;
        if (C5046bo.isNullOrNil(str2)) {
        }
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40149);
        if (baseViewHolder.rHC != null) {
            baseViewHolder.rHC.setLayoutResource(2130970780);
            baseViewHolder.rIl = (ViewStub) baseViewHolder.mRR.findViewById(2131827717);
            if (!(baseViewHolder.rIm || baseViewHolder.rIl == null)) {
                baseViewHolder.rIn = baseViewHolder.rIl.inflate();
                baseViewHolder.rIm = true;
            }
        } else {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(2131827798);
            baseViewHolder.rIm = true;
        }
        baseViewHolder.rvR = baseViewHolder.rIn;
        baseViewHolder.rvR.findViewById(2131824637).setOnTouchListener(this.qPr.riQ);
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rvR.findViewById(2131825687);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rvR.findViewById(2131824637);
        baseViewHolder.rHG = (TextView) baseViewHolder.rvR.findViewById(2131825690);
        baseViewHolder.gne = (TextView) baseViewHolder.rvR.findViewById(2131825689);
        baseViewHolder.gne.setTextColor(this.mActivity.getResources().getColor(C25738R.color.a0k));
        baseViewHolder.gne.setMaxLines(1);
        C29036i.m46100b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.m2505o(40149);
    }
}
