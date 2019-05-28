package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.JavaCallback;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.d.a.q */
public final class C45302q extends C9265n {
    final C1481e chP;

    /* renamed from: com.tencent.mm.d.a.q$1 */
    class C260641 implements JavaCallback {
        C260641() {
        }

        public final Object invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.m2504i(113868);
            if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                C4990ab.m7420w("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
                AppMethodBeat.m2505o(113868);
                return null;
            }
            C4990ab.m7417i("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", Integer.valueOf(v8Array.getInteger(0)));
            Object go = C45302q.this.chP.mo4934go(r0);
            AppMethodBeat.m2505o(113868);
            return go;
        }
    }

    public C45302q(C1481e c1481e) {
        super("WeixinArrayBuffer");
        this.chP = c1481e;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo4940a(C32488l c32488l, V8Object v8Object) {
        AppMethodBeat.m2504i(113869);
        v8Object.registerJavaMethod(new C260641(), "get");
        AppMethodBeat.m2505o(113869);
    }

    /* Access modifiers changed, original: final */
    public final void cleanup() {
    }
}
