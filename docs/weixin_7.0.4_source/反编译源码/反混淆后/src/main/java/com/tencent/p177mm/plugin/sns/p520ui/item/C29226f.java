package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21925g;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C13707q;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.f */
public final class C29226f extends BaseTimeLineItem {
    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        Object obj;
        Object obj2;
        String str;
        String str2;
        AppMethodBeat.m2504i(40152);
        baseViewHolder.rHF.setPosition(i);
        String str3 = c13633av.riA;
        C46236n c46236n = c13633av.qBY;
        Object obj3 = null;
        if (c13633av.rgZ) {
            if (c46236n.cqo().qUR == 2) {
                obj3 = 1;
                baseViewHolder.rvR.setTag(baseViewHolder);
                baseViewHolder.rvR.setOnClickListener(c46251au.qOL.rKs);
            }
            obj = obj3;
            obj2 = null;
        } else {
            if (timeLineObject.xfI.wbJ == 9) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDu);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 10) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDw);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 17) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDx);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 22) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDy);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 23) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDz);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 14) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDv);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 12) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDD);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 13) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDE);
                    obj = null;
                    obj2 = null;
                } else {
                    baseViewHolder.rvR.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 26) {
                baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rDF);
                obj = null;
                obj2 = null;
            } else {
                baseViewHolder.rvR.setTag(new C13707q(timeLineObject, str3));
                baseViewHolder.rvR.setOnClickListener(c46251au.rqg.rvD);
                if ((timeLineObject.fgt & 1) > 0) {
                    obj = null;
                    int obj22 = 1;
                }
            }
            obj = null;
            obj22 = null;
        }
        if (obj != null) {
            c46251au.jMO.mo39887c(baseViewHolder.rvR, c46251au.qOL.rKa, c46251au.qOL.rJH);
        } else {
            c46251au.jMO.mo39887c(baseViewHolder.rvR, c46251au.qOL.rJW, c46251au.qOL.rJH);
        }
        obj3 = timeLineObject.xfI.wbJ == 9 ? 1 : (C3890a.coe() & 1) <= 0 ? 1 : null;
        String ZI = obj3 != null ? C46251au.m86603ZI(timeLineObject.xfI.Url) : "";
        if (timeLineObject.xfI.wbJ == 9 || timeLineObject.xfI.wbJ == 14 || timeLineObject.xfI.wbJ == 12 || timeLineObject.xfI.wbJ == 13 || obj != null) {
            str = timeLineObject.xfI.Desc;
        } else {
            str = ZI;
        }
        ZI = timeLineObject.xfI.Title;
        if (ZI == null || ZI.length() <= 40) {
            str2 = ZI;
        } else {
            str2 = ZI.substring(0, 40) + "...";
        }
        baseViewHolder.rhd.setVisibility(8);
        if (!timeLineObject.xfI.wbK.isEmpty()) {
            baseViewHolder.rHF.setVisibility(0);
            bau bau = (bau) timeLineObject.xfI.wbK.get(0);
            C21925g cnC;
            View view;
            int hashCode;
            C44222az dtg;
            if (timeLineObject.xfI.wbJ == 5) {
                str2 = bau.Title;
                baseViewHolder.rhd.setImageResource(C25738R.drawable.aql);
                baseViewHolder.rhd.setVisibility(0);
                cnC = C13373af.cnC();
                view = baseViewHolder.rHF;
                hashCode = this.mActivity.hashCode();
                dtg = C44222az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC.mo37440a(bau, view, (int) C1318a.app_attach_file_icon_video, hashCode, dtg);
            } else if (timeLineObject.xfI.wbJ == 18) {
                baseViewHolder.rhd.setVisibility(0);
                baseViewHolder.rhd.setImageResource(C25738R.drawable.aql);
                baseViewHolder.rHF.setVisibility(0);
                cnC = C13373af.cnC();
                view = baseViewHolder.rHF;
                hashCode = this.mActivity.hashCode();
                dtg = C44222az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC.mo37440a(bau, view, (int) C1318a.app_attach_file_icon_video, hashCode, dtg);
            } else {
                if (!(timeLineObject.qNQ == null || C5046bo.isNullOrNil(timeLineObject.qNQ.uaa))) {
                    baseViewHolder.rhd.setImageResource(C25738R.drawable.aql);
                    baseViewHolder.rhd.setVisibility(0);
                }
                cnC = C13373af.cnC();
                TagImageView tagImageView = baseViewHolder.rHF;
                int hashCode2 = this.mActivity.hashCode();
                C44222az dtg2 = C44222az.dtg();
                dtg2.oyB = timeLineObject.pcX;
                cnC.mo37455b(bau, tagImageView, hashCode2, dtg2);
            }
        } else if (timeLineObject.xfI.wbJ == 18) {
            baseViewHolder.rhd.setVisibility(0);
            baseViewHolder.rhd.setImageResource(C25738R.drawable.aql);
            baseViewHolder.rHF.setVisibility(0);
            C13373af.cnC().mo37438a(baseViewHolder.rHF, -1, (int) C1318a.app_attach_file_icon_video, this.mActivity.hashCode());
        } else if (timeLineObject.xfI.wbJ == 26) {
            baseViewHolder.rHF.setVisibility(0);
            C13373af.cnC().mo37438a(baseViewHolder.rHF, -1, (int) C1318a.note_sns_link_default, this.mActivity.hashCode());
        } else {
            baseViewHolder.rHF.setVisibility(0);
            C13373af.cnC().mo37438a(baseViewHolder.rHF, -1, (int) C1318a.app_attach_file_icon_webpage, this.mActivity.hashCode());
        }
        if (C5046bo.isNullOrNil(str)) {
            baseViewHolder.rHG.setVisibility(8);
        } else {
            baseViewHolder.rHG.setVisibility(0);
            baseViewHolder.rHG.setText(str);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            if (baseViewHolder.rHG.getVisibility() == 8) {
                if (baseViewHolder.rHH != 2) {
                    baseViewHolder.gne.setMaxLines(2);
                }
                baseViewHolder.rHH = 2;
            } else {
                if (baseViewHolder.rHH != 1) {
                    baseViewHolder.gne.setMaxLines(1);
                }
                baseViewHolder.rHH = 1;
            }
            baseViewHolder.gne.setVisibility(0);
            if (obj22 != null) {
                baseViewHolder.gne.setText(C29036i.m46097a(str2, this.mActivity, baseViewHolder.gne));
                AppMethodBeat.m2505o(40152);
                return;
            }
            baseViewHolder.gne.setText(str2);
            AppMethodBeat.m2505o(40152);
        } else if (i2 == 1) {
            baseViewHolder.gne.setText(C46251au.m86603ZI(timeLineObject.xfI.Url));
            baseViewHolder.gne.setVisibility(0);
            AppMethodBeat.m2505o(40152);
        } else {
            baseViewHolder.gne.setVisibility(8);
            AppMethodBeat.m2505o(40152);
        }
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40151);
        if (baseViewHolder.rHC == null || baseViewHolder.rHC.getParent() == null) {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(2131827798);
            baseViewHolder.rIm = true;
        } else {
            baseViewHolder.rHC.setLayoutResource(2130970780);
            if (!baseViewHolder.rIm) {
                baseViewHolder.rIn = baseViewHolder.rHC.inflate();
                baseViewHolder.rIm = true;
            }
        }
        baseViewHolder.rvR = baseViewHolder.rIn;
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rvR.findViewById(2131825687);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rvR.findViewById(2131824637);
        baseViewHolder.rHG = (TextView) baseViewHolder.rvR.findViewById(2131825690);
        baseViewHolder.gne = (TextView) baseViewHolder.rvR.findViewById(2131825689);
        baseViewHolder.gne.setTextColor(this.mActivity.getResources().getColor(C25738R.color.f11782h4));
        C29036i.m46100b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.m2505o(40151);
    }
}
