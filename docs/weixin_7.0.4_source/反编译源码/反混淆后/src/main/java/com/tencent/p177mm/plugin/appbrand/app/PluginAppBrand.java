package com.tencent.p177mm.plugin.appbrand.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Keep;
import com.tencent.luggage.bridge.p814a.C8852a;
import com.tencent.luggage.bridge.p814a.C8852a.C88531;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.ipcinvoker.C45412g;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32810j;
import com.tencent.p177mm.modelappbrand.C37934g;
import com.tencent.p177mm.modelappbrand.C45446k;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.modelappbrand.p1642b.C45444a;
import com.tencent.p177mm.p1174aa.C32220e;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.p230g.p231a.C45381vz;
import com.tencent.p177mm.plugin.appbrand.C24681ah;
import com.tencent.p177mm.plugin.appbrand.C27305t;
import com.tencent.p177mm.plugin.appbrand.C33111b;
import com.tencent.p177mm.plugin.appbrand.C42331ag;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z;
import com.tencent.p177mm.plugin.appbrand.appcache.C42359s;
import com.tencent.p177mm.plugin.appbrand.appcache.C42360t;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.C38110c;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.C42355e;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33104x.C19094a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C33104x.C33105b;
import com.tencent.p177mm.plugin.appbrand.appstorage.p1535a.C38120a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10120c;
import com.tencent.p177mm.plugin.appbrand.appusage.C24686am;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.appusage.C38125ad;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f;
import com.tencent.p177mm.plugin.appbrand.appusage.C42377o;
import com.tencent.p177mm.plugin.appbrand.appusage.C42381p;
import com.tencent.p177mm.plugin.appbrand.appusage.C45520e;
import com.tencent.p177mm.plugin.appbrand.appusage.C45521g;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C10146e;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C26798h;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C45534c;
import com.tencent.p177mm.plugin.appbrand.config.C2115g.C21161;
import com.tencent.p177mm.plugin.appbrand.config.C26841n;
import com.tencent.p177mm.plugin.appbrand.debugger.C26850j;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1138a.C16599c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1138a.C42419d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p285c.C38191a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.C33173b;
import com.tencent.p177mm.plugin.appbrand.game.C38217c;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C19232c;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.C19290a;
import com.tencent.p177mm.plugin.appbrand.launching.C42609an;
import com.tencent.p177mm.plugin.appbrand.launching.p906b.C45636g;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C42614i;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38094a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38095c;
import com.tencent.p177mm.plugin.appbrand.p1468a.C45508b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27289f;
import com.tencent.p177mm.plugin.appbrand.p329s.C27293i;
import com.tencent.p177mm.plugin.appbrand.p329s.p330a.C2456a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C10834e;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C27324d;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C38525a;
import com.tencent.p177mm.plugin.appbrand.p896i.C10263a;
import com.tencent.p177mm.plugin.appbrand.p896i.C26904b;
import com.tencent.p177mm.plugin.appbrand.p896i.C38239c;
import com.tencent.p177mm.plugin.appbrand.p896i.C38240e;
import com.tencent.p177mm.plugin.appbrand.p896i.C45566d;
import com.tencent.p177mm.plugin.appbrand.p896i.C45567f;
import com.tencent.p177mm.plugin.appbrand.report.model.C2445j;
import com.tencent.p177mm.plugin.appbrand.service.C10733b;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C19732h;
import com.tencent.p177mm.plugin.appbrand.service.C19734i;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.appbrand.service.C45690c;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.p177mm.plugin.appbrand.share.p913a.C10736a;
import com.tencent.p177mm.plugin.appbrand.task.p1139a.C16697b;
import com.tencent.p177mm.plugin.appbrand.widget.C38572b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.C38584c;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.p1622w.C43755c;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Keep
/* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand */
public final class PluginAppBrand extends C7597f implements C1671c, C1813aj, C38095c {
    public static final String TAG = "MicroMsg.PluginAppBrand";
    private final C27289f singletonRegistry = new C27289f();
    private C4884c<C45381vz> xWebViewInitCompleteEventIListener = new C267211();

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$4 */
    class C189994 implements C1675g {
        C189994() {
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(129217);
            ((C9687e) C1720g.m3528K(C9687e.class)).initialize();
            AppMethodBeat.m2505o(129217);
        }

