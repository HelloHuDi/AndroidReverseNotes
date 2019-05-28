package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.SharedV8ArrayBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.d.a.k */
public final class C32485k implements C1481e {
    private final AtomicInteger chI = new AtomicInteger(0);
    private final Map<Integer, C26061a> chJ = new HashMap();
    private final C32488l chK;

    /* renamed from: com.tencent.mm.d.a.k$a */
    static final class C26061a {
        final C32488l chK;
        ByteBuffer chL = ByteBuffer.allocateDirect(this.mCapacity);
        SharedV8ArrayBuffer chM = null;
        private final int mCapacity;

        /* renamed from: com.tencent.mm.d.a.k$a$1 */
        class C260621 implements Runnable {
            C260621() {
            }

            public final void run() {
                AppMethodBeat.m2504i(113828);
                C4990ab.m7416i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
                C26061a.this.chM.manualRelease();
                AppMethodBeat.m2505o(113828);
            }
        }

        C26061a(int i, C32488l c32488l) {
            AppMethodBeat.m2504i(113829);
            this.chK = c32488l;
            this.mCapacity = i;
            AppMethodBeat.m2505o(113829);
        }
    }

    public C32485k(C32488l c32488l) {
        AppMethodBeat.m2504i(113830);
        this.chK = c32488l;
        AppMethodBeat.m2505o(113830);
    }

    /* renamed from: gn */
    public final int mo4933gn(int i) {
        AppMethodBeat.m2504i(113831);
        int addAndGet = this.chI.addAndGet(1);
        this.chJ.put(Integer.valueOf(addAndGet), new C26061a(i, this.chK));
        C4990ab.m7417i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", Integer.valueOf(i), Integer.valueOf(addAndGet));
        AppMethodBeat.m2505o(113831);
        return addAndGet;
    }

    /* renamed from: go */
    public final SharedV8ArrayBuffer mo4934go(int i) {
        AppMethodBeat.m2504i(113832);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            C26061a c26061a = (C26061a) this.chJ.get(Integer.valueOf(i));
            if (c26061a.chM == null) {
                c26061a.chM = c26061a.chK.mo53119CB().newSharedV8ArrayBuffer(c26061a.chL);
            }
            SharedV8ArrayBuffer sharedV8ArrayBuffer = c26061a.chM;
            AppMethodBeat.m2505o(113832);
            return sharedV8ArrayBuffer;
        }
        C4990ab.m7421w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.m2505o(113832);
        return null;
    }

    /* renamed from: gp */
    public final ByteBuffer mo4935gp(int i) {
        AppMethodBeat.m2504i(113833);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            ByteBuffer byteBuffer = ((C26061a) this.chJ.get(Integer.valueOf(i))).chL;
            AppMethodBeat.m2505o(113833);
            return byteBuffer;
        }
        C4990ab.m7421w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.m2505o(113833);
        return null;
    }

    public final void destroy(int i) {
        AppMethodBeat.m2504i(113834);
        if (this.chJ.containsKey(Integer.valueOf(i))) {
            C4990ab.m7417i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", Integer.valueOf(i));
            C26061a c26061a = (C26061a) this.chJ.get(Integer.valueOf(i));
            c26061a.chK.chO.mo73187k(new C260621());
            this.chJ.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(113834);
            return;
        }
        C4990ab.m7421w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", Integer.valueOf(i));
        AppMethodBeat.m2505o(113834);
    }
}
