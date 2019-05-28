package com.tencent.p177mm.plugin.wallet_core.model;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ai */
public final class C29629ai {
    public int tCP = 0;
    private int tCQ = 0;

    public C29629ai(int i, int i2) {
        AppMethodBeat.m2504i(46948);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(196660, Integer.valueOf(i));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BALANCE_SHOW_INT, Integer.valueOf(i2));
        this.tCP = i;
        this.tCQ = i2;
        C4990ab.m7416i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i + "balanceShow:" + i2);
        AppMethodBeat.m2505o(46948);
    }

    public C29629ai() {
        AppMethodBeat.m2504i(46949);
        C1720g.m3537RQ();
        this.tCP = ((Integer) C1720g.m3536RP().mo5239Ry().get(196660, Integer.valueOf(0))).intValue();
        C1720g.m3537RQ();
        this.tCQ = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BALANCE_SHOW_INT, Integer.valueOf(0))).intValue();
        C4990ab.m7416i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.tCP + "balanceShow:" + this.tCQ);
        AppMethodBeat.m2505o(46949);
    }

    public final boolean cPW() {
        boolean z;
        AppMethodBeat.m2504i(46950);
        if ((this.tCP & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46950);
        return z;
    }

    public final boolean cNb() {
        boolean z;
        AppMethodBeat.m2504i(46951);
        if ((this.tCP & 4) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46951);
        return z;
    }

    public final boolean cPX() {
        boolean z;
        AppMethodBeat.m2504i(46952);
        if ((this.tCP & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46952);
        return z;
    }

    public final boolean cPY() {
        boolean z;
        AppMethodBeat.m2504i(46953);
        if ((this.tCP & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46953);
        return z;
    }

    public final boolean cPZ() {
        boolean z;
        AppMethodBeat.m2504i(46954);
        if ((this.tCP & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46954);
        return z;
    }

    public final boolean cQa() {
        boolean z;
        AppMethodBeat.m2504i(46955);
        if ((this.tCP & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46955);
        return z;
    }

    public final boolean adL() {
        boolean z;
        AppMethodBeat.m2504i(46956);
        if ((this.tCP & Utility.DEFAULT_STREAM_BUFFER_SIZE) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46956);
        return z;
    }

    public final boolean cQb() {
        boolean z;
        AppMethodBeat.m2504i(46957);
        if ((this.tCP & 262144) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isReportWifiSSid, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46957);
        return z;
    }

    public final boolean cQc() {
        boolean z;
        AppMethodBeat.m2504i(46958);
        if ((this.tCP & 8388608) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isReportCellInfo, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46958);
        return z;
    }

    public final boolean cQd() {
        boolean z;
        AppMethodBeat.m2504i(46959);
        if ((this.tCP & 32768) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46959);
        return z;
    }

    public final boolean cQe() {
        boolean z;
        AppMethodBeat.m2504i(46960);
        if ((this.tCP & 2097152) > 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46960);
        return z;
    }

    public final boolean cQf() {
        AppMethodBeat.m2504i(46961);
        C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isShowBalance, ret = %s switchBit %s", Boolean.valueOf(C5046bo.m7563gW(this.tCQ, 1)), Integer.valueOf(this.tCP));
        AppMethodBeat.m2505o(46961);
        return C5046bo.m7563gW(this.tCQ, 1);
    }
}
