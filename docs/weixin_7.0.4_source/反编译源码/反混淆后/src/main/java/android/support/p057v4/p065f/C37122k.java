package android.support.p057v4.p065f;

/* renamed from: android.support.v4.f.k */
public final class C37122k {

    /* renamed from: android.support.v4.f.k$a */
    public interface C8387a<T> {
        /* renamed from: aA */
        T mo6364aA();

        boolean release(T t);
    }

    /* renamed from: android.support.v4.f.k$b */
    public static class C16505b<T> implements C8387a<T> {
        /* renamed from: gH */
        private final Object[] f3509gH;
        /* renamed from: gI */
        private int f3510gI;

        public C16505b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f3509gH = new Object[i];
        }

        /* renamed from: aA */
        public T mo6364aA() {
            if (this.f3510gI <= 0) {
                return null;
            }
            int i = this.f3510gI - 1;
            T t = this.f3509gH[i];
            this.f3509gH[i] = null;
            this.f3510gI--;
            return t;
        }

        public boolean release(T t) {
            boolean z;
            for (int i = 0; i < this.f3510gI; i++) {
                if (this.f3509gH[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.f3510gI >= this.f3509gH.length) {
                return false;
            } else {
                this.f3509gH[this.f3510gI] = t;
                this.f3510gI++;
                return true;
            }
        }
    }

    /* renamed from: android.support.v4.f.k$c */
    public static class C25335c<T> extends C16505b<T> {
        private final Object mLock = new Object();

        public C25335c(int i) {
            super(i);
        }

        /* renamed from: aA */
        public final T mo6364aA() {
            Object aA;
            synchronized (this.mLock) {
                aA = super.mo6364aA();
            }
            return aA;
        }

        public final boolean release(T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }
}
