package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.b.c.c;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class f extends a<h> {
    public abstract void a(h hVar, JSONObject jSONObject, int i, d dVar);

    public void a(h hVar, JSONObject jSONObject, int i) {
        if (jSONObject.optBoolean("requestInQueue", true)) {
            c.v(hVar.getRuntime()).a(this, hVar, jSONObject, i);
        } else {
            a.u(hVar.getRuntime()).a(this, hVar, jSONObject, i);
        }
    }

    protected static MMActivity a(h hVar) {
        Activity ad;
        if (hVar instanceof q) {
            ad = ((q) hVar).ad(Activity.class);
        } else {
            ad = hVar.getContext();
        }
        if (ad == null || !(ad instanceof MMActivity)) {
            return null;
        }
        return (MMActivity) ad;
    }

    protected static LinkedList<c> x(LinkedList<buj> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            buj buj = (buj) it.next();
            c cVar = new c();
            cVar.scope = buj.vOF;
            cVar.desc = buj.Desc;
            cVar.state = buj.wWa;
            linkedList2.add(cVar);
        }
        return linkedList2;
    }

    protected static <T> LinkedList<T> k(ArrayList<T> arrayList) {
        if (arrayList == null) {
            return null;
        }
        LinkedList<T> linkedList = new LinkedList();
        linkedList.addAll(arrayList);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    public final void b(h hVar, int i, String str) {
        hVar.M(i, j(str, null));
    }
}
