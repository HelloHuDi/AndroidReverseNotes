package com.tencent.liteav.basic.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.basic.g.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a {
    private long A;
    private long B;
    private long C;
    private long D;
    private long E;
    private long F;
    private ReadWriteLock G;
    private b a;
    private LinkedList<b> b;
    private LinkedList<b> c;
    private long d;
    private long e;
    private volatile boolean f;
    private volatile float g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private HandlerThread q;
    private Handler r;
    private boolean s;
    private long t;
    private long u;
    private volatile long v;
    private volatile long w;
    private int x;
    private int y;
    private long z;

    static /* synthetic */ void g(a aVar, long j) {
        AppMethodBeat.i(66066);
        aVar.e(j);
        AppMethodBeat.o(66066);
    }

    static /* synthetic */ long j(a aVar) {
        long j = aVar.A + 1;
        aVar.A = j;
        return j;
    }

    static /* synthetic */ long l(a aVar) {
        long j = aVar.E + 1;
        aVar.E = j;
        return j;
    }

    static /* synthetic */ void p(a aVar) {
        AppMethodBeat.i(66065);
        aVar.m();
        AppMethodBeat.o(66065);
    }

    public a() {
        AppMethodBeat.i(66049);
        this.a = null;
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = 0;
        this.e = 15;
        this.f = false;
        this.g = 1.0f;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = false;
        this.t = 20;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = new ReentrantReadWriteLock();
        this.q = new HandlerThread("VideoJitterBufferHandler");
        this.q.start();
        this.G.writeLock().lock();
        this.r = new Handler(this.q.getLooper());
        this.G.writeLock().unlock();
        AppMethodBeat.o(66049);
    }

    public void a(final b bVar) {
        AppMethodBeat.i(66050);
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66045);
                    a.this.a = bVar;
                    AppMethodBeat.o(66045);
                }
            });
        }
        this.G.readLock().unlock();
        AppMethodBeat.o(66050);
    }

    public void a() {
        AppMethodBeat.i(66051);
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66047);
                    a.this.s = true;
                    a.this.B = TXCTimeUtil.getTimeTick();
                    AppMethodBeat.o(66047);
                }
            });
        }
        this.G.readLock().unlock();
        m();
        AppMethodBeat.o(66051);
    }

    public void b() {
        AppMethodBeat.i(66052);
        this.G.writeLock().lock();
        if (this.r != null) {
            this.r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66048);
                    a.this.s = false;
                    a.a(a.this);
                    try {
                        Looper.myLooper().quit();
                        AppMethodBeat.o(66048);
                    } catch (Exception e) {
                        AppMethodBeat.o(66048);
                    }
                }
            });
        }
        this.r = null;
        this.G.writeLock().unlock();
        AppMethodBeat.o(66052);
    }

    private void l() {
        AppMethodBeat.i(66053);
        this.b.clear();
        this.d = 0;
        this.c.clear();
        this.e = 15;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.v = 0;
        this.w = 0;
        this.y = 0;
        this.x = 0;
        this.f = false;
        this.g = 1.0f;
        this.k = 0;
        this.o = 0;
        this.l = 0;
        this.m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.p = false;
        AppMethodBeat.o(66053);
    }

    public void a(boolean z) {
        this.p = z;
    }

    private void m() {
        AppMethodBeat.i(66054);
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.postDelayed(new Runnable() {
                public void run() {
                    b d;
                    long o;
                    AppMethodBeat.i(66067);
                    while (a.this.b != null && !a.this.b.isEmpty() && !a.this.p) {
                        a.this.c();
                        d = a.d(a.this);
                        if (d == null) {
                            break;
                        } else if (!(d == null || a.this.a == null)) {
                            a.this.a.b(d);
                        }
                    }
                    while (!a.this.c.isEmpty() && a.this.a != null) {
                        d = (b) a.this.c.getFirst();
                        o = a.this.a.o();
                        if (0 == o) {
                            o = a.this.v;
                        }
                        if (d.g > o) {
                            break;
                        }
                        a.this.a.c(d);
                        a.this.c.removeFirst();
                    }
                    long timeTick = TXCTimeUtil.getTimeTick();
                    if (timeTick > a.this.B + 200) {
                        a.this.z = a.this.z + a.this.d();
                        a.j(a.this);
                        o = a.this.e();
                        a.this.D = a.this.D + o;
                        a.l(a.this);
                        if (a.this.E > 0) {
                            a.this.F = a.this.D / a.this.E;
                        }
                        if (o > a.this.C) {
                            a.this.C = o;
                        }
                        a.this.B = timeTick;
                    }
                    if (a.this.s) {
                        a.p(a.this);
                    }
                    AppMethodBeat.o(66067);
                }
            }, this.t);
        }
        this.G.readLock().unlock();
        AppMethodBeat.o(66054);
    }

    public void a(final b bVar) {
        AppMethodBeat.i(66055);
        if (bVar == null) {
            AppMethodBeat.o(66055);
            return;
        }
        if (bVar.g > this.w || bVar.g + 500 < this.w) {
            this.w = bVar.g;
        }
        if (this.v > this.w) {
            this.v = this.w;
        }
        if (bVar.b == 0) {
            this.x = this.y;
            this.y = 1;
        } else if (bVar.b == 2 || bVar.b == 1) {
            this.y++;
        }
        this.G.readLock().lock();
        if (this.r != null) {
            this.r.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66046);
                    if (bVar.b == 6) {
                        a.this.c.add(bVar);
                        AppMethodBeat.o(66046);
                        return;
                    }
                    a.this.b.add(bVar);
                    a.this.d = (long) a.this.b.size();
                    if (a.this.a != null) {
                        a.this.d = a.this.d + ((long) a.this.a.p());
                    }
                    a.g(a.this, bVar.h);
                    AppMethodBeat.o(66046);
                }
            });
        }
        this.G.readLock().unlock();
        AppMethodBeat.o(66055);
    }

    private b n() {
        AppMethodBeat.i(66056);
        if (this.b == null || this.b.isEmpty()) {
            AppMethodBeat.o(66056);
            return null;
        }
        Object obj;
        b bVar;
        if (this.v > this.w) {
            this.v = this.w;
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.k == 0) {
            obj = 1;
        } else {
            long b;
            bVar = (b) this.b.getFirst();
            if (bVar.h > this.k) {
                b = b(bVar.h - this.k);
            } else {
                long b2 = b(0);
                TXCLog.w("TXCVideoJitterBuffer", "videojitter pull nal with invalid ts, current dts [" + bVar.h + "] < last dts[ " + this.k + "]!!! decInterval is " + b2);
                b = b2;
            }
            if (this.o + b <= this.u + timeTick) {
                this.u = (this.u + timeTick) - (this.o + b);
                if (this.u > b) {
                    this.u = b;
                }
                int obj2 = 1;
            } else {
                obj2 = null;
            }
        }
        if (obj2 != null) {
            bVar = o();
            f(bVar.h);
            this.o = timeTick;
            AppMethodBeat.o(66056);
            return bVar;
        }
        AppMethodBeat.o(66056);
        return null;
    }

    private long b(long j) {
        long j2 = 500;
        AppMethodBeat.i(66057);
        if (j > 500) {
            j = 500;
        }
        if (j > 0) {
            long o;
            float d;
            if (this.a != null) {
                o = this.a.o();
            } else {
                o = 0;
            }
            if (o > 0) {
                j2 = 50;
            } else if (this.f) {
                j2 = 200;
            }
            j2 = a(j, j2);
            if (this.f) {
                d = d(j2);
            } else {
                d = c(j2);
            }
            j2 = (long) (((float) j) / d);
            AppMethodBeat.o(66057);
            return j2;
        } else if (this.e > 0) {
            j2 = 1000 / this.e;
            AppMethodBeat.o(66057);
            return j2;
        } else {
            AppMethodBeat.o(66057);
            return 0;
        }
    }

    /* JADX WARNING: Missing block: B:3:0x000f, code skipped:
            if (r6 < r0) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(long j, long j2) {
        long j3;
        if (this.e > 0) {
            j3 = 1000 / this.e;
        }
        j3 = j;
        if (j3 > j2) {
            return j3;
        }
        return j2;
    }

    private float c(long j) {
        long j2 = 0;
        AppMethodBeat.i(66058);
        int i = 0;
        if (this.a != null) {
            i = this.a.p();
        }
        if (i > 24) {
            TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            AppMethodBeat.o(66058);
            return 0.1f;
        }
        long o;
        float f;
        if (this.a != null) {
            o = this.a.o();
        } else {
            o = 0;
        }
        if (o > 0) {
            f = o >= this.v + j ? o >= (this.v + j) + 200 ? 2.2f : 1.2f : this.v >= o + j ? this.v >= (o + j) + 200 ? 0.5f : 0.9f : 1.0f;
        } else {
            float f2;
            if (this.w > this.v) {
                o = this.w - this.v;
            } else {
                o = 0;
            }
            long j3 = (long) (this.g * 1000.0f);
            if (this.a != null) {
                j2 = this.n * ((long) this.a.p());
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
        AppMethodBeat.o(66058);
        return f;
    }

    private float d(long j) {
        AppMethodBeat.i(66059);
        float f = 1.0f;
        int i = 0;
        if (this.a != null) {
            i = this.a.p();
        }
        if (i > 24) {
            TXCLog.e("TXCVideoJitterBuffer", "videojitter pull nal with speed : 0.1");
            AppMethodBeat.o(66059);
            return 0.1f;
        }
        float f2;
        long j2 = 0;
        if (this.a != null) {
            j2 = this.a.o();
        }
        if (j2 <= 0 || this.a == null || 0 == this.a.n()) {
            j2 = 0;
            if (this.w > this.v) {
                j2 = this.w - this.v;
            }
            long j3 = (long) (this.g * 1000.0f);
            long j4 = 0;
            if (this.a != null) {
                j4 = this.n * ((long) this.a.p());
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
        } else if (j2 >= this.v + j) {
            f2 = j2 >= (this.v + j) + 200 ? 2.2f : 1.5f;
        } else {
            if (this.v >= j2 + j) {
                f2 = this.v >= (j2 + j) + 400 ? 1.0f : this.v >= (j2 + j) + 200 ? 0.5f : 0.7f;
            }
            f2 = f;
        }
        AppMethodBeat.o(66059);
        return f2;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        int i = 0;
        AppMethodBeat.i(66060);
        if (this.b.size() == 0) {
            AppMethodBeat.o(66060);
            return;
        }
        this.b.getFirst();
        this.b.getLast();
        int p;
        if (this.a != null) {
            p = this.a.p();
        } else {
            p = 0;
        }
        if (!this.b.isEmpty() && p >= 24) {
            int i2;
            int i3 = 0;
            for (i2 = 0; i2 < this.b.size(); i2++) {
                if (((b) this.b.get(i2)).b == 0) {
                    i3 = i2;
                }
            }
            while (true) {
                i2 = i;
                if (!this.b.isEmpty() && i2 < i3) {
                    this.k = ((b) this.b.getFirst()).h;
                    while (!this.c.isEmpty()) {
                        b bVar = (b) this.c.getFirst();
                        if (bVar.g > ((b) this.b.getFirst()).h) {
                            break;
                        }
                        this.a.c(bVar);
                        this.c.removeFirst();
                    }
                    this.b.removeFirst();
                    i = i2 + 1;
                } else if (i2 > 0) {
                    TXCLog.w("TXCVideoJitterBuffer", "videojitter cache too maney ， so drop " + i2 + " frames");
                }
            }
            if (i2 > 0) {
            }
        }
        AppMethodBeat.o(66060);
    }

    private b o() {
        AppMethodBeat.i(66061);
        b bVar = null;
        if (!this.b.isEmpty()) {
            bVar = (b) this.b.getFirst();
            this.b.removeFirst();
            this.d = (long) this.b.size();
            if (this.a != null) {
                this.d += (long) this.a.p();
            }
        }
        AppMethodBeat.o(66061);
        return bVar;
    }

    private void e(long j) {
        if (this.j != 0) {
            if (this.i >= 5) {
                this.e = this.h / this.i;
                if (this.e > 200) {
                    this.e = 200;
                } else if (this.e < 1) {
                    this.e = 1;
                }
                if (this.e >= 30 && this.t != 5) {
                    this.t = 5;
                }
                this.h = 0;
                this.i = 0;
            } else {
                long j2 = j - this.j;
                if (j2 > 0) {
                    this.h = (1000 / j2) + this.h;
                    this.i++;
                }
            }
        }
        this.j = j;
    }

    private void f(long j) {
        if (this.k != 0) {
            long j2;
            if (j > this.k) {
                j2 = j - this.k;
                if (j2 > 500) {
                    j2 = 500;
                }
            } else if (this.e > 0) {
                j2 = 1000 / this.e;
            } else {
                j2 = 0;
            }
            this.l = j2 + this.l;
            this.m++;
            if (this.m >= 5) {
                this.n = this.l / this.m;
                if (this.n > 500) {
                    this.n = 500;
                } else if (this.n < 5) {
                    this.n = 5;
                }
                this.l = 0;
                this.m = 0;
            }
        }
        this.k = j;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void a(float f) {
        this.g = f;
    }

    public void a(long j) {
        this.v = j;
        if (this.v > this.w) {
            this.v = this.w;
        }
    }

    public long d() {
        return this.w - this.v;
    }

    public long e() {
        return this.d;
    }

    public long f() {
        return this.v;
    }

    public long g() {
        return this.w;
    }

    public int h() {
        return this.x;
    }

    public long i() {
        return this.C;
    }

    public long j() {
        return this.F;
    }

    public long k() {
        long j;
        if (this.A != 0) {
            j = this.z / this.A;
        } else {
            j = 0;
        }
        this.A = 0;
        this.z = 0;
        return j;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(66062);
        super.finalize();
        try {
            b();
            AppMethodBeat.o(66062);
        } catch (Exception e) {
            AppMethodBeat.o(66062);
        }
    }
}
