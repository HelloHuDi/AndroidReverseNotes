package com.tencent.p177mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1168a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p230g.p231a.C42048r;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.protocal.protobuf.C23398hu;
import com.tencent.p177mm.protocal.protobuf.C23399hv;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.model.c */
public final class C27739c implements C1202f {
    private String kVc;
    private C45158c kVd = new C115551();

    /* renamed from: com.tencent.mm.plugin.emoji.model.c$1 */
    class C115551 implements C45158c {
        C115551() {
        }

        /* renamed from: a */
        public final void mo15193a(boolean z, Object... objArr) {
            AppMethodBeat.m2504i(52998);
            if (objArr == null || objArr.length < 2) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
                AppMethodBeat.m2505o(52998);
                return;
            }
            C40588xx c40588xx;
            int intValue = ((Integer) objArr[1]).intValue();
            if (objArr[0] instanceof C40588xx) {
                c40588xx = (C40588xx) objArr[0];
            } else {
                c40588xx = null;
            }
            if (c40588xx == null) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
                AppMethodBeat.m2505o(52998);
                return;
            }
            String str;
            boolean z2;
            String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", c40588xx.Md5);
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
                    if (C5730e.asZ(str) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            z3 = C1168a.m2550g(Base64.encodeToString(C5046bo.anf(c40588xx.AesKey), 0), str, L);
                            if (z3) {
                                C38876c.m65942hF(7);
                            } else {
                                C38876c.m65942hF(8);
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", C5046bo.m7574l(e));
                            C38876c.m65942hF(8);
                        }
                        C4990ab.m7417i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (z3) {
                            C5730e.deleteFile(str);
                        } else {
                            String str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                            String str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                            Object[] objArr2 = new Object[5];
                            objArr2[0] = c40588xx.Md5;
                            objArr2[1] = Long.valueOf(C5730e.asZ(str));
                            objArr2[2] = C5730e.atg(str) == null ? "" : C5730e.atg(str);
                            objArr2[3] = c40588xx.AesKey;
                            objArr2[4] = c40588xx.EncryptUrl;
                            C4990ab.m7417i(str2, str3, objArr2);
                            C38876c.m65941a(c40588xx.Md5, 3, 0, 1, "", 1, "");
                            C5730e.deleteFile(str);
                            C27739c.m44085cb(c40588xx.Md5, 2);
                            AppMethodBeat.m2505o(52998);
                            return;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", c40588xx.Md5);
                    C38876c.m65941a(c40588xx.Md5, 3, 1, 1, "", 1, "");
                    C27739c.m44085cb(c40588xx.Md5, 2);
                    AppMethodBeat.m2505o(52998);
                    return;
                }
                C5728b c5728b = new C5728b(L);
                int asZ = (int) C5730e.asZ(L);
                byte[] e2 = C5730e.m8632e(L, 0, 10);
                if (asZ <= 0 || e2 == null) {
                    C27739c.m44084a(c40588xx, z2);
                    AppMethodBeat.m2505o(52998);
                    return;
                }
                String atg = C5730e.atg(C5736j.m8649w(c5728b.mUri));
                String str4 = c40588xx.Md5;
                if (intValue == 101) {
                    str4 = c40588xx.ExternMd5;
                }
                if (C5046bo.isNullOrNil(atg) || !atg.equalsIgnoreCase(str4)) {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", atg, c40588xx.Md5, c40588xx.Url);
                    c5728b.delete();
                    C27739c.m44085cb(c40588xx.Md5, 2);
                    if (z2) {
                        C38876c.m65942hF(5);
                        C38876c.m65941a(c40588xx.Md5, 3, 0, 1, "", 1, "");
                        AppMethodBeat.m2505o(52998);
                        return;
                    }
                    C38876c.m65942hF(5);
                    C38876c.m65941a(c40588xx.Md5, 2, 0, 1, "", 1, "");
                    AppMethodBeat.m2505o(52998);
                    return;
                }
                if (z2) {
                    C38876c.m65942hF(4);
                    C38876c.m65941a(c40588xx.Md5, 3, 0, 0, "", 0, "");
                } else {
                    C38876c.m65942hF(4);
                    C38876c.m65941a(c40588xx.Md5, 2, 0, 0, "", 1, "");
                }
                asZ = EmojiInfo.zYY;
                if (C5063r.m7677bS(e2)) {
                    asZ = EmojiInfo.zYX;
                } else {
                    asZ = EmojiInfo.zYY;
                }
                EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(atg);
                if (aqi == null) {
                    aqi = new EmojiInfo();
                    aqi.field_md5 = c40588xx.Md5;
                    aqi.field_catalog = EmojiInfo.yau;
                    aqi.field_size = (int) C5730e.asZ(L);
                }
                aqi.field_type = asZ;
                aqi.field_state = EmojiInfo.zZb;
                C42952j.getEmojiStorageMgr().xYn.mo48555G(aqi);
                C27739c.m44085cb(c40588xx.Md5, 1);
                EmojiLogic.m44076a(C4996ah.getContext(), null, aqi.mo20410Aq(), aqi.ptQ, aqi);
                AppMethodBeat.m2505o(52998);
                return;
            }
            C27739c.m44084a(c40588xx, z2);
            AppMethodBeat.m2505o(52998);
        }
    }

    public C27739c() {
        AppMethodBeat.m2504i(52999);
        AppMethodBeat.m2505o(52999);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53000);
        C4990ab.m7417i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case 221:
                AppMethodBeat.m2505o(53000);
                return;
            case 697:
                String str2 = "";
                C27737e c27737e = (C27737e) c1207m;
                if (c27737e.kWt == C27737e.kWr) {
                    C23398hu c23398hu;
                    if (c27737e.ehh == null) {
                        c23398hu = null;
                    } else {
                        c23398hu = (C23398hu) c27737e.ehh.fsG.fsP;
                    }
                    if (!(c23398hu == null || c23398hu.vKk == null || c23398hu.vKk.size() <= 0)) {
                        str2 = (String) c23398hu.vKk.get(0);
                    }
                    if (!C5046bo.isEqual(str2, this.kVc)) {
                        AppMethodBeat.m2505o(53000);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        C23399hv bku = c27737e.bku();
                        if (bku == null || bku.vKl == null || bku.vKl.size() <= 0) {
                            C27739c.m44085cb(str2, 2);
                            C4990ab.m7412e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            AppMethodBeat.m2505o(53000);
                            return;
                        }
                        C40588xx c40588xx = (C40588xx) bku.vKl.get(0);
                        String L = EmojiLogic.m44073L(C2933b.m5221Yb(), "", c40588xx.Md5);
                        if (C26072e.m41622OQ() && C26072e.m41623OR() && !C5046bo.isNullOrNil(c40588xx.ExternUrl) && !C5046bo.isNullOrNil(c40588xx.ExternMd5)) {
                            C42952j.bjW().mo43771a(c40588xx.ExternUrl, C20364g.m31467r(L + "_extern", c40588xx, Integer.valueOf(101)), this.kVd);
                            AppMethodBeat.m2505o(53000);
                            return;
                        } else if (!C5046bo.isNullOrNil(c40588xx.EncryptUrl) && !C5046bo.isNullOrNil(c40588xx.AesKey)) {
                            C42952j.bjW().mo43771a(c40588xx.EncryptUrl, C20364g.m31467r(L + "_encrypt", c40588xx, Integer.valueOf(102)), this.kVd);
                            C38876c.m65942hF(6);
                            AppMethodBeat.m2505o(53000);
                            return;
                        } else if (C5046bo.isNullOrNil(c40588xx.Url)) {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            C27739c.m44085cb(str2, 2);
                            AppMethodBeat.m2505o(53000);
                            return;
                        } else {
                            C42952j.bjW().mo43771a(c40588xx.Url, C20364g.m31466q(L, c40588xx, Integer.valueOf(100)), this.kVd);
                            C38876c.m65942hF(1);
                            AppMethodBeat.m2505o(53000);
                            return;
                        }
                    } else {
                        C27739c.m44085cb(str2, 2);
                        AppMethodBeat.m2505o(53000);
                        return;
                    }
                }
                C4990ab.m7416i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                AppMethodBeat.m2505o(53000);
                return;
            default:
                C4990ab.m7416i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                AppMethodBeat.m2505o(53000);
                return;
        }
    }

    /* renamed from: c */
    public final void mo45575c(C8910b c8910b) {
        AppMethodBeat.m2504i(53001);
        if (c8910b == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            AppMethodBeat.m2505o(53001);
            return;
        }
        String str = c8910b.fgq;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            AppMethodBeat.m2505o(53001);
            return;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = str;
        emojiInfo.field_app_id = c8910b.appId;
        emojiInfo.field_catalog = EmojiInfo.yau;
        emojiInfo.field_size = c8910b.fgo;
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.zZd;
        C42952j.getEmojiStorageMgr().xYn.mo48554F(emojiInfo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        C1720g.m3535RO().eJo.mo14541a(new C27737e(linkedList), 0);
        C27739c.m44085cb(str, 0);
        C4990ab.m7411d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", str);
        this.kVc = str;
        AppMethodBeat.m2505o(53001);
    }

    /* renamed from: cb */
    static void m44085cb(String str, int i) {
        AppMethodBeat.m2504i(53002);
        C42048r c42048r = new C42048r();
        c42048r.csC.csD = str;
        c42048r.csC.status = i;
        c42048r.csC.csE = 0;
        C4879a.xxA.mo10055m(c42048r);
        C4990ab.m7411d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", str, Integer.valueOf(0), Integer.valueOf(i));
        AppMethodBeat.m2505o(53002);
    }

    /* renamed from: a */
    static /* synthetic */ void m44084a(C40588xx c40588xx, boolean z) {
        AppMethodBeat.m2504i(53003);
        C4990ab.m7417i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", c40588xx.Md5);
        if (z) {
            C38876c.m65941a(c40588xx.Md5, 3, 1, 1, "", 1, "");
            C38876c.m65942hF(8);
        } else {
            C38876c.m65941a(c40588xx.Md5, 2, 1, 1, "", 1, "");
            C38876c.m65942hF(3);
        }
        C27739c.m44085cb(c40588xx.Md5, 2);
        AppMethodBeat.m2505o(53003);
    }
}
