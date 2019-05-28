package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

final class c {
    public static final ParcelUuid hFA = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid hFB = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFC = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFD = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFE = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFF = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFG = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFH = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFI = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid[] hFJ = new ParcelUuid[]{hFp, hFq, hFr, hFs, hFu, hFw, hFx, hFy, hFB, hFC, hFF, hFG, hFH};
    public static final ParcelUuid hFp = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFq = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFr = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFs = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFt = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFu = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFv = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFw = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFx = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid hFy = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid hFz = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");

    static {
        AppMethodBeat.i(94308);
        AppMethodBeat.o(94308);
    }

    public static ParcelUuid ai(byte[] bArr) {
        AppMethodBeat.i(94307);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("uuidBytes cannot be null");
            AppMethodBeat.o(94307);
            throw illegalArgumentException;
        }
        int length = bArr.length;
        ParcelUuid parcelUuid;
        if (length != 2 && length != 4 && length != 16) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(length)));
            AppMethodBeat.o(94307);
            throw illegalArgumentException2;
        } else if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            parcelUuid = new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            AppMethodBeat.o(94307);
            return parcelUuid;
        } else {
            long j;
            if (length == 2) {
                j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
            } else {
                j = ((((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8))) + ((long) ((bArr[2] & 255) << 16))) + ((long) ((bArr[3] & 255) << 24));
            }
            parcelUuid = new ParcelUuid(new UUID(hFI.getUuid().getMostSignificantBits() + (j << 32), hFI.getUuid().getLeastSignificantBits()));
            AppMethodBeat.o(94307);
            return parcelUuid;
        }
    }
}
