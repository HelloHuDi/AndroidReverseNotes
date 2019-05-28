package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class ah {
    public ArrayList<Bankcard> tCN = new ArrayList();
    public String tCO;

    public ah() {
        AppMethodBeat.i(46944);
        AppMethodBeat.o(46944);
    }

    public final Bankcard acB(String str) {
        Bankcard bankcard;
        AppMethodBeat.i(46945);
        if (this.tCN.size() > 0) {
            Iterator it = this.tCN.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    break;
                }
            }
            bankcard = null;
            if (bankcard == null) {
                ab.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
            } else {
                ab.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
            }
        } else {
            ab.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
            bankcard = null;
        }
        AppMethodBeat.o(46945);
        return bankcard;
    }

    public final boolean cPU() {
        AppMethodBeat.i(46946);
        if (this.tCN.size() > 0) {
            AppMethodBeat.o(46946);
            return true;
        }
        AppMethodBeat.o(46946);
        return false;
    }

    public final Bankcard cPV() {
        AppMethodBeat.i(46947);
        Bankcard bankcard;
        if (!cPU()) {
            ab.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
            AppMethodBeat.o(46947);
            return null;
        } else if (TextUtils.isEmpty(this.tCO)) {
            ab.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
            bankcard = (Bankcard) this.tCN.get(0);
            AppMethodBeat.o(46947);
            return bankcard;
        } else {
            bankcard = acB(this.tCO);
            AppMethodBeat.o(46947);
            return bankcard;
        }
    }
}
