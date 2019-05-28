package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C7489c.C7494c;
import com.tencent.p177mm.protocal.protobuf.buj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.f */
public abstract class C33245f extends C10296a<C33327h> {
    /* renamed from: a */
    public abstract void mo21765a(C33327h c33327h, JSONObject jSONObject, int i, C2227d c2227d);

    /* renamed from: a */
    public void mo5994a(C33327h c33327h, JSONObject jSONObject, int i) {
        if (jSONObject.optBoolean("requestInQueue", true)) {
            C6769c.m11208v(c33327h.getRuntime()).mo6091a(this, c33327h, jSONObject, i);
        } else {
            C19306a.m29983u(c33327h.getRuntime()).mo6091a(this, c33327h, jSONObject, i);
        }
    }

    /* renamed from: a */
    protected static MMActivity m54389a(C33327h c33327h) {
        Activity ad;
        if (c33327h instanceof C38492q) {
            ad = ((C38492q) c33327h).mo61197ad(Activity.class);
        } else {
            ad = c33327h.getContext();
        }
        if (ad == null || !(ad instanceof MMActivity)) {
            return null;
        }
        return (MMActivity) ad;
    }

    /* renamed from: x */
    protected static LinkedList<C7494c> m54391x(LinkedList<buj> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            buj buj = (buj) it.next();
            C7494c c7494c = new C7494c();
            c7494c.scope = buj.vOF;
            c7494c.desc = buj.Desc;
            c7494c.state = buj.wWa;
            linkedList2.add(c7494c);
        }
        return linkedList2;
    }

    /* renamed from: k */
    protected static <T> LinkedList<T> m54390k(ArrayList<T> arrayList) {
        if (arrayList == null) {
            return null;
        }
        LinkedList<T> linkedList = new LinkedList();
        linkedList.addAll(arrayList);
        return linkedList;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo53782b(C33327h c33327h, int i, String str) {
        c33327h.mo6107M(i, mo73394j(str, null));
    }
}
