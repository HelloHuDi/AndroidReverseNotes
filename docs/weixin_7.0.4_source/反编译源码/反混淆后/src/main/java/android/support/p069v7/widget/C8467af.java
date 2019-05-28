package android.support.p069v7.widget;

import android.support.p057v4.p066os.C31862f;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C17480i.C17481a;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: android.support.v7.widget.af */
final class C8467af implements Runnable {
    static final ThreadLocal<C8467af> aiU = new ThreadLocal();
    static Comparator<C8470b> aiZ = new C84681();
    ArrayList<RecyclerView> aiV = new ArrayList();
    long aiW;
    long aiX;
    private ArrayList<C8470b> aiY = new ArrayList();

    /* renamed from: android.support.v7.widget.af$1 */
    static class C84681 implements Comparator<C8470b> {
        C84681() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C8470b c8470b = (C8470b) obj;
            C8470b c8470b2 = (C8470b) obj2;
            if ((c8470b.ajg == null ? 1 : 0) != (c8470b2.ajg == null ? 1 : 0)) {
                if (c8470b.ajg == null) {
                    return 1;
                }
                return -1;
            } else if (c8470b.ajd == c8470b2.ajd) {
                int i = c8470b2.aje - c8470b.aje;
                if (i != 0) {
                    return i;
                }
                i = c8470b.ajf - c8470b2.ajf;
                if (i == 0) {
                    return 0;
                }
                return i;
            } else if (c8470b.ajd) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    /* renamed from: android.support.v7.widget.af$a */
    static class C8469a implements C17481a {
        int aja;
        int ajb;
        int[] ajc;
        int mCount;

        C8469a() {
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo18522a(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.ajc != null) {
                Arrays.fill(this.ajc, -1);
            }
            C17480i c17480i = recyclerView.ank;
            if (recyclerView.f16849Yq != null && c17480i != null && c17480i.aoG) {
                if (z) {
                    if (!recyclerView.ane.mo66569hw()) {
                        c17480i.mo1750a(recyclerView.f16849Yq.getItemCount(), (C17481a) this);
                    }
                } else if (!recyclerView.mo66397jO()) {
                    c17480i.mo1749a(this.aja, this.ajb, recyclerView.anY, (C17481a) this);
                }
                if (this.mCount > c17480i.aoH) {
                    c17480i.aoH = this.mCount;
                    c17480i.aoI = z;
                    recyclerView.anc.mo42380kb();
                }
            }
        }

