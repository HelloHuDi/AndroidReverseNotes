package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements Runnable {
    public e hnA;
    public String hnB;
    public long hnC;
    public String hnw;
    public JSONObject hnx;
    public com.tencent.mm.plugin.appbrand.dynamic.d.b hny;
    public com.tencent.mm.z.b.b.a hnz;
    public String process;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10888);
            Bundle bundle = (Bundle) obj;
            u.v("DrawCanvasRunnable", "IPCInvoke_DrawCanvas strategy %d", Integer.valueOf(bundle.getInt("drawStrategy")));
            String string;
            Bundle bundle2;
            final String string2;
            View zS;
            DrawCanvasArg drawCanvasArg;
            d dVar;
            com.tencent.mm.plugin.appbrand.canvas.widget.a aVar;
            switch (bundle.getInt("drawStrategy")) {
                case 0:
                    string = bundle.getString("__session_id");
                    com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    com.tencent.mm.plugin.appbrand.collector.c.bD(string, "after_cross_process_invoke");
                    bundle2 = new Bundle();
                    string2 = bundle.getString("viewId");
                    zS = com.tencent.mm.plugin.appbrand.dynamic.e.azz().zS(string2);
                    drawCanvasArg = (DrawCanvasArg) bundle.getParcelable("jsApiInvokeDataObj");
                    final String string3 = bundle.getString("remoteProcess");
                    if (zS instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                        final int i = bundle.getInt("drawStrategy");
                        if (drawCanvasArg != null) {
                            com.tencent.mm.plugin.appbrand.collector.c.bD(string, "after_cp_parse_json_end");
                            if (zS instanceof d) {
                                dVar = (d) zS;
                                dVar.setSessionId(string);
                                dVar.setStartTime(drawCanvasArg.hdW);
                            }
                            aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) zS;
                            if (drawCanvasArg.hdU) {
                                aVar.b(drawCanvasArg, null);
                            } else {
                                aVar.a(drawCanvasArg, new com.tencent.mm.plugin.appbrand.canvas.widget.a.a() {
                                    public final void a(final DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.i(10887);
                                        if (com.tencent.mm.ipcinvoker.e.lg(string3)) {
                                            a.bb(string2, i).F(new Runnable() {
                                                public final void run() {
                                                    AppMethodBeat.i(10886);
                                                    ab.v("DrawCanvasRunnable", "running release");
                                                    if (drawCanvasArg != null) {
                                                        drawCanvasArg.reset();
                                                    }
                                                    AppMethodBeat.o(10886);
                                                }
                                            });
                                            AppMethodBeat.o(10887);
                                            return;
                                        }
                                        if (drawCanvasArg != null) {
                                            drawCanvasArg.reset();
                                        }
                                        AppMethodBeat.o(10887);
                                    }
                                });
                            }
                            aVar.ayc();
                            bundle2.putBoolean("ret", true);
                            cVar.ao(bundle2);
                            AppMethodBeat.o(10888);
                            return;
                        }
                        ab.e("DrawCanvasRunnable", "no draw actions");
                        bundle2.putBoolean("ret", false);
                        bundle2.putString("reason", "no draw actions");
                        cVar.ao(bundle2);
                        AppMethodBeat.o(10888);
                        return;
                    }
                    if (drawCanvasArg != null) {
                        drawCanvasArg.reset();
                    }
                    ab.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string2);
                    bundle2.putBoolean("ret", false);
                    bundle2.putString("reason", "view is not a instance of DrawableView");
                    cVar.ao(bundle2);
                    AppMethodBeat.o(10888);
                    return;
                case 1:
                    String string4 = bundle.getString("__session_id");
                    com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    com.tencent.mm.plugin.appbrand.collector.c.bD(string4, "after_cross_process_invoke");
                    Bundle bundle3 = new Bundle();
                    View zS2 = com.tencent.mm.plugin.appbrand.dynamic.e.azz().zS(bundle.getString("viewId"));
                    if (zS2 instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                        try {
                            JSONObject lw = h.lw(bundle.getString("jsApiInvokeData"));
                            JSONArray optJSONArray = lw.optJSONArray("actions");
                            boolean optBoolean = lw.optBoolean("reserve");
                            com.tencent.mm.plugin.appbrand.collector.c.bD(string4, "after_cp_parse_json_end");
                            if (zS2 instanceof d) {
                                d dVar2 = (d) zS2;
                                dVar2.setSessionId(string4);
                                dVar2.setStartTime(lw.optLong("__invoke_jsapi_timestamp"));
                            }
                            com.tencent.mm.plugin.appbrand.canvas.widget.a aVar2 = (com.tencent.mm.plugin.appbrand.canvas.widget.a) zS2;
                            if (optBoolean) {
                                aVar2.b(optJSONArray, null);
                            } else {
                                aVar2.a(optJSONArray, null);
                            }
                            aVar2.ayc();
                            bundle3.putBoolean("ret", true);
                            cVar.ao(bundle3);
                            AppMethodBeat.o(10888);
                            return;
                        } catch (JSONException e) {
                            ab.e("DrawCanvasRunnable", "drawCanvas failed, IPC parse JSONObject error : %s", e);
                            bundle3.putBoolean("ret", false);
                            bundle3.putString("reason", "parse json data error");
                            cVar.ao(bundle3);
                            AppMethodBeat.o(10888);
                            return;
                        }
                    }
                    ab.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", r0);
                    bundle3.putBoolean("ret", false);
                    bundle3.putString("reason", "view is not a instance of DrawableView");
                    cVar.ao(bundle3);
                    AppMethodBeat.o(10888);
                    return;
                default:
                    string = bundle.getString("__session_id");
                    com.tencent.mm.plugin.appbrand.collector.c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
                    com.tencent.mm.plugin.appbrand.collector.c.bD(string, "after_cross_process_invoke");
                    bundle2 = new Bundle();
                    string2 = bundle.getString("viewId");
                    zS = com.tencent.mm.plugin.appbrand.dynamic.e.azz().zS(string2);
                    drawCanvasArg = (DrawCanvasArg) bundle.getParcelable("jsApiInvokeDataObj");
                    if (zS instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                        final int i2 = bundle.getInt("drawStrategy");
                        if (drawCanvasArg != null) {
                            com.tencent.mm.plugin.appbrand.collector.c.bD(string, "after_cp_parse_json_end");
                            if (zS instanceof d) {
                                dVar = (d) zS;
                                dVar.setSessionId(string);
                                dVar.setStartTime(drawCanvasArg.hdW);
                            }
                            aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) zS;
                            if (drawCanvasArg.hdU) {
                                aVar.b(drawCanvasArg, null);
                            } else {
                                try {
                                    drawCanvasArg.hdY = new JSONObject(drawCanvasArg.hdV).optJSONArray("actions");
                                } catch (JSONException e2) {
                                    ab.e("DrawCanvasArg", "drawCanvas failed, IPC parse JSONObject error : %s", e2);
                                }
                                aVar.a(drawCanvasArg, new com.tencent.mm.plugin.appbrand.canvas.widget.a.a() {
                                    public final void a(final DrawCanvasArg drawCanvasArg) {
                                        AppMethodBeat.i(10885);
                                        a.bb(string2, i2).F(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(10884);
                                                ab.v("DrawCanvasRunnable", "running release");
                                                if (drawCanvasArg != null) {
                                                    drawCanvasArg.reset();
                                                }
                                                AppMethodBeat.o(10884);
                                            }
                                        });
                                        AppMethodBeat.o(10885);
                                    }
                                });
                                if (drawCanvasArg.hdZ == null) {
                                    drawCanvasArg.hdZ = new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(103700);
                                            DrawCanvasArg.a(DrawCanvasArg.this, DrawCanvasArg.this.hdY);
                                            DrawCanvasArg.this.hdZ = null;
                                            DrawCanvasArg.this.heb = true;
                                            if (DrawCanvasArg.this.hea) {
                                                DrawCanvasArg.f(DrawCanvasArg.this);
                                            }
                                            ab.i("DrawCanvasArg", "async parse success");
                                            AppMethodBeat.o(103700);
                                        }
                                    };
                                    com.tencent.mm.sdk.g.d.post(drawCanvasArg.hdZ, "DrawCanvasArg-async-parse");
                                }
                            }
                            aVar.ayc();
                            bundle2.putBoolean("ret", true);
                            cVar.ao(bundle2);
                            AppMethodBeat.o(10888);
                            return;
                        }
                        ab.e("DrawCanvasRunnable", "no draw actions");
                        bundle2.putBoolean("ret", false);
                        bundle2.putString("reason", "no draw actions");
                        cVar.ao(bundle2);
                        AppMethodBeat.o(10888);
                        return;
                    }
                    if (drawCanvasArg != null) {
                        drawCanvasArg.reset();
                    }
                    ab.i("DrawCanvasRunnable", "drawCanvas failed, view is not a instance of DrawableView.(%s)", string2);
                    bundle2.putBoolean("ret", false);
                    bundle2.putString("reason", "view is not a instance of DrawableView");
                    cVar.ao(bundle2);
                    AppMethodBeat.o(10888);
                    return;
            }
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.d.b bVar, com.tencent.mm.z.b.b.a aVar, e eVar, String str3) {
        AppMethodBeat.i(10889);
        this.process = str;
        this.hnw = str2;
        this.hnx = jSONObject;
        this.hny = bVar;
        this.hnz = aVar;
        this.hnA = eVar;
        this.hnB = str3;
        this.hnC = System.currentTimeMillis();
        AppMethodBeat.o(10889);
    }

    public final void run() {
        AppMethodBeat.i(10890);
        if (this.hnA.Ai(this.hnB)) {
            DrawCanvasArg drawCanvasArg;
            u.v("DrawCanvasRunnable", "running draw", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("viewId", this.hnw);
            bundle.putInt("drawStrategy", this.hnA.azV());
            bundle.putString("remoteProcess", com.tencent.mm.ipcinvoker.e.PN());
            a.bN(this.hnw, this.hnB);
            switch (this.hnA.azV()) {
                case 0:
                case 2:
                    drawCanvasArg = (DrawCanvasArg) this.hnA.d(this.hnx, this.hnB);
                    this.hnA.bs(drawCanvasArg);
                    bundle.putParcelable("jsApiInvokeDataObj", drawCanvasArg);
                    break;
                case 1:
                    String str = (String) this.hnA.d(this.hnx, this.hnB);
                    this.hnA.bs(this.hnB);
                    bundle.putString("jsApiInvokeData", str);
                    drawCanvasArg = null;
                    break;
                default:
                    drawCanvasArg = null;
                    break;
            }
            String o = com.tencent.mm.plugin.appbrand.dynamic.h.d.o(this.hnx);
            CollectSession bD = com.tencent.mm.plugin.appbrand.collector.c.bD(o, "after_jsapi_invoke");
            bundle.putString("__session_id", o);
            bundle.putParcelable("__cost_time_session", bD);
            v.kT(19);
            ad eZ = new ad().eZ(u.pr(this.hnw));
            eZ.cYw = (long) u.pq(this.hnw);
            eZ.cYs = 11;
            eZ = eZ.eY(this.hnw);
            eZ.cYt = System.currentTimeMillis();
            eZ.fa(at.gB(ah.getContext())).ajK();
            if (f.a(this.process, bundle, a.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(10883);
                    Bundle bundle = (Bundle) obj;
                    if (!(b.this.hnz == null || b.this.hny == null)) {
                        b.this.hnz.au(b.this.hny.a(bundle.getBoolean("ret"), bundle.getString("reason", ""), null));
                    }
                    u.i("DrawCanvasRunnable", "invoke callback", new Object[0]);
                    if (!com.tencent.mm.ipcinvoker.e.lg(b.this.process)) {
                        b.this.hnA.F(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(10882);
                                if (drawCanvasArg != null) {
                                    drawCanvasArg.reset();
                                }
                                AppMethodBeat.o(10882);
                            }
                        });
                    }
                    View zS = com.tencent.mm.plugin.appbrand.dynamic.e.azz().zS(b.this.hnw);
                    if (zS instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                        ((com.tencent.mm.plugin.appbrand.dynamic.h) zS).azB();
                    }
                    AppMethodBeat.o(10883);
                }
            })) {
                this.hnA.azU();
                AppMethodBeat.o(10890);
                return;
            }
            if (drawCanvasArg != null) {
                drawCanvasArg.reset();
            }
            AppMethodBeat.o(10890);
            return;
        }
        if (!(this.hnz == null || this.hny == null)) {
            this.hnz.au(this.hny.a(true, "same actions with last draw, drop this", null));
        }
        AppMethodBeat.o(10890);
    }
}
