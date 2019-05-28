package com.tencent.p177mm.plugin.ext.p730c;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.ext.c.d */
public final class C38994d {
    private static SparseArray<byte[]> lQW = new SparseArray(1);

    /* renamed from: com.tencent.mm.plugin.ext.c.d$b */
    public static class C38995b {
        int aIV;
        int aIW;
        byte[] cLa;
        public String cvZ;
        Rect lQX;
        int rotate;

        public C38995b(byte[] bArr, int i, int i2, int i3, Rect rect, String str) {
            this.cLa = bArr;
            this.aIV = i;
            this.aIW = i2;
            this.rotate = i3;
            this.lQX = rect;
            this.cvZ = str;
        }

        public final String toString() {
            AppMethodBeat.m2504i(20413);
            String str = "RetrieveResult{yuvDataLength=" + (this.cLa != null ? Integer.valueOf(this.cLa.length) : BuildConfig.COMMAND) + ", previewWidth=" + this.aIV + ", previewHeight=" + this.aIW + ", rotate=" + this.rotate + ", scanRect=" + this.lQX + ", md5=" + this.cvZ + '}';
            AppMethodBeat.m2505o(20413);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.c.d$c */
    interface C38996c {
        /* renamed from: aG */
        C38995b mo61880aG(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.ext.c.d$a */
    public static class C38997a implements C38996c {
        /* renamed from: aG */
        public final C38995b mo61880aG(String str, boolean z) {
            AppMethodBeat.m2504i(20412);
            if (C5730e.m8628ct(str)) {
                C38995b c = C38994d.m66235c(C5730e.m8632e(str, 0, -1), z);
                AppMethodBeat.m2505o(20412);
                return c;
            }
            C4990ab.m7420w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
            AppMethodBeat.m2505o(20412);
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(20416);
        AppMethodBeat.m2505o(20416);
    }

    static C38996c brV() {
        AppMethodBeat.m2504i(20414);
        C38997a c38997a = new C38997a();
        AppMethodBeat.m2505o(20414);
        return c38997a;
    }

    /* renamed from: aR */
    private static int m66234aR(byte[] bArr) {
        return (((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24);
    }

    /* renamed from: c */
    static /* synthetic */ C38995b m66235c(byte[] bArr, boolean z) {
        String str = null;
        AppMethodBeat.m2504i(20415);
        if (bArr == null || bArr.length <= 14) {
            C4990ab.m7420w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            AppMethodBeat.m2505o(20415);
            return null;
        }
        Object obj;
        if (z) {
            str = C1178g.m2591x(bArr);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, 4, bArr3, 0, 4);
        byte[] bArr4 = new byte[4];
        System.arraycopy(bArr, 8, bArr4, 0, 4);
        byte[] bArr5 = new byte[4];
        System.arraycopy(bArr, 12, bArr5, 0, 4);
        byte[] bArr6 = new byte[4];
        System.arraycopy(bArr, 16, bArr6, 0, 4);
        byte[] bArr7 = new byte[4];
        System.arraycopy(bArr, 20, bArr7, 0, 4);
        byte[] bArr8 = new byte[4];
        System.arraycopy(bArr, 24, bArr8, 0, 4);
        int length = bArr.length - 28;
        Object obj2 = (byte[]) lQW.get(length);
        if (obj2 == null) {
            obj = new byte[length];
            lQW.put(length, obj);
        } else {
            obj = obj2;
        }
        System.arraycopy(bArr, 28, obj, 0, length);
        int aR = C38994d.m66234aR(bArr2);
        int aR2 = C38994d.m66234aR(bArr3);
        length = C38994d.m66234aR(bArr4);
        int aR3 = C38994d.m66234aR(bArr5);
        C4990ab.m7417i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", new C38995b(obj, aR, aR2, C38994d.m66234aR(bArr8), new Rect(length, aR3, C38994d.m66234aR(bArr6) + length, C38994d.m66234aR(bArr7) + aR3), str));
        AppMethodBeat.m2505o(20415);
        return new C38995b(obj, aR, aR2, C38994d.m66234aR(bArr8), new Rect(length, aR3, C38994d.m66234aR(bArr6) + length, C38994d.m66234aR(bArr7) + aR3), str);
    }
}
