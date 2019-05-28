package com.tencent.liteav.basic.p1168b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.tencent.liteav.basic.b.a */
public class C17770a {
    /* renamed from: A */
    private long f4077A;
    /* renamed from: B */
    private long f4078B;
    /* renamed from: C */
    private long f4079C;
    /* renamed from: D */
    private long f4080D;
    /* renamed from: E */
    private long f4081E;
    /* renamed from: F */
    private long f4082F;
    /* renamed from: G */
    private ReadWriteLock f4083G;
    /* renamed from: a */
    private C25645b f4084a;
    /* renamed from: b */
    private LinkedList<C25649b> f4085b;
    /* renamed from: c */
    private LinkedList<C25649b> f4086c;
    /* renamed from: d */
    private long f4087d;
    /* renamed from: e */
    private long f4088e;
    /* renamed from: f */
    private volatile boolean f4089f;
    /* renamed from: g */
    private volatile float f4090g;
    /* renamed from: h */
    private long f4091h;
    /* renamed from: i */
    private long f4092i;
    /* renamed from: j */
    private long f4093j;
    /* renamed from: k */
    private long f4094k;
    /* renamed from: l */
    private long f4095l;
    /* renamed from: m */
    private long f4096m;
    /* renamed from: n */
    private long f4097n;
    /* renamed from: o */
    private long f4098o;
    /* renamed from: p */
    private boolean f4099p;
    /* renamed from: q */
    private HandlerThread f4100q;
    /* renamed from: r */
    private Handler f4101r;
    /* renamed from: s */
    private boolean f4102s;
    /* renamed from: t */
    private long f4103t;
    /* renamed from: u */
    private long f4104u;
    /* renamed from: v */
    private volatile long f4105v;
    /* renamed from: w */
    private volatile long f4106w;
    /* renamed from: x */
    private int f4107x;
    /* renamed from: y */
    private int f4108y;
    /* renamed from: z */
    private long f4109z;

    /* renamed from: com.tencent.liteav.basic.b.a$2 */
    class C177722 implements Runnable {
        C177722() {
        }

        public void run() {
            AppMethodBeat.m2504i(66047);
            C17770a.this.f4102s = true;
            C17770a.this.f4078B = TXCTimeUtil.getTimeTick();
            AppMethodBeat.m2505o(66047);
        }
    }

    /* renamed from: com.tencent.liteav.basic.b.a$4 */
    class C177744 implements Runnable {
        C177744() {
        }

        public void run() {
            C25649b d;
            long o;
            AppMethodBeat.m2504i(66067);
            while (C17770a.this.f4085b != null && !C17770a.this.f4085b.isEmpty() && !C17770a.this.f4099p) {
                C17770a.this.mo32876c();
                d = C17770a.m27694d(C17770a.this);
                if (d == null) {
                    break;
                } else if (!(d == null || C17770a.this.f4084a == null)) {
                    C17770a.this.f4084a.mo32918b(d);
                }
            }
            while (!C17770a.this.f4086c.isEmpty() && C17770a.this.f4084a != null) {
                d = (C25649b) C17770a.this.f4086c.getFirst();
                o = C17770a.this.f4084a.mo32934o();
                if (0 == o) {
                    o = C17770a.this.f4105v;
                }
                if (d.f5257g > o) {
                    break;
                }
                C17770a.this.f4084a.mo32922c(d);
                C17770a.this.f4086c.removeFirst();
            }
            long timeTick = TXCTimeUtil.getTimeTick();
            if (timeTick > C17770a.this.f4078B + 200) {
                C17770a.this.f4109z = C17770a.this.f4109z + C17770a.this.mo32877d();
                C17770a.m27705j(C17770a.this);
                o = C17770a.this.mo32878e();
                C17770a.this.f4080D = C17770a.this.f4080D + o;
                C17770a.m27707l(C17770a.this);
                if (C17770a.this.f4081E > 0) {
                    C17770a.this.f4082F = C17770a.this.f4080D / C17770a.this.f4081E;
                }
                if (o > C17770a.this.f4079C) {
                    C17770a.this.f4079C = o;
                }
                C17770a.this.f4078B = timeTick;
            }
            if (C17770a.this.f4102s) {
                C17770a.m27715p(C17770a.this);
            }
            AppMethodBeat.m2505o(66067);
        }
    }

    /* renamed from: com.tencent.liteav.basic.b.a$3 */
    class C177753 implements Runnable {
        C177753() {
        }

