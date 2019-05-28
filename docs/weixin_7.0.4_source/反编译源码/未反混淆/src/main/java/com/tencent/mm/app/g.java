package com.tencent.mm.app;

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
import com.tencent.mm.R;
import com.tencent.mm.ca.b;
import com.tencent.mm.ci.k;
import com.tencent.mm.cj.c;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.j;
import com.tencent.mm.modelrecovery.PluginRecovery;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.bbom.PluginBigBallOfMud;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.v;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.xweb.WebView;
import java.security.Key;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

public final class g extends d {
    private static boolean cel = true;
    private k cej = new k();
    private volatile boolean cek = false;

    public g() {
        AppMethodBeat.i(137994);
        AppMethodBeat.o(137994);
    }

    static /* synthetic */ void Bh() {
        AppMethodBeat.i(138002);
        Bf();
        AppMethodBeat.o(138002);
    }

    public final void Bd() {
        AppMethodBeat.i(137995);
        super.Bd();
        a.k("Hello WeChat, DefaultBootStep load debugger and newInstance xlog...", new Object[0]);
        ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        l.cT(((h) com.tencent.mm.kernel.g.RM().Rn()).eHT);
        q.G(com.tencent.mm.boot.a.a.class);
        q.cY("com.tencent.mm.boot");
        q.a(((h) com.tencent.mm.kernel.g.RM().Rn()).cc, ((h) com.tencent.mm.kernel.g.RM().Rn()).cc.getResources());
        if (ah.isAppBrandProcess()) {
            com.tencent.mm.k.a.a.a(new com.tencent.mm.k.a() {
                public final boolean Bi() {
                    AppMethodBeat.i(138006);
                    c.a(WebView.d.WV_KIND_CW);
                    boolean dPa = c.dPa();
                    AppMethodBeat.o(138006);
                    return dPa;
                }
            });
        }
        Application application = ((h) com.tencent.mm.kernel.g.RM().Rn()).cc;
        ah.f(b.a(application.getResources(), application));
        com.tencent.mm.ca.a.a(new com.tencent.mm.ca.a.a() {
            public final void Bj() {
                AppMethodBeat.i(138010);
                com.tencent.mm.bs.a.jB(ah.getContext());
                AppMethodBeat.o(138010);
            }
        });
        AppMethodBeat.o(137995);
    }

