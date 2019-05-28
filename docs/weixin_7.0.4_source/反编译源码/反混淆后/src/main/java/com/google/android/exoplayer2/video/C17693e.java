package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.video.e */
public interface C17693e {

    /* renamed from: com.google.android.exoplayer2.video.e$a */
    public static final class C0886a {
        final C17693e btb;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.video.e$a$3 */
        class C08893 implements Runnable {
            final /* synthetic */ Format aPN;

            C08893(Format format) {
                this.aPN = format;
            }

            public final void run() {
                AppMethodBeat.m2504i(96039);
                C0886a.this.btb.mo2637c(this.aPN);
                AppMethodBeat.m2505o(96039);
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$2 */
        class C08912 implements Runnable {
            final /* synthetic */ String aPK;
            final /* synthetic */ long aPL;
            final /* synthetic */ long aPM;

            C08912(String str, long j, long j2) {
                this.aPK = str;
                this.aPL = j;
                this.aPM = j2;
            }

            public final void run() {
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$1 */
        class C08931 implements Runnable {
            final /* synthetic */ C32021d aPI;

            C08931(C32021d c32021d) {
                this.aPI = c32021d;
            }

            public final void run() {
                AppMethodBeat.m2504i(96038);
                C0886a.this.btb.mo2632a(this.aPI);
                AppMethodBeat.m2505o(96038);
            }
        }

        public C0886a(Handler handler, C17693e c17693e) {
            AppMethodBeat.m2504i(96043);
            this.handler = c17693e != null ? (Handler) C45039a.checkNotNull(handler) : null;
            this.btb = c17693e;
            AppMethodBeat.m2505o(96043);
        }

        /* renamed from: k */
        public final void mo2649k(final int i, final long j) {
            AppMethodBeat.m2504i(96044);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                    }
                });
            }
            AppMethodBeat.m2505o(96044);
        }

        /* renamed from: c */
        public final void mo2646c(int i, int i2, int i3, float f) {
            AppMethodBeat.m2504i(96045);
            if (this.btb != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(96040);
                        C0886a.this.btb.mo2633b(i4, i5, i6, f2);
                        AppMethodBeat.m2505o(96040);
                    }
                });
            }
            AppMethodBeat.m2505o(96045);
        }

        /* renamed from: d */
        public final void mo2647d(final Surface surface) {
            AppMethodBeat.m2504i(96046);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(96041);
                        C0886a.this.btb.mo2636c(surface);
                        AppMethodBeat.m2505o(96041);
                    }
                });
            }
            AppMethodBeat.m2505o(96046);
        }

        /* renamed from: e */
        public final void mo2648e(final C32021d c32021d) {
            AppMethodBeat.m2504i(96047);
            if (this.btb != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(96042);
                        C0886a.this.btb.mo2634b(c32021d);
                        AppMethodBeat.m2505o(96042);
                    }
                });
            }
            AppMethodBeat.m2505o(96047);
        }
    }

    /* renamed from: a */
    void mo2632a(C32021d c32021d);

    /* renamed from: b */
    void mo2633b(int i, int i2, int i3, float f);

    /* renamed from: b */
    void mo2634b(C32021d c32021d);

    /* renamed from: c */
    void mo2636c(Surface surface);

    /* renamed from: c */
    void mo2637c(Format format);
}
