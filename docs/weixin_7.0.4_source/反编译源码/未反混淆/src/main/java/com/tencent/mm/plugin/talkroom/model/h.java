package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class h {
    private static final int sxv = a.sxv;

    public static String aU(Context context, String str) {
        AppMethodBeat.i(25846);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25846);
            return null;
        }
        aw.ZK();
        ad aoO = c.XM().aoO(str);
        String mJ;
        if (aoO == null) {
            AppMethodBeat.o(25846);
            return null;
        } else if (!t.kH(str)) {
            mJ = s.mJ(str);
            AppMethodBeat.o(25846);
            return mJ;
        } else if (bo.isNullOrNil(aoO.field_nickname)) {
            mJ = context.getString(R.string.eux);
            AppMethodBeat.o(25846);
            return mJ;
        } else {
            mJ = aoO.Oi();
            AppMethodBeat.o(25846);
            return mJ;
        }
    }
}
