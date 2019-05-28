package android.support.constraint.p780a;

/* renamed from: android.support.constraint.a.g */
final class C41478g {

    /* renamed from: android.support.constraint.a.g$a */
    interface C8314a<T> {
        /* renamed from: aA */
        T mo18098aA();

        /* renamed from: b */
        void mo18099b(T[] tArr, int i);

        boolean release(T t);
    }

    /* renamed from: android.support.constraint.a.g$b */
    static class C31828b<T> implements C8314a<T> {
        /* renamed from: gH */
        private final Object[] f14538gH = new Object[256];
        /* renamed from: gI */
        private int f14539gI;

        C31828b() {
        }

        /* renamed from: aA */
        public final T mo18098aA() {
            if (this.f14539gI <= 0) {
                return null;
            }
            int i = this.f14539gI - 1;
            T t = this.f14538gH[i];
            this.f14538gH[i] = null;
            this.f14539gI--;
            return t;
        }

        public final boolean release(T t) {
            if (this.f14539gI >= this.f14538gH.length) {
                return false;
            }
            this.f14538gH[this.f14539gI] = t;
            this.f14539gI++;
            return true;
        }

        /* renamed from: b */
        public final void mo18099b(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.f14539gI < this.f14538gH.length) {
                    this.f14538gH[this.f14539gI] = t;
                    this.f14539gI++;
                }
            }
        }
    }
}
