package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C42453x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.sqlitelint.config.SharePluginInfo;

/* renamed from: com.tencent.mm.d.a.p */
public final class C18182p extends C9265n {
    public C42453x cij;
    private final JavaVoidCallback cik = new C181861();

    /* renamed from: com.tencent.mm.d.a.p$4 */
    class C181804 implements JavaVoidCallback {
        C181804() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113863);
            C4990ab.m7420w("MicroMsg.J2V8_Console", v8Array.toString());
            AppMethodBeat.m2505o(113863);
        }
    }

    /* renamed from: com.tencent.mm.d.a.p$5 */
    class C181815 implements JavaVoidCallback {
        C181815() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113864);
            String v8Array2 = v8Array.toString();
            C4990ab.m7412e("MicroMsg.J2V8_Console", v8Array2);
            if (C18182p.this.cij != null) {
                C18182p.this.cij.onError(v8Array2);
            }
            AppMethodBeat.m2505o(113864);
        }
    }

    /* renamed from: com.tencent.mm.d.a.p$3 */
    class C181833 implements JavaVoidCallback {
        C181833() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113862);
            C4990ab.m7416i("MicroMsg.J2V8_Console", v8Array.toString());
            AppMethodBeat.m2505o(113862);
        }
    }

    /* renamed from: com.tencent.mm.d.a.p$6 */
    class C181846 implements JavaVoidCallback {
        C181846() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113865);
            C4990ab.m7410d("MicroMsg.J2V8_Console", v8Array.toString());
            AppMethodBeat.m2505o(113865);
        }
    }

    /* renamed from: com.tencent.mm.d.a.p$2 */
    class C181852 implements JavaVoidCallback {
        C181852() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113861);
            C4990ab.m7418v("MicroMsg.J2V8_Console", v8Array.toString());
            AppMethodBeat.m2505o(113861);
        }
    }

    /* renamed from: com.tencent.mm.d.a.p$1 */
    class C181861 implements JavaVoidCallback {
        C181861() {
        }

        public final void invoke(V8Object v8Object, V8Array v8Array) {
        }
    }

    public C18182p() {
        super("console");
        AppMethodBeat.m2504i(113866);
        AppMethodBeat.m2505o(113866);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo4940a(C32488l c32488l, V8Object v8Object) {
        AppMethodBeat.m2504i(113867);
        v8Object.registerJavaMethod(new C181852(), "log");
        v8Object.registerJavaMethod(new C181833(), "info");
        v8Object.registerJavaMethod(new C181804(), "warn");
        v8Object.registerJavaMethod(new C181815(), "error");
        v8Object.registerJavaMethod(new C181846(), "debug");
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
        AppMethodBeat.m2505o(113867);
    }

    public final void cleanup() {
    }
}