    public final void Be() {
        AppMethodBeat.i(137996);
        com.tencent.mm.kernel.g.RL().eJD = com.tencent.mm.plugin.zero.a.d.class;
        d.Q(PluginZero.class);
        d.Q(PluginMessengerFoundation.class);
        d.Q(PluginReport.class);
        d.Q(PluginAuth.class);
        d.Q(PluginBigBallOfMud.class);
        d.Q(PluginRecovery.class);
        d.lO("com.tencent.mm.plugin.bbom.PluginCompatOldStructure");
        d.lO("com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync");
        d.lO("com.tencent.mm.plugin.avatar.PluginAvatar");
        d.lO("com.tencent.mm.plugin.comm.PluginComm");
        d.lO("com.tencent.mm.plugin.audio.PluginVoice");
        d.lO("com.tencent.mm.plugin.biz.PluginBiz");
        lP("com.tencent.mm.plugin.bizui.PluginBIZUI");
        d.lO("com.tencent.mm.plugin.brandservice.PluginBrandService");
        d.lO("com.tencent.mm.plugin.readerapp.PluginReaderApp");
        d.lO("com.tencent.mm.plugin.notification.PluginNotification");
        d.lO("com.tencent.mm.plugin.messenger.PluginMessenger");
        d.lO("com.tencent.mm.plugin.welab.PluginWelab");
        d.lO("com.tencent.mm.plugin.sport.PluginSport");
        d.lO("com.tencent.mm.plugin.fts.PluginFTS");
        d.lO("com.tencent.mm.openim.PluginOpenIM");
        lP("com.tencent.mm.plugin.misc.PluginMisc");
        d.lO("com.tencent.mm.openim.room.PluginOpenIMRoom");
        d.lO("com.tencent.mm.roomsdk.PluginRoomSdk");
        d.lO("com.tencent.mm.ipcinvoker.wx_extension.PluginIPC");
        d.lO("com.tencent.mm.plugin.abtest.PluginABTest");
        d.lO("com.tencent.mm.plugin.backup.PluginBackup");
        d.lO("com.tencent.mm.plugin.hardcoder.PluginHardcoder");
        lP("com.tencent.mm.plugin.performance.PluginPerformance");
        lP("com.tencent.mm.plugin.chatroom.PluginChatroom");
        lP("com.tencent.mm.PluginFunctionMsg");
        lP("com.tencent.mm.insane_statistic.PluginInsaneStatistic");
        lP("com.tencent.mm.plugin.appbrand.app.PluginAppBrand");
        lP("com.tencent.mm.plugin.appbrand.compat.PluginAppBrandCompat");
        lP("com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile");
        lP("com.tencent.mm.plugin.uishow.PluginUIShow");
        lP("com.tencent.mm.plugin.emoji.PluginEmoji");
        lP("com.tencent.mm.chatroom.plugin.PluginChatroomUI");
        lP("com.tencent.mm.plugin.game.PluginGame");
        lP("com.tencent.mm.game.report.PluginGameReport");
        lP("com.tencent.mm.plugin.wepkg.PluginWePkg");
        lP("com.tencent.mm.plugin.game.commlib.PluginCommLib");
        lP("com.tencent.mm.plugin.video.PluginVideo");
        lP("com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt");
        lP("com.tencent.mm.plugin.sns.PluginSns");
        lP("com.tencent.mm.plugin.downloader.PluginDownloader");
        lP("com.tencent.mm.plugin.fav.PluginFav");
        lP("com.tencent.mm.plugin.fav.ui.PluginFavUI");
        lP("com.tencent.mm.plugin.record.PluginRecord");
        lP("com.tencent.mm.plugin.music.PluginMusic");
        lP("com.tencent.mm.plugin.MMPhotoEditPlugin");
        lP("com.tencent.mm.plugin.account.PluginAccount");
        lP("com.tencent.mm.plugin.facedetect.PluginFace");
        lP("com.tencent.mm.plugin.soter.PluginSoter");
        lP("com.tencent.mm.plugin.walletlock.PluginWalletLock");
        lP("com.tencent.mm.plugin.wxpay.PluginWxPay");
        lP("com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk");
        lP("com.tencent.mm.plugin.wxpayapi.PluginWxPayApi");
        lP("com.tencent.mm.plugin.radar.PluginRadar");
        lP("com.tencent.mm.plugin.topstory.PluginTopStory");
        lP("com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI");
        lP("com.tencent.mm.plugin.websearch.PluginWebSearch");
        lP("com.tencent.mm.plugin.fts.ui.PluginFTSUI");
        lP("com.tencent.mm.plugin.card.PluginCard");
        lP("com.tencent.mm.plugin.card.compat.PluginCardCompat");
        lP("com.tencent.mm.plugin.kitchen.PluginKitchen");
        lP("com.tencent.mm.plugin.expt.PluginExpt");
        lP("com.tencent.mm.plugin.forcenotify.PluginForceNotify");
        lP("com.tencent.mm.plugin.monitor.PluginMonitor");
        lP("com.tencent.mm.plugin.fcm.PluginFCM");
        lP("com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture");
        lP("com.tencent.mm.plugin.selectcontact.PluginSelectContact");
        lP("com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice");
        lP("com.tencent.mm.plugin.webview.PluginWebView");
        lP("com.tencent.mm.plugin.priority.PluginPriority");
        lP("com.tencent.mm.plugin.mmsight.PluginMMSight");
        lP("com.tencent.mm.plugin.secinforeport.PluginSecInfoReport");
        lP("com.tencent.mm.plugin.normsg.PluginNormsg");
        lP("com.tencent.mm.plugin.netmock.PluginNetMock");
        if (f.xxZ.amr("ENABLE_STETHO")) {
            lP("com.tencent.mm.plugin.stetho.PluginStetho");
        }
        lP("com.tencent.mm.plugin.appbrand.functions.comm.preloader.PluginLFPreloader");
        lP("com.tencent.mm.plugin.boots.PluginBoots");
        lP("com.tencent.mm.plugin.downloader_app.PluginDownloaderApp");
        lP("com.tencent.mm.plugin.game.luggage.PluginLuggageGame");
        lP("com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor");
        lP("com.tencent.mm.plugin.story.PluginStory");
        com.tencent.mm.kernel.a.b.g gVar = com.tencent.mm.kernel.a.c.Sa().eKU;
        com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(p.class);
        gVar.eMh.put(com.tencent.mm.kernel.api.c.class, M);
        AppMethodBeat.o(137996);
    }

