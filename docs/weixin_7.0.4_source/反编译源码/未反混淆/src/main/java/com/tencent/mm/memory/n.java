package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n implements i {
    private static ConcurrentHashMap<Bitmap, Integer> fdN = new ConcurrentHashMap();
    private boolean DEBUG = false;
    public Bitmap bitmap = null;
    private ak fbD = new ak(Looper.getMainLooper());
    private boolean fdL = false;
    private AtomicInteger fdM = new AtomicInteger();
    private boolean fdO = true;
    private Runnable fdP = new Runnable() {
        public final void run() {
            AppMethodBeat.i(115391);
            n.a(n.this);
            AppMethodBeat.o(115391);
        }
    };
    private int fdQ = 0;
    private int fdR = 0;

    static /* synthetic */ boolean a(n nVar) {
        AppMethodBeat.i(115405);
        boolean Xk = nVar.Xk();
        AppMethodBeat.o(115405);
        return Xk;
    }

    static {
        AppMethodBeat.i(115406);
        AppMethodBeat.o(115406);
    }

    private n(Bitmap bitmap) {
        AppMethodBeat.i(115392);
        this.bitmap = bitmap;
        this.fdM.set(1);
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "bitmap " + bitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bo.dpG().toString());
        }
        this.fdL = false;
        getAllocationByteCount();
        AppMethodBeat.o(115392);
    }

    public static n w(Bitmap bitmap) {
        AppMethodBeat.i(115393);
        if (bitmap == null) {
            AppMethodBeat.o(115393);
            return null;
        }
        n nVar = new n(bitmap);
        AppMethodBeat.o(115393);
        return nVar;
    }

    public final Bitmap Xh() {
        this.fdO = false;
        return this.bitmap;
    }

    public final void Xd() {
        AppMethodBeat.i(115394);
        this.fdM.incrementAndGet();
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.fdM + " bitmap:" + this.bitmap + " " + this + " " + bo.dpG().toString());
        }
        AppMethodBeat.o(115394);
    }

    public final void Xe() {
        AppMethodBeat.i(115395);
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.fdM + " bitmap:" + this.bitmap + " " + this + " " + bo.dpG().toString());
        }
        if (this.fdM.get() > 0) {
            this.fdM.decrementAndGet();
            if (this.fdM.get() < 0) {
                AppMethodBeat.o(115395);
                return;
            } else {
                this.fbD.removeCallbacks(this.fdP);
                this.fbD.postDelayed(this.fdP, 500);
            }
        }
        AppMethodBeat.o(115395);
    }

    public final Bitmap Xi() {
        AppMethodBeat.i(115396);
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bo.dpG().toString());
        }
        Bitmap bitmap = this.bitmap;
        AppMethodBeat.o(115396);
        return bitmap;
    }

    public final boolean isRecycled() {
        AppMethodBeat.i(115397);
        if (this.fdL || this.bitmap == null || this.bitmap.isRecycled()) {
            AppMethodBeat.o(115397);
            return true;
        }
        AppMethodBeat.o(115397);
        return false;
    }

    public final boolean Xj() {
        AppMethodBeat.i(115398);
        this.fdM.decrementAndGet();
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.fdL + " isMutable:" + this.fdO + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdM + bo.dpG().toString());
        }
        Xk();
        AppMethodBeat.o(115398);
        return true;
    }

    private boolean Xk() {
        AppMethodBeat.i(115399);
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.fdL + " isMutable:" + this.fdO + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdM + bo.dpG().toString());
        }
        if (this.fdL || this.fdM.get() > 0) {
            AppMethodBeat.o(115399);
            return false;
        }
        this.fdL = true;
        if (this.DEBUG) {
            fdN.remove(this.bitmap);
        }
        if (this.fdO) {
            l.Xf().v(this.bitmap);
        }
        AppMethodBeat.o(115399);
        return true;
    }

    private final int Xl() {
        AppMethodBeat.i(115400);
        int i;
        if (this.bitmap == null || this.bitmap.isRecycled()) {
            ab.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.fdQ + " " + toString());
            i = this.fdQ;
            AppMethodBeat.o(115400);
            return i;
        }
        this.fdQ = this.bitmap.getByteCount();
        i = this.fdQ;
        AppMethodBeat.o(115400);
        return i;
    }

    public final int getAllocationByteCount() {
        AppMethodBeat.i(115401);
        int Xl;
        if (d.fP(19)) {
            Xl = Xl();
            AppMethodBeat.o(115401);
            return Xl;
        } else if (this.bitmap == null || this.bitmap.isRecycled()) {
            ab.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.fdR + " " + toString());
            Xl = this.fdR;
            AppMethodBeat.o(115401);
            return Xl;
        } else {
            this.fdR = this.bitmap.getAllocationByteCount();
            Xl = this.fdR;
            AppMethodBeat.o(115401);
            return Xl;
        }
    }

    public String toString() {
        AppMethodBeat.i(115402);
        String str;
        if (this.DEBUG) {
            str = super.toString() + " code: " + hashCode() + " attachCount: " + this.fdM;
            if (this.bitmap != null) {
                str = str + this.bitmap;
            }
            AppMethodBeat.o(115402);
            return str;
        }
        str = super.toString();
        AppMethodBeat.o(115402);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(115403);
        if (this.DEBUG) {
            ab.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
        }
        AppMethodBeat.o(115403);
    }

    public final String Xm() {
        AppMethodBeat.i(115404);
        String str = this + " " + this.bitmap;
        AppMethodBeat.o(115404);
        return str;
    }
}
