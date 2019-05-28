package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1171c;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.protocal.p */
public final class C46518p {

    /* renamed from: com.tencent.mm.protocal.p$a */
    public static class C40498a extends C4834d implements C4832b {
        public int bJt = 0;
        public int cAd = 0;
        public int fQi = 0;
        public String vyw = "";
        public byte[] vyx = new byte[0];

        public C40498a() {
            AppMethodBeat.m2504i(28283);
            AppMethodBeat.m2505o(28283);
        }

        private byte[] dmt() {
            AppMethodBeat.m2504i(28284);
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
                C4990ab.m7412e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(28284);
            return toByteArray;
        }

        /* renamed from: bM */
        private byte[] m69630bM(byte[] bArr) {
            AppMethodBeat.m2504i(28285);
            if (bArr == null) {
                AppMethodBeat.m2505o(28285);
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
                C4990ab.m7412e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.m2505o(28285);
            return toByteArray;
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(28286);
            byte[] dmt = dmt();
            PByteArray pByteArray = new PByteArray();
            C1171c.m2554a(pByteArray, dmt, C46518p.akG(this.vye));
            dmt = m69630bM(pByteArray.value);
            AppMethodBeat.m2505o(28286);
            return dmt;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
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

    /* renamed from: com.tencent.mm.protocal.p$b */
    public static class C46517b extends C4835e implements C4833c {
        private int bJt;
        private int cAd;
        public byte[] content;
        public String deviceID;
        public String fOt;
        private int fQi;

        public C46517b() {
            AppMethodBeat.m2504i(28287);
            this.fOt = "";
            this.content = new byte[0];
            this.deviceID = "";
            this.cAd = 0;
            this.bJt = 0;
            this.fQi = 0;
            this.fOt = "";
            this.content = new byte[0];
            AppMethodBeat.m2505o(28287);
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean dms() {
            return true;
        }

        /* renamed from: bN */
        private byte[] m87806bN(byte[] bArr) {
            AppMethodBeat.m2504i(28288);
            if (bArr == null || bArr.length < 2) {
                C4990ab.m7412e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                AppMethodBeat.m2505o(28288);
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.cAd = dataInputStream.readByte();
                this.bJt = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                C4990ab.m7410d("MicroMsg.MMDirectSend", "cmdId:" + this.cAd + ", flag=" + this.bJt + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
            } catch (IOException e) {
                C4990ab.m7412e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
            }
            AppMethodBeat.m2505o(28288);
            return bArr2;
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(28289);
            byte[] akG = C46518p.akG(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (C1171c.m2555b(pByteArray, m87806bN(bArr), akG) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr2[i] = (byte) 0;
                }
                if (C1171c.m2555b(pByteArray, m87806bN(bArr), bArr2) != 0) {
                    C4990ab.m7413e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", C5046bo.m7539ca(akG));
                    AppMethodBeat.m2505o(28289);
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                C4990ab.m7412e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
            } else {
                IOException iOException;
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                    this.fQi = dataInputStream.readInt();
                    C4990ab.m7410d("MicroMsg.MMDirectSend", "seq=" + this.fQi);
                    short readShort = dataInputStream.readShort();
                    if (readShort < (short) 0) {
                        iOException = new IOException("sender empty");
                        AppMethodBeat.m2505o(28289);
                        throw iOException;
                    }
                    byte[] bArr4 = new byte[readShort];
                    dataInputStream.readFully(bArr4);
                    this.fOt = new String(bArr4);
                    C4990ab.m7410d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.fOt);
                    readShort = dataInputStream.readShort();
                    if (readShort < (short) 0) {
                        iOException = new IOException("content empty");
                        AppMethodBeat.m2505o(28289);
                        throw iOException;
                    }
                    this.content = new byte[readShort];
                    dataInputStream.readFully(this.content);
                    C4990ab.m7410d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                } catch (IOException iOException2) {
                    C4990ab.m7412e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + iOException2.getMessage());
                }
            }
            AppMethodBeat.m2505o(28289);
            return 0;
        }
    }

    static /* synthetic */ byte[] akG(String str) {
        AppMethodBeat.m2504i(28290);
        byte[] bArr = new byte[16];
        System.arraycopy(str.getBytes(), 0, bArr, 0, 15);
        bArr[15] = (byte) 0;
        C4990ab.m7411d("MicroMsg.MMDirectSend", "new direct send: key=%s", C5046bo.m7539ca(C1178g.m2592y(bArr)));
        AppMethodBeat.m2505o(28290);
        return C1178g.m2592y(bArr);
    }
}
