package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.c */
public final class C40097c extends C7563j<Bankcard> {
    public static final String[] fnj = new String[]{C7563j.m13217a(Bankcard.ccO, "WalletBankcard")};
    public C4927e bSd;
    private List<Object> bkF = new LinkedList();

    /* renamed from: a */
    public final /* synthetic */ boolean mo16760a(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(47069);
        if (super.mo16760a((Bankcard) c4925c, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47069);
            return true;
        }
        AppMethodBeat.m2505o(47069);
        return false;
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(47070);
        boolean f = mo63410f((Bankcard) c4925c);
        AppMethodBeat.m2505o(47070);
        return f;
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(47068);
        if (super.mo10103c((Bankcard) c4925c, strArr)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47068);
            return true;
        }
        AppMethodBeat.m2505o(47068);
        return false;
    }

    static {
        AppMethodBeat.m2504i(47071);
        AppMethodBeat.m2505o(47071);
    }

    public C40097c(C4927e c4927e) {
        super(c4927e, Bankcard.ccO, "WalletBankcard", null);
        AppMethodBeat.m2504i(47059);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(47059);
    }

    public final ArrayList<Bankcard> cQB() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.m2504i(47060);
        Cursor a = this.bSd.mo10104a("select * from WalletBankcard where cardType <= 7", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47060);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.mo8995d(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(47060);
        }
        return arrayList;
    }

    public final Bankcard cRc() {
        Bankcard bankcard = null;
        AppMethodBeat.m2504i(47061);
        Cursor a = this.bSd.mo10104a("select * from WalletBankcard where cardType & " + Bankcard.twI + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47061);
        } else {
            if (a.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(47061);
        }
        return bankcard;
    }

    public final Bankcard cRd() {
        Bankcard bankcard = null;
        AppMethodBeat.m2504i(47062);
        Cursor a = this.bSd.mo10104a("select * from WalletBankcard where cardType & " + Bankcard.twL + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47062);
        } else {
            if (a.moveToFirst()) {
                bankcard = new Bankcard();
                bankcard.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(47062);
        }
        return bankcard;
    }

    public final ArrayList<Bankcard> cRe() {
        ArrayList<Bankcard> arrayList = null;
        AppMethodBeat.m2504i(47063);
        Cursor a = this.bSd.mo10104a("select * from WalletBankcard where cardType & " + Bankcard.twH + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47063);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.mo8995d(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(47063);
        }
        return arrayList;
    }

    public final Bankcard cRf() {
        Bankcard bankcard = null;
        AppMethodBeat.m2504i(47064);
        Cursor a = this.bSd.mo10104a("select * from WalletBankcard where cardType & " + Bankcard.twJ + " != 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47064);
        } else {
            if (a.moveToNext()) {
                bankcard = new Bankcard();
                bankcard.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(47064);
        }
        return bankcard;
    }

    /* renamed from: dU */
    public final boolean mo63409dU(List<Bankcard> list) {
        AppMethodBeat.m2504i(47065);
        for (C4925c b : list) {
            super.mo10101b(b);
        }
        Iterator it = this.bkF.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(47065);
        return true;
    }

    /* renamed from: f */
    public final boolean mo63410f(Bankcard bankcard) {
        AppMethodBeat.m2504i(47066);
        if (super.mo10101b((C4925c) bankcard)) {
            Iterator it = this.bkF.iterator();
            while (it.hasNext()) {
                it.next();
            }
            AppMethodBeat.m2505o(47066);
            return true;
        }
        AppMethodBeat.m2505o(47066);
        return false;
    }

    public final boolean apM() {
        AppMethodBeat.m2504i(47067);
        boolean hY = this.bSd.mo10108hY("WalletBankcard", "delete from WalletBankcard");
        AppMethodBeat.m2505o(47067);
        return hY;
    }
}
