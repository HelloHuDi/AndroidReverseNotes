package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class x {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public byte[] eJt;
        public byte[] fIi = new byte[0];
        public int netType;
        public int uin = 0;
        public int vyo;

        public a() {
            AppMethodBeat.i(58866);
            AppMethodBeat.o(58866);
        }

        public final void hB(int i) {
            this.uin = i;
        }

        public final byte[] ZT() {
            AppMethodBeat.i(58867);
            String str = "MicroMsg.MMSyncCheck";
            String str2 = "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.fIi == null ? -1 : this.fIi.length);
            objArr[2] = bo.dpG();
            ab.d(str, str2, objArr);
            byte[] bArr;
            if (this.uin == 0 || bo.cb(this.fIi)) {
                bArr = new byte[0];
                AppMethodBeat.o(58867);
                return bArr;
            }
            int length = (((this.uin >> 13) & 524287) | (this.fIi.length << 19)) ^ 1442968193;
            int length2 = 1442968193 ^ (((this.fIi.length >> 13) & 524287) | (this.uin << 19));
            byte[] bArr2 = new byte[(this.fIi.length + 32)];
            ab.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.fIi.length), Integer.valueOf(length2), Integer.valueOf(bArr2.length));
            bArr2[0] = (byte) ((length >> 24) & 255);
            bArr2[1] = (byte) ((length >> 16) & 255);
            bArr2[2] = (byte) ((length >> 8) & 255);
            bArr2[3] = (byte) (length & 255);
            bArr2[4] = (byte) ((length2 >> 24) & 255);
            bArr2[5] = (byte) ((length2 >> 16) & 255);
            bArr2[6] = (byte) ((length2 >> 8) & 255);
            bArr2[7] = (byte) (length2 & 255);
            System.arraycopy(this.fIi, 0, bArr2, 8, this.fIi.length);
            bArr2[bArr2.length - 24] = (byte) ((d.vxo >> 24) & 255);
            bArr2[bArr2.length - 23] = (byte) ((d.vxo >> 16) & 255);
            bArr2[bArr2.length - 22] = (byte) ((d.vxo >> 8) & 255);
            bArr2[bArr2.length - 21] = (byte) (d.vxo & 255);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            bArr = locale.getBytes();
            System.arraycopy(bArr, 0, bArr2, bArr2.length - 20, bArr.length);
            ab.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bArr));
            bArr2[bArr2.length - 12] = (byte) 0;
            bArr2[bArr2.length - 11] = (byte) 0;
            bArr2[bArr2.length - 10] = (byte) 0;
            bArr2[bArr2.length - 9] = (byte) 2;
            bArr2[bArr2.length - 8] = (byte) ((this.netType >> 24) & 255);
            bArr2[bArr2.length - 7] = (byte) ((this.netType >> 16) & 255);
            bArr2[bArr2.length - 6] = (byte) ((this.netType >> 8) & 255);
            bArr2[bArr2.length - 5] = (byte) (this.netType & 255);
            bArr2[bArr2.length - 4] = (byte) ((this.vyo >> 24) & 255);
            bArr2[bArr2.length - 3] = (byte) ((this.vyo >> 16) & 255);
            bArr2[bArr2.length - 2] = (byte) ((this.vyo >> 8) & 255);
            bArr2[bArr2.length - 1] = (byte) (this.vyo & 255);
            ab.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(bArr2));
            this.eJt = g.y(bArr2);
            AppMethodBeat.o(58867);
            return bArr2;
        }

        public final int ZU() {
            return 0;
        }

        public final int getCmdId() {
            return 205;
        }

        public final boolean dms() {
            return true;
        }

        public final boolean adr() {
            return false;
        }
    }

    public static class b extends e implements c {
        private String cHz = null;
        public byte[] eJt = null;
        public long vyM = 7;
        private byte[] vyN;

        @TargetApi(9)
        public final String dmu() {
            AppMethodBeat.i(58868);
            String str;
            if (this.eJt == null) {
                str = "";
                AppMethodBeat.o(58868);
                return str;
            }
            if (this.cHz == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.vyN, this.eJt);
                if (bo.cb(aesDecrypt)) {
                    str = "";
                    AppMethodBeat.o(58868);
                    return str;
                } else if (VERSION.SDK_INT >= 9) {
                    this.cHz = new String(aesDecrypt, Charset.forName("UTF-8"));
                } else {
                    this.cHz = new String(aesDecrypt);
                }
            }
            str = this.cHz;
            AppMethodBeat.o(58868);
            return str;
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58869);
            if (bArr == null || bArr.length < 12) {
                ab.e("MicroMsg.MMSyncCheck", "dksynccheck err resp buf:" + (bArr == null ? -1 : bArr.length));
                AppMethodBeat.o(58869);
                return -1;
            }
            this.vyM = (long) ((((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24));
            int i = (((bArr[7] & 255) | ((bArr[6] & 255) << 8)) | ((bArr[5] & 255) << 16)) | ((bArr[4] & 255) << 24);
            int i2 = (((bArr[11] & 255) | ((bArr[10] & 255) << 8)) | ((bArr[9] & 255) << 16)) | ((bArr[8] & 255) << 24);
            ab.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", Long.valueOf(this.vyM), Integer.valueOf(i), Integer.valueOf(i2));
            if (i != -3002) {
                this.cHz = "";
                AppMethodBeat.o(58869);
                return i;
            } else if (i2 == bArr.length - 12 || i2 == (bArr.length - 12) - 16) {
                if (i2 == (bArr.length - 12) - 16) {
                    this.eJt = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.eJt, 0, 16);
                }
                this.vyN = new byte[i2];
                System.arraycopy(bArr, 12, this.vyN, 0, i2);
                AppMethodBeat.o(58869);
                return i;
            } else {
                ab.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                AppMethodBeat.o(58869);
                return -1;
            }
        }

        public final int getCmdId() {
            return 1000000205;
        }

        public final boolean dms() {
            return true;
        }
    }
}
