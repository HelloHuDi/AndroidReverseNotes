package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.a */
public final class C20728a {
    /* renamed from: a */
    public static void m31955a(MMActivity mMActivity, C27966g c27966g) {
        String mK;
        AppMethodBeat.m2504i(74456);
        if (14 != c27966g.field_type || C5046bo.isNullOrNil(c27966g.field_favProto.title)) {
            abl abl = c27966g.field_favProto.wit;
            if (abl == null || C5046bo.isNullOrNil(abl.whU)) {
                mK = C39037b.m66412mK(c27966g.field_fromUser);
            } else {
                mK = C39037b.m66338LC(abl.whU);
                String mK2;
                if (C1853r.m3846Yz().equals(abl.cEV)) {
                    mK2 = C39037b.m66412mK(abl.toUser);
                    if (!C5046bo.m7532bc(mK2, "").equals(abl.toUser)) {
                        mK = mK + " - " + mK2;
                    }
                } else {
                    mK2 = C39037b.m66412mK(abl.cEV);
                    if (!C5046bo.m7532bc(mK2, "").equals(abl.cEV)) {
                        mK = mK + " - " + mK2;
                    }
                }
            }
        } else {
            mK = c27966g.field_favProto.title;
        }
        CharSequence format = DateFormat.format("yyyy/M/d", c27966g.field_updateTime);
        mMActivity.setMMSubTitle(String.format(mMActivity.getString(C25738R.string.bnt), new Object[]{mK, format}));
        AppMethodBeat.m2505o(74456);
    }
}
