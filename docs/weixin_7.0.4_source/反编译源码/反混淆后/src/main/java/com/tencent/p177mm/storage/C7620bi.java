package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p181af.C7471s;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C1304a.C1302a;
import com.tencent.p177mm.p230g.p231a.C6527nk;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C6542qe;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.bi */
public final class C7620bi extends C7471s {
    public static String xZb = "voip_content_voice";
    public static String xZc = "voip_content_video";
    public boolean xZd = false;
    private String xZe;

    /* renamed from: com.tencent.mm.storage.bi$a */
    public static final class C5135a {
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

        private C5135a() {
        }

        public static C5135a apC(String str) {
            AppMethodBeat.m2504i(60141);
            C5135a c5135a = new C5135a();
            String trim = C5046bo.m7532bc(str, "").trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map z = C5049br.m7595z(trim, "msg");
            if (z != null) {
                try {
                    if (z.get(".msg.$fromusername") == null) {
                        c5135a.svN = (String) z.get(".msg.$username");
                    } else {
                        c5135a.svN = (String) z.get(".msg.$fromusername");
                    }
                    if (z.get(".msg.$fromnickname") == null) {
                        c5135a.nickname = (String) z.get(".msg.$nickname");
                    } else {
                        c5135a.nickname = (String) z.get(".msg.$fromnickname");
                    }
                    c5135a.dFl = (String) z.get(".msg.$alias");
                    c5135a.gwG = (String) z.get(".msg.$fullpy");
                    c5135a.gwF = (String) z.get(".msg.$shortpy");
                    c5135a.source = (String) z.get(".msg.$source");
                    c5135a.xZh = C5046bo.getInt((String) z.get(".msg.$imagestatus"), 0);
                    c5135a.scene = C5046bo.getInt((String) z.get(".msg.$scene"), 0);
                    c5135a.xZi = (String) z.get(".msg.$mobileidentify");
                    c5135a.xZj = (String) z.get(".msg.$mobilelongidentify");
                    if (z.get(".msg.$qqnum") != null && ((String) z.get(".msg.$qqnum")).length() > 0) {
                        c5135a.pnz = C5046bo.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    c5135a.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        c5135a.dtS = C5046bo.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    c5135a.dud = (String) z.get(".msg.$city");
                    c5135a.duc = (String) z.get(".msg.$province");
                    c5135a.gwH = (String) z.get(".msg.$qqnickname");
                    c5135a.gwK = (String) z.get(".msg.$qqremark");
                    if (TextUtils.isEmpty((CharSequence) z.get(".msg.$certflag"))) {
                        trim = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } else {
                        trim = (String) z.get(".msg.$certflag");
                    }
                    c5135a.ufB = C5046bo.getInt(trim, 0);
                    c5135a.duh = C5046bo.nullAsNil((String) z.get(".msg.$certinfo"));
                    c5135a.pln = C5046bo.nullAsNil((String) z.get(".msg.$brandIconUrl"));
                    c5135a.dui = C5046bo.nullAsNil((String) z.get(".msg.$regionCode"));
                    c5135a.xZk = C5046bo.nullAsNil((String) z.get(".msg.$bigheadimgurl"));
                    c5135a.xZl = C5046bo.nullAsNil((String) z.get(".msg.$smallheadimgurl"));
                    c5135a.gta = C5046bo.nullAsNil((String) z.get(".msg.$googlecontact"));
                    c5135a.vqs = C5046bo.nullAsNil((String) z.get(".msg.$antispamticket"));
                    c5135a.xZm = C5046bo.nullAsNil((String) z.get(".msg.$openimappid"));
                    c5135a.xZn = C5046bo.nullAsNil((String) z.get(".msg.$openimdesc"));
                    c5135a.xZo = C5046bo.nullAsNil((String) z.get(".msg.$openimdescicon"));
                    c5135a.xZp = C5046bo.nullAsNil((String) z.get(".msg.$openimcustominfo"));
                    if (C7616ad.aox(c5135a.svN)) {
                        c5135a.vqs = C5046bo.nullAsNil((String) z.get(".msg.$ticket"));
                    }
                    C4990ab.m7417i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", c5135a.svN, c5135a.vqs, c5135a.xZk, c5135a.xZl);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MsgInfo", "exception:%s", C5046bo.m7574l(e));
                }
            }
            AppMethodBeat.m2505o(60141);
            return c5135a;
        }

