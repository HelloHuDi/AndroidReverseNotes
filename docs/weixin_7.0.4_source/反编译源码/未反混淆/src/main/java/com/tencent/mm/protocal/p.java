package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class p {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public int bJt = 0;
        public int cAd = 0;
        public int fQi = 0;
        public String vyw = "";
        public byte[] vyx = new byte[0];

        public a() {
            AppMethodBeat.i(28283);
            AppMethodBeat.o(28283);
        }

        private byte[] dmt() {
            AppMethodBeat.i(28284);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.fQi);
                dataOutputStream.writeShort(this.vyw.getBytes().length);
                dataOutputStream.write(this.vyw.getBytes());
                dataOutputStream.writeShort(this.vyx.length);
                dataOutputStream.write(this.vyx);
                dataOutputStream.close();
            } catch (IOException e) {
                ab.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(28284);
            return toByteArray;
        }

        private byte[] bM(byte[] bArr) {
            AppMethodBeat.i(28285);
            if (bArr == null) {
                AppMethodBeat.o(28285);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(this.cAd);
                dataOutputStream.writeByte(this.bJt);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            } catch (IOException e) {
                ab.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(28285);
            return toByteArray;
        }

        public final byte[] ZT() {
            AppMethodBeat.i(28286);
            byte[] dmt = dmt();
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, dmt, p.akG(this.vye));
            dmt = bM(pByteArray.value);
            AppMethodBeat.o(28286);
            return dmt;
        }

        public final int ZU() {
            return 10;
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean dms() {
            return true;
        }

        public final boolean adr() {
            return false;
        }
    }

    public static class b extends e implements l.c {
        private int bJt;
        private int cAd;
        public byte[] content;
        public String deviceID;
        public String fOt;
        private int fQi;

        public b() {
            AppMethodBeat.i(28287);
            this.fOt = "";
            this.content = new byte[0];
            this.deviceID = "";
            this.cAd = 0;
            this.bJt = 0;
            this.fQi = 0;
            this.fOt = "";
            this.content = new byte[0];
            AppMethodBeat.o(28287);
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean dms() {
            return true;
        }

        private byte[] bN(byte[] bArr) {
            AppMethodBeat.i(28288);
            if (bArr == null || bArr.length < 2) {
                ab.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                AppMethodBeat.o(28288);
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.cAd = dataInputStream.readByte();
                this.bJt = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                ab.d("MicroMsg.MMDirectSend", "cmdId:" + this.cAd + ", flag=" + this.bJt + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
            } catch (IOException e) {
                ab.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
            }
            AppMethodBeat.o(28288);
            return bArr2;
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(28289);
            byte[] akG = p.akG(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (c.b(pByteArray, bN(bArr), akG) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr2[i] = (byte) 0;
                }
                if (c.b(pByteArray, bN(bArr), bArr2) != 0) {
                    ab.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", bo.ca(akG));
                    AppMethodBeat.o(28289);
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                ab.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
            } else {
                IOException iOException;
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                    this.fQi = dataInputStream.readInt();
                    ab.d("MicroMsg.MMDirectSend", "seq=" + this.fQi);
                    short readShort = dataInputStream.readShort();
                    if (readShort < (short) 0) {
                        iOException = new IOException("sender empty");
                        AppMethodBeat.o(28289);
                        throw iOException;
                    }
                    byte[] bArr4 = new byte[readShort];
                    dataInputStream.readFully(bArr4);
                    this.fOt = new String(bArr4);
                    ab.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.fOt);
                    readShort = dataInputStream.readShort();
                    if (readShort < (short) 0) {
                        iOException = new IOException("content empty");
                        AppMethodBeat.o(28289);
                        throw iOException;
                    }
                    this.content = new byte[readShort];
                    dataInputStream.readFully(this.content);
                    ab.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                } catch (IOException iOException2) {
                    ab.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + iOException2.getMessage());
                }
            }
            AppMethodBeat.o(28289);
            return 0;
        }
    }

    static /* synthetic */ byte[] akG(String str) {
        AppMethodBeat.i(28290);
        byte[] bArr = new byte[16];
        System.arraycopy(str.getBytes(), 0, bArr, 0, 15);
        bArr[15] = (byte) 0;
        ab.d("MicroMsg.MMDirectSend", "new direct send: key=%s", bo.ca(g.y(bArr)));
        AppMethodBeat.o(28290);
        return g.y(bArr);
    }
}
