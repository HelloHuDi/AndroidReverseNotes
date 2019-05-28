package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.wear.model.e.r */
public final class C40185r {
    private static AtomicInteger tYM = new AtomicInteger();

    static {
        AppMethodBeat.m2504i(26430);
        AppMethodBeat.m2505o(26430);
    }

    /* renamed from: b */
    public static void m68920b(int i, byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(26429);
        if (z) {
            bArr = C43841a.cUn().tXt.mo56292bC(bArr);
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
            C43841a.cUn().tXt.mo56290bA(byteArrayOutputStream.toByteArray());
            AppMethodBeat.m2505o(26429);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(0), Integer.valueOf(incrementAndGet), Integer.valueOf(i));
            AppMethodBeat.m2505o(26429);
        }
    }
}
