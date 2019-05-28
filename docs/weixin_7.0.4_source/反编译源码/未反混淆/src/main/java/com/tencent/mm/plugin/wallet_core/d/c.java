package com.tencent.mm.plugin.wallet_core.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends j<Bankcard> {
    public static final String[] fnj = new String[]{j.a(Bankcard.ccO, "WalletBankcard")};
    public e bSd;
    private List<Object> bkF = new LinkedList();

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        AppMethodBeat.i(47069);
        if (super.a((Bankcard) cVar, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47069);
            return true;
        }
        AppMethodBeat.o(47069);
        return false;
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(47070);
        boolean f = f((Bankcard) cVar);
        AppMethodBeat.o(47070);
        return f;
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        AppMethodBeat.i(47068);
        if (super.c((Bankcard) cVar, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47068);
            return true;
        }
        AppMethodBeat.o(47068);
        return false;
    }

    static {
        AppMethodBeat.i(47071);
        AppMethodBeat.o(47071);
    }

    public c(e eVar) {
        super(eVar, Bankcard.ccO, "WalletBankcard", null);
        AppMethodBeat.i(47059);
        this.bSd = eVar;
        AppMethodBeat.o(47059);
    }

    public final ArrayList<Bankcard> cQB() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.i(47060);
        Cursor a = this.bSd.a("select * from WalletBankcard where cardType <= 7", null, 2);
        if (a == null) {
            AppMethodBeat.o(47060);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.d(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(47060);
        }
        return arrayList;
    }

    public final Bankcard cRc() {
        Bankcard bankcard = null;
        AppMethodBeat.i(47061);
        Cursor a = this.bSd.a("select * from WalletBankcard where cardType & " + Bankcard.twI + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.o(47061);
        } else {
            if (a.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.d(a);
            }
            a.close();
            AppMethodBeat.o(47061);
        }
        return bankcard;
    }

    public final Bankcard cRd() {
        Bankcard bankcard = null;
        AppMethodBeat.i(47062);
        Cursor a = this.bSd.a("select * from WalletBankcard where cardType & " + Bankcard.twL + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.o(47062);
        } else {
            if (a.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.d(a);
            }
            a.close();
            AppMethodBeat.o(47062);
        }
        return bankcard;
    }

    public final ArrayList<Bankcard> cRe() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.i(47063);
        Cursor a = this.bSd.a("select * from WalletBankcard where cardType & " + Bankcard.twH + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.o(47063);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.d(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(47063);
        }
        return arrayList;
    }

    public final Bankcard cRf() {
        Bankcard bankcard = null;
        AppMethodBeat.i(47064);
        Cursor a = this.bSd.a("select * from WalletBankcard where cardType & " + Bankcard.twJ + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.o(47064);
        } else {
            if (a.moveToNext()) {
                bankcard = new Bankcard();
                bankcard.d(a);
            }
            a.close();
            AppMethodBeat.o(47064);
        }
        return bankcard;
    }

    public final boolean dU(List<Bankcard> list) {
        AppMethodBeat.i(47065);
        for (com.tencent.mm.sdk.e.c b : list) {
            super.b(b);
        }
        Iterator it = this.bkF.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(47065);
        return true;
    }

    public final boolean f(Bankcard bankcard) {
        AppMethodBeat.i(47066);
        if (super.b((com.tencent.mm.sdk.e.c) bankcard)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.o(47066);
            return true;
        }
        AppMethodBeat.o(47066);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.i(47067);
        boolean hY = this.bSd.hY("WalletBankcard", "delete from WalletBankcard");
        AppMethodBeat.o(47067);
        return hY;
    }
}
