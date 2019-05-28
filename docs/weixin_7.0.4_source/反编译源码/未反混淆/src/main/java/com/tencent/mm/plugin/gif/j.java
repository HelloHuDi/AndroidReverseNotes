package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class j implements a {
    private int height;
    private String lis;
    private long npo = 0;
    private long npp;
    private int npv = -1;
    private int width;

    public j(String str, int i, int i2, long j) {
        AppMethodBeat.i(62448);
        this.lis = str;
        this.width = i;
        this.height = i2;
        this.npp = j;
        this.npv = 20;
        ab.i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(20), str);
        AppMethodBeat.o(62448);
    }

    public final boolean EK() {
        AppMethodBeat.i(62449);
        this.npo = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.npp, this.npv);
        if (this.npo == 0) {
            h.pYm.k(852, 12, 1);
            ab.e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", Long.valueOf(this.npo));
            AppMethodBeat.o(62449);
            return false;
        }
        ab.i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.npo));
        AppMethodBeat.o(62449);
        return true;
    }

    public final boolean c(byte[] bArr, long j) {
        AppMethodBeat.i(62450);
        if (this.npo == 0 || bo.cb(bArr) || bArr.length != (this.width * this.height) * 4) {
            ab.i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.o(62450);
            return false;
        }
        long j2 = this.npp;
        if (j >= 0) {
            j2 = j;
        }
        if (MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2) < 0) {
            ab.e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", Integer.valueOf(MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2)));
            AppMethodBeat.o(62450);
            return false;
        }
        AppMethodBeat.o(62450);
        return true;
    }

    public final boolean bFM() {
        AppMethodBeat.i(62451);
        if (this.npo != 0) {
            byte[] nativeFinishWxAMEncode = MMWXGFJNI.nativeFinishWxAMEncode(this.npo);
            if (nativeFinishWxAMEncode == null || nativeFinishWxAMEncode.length <= 0) {
                ab.i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishWxAMEncode));
                AppMethodBeat.o(62451);
                return false;
            }
            ab.i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishWxAMEncode.length));
            if (!bo.isNullOrNil(this.lis)) {
                FileOp.q(this.lis, nativeFinishWxAMEncode);
                AppMethodBeat.o(62451);
                return true;
            }
        }
        AppMethodBeat.o(62451);
        return false;
    }
}
