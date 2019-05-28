package com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.C11755a;
import com.tencent.p177mm.plugin.expt.hellhound.core.C11759b;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.C27897a;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a.C38989b;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C20600d;
import com.tencent.p177mm.plugin.expt.p394a.C20593b.C11746b;
import com.tencent.p177mm.plugin.expt.p394a.C43014c.C38982a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44101be;
import com.tencent.p177mm.protocal.protobuf.acp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7370b;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.a.b */
public final class C34073b {
    private static volatile C34073b lMQ;
    C11752a lMO = new C11752a();
    public C11746b lMP;
    private boolean lMR = false;
    private boolean lMS = false;
    private boolean lMT = true;

    public static C34073b bqF() {
        AppMethodBeat.m2504i(73450);
        if (lMQ == null) {
            synchronized (C34073b.class) {
                try {
                    if (lMQ == null) {
                        lMQ = new C34073b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73450);
                    }
                }
            }
        }
        C34073b c34073b = lMQ;
        AppMethodBeat.m2505o(73450);
        return c34073b;
    }

    private C34073b() {
        AppMethodBeat.m2504i(73451);
        AppMethodBeat.m2505o(73451);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x02ad  */
    /* JADX WARNING: Missing block: B:122:0x0494, code skipped:
            if ("com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(r0) != false) goto L_0x0496;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: s */
    public static void m55845s(int i, String str, String str2) {
        boolean z = true;
        AppMethodBeat.m2504i(73452);
        if (C11755a.bqk()) {
            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor start !!!");
            C34073b bqF = C34073b.bqF();
            String str3;
            acp bqE;
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                    if (!TextUtils.isEmpty(str)) {
                        boolean KR;
                        int i2;
                        String str4;
                        switch (i) {
                            case 100:
                                if (!TextUtils.isEmpty(str)) {
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: " + str + "/" + str2);
                                    if (bqF.m55840KV(str)) {
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx TRUE");
                                        C27897a.m44362uX(7);
                                        C11752a.m19560uY(7);
                                        bqF.m55843ef(str, str2);
                                    } else {
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx FALSE");
                                        try {
                                            C7583c bqy;
                                            KR = C38989b.bqC().lMN.mo73733KR(str);
                                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isStartActivity: ".concat(String.valueOf(KR)));
                                            if (KR) {
                                                i2 = 0;
                                            } else {
                                                KR = C38989b.bqC().lMN.bqB();
                                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isFinish: ".concat(String.valueOf(KR)));
                                                if (KR) {
                                                    i2 = 0;
                                                } else {
                                                    if (!TextUtils.isEmpty(str)) {
                                                        C20600d.bqu();
                                                        bqy = C20600d.bqy();
                                                        if (bqy != null) {
                                                            str4 = (String) bqy.get(0);
                                                            str3 = (String) bqy.get(1);
                                                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront resume/pause " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " / " + str4 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3);
                                                            if (!(str.equals(str4) && str2.equals(str3))) {
                                                                i2 = 0;
                                                            }
                                                        }
                                                    }
                                                    if (C11759b.m19573KN(str)) {
                                                        C4990ab.m7412e("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront 7事件，过滤小程序");
                                                        i2 = 0;
                                                    } else {
                                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront ret: true");
                                                        KR = true;
                                                    }
                                                }
                                            }
                                            if (i2 == 0) {
                                                bqE = C11752a.bqE();
                                                if (bqE == null || bqE.wkl != 8) {
                                                    KR = false;
                                                } else {
                                                    KR = true;
                                                }
                                                if (KR) {
                                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFrontToBackAction.lastAction: true");
                                                    if ("com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(str)) {
                                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _isBackToFront 过滤掉第三方App进入微信的场景: ".concat(String.valueOf(str)));
                                                    } else {
                                                        bqF.lMS = true;
                                                    }
                                                } else {
                                                    C20600d.bqu();
                                                    bqy = C20600d.bqy();
                                                    CharSequence charSequence = null;
                                                    if (bqy != null) {
                                                        charSequence = (String) bqy.get(0);
                                                    }
                                                    if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(charSequence)) {
                                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor _isBackToFront: crash路径 !!!");
                                                        C7060h.pYm.mo8378a(932, 98, 1, false);
                                                    }
                                                }
                                                z = false;
                                            }
                                            if (z) {
                                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: YES");
                                                C27897a.m44362uX(7);
                                                C11752a.m19560uY(7);
                                                bqF.m55843ef(str, str2);
                                            } else {
                                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: FALSE");
                                            }
                                        } catch (Exception e) {
                                            C4990ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, backToFront", new Object[0]);
                                            C7060h.pYm.mo8378a(932, 44, 1, false);
                                        }
                                    }
                                }
                                bqE = C11752a.bqE();
                                if (bqE == null) {
                                    bqE = new acp();
                                }
                                if (C11759b.bqo()) {
                                    bqE.wkn = Process.myPid();
                                }
                                bqE.wko = str;
                                bqE.wkp = str2;
                                bqE.wkm = System.currentTimeMillis();
                                C4990ab.m7410d("FrontBackDao", "habbyge-mali, setLastMMProcessParamsOnResume: " + bqE.wko + "/" + bqE.fQi);
                                C11752a.m19558a(bqE);
                                AppMethodBeat.m2505o(73452);
                                return;
                            case 101:
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_PAUSE: ".concat(String.valueOf(str)));
                                C20600d.bqu();
                                C44101be bqv = C20600d.bqv();
                                if (bqv != null) {
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause topActivity: " + bqv.vDg.activityName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqv.vDg.wkp);
                                    if (!bqv.vDg.activityName.startsWith("com.tencent.mm")) {
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause 栈顶非微信页面: " + bqv.vDg.activityName);
                                        KR = true;
                                    } else if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(bqv.vDg.activityName) && "com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(str)) {
                                        KR = true;
                                    }
                                    if (!KR) {
                                        KR = C38989b.bqC().lMN.mo73735KT(str);
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.startActivity: " + KR + "/" + str);
                                        if (KR) {
                                            bqF.lMT = false;
                                            AppMethodBeat.m2505o(73452);
                                            return;
                                        }
                                        KR = C38989b.bqC().lMN.mo73736KU(str);
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.finish: " + KR + "/" + str);
                                        if (KR) {
                                            bqF.lMT = false;
                                            AppMethodBeat.m2505o(73452);
                                            return;
                                        }
                                    }
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause front2back YES: ".concat(String.valueOf(str)));
                                    C27897a.m44362uX(8);
                                    C11752a.m19560uY(8);
                                    bqF.lMT = true;
                                    bqF.m55844eg(str, str2);
                                    AppMethodBeat.m2505o(73452);
                                    return;
                                }
                                KR = false;
                                if (KR) {
                                }
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause front2back YES: ".concat(String.valueOf(str)));
                                C27897a.m44362uX(8);
                                C11752a.m19560uY(8);
                                bqF.lMT = true;
                                bqF.m55844eg(str, str2);
                                AppMethodBeat.m2505o(73452);
                                return;
                            case 102:
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_STOP: ".concat(String.valueOf(str)));
                                if (TextUtils.isEmpty(str)) {
                                    C4990ab.m7412e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop == null");
                                    AppMethodBeat.m2505o(73452);
                                    return;
                                } else if (bqF.lMT) {
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop isFront2Back-1: true");
                                    AppMethodBeat.m2505o(73452);
                                    return;
                                } else {
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop stopActivityName: ".concat(String.valueOf(str)));
                                    try {
                                        C7625d ee = C34073b.m55842ee(str, str2);
                                        if (ee == null || !((Boolean) ee.get(2)).booleanValue()) {
                                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop: false");
                                            AppMethodBeat.m2505o(73452);
                                            return;
                                        }
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop: " + ((String) ee.get(0)) + " / true");
                                        C27897a.m44362uX(8);
                                        C11752a.m19560uY(8);
                                        bqF.m55844eg(str, str2);
                                        AppMethodBeat.m2505o(73452);
                                        return;
                                    } catch (Exception e2) {
                                        C4990ab.printErrStackTrace("HellFrontBackMonitor", e2, "habbyge-mali, judgeFront2BackOnStop", new Object[0]);
                                        C7060h.pYm.mo8378a(932, 42, 1, false);
                                        AppMethodBeat.m2505o(73452);
                                        return;
                                    }
                                }
                            case 103:
                                C7583c bqx;
                                Object obj;
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_FINISH: ".concat(String.valueOf(str)));
                                C20600d.bqu();
                                if (str == null) {
                                    try {
                                        C4990ab.m7412e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: aName == null");
                                        bqx = C20600d.bqx();
                                        if (bqx != null) {
                                            str2 = null;
                                            obj = (String) bqx.get(0);
                                        }
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish activity==null: ".concat(String.valueOf(obj)));
                                        i2 = 0;
                                    } catch (Exception e22) {
                                        C4990ab.printErrStackTrace("HellFrontBackMonitor", e22, "habbyge-mali, judgeFront2BackOnFinish", new Object[0]);
                                        C7060h.pYm.mo8378a(932, 40, 1, false);
                                        break;
                                    }
                                }
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: ".concat(String.valueOf(str)));
                                KR = true;
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish, aName: ".concat(String.valueOf(obj)));
                                if (i2 != 0 && "com.tencent.mm.ui.LauncherUI".equals(obj)) {
                                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, shutdown && isLuancherUI");
                                    bqx = C20600d.bqy();
                                    if (bqx != null) {
                                        str4 = (String) bqx.get(0);
                                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _quiteActivity.pause = ".concat(String.valueOf(str4)));
                                        break;
                                    }
                                    z = false;
                                    if (z) {
                                        C11752a.m19560uY(8);
                                        C27897a.m44362uX(8);
                                        bqF.m55844eg(obj, str2);
                                    }
                                }
                                AppMethodBeat.m2505o(73452);
                                return;
                        }
                    }
                    AppMethodBeat.m2505o(73452);
                    return;
                case 104:
                    C7370b c7370b;
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed");
                    if (C11759b.bqo()) {
                        C7370b c7370b2;
                        int myPid = Process.myPid();
                        bqE = C11752a.bqE();
                        if (bqE == null) {
                            bqE = new acp();
                        }
                        if (bqE.wkn <= 0) {
                            C4990ab.m7416i("FrontBackDao", "habbyge-mali, handleLastProcessParams lastMMProcessId <= 0");
                            c7370b2 = null;
                        } else {
                            if (bqE.wkn != myPid) {
                                C4990ab.m7416i("FrontBackDao", "habbyge-mali, handleLastProcessParams last != curr ---1: " + bqE.wkn + "/" + myPid);
                                if (bqE.wkl == 7) {
                                    boolean z2;
                                    C34073b.bqF();
                                    acp bqE2 = C11752a.bqE();
                                    if (bqE2 == null || !bqE2.wkq) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        C4990ab.m7420w("FrontBackDao", "habbyge-mali, getIsLogoutFromMMPageFlowService true");
                                        C11752a.m19559gR(false);
                                        c7370b = null;
                                    } else {
                                        int i3;
                                        str3 = "page_hell_seq_mmkv_key";
                                        if (TextUtils.isEmpty(str3)) {
                                            i3 = -1;
                                        } else {
                                            i3 = C5018as.amF("_hellhound_mmkv").getInt(str3, -1);
                                        }
                                        bqE.fQi = i3;
                                        c7370b2 = C5710a.m8575b(bqE.wko, bqE.wkp, Integer.valueOf(bqE.wkn), Long.valueOf(bqE.wkm), Integer.valueOf(bqE.fQi));
                                    }
                                }
                            } else {
                                C4990ab.m7416i("FrontBackDao", "habbyge-mali, handleLastProcessParams last == curr: " + bqE.wkn + "/" + myPid);
                            }
                            c7370b2 = null;
                        }
                        c7370b = c7370b2;
                    } else {
                        c7370b = null;
                    }
                    if (c7370b != null) {
                        C11752a.m19560uY(8);
                        C27897a.m44362uX(8);
                        str3 = (String) c7370b.get(0);
                        String str5 = (String) c7370b.get(1);
                        int intValue = ((Integer) c7370b.get(2)).intValue();
                        long longValue = ((Long) c7370b.get(3)).longValue();
                        int intValue2 = ((Integer) c7370b.get(4)).intValue();
                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed need 补充8事件: " + str3 + "/" + intValue + "/" + longValue + "/" + intValue2);
                        if (bqF.lMP != null) {
                            bqF.lMP.mo23506a(str3, str5, intValue, longValue, intValue2);
                        }
                    }
                    AppMethodBeat.m2505o(73452);
                    return;
                case 105:
                    C34074c.m55847a("login", C38982a.MMActivity_Back2Front, 1, C5046bo.anU());
                    AppMethodBeat.m2505o(73452);
                    return;
                case 106:
                    C34074c.m55847a("logout", C38982a.MMActivity_Front2Back, -1, C5046bo.anU());
                    break;
            }
            AppMethodBeat.m2505o(73452);
            return;
        }
        C4990ab.m7420w("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor close !!!");
        AppMethodBeat.m2505o(73452);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: KV */
    private boolean m55840KV(String str) {
        String str2;
        String str3;
        AppMethodBeat.m2504i(73453);
        C20600d.bqu();
        try {
            C7583c bqy = C20600d.bqy();
            if (bqy != null) {
                str2 = (String) bqy.get(0);
                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx resume/pause = " + str + "/" + str2);
                if (!"com.tencent.mm.plugin.voip.ui.VideoActivity".equals(str) && (TextUtils.isEmpty(str2) || "com.tencent.mm.app.WeChatSplashActivity".equals(str2))) {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, VOIP start MM Process");
                    AppMethodBeat.m2505o(73453);
                    return true;
                } else if ("com.tencent.mm.app.WeChatSplashActivity".equals(str) || !TextUtils.isEmpty(str2)) {
                    if ("com.tencent.mm.app.WeChatSplashActivity".equals(str)) {
                        boolean z;
                        if (str2 == null || !str2.startsWith("com.tencent.mm.splash.")) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 splash hook restart ~");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        }
                    }
                    if ("com.tencent.mm.ui.LauncherUI".equals(str) || !TextUtils.isEmpty(str2)) {
                        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str2) && !"com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(str)) {
                            str3 = "com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI";
                            if (!("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(str) || str3.equals(str))) {
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 3");
                                AppMethodBeat.m2505o(73453);
                                return true;
                            }
                        }
                        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str2) && "com.tencent.mm.ui.LauncherUI".equals(str)) {
                            this.lMR = true;
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 4");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        } else if ("com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(str) && str2 == null) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx: frome outer jump to Timeline");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        } else if ("com.tencent.mm.ui.tools.AddFavoriteUI".equals(str) && "com.tencent.mm.app.WeChatSplashActivity".equals(str2)) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx: from outer jump to 收藏");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        } else if (C34073b.m55841KW(str)) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过小程序桌面快捷方式");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        } else if ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(str)) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
                            AppMethodBeat.m2505o(73453);
                            return true;
                        } else {
                            if ("com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(str) && "com.tencent.mm.ui.LauncherUI".equals(str2)) {
                                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 之前登录过，登录页");
                                if (this.lMR) {
                                    this.lMR = false;
                                } else if (this.lMS) {
                                    this.lMS = false;
                                } else {
                                    AppMethodBeat.m2505o(73453);
                                    return true;
                                }
                            }
                            AppMethodBeat.m2505o(73453);
                            return false;
                        }
                    }
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 2");
                    AppMethodBeat.m2505o(73453);
                    return true;
                } else {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 1");
                    AppMethodBeat.m2505o(73453);
                    return true;
                }
            }
        } catch (Exception e) {
            C7060h.pYm.mo8378a(932, 45, 1, false);
        }
        str2 = null;
        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx resume/pause = " + str + "/" + str2);
        if (!"com.tencent.mm.plugin.voip.ui.VideoActivity".equals(str)) {
        }
        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str)) {
        }
        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str)) {
        }
        if ("com.tencent.mm.ui.LauncherUI".equals(str)) {
        }
        str3 = "com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI";
        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 3");
        AppMethodBeat.m2505o(73453);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: KW */
    private static boolean m55841KW(String str) {
        Object obj;
        int i;
        AppMethodBeat.m2504i(73454);
        C20600d.bqu();
        try {
            C7583c bqy = C20600d.bqy();
            if (bqy != null) {
                obj = (String) bqy.get(0);
                if (C11759b.m19573KN(str) || !"com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(obj)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-1");
                    AppMethodBeat.m2505o(73454);
                    return true;
                }
                if (C11759b.m19573KN(str) && TextUtils.isEmpty(obj)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-2");
                    AppMethodBeat.m2505o(73454);
                    return true;
                }
                boolean z;
                if (C11759b.m19573KN(str) && "com.tencent.mm.app.WeChatSplashActivity".equals(obj)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-3");
                }
                AppMethodBeat.m2505o(73454);
                return z;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, isStartWxByLittlePragramShortcut", new Object[0]);
        }
        obj = null;
        if (C11759b.m19573KN(str)) {
        }
        i = 0;
        if (i == 0) {
        }
    }

    /* renamed from: ee */
    private static C7625d<String, String, Boolean> m55842ee(String str, String str2) {
        AppMethodBeat.m2504i(73455);
        C20600d.bqu();
        try {
            C7583c bqx = C20600d.bqx();
            C7583c bqy = C20600d.bqy();
            if (str == null || bqx == null || bqy == null) {
                C4990ab.m7412e("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: illeagal Event");
                AppMethodBeat.m2505o(73455);
                return null;
            }
            if ("com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals((String) bqx.get(0))) {
                C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFakeSwitchAccountUI true");
                AppMethodBeat.m2505o(73455);
                return null;
            }
            int i;
            boolean z;
            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: Resume/pause/stop = " + bqx + "/" + bqy + "/" + str);
            int i2;
            if (str2.equals(bqx.get(1)) && str2.equals(bqy.get(1))) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (str.equals(bqx.get(0)) && str.equals(bqy.get(0))) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 || i2 == 0) {
                z = false;
            } else {
                z = true;
            }
            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop, case-1：".concat(String.valueOf(z)));
            if (z) {
                C44101be bqv = C20600d.bqv();
                if (bqv != null) {
                    C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8: " + bqv.vDg.activityName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqv.vDg.wkp);
                    if (!bqv.vDg.activityName.startsWith("com.tencent.mm")) {
                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: NOT wx activity");
                    } else if (TextUtils.isEmpty(bqv.vDg.wkp)) {
                        if (!bqv.vDg.activityName.equals(str)) {
                            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-1: false");
                            z = false;
                        }
                    } else if (!C20600d.m31828k(str, str2, bqv.vDg.activityName, bqv.vDg.wkp)) {
                        C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-2: false");
                        z = false;
                    }
                }
            }
            C4990ab.m7416i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop case1 && case2：".concat(String.valueOf(z)));
            C7625d<String, String, Boolean> i3 = C5710a.m8577i(str, str2, Boolean.valueOf(z));
            AppMethodBeat.m2505o(73455);
            return i3;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, isFront2BackOnStop", new Object[0]);
            C7060h.pYm.mo8378a(932, 43, 1, false);
            AppMethodBeat.m2505o(73455);
            return null;
        }
    }

    /* renamed from: ef */
    private void m55843ef(String str, String str2) {
        AppMethodBeat.m2504i(73456);
        if (this.lMP != null) {
            this.lMP.mo23507ec(str, str2);
        }
        AppMethodBeat.m2505o(73456);
    }

    /* renamed from: eg */
    private void m55844eg(String str, String str2) {
        AppMethodBeat.m2504i(73457);
        if (this.lMP != null) {
            this.lMP.mo23508ed(str, str2);
        }
        AppMethodBeat.m2505o(73457);
    }
}
