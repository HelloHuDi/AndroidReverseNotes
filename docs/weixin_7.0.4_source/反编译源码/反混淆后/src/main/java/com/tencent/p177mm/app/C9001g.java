package com.tencent.p177mm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.blink.C9085c.C13171;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.kernel.p238a.C6615d;
import com.tencent.p177mm.kernel.p238a.p240b.C6598g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.kiss.p243a.C1742b.C1739b;
import com.tencent.p177mm.kiss.p243a.C1742b.C17441;
import com.tencent.p177mm.kiss.p243a.C32721a;
import com.tencent.p177mm.modelrecovery.PluginRecovery;
import com.tencent.p177mm.p1638bs.C45273a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p210ca.C32432a.C32433a;
import com.tencent.p177mm.p217ci.C18167k;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p237k.C1640a;
import com.tencent.p177mm.p237k.C1640a.C1641a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.auth.PluginAuth;
import com.tencent.p177mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.p177mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.PluginReport;
import com.tencent.p177mm.plugin.zero.PluginZero;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.splash.C5115h;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.vfs.FileSystemManager.C5715a;
import com.tencent.p177mm.vfs.FileSystemManager.C5716b;
import com.tencent.xweb.WebView.C44570d;
import java.security.Key;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.app.g */
public final class C9001g extends C6615d {
    private static boolean cel = true;
    private C18167k cej = new C18167k();
    private volatile boolean cek = false;

    /* renamed from: com.tencent.mm.app.g$1 */
    class C89981 implements C1640a {
        C89981() {
        }

        /* renamed from: Bi */
        public final boolean mo5101Bi() {
            AppMethodBeat.m2504i(138006);
            C45287c.m83502a(C44570d.WV_KIND_CW);
            boolean dPa = C45287c.dPa();
            AppMethodBeat.m2505o(138006);
            return dPa;
        }
    }

    /* renamed from: com.tencent.mm.app.g$2 */
    class C89992 implements C32433a {
        C89992() {
        }

        /* renamed from: Bj */
        public final void mo20433Bj() {
            AppMethodBeat.m2504i(138010);
            C45273a.m83446jB(C4996ah.getContext());
            AppMethodBeat.m2505o(138010);
        }
    }

    /* renamed from: com.tencent.mm.app.g$3 */
    class C90023 implements C5716b {
        C90023() {
        }

        /* renamed from: Bk */
        private static boolean m16236Bk() {
            AppMethodBeat.m2504i(138007);
            try {
                boolean RK = C1720g.m3531RK();
                AppMethodBeat.m2505o(138007);
                return RK;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(138007);
                return false;
            }
        }

