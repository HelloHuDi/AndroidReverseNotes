package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C44492dg;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hy */
public class C36518hy {
    /* renamed from: a */
    private C31061iz f15382a;
    /* renamed from: b */
    private C44492dg f15383b;
    /* renamed from: c */
    private int f15384c = 0;
    /* renamed from: d */
    private C5889a f15385d;
    /* renamed from: e */
    private boolean f15386e = false;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hy$a */
    class C5889a {
        /* renamed from: a */
        final /* synthetic */ C36518hy f1634a;
        /* renamed from: b */
        private float f1635b = 0.0f;
        /* renamed from: c */
        private float f1636c = 0.0f;
        /* renamed from: d */
        private float f1637d = 0.0f;
        /* renamed from: e */
        private float f1638e = 0.0f;
        /* renamed from: f */
        private int f1639f = -1;
        /* renamed from: g */
        private int f1640g = 1;
        /* renamed from: h */
        private int f1641h = 0;
        /* renamed from: i */
        private float f1642i = 0.0f;
        /* renamed from: j */
        private float f1643j = 0.0f;
        /* renamed from: k */
        private int f1644k = 0;
        /* renamed from: l */
        private boolean f1645l = false;
        /* renamed from: m */
        private Handler f1646m = new C58901();

        /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hy$a$1 */
        class C58901 extends Handler {
            C58901() {
            }

            public void handleMessage(Message message) {
                AppMethodBeat.m2504i(99689);
                C5889a.this.f1643j = C5889a.this.f1643j + C5889a.this.f1642i;
                C36518hy.m60446a(C5889a.this.f1634a, C5889a.this.f1635b, C5889a.this.f1636c, C5889a.this.f1637d, C5889a.this.f1643j);
                if (C5889a.this.f1644k = C5889a.this.f1644k + 1 < C5889a.this.f1640g - 1) {
                    C5889a.this.f1646m.sendEmptyMessageDelayed(0, (long) C5889a.this.f1641h);
                    AppMethodBeat.m2505o(99689);
                } else if (C5889a.this.f1645l) {
                    C36518hy.m60445a(C5889a.this.f1634a);
                    C5889a.m9137k(C5889a.this);
                    AppMethodBeat.m2505o(99689);
                } else {
                    C36518hy.m60446a(C5889a.this.f1634a, C5889a.this.f1635b, C5889a.this.f1636c, C5889a.this.f1637d, C5889a.this.f1638e);
                    AppMethodBeat.m2505o(99689);
                }
            }
        }

        /* renamed from: k */
        static /* synthetic */ void m9137k(C5889a c5889a) {
            AppMethodBeat.m2504i(99696);
            c5889a.m9128b();
            AppMethodBeat.m2505o(99696);
        }

