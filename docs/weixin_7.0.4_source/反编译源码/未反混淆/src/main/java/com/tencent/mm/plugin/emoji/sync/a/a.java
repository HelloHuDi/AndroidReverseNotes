package com.tencent.mm.plugin.emoji.sync.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.c;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends c {
    private EmojiInfo exP;
    private String kWM;
    private String kWN;
    private String kWl;
    private d kXJ;
    private String kXK;
    private String kXL;
    private String kXM;
    private String kXN;
    private String kXO;
    private String kXP;
    private String kXQ;
    private com.tencent.mm.plugin.emoji.d.a kXR;
    private com.tencent.mm.at.a.b.a kXS;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.i(53198);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
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
        this.exP = j.getEmojiStorageMgr().xYn.aqi(this.kXK);
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
        if (bo.isNullOrNil(this.kXL)) {
            this.kXL = this.exP.field_cdnUrl;
        } else {
            this.exP.field_cdnUrl = this.kXL;
        }
        if (bo.isNullOrNil(this.kXN)) {
            this.kXN = this.exP.field_encrypturl;
            this.kXO = this.exP.field_aeskey;
        } else {
            this.exP.field_encrypturl = this.kXN;
            this.exP.field_aeskey = this.kXO;
        }
        if (!bo.isNullOrNil(this.kWM)) {
            this.exP.field_designerID = this.kWM;
        }
        if (!bo.isNullOrNil(this.kWl)) {
            this.exP.field_groupId = this.kWl;
        }
        if (!bo.isNullOrNil(this.kXM)) {
            this.exP.field_thumbUrl = this.kXM;
        }
        if (!bo.isNullOrNil(this.kWN)) {
            this.exP.field_activityid = this.kWN;
        }
        this.exP.field_externUrl = this.kXP;
        this.exP.field_externMd5 = this.kXQ;
        this.exP.field_attachedText = null;
        this.kXR = new com.tencent.mm.plugin.emoji.d.a();
        this.kXS = new com.tencent.mm.at.a.b.a();
        AppMethodBeat.o(53198);
    }

    public final void run() {
        AppMethodBeat.i(53199);
        if (this.kXJ != null) {
            this.kXJ.JH(this.kXK);
        } else {
            ab.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", this.exP.Aq(), this.exP.field_cdnUrl, this.exP.field_thumbUrl, this.exP.field_designerID, this.exP.field_encrypturl, this.exP.field_groupId);
        if (bo.isNullOrNil(this.kXL) && bo.isNullOrNil(this.kXN) && bo.isNullOrNil(this.kXP)) {
            h.pYm.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kXK);
            g.RO().eJo.a(new e(linkedList), 0);
            bkK();
        } else {
            int i;
            String str = this.kXL;
            if (!bo.isNullOrNil(this.kXP) && !bo.isNullOrNil(this.kXQ)) {
                str = this.kXP;
                i = 1;
            } else if (bo.isNullOrNil(this.kXN) || bo.isNullOrNil(this.kXO)) {
                i = 0;
            } else {
                str = this.kXN;
                i = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b sE = this.kXR.sE(str);
            if (sE == null || bo.cb(sE.data)) {
                ab.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                bkK();
            } else {
                ab.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                byte[] bArr = sE.data;
                if (i != 0) {
                    try {
                        byte[] bArr2 = sE.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(bo.anf(this.kXO), 0).getBytes(), 0);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Exception e) {
                        ab.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", bo.l(e));
                    }
                }
                boolean a = this.kXS.a(str, bArr, com.tencent.mm.plugin.emoji.e.g.q(this.exP.dve(), new Object[0]));
                File file = new File(this.exP.dve());
                if (a && file.exists()) {
                    String v = com.tencent.mm.a.g.v(file);
                    str = this.exP.Aq();
                    if (!bo.isNullOrNil(this.kXQ)) {
                        str = this.kXQ;
                    }
                    if (bo.isNullOrNil(v) || !v.equalsIgnoreCase(r3)) {
                        if (file.exists()) {
                            file.delete();
                        }
                        bkK();
                        if (i != 0) {
                            com.tencent.mm.plugin.emoji.c.hF(8);
                            com.tencent.mm.plugin.emoji.c.a(this.kXK, 3, 0, 1, this.kWl, 1, this.kWM);
                        } else {
                            com.tencent.mm.plugin.emoji.c.hF(5);
                            com.tencent.mm.plugin.emoji.c.a(this.kXK, 2, 0, 1, this.kWl, 1, this.kWM);
                        }
                    } else {
                        this.exP.field_size = bArr.length;
                        this.exP.field_state = EmojiInfo.zZb;
                        this.exP.field_temp = 0;
                        this.exP.field_catalog = EmojiInfo.yaB;
                        this.exP.field_type = EmojiLogic.aF(bArr);
                        int dvi = j.getEmojiStorageMgr().xYn.dvi();
                        if (dvi < com.tencent.mm.emoji.a.e.OM()) {
                            dvi = com.tencent.mm.emoji.a.e.OM();
                        } else {
                            dvi++;
                        }
                        this.exP.field_idx = dvi;
                        j.getEmojiStorageMgr().xYn.G(this.exP);
                        cx cxVar = new cx();
                        cxVar.cvY.cvZ = this.kXK;
                        cxVar.cvY.cuy = 0;
                        cxVar.cvY.success = true;
                        com.tencent.mm.sdk.b.a.xxA.m(cxVar);
                        if (i != 0) {
                            com.tencent.mm.plugin.emoji.c.hF(7);
                            com.tencent.mm.plugin.emoji.c.hF(4);
                            com.tencent.mm.plugin.emoji.c.a(this.kXK, 3, 0, 0, this.kWl, 0, this.kWM);
                        } else {
                            com.tencent.mm.plugin.emoji.c.hF(2);
                            com.tencent.mm.plugin.emoji.c.hF(4);
                            com.tencent.mm.plugin.emoji.c.a(this.kXK, 2, 0, 0, this.kWl, 1, this.kWM);
                        }
                        f.bjK().c(this.exP, true);
                    }
                } else {
                    bkK();
                    if (i != 0) {
                        com.tencent.mm.plugin.emoji.c.hF(8);
                        com.tencent.mm.plugin.emoji.c.a(this.kXK, 3, 0, 1, this.kWl, 1, this.kWM);
                    } else {
                        com.tencent.mm.plugin.emoji.c.hF(3);
                        com.tencent.mm.plugin.emoji.c.a(this.kXK, 2, 1, 1, this.kWl, 1, this.kWM);
                    }
                }
            }
        }
        if (!bo.isNullOrNil(this.exP.field_thumbUrl)) {
            b sE2 = this.kXR.sE(this.exP.field_thumbUrl);
            if (sE2 != null) {
                this.kXS.a(this.exP.field_thumbUrl, sE2.data, com.tencent.mm.plugin.emoji.e.g.q(this.exP.dve() + "_cover", new Object[0]));
            }
        }
        AppMethodBeat.o(53199);
    }

    private void bkK() {
        AppMethodBeat.i(53200);
        ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        cx cxVar = new cx();
        cxVar.cvY.cvZ = this.kXK;
        cxVar.cvY.cuy = 0;
        cxVar.cvY.success = false;
        com.tencent.mm.sdk.b.a.xxA.m(cxVar);
        if (this.exP != null) {
            ab.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", this.exP.Aq());
            this.exP.field_state = EmojiInfo.zZc;
            this.exP.field_catalog = EmojiInfo.yau;
            j.getEmojiStorageMgr().xYn.G(this.exP);
        }
        AppMethodBeat.o(53200);
    }

    public final String getKey() {
        return this.kXK;
    }

    public final void a(d dVar) {
        this.kXJ = dVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(53201);
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(bo.isNullOrNil(this.kXK) || bo.isNullOrNil(aVar.kXK) || !this.kXK.equals(aVar.kXK))) {
                AppMethodBeat.o(53201);
                return true;
            }
        }
        AppMethodBeat.o(53201);
        return false;
    }

    public final void cancel() {
    }
}
