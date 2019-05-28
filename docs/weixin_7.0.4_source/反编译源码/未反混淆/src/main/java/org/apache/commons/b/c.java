package org.apache.commons.b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c {
    private transient a[] BWZ;
    private final float BXa;
    private transient int count;
    private int yrA;

    static class a {
        a BXb;
        final int key;
        final int puf;
        Object value;

        protected a(int i, int i2, Object obj, a aVar) {
            this.puf = i;
            this.key = i2;
            this.value = obj;
            this.BXb = aVar;
        }
    }

    public c() {
        this((byte) 0);
    }

    private c(byte b) {
        AppMethodBeat.i(116954);
        this.BXa = 0.75f;
        this.BWZ = new a[20];
        this.yrA = 15;
        AppMethodBeat.o(116954);
    }

    public final Object v(int i, Object obj) {
        a aVar;
        AppMethodBeat.i(116955);
        a[] aVarArr = this.BWZ;
        int length = (i & BaseClientBuilder.API_PRIORITY_OTHER) % aVarArr.length;
        for (aVar = aVarArr[length]; aVar != null; aVar = aVar.BXb) {
            if (aVar.puf == i) {
                Object obj2 = aVar.value;
                aVar.value = obj;
                AppMethodBeat.o(116955);
                return obj2;
            }
        }
        if (this.count >= this.yrA) {
            length = this.BWZ.length;
            a[] aVarArr2 = this.BWZ;
            int i2 = (length * 2) + 1;
            a[] aVarArr3 = new a[i2];
            this.yrA = (int) (((float) i2) * this.BXa);
            this.BWZ = aVarArr3;
            while (true) {
                int i3 = length - 1;
                if (length <= 0) {
                    break;
                }
                a aVar2 = aVarArr2[i3];
                while (aVar2 != null) {
                    aVar = aVar2.BXb;
                    int i4 = (aVar2.puf & BaseClientBuilder.API_PRIORITY_OTHER) % i2;
                    aVar2.BXb = aVarArr3[i4];
                    aVarArr3[i4] = aVar2;
                    aVar2 = aVar;
                }
                length = i3;
            }
            aVarArr = this.BWZ;
            length = (i & BaseClientBuilder.API_PRIORITY_OTHER) % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.count++;
        AppMethodBeat.o(116955);
        return null;
    }
}
