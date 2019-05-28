package com.tencent.mm.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bf.e;
import com.tencent.mm.blink.b;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.x;
import com.tencent.mm.cj.c;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelmulti.h;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.webview.ui.tools.bag.l;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.w;
import java.util.Map;

public final class MMAppMgr {
    private static StringBuffer ymG;
    private static long ymH;
    public static boolean ymL = true;
    private final ap cfq = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(29547);
            String cc = bo.cc(ah.getContext());
            if (cc == null || !cc.toLowerCase().startsWith(ah.getPackageName())) {
                ab.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
                c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                AppMethodBeat.o(29547);
            } else {
                ab.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
                AppMethodBeat.o(29547);
            }
            return false;
        }
    }, true);
    private long fPQ;
    private String gEn;
    public Receiver ymI;
    private boolean ymJ = false;
    private boolean ymK = false;
    private final ap ymM = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(29557);
            if (MMAppMgr.this.ymK == MMAppMgr.this.ymJ) {
                ab.d("MicroMsg.MMAppMgr", "status not changed, cur=" + MMAppMgr.this.ymK);
                AppMethodBeat.o(29557);
                return true;
            } else if (aw.ZD()) {
                AppMethodBeat.o(29557);
                return false;
            } else {
                MMAppMgr.this.ymK = MMAppMgr.this.ymJ;
                com.tencent.mrs.a.onForeground(MMAppMgr.this.ymK);
                com.tencent.mm.plugin.performance.elf.a.as(MainProcessChecker.class).jJ(MMAppMgr.this.ymK);
                com.tencent.mm.plugin.performance.a aVar = com.tencent.mm.plugin.performance.a.peX;
                boolean a = MMAppMgr.this.ymK;
                if (aVar.aFV && aVar.handler != null) {
                    ab.i("MicroMsg.PowerTest", "onAppForeground isForeground:%s", Boolean.valueOf(a));
                    if (!a) {
                        aVar.peY = false;
                        aVar.peW.pfc = false;
                        aVar.handler.removeCallbacks(aVar.peW);
                        aVar.handler.postDelayed(aVar.peW, 120000);
                    }
                    aVar.caA = a;
                }
                com.tencent.mm.performance.a.a.any().caA = MMAppMgr.this.ymK;
                BaseEvent.onForeground(MMAppMgr.this.ymK);
                com.tencent.mm.an.a.cL(MMAppMgr.this.ymK);
                k kVar;
                vv vvVar;
                hb hbVar;
                sn snVar;
                if (MMAppMgr.this.ymK) {
                    ab.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    aw.Rg().cE(true);
                    if (aw.RK() && g.RN().eJb && !aw.QT()) {
                        x xVar = x.ecN;
                        if (!xVar.hasInit) {
                            Map dru;
                            xVar.hasInit = true;
                            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100066");
                            if (ll.isValid()) {
                                dru = ll.dru();
                                xVar.ecZ = com.tencent.mm.platformtools.ah.getInt((String) dru.get("maxCacheCount"), 20);
                                xVar.eda = com.tencent.mm.platformtools.ah.getInt((String) dru.get("maxCacheHours"), 24);
                            }
                            ll = com.tencent.mm.model.c.c.abi().ll("100058");
                            if (ll.isValid()) {
                                dru = ll.dru();
                                xVar.edb = com.tencent.mm.platformtools.ah.getInt((String) dru.get("cacheLogCount"), 30);
                                xVar.edc = com.tencent.mm.platformtools.ah.getInt((String) dru.get("maxCacheTime"), 10800);
                            }
                            ab.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(xVar.ecZ), Integer.valueOf(xVar.eda), Integer.valueOf(xVar.edb), Integer.valueOf(xVar.edc));
                        }
                        if (MMAppMgr.ymL) {
                            com.tencent.mm.sdk.b.a.xxA.m(new pw());
                        } else {
                            MMAppMgr.ymL = true;
                        }
                        com.tencent.mm.modelsimple.c.cQ(true);
                        n.ahW().lN(3);
                        aw.Rg().a(new h(), 0);
                        b.HQ().o(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29556);
                                m.amc().run();
                                o.alq().run();
                                com.tencent.mm.at.o.ahj().run();
                                am.dhP().run();
                                if (ao.a.flx != null) {
                                    ao.a.flx.Zw();
                                }
                                com.tencent.mm.sdk.b.a.xxA.m(new sf());
                                aw.ZK();
                                com.tencent.mm.model.c.XL().c(null);
                                AppMethodBeat.o(29556);
                            }
                        });
                        bv.aaq().c(19, Integer.valueOf(1));
                        e ajY = e.ajY();
                        ab.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        ajY.fBz.pk(true);
                        com.tencent.mm.at.o.ahn().cE(true);
                        if (f.vdy != null) {
                            f.vdy.cDy();
                        }
                        kVar = new k();
                        kVar.csh.csi = true;
                        com.tencent.mm.sdk.b.a.xxA.m(kVar);
                        com.tencent.mm.modelstat.o.mg(4);
                        com.tencent.mm.modelstat.o.mg(3);
                        com.tencent.mm.modelstat.o.cT(true);
                        su suVar = new su();
                        suVar.cOT.cOU = true;
                        suVar.cOT.scene = 1;
                        com.tencent.mm.sdk.b.a.xxA.m(suVar);
                        vvVar = new vv();
                        vvVar.cSX.cuy = 5;
                        com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                        hbVar = new hb();
                        hbVar.cBM.cuy = 2;
                        com.tencent.mm.sdk.b.a.xxA.m(hbVar);
                        snVar = new sn();
                        snVar.cON.state = 1;
                        com.tencent.mm.sdk.b.a.xxA.m(snVar);
                        ((d) g.K(d.class)).fZ(true);
                    }
                    aw.Rg().cD(false);
                    ah.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (!MMAppMgr.this.cfq.doT()) {
                        MMAppMgr.this.cfq.stopTimer();
                    }
                } else {
                    ab.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                    MMAppMgr.this.fPQ = bo.yz();
                    MMAppMgr.this.gEn = "desktop";
                    kVar = new k();
                    kVar.csh.csi = false;
                    com.tencent.mm.sdk.b.a.xxA.m(kVar);
                    aw.Rg().cE(false);
                    if (aw.RK()) {
                        g.RQ();
                        if (g.RN().eJb) {
                            com.tencent.mm.bq.a.akz(com.tencent.mm.bq.a.dlM());
                            Looper.myQueue().addIdleHandler(new IdleHandler() {
                                public final boolean queueIdle() {
                                    AppMethodBeat.i(116554);
                                    if (g.Rg().foreground) {
                                        ab.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
                                        AppMethodBeat.o(116554);
                                    } else {
                                        ab.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
                                        e.this.fBz.pk(false);
                                        AppMethodBeat.o(116554);
                                    }
                                    return false;
                                }
                            });
                            oe oeVar = new oe();
                            oeVar.cKx.state = 0;
                            com.tencent.mm.sdk.b.a.xxA.m(oeVar);
                            com.tencent.mm.sdk.b.a.xxA.m(new tk());
                            com.tencent.mm.g.a.d dVar = new com.tencent.mm.g.a.d();
                            dVar.crQ.crR = false;
                            com.tencent.mm.sdk.b.a.xxA.m(dVar);
                            pc pcVar = new pc();
                            pcVar.cLr.active = false;
                            com.tencent.mm.sdk.b.a.xxA.m(pcVar);
                            com.tencent.mm.at.o.ahn().cE(false);
                            MMAppMgr.dyu();
                            cu cuVar = new cu();
                            cuVar.cvW.state = 0;
                            com.tencent.mm.sdk.b.a.xxA.m(cuVar);
                            vvVar = new vv();
                            vvVar.cSX.cuy = 3;
                            com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                            hbVar = new hb();
                            hbVar.cBM.cuy = 1;
                            com.tencent.mm.sdk.b.a.xxA.m(hbVar);
                            snVar = new sn();
                            snVar.cON.state = 0;
                            com.tencent.mm.sdk.b.a.xxA.m(snVar);
                            ((d) g.K(d.class)).fZ(false);
                            com.tencent.mm.modelsimple.c.cQ(false);
                            com.tencent.mm.modelstat.o.cT(false);
                        }
                    }
                    if (!MMAppMgr.this.cfq.doT()) {
                        MMAppMgr.this.cfq.stopTimer();
                    }
                    boolean z = bo.bI(ah.getContext(), new StringBuilder().append(ah.getPackageName()).append(":tools").toString()) || bo.bI(ah.getContext(), ah.getPackageName() + ":toolsmp");
                    ab.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(z));
                    if (z) {
                        MMAppMgr.this.cfq.ae(60000, 60000);
                    }
                }
                AppMethodBeat.o(29557);
                return true;
            }
        }
    }, false);
    public int ymN = 0;
    private boolean ymO = true;
    private final ap ymP = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(29558);
            if (MMAppMgr.this.ymN >= 30) {
                AppMethodBeat.o(29558);
                return false;
            } else if (!com.tencent.mm.sdk.platformtools.o.gn(ah.getContext()) && !MMAppMgr.this.ymJ && g.RN().QY()) {
                MMAppMgr.this.ymO = true;
                l.uzq.dbi();
                AppMethodBeat.o(29558);
                return false;
            } else if (MMAppMgr.this.ymJ && MMAppMgr.this.ymO && g.RN().QY()) {
                MMAppMgr.this.ymO = false;
                l.uzq.nU(true);
                AppMethodBeat.o(29558);
                return false;
            } else {
                MMAppMgr mMAppMgr = MMAppMgr.this;
                mMAppMgr.ymN++;
                AppMethodBeat.o(29558);
                return true;
            }
        }
    }, true);

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        private static boolean aT(Intent intent) {
            AppMethodBeat.i(29567);
            if (!intent.getBooleanExtra("process_is_mm", false)) {
                AppMethodBeat.o(29567);
                return true;
            } else if (intent.getIntExtra("process_id", 0) == Process.myPid()) {
                AppMethodBeat.o(29567);
                return true;
            } else {
                AppMethodBeat.o(29567);
                return false;
            }
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(29568);
            if (intent == null) {
                AppMethodBeat.o(29568);
            } else if (aw.ZD() || aw.ZF()) {
                AppMethodBeat.o(29568);
            } else {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (aT(intent)) {
                        MMAppMgr.a(this.appMgr, intent, true);
                        this.appMgr.c(intent, true);
                        AppMethodBeat.o(29568);
                        return;
                    }
                    ab.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                    AppMethodBeat.o(29568);
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (aT(intent)) {
                        com.tencent.mm.booter.n.IF();
                        MMAppMgr.a(this.appMgr, intent, false);
                        this.appMgr.c(intent, false);
                        if (MMAppMgr.ymG != null && MMAppMgr.ymG.length() > 800) {
                            new ak(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(29565);
                                    MMAppMgr.BK();
                                    AppMethodBeat.o(29565);
                                }
                            });
                        }
                        AppMethodBeat.o(29568);
                        return;
                    }
                    ab.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                    AppMethodBeat.o(29568);
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    MMAppMgr.aS(intent);
                    if (MMAppMgr.ymG != null && MMAppMgr.ymG.length() > 800) {
                        new ak(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(29566);
                                MMAppMgr.BK();
                                AppMethodBeat.o(29566);
                            }
                        });
                    }
                    AppMethodBeat.o(29568);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    int intExtra;
                    if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        ab.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(intExtra)));
                        if (aw.RK()) {
                            if (intExtra == 2) {
                                int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                                com.tencent.mm.plugin.report.service.h.pYm.e(11147, Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                            } else {
                                com.tencent.mm.plugin.report.service.h.pYm.e(11147, Integer.valueOf(intExtra));
                            }
                            if (intExtra == 4 && i.dhV() == 4) {
                                com.tencent.mm.pluginsdk.model.app.a dhs = com.tencent.mm.pluginsdk.model.app.a.dhs();
                                if (dhs != null) {
                                    dhs.dhu();
                                }
                            }
                        }
                    } else {
                        ab.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(intent.getIntExtra("intent_extra_opcode", 0))));
                        if (aw.RK()) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(10328, Integer.valueOf(intExtra));
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (aw.RK() && !(longExtra == 0 && longExtra2 == 0)) {
                        ab.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            com.tencent.mm.modelstat.n.I((int) longExtra2, (int) longExtra, 0);
                            AppMethodBeat.o(29568);
                            return;
                        }
                        com.tencent.mm.modelstat.n.J((int) longExtra2, (int) longExtra, 0);
                    }
                    AppMethodBeat.o(29568);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.bd(context);
                    AppMethodBeat.o(29568);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    com.tencent.mm.pluginsdk.ui.tools.a.aF(intent);
                    AppMethodBeat.o(29568);
                } else {
                    ab.e("MicroMsg.MMAppMgr", "unknown broadcast action");
                    AppMethodBeat.o(29568);
                }
            }
        }
    }

    public MMAppMgr() {
        AppMethodBeat.i(29569);
        AppMethodBeat.o(29569);
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(29591);
        dyq();
        AppMethodBeat.o(29591);
    }

    public final void c(Intent intent, boolean z) {
        String str;
        AppMethodBeat.i(29570);
        if (z) {
            com.tencent.mm.ah.n.acp();
            oe oeVar = new oe();
            oeVar.cKx.state = 1;
            com.tencent.mm.sdk.b.a.xxA.m(oeVar);
            com.tencent.mm.g.a.d dVar = new com.tencent.mm.g.a.d();
            dVar.crQ.crR = true;
            com.tencent.mm.sdk.b.a.xxA.m(dVar);
            pc pcVar = new pc();
            pcVar.cLr.active = true;
            com.tencent.mm.sdk.b.a.xxA.m(pcVar);
            cu cuVar = new cu();
            cuVar.cvW.state = 1;
            com.tencent.mm.sdk.b.a.xxA.m(cuVar);
        }
        gd gdVar = new gd();
        gdVar.cAs.csi = z;
        com.tencent.mm.sdk.b.a.xxA.m(gdVar);
        this.ymJ = z;
        String stringExtra = intent.getStringExtra("classname");
        if (bo.isNullOrNil(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        x xVar;
        if (z) {
            xVar = x.ecN;
            if (xVar.ecY == -1) {
                if (xVar.ecO.Ml(3) == 0) {
                    xVar.ecO.setLong(1, com.tencent.mm.platformtools.ah.anT());
                }
                xVar.ecY = com.tencent.mm.platformtools.ah.anT();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                if (xVar.ecR == null) {
                    stringExtra = BuildConfig.COMMAND;
                } else {
                    stringExtra = xVar.ecR.ede;
                }
                objArr[0] = stringExtra;
                objArr[1] = str;
                ab.i(str2, str3, objArr);
                if (xVar.ecR != null) {
                    xVar.ecV = com.tencent.mm.platformtools.ah.yz();
                    if (str != null && str.contains("WebViewUI")) {
                        xVar.ecW = com.tencent.mm.platformtools.ah.yz();
                    }
                }
            }
        } else {
            xVar = x.ecN;
            if (xVar.ecY != -1) {
                stringExtra = ((String) xVar.ecO.get(2, "")) + xVar.ecY + "|" + com.tencent.mm.platformtools.ah.anT() + "#";
                xVar.ecO.set(2, stringExtra);
                int Ml = xVar.ecO.Ml(3) + 1;
                xVar.ecO.setInt(3, Ml);
                ab.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(Ml), Long.valueOf(xVar.ecY), Long.valueOf(r4));
                xVar.ecY = -1;
                if (com.tencent.mm.platformtools.ah.fp(xVar.ecO.getLong(1, 0)) > 3600 * ((long) xVar.eda) || Ml > xVar.ecZ) {
                    com.tencent.mm.plugin.report.service.h.pYm.X(13110, stringExtra);
                    ab.i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    xVar.ecO.set(2, "");
                    xVar.ecO.setInt(3, 0);
                }
                if (xVar.ecR != null) {
                    x.a aVar = xVar.ecR;
                    aVar.time += com.tencent.mm.platformtools.ah.az(xVar.ecV) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        aVar = xVar.ecR;
                        aVar.edi = (int) (((long) aVar.edi) + (com.tencent.mm.platformtools.ah.az(xVar.ecW) / 1000));
                    }
                    ab.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(xVar.ecR.time));
                }
            }
        }
        if (g.RN().QY()) {
            Object obj;
            if (bo.isNullOrNil(l.uzq.uzu.url)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.ymN = 0;
                this.ymP.ae(100, 20);
            }
        }
        this.ymM.ae(800, 800);
        AppMethodBeat.o(29570);
    }

    private static void dyq() {
        AppMethodBeat.i(29571);
        StringBuffer stringBuffer = new StringBuffer(800);
        if (ymG == null) {
            ymG = stringBuffer;
            ymH = bo.anT();
            AppMethodBeat.o(29571);
            return;
        }
        String stringBuffer2 = ymG.toString();
        stringBuffer.append(aqF(stringBuffer2));
        ymG = stringBuffer;
        ab.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        com.tencent.mm.plugin.report.service.h.pYm.X(10508, "1," + ymH + "," + stringBuffer2);
        ymH = bo.anT();
        AppMethodBeat.o(29571);
    }

    private static String aqF(String str) {
        AppMethodBeat.i(29572);
        int i = 0;
        int length = str.length() - 1;
        while (length >= 0) {
            if (str.charAt(length) == '|') {
                i++;
            }
            if (i == 3) {
                break;
            }
            length--;
        }
        String substring = str.substring(length + 1);
        AppMethodBeat.o(29572);
        return substring;
    }

    public static void dyr() {
        AppMethodBeat.i(29573);
        com.tencent.mrs.a.onDestroy();
        dyq();
        ab.appenderClose();
        BaseEvent.onSingalCrash(0);
        AppMethodBeat.o(29573);
    }

    public static void cancelNotification(String str) {
        AppMethodBeat.i(29574);
        aw.getNotification().cancelNotification(str);
        AppMethodBeat.o(29574);
    }

    public static void BV() {
        AppMethodBeat.i(29575);
        aw.getNotification().BV();
        AppMethodBeat.o(29575);
    }

    public static void aAd() {
        AppMethodBeat.i(29576);
        pQ(true);
        AppMethodBeat.o(29576);
    }

    public static void pQ(boolean z) {
        AppMethodBeat.i(29577);
        ab.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bo.dpG(), Boolean.valueOf(z));
        com.tencent.mm.plugin.report.b.d.u(2, 0, "");
        if (z) {
            dys();
        }
        com.tencent.mm.sdk.b.a.xxA.m(new com.tencent.mm.g.a.x());
        jl jlVar = new jl();
        jlVar.cEK.status = 0;
        jlVar.cEK.boZ = 2;
        com.tencent.mm.sdk.b.a.xxA.m(jlVar);
        dyq();
        if (z) {
            aw.lE(bo.dpG().toString());
            g.RQ().releaseAll();
        }
        ab.appenderClose();
        BaseEvent.onSingalCrash(0);
        com.tencent.mrs.a.onDestroy();
        com.tencent.mm.bs.a.f(ah.getContext(), "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4");
        try {
            w.clearAllWebViewCache(ah.getContext(), true);
            ab.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
        } catch (Exception e) {
            ab.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", e);
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(29577);
    }

    public static void dys() {
        AppMethodBeat.i(29578);
        Context context = ah.getContext();
        if (context != null) {
            if (com.tencent.mm.booter.c.Ij()) {
                com.tencent.mm.app.e.Bc();
            } else {
                try {
                    context.stopService(new Intent(context, CoreService.class));
                } catch (Exception e) {
                    ab.e("MicroMsg.MMAppMgr", "killService() Exception:%s", e.getMessage());
                }
            }
            com.tencent.mm.bp.d.aI(new Intent(context, NotifyService.class));
            context.stopService(new Intent(context, CacheService.class));
            com.tencent.mm.bp.d.l(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
        }
        AppMethodBeat.o(29578);
    }

    public static void bd(Context context) {
        AppMethodBeat.i(29579);
        k(context, true);
        AppMethodBeat.o(29579);
    }

    public static void k(Context context, boolean z) {
        AppMethodBeat.i(29580);
        g.RQ().cn(z);
        com.tencent.mrs.a.onDestroy();
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        com.tencent.mm.booter.n.BY();
        if (!(aw.Rg() == null || aw.Rg().ftA == null)) {
            aw.Rg().ftA.cH(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.o(29580);
    }

    public static void be(Context context) {
        AppMethodBeat.i(29581);
        aa.anh().edit().putBoolean("is_in_notify_mode", true).commit();
        aj.amB("welcome_page_show");
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().k(-1, null);
        z zVar = new z();
        zVar.csU.csV = false;
        com.tencent.mm.sdk.b.a.xxA.m(zVar);
        com.tencent.mm.plugin.setting.b.gkF.BV();
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IH();
        k(context, false);
        AppMethodBeat.o(29581);
    }

    public static boolean c(Context context, final OnClickListener onClickListener) {
        AppMethodBeat.i(29582);
        if (aw.RK()) {
            aw.ZK();
            final int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(65, Integer.valueOf(0))).intValue();
            if (intValue >= 5) {
                AppMethodBeat.o(29582);
                return false;
            } else if (aj.amA("show_wap_adviser")) {
                View inflate = View.inflate(context, R.layout.ais, null);
                ((TextView) inflate.findViewById(R.id.dhn)).setText(R.string.d5y);
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
                aVar.PV(R.string.tz);
                aVar.fn(inflate);
                aVar.Qc(R.string.s6).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29559);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(65, Integer.valueOf(intValue + 1));
                        AppMethodBeat.o(29559);
                    }
                });
                aVar.rc(false);
                aVar.Qd(R.string.d5v).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29560);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(65, Integer.valueOf(5));
                        AppMethodBeat.o(29560);
                    }
                });
                aVar.a(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(29561);
                        aj.amB("show_wap_adviser");
                        if (onClickListener != null) {
                            onClickListener.onClick(dialogInterface, 0);
                        }
                        AppMethodBeat.o(29561);
                    }
                });
                aVar.aMb().show();
                AppMethodBeat.o(29582);
                return true;
            } else {
                AppMethodBeat.o(29582);
                return false;
            }
        }
        AppMethodBeat.o(29582);
        return false;
    }

    public static boolean hr(final Context context) {
        AppMethodBeat.i(29583);
        if (aw.RK()) {
            aw.ZK();
            if (bo.e((Boolean) com.tencent.mm.model.c.Ry().get(61, null))) {
                AppMethodBeat.o(29583);
                return false;
            } else if (aj.amA("show_wap_adviser")) {
                View inflate = View.inflate(context, R.layout.ais, null);
                ((TextView) inflate.findViewById(R.id.dhn)).setText(R.string.d5z);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dhp);
                checkBox.setText(context.getString(R.string.den));
                checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(29562);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(61, Boolean.valueOf(z));
                        AppMethodBeat.o(29562);
                    }
                });
                checkBox.setVisibility(0);
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
                aVar.PV(R.string.tz);
                aVar.fn(inflate);
                aVar.Qc(R.string.dep).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29563);
                        try {
                            context.startActivity(new Intent("android.settings.APN_SETTINGS"));
                            AppMethodBeat.o(29563);
                        } catch (Exception e) {
                            AppMethodBeat.o(29563);
                        }
                    }
                });
                aVar.rc(false);
                aVar.Qd(R.string.deo);
                aVar.a(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(29564);
                        aj.amB("show_wap_adviser");
                        AppMethodBeat.o(29564);
                    }
                });
                aVar.aMb().show();
                AppMethodBeat.o(29583);
                return true;
            } else {
                AppMethodBeat.o(29583);
                return false;
            }
        }
        AppMethodBeat.o(29583);
        return false;
    }

    public static boolean Ch() {
        return false;
    }

    public static void aq(Activity activity) {
        AppMethodBeat.i(29584);
        Intent intent = new Intent();
        com.tencent.mm.bp.d.H(activity, "whatsnew", ".ui.WhatsNewUI");
        AppMethodBeat.o(29584);
    }

    public static void hs(Context context) {
        AppMethodBeat.i(29585);
        SharedPreferences sharedPreferences = context.getSharedPreferences(ah.doA(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.string.cmd));
            intent.putExtra("duplicate", false);
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), ah.doz() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.drawable.icon));
            intent.putExtra("shortcut_icon_resource_id", R.drawable.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            com.tencent.mm.plugin.base.model.b.r(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
        AppMethodBeat.o(29585);
    }

    public static boolean ar(Activity activity) {
        AppMethodBeat.i(29586);
        boolean a = a(activity, null);
        AppMethodBeat.o(29586);
        return a;
    }

    public static boolean a(final Activity activity, final OnClickListener onClickListener) {
        AppMethodBeat.i(29587);
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(ah.doA(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        com.tencent.mm.sdk.platformtools.g.xye &= z;
        if (z) {
            View inflate = View.inflate(activity, R.layout.a6d, null);
            String string = activity.getString(R.string.dei);
            String string2 = activity.getString(R.string.cw3);
            String string3 = activity.getString(R.string.cw2, new Object[]{string, string2});
            Spannable newSpannable = Factory.getInstance().newSpannable(string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(29548);
                    bo.M(activity, ah.getResources().getString(R.string.g7o, new Object[]{com.tencent.mm.sdk.platformtools.aa.gw(activity), com.tencent.mm.sdk.platformtools.aa.doq(), "setting", Integer.valueOf(0), Integer.valueOf(0)}));
                    AppMethodBeat.o(29548);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(29549);
                    textPaint.setColor(activity.getResources().getColor(R.color.t7));
                    AppMethodBeat.o(29549);
                }
            }, string3.indexOf(string), string.length() + string3.indexOf(string), 33);
            newSpannable.setSpan(new StyleSpan(1), string3.indexOf(string2), string2.length() + string3.indexOf(string2), 33);
            TextView textView = (TextView) inflate.findViewById(R.id.ca3);
            textView.setText(newSpannable);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ca4);
            com.tencent.mm.ui.widget.a.c a = com.tencent.mm.ui.base.h.a((Context) activity, false, null, inflate, activity.getString(R.string.atd), activity.getString(R.string.cvz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(29550);
                    if (checkBox.isChecked()) {
                        Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    com.tencent.mm.sdk.platformtools.g.xye = false;
                    dialogInterface.dismiss();
                    MMAppMgr.hs(activity);
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i);
                    }
                    AppMethodBeat.o(29550);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(29551);
                    dialogInterface.dismiss();
                    MMAppMgr.bd(activity);
                    AppMethodBeat.o(29551);
                }
            });
            if (a == null) {
                AppMethodBeat.o(29587);
                return false;
            }
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(29552);
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                    AppMethodBeat.o(29552);
                }
            });
        }
        AppMethodBeat.o(29587);
        return z;
    }

    public static boolean a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        AppMethodBeat.i(29588);
        View inflate = View.inflate(context, R.layout.ais, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dhp);
        checkBox.setText(context.getString(R.string.d5r));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(29553);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(16385, Boolean.valueOf(!z));
                AppMethodBeat.o(29553);
            }
        });
        inflate.findViewById(R.id.dho).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.dhn);
        switch (i) {
            case 1:
                textView.setText(R.string.d5q);
                z = true;
                break;
            case 3:
                textView.setText(R.string.d60);
                z = false;
                break;
            default:
                textView.setText(R.string.d60);
                z = true;
                break;
        }
        if (z) {
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
            aVar.PV(R.string.tz);
            aVar.rc(false);
            aVar.fn(inflate);
            aVar.Qc(R.string.d5x).a(onClickListener);
            aVar.Qd(R.string.d5r).b(onClickListener2);
            aVar.aMb().show();
            AppMethodBeat.o(29588);
            return true;
        }
        AppMethodBeat.o(29588);
        return false;
    }

    public static com.tencent.mm.ui.widget.a.c bg(final Context context) {
        AppMethodBeat.i(29589);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION);
            if (at.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                AppMethodBeat.o(29589);
                return null;
            }
            aw.ZK();
            Boolean bool = (Boolean) com.tencent.mm.model.c.Ry().get(4105, Boolean.FALSE);
            if (bool == null || !bool.booleanValue()) {
                View inflate = View.inflate(context, R.layout.a9u, null);
                ((CheckBox) inflate.findViewById(R.id.cpa)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(29554);
                        if (z) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(4105, Boolean.TRUE);
                            AppMethodBeat.o(29554);
                            return;
                        }
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(4105, Boolean.FALSE);
                        AppMethodBeat.o(29554);
                    }
                });
                OnClickListener anonymousClass8 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29555);
                        try {
                            context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                            AppMethodBeat.o(29555);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                            AppMethodBeat.o(29555);
                        }
                    }
                };
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
                aVar.PV(R.string.d56);
                aVar.fn(inflate);
                aVar.Qc(R.string.tk).a(anonymousClass8);
                aVar.Qd(R.string.r7);
                com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
                aMb.show();
                AppMethodBeat.o(29589);
                return aMb;
            }
            AppMethodBeat.o(29589);
            return null;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            AppMethodBeat.o(29589);
            return null;
        }
    }

    static /* synthetic */ void a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        AppMethodBeat.i(29590);
        String stringExtra = intent.getStringExtra("classname");
        if (bo.isNullOrNil(stringExtra)) {
            ab.i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            AppMethodBeat.o(29590);
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        com.tencent.mm.sdk.a.b.ame(stringExtra);
        if (ymG == null) {
            ymG = new StringBuffer(800);
            ymH = bo.anT();
            ymG.append("start:");
            ymG.append(bo.anT());
            ymG.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.gEn)) {
                ymG.append("desktop:");
                ymG.append(bo.az(mMAppMgr.fPQ) + 800);
                ymG.append("|");
            }
            mMAppMgr.fPQ = bo.yz();
            mMAppMgr.gEn = stringExtra;
        } else {
            ymG.append(mMAppMgr.gEn + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            ymG.append(bo.az(mMAppMgr.fPQ));
            ymG.append("|");
        }
        com.tencent.mm.g.a.e eVar = new com.tencent.mm.g.a.e();
        eVar.crS.active = z;
        eVar.crS.className = stringExtra;
        com.tencent.mm.sdk.b.a.xxA.m(eVar);
        ab.i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
        AppMethodBeat.o(29590);
    }

    static /* synthetic */ void aS(Intent intent) {
        AppMethodBeat.i(29592);
        String stringExtra = intent.getStringExtra(FirebaseAnalytics.b.CONTENT);
        if (bo.isNullOrNil(stringExtra)) {
            ab.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
            AppMethodBeat.o(29592);
            return;
        }
        if (ymG == null) {
            ymG = new StringBuffer(800);
        }
        ymG.append(stringExtra);
        ab.i("MicroMsg.MMAppMgr", "cpan content: %s", stringExtra);
        AppMethodBeat.o(29592);
    }

    static /* synthetic */ void dyu() {
        boolean z;
        AppMethodBeat.i(29593);
        ab.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
        aw.ZK();
        Object obj = com.tencent.mm.model.c.Ry().get(327808, null);
        if (obj == null) {
            z = true;
        } else if (bo.isNullOrNil(obj.toString())) {
            z = true;
        } else {
            if (System.currentTimeMillis() - bo.anl(obj.toString()) >= 604800000) {
                z = true;
            } else {
                z = false;
            }
        }
        ab.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
        if (z) {
            try {
                com.tencent.mm.plugin.report.service.h.pYm.X(11375, bo.nullAsNil(Secure.getString(ah.getContext().getContentResolver(), "default_input_method")));
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(327808, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(29593);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
            }
        }
        AppMethodBeat.o(29593);
    }
}
