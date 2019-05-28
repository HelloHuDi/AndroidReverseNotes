package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.q;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.appusage.ad;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.am;
import com.tencent.mm.plugin.appbrand.appusage.o;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC;
import com.tencent.mm.plugin.appbrand.backgroundfetch.h;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.j;
import com.tencent.mm.plugin.appbrand.dynamic.h.e;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Keep
public final class PluginAppBrand extends f implements c, aj, com.tencent.mm.plugin.appbrand.a.c {
    public static final String TAG = "MicroMsg.PluginAppBrand";
    private final com.tencent.mm.plugin.appbrand.s.f singletonRegistry = new com.tencent.mm.plugin.appbrand.s.f();
    private com.tencent.mm.sdk.b.c<vz> xWebViewInitCompleteEventIListener = new com.tencent.mm.sdk.b.c<vz>() {
        {
            AppMethodBeat.i(129213);
            this.xxI = vz.class.getName().hashCode();
            AppMethodBeat.o(129213);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(129214);
            vz vzVar = (vz) bVar;
            u.i(PluginAppBrand.TAG, "recv XWebViewInitCompleteEvent", new Object[0]);
            if (vzVar.cTk.success) {
                if (ah.doF()) {
                    e.cC(ah.getContext());
                } else if (ah.bqo()) {
                    ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).auH();
                }
            }
            AppMethodBeat.o(129214);
            return false;
        }
    };

    static final class a extends q implements com.tencent.mm.kernel.a.b.b {
        private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a gQZ;
        private final com.tencent.mm.sdk.b.c gRa = new com.tencent.mm.sdk.b.c<ae>() {
            {
                AppMethodBeat.i(129220);
                this.xxI = ae.class.getName().hashCode();
                AppMethodBeat.o(129220);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(129221);
                g.K(d.class);
                AppMethodBeat.o(129221);
                return false;
            }
        };
        private j gRb = new j();

        a() {
            super(f.class);
            AppMethodBeat.i(129222);
            AppMethodBeat.o(129222);
        }

        public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
            AppMethodBeat.i(129223);
            super.onAccountInitialized(cVar);
            if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                com.tencent.mm.plugin.appbrand.appusage.e eVar = new com.tencent.mm.plugin.appbrand.appusage.e();
                if (eVar.kw(com.tencent.mm.protocal.d.vxo)) {
                    eVar.transfer(com.tencent.mm.protocal.d.vxo);
                }
            }
            g.a(com.tencent.mm.plugin.appbrand.appusage.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.c()));
            com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
            ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.i.d());
            ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.i.c());
            g.a(com.tencent.mm.plugin.appbrand.a.b.class, new com.tencent.mm.kernel.c.e(t.gTk));
            g.a(ag.class, new com.tencent.mm.kernel.c.e(new p()));
            g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.f()));
            g.a(d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.b()));
            g.a(com.tencent.mm.modelappbrand.b.a.class, new com.tencent.mm.kernel.c.e(com.tencent.mm.plugin.appbrand.t.auu()));
            g.a(h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.backgroundfetch.e()));
            g.a(com.tencent.mm.plugin.appbrand.service.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appcache.b.c()));
            com.tencent.mm.vfs.e.N(ah.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/", true);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.e.gVO);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.i.b.f4int);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("WeAppPushCommand", com.tencent.mm.plugin.appbrand.i.f.inF);
            this.gQZ = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
            com.tencent.mm.plugin.downloader.model.d.bij();
            com.tencent.mm.plugin.downloader.model.b.a(this.gQZ);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.gRb);
            AppMethodBeat.o(129223);
        }

        public final void parallelsDependency() {
            AppMethodBeat.i(129224);
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(g.M(n.class));
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(g.M(com.tencent.mm.plugin.appbrand.a.c.class));
            AppMethodBeat.o(129224);
        }

        public final void onAccountRelease() {
            AppMethodBeat.i(129225);
            g.L(ag.class);
            g.L(af.class);
            g.L(d.class);
            g.L(h.class);
            g.L(com.tencent.mm.plugin.appbrand.appusage.c.class);
            super.onAccountRelease();
            ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QB("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.b.e.gVO);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.i.b.f4int);
            com.tencent.mm.plugin.downloader.model.d.bij();
            com.tencent.mm.plugin.downloader.model.b.b(this.gQZ);
            ((com.tencent.mm.plugin.messenger.foundation.a.p) g.M(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.gRb);
            AppMethodBeat.o(129225);
        }
    }

    public PluginAppBrand() {
        AppMethodBeat.i(129226);
        AppMethodBeat.o(129226);
    }

    static {
        AppMethodBeat.i(129236);
        k.a("appbrandcommon", PluginAppBrand.class.getClassLoader());
        k.a("wechatzstd", PluginAppBrand.class.getClassLoader());
        AppMethodBeat.o(129236);
    }

    public final List<ai> getDataTransferList() {
        AppMethodBeat.i(129227);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new ai() {
            public final void transfer(int i) {
                AppMethodBeat.i(129842);
                if (kw(i)) {
                    try {
                        ab.d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                        com.tencent.mm.plugin.appbrand.app.f auL = com.tencent.mm.plugin.appbrand.app.f.auL();
                        if (auL != null) {
                            a auM = auL.auM();
                            com.tencent.mm.plugin.appbrand.app.f.auO();
                            auM.hY("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                            AppMethodBeat.o(129842);
                            return;
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", e);
                    }
                    AppMethodBeat.o(129842);
                    return;
                }
                AppMethodBeat.o(129842);
            }

            public final boolean kw(int i) {
                return i >= 637863936 && i <= 637863988;
            }

            public final String getTag() {
                return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
            }
        });
        linkedList.add(new ad());
        linkedList.add(new com.tencent.mm.plugin.appbrand.appusage.e());
        AppMethodBeat.o(129227);
        return linkedList;
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
    }

    public final void onAccountRelease() {
    }

    /* Access modifiers changed, original: final */
    public final f getCore() {
        AppMethodBeat.i(129228);
        f fVar = (f) q.Y(f.class);
        AppMethodBeat.o(129228);
        return fVar;
    }

    public final void installed() {
        AppMethodBeat.i(129229);
        alias(com.tencent.mm.plugin.appbrand.a.c.class);
        this.xWebViewInitCompleteEventIListener.dnU();
        AppMethodBeat.o(129229);
    }

    public final void dependency() {
        AppMethodBeat.i(129230);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.appbrand.compat.a.c.class);
        AppMethodBeat.o(129230);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(129231);
        if (isAppBrandProcess()) {
            g.RQ().a(new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(129215);
                    com.tencent.mm.plugin.appbrand.a.a.gQI = bo.anU();
                    AppMethodBeat.o(129215);
                }

                public final void bi(boolean z) {
                }
            });
        }
        AppMethodBeat.o(129231);
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(129232);
        ab.d(TAG, "current process name = %s, isMainThread %b", ((com.tencent.mm.kernel.b.h) g.RM().Rn()).eHT, Boolean.valueOf(al.isMainThread()));
        g.a(IBSPatchJNIService.class, new com.tencent.mm.kernel.c.e(new BSPatchJNIWrapper()));
        g.a(com.tencent.mm.plugin.appbrand.service.e.class, new com.tencent.mm.kernel.c.e(new an()));
        g.a(com.tencent.mm.modelappbrand.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.d()));
        g.a(com.tencent.mm.plugin.appbrand.service.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.b.g()));
        g.a(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a) gVar.SG() ? x.b.gYG : com.tencent.mm.plugin.appbrand.appstorage.x.a.gYE);
        com.tencent.mm.plugin.appbrand.game.c.c.axy();
        initJSONABTestGetter();
        g gVar2 = new g();
        if (com.tencent.luggage.bridge.a.a.bOP != null) {
            com.tencent.luggage.g.d.e("Luggage.LuggageBoot", "do not setup more than once.");
        } else {
            com.tencent.luggage.bridge.a.a.bOP = gVar2;
            gVar2.a(new com.tencent.luggage.bridge.a.a.c() {
                public final <T extends com.tencent.luggage.a.b> void a(Class<T> cls, T t) {
                    AppMethodBeat.i(90747);
                    com.tencent.luggage.a.e.a((Class) cls, (com.tencent.luggage.a.b) t);
                    AppMethodBeat.o(90747);
                }

                public final <T extends com.tencent.luggage.a.d> void a(Class<T> cls, T t) {
                    AppMethodBeat.i(90748);
                    com.tencent.luggage.a.e.a((Class) cls, (com.tencent.luggage.a.d) t);
                    AppMethodBeat.o(90748);
                }
            });
        }
        if (gVar.SG()) {
            g.RQ().a(new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(129216);
                    com.tencent.mm.plugin.appbrand.ui.banner.d.aMO();
                    AppMethodBeat.o(129216);
                }

                public final void bi(boolean z) {
                }
            });
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c cVar = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c.iZz;
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.c.init(ah.getContext());
            com.tencent.mm.plugin.w.c.qwS.a(new com.tencent.mm.plugin.appbrand.ag());
            com.tencent.mm.plugin.w.c.qwS.a(new com.tencent.mm.plugin.appbrand.ah());
            g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
            g.a(d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.b()));
            g.a(i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
            g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
            g.a(com.tencent.mm.plugin.appbrand.service.a.class, new com.tencent.mm.kernel.c.e(new d()));
            g.a(com.tencent.mm.plugin.appbrand.service.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.n()));
            g.a(com.tencent.mm.plugin.appbrand.service.g.class, new com.tencent.mm.kernel.c.e(new c()));
            g.a(com.tencent.mm.plugin.appbrand.a.d.class, new com.tencent.mm.kernel.c.e(new h()));
            g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new com.tencent.mm.kernel.c.e(new i()));
            g.a(com.tencent.mm.plugin.appbrand.service.i.class, new com.tencent.mm.kernel.c.e(new am()));
            g.a(com.tencent.mm.plugin.appbrand.service.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.c()));
            g.a(com.tencent.mm.modelappbrand.k.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.i.e()));
            g.a(com.tencent.mm.modelappbrand.j.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.i.a()));
            g.a(com.tencent.mm.plugin.appbrand.service.b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.s.i()));
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), "//wagame", "//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//appbrand_predownload_trigger", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//xweb_video", "//localwxalibrary");
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), "//widget");
            g.RQ().a(new com.tencent.mm.kernel.api.g() {
                public final void BR() {
                    AppMethodBeat.i(129217);
                    ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).initialize();
                    AppMethodBeat.o(129217);
                }

                public final void bi(boolean z) {
                    AppMethodBeat.i(129218);
                    ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).aby().exit();
                    AppMethodBeat.o(129218);
                }
            });
            if (DebuggerShell.ayU()) {
                g.a(DebuggerShell.class, new DebuggerShell());
            }
            z.a(new s());
            AppMethodBeat.o(129232);
            return;
        }
        if (ah.doF() || ah.doG() || isAppBrandProcess()) {
            com.tencent.mm.plugin.appbrand.report.model.j.aLp();
            com.tencent.mm.ipcinvoker.g.lh("com.tencent.mm:tools");
            g.a(ag.class, new com.tencent.mm.kernel.c.e(new o()));
            g.a(af.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.g()));
            g.a(d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.b()));
            g.a(h.class, new com.tencent.mm.kernel.c.e(new AppBrandBackgroundFetchDataStorageIPC()));
            g.a(com.tencent.mm.plugin.appbrand.service.a.class, new com.tencent.mm.kernel.c.e(new e()));
            com.tencent.mm.plugin.appbrand.launching.precondition.i.cR(ah.getContext());
            com.tencent.mm.plugin.appbrand.s.f fVar = this.singletonRegistry;
            Application application = gVar.cc;
            ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
            application.registerActivityLifecycleCallbacks(fVar);
            fVar = this.singletonRegistry;
            application = gVar.cc;
            fVar.iRo = true;
            fVar.app = application;
            fVar = this.singletonRegistry;
            ab.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", com.tencent.mm.plugin.appbrand.s.a.a.iRU);
            fVar.iRm.offer(r1);
        }
        if (ah.doF() || ah.doG()) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.b.initialize();
            ao.a(new ao.c() {
                public final void b(String str, Throwable th) {
                    AppMethodBeat.i(129219);
                    if (bo.nullAsNil(str).contains(".plugin.appbrand")) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(365, 3, 1, false);
                        KVCommCrossProcessReceiver.cgo();
                    }
                    AppMethodBeat.o(129219);
                }
            });
        } else if (isAppBrandProcess()) {
            AppBrandProcessSuicideLogic.e(gVar.cc);
            try {
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4);
                String str = ah.getProcessName() + ":start_time";
                Editor edit = sharedPreferences.edit();
                if (sharedPreferences.contains(str)) {
                    edit.remove(str);
                    com.tencent.mm.plugin.report.e.pXa.a(365, 2, 1, false);
                }
                com.tencent.mm.plugin.report.e.pXa.a(365, 4, 1, false);
                edit.putLong(str, System.currentTimeMillis());
                edit.commit();
                ab.v("MicroMsg.AppBrandReporter", "onProcessStart");
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrandReporter", th, "onProcessStart()", new Object[0]);
            }
            KVCommCrossProcessReceiver.cgk();
            com.tencent.mm.plugin.appbrand.task.a.b.e(gVar.cc);
        } else if (isSupportProcess()) {
            e.cC(ah.getContext());
            com.tencent.mm.aa.h.initialize();
        }
        if (ah.doF()) {
            com.tencent.mm.aa.h.initialize();
        }
        AppMethodBeat.o(129232);
    }

    public final String name() {
        return "plugin-appbrand";
    }

    static boolean isAppBrandProcess() {
        AppMethodBeat.i(129233);
        try {
            boolean startsWith = ((com.tencent.mm.kernel.b.h) g.RM().Rn()).eHT.startsWith(ah.getPackageName() + ":appbrand");
            AppMethodBeat.o(129233);
            return startsWith;
        } catch (Exception e) {
            AppMethodBeat.o(129233);
            return false;
        }
    }

    static boolean isSupportProcess() {
        AppMethodBeat.i(129234);
        try {
            boolean equals = "com.tencent.mm:support".equals(((com.tencent.mm.kernel.b.h) g.RM().Rn()).eHT);
            AppMethodBeat.o(129234);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.o(129234);
            return false;
        }
    }

    private void initJSONABTestGetter() {
        AppMethodBeat.i(129235);
        com.tencent.mm.aa.h.a(new com.tencent.mm.aa.e() {
        });
        AppMethodBeat.o(129235);
    }
}
