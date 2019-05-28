package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C43806ag;
import com.tencent.p177mm.protocal.protobuf.bjg;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.i */
public final class C22568i extends C7563j<C43806ag> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C43806ag.ccO, "WalletRegionGreyAreaList")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(47086);
        AppMethodBeat.m2505o(47086);
    }

    public C22568i(C4927e c4927e) {
        super(c4927e, C43806ag.ccO, "WalletRegionGreyAreaList", null);
        this.bSd = c4927e;
    }

    /* renamed from: a */
    public final void mo38096a(int i, bjg bjg) {
        AppMethodBeat.m2504i(47084);
        C43806ag c43806ag = new C43806ag();
        c43806ag.field_wallet_region = i;
        try {
            c43806ag.field_wallet_grey_item_buf = bjg.toByteArray();
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.mo10099a(c43806ag);
        AppMethodBeat.m2505o(47084);
    }

    /* renamed from: Ht */
    public final C43806ag mo38095Ht(int i) {
        AppMethodBeat.m2504i(47085);
        String concat = "select * from WalletRegionGreyAreaList where wallet_region = ".concat(String.valueOf(i));
        Cursor a = this.bSd.mo10104a(concat, null, 2);
        C4990ab.m7416i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem ".concat(String.valueOf(concat)));
        C43806ag c43806ag;
        if (a == null) {
            c43806ag = new C43806ag();
            AppMethodBeat.m2505o(47085);
            return c43806ag;
        }
        c43806ag = new C43806ag();
        if (a.moveToNext()) {
            c43806ag = new C43806ag();
            c43806ag.mo8995d(a);
        }
        C4990ab.m7416i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        a.close();
        AppMethodBeat.m2505o(47085);
        return c43806ag;
    }
}
