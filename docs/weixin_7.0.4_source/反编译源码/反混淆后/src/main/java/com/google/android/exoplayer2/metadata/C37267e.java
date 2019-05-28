package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C41591a;
import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.metadata.e */
public final class C37267e extends C41591a implements Callback {
    private boolean beE;
    private final C37266c beY;
    private final C8694a beZ;
    private final C8692k bef;
    private final Handler bfa;
    private final C36689d bfb;
    private final Metadata[] bfc;
    private final long[] bfd;
    private int bfe;
    private int bff;
    private C17679a bfg;

    /* renamed from: com.google.android.exoplayer2.metadata.e$a */
    public interface C8694a {
        /* renamed from: b */
        void mo2635b(Metadata metadata);
    }

    public C37267e(C8694a c8694a, Looper looper) {
        this(c8694a, looper, C37266c.beX);
    }

    private C37267e(C8694a c8694a, Looper looper, C37266c c37266c) {
        super(4);
        AppMethodBeat.m2504i(95349);
        this.beZ = (C8694a) C45039a.checkNotNull(c8694a);
        this.bfa = looper == null ? null : new Handler(looper, this);
        this.beY = (C37266c) C45039a.checkNotNull(c37266c);
        this.bef = new C8692k();
        this.bfb = new C36689d();
        this.bfc = new Metadata[5];
        this.bfd = new long[5];
        AppMethodBeat.m2505o(95349);
    }

    /* renamed from: b */
    public final int mo19256b(Format format) {
        AppMethodBeat.m2504i(95350);
        if (this.beY.mo32377g(format)) {
            AppMethodBeat.m2505o(95350);
            return 4;
        }
        AppMethodBeat.m2505o(95350);
        return 0;
    }

    /* renamed from: a */
    public final void mo32348a(Format[] formatArr, long j) {
        AppMethodBeat.m2504i(95351);
        this.bfg = this.beY.mo32378h(formatArr[0]);
        AppMethodBeat.m2505o(95351);
    }

    /* renamed from: b */
    public final void mo32349b(long j, boolean z) {
        AppMethodBeat.m2504i(95352);
        m62531rN();
        this.beE = false;
        AppMethodBeat.m2505o(95352);
    }

    /* renamed from: f */
    public final void mo32350f(long j, long j2) {
        AppMethodBeat.m2504i(95353);
        if (!this.beE && this.bff < 5) {
            this.bfb.clear();
            if (mo66727a(this.bef, (C32022e) this.bfb, false) == -4) {
                if (this.bfb.mo42774qG()) {
                    this.beE = true;
                } else if (!this.bfb.mo42773qF()) {
                    this.bfb.aOr = this.bef.aOv.aOr;
                    this.bfb.mo52317qL();
                    try {
                        int i = (this.bfe + this.bff) % 5;
                        this.bfc[i] = this.bfg.mo19234a(this.bfb);
                        this.bfd[i] = this.bfb.aSk;
                        this.bff++;
                    } catch (C45044b e) {
                        C25533e b = C25533e.m40358b(e, this.index);
                        AppMethodBeat.m2505o(95353);
                        throw b;
                    }
                }
            }
        }
        if (this.bff > 0 && this.bfd[this.bfe] <= j) {
            Object obj = this.bfc[this.bfe];
            if (this.bfa != null) {
                this.bfa.obtainMessage(0, obj).sendToTarget();
            } else {
                m62530d(obj);
            }
            this.bfc[this.bfe] = null;
            this.bfe = (this.bfe + 1) % 5;
            this.bff--;
        }
        AppMethodBeat.m2505o(95353);
    }

    /* renamed from: pK */
    public final void mo32353pK() {
        AppMethodBeat.m2504i(95354);
        m62531rN();
        this.bfg = null;
        AppMethodBeat.m2505o(95354);
    }

    /* renamed from: qf */
    public final boolean mo32354qf() {
        return this.beE;
    }

    public final boolean isReady() {
        return true;
    }

    /* renamed from: rN */
    private void m62531rN() {
        AppMethodBeat.m2504i(95355);
        Arrays.fill(this.bfc, null);
        this.bfe = 0;
        this.bff = 0;
        AppMethodBeat.m2505o(95355);
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(95356);
        switch (message.what) {
            case 0:
                m62530d((Metadata) message.obj);
                AppMethodBeat.m2505o(95356);
                return true;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(95356);
                throw illegalStateException;
        }
    }

    /* renamed from: d */
    private void m62530d(Metadata metadata) {
        AppMethodBeat.m2504i(95357);
        this.beZ.mo2635b(metadata);
        AppMethodBeat.m2505o(95357);
    }
}
