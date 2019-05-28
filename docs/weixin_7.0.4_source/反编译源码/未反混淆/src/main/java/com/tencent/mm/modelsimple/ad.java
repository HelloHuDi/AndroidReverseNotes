package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ad {
    private static f ehi = null;
    private static boolean fPO = false;
    private static int fPP = 3;
    private static long fPQ = 0;

    public static void run() {
        AppMethodBeat.i(108300);
        if (fPO) {
            ab.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            AppMethodBeat.o(108300);
            return;
        }
        if (fPQ == 0 || bo.az(fPQ) > 180000) {
            fPQ = bo.yz();
            fPP = 3;
        }
        if (fPP <= 0) {
            ab.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            AppMethodBeat.o(108300);
            return;
        }
        fPP--;
        final String str = e.euY + "temp.avatar.hd";
        if (com.tencent.mm.vfs.e.ct(str)) {
            if (ehi == null) {
                ehi = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(108299);
                        ab.i("MicroMsg.PostTaskUploadHDHeadImg", "onSceneEnd errType:%d, erCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.vfs.e.deleteFile(str);
                        }
                        ad.fPO = false;
                        g.Rg().b(157, ad.ehi);
                        AppMethodBeat.o(108299);
                    }
                };
            }
            g.Rg().a(157, ehi);
            g.Rg().a(new l(str), 0);
            fPO = true;
            AppMethodBeat.o(108300);
            return;
        }
        ab.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
        AppMethodBeat.o(108300);
    }
}
