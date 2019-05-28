package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C16316o;
import com.tencent.tinker.p668a.p669a.C36542h;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C36543i.C36544e;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a.C59191;
import com.tencent.tinker.p673c.p674a.p675c.C5920a.C59242;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.tinker.c.a.a.a.h */
public final class C41085h extends C46815i<C36542h> {
    private C31086a AzR = null;
    private C36544e AzS = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29594a(C5920a c5920a, Comparable comparable) {
        C36542h c36542h = (C36542h) comparable;
        int[] iArr = c36542h.AxV;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = c5920a.mo12572RL(iArr[i]);
        }
        byte[] bArr = c36542h.AxW;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        C59191 c59191 = new C59191(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        C59242 c59242 = new C59242(byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new C36542h(c36542h.off, c36542h.AxU, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    C16316o.m25140a(c59242, C16316o.m25141b(c59191));
                    break;
                case 2:
                    C16316o.m25144c(c59242, C16316o.m25139a(c59191));
                    break;
                case 3:
                case 4:
                    C16316o.m25140a(c59242, C16316o.m25141b(c59191));
                    C16316o.m25142b(c59242, c5920a.mo12572RL(C16316o.m25143c(c59191)));
                    C16316o.m25142b(c59242, c5920a.mo12573RM(C16316o.m25143c(c59191)));
                    if (read != 4) {
                        break;
                    }
                    C16316o.m25142b(c59242, c5920a.mo12572RL(C16316o.m25143c(c59191)));
                    break;
                case 5:
                case 6:
                    C16316o.m25140a(c59242, C16316o.m25141b(c59191));
                    break;
                case 9:
                    C16316o.m25142b(c59242, c5920a.mo12572RL(C16316o.m25143c(c59191)));
                    break;
                default:
                    break;
            }
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ int mo29598e(Comparable comparable) {
        C36542h c36542h = (C36542h) comparable;
        C31086a c31086a = this.AzR;
        c31086a.size++;
        return this.AzS.mo57808a(c36542h);
    }

    public C41085h(C31093a c31093a, C36543i c36543i, C36543i c36543i2, C7392c c7392c) {
        super(c31093a, c36543i, c7392c);
        if (c36543i2 != null) {
            this.AzR = c36543i2.AxY.AyG;
            this.AzS = c36543i2.mo57798a(this.AzR);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            c7392c.AAY.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C31086a mo29597c(C36543i c36543i) {
        return c36543i.AxY.AyG;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo29595a(C7392c c7392c, int i, int i2) {
        if (i2 >= 0) {
            c7392c.ABm.mo40758RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Comparable mo29593a(C46943a c46943a) {
        return c46943a.dRE();
    }
}
