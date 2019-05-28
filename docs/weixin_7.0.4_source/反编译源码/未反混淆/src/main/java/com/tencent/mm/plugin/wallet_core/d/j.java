package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends com.tencent.mm.sdk.e.j<aj> {
    public static final String[] fnj = new String[]{com.tencent.mm.sdk.e.j.a(aj.ccO, "WalletUserInfo")};
    private e bSd;
    private List<Object> bkF = new LinkedList();

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        AppMethodBeat.i(47092);
        if (super.a((aj) cVar, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47092);
            return true;
        }
        AppMethodBeat.o(47092);
        return false;
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(47091);
        if (super.c((aj) cVar, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47091);
            return true;
        }
        AppMethodBeat.o(47091);
        return false;
    }

    static {
        AppMethodBeat.i(47094);
        AppMethodBeat.o(47094);
    }

    public j(e eVar) {
        super(eVar, aj.ccO, "WalletUserInfo", null);
        AppMethodBeat.i(47087);
        ab.i("MicroMsg.WalletUserInfoStorage", "already call constructor.");
        this.bSd = eVar;
        AppMethodBeat.o(47087);
    }

    public final aj cRh() {
        AppMethodBeat.i(47088);
        aj ajVar = new aj();
        Cursor a = this.bSd.a("select * from WalletUserInfo", null, 2);
        ajVar.field_is_reg = -1;
        if (a == null) {
            AppMethodBeat.o(47088);
        } else {
            if (a.moveToNext()) {
                ajVar.d(a);
            }
            a.close();
            AppMethodBeat.o(47088);
        }
        return ajVar;
    }

    public final boolean b(aj ajVar) {
        AppMethodBeat.i(47089);
        if (super.b((c) ajVar)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47089);
            return true;
        }
        AppMethodBeat.o(47089);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.i(47090);
        boolean hY = this.bSd.hY("WalletUserInfo", "delete from WalletUserInfo");
        AppMethodBeat.o(47090);
        return hY;
    }
}
