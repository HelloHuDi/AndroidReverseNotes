package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;

public final class as {
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
    public String id;
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

    public static as D(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62707);
        if (emojiInfo == null) {
            ab.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            AppMethodBeat.o(62707);
            return null;
        }
        as asVar = new as();
        asVar.cvZ = emojiInfo.field_md5;
        asVar.xYc = emojiInfo.field_type;
        asVar.xYd = emojiInfo.field_size;
        asVar.cwg = emojiInfo.field_groupId;
        asVar.xYh = emojiInfo.field_designerID;
        asVar.thumbUrl = emojiInfo.field_thumbUrl;
        asVar.cAp = emojiInfo.field_encrypturl;
        asVar.aeskey = emojiInfo.field_aeskey;
        asVar.width = emojiInfo.field_width;
        asVar.height = emojiInfo.field_height;
        asVar.nuk = emojiInfo.field_cdnUrl;
        asVar.xYi = emojiInfo.field_externUrl;
        asVar.xYj = emojiInfo.field_externMd5;
        asVar.xYl = emojiInfo.field_activityid;
        asVar.fgu = emojiInfo.field_tpurl;
        asVar.fgA = emojiInfo.field_tpauthkey;
        asVar.eyJ = emojiInfo.field_attachedText;
        asVar.lgY = emojiInfo.field_lensId;
        asVar.xYm = emojiInfo.field_attachTextColor;
        AppMethodBeat.o(62707);
        return asVar;
    }

    public static void a(as asVar, EmojiInfo emojiInfo) {
        emojiInfo.field_md5 = asVar.cvZ;
        emojiInfo.field_svrid = asVar.id;
        emojiInfo.field_type = asVar.xYc;
        emojiInfo.field_size = asVar.xYd;
        emojiInfo.field_groupId = asVar.cwg;
        emojiInfo.field_designerID = asVar.xYh;
        emojiInfo.field_thumbUrl = asVar.thumbUrl;
        emojiInfo.field_cdnUrl = asVar.nuk;
        emojiInfo.field_encrypturl = asVar.cAp;
        emojiInfo.field_aeskey = asVar.aeskey;
        emojiInfo.field_width = asVar.width;
        emojiInfo.field_height = asVar.height;
        emojiInfo.field_externUrl = asVar.xYi;
        emojiInfo.field_externMd5 = asVar.xYj;
        emojiInfo.field_activityid = asVar.xYl;
        emojiInfo.field_tpurl = asVar.fgu;
        emojiInfo.field_tpauthkey = asVar.fgA;
        emojiInfo.field_attachedText = asVar.eyJ;
        emojiInfo.field_lensId = asVar.lgY;
        emojiInfo.field_attachTextColor = asVar.xYm;
    }

    public static as a(Map<String, String> map, String str, String str2, String str3) {
        AppMethodBeat.i(62708);
        if (map == null) {
            AppMethodBeat.o(62708);
            return null;
        }
        as asVar = new as();
        asVar.xYg = str2;
        asVar.talker = str;
        asVar.id = (String) map.get(".msg.emoji.$idbuffer");
        asVar.fWW = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        asVar.cvZ = str4;
        if (str4 == null) {
            asVar.cvZ = (String) map.get(".msg.emoji.$md5");
        }
        if (!bo.isNullOrNil(asVar.cvZ)) {
            asVar.cvZ = asVar.cvZ.toLowerCase();
        }
        try {
            asVar.xYc = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                asVar.xYd = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                asVar.xYd = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                asVar.xYe = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                asVar.xYf = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                asVar.cwg = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                asVar.nuk = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$tpurl") != null) {
                asVar.fgu = (String) map.get(".msg.emoji.$tpurl");
            }
            if (map.get(".msg.emoji.$tpauthkey") != null) {
                asVar.fgA = (String) map.get(".msg.emoji.$tpauthkey");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                asVar.xYh = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                asVar.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                asVar.cAp = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                asVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                asVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                asVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                asVar.xYi = (String) map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                asVar.xYj = (String) map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                asVar.xYl = (String) map.get(".msg.emoji.$activityid");
            }
            if (map.get(".msg.emoji.$attachedtext") != null) {
                asVar.eyJ = (String) map.get(".msg.emoji.$attachedtext");
            }
            if (map.get(".msg.emoji.$attachedtextcolor") != null) {
                asVar.xYm = (String) map.get(".msg.emoji.$attachedtextcolor");
            }
            if (map.get(".msg.emoji.$lensid") != null) {
                asVar.lgY = (String) map.get(".msg.emoji.$lensid");
            }
            if (!bo.isNullOrNil(str3)) {
                asVar.dqJ = str3;
            }
            ab.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s tpUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", asVar.id, asVar.cvZ, Integer.valueOf(asVar.xYc), Integer.valueOf(asVar.xYd), Integer.valueOf(asVar.xYe), Integer.valueOf(asVar.xYf), asVar.cwg, asVar.nuk, asVar.fgu, asVar.xYh, asVar.thumbUrl, asVar.cAp, Integer.valueOf(asVar.width), Integer.valueOf(asVar.height), asVar.xYi, asVar.xYj);
            AppMethodBeat.o(62708);
            return asVar;
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", bo.l(e));
            AppMethodBeat.o(62708);
            return null;
        }
    }
}
