package com.google.android.exoplayer2.p099a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.a.e */
public interface C0826e {

    /* renamed from: com.google.android.exoplayer2.a.e$a */
    public static final class C0827a {
        final C0826e aPH;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.a.e$a$6 */
        class C08296 implements Runnable {
            final /* synthetic */ int aPS;

            C08296(int i) {
                this.aPS = i;
            }

            public final void run() {
                AppMethodBeat.m2504i(94657);
                C0827a.this.aPH.mo2527dx(this.aPS);
                AppMethodBeat.m2505o(94657);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$4 */
        class C08304 implements Runnable {
            final /* synthetic */ int aPO;
            final /* synthetic */ long aPP;
            final /* synthetic */ long aPQ;

            C08304(int i, long j, long j2) {
                this.aPO = i;
                this.aPP = j;
                this.aPQ = j2;
            }

            public final void run() {
                AppMethodBeat.m2504i(94655);
                C0827a.this.aPH.mo2524d(this.aPO, this.aPP, this.aPQ);
                AppMethodBeat.m2505o(94655);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$1 */
        class C08311 implements Runnable {
            final /* synthetic */ C32021d aPI;

            C08311(C32021d c32021d) {
                this.aPI = c32021d;
            }

            public final void run() {
                AppMethodBeat.m2504i(94652);
                C0827a.this.aPH.mo2523c(this.aPI);
                AppMethodBeat.m2505o(94652);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$2 */
        class C08322 implements Runnable {
            final /* synthetic */ String aPK;
            final /* synthetic */ long aPL;
            final /* synthetic */ long aPM;

            C08322(String str, long j, long j2) {
                this.aPK = str;
                this.aPL = j;
                this.aPM = j2;
            }

            public final void run() {
                AppMethodBeat.m2504i(94653);
                C0827a.this.aPH.mo2522b(this.aPK, this.aPL, this.aPM);
                AppMethodBeat.m2505o(94653);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$3 */
        class C08333 implements Runnable {
            final /* synthetic */ Format aPN;

            C08333(Format format) {
                this.aPN = format;
            }

            public final void run() {
                AppMethodBeat.m2504i(94654);
                C0827a.this.aPH.mo2525d(this.aPN);
                AppMethodBeat.m2505o(94654);
            }
        }

        public C0827a(Handler handler, C0826e c0826e) {
            AppMethodBeat.m2504i(94658);
            this.handler = c0826e != null ? (Handler) C45039a.checkNotNull(handler) : null;
            this.aPH = c0826e;
            AppMethodBeat.m2505o(94658);
        }

        /* renamed from: e */
        public final void mo2528e(final C32021d c32021d) {
            AppMethodBeat.m2504i(94659);
            if (this.aPH != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(94656);
                        C0827a.this.aPH.mo2526d(c32021d);
                        AppMethodBeat.m2505o(94656);
                    }
                });
            }
            AppMethodBeat.m2505o(94659);
        }
    }

    /* renamed from: b */
    void mo2522b(String str, long j, long j2);

    /* renamed from: c */
    void mo2523c(C32021d c32021d);

    /* renamed from: d */
    void mo2524d(int i, long j, long j2);

    /* renamed from: d */
    void mo2525d(Format format);

    /* renamed from: d */
    void mo2526d(C32021d c32021d);

    /* renamed from: dx */
    void mo2527dx(int i);
}
