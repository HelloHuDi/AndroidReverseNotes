package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String jHS = h.jGM;
    public static final String jHT = h.jGN;
    public static final String jHU = h.jGO;
    public static final String jHV = h.jGP;
    public byte jHW;
    public byte jHX;
    public byte jHY;
    public byte jHZ;
    public byte[] jIa;
    public int jIb;
    public byte jIc;
    public byte jId;
    public byte[] jIe;

    static {
        AppMethodBeat.i(18471);
        AppMethodBeat.o(18471);
    }

    public e() {
        AppMethodBeat.i(18469);
        this.jHc = null;
        this.jHd = 8;
        this.jGw = 16;
        this.jHW = (byte) 0;
        this.jHX = (byte) 0;
        this.jHY = (byte) 0;
        this.jHZ = (byte) 0;
        this.jIa = new byte[]{(byte) 0, (byte) 0};
        this.jIb = -1;
        this.jIc = (byte) 0;
        this.jId = (byte) 0;
        this.jIe = null;
        AppMethodBeat.o(18469);
    }

    public final byte[] aVE() {
        AppMethodBeat.i(18470);
        byte[] bArr;
        if (this.jHc.equalsIgnoreCase(jHS)) {
            bArr = new byte[3];
            System.arraycopy(Byte.valueOf(this.jHW), 0, bArr, 0, 1);
            System.arraycopy(Byte.valueOf(this.jHX), 0, bArr, 1, 1);
            System.arraycopy(Byte.valueOf(this.jHY), 0, bArr, 2, 1);
            AppMethodBeat.o(18470);
            return bArr;
        } else if (this.jHc.equalsIgnoreCase(jHT)) {
            bArr = new byte[1];
            System.arraycopy(Byte.valueOf(this.jHZ), 0, bArr, 0, 1);
            AppMethodBeat.o(18470);
            return bArr;
        } else if (this.jHc.equalsIgnoreCase(jHV)) {
            bArr = new byte[this.jIb];
            byte b = (byte) ((this.jIb >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.jIb & 255)), 0, bArr, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, bArr, 1, 1);
            System.arraycopy(Byte.valueOf(this.jIc), 0, bArr, 2, 1);
            if (this.jIb > 3) {
                System.arraycopy(this.jIe, 0, bArr, 3, this.jIb - 3);
            }
            AppMethodBeat.o(18470);
            return bArr;
        } else {
            AppMethodBeat.o(18470);
            return null;
        }
    }
}
