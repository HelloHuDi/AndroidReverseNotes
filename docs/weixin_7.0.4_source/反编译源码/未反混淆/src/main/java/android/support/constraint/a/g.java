package android.support.constraint.a;

final class g {

    interface a<T> {
        T aA();

        void b(T[] tArr, int i);

        boolean release(T t);
    }

    static class b<T> implements a<T> {
        private final Object[] gH = new Object[256];
        private int gI;

        b() {
        }

        public final T aA() {
            if (this.gI <= 0) {
                return null;
            }
            int i = this.gI - 1;
            T t = this.gH[i];
            this.gH[i] = null;
            this.gI--;
            return t;
        }

        public final boolean release(T t) {
            if (this.gI >= this.gH.length) {
                return false;
            }
            this.gH[this.gI] = t;
            this.gI++;
            return true;
        }

        public final void b(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.gI < this.gH.length) {
                    this.gH[this.gI] = t;
                    this.gI++;
                }
            }
        }
    }
}
