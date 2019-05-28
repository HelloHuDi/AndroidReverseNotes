package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {

    public static final class a {
        final e aPH;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.a.e$a$6 */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ int aPS;

            AnonymousClass6(int i) {
                this.aPS = i;
            }

            public final void run() {
                AppMethodBeat.i(94657);
                a.this.aPH.dx(this.aPS);
                AppMethodBeat.o(94657);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ int aPO;
            final /* synthetic */ long aPP;
            final /* synthetic */ long aPQ;

            AnonymousClass4(int i, long j, long j2) {
                this.aPO = i;
                this.aPP = j;
                this.aPQ = j2;
            }

            public final void run() {
                AppMethodBeat.i(94655);
                a.this.aPH.d(this.aPO, this.aPP, this.aPQ);
                AppMethodBeat.o(94655);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d aPI;

            AnonymousClass1(d dVar) {
                this.aPI = dVar;
            }

            public final void run() {
                AppMethodBeat.i(94652);
                a.this.aPH.c(this.aPI);
                AppMethodBeat.o(94652);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String aPK;
            final /* synthetic */ long aPL;
            final /* synthetic */ long aPM;

            AnonymousClass2(String str, long j, long j2) {
                this.aPK = str;
                this.aPL = j;
                this.aPM = j2;
            }

            public final void run() {
                AppMethodBeat.i(94653);
                a.this.aPH.b(this.aPK, this.aPL, this.aPM);
                AppMethodBeat.o(94653);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Format aPN;

            AnonymousClass3(Format format) {
                this.aPN = format;
            }

            public final void run() {
                AppMethodBeat.i(94654);
                a.this.aPH.d(this.aPN);
                AppMethodBeat.o(94654);
            }
        }

        public a(Handler handler, e eVar) {
            AppMethodBeat.i(94658);
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler) : null;
            this.aPH = eVar;
            AppMethodBeat.o(94658);
        }

        public final void e(final d dVar) {
            AppMethodBeat.i(94659);
            if (this.aPH != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(94656);
                        a.this.aPH.d(dVar);
                        AppMethodBeat.o(94656);
                    }
                });
            }
            AppMethodBeat.o(94659);
        }
    }

    void b(String str, long j, long j2);

    void c(d dVar);

    void d(int i, long j, long j2);

    void d(Format format);

    void d(d dVar);

    void dx(int i);
}
