package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.z.b.a {
    public abstract void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, com.tencent.mm.z.b.b.a<JSONObject> aVar2);

    public a(String str, int i) {
        super(str, i);
    }

    /* Access modifiers changed, original: protected */
    public void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, Bundle bundle, com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        a(aVar, jSONObject, (com.tencent.mm.z.b.b.a) aVar2);
    }
}
