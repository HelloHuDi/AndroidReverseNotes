package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.sqlitelint.config.SharePluginInfo;

public final class p extends n {
    public x cij;
    private final JavaVoidCallback cik = new JavaVoidCallback() {
        public final void invoke(V8Object v8Object, V8Array v8Array) {
        }
    };

    public p() {
        super("console");
        AppMethodBeat.i(113866);
        AppMethodBeat.o(113866);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(l lVar, V8Object v8Object) {
        AppMethodBeat.i(113867);
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113861);
                ab.v("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(113861);
            }
        }, "log");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113862);
                ab.i("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(113862);
            }
        }, "info");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113863);
                ab.w("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(113863);
            }
        }, "warn");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113864);
                String v8Array2 = v8Array.toString();
                ab.e("MicroMsg.J2V8_Console", v8Array2);
                if (p.this.cij != null) {
                    p.this.cij.onError(v8Array2);
                }
                AppMethodBeat.o(113864);
            }
        }, "error");
        v8Object.registerJavaMethod(new JavaVoidCallback() {
            public final void invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(113865);
                ab.d("MicroMsg.J2V8_Console", v8Array.toString());
                AppMethodBeat.o(113865);
            }
        }, "debug");
        v8Object.registerJavaMethod(this.cik, "assert");
        v8Object.registerJavaMethod(this.cik, "count");
        v8Object.registerJavaMethod(this.cik, Scopes.PROFILE);
        v8Object.registerJavaMethod(this.cik, "profileEnd");
        v8Object.registerJavaMethod(this.cik, "time");
        v8Object.registerJavaMethod(this.cik, "timeEnd");
        v8Object.registerJavaMethod(this.cik, "timeStamp");
        v8Object.registerJavaMethod(this.cik, "takeHeapSnapshot");
        v8Object.registerJavaMethod(this.cik, "group");
        v8Object.registerJavaMethod(this.cik, "groupCollapsed");
        v8Object.registerJavaMethod(this.cik, "groupEnd");
        v8Object.registerJavaMethod(this.cik, "clear");
        v8Object.registerJavaMethod(this.cik, "dir");
        v8Object.registerJavaMethod(this.cik, "dirxml");
        v8Object.registerJavaMethod(this.cik, SharePluginInfo.ISSUE_KEY_TABLE);
        v8Object.registerJavaMethod(this.cik, "trace");
        AppMethodBeat.o(113867);
    }

    public final void cleanup() {
    }
}
