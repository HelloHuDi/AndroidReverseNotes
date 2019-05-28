package com.tencent.p177mm.p652z;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40954d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.z.a */
public final class C44436a {

    /* renamed from: com.tencent.mm.z.a$a */
    public interface C36402a {
        /* renamed from: Qp */
        void mo44634Qp();

        /* renamed from: lo */
        void mo44635lo(String str);
    }

    /* renamed from: a */
    public static void m80370a(C40954d c40954d, String str, final C36402a c36402a) {
        AppMethodBeat.m2504i(115298);
        if (C5046bo.isNullOrNil(str)) {
            c36402a.mo44635lo("");
            AppMethodBeat.m2505o(115298);
            return;
        }
        c40954d.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.m2504i(115297);
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (c36402a != null) {
                        c36402a.mo44635lo(str);
                        AppMethodBeat.m2505o(115297);
                        return;
                    }
                } else if (c36402a != null) {
                    c36402a.mo44634Qp();
                }
                AppMethodBeat.m2505o(115297);
            }
        });
        AppMethodBeat.m2505o(115298);
    }
}
