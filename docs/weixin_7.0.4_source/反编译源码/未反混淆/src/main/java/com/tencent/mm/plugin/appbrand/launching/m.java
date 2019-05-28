package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.util.Locale;
import java.util.concurrent.Callable;

public interface m extends Callable<WxaPkgWrappingInfo> {

    public static final class a extends Error {
        final String ihb;

        static final class a {
            String errorMessage;
            String ihb;

            a() {
            }

            /* Access modifiers changed, original: final|varargs */
            public final a n(String str, Object... objArr) {
                AppMethodBeat.i(131814);
                this.ihb = String.format(Locale.US, str, objArr);
                AppMethodBeat.o(131814);
                return this;
            }

            /* Access modifiers changed, original: final|varargs */
            public final a o(String str, Object... objArr) {
                AppMethodBeat.i(131815);
                this.errorMessage = String.format(Locale.US, str, objArr);
                AppMethodBeat.o(131815);
                return this;
            }

            /* Access modifiers changed, original: final */
            public final a aHl() {
                AppMethodBeat.i(131816);
                a aVar = new a(this.errorMessage, this.ihb);
                AppMethodBeat.o(131816);
                return aVar;
            }
        }

        a(String str, String str2) {
            super(str);
            this.ihb = str2;
        }
    }

    void onDownloadProgress(int i);
}
