package android.support.constraint.a.a;

public final class n extends o {
    float value = 0.0f;

    public final void reset() {
        super.reset();
        this.value = 0.0f;
    }

    public final void E(int i) {
        if (this.state == 0 || this.value != ((float) i)) {
            this.value = (float) i;
            if (this.state == 1) {
                invalidate();
            }
            bf();
        }
    }
}
