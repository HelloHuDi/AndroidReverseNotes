package com.tencent.p177mm.plugin.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p1642b.C45444a;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.base.model.C11157c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.t */
public final class C27305t implements C45444a {

    /* renamed from: com.tencent.mm.plugin.appbrand.t$a */
    static class C19739a {
        static C27305t gQg = new C27305t();

        static {
            AppMethodBeat.m2504i(129115);
            AppMethodBeat.m2505o(129115);
        }
    }

    public static C27305t auu() {
        return C19739a.gQg;
    }

    /* renamed from: a */
    public final Intent mo45003a(String str, int i, String str2, String str3, String[] strArr, String str4, int i2, int i3) {
        AppMethodBeat.m2504i(129116);
        String Fv = C11157c.m18863Fv(str2);
        if (C5046bo.isNullOrNil(Fv)) {
            AppMethodBeat.m2505o(129116);
            return null;
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
        }
        String x = C1178g.m2591x((str2 + stringBuilder.toString()).getBytes());
        Intent intent = new Intent("com.tencent.mm.action.WX_SHORTCUT");
        intent.putExtra("type", i3);
        intent.putExtra("id", Fv);
        intent.putExtra("ext_info", C11157c.m18863Fv(str4));
        intent.putExtra("token", C11157c.m18864db(str4, String.valueOf(i2)));
        intent.putExtra("digest", x);
        intent.putExtra("ext_info_1", i);
        intent.setPackage(str);
        intent.addFlags(67108864);
        AppMethodBeat.m2505o(129116);
        return intent;
    }
}
