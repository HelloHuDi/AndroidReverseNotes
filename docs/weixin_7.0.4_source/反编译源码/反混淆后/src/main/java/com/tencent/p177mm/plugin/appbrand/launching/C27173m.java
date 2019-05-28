package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.Locale;
import java.util.concurrent.Callable;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.m */
public interface C27173m extends Callable<WxaPkgWrappingInfo> {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.m$a */
    public static final class C27174a extends Error {
        final String ihb;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.m$a$a */
        static final class C27175a {
            String errorMessage;
            String ihb;

            C27175a() {
            }

            /* Access modifiers changed, original: final|varargs */
            /* renamed from: n */
            public final C27175a mo44848n(String str, Object... objArr) {
                AppMethodBeat.m2504i(131814);
                this.ihb = String.format(Locale.US, str, objArr);
                AppMethodBeat.m2505o(131814);
                return this;
            }

            /* Access modifiers changed, original: final|varargs */
            /* renamed from: o */
            public final C27175a mo44849o(String str, Object... objArr) {
                AppMethodBeat.m2504i(131815);
                this.errorMessage = String.format(Locale.US, str, objArr);
                AppMethodBeat.m2505o(131815);
                return this;
            }

            /* Access modifiers changed, original: final */
            public final C27174a aHl() {
                AppMethodBeat.m2504i(131816);
                C27174a c27174a = new C27174a(this.errorMessage, this.ihb);
                AppMethodBeat.m2505o(131816);
                return c27174a;
            }
        }

        C27174a(String str, String str2) {
            super(str);
            this.ihb = str2;
        }
    }

    void onDownloadProgress(int i);
}
