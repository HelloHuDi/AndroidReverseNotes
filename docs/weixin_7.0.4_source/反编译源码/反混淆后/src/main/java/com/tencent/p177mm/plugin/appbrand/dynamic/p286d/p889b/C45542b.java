package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg.C268221;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.collector.C2108d;
import com.tencent.p177mm.plugin.appbrand.collector.CollectSession;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.C45543b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a.C42421e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C26863d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.b */
public final class C45542b implements Runnable {
    public C42421e hnA;
    public String hnB;
    public long hnC;
    public String hnw;
    public JSONObject hnx;
    public C45543b hny;
    public C16115a hnz;
    public String process;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.b$a */
    static class C45541a implements C37866a<Bundle, Bundle> {
        private C45541a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10888);
            Bundle bundle = (Bundle) obj;
            C18652u.m29157v("DrawCanvasRunnable", "IPCInvoke_DrawCanvas strategy %d", Integer.valueOf(bundle.getInt("drawStrategy")));
            String string;
            Bundle bundle2;
            final String string2;
            View zS;
            DrawCanvasArg drawCanvasArg;
            C2108d c2108d;
            C10164a c10164a;
            switch (bundle.getInt("drawStrategy")) {
                case 0:
                    string = bundle.getString("__session_id");
                    C2107c.m4311a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    C2107c.m4312bD(string, "after_cross_process_invoke");
                    bundle2 = new Bundle();
                    string2 = bundle.getString("viewId");
                    zS = C10210e.azz().mo21627zS(string2);
                    drawCanvasArg = (DrawCanvasArg) bundle.getParcelable("jsApiInvokeDataObj");
                    final String string3 = bundle.getString("remoteProcess");
                    if (zS instanceof C10164a) {
                        final int i = bundle.getInt("drawStrategy");
                        if (drawCanvasArg != null) {
                            C2107c.m4312bD(string, "after_cp_parse_json_end");
                            if (zS instanceof C2108d) {
                                c2108d = (C2108d) zS;
                                c2108d.setSessionId(string);
                                c2108d.setStartTime(drawCanvasArg.hdW);
                            }
                            c10164a = (C10164a) zS;
                            if (drawCanvasArg.hdU) {
                                c10164a.mo21538b(drawCanvasArg, null);
                            } else {
                                c10164a.mo21534a(drawCanvasArg, new C10165a() {
                                    /* renamed from: a */
                                    public final void mo6094a(final DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.m2504i(10887);
                                        if (C9548e.m17008lg(string3)) {
                                            C10204a.m17844bb(string2, i).mo21613F(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.m2504i(10886);
                                                    C4990ab.m7418v("DrawCanvasRunnable", "running release");
                                                    if (drawCanvasArg != null) {
                                                        drawCanvasArg.reset();
                                                    }
                                                    AppMethodBeat.m2505o(10886);
                                                }
                                            });
                                            AppMethodBeat.m2505o(10887);
                                            return;
                                        }
                                        if (drawCanvasArg != null) {
                                            drawCanvasArg.reset();
                                        }
                                        AppMethodBeat.m2505o(10887);
                                    }
                                });
                            }
                            c10164a.ayc();
                            bundle2.putBoolean("ret", true);
                            c18507c.mo5960ao(bundle2);
                            AppMethodBeat.m2505o(10888);
                            return;
                        }
                        C4990ab.m7412e("DrawCanvasRunnable", "no draw actions");
                        bundle2.putBoolean("ret", false);
                        bundle2.putString("reason", "no draw actions");
                        c18507c.mo5960ao(bundle2);
                        AppMethodBeat.m2505o(10888);
                        return;
                    }
                    if (drawCanvasArg != null) {
                        drawCanvasArg.reset();
                    }
                    C4990ab.m7417i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string2);
                    bundle2.putBoolean("ret", false);
                    bundle2.putString("reason", "view is not a instance of DrawableView");
                    c18507c.mo5960ao(bundle2);
                    AppMethodBeat.m2505o(10888);
                    return;
                case 1:
                    String string4 = bundle.getString("__session_id");
                    C2107c.m4311a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    C2107c.m4312bD(string4, "after_cross_process_invoke");
                    Bundle bundle3 = new Bundle();
                    View zS2 = C10210e.azz().mo21627zS(bundle.getString("viewId"));
                    if (zS2 instanceof C10164a) {
                        try {
                            JSONObject lw = C41725h.m73457lw(bundle.getString("jsApiInvokeData"));
                            JSONArray optJSONArray = lw.optJSONArray("actions");
                            boolean optBoolean = lw.optBoolean("reserve");
                            C2107c.m4312bD(string4, "after_cp_parse_json_end");
                            if (zS2 instanceof C2108d) {
                                C2108d c2108d2 = (C2108d) zS2;
                                c2108d2.setSessionId(string4);
                                c2108d2.setStartTime(lw.optLong("__invoke_jsapi_timestamp"));
                            }
                            C10164a c10164a2 = (C10164a) zS2;
                            if (optBoolean) {
                                c10164a2.mo21539b(optJSONArray, null);
                            } else {
                                c10164a2.mo21535a(optJSONArray, null);
                            }
                            c10164a2.ayc();
                            bundle3.putBoolean("ret", true);
                            c18507c.mo5960ao(bundle3);
                            AppMethodBeat.m2505o(10888);
                            return;
                        } catch (JSONException e) {
                            C4990ab.m7413e("DrawCanvasRunnable", "drawCanvas failed, IPC parse JSONObject error : %s", e);
                            bundle3.putBoolean("ret", false);
                            bundle3.putString("reason", "parse json data error");
                            c18507c.mo5960ao(bundle3);
                            AppMethodBeat.m2505o(10888);
                            return;
                        }
                    }
                    C4990ab.m7417i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", r0);
                    bundle3.putBoolean("ret", false);
                    bundle3.putString("reason", "view is not a instance of DrawableView");
                    c18507c.mo5960ao(bundle3);
                    AppMethodBeat.m2505o(10888);
                    return;
                default:
                    string = bundle.getString("__session_id");
                    C2107c.m4311a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    C2107c.m4312bD(string, "after_cross_process_invoke");
                    bundle2 = new Bundle();
                    string2 = bundle.getString("viewId");
                    zS = C10210e.azz().mo21627zS(string2);
                    drawCanvasArg = (DrawCanvasArg) bundle.getParcelable("jsApiInvokeDataObj");
                    if (zS instanceof C10164a) {
                        final int i2 = bundle.getInt("drawStrategy");
                        if (drawCanvasArg != null) {
                            C2107c.m4312bD(string, "after_cp_parse_json_end");
                            if (zS instanceof C2108d) {
                                c2108d = (C2108d) zS;
                                c2108d.setSessionId(string);
                                c2108d.setStartTime(drawCanvasArg.hdW);
                            }
                            c10164a = (C10164a) zS;
                            if (drawCanvasArg.hdU) {
                                c10164a.mo21538b(drawCanvasArg, null);
                            } else {
                                try {
                                    drawCanvasArg.hdY = new JSONObject(drawCanvasArg.hdV).optJSONArray("actions");
                                } catch (JSONException e2) {
                                    C4990ab.m7413e("DrawCanvasArg", "drawCanvas failed, IPC parse JSONObject error : %s", e2);
                                }
                                c10164a.mo21534a(drawCanvasArg, new C10165a() {
                                    /* renamed from: a */
                                    public final void mo6094a(final DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.m2504i(10885);
                                        C10204a.m17844bb(string2, i2).mo21613F(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.m2504i(10884);
                                                C4990ab.m7418v("DrawCanvasRunnable", "running release");
                                                if (drawCanvasArg != null) {
                                                    drawCanvasArg.reset();
                                                }
                                                AppMethodBeat.m2505o(10884);
                                            }
                                        });
                                        AppMethodBeat.m2505o(10885);
                                    }
                                });
                                if (drawCanvasArg.hdZ == null) {
                                    drawCanvasArg.hdZ = new C268221();
                                    C7305d.post(drawCanvasArg.hdZ, "DrawCanvasArg-async-parse");
                                }
                            }
                            c10164a.ayc();
                            bundle2.putBoolean("ret", true);
                            c18507c.mo5960ao(bundle2);
                            AppMethodBeat.m2505o(10888);
                            return;
                        }
                        C4990ab.m7412e("DrawCanvasRunnable", "no draw actions");
                        bundle2.putBoolean("ret", false);
                        bundle2.putString("reason", "no draw actions");
                        c18507c.mo5960ao(bundle2);
                        AppMethodBeat.m2505o(10888);
                        return;
                    }
                    if (drawCanvasArg != null) {
                        drawCanvasArg.reset();
                    }
                    C4990ab.m7417i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string2);
                    bundle2.putBoolean("ret", false);
                    bundle2.putString("reason", "view is not a instance of DrawableView");
                    c18507c.mo5960ao(bundle2);
                    AppMethodBeat.m2505o(10888);
                    return;
            }
        }
    }

    /* renamed from: a */
    public final void mo73354a(String str, String str2, JSONObject jSONObject, C45543b c45543b, C16115a c16115a, C42421e c42421e, String str3) {
        AppMethodBeat.m2504i(10889);
        this.process = str;
        this.hnw = str2;
        this.hnx = jSONObject;
        this.hny = c45543b;
        this.hnz = c16115a;
        this.hnA = c42421e;
        this.hnB = str3;
        this.hnC = System.currentTimeMillis();
        AppMethodBeat.m2505o(10889);
    }

    public final void run() {
        AppMethodBeat.m2504i(10890);
        if (this.hnA.mo21612Ai(this.hnB)) {
            DrawCanvasArg drawCanvasArg;
            C18652u.m29157v("DrawCanvasRunnable", "running draw", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("viewId", this.hnw);
            bundle.putInt("drawStrategy", this.hnA.azV());
            bundle.putString("remoteProcess", C9548e.m17007PN());
            C10204a.m17843bN(this.hnw, this.hnB);
            switch (this.hnA.azV()) {
                case 0:
                case 2:
                    drawCanvasArg = (DrawCanvasArg) this.hnA.mo21618d(this.hnx, this.hnB);
                    this.hnA.mo21616bs(drawCanvasArg);
                    bundle.putParcelable("jsApiInvokeDataObj", drawCanvasArg);
                    break;
                case 1:
                    String str = (String) this.hnA.mo21618d(this.hnx, this.hnB);
                    this.hnA.mo21616bs(this.hnB);
                    bundle.putString("jsApiInvokeData", str);
                    drawCanvasArg = null;
                    break;
                default:
                    drawCanvasArg = null;
                    break;
            }
            String o = C26863d.m42788o(this.hnx);
            CollectSession bD = C2107c.m4312bD(o, "after_jsapi_invoke");
            bundle.putString("__session_id", o);
            bundle.putParcelable("__cost_time_session", bD);
            C26439v.m42099kT(19);
            C26273ad eZ = new C26273ad().mo43951eZ(C18652u.m29154pr(this.hnw));
            eZ.cYw = (long) C18652u.m29153pq(this.hnw);
            eZ.cYs = 11;
            eZ = eZ.mo43950eY(this.hnw);
            eZ.cYt = System.currentTimeMillis();
            eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
            if (C9549f.m17012a(this.process, bundle, C45541a.class, new C18507c<Bundle>() {

                /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.b$1$1 */
                class C331521 implements Runnable {
                    C331521() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(10882);
                        if (drawCanvasArg != null) {
                            drawCanvasArg.reset();
                        }
                        AppMethodBeat.m2505o(10882);
                    }
                }

                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(10883);
                    Bundle bundle = (Bundle) obj;
                    if (!(C45542b.this.hnz == null || C45542b.this.hny == null)) {
                        C45542b.this.hnz.mo11732au(C45542b.this.hny.mo57327a(bundle.getBoolean("ret"), bundle.getString("reason", ""), null));
                    }
                    C18652u.m29151i("DrawCanvasRunnable", "invoke callback", new Object[0]);
                    if (!C9548e.m17008lg(C45542b.this.process)) {
                        C45542b.this.hnA.mo21613F(new C331521());
                    }
                    View zS = C10210e.azz().mo21627zS(C45542b.this.hnw);
                    if (zS instanceof C2150h) {
                        ((C2150h) zS).azB();
                    }
                    AppMethodBeat.m2505o(10883);
                }
            })) {
                this.hnA.azU();
                AppMethodBeat.m2505o(10890);
                return;
            }
            if (drawCanvasArg != null) {
                drawCanvasArg.reset();
            }
            AppMethodBeat.m2505o(10890);
            return;
        }
        if (!(this.hnz == null || this.hny == null)) {
            this.hnz.mo11732au(this.hny.mo57327a(true, "same actions with last draw, drop this", null));
        }
        AppMethodBeat.m2505o(10890);
    }
}
