package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {

    public static final class a {
        final e btb;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.video.e$a$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Format aPN;

            AnonymousClass3(Format format) {
                this.aPN = format;
            }

            public final void run() {
                AppMethodBeat.i(96039);
                a.this.btb.c(this.aPN);
                AppMethodBeat.o(96039);
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$2 */
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
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d aPI;

            AnonymousClass1(d dVar) {
                this.aPI = dVar;
            }

            public final void run() {
                AppMethodBeat.i(96038);
                a.this.btb.a(this.aPI);
                AppMethodBeat.o(96038);
            }
        }

        public a(Handler handler, e eVar) {
            AppMethodBeat.i(96043);
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler) : null;
            this.btb = eVar;
            AppMethodBeat.o(96043);
        }

        public final void k(final int i, final long j) {
            AppMethodBeat.i(96044);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                    }
                });
            }
            AppMethodBeat.o(96044);
        }

        public final void c(int i, int i2, int i3, float f) {
            AppMethodBeat.i(96045);
            if (this.btb != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(96040);
                        a.this.btb.b(i4, i5, i6, f2);
                        AppMethodBeat.o(96040);
                    }
                });
            }
            AppMethodBeat.o(96045);
        }

        public final void d(final Surface surface) {
            AppMethodBeat.i(96046);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(96041);
                        a.this.btb.c(surface);
                        AppMethodBeat.o(96041);
                    }
                });
            }
            AppMethodBeat.o(96046);
        }

        public final void e(final d dVar) {
            AppMethodBeat.i(96047);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(96042);
                        a.this.btb.b(dVar);
                        AppMethodBeat.o(96042);
                    }
                });
            }
            AppMethodBeat.o(96047);
        }
    }

    void a(d dVar);

    void b(int i, int i2, int i3, float f);

    void b(d dVar);

    void c(Surface surface);

    void c(Format format);
}