        /* renamed from: T */
        public final void mo18521T(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.mCount * 2;
                if (this.ajc == null) {
                    this.ajc = new int[4];
                    Arrays.fill(this.ajc, -1);
                } else if (i3 >= this.ajc.length) {
                    int[] iArr = this.ajc;
                    this.ajc = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.ajc, 0, iArr.length);
                }
                this.ajc[i3] = i;
                this.ajc[i3 + 1] = i2;
                this.mCount++;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bM */
        public final boolean mo18523bM(int i) {
            if (this.ajc == null) {
                return false;
            }
            int i2 = this.mCount * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.ajc[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ig */
        public final void mo18524ig() {
            if (this.ajc != null) {
                Arrays.fill(this.ajc, -1);
            }
            this.mCount = 0;
        }
    }

    /* renamed from: android.support.v7.widget.af$b */
    static class C8470b {
        public boolean ajd;
        public int aje;
        public int ajf;
        public RecyclerView ajg;
        public int position;

        C8470b() {
        }
    }

    C8467af() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo18518b(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.aiW == 0) {
            this.aiW = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C8469a c8469a = recyclerView.anX;
        c8469a.aja = i;
        c8469a.ajb = i2;
    }

    /* renamed from: a */
    private static C41531v m15007a(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int hU = recyclerView.anf.mo51996hU();
        for (int i2 = 0; i2 < hU; i2++) {
            C41531v bn = RecyclerView.m72546bn(recyclerView.anf.mo51992bI(i2));
            if (bn.mPosition == i && !bn.mo66461kq()) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            return null;
        }
        C25374o c25374o = recyclerView.anc;
        try {
            recyclerView.mo66404jw();
            C41531v e = c25374o.mo42375e(i, j);
            if (e != null) {
                if (!e.isBound() || e.mo66461kq()) {
                    c25374o.mo42366a(e, false);
                } else {
                    c25374o.mo42367bI(e.apJ);
                }
            }
            recyclerView.mo66341al(false);
            return e;
        } catch (Throwable th) {
            recyclerView.mo66341al(false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0100 A:{Catch:{ all -> 0x019a, all -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a8 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        try {
            C31862f.beginSection("RV Prefetch");
            if (this.aiV.isEmpty()) {
                this.aiW = 0;
                return;
            }
            RecyclerView recyclerView;
            C8470b windowVisibility;
            int size = this.aiV.size();
            long j = 0;
            int i = 0;
            while (i < size) {
                long max;
                recyclerView = (RecyclerView) this.aiV.get(i);
                windowVisibility = recyclerView.getWindowVisibility();
                if (windowVisibility == null) {
                    max = Math.max(recyclerView.getDrawingTime(), j);
                } else {
                    max = j;
                }
                i++;
                j = max;
            }
            if (j == 0) {
                this.aiW = 0;
                C31862f.endSection();
                return;
            }
            int i2;
            int i3;
            i = TimeUnit.MILLISECONDS.toNanos(j) + this.aiX;
            int size2 = this.aiV.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size2) {
                recyclerView = (RecyclerView) this.aiV.get(i5);
                if (recyclerView.getWindowVisibility() == 0) {
                    recyclerView.anX.mo18522a(recyclerView, false);
                    i2 = recyclerView.anX.mCount + i4;
                } else {
                    i2 = i4;
                }
                i5++;
                i4 = i2;
            }
            this.aiY.ensureCapacity(i4);
            i4 = 0;
            for (int i6 = 0; i6 < size2; i6++) {
                recyclerView = (RecyclerView) this.aiV.get(i6);
                if (recyclerView.getWindowVisibility() == 0) {
                    C8469a c8469a = recyclerView.anX;
                    int abs = Math.abs(c8469a.aja) + Math.abs(c8469a.ajb);
                    i5 = i4;
                    for (i3 = 0; i3 < c8469a.mCount * 2; i3 += 2) {
                        C8470b c8470b;
                        if (i5 >= this.aiY.size()) {
                            windowVisibility = new C8470b();
                            this.aiY.add(windowVisibility);
                            c8470b = windowVisibility;
                        } else {
                            c8470b = (C8470b) this.aiY.get(i5);
                        }
                        int i7 = c8469a.ajc[i3 + 1];
                        c8470b.ajd = i7 <= abs;
                        c8470b.aje = abs;
                        c8470b.ajf = i7;
                        c8470b.ajg = recyclerView;
                        c8470b.position = c8469a.ajc[i3];
                        i5++;
                    }
                    i2 = i5;
                } else {
                    i2 = i4;
                }
                i4 = i2;
            }
            Collections.sort(this.aiY, aiZ);
            i3 = 0;
            if (i3 >= this.aiY.size()) {
                windowVisibility = (C8470b) this.aiY.get(i3);
                if (windowVisibility.ajg != null) {
                    C41531v a = C8467af.m15007a(windowVisibility.ajg, windowVisibility.position, windowVisibility.ajd ? Long.MAX_VALUE : i);
                    if (!(a == null || a.apK == null || !a.isBound() || a.mo66461kq())) {
                        recyclerView = (RecyclerView) a.apK.get();
                        if (recyclerView != null) {
                            if (recyclerView.anA && recyclerView.anf.mo51996hU() != 0) {
                                recyclerView.mo66400jj();
                            }
                            C8469a c8469a2 = recyclerView.anX;
                            c8469a2.mo18522a(recyclerView, true);
                            if (c8469a2.mCount != 0) {
                                C31862f.beginSection("RV Nested Prefetch");
                                C31880s c31880s = recyclerView.anY;
                                C41523a c41523a = recyclerView.f16849Yq;
                                c31880s.aps = 1;
                                c31880s.apt = c41523a.getItemCount();
                                c31880s.apv = false;
                                c31880s.apw = false;
                                c31880s.apx = false;
                                for (i5 = 0; i5 < c8469a2.mCount * 2; i5 += 2) {
                                    C8467af.m15007a(recyclerView, c8469a2.ajc[i5], i);
                                }
                            }
                        }
                    }
                    windowVisibility.ajd = false;
                    windowVisibility.aje = 0;
                    windowVisibility.ajf = 0;
                    windowVisibility.ajg = null;
                    windowVisibility.position = 0;
                    i3++;
                    if (i3 >= this.aiY.size()) {
                    }
                }
            }
            this.aiW = 0;
            C31862f.endSection();
        } catch (Throwable th) {
            this.aiW = 0;
        } finally {
            C31862f.endSection();
        }
    }
}