        /* renamed from: bi */
        public final void mo5177bi(boolean z) {
            AppMethodBeat.m2504i(129218);
            ((C9687e) C1720g.m3528K(C9687e.class)).shutdown();
            ((C9687e) C1720g.m3528K(C9687e.class)).aby().exit();
            AppMethodBeat.m2505o(129218);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$5 */
    class C190005 implements C5011c {
        C190005() {
        }

        /* renamed from: b */
        public final void mo4564b(String str, Throwable th) {
            AppMethodBeat.m2504i(129219);
            if (C5046bo.nullAsNil(str).contains(".plugin.appbrand")) {
                C7060h.pYm.mo8378a(365, 3, 1, false);
                KVCommCrossProcessReceiver.cgo();
            }
            AppMethodBeat.m2505o(129219);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$6 */
    class C190016 implements C32220e {
        C190016() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$a */
    static final class C19002a extends C7485q implements C1655b {
        private C19290a gQZ;
        private final C4884c gRa = new C190031();
        private C26850j gRb = new C26850j();

        /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$a$1 */
        class C190031 extends C4884c<C32512ae> {
            C190031() {
                AppMethodBeat.m2504i(129220);
                this.xxI = C32512ae.class.getName().hashCode();
                AppMethodBeat.m2505o(129220);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(129221);
                C1720g.m3528K(C11048d.class);
                AppMethodBeat.m2505o(129221);
                return false;
            }
        }

        C19002a() {
            super(C42340f.class);
            AppMethodBeat.m2504i(129222);
            AppMethodBeat.m2505o(129222);
        }

        public final void onAccountInitialized(C1705c c1705c) {
            AppMethodBeat.m2504i(129223);
            super.onAccountInitialized(c1705c);
            if (C5058f.IS_FLAVOR_RED) {
                C45520e c45520e = new C45520e();
                if (c45520e.mo5386kw(C7243d.vxo)) {
                    c45520e.transfer(C7243d.vxo);
                }
            }
            C1720g.m3543a(C10120c.class, new C6625e(new C10120c()));
            C33173b.initialize();
            ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a("link_view_wxapp", new C45566d());
            ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_view_wxapp", new C38239c());
            C1720g.m3543a(C45508b.class, new C6625e(C42360t.gTk));
            C1720g.m3543a(C26767ag.class, new C6625e(new C42381p()));
            C1720g.m3543a(C10118af.class, new C6625e(new C38128f()));
            C1720g.m3543a(C11048d.class, new C6625e(new C38572b()));
            C1720g.m3543a(C45444a.class, new C6625e(C27305t.auu()));
            C1720g.m3543a(C26798h.class, new C6625e(new C10146e()));
            C1720g.m3543a(C19732h.class, new C6625e(new C38110c()));
            C5730e.m8618N(C4996ah.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/", true);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("WeAppSyncCommand", C42355e.gVO);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("subscribesysmsg", C26904b.f13673int);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("WeAppPushCommand", C45567f.inF);
            this.gQZ = new C19290a();
            C2896d.bij();
            C2886b.m5129a(this.gQZ);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("DebugAppCodeUpdated", this.gRb);
            AppMethodBeat.m2505o(129223);
        }

        public final void parallelsDependency() {
            AppMethodBeat.m2504i(129224);
            C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C12029n.class));
            C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C38095c.class));
            AppMethodBeat.m2505o(129224);
        }

        public final void onAccountRelease() {
            AppMethodBeat.m2504i(129225);
            C1720g.m3529L(C26767ag.class);
            C1720g.m3529L(C10118af.class);
            C1720g.m3529L(C11048d.class);
            C1720g.m3529L(C26798h.class);
            C1720g.m3529L(C10120c.class);
            super.onAccountRelease();
            ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB("link_view_wxapp");
            ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_view_wxapp");
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("WeAppSyncCommand", C42355e.gVO);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("subscribesysmsg", C26904b.f13673int);
            C2896d.bij();
            C2886b.m5130b(this.gQZ);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("DebugAppCodeUpdated", this.gRb);
            AppMethodBeat.m2505o(129225);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$1 */
    class C267211 extends C4884c<C45381vz> {
        C267211() {
            AppMethodBeat.m2504i(129213);
            this.xxI = C45381vz.class.getName().hashCode();
            AppMethodBeat.m2505o(129213);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129214);
            C45381vz c45381vz = (C45381vz) c4883b;
            C18652u.m29151i(PluginAppBrand.TAG, "recv XWebViewInitCompleteEvent", new Object[0]);
            if (c45381vz.cTk.success) {
                if (C4996ah.doF()) {
                    C26864e.m42795cC(C4996ah.getContext());
                } else if (C4996ah.bqo()) {
                    ((C27297a) C1720g.m3528K(C27297a.class)).auH();
                }
            }
            AppMethodBeat.m2505o(129214);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$2 */
    class C267222 implements C1675g {
        C267222() {
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(129215);
            C38094a.gQI = C5046bo.anU();
            AppMethodBeat.m2505o(129215);
        }

        /* renamed from: bi */
        public final void mo5177bi(boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.PluginAppBrand$3 */
    class C267233 implements C1675g {
        C267233() {
        }

        /* renamed from: BR */
        public final void mo5176BR() {
            AppMethodBeat.m2504i(129216);
            C27324d.aMO();
            AppMethodBeat.m2505o(129216);
        }

        /* renamed from: bi */
        public final void mo5177bi(boolean z) {
        }
    }

    public PluginAppBrand() {
        AppMethodBeat.m2504i(129226);
        AppMethodBeat.m2505o(129226);
    }

    static {
        AppMethodBeat.m2504i(129236);
        C1449k.m3079a("appbrandcommon", PluginAppBrand.class.getClassLoader());
        C1449k.m3079a("wechatzstd", PluginAppBrand.class.getClassLoader());
        AppMethodBeat.m2505o(129236);
    }

    public final List<C1812ai> getDataTransferList() {
        AppMethodBeat.m2504i(129227);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C21161());
        linkedList.add(new C38125ad());
        linkedList.add(new C45520e());
        AppMethodBeat.m2505o(129227);
        return linkedList;
    }

    public final void onAccountInitialized(C1705c c1705c) {
    }

    public final void onAccountRelease() {
    }

    /* Access modifiers changed, original: final */
    public final C42340f getCore() {
        AppMethodBeat.m2504i(129228);
        C42340f c42340f = (C42340f) C7485q.m12925Y(C42340f.class);
        AppMethodBeat.m2505o(129228);
        return c42340f;
    }

    public final void installed() {
        AppMethodBeat.m2504i(129229);
        alias(C38095c.class);
        this.xWebViewInitCompleteEventIListener.dnU();
        AppMethodBeat.m2505o(129229);
    }

    public final void dependency() {
        AppMethodBeat.m2504i(129230);
        dependsOn(C27697a.class);
        dependsOn(C45534c.class);
        AppMethodBeat.m2505o(129230);
    }

    public final void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(129231);
        if (PluginAppBrand.isAppBrandProcess()) {
            C1720g.m3537RQ().mo5252a(new C267222());
        }
        AppMethodBeat.m2505o(129231);
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(129232);
        C4990ab.m7411d(TAG, "current process name = %s, isMainThread %b", ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT, Boolean.valueOf(C5004al.isMainThread()));
        C1720g.m3543a(IBSPatchJNIService.class, new C6625e(new BSPatchJNIWrapper()));
        C1720g.m3543a(C45691e.class, new C6625e(new C42609an()));
        C1720g.m3543a(C9687e.class, new C6625e(new C16599c()));
        C1720g.m3543a(C37934g.class, new C6625e(new C42419d()));
        C1720g.m3543a(C42687f.class, new C6625e(new C45636g()));
        C1720g.m3542a(C38120a.class, (C1694a) c1681g.mo5181SG() ? C33105b.gYG : C19094a.gYE);
        C19232c.axy();
        initJSONABTestGetter();
        C42344g c42344g = new C42344g();
        if (C8852a.bOP != null) {
            C45124d.m82927e("Luggage.LuggageBoot", "do not setup more than once.");
        } else {
            C8852a.bOP = c42344g;
            c42344g.mo20026a(new C88531());
        }
        if (c1681g.mo5181SG()) {
            C1720g.m3537RQ().mo5252a(new C267233());
            C38584c c38584c = C38584c.iZz;
            C38584c.init(C4996ah.getContext());
            C43755c.qwS.mo69466a(new C42331ag());
            C43755c.qwS.mo69466a(new C24681ah());
            C1720g.m3543a(C19002a.class, new C6625e(new C19002a()));
            C1720g.m3543a(C11048d.class, new C6625e(new C38572b()));
            C1720g.m3543a(C32809i.class, new C6625e(new C10736a()));
            C1720g.m3543a(C10834e.class, new C6625e(new C38525a()));
            C1720g.m3543a(C27297a.class, new C6625e(new C19020d()));
            C1720g.m3543a(C42686d.class, new C6625e(new C26841n()));
            C1720g.m3543a(C19731g.class, new C6625e(new C24682c()));
            C1720g.m3543a(C33065d.class, new C6625e(new C45509h()));
            C1720g.m3543a(C33574a.class, new C6625e(new C10062i()));
            C1720g.m3543a(C19734i.class, new C6625e(new C24686am()));
            C1720g.m3543a(C45690c.class, new C6625e(new C38217c()));
            C1720g.m3543a(C45446k.class, new C6625e(new C38240e()));
            C1720g.m3543a(C32810j.class, new C6625e(new C10263a()));
            C1720g.m3543a(C10733b.class, new C6625e(new C27293i()));
            C44042b.m79163a(new C33111b(), "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_video", "//localwxalibrary");
            C44042b.m79163a(new C38191a(), "//widget");
            C1720g.m3537RQ().mo5252a(new C189994());
            if (DebuggerShell.ayU()) {
                C1720g.m3542a(DebuggerShell.class, new DebuggerShell());
            }
            C26751z.m42581a(new C42359s());
            AppMethodBeat.m2505o(129232);
            return;
        }
        if (C4996ah.doF() || C4996ah.doG() || PluginAppBrand.isAppBrandProcess()) {
            C2445j.aLp();
            C45412g.m83632lh("com.tencent.mm:tools");
            C1720g.m3543a(C26767ag.class, new C6625e(new C42377o()));
            C1720g.m3543a(C10118af.class, new C6625e(new C45521g()));
            C1720g.m3543a(C11048d.class, new C6625e(new C38572b()));
            C1720g.m3543a(C26798h.class, new C6625e(new AppBrandBackgroundFetchDataStorageIPC()));
            C1720g.m3543a(C27297a.class, new C6625e(new C42333e()));
            C42614i.m75453cR(C4996ah.getContext());
            C27289f c27289f = this.singletonRegistry;
            Application application = c1681g.f1233cc;
            C4990ab.m7416i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
            application.registerActivityLifecycleCallbacks(c27289f);
            c27289f = this.singletonRegistry;
            application = c1681g.f1233cc;
            c27289f.iRo = true;
            c27289f.app = application;
            c27289f = this.singletonRegistry;
            C4990ab.m7417i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", C2456a.iRU);
            c27289f.iRm.offer(r1);
        }
        if (C4996ah.doF() || C4996ah.doG()) {
            C33173b.initialize();
            C5013ao.m7457a(new C190005());
        } else if (PluginAppBrand.isAppBrandProcess()) {
            AppBrandProcessSuicideLogic.m29572e(c1681g.f1233cc);
            try {
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "pref_appbrand_process", 4);
                String str = C4996ah.getProcessName() + ":start_time";
                Editor edit = sharedPreferences.edit();
                if (sharedPreferences.contains(str)) {
                    edit.remove(str);
                    C7053e.pXa.mo8378a(365, 2, 1, false);
                }
                C7053e.pXa.mo8378a(365, 4, 1, false);
                edit.putLong(str, System.currentTimeMillis());
                edit.commit();
                C4990ab.m7418v("MicroMsg.AppBrandReporter", "onProcessStart");
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessStart()", new Object[0]);
            }
            KVCommCrossProcessReceiver.cgk();
            C16697b.m25702e(c1681g.f1233cc);
        } else if (PluginAppBrand.isSupportProcess()) {
            C26864e.m42795cC(C4996ah.getContext());
            C41725h.initialize();
        }
        if (C4996ah.doF()) {
            C41725h.initialize();
        }
        AppMethodBeat.m2505o(129232);
    }

    public final String name() {
        return "plugin-appbrand";
    }

    static boolean isAppBrandProcess() {
        AppMethodBeat.m2504i(129233);
        try {
            boolean startsWith = ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT.startsWith(C4996ah.getPackageName() + ":appbrand");
            AppMethodBeat.m2505o(129233);
            return startsWith;
        } catch (Exception e) {
            AppMethodBeat.m2505o(129233);
            return false;
        }
    }

    static boolean isSupportProcess() {
        AppMethodBeat.m2504i(129234);
        try {
            boolean equals = "com.tencent.mm:support".equals(((C6624h) C1720g.m3533RM().mo5224Rn()).eHT);
            AppMethodBeat.m2505o(129234);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.m2505o(129234);
            return false;
        }
    }

    private void initJSONABTestGetter() {
        AppMethodBeat.m2504i(129235);
        C41725h.m73454a(new C190016());
        AppMethodBeat.m2505o(129235);
    }
}