        C5889a(C36518hy c36518hy, int i, int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9 = 0;
            int i10 = 255;
            this.f1634a = c36518hy;
            AppMethodBeat.m2504i(99690);
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
            this.f1635b = ((float) i7) / 255.0f;
            this.f1636c = ((float) i8) / 255.0f;
            this.f1637d = ((float) i6) / 255.0f;
            this.f1638e = ((float) i10) / 255.0f;
            this.f1639f = i5;
            AppMethodBeat.m2505o(99690);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo12496a(long j) {
            AppMethodBeat.m2504i(99691);
            this.f1645l = false;
            m9126a(0.0f, this.f1638e, j);
            AppMethodBeat.m2505o(99691);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public void mo12497b(long j) {
            AppMethodBeat.m2504i(99692);
            this.f1645l = true;
            m9126a(this.f1643j, 0.0f, j);
            AppMethodBeat.m2505o(99692);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo12495a() {
            AppMethodBeat.m2504i(99693);
            if (this.f1646m != null) {
                this.f1646m.removeMessages(0);
            }
            AppMethodBeat.m2505o(99693);
        }

        /* renamed from: a */
        private void m9126a(float f, float f2, long j) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.m2504i(99694);
            if (this.f1646m == null) {
                AppMethodBeat.m2505o(99694);
                return;
            }
            float f5;
            mo12495a();
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
            this.f1640g = 1;
            if (j > 0) {
                this.f1640g = (int) (50 * (j / 1000));
            }
            if (this.f1640g == 0) {
                this.f1640g = 1;
            }
            this.f1641h = (int) (j / ((long) this.f1640g));
            this.f1642i = (f3 - f5) / ((float) this.f1640g);
            this.f1643j = f5;
            this.f1644k = 0;
            this.f1646m.sendEmptyMessage(0);
            AppMethodBeat.m2505o(99694);
        }

        /* renamed from: b */
        private void m9128b() {
            AppMethodBeat.m2504i(99695);
            this.f1646m = null;
            this.f1634a.mo57755b();
            AppMethodBeat.m2505o(99695);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m60446a(C36518hy c36518hy, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(99703);
        c36518hy.m60443a(f, f2, f3, f4);
        AppMethodBeat.m2505o(99703);
    }

    public C36518hy(C31061iz c31061iz, C44492dg c44492dg) {
        this.f15382a = c31061iz;
        this.f15383b = c44492dg;
    }

    /* renamed from: a */
    public boolean mo57753a() {
        AppMethodBeat.m2504i(99697);
        if (this.f15383b == null) {
            AppMethodBeat.m2505o(99697);
            return false;
        }
        int a = this.f15383b.mo70807a();
        if (this.f15385d == null) {
            this.f15385d = new C5889a(this, mo57754b(a), m60447c(a), m60448d(a), m60450e(a), -1);
        }
        this.f15385d.mo12496a(this.f15383b.mo70808b());
        AppMethodBeat.m2505o(99697);
        return true;
    }

    /* renamed from: a */
    public void mo57751a(long j) {
        AppMethodBeat.m2504i(99698);
        if (j <= 0 || this.f15385d == null) {
            if (this.f15385d != null) {
                this.f15385d.mo12495a();
            }
            m60449d();
            mo57755b();
            AppMethodBeat.m2505o(99698);
            return;
        }
        this.f15385d.mo12497b(j);
        AppMethodBeat.m2505o(99698);
    }

    /* renamed from: b */
    public void mo57755b() {
        this.f15385d = null;
        this.f15382a = null;
        this.f15383b = null;
    }

    /* renamed from: a */
    public void mo57750a(int i) {
    }

    /* renamed from: a */
    public void mo57752a(boolean z) {
        AppMethodBeat.m2504i(99699);
        this.f15386e = z;
        if (z) {
            mo57753a();
            AppMethodBeat.m2505o(99699);
            return;
        }
        m60449d();
        AppMethodBeat.m2505o(99699);
    }

    /* renamed from: c */
    public boolean mo57756c() {
        return this.f15386e;
    }

    /* renamed from: b */
    public int mo57754b(int i) {
        return (i >> 16) & 255;
    }

    /* renamed from: c */
    private int m60447c(int i) {
        return (i >> 8) & 255;
    }

    /* renamed from: d */
    private int m60448d(int i) {
        return i & 255;
    }

    /* renamed from: e */
    private int m60450e(int i) {
        return (i >> 24) & 255;
    }

    /* renamed from: a */
    private void m60444a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99700);
        if (!(this.f15382a == null || this.f15383b == null)) {
            this.f15384c = this.f15382a.mo75386b().mo20150a(i, i2, i3, i4, -1, (float) this.f15383b.mo70809c());
            this.f15382a.mo75389h();
        }
        AppMethodBeat.m2505o(99700);
    }

    /* renamed from: a */
    private void m60443a(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(99701);
        if (this.f15382a == null) {
            AppMethodBeat.m2505o(99701);
            return;
        }
        if (this.f15384c <= 0) {
            m60444a((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f), 0);
        }
        this.f15382a.mo75386b().mo20192b(this.f15384c, (int) (f4 * 255.0f));
        this.f15382a.mo75386b().mo20154a();
        AppMethodBeat.m2505o(99701);
    }

    /* renamed from: d */
    private void m60449d() {
        AppMethodBeat.m2504i(99702);
        if (this.f15382a != null) {
            this.f15382a.mo75386b().mo20217e(this.f15384c);
            this.f15382a.mo75386b().mo20154a();
            this.f15384c = -1;
        }
        AppMethodBeat.m2505o(99702);
    }
}
