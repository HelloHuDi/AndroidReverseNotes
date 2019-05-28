package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C10512b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38375d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38378c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38379e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.a */
public final class C33280a {
    /* renamed from: a */
    public static void m54434a(C33303e c33303e, MotionEvent motionEvent, String str, boolean z) {
        C42467ah c38378c;
        int i = 0;
        AppMethodBeat.m2504i(126288);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        C38376f c38376f = new C38376f();
        c38376f.mo61035b(pointerId, x, y);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException e) {
        }
        C4990ab.m7417i("MicroMsg.InsertViewTouchEventDispatch", "action:%d", Integer.valueOf(motionEvent.getAction()));
        JSONArray jSONArray;
        C38376f[] y2;
        switch (motionEvent.getAction()) {
            case 0:
                try {
                    jSONObject.put("touch", c38376f.toJSONObject());
                } catch (JSONException e2) {
                }
                c38378c = new C38378c();
                break;
            case 1:
                try {
                    jSONObject.put("touch", c38376f.toJSONObject());
                } catch (JSONException e3) {
                }
                c38378c = new C38379e();
                break;
            case 2:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e4) {
                }
                y2 = C33280a.m54435y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].toJSONObject());
                        i++;
                    }
                }
                c38378c = new C38375d();
                break;
            case 3:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e5) {
                }
                y2 = C33280a.m54435y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].toJSONObject());
                        i++;
                    }
                }
                c38378c = new C10512b();
                break;
            default:
                c38378c = null;
                break;
        }
        if (c38378c == null || !z) {
            if (c38378c != null) {
                c38378c.mo61028AM(jSONObject.toString());
                c33303e.mo6115b(c38378c);
            }
            AppMethodBeat.m2505o(126288);
            return;
        }
        c38378c.mo61028AM(jSONObject.toString());
        c33303e.mo6108a(c38378c);
        AppMethodBeat.m2505o(126288);
    }

    /* renamed from: y */
    private static C38376f[] m54435y(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(126289);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            C38376f c38376f = new C38376f();
            c38376f.f16151id = motionEvent.getPointerId(i2);
            c38376f.f16152x = motionEvent.getX(i2);
            c38376f.f16153y = motionEvent.getY(i2);
            arrayList.add(c38376f);
        }
        C38376f[] c38376fArr = new C38376f[arrayList.size()];
        while (i < arrayList.size()) {
            c38376fArr[i] = (C38376f) arrayList.get(i);
            i++;
        }
        AppMethodBeat.m2505o(126289);
        return c38376fArr;
    }
}