        public final String dtY() {
            return this.svN;
        }

        public final String getDisplayName() {
            AppMethodBeat.m2504i(60142);
            String str;
            if (!TextUtils.isEmpty(this.nickname)) {
                str = this.nickname;
                AppMethodBeat.m2505o(60142);
                return str;
            } else if (TextUtils.isEmpty(this.dFl)) {
                C4990ab.m7414f("MicroMsg.MsgInfo", "username is nullOrNil");
                str = C5046bo.nullAsNil(this.svN);
                AppMethodBeat.m2505o(60142);
                return str;
            } else {
                str = this.dFl;
                AppMethodBeat.m2505o(60142);
                return str;
            }
        }

        public final String dtZ() {
            AppMethodBeat.m2504i(60143);
            String str;
            if (this.gwK != null && this.gwK.length() > 0) {
                str = this.gwK;
                AppMethodBeat.m2505o(60143);
                return str;
            } else if (this.gwH == null || this.gwH.length() <= 0) {
                str = Long.toString(this.pnz);
                AppMethodBeat.m2505o(60143);
                return str;
            } else {
                str = this.gwH;
                AppMethodBeat.m2505o(60143);
                return str;
            }
        }

        public final String getCity() {
            AppMethodBeat.m2504i(60144);
            if (!C5046bo.isNullOrNil(this.dui)) {
                String[] split = this.dui.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        RegionCodeDecoder.duj();
                        this.dud = RegionCodeDecoder.m7797aD(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        RegionCodeDecoder.duj();
                        this.dud = RegionCodeDecoder.m7798id(split[0], split[1]);
                    } else {
                        this.dud = "";
                    }
                }
            }
            String str = this.dud;
            AppMethodBeat.m2505o(60144);
            return str;
        }

