package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31001da;
import com.tencent.tencentmap.mapsdk.p666a.C36464bj;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lt */
public class C5907lt implements C36464bj {
    /* renamed from: a */
    private C31001da f1670a = C31001da.zh;

    /* renamed from: a */
    public String mo12540a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(100481);
        String e = C24414lq.m37994e();
        if (e == null) {
            AppMethodBeat.m2505o(100481);
            return null;
        }
        int[] h = C24414lq.m37997h();
        if (h.length == 0) {
            e = e.replaceFirst("\\{range\\}", "");
        } else {
            e = e.replaceFirst("\\{range\\}", Integer.toString(mo12538a(i + i2, h.length)));
        }
        e = e.replaceFirst("\\{z\\}", Integer.toString(i3)).replaceFirst("\\{x\\}", Integer.toString(i)).replaceFirst("\\{y\\}", Integer.toString(i2)).replaceFirst("\\{style\\}", Integer.toString(C24414lq.m37987a())).replaceFirst("\\{scene\\}", Integer.toString(C24414lq.m37991b())).replaceFirst("\\{version\\}", Integer.toString(C24414lq.m37992c())).replaceFirst("\\{ch\\}", this.f1670a.name()) + "&foreignLanguage=" + this.f1670a.name();
        AppMethodBeat.m2505o(100481);
        return e;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo12538a(int i, int i2) {
        int i3 = i % i2;
        return i3 * i2 < 0 ? i3 + i2 : i3;
    }

    /* renamed from: a */
    public void mo12541a(C31001da c31001da) {
        this.f1670a = c31001da;
    }

    /* renamed from: a */
    public C31001da mo12539a() {
        return this.f1670a;
    }
}
