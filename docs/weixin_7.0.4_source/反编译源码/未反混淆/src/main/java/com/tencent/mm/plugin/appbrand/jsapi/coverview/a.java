package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.d.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(e eVar, MotionEvent motionEvent, String str, boolean z) {
        ah cVar;
        int i = 0;
        AppMethodBeat.i(126288);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        f fVar = new f();
        fVar.b(pointerId, x, y);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException e) {
        }
        ab.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d", Integer.valueOf(motionEvent.getAction()));
        JSONArray jSONArray;
        f[] y2;
        switch (motionEvent.getAction()) {
            case 0:
                try {
                    jSONObject.put("touch", fVar.toJSONObject());
                } catch (JSONException e2) {
                }
                cVar = new c();
                break;
            case 1:
                try {
                    jSONObject.put("touch", fVar.toJSONObject());
                } catch (JSONException e3) {
                }
                cVar = new d.e();
                break;
            case 2:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e4) {
                }
                y2 = y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].toJSONObject());
                        i++;
                    }
                }
                cVar = new d.d();
                break;
            case 3:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e5) {
                }
                y2 = y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].toJSONObject());
                        i++;
                    }
                }
                cVar = new b();
                break;
            default:
                cVar = null;
                break;
        }
        if (cVar == null || !z) {
            if (cVar != null) {
                cVar.AM(jSONObject.toString());
                eVar.b(cVar);
            }
            AppMethodBeat.o(126288);
            return;
        }
        cVar.AM(jSONObject.toString());
        eVar.a(cVar);
        AppMethodBeat.o(126288);
    }

    private static f[] y(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.i(126289);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            f fVar = new f();
            fVar.id = motionEvent.getPointerId(i2);
            fVar.x = motionEvent.getX(i2);
            fVar.y = motionEvent.getY(i2);
            arrayList.add(fVar);
        }
        f[] fVarArr = new f[arrayList.size()];
        while (i < arrayList.size()) {
            fVarArr[i] = (f) arrayList.get(i);
            i++;
        }
        AppMethodBeat.o(126289);
        return fVarArr;
    }
}
