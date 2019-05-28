package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import junit.framework.Assert;

public final class bi extends s {
    public static String xZb = "voip_content_voice";
    public static String xZc = "voip_content_video";
    public boolean xZd = false;
    private String xZe;

    public static final class a {
        public String dFl = "";
        public int dtS;
        private String duc;
        private String dud;
        public String duh = "";
        private String dui = "";
        public String gta = "";
        public String gwF = "";
        public String gwG = "";
        public String gwH = "";
        public String gwK = "";
        public String nickname = "";
        public String pln = "";
        public long pnz = 0;
        public int scene = 0;
        public String signature;
        private String source = "";
        public String svN = "";
        public int ufB = 0;
        public String vqs = "";
        public int xZh = 0;
        public String xZi = "";
        public String xZj = "";
        public String xZk = "";
        public String xZl = "";
        public String xZm = "";
        public String xZn = "";
        public String xZo = "";
        public String xZp = "";

        private a() {
        }

        public static a apC(String str) {
            AppMethodBeat.i(60141);
            a aVar = new a();
            String trim = bo.bc(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map z = br.z(trim, "msg");
            if (z != null) {
                try {
                    if (z.get(".msg.$fromusername") == null) {
                        aVar.svN = (String) z.get(".msg.$username");
                    } else {
                        aVar.svN = (String) z.get(".msg.$fromusername");
                    }
                    if (z.get(".msg.$fromnickname") == null) {
                        aVar.nickname = (String) z.get(".msg.$nickname");
                    } else {
                        aVar.nickname = (String) z.get(".msg.$fromnickname");
                    }
                    aVar.dFl = (String) z.get(".msg.$alias");
                    aVar.gwG = (String) z.get(".msg.$fullpy");
                    aVar.gwF = (String) z.get(".msg.$shortpy");
                    aVar.source = (String) z.get(".msg.$source");
                    aVar.xZh = bo.getInt((String) z.get(".msg.$imagestatus"), 0);
                    aVar.scene = bo.getInt((String) z.get(".msg.$scene"), 0);
                    aVar.xZi = (String) z.get(".msg.$mobileidentify");
                    aVar.xZj = (String) z.get(".msg.$mobilelongidentify");
                    if (z.get(".msg.$qqnum") != null && ((String) z.get(".msg.$qqnum")).length() > 0) {
                        aVar.pnz = bo.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    aVar.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        aVar.dtS = bo.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    aVar.dud = (String) z.get(".msg.$city");
                    aVar.duc = (String) z.get(".msg.$province");
                    aVar.gwH = (String) z.get(".msg.$qqnickname");
                    aVar.gwK = (String) z.get(".msg.$qqremark");
                    if (TextUtils.isEmpty((CharSequence) z.get(".msg.$certflag"))) {
                        trim = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        trim = (String) z.get(".msg.$certflag");
                    }
                    aVar.ufB = bo.getInt(trim, 0);
                    aVar.duh = bo.nullAsNil((String) z.get(".msg.$certinfo"));
                    aVar.pln = bo.nullAsNil((String) z.get(".msg.$brandIconUrl"));
                    aVar.dui = bo.nullAsNil((String) z.get(".msg.$regionCode"));
                    aVar.xZk = bo.nullAsNil((String) z.get(".msg.$bigheadimgurl"));
                    aVar.xZl = bo.nullAsNil((String) z.get(".msg.$smallheadimgurl"));
                    aVar.gta = bo.nullAsNil((String) z.get(".msg.$googlecontact"));
                    aVar.vqs = bo.nullAsNil((String) z.get(".msg.$antispamticket"));
                    aVar.xZm = bo.nullAsNil((String) z.get(".msg.$openimappid"));
                    aVar.xZn = bo.nullAsNil((String) z.get(".msg.$openimdesc"));
                    aVar.xZo = bo.nullAsNil((String) z.get(".msg.$openimdescicon"));
                    aVar.xZp = bo.nullAsNil((String) z.get(".msg.$openimcustominfo"));
                    if (ad.aox(aVar.svN)) {
                        aVar.vqs = bo.nullAsNil((String) z.get(".msg.$ticket"));
                    }
                    ab.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", aVar.svN, aVar.vqs, aVar.xZk, aVar.xZl);
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgInfo", "exception:%s", bo.l(e));
                }
            }
            AppMethodBeat.o(60141);
            return aVar;
        }

        public final String dtY() {
            return this.svN;
        }

        public final String getDisplayName() {
            AppMethodBeat.i(60142);
            String str;
            if (!TextUtils.isEmpty(this.nickname)) {
                str = this.nickname;
                AppMethodBeat.o(60142);
                return str;
            } else if (TextUtils.isEmpty(this.dFl)) {
                ab.f("MicroMsg.MsgInfo", "username is nullOrNil");
                str = bo.nullAsNil(this.svN);
                AppMethodBeat.o(60142);
                return str;
            } else {
                str = this.dFl;
                AppMethodBeat.o(60142);
                return str;
            }
        }

        public final String dtZ() {
            AppMethodBeat.i(60143);
            String str;
            if (this.gwK != null && this.gwK.length() > 0) {
                str = this.gwK;
                AppMethodBeat.o(60143);
                return str;
            } else if (this.gwH == null || this.gwH.length() <= 0) {
                str = Long.toString(this.pnz);
                AppMethodBeat.o(60143);
                return str;
            } else {
                str = this.gwH;
                AppMethodBeat.o(60143);
                return str;
            }
        }

        public final String getCity() {
            AppMethodBeat.i(60144);
            if (!bo.isNullOrNil(this.dui)) {
                String[] split = this.dui.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        RegionCodeDecoder.duj();
                        this.dud = RegionCodeDecoder.aD(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        RegionCodeDecoder.duj();
                        this.dud = RegionCodeDecoder.id(split[0], split[1]);
                    } else {
                        this.dud = "";
                    }
                }
            }
            String str = this.dud;
            AppMethodBeat.o(60144);
            return str;
        }

        public final String getProvince() {
            AppMethodBeat.i(60145);
            if (!bo.isNullOrNil(this.dui)) {
                String[] split = this.dui.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.apQ(split[0])) {
                        RegionCodeDecoder.duj();
                        this.duc = RegionCodeDecoder.apR(split[0]);
                    } else {
                        RegionCodeDecoder.duj();
                        this.duc = RegionCodeDecoder.id(split[0], split[1]);
                    }
                }
            }
            String str = this.duc;
            AppMethodBeat.o(60145);
            return str;
        }
    }

    public static final class b {
        public int cED = 0;
        public String eUu = "";
        public String label = "";
        public String nJB = "";
        public double nJu = 0.0d;
        public double nJv = 0.0d;
        public String svN = "";
        public String vaO = "";
        public String xZq = "";
        public String xZr = null;
        public String xZs = null;
        public String xZt = null;

        public final String toString() {
            AppMethodBeat.i(60146);
            String format = String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.nJu * 1000000.0d)), Integer.valueOf((int) (this.nJv * 1000000.0d)), Integer.valueOf(this.cED)});
            AppMethodBeat.o(60146);
            return format;
        }

        public static b apD(String str) {
            AppMethodBeat.i(60147);
            b bVar = new b();
            Map z = br.z(str, "msg");
            if (z != null) {
                bVar.svN = bo.bc((String) z.get(".msg.location.$fromusername"), "");
                bVar.nJu = bo.anm((String) z.get(".msg.location.$x"));
                bVar.nJv = bo.anm((String) z.get(".msg.location.$y"));
                bVar.label = bo.bc((String) z.get(".msg.location.$label"), "");
                bVar.xZq = bo.bc((String) z.get(".msg.location.$maptype"), "");
                bVar.cED = bo.ank((String) z.get(".msg.location.$scale"));
                bVar.xZt = bo.bc((String) z.get(".msg.location.$localLocationen"), "");
                bVar.xZr = bo.bc((String) z.get(".msg.location.$localLocationcn"), "");
                bVar.xZs = bo.bc((String) z.get(".msg.location.$localLocationtw"), "");
                bVar.eUu = bo.bc((String) z.get(".msg.location.$poiname"), "");
                bVar.vaO = bo.bc((String) z.get(".msg.location.$infourl"), "");
                bVar.nJB = bo.bc((String) z.get(".msg.location.$poiid"), "");
            }
            AppMethodBeat.o(60147);
            return bVar;
        }

        public final boolean dua() {
            AppMethodBeat.i(60148);
            if (this.eUu == null || this.eUu.equals("") || this.eUu.equals("[位置]")) {
                AppMethodBeat.o(60148);
                return false;
            }
            AppMethodBeat.o(60148);
            return true;
        }

        public final boolean dub() {
            AppMethodBeat.i(60149);
            if (Math.abs(this.nJv) > 180.0d || Math.abs(this.nJu) > 90.0d) {
                AppMethodBeat.o(60149);
                return false;
            }
            AppMethodBeat.o(60149);
            return true;
        }
    }

    public static final class c {
        public String content = "";
        public String fOt = "";
        public boolean mpz = false;
        public String ptI;
        public String title = "";
        public String xZu = "";

        private c() {
        }

        public static c apE(String str) {
            AppMethodBeat.i(60150);
            c cVar = new c();
            Map z = br.z(str, "msg");
            if (z != null) {
                try {
                    cVar.title = (String) z.get(".msg.pushmail.content.subject");
                    cVar.content = (String) z.get(".msg.pushmail.content.digest");
                    cVar.fOt = (String) z.get(".msg.pushmail.content.sender");
                    cVar.xZu = (String) z.get(".msg.pushmail.waplink");
                    cVar.mpz = bo.nullAsNil((String) z.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.ptI = (String) z.get(".msg.pushmail.mailid");
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgInfo", "exception:%s", bo.l(e));
                }
            }
            AppMethodBeat.o(60150);
            return cVar;
        }
    }

    public static final class d {
        public int cAd;
        public String chatroomName = "";
        public String content = "";
        private String countryCode;
        public String dFl = "";
        public int dtS;
        private String fno;
        private String fnp;
        public String gta;
        public String gwF = "";
        public String gwG = "";
        public String gwH = "";
        private String gwK = "";
        public String ijx;
        public String mGZ;
        public String nickname = "";
        public long pnz = 0;
        public int scene = 0;
        public String signature;
        public String svN = "";
        public String vjM;
        public String xZA;
        public int xZh = 0;
        public String xZi = "";
        public String xZj = "";
        public String xZk = "";
        public String xZl = "";
        public int xZv = 0;
        public String xZw;
        public String xZx;
        public int xZy;
        public String xZz;

        private d() {
        }

        public static d apF(String str) {
            AppMethodBeat.i(60151);
            d dVar = new d();
            Map z = br.z(str, "msg");
            if (z != null) {
                try {
                    dVar.svN = (String) z.get(".msg.$fromusername");
                    dVar.dFl = (String) z.get(".msg.$alias");
                    dVar.nickname = (String) z.get(".msg.$fromnickname");
                    dVar.gwG = (String) z.get(".msg.$fullpy");
                    dVar.gwF = (String) z.get(".msg.$shortpy");
                    dVar.content = (String) z.get(".msg.$content");
                    dVar.xZh = bo.getInt((String) z.get(".msg.$imagestatus"), 0);
                    dVar.scene = bo.getInt((String) z.get(".msg.$scene"), 0);
                    dVar.xZi = (String) z.get(".msg.$mhash");
                    dVar.xZj = (String) z.get(".msg.$mfullhash");
                    if (z.get(z.get(".msg.$qqnum")) != null && ((String) z.get(z.get(".msg.$qqnum"))).length() > 0) {
                        dVar.pnz = bo.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    dVar.gwH = (String) z.get(".msg.$qqnickname");
                    dVar.gwK = (String) z.get(".msg.$qqremark");
                    dVar.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        dVar.dtS = bo.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    dVar.fno = (String) z.get(".msg.$city");
                    dVar.fnp = (String) z.get(".msg.$province");
                    dVar.countryCode = (String) z.get(".msg.$country");
                    if (z.get(".msg.$snsflag") != null) {
                        dVar.xZv = bo.getInt((String) z.get(".msg.$snsflag"), 0);
                        dVar.xZw = (String) z.get(".msg.$snsbgimgid");
                    }
                    dVar.mGZ = (String) z.get(".msg.$ticket");
                    ab.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.mGZ);
                    dVar.xZk = bo.nullAsNil((String) z.get(".msg.$bigheadimgurl"));
                    dVar.xZl = bo.nullAsNil((String) z.get(".msg.$smallheadimgurl"));
                    dVar.cAd = bo.getInt((String) z.get(".msg.$opcode"), 0);
                    dVar.xZx = bo.nullAsNil((String) z.get(".msg.$encryptusername"));
                    dVar.gta = bo.nullAsNil((String) z.get(".msg.$googlecontact"));
                    ab.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.svN, dVar.xZk, dVar.xZl);
                    dVar.chatroomName = bo.nullAsNil((String) z.get(".msg.$chatroomusername"));
                    dVar.ijx = (String) z.get(".msg.$sourceusername");
                    dVar.vjM = (String) z.get(".msg.$sourcenickname");
                    dVar.xZy = bo.getInt((String) z.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.xZy == 1) {
                        dVar.xZz = (String) z.get(".msg.Antispam.safetyWarning");
                        dVar.xZA = (String) z.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(60151);
            return dVar;
        }

        public final String duc() {
            return this.mGZ;
        }

        public final String Hq() {
            return this.dFl;
        }

        public final String dtY() {
            return this.svN;
        }

        public final String Hs() {
            return this.nickname;
        }

        public final String getDisplayName() {
            AppMethodBeat.i(60152);
            String str;
            if (this.nickname == null || this.nickname.length() <= 0) {
                ab.f("MicroMsg.MsgInfo", "username is nullOrNil");
                str = this.svN;
                AppMethodBeat.o(60152);
                return str;
            }
            str = this.nickname;
            AppMethodBeat.o(60152);
            return str;
        }

        public final String Hu() {
            return this.gwG;
        }

        public final String Ht() {
            return this.gwF;
        }

        public final int dud() {
            return this.dtS;
        }

        public final String due() {
            return this.signature;
        }

        public final String getCity() {
            AppMethodBeat.i(60153);
            String str;
            if (bo.isNullOrNil(this.countryCode) || bo.isNullOrNil(this.fnp)) {
                str = this.fno;
                AppMethodBeat.o(60153);
                return str;
            } else if (bo.isNullOrNil(this.fno)) {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.id(this.countryCode, this.fnp);
                AppMethodBeat.o(60153);
                return str;
            } else {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.aD(this.countryCode, this.fnp, this.fno);
                AppMethodBeat.o(60153);
                return str;
            }
        }

        public final String getProvince() {
            AppMethodBeat.i(60154);
            String str;
            if (bo.isNullOrNil(this.countryCode)) {
                str = this.fnp;
                AppMethodBeat.o(60154);
                return str;
            } else if (bo.isNullOrNil(this.fnp) || bo.isNullOrNil(this.fno) || !RegionCodeDecoder.apQ(this.countryCode)) {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.apR(this.countryCode);
                AppMethodBeat.o(60154);
                return str;
            } else {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.id(this.countryCode, this.fnp);
                AppMethodBeat.o(60154);
                return str;
            }
        }

        public final String duf() {
            return this.xZx;
        }
    }

    public bi(String str) {
        AppMethodBeat.i(60155);
        super.ju(str);
        AppMethodBeat.o(60155);
    }

    public final boolean bAA() {
        AppMethodBeat.i(60156);
        if ((getType() & CdnLogic.kBizGeneric) == 49) {
            AppMethodBeat.o(60156);
            return true;
        }
        AppMethodBeat.o(60156);
        return false;
    }

    public final boolean drC() {
        AppMethodBeat.i(60157);
        if (getType() == 285212721) {
            AppMethodBeat.o(60157);
            return true;
        }
        AppMethodBeat.o(60157);
        return false;
    }

    public final boolean drD() {
        AppMethodBeat.i(60158);
        if (getType() == 34) {
            AppMethodBeat.o(60158);
            return true;
        }
        AppMethodBeat.o(60158);
        return false;
    }

    public final boolean dtp() {
        AppMethodBeat.i(60159);
        if (getType() == 436207665) {
            AppMethodBeat.o(60159);
            return true;
        }
        AppMethodBeat.o(60159);
        return false;
    }

    public final boolean dtq() {
        AppMethodBeat.i(60160);
        if (getType() == 469762097) {
            AppMethodBeat.o(60160);
            return true;
        }
        AppMethodBeat.o(60160);
        return false;
    }

    public final boolean dtr() {
        AppMethodBeat.i(60161);
        if (getType() == 301989937) {
            AppMethodBeat.o(60161);
            return true;
        }
        AppMethodBeat.o(60161);
        return false;
    }

    public final boolean dts() {
        AppMethodBeat.i(60162);
        if (getType() == 50 || getType() == 53) {
            AppMethodBeat.o(60162);
            return true;
        }
        AppMethodBeat.o(60162);
        return false;
    }

    public final boolean dtt() {
        AppMethodBeat.i(60163);
        if (getType() == 52) {
            AppMethodBeat.o(60163);
            return true;
        }
        AppMethodBeat.o(60163);
        return false;
    }

    public final boolean dtu() {
        AppMethodBeat.i(60164);
        if (getType() == 318767153) {
            AppMethodBeat.o(60164);
            return true;
        }
        AppMethodBeat.o(60164);
        return false;
    }

    public final boolean dtv() {
        AppMethodBeat.i(60165);
        if (getType() == 10002) {
            AppMethodBeat.o(60165);
            return true;
        }
        AppMethodBeat.o(60165);
        return false;
    }

    public final boolean drE() {
        AppMethodBeat.i(60166);
        switch (getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                AppMethodBeat.o(60166);
                return true;
            default:
                AppMethodBeat.o(60166);
                return false;
        }
    }

    public final boolean dtw() {
        AppMethodBeat.i(60167);
        if (getType() == 42 || getType() == 66) {
            AppMethodBeat.o(60167);
            return true;
        }
        AppMethodBeat.o(60167);
        return false;
    }

    public final boolean bAC() {
        AppMethodBeat.i(60168);
        if (getType() == 48) {
            AppMethodBeat.o(60168);
            return true;
        }
        AppMethodBeat.o(60168);
        return false;
    }

    public final boolean isText() {
        AppMethodBeat.i(60169);
        switch (getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                AppMethodBeat.o(60169);
                return true;
            default:
                AppMethodBeat.o(60169);
                return false;
        }
    }

    public final boolean isSystem() {
        AppMethodBeat.i(60170);
        if (getType() == Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.o(60170);
            return true;
        }
        AppMethodBeat.o(60170);
        return false;
    }

    public final boolean bws() {
        AppMethodBeat.i(60171);
        if (getType() == 43) {
            AppMethodBeat.o(60171);
            return true;
        }
        AppMethodBeat.o(60171);
        return false;
    }

    public final boolean bwt() {
        AppMethodBeat.i(60172);
        if (getType() == 62) {
            AppMethodBeat.o(60172);
            return true;
        }
        AppMethodBeat.o(60172);
        return false;
    }

    public final boolean dtx() {
        AppMethodBeat.i(60173);
        if (getType() == 47) {
            AppMethodBeat.o(60173);
            return true;
        }
        AppMethodBeat.o(60173);
        return false;
    }

    public final boolean dty() {
        AppMethodBeat.i(60174);
        if (getType() == 1048625) {
            AppMethodBeat.o(60174);
            return true;
        }
        AppMethodBeat.o(60174);
        return false;
    }

    public final boolean dtz() {
        AppMethodBeat.i(60175);
        if (getType() == 16777265) {
            AppMethodBeat.o(60175);
            return true;
        }
        AppMethodBeat.o(60175);
        return false;
    }

    public final boolean dtA() {
        AppMethodBeat.i(60176);
        if (getType() == 268435505) {
            AppMethodBeat.o(60176);
            return true;
        }
        AppMethodBeat.o(60176);
        return false;
    }

    public final boolean dtB() {
        AppMethodBeat.i(60177);
        if (getType() == -1879048191) {
            AppMethodBeat.o(60177);
            return true;
        }
        AppMethodBeat.o(60177);
        return false;
    }

    public final boolean dtC() {
        AppMethodBeat.i(60178);
        if (getType() == -1879048190) {
            AppMethodBeat.o(60178);
            return true;
        }
        AppMethodBeat.o(60178);
        return false;
    }

    public final boolean dtD() {
        AppMethodBeat.i(60179);
        if (getType() == -1879048189) {
            AppMethodBeat.o(60179);
            return true;
        }
        AppMethodBeat.o(60179);
        return false;
    }

    public final boolean dtE() {
        AppMethodBeat.i(60180);
        switch (getType()) {
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case e.CTRL_INDEX /*57*/:
                AppMethodBeat.o(60180);
                return true;
            default:
                AppMethodBeat.o(60180);
                return false;
        }
    }

    public final boolean dtF() {
        AppMethodBeat.i(60181);
        if (!Cj() || bo.isNullOrNil(this.field_transContent)) {
            AppMethodBeat.o(60181);
            return false;
        }
        AppMethodBeat.o(60181);
        return true;
    }

    public static bi ar(bi biVar) {
        AppMethodBeat.i(60182);
        if (biVar == null) {
            ab.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            AppMethodBeat.o(60182);
            return null;
        }
        bi biVar2 = new bi();
        biVar2.setMsgId(biVar.field_msgId);
        biVar2.eI(biVar.field_msgSvrId);
        biVar2.setType(biVar.getType());
        biVar2.setStatus(biVar.field_status);
        biVar2.hO(biVar.field_isSend);
        biVar2.field_isShowTimer = biVar.field_isShowTimer;
        biVar2.dJj = true;
        biVar2.eJ(biVar.field_createTime);
        biVar2.ju(biVar.field_talker);
        biVar2.setContent(biVar.field_content);
        biVar2.jv(biVar.field_imgPath);
        biVar2.jw(biVar.field_reserved);
        biVar2.I(biVar.field_lvbuffer);
        biVar2.jx(biVar.field_transContent);
        biVar2.jz(biVar.dJv);
        biVar2.ht(biVar.dqI);
        biVar2.ix(biVar.dqJ);
        AppMethodBeat.o(60182);
        return biVar2;
    }

    public final void setStatus(int i) {
        AppMethodBeat.i(60183);
        super.setStatus(i);
        if (this.field_isSend == 1 && dtG()) {
            if (this.field_status == 5) {
                ab.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, bo.dpG());
                qc qcVar = new qc();
                qcVar.cMs.csG = this;
                com.tencent.mm.sdk.b.a.xxA.m(qcVar);
                AppMethodBeat.o(60183);
                return;
            } else if (this.field_status == 2) {
                ab.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(getType()));
                qe qeVar = new qe();
                qeVar.cMu.csG = this;
                com.tencent.mm.sdk.b.a.xxA.m(qeVar);
                AppMethodBeat.o(60183);
                return;
            }
        } else if (this.field_isSend == 0) {
            nk nkVar = new nk();
            nkVar.cJI.csG = this;
            com.tencent.mm.sdk.b.a.xxA.m(nkVar);
        }
        AppMethodBeat.o(60183);
    }

    private boolean dtG() {
        AppMethodBeat.i(60184);
        if (isText() || bAC() || dtw()) {
            AppMethodBeat.o(60184);
            return false;
        }
        AppMethodBeat.o(60184);
        return true;
    }

    public final void dtJ() {
        AppMethodBeat.i(60186);
        if (dtK()) {
            ht(this.dqI & -33);
        }
        AppMethodBeat.o(60186);
    }

    public final boolean dtM() {
        AppMethodBeat.i(60188);
        if (!dtF() || (this.dqI & 16) <= 0) {
            AppMethodBeat.o(60188);
            return false;
        }
        AppMethodBeat.o(60188);
        return true;
    }

    public final void dtN() {
        AppMethodBeat.i(60189);
        if (dtF()) {
            ht(this.dqI | 16);
            AppMethodBeat.o(60189);
            return;
        }
        AppMethodBeat.o(60189);
    }

    public final void dtO() {
        AppMethodBeat.i(60190);
        if (dtF()) {
            ht(this.dqI & -17);
            AppMethodBeat.o(60190);
            return;
        }
        AppMethodBeat.o(60190);
    }

    public final boolean dtP() {
        AppMethodBeat.i(60191);
        if (!dtF() || (this.dqI & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            AppMethodBeat.o(60191);
            return false;
        }
        AppMethodBeat.o(60191);
        return true;
    }

    public final boolean dtS() {
        return ((this.dqI & 128) == 0 && (this.dqI & 768) == 0) ? false : true;
    }

    public final void Mr(int i) {
        AppMethodBeat.i(60194);
        switch (i) {
            case 0:
            case 1:
                ht(this.dqI | i);
                AppMethodBeat.o(60194);
                return;
            default:
                ab.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                AppMethodBeat.o(60194);
                return;
        }
    }

    private static boolean Cj() {
        AppMethodBeat.i(60195);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("TranslateMsgOff");
        if (bo.isNullOrNil(value)) {
            AppMethodBeat.o(60195);
            return true;
        } else if (bo.ank(value) != 0) {
            ab.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            AppMethodBeat.o(60195);
            return false;
        } else {
            AppMethodBeat.o(60195);
            return true;
        }
    }

    public static boolean aT(Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(60200);
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.o(60200);
        return z;
    }

    public static boolean aU(Map<String, String> map) {
        boolean z;
        AppMethodBeat.i(60201);
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.o(60201);
        return z;
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(60202);
        super.d(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append(10).append("msgSvrId = ").append(this.field_msgSvrId).append(10).append("type = ").append(getType()).append(10).append("createTime = ").append(this.field_createTime).append(10).append("talker = ").append(this.field_talker).append(10).append("flag = ").append(this.field_flag).append(10).append("content.length() = ").append(str.length()).append(10).append("content = ").append(str.substring(0, 256));
            ab.e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final bi ar = ar(this);
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(60140);
                    ((j) g.K(j.class)).bOr().a(j, ar);
                    AppMethodBeat.o(60140);
                }
            });
        }
        mS(this.field_msgId);
        AppMethodBeat.o(60202);
    }

    public static void mS(long j) {
        AppMethodBeat.i(60203);
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
        AppMethodBeat.o(60203);
    }

    public final String dtW() {
        AppMethodBeat.i(60205);
        String str;
        if (dtv()) {
            if (this.xZe == null) {
                dtX();
            }
            str = this.xZe;
            AppMethodBeat.o(60205);
            return str;
        }
        str = "";
        AppMethodBeat.o(60205);
        return str;
    }

    public final com.tencent.mm.ay.a dtX() {
        AppMethodBeat.i(60206);
        ab.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.ay.a b = com.tencent.mm.ay.a.a.b(br.z(this.field_content, "sysmsg"), this);
        if (b != null) {
            ab.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            b.aip();
            this.xZe = b.TEXT;
        } else {
            ab.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        AppMethodBeat.o(60206);
        return b;
    }

    public final int getType() {
        AppMethodBeat.i(60207);
        int type = super.getType();
        if (type == 486539313) {
            AppMethodBeat.o(60207);
            return 285212721;
        }
        AppMethodBeat.o(60207);
        return type;
    }

    public final boolean dtH() {
        return (this.dJy & 1) > 0;
    }

    public final void dtI() {
        AppMethodBeat.i(60185);
        ib(this.dJy | 1);
        AppMethodBeat.o(60185);
    }

    public final boolean dtK() {
        return (this.dqI & 32) > 0;
    }

    public final void dtL() {
        AppMethodBeat.i(60187);
        ht(this.dqI | 8);
        AppMethodBeat.o(60187);
    }

    public final void dtQ() {
        AppMethodBeat.i(60192);
        ht(this.dqI | 128);
        AppMethodBeat.o(60192);
    }

    public final void dtR() {
        AppMethodBeat.i(60193);
        ht(this.dqI & -129);
        AppMethodBeat.o(60193);
    }

    public final void dtT() {
        AppMethodBeat.i(60196);
        ht(this.dqI & -65);
        AppMethodBeat.o(60196);
    }

    public final void dtU() {
        AppMethodBeat.i(60197);
        ht(this.dqI | 64);
        AppMethodBeat.o(60197);
    }

    public final boolean apB(String str) {
        AppMethodBeat.i(60198);
        if (!(bo.isNullOrNil(this.dqJ) || bo.isNullOrNil(str))) {
            Map z = br.z(this.dqJ, "msgsource");
            if (z == null) {
                AppMethodBeat.o(60198);
                return false;
            }
            String str2 = (String) z.get(".msgsource.atuserlist");
            if (!bo.isNullOrNil(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        AppMethodBeat.o(60198);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(60198);
        return false;
    }

    public final boolean dtV() {
        boolean z;
        AppMethodBeat.i(60199);
        if (bo.isNullOrNil(this.dqJ) || !(this.dqJ.contains("announcement@all") || this.dqJ.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        ab.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        AppMethodBeat.o(60199);
        return z;
    }

    public final ContentValues Hl() {
        AppMethodBeat.i(60204);
        mS(this.field_msgId);
        ContentValues Hl = super.Hl();
        AppMethodBeat.o(60204);
        return Hl;
    }
}
