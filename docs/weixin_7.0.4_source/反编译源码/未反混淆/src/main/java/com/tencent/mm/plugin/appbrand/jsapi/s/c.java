package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    public static class a implements OnTouchListener {
        private static volatile View ibw;
        private b eIo;
        private com.tencent.mm.plugin.appbrand.jsapi.c hcM;
        private f ibA;
        private Runnable ibB;
        private int ibC;
        private float ibD;
        private MotionEvent ibE;
        private MotionEvent ibF;
        private f ibG;
        private f ibH;
        private Map<Integer, f> ibx = new HashMap();
        private boolean iby;
        private boolean ibz;
        private View mView;

        static /* synthetic */ void b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, ah ahVar, String str) {
            AppMethodBeat.i(91075);
            a(cVar, ahVar, str);
            AppMethodBeat.o(91075);
        }

        public a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, b bVar) {
            AppMethodBeat.i(91068);
            Assert.assertNotNull(cVar);
            Assert.assertNotNull(bVar);
            this.eIo = bVar;
            this.ibC = cVar.aBw();
            this.hcM = cVar;
            this.ibD = (float) ViewConfiguration.get(cVar.getContext()).getScaledTouchSlop();
            this.ibG = new f();
            this.ibH = new f();
            this.ibB = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91067);
                    if (a.this.iby) {
                        f co = d.co(a.this.mView);
                        if (Math.abs(a.this.ibA.x - co.x) > 1.0f || Math.abs(a.this.ibA.y - co.y) > 1.0f) {
                            ab.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                            AppMethodBeat.o(91067);
                            return;
                        } else if (a.this.ibx.size() != 1) {
                            ab.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                            AppMethodBeat.o(91067);
                            return;
                        } else if (Math.abs(a.this.ibG.x - a.this.ibH.x) > a.this.ibD || Math.abs(a.this.ibG.y - a.this.ibH.y) > a.this.ibD) {
                            ab.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", Float.valueOf(a.this.ibG.x), Float.valueOf(a.this.ibH.x), Float.valueOf(a.this.ibG.y), Float.valueOf(a.this.ibH.y));
                            AppMethodBeat.o(91067);
                            return;
                        } else {
                            ab.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", Float.valueOf(a.this.ibG.x), Float.valueOf(a.this.ibH.x), Float.valueOf(a.this.ibG.y), Float.valueOf(a.this.ibH.y));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("data", a.this.eIo.getString("data", ""));
                                jSONObject.put("touch", a.this.ibG.toJSONObject());
                            } catch (JSONException e) {
                            }
                            if (!a.this.eIo.getBoolean("disableScroll", false)) {
                                a.this.ibE = MotionEvent.obtain(a.this.ibF);
                                a.this.ibE.setAction(0);
                                a.this.eIo.z("fakeDownEvent", true);
                                a.this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                a.this.mView.setDuplicateParentStateEnabled(false);
                                a.a(a.this.mView, MotionEvent.obtain(a.this.ibE));
                            }
                            a.b(cVar, new com.tencent.mm.plugin.appbrand.jsapi.s.d.a(), jSONObject.toString());
                            AppMethodBeat.o(91067);
                            return;
                        }
                    }
                    ab.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                    AppMethodBeat.o(91067);
                }
            };
            AppMethodBeat.o(91068);
        }

        /* JADX WARNING: Missing block: B:16:0x00b7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(91069);
     */
        /* JADX WARNING: Missing block: B:69:0x022c, code skipped:
            if (r9 < 0.0f) goto L_0x02a1;
     */
        /* JADX WARNING: Missing block: B:71:0x0231, code skipped:
            if (r10 < 0.0f) goto L_0x02a1;
     */
        /* JADX WARNING: Missing block: B:73:0x023a, code skipped:
            if (r9 > ((float) r19.getWidth())) goto L_0x02a1;
     */
        /* JADX WARNING: Missing block: B:75:0x0243, code skipped:
            if (r10 > ((float) r19.getHeight())) goto L_0x02a1;
     */
        /* JADX WARNING: Missing block: B:76:0x0245, code skipped:
            r2 = 1;
     */
        /* JADX WARNING: Missing block: B:77:0x0246, code skipped:
            if (r2 == null) goto L_0x00b7;
     */
        /* JADX WARNING: Missing block: B:78:0x0248, code skipped:
            r12 = new com.tencent.mm.plugin.appbrand.jsapi.s.d.f(r8, r9, r10);
     */
        /* JADX WARNING: Missing block: B:79:0x024d, code skipped:
            if (r7 != 0) goto L_0x02a3;
     */
        /* JADX WARNING: Missing block: B:80:0x024f, code skipped:
            if (r3 != false) goto L_0x02a3;
     */
        /* JADX WARNING: Missing block: B:81:0x0251, code skipped:
            r2 = true;
     */
        /* JADX WARNING: Missing block: B:82:0x0252, code skipped:
            l(r19, r2);
     */
        /* JADX WARNING: Missing block: B:83:0x0265, code skipped:
            if (r18.ibx.containsKey(java.lang.Integer.valueOf(r8)) == false) goto L_0x03ab;
     */
        /* JADX WARNING: Missing block: B:84:0x0267, code skipped:
            r2 = 1;
     */
        /* JADX WARNING: Missing block: B:85:0x0268, code skipped:
            r18.ibx.put(java.lang.Integer.valueOf(r8), r12);
     */
        /* JADX WARNING: Missing block: B:86:0x0273, code skipped:
            if (r6 != false) goto L_0x00b7;
     */
        /* JADX WARNING: Missing block: B:87:0x0275, code skipped:
            if (r2 != null) goto L_0x00b7;
     */
        /* JADX WARNING: Missing block: B:88:0x0277, code skipped:
            a(r18.hcM, r12, new com.tencent.mm.plugin.appbrand.jsapi.s.d.c(), r11);
     */
        /* JADX WARNING: Missing block: B:91:0x02a1, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:92:0x02a3, code skipped:
            r2 = false;
     */
        /* JADX WARNING: Missing block: B:99:0x02e1, code skipped:
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.s.d.f) r18.ibx.remove(java.lang.Integer.valueOf(r8));
     */
        /* JADX WARNING: Missing block: B:100:0x02ef, code skipped:
            if (r2 == null) goto L_0x00b7;
     */
        /* JADX WARNING: Missing block: B:101:0x02f1, code skipped:
            l(r19, false);
            a(r18.hcM, r2, new com.tencent.mm.plugin.appbrand.jsapi.s.d.e(), r11);
     */
        /* JADX WARNING: Missing block: B:124:0x03ab, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:136:?, code skipped:
            return r4;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(91069);
            if (ibw == null || ibw.equals(view)) {
                this.ibF = motionEvent;
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                motionEvent.getPointerCount();
                int pointerId = motionEvent.getPointerId(actionIndex);
                float x = motionEvent.getX(actionIndex);
                float y = motionEvent.getY(actionIndex);
                if (actionMasked == 0 || this.eIo.nX("isTouching") || s.av(view) || actionMasked == 3) {
                    String string = this.eIo.getString("data", "");
                    boolean z = this.eIo.getBoolean("disableScroll", false);
                    boolean z2 = this.eIo.getBoolean("fakeDownEvent", false);
                    boolean z3 = this.eIo.getBoolean("onLongClick", false);
                    this.ibz = this.eIo.getBoolean("enableLongClick", false);
                    this.ibH.b(pointerId, x, y);
                    boolean z4 = z | z3;
                    boolean z5;
                    JSONObject jSONObject;
                    JSONArray jSONArray;
                    f[] y2;
                    switch (actionMasked) {
                        case 0:
                            if (this.ibE == null || motionEvent.getDownTime() == this.ibE.getDownTime()) {
                                z5 = z2;
                            } else {
                                this.eIo.z("fakeDownEvent", false);
                                ab.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
                                z5 = false;
                            }
                            if (z || z5) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                                view.setDuplicateParentStateEnabled(false);
                                ab.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
                            } else {
                                view.setDuplicateParentStateEnabled(true);
                            }
                            if (z5) {
                                z3 = true;
                                z2 = true;
                                this.eIo.z("fakeDownEvent", false);
                                this.eIo.z("onLongClick", true);
                            } else {
                                ibw = view;
                                this.ibA = d.co(view);
                                this.ibG.b(pointerId, x, y);
                                z2 = z4;
                            }
                            this.eIo.z("isTouching", true);
                            if (!(!this.ibz || z3 || this.ibx.containsKey(Integer.valueOf(pointerId)))) {
                                view.postDelayed(this.ibB, (long) ViewConfiguration.getLongPressTimeout());
                            }
                            z4 = z2;
                            break;
                        case 1:
                            if (z || z3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else {
                                view.setDuplicateParentStateEnabled(false);
                            }
                            ibw = null;
                            this.eIo.z("isTouching", false);
                            if (this.eIo.containsKey("disableScroll-nextState")) {
                                this.eIo.z("disableScroll", this.eIo.getBoolean("disableScroll-nextState", z));
                                break;
                            }
                            break;
                        case 2:
                            Object obj;
                            actionIndex = 0;
                            while (true) {
                                int i = actionIndex;
                                if (i < motionEvent.getPointerCount()) {
                                    float x2 = motionEvent.getX(i);
                                    float y3 = motionEvent.getY(i);
                                    f fVar = (f) this.ibx.get(Integer.valueOf(motionEvent.getPointerId(i)));
                                    if (fVar == null || (x2 == fVar.x && y3 == fVar.y)) {
                                        actionIndex = i + 1;
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            obj = 1;
                            if (obj != null) {
                                if (this.ibx.size() == 1 && this.iby && (Math.abs(this.ibG.x - this.ibH.x) > this.ibD || Math.abs(this.ibG.y - this.ibH.y) > this.ibD)) {
                                    l(view, false);
                                }
                                jSONObject = new JSONObject();
                                jSONArray = new JSONArray();
                                try {
                                    jSONObject.put("data", string);
                                    jSONObject.put("touches", jSONArray);
                                } catch (JSONException e) {
                                }
                                y2 = y(motionEvent);
                                if (y2.length > 0) {
                                    for (f toJSONObject : y2) {
                                        jSONArray.put(toJSONObject.toJSONObject());
                                    }
                                }
                                if (this.ibx.size() != 0) {
                                    a(this.hcM, new d(), jSONObject.toString());
                                    break;
                                }
                            }
                            break;
                        case 3:
                            ibw = null;
                            l(view, false);
                            if (z || z3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else {
                                view.setDuplicateParentStateEnabled(false);
                            }
                            this.eIo.z("isTouching", false);
                            if (this.eIo.containsKey("disableScroll-nextState")) {
                                this.eIo.z("disableScroll", this.eIo.getBoolean("disableScroll-nextState", z));
                            }
                            if (s.av(view)) {
                                jSONObject = new JSONObject();
                                jSONArray = new JSONArray();
                                try {
                                    jSONObject.put("data", string);
                                    jSONObject.put("touches", jSONArray);
                                } catch (JSONException e2) {
                                }
                                y2 = y(motionEvent);
                                for (f toJSONObject2 : y2) {
                                    jSONArray.put(toJSONObject2.toJSONObject());
                                }
                                a(this.hcM, new d.b(), jSONObject.toString());
                            }
                            this.ibx.clear();
                            break;
                        case 5:
                            z5 = z2;
                            break;
                        case 6:
                            break;
                    }
                }
                AppMethodBeat.o(91069);
                return false;
            }
            ab.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
            AppMethodBeat.o(91069);
            return false;
        }

        private void l(View view, boolean z) {
            AppMethodBeat.i(91070);
            this.mView = view;
            this.iby = z;
            if (!z) {
                this.eIo.z("fakeDownEvent", false);
                this.eIo.z("onLongClick", false);
                this.mView.removeCallbacks(this.ibB);
                this.ibG.b(-1, 0.0f, 0.0f);
                this.ibE = null;
            }
            AppMethodBeat.o(91070);
        }

        private static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, f fVar, ah ahVar, String str) {
            AppMethodBeat.i(91071);
            if (fVar == null) {
                AppMethodBeat.o(91071);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
                jSONObject.put("touch", fVar.toJSONObject());
            } catch (JSONException e) {
            }
            a(cVar, ahVar, jSONObject.toString());
            AppMethodBeat.o(91071);
        }

        private static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, ah ahVar, String str) {
            AppMethodBeat.i(91072);
            cVar.a(ahVar.getName(), str, null);
            AppMethodBeat.o(91072);
        }

        private f[] y(MotionEvent motionEvent) {
            int i = 0;
            AppMethodBeat.i(91073);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                f fVar = (f) this.ibx.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (fVar != null) {
                    fVar.x = motionEvent.getX(i2);
                    fVar.y = motionEvent.getY(i2);
                    arrayList.add(fVar);
                }
            }
            f[] fVarArr = new f[arrayList.size()];
            while (i < arrayList.size()) {
                fVarArr[i] = (f) arrayList.get(i);
                i++;
            }
            AppMethodBeat.o(91073);
            return fVarArr;
        }
    }
}
