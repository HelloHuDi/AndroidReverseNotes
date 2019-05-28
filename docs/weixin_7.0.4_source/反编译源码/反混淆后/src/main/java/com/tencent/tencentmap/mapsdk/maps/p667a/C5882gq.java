package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.PointF;
import com.tencent.map.lib.C1015d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gq */
public class C5882gq implements C44513gf {
    /* renamed from: a */
    private ArrayList<C44513gf> f1608a = new ArrayList();

    public C5882gq() {
        AppMethodBeat.m2504i(99425);
        AppMethodBeat.m2505o(99425);
    }

    /* renamed from: a */
    public synchronized void mo12456a(C44513gf c44513gf) {
        AppMethodBeat.m2504i(99426);
        if (!(c44513gf == null || this.f1608a.contains(c44513gf))) {
            this.f1608a.add(c44513gf);
        }
        AppMethodBeat.m2505o(99426);
    }

    /* renamed from: b */
    public synchronized void mo12461b(C44513gf c44513gf) {
        AppMethodBeat.m2504i(99427);
        this.f1608a.remove(c44513gf);
        AppMethodBeat.m2505o(99427);
    }

    /* renamed from: a */
    public synchronized boolean mo12458a(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99428);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12458a(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99428);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99428);
        return z;
    }

    /* renamed from: b */
    public synchronized boolean mo12463b(float f, float f2) {
        boolean z;
        int size;
        AppMethodBeat.m2504i(99429);
        for (size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12463b(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99429);
                break;
            }
        }
        C1015d.m2288a("notify onSingleTap");
        for (size = this.f1608a.size() - 1; size >= 0; size--) {
            ((C44513gf) this.f1608a.get(size)).mo12455a();
        }
        z = false;
        AppMethodBeat.m2505o(99429);
        return z;
    }

    /* renamed from: a */
    public void mo12455a() {
        AppMethodBeat.m2504i(99430);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            ((C44513gf) this.f1608a.get(size)).mo12455a();
        }
        AppMethodBeat.m2505o(99430);
    }

    /* renamed from: c */
    public synchronized boolean mo12465c(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99431);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12465c(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99431);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99431);
        return z;
    }

    /* renamed from: d */
    public synchronized boolean mo12467d(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99432);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12467d(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99432);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99432);
        return z;
    }

    /* renamed from: e */
    public synchronized boolean mo12468e(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99433);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12468e(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99433);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99433);
        return z;
    }

    /* renamed from: f */
    public synchronized boolean mo12469f(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99434);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12469f(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99434);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99434);
        return z;
    }

    /* renamed from: g */
    public synchronized boolean mo12470g(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99435);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12470g(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99435);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99435);
        return z;
    }

    /* renamed from: h */
    public synchronized boolean mo12471h(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99436);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12471h(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99436);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99436);
        return z;
    }

    /* renamed from: b */
    public synchronized boolean mo12462b() {
        boolean z;
        AppMethodBeat.m2504i(99437);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12462b()) {
                z = true;
                AppMethodBeat.m2505o(99437);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99437);
        return z;
    }

    /* renamed from: c */
    public synchronized boolean mo12464c() {
        boolean z;
        AppMethodBeat.m2504i(99438);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12464c()) {
                z = true;
                AppMethodBeat.m2505o(99438);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99438);
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo12457a(float f) {
        boolean z;
        AppMethodBeat.m2504i(99439);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12457a(f)) {
                z = true;
                AppMethodBeat.m2505o(99439);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99439);
        return z;
    }

    /* renamed from: d */
    public synchronized boolean mo12466d() {
        boolean z;
        AppMethodBeat.m2504i(99440);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12466d()) {
                z = true;
                AppMethodBeat.m2505o(99440);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99440);
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo12460a(PointF pointF, PointF pointF2, float f) {
        boolean z;
        AppMethodBeat.m2504i(99441);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12460a(pointF, pointF2, f)) {
                z = true;
                AppMethodBeat.m2505o(99441);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99441);
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo12459a(PointF pointF, PointF pointF2, double d, double d2) {
        boolean z;
        AppMethodBeat.m2504i(99442);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12459a(pointF, pointF2, d, d2)) {
                z = true;
                AppMethodBeat.m2505o(99442);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99442);
        return z;
    }

    /* renamed from: i */
    public synchronized boolean mo12472i(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99443);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12472i(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99443);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99443);
        return z;
    }

    /* renamed from: j */
    public synchronized boolean mo12473j(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99444);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12473j(f, f2)) {
                z = true;
                AppMethodBeat.m2505o(99444);
                break;
            }
        }
        z = false;
        AppMethodBeat.m2505o(99444);
        return z;
    }

    /* renamed from: k */
    public boolean mo12474k(float f, float f2) {
        AppMethodBeat.m2504i(99445);
        for (int size = this.f1608a.size() - 1; size >= 0; size--) {
            if (((C44513gf) this.f1608a.get(size)).mo12474k(f, f2)) {
                AppMethodBeat.m2505o(99445);
                return true;
            }
        }
        AppMethodBeat.m2505o(99445);
        return false;
    }
}
