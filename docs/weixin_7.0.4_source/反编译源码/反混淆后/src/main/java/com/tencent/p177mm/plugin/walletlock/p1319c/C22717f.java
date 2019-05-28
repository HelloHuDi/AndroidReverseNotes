package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26255ur;
import com.tencent.p177mm.p230g.p231a.C32643tr;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1057a.C14373a;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1058ui.FingerprintWalletLockUI;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C29714a;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40175b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40176d;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C46391e;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.GestureGuardLogicUI;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.protocal.protobuf.bim;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.walletlock.c.f */
public final class C22717f {
    public C4884c tWT = new C29710c();
    public C4884c tWU = new C227191();
    private C4884c tWV = new C227202();
    public C4884c tWW = new C227183();

    /* renamed from: com.tencent.mm.plugin.walletlock.c.f$3 */
    class C227183 extends C4884c<C32643tr> {
        C227183() {
            AppMethodBeat.m2504i(51711);
            this.xxI = C32643tr.class.getName().hashCode();
            AppMethodBeat.m2505o(51711);
        }

        /* renamed from: a */
        private static boolean m34499a(C32643tr c32643tr) {
            AppMethodBeat.m2504i(51712);
            bim bim = c32643tr.cPQ.cPR;
            C40171g c40171g = C40171g.tWY;
            C40171g.cTq();
            if (C46391e.m87262b(bim)) {
                C4990ab.m7417i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", Integer.valueOf(bim.wLS.getILen()), Boolean.valueOf(C46391e.m87262b(bim)), Integer.valueOf(bim.wLT), Integer.valueOf(bim.wLR));
                C40176d.m68912a(bim);
            } else {
                C4990ab.m7420w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
            }
            C4990ab.m7417i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", Boolean.valueOf(C46391e.cTz()));
            C40175b.m68909nx(r0);
            ((C40167b) C1720g.m3528K(C40167b.class)).init();
            AppMethodBeat.m2505o(51712);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.c.f$1 */
    class C227191 extends C4884c<C26255ur> {
        C227191() {
            AppMethodBeat.m2504i(51706);
            this.xxI = C26255ur.class.getName().hashCode();
            AppMethodBeat.m2505o(51706);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(51707);
            C26255ur c26255ur = (C26255ur) c4883b;
            C4990ab.m7417i("MicroMsg.WalletLockInitTask", "alvinluo wallet lock protect request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(c26255ur.cRv.cRx), Boolean.valueOf(C40172i.tXc.cUd()), Boolean.valueOf(C40172i.tXc.cUe()));
            C40171g c40171g;
            Object obj;
            long cTr;
            switch (c26255ur.cRv.cRx) {
                case 0:
                    if (!(c26255ur.cRv.activity instanceof GestureGuardLogicUI) && !(c26255ur.cRv.activity instanceof FingerprintWalletLockUI)) {
                        c40171g = C40171g.tWY;
                        if (c26255ur == null) {
                            obj = null;
                        } else if (C40172i.tXc.cUd()) {
                            C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                            C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                            C40172i.tXc.mo63515nB(false);
                            obj = null;
                        } else {
                            C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(c40171g.mType));
                            if (c40171g.mType == 2) {
                                cTr = C14373a.cTr();
                            } else if (c40171g.mType == 1) {
                                cTr = C40176d.cTr();
                            } else {
                                obj = null;
                            }
                            C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, PREVENT_INPUT_PWD_SECONDS: %d", Long.valueOf(cTr), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - cTr) / 1000), Integer.valueOf(C29714a.tVy));
                            if (cTr == -1 || r2 >= ((long) C29714a.tVy) || C40171g.tWY.cTk()) {
                                C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                                obj = 1;
                            } else {
                                C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            c26255ur.cRw.data = Integer.valueOf(16);
                            break;
                        }
                        c26255ur.cRw.data = Integer.valueOf(17);
                        break;
                    }
                    c26255ur.cRw.data = Integer.valueOf(16);
                    break;
                    break;
                case 1:
                    if (!(c26255ur.cRv.activity instanceof GestureGuardLogicUI) && !(c26255ur.cRv.activity instanceof FingerprintWalletLockUI)) {
                        c40171g = C40171g.tWY;
                        if (c26255ur == null) {
                            obj = null;
                        } else if (C40172i.tXc.cUd()) {
                            C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                            C40172i.tXc.mo63515nB(false);
                            C40172i.tXc.mo63516nC(false);
                            obj = null;
                        } else if (C40172i.tXc.cUe()) {
                            C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            C40172i.tXc.mo63515nB(false);
                            C40172i.tXc.mo63516nC(false);
                            obj = null;
                        } else {
                            C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo current wallet lock type: %d", Integer.valueOf(c40171g.mType));
                            if (c40171g.mType == 2) {
                                cTr = C14373a.cTr();
                            } else if (c40171g.mType == 1) {
                                cTr = C40176d.cTr();
                            } else {
                                obj = null;
                            }
                            C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                            C4990ab.m7417i("MicroMsg.WalletLockManager", "alvinluo lastVerifyOkTime: %d, elapsedRealTime: %d, pastTime: %d, %d", Long.valueOf(cTr), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf((SystemClock.elapsedRealtime() - cTr) / 1000), Integer.valueOf(C29714a.tVy));
                            if (cTr == -1 || r2 >= ((long) C29714a.tVy) || C40171g.tWY.cTk()) {
                                C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                obj = 1;
                            } else {
                                C4990ab.m7410d("MicroMsg.WalletLockManager", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            c26255ur.cRw.data = Integer.valueOf(16);
                            break;
                        }
                        c26255ur.cRw.data = Integer.valueOf(17);
                        break;
                    }
                    c26255ur.cRw.data = Integer.valueOf(16);
                    break;
                    break;
            }
            c26255ur.cRv.activity = null;
            C4990ab.m7417i("MicroMsg.WalletLockInitTask", "alvinluo protect result: %s", c26255ur.cRw.data);
            AppMethodBeat.m2505o(51707);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.c.f$2 */
    class C227202 extends C4884c<C26255ur> {
        C227202() {
            AppMethodBeat.m2504i(51708);
            this.xxI = C26255ur.class.getName().hashCode();
            AppMethodBeat.m2505o(51708);
        }

        /* renamed from: a */
        private static boolean m34502a(C26255ur c26255ur) {
            AppMethodBeat.m2504i(51709);
            C4990ab.m7419v("MicroMsg.WalletLockInitTask", "alvinluo gestureprotectListener request: %d, verfiyMaskOnCreate: %b, verfiyMaskOnResume: %b", Integer.valueOf(c26255ur.cRv.cRx), Boolean.valueOf(C40172i.tXc.cUd()), Boolean.valueOf(C40172i.tXc.cUe()));
            long cTr;
            long elapsedRealtime;
            switch (c26255ur.cRv.cRx) {
                case 0:
                    if (!(c26255ur.cRv.activity instanceof GestureGuardLogicUI)) {
                        if (!C40172i.tXc.cUd()) {
                            cTr = C40176d.cTr();
                            elapsedRealtime = (SystemClock.elapsedRealtime() - cTr) / 1000;
                            if (cTr != -1 && elapsedRealtime < ((long) C29714a.tVy) && (!C40175b.cTA() || !C40175b.cTz())) {
                                C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                                c26255ur.cRw.data = Integer.valueOf(16);
                                C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                                break;
                            }
                            C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates needs verify.");
                            c26255ur.cRw.data = Integer.valueOf(17);
                            break;
                        }
                        C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                        c26255ur.cRw.data = Integer.valueOf(16);
                        C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                        C40172i.tXc.mo63515nB(false);
                        break;
                    }
                    C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONCREATE indicates need not verify.");
                    c26255ur.cRw.data = Integer.valueOf(16);
                    break;
                case 1:
                    if (!(c26255ur.cRv.activity instanceof GestureGuardLogicUI)) {
                        if (!C40172i.tXc.cUd()) {
                            if (!C40172i.tXc.cUe()) {
                                cTr = C40176d.cTr();
                                elapsedRealtime = (SystemClock.elapsedRealtime() - cTr) / 1000;
                                if ((cTr == -1 || elapsedRealtime >= ((long) C29714a.tVy) || C40175b.cTA()) && C40175b.cTz()) {
                                    C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates needs verify.");
                                    c26255ur.cRw.data = Integer.valueOf(17);
                                } else {
                                    C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                                    c26255ur.cRw.data = Integer.valueOf(16);
                                }
                                C40172i.tXc.mo63510c(new WeakReference(c26255ur.cRv.activity));
                                break;
                            }
                            C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates reenter.");
                            C40172i.tXc.mo63515nB(false);
                            C40172i.tXc.mo63516nC(false);
                            c26255ur.cRw.data = Integer.valueOf(18);
                            break;
                        }
                        C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                        C40172i.tXc.mo63515nB(false);
                        C40172i.tXc.mo63516nC(false);
                        c26255ur.cRw.data = Integer.valueOf(16);
                        break;
                    }
                    C4990ab.m7410d("MicroMsg.WalletLockInitTask", "REQUEST_PROTECT_ME_ONRESUME indicates need not verify.");
                    c26255ur.cRw.data = Integer.valueOf(16);
                    break;
                    break;
                case 2:
                    c26255ur.cRw.data = Boolean.valueOf(C46391e.cTz());
                    break;
                case 3:
                    c26255ur.cRw.data = Boolean.valueOf(C40175b.cTA());
                    break;
                case 4:
                    C40172i.tXc.cUf();
                    break;
            }
            c26255ur.cRv.activity = null;
            AppMethodBeat.m2505o(51709);
            return false;
        }
    }

    public C22717f() {
        AppMethodBeat.m2504i(51714);
        AppMethodBeat.m2505o(51714);
    }
}
