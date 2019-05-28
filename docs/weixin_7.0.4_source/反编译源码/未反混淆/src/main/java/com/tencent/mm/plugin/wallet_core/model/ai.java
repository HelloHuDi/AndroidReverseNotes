package com.tencent.mm.plugin.wallet_core.model;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class ai {
    public int tCP = 0;
    private int tCQ = 0;

    public ai(int i, int i2) {
        AppMethodBeat.i(46948);
        g.RQ();
        g.RP().Ry().set(196660, Integer.valueOf(i));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_WALLET_BALANCE_SHOW_INT, Integer.valueOf(i2));
        this.tCP = i;
        this.tCQ = i2;
        ab.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i + "balanceShow:" + i2);
        AppMethodBeat.o(46948);
    }

    public ai() {
        AppMethodBeat.i(46949);
        g.RQ();
        this.tCP = ((Integer) g.RP().Ry().get(196660, Integer.valueOf(0))).intValue();
        g.RQ();
        this.tCQ = ((Integer) g.RP().Ry().get(a.USERINFO_WALLET_BALANCE_SHOW_INT, Integer.valueOf(0))).intValue();
        ab.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.tCP + "balanceShow:" + this.tCQ);
        AppMethodBeat.o(46949);
    }

    public final boolean cPW() {
        boolean z;
        AppMethodBeat.i(46950);
        if ((this.tCP & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46950);
        return z;
    }

    public final boolean cNb() {
        boolean z;
        AppMethodBeat.i(46951);
        if ((this.tCP & 4) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46951);
        return z;
    }

    public final boolean cPX() {
        boolean z;
        AppMethodBeat.i(46952);
        if ((this.tCP & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46952);
        return z;
    }

    public final boolean cPY() {
        boolean z;
        AppMethodBeat.i(46953);
        if ((this.tCP & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46953);
        return z;
    }

    public final boolean cPZ() {
        boolean z;
        AppMethodBeat.i(46954);
        if ((this.tCP & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46954);
        return z;
    }

    public final boolean cQa() {
        boolean z;
        AppMethodBeat.i(46955);
        if ((this.tCP & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46955);
        return z;
    }

    public final boolean adL() {
        boolean z;
        AppMethodBeat.i(46956);
        if ((this.tCP & Utility.DEFAULT_STREAM_BUFFER_SIZE) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46956);
        return z;
    }

    public final boolean cQb() {
        boolean z;
        AppMethodBeat.i(46957);
        if ((this.tCP & 262144) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46957);
        return z;
    }

    public final boolean cQc() {
        boolean z;
        AppMethodBeat.i(46958);
        if ((this.tCP & 8388608) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46958);
        return z;
    }

    public final boolean cQd() {
        boolean z;
        AppMethodBeat.i(46959);
        if ((this.tCP & 32768) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46959);
        return z;
    }

    public final boolean cQe() {
        boolean z;
        AppMethodBeat.i(46960);
        if ((this.tCP & 2097152) > 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46960);
        return z;
    }

    public final boolean cQf() {
        AppMethodBeat.i(46961);
        ab.i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", Boolean.valueOf(bo.gW(this.tCQ, 1)), Integer.valueOf(this.tCP));
        AppMethodBeat.o(46961);
        return bo.gW(this.tCQ, 1);
    }
}
