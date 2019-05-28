package com.tencent.p177mm.plugin.luckymoney.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p230g.p231a.C41963al;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.plugin.luckymoney.model.C21208t.C21209a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.h */
public final class C28424h extends C4884c<C41963al> {
    private ArrayList<String> nWF;

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.h$1 */
    class C284251 implements C21209a {
        C284251() {
        }

        /* renamed from: aS */
        public final void mo36588aS(String str, boolean z) {
            AppMethodBeat.m2504i(42286);
            if (z) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(42286);
                return;
            }
            C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(42286);
        }
    }

    public C28424h() {
        AppMethodBeat.m2504i(42287);
        this.nWF = new ArrayList();
        this.xxI = C41963al.class.getName().hashCode();
        AppMethodBeat.m2505o(42287);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(42288);
        C41963al c41963al = (C41963al) c4883b;
        if (!C1720g.m3531RK()) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (c41963al instanceof C41963al) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(1))).intValue();
            C4990ab.m7416i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:".concat(String.valueOf(intValue)));
            if (intValue == 0) {
                C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = c41963al.ctv.ctw;
                String str2 = c41963al.ctv.cty;
                int i = c41963al.ctv.ctz;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!C5023at.isWifi(C4996ah.getContext())) {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.nWF.contains(str)) {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:".concat(String.valueOf(str)));
                } else {
                    String str3 = C46063x.m85799Qk(str) + ".temp";
                    if (new File(str3).exists()) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.nWF.add(str);
                        C21208t c21208t = new C21208t();
                        C284251 c284251 = new C284251();
                        C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", str);
                        c21208t.nXW = false;
                        c21208t.lvp = C5046bo.nullAsNil(C37458c.m63162a("NewYearImg", System.currentTimeMillis(), C1853r.m3850Zd().field_username, ""));
                        C4990ab.m7417i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", c21208t.lvp);
                        c21208t.nXV = str3;
                        c21208t.nXU = c284251;
                        C42130g c42130g = new C42130g();
                        c42130g.cRY = false;
                        c42130g.egl = c21208t;
                        c42130g.field_fullpath = str3;
                        c42130g.field_mediaId = c21208t.lvp;
                        c42130g.field_fileId = str;
                        c42130g.field_aesKey = str2;
                        c42130g.field_totalLen = i;
                        c42130g.field_fileType = C42129a.MediaType_FILE;
                        c42130g.field_priority = C42129a.efC;
                        c42130g.field_needStorage = false;
                        c42130g.field_isStreamMedia = false;
                        c42130g.field_appType = 0;
                        c42130g.field_bzScene = 0;
                        if (!C37461f.afx().mo51222b(c42130g, -1)) {
                            C4990ab.m7413e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", str);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(42288);
        return false;
    }
}
