package com.tencent.p177mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.gif.j */
public final class C34326j implements C39242a {
    private int height;
    private String lis;
    private long npo = 0;
    private long npp;
    private int npv = -1;
    private int width;

    public C34326j(String str, int i, int i2, long j) {
        AppMethodBeat.m2504i(62448);
        this.lis = str;
        this.width = i;
        this.height = i2;
        this.npp = j;
        this.npv = 20;
        C4990ab.m7417i("MicroMsg.MMWxAMEncoder", "create MMWxAMEncoder, width: %s, height: %s, frameDurationMs: %s, qp: %s, outputPath: %s", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(20), str);
        AppMethodBeat.m2505o(62448);
    }

    /* renamed from: EK */
    public final boolean mo7644EK() {
        AppMethodBeat.m2504i(62449);
        this.npo = MMWXGFJNI.nativeInitWxAMEncoder(this.width, this.height, this.npp, this.npv);
        if (this.npo == 0) {
            C7060h.pYm.mo15419k(852, 12, 1);
            C4990ab.m7413e("MicroMsg.MMWxAMEncoder", "init wxam encoder failed! %s", Long.valueOf(this.npo));
            AppMethodBeat.m2505o(62449);
            return false;
        }
        C4990ab.m7417i("MicroMsg.MMWxAMEncoder", "successfully init wxam encoder: %s", Long.valueOf(this.npo));
        AppMethodBeat.m2505o(62449);
        return true;
    }

    /* renamed from: c */
    public final boolean mo7646c(byte[] bArr, long j) {
        AppMethodBeat.m2504i(62450);
        if (this.npo == 0 || C5046bo.m7540cb(bArr) || bArr.length != (this.width * this.height) * 4) {
            C4990ab.m7416i("MicroMsg.MMWxAMEncoder", "add rgba frame failed, frame size or encoder ptr is not match");
            AppMethodBeat.m2505o(62450);
            return false;
        }
        long j2 = this.npp;
        if (j >= 0) {
            j2 = j;
        }
        if (MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2) < 0) {
            C4990ab.m7413e("MicroMsg.MMWxAMEncoder", "add rgba frame failed: %s", Integer.valueOf(MMWXGFJNI.nativeAddWxAMEncodeRgbaFrame(this.npo, this.width, this.height, bArr, j2)));
            AppMethodBeat.m2505o(62450);
            return false;
        }
        AppMethodBeat.m2505o(62450);
        return true;
    }

    public final boolean bFM() {
        AppMethodBeat.m2504i(62451);
        if (this.npo != 0) {
            byte[] nativeFinishWxAMEncode = MMWXGFJNI.nativeFinishWxAMEncode(this.npo);
            if (nativeFinishWxAMEncode == null || nativeFinishWxAMEncode.length <= 0) {
                C4990ab.m7417i("MicroMsg.MMWxAMEncoder", "finish encode error, buf: %s", Arrays.toString(nativeFinishWxAMEncode));
                AppMethodBeat.m2505o(62451);
                return false;
            }
            C4990ab.m7417i("MicroMsg.MMWxAMEncoder", "encoder buffer size: %s", Integer.valueOf(nativeFinishWxAMEncode.length));
            if (!C5046bo.isNullOrNil(this.lis)) {
                FileOp.m64141q(this.lis, nativeFinishWxAMEncode);
                AppMethodBeat.m2505o(62451);
                return true;
            }
        }
        AppMethodBeat.m2505o(62451);
        return false;
    }
}
