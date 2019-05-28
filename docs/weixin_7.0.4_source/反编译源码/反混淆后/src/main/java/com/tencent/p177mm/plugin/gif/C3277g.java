package com.tencent.p177mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.gif.g */
public final class C3277g implements C39242a {
    private int height;
    private String lis;
    private long npo = 0;
    private long npp;
    private int width;

    public C3277g(String str, int i, int i2, long j) {
        AppMethodBeat.m2504i(62421);
        this.lis = str;
        this.width = i;
        this.height = i2;
        this.npp = j;
        C4990ab.m7417i("MicroMsg.MMGifEncoder", "create MMGifEncoder, width: %s, height: %s, frameDurationMs: %s, outputPath: %s", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str);
        AppMethodBeat.m2505o(62421);
    }

    /* renamed from: EK */
    public final boolean mo7644EK() {
        AppMethodBeat.m2504i(62422);
        this.npo = MMWXGFJNI.nativeInitGifEncode(this.width, this.height, this.npp);
        if (this.npo == 0) {
            C7060h.pYm.mo15419k(852, 11, 1);
            C4990ab.m7413e("MicroMsg.MMGifEncoder", "init gif encoder failed! %s", Long.valueOf(this.npo));
            AppMethodBeat.m2505o(62422);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMGifEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.npo));
        AppMethodBeat.m2505o(62422);
        return true;
    }

    /* renamed from: c */
    public final boolean mo7646c(byte[] bArr, long j) {
        AppMethodBeat.m2504i(62423);
        if (this.npo == 0 || C5046bo.m7540cb(bArr) || bArr.length != (this.width * this.height) * 4) {
            C4990ab.m7416i("MicroMsg.MMGifEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.m2505o(62423);
            return false;
        }
        long j2 = this.npp;
        if (j >= 0) {
            j2 = j;
        }
        if (MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2) < 0) {
            C4990ab.m7413e("MicroMsg.MMGifEncoder", "add rgba frame failed: %s", Integer.valueOf(MMWXGFJNI.nativeAddGifEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2)));
            AppMethodBeat.m2505o(62423);
            return false;
        }
        AppMethodBeat.m2505o(62423);
        return true;
    }

    public final boolean bFM() {
        AppMethodBeat.m2504i(62424);
        if (this.npo != 0) {
            byte[] nativeFinishGifEncode = MMWXGFJNI.nativeFinishGifEncode(this.npo);
            if (nativeFinishGifEncode == null || nativeFinishGifEncode.length <= 0) {
                C4990ab.m7417i("MicroMsg.MMGifEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishGifEncode));
                AppMethodBeat.m2505o(62424);
                return false;
            }
            C4990ab.m7417i("MicroMsg.MMGifEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishGifEncode.length));
            if (!C5046bo.isNullOrNil(this.lis)) {
                FileOp.m64141q(this.lis, nativeFinishGifEncode);
                AppMethodBeat.m2505o(62424);
                return true;
            }
        }
        AppMethodBeat.m2505o(62424);
        return false;
    }
}
