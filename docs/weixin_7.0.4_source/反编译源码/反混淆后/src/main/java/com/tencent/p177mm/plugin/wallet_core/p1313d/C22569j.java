package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.j */
public final class C22569j extends C7563j<C22586aj> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C22586aj.ccO, "WalletUserInfo")};
    private C4927e bSd;
    private List<Object> bkF = new LinkedList();

    /* renamed from: a */
    public final /* synthetic */ boolean mo16760a(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(47092);
        if (super.mo16760a((C22586aj) c4925c, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47092);
            return true;
        }
        AppMethodBeat.m2505o(47092);
        return false;
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(47091);
        if (super.mo10103c((C22586aj) c4925c, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47091);
            return true;
        }
        AppMethodBeat.m2505o(47091);
        return false;
    }

    static {
        AppMethodBeat.m2504i(47094);
        AppMethodBeat.m2505o(47094);
    }

    public C22569j(C4927e c4927e) {
        super(c4927e, C22586aj.ccO, "WalletUserInfo", null);
        AppMethodBeat.m2504i(47087);
        C4990ab.m7416i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
        this.bSd = c4927e;
        AppMethodBeat.m2505o(47087);
    }

    public final C22586aj cRh() {
        AppMethodBeat.m2504i(47088);
        C22586aj c22586aj = new C22586aj();
        Cursor a = this.bSd.mo10104a("select * from WalletUserInfo", null, 2);
        c22586aj.field_is_reg = -1;
        if (a == null) {
            AppMethodBeat.m2505o(47088);
        } else {
            if (a.moveToNext()) {
                c22586aj.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(47088);
        }
        return c22586aj;
    }

    /* renamed from: b */
    public final boolean mo38098b(C22586aj c22586aj) {
        AppMethodBeat.m2504i(47089);
        if (super.mo10101b((C4925c) c22586aj)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47089);
            return true;
        }
        AppMethodBeat.m2505o(47089);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.m2504i(47090);
        boolean hY = this.bSd.mo10108hY("WalletUserInfo", "delete from WalletUserInfo");
        AppMethodBeat.m2505o(47090);
        return hY;
    }
}
