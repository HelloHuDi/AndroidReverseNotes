package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.mm.z.b.a;
import org.json.JSONObject;

public abstract class b extends a {
    public abstract JSONObject a(com.tencent.mm.z.c.a aVar);

    public final /* bridge */ /* synthetic */ String a(com.tencent.mm.z.c.a aVar, Object obj, Object obj2, com.tencent.mm.z.b.b.a aVar2) {
        return super.a(aVar, (JSONObject) obj, (Bundle) obj2, aVar2);
    }

    public b(String str, int i) {
        super(str, i);
    }

    public final /* synthetic */ String a(com.tencent.mm.z.c.a aVar, Object obj, com.tencent.mm.z.b.b.a aVar2) {
        return a(aVar).toString();
    }
}
