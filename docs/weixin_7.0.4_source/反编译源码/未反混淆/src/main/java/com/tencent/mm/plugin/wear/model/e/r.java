package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r {
    private static AtomicInteger tYM = new AtomicInteger();

    static {
        AppMethodBeat.i(26430);
        AppMethodBeat.o(26430);
    }

    public static void b(int i, byte[] bArr, boolean z) {
        AppMethodBeat.i(26429);
        if (z) {
            bArr = a.cUn().tXt.bC(bArr);
        }
        int incrementAndGet = tYM.incrementAndGet();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(incrementAndGet);
            dataOutputStream.writeInt(i);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
            a.cUn().tXt.bA(byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(26429);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(0), Integer.valueOf(incrementAndGet), Integer.valueOf(i));
            AppMethodBeat.o(26429);
        }
    }
}
