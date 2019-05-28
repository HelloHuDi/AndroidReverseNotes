package android.support.constraint.p780a.p781a;

/* renamed from: android.support.constraint.a.a.n */
public final class C17372n extends C25288o {
    float value = 0.0f;

    public final void reset() {
        super.reset();
        this.value = 0.0f;
    }

    /* renamed from: E */
    public final void mo31500E(int i) {
        if (this.state == 0 || this.value != ((float) i)) {
            this.value = (float) i;
            if (this.state == 1) {
                invalidate();
            }
            mo42144bf();
        }
    }
}
