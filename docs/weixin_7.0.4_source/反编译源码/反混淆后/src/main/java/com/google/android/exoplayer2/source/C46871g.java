package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C37253f;
import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p110h.C0867f.C0868a;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C41629f.C8715c;
import com.google.android.exoplayer2.source.C45052i.C37281a;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.g */
public final class C46871g implements C8715c, C45052i {
    private final C17694a aMW;
    private final int bgC;
    private final C0881a bgD;
    private final String bgG;
    private C37281a bgz;
    private final C0868a bhk;
    private final C32039h bhl;
    private final int bhm;
    private long bhn;
    private boolean bho;
    private final Handler eventHandler;
    private final Uri uri;

    /* renamed from: com.google.android.exoplayer2.source.g$a */
    public interface C0881a {
        void onLoadError(IOException iOException);
    }

    public C46871g(Uri uri, C0868a c0868a, C32039h c32039h) {
        this(uri, c0868a, c32039h, (byte) 0);
    }

    private C46871g(Uri uri, C0868a c0868a, C32039h c32039h, byte b) {
        this(uri, c0868a, c32039h, 0);
    }

    private C46871g(Uri uri, C0868a c0868a, C32039h c32039h, char c) {
        AppMethodBeat.m2504i(95506);
        this.uri = uri;
        this.bhk = c0868a;
        this.bhl = c32039h;
        this.bgC = -1;
        this.eventHandler = null;
        this.bgD = null;
        this.bgG = null;
        this.bhm = 1048576;
        this.aMW = new C17694a();
        AppMethodBeat.m2505o(95506);
    }

    /* renamed from: a */
    public final void mo42821a(C37253f c37253f, C37281a c37281a) {
        AppMethodBeat.m2504i(95507);
        this.bgz = c37281a;
        m89107f(-9223372036854775807L, false);
        AppMethodBeat.m2505o(95507);
    }

    /* renamed from: rX */
    public final void mo42824rX() {
    }

    /* renamed from: a */
    public final C37279h mo42820a(C45051b c45051b, C32053b c32053b) {
        AppMethodBeat.m2504i(95508);
        C45039a.checkArgument(c45051b.bhq == 0);
        C41629f c41629f = new C41629f(this.uri, this.bhk.mo2587tm(), this.bhl.mo2572ra(), this.bgC, this.eventHandler, this.bgD, this, c32053b, this.bgG, this.bhm);
        AppMethodBeat.m2505o(95508);
        return c41629f;
    }

    /* renamed from: b */
    public final void mo42823b(C37279h c37279h) {
        AppMethodBeat.m2504i(95509);
        C41629f c41629f = (C41629f) c37279h;
        boolean a = c41629f.bgI.mo66742a(c41629f);
        if (c41629f.prepared && !a) {
            for (C25560k sq : c41629f.bgO) {
                sq.mo42842sq();
            }
        }
        c41629f.handler.removeCallbacksAndMessages(null);
        c41629f.released = true;
        AppMethodBeat.m2505o(95509);
    }

    /* renamed from: rY */
    public final void mo42825rY() {
        this.bgz = null;
    }

    /* renamed from: e */
    public final void mo19291e(long j, boolean z) {
        AppMethodBeat.m2504i(95510);
        if (j == -9223372036854775807L) {
            j = this.bhn;
        }
        if (!(this.bhn == j && this.bho == z) && (this.bhn == -9223372036854775807L || j != -9223372036854775807L)) {
            m89107f(j, z);
            AppMethodBeat.m2505o(95510);
            return;
        }
        AppMethodBeat.m2505o(95510);
    }

    /* renamed from: f */
    private void m89107f(long j, boolean z) {
        AppMethodBeat.m2504i(95511);
        this.bhn = j;
        this.bho = z;
        this.bgz.mo42822a(new C25561n(this.bhn, this.bho), null);
        AppMethodBeat.m2505o(95511);
    }
}
