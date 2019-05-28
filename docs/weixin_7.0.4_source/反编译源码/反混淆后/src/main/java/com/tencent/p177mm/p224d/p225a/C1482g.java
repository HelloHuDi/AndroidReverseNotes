package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.C45010V8;
import com.eclipsesource.p097v8.ILoadLibraryDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.d.a.g */
public final class C1482g {

    /* renamed from: com.tencent.mm.d.a.g$1 */
    static class C14831 implements ILoadLibraryDelegate {
        C14831() {
        }

        public final void loadLibrary(String str) {
            AppMethodBeat.m2504i(113799);
            C1449k.m3079a("mmv8", C37665i.class.getClassLoader());
            C1449k.m3079a("node", C37665i.class.getClassLoader());
            C1449k.m3079a("j2v8", C37665i.class.getClassLoader());
            C4990ab.m7416i("MicroMsg.JSRuntimeCreator", "load so done");
            AppMethodBeat.m2505o(113799);
        }
    }

    static {
        AppMethodBeat.m2504i(113803);
        C45010V8.setLoadLibraryDelegate(new C14831());
        AppMethodBeat.m2505o(113803);
    }

    /* renamed from: g */
    public static C37665i m3102g(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113800);
        C37665i j = C37665i.m63696j(str, bArr);
        AppMethodBeat.m2505o(113800);
        return j;
    }

    /* renamed from: h */
    public static C26066v m3103h(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113801);
        C26066v k = C26066v.m41605k(str, bArr);
        AppMethodBeat.m2505o(113801);
        return k;
    }

    /* renamed from: i */
    public static C26066v m3104i(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113802);
        C26066v f = C37664b.m63693f(str, bArr);
        AppMethodBeat.m2505o(113802);
        return f;
    }
}
