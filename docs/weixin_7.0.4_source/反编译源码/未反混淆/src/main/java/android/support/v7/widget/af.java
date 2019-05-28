package android.support.v7.widget;

import android.support.v4.os.f;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class af implements Runnable {
    static final ThreadLocal<af> aiU = new ThreadLocal();
    static Comparator<b> aiZ = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            b bVar = (b) obj;
            b bVar2 = (b) obj2;
            if ((bVar.ajg == null ? 1 : 0) != (bVar2.ajg == null ? 1 : 0)) {
                if (bVar.ajg == null) {
                    return 1;
                }
                return -1;
            } else if (bVar.ajd == bVar2.ajd) {
                int i = bVar2.aje - bVar.aje;
                if (i != 0) {
                    return i;
                }
                i = bVar.ajf - bVar2.ajf;
                if (i == 0) {
                    return 0;
                }
                return i;
            } else if (bVar.ajd) {
                return -1;
            } else {
                return 1;
            }
        }
    };
    ArrayList<RecyclerView> aiV = new ArrayList();
    long aiW;
    long aiX;
    private ArrayList<b> aiY = new ArrayList();

    static class a implements android.support.v7.widget.RecyclerView.i.a {
        int aja;
        int ajb;
        int[] ajc;
        int mCount;

        a() {
        }

        /* Access modifiers changed, original: final */
        public final void a(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.ajc != null) {
                Arrays.fill(this.ajc, -1);
            }
            i iVar = recyclerView.ank;
            if (recyclerView.Yq != null && iVar != null && iVar.aoG) {
                if (z) {
                    if (!recyclerView.ane.hw()) {
                        iVar.a(recyclerView.Yq.getItemCount(), (android.support.v7.widget.RecyclerView.i.a) this);
                    }
                } else if (!recyclerView.jO()) {
                    iVar.a(this.aja, this.ajb, recyclerView.anY, (android.support.v7.widget.RecyclerView.i.a) this);
                }
                if (this.mCount > iVar.aoH) {
                    iVar.aoH = this.mCount;
                    iVar.aoI = z;
                    recyclerView.anc.kb();
                }
            }
        }

        public final void T(int i, int i2) {
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
        public final boolean bM(int i) {
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
        public final void ig() {
            if (this.ajc != null) {
                Arrays.fill(this.ajc, -1);
            }
            this.mCount = 0;
        }
    }

    static class b {
        public boolean ajd;
        public int aje;
        public int ajf;
        public RecyclerView ajg;
        public int position;

        b() {
        }
    }

    af() {
    }

    /* Access modifiers changed, original: final */
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.aiW == 0) {
            this.aiW = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        a aVar = recyclerView.anX;
        aVar.aja = i;
        aVar.ajb = i2;
    }

    private static v a(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int hU = recyclerView.anf.hU();
        for (int i2 = 0; i2 < hU; i2++) {
            v bn = RecyclerView.bn(recyclerView.anf.bI(i2));
            if (bn.mPosition == i && !bn.kq()) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            return null;
        }
        o oVar = recyclerView.anc;
        try {
            recyclerView.jw();
            v e = oVar.e(i, j);
            if (e != null) {
                if (!e.isBound() || e.kq()) {
                    oVar.a(e, false);
                } else {
                    oVar.bI(e.apJ);
                }
            }
            recyclerView.al(false);
            return e;
        } catch (Throwable th) {
            recyclerView.al(false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0100 A:{Catch:{ all -> 0x019a, all -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a8 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        try {
            f.beginSection("RV Prefetch");
            if (this.aiV.isEmpty()) {
                this.aiW = 0;
                return;
            }
            RecyclerView recyclerView;
            b windowVisibility;
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
                f.endSection();
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
                    recyclerView.anX.a(recyclerView, false);
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
                    a aVar = recyclerView.anX;
                    int abs = Math.abs(aVar.aja) + Math.abs(aVar.ajb);
                    i5 = i4;
                    for (i3 = 0; i3 < aVar.mCount * 2; i3 += 2) {
                        b bVar;
                        if (i5 >= this.aiY.size()) {
                            windowVisibility = new b();
                            this.aiY.add(windowVisibility);
                            bVar = windowVisibility;
                        } else {
                            bVar = (b) this.aiY.get(i5);
                        }
                        int i7 = aVar.ajc[i3 + 1];
                        bVar.ajd = i7 <= abs;
                        bVar.aje = abs;
                        bVar.ajf = i7;
                        bVar.ajg = recyclerView;
                        bVar.position = aVar.ajc[i3];
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
                windowVisibility = (b) this.aiY.get(i3);
                if (windowVisibility.ajg != null) {
                    v a = a(windowVisibility.ajg, windowVisibility.position, windowVisibility.ajd ? Long.MAX_VALUE : i);
                    if (!(a == null || a.apK == null || !a.isBound() || a.kq())) {
                        recyclerView = (RecyclerView) a.apK.get();
                        if (recyclerView != null) {
                            if (recyclerView.anA && recyclerView.anf.hU() != 0) {
                                recyclerView.jj();
                            }
                            a aVar2 = recyclerView.anX;
                            aVar2.a(recyclerView, true);
                            if (aVar2.mCount != 0) {
                                f.beginSection("RV Nested Prefetch");
                                s sVar = recyclerView.anY;
                                android.support.v7.widget.RecyclerView.a aVar3 = recyclerView.Yq;
                                sVar.aps = 1;
                                sVar.apt = aVar3.getItemCount();
                                sVar.apv = false;
                                sVar.apw = false;
                                sVar.apx = false;
                                for (i5 = 0; i5 < aVar2.mCount * 2; i5 += 2) {
                                    a(recyclerView, aVar2.ajc[i5], i);
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
            f.endSection();
        } catch (Throwable th) {
            this.aiW = 0;
        } finally {
            f.endSection();
        }
    }
}