        public final String getProvince() {
            AppMethodBeat.m2504i(60145);
            if (!C5046bo.isNullOrNil(this.dui)) {
                String[] split = this.dui.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.apQ(split[0])) {
                        RegionCodeDecoder.duj();
                        this.duc = RegionCodeDecoder.apR(split[0]);
                    } else {
                        RegionCodeDecoder.duj();
                        this.duc = RegionCodeDecoder.m7798id(split[0], split[1]);
                    }
                }
            }
            String str = this.duc;
            AppMethodBeat.m2505o(60145);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.storage.bi$b */
    public static final class C5136b {
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
            AppMethodBeat.m2504i(60146);
            String format = String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.nJu * 1000000.0d)), Integer.valueOf((int) (this.nJv * 1000000.0d)), Integer.valueOf(this.cED)});
            AppMethodBeat.m2505o(60146);
            return format;
        }

        public static C5136b apD(String str) {
            AppMethodBeat.m2504i(60147);
            C5136b c5136b = new C5136b();
            Map z = C5049br.m7595z(str, "msg");
            if (z != null) {
                c5136b.svN = C5046bo.m7532bc((String) z.get(".msg.location.$fromusername"), "");
                c5136b.nJu = C5046bo.anm((String) z.get(".msg.location.$x"));
                c5136b.nJv = C5046bo.anm((String) z.get(".msg.location.$y"));
                c5136b.label = C5046bo.m7532bc((String) z.get(".msg.location.$label"), "");
                c5136b.xZq = C5046bo.m7532bc((String) z.get(".msg.location.$maptype"), "");
                c5136b.cED = C5046bo.ank((String) z.get(".msg.location.$scale"));
                c5136b.xZt = C5046bo.m7532bc((String) z.get(".msg.location.$localLocationen"), "");
                c5136b.xZr = C5046bo.m7532bc((String) z.get(".msg.location.$localLocationcn"), "");
                c5136b.xZs = C5046bo.m7532bc((String) z.get(".msg.location.$localLocationtw"), "");
                c5136b.eUu = C5046bo.m7532bc((String) z.get(".msg.location.$poiname"), "");
                c5136b.vaO = C5046bo.m7532bc((String) z.get(".msg.location.$infourl"), "");
                c5136b.nJB = C5046bo.m7532bc((String) z.get(".msg.location.$poiid"), "");
            }
            AppMethodBeat.m2505o(60147);
            return c5136b;
        }

        public final boolean dua() {
            AppMethodBeat.m2504i(60148);
            if (this.eUu == null || this.eUu.equals("") || this.eUu.equals("[位置]")) {
                AppMethodBeat.m2505o(60148);
                return false;
            }
            AppMethodBeat.m2505o(60148);
            return true;
        }

        public final boolean dub() {
            AppMethodBeat.m2504i(60149);
            if (Math.abs(this.nJv) > 180.0d || Math.abs(this.nJu) > 90.0d) {
                AppMethodBeat.m2505o(60149);
                return false;
            }
            AppMethodBeat.m2505o(60149);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.storage.bi$c */
    public static final class C5137c {
        public String content = "";
        public String fOt = "";
        public boolean mpz = false;
        public String ptI;
        public String title = "";
        public String xZu = "";

        private C5137c() {
        }

        public static C5137c apE(String str) {
            AppMethodBeat.m2504i(60150);
            C5137c c5137c = new C5137c();
            Map z = C5049br.m7595z(str, "msg");
            if (z != null) {
                try {
                    c5137c.title = (String) z.get(".msg.pushmail.content.subject");
                    c5137c.content = (String) z.get(".msg.pushmail.content.digest");
                    c5137c.fOt = (String) z.get(".msg.pushmail.content.sender");
                    c5137c.xZu = (String) z.get(".msg.pushmail.waplink");
                    c5137c.mpz = C5046bo.nullAsNil((String) z.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    c5137c.ptI = (String) z.get(".msg.pushmail.mailid");
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MsgInfo", "exception:%s", C5046bo.m7574l(e));
                }
            }
            AppMethodBeat.m2505o(60150);
            return c5137c;
        }
    }

    /* renamed from: com.tencent.mm.storage.bi$d */
    public static final class C5138d {
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

        private C5138d() {
        }

        public static C5138d apF(String str) {
            AppMethodBeat.m2504i(60151);
            C5138d c5138d = new C5138d();
            Map z = C5049br.m7595z(str, "msg");
            if (z != null) {
                try {
                    c5138d.svN = (String) z.get(".msg.$fromusername");
                    c5138d.dFl = (String) z.get(".msg.$alias");
                    c5138d.nickname = (String) z.get(".msg.$fromnickname");
                    c5138d.gwG = (String) z.get(".msg.$fullpy");
                    c5138d.gwF = (String) z.get(".msg.$shortpy");
                    c5138d.content = (String) z.get(".msg.$content");
                    c5138d.xZh = C5046bo.getInt((String) z.get(".msg.$imagestatus"), 0);
                    c5138d.scene = C5046bo.getInt((String) z.get(".msg.$scene"), 0);
                    c5138d.xZi = (String) z.get(".msg.$mhash");
                    c5138d.xZj = (String) z.get(".msg.$mfullhash");
                    if (z.get(z.get(".msg.$qqnum")) != null && ((String) z.get(z.get(".msg.$qqnum"))).length() > 0) {
                        c5138d.pnz = C5046bo.getLong((String) z.get(".msg.$qqnum"), 0);
                    }
                    c5138d.gwH = (String) z.get(".msg.$qqnickname");
                    c5138d.gwK = (String) z.get(".msg.$qqremark");
                    c5138d.signature = (String) z.get(".msg.$sign");
                    if (z.get(".msg.$sex") != null && ((String) z.get(".msg.$sex")).length() > 0) {
                        c5138d.dtS = C5046bo.getInt((String) z.get(".msg.$sex"), 0);
                    }
                    c5138d.fno = (String) z.get(".msg.$city");
                    c5138d.fnp = (String) z.get(".msg.$province");
                    c5138d.countryCode = (String) z.get(".msg.$country");
                    if (z.get(".msg.$snsflag") != null) {
                        c5138d.xZv = C5046bo.getInt((String) z.get(".msg.$snsflag"), 0);
                        c5138d.xZw = (String) z.get(".msg.$snsbgimgid");
                    }
                    c5138d.mGZ = (String) z.get(".msg.$ticket");
                    C4990ab.m7411d("MicroMsg.MsgInfo", "dkverify ticket:%s", c5138d.mGZ);
                    c5138d.xZk = C5046bo.nullAsNil((String) z.get(".msg.$bigheadimgurl"));
                    c5138d.xZl = C5046bo.nullAsNil((String) z.get(".msg.$smallheadimgurl"));
                    c5138d.cAd = C5046bo.getInt((String) z.get(".msg.$opcode"), 0);
                    c5138d.xZx = C5046bo.nullAsNil((String) z.get(".msg.$encryptusername"));
                    c5138d.gta = C5046bo.nullAsNil((String) z.get(".msg.$googlecontact"));
                    C4990ab.m7411d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", c5138d.svN, c5138d.xZk, c5138d.xZl);
                    c5138d.chatroomName = C5046bo.nullAsNil((String) z.get(".msg.$chatroomusername"));
                    c5138d.ijx = (String) z.get(".msg.$sourceusername");
                    c5138d.vjM = (String) z.get(".msg.$sourcenickname");
                    c5138d.xZy = C5046bo.getInt((String) z.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (c5138d.xZy == 1) {
                        c5138d.xZz = (String) z.get(".msg.Antispam.safetyWarning");
                        c5138d.xZA = (String) z.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MsgInfo", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(60151);
            return c5138d;
        }

        public final String duc() {
            return this.mGZ;
        }

        /* renamed from: Hq */
        public final String mo10543Hq() {
            return this.dFl;
        }

        public final String dtY() {
            return this.svN;
        }

        /* renamed from: Hs */
        public final String mo10544Hs() {
            return this.nickname;
        }

        public final String getDisplayName() {
            AppMethodBeat.m2504i(60152);
            String str;
            if (this.nickname == null || this.nickname.length() <= 0) {
                C4990ab.m7414f("MicroMsg.MsgInfo", "username is nullOrNil");
                str = this.svN;
                AppMethodBeat.m2505o(60152);
                return str;
            }
            str = this.nickname;
            AppMethodBeat.m2505o(60152);
            return str;
        }

        /* renamed from: Hu */
        public final String mo10546Hu() {
            return this.gwG;
        }

        /* renamed from: Ht */
        public final String mo10545Ht() {
            return this.gwF;
        }

        public final int dud() {
            return this.dtS;
        }

        public final String due() {
            return this.signature;
        }

        public final String getCity() {
            AppMethodBeat.m2504i(60153);
            String str;
            if (C5046bo.isNullOrNil(this.countryCode) || C5046bo.isNullOrNil(this.fnp)) {
                str = this.fno;
                AppMethodBeat.m2505o(60153);
                return str;
            } else if (C5046bo.isNullOrNil(this.fno)) {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.m7798id(this.countryCode, this.fnp);
                AppMethodBeat.m2505o(60153);
                return str;
            } else {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.m7797aD(this.countryCode, this.fnp, this.fno);
                AppMethodBeat.m2505o(60153);
                return str;
            }
        }

        public final String getProvince() {
            AppMethodBeat.m2504i(60154);
            String str;
            if (C5046bo.isNullOrNil(this.countryCode)) {
                str = this.fnp;
                AppMethodBeat.m2505o(60154);
                return str;
            } else if (C5046bo.isNullOrNil(this.fnp) || C5046bo.isNullOrNil(this.fno) || !RegionCodeDecoder.apQ(this.countryCode)) {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.apR(this.countryCode);
                AppMethodBeat.m2505o(60154);
                return str;
            } else {
                RegionCodeDecoder.duj();
                str = RegionCodeDecoder.m7798id(this.countryCode, this.fnp);
                AppMethodBeat.m2505o(60154);
                return str;
            }
        }

        public final String duf() {
            return this.xZx;
        }
    }

    public C7620bi(String str) {
        AppMethodBeat.m2504i(60155);
        super.mo14794ju(str);
        AppMethodBeat.m2505o(60155);
    }

    public final boolean bAA() {
        AppMethodBeat.m2504i(60156);
        if ((getType() & CdnLogic.kBizGeneric) == 49) {
            AppMethodBeat.m2505o(60156);
            return true;
        }
        AppMethodBeat.m2505o(60156);
        return false;
    }

    public final boolean drC() {
        AppMethodBeat.m2504i(60157);
        if (getType() == 285212721) {
            AppMethodBeat.m2505o(60157);
            return true;
        }
        AppMethodBeat.m2505o(60157);
        return false;
    }

    public final boolean drD() {
        AppMethodBeat.m2504i(60158);
        if (getType() == 34) {
            AppMethodBeat.m2505o(60158);
            return true;
        }
        AppMethodBeat.m2505o(60158);
        return false;
    }

    public final boolean dtp() {
        AppMethodBeat.m2504i(60159);
        if (getType() == 436207665) {
            AppMethodBeat.m2505o(60159);
            return true;
        }
        AppMethodBeat.m2505o(60159);
        return false;
    }

    public final boolean dtq() {
        AppMethodBeat.m2504i(60160);
        if (getType() == 469762097) {
            AppMethodBeat.m2505o(60160);
            return true;
        }
        AppMethodBeat.m2505o(60160);
        return false;
    }

    public final boolean dtr() {
        AppMethodBeat.m2504i(60161);
        if (getType() == 301989937) {
            AppMethodBeat.m2505o(60161);
            return true;
        }
        AppMethodBeat.m2505o(60161);
        return false;
    }

    public final boolean dts() {
        AppMethodBeat.m2504i(60162);
        if (getType() == 50 || getType() == 53) {
            AppMethodBeat.m2505o(60162);
            return true;
        }
        AppMethodBeat.m2505o(60162);
        return false;
    }

    public final boolean dtt() {
        AppMethodBeat.m2504i(60163);
        if (getType() == 52) {
            AppMethodBeat.m2505o(60163);
            return true;
        }
        AppMethodBeat.m2505o(60163);
        return false;
    }

    public final boolean dtu() {
        AppMethodBeat.m2504i(60164);
        if (getType() == 318767153) {
            AppMethodBeat.m2505o(60164);
            return true;
        }
        AppMethodBeat.m2505o(60164);
        return false;
    }

    public final boolean dtv() {
        AppMethodBeat.m2504i(60165);
        if (getType() == 10002) {
            AppMethodBeat.m2505o(60165);
            return true;
        }
        AppMethodBeat.m2505o(60165);
        return false;
    }

    public final boolean drE() {
        AppMethodBeat.m2504i(60166);
        switch (getType()) {
            case 3:
            case 13:
            case 23:
            case 33:
            case 39:
                AppMethodBeat.m2505o(60166);
                return true;
            default:
                AppMethodBeat.m2505o(60166);
                return false;
        }
    }

    public final boolean dtw() {
        AppMethodBeat.m2504i(60167);
        if (getType() == 42 || getType() == 66) {
            AppMethodBeat.m2505o(60167);
            return true;
        }
        AppMethodBeat.m2505o(60167);
        return false;
    }

    public final boolean bAC() {
        AppMethodBeat.m2504i(60168);
        if (getType() == 48) {
            AppMethodBeat.m2505o(60168);
            return true;
        }
        AppMethodBeat.m2505o(60168);
        return false;
    }

    public final boolean isText() {
        AppMethodBeat.m2504i(60169);
        switch (getType()) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                AppMethodBeat.m2505o(60169);
                return true;
            default:
                AppMethodBeat.m2505o(60169);
                return false;
        }
    }

    public final boolean isSystem() {
        AppMethodBeat.m2504i(60170);
        if (getType() == Downloads.MIN_WAIT_FOR_NETWORK) {
            AppMethodBeat.m2505o(60170);
            return true;
        }
        AppMethodBeat.m2505o(60170);
        return false;
    }

    public final boolean bws() {
        AppMethodBeat.m2504i(60171);
        if (getType() == 43) {
            AppMethodBeat.m2505o(60171);
            return true;
        }
        AppMethodBeat.m2505o(60171);
        return false;
    }

    public final boolean bwt() {
        AppMethodBeat.m2504i(60172);
        if (getType() == 62) {
            AppMethodBeat.m2505o(60172);
            return true;
        }
        AppMethodBeat.m2505o(60172);
        return false;
    }

    public final boolean dtx() {
        AppMethodBeat.m2504i(60173);
        if (getType() == 47) {
            AppMethodBeat.m2505o(60173);
            return true;
        }
        AppMethodBeat.m2505o(60173);
        return false;
    }

    public final boolean dty() {
        AppMethodBeat.m2504i(60174);
        if (getType() == 1048625) {
            AppMethodBeat.m2505o(60174);
            return true;
        }
        AppMethodBeat.m2505o(60174);
        return false;
    }

    public final boolean dtz() {
        AppMethodBeat.m2504i(60175);
        if (getType() == 16777265) {
            AppMethodBeat.m2505o(60175);
            return true;
        }
        AppMethodBeat.m2505o(60175);
        return false;
    }

    public final boolean dtA() {
        AppMethodBeat.m2504i(60176);
        if (getType() == 268435505) {
            AppMethodBeat.m2505o(60176);
            return true;
        }
        AppMethodBeat.m2505o(60176);
        return false;
    }

    public final boolean dtB() {
        AppMethodBeat.m2504i(60177);
        if (getType() == -1879048191) {
            AppMethodBeat.m2505o(60177);
            return true;
        }
        AppMethodBeat.m2505o(60177);
        return false;
    }

    public final boolean dtC() {
        AppMethodBeat.m2504i(60178);
        if (getType() == -1879048190) {
            AppMethodBeat.m2505o(60178);
            return true;
        }
        AppMethodBeat.m2505o(60178);
        return false;
    }

    public final boolean dtD() {
        AppMethodBeat.m2504i(60179);
        if (getType() == -1879048189) {
            AppMethodBeat.m2505o(60179);
            return true;
        }
        AppMethodBeat.m2505o(60179);
        return false;
    }

    public final boolean dtE() {
        AppMethodBeat.m2504i(60180);
        switch (getType()) {
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case C19410e.CTRL_INDEX /*57*/:
                AppMethodBeat.m2505o(60180);
                return true;
            default:
                AppMethodBeat.m2505o(60180);
                return false;
        }
    }

    public final boolean dtF() {
        AppMethodBeat.m2504i(60181);
        if (!C7620bi.m13566Cj() || C5046bo.isNullOrNil(this.field_transContent)) {
            AppMethodBeat.m2505o(60181);
            return false;
        }
        AppMethodBeat.m2505o(60181);
        return true;
    }

    /* renamed from: ar */
    public static C7620bi m13569ar(C7620bi c7620bi) {
        AppMethodBeat.m2504i(60182);
        if (c7620bi == null) {
            C4990ab.m7410d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            AppMethodBeat.m2505o(60182);
            return null;
        }
        C7620bi c7620bi2 = new C7620bi();
        c7620bi2.setMsgId(c7620bi.field_msgId);
        c7620bi2.mo14774eI(c7620bi.field_msgSvrId);
        c7620bi2.setType(c7620bi.getType());
        c7620bi2.setStatus(c7620bi.field_status);
        c7620bi2.mo14781hO(c7620bi.field_isSend);
        c7620bi2.field_isShowTimer = c7620bi.field_isShowTimer;
        c7620bi2.dJj = true;
        c7620bi2.mo14775eJ(c7620bi.field_createTime);
        c7620bi2.mo14794ju(c7620bi.field_talker);
        c7620bi2.setContent(c7620bi.field_content);
        c7620bi2.mo14795jv(c7620bi.field_imgPath);
        c7620bi2.mo14796jw(c7620bi.field_reserved);
        c7620bi2.mo14773I(c7620bi.field_lvbuffer);
        c7620bi2.mo14797jx(c7620bi.field_transContent);
        c7620bi2.mo14799jz(c7620bi.dJv);
        c7620bi2.mo14785ht(c7620bi.dqI);
        c7620bi2.mo14791ix(c7620bi.dqJ);
        AppMethodBeat.m2505o(60182);
        return c7620bi2;
    }

    public final void setStatus(int i) {
        AppMethodBeat.m2504i(60183);
        super.setStatus(i);
        if (this.field_isSend == 1 && dtG()) {
            if (this.field_status == 5) {
                C4990ab.m7413e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(getType()), this.field_talker, C5046bo.dpG());
                C6541qc c6541qc = new C6541qc();
                c6541qc.cMs.csG = this;
                C4879a.xxA.mo10055m(c6541qc);
                AppMethodBeat.m2505o(60183);
                return;
            } else if (this.field_status == 2) {
                C4990ab.m7411d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(getType()));
                C6542qe c6542qe = new C6542qe();
                c6542qe.cMu.csG = this;
                C4879a.xxA.mo10055m(c6542qe);
                AppMethodBeat.m2505o(60183);
                return;
            }
        } else if (this.field_isSend == 0) {
            C6527nk c6527nk = new C6527nk();
            c6527nk.cJI.csG = this;
            C4879a.xxA.mo10055m(c6527nk);
        }
        AppMethodBeat.m2505o(60183);
    }

    private boolean dtG() {
        AppMethodBeat.m2504i(60184);
        if (isText() || bAC() || dtw()) {
            AppMethodBeat.m2505o(60184);
            return false;
        }
        AppMethodBeat.m2505o(60184);
        return true;
    }

    public final void dtJ() {
        AppMethodBeat.m2504i(60186);
        if (dtK()) {
            mo14785ht(this.dqI & -33);
        }
        AppMethodBeat.m2505o(60186);
    }

    public final boolean dtM() {
        AppMethodBeat.m2504i(60188);
        if (!dtF() || (this.dqI & 16) <= 0) {
            AppMethodBeat.m2505o(60188);
            return false;
        }
        AppMethodBeat.m2505o(60188);
        return true;
    }

    public final void dtN() {
        AppMethodBeat.m2504i(60189);
        if (dtF()) {
            mo14785ht(this.dqI | 16);
            AppMethodBeat.m2505o(60189);
            return;
        }
        AppMethodBeat.m2505o(60189);
    }

    public final void dtO() {
        AppMethodBeat.m2504i(60190);
        if (dtF()) {
            mo14785ht(this.dqI & -17);
            AppMethodBeat.m2505o(60190);
            return;
        }
        AppMethodBeat.m2505o(60190);
    }

    public final boolean dtP() {
        AppMethodBeat.m2504i(60191);
        if (!dtF() || (this.dqI & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            AppMethodBeat.m2505o(60191);
            return false;
        }
        AppMethodBeat.m2505o(60191);
        return true;
    }

    public final boolean dtS() {
        return ((this.dqI & 128) == 0 && (this.dqI & 768) == 0) ? false : true;
    }

    /* renamed from: Mr */
    public final void mo17082Mr(int i) {
        AppMethodBeat.m2504i(60194);
        switch (i) {
            case 0:
            case 1:
                mo14785ht(this.dqI | i);
                AppMethodBeat.m2505o(60194);
                return;
            default:
                C4990ab.m7420w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                AppMethodBeat.m2505o(60194);
                return;
        }
    }

    /* renamed from: Cj */
    private static boolean m13566Cj() {
        AppMethodBeat.m2504i(60195);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("TranslateMsgOff");
        if (C5046bo.isNullOrNil(value)) {
            AppMethodBeat.m2505o(60195);
            return true;
        } else if (C5046bo.ank(value) != 0) {
            C4990ab.m7410d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            AppMethodBeat.m2505o(60195);
            return false;
        } else {
            AppMethodBeat.m2505o(60195);
            return true;
        }
    }

    /* renamed from: aT */
    public static boolean m13567aT(Map<String, String> map) {
        boolean z;
        AppMethodBeat.m2504i(60200);
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(60200);
        return z;
    }

    /* renamed from: aU */
    public static boolean m13568aU(Map<String, String> map) {
        boolean z;
        AppMethodBeat.m2504i(60201);
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(60201);
        return z;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(60202);
        super.mo8995d(cursor);
        String str = this.field_content;
        if (str != null && str.length() > 2097152) {
            final long j = this.field_msgId;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append("Very big message: \nmsgId = ").append(j).append(10).append("msgSvrId = ").append(this.field_msgSvrId).append(10).append("type = ").append(getType()).append(10).append("createTime = ").append(this.field_createTime).append(10).append("talker = ").append(this.field_talker).append(10).append("flag = ").append(this.field_flag).append(10).append("content.length() = ").append(str.length()).append(10).append("content = ").append(str.substring(0, 256));
            C4990ab.m7412e("MicroMsg.MsgInfo", stringBuilder.toString());
            setType(1);
            setContent("");
            final C7620bi ar = C7620bi.m13569ar(this);
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(60140);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, ar);
                    AppMethodBeat.m2505o(60140);
                }
            });
        }
        C7620bi.m13570mS(this.field_msgId);
        AppMethodBeat.m2505o(60202);
    }

    /* renamed from: mS */
    public static void m13570mS(long j) {
        AppMethodBeat.m2504i(60203);
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
        AppMethodBeat.m2505o(60203);
    }

    public final String dtW() {
        AppMethodBeat.m2504i(60205);
        String str;
        if (dtv()) {
            if (this.xZe == null) {
                dtX();
            }
            str = this.xZe;
            AppMethodBeat.m2505o(60205);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(60205);
        return str;
    }

    public final C1304a dtX() {
        AppMethodBeat.m2504i(60206);
        C4990ab.m7416i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        C1304a b = C1302a.m2778b(C5049br.m7595z(this.field_content, "sysmsg"), this);
        if (b != null) {
            C4990ab.m7417i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            b.aip();
            this.xZe = b.TEXT;
        } else {
            C4990ab.m7412e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        AppMethodBeat.m2505o(60206);
        return b;
    }

    public final int getType() {
        AppMethodBeat.m2504i(60207);
        int type = super.getType();
        if (type == 486539313) {
            AppMethodBeat.m2505o(60207);
            return 285212721;
        }
        AppMethodBeat.m2505o(60207);
        return type;
    }

    public final boolean dtH() {
        return (this.dJy & 1) > 0;
    }

    public final void dtI() {
        AppMethodBeat.m2504i(60185);
        mo14787ib(this.dJy | 1);
        AppMethodBeat.m2505o(60185);
    }

    public final boolean dtK() {
        return (this.dqI & 32) > 0;
    }

    public final void dtL() {
        AppMethodBeat.m2504i(60187);
        mo14785ht(this.dqI | 8);
        AppMethodBeat.m2505o(60187);
    }

    public final void dtQ() {
        AppMethodBeat.m2504i(60192);
        mo14785ht(this.dqI | 128);
        AppMethodBeat.m2505o(60192);
    }

    public final void dtR() {
        AppMethodBeat.m2504i(60193);
        mo14785ht(this.dqI & -129);
        AppMethodBeat.m2505o(60193);
    }

    public final void dtT() {
        AppMethodBeat.m2504i(60196);
        mo14785ht(this.dqI & -65);
        AppMethodBeat.m2505o(60196);
    }

    public final void dtU() {
        AppMethodBeat.m2504i(60197);
        mo14785ht(this.dqI | 64);
        AppMethodBeat.m2505o(60197);
    }

    public final boolean apB(String str) {
        AppMethodBeat.m2504i(60198);
        if (!(C5046bo.isNullOrNil(this.dqJ) || C5046bo.isNullOrNil(str))) {
            Map z = C5049br.m7595z(this.dqJ, "msgsource");
            if (z == null) {
                AppMethodBeat.m2505o(60198);
                return false;
            }
            String str2 = (String) z.get(".msgsource.atuserlist");
            if (!C5046bo.isNullOrNil(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        AppMethodBeat.m2505o(60198);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(60198);
        return false;
    }

    public final boolean dtV() {
        boolean z;
        AppMethodBeat.m2504i(60199);
        if (C5046bo.isNullOrNil(this.dqJ) || !(this.dqJ.contains("announcement@all") || this.dqJ.contains("notify@all"))) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7411d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(60199);
        return z;
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        AppMethodBeat.m2504i(60204);
        C7620bi.m13570mS(this.field_msgId);
        ContentValues Hl = super.mo10098Hl();
        AppMethodBeat.m2505o(60204);
        return Hl;
    }
}
