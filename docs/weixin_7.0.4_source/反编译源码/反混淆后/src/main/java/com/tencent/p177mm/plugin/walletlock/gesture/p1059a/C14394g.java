package com.tencent.p177mm.plugin.walletlock.gesture.p1059a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.a.g */
public final class C14394g {
    public long tVD = -1;
    public long tVE = 0;

    public final byte[] toByteArray() {
        AppMethodBeat.m2504i(51584);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.tVD);
            dataOutputStream.writeLong(this.tVE);
            dataOutputStream.close();
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(51584);
        return toByteArray;
    }

    /* renamed from: bz */
    public final C14394g mo26658bz(byte[] bArr) {
        AppMethodBeat.m2504i(51585);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.tVD = dataInputStream.readLong();
            this.tVE = dataInputStream.readLong();
            dataInputStream.close();
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(51585);
        return this;
    }
}
