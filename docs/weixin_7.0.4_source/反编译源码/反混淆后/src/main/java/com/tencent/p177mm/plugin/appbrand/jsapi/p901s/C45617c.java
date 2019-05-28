package com.tencent.p177mm.plugin.appbrand.jsapi.p901s;

import android.support.p057v4.view.C0477s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C10511a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C10512b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38375d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.c */
public final class C45617c {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.s.c$a */
    public static class C19473a implements OnTouchListener {
        private static volatile View ibw;
        private C32800b eIo;
        private C2241c hcM;
        private C38376f ibA;
        private Runnable ibB;
        private int ibC;
        private float ibD;
        private MotionEvent ibE;
        private MotionEvent ibF;
        private C38376f ibG;
        private C38376f ibH;
        private Map<Integer, C38376f> ibx = new HashMap();
        private boolean iby;
        private boolean ibz;
        private View mView;

        /* renamed from: b */
        static /* synthetic */ void m30151b(C2241c c2241c, C42467ah c42467ah, String str) {
            AppMethodBeat.m2504i(91075);
            C19473a.m30147a(c2241c, c42467ah, str);
            AppMethodBeat.m2505o(91075);
        }

        public C19473a(final C2241c c2241c, C32800b c32800b) {
            AppMethodBeat.m2504i(91068);
            Assert.assertNotNull(c2241c);
            Assert.assertNotNull(c32800b);
            this.eIo = c32800b;
            this.ibC = c2241c.aBw();
            this.hcM = c2241c;
            this.ibD = (float) ViewConfiguration.get(c2241c.getContext()).getScaledTouchSlop();
            this.ibG = new C38376f();
            this.ibH = new C38376f();
            this.ibB = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(91067);
                    if (C19473a.this.iby) {
                        C38376f co = C38377d.m64950co(C19473a.this.mView);
                        if (Math.abs(C19473a.this.ibA.f16152x - co.f16152x) > 1.0f || Math.abs(C19473a.this.ibA.f16153y - co.f16153y) > 1.0f) {
                            C4990ab.m7418v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                            AppMethodBeat.m2505o(91067);
                            return;
                        } else if (C19473a.this.ibx.size() != 1) {
                            C4990ab.m7418v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                            AppMethodBeat.m2505o(91067);
                            return;
                        } else if (Math.abs(C19473a.this.ibG.f16152x - C19473a.this.ibH.f16152x) > C19473a.this.ibD || Math.abs(C19473a.this.ibG.f16153y - C19473a.this.ibH.f16153y) > C19473a.this.ibD) {
                            C4990ab.m7419v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", Float.valueOf(C19473a.this.ibG.f16152x), Float.valueOf(C19473a.this.ibH.f16152x), Float.valueOf(C19473a.this.ibG.f16153y), Float.valueOf(C19473a.this.ibH.f16153y));
                            AppMethodBeat.m2505o(91067);
                            return;
                        } else {
                            C4990ab.m7419v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", Float.valueOf(C19473a.this.ibG.f16152x), Float.valueOf(C19473a.this.ibH.f16152x), Float.valueOf(C19473a.this.ibG.f16153y), Float.valueOf(C19473a.this.ibH.f16153y));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("data", C19473a.this.eIo.getString("data", ""));
                                jSONObject.put("touch", C19473a.this.ibG.toJSONObject());
                            } catch (JSONException e) {
                            }
                            if (!C19473a.this.eIo.getBoolean("disableScroll", false)) {
                                C19473a.this.ibE = MotionEvent.obtain(C19473a.this.ibF);
                                C19473a.this.ibE.setAction(0);
                                C19473a.this.eIo.mo53359z("fakeDownEvent", true);
                                C19473a.this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                C19473a.this.mView.setDuplicateParentStateEnabled(false);
                                C19473a.m30146a(C19473a.this.mView, MotionEvent.obtain(C19473a.this.ibE));
                            }
                            C19473a.m30151b(c2241c, new C10511a(), jSONObject.toString());
                            AppMethodBeat.m2505o(91067);
                            return;
                        }
                    }
                    C4990ab.m7418v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                    AppMethodBeat.m2505o(91067);
                }
            };
            AppMethodBeat.m2505o(91068);
        }

        /* JADX WARNING: Missing block: B:16:0x00b7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(91069);
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
            r12 = new com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f(r8, r9, r10);
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
            m30160l(r19, r2);
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
            com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C45617c.C19473a.m30148a(r18.hcM, r12, new com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38378c(), r11);
     */
        /* JADX WARNING: Missing block: B:91:0x02a1, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:92:0x02a3, code skipped:
            r2 = false;
     */
        /* JADX WARNING: Missing block: B:99:0x02e1, code skipped:
            r2 = (com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f) r18.ibx.remove(java.lang.Integer.valueOf(r8));
     */
        /* JADX WARNING: Missing block: B:100:0x02ef, code skipped:
            if (r2 == null) goto L_0x00b7;
     */
        /* JADX WARNING: Missing block: B:101:0x02f1, code skipped:
            m30160l(r19, false);
            com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C45617c.C19473a.m30148a(r18.hcM, r2, new com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38379e(), r11);
     */
        /* JADX WARNING: Missing block: B:124:0x03ab, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:136:?, code skipped:
            return r4;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(91069);
            if (ibw == null || ibw.equals(view)) {
                this.ibF = motionEvent;
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                motionEvent.getPointerCount();
                int pointerId = motionEvent.getPointerId(actionIndex);
                float x = motionEvent.getX(actionIndex);
                float y = motionEvent.getY(actionIndex);
                if (actionMasked == 0 || this.eIo.mo53357nX("isTouching") || C0477s.m930av(view) || actionMasked == 3) {
                    String string = this.eIo.getString("data", "");
                    boolean z = this.eIo.getBoolean("disableScroll", false);
                    boolean z2 = this.eIo.getBoolean("fakeDownEvent", false);
                    boolean z3 = this.eIo.getBoolean("onLongClick", false);
                    this.ibz = this.eIo.getBoolean("enableLongClick", false);
                    this.ibH.mo61035b(pointerId, x, y);
                    boolean z4 = z | z3;
                    boolean z5;
                    JSONObject jSONObject;
                    JSONArray jSONArray;
                    C38376f[] y2;
                    switch (actionMasked) {
                        case 0:
                            if (this.ibE == null || motionEvent.getDownTime() == this.ibE.getDownTime()) {
                                z5 = z2;
                            } else {
                                this.eIo.mo53359z("fakeDownEvent", false);
                                C4990ab.m7418v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
                                z5 = false;
                            }
                            if (z || z5) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                                view.setDuplicateParentStateEnabled(false);
                                C4990ab.m7416i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
                            } else {
                                view.setDuplicateParentStateEnabled(true);
                            }
                            if (z5) {
                                z3 = true;
                                z2 = true;
                                this.eIo.mo53359z("fakeDownEvent", false);
                                this.eIo.mo53359z("onLongClick", true);
                            } else {
                                ibw = view;
                                this.ibA = C38377d.m64950co(view);
                                this.ibG.mo61035b(pointerId, x, y);
                                z2 = z4;
                            }
                            this.eIo.mo53359z("isTouching", true);
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
                            this.eIo.mo53359z("isTouching", false);
                            if (this.eIo.containsKey("disableScroll-nextState")) {
                                this.eIo.mo53359z("disableScroll", this.eIo.getBoolean("disableScroll-nextState", z));
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
                                    C38376f c38376f = (C38376f) this.ibx.get(Integer.valueOf(motionEvent.getPointerId(i)));
                                    if (c38376f == null || (x2 == c38376f.f16152x && y3 == c38376f.f16153y)) {
                                        actionIndex = i + 1;
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            obj = 1;
                            if (obj != null) {
                                if (this.ibx.size() == 1 && this.iby && (Math.abs(this.ibG.f16152x - this.ibH.f16152x) > this.ibD || Math.abs(this.ibG.f16153y - this.ibH.f16153y) > this.ibD)) {
                                    m30160l(view, false);
                                }
                                jSONObject = new JSONObject();
                                jSONArray = new JSONArray();
                                try {
                                    jSONObject.put("data", string);
                                    jSONObject.put("touches", jSONArray);
                                } catch (JSONException e) {
                                }
                                y2 = m30161y(motionEvent);
                                if (y2.length > 0) {
                                    for (C38376f toJSONObject : y2) {
                                        jSONArray.put(toJSONObject.toJSONObject());
                                    }
                                }
                                if (this.ibx.size() != 0) {
                                    C19473a.m30147a(this.hcM, new C38375d(), jSONObject.toString());
                                    break;
                                }
                            }
                            break;
                        case 3:
                            ibw = null;
                            m30160l(view, false);
                            if (z || z3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else {
                                view.setDuplicateParentStateEnabled(false);
                            }
                            this.eIo.mo53359z("isTouching", false);
                            if (this.eIo.containsKey("disableScroll-nextState")) {
                                this.eIo.mo53359z("disableScroll", this.eIo.getBoolean("disableScroll-nextState", z));
                            }
                            if (C0477s.m930av(view)) {
                                jSONObject = new JSONObject();
                                jSONArray = new JSONArray();
                                try {
                                    jSONObject.put("data", string);
                                    jSONObject.put("touches", jSONArray);
                                } catch (JSONException e2) {
                                }
                                y2 = m30161y(motionEvent);
                                for (C38376f toJSONObject2 : y2) {
                                    jSONArray.put(toJSONObject2.toJSONObject());
                                }
                                C19473a.m30147a(this.hcM, new C10512b(), jSONObject.toString());
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
                AppMethodBeat.m2505o(91069);
                return false;
            }
            C4990ab.m7418v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
            AppMethodBeat.m2505o(91069);
            return false;
        }

        /* renamed from: l */
        private void m30160l(View view, boolean z) {
            AppMethodBeat.m2504i(91070);
            this.mView = view;
            this.iby = z;
            if (!z) {
                this.eIo.mo53359z("fakeDownEvent", false);
                this.eIo.mo53359z("onLongClick", false);
                this.mView.removeCallbacks(this.ibB);
                this.ibG.mo61035b(-1, 0.0f, 0.0f);
                this.ibE = null;
            }
            AppMethodBeat.m2505o(91070);
        }

        /* renamed from: a */
        private static void m30148a(C2241c c2241c, C38376f c38376f, C42467ah c42467ah, String str) {
            AppMethodBeat.m2504i(91071);
            if (c38376f == null) {
                AppMethodBeat.m2505o(91071);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
                jSONObject.put("touch", c38376f.toJSONObject());
            } catch (JSONException e) {
            }
            C19473a.m30147a(c2241c, c42467ah, jSONObject.toString());
            AppMethodBeat.m2505o(91071);
        }

        /* renamed from: a */
        private static void m30147a(C2241c c2241c, C42467ah c42467ah, String str) {
            AppMethodBeat.m2504i(91072);
            c2241c.mo6109a(c42467ah.getName(), str, null);
            AppMethodBeat.m2505o(91072);
        }

        /* renamed from: y */
        private C38376f[] m30161y(MotionEvent motionEvent) {
            int i = 0;
            AppMethodBeat.m2504i(91073);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                C38376f c38376f = (C38376f) this.ibx.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (c38376f != null) {
                    c38376f.f16152x = motionEvent.getX(i2);
                    c38376f.f16153y = motionEvent.getY(i2);
                    arrayList.add(c38376f);
                }
            }
            C38376f[] c38376fArr = new C38376f[arrayList.size()];
            while (i < arrayList.size()) {
                c38376fArr[i] = (C38376f) arrayList.get(i);
                i++;
            }
            AppMethodBeat.m2505o(91073);
            return c38376fArr;
        }
    }
}
