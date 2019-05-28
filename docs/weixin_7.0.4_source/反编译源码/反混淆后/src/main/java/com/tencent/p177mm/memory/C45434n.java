package com.tencent.p177mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.memory.n */
public class C45434n implements C26406i {
    private static ConcurrentHashMap<Bitmap, Integer> fdN = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private boolean fdL = false;
    private AtomicInteger fdM = new AtomicInteger();
    private boolean fdO = true;
    private Runnable fdP = new C18081();
    private int fdQ = 0;
    private int fdR = 0;

    /* renamed from: com.tencent.mm.memory.n$1 */
    class C18081 implements Runnable {
        C18081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(115391);
            C45434n.m83679a(C45434n.this);
            AppMethodBeat.m2505o(115391);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m83679a(C45434n c45434n) {
        AppMethodBeat.m2504i(115405);
        boolean Xk = c45434n.m83677Xk();
        AppMethodBeat.m2505o(115405);
        return Xk;
    }

    static {
        AppMethodBeat.m2504i(115406);
        AppMethodBeat.m2505o(115406);
    }

    private C45434n(Bitmap bitmap) {
        AppMethodBeat.m2504i(115392);
        this.bitmap = bitmap;
        this.fdM.set(1);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + C5046bo.dpG().toString());
        }
        this.fdL = false;
        getAllocationByteCount();
        AppMethodBeat.m2505o(115392);
    }

    /* renamed from: w */
    public static C45434n m83680w(Bitmap bitmap) {
        AppMethodBeat.m2504i(115393);
        if (bitmap == null) {
            AppMethodBeat.m2505o(115393);
            return null;
        }
        C45434n c45434n = new C45434n(bitmap);
        AppMethodBeat.m2505o(115393);
        return c45434n;
    }

    /* renamed from: Xh */
    public final Bitmap mo73229Xh() {
        this.fdO = false;
        return this.bitmap;
    }

    /* renamed from: Xd */
    public final void mo33853Xd() {
        AppMethodBeat.m2504i(115394);
        this.fdM.incrementAndGet();
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.fdM + " bitmap:" + this.bitmap + " " + this + " " + C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(115394);
    }

    /* renamed from: Xe */
    public final void mo33854Xe() {
        AppMethodBeat.m2504i(115395);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.fdM + " bitmap:" + this.bitmap + " " + this + " " + C5046bo.dpG().toString());
        }
        if (this.fdM.get() > 0) {
            this.fdM.decrementAndGet();
            if (this.fdM.get() < 0) {
                AppMethodBeat.m2505o(115395);
                return;
            } else {
                this.fbD.removeCallbacks(this.fdP);
                this.fbD.postDelayed(this.fdP, 500);
            }
        }
        AppMethodBeat.m2505o(115395);
    }

    /* renamed from: Xi */
    public final Bitmap mo73230Xi() {
        AppMethodBeat.m2504i(115396);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + C5046bo.dpG().toString());
        }
        Bitmap bitmap = this.bitmap;
        AppMethodBeat.m2505o(115396);
        return bitmap;
    }

    public final boolean isRecycled() {
        AppMethodBeat.m2504i(115397);
        if (this.fdL || this.bitmap == null || this.bitmap.isRecycled()) {
            AppMethodBeat.m2505o(115397);
            return true;
        }
        AppMethodBeat.m2505o(115397);
        return false;
    }

    /* renamed from: Xj */
    public final boolean mo73231Xj() {
        AppMethodBeat.m2504i(115398);
        this.fdM.decrementAndGet();
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "recycle~:" + this.fdL + " isMutable:" + this.fdO + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdM + C5046bo.dpG().toString());
        }
        m83677Xk();
        AppMethodBeat.m2505o(115398);
        return true;
    }

    /* renamed from: Xk */
    private boolean m83677Xk() {
        AppMethodBeat.m2504i(115399);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.fdL + " isMutable:" + this.fdO + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdM + C5046bo.dpG().toString());
        }
        if (this.fdL || this.fdM.get() > 0) {
            AppMethodBeat.m2505o(115399);
            return false;
        }
        this.fdL = true;
        if (this.DEBUG) {
            fdN.remove(this.bitmap);
        }
        if (this.fdO) {
            C37899l.m63997Xf().mo60652v(this.bitmap);
        }
        AppMethodBeat.m2505o(115399);
        return true;
    }

    /* renamed from: Xl */
    private final int m83678Xl() {
        AppMethodBeat.m2504i(115400);
        int i;
        if (this.bitmap == null || this.bitmap.isRecycled()) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.fdQ + " " + toString());
            i = this.fdQ;
            AppMethodBeat.m2505o(115400);
            return i;
        }
        this.fdQ = this.bitmap.getByteCount();
        i = this.fdQ;
        AppMethodBeat.m2505o(115400);
        return i;
    }

    public final int getAllocationByteCount() {
        AppMethodBeat.m2504i(115401);
        int Xl;
        if (C1443d.m3067fP(19)) {
            Xl = m83678Xl();
            AppMethodBeat.m2505o(115401);
            return Xl;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.fdR + " " + toString());
            Xl = this.fdR;
            AppMethodBeat.m2505o(115401);
            return Xl;
        } else {
            this.fdR = this.bitmap.getAllocationByteCount();
            Xl = this.fdR;
            AppMethodBeat.m2505o(115401);
            return Xl;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(115402);
        String str;
        if (this.DEBUG) {
            str = super.toString() + " code: " + hashCode() + " attachCount: " + this.fdM;
            if (this.bitmap != null) {
                str = str + this.bitmap;
            }
            AppMethodBeat.m2505o(115402);
            return str;
        }
        str = super.toString();
        AppMethodBeat.m2505o(115402);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(115403);
        if (this.DEBUG) {
            C4990ab.m7416i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
        AppMethodBeat.m2505o(115403);
    }

    /* renamed from: Xm */
    public final String mo73232Xm() {
        AppMethodBeat.m2504i(115404);
        String str = this + " " + this.bitmap;
        AppMethodBeat.m2505o(115404);
        return str;
    }
}
