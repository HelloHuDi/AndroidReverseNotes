package com.tencent.p177mm.plugin.p436hp.p1272a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28317b;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28318d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.che;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.hp.a.a */
public final class C21068a {

    /* renamed from: com.tencent.mm.plugin.hp.a.a$1 */
    public static class C210691 implements Runnable {
        final /* synthetic */ String ntq;
        final /* synthetic */ String ntr;
        final /* synthetic */ C28317b nts;
        final /* synthetic */ Context val$context;

        public C210691(String str, Context context, String str2, C28317b c28317b) {
            this.ntq = str;
            this.val$context = context;
            this.ntr = str2;
            this.nts = c28317b;
        }

        public final void run() {
            int i;
            AppMethodBeat.m2504i(90545);
            if (C1173e.m2561ct(this.ntq)) {
                boolean i2 = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int b = C46026b.m85592b(C28318d.m44928en(this.val$context), this.ntr, this.ntq, this.nts.nun);
                SharePatchFileUtil.m9373as(new File(this.ntr));
                C4990ab.m7417i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b));
                i2 = b;
            }
            if (i2 == 0) {
                if (C32429a.m53087cM(this.ntq)) {
                    String string;
                    C4990ab.m7417i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", Boolean.valueOf(C32429a.m53087cM(this.ntq)));
                    Context context = C4996ah.getContext();
                    if (C5046bo.isNullOrNil(this.nts.bGx())) {
                        string = context.getString(C25738R.string.ez8);
                    } else {
                        string = this.nts.bGx();
                    }
                    che che = new che();
                    che.num = this.nts.num;
                    che.title = context.getString(C25738R.string.byv);
                    che.xgb = context.getString(C25738R.string.cdx);
                    che.nna = context.getString(C25738R.string.eyp);
                    che.nun = this.nts.nun;
                    che.nuo = this.nts.nuo;
                    che.iCm = this.nts.fileSize;
                    che.nuk = this.nts.nuk;
                    che.cdy = this.nts.nul;
                    che.versionCode = this.nts.versionCode;
                    che.xga = this.ntq;
                    che.bzH = string;
                    C28318d.m44926a(che);
                    if (this.nts.nui.intValue() == 3) {
                        C7060h.pYm.mo8378a(614, 58, 1, false);
                    }
                    C4990ab.m7410d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
                } else {
                    C4990ab.m7416i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                }
            } else {
                C4990ab.m7416i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
            }
            switch (i2) {
                case -2:
                    C7060h.pYm.mo8378a(614, 53, 1, false);
                    C4990ab.m7410d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
                    break;
                case -1:
                    C7060h.pYm.mo8378a(614, 52, 1, false);
                    C4990ab.m7410d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
                    AppMethodBeat.m2505o(90545);
                    return;
            }
            AppMethodBeat.m2505o(90545);
        }
    }
}