        public void run() {
            AppMethodBeat.m2504i(66048);
            C17770a.this.f4102s = false;
            C17770a.m27684a(C17770a.this);
            try {
                Looper.myLooper().quit();
                AppMethodBeat.m2505o(66048);
            } catch (Exception e) {
                AppMethodBeat.m2505o(66048);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m27702g(C17770a c17770a, long j) {
        AppMethodBeat.m2504i(66066);
        c17770a.m27697e(j);
        AppMethodBeat.m2505o(66066);
    }

    /* renamed from: j */
    static /* synthetic */ long m27705j(C17770a c17770a) {
        long j = c17770a.f4077A + 1;
        c17770a.f4077A = j;
        return j;
    }

    /* renamed from: l */
    static /* synthetic */ long m27707l(C17770a c17770a) {
        long j = c17770a.f4081E + 1;
        c17770a.f4081E = j;
        return j;
    }

    /* renamed from: p */
    static /* synthetic */ void m27715p(C17770a c17770a) {
        AppMethodBeat.m2504i(66065);
        c17770a.m27710m();
        AppMethodBeat.m2505o(66065);
    }

    public C17770a() {
        AppMethodBeat.m2504i(66049);
        this.f4084a = null;
        this.f4085b = new LinkedList();
        this.f4086c = new LinkedList();
        this.f4087d = 0;
        this.f4088e = 15;
        this.f4089f = false;
        this.f4090g = 1.0f;
        this.f4091h = 0;
        this.f4092i = 0;
        this.f4093j = 0;
        this.f4094k = 0;
        this.f4095l = 0;
        this.f4096m = 0;
        this.f4097n = 0;
        this.f4098o = 0;
        this.f4099p = false;
        this.f4100q = null;
        this.f4101r = null;
        this.f4102s = false;
        this.f4103t = 20;
        this.f4104u = 0;
        this.f4105v = 0;
        this.f4106w = 0;
        this.f4107x = 0;
        this.f4108y = 0;
        this.f4109z = 0;
        this.f4077A = 0;
        this.f4078B = 0;
        this.f4079C = 0;
        this.f4080D = 0;
        this.f4081E = 0;
        this.f4082F = 0;
        this.f4083G = new ReentrantReadWriteLock();
        this.f4100q = new HandlerThread("VideoJitterBufferHandler");
        this.f4100q.start();
        this.f4083G.writeLock().lock();
        this.f4101r = new Handler(this.f4100q.getLooper());
        this.f4083G.writeLock().unlock();
        AppMethodBeat.m2505o(66049);
    }

    /* renamed from: a */
    public void mo32871a(final C25645b c25645b) {
        AppMethodBeat.m2504i(66050);
        this.f4083G.readLock().lock();
        if (this.f4101r != null) {
            this.f4101r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(66045);
                    C17770a.this.f4084a = c25645b;
                    AppMethodBeat.m2505o(66045);
                }
            });
        }
        this.f4083G.readLock().unlock();
        AppMethodBeat.m2505o(66050);
    }

    /* renamed from: a */
    public void mo32868a() {
        AppMethodBeat.m2504i(66051);
        this.f4083G.readLock().lock();
        if (this.f4101r != null) {
            this.f4101r.post(new C177722());
        }
        this.f4083G.readLock().unlock();
        m27710m();
        AppMethodBeat.m2505o(66051);
    }

    /* renamed from: b */
    public void mo32874b() {
        AppMethodBeat.m2504i(66052);
        this.f4083G.writeLock().lock();
        if (this.f4101r != null) {
            this.f4101r.post(new C177753());
        }
        this.f4101r = null;
        this.f4083G.writeLock().unlock();
        AppMethodBeat.m2505o(66052);
    }

    /* renamed from: l */
    private void m27708l() {
        AppMethodBeat.m2504i(66053);
        this.f4085b.clear();
        this.f4087d = 0;
        this.f4086c.clear();
        this.f4088e = 15;
        this.f4091h = 0;
        this.f4092i = 0;
        this.f4093j = 0;
        this.f4105v = 0;
        this.f4106w = 0;
        this.f4108y = 0;
        this.f4107x = 0;
        this.f4089f = false;
        this.f4090g = 1.0f;
        this.f4094k = 0;
        this.f4098o = 0;
        this.f4095l = 0;
        this.f4096m = 0;
        this.f4079C = 0;
        this.f4080D = 0;
        this.f4081E = 0;
        this.f4082F = 0;
        this.f4099p = false;
        AppMethodBeat.m2505o(66053);
    }

