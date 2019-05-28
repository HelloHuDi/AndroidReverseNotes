package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.AnonymousClass1;
import com.tencent.tinker.c.a.c.a.AnonymousClass2;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class h extends i<com.tencent.tinker.a.a.h> {
    private a AzR = null;
    private e AzS = null;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        int[] iArr = hVar.AxV;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = aVar.RL(iArr[i]);
        }
        byte[] bArr = hVar.AxW;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 512);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new com.tencent.tinker.a.a.h(hVar.off, hVar.AxU, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 2:
                    o.c(anonymousClass2, o.a(anonymousClass1));
                    break;
                case 3:
                case 4:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    o.b(anonymousClass2, aVar.RL(o.c(anonymousClass1)));
                    o.b(anonymousClass2, aVar.RM(o.c(anonymousClass1)));
                    if (read != 4) {
                        break;
                    }
                    o.b(anonymousClass2, aVar.RL(o.c(anonymousClass1)));
                    break;
                case 5:
                case 6:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 9:
                    o.b(anonymousClass2, aVar.RL(o.c(anonymousClass1)));
                    break;
                default:
                    break;
            }
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        a aVar = this.AzR;
        aVar.size++;
        return this.AzS.a(hVar);
    }

    public h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.AzR = iVar2.AxY.AyG;
            this.AzS = iVar2.a(this.AzR);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.AAY.put(i2, i4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a c(i iVar) {
        return iVar.AxY.AyG;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.ABm.RI(i2);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.dRE();
    }
}
