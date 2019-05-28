package com.tencent.p177mm.p612ui;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mrs.C5769a;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C1246e;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.booter.C41900n;
import com.tencent.p177mm.booter.C41908x;
import com.tencent.p177mm.booter.C41908x.C32426a;
import com.tencent.p177mm.booter.C45270c;
import com.tencent.p177mm.booter.CoreService;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.booter.cache.CacheService;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelsimple.C26467c;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.modelstat.C9711n;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.p1186bq.C18114a;
import com.tencent.p177mm.p1638bs.C45273a;
import com.tencent.p177mm.p182ah.C45140n;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p202bf.C9077e;
import com.tencent.p177mm.p202bf.C9077e.C90781;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18395su;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C26270x;
import com.tencent.p177mm.p230g.p231a.C32533cu;
import com.tencent.p177mm.p230g.p231a.C32621pw;
import com.tencent.p177mm.p230g.p231a.C32629sf;
import com.tencent.p177mm.p230g.p231a.C32640tk;
import com.tencent.p177mm.p230g.p231a.C41997hb;
import com.tencent.p177mm.p230g.p231a.C42034pc;
import com.tencent.p177mm.p230g.p231a.C45366sn;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p230g.p231a.C9326e;
import com.tencent.p177mm.p230g.p231a.C9352gd;
import com.tencent.p177mm.p230g.p231a.C9428oe;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.performance.p1466a.C32884a;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.base.model.C42781b;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.performance.C34666a;
import com.tencent.p177mm.plugin.performance.elf.C43368a;
import com.tencent.p177mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.p177mm.plugin.report.p499b.C34829d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C29879l;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C44057a;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C44094a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C40618o;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C16403w;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.MMAppMgr */
public final class MMAppMgr {
    private static StringBuffer ymG;
    private static long ymH;
    public static boolean ymL = true;
    private final C7564ap cfq = new C7564ap(new C51991(), true);
    private long fPQ;
    private String gEn;
    public Receiver ymI;
    private boolean ymJ = false;
    private boolean ymK = false;
    private final C7564ap ymM = new C7564ap(Looper.getMainLooper(), new C52029(), false);
    public int ymN = 0;
    private boolean ymO = true;
    private final C7564ap ymP = new C7564ap(Looper.getMainLooper(), new C519110(), true);

