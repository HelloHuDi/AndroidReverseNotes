package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C41735l;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.modelsimple.ad */
public final class C45451ad {
    private static C1202f ehi = null;
    private static boolean fPO = false;
    private static int fPP = 3;
    private static long fPQ = 0;

    public static void run() {
        AppMethodBeat.m2504i(108300);
        if (fPO) {
            C4990ab.m7416i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            AppMethodBeat.m2505o(108300);
            return;
        }
        if (fPQ == 0 || C5046bo.m7525az(fPQ) > 180000) {
            fPQ = C5046bo.m7588yz();
            fPP = 3;
        }
        if (fPP <= 0) {
            C4990ab.m7416i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            AppMethodBeat.m2505o(108300);
            return;
        }
        fPP--;
        final String str = C6457e.euY + "temp.avatar.hd";
        if (C5730e.m8628ct(str)) {
            if (ehi == null) {
                ehi = new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(108299);
                        C4990ab.m7417i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            C5730e.deleteFile(str);
                        }
                        C45451ad.fPO = false;
                        C1720g.m3540Rg().mo14546b(157, C45451ad.ehi);
                        AppMethodBeat.m2505o(108299);
                    }
                };
            }
            C1720g.m3540Rg().mo14539a(157, ehi);
            C1720g.m3540Rg().mo14541a(new C41735l(str), 0);
            fPO = true;
            AppMethodBeat.m2505o(108300);
            return;
        }
        C4990ab.m7410d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
        AppMethodBeat.m2505o(108300);
    }
}
