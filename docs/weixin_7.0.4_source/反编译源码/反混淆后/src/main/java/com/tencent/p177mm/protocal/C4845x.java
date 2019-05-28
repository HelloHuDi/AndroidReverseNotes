package com.tencent.p177mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.tencent.mm.protocal.x */
public final class C4845x {

    /* renamed from: com.tencent.mm.protocal.x$a */
    public static class C4846a extends C4834d implements C4832b {
        public byte[] eJt;
        public byte[] fIi = new byte[0];
        public int netType;
        public int uin = 0;
        public int vyo;

        public C4846a() {
            AppMethodBeat.m2504i(58866);
            AppMethodBeat.m2505o(58866);
        }

        /* renamed from: hB */
        public final void mo10000hB(int i) {
            this.uin = i;
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            AppMethodBeat.m2504i(58867);
            String str = "MicroMsg.MMSyncCheck";
            String str2 = "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.fIi == null ? -1 : this.fIi.length);
            objArr[2] = C5046bo.dpG();
            C4990ab.m7411d(str, str2, objArr);
            byte[] bArr;
            if (this.uin == 0 || C5046bo.m7540cb(this.fIi)) {
                bArr = new byte[0];
                AppMethodBeat.m2505o(58867);
                return bArr;
            }
            int length = (((this.uin >> 13) & 524287) | (this.fIi.length << 19)) ^ 1442968193;
            int length2 = 1442968193 ^ (((this.fIi.length >> 13) & 524287) | (this.uin << 19));
            byte[] bArr2 = new byte[(this.fIi.length + 32)];
            C4990ab.m7411d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.fIi.length), Integer.valueOf(length2), Integer.valueOf(bArr2.length));
            bArr2[0] = (byte) ((length >> 24) & 255);
            bArr2[1] = (byte) ((length >> 16) & 255);
            bArr2[2] = (byte) ((length >> 8) & 255);
            bArr2[3] = (byte) (length & 255);
            bArr2[4] = (byte) ((length2 >> 24) & 255);
            bArr2[5] = (byte) ((length2 >> 16) & 255);
            bArr2[6] = (byte) ((length2 >> 8) & 255);
            bArr2[7] = (byte) (length2 & 255);
            System.arraycopy(this.fIi, 0, bArr2, 8, this.fIi.length);
            bArr2[bArr2.length - 24] = (byte) ((C7243d.vxo >> 24) & 255);
            bArr2[bArr2.length - 23] = (byte) ((C7243d.vxo >> 16) & 255);
            bArr2[bArr2.length - 22] = (byte) ((C7243d.vxo >> 8) & 255);
            bArr2[bArr2.length - 21] = (byte) (C7243d.vxo & 255);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            bArr = locale.getBytes();
            System.arraycopy(bArr, 0, bArr2, bArr2.length - 20, bArr.length);
            C4990ab.m7410d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bArr));
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
            C4990ab.m7410d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(bArr2));
            this.eJt = C1178g.m2592y(bArr2);
            AppMethodBeat.m2505o(58867);
            return bArr2;
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
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

    /* renamed from: com.tencent.mm.protocal.x$b */
    public static class C4847b extends C4835e implements C4833c {
        private String cHz = null;
        public byte[] eJt = null;
        public long vyM = 7;
        private byte[] vyN;

        @TargetApi(9)
        public final String dmu() {
            AppMethodBeat.m2504i(58868);
            String str;
            if (this.eJt == null) {
                str = "";
                AppMethodBeat.m2505o(58868);
                return str;
            }
            if (this.cHz == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.vyN, this.eJt);
                if (C5046bo.m7540cb(aesDecrypt)) {
                    str = "";
                    AppMethodBeat.m2505o(58868);
                    return str;
                } else if (VERSION.SDK_INT >= 9) {
                    this.cHz = new String(aesDecrypt, Charset.forName("UTF-8"));
                } else {
                    this.cHz = new String(aesDecrypt);
                }
            }
            str = this.cHz;
            AppMethodBeat.m2505o(58868);
            return str;
        }

        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58869);
            if (bArr == null || bArr.length < 12) {
                C4990ab.m7412e("MicroMsg.MMSyncCheck", "dksynccheck err resp buf:" + (bArr == null ? -1 : bArr.length));
                AppMethodBeat.m2505o(58869);
                return -1;
            }
            this.vyM = (long) ((((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24));
            int i = (((bArr[7] & 255) | ((bArr[6] & 255) << 8)) | ((bArr[5] & 255) << 16)) | ((bArr[4] & 255) << 24);
            int i2 = (((bArr[11] & 255) | ((bArr[10] & 255) << 8)) | ((bArr[9] & 255) << 16)) | ((bArr[8] & 255) << 24);
            C4990ab.m7411d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", Long.valueOf(this.vyM), Integer.valueOf(i), Integer.valueOf(i2));
            if (i != -3002) {
                this.cHz = "";
                AppMethodBeat.m2505o(58869);
                return i;
            } else if (i2 == bArr.length - 12 || i2 == (bArr.length - 12) - 16) {
                if (i2 == (bArr.length - 12) - 16) {
                    this.eJt = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.eJt, 0, 16);
                }
                this.vyN = new byte[i2];
                System.arraycopy(bArr, 12, this.vyN, 0, i2);
                AppMethodBeat.m2505o(58869);
                return i;
            } else {
                C4990ab.m7413e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                AppMethodBeat.m2505o(58869);
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
