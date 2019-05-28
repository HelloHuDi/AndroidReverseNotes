package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;

public final class f extends BaseTimeLineItem {
    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        Object obj;
        Object obj2;
        String str;
        String str2;
        AppMethodBeat.i(40152);
        baseViewHolder.rHF.setPosition(i);
        String str3 = avVar.riA;
        n nVar = avVar.qBY;
        Object obj3 = null;
        if (avVar.rgZ) {
            if (nVar.cqo().qUR == 2) {
                obj3 = 1;
                baseViewHolder.rvR.setTag(baseViewHolder);
                baseViewHolder.rvR.setOnClickListener(auVar.qOL.rKs);
            }
            obj = obj3;
            obj2 = null;
        } else {
            if (timeLineObject.xfI.wbJ == 9) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDu);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 10) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDw);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 17) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDx);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 22) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDy);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 23) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDz);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 14) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDv);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 12) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDD);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 13) {
                if (timeLineObject.xfI.wbK.size() > 0) {
                    baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                    baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDE);
                    obj = null;
                    obj2 = null;
                } else {
                    baseViewHolder.rvR.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (timeLineObject.xfI.wbJ == 26) {
                baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                baseViewHolder.rvR.setOnClickListener(auVar.rqg.rDF);
                obj = null;
                obj2 = null;
            } else {
                baseViewHolder.rvR.setTag(new q(timeLineObject, str3));
                baseViewHolder.rvR.setOnClickListener(auVar.rqg.rvD);
                if ((timeLineObject.fgt & 1) > 0) {
                    obj = null;
                    int obj22 = 1;
                }
            }
            obj = null;
            obj22 = null;
        }
        if (obj != null) {
            auVar.jMO.c(baseViewHolder.rvR, auVar.qOL.rKa, auVar.qOL.rJH);
        } else {
            auVar.jMO.c(baseViewHolder.rvR, auVar.qOL.rJW, auVar.qOL.rJH);
        }
        obj3 = timeLineObject.xfI.wbJ == 9 ? 1 : (a.coe() & 1) <= 0 ? 1 : null;
        String ZI = obj3 != null ? au.ZI(timeLineObject.xfI.Url) : "";
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
            g cnC;
            View view;
            int hashCode;
            az dtg;
            if (timeLineObject.xfI.wbJ == 5) {
                str2 = bau.Title;
                baseViewHolder.rhd.setImageResource(R.drawable.aql);
                baseViewHolder.rhd.setVisibility(0);
                cnC = af.cnC();
                view = baseViewHolder.rHF;
                hashCode = this.mActivity.hashCode();
                dtg = az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC.a(bau, view, (int) R.raw.app_attach_file_icon_video, hashCode, dtg);
            } else if (timeLineObject.xfI.wbJ == 18) {
                baseViewHolder.rhd.setVisibility(0);
                baseViewHolder.rhd.setImageResource(R.drawable.aql);
                baseViewHolder.rHF.setVisibility(0);
                cnC = af.cnC();
                view = baseViewHolder.rHF;
                hashCode = this.mActivity.hashCode();
                dtg = az.dtg();
                dtg.oyB = timeLineObject.pcX;
                cnC.a(bau, view, (int) R.raw.app_attach_file_icon_video, hashCode, dtg);
            } else {
                if (!(timeLineObject.qNQ == null || bo.isNullOrNil(timeLineObject.qNQ.uaa))) {
                    baseViewHolder.rhd.setImageResource(R.drawable.aql);
                    baseViewHolder.rhd.setVisibility(0);
                }
                cnC = af.cnC();
                TagImageView tagImageView = baseViewHolder.rHF;
                int hashCode2 = this.mActivity.hashCode();
                az dtg2 = az.dtg();
                dtg2.oyB = timeLineObject.pcX;
                cnC.b(bau, tagImageView, hashCode2, dtg2);
            }
        } else if (timeLineObject.xfI.wbJ == 18) {
            baseViewHolder.rhd.setVisibility(0);
            baseViewHolder.rhd.setImageResource(R.drawable.aql);
            baseViewHolder.rHF.setVisibility(0);
            af.cnC().a(baseViewHolder.rHF, -1, (int) R.raw.app_attach_file_icon_video, this.mActivity.hashCode());
        } else if (timeLineObject.xfI.wbJ == 26) {
            baseViewHolder.rHF.setVisibility(0);
            af.cnC().a(baseViewHolder.rHF, -1, (int) R.raw.note_sns_link_default, this.mActivity.hashCode());
        } else {
            baseViewHolder.rHF.setVisibility(0);
            af.cnC().a(baseViewHolder.rHF, -1, (int) R.raw.app_attach_file_icon_webpage, this.mActivity.hashCode());
        }
        if (bo.isNullOrNil(str)) {
            baseViewHolder.rHG.setVisibility(8);
        } else {
            baseViewHolder.rHG.setVisibility(0);
            baseViewHolder.rHG.setText(str);
        }
        if (!bo.isNullOrNil(str2)) {
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
                baseViewHolder.gne.setText(i.a(str2, this.mActivity, baseViewHolder.gne));
                AppMethodBeat.o(40152);
                return;
            }
            baseViewHolder.gne.setText(str2);
            AppMethodBeat.o(40152);
        } else if (i2 == 1) {
            baseViewHolder.gne.setText(au.ZI(timeLineObject.xfI.Url));
            baseViewHolder.gne.setVisibility(0);
            AppMethodBeat.o(40152);
        } else {
            baseViewHolder.gne.setVisibility(8);
            AppMethodBeat.o(40152);
        }
    }

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40151);
        if (baseViewHolder.rHC == null || baseViewHolder.rHC.getParent() == null) {
            baseViewHolder.rIn = baseViewHolder.mRR.findViewById(R.id.ek3);
            baseViewHolder.rIm = true;
        } else {
            baseViewHolder.rHC.setLayoutResource(R.layout.avr);
            if (!baseViewHolder.rIm) {
                baseViewHolder.rIn = baseViewHolder.rHC.inflate();
                baseViewHolder.rIm = true;
            }
        }
        baseViewHolder.rvR = baseViewHolder.rIn;
        baseViewHolder.rHF = (TagImageView) baseViewHolder.rvR.findViewById(R.id.d11);
        baseViewHolder.rhd = (ImageView) baseViewHolder.rvR.findViewById(R.id.c9m);
        baseViewHolder.rHG = (TextView) baseViewHolder.rvR.findViewById(R.id.d14);
        baseViewHolder.gne = (TextView) baseViewHolder.rvR.findViewById(R.id.d13);
        baseViewHolder.gne.setTextColor(this.mActivity.getResources().getColor(R.color.h4));
        i.b(baseViewHolder.rHF, this.mActivity);
        AppMethodBeat.o(40151);
    }
}
