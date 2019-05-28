package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a {

    /* renamed from: com.tencent.mm.plugin.hp.a.a$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ntq;
        final /* synthetic */ String ntr;
        final /* synthetic */ b nts;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(String str, Context context, String str2, b bVar) {
            this.ntq = str;
            this.val$context = context;
            this.ntr = str2;
            this.nts = bVar;
        }

        public final void run() {
            int i;
            AppMethodBeat.i(90545);
            if (e.ct(this.ntq)) {
                boolean i2 = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int b = b.b(d.en(this.val$context), this.ntr, this.ntq, this.nts.nun);
                SharePatchFileUtil.as(new File(this.ntr));
                ab.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b));
                i2 = b;
            }
            if (i2 == 0) {
                if (com.tencent.mm.c.a.cM(this.ntq)) {
                    String string;
                    ab.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", Boolean.valueOf(com.tencent.mm.c.a.cM(this.ntq)));
                    Context context = ah.getContext();
                    if (bo.isNullOrNil(this.nts.bGx())) {
                        string = context.getString(R.string.ez8);
                    } else {
                        string = this.nts.bGx();
                    }
                    che che = new che();
                    che.num = this.nts.num;
                    che.title = context.getString(R.string.byv);
                    che.xgb = context.getString(R.string.cdx);
                    che.nna = context.getString(R.string.eyp);
                    che.nun = this.nts.nun;
                    che.nuo = this.nts.nuo;
                    che.iCm = this.nts.fileSize;
                    che.nuk = this.nts.nuk;
                    che.cdy = this.nts.nul;
                    che.versionCode = this.nts.versionCode;
                    che.xga = this.ntq;
                    che.bzH = string;
                    d.a(che);
                    if (this.nts.nui.intValue() == 3) {
                        h.pYm.a(614, 58, 1, false);
                    }
                    ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
                } else {
                    ab.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                }
            } else {
                ab.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
            }
            switch (i2) {
                case -2:
                    h.pYm.a(614, 53, 1, false);
                    ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
                    break;
                case -1:
                    h.pYm.a(614, 52, 1, false);
                    ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
                    AppMethodBeat.o(90545);
                    return;
            }
            AppMethodBeat.o(90545);
        }
    }
}
