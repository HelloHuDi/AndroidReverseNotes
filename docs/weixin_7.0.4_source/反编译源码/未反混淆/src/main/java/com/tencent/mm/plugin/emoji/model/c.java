package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.LinkedList;

public final class c implements f {
    private String kVc;
    private com.tencent.mm.at.a.c.c kVd = new com.tencent.mm.at.a.c.c() {
        public final void a(boolean z, Object... objArr) {
            AppMethodBeat.i(52998);
            if (objArr == null || objArr.length < 2) {
                ab.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
                AppMethodBeat.o(52998);
                return;
            }
            xx xxVar;
            int intValue = ((Integer) objArr[1]).intValue();
            if (objArr[0] instanceof xx) {
                xxVar = (xx) objArr[0];
            } else {
                xxVar = null;
            }
            if (xxVar == null) {
                ab.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
                AppMethodBeat.o(52998);
                return;
            }
            String str;
            boolean z2;
            String L = EmojiLogic.L(b.Yb(), "", xxVar.Md5);
            new StringBuilder().append(L).append("_encrypt");
            if (intValue == 101) {
                str = L + "_extern";
                z2 = true;
            } else if (intValue == 102) {
                str = L + "_encrypt";
                z2 = true;
            } else {
                str = null;
                z2 = false;
            }
            if (z) {
                if (z2) {
                    boolean z3 = false;
                    if (e.asZ(str) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            z3 = a.g(Base64.encodeToString(bo.anf(xxVar.AesKey), 0), str, L);
                            if (z3) {
                                com.tencent.mm.plugin.emoji.c.hF(7);
                            } else {
                                com.tencent.mm.plugin.emoji.c.hF(8);
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", bo.l(e));
                            com.tencent.mm.plugin.emoji.c.hF(8);
                        }
                        ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (z3) {
                            e.deleteFile(str);
                        } else {
                            String str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                            String str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                            Object[] objArr2 = new Object[5];
                            objArr2[0] = xxVar.Md5;
                            objArr2[1] = Long.valueOf(e.asZ(str));
                            objArr2[2] = e.atg(str) == null ? "" : e.atg(str);
                            objArr2[3] = xxVar.AesKey;
                            objArr2[4] = xxVar.EncryptUrl;
                            ab.i(str2, str3, objArr2);
                            com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 3, 0, 1, "", 1, "");
                            e.deleteFile(str);
                            c.cb(xxVar.Md5, 2);
                            AppMethodBeat.o(52998);
                            return;
                        }
                    }
                    ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", xxVar.Md5);
                    com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 3, 1, 1, "", 1, "");
                    c.cb(xxVar.Md5, 2);
                    AppMethodBeat.o(52998);
                    return;
                }
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(L);
                int asZ = (int) e.asZ(L);
                byte[] e2 = e.e(L, 0, 10);
                if (asZ <= 0 || e2 == null) {
                    c.a(xxVar, z2);
                    AppMethodBeat.o(52998);
                    return;
                }
                String atg = e.atg(j.w(bVar.mUri));
                String str4 = xxVar.Md5;
                if (intValue == 101) {
                    str4 = xxVar.ExternMd5;
                }
                if (bo.isNullOrNil(atg) || !atg.equalsIgnoreCase(str4)) {
                    ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", atg, xxVar.Md5, xxVar.Url);
                    bVar.delete();
                    c.cb(xxVar.Md5, 2);
                    if (z2) {
                        com.tencent.mm.plugin.emoji.c.hF(5);
                        com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 3, 0, 1, "", 1, "");
                        AppMethodBeat.o(52998);
                        return;
                    }
                    com.tencent.mm.plugin.emoji.c.hF(5);
                    com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 2, 0, 1, "", 1, "");
                    AppMethodBeat.o(52998);
                    return;
                }
                if (z2) {
                    com.tencent.mm.plugin.emoji.c.hF(4);
                    com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 3, 0, 0, "", 0, "");
                } else {
                    com.tencent.mm.plugin.emoji.c.hF(4);
                    com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 2, 0, 0, "", 1, "");
                }
                asZ = EmojiInfo.zYY;
                if (r.bS(e2)) {
                    asZ = EmojiInfo.zYX;
                } else {
                    asZ = EmojiInfo.zYY;
                }
                EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(atg);
                if (aqi == null) {
                    aqi = new EmojiInfo();
                    aqi.field_md5 = xxVar.Md5;
                    aqi.field_catalog = EmojiInfo.yau;
                    aqi.field_size = (int) e.asZ(L);
                }
                aqi.field_type = asZ;
                aqi.field_state = EmojiInfo.zZb;
                j.getEmojiStorageMgr().xYn.G(aqi);
                c.cb(xxVar.Md5, 1);
                EmojiLogic.a(ah.getContext(), null, aqi.Aq(), aqi.ptQ, aqi);
                AppMethodBeat.o(52998);
                return;
            }
            c.a(xxVar, z2);
            AppMethodBeat.o(52998);
        }
    };

    public c() {
        AppMethodBeat.i(52999);
        AppMethodBeat.o(52999);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53000);
        ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case 221:
                AppMethodBeat.o(53000);
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) mVar;
                if (eVar.kWt == com.tencent.mm.plugin.emoji.f.e.kWr) {
                    hu huVar;
                    if (eVar.ehh == null) {
                        huVar = null;
                    } else {
                        huVar = (hu) eVar.ehh.fsG.fsP;
                    }
                    if (!(huVar == null || huVar.vKk == null || huVar.vKk.size() <= 0)) {
                        str2 = (String) huVar.vKk.get(0);
                    }
                    if (!bo.isEqual(str2, this.kVc)) {
                        AppMethodBeat.o(53000);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        hv bku = eVar.bku();
                        if (bku == null || bku.vKl == null || bku.vKl.size() <= 0) {
                            cb(str2, 2);
                            ab.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            AppMethodBeat.o(53000);
                            return;
                        }
                        xx xxVar = (xx) bku.vKl.get(0);
                        String L = EmojiLogic.L(b.Yb(), "", xxVar.Md5);
                        if (com.tencent.mm.emoji.a.e.OQ() && com.tencent.mm.emoji.a.e.OR() && !bo.isNullOrNil(xxVar.ExternUrl) && !bo.isNullOrNil(xxVar.ExternMd5)) {
                            j.bjW().a(xxVar.ExternUrl, g.r(L + "_extern", xxVar, Integer.valueOf(101)), this.kVd);
                            AppMethodBeat.o(53000);
                            return;
                        } else if (!bo.isNullOrNil(xxVar.EncryptUrl) && !bo.isNullOrNil(xxVar.AesKey)) {
                            j.bjW().a(xxVar.EncryptUrl, g.r(L + "_encrypt", xxVar, Integer.valueOf(102)), this.kVd);
                            com.tencent.mm.plugin.emoji.c.hF(6);
                            AppMethodBeat.o(53000);
                            return;
                        } else if (bo.isNullOrNil(xxVar.Url)) {
                            ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            cb(str2, 2);
                            AppMethodBeat.o(53000);
                            return;
                        } else {
                            j.bjW().a(xxVar.Url, g.q(L, xxVar, Integer.valueOf(100)), this.kVd);
                            com.tencent.mm.plugin.emoji.c.hF(1);
                            AppMethodBeat.o(53000);
                            return;
                        }
                    } else {
                        cb(str2, 2);
                        AppMethodBeat.o(53000);
                        return;
                    }
                }
                ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                AppMethodBeat.o(53000);
                return;
            default:
                ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                AppMethodBeat.o(53000);
                return;
        }
    }

    public final void c(com.tencent.mm.af.j.b bVar) {
        AppMethodBeat.i(53001);
        if (bVar == null) {
            ab.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            AppMethodBeat.o(53001);
            return;
        }
        String str = bVar.fgq;
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            AppMethodBeat.o(53001);
            return;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = str;
        emojiInfo.field_app_id = bVar.appId;
        emojiInfo.field_catalog = EmojiInfo.yau;
        emojiInfo.field_size = bVar.fgo;
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.zZd;
        j.getEmojiStorageMgr().xYn.F(emojiInfo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
        cb(str, 0);
        ab.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", str);
        this.kVc = str;
        AppMethodBeat.o(53001);
    }

    static void cb(String str, int i) {
        AppMethodBeat.i(53002);
        com.tencent.mm.g.a.r rVar = new com.tencent.mm.g.a.r();
        rVar.csC.csD = str;
        rVar.csC.status = i;
        rVar.csC.csE = 0;
        com.tencent.mm.sdk.b.a.xxA.m(rVar);
        ab.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", str, Integer.valueOf(0), Integer.valueOf(i));
        AppMethodBeat.o(53002);
    }

    static /* synthetic */ void a(xx xxVar, boolean z) {
        AppMethodBeat.i(53003);
        ab.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", xxVar.Md5);
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 3, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.hF(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(xxVar.Md5, 2, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.hF(3);
        }
        cb(xxVar.Md5, 2);
        AppMethodBeat.o(53003);
    }
}
