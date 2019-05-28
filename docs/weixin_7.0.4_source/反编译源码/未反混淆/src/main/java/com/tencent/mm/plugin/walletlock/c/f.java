package com.tencent.mm.plugin.walletlock.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.a;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class f {
    public c tWT = new c();
    public c tWU = new c<ur>() {
        {
            AppMethodBeat.i(51706);
            this.xxI = ur.class.getName().hashCode();
            AppMethodBeat.o(51706);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(51707);
            ur urVar = (ur) bVar;
            ab.i("MicroMsg.WalletLockInitTask", "alvinluo wallet lock protect request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(urVar.cRv.cRx), Boolean.valueOf(i.tXc.cUd()), Boolean.valueOf(i.tXc.cUe()));
            g gVar;
            Object obj;
            long cTr;
            switch (urVar.cRv.cRx) {
                case 0:
                    if (!(urVar.cRv.activity instanceof GestureGuardLogicUI) && !(urVar.cRv.activity instanceof FingerprintWalletLockUI)) {
                        gVar = g.tWY;
                        if (urVar == null) {
                            obj = null;
                        } else if (i.tXc.cUd()) {
                            ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            i.tXc.c(new WeakReference(urVar.cRv.activity));
                            i.tXc.nB(false);
                            obj = null;
                        } else {
                            ab.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(gVar.mType));
                            if (gVar.mType == 2) {
                                cTr = a.cTr();
                            } else if (gVar.mType == 1) {
                                cTr = d.cTr();
                            } else {
                                obj = null;
                            }
                            ab.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, PREVENT_INPUT_PWD_SECONDS: %d", Long.valueOf(cTr), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - cTr) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.tVy));
                            if (cTr == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tVy) || g.tWY.cTk()) {
                                ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                obj = 1;
                            } else {
                                ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                i.tXc.c(new WeakReference(urVar.cRv.activity));
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            urVar.cRw.data = Integer.valueOf(16);
                            break;
                        }
                        urVar.cRw.data = Integer.valueOf(17);
                        break;
                    }
                    urVar.cRw.data = Integer.valueOf(16);
                    break;
                    break;
                case 1:
                    if (!(urVar.cRv.activity instanceof GestureGuardLogicUI) && !(urVar.cRv.activity instanceof FingerprintWalletLockUI)) {
                        gVar = g.tWY;
                        if (urVar == null) {
                            obj = null;
                        } else if (i.tXc.cUd()) {
                            ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            i.tXc.nB(false);
                            i.tXc.nC(false);
                            obj = null;
                        } else if (i.tXc.cUe()) {
                            ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            i.tXc.nB(false);
                            i.tXc.nC(false);
                            obj = null;
                        } else {
                            ab.i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(gVar.mType));
                            if (gVar.mType == 2) {
                                cTr = a.cTr();
                            } else if (gVar.mType == 1) {
                                cTr = d.cTr();
                            } else {
                                obj = null;
                            }
                            i.tXc.c(new WeakReference(urVar.cRv.activity));
                            ab.i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, %d", Long.valueOf(cTr), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - cTr) / 1000), Integer.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.a.tVy));
                            if (cTr == -1 || r2 >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tVy) || g.tWY.cTk()) {
                                ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                obj = 1;
                            } else {
                                ab.d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            urVar.cRw.data = Integer.valueOf(16);
                            break;
                        }
                        urVar.cRw.data = Integer.valueOf(17);
                        break;
                    }
                    urVar.cRw.data = Integer.valueOf(16);
                    break;
                    break;
            }
            urVar.cRv.activity = null;
            ab.i("MicroMsg.WalletLockInitTask", "alvinluo protect result: %s", urVar.cRw.data);
            AppMethodBeat.o(51707);
            return false;
        }
    };
    private c tWV = new c<ur>() {
        {
            AppMethodBeat.i(51708);
            this.xxI = ur.class.getName().hashCode();
            AppMethodBeat.o(51708);
        }

        private static boolean a(ur urVar) {
            AppMethodBeat.i(51709);
            ab.v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(urVar.cRv.cRx), Boolean.valueOf(i.tXc.cUd()), Boolean.valueOf(i.tXc.cUe()));
            long cTr;
            long elapsedRealtime;
            switch (urVar.cRv.cRx) {
                case 0:
                    if (!(urVar.cRv.activity instanceof GestureGuardLogicUI)) {
                        if (!i.tXc.cUd()) {
                            cTr = d.cTr();
                            elapsedRealtime = (SystemClock.elapsedRealtime() - cTr) / 1000;
                            if (cTr != -1 && elapsedRealtime < ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tVy) && (!com.tencent.mm.plugin.walletlock.gesture.a.b.cTA() || !com.tencent.mm.plugin.walletlock.gesture.a.b.cTz())) {
                                ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                urVar.cRw.data = Integer.valueOf(16);
                                i.tXc.c(new WeakReference(urVar.cRv.activity));
                                break;
                            }
                            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                            urVar.cRw.data = Integer.valueOf(17);
                            break;
                        }
                        ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        urVar.cRw.data = Integer.valueOf(16);
                        i.tXc.c(new WeakReference(urVar.cRv.activity));
                        i.tXc.nB(false);
                        break;
                    }
                    ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                    urVar.cRw.data = Integer.valueOf(16);
                    break;
                case 1:
                    if (!(urVar.cRv.activity instanceof GestureGuardLogicUI)) {
                        if (!i.tXc.cUd()) {
                            if (!i.tXc.cUe()) {
                                cTr = d.cTr();
                                elapsedRealtime = (SystemClock.elapsedRealtime() - cTr) / 1000;
                                if ((cTr == -1 || elapsedRealtime >= ((long) com.tencent.mm.plugin.walletlock.gesture.a.a.tVy) || com.tencent.mm.plugin.walletlock.gesture.a.b.cTA()) && com.tencent.mm.plugin.walletlock.gesture.a.b.cTz()) {
                                    ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                    urVar.cRw.data = Integer.valueOf(17);
                                } else {
                                    ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                    urVar.cRw.data = Integer.valueOf(16);
                                }
                                i.tXc.c(new WeakReference(urVar.cRv.activity));
                                break;
                            }
                            ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            i.tXc.nB(false);
                            i.tXc.nC(false);
                            urVar.cRw.data = Integer.valueOf(18);
                            break;
                        }
                        ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        i.tXc.nB(false);
                        i.tXc.nC(false);
                        urVar.cRw.data = Integer.valueOf(16);
                        break;
                    }
                    ab.d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                    urVar.cRw.data = Integer.valueOf(16);
                    break;
                    break;
                case 2:
                    urVar.cRw.data = Boolean.valueOf(e.cTz());
                    break;
                case 3:
                    urVar.cRw.data = Boolean.valueOf(com.tencent.mm.plugin.walletlock.gesture.a.b.cTA());
                    break;
                case 4:
                    i.tXc.cUf();
                    break;
            }
            urVar.cRv.activity = null;
            AppMethodBeat.o(51709);
            return false;
        }
    };
    public c tWW = new c<tr>() {
        {
            AppMethodBeat.i(51711);
            this.xxI = tr.class.getName().hashCode();
            AppMethodBeat.o(51711);
        }

        private static boolean a(tr trVar) {
            AppMethodBeat.i(51712);
            bim bim = trVar.cPQ.cPR;
            g gVar = g.tWY;
            g.cTq();
            if (e.b(bim)) {
                ab.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", Integer.valueOf(bim.wLS.getILen()), Boolean.valueOf(e.b(bim)), Integer.valueOf(bim.wLT), Integer.valueOf(bim.wLR));
                d.a(bim);
            } else {
                ab.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
            }
            ab.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", Boolean.valueOf(e.cTz()));
            com.tencent.mm.plugin.walletlock.gesture.a.b.nx(r0);
            ((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).init();
            AppMethodBeat.o(51712);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(51714);
        AppMethodBeat.o(51714);
    }
}
