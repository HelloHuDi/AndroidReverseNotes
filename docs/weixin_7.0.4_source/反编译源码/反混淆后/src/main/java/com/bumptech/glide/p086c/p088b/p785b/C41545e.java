package com.bumptech.glide.p086c.p088b.p785b;

import android.util.Log;
import com.bumptech.glide.p084a.C31916a;
import com.bumptech.glide.p084a.C31916a.C31917b;
import com.bumptech.glide.p084a.C31916a.C31918d;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.p088b.p785b.C31932a.C31931b;
import com.bumptech.glide.p086c.p088b.p785b.C44984c.C17517a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.c.b.b.e */
public final class C41545e implements C31932a {
    private final C25415j aDe;
    private final C44984c aDf = new C44984c();
    private C31916a aDg;
    private final long axz;
    private final File directory;

    @Deprecated
    C41545e(File file, long j) {
        AppMethodBeat.m2504i(91981);
        this.directory = file;
        this.axz = j;
        this.aDe = new C25415j();
        AppMethodBeat.m2505o(91981);
    }

    /* renamed from: mX */
    private synchronized C31916a m72733mX() {
        C31916a c31916a;
        AppMethodBeat.m2504i(91982);
        if (this.aDg == null) {
            this.aDg = C31916a.m51804a(this.directory, this.axz);
        }
        c31916a = this.aDg;
        AppMethodBeat.m2505o(91982);
        return c31916a;
    }

    /* renamed from: a */
    public final File mo52046a(C0779h c0779h) {
        AppMethodBeat.m2504i(91983);
        String c = this.aDe.mo42462c(c0779h);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            new StringBuilder("Get: Obtained: ").append(c).append(" for for Key: ").append(c0779h);
        }
        File file = null;
        try {
            C31918d X = m72733mX().mo52028X(c);
            if (X != null) {
                file = X.files[0];
            }
        } catch (IOException e) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        }
        AppMethodBeat.m2505o(91983);
        return file;
    }

    /* renamed from: a */
    public final void mo52047a(C0779h c0779h, C31931b c31931b) {
        C17517a c17517a;
        AppMethodBeat.m2504i(91984);
        String c = this.aDe.mo42462c(c0779h);
        C44984c c44984c = this.aDf;
        synchronized (c44984c) {
            try {
                c17517a = (C17517a) c44984c.aCX.get(c);
                if (c17517a == null) {
                    c17517a = c44984c.aCY.mo42460mV();
                    c44984c.aCX.put(c, c17517a);
                }
                c17517a.aDa++;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(91984);
            }
        }
        c17517a.aCZ.lock();
        C31917b Y;
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                new StringBuilder("Put: Obtained: ").append(c).append(" for for Key: ").append(c0779h);
            }
            C31916a mX = m72733mX();
            if (mX.mo52028X(c) != null) {
                this.aDf.release(c);
                return;
            }
            Y = mX.mo52029Y(c);
            if (Y == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(c)));
                AppMethodBeat.m2505o(91984);
                throw illegalStateException;
            }
            if (c31931b.mo2209m(Y.mo52032lP())) {
                C31916a.m51807a(C31916a.this, Y, true);
                Y.axK = true;
            }
            Y.mo52033lQ();
            this.aDf.release(c);
            AppMethodBeat.m2505o(91984);
        } catch (IOException e) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
        } catch (Throwable th) {
            this.aDf.release(c);
            AppMethodBeat.m2505o(91984);
        }
    }
}
