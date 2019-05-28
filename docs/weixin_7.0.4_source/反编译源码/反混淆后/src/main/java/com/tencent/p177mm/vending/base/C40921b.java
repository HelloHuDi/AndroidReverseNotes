package com.tencent.p177mm.vending.base;

import com.tencent.p177mm.vending.base.Vending.C24129c;
import com.tencent.p177mm.vending.base.Vending.C24129c.C16032b;
import com.tencent.p177mm.vending.base.Vending.C46710i;
import com.tencent.p177mm.vending.p640f.C5687a;

/* renamed from: com.tencent.mm.vending.base.b */
public abstract class C40921b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    /* renamed from: a */
    public int f16224a = 5;
    /* renamed from: c */
    public int f16225c = 0;
    private C24133a zXn = new C24133a();

    /* renamed from: com.tencent.mm.vending.base.b$a */
    static final class C24133a {
        /* renamed from: a */
        public int f4447a;
        /* renamed from: b */
        public int f4448b;
        /* renamed from: c */
        boolean f4449c;

        private C24133a() {
            this.f4447a = -1;
            this.f4448b = -1;
            this.f4449c = false;
        }

        /* synthetic */ C24133a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final void mo39936b(int i, int i2) {
            this.f4447a = i;
            this.f4448b = i2;
        }
    }

    /* renamed from: Ep */
    public abstract _Struct mo37601Ep(int i);

    public abstract int dMa();

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ boolean invalidIndex(Object obj) {
        return ((Integer) obj).intValue() < 0;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ void requestIndexImpl(C46710i c46710i, Object obj) {
        Integer num = (Integer) obj;
        int i = this.f16225c;
        if (i > 0) {
            m70942a(Math.min(i - 1, num.intValue()), Math.min(i - 1, num.intValue() + this.f16224a));
            m70942a(Math.max(Math.min(0, num.intValue()), num.intValue()), Math.max(Math.min(0, num.intValue()), num.intValue() - this.f16224a));
        }
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object resolveAsynchronous(Object obj) {
        return mo37601Ep(((Integer) obj).intValue());
    }

    public final <T> T get(int i) {
        if (this.f16225c != 0) {
            return super.get(Integer.valueOf(i));
        }
        C5687a.m8541e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void synchronizing(int i, Object obj) {
        this.f16225c = dMa();
        C5687a.m8542i("Vending.ForwardVending", "the count %s", Integer.valueOf(this.f16225c));
    }

    /* renamed from: a */
    private void m70942a(int i, int i2) {
        int i3;
        int[] iArr;
        int i4 = i >= i2 ? 1 : 0;
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        synchronized (this.zXn) {
            C24133a c24133a = this.zXn;
            if (c24133a.f4449c) {
                int i5 = c24133a.f4447a;
                i3 = c24133a.f4448b;
                if (i5 > max || i3 < min) {
                    if (i5 > max + 1 || i3 < min - 1) {
                        c24133a.mo39936b(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i3) {
                        c24133a.mo39936b(min, max);
                        iArr = new int[]{min, i5 - 1, i3 + 1, max};
                    } else {
                        c24133a.mo39936b(min, i3);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i3) {
                    c24133a.mo39936b(i5, max);
                    iArr = new int[]{i3 + 1, max};
                } else {
                    iArr = null;
                }
            } else {
                c24133a.mo39936b(min, max);
                c24133a.f4449c = true;
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
                    C24129c a = mo75077a();
                    Integer valueOf = Integer.valueOf(i7);
                    if (!a.zXq.get()) {
                        synchronized (a.f4443b) {
                            C16032b c16032b = (C16032b) a.f4442a.get(valueOf);
                            if (c16032b == null || c16032b == C16032b.NIL) {
                                a.f4442a.put(valueOf, C16032b.PENDING);
                                a.f4444e.sendMessage(a.f4444e.obtainMessage(0, valueOf));
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
            C24133a c24133a = this.zXn;
            c24133a.f4447a = -1;
            c24133a.f4448b = -1;
            c24133a.f4449c = false;
        }
    }
}
