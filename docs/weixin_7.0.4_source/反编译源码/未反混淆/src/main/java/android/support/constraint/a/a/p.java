package android.support.constraint.a.a;

import android.support.constraint.a.a.e.b;
import java.util.ArrayList;

public final class p {
    int iJ;
    int iK;
    ArrayList<a> ku = new ArrayList();
    int mHeight;
    int mWidth;

    static class a {
        e hy;
        int hz;
        e kc;
        b kv;
        int kw;

        public a(e eVar) {
            this.kc = eVar;
            this.hy = eVar.hy;
            this.hz = eVar.aH();
            this.kv = eVar.hB;
            this.kw = eVar.hD;
        }
    }

    public p(f fVar) {
        this.iJ = fVar.getX();
        this.iK = fVar.getY();
        this.mWidth = fVar.getWidth();
        this.mHeight = fVar.getHeight();
        ArrayList aT = fVar.aT();
        int size = aT.size();
        for (int i = 0; i < size; i++) {
            this.ku.add(new a((e) aT.get(i)));
        }
    }
}
