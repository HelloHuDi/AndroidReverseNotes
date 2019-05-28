package com.tencent.mm.plugin.expt.hellhound.a.a;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.c;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class b {
    private static volatile b lMQ;
    a lMO = new a();
    public com.tencent.mm.plugin.expt.a.b.b lMP;
    private boolean lMR = false;
    private boolean lMS = false;
    private boolean lMT = true;

    public static b bqF() {
        AppMethodBeat.i(73450);
        if (lMQ == null) {
            synchronized (b.class) {
                try {
                    if (lMQ == null) {
                        lMQ = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73450);
                    }
                }
            }
        }
        b bVar = lMQ;
        AppMethodBeat.o(73450);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(73451);
        AppMethodBeat.o(73451);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x02ad  */
    /* JADX WARNING: Missing block: B:122:0x0494, code skipped:
            if ("com.tencent.mm.plugin.setting.ui.setting.SettingsUI".equals(r0) != false) goto L_0x0496;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void s(int i, String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(73452);
        if (a.bqk()) {
            ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor start !!!");
            b bqF = bqF();
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
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: " + str + "/" + str2);
                                    if (bqF.KV(str)) {
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx TRUE");
                                        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(7);
                                        a.uY(7);
                                        bqF.ef(str, str2);
                                    } else {
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeBackToFront: _launchWx FALSE");
                                        try {
                                            c bqy;
                                            KR = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.bqC().lMN.KR(str);
                                            ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isStartActivity: ".concat(String.valueOf(KR)));
                                            if (KR) {
                                                i2 = 0;
                                            } else {
                                                KR = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.bqC().lMN.bqB();
                                                ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront isFinish: ".concat(String.valueOf(KR)));
                                                if (KR) {
                                                    i2 = 0;
                                                } else {
                                                    if (!TextUtils.isEmpty(str)) {
                                                        d.bqu();
                                                        bqy = d.bqy();
                                                        if (bqy != null) {
                                                            str4 = (String) bqy.get(0);
                                                            str3 = (String) bqy.get(1);
                                                            ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront resume/pause " + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str2 + " / " + str4 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3);
                                                            if (!(str.equals(str4) && str2.equals(str3))) {
                                                                i2 = 0;
                                                            }
                                                        }
                                                    }
                                                    if (com.tencent.mm.plugin.expt.hellhound.core.b.KN(str)) {
                                                        ab.e("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront 7事件，过滤小程序");
                                                        i2 = 0;
                                                    } else {
                                                        ab.i("HellFrontBackMonitor", "habbyge-mali, _doIsBackToFront ret: true");
                                                        KR = true;
                                                    }
                                                }
                                            }
                                            if (i2 == 0) {
                                                bqE = a.bqE();
                                                if (bqE == null || bqE.wkl != 8) {
                                                    KR = false;
                                                } else {
                                                    KR = true;
                                                }
                                                if (KR) {
                                                    ab.i("HellFrontBackMonitor", "habbyge-mali, isFrontToBackAction.lastAction: true");
                                                    if ("com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(str)) {
                                                        ab.i("HellFrontBackMonitor", "habbyge-mali, _isBackToFront 过滤掉第三方App进入微信的场景: ".concat(String.valueOf(str)));
                                                    } else {
                                                        bqF.lMS = true;
                                                    }
                                                } else {
                                                    d.bqu();
                                                    bqy = d.bqy();
                                                    CharSequence charSequence = null;
                                                    if (bqy != null) {
                                                        charSequence = (String) bqy.get(0);
                                                    }
                                                    if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(charSequence)) {
                                                        ab.i("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor _isBackToFront: crash路径 !!!");
                                                        h.pYm.a(932, 98, 1, false);
                                                    }
                                                }
                                                z = false;
                                            }
                                            if (z) {
                                                ab.i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: YES");
                                                com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(7);
                                                a.uY(7);
                                                bqF.ef(str, str2);
                                            } else {
                                                ab.i("HellFrontBackMonitor", "habbyge-mali, backToFront: isFrontToBackOfLastAction: FALSE");
                                            }
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, backToFront", new Object[0]);
                                            h.pYm.a(932, 44, 1, false);
                                        }
                                    }
                                }
                                bqE = a.bqE();
                                if (bqE == null) {
                                    bqE = new acp();
                                }
                                if (com.tencent.mm.plugin.expt.hellhound.core.b.bqo()) {
                                    bqE.wkn = Process.myPid();
                                }
                                bqE.wko = str;
                                bqE.wkp = str2;
                                bqE.wkm = System.currentTimeMillis();
                                ab.d("FrontBackDao", "habbyge-mali, setLastMMProcessParamsOnResume: " + bqE.wko + "/" + bqE.fQi);
                                a.a(bqE);
                                AppMethodBeat.o(73452);
                                return;
                            case 101:
                                ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_PAUSE: ".concat(String.valueOf(str)));
                                d.bqu();
                                be bqv = d.bqv();
                                if (bqv != null) {
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause topActivity: " + bqv.vDg.activityName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqv.vDg.wkp);
                                    if (!bqv.vDg.activityName.startsWith("com.tencent.mm")) {
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause 栈顶非微信页面: " + bqv.vDg.activityName);
                                        KR = true;
                                    } else if ("com.tencent.mm.ui.transmit.SendAppMessageWrapperUI".equals(bqv.vDg.activityName) && "com.tencent.mm.plugin.sns.ui.SnsUploadUI".equals(str)) {
                                        KR = true;
                                    }
                                    if (!KR) {
                                        KR = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.bqC().lMN.KT(str);
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.startActivity: " + KR + "/" + str);
                                        if (KR) {
                                            bqF.lMT = false;
                                            AppMethodBeat.o(73452);
                                            return;
                                        }
                                        KR = com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b.bqC().lMN.KU(str);
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause.finish: " + KR + "/" + str);
                                        if (KR) {
                                            bqF.lMT = false;
                                            AppMethodBeat.o(73452);
                                            return;
                                        }
                                    }
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause front2back YES: ".concat(String.valueOf(str)));
                                    com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
                                    a.uY(8);
                                    bqF.lMT = true;
                                    bqF.eg(str, str2);
                                    AppMethodBeat.o(73452);
                                    return;
                                }
                                KR = false;
                                if (KR) {
                                }
                                ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnPause front2back YES: ".concat(String.valueOf(str)));
                                com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
                                a.uY(8);
                                bqF.lMT = true;
                                bqF.eg(str, str2);
                                AppMethodBeat.o(73452);
                                return;
                            case 102:
                                ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_STOP: ".concat(String.valueOf(str)));
                                if (TextUtils.isEmpty(str)) {
                                    ab.e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop == null");
                                    AppMethodBeat.o(73452);
                                    return;
                                } else if (bqF.lMT) {
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop isFront2Back-1: true");
                                    AppMethodBeat.o(73452);
                                    return;
                                } else {
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop stopActivityName: ".concat(String.valueOf(str)));
                                    try {
                                        com.tencent.mm.vending.j.d ee = ee(str, str2);
                                        if (ee == null || !((Boolean) ee.get(2)).booleanValue()) {
                                            ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop: false");
                                            AppMethodBeat.o(73452);
                                            return;
                                        }
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnStop: " + ((String) ee.get(0)) + " / true");
                                        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
                                        a.uY(8);
                                        bqF.eg(str, str2);
                                        AppMethodBeat.o(73452);
                                        return;
                                    } catch (Exception e2) {
                                        ab.printErrStackTrace("HellFrontBackMonitor", e2, "habbyge-mali, judgeFront2BackOnStop", new Object[0]);
                                        h.pYm.a(932, 42, 1, false);
                                        AppMethodBeat.o(73452);
                                        return;
                                    }
                                }
                            case 103:
                                c bqx;
                                Object obj;
                                ab.i("HellFrontBackMonitor", "habbyge-mali, frontBack ACTION_FINISH: ".concat(String.valueOf(str)));
                                d.bqu();
                                if (str == null) {
                                    try {
                                        ab.e("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: aName == null");
                                        bqx = d.bqx();
                                        if (bqx != null) {
                                            str2 = null;
                                            obj = (String) bqx.get(0);
                                        }
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish activity==null: ".concat(String.valueOf(obj)));
                                        i2 = 0;
                                    } catch (Exception e22) {
                                        ab.printErrStackTrace("HellFrontBackMonitor", e22, "habbyge-mali, judgeFront2BackOnFinish", new Object[0]);
                                        h.pYm.a(932, 40, 1, false);
                                        break;
                                    }
                                }
                                ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish: ".concat(String.valueOf(str)));
                                KR = true;
                                ab.i("HellFrontBackMonitor", "habbyge-mali, judgeFront2BackOnFinish, aName: ".concat(String.valueOf(obj)));
                                if (i2 != 0 && "com.tencent.mm.ui.LauncherUI".equals(obj)) {
                                    ab.i("HellFrontBackMonitor", "habbyge-mali, shutdown && isLuancherUI");
                                    bqx = d.bqy();
                                    if (bqx != null) {
                                        str4 = (String) bqx.get(0);
                                        ab.i("HellFrontBackMonitor", "habbyge-mali, _quiteActivity.pause = ".concat(String.valueOf(str4)));
                                        break;
                                    }
                                    z = false;
                                    if (z) {
                                        a.uY(8);
                                        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
                                        bqF.eg(obj, str2);
                                    }
                                }
                                AppMethodBeat.o(73452);
                                return;
                        }
                    }
                    AppMethodBeat.o(73452);
                    return;
                case 104:
                    com.tencent.mm.vending.j.b bVar;
                    ab.i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed");
                    if (com.tencent.mm.plugin.expt.hellhound.core.b.bqo()) {
                        com.tencent.mm.vending.j.b bVar2;
                        int myPid = Process.myPid();
                        bqE = a.bqE();
                        if (bqE == null) {
                            bqE = new acp();
                        }
                        if (bqE.wkn <= 0) {
                            ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams lastMMProcessId <= 0");
                            bVar2 = null;
                        } else {
                            if (bqE.wkn != myPid) {
                                ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last != curr ---1: " + bqE.wkn + "/" + myPid);
                                if (bqE.wkl == 7) {
                                    boolean z2;
                                    bqF();
                                    acp bqE2 = a.bqE();
                                    if (bqE2 == null || !bqE2.wkq) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        ab.w("FrontBackDao", "habbyge-mali, getIsLogoutFromMMPageFlowService true");
                                        a.gR(false);
                                        bVar = null;
                                    } else {
                                        int i3;
                                        str3 = "page_hell_seq_mmkv_key";
                                        if (TextUtils.isEmpty(str3)) {
                                            i3 = -1;
                                        } else {
                                            i3 = as.amF("_hellhound_mmkv").getInt(str3, -1);
                                        }
                                        bqE.fQi = i3;
                                        bVar2 = com.tencent.mm.vending.j.a.b(bqE.wko, bqE.wkp, Integer.valueOf(bqE.wkn), Long.valueOf(bqE.wkm), Integer.valueOf(bqE.fQi));
                                    }
                                }
                            } else {
                                ab.i("FrontBackDao", "habbyge-mali, handleLastProcessParams last == curr: " + bqE.wkn + "/" + myPid);
                            }
                            bVar2 = null;
                        }
                        bVar = bVar2;
                    } else {
                        bVar = null;
                    }
                    if (bVar != null) {
                        a.uY(8);
                        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
                        str3 = (String) bVar.get(0);
                        String str5 = (String) bVar.get(1);
                        int intValue = ((Integer) bVar.get(2)).intValue();
                        long longValue = ((Long) bVar.get(3)).longValue();
                        int intValue2 = ((Integer) bVar.get(4)).intValue();
                        ab.i("HellFrontBackMonitor", "habbyge-mali, add8EventMMProcessEndIfNeed need 补充8事件: " + str3 + "/" + intValue + "/" + longValue + "/" + intValue2);
                        if (bqF.lMP != null) {
                            bqF.lMP.a(str3, str5, intValue, longValue, intValue2);
                        }
                    }
                    AppMethodBeat.o(73452);
                    return;
                case 105:
                    c.a("login", com.tencent.mm.plugin.expt.a.c.a.MMActivity_Back2Front, 1, bo.anU());
                    AppMethodBeat.o(73452);
                    return;
                case 106:
                    c.a("logout", com.tencent.mm.plugin.expt.a.c.a.MMActivity_Front2Back, -1, bo.anU());
                    break;
            }
            AppMethodBeat.o(73452);
            return;
        }
        ab.w("HellFrontBackMonitor", "habbyge-mali, HellFrontBackMonitor monitor close !!!");
        AppMethodBeat.o(73452);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean KV(String str) {
        String str2;
        String str3;
        AppMethodBeat.i(73453);
        d.bqu();
        try {
            c bqy = d.bqy();
            if (bqy != null) {
                str2 = (String) bqy.get(0);
                ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx resume/pause = " + str + "/" + str2);
                if (!"com.tencent.mm.plugin.voip.ui.VideoActivity".equals(str) && (TextUtils.isEmpty(str2) || "com.tencent.mm.app.WeChatSplashActivity".equals(str2))) {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, VOIP start MM Process");
                    AppMethodBeat.o(73453);
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
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 splash hook restart ~");
                            AppMethodBeat.o(73453);
                            return true;
                        }
                    }
                    if ("com.tencent.mm.ui.LauncherUI".equals(str) || !TextUtils.isEmpty(str2)) {
                        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str2) && !"com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(str)) {
                            str3 = "com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI";
                            if (!("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(str) || str3.equals(str))) {
                                ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 3");
                                AppMethodBeat.o(73453);
                                return true;
                            }
                        }
                        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str2) && "com.tencent.mm.ui.LauncherUI".equals(str)) {
                            this.lMR = true;
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 4");
                            AppMethodBeat.o(73453);
                            return true;
                        } else if ("com.tencent.mm.ui.tools.ShareToTimeLineUI".equals(str) && str2 == null) {
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx: frome outer jump to Timeline");
                            AppMethodBeat.o(73453);
                            return true;
                        } else if ("com.tencent.mm.ui.tools.AddFavoriteUI".equals(str) && "com.tencent.mm.app.WeChatSplashActivity".equals(str2)) {
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx: from outer jump to 收藏");
                            AppMethodBeat.o(73453);
                            return true;
                        } else if (KW(str)) {
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过小程序桌面快捷方式");
                            AppMethodBeat.o(73453);
                            return true;
                        } else if ("com.tencent.mm.plugin.base.stub.UIEntryStub".equals(str)) {
                            ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 通过第三方拉起微信(第三方登录、分享好友、朋友圈)");
                            AppMethodBeat.o(73453);
                            return true;
                        } else {
                            if ("com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(str) && "com.tencent.mm.ui.LauncherUI".equals(str2)) {
                                ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 之前登录过，登录页");
                                if (this.lMR) {
                                    this.lMR = false;
                                } else if (this.lMS) {
                                    this.lMS = false;
                                } else {
                                    AppMethodBeat.o(73453);
                                    return true;
                                }
                            }
                            AppMethodBeat.o(73453);
                            return false;
                        }
                    }
                    ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 2");
                    AppMethodBeat.o(73453);
                    return true;
                } else {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 1");
                    AppMethodBeat.o(73453);
                    return true;
                }
            }
        } catch (Exception e) {
            h.pYm.a(932, 45, 1, false);
        }
        str2 = null;
        ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx resume/pause = " + str + "/" + str2);
        if (!"com.tencent.mm.plugin.voip.ui.VideoActivity".equals(str)) {
        }
        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str)) {
        }
        if ("com.tencent.mm.app.WeChatSplashActivity".equals(str)) {
        }
        if ("com.tencent.mm.ui.LauncherUI".equals(str)) {
        }
        str3 = "com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI";
        ab.i("HellFrontBackMonitor", "habbyge-mali, _launchWx 启动微信进程 3");
        AppMethodBeat.o(73453);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean KW(String str) {
        Object obj;
        int i;
        AppMethodBeat.i(73454);
        d.bqu();
        try {
            c bqy = d.bqy();
            if (bqy != null) {
                obj = (String) bqy.get(0);
                if (com.tencent.mm.plugin.expt.hellhound.core.b.KN(str) || !"com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(obj)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-1");
                    AppMethodBeat.o(73454);
                    return true;
                }
                if (com.tencent.mm.plugin.expt.hellhound.core.b.KN(str) && TextUtils.isEmpty(obj)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-2");
                    AppMethodBeat.o(73454);
                    return true;
                }
                boolean z;
                if (com.tencent.mm.plugin.expt.hellhound.core.b.KN(str) && "com.tencent.mm.app.WeChatSplashActivity".equals(obj)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, isStartWxByLittlePragramShortcut case-3");
                }
                AppMethodBeat.o(73454);
                return z;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, isStartWxByLittlePragramShortcut", new Object[0]);
        }
        obj = null;
        if (com.tencent.mm.plugin.expt.hellhound.core.b.KN(str)) {
        }
        i = 0;
        if (i == 0) {
        }
    }

    private static com.tencent.mm.vending.j.d<String, String, Boolean> ee(String str, String str2) {
        AppMethodBeat.i(73455);
        d.bqu();
        try {
            c bqx = d.bqx();
            c bqy = d.bqy();
            if (str == null || bqx == null || bqy == null) {
                ab.e("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: illeagal Event");
                AppMethodBeat.o(73455);
                return null;
            }
            if ("com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals((String) bqx.get(0))) {
                ab.i("HellFrontBackMonitor", "habbyge-mali, isFakeSwitchAccountUI true");
                AppMethodBeat.o(73455);
                return null;
            }
            int i;
            boolean z;
            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: Resume/pause/stop = " + bqx + "/" + bqy + "/" + str);
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
            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop, case-1：".concat(String.valueOf(z)));
            if (z) {
                be bqv = d.bqv();
                if (bqv != null) {
                    ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8: " + bqv.vDg.activityName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bqv.vDg.wkp);
                    if (!bqv.vDg.activityName.startsWith("com.tencent.mm")) {
                        ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop: NOT wx activity");
                    } else if (TextUtils.isEmpty(bqv.vDg.wkp)) {
                        if (!bqv.vDg.activityName.equals(str)) {
                            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-1: false");
                            z = false;
                        }
                    } else if (!d.k(str, str2, bqv.vDg.activityName, bqv.vDg.wkp)) {
                        ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop isEvent8-2: false");
                        z = false;
                    }
                }
            }
            ab.i("HellFrontBackMonitor", "habbyge-mali, isFront2BackOnStop case1 && case2：".concat(String.valueOf(z)));
            com.tencent.mm.vending.j.d<String, String, Boolean> i3 = com.tencent.mm.vending.j.a.i(str, str2, Boolean.valueOf(z));
            AppMethodBeat.o(73455);
            return i3;
        } catch (Exception e) {
            ab.printErrStackTrace("HellFrontBackMonitor", e, "habbyge-mali, isFront2BackOnStop", new Object[0]);
            h.pYm.a(932, 43, 1, false);
            AppMethodBeat.o(73455);
            return null;
        }
    }

    private void ef(String str, String str2) {
        AppMethodBeat.i(73456);
        if (this.lMP != null) {
            this.lMP.ec(str, str2);
        }
        AppMethodBeat.o(73456);
    }

    private void eg(String str, String str2) {
        AppMethodBeat.i(73457);
        if (this.lMP != null) {
            this.lMP.ed(str, str2);
        }
        AppMethodBeat.o(73457);
    }
}
