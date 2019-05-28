package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class ae {
    private static ae gep = null;
    private HashMap<Integer, a> geq = new HashMap();

    public interface a {
        int anv();
    }

    public ae() {
        AppMethodBeat.i(58693);
        AppMethodBeat.o(58693);
    }

    public static synchronized ae anu() {
        ae aeVar;
        synchronized (ae.class) {
            AppMethodBeat.i(58694);
            if (gep == null) {
                gep = new ae();
            }
            aeVar = gep;
            AppMethodBeat.o(58694);
        }
        return aeVar;
    }

    public final synchronized int h(int i, byte[] bArr) {
        int i2;
        AppMethodBeat.i(58695);
        a aVar = (a) this.geq.get(Integer.valueOf(i));
        String str = "MicroMsg.PostPushEventHandler";
        String str2 = "postEvent event:%s cb:%s data:%s [%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = aVar;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[3] = bo.dpG();
        ab.i(str, str2, objArr);
        if (aVar == null) {
            String str3 = "MicroMsg.PostPushEventHandler";
            str = "postEvent cb == null  event:%s cb:%s data:%s [%s]";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = aVar;
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[3] = bo.dpG();
            ab.e(str3, str, objArr2);
            i2 = -3;
            AppMethodBeat.o(58695);
        } else {
            i2 = aVar.anv();
            AppMethodBeat.o(58695);
        }
        return i2;
    }
}
