package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.e.b;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.d;
import com.tencent.mm.z.c.f;
import com.tencent.mm.z.d.a;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView;
import org.json.JSONObject;

public class e {
    private static volatile com.tencent.mm.z.c.e hoH;
    private static volatile DebuggerInfo hoI;

    static /* synthetic */ com.tencent.mm.z.c.e aAi() {
        AppMethodBeat.i(10972);
        com.tencent.mm.z.c.e aAf = aAf();
        AppMethodBeat.o(10972);
        return aAf;
    }

    public static com.tencent.mm.z.c.e a(Context context, final WxaWidgetContext wxaWidgetContext, a aVar, Bundle bundle) {
        com.tencent.mm.z.c.e eVar;
        com.tencent.mm.z.c.e aAf;
        String convertStreamToString;
        AppMethodBeat.i(10966);
        synchronized (e.class) {
            try {
                eVar = hoH;
                hoH = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(10966);
                }
            }
        }
        String str = "MicroMsg.PreloadOptimizer";
        String str2 = "hit preloaded jsBridge %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(eVar != null);
        u.i(str, str2, objArr);
        if (eVar == null) {
            aAf = aAf();
        } else {
            aAf = eVar;
        }
        int i = bundle.getInt("widget_type");
        c cVar = new c();
        cVar.eIq = wxaWidgetContext.getId();
        if (i == 1) {
            cVar.hnl = new com.tencent.mm.plugin.appbrand.dynamic.i.c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        com.tencent.mm.z.c.c cVar2 = new com.tencent.mm.z.c.c(context, aAf, aVar, cVar);
        cVar2.eIj = p.nM(i);
        aAf.eIr = cVar2;
        d dVar = aAf.eIt;
        aAf.eIs = new f(dVar, com.tencent.mm.plugin.appbrand.dynamic.f.a.nN(i), aVar);
        aAf.eIv = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.azQ();
        WidgetRuntimeConfig azM = wxaWidgetContext.azM();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "widgetType", Integer.valueOf(azM.hog));
        a(jSONObject, "platform", "android");
        a(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.azK().hmD));
        if (wxaWidgetContext.azL() != null) {
            a(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.azL().hfW));
        }
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "drawMinInterval", Integer.valueOf(azM.hox));
        a(jSONObject2, "timerEnabled", Boolean.valueOf(azM.hoy));
        a(jSONObject2, "drawLock", Boolean.valueOf(azM.hoz));
        dVar.evaluateJavascript(String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[]{jSONObject2.toString(), jSONObject.toString(), ""}), null);
        ab.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", wxaWidgetContext.getId(), r1);
        v.kT(10);
        ad eZ = new ad().eZ(u.pr(wxaWidgetContext.getId()));
        eZ.cYw = (long) u.pq(wxaWidgetContext.getId());
        eZ.cYs = 5;
        eZ = eZ.eY(wxaWidgetContext.getId());
        eZ.cYt = System.currentTimeMillis();
        eZ.fa(at.gB(ah.getContext())).ajK();
        String bR = com.tencent.mm.plugin.appbrand.dynamic.j.c.bR(wxaWidgetContext.getId(), "WAWidget.js");
        if (bo.isNullOrNil(bR)) {
            u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
            convertStreamToString = com.tencent.mm.plugin.appbrand.r.d.convertStreamToString(an.openRead("WAWidget.js"));
        } else {
            convertStreamToString = bR;
        }
        if (bo.isNullOrNil(convertStreamToString)) {
            ab.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        h.pYm.a(636, 0, 1, false);
        com.tencent.mm.z.a.a(dVar, convertStreamToString, new com.tencent.mm.z.a.a() {
            public final void Qp() {
                AppMethodBeat.i(10962);
                v.kT(11);
                ad eZ = new ad().eZ(u.pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) u.pq(wxaWidgetContext.getId());
                eZ.cYs = 6;
                eZ.cYu = 1;
                eZ = eZ.eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.fa(at.gB(ah.getContext())).ajK();
                h.pYm.a(636, 1, 1, false);
                AppMethodBeat.o(10962);
            }

            public final void lo(String str) {
                AppMethodBeat.i(10963);
                v.kT(12);
                ad eZ = new ad().eZ(u.pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) u.pq(wxaWidgetContext.getId());
                eZ.cYs = 6;
                eZ.cYu = 2;
                eZ = eZ.eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.fa(at.gB(ah.getContext())).ajK();
                j.azE().zZ(wxaWidgetContext.getId());
                h.pYm.a(636, 2, 1, false);
                ab.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", str);
                AppMethodBeat.o(10963);
            }
        });
        ab.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", wxaWidgetContext.getId());
        v.kT(13);
        convertStreamToString = com.tencent.mm.plugin.appbrand.dynamic.j.c.bR(wxaWidgetContext.getId(), "widget.js");
        if (bo.isNullOrNil(convertStreamToString)) {
            ab.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.azA().aZ(wxaWidgetContext.getId(), TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
        }
        h.pYm.a(636, 3, 1, false);
        com.tencent.mm.z.a.a(dVar, convertStreamToString, new com.tencent.mm.z.a.a() {
            public final void Qp() {
                AppMethodBeat.i(10964);
                v.kT(14);
                ad eZ = new ad().eZ(u.pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) u.pq(wxaWidgetContext.getId());
                eZ.cYs = 7;
                eZ.cYu = 1;
                eZ = eZ.eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.fa(at.gB(ah.getContext())).ajK();
                h.pYm.a(636, 4, 1, false);
                j.azE().zZ(wxaWidgetContext.getId());
                AppMethodBeat.o(10964);
            }

            public final void lo(String str) {
                AppMethodBeat.i(TbsReaderView.READER_CHANNEL_DOC_ID);
                v.kT(15);
                ad eZ = new ad().eZ(u.pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) u.pq(wxaWidgetContext.getId());
                eZ.cYs = 7;
                eZ.cYu = 2;
                eZ = eZ.eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.ajK();
                h.pYm.a(636, 5, 1, false);
                ab.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", str);
                AppMethodBeat.o(TbsReaderView.READER_CHANNEL_DOC_ID);
            }
        });
        ab.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", wxaWidgetContext.getId());
        cC(context);
        AppMethodBeat.o(10966);
        return aAf;
    }

    private static void G(final Runnable runnable) {
        AppMethodBeat.i(10967);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(10960);
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.i(10959);
                        Looper.myQueue().removeIdleHandler(this);
                        runnable.run();
                        AppMethodBeat.o(10959);
                        return false;
                    }
                });
                AppMethodBeat.o(10960);
            }
        };
        if (al.isMainThread()) {
            anonymousClass1.run();
            AppMethodBeat.o(10967);
            return;
        }
        al.d(anonymousClass1);
        AppMethodBeat.o(10967);
    }

    public static void cC(final Context context) {
        AppMethodBeat.i(10968);
        G(new Runnable() {
            /* JADX WARNING: Missing block: B:8:0x0014, code skipped:
            com.tencent.mm.modelappbrand.u.i("MicroMsg.PreloadOptimizer", "start preload mini jsbridge", new java.lang.Object[0]);
            com.tencent.mm.plugin.appbrand.dynamic.h.e.aAh();
            r0 = com.tencent.mm.plugin.appbrand.dynamic.h.e.aAi();
            r1 = com.tencent.mm.plugin.appbrand.dynamic.h.e.class;
     */
            /* JADX WARNING: Missing block: B:9:0x0029, code skipped:
            monitor-enter(r1);
     */
            /* JADX WARNING: Missing block: B:11:?, code skipped:
            com.tencent.mm.plugin.appbrand.dynamic.h.e.b(r0);
     */
            /* JADX WARNING: Missing block: B:12:0x002d, code skipped:
            monitor-exit(r1);
     */
            /* JADX WARNING: Missing block: B:20:0x003a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(10961);
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(10961);
                synchronized (e.class) {
                    try {
                        if (e.hoH != null) {
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(10961);
                    }
                }
            }
        });
        AppMethodBeat.o(10968);
    }

    private static com.tencent.mm.z.c.e aAf() {
        AppMethodBeat.i(10969);
        com.tencent.mm.z.c.e eVar = new com.tencent.mm.z.c.e();
        eVar.a(a(eVar));
        AppMethodBeat.o(10969);
        return eVar;
    }

    private static d a(com.tencent.mm.z.c.e eVar) {
        AppMethodBeat.i(10970);
        d bt = b.bt(eVar);
        h.pYm.a(639, 2, 1, false);
        ab.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        h.pYm.a(639, 0, 1, false);
        AppMethodBeat.o(10970);
        return bt;
    }

    private static void a(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.i(10971);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.o(10971);
        } catch (Exception e) {
            ab.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", e);
            AppMethodBeat.o(10971);
        }
    }
}
