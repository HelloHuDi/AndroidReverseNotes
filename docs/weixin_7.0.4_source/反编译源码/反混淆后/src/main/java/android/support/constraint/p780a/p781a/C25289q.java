package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17375c;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.q */
public class C25289q extends C17368f {
    /* renamed from: kx */
    protected ArrayList<C17368f> f5052kx = new ArrayList();

    public void reset() {
        this.f5052kx.clear();
        super.reset();
    }

    /* renamed from: e */
    public final void mo42149e(C17368f c17368f) {
        this.f5052kx.add(c17368f);
        if (c17368f.f3620iG != null) {
            ((C25289q) c17368f.f3620iG).mo42150f(c17368f);
        }
        c17368f.f3620iG = this;
    }

    /* renamed from: f */
    public final void mo42150f(C17368f c17368f) {
        this.f5052kx.remove(c17368f);
        c17368f.f3620iG = null;
    }

    public final void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.f5052kx.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C17368f) this.f5052kx.get(i3)).setOffset(mo31461aQ(), mo31462aR());
        }
    }

    /* renamed from: aU */
    public final void mo31465aU() {
        super.mo31465aU();
        if (this.f5052kx != null) {
            int size = this.f5052kx.size();
            for (int i = 0; i < size; i++) {
                C17368f c17368f = (C17368f) this.f5052kx.get(i);
                c17368f.setOffset(mo31459aO(), mo31460aP());
                if (!(c17368f instanceof C31242g)) {
                    c17368f.mo31465aU();
                }
            }
        }
    }

    /* renamed from: aZ */
    public void mo42147aZ() {
        mo31465aU();
        if (this.f5052kx != null) {
            int size = this.f5052kx.size();
            for (int i = 0; i < size; i++) {
                C17368f c17368f = (C17368f) this.f5052kx.get(i);
                if (c17368f instanceof C25289q) {
                    ((C25289q) c17368f).mo42147aZ();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo31448a(C17375c c17375c) {
        super.mo31448a(c17375c);
        int size = this.f5052kx.size();
        for (int i = 0; i < size; i++) {
            ((C17368f) this.f5052kx.get(i)).mo31448a(c17375c);
        }
    }

    /* renamed from: bh */
    public final void mo42148bh() {
        this.f5052kx.clear();
    }
}
