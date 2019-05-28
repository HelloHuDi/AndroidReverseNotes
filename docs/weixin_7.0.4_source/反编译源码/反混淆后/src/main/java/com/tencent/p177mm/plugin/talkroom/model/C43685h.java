package com.tencent.p177mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.talkroom.model.h */
public final class C43685h {
    private static final int sxv = C43682a.sxv;

    /* renamed from: aU */
    public static String m78271aU(Context context, String str) {
        AppMethodBeat.m2504i(25846);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25846);
            return null;
        }
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        String mJ;
        if (aoO == null) {
            AppMethodBeat.m2505o(25846);
            return null;
        } else if (!C1855t.m3896kH(str)) {
            mJ = C1854s.m3866mJ(str);
            AppMethodBeat.m2505o(25846);
            return mJ;
        } else if (C5046bo.isNullOrNil(aoO.field_nickname)) {
            mJ = context.getString(C25738R.string.eux);
            AppMethodBeat.m2505o(25846);
            return mJ;
        } else {
            mJ = aoO.mo16706Oi();
            AppMethodBeat.m2505o(25846);
            return mJ;
        }
    }
}
