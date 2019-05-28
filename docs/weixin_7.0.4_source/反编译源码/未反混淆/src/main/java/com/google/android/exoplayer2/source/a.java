package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public interface a {

    public static final class a {
        public final a bfZ;
        private final long bga;
        public final Handler handler;

        /* renamed from: com.google.android.exoplayer2.source.a$a$5 */
        public class AnonymousClass5 implements Runnable {
            final /* synthetic */ int bgd;
            final /* synthetic */ Format bge;
            final /* synthetic */ int bgf;
            final /* synthetic */ Object bgg;
            final /* synthetic */ long bgp;

            public AnonymousClass5(int i, Format format, int i2, Object obj, long j) {
                this.bgd = i;
                this.bge = format;
                this.bgf = i2;
                this.bgg = obj;
                this.bgp = j;
            }

            public final void run() {
                AppMethodBeat.i(95433);
                a.a(a.this, this.bgp);
                AppMethodBeat.o(95433);
            }
        }

        public a(Handler handler, a aVar) {
            this(handler, aVar, (byte) 0);
        }

        private a(Handler handler, a aVar, byte b) {
            AppMethodBeat.i(95435);
            this.handler = aVar != null ? (Handler) com.google.android.exoplayer2.i.a.checkNotNull(handler) : null;
            this.bfZ = aVar;
            this.bga = 0;
            AppMethodBeat.o(95435);
        }

        public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            AppMethodBeat.i(95436);
            if (this.bfZ != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j4 = j;
                final long j5 = j2;
                final long j6 = j3;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(95429);
                        a.a(a.this, j4);
                        a.a(a.this, j5);
                        AppMethodBeat.o(95429);
                    }
                });
            }
            AppMethodBeat.o(95436);
        }

        public final void a(i iVar, long j, long j2, long j3) {
            AppMethodBeat.i(95437);
            a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            AppMethodBeat.o(95437);
        }

        public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            AppMethodBeat.i(95438);
            if (this.bfZ != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(95430);
                        a aVar = a.this.bfZ;
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                        aVar.rO();
                        AppMethodBeat.o(95430);
                    }
                });
            }
            AppMethodBeat.o(95438);
        }

        public final void b(i iVar, long j, long j2, long j3) {
            AppMethodBeat.i(95439);
            b(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            AppMethodBeat.o(95439);
        }

        public final void b(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            AppMethodBeat.i(95440);
            if (this.bfZ != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(95431);
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                        AppMethodBeat.o(95431);
                    }
                });
            }
            AppMethodBeat.o(95440);
        }

        public final void a(i iVar, long j, long j2, long j3, IOException iOException, boolean z) {
            AppMethodBeat.i(95441);
            a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
            AppMethodBeat.o(95441);
        }

        public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            AppMethodBeat.i(95442);
            if (this.bfZ != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                final IOException iOException2 = iOException;
                final boolean z2 = z;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(95432);
                        a aVar = a.this.bfZ;
                        i iVar = iVar2;
                        Format format = format2;
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                        aVar.a(iVar, format, iOException2);
                        AppMethodBeat.o(95432);
                    }
                });
            }
            AppMethodBeat.o(95442);
        }

        public final void rQ() {
            AppMethodBeat.i(95443);
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(95434);
                    a.this.bfZ.rP();
                    AppMethodBeat.o(95434);
                }
            });
            AppMethodBeat.o(95443);
        }

        static /* synthetic */ long a(a aVar, long j) {
            AppMethodBeat.i(95444);
            long w = b.w(j);
            if (w == -9223372036854775807L) {
                AppMethodBeat.o(95444);
                return -9223372036854775807L;
            }
            long j2 = aVar.bga + w;
            AppMethodBeat.o(95444);
            return j2;
        }
    }

    void a(i iVar, Format format, IOException iOException);

    void rO();

    void rP();
}