    public final void a(final com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(137997);
        FileSystemManager.se(!gVar.SG());
        FileSystemManager.a(new FileSystemManager.b() {
            private static boolean Bk() {
                AppMethodBeat.i(138007);
                try {
                    boolean RK = com.tencent.mm.kernel.g.RK();
                    AppMethodBeat.o(138007);
                    return RK;
                } catch (Throwable th) {
                    AppMethodBeat.o(138007);
                    return false;
                }
            }

            public final Key e(String str, Map<String, String> map) {
                AppMethodBeat.i(138008);
                if (map.get("account") == null || !AnonymousClass3.Bk()) {
                    AppMethodBeat.o(138008);
                    return null;
                }
                ab.i("VFS.Debug", "KeyGen.generate: ".concat(String.valueOf(str)));
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.RN();
                Key secretKeySpec = new SecretKeySpec(com.tencent.mm.a.g.y(stringBuilder.append(com.tencent.mm.kernel.a.QG()).append(str).toString().getBytes()), "RC4");
                AppMethodBeat.o(138008);
                return secretKeySpec;
            }
        });
        Bf();
        if (((h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            new al("Startup-SideWork").aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137958);
                    LayoutInflater e;
                    Looper looper;
                    com.tencent.mm.kiss.a.b SM;
                    try {
                        e = g.this.cej;
                        byte[] bArr = e.eHH;
                        synchronized (bArr) {
                            looper = e.eHH;
                            g.this.cej.done();
                            ContextWrapper contextWrapper = new ContextWrapper(gVar.cc);
                            SM = com.tencent.mm.kiss.a.b.SM();
                            looper = com.tencent.mm.kiss.a.a.SL().eMJ.getLooper();
                            e = v.hu(contextWrapper);
                            boolean z = SM.eMP;
                            if (!z) {
                                SM.eMP = z;
                                SM.mInflater = e;
                                SM.eMN = looper;
                                SM.mMode = 2;
                                SM.eMO = new com.tencent.mm.kiss.a.b.AnonymousClass1(SM.eMN);
                                if (com.tencent.mm.compatible.util.d.fP(26)) {
                                    SM.eMR = new com.tencent.mm.kiss.a.b.b(looper);
                                }
                            }
                            com.tencent.mm.blink.a.HJ();
                            Context baseContext = ((h) com.tencent.mm.kernel.g.RM().Rn()).cc.getBaseContext();
                            boolean a = com.tencent.mm.kiss.a.b.SM().a("R.layout.actionbar_title_launcher", 1, R.layout.ag, new LinearLayout(baseContext), false, new int[0]);
                            z = true;
                            com.tencent.mm.kiss.a.b.SM().a("R.layout.main_tab", 1, R.layout.ab9, new int[0]);
                            if (com.tencent.mm.bz.a.ga(baseContext)) {
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.mm_bottom_tabitem_large", 4, R.layout.adg, new LinearLayout(baseContext), false, new int[0]);
                            } else {
                                z = true;
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.mm_bottom_tabitem", 4, R.layout.adf, new LinearLayout(baseContext), false, new int[0]);
                            }
                            com.tencent.mm.kiss.a.b.SM().a("R.layout.mm_activity", 4, R.layout.ad1, new int[0]);
                            if (!(Build.BRAND.equals("vivo") && com.tencent.mm.compatible.util.d.fP(20))) {
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.main", 1, R.layout.ab6, new int[0]);
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.address", 1, R.layout.az, new int[0]);
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.mm_preference_fragment_list_content", 2, R.layout.afg, new int[0]);
                            }
                            z = true;
                            com.tencent.mm.kiss.a.b.SM().a("R.layout.actionview_with_dot_tips", 1, R.layout.ai, new int[0]);
                            if (com.tencent.mm.bz.a.ga(baseContext)) {
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.conversation_item_with_cache_large", 8, R.layout.ra, null, false, new int[0]);
                            } else if (com.tencent.mm.bz.a.gc(baseContext)) {
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.conversation_item_with_cache_small", 8, R.layout.rb, null, false, new int[0]);
                            } else {
                                com.tencent.mm.kiss.a.b.SM().a("R.layout.conversation_item_with_cache", 8, R.layout.r_, null, false, new int[0]);
                            }
                            if (a) {
                                com.tencent.mm.kiss.a.b SM2 = com.tencent.mm.kiss.a.b.SM();
                                SM2.eMO.post(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(15835);
                                        a.HK();
                                        AppMethodBeat.o(15835);
                                    }
                                });
                            }
                            g.this.cej.done();
                            AppMethodBeat.o(137958);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            String str = "MicroMsg.DefaultBootStep";
                            looper = "";
                            g.this.cej.done();
                            AppMethodBeat.o(137958);
                        } catch (Throwable th) {
                            g.this.cej.done();
                            AppMethodBeat.o(137958);
                        }
                    } finally {
                        while (true) {
                        }
                        SM = 137958;
                        AppMethodBeat.o(137958);
                    }
                }
            });
        }
        if (gVar.SG()) {
            FileSystemManager dMy = FileSystemManager.dMy();
            dMy.Cap = false;
            FileSystemManager.a ens = dMy.ens();
            ens.zYT.clear();
            ens.zYU.clear();
            ens.zYW.clear();
            ens.zZn = null;
            ens.zZo = true;
            ens.commit();
        }
        super.a(gVar);
        AppMethodBeat.o(137997);
    }

    private static void Bf() {
        AppMethodBeat.i(137998);
        long currentTimeMillis = System.currentTimeMillis();
        q.Bz();
        com.tencent.mm.blink.a.s(4, System.currentTimeMillis() - currentTimeMillis);
        com.tencent.mm.blink.a.s(5, 1);
        ab.i("MicroMsg.DefaultBootStep", "SVG newInstance done, spent %s", Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(137998);
    }

    public final void b(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(137999);
        if (((h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            k kVar = this.cej;
            synchronized (kVar.eHH) {
                try {
                    if (kVar.eHH[0] == (byte) -1) {
                        j.i("MicroMsg.WxWaitingLock", "waiting %s", kVar);
                        kVar.eHH.wait();
                        j.i("MicroMsg.WxWaitingLock", "after waiting %s", kVar);
                    }
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.WxWaitingLock", e, "", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(137999);
                }
            }
            if (this.cek) {
                ab.e("MicroMsg.DefaultBootStep", "SVG still failed!");
            }
        }
        super.b(gVar);
        AppMethodBeat.o(137999);
    }

    public final boolean Bg() {
        AppMethodBeat.i(138000);
        if (cel) {
            AppMethodBeat.o(138000);
            return true;
        } else if (((h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            com.tencent.mm.kernel.g.RN();
            if (com.tencent.mm.kernel.a.QX() && com.tencent.mm.kernel.g.RN().QY()) {
                if (com.tencent.mm.splash.h.xGC.size() == 1) {
                    if (ah.doy().equals(com.tencent.mm.splash.h.an((Activity) com.tencent.mm.splash.h.xGC.get(0)))) {
                        ab.i("MicroMsg.DefaultBootStep", "Found LauncherUI only.");
                        AppMethodBeat.o(138000);
                        return false;
                    }
                }
                AppMethodBeat.o(138000);
                return true;
            }
            AppMethodBeat.o(138000);
            return true;
        } else {
            AppMethodBeat.o(138000);
            return true;
        }
    }

    static /* synthetic */ void a(g gVar, final com.tencent.mm.kernel.b.g gVar2) {
        AppMethodBeat.i(138001);
        new bj() {
            public final Object run() {
                AppMethodBeat.i(137967);
                g.Bh();
                AppMethodBeat.o(137967);
                return null;
            }
        }.b(new ak(Looper.getMainLooper()));
        AppMethodBeat.o(138001);
    }
}
