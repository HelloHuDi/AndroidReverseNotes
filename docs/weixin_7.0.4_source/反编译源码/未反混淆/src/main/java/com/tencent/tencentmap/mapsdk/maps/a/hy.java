package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dg;

public class hy {
    private iz a;
    private dg b;
    private int c = 0;
    private a d;
    private boolean e = false;

    class a {
        final /* synthetic */ hy a;
        private float b = 0.0f;
        private float c = 0.0f;
        private float d = 0.0f;
        private float e = 0.0f;
        private int f = -1;
        private int g = 1;
        private int h = 0;
        private float i = 0.0f;
        private float j = 0.0f;
        private int k = 0;
        private boolean l = false;
        private Handler m = new Handler() {
            public void handleMessage(Message message) {
                AppMethodBeat.i(99689);
                a.this.j = a.this.j + a.this.i;
                hy.a(a.this.a, a.this.b, a.this.c, a.this.d, a.this.j);
                if (a.this.k = a.this.k + 1 < a.this.g - 1) {
                    a.this.m.sendEmptyMessageDelayed(0, (long) a.this.h);
                    AppMethodBeat.o(99689);
                } else if (a.this.l) {
                    hy.a(a.this.a);
                    a.k(a.this);
                    AppMethodBeat.o(99689);
                } else {
                    hy.a(a.this.a, a.this.b, a.this.c, a.this.d, a.this.e);
                    AppMethodBeat.o(99689);
                }
            }
        };

        static /* synthetic */ void k(a aVar) {
            AppMethodBeat.i(99696);
            aVar.b();
            AppMethodBeat.o(99696);
        }

        a(hy hyVar, int i, int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9 = 0;
            int i10 = 255;
            this.a = hyVar;
            AppMethodBeat.i(99690);
            if (i < 0) {
                i6 = 0;
            } else {
                i6 = i;
            }
            if (i6 > 255) {
                i7 = 255;
            } else {
                i7 = i6;
            }
            if (i2 < 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if (i6 > 255) {
                i8 = 255;
            } else {
                i8 = i6;
            }
            if (i3 < 0) {
                i6 = 0;
            } else {
                i6 = i3;
            }
            if (i6 > 255) {
                i6 = 255;
            }
            if (i4 >= 0) {
                i9 = i4;
            }
            if (i9 <= 255) {
                i10 = i9;
            }
            this.b = ((float) i7) / 255.0f;
            this.c = ((float) i8) / 255.0f;
            this.d = ((float) i6) / 255.0f;
            this.e = ((float) i10) / 255.0f;
            this.f = i5;
            AppMethodBeat.o(99690);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(long j) {
            AppMethodBeat.i(99691);
            this.l = false;
            a(0.0f, this.e, j);
            AppMethodBeat.o(99691);
        }

        /* Access modifiers changed, original: 0000 */
        public void b(long j) {
            AppMethodBeat.i(99692);
            this.l = true;
            a(this.j, 0.0f, j);
            AppMethodBeat.o(99692);
        }

        /* Access modifiers changed, original: 0000 */
        public void a() {
            AppMethodBeat.i(99693);
            if (this.m != null) {
                this.m.removeMessages(0);
            }
            AppMethodBeat.o(99693);
        }

        private void a(float f, float f2, long j) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.i(99694);
            if (this.m == null) {
                AppMethodBeat.o(99694);
                return;
            }
            float f5;
            a();
            if (f < 0.0f) {
                f5 = 0.0f;
            } else {
                f5 = f;
            }
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
            if (f2 >= 0.0f) {
                f4 = f2;
            }
            if (f4 <= 1.0f) {
                f3 = f4;
            }
            if (j < 0) {
                j = 0;
            }
            this.g = 1;
            if (j > 0) {
                this.g = (int) (50 * (j / 1000));
            }
            if (this.g == 0) {
                this.g = 1;
            }
            this.h = (int) (j / ((long) this.g));
            this.i = (f3 - f5) / ((float) this.g);
            this.j = f5;
            this.k = 0;
            this.m.sendEmptyMessage(0);
            AppMethodBeat.o(99694);
        }

        private void b() {
            AppMethodBeat.i(99695);
            this.m = null;
            this.a.b();
            AppMethodBeat.o(99695);
        }
    }

    static /* synthetic */ void a(hy hyVar, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(99703);
        hyVar.a(f, f2, f3, f4);
        AppMethodBeat.o(99703);
    }

    public hy(iz izVar, dg dgVar) {
        this.a = izVar;
        this.b = dgVar;
    }

    public boolean a() {
        AppMethodBeat.i(99697);
        if (this.b == null) {
            AppMethodBeat.o(99697);
            return false;
        }
        int a = this.b.a();
        if (this.d == null) {
            this.d = new a(this, b(a), c(a), d(a), e(a), -1);
        }
        this.d.a(this.b.b());
        AppMethodBeat.o(99697);
        return true;
    }

    public void a(long j) {
        AppMethodBeat.i(99698);
        if (j <= 0 || this.d == null) {
            if (this.d != null) {
                this.d.a();
            }
            d();
            b();
            AppMethodBeat.o(99698);
            return;
        }
        this.d.b(j);
        AppMethodBeat.o(99698);
    }

    public void b() {
        this.d = null;
        this.a = null;
        this.b = null;
    }

    public void a(int i) {
    }

    public void a(boolean z) {
        AppMethodBeat.i(99699);
        this.e = z;
        if (z) {
            a();
            AppMethodBeat.o(99699);
            return;
        }
        d();
        AppMethodBeat.o(99699);
    }

    public boolean c() {
        return this.e;
    }

    public int b(int i) {
        return (i >> 16) & 255;
    }

    private int c(int i) {
        return (i >> 8) & 255;
    }

    private int d(int i) {
        return i & 255;
    }

    private int e(int i) {
        return (i >> 24) & 255;
    }

    private void a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99700);
        if (!(this.a == null || this.b == null)) {
            this.c = this.a.b().a(i, i2, i3, i4, -1, (float) this.b.c());
            this.a.h();
        }
        AppMethodBeat.o(99700);
    }

    private void a(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(99701);
        if (this.a == null) {
            AppMethodBeat.o(99701);
            return;
        }
        if (this.c <= 0) {
            a((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f), 0);
        }
        this.a.b().b(this.c, (int) (f4 * 255.0f));
        this.a.b().a();
        AppMethodBeat.o(99701);
    }

    private void d() {
        AppMethodBeat.i(99702);
        if (this.a != null) {
            this.a.b().e(this.c);
            this.a.b().a();
            this.c = -1;
        }
        AppMethodBeat.o(99702);
    }
}
