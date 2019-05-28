package com.tencent.p177mm.plugin.appbrand.dynamic.p288h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p652z.C44436a;
import com.tencent.p177mm.p652z.C44436a.C36402a;
import com.tencent.p177mm.p652z.p1101b.C40954d;
import com.tencent.p177mm.p652z.p653c.C16117f;
import com.tencent.p177mm.p652z.p653c.C30909e;
import com.tencent.p177mm.p652z.p653c.C5756c;
import com.tencent.p177mm.p652z.p654d.C5759a;
import com.tencent.p177mm.plugin.appbrand.appcache.C38104an;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.C19180a;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1220f.C19182a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1221i.C19189c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.C45546p;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C19177c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C2151c;
import com.tencent.p177mm.plugin.appbrand.dynamic.p891e.C26862b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.e */
public class C26864e {
    private static volatile C30909e hoH;
    private static volatile DebuggerInfo hoI;

    static /* synthetic */ C30909e aAi() {
        AppMethodBeat.m2504i(10972);
        C30909e aAf = C26864e.aAf();
        AppMethodBeat.m2505o(10972);
        return aAf;
    }

    /* renamed from: a */
    public static C30909e m42792a(Context context, final WxaWidgetContext wxaWidgetContext, C5759a c5759a, Bundle bundle) {
        C30909e c30909e;
        C30909e aAf;
        String convertStreamToString;
        AppMethodBeat.m2504i(10966);
        synchronized (C26864e.class) {
            try {
                c30909e = hoH;
                hoH = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(10966);
                }
            }
        }
        String str = "MicroMsg.PreloadOptimizer";
        String str2 = "hit preloaded jsBridge %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(c30909e != null);
        C18652u.m29151i(str, str2, objArr);
        if (c30909e == null) {
            aAf = C26864e.aAf();
        } else {
            aAf = c30909e;
        }
        int i = bundle.getInt("widget_type");
        C19177c c19177c = new C19177c();
        c19177c.eIq = wxaWidgetContext.getId();
        if (i == 1) {
            c19177c.hnl = new C19189c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        C5756c c5756c = new C5756c(context, aAf, c5759a, c19177c);
        c5756c.eIj = C45546p.m83997nM(i);
        aAf.eIr = c5756c;
        C40954d c40954d = aAf.eIt;
        aAf.eIs = new C16117f(c40954d, C19182a.m29838nN(i), c5759a);
        aAf.eIv = C19180a.azQ();
        WidgetRuntimeConfig azM = wxaWidgetContext.azM();
        JSONObject jSONObject = new JSONObject();
        C26864e.m42793a(jSONObject, "widgetType", Integer.valueOf(azM.hog));
        C26864e.m42793a(jSONObject, "platform", "android");
        C26864e.m42793a(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.azK().hmD));
        if (wxaWidgetContext.azL() != null) {
            C26864e.m42793a(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.azL().hfW));
        }
        C26864e.m42793a(jSONObject, "clientVersion", Integer.valueOf(C7243d.vxo));
        JSONObject jSONObject2 = new JSONObject();
        C26864e.m42793a(jSONObject2, "drawMinInterval", Integer.valueOf(azM.hox));
        C26864e.m42793a(jSONObject2, "timerEnabled", Boolean.valueOf(azM.hoy));
        C26864e.m42793a(jSONObject2, "drawLock", Boolean.valueOf(azM.hoz));
        c40954d.evaluateJavascript(String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[]{jSONObject2.toString(), jSONObject.toString(), ""}), null);
        C4990ab.m7419v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", wxaWidgetContext.getId(), r1);
        C26439v.m42099kT(10);
        C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(wxaWidgetContext.getId()));
        eZ.cYw = (long) C18652u.m29153pq(wxaWidgetContext.getId());
        eZ.cYs = 5;
        eZ = eZ.mo43950eY(wxaWidgetContext.getId());
        eZ.cYt = System.currentTimeMillis();
        eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
        String bR = C2151c.m4363bR(wxaWidgetContext.getId(), "WAWidget.js");
        if (C5046bo.isNullOrNil(bR)) {
            C18652u.m29151i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
            convertStreamToString = C45672d.convertStreamToString(C38104an.openRead("WAWidget.js"));
        } else {
            convertStreamToString = bR;
        }
        if (C5046bo.isNullOrNil(convertStreamToString)) {
            C4990ab.m7412e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        C7060h.pYm.mo8378a(636, 0, 1, false);
        C44436a.m80370a(c40954d, convertStreamToString, new C36402a() {
            /* renamed from: Qp */
            public final void mo44634Qp() {
                AppMethodBeat.m2504i(10962);
                C26439v.m42099kT(11);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) C18652u.m29153pq(wxaWidgetContext.getId());
                eZ.cYs = 6;
                eZ.cYu = 1;
                eZ = eZ.mo43950eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                C7060h.pYm.mo8378a(636, 1, 1, false);
                AppMethodBeat.m2505o(10962);
            }

            /* renamed from: lo */
            public final void mo44635lo(String str) {
                AppMethodBeat.m2504i(10963);
                C26439v.m42099kT(12);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) C18652u.m29153pq(wxaWidgetContext.getId());
                eZ.cYs = 6;
                eZ.cYu = 2;
                eZ = eZ.mo43950eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                C38203j.azE().mo60941zZ(wxaWidgetContext.getId());
                C7060h.pYm.mo8378a(636, 2, 1, false);
                C4990ab.m7413e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", str);
                AppMethodBeat.m2505o(10963);
            }
        });
        C4990ab.m7419v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", wxaWidgetContext.getId());
        C26439v.m42099kT(13);
        convertStreamToString = C2151c.m4363bR(wxaWidgetContext.getId(), "widget.js");
        if (C5046bo.isNullOrNil(convertStreamToString)) {
            C4990ab.m7412e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            C10211f.azA().mo21628aZ(wxaWidgetContext.getId(), TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
        }
        C7060h.pYm.mo8378a(636, 3, 1, false);
        C44436a.m80370a(c40954d, convertStreamToString, new C36402a() {
            /* renamed from: Qp */
            public final void mo44634Qp() {
                AppMethodBeat.m2504i(10964);
                C26439v.m42099kT(14);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) C18652u.m29153pq(wxaWidgetContext.getId());
                eZ.cYs = 7;
                eZ.cYu = 1;
                eZ = eZ.mo43950eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                C7060h.pYm.mo8378a(636, 4, 1, false);
                C38203j.azE().mo60941zZ(wxaWidgetContext.getId());
                AppMethodBeat.m2505o(10964);
            }

            /* renamed from: lo */
            public final void mo44635lo(String str) {
                AppMethodBeat.m2504i(TbsReaderView.READER_CHANNEL_DOC_ID);
                C26439v.m42099kT(15);
                C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(wxaWidgetContext.getId()));
                eZ.cYw = (long) C18652u.m29153pq(wxaWidgetContext.getId());
                eZ.cYs = 7;
                eZ.cYu = 2;
                eZ = eZ.mo43950eY(wxaWidgetContext.getId());
                eZ.cYt = System.currentTimeMillis();
                eZ.ajK();
                C7060h.pYm.mo8378a(636, 5, 1, false);
                C4990ab.m7413e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", str);
                AppMethodBeat.m2505o(TbsReaderView.READER_CHANNEL_DOC_ID);
            }
        });
        C4990ab.m7419v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", wxaWidgetContext.getId());
        C26864e.m42795cC(context);
        AppMethodBeat.m2505o(10966);
        return aAf;
    }

    /* renamed from: G */
    private static void m42790G(final Runnable runnable) {
        AppMethodBeat.m2504i(10967);
        C191861 c191861 = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.e$1$1 */
            class C191871 implements IdleHandler {
                C191871() {
                }

                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(10959);
                    Looper.myQueue().removeIdleHandler(this);
                    runnable.run();
                    AppMethodBeat.m2505o(10959);
                    return false;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(10960);
                Looper.myQueue().addIdleHandler(new C191871());
                AppMethodBeat.m2505o(10960);
            }
        };
        if (C5004al.isMainThread()) {
            c191861.run();
            AppMethodBeat.m2505o(10967);
            return;
        }
        C5004al.m7441d(c191861);
        AppMethodBeat.m2505o(10967);
    }

    /* renamed from: cC */
    public static void m42795cC(final Context context) {
        AppMethodBeat.m2504i(10968);
        C26864e.m42790G(new Runnable() {
            /* JADX WARNING: Missing block: B:8:0x0014, code skipped:
            com.tencent.p177mm.modelappbrand.C18652u.m29151i("MicroMsg.PreloadOptimizer", "start preload mini jsbridge", new java.lang.Object[0]);
            com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e.aAh();
            r0 = com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e.aAi();
            r1 = com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e.class;
     */
            /* JADX WARNING: Missing block: B:9:0x0029, code skipped:
            monitor-enter(r1);
     */
            /* JADX WARNING: Missing block: B:11:?, code skipped:
            com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26864e.m42794b(r0);
     */
            /* JADX WARNING: Missing block: B:12:0x002d, code skipped:
            monitor-exit(r1);
     */
            /* JADX WARNING: Missing block: B:20:0x003a, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(10961);
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(10961);
                synchronized (C26864e.class) {
                    try {
                        if (C26864e.hoH != null) {
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(10961);
                    }
                }
            }
        });
        AppMethodBeat.m2505o(10968);
    }

    private static C30909e aAf() {
        AppMethodBeat.m2504i(10969);
        C30909e c30909e = new C30909e();
        c30909e.mo49449a(C26864e.m42791a(c30909e));
        AppMethodBeat.m2505o(10969);
        return c30909e;
    }

    /* renamed from: a */
    private static C40954d m42791a(C30909e c30909e) {
        AppMethodBeat.m2504i(10970);
        C40954d bt = C26862b.m42786bt(c30909e);
        C7060h.pYm.mo8378a(639, 2, 1, false);
        C4990ab.m7416i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        C7060h.pYm.mo8378a(639, 0, 1, false);
        AppMethodBeat.m2505o(10970);
        return bt;
    }

    /* renamed from: a */
    private static void m42793a(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.m2504i(10971);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(10971);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", e);
            AppMethodBeat.m2505o(10971);
        }
    }
}