    /* renamed from: a */
    public void mo32873a(boolean z) {
        this.f4099p = z;
    }

    /* renamed from: m */
    private void m27710m() {
        AppMethodBeat.m2504i(66054);
        this.f4083G.readLock().lock();
        if (this.f4101r != null) {
            this.f4101r.postDelayed(new C177744(), this.f4103t);
        }
        this.f4083G.readLock().unlock();
        AppMethodBeat.m2505o(66054);
    }

    /* renamed from: a */
    public void mo32872a(final C25649b c25649b) {
        AppMethodBeat.m2504i(66055);
        if (c25649b == null) {
            AppMethodBeat.m2505o(66055);
            return;
        }
        if (c25649b.f5257g > this.f4106w || c25649b.f5257g + 500 < this.f4106w) {
            this.f4106w = c25649b.f5257g;
        }
        if (this.f4105v > this.f4106w) {
            this.f4105v = this.f4106w;
        }
        if (c25649b.f5252b == 0) {
            this.f4107x = this.f4108y;
            this.f4108y = 1;
        } else if (c25649b.f5252b == 2 || c25649b.f5252b == 1) {
            this.f4108y++;
        }
        this.f4083G.readLock().lock();
        if (this.f4101r != null) {
            this.f4101r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(66046);
                    if (c25649b.f5252b == 6) {
                        C17770a.this.f4086c.add(c25649b);
                        AppMethodBeat.m2505o(66046);
                        return;
                    }
                    C17770a.this.f4085b.add(c25649b);
                    C17770a.this.f4087d = (long) C17770a.this.f4085b.size();
                    if (C17770a.this.f4084a != null) {
                        C17770a.this.f4087d = C17770a.this.f4087d + ((long) C17770a.this.f4084a.mo32935p());
                    }
                    C17770a.m27702g(C17770a.this, c25649b.f5258h);
                    AppMethodBeat.m2505o(66046);
                }
            });
        }
        this.f4083G.readLock().unlock();
        AppMethodBeat.m2505o(66055);
    }

    /* renamed from: n */
    private C25649b m27712n() {
        AppMethodBeat.m2504i(66056);
        if (this.f4085b == null || this.f4085b.isEmpty()) {
            AppMethodBeat.m2505o(66056);
            return null;
        }
        Object obj;
        C25649b c25649b;
        if (this.f4105v > this.f4106w) {
            this.f4105v = this.f4106w;
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.f4094k == 0) {
            obj = 1;
        } else {
            long b;
            c25649b = (C25649b) this.f4085b.getFirst();
            if (c25649b.f5258h > this.f4094k) {
                b = m27686b(c25649b.f5258h - this.f4094k);
            } else {
                long b2 = m27686b(0);
                TXCLog.m15679w("TXCVideoJitterBuffer", "videojitter pull nal with invalid ts, current dts [" + c25649b.f5258h + "] < last dts[ " + this.f4094k + "]!!! decInterval is " + b2);
                b = b2;
            }
            if (this.f4098o + b <= this.f4104u + timeTick) {
                this.f4104u = (this.f4104u + timeTick) - (this.f4098o + b);
                if (this.f4104u > b) {
                    this.f4104u = b;
                }
                int obj2 = 1;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            c25649b = m27713o();
            m27700f(c25649b.f5258h);
            this.f4098o = timeTick;
            AppMethodBeat.m2505o(66056);
            return c25649b;
        }
        AppMethodBeat.m2505o(66056);
        return null;
    }

    /* renamed from: b */
    private long m27686b(long j) {
        long j2 = 500;
        AppMethodBeat.m2504i(66057);
        if (j > 500) {
            j = 500;
        }
        if (j > 0) {
            long o;
            float d;
            if (this.f4084a != null) {
                o = this.f4084a.mo32934o();
            } else {
                o = 0;
            }
            if (o > 0) {
                j2 = 50;
            } else if (this.f4089f) {
                j2 = 200;
            }
            j2 = m27681a(j, j2);
            if (this.f4089f) {
                d = m27692d(j2);
            } else {
                d = m27689c(j2);
            }
            j2 = (long) (((float) j) / d);
            AppMethodBeat.m2505o(66057);
            return j2;
        } else if (this.f4088e > 0) {
            j2 = 1000 / this.f4088e;
            AppMethodBeat.m2505o(66057);
            return j2;
        } else {
            AppMethodBeat.m2505o(66057);
            return 0;
        }
    }

    /* JADX WARNING: Missing block: B:3:0x000f, code skipped:
            if (r6 < r0) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private long m27681a(long j, long j2) {
        long j3;
        if (this.f4088e > 0) {
            j3 = 1000 / this.f4088e;
        }
        j3 = j;
        if (j3 > j2) {
            return j3;
        }
        return j2;
    }

    /* renamed from: c */
    private float m27689c(long j) {
        long j2 = 0;
        AppMethodBeat.m2504i(66058);
        int i = 0;
        if (this.f4084a != null) {
            i = this.f4084a.mo32935p();
        }
        if (i > 24) {
            TXCLog.m15676e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            AppMethodBeat.m2505o(66058);
            return 0.1f;
        }
        long o;
        float f;
        if (this.f4084a != null) {
            o = this.f4084a.mo32934o();
        } else {
            o = 0;
        }
        if (o > 0) {
            f = o >= this.f4105v + j ? o >= (this.f4105v + j) + 200 ? 2.2f : 1.2f : this.f4105v >= o + j ? this.f4105v >= (o + j) + 200 ? 0.5f : 0.9f : 1.0f;
        } else {
            float f2;
            if (this.f4106w > this.f4105v) {
                o = this.f4106w - this.f4105v;
            } else {
                o = 0;
            }
            long j3 = (long) (this.f4090g * 1000.0f);
            if (this.f4084a != null) {
                j2 = this.f4097n * ((long) this.f4084a.mo32935p());
            }
            if (j2 > j3) {
                j3 = j2;
            }
            if (o > j3 + j) {
                f2 = 1.1f;
            } else {
                f2 = 1.0f;
            }
            f = o <= j3 ? 1.0f : f2;
        }
        AppMethodBeat.m2505o(66058);
        return f;
    }

    /* renamed from: d */
    private float m27692d(long j) {
        AppMethodBeat.m2504i(66059);
        float f = 1.0f;
        int i = 0;
        if (this.f4084a != null) {
            i = this.f4084a.mo32935p();
        }
        if (i > 24) {
            TXCLog.m15676e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            AppMethodBeat.m2505o(66059);
            return 0.1f;
        }
        float f2;
        long j2 = 0;
        if (this.f4084a != null) {
            j2 = this.f4084a.mo32934o();
        }
        if (j2 <= 0 || this.f4084a == null || 0 == this.f4084a.mo32933n()) {
            j2 = 0;
            if (this.f4106w > this.f4105v) {
                j2 = this.f4106w - this.f4105v;
            }
            long j3 = (long) (this.f4090g * 1000.0f);
            long j4 = 0;
            if (this.f4084a != null) {
                j4 = this.f4097n * ((long) this.f4084a.mo32935p());
            }
            if (j4 <= j3) {
                j4 = j3;
            }
            if (j2 > j4 + j) {
                f = 1.2f;
            }
            if (j2 <= j4) {
                f2 = 1.0f;
            }
            f2 = f;
        } else if (j2 >= this.f4105v + j) {
            f2 = j2 >= (this.f4105v + j) + 200 ? 2.2f : 1.5f;
        } else {
            if (this.f4105v >= j2 + j) {
                f2 = this.f4105v >= (j2 + j) + 400 ? 1.0f : this.f4105v >= (j2 + j) + 200 ? 0.5f : 0.7f;
            }
            f2 = f;
        }
        AppMethodBeat.m2505o(66059);
        return f2;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public void mo32876c() {
        int i = 0;
        AppMethodBeat.m2504i(66060);
        if (this.f4085b.size() == 0) {
            AppMethodBeat.m2505o(66060);
            return;
        }
        this.f4085b.getFirst();
        this.f4085b.getLast();
        int p;
        if (this.f4084a != null) {
            p = this.f4084a.mo32935p();
        } else {
            p = 0;
        }
        if (!this.f4085b.isEmpty() && p >= 24) {
            int i2;
            int i3 = 0;
            for (i2 = 0; i2 < this.f4085b.size(); i2++) {
                if (((C25649b) this.f4085b.get(i2)).f5252b == 0) {
                    i3 = i2;
                }
            }
            while (true) {
                i2 = i;
                if (!this.f4085b.isEmpty() && i2 < i3) {
                    this.f4094k = ((C25649b) this.f4085b.getFirst()).f5258h;
                    while (!this.f4086c.isEmpty()) {
                        C25649b c25649b = (C25649b) this.f4086c.getFirst();
                        if (c25649b.f5257g > ((C25649b) this.f4085b.getFirst()).f5258h) {
                            break;
                        }
                        this.f4084a.mo32922c(c25649b);
                        this.f4086c.removeFirst();
                    }
                    this.f4085b.removeFirst();
                    i = i2 + 1;
                } else if (i2 > 0) {
                    TXCLog.m15679w("TXCVideoJitterBuffer", "videojitter cache too maney ， so drop " + i2 + " frames");
                }
            }
            if (i2 > 0) {
            }
        }
        AppMethodBeat.m2505o(66060);
    }

    /* renamed from: o */
    private C25649b m27713o() {
        AppMethodBeat.m2504i(66061);
        C25649b c25649b = null;
        if (!this.f4085b.isEmpty()) {
            c25649b = (C25649b) this.f4085b.getFirst();
            this.f4085b.removeFirst();
            this.f4087d = (long) this.f4085b.size();
            if (this.f4084a != null) {
                this.f4087d += (long) this.f4084a.mo32935p();
            }
        }
        AppMethodBeat.m2505o(66061);
        return c25649b;
    }

    /* renamed from: e */
    private void m27697e(long j) {
        if (this.f4093j != 0) {
            if (this.f4092i >= 5) {
                this.f4088e = this.f4091h / this.f4092i;
                if (this.f4088e > 200) {
                    this.f4088e = 200;
                } else if (this.f4088e < 1) {
                    this.f4088e = 1;
                }
                if (this.f4088e >= 30 && this.f4103t != 5) {
                    this.f4103t = 5;
                }
                this.f4091h = 0;
                this.f4092i = 0;
            } else {
                long j2 = j - this.f4093j;
                if (j2 > 0) {
                    this.f4091h = (1000 / j2) + this.f4091h;
                    this.f4092i++;
                }
            }
        }
        this.f4093j = j;
    }

    /* renamed from: f */
    private void m27700f(long j) {
        if (this.f4094k != 0) {
            long j2;
            if (j > this.f4094k) {
                j2 = j - this.f4094k;
                if (j2 > 500) {
                    j2 = 500;
                }
            } else if (this.f4088e > 0) {
                j2 = 1000 / this.f4088e;
            } else {
                j2 = 0;
            }
            this.f4095l = j2 + this.f4095l;
            this.f4096m++;
            if (this.f4096m >= 5) {
                this.f4097n = this.f4095l / this.f4096m;
                if (this.f4097n > 500) {
                    this.f4097n = 500;
                } else if (this.f4097n < 5) {
                    this.f4097n = 5;
                }
                this.f4095l = 0;
                this.f4096m = 0;
            }
        }
        this.f4094k = j;
    }

    /* renamed from: b */
    public void mo32875b(boolean z) {
        this.f4089f = z;
    }

    /* renamed from: a */
    public void mo32869a(float f) {
        this.f4090g = f;
    }

    /* renamed from: a */
    public void mo32870a(long j) {
        this.f4105v = j;
        if (this.f4105v > this.f4106w) {
            this.f4105v = this.f4106w;
        }
    }

    /* renamed from: d */
    public long mo32877d() {
        return this.f4106w - this.f4105v;
    }

    /* renamed from: e */
    public long mo32878e() {
        return this.f4087d;
    }

    /* renamed from: f */
    public long mo32879f() {
        return this.f4105v;
    }

    /* renamed from: g */
    public long mo32881g() {
        return this.f4106w;
    }

    /* renamed from: h */
    public int mo32882h() {
        return this.f4107x;
    }

    /* renamed from: i */
    public long mo32883i() {
        return this.f4079C;
    }

    /* renamed from: j */
    public long mo32884j() {
        return this.f4082F;
    }

    /* renamed from: k */
    public long mo32885k() {
        long j;
        if (this.f4077A != 0) {
            j = this.f4109z / this.f4077A;
        } else {
            j = 0;
        }
        this.f4077A = 0;
        this.f4109z = 0;
        return j;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66062);
        super.finalize();
        try {
            mo32874b();
            AppMethodBeat.m2505o(66062);
        } catch (Exception e) {
            AppMethodBeat.m2505o(66062);
        }
    }
}
