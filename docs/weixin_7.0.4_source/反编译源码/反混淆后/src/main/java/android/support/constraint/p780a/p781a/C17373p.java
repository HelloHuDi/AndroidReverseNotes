package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.p781a.C25284e.C25285b;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.p */
public final class C17373p {
    /* renamed from: iJ */
    int f3694iJ;
    /* renamed from: iK */
    int f3695iK;
    /* renamed from: ku */
    ArrayList<C8313a> f3696ku = new ArrayList();
    int mHeight;
    int mWidth;

    /* renamed from: android.support.constraint.a.a.p$a */
    static class C8313a {
        /* renamed from: hy */
        C25284e f2152hy;
        /* renamed from: hz */
        int f2153hz;
        /* renamed from: kc */
        C25284e f2154kc;
        /* renamed from: kv */
        C25285b f2155kv;
        /* renamed from: kw */
        int f2156kw;

        public C8313a(C25284e c25284e) {
            this.f2154kc = c25284e;
            this.f2152hy = c25284e.f5032hy;
            this.f2153hz = c25284e.mo42138aH();
            this.f2155kv = c25284e.f5025hB;
            this.f2156kw = c25284e.f5027hD;
        }
    }

    public C17373p(C17368f c17368f) {
        this.f3694iJ = c17368f.getX();
        this.f3695iK = c17368f.getY();
        this.mWidth = c17368f.getWidth();
        this.mHeight = c17368f.getHeight();
        ArrayList aT = c17368f.mo31464aT();
        int size = aT.size();
        for (int i = 0; i < size; i++) {
            this.f3696ku.add(new C8313a((C25284e) aT.get(i)));
        }
    }
}
