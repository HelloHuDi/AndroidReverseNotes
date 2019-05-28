package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class d {
    private static SparseArray<byte[]> lQW = new SparseArray(1);

    public static class b {
        int aIV;
        int aIW;
        byte[] cLa;
        public String cvZ;
        Rect lQX;
        int rotate;

        public b(byte[] bArr, int i, int i2, int i3, Rect rect, String str) {
            this.cLa = bArr;
            this.aIV = i;
            this.aIW = i2;
            this.rotate = i3;
            this.lQX = rect;
            this.cvZ = str;
        }

        public final String toString() {
            AppMethodBeat.i(20413);
            String str = "RetrieveResult{yuvDataLength=" + (this.cLa != null ? Integer.valueOf(this.cLa.length) : BuildConfig.COMMAND) + ", previewWidth=" + this.aIV + ", previewHeight=" + this.aIW + ", rotate=" + this.rotate + ", scanRect=" + this.lQX + ", md5=" + this.cvZ + '}';
            AppMethodBeat.o(20413);
            return str;
        }
    }

    interface c {
        b aG(String str, boolean z);
    }

    public static class a implements c {
        public final b aG(String str, boolean z) {
            AppMethodBeat.i(20412);
            if (e.ct(str)) {
                b c = d.c(e.e(str, 0, -1), z);
                AppMethodBeat.o(20412);
                return c;
            }
            ab.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: handle not exist");
            AppMethodBeat.o(20412);
            return null;
        }
    }

    static {
        AppMethodBeat.i(20416);
        AppMethodBeat.o(20416);
    }

    static c brV() {
        AppMethodBeat.i(20414);
        a aVar = new a();
        AppMethodBeat.o(20414);
        return aVar;
    }

    private static int aR(byte[] bArr) {
        return (((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24);
    }

    static /* synthetic */ b c(byte[] bArr, boolean z) {
        String str = null;
        AppMethodBeat.i(20415);
        if (bArr == null || bArr.length <= 14) {
            ab.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            AppMethodBeat.o(20415);
            return null;
        }
        Object obj;
        if (z) {
            str = g.x(bArr);
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
        int aR = aR(bArr2);
        int aR2 = aR(bArr3);
        length = aR(bArr4);
        int aR3 = aR(bArr5);
        ab.i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", new b(obj, aR, aR2, aR(bArr8), new Rect(length, aR3, aR(bArr6) + length, aR(bArr7) + aR3), str));
        AppMethodBeat.o(20415);
        return new b(obj, aR, aR2, aR(bArr8), new Rect(length, aR3, aR(bArr6) + length, aR(bArr7) + aR3), str);
    }
}
