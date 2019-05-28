package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class g {
    public long tVD = -1;
    public long tVE = 0;

    public final byte[] toByteArray() {
        AppMethodBeat.i(51584);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.tVD);
            dataOutputStream.writeLong(this.tVE);
            dataOutputStream.close();
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(51584);
        return toByteArray;
    }

    public final g bz(byte[] bArr) {
        AppMethodBeat.i(51585);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.tVD = dataInputStream.readLong();
            this.tVE = dataInputStream.readLong();
            dataInputStream.close();
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        AppMethodBeat.o(51585);
        return this;
    }
}
