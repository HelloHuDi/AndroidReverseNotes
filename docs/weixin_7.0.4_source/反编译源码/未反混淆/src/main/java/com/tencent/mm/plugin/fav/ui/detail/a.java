package com.tencent.mm.plugin.fav.ui.detail;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public final class a {
    public static void a(MMActivity mMActivity, g gVar) {
        String mK;
        AppMethodBeat.i(74456);
        if (14 != gVar.field_type || bo.isNullOrNil(gVar.field_favProto.title)) {
            abl abl = gVar.field_favProto.wit;
            if (abl == null || bo.isNullOrNil(abl.whU)) {
                mK = b.mK(gVar.field_fromUser);
            } else {
                mK = b.LC(abl.whU);
                String mK2;
                if (r.Yz().equals(abl.cEV)) {
                    mK2 = b.mK(abl.toUser);
                    if (!bo.bc(mK2, "").equals(abl.toUser)) {
                        mK = mK + " - " + mK2;
                    }
                } else {
                    mK2 = b.mK(abl.cEV);
                    if (!bo.bc(mK2, "").equals(abl.cEV)) {
                        mK = mK + " - " + mK2;
                    }
                }
            }
        } else {
            mK = gVar.field_favProto.title;
        }
        CharSequence format = DateFormat.format("yyyy/M/d", gVar.field_updateTime);
        mMActivity.setMMSubTitle(String.format(mMActivity.getString(R.string.bnt), new Object[]{mK, format}));
        AppMethodBeat.o(74456);
    }
}
