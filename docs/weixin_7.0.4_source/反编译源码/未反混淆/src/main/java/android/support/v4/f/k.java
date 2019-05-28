package android.support.v4.f;

public final class k {

    public interface a<T> {
        T aA();

        boolean release(T t);
    }

    public static class b<T> implements a<T> {
        private final Object[] gH;
        private int gI;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.gH = new Object[i];
        }

        public T aA() {
            if (this.gI <= 0) {
                return null;
            }
            int i = this.gI - 1;
            T t = this.gH[i];
            this.gH[i] = null;
            this.gI--;
            return t;
        }

        public boolean release(T t) {
            boolean z;
            for (int i = 0; i < this.gI; i++) {
                if (this.gH[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.gI >= this.gH.length) {
                return false;
            } else {
                this.gH[this.gI] = t;
                this.gI++;
                return true;
            }
        }
    }

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c(int i) {
            super(i);
        }

        public final T aA() {
            Object aA;
            synchronized (this.mLock) {
                aA = super.aA();
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
