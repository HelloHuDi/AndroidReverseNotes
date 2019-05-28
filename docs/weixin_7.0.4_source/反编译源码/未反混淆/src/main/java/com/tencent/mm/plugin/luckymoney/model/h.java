package com.tencent.mm.plugin.luckymoney.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.al;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.io.File;
import java.util.ArrayList;

public final class h extends c<al> {
    private ArrayList<String> nWF;

    public h() {
        AppMethodBeat.i(42287);
        this.nWF = new ArrayList();
        this.xxI = al.class.getName().hashCode();
        AppMethodBeat.o(42287);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(42288);
        al alVar = (al) bVar;
        if (!g.RK()) {
            ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (alVar instanceof al) {
            ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(1))).intValue();
            ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:".concat(String.valueOf(intValue)));
            if (intValue == 0) {
                ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = alVar.ctv.ctw;
                String str2 = alVar.ctv.cty;
                int i = alVar.ctv.ctz;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!at.isWifi(ah.getContext())) {
                    ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.nWF.contains(str)) {
                    ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:".concat(String.valueOf(str)));
                } else {
                    String str3 = x.Qk(str) + ".temp";
                    if (new File(str3).exists()) {
                        ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.nWF.add(str);
                        t tVar = new t();
                        AnonymousClass1 anonymousClass1 = new t.a() {
                            public final void aS(String str, boolean z) {
                                AppMethodBeat.i(42286);
                                if (z) {
                                    ab.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(str)));
                                    AppMethodBeat.o(42286);
                                    return;
                                }
                                ab.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(str)));
                                AppMethodBeat.o(42286);
                            }
                        };
                        ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", str);
                        tVar.nXW = false;
                        tVar.lvp = bo.nullAsNil(com.tencent.mm.al.c.a("NewYearImg", System.currentTimeMillis(), r.Zd().field_username, ""));
                        ab.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", tVar.lvp);
                        tVar.nXV = str3;
                        tVar.nXU = anonymousClass1;
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.cRY = false;
                        gVar.egl = tVar;
                        gVar.field_fullpath = str3;
                        gVar.field_mediaId = tVar.lvp;
                        gVar.field_fileId = str;
                        gVar.field_aesKey = str2;
                        gVar.field_totalLen = i;
                        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
                        gVar.field_priority = com.tencent.mm.i.a.efC;
                        gVar.field_needStorage = false;
                        gVar.field_isStreamMedia = false;
                        gVar.field_appType = 0;
                        gVar.field_bzScene = 0;
                        if (!f.afx().b(gVar, -1)) {
                            ab.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", str);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(42288);
        return false;
    }
}
