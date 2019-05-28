package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class g implements a {
    private int height;
    private String lis;
    private long npo = 0;
    private long npp;
    private int width;

    public g(String str, int i, int i2, long j) {
        AppMethodBeat.i(62421);
        this.lis = str;
        this.width = i;
        this.height = i2;
        this.npp = j;
        ab.i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str);
        AppMethodBeat.o(62421);
    }

    public final boolean EK() {
        AppMethodBeat.i(62422);
        this.npo = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.npp);
        if (this.npo == 0) {
            h.pYm.k(852, 11, 1);
            ab.e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", Long.valueOf(this.npo));
            AppMethodBeat.o(62422);
            return false;
        }
        ab.i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.npo));
        AppMethodBeat.o(62422);
        return true;
    }

    public final boolean c(byte[] bArr, long j) {
        AppMethodBeat.i(62423);
        if (this.npo == 0 || bo.cb(bArr) || bArr.length != (this.width * this.height) * 4) {
            ab.i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.o(62423);
            return false;
        }
        long j2 = this.npp;
        if (j >= 0) {
            j2 = j;
        }
        if (MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2) < 0) {
            ab.e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", Integer.valueOf(MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2)));
            AppMethodBeat.o(62423);
            return false;
        }
        AppMethodBeat.o(62423);
        return true;
    }

    public final boolean bFM() {
        AppMethodBeat.i(62424);
        if (this.npo != 0) {
            byte[] nativeFinishGifEncode = MMWXGFJNI.nativeFinishGifEncode(this.npo);
            if (nativeFinishGifEncode == null || nativeFinishGifEncode.length <= 0) {
                ab.i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishGifEncode));
                AppMethodBeat.o(62424);
                return false;
            }
            ab.i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishGifEncode.length));
            if (!bo.isNullOrNil(this.lis)) {
                FileOp.q(this.lis, nativeFinishGifEncode);
                AppMethodBeat.o(62424);
                return true;
            }
        }
        AppMethodBeat.o(62424);
        return false;
    }
}
