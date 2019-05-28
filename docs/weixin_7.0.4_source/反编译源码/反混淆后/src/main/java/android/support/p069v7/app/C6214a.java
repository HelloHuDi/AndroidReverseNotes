package android.support.p069v7.app;

import android.support.p057v4.widget.DrawerLayout.C0503c;
import android.support.p069v7.p073d.p074a.C0592b;

/* renamed from: android.support.v7.app.a */
public final class C6214a implements C0503c {
    /* renamed from: Tb */
    private final C0573a f1804Tb;
    /* renamed from: Tc */
    private C0592b f1805Tc;
    /* renamed from: Td */
    private boolean f1806Td;
    /* renamed from: Te */
    boolean f1807Te;
    /* renamed from: Tf */
    private final int f1808Tf;
    /* renamed from: Tg */
    private final int f1809Tg;

    /* renamed from: android.support.v7.app.a$a */
    public interface C0573a {
        /* renamed from: bc */
        void mo1392bc(int i);
    }

    /* renamed from: E */
    public final void mo1172E(float f) {
        if (this.f1806Td) {
            setPosition(Math.min(1.0f, Math.max(0.0f, f)));
        } else {
            setPosition(0.0f);
        }
    }

    /* renamed from: eH */
    public final void mo1173eH() {
        setPosition(1.0f);
        if (this.f1807Te) {
            m9983bc(this.f1809Tg);
        }
    }

    /* renamed from: eI */
    public final void mo1174eI() {
        setPosition(0.0f);
        if (this.f1807Te) {
            m9983bc(this.f1808Tf);
        }
    }

    /* renamed from: bc */
    private void m9983bc(int i) {
        this.f1804Tb.mo1392bc(i);
    }

    private void setPosition(float f) {
        if (f == 1.0f) {
            this.f1805Tc.mo1460T(true);
        } else if (f == 0.0f) {
            this.f1805Tc.mo1460T(false);
        }
        this.f1805Tc.setProgress(f);
    }
}
