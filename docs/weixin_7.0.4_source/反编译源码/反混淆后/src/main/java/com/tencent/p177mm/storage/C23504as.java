package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.Map;

/* renamed from: com.tencent.mm.storage.as */
public final class C23504as {
    public String aeskey;
    public String cAp;
    public long cKK;
    public long createTime;
    public String cvZ;
    public String cwg;
    public int dqI;
    public String dqJ = "";
    public String eyJ;
    public String fWW;
    public String fgA;
    public String fgu;
    public int gag;
    public int height;
    /* renamed from: id */
    public String f4420id;
    public String lgY;
    public String nuk;
    public String talker;
    public String thumbUrl;
    public int width;
    public int xYc;
    public int xYd;
    public int xYe;
    public int xYf;
    public String xYg = "";
    public String xYh;
    public String xYi;
    public String xYj;
    public boolean xYk = true;
    public String xYl;
    public String xYm;

    /* renamed from: D */
    public static C23504as m36330D(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62707);
        if (emojiInfo == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            AppMethodBeat.m2505o(62707);
            return null;
        }
        C23504as c23504as = new C23504as();
        c23504as.cvZ = emojiInfo.field_md5;
        c23504as.xYc = emojiInfo.field_type;
        c23504as.xYd = emojiInfo.field_size;
        c23504as.cwg = emojiInfo.field_groupId;
        c23504as.xYh = emojiInfo.field_designerID;
        c23504as.thumbUrl = emojiInfo.field_thumbUrl;
        c23504as.cAp = emojiInfo.field_encrypturl;
        c23504as.aeskey = emojiInfo.field_aeskey;
        c23504as.width = emojiInfo.field_width;
        c23504as.height = emojiInfo.field_height;
        c23504as.nuk = emojiInfo.field_cdnUrl;
        c23504as.xYi = emojiInfo.field_externUrl;
        c23504as.xYj = emojiInfo.field_externMd5;
        c23504as.xYl = emojiInfo.field_activityid;
        c23504as.fgu = emojiInfo.field_tpurl;
        c23504as.fgA = emojiInfo.field_tpauthkey;
        c23504as.eyJ = emojiInfo.field_attachedText;
        c23504as.lgY = emojiInfo.field_lensId;
        c23504as.xYm = emojiInfo.field_attachTextColor;
        AppMethodBeat.m2505o(62707);
        return c23504as;
    }

    /* renamed from: a */
    public static void m36332a(C23504as c23504as, EmojiInfo emojiInfo) {
        emojiInfo.field_md5 = c23504as.cvZ;
        emojiInfo.field_svrid = c23504as.f4420id;
        emojiInfo.field_type = c23504as.xYc;
        emojiInfo.field_size = c23504as.xYd;
        emojiInfo.field_groupId = c23504as.cwg;
        emojiInfo.field_designerID = c23504as.xYh;
        emojiInfo.field_thumbUrl = c23504as.thumbUrl;
        emojiInfo.field_cdnUrl = c23504as.nuk;
        emojiInfo.field_encrypturl = c23504as.cAp;
        emojiInfo.field_aeskey = c23504as.aeskey;
        emojiInfo.field_width = c23504as.width;
        emojiInfo.field_height = c23504as.height;
        emojiInfo.field_externUrl = c23504as.xYi;
        emojiInfo.field_externMd5 = c23504as.xYj;
        emojiInfo.field_activityid = c23504as.xYl;
        emojiInfo.field_tpurl = c23504as.fgu;
        emojiInfo.field_tpauthkey = c23504as.fgA;
        emojiInfo.field_attachedText = c23504as.eyJ;
        emojiInfo.field_lensId = c23504as.lgY;
        emojiInfo.field_attachTextColor = c23504as.xYm;
    }

    /* renamed from: a */
    public static C23504as m36331a(Map<String, String> map, String str, String str2, String str3) {
        AppMethodBeat.m2504i(62708);
        if (map == null) {
            AppMethodBeat.m2505o(62708);
            return null;
        }
        C23504as c23504as = new C23504as();
        c23504as.xYg = str2;
        c23504as.talker = str;
        c23504as.f4420id = (String) map.get(".msg.emoji.$idbuffer");
        c23504as.fWW = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        c23504as.cvZ = str4;
        if (str4 == null) {
            c23504as.cvZ = (String) map.get(".msg.emoji.$md5");
        }
        if (!C5046bo.isNullOrNil(c23504as.cvZ)) {
            c23504as.cvZ = c23504as.cvZ.toLowerCase();
        }
        try {
            c23504as.xYc = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                c23504as.xYd = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                c23504as.xYd = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                c23504as.xYe = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                c23504as.xYf = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                c23504as.cwg = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                c23504as.nuk = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$tpurl") != null) {
                c23504as.fgu = (String) map.get(".msg.emoji.$tpurl");
            }
            if (map.get(".msg.emoji.$tpauthkey") != null) {
                c23504as.fgA = (String) map.get(".msg.emoji.$tpauthkey");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                c23504as.xYh = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                c23504as.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                c23504as.cAp = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                c23504as.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                c23504as.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                c23504as.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                c23504as.xYi = (String) map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                c23504as.xYj = (String) map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                c23504as.xYl = (String) map.get(".msg.emoji.$activityid");
            }
            if (map.get(".msg.emoji.$attachedtext") != null) {
                c23504as.eyJ = (String) map.get(".msg.emoji.$attachedtext");
            }
            if (map.get(".msg.emoji.$attachedtextcolor") != null) {
                c23504as.xYm = (String) map.get(".msg.emoji.$attachedtextcolor");
            }
            if (map.get(".msg.emoji.$lensid") != null) {
                c23504as.lgY = (String) map.get(".msg.emoji.$lensid");
            }
            if (!C5046bo.isNullOrNil(str3)) {
                c23504as.dqJ = str3;
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", c23504as.f4420id, c23504as.cvZ, Integer.valueOf(c23504as.xYc), Integer.valueOf(c23504as.xYd), Integer.valueOf(c23504as.xYe), Integer.valueOf(c23504as.xYf), c23504as.cwg, c23504as.nuk, c23504as.fgu, c23504as.xYh, c23504as.thumbUrl, c23504as.cAp, Integer.valueOf(c23504as.width), Integer.valueOf(c23504as.height), c23504as.xYi, c23504as.xYj);
            AppMethodBeat.m2505o(62708);
            return c23504as;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(62708);
            return null;
        }
    }
}
