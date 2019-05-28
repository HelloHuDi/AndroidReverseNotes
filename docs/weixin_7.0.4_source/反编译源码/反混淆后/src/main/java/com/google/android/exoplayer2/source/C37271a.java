package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.a */
public interface C37271a {

    /* renamed from: com.google.android.exoplayer2.source.a$a */
    public static final class C8705a {
        public final C37271a bfZ;
        private final long bga;
        public final Handler handler;

        /* renamed from: com.google.android.exoplayer2.source.a$a$6 */
        class C87096 implements Runnable {
            C87096() {
            }

            public final void run() {
                AppMethodBeat.m2504i(95434);
                C8705a.this.bfZ.mo46629rP();
                AppMethodBeat.m2505o(95434);
            }
        }

        /* renamed from: com.google.android.exoplayer2.source.a$a$5 */
        public class C87105 implements Runnable {
            final /* synthetic */ int bgd;
            final /* synthetic */ Format bge;
            final /* synthetic */ int bgf;
            final /* synthetic */ Object bgg;
            final /* synthetic */ long bgp;

            public C87105(int i, Format format, int i2, Object obj, long j) {
                this.bgd = i;
                this.bge = format;
                this.bgf = i2;
                this.bgg = obj;
                this.bgp = j;
            }

            public final void run() {
                AppMethodBeat.m2504i(95433);
                C8705a.m15442a(C8705a.this, this.bgp);
                AppMethodBeat.m2505o(95433);
            }
        }

        public C8705a(Handler handler, C37271a c37271a) {
            this(handler, c37271a, (byte) 0);
        }

        private C8705a(Handler handler, C37271a c37271a, byte b) {
            AppMethodBeat.m2504i(95435);
            this.handler = c37271a != null ? (Handler) C45039a.checkNotNull(handler) : null;
            this.bfZ = c37271a;
            this.bga = 0;
            AppMethodBeat.m2505o(95435);
        }

        /* renamed from: a */
        public final void mo19260a(C17665i c17665i, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
            AppMethodBeat.m2504i(95436);
            if (this.bfZ != null) {
                final C17665i c17665i2 = c17665i;
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
                        AppMethodBeat.m2504i(95429);
                        C8705a.m15442a(C8705a.this, j4);
                        C8705a.m15442a(C8705a.this, j5);
                        AppMethodBeat.m2505o(95429);
                    }
                });
            }
            AppMethodBeat.m2505o(95436);
        }

        /* renamed from: a */
        public final void mo19263a(C17665i c17665i, long j, long j2, long j3) {
            AppMethodBeat.m2504i(95437);
            mo19261a(c17665i, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            AppMethodBeat.m2505o(95437);
        }

        /* renamed from: a */
        public final void mo19261a(C17665i c17665i, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            AppMethodBeat.m2504i(95438);
            if (this.bfZ != null) {
                final C17665i c17665i2 = c17665i;
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
                        AppMethodBeat.m2504i(95430);
                        C37271a c37271a = C8705a.this.bfZ;
                        C8705a.m15442a(C8705a.this, j6);
                        C8705a.m15442a(C8705a.this, j7);
                        c37271a.mo46628rO();
                        AppMethodBeat.m2505o(95430);
                    }
                });
            }
            AppMethodBeat.m2505o(95438);
        }

        /* renamed from: b */
        public final void mo19266b(C17665i c17665i, long j, long j2, long j3) {
            AppMethodBeat.m2504i(95439);
            mo19265b(c17665i, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
            AppMethodBeat.m2505o(95439);
        }

        /* renamed from: b */
        public final void mo19265b(C17665i c17665i, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            AppMethodBeat.m2504i(95440);
            if (this.bfZ != null) {
                final C17665i c17665i2 = c17665i;
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
                        AppMethodBeat.m2504i(95431);
                        C8705a.m15442a(C8705a.this, j6);
                        C8705a.m15442a(C8705a.this, j7);
                        AppMethodBeat.m2505o(95431);
                    }
                });
            }
            AppMethodBeat.m2505o(95440);
        }

        /* renamed from: a */
        public final void mo19264a(C17665i c17665i, long j, long j2, long j3, IOException iOException, boolean z) {
            AppMethodBeat.m2504i(95441);
            mo19262a(c17665i, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
            AppMethodBeat.m2505o(95441);
        }

        /* renamed from: a */
        public final void mo19262a(C17665i c17665i, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            AppMethodBeat.m2504i(95442);
            if (this.bfZ != null) {
                final C17665i c17665i2 = c17665i;
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
                        AppMethodBeat.m2504i(95432);
                        C37271a c37271a = C8705a.this.bfZ;
                        C17665i c17665i = c17665i2;
                        Format format = format2;
                        C8705a.m15442a(C8705a.this, j6);
                        C8705a.m15442a(C8705a.this, j7);
                        c37271a.mo46627a(c17665i, format, iOException2);
                        AppMethodBeat.m2505o(95432);
                    }
                });
            }
            AppMethodBeat.m2505o(95442);
        }

        /* renamed from: rQ */
        public final void mo19267rQ() {
            AppMethodBeat.m2504i(95443);
            this.handler.post(new C87096());
            AppMethodBeat.m2505o(95443);
        }

        /* renamed from: a */
        static /* synthetic */ long m15442a(C8705a c8705a, long j) {
            AppMethodBeat.m2504i(95444);
            long w = C17628b.m27433w(j);
            if (w == -9223372036854775807L) {
                AppMethodBeat.m2505o(95444);
                return -9223372036854775807L;
            }
            long j2 = c8705a.bga + w;
            AppMethodBeat.m2505o(95444);
            return j2;
        }
    }

    /* renamed from: a */
    void mo46627a(C17665i c17665i, Format format, IOException iOException);

    /* renamed from: rO */
    void mo46628rO();

    /* renamed from: rP */
    void mo46629rP();
}
