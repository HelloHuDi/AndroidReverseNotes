package android.support.constraint.a.a;

import android.support.constraint.a.c;
import java.util.ArrayList;

public class q extends f {
    protected ArrayList<f> kx = new ArrayList();

    public void reset() {
        this.kx.clear();
        super.reset();
    }

    public final void e(f fVar) {
        this.kx.add(fVar);
        if (fVar.iG != null) {
            ((q) fVar.iG).f(fVar);
        }
        fVar.iG = this;
    }

    public final void f(f fVar) {
        this.kx.remove(fVar);
        fVar.iG = null;
    }

    public final void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.kx.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f) this.kx.get(i3)).setOffset(aQ(), aR());
        }
    }

    public final void aU() {
        super.aU();
        if (this.kx != null) {
            int size = this.kx.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.kx.get(i);
                fVar.setOffset(aO(), aP());
                if (!(fVar instanceof g)) {
                    fVar.aU();
                }
            }
        }
    }

    public void aZ() {
        aU();
        if (this.kx != null) {
            int size = this.kx.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.kx.get(i);
                if (fVar instanceof q) {
                    ((q) fVar).aZ();
                }
            }
        }
    }

    public final void a(c cVar) {
        super.a(cVar);
        int size = this.kx.size();
        for (int i = 0; i < size; i++) {
            ((f) this.kx.get(i)).a(cVar);
        }
    }

    public final void bh() {
        this.kx.clear();
    }
}
