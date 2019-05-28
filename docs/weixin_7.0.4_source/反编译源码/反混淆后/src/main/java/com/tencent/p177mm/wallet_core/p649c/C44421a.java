package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.wallet_core.c.a */
public abstract class C44421a<K extends btd, P extends C37440a<K>> {
    protected List<C40926a<K>> callbacks = new ArrayList();
    protected P fsz;
    protected boolean okX = false;

    /* renamed from: com.tencent.mm.wallet_core.c.a$1 */
    class C160751 implements C5681a<Object, K> {
        C160751() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(49020);
            btd btd = (btd) obj;
            C44421a.this.okX = false;
            C44421a.m80302a(C44421a.this, btd);
            AppMethodBeat.m2505o(49020);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.a$2 */
    class C308582 implements C5681a<K, C37441a<K>> {
        C308582() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(49021);
            C37441a c37441a = (C37441a) obj;
            C44421a.this.mo56147e(c37441a);
            btd btd = c37441a.fsy;
            AppMethodBeat.m2505o(49021);
            return btd;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.a$a */
    public interface C40926a<K> {
        /* renamed from: bX */
        void mo9356bX(K k);

        /* renamed from: bY */
        void mo9357bY(K k);
    }

    public abstract K bLr();

    /* renamed from: e */
    public abstract void mo56147e(C37441a<K> c37441a);

    /* renamed from: a */
    public final void mo70316a(C40926a<K> c40926a) {
        C4990ab.m7417i("MicroMsg.AsyncCgiLoader", "try do cgi: %s", Boolean.TRUE);
        c40926a.mo9357bY(bLr());
        if (!this.callbacks.contains(c40926a)) {
            this.callbacks.add(c40926a);
        }
        C4990ab.m7417i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", Boolean.valueOf(this.okX));
        if (!this.okX) {
            this.okX = true;
            C37440a c37440a = this.fsz;
            Assert.assertNotNull("cgi must not be null", c37440a);
            c37440a.acy().mo60492h(new C308582()).mo60487b(new C160751());
        }
    }

    /* renamed from: b */
    public final void mo70317b(P p) {
        this.fsz = p;
    }

    /* renamed from: a */
    static /* synthetic */ void m80302a(C44421a c44421a, btd btd) {
        for (int size = c44421a.callbacks.size() - 1; size >= 0; size--) {
            C40926a c40926a = (C40926a) c44421a.callbacks.get(size);
            c40926a.mo9356bX(btd);
            c44421a.callbacks.remove(c40926a);
        }
    }
}