    /* renamed from: com.tencent.mm.ui.MMAppMgr$6 */
    static class C51886 implements OnCheckedChangeListener {
        C51886() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(29553);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(16385, Boolean.valueOf(!z));
            AppMethodBeat.m2505o(29553);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$7 */
    static class C51897 implements OnCheckedChangeListener {
        C51897() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(29554);
            if (z) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4105, Boolean.TRUE);
                AppMethodBeat.m2505o(29554);
                return;
            }
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4105, Boolean.FALSE);
            AppMethodBeat.m2505o(29554);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$10 */
    class C519110 implements C5015a {
        C519110() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(29558);
            if (MMAppMgr.this.ymN >= 30) {
                AppMethodBeat.m2505o(29558);
                return false;
            } else if (!C40618o.m70064gn(C4996ah.getContext()) && !MMAppMgr.this.ymJ && C1720g.m3534RN().mo5161QY()) {
                MMAppMgr.this.ymO = true;
                C29879l.uzq.dbi();
                AppMethodBeat.m2505o(29558);
                return false;
            } else if (MMAppMgr.this.ymJ && MMAppMgr.this.ymO && C1720g.m3534RN().mo5161QY()) {
                MMAppMgr.this.ymO = false;
                C29879l.uzq.mo48112nU(true);
                AppMethodBeat.m2505o(29558);
                return false;
            } else {
                MMAppMgr mMAppMgr = MMAppMgr.this;
                mMAppMgr.ymN++;
                AppMethodBeat.m2505o(29558);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$12 */
    static class C519312 implements OnClickListener {
        C519312() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29560);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(65, Integer.valueOf(5));
            AppMethodBeat.m2505o(29560);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$16 */
    static class C519416 implements OnDismissListener {
        C519416() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(29564);
            C4997aj.amB("show_wap_adviser");
            AppMethodBeat.m2505o(29564);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$1 */
    class C51991 implements C5015a {
        C51991() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(29547);
            String cc = C5046bo.m7542cc(C4996ah.getContext());
            if (cc == null || !cc.toLowerCase().startsWith(C4996ah.getPackageName())) {
                C4990ab.m7416i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
                C45287c.atD("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                AppMethodBeat.m2505o(29547);
            } else {
                C4990ab.m7416i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
                AppMethodBeat.m2505o(29547);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$14 */
    static class C520014 implements OnCheckedChangeListener {
        C520014() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(29562);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(61, Boolean.valueOf(z));
            AppMethodBeat.m2505o(29562);
        }
    }

    /* renamed from: com.tencent.mm.ui.MMAppMgr$9 */
    class C52029 implements C5015a {

        /* renamed from: com.tencent.mm.ui.MMAppMgr$9$1 */
        class C52031 implements Runnable {
            C52031() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29556);
                C26500m.amc().run();
                C37961o.alq().run();
                C32291o.ahj().run();
                C14877am.dhP().run();
                if (C26417a.flx != null) {
                    C26417a.flx.mo44185Zw();
                }
                C4879a.xxA.mo10055m(new C32629sf());
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(null);
                AppMethodBeat.m2505o(29556);
            }
        }

        C52029() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(29557);
            if (MMAppMgr.this.ymK == MMAppMgr.this.ymJ) {
                C4990ab.m7410d("MicroMsg.MMAppMgr", "status not changed, cur=" + MMAppMgr.this.ymK);
                AppMethodBeat.m2505o(29557);
                return true;
            } else if (C9638aw.m17183ZD()) {
                AppMethodBeat.m2505o(29557);
                return false;
            } else {
                MMAppMgr.this.ymK = MMAppMgr.this.ymJ;
                C5769a.onForeground(MMAppMgr.this.ymK);
                C43368a.m77392as(MainProcessChecker.class).mo62438jJ(MMAppMgr.this.ymK);
                C34666a c34666a = C34666a.peX;
                boolean a = MMAppMgr.this.ymK;
                if (c34666a.aFV && c34666a.handler != null) {
                    C4990ab.m7417i("MicroMsg.PowerTest", "onAppForeground isForeground:%s", Boolean.valueOf(a));
                    if (!a) {
                        c34666a.peY = false;
                        c34666a.peW.pfc = false;
                        c34666a.handler.removeCallbacks(c34666a.peW);
                        c34666a.handler.postDelayed(c34666a.peW, 120000);
                    }
                    c34666a.caA = a;
                }
                C32884a.any().caA = MMAppMgr.this.ymK;
                BaseEvent.onForeground(MMAppMgr.this.ymK);
                C41753a.m73603cL(MMAppMgr.this.ymK);
                C6504k c6504k;
                C9497vv c9497vv;
                C41997hb c41997hb;
                C45366sn c45366sn;
                if (MMAppMgr.this.ymK) {
                    C4990ab.m7420w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
                    C9638aw.m17182Rg().mo14549cE(true);
                    if (C9638aw.m17179RK() && C1720g.m3534RN().eJb && !C9638aw.m17178QT()) {
                        C41908x c41908x = C41908x.ecN;
                        if (!c41908x.hasInit) {
                            Map dru;
                            c41908x.hasInit = true;
                            C5141c ll = C18624c.abi().mo17131ll("100066");
                            if (ll.isValid()) {
                                dru = ll.dru();
                                c41908x.ecZ = C42252ah.getInt((String) dru.get("maxCacheCount"), 20);
                                c41908x.eda = C42252ah.getInt((String) dru.get("maxCacheHours"), 24);
                            }
                            ll = C18624c.abi().mo17131ll("100058");
                            if (ll.isValid()) {
                                dru = ll.dru();
                                c41908x.edb = C42252ah.getInt((String) dru.get("cacheLogCount"), 30);
                                c41908x.edc = C42252ah.getInt((String) dru.get("maxCacheTime"), 10800);
                            }
                            C4990ab.m7417i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", Integer.valueOf(c41908x.ecZ), Integer.valueOf(c41908x.eda), Integer.valueOf(c41908x.edb), Integer.valueOf(c41908x.edc));
                        }
                        if (MMAppMgr.ymL) {
                            C4879a.xxA.mo10055m(new C32621pw());
                        } else {
                            MMAppMgr.ymL = true;
                        }
                        C26467c.m42174cQ(true);
                        C18668n.ahW().mo44216lN(3);
                        C9638aw.m17182Rg().mo14541a(new C26451h(), 0);
                        C1314b.m2812HQ().mo4642o(new C52031());
                        C37907bv.aaq().mo60662c(19, Integer.valueOf(1));
                        C9077e ajY = C9077e.ajY();
                        C4990ab.m7410d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
                        ajY.fBz.mo39164pk(true);
                        C32291o.ahn().mo43784cE(true);
                        if (C44044f.vdy != null) {
                            C44044f.vdy.cDy();
                        }
                        c6504k = new C6504k();
                        c6504k.csh.csi = true;
                        C4879a.xxA.mo10055m(c6504k);
                        C18698o.m29229mg(4);
                        C18698o.m29229mg(3);
                        C18698o.m29225cT(true);
                        C18395su c18395su = new C18395su();
                        c18395su.cOT.cOU = true;
                        c18395su.cOT.scene = 1;
                        C4879a.xxA.mo10055m(c18395su);
                        c9497vv = new C9497vv();
                        c9497vv.cSX.cuy = 5;
                        C4879a.xxA.mo10055m(c9497vv);
                        c41997hb = new C41997hb();
                        c41997hb.cBM.cuy = 2;
                        C4879a.xxA.mo10055m(c41997hb);
                        c45366sn = new C45366sn();
                        c45366sn.cON.state = 1;
                        C4879a.xxA.mo10055m(c45366sn);
                        ((C45826d) C1720g.m3528K(C45826d.class)).mo7018fZ(true);
                    }
                    C9638aw.m17182Rg().mo14548cD(false);
                    C4996ah.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
                    if (!MMAppMgr.this.cfq.doT()) {
                        MMAppMgr.this.cfq.stopTimer();
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
                    MMAppMgr.this.fPQ = C5046bo.m7588yz();
                    MMAppMgr.this.gEn = "desktop";
                    c6504k = new C6504k();
                    c6504k.csh.csi = false;
                    C4879a.xxA.mo10055m(c6504k);
                    C9638aw.m17182Rg().mo14549cE(false);
                    if (C9638aw.m17179RK()) {
                        C1720g.m3537RQ();
                        if (C1720g.m3534RN().eJb) {
                            C18114a.akz(C18114a.dlM());
                            Looper.myQueue().addIdleHandler(new C90781());
                            C9428oe c9428oe = new C9428oe();
                            c9428oe.cKx.state = 0;
                            C4879a.xxA.mo10055m(c9428oe);
                            C4879a.xxA.mo10055m(new C32640tk());
                            C26111d c26111d = new C26111d();
                            c26111d.crQ.crR = false;
                            C4879a.xxA.mo10055m(c26111d);
                            C42034pc c42034pc = new C42034pc();
                            c42034pc.cLr.active = false;
                            C4879a.xxA.mo10055m(c42034pc);
                            C32291o.ahn().mo43784cE(false);
                            MMAppMgr.dyu();
                            C32533cu c32533cu = new C32533cu();
                            c32533cu.cvW.state = 0;
                            C4879a.xxA.mo10055m(c32533cu);
                            c9497vv = new C9497vv();
                            c9497vv.cSX.cuy = 3;
                            C4879a.xxA.mo10055m(c9497vv);
                            c41997hb = new C41997hb();
                            c41997hb.cBM.cuy = 1;
                            C4879a.xxA.mo10055m(c41997hb);
                            c45366sn = new C45366sn();
                            c45366sn.cON.state = 0;
                            C4879a.xxA.mo10055m(c45366sn);
                            ((C45826d) C1720g.m3528K(C45826d.class)).mo7018fZ(false);
                            C26467c.m42174cQ(false);
                            C18698o.m29225cT(false);
                        }
                    }
                    if (!MMAppMgr.this.cfq.doT()) {
                        MMAppMgr.this.cfq.stopTimer();
                    }
                    boolean z = C5046bo.m7529bI(C4996ah.getContext(), new StringBuilder().append(C4996ah.getPackageName()).append(":tools").toString()) || C5046bo.m7529bI(C4996ah.getContext(), C4996ah.getPackageName() + ":toolsmp");
                    C4990ab.m7417i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", Boolean.valueOf(z));
                    if (z) {
                        MMAppMgr.this.cfq.mo16770ae(60000, 60000);
                    }
                }
                AppMethodBeat.m2505o(29557);
                return true;
            }
        }
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    /* renamed from: com.tencent.mm.ui.MMAppMgr$Receiver */
    public static class Receiver extends BroadcastReceiver {
        private MMAppMgr appMgr;

        /* renamed from: com.tencent.mm.ui.MMAppMgr$Receiver$2 */
        class C52042 implements Runnable {
            C52042() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29566);
                MMAppMgr.m7890BK();
                AppMethodBeat.m2505o(29566);
            }
        }

        /* renamed from: com.tencent.mm.ui.MMAppMgr$Receiver$1 */
        class C52051 implements Runnable {
            C52051() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29565);
                MMAppMgr.m7890BK();
                AppMethodBeat.m2505o(29565);
            }
        }

        public Receiver(MMAppMgr mMAppMgr) {
            this.appMgr = mMAppMgr;
        }

        /* renamed from: aT */
        private static boolean m7919aT(Intent intent) {
            AppMethodBeat.m2504i(29567);
            if (!intent.getBooleanExtra("process_is_mm", false)) {
                AppMethodBeat.m2505o(29567);
                return true;
            } else if (intent.getIntExtra("process_id", 0) == Process.myPid()) {
                AppMethodBeat.m2505o(29567);
                return true;
            } else {
                AppMethodBeat.m2505o(29567);
                return false;
            }
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(29568);
            if (intent == null) {
                AppMethodBeat.m2505o(29568);
            } else if (C9638aw.m17183ZD() || C9638aw.m17185ZF()) {
                AppMethodBeat.m2505o(29568);
            } else {
                String action = intent.getAction();
                if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                    if (Receiver.m7919aT(intent)) {
                        MMAppMgr.m7895a(this.appMgr, intent, true);
                        this.appMgr.mo10674c(intent, true);
                        AppMethodBeat.m2505o(29568);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                    AppMethodBeat.m2505o(29568);
                } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                    if (Receiver.m7919aT(intent)) {
                        C41900n.m74002IF();
                        MMAppMgr.m7895a(this.appMgr, intent, false);
                        this.appMgr.mo10674c(intent, false);
                        if (MMAppMgr.ymG != null && MMAppMgr.ymG.length() > 800) {
                            new C7306ak(Looper.getMainLooper()).post(new C52051());
                        }
                        AppMethodBeat.m2505o(29568);
                        return;
                    }
                    C4990ab.m7421w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()));
                    AppMethodBeat.m2505o(29568);
                } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                    MMAppMgr.m7900aS(intent);
                    if (MMAppMgr.ymG != null && MMAppMgr.ymG.length() > 800) {
                        new C7306ak(Looper.getMainLooper()).post(new C52042());
                    }
                    AppMethodBeat.m2505o(29568);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                    int intExtra;
                    if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                        intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                        C4990ab.m7410d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(intExtra)));
                        if (C9638aw.m17179RK()) {
                            if (intExtra == 2) {
                                int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                                C7060h.pYm.mo8381e(11147, Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                            } else {
                                C7060h.pYm.mo8381e(11147, Integer.valueOf(intExtra));
                            }
                            if (intExtra == 4 && C30035i.dhV() == 4) {
                                C44057a dhs = C44057a.dhs();
                                if (dhs != null) {
                                    dhs.dhu();
                                }
                            }
                        }
                    } else {
                        C4990ab.m7410d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(intent.getIntExtra("intent_extra_opcode", 0))));
                        if (C9638aw.m17179RK()) {
                            C7060h.pYm.mo8381e(10328, Integer.valueOf(intExtra));
                        }
                    }
                    long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                    long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                    boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                    if (C9638aw.m17179RK() && !(longExtra == 0 && longExtra2 == 0)) {
                        C4990ab.m7411d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra));
                        if (booleanExtra) {
                            C9711n.m17283I((int) longExtra2, (int) longExtra, 0);
                            AppMethodBeat.m2505o(29568);
                            return;
                        }
                        C9711n.m17284J((int) longExtra2, (int) longExtra, 0);
                    }
                    AppMethodBeat.m2505o(29568);
                } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                    MMAppMgr.m7905bd(context);
                    AppMethodBeat.m2505o(29568);
                } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                    C44094a.m79369aF(intent);
                    AppMethodBeat.m2505o(29568);
                } else {
                    C4990ab.m7412e("MicroMsg.MMAppMgr", "unknown broadcast action");
                    AppMethodBeat.m2505o(29568);
                }
            }
        }
    }

    public MMAppMgr() {
        AppMethodBeat.m2504i(29569);
        AppMethodBeat.m2505o(29569);
    }

    /* renamed from: BK */
    static /* synthetic */ void m7890BK() {
        AppMethodBeat.m2504i(29591);
        MMAppMgr.dyq();
        AppMethodBeat.m2505o(29591);
    }

    /* renamed from: c */
    public final void mo10674c(Intent intent, boolean z) {
        String str;
        AppMethodBeat.m2504i(29570);
        if (z) {
            C45140n.acp();
            C9428oe c9428oe = new C9428oe();
            c9428oe.cKx.state = 1;
            C4879a.xxA.mo10055m(c9428oe);
            C26111d c26111d = new C26111d();
            c26111d.crQ.crR = true;
            C4879a.xxA.mo10055m(c26111d);
            C42034pc c42034pc = new C42034pc();
            c42034pc.cLr.active = true;
            C4879a.xxA.mo10055m(c42034pc);
            C32533cu c32533cu = new C32533cu();
            c32533cu.cvW.state = 1;
            C4879a.xxA.mo10055m(c32533cu);
        }
        C9352gd c9352gd = new C9352gd();
        c9352gd.cAs.csi = z;
        C4879a.xxA.mo10055m(c9352gd);
        this.ymJ = z;
        String stringExtra = intent.getStringExtra("classname");
        if (C5046bo.isNullOrNil(stringExtra)) {
            str = "";
        } else {
            str = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        }
        C41908x c41908x;
        if (z) {
            c41908x = C41908x.ecN;
            if (c41908x.ecY == -1) {
                if (c41908x.ecO.mo10573Ml(3) == 0) {
                    c41908x.ecO.setLong(1, C42252ah.anT());
                }
                c41908x.ecY = C42252ah.anT();
                String str2 = "MicroMsg.StayTimeReport";
                String str3 = "onAppResume chatUser:%s, class:%s";
                Object[] objArr = new Object[2];
                if (c41908x.ecR == null) {
                    stringExtra = BuildConfig.COMMAND;
                } else {
                    stringExtra = c41908x.ecR.ede;
                }
                objArr[0] = stringExtra;
                objArr[1] = str;
                C4990ab.m7417i(str2, str3, objArr);
                if (c41908x.ecR != null) {
                    c41908x.ecV = C42252ah.m74632yz();
                    if (str != null && str.contains("WebViewUI")) {
                        c41908x.ecW = C42252ah.m74632yz();
                    }
                }
            }
        } else {
            c41908x = C41908x.ecN;
            if (c41908x.ecY != -1) {
                stringExtra = ((String) c41908x.ecO.get(2, "")) + c41908x.ecY + "|" + C42252ah.anT() + "#";
                c41908x.ecO.set(2, stringExtra);
                int Ml = c41908x.ecO.mo10573Ml(3) + 1;
                c41908x.ecO.setInt(3, Ml);
                C4990ab.m7417i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", Integer.valueOf(Ml), Long.valueOf(c41908x.ecY), Long.valueOf(r4));
                c41908x.ecY = -1;
                if (C42252ah.m74621fp(c41908x.ecO.getLong(1, 0)) > 3600 * ((long) c41908x.eda) || Ml > c41908x.ecZ) {
                    C7060h.pYm.mo8374X(13110, stringExtra);
                    C4990ab.m7417i("MicroMsg.StayTimeReport", "report appStayTime:%s", stringExtra);
                    c41908x.ecO.set(2, "");
                    c41908x.ecO.setInt(3, 0);
                }
                if (c41908x.ecR != null) {
                    C32426a c32426a = c41908x.ecR;
                    c32426a.time += C42252ah.m74606az(c41908x.ecV) / 1000;
                    if (str != null && str.contains("WebViewUI")) {
                        c32426a = c41908x.ecR;
                        c32426a.edi = (int) (((long) c32426a.edi) + (C42252ah.m74606az(c41908x.ecW) / 1000));
                    }
                    C4990ab.m7417i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", Long.valueOf(c41908x.ecR.time));
                }
            }
        }
        if (C1720g.m3534RN().mo5161QY()) {
            Object obj;
            if (C5046bo.isNullOrNil(C29879l.uzq.uzu.url)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.ymN = 0;
                this.ymP.mo16770ae(100, 20);
            }
        }
        this.ymM.mo16770ae(800, 800);
        AppMethodBeat.m2505o(29570);
    }

    private static void dyq() {
        AppMethodBeat.m2504i(29571);
        StringBuffer stringBuffer = new StringBuffer(800);
        if (ymG == null) {
            ymG = stringBuffer;
            ymH = C5046bo.anT();
            AppMethodBeat.m2505o(29571);
            return;
        }
        String stringBuffer2 = ymG.toString();
        stringBuffer.append(MMAppMgr.aqF(stringBuffer2));
        ymG = stringBuffer;
        C4990ab.m7417i("MicroMsg.MMAppMgr", "oreh report clickstream %s", stringBuffer2);
        C7060h.pYm.mo8374X(10508, "1," + ymH + "," + stringBuffer2);
        ymH = C5046bo.anT();
        AppMethodBeat.m2505o(29571);
    }

    private static String aqF(String str) {
        AppMethodBeat.m2504i(29572);
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
        AppMethodBeat.m2505o(29572);
        return substring;
    }

    public static void dyr() {
        AppMethodBeat.m2504i(29573);
        C5769a.onDestroy();
        MMAppMgr.dyq();
        C4990ab.appenderClose();
        BaseEvent.onSingalCrash(0);
        AppMethodBeat.m2505o(29573);
    }

    public static void cancelNotification(String str) {
        AppMethodBeat.m2504i(29574);
        C9638aw.getNotification().cancelNotification(str);
        AppMethodBeat.m2505o(29574);
    }

    /* renamed from: BV */
    public static void m7891BV() {
        AppMethodBeat.m2504i(29575);
        C9638aw.getNotification().mo41566BV();
        AppMethodBeat.m2505o(29575);
    }

    public static void aAd() {
        AppMethodBeat.m2504i(29576);
        MMAppMgr.m7914pQ(true);
        AppMethodBeat.m2505o(29576);
    }

    /* renamed from: pQ */
    public static void m7914pQ(boolean z) {
        AppMethodBeat.m2504i(29577);
        C4990ab.m7421w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), C5046bo.dpG(), Boolean.valueOf(z));
        C34829d.m57192u(2, 0, "");
        if (z) {
            MMAppMgr.dys();
        }
        C4879a.xxA.mo10055m(new C26270x());
        C26171jl c26171jl = new C26171jl();
        c26171jl.cEK.status = 0;
        c26171jl.cEK.boZ = 2;
        C4879a.xxA.mo10055m(c26171jl);
        MMAppMgr.dyq();
        if (z) {
            C9638aw.m17202lE(C5046bo.dpG().toString());
            C1720g.m3537RQ().releaseAll();
        }
        C4990ab.appenderClose();
        BaseEvent.onSingalCrash(0);
        C5769a.onDestroy();
        C45273a.m83444f(C4996ah.getContext(), "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4");
        try {
            C16403w.clearAllWebViewCache(C4996ah.getContext(), true);
            C4990ab.m7416i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMAppMgr", "clear cookie failed : %s", e);
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.m2505o(29577);
    }

    public static void dys() {
        AppMethodBeat.m2504i(29578);
        Context context = C4996ah.getContext();
        if (context != null) {
            if (C45270c.m83434Ij()) {
                C1246e.m2684Bc();
            } else {
                try {
                    context.stopService(new Intent(context, CoreService.class));
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMAppMgr", "killService() Exception:%s", e.getMessage());
                }
            }
            C25985d.m41464aI(new Intent(context, NotifyService.class));
            context.stopService(new Intent(context, CacheService.class));
            C25985d.m41479l(new Intent().setClassName(context, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
        }
        AppMethodBeat.m2505o(29578);
    }

    /* renamed from: bd */
    public static void m7905bd(Context context) {
        AppMethodBeat.m2504i(29579);
        MMAppMgr.m7913k(context, true);
        AppMethodBeat.m2505o(29579);
    }

    /* renamed from: k */
    public static void m7913k(Context context, boolean z) {
        AppMethodBeat.m2504i(29580);
        C1720g.m3537RQ().mo5256cn(z);
        C5769a.onDestroy();
        BaseEvent.onSingalCrash(0);
        MMNativeJpeg.Destroy();
        C41900n.m74000BY();
        if (!(C9638aw.m17182Rg() == null || C9638aw.m17182Rg().ftA == null)) {
            C9638aw.m17182Rg().ftA.mo5533cH(z);
        }
        Intent intent = new Intent().setClass(context, LauncherUI.class);
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        intent.putExtra("kill_service", z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(29580);
    }

    /* renamed from: be */
    public static void m7906be(Context context) {
        AppMethodBeat.m2504i(29581);
        C1892aa.anh().edit().putBoolean("is_in_notify_mode", true).commit();
        C4997aj.amB("welcome_page_show");
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41583k(-1, null);
        C45382z c45382z = new C45382z();
        c45382z.csU.csV = false;
        C4879a.xxA.mo10055m(c45382z);
        C24824b.gkF.mo38846BV();
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41568IH();
        MMAppMgr.m7913k(context, false);
        AppMethodBeat.m2505o(29581);
    }

    /* renamed from: c */
    public static boolean m7909c(Context context, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(29582);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            final int intValue = ((Integer) C18628c.m29072Ry().get(65, Integer.valueOf(0))).intValue();
            if (intValue >= 5) {
                AppMethodBeat.m2505o(29582);
                return false;
            } else if (C4997aj.amA("show_wap_adviser")) {
                View inflate = View.inflate(context, 2130970300, null);
                ((TextView) inflate.findViewById(2131826339)).setText(C25738R.string.d5y);
                C5652a c5652a = new C5652a(context);
                c5652a.mo11446PV(C25738R.string.f9238tz);
                c5652a.mo11479fn(inflate);
                c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29559);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(65, Integer.valueOf(intValue + 1));
                        AppMethodBeat.m2505o(29559);
                    }
                });
                c5652a.mo11482rc(false);
                c5652a.mo11454Qd(C25738R.string.d5v).mo11476b(new C519312());
                c5652a.mo11458a(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(29561);
                        C4997aj.amB("show_wap_adviser");
                        if (onClickListener != null) {
                            onClickListener.onClick(dialogInterface, 0);
                        }
                        AppMethodBeat.m2505o(29561);
                    }
                });
                c5652a.aMb().show();
                AppMethodBeat.m2505o(29582);
                return true;
            } else {
                AppMethodBeat.m2505o(29582);
                return false;
            }
        }
        AppMethodBeat.m2505o(29582);
        return false;
    }

    /* renamed from: hr */
    public static boolean m7911hr(final Context context) {
        AppMethodBeat.m2504i(29583);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            if (C5046bo.m7546e((Boolean) C18628c.m29072Ry().get(61, null))) {
                AppMethodBeat.m2505o(29583);
                return false;
            } else if (C4997aj.amA("show_wap_adviser")) {
                View inflate = View.inflate(context, 2130970300, null);
                ((TextView) inflate.findViewById(2131826339)).setText(C25738R.string.d5z);
                CheckBox checkBox = (CheckBox) inflate.findViewById(2131826341);
                checkBox.setText(context.getString(C25738R.string.den));
                checkBox.setOnCheckedChangeListener(new C520014());
                checkBox.setVisibility(0);
                C5652a c5652a = new C5652a(context);
                c5652a.mo11446PV(C25738R.string.f9238tz);
                c5652a.mo11479fn(inflate);
                c5652a.mo11453Qc(C25738R.string.dep).mo11457a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29563);
                        try {
                            context.startActivity(new Intent("android.settings.APN_SETTINGS"));
                            AppMethodBeat.m2505o(29563);
                        } catch (Exception e) {
                            AppMethodBeat.m2505o(29563);
                        }
                    }
                });
                c5652a.mo11482rc(false);
                c5652a.mo11454Qd(C25738R.string.deo);
                c5652a.mo11458a(new C519416());
                c5652a.aMb().show();
                AppMethodBeat.m2505o(29583);
                return true;
            } else {
                AppMethodBeat.m2505o(29583);
                return false;
            }
        }
        AppMethodBeat.m2505o(29583);
        return false;
    }

    /* renamed from: Ch */
    public static boolean m7892Ch() {
        return false;
    }

    /* renamed from: aq */
    public static void m7901aq(Activity activity) {
        AppMethodBeat.m2504i(29584);
        Intent intent = new Intent();
        C25985d.m41448H(activity, "whatsnew", ".ui.WhatsNewUI");
        AppMethodBeat.m2505o(29584);
    }

    /* renamed from: hs */
    public static void m7912hs(Context context) {
        AppMethodBeat.m2504i(29585);
        SharedPreferences sharedPreferences = context.getSharedPreferences(C4996ah.doA(), 0);
        if (!sharedPreferences.getBoolean("Main_ShortCut", false)) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(C25738R.string.cmd));
            intent.putExtra("duplicate", false);
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(context.getPackageName(), C4996ah.doz() + ".ui.LauncherUI"));
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, C25738R.drawable.icon));
            intent.putExtra("shortcut_icon_resource_id", C25738R.drawable.icon);
            intent.putExtra("shortcut_is_adaptive_icon", true);
            intent.putExtra("is_main_shortcut", true);
            C42781b.m75869r(context, intent);
            Editor edit = sharedPreferences.edit();
            edit.putBoolean("Main_ShortCut", true);
            edit.commit();
        }
        AppMethodBeat.m2505o(29585);
    }

    /* renamed from: ar */
    public static boolean m7902ar(Activity activity) {
        AppMethodBeat.m2504i(29586);
        boolean a = MMAppMgr.m7896a(activity, null);
        AppMethodBeat.m2505o(29586);
        return a;
    }

    /* renamed from: a */
    public static boolean m7896a(final Activity activity, final OnClickListener onClickListener) {
        AppMethodBeat.m2504i(29587);
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(C4996ah.doA(), 0);
        boolean z = sharedPreferences.getBoolean("gprs_alert", true);
        C5059g.xye &= z;
        if (z) {
            View inflate = View.inflate(activity, 2130969804, null);
            String string = activity.getString(C25738R.string.dei);
            String string2 = activity.getString(C25738R.string.cw3);
            String string3 = activity.getString(C25738R.string.cw2, new Object[]{string, string2});
            Spannable newSpannable = Factory.getInstance().newSpannable(string3);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(29548);
                    C5046bo.m7506M(activity, C4996ah.getResources().getString(C25738R.string.g7o, new Object[]{C4988aa.m7403gw(activity), C4988aa.doq(), "setting", Integer.valueOf(0), Integer.valueOf(0)}));
                    AppMethodBeat.m2505o(29548);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.m2504i(29549);
                    textPaint.setColor(activity.getResources().getColor(C25738R.color.f12123t7));
                    AppMethodBeat.m2505o(29549);
                }
            }, string3.indexOf(string), string.length() + string3.indexOf(string), 33);
            newSpannable.setSpan(new StyleSpan(1), string3.indexOf(string2), string2.length() + string3.indexOf(string2), 33);
            TextView textView = (TextView) inflate.findViewById(2131824691);
            textView.setText(newSpannable);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            final CheckBox checkBox = (CheckBox) inflate.findViewById(2131824692);
            C5653c a = C30379h.m48451a((Context) activity, false, null, inflate, activity.getString(C25738R.string.atd), activity.getString(C25738R.string.cvz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(29550);
                    if (checkBox.isChecked()) {
                        Editor edit = sharedPreferences.edit();
                        edit.putBoolean("gprs_alert", false);
                        edit.commit();
                    }
                    C5059g.xye = false;
                    dialogInterface.dismiss();
                    MMAppMgr.m7912hs(activity);
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i);
                    }
                    AppMethodBeat.m2505o(29550);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(29551);
                    dialogInterface.dismiss();
                    MMAppMgr.m7905bd(activity);
                    AppMethodBeat.m2505o(29551);
                }
            });
            if (a == null) {
                AppMethodBeat.m2505o(29587);
                return false;
            }
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(29552);
                    activity.onKeyDown(4, new KeyEvent(0, 4));
                    AppMethodBeat.m2505o(29552);
                }
            });
        }
        AppMethodBeat.m2505o(29587);
        return z;
    }

    /* renamed from: a */
    public static boolean m7897a(Context context, int i, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        AppMethodBeat.m2504i(29588);
        View inflate = View.inflate(context, 2130970300, null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131826341);
        checkBox.setText(context.getString(C25738R.string.d5r));
        checkBox.setOnCheckedChangeListener(new C51886());
        inflate.findViewById(2131826340).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(2131826339);
        switch (i) {
            case 1:
                textView.setText(C25738R.string.d5q);
                z = true;
                break;
            case 3:
                textView.setText(C25738R.string.d60);
                z = false;
                break;
            default:
                textView.setText(C25738R.string.d60);
                z = true;
                break;
        }
        if (z) {
            C5652a c5652a = new C5652a(context);
            c5652a.mo11446PV(C25738R.string.f9238tz);
            c5652a.mo11482rc(false);
            c5652a.mo11479fn(inflate);
            c5652a.mo11453Qc(C25738R.string.d5x).mo11457a(onClickListener);
            c5652a.mo11454Qd(C25738R.string.d5r).mo11476b(onClickListener2);
            c5652a.aMb().show();
            AppMethodBeat.m2505o(29588);
            return true;
        }
        AppMethodBeat.m2505o(29588);
        return false;
    }

    /* renamed from: bg */
    public static C5653c m7907bg(final Context context) {
        AppMethodBeat.m2504i(29589);
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
            if (C5023at.isWifi(context) && locationManager.isProviderEnabled("gps")) {
                AppMethodBeat.m2505o(29589);
                return null;
            }
            C9638aw.m17190ZK();
            Boolean bool = (Boolean) C18628c.m29072Ry().get(4105, Boolean.FALSE);
            if (bool == null || !bool.booleanValue()) {
                View inflate = View.inflate(context, 2130969932, null);
                ((CheckBox) inflate.findViewById(2131825253)).setOnCheckedChangeListener(new C51897());
                OnClickListener c51908 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29555);
                        try {
                            context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                            AppMethodBeat.m2505o(29555);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
                            AppMethodBeat.m2505o(29555);
                        }
                    }
                };
                C5652a c5652a = new C5652a(context);
                c5652a.mo11446PV(C25738R.string.d56);
                c5652a.mo11479fn(inflate);
                c5652a.mo11453Qc(C25738R.string.f9225tk).mo11457a(c51908);
                c5652a.mo11454Qd(C25738R.string.f9154r7);
                C5653c aMb = c5652a.aMb();
                aMb.show();
                AppMethodBeat.m2505o(29589);
                return aMb;
            }
            AppMethodBeat.m2505o(29589);
            return null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert error", new Object[0]);
            AppMethodBeat.m2505o(29589);
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m7895a(MMAppMgr mMAppMgr, Intent intent, boolean z) {
        AppMethodBeat.m2504i(29590);
        String stringExtra = intent.getStringExtra("classname");
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7416i("MicroMsg.MMAppMgr", "dealWithClickStream className is null, broadcast should set this intent flag");
            AppMethodBeat.m2505o(29590);
            return;
        }
        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(".") + 1);
        C4872b.ame(stringExtra);
        if (ymG == null) {
            ymG = new StringBuffer(800);
            ymH = C5046bo.anT();
            ymG.append("start:");
            ymG.append(C5046bo.anT());
            ymG.append("|");
        }
        if (z) {
            if ("desktop".equals(mMAppMgr.gEn)) {
                ymG.append("desktop:");
                ymG.append(C5046bo.m7525az(mMAppMgr.fPQ) + 800);
                ymG.append("|");
            }
            mMAppMgr.fPQ = C5046bo.m7588yz();
            mMAppMgr.gEn = stringExtra;
        } else {
            ymG.append(mMAppMgr.gEn + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            ymG.append(C5046bo.m7525az(mMAppMgr.fPQ));
            ymG.append("|");
        }
        C9326e c9326e = new C9326e();
        c9326e.crS.active = z;
        c9326e.crS.className = stringExtra;
        C4879a.xxA.mo10055m(c9326e);
        C4990ab.m7417i("MicroMsg.MMAppMgr", "dkact classname %s, isAcitvity %b", stringExtra, Boolean.valueOf(z));
        AppMethodBeat.m2505o(29590);
    }

    /* renamed from: aS */
    static /* synthetic */ void m7900aS(Intent intent) {
        AppMethodBeat.m2504i(29592);
        String stringExtra = intent.getStringExtra(C8741b.CONTENT);
        if (C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7416i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
            AppMethodBeat.m2505o(29592);
            return;
        }
        if (ymG == null) {
            ymG = new StringBuffer(800);
        }
        ymG.append(stringExtra);
        C4990ab.m7417i("MicroMsg.MMAppMgr", "cpan content: %s", stringExtra);
        AppMethodBeat.m2505o(29592);
    }

    static /* synthetic */ void dyu() {
        boolean z;
        AppMethodBeat.m2504i(29593);
        C4990ab.m7410d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
        C9638aw.m17190ZK();
        Object obj = C18628c.m29072Ry().get(327808, null);
        if (obj == null) {
            z = true;
        } else if (C5046bo.isNullOrNil(obj.toString())) {
            z = true;
        } else {
            if (System.currentTimeMillis() - C5046bo.anl(obj.toString()) >= 604800000) {
                z = true;
            } else {
                z = false;
            }
        }
        C4990ab.m7411d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", String.valueOf(z));
        if (z) {
            try {
                C7060h.pYm.mo8374X(11375, C5046bo.nullAsNil(Secure.getString(C4996ah.getContext().getContentResolver(), "default_input_method")));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(327808, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.m2505o(29593);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(29593);
    }
}
