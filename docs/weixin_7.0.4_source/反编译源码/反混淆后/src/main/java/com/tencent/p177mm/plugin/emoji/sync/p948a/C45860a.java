package com.tencent.p177mm.plugin.emoji.sync.p948a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p192b.C31264a;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.plugin.emoji.C38876c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p382d.C20358a;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.emoji.sync.C11563d;
import com.tencent.p177mm.plugin.emoji.sync.C27745c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.tencent.mm.plugin.emoji.sync.a.a */
public final class C45860a extends C27745c {
    private EmojiInfo exP;
    private String kWM;
    private String kWN;
    private String kWl;
    private C11563d kXJ;
    private String kXK;
    private String kXL;
    private String kXM;
    private String kXN;
    private String kXO;
    private String kXP;
    private String kXQ;
    private C20358a kXR;
    private C31264a kXS;

    public C45860a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.m2504i(53198);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.kXK = str;
        this.kXL = str2;
        this.kXM = str3;
        this.kWM = str4;
        this.kXN = str5;
        this.kXO = str6;
        this.kXP = str8;
        this.kXQ = str9;
        this.kWl = str7;
        this.kWN = str10;
        this.exP = C42952j.getEmojiStorageMgr().xYn.aqi(this.kXK);
        if (this.exP == null) {
            this.exP = new EmojiInfo();
            this.exP.field_md5 = this.kXK;
            this.exP.field_cdnUrl = this.kXL;
            this.exP.field_thumbUrl = this.kXM;
            this.exP.field_designerID = this.kWM;
            this.exP.field_encrypturl = this.kXN;
            this.exP.field_aeskey = this.kXO;
            this.exP.field_groupId = this.kWl;
        }
        if (C5046bo.isNullOrNil(this.kXL)) {
            this.kXL = this.exP.field_cdnUrl;
        } else {
            this.exP.field_cdnUrl = this.kXL;
        }
        if (C5046bo.isNullOrNil(this.kXN)) {
            this.kXN = this.exP.field_encrypturl;
            this.kXO = this.exP.field_aeskey;
        } else {
            this.exP.field_encrypturl = this.kXN;
            this.exP.field_aeskey = this.kXO;
        }
        if (!C5046bo.isNullOrNil(this.kWM)) {
            this.exP.field_designerID = this.kWM;
        }
        if (!C5046bo.isNullOrNil(this.kWl)) {
            this.exP.field_groupId = this.kWl;
        }
        if (!C5046bo.isNullOrNil(this.kXM)) {
            this.exP.field_thumbUrl = this.kXM;
        }
        if (!C5046bo.isNullOrNil(this.kWN)) {
            this.exP.field_activityid = this.kWN;
        }
        this.exP.field_externUrl = this.kXP;
        this.exP.field_externMd5 = this.kXQ;
        this.exP.field_attachedText = null;
        this.kXR = new C20358a();
        this.kXS = new C31264a();
        AppMethodBeat.m2505o(53198);
    }

    public final void run() {
        AppMethodBeat.m2504i(53199);
        if (this.kXJ != null) {
            this.kXJ.mo7131JH(this.kXK);
        } else {
            C4990ab.m7420w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        C4990ab.m7417i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", this.exP.mo20410Aq(), this.exP.field_cdnUrl, this.exP.field_thumbUrl, this.exP.field_designerID, this.exP.field_encrypturl, this.exP.field_groupId);
        if (C5046bo.isNullOrNil(this.kXL) && C5046bo.isNullOrNil(this.kXN) && C5046bo.isNullOrNil(this.kXP)) {
            C7060h.pYm.mo8378a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kXK);
            C1720g.m3535RO().eJo.mo14541a(new C27737e(linkedList), 0);
            bkK();
        } else {
            int i;
            String str = this.kXL;
            if (!C5046bo.isNullOrNil(this.kXP) && !C5046bo.isNullOrNil(this.kXQ)) {
                str = this.kXP;
                i = 1;
            } else if (C5046bo.isNullOrNil(this.kXN) || C5046bo.isNullOrNil(this.kXO)) {
                i = 0;
            } else {
                str = this.kXN;
                i = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C37477b sE = this.kXR.mo33454sE(str);
            if (sE == null || C5046bo.m7540cb(sE.data)) {
                C4990ab.m7411d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                bkK();
            } else {
                C4990ab.m7411d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                byte[] bArr = sE.data;
                if (i != 0) {
                    try {
                        byte[] bArr2 = sE.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(C5046bo.anf(this.kXO), 0).getBytes(), 0);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", C5046bo.m7574l(e));
                    }
                }
                boolean a = this.kXS.mo43778a(str, bArr, C20364g.m31466q(this.exP.dve(), new Object[0]));
                File file = new File(this.exP.dve());
                if (a && file.exists()) {
                    String v = C1178g.m2589v(file);
                    str = this.exP.mo20410Aq();
                    if (!C5046bo.isNullOrNil(this.kXQ)) {
                        str = this.kXQ;
                    }
                    if (C5046bo.isNullOrNil(v) || !v.equalsIgnoreCase(r3)) {
                        if (file.exists()) {
                            file.delete();
                        }
                        bkK();
                        if (i != 0) {
                            C38876c.m65942hF(8);
                            C38876c.m65941a(this.kXK, 3, 0, 1, this.kWl, 1, this.kWM);
                        } else {
                            C38876c.m65942hF(5);
                            C38876c.m65941a(this.kXK, 2, 0, 1, this.kWl, 1, this.kWM);
                        }
                    } else {
                        this.exP.field_size = bArr.length;
                        this.exP.field_state = EmojiInfo.zZb;
                        this.exP.field_temp = 0;
                        this.exP.field_catalog = EmojiInfo.yaB;
                        this.exP.field_type = EmojiLogic.m44079aF(bArr);
                        int dvi = C42952j.getEmojiStorageMgr().xYn.dvi();
                        if (dvi < C26072e.m41618OM()) {
                            dvi = C26072e.m41618OM();
                        } else {
                            dvi++;
                        }
                        this.exP.field_idx = dvi;
                        C42952j.getEmojiStorageMgr().xYn.mo48555G(this.exP);
                        C26107cx c26107cx = new C26107cx();
                        c26107cx.cvY.cvZ = this.kXK;
                        c26107cx.cvY.cuy = 0;
                        c26107cx.cvY.success = true;
                        C4879a.xxA.mo10055m(c26107cx);
                        if (i != 0) {
                            C38876c.m65942hF(7);
                            C38876c.m65942hF(4);
                            C38876c.m65941a(this.kXK, 3, 0, 0, this.kWl, 0, this.kWM);
                        } else {
                            C38876c.m65942hF(2);
                            C38876c.m65942hF(4);
                            C38876c.m65941a(this.kXK, 2, 0, 0, this.kWl, 1, this.kWM);
                        }
                        C20362f.bjK().mo35591c(this.exP, true);
                    }
                } else {
                    bkK();
                    if (i != 0) {
                        C38876c.m65942hF(8);
                        C38876c.m65941a(this.kXK, 3, 0, 1, this.kWl, 1, this.kWM);
                    } else {
                        C38876c.m65942hF(3);
                        C38876c.m65941a(this.kXK, 2, 1, 1, this.kWl, 1, this.kWM);
                    }
                }
            }
        }
        if (!C5046bo.isNullOrNil(this.exP.field_thumbUrl)) {
            C37477b sE2 = this.kXR.mo33454sE(this.exP.field_thumbUrl);
            if (sE2 != null) {
                this.kXS.mo43778a(this.exP.field_thumbUrl, sE2.data, C20364g.m31466q(this.exP.dve() + "_cover", new Object[0]));
            }
        }
        AppMethodBeat.m2505o(53199);
    }

    private void bkK() {
        AppMethodBeat.m2504i(53200);
        C4990ab.m7416i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        C26107cx c26107cx = new C26107cx();
        c26107cx.cvY.cvZ = this.kXK;
        c26107cx.cvY.cuy = 0;
        c26107cx.cvY.success = false;
        C4879a.xxA.mo10055m(c26107cx);
        if (this.exP != null) {
            C4990ab.m7417i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", this.exP.mo20410Aq());
            this.exP.field_state = EmojiInfo.zZc;
            this.exP.field_catalog = EmojiInfo.yau;
            C42952j.getEmojiStorageMgr().xYn.mo48555G(this.exP);
        }
        AppMethodBeat.m2505o(53200);
    }

    public final String getKey() {
        return this.kXK;
    }

    /* renamed from: a */
    public final void mo23266a(C11563d c11563d) {
        this.kXJ = c11563d;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(53201);
        if (obj != null && (obj instanceof C45860a)) {
            C45860a c45860a = (C45860a) obj;
            if (!(C5046bo.isNullOrNil(this.kXK) || C5046bo.isNullOrNil(c45860a.kXK) || !this.kXK.equals(c45860a.kXK))) {
                AppMethodBeat.m2505o(53201);
                return true;
            }
        }
        AppMethodBeat.m2505o(53201);
        return false;
    }

    public final void cancel() {
    }
}
