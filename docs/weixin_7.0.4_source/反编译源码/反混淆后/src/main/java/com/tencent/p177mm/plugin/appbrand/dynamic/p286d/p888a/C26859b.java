package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a;

import android.os.Bundle;
import com.tencent.p177mm.p652z.p1101b.C36404a;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a.b */
public abstract class C26859b extends C36404a {
    /* renamed from: a */
    public abstract JSONObject mo5954a(C36405a c36405a);

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ String mo21610a(C36405a c36405a, Object obj, Object obj2, C16115a c16115a) {
        return super.mo21610a(c36405a, (JSONObject) obj, (Bundle) obj2, c16115a);
    }

    public C26859b(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    public final /* synthetic */ String mo21609a(C36405a c36405a, Object obj, C16115a c16115a) {
        return mo5954a(c36405a).toString();
    }
}