        /* renamed from: e */
        public final Key mo11629e(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(138008);
            if (map.get("account") == null || !C90023.m16236Bk()) {
                AppMethodBeat.m2505o(138008);
                return null;
            }
            C4990ab.m7416i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(str)));
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            Key secretKeySpec = new SecretKeySpec(C1178g.m2592y(stringBuilder.append(C1668a.m3384QG()).append(str).toString().getBytes()), "RC4");
            AppMethodBeat.m2505o(138008);
            return secretKeySpec;
        }
    }

    public C9001g() {
        AppMethodBeat.m2504i(137994);
        AppMethodBeat.m2505o(137994);
    }

    /* renamed from: Bh */
    static /* synthetic */ void m16227Bh() {
        AppMethodBeat.m2504i(138002);
        C9001g.m16226Bf();
        AppMethodBeat.m2505o(138002);
    }

    /* renamed from: Bd */
    public final void mo5147Bd() {
        AppMethodBeat.m2504i(137995);
        super.mo5147Bd();
        C1651a.m3339k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
        C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        C25794l.m41016cT(((C6624h) C1720g.m3533RM().mo5224Rn()).eHT);
        C1266q.m2720G(C1318a.class);
        C1266q.m2722cY("com.tencent.mm.boot");
        C1266q.m2721a(((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc, ((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc.getResources());
        if (C4996ah.isAppBrandProcess()) {
            C1641a.m3315a(new C89981());
        }
        Application application = ((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc;
        C4996ah.m7431f(C18121b.m28547a(application.getResources(), application));
        C32432a.m53092a(new C89992());
        AppMethodBeat.m2505o(137995);
    }

    /* renamed from: Be */
    public final void mo5148Be() {
        AppMethodBeat.m2504i(137996);
        C1720g.m3532RL().eJD = C44035d.class;
        C6615d.m10917Q(PluginZero.class);
        C6615d.m10917Q(PluginMessengerFoundation.class);
        C6615d.m10917Q(PluginReport.class);
        C6615d.m10917Q(PluginAuth.class);
        C6615d.m10917Q(PluginBigBallOfMud.class);
        C6615d.m10917Q(PluginRecovery.class);
        C6615d.m10918lO("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
        C6615d.m10918lO("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        C6615d.m10918lO("com.tencent.mm.plugin.avatar.PluginAvatar");
        C6615d.m10918lO("com.tencent.mm.plugin.comm.PluginComm");
        C6615d.m10918lO("com.tencent.mm.plugin.audio.PluginVoice");
        C6615d.m10918lO("com.tencent.mm.plugin.biz.PluginBiz");
        mo14831lP("com.tencent.mm.plugin.bizui.PluginBIZUI");
        C6615d.m10918lO("com.tencent.mm.plugin.brandservice.PluginBrandService");
        C6615d.m10918lO("com.tencent.mm.plugin.readerapp.PluginReaderApp");
        C6615d.m10918lO("com.tencent.mm.plugin.notification.PluginNotification");
        C6615d.m10918lO("com.tencent.mm.plugin.messenger.PluginMessenger");
        C6615d.m10918lO("com.tencent.mm.plugin.welab.PluginWelab");
        C6615d.m10918lO("com.tencent.mm.plugin.sport.PluginSport");
        C6615d.m10918lO("com.tencent.mm.plugin.fts.PluginFTS");
        C6615d.m10918lO("com.tencent.mm.openim.PluginOpenIM");
        mo14831lP("com.tencent.mm.plugin.misc.PluginMisc");
        C6615d.m10918lO("com.tencent.mm.openim.room.PluginOpenIMRoom");
        C6615d.m10918lO("com.tencent.mm.roomsdk.PluginRoomSdk");
        C6615d.m10918lO("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
        C6615d.m10918lO("com.tencent.mm.plugin.abtest.PluginABTest");
        C6615d.m10918lO("com.tencent.mm.plugin.backup.PluginBackup");
        C6615d.m10918lO("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
        mo14831lP("com.tencent.mm.plugin.performance.PluginPerformance");
        mo14831lP("com.tencent.mm.plugin.chatroom.PluginChatroom");
        mo14831lP("com.tencent.mm.PluginFunctionMsg");
        mo14831lP("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        mo14831lP("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        mo14831lP("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
        mo14831lP("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
        mo14831lP("com.tencent.mm.plugin.uishow.PluginUIShow");
        mo14831lP("com.tencent.mm.plugin.emoji.PluginEmoji");
        mo14831lP("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
        mo14831lP("com.tencent.mm.plugin.game.PluginGame");
        mo14831lP("com.tencent.mm.game.report.PluginGameReport");
        mo14831lP("com.tencent.mm.plugin.wepkg.PluginWePkg");
        mo14831lP("com.tencent.mm.plugin.game.commlib.PluginCommLib");
        mo14831lP("com.tencent.mm.plugin.video.PluginVideo");
        mo14831lP("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        mo14831lP("com.tencent.mm.plugin.sns.PluginSns");
        mo14831lP("com.tencent.mm.plugin.downloader.PluginDownloader");
        mo14831lP("com.tencent.mm.plugin.fav.PluginFav");
        mo14831lP("com.tencent.mm.plugin.fav.ui.PluginFavUI");
        mo14831lP("com.tencent.mm.plugin.record.PluginRecord");
        mo14831lP("com.tencent.mm.plugin.music.PluginMusic");
        mo14831lP("com.tencent.mm.plugin.MMPhotoEditPlugin");
        mo14831lP("com.tencent.mm.plugin.account.PluginAccount");
        mo14831lP("com.tencent.mm.plugin.facedetect.PluginFace");
        mo14831lP("com.tencent.mm.plugin.soter.PluginSoter");
        mo14831lP("com.tencent.mm.plugin.walletlock.PluginWalletLock");
        mo14831lP("com.tencent.mm.plugin.wxpay.PluginWxPay");
        mo14831lP("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        mo14831lP("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
        mo14831lP("com.tencent.mm.plugin.radar.PluginRadar");
        mo14831lP("com.tencent.mm.plugin.topstory.PluginTopStory");
        mo14831lP("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
        mo14831lP("com.tencent.mm.plugin.websearch.PluginWebSearch");
        mo14831lP("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
        mo14831lP("com.tencent.mm.plugin.card.PluginCard");
        mo14831lP("com.tencent.mm.plugin.card.compat.PluginCardCompat");
        mo14831lP("com.tencent.mm.plugin.kitchen.PluginKitchen");
        mo14831lP("com.tencent.mm.plugin.expt.PluginExpt");
        mo14831lP("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
        mo14831lP("com.tencent.mm.plugin.monitor.PluginMonitor");
        mo14831lP("com.tencent.mm.plugin.fcm.PluginFCM");
        mo14831lP("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
        mo14831lP("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
        mo14831lP("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
        mo14831lP("com.tencent.mm.plugin.webview.PluginWebView");
        mo14831lP("com.tencent.mm.plugin.priority.PluginPriority");
        mo14831lP("com.tencent.mm.plugin.mmsight.PluginMMSight");
        mo14831lP("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        mo14831lP("com.tencent.mm.plugin.normsg.PluginNormsg");
        mo14831lP("com.tencent.mm.plugin.netmock.PluginNetMock");
        if (C5058f.xxZ.amr("ENABLE_STETHO")) {
            mo14831lP("com.tencent.mm.plugin.stetho.PluginStetho");
        }
        mo14831lP("com.tencent.mm.plugin.appbrand.functions.comm.preloader.PluginLFPreloader");
        mo14831lP("com.tencent.mm.plugin.boots.PluginBoots");
        mo14831lP("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
        mo14831lP("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
        mo14831lP("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
        mo14831lP("com.tencent.mm.plugin.story.PluginStory");
        C6598g c6598g = C6610c.m10890Sa().eKU;
        C1677a M = C1720g.m3530M(C6983p.class);
        c6598g.eMh.put(C1671c.class, M);
        AppMethodBeat.m2505o(137996);
    }

    /* renamed from: a */
    public final void mo5151a(final C1681g c1681g) {
        AppMethodBeat.m2504i(137997);
        FileSystemManager.m8610se(!c1681g.mo5181SG());
        FileSystemManager.m8600a(new C90023());
        C9001g.m16226Bf();
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            new C5004al("Startup-SideWork").mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137958);
                    LayoutInflater e;
                    Looper looper;
                    C1742b SM;
                    try {
                        e = C9001g.this.cej;
                        byte[] bArr = e.eHH;
                        synchronized (bArr) {
                            looper = e.eHH;
                            C9001g.this.cej.done();
                            ContextWrapper contextWrapper = new ContextWrapper(c1681g.f1233cc);
                            SM = C1742b.m3596SM();
                            looper = C32721a.m53394SL().eMJ.getLooper();
                            e = C5616v.m8409hu(contextWrapper);
                            boolean z = SM.eMP;
                            if (!z) {
                                SM.eMP = z;
                                SM.mInflater = e;
                                SM.eMN = looper;
                                SM.mMode = 2;
                                SM.eMO = new C17441(SM.eMN);
                                if (C1443d.m3067fP(26)) {
                                    SM.eMR = new C1739b(looper);
                                }
                            }
                            C1311a.m2792HJ();
                            Context baseContext = ((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc.getBaseContext();
                            boolean a = C1742b.m3596SM().mo5275a("R.layout.actionbar_title_launcher", 1, 2130968619, new LinearLayout(baseContext), false, new int[0]);
                            z = true;
                            C1742b.m3596SM().mo5276a("R.layout.main_tab", 1, 2130970021, new int[0]);
                            if (C1338a.m2865ga(baseContext)) {
                                C1742b.m3596SM().mo5275a("R.layout.mm_bottom_tabitem_large", 4, 2130970103, new LinearLayout(baseContext), false, new int[0]);
                            } else {
                                z = true;
                                C1742b.m3596SM().mo5275a("R.layout.mm_bottom_tabitem", 4, 2130970102, new LinearLayout(baseContext), false, new int[0]);
                            }
                            C1742b.m3596SM().mo5276a("R.layout.mm_activity", 4, 2130970087, new int[0]);
                            if (!(Build.BRAND.equals("vivo") && C1443d.m3067fP(20))) {
                                C1742b.m3596SM().mo5276a("R.layout.main", 1, 2130970018, new int[0]);
                                C1742b.m3596SM().mo5276a("R.layout.address", 1, 2130968638, new int[0]);
                                C1742b.m3596SM().mo5276a("R.layout.mm_preference_fragment_list_content", 2, 2130970177, new int[0]);
                            }
                            z = true;
                            C1742b.m3596SM().mo5276a("R.layout.actionview_with_dot_tips", 1, 2130968621, new int[0]);
                            if (C1338a.m2865ga(baseContext)) {
                                C1742b.m3596SM().mo5275a("R.layout.conversation_item_with_cache_large", 8, 2130969244, null, false, new int[0]);
                            } else if (C1338a.m2867gc(baseContext)) {
                                C1742b.m3596SM().mo5275a("R.layout.conversation_item_with_cache_small", 8, 2130969245, null, false, new int[0]);
                            } else {
                                C1742b.m3596SM().mo5275a("R.layout.conversation_item_with_cache", 8, 2130969243, null, false, new int[0]);
                            }
                            if (a) {
                                C1742b SM2 = C1742b.m3596SM();
                                SM2.eMO.post(new C13171());
                            }
                            C9001g.this.cej.done();
                            AppMethodBeat.m2505o(137958);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            String str = "MicroMsg.DefaultBootStep";
                            looper = "";
                            C9001g.this.cej.done();
                            AppMethodBeat.m2505o(137958);
                        } catch (Throwable th) {
                            C9001g.this.cej.done();
                            AppMethodBeat.m2505o(137958);
                        }
                    } finally {
                        while (true) {
                        }
                        SM = 137958;
                        AppMethodBeat.m2505o(137958);
                    }
                }
            });
        }
        if (c1681g.mo5181SG()) {
            FileSystemManager dMy = FileSystemManager.dMy();
            dMy.Cap = false;
            C5715a ens = dMy.ens();
            ens.zYT.clear();
            ens.zYU.clear();
            ens.zYW.clear();
            ens.zZn = null;
            ens.zZo = true;
            ens.commit();
        }
        super.mo5151a(c1681g);
        AppMethodBeat.m2505o(137997);
    }

    /* renamed from: Bf */
    private static void m16226Bf() {
        AppMethodBeat.m2504i(137998);
        long currentTimeMillis = System.currentTimeMillis();
        C1266q.m2719Bz();
        C1311a.m2810s(4, System.currentTimeMillis() - currentTimeMillis);
        C1311a.m2810s(5, 1);
        C4990ab.m7417i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", Long.valueOf(currentTimeMillis));
        AppMethodBeat.m2505o(137998);
    }

    /* renamed from: b */
    public final void mo5152b(C1681g c1681g) {
        AppMethodBeat.m2504i(137999);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C18167k c18167k = this.cej;
            synchronized (c18167k.eHH) {
                try {
                    if (c18167k.eHH[0] == (byte) -1) {
                        C1736j.m3587i("MicroMsg.WxWaitingLock", "waiting %s", c18167k);
                        c18167k.eHH.wait();
                        C1736j.m3587i("MicroMsg.WxWaitingLock", "after waiting %s", c18167k);
                    }
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.WxWaitingLock", e, "", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(137999);
                }
            }
            if (this.cek) {
                C4990ab.m7412e("MicroMsg.DefaultBootStep", "SVG still failed!");
            }
        }
        super.mo5152b(c1681g);
        AppMethodBeat.m2505o(137999);
    }

    /* renamed from: Bg */
    public final boolean mo14830Bg() {
        AppMethodBeat.m2504i(138000);
        if (cel) {
            AppMethodBeat.m2505o(138000);
            return true;
        } else if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C1720g.m3534RN();
            if (C1668a.m3395QX() && C1720g.m3534RN().mo5161QY()) {
                if (C5115h.xGC.size() == 1) {
                    if (C4996ah.doy().equals(C5115h.m7774an((Activity) C5115h.xGC.get(0)))) {
                        C4990ab.m7416i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
                        AppMethodBeat.m2505o(138000);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(138000);
                return true;
            }
            AppMethodBeat.m2505o(138000);
            return true;
        } else {
            AppMethodBeat.m2505o(138000);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m16229a(C9001g c9001g, final C1681g c1681g) {
        AppMethodBeat.m2504i(138001);
        new C5039bj() {
            public final Object run() {
                AppMethodBeat.m2504i(137967);
                C9001g.m16227Bh();
                AppMethodBeat.m2505o(137967);
                return null;
            }
        }.mo10372b(new C7306ak(Looper.getMainLooper()));
        AppMethodBeat.m2505o(138001);
    }
}
