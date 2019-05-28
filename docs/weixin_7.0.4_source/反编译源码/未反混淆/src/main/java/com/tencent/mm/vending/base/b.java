package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.c;

public abstract class b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    public int a = 5;
    public int c = 0;
    private a zXn = new a();

    static final class a {
        public int a;
        public int b;
        boolean c;

        private a() {
            this.a = -1;
            this.b = -1;
            this.c = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public abstract _Struct Ep(int i);

    public abstract int dMa();

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ boolean invalidIndex(Object obj) {
        return ((Integer) obj).intValue() < 0;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ void requestIndexImpl(i iVar, Object obj) {
        Integer num = (Integer) obj;
        int i = this.c;
        if (i > 0) {
            a(Math.min(i - 1, num.intValue()), Math.min(i - 1, num.intValue() + this.a));
            a(Math.max(Math.min(0, num.intValue()), num.intValue()), Math.max(Math.min(0, num.intValue()), num.intValue() - this.a));
        }
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object resolveAsynchronous(Object obj) {
        return Ep(((Integer) obj).intValue());
    }

    public final <T> T get(int i) {
        if (this.c != 0) {
            return super.get(Integer.valueOf(i));
        }
        com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void synchronizing(int i, Object obj) {
        this.c = dMa();
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "the count %s", Integer.valueOf(this.c));
    }

    private void a(int i, int i2) {
        int i3;
        int[] iArr;
        int i4 = i >= i2 ? 1 : 0;
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        synchronized (this.zXn) {
            a aVar = this.zXn;
            if (aVar.c) {
                int i5 = aVar.a;
                i3 = aVar.b;
                if (i5 > max || i3 < min) {
                    if (i5 > max + 1 || i3 < min - 1) {
                        aVar.b(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i3) {
                        aVar.b(min, max);
                        iArr = new int[]{min, i5 - 1, i3 + 1, max};
                    } else {
                        aVar.b(min, i3);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i3) {
                    aVar.b(i5, max);
                    iArr = new int[]{i3 + 1, max};
                } else {
                    iArr = null;
                }
            } else {
                aVar.b(min, max);
                aVar.c = true;
                iArr = new int[]{min, max};
            }
        }
        if (iArr != null) {
            min = i4 != 0 ? iArr.length - 2 : 0;
            while (true) {
                if (i4 != 0) {
                    if (min < 0) {
                        return;
                    }
                } else if (min >= iArr.length) {
                    return;
                }
                int i6 = iArr[min];
                i3 = iArr[min + 1];
                int abs = Math.abs(i6 - i3);
                for (max = 0; max <= abs; max++) {
                    int i7;
                    if (i4 != 0) {
                        i7 = i3 - max;
                    } else {
                        i7 = i6 + max;
                    }
                    c a = a();
                    Integer valueOf = Integer.valueOf(i7);
                    if (!a.zXq.get()) {
                        synchronized (a.b) {
                            com.tencent.mm.vending.base.Vending.c.b bVar = (com.tencent.mm.vending.base.Vending.c.b) a.a.get(valueOf);
                            if (bVar == null || bVar == com.tencent.mm.vending.base.Vending.c.b.NIL) {
                                a.a.put(valueOf, com.tencent.mm.vending.base.Vending.c.b.PENDING);
                                a.e.sendMessage(a.e.obtainMessage(0, valueOf));
                            }
                        }
                    }
                }
                if (i4 != 0) {
                    min -= 2;
                } else {
                    min += 2;
                }
            }
            while (true) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void loaderClear() {
        synchronized (this.zXn) {
            a aVar = this.zXn;
            aVar.a = -1;
            aVar.b = -1;
            aVar.c = false;
        }
    }
}
