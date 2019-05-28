package com.tencent.p177mm.plugin.scanner.util;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.scanner.C28892c;
import com.tencent.p177mm.plugin.scanner.p504ui.C13161i;
import com.tencent.p177mm.plugin.scanner.p504ui.ProductUI;
import com.tencent.p177mm.plugin.scanner.p740a.C43482a;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.util.o */
public final class C43494o {

    /* renamed from: com.tencent.mm.plugin.scanner.util.o$a */
    public static class C13185a {
        public String field_certification;
        public String field_certificationurl;
        public String field_detailurl;
        public String field_exposeurl;
        public String field_extinfo;
        public String field_feedbackurl;
        public int field_functionType;
        public int field_getaction;
        public String field_headerbackgroundurl;
        public String field_headermask;
        public String field_introlink;
        public String field_introtitle;
        public String field_playurl;
        public String field_productid;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public int field_type;
        public String field_xml;
        public int field_xmlType;
        public LinkedList<C43482a> qiL;
        public C13186a qiM;

        /* renamed from: com.tencent.mm.plugin.scanner.util.o$a$a */
        public static class C13186a {
            public LinkedList<C13187a> qiN;
            public LinkedList<C13184b> qiO;

            /* renamed from: com.tencent.mm.plugin.scanner.util.o$a$a$b */
            public static class C13184b {
                public String desc;
                public String title;
            }

            /* renamed from: com.tencent.mm.plugin.scanner.util.o$a$a$a */
            public static class C13187a {
                public String link;
            }
        }

        /* renamed from: n */
        public final void mo25237n(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(81474);
            if (map != null) {
                String str2;
                this.qiM = new C13186a();
                this.qiM.qiN = new LinkedList();
                String str3 = str + ".bannerlist.banner";
                int i = 0;
                while (i < 1000) {
                    str2 = (String) map.get((str3 + (i > 0 ? Integer.valueOf(i) : "")) + ".link");
                    if (C5046bo.isNullOrNil(str2)) {
                        break;
                    }
                    C13187a c13187a = new C13187a();
                    c13187a.link = str2;
                    this.qiM.qiN.add(c13187a);
                    i++;
                }
                this.qiM.qiO = new LinkedList();
                str3 = str + ".detaillist.detail";
                i = 0;
                while (i < 1000) {
                    String str4 = str3 + (i > 0 ? Integer.valueOf(i) : "");
                    str2 = (String) map.get(str4 + ".title");
                    str4 = (String) map.get(str4 + ".desc");
                    if (C5046bo.isNullOrNil(str2) && C5046bo.isNullOrNil(str4)) {
                        break;
                    }
                    C13184b c13184b = new C13184b();
                    c13184b.title = str2;
                    c13184b.desc = str4;
                    this.qiM.qiO.add(c13184b);
                    i++;
                }
            }
            AppMethodBeat.m2505o(81474);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.o$c */
    public static class C39641c {
        public String nickname;
        public String username;

        public C39641c(String str, String str2) {
            this.username = str;
            this.nickname = str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.o$b */
    public static class C43495b {
        public String link;

        public C43495b(String str) {
            this.link = str;
        }
    }

    /* renamed from: T */
    public static String m77709T(Context context, int i) {
        AppMethodBeat.m2504i(81475);
        String str;
        if (context == null || i < 0) {
            str = "";
            AppMethodBeat.m2505o(81475);
            return str;
        }
        if (i == 0) {
            context.getString(C25738R.string.dyq);
        } else if (i == 1) {
            context.getString(C25738R.string.dyj);
        } else if (i == 2) {
            context.getString(C25738R.string.dyp);
        } else if (i == 3) {
            context.getString(C25738R.string.dyk);
        }
        str = context.getString(C25738R.string.dyq);
        AppMethodBeat.m2505o(81475);
        return str;
    }

    /* renamed from: Wn */
    public static int m77710Wn(String str) {
        AppMethodBeat.m2504i(81476);
        if (str == null) {
            AppMethodBeat.m2505o(81476);
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            AppMethodBeat.m2505o(81476);
            return 1;
        } else if (trim.startsWith("<url")) {
            AppMethodBeat.m2505o(81476);
            return 2;
        } else if (trim.startsWith("<product")) {
            AppMethodBeat.m2505o(81476);
            return 3;
        } else if (trim.startsWith("<search")) {
            AppMethodBeat.m2505o(81476);
            return 4;
        } else {
            AppMethodBeat.m2505o(81476);
            return 0;
        }
    }

    /* renamed from: Wo */
    public static C39641c m77711Wo(String str) {
        AppMethodBeat.m2504i(81477);
        if (str == null) {
            AppMethodBeat.m2505o(81477);
            return null;
        }
        Map z = C5049br.m7595z(str, "user");
        if (z == null) {
            AppMethodBeat.m2505o(81477);
            return null;
        }
        C39641c c39641c = new C39641c(C5046bo.nullAsNil((String) z.get(".user.username")), C5046bo.nullAsNil((String) z.get(".user.nickname")));
        AppMethodBeat.m2505o(81477);
        return c39641c;
    }

    /* renamed from: Wp */
    public static C43495b m77712Wp(String str) {
        AppMethodBeat.m2504i(81478);
        if (str == null) {
            AppMethodBeat.m2505o(81478);
            return null;
        }
        Map z = C5049br.m7595z(str, "url");
        if (z == null) {
            AppMethodBeat.m2505o(81478);
            return null;
        }
        C43495b c43495b = new C43495b(C5046bo.nullAsNil((String) z.get(".url.link")));
        AppMethodBeat.m2505o(81478);
        return c43495b;
    }

    /* renamed from: cW */
    public static C13185a m77716cW(String str, int i) {
        AppMethodBeat.m2504i(81479);
        if (str == null) {
            AppMethodBeat.m2505o(81479);
            return null;
        }
        int i2;
        Map z;
        String str2 = "";
        if (str.startsWith("<productInfo")) {
            str2 = ".productInfo";
            i2 = 1;
            z = C5049br.m7595z(str, "productInfo");
        } else {
            z = C5049br.m7595z(str, "product");
            i2 = 0;
        }
        if (z == null) {
            AppMethodBeat.m2505o(81479);
            return null;
        }
        C13185a c13185a = new C13185a();
        if (C5046bo.isNullOrNil((String) z.get(str2 + ".product.$type"))) {
            c13185a.field_type = 0;
        } else {
            c13185a.field_type = Integer.valueOf((String) z.get(str2 + ".product.$type")).intValue();
        }
        c13185a.field_productid = C5046bo.nullAsNil((String) z.get(str2 + ".product.id"));
        c13185a.field_subtitle = C5046bo.nullAsNil((String) z.get(str2 + ".product.subtitle"));
        c13185a.field_shareurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.shareurl"));
        c13185a.field_playurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.playurl"));
        c13185a.field_xmlType = 3;
        c13185a.field_title = C5046bo.nullAsNil((String) z.get(str2 + ".product.title"));
        c13185a.field_thumburl = C5046bo.nullAsNil((String) z.get(str2 + ".product.thumburl"));
        c13185a.field_source = C5046bo.nullAsNil((String) z.get(str2 + ".product.source"));
        c13185a.field_feedbackurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.feedbackurl"));
        c13185a.field_extinfo = C5046bo.nullAsNil((String) z.get(str2 + ".product.extinfo"));
        c13185a.field_introtitle = C5046bo.nullAsNil((String) z.get(str2 + ".product.introtitle"));
        c13185a.field_introlink = C5046bo.nullAsNil((String) z.get(str2 + ".product.introlink"));
        c13185a.field_getaction = C5046bo.getInt((String) z.get(str2 + ".product.getaction"), 0);
        c13185a.field_certification = C5046bo.nullAsNil((String) z.get(str2 + ".product.certification"));
        c13185a.field_headerbackgroundurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.headerbackgroundurl"));
        c13185a.field_headermask = C5046bo.nullAsNil((String) z.get(str2 + ".product.headermask"));
        c13185a.field_detailurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.detailurl"));
        c13185a.field_certificationurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.certificationurl"));
        c13185a.field_exposeurl = C5046bo.nullAsNil((String) z.get(str2 + ".product.exposeurl"));
        c13185a.qiL = C43482a.m77679l(z, str2 + ".product");
        c13185a.mo25237n(z, str2 + ".product");
        String str3 = (String) z.get(str2 + ".functionType");
        if (C5046bo.isNullOrNil(str3)) {
            c13185a.field_functionType = i;
        } else {
            c13185a.field_functionType = Integer.valueOf(str3).intValue();
        }
        if (i2 != 0) {
            c13185a.field_xml = str;
        } else {
            StringBuilder stringBuilder = new StringBuilder(256);
            stringBuilder.append("<productInfo>");
            stringBuilder.append(str);
            stringBuilder.append("<functionType>" + c13185a.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
            c13185a.field_xml = stringBuilder.toString();
        }
        AppMethodBeat.m2505o(81479);
        return c13185a;
    }

    /* renamed from: Wq */
    public static C13185a m77713Wq(String str) {
        AppMethodBeat.m2504i(81480);
        if (str == null) {
            AppMethodBeat.m2505o(81480);
            return null;
        }
        Map z = C5049br.m7595z(str, C8740a.SEARCH);
        if (z == null) {
            AppMethodBeat.m2505o(81480);
            return null;
        }
        C13185a c13185a = new C13185a();
        c13185a.field_xmlType = 4;
        c13185a.field_xml = str;
        c13185a.qiL = C43482a.m77679l(z, ".search");
        AppMethodBeat.m2505o(81480);
        return c13185a;
    }

    /* renamed from: c */
    public static String m77715c(C13185a c13185a) {
        String str;
        AppMethodBeat.m2504i(81481);
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!C5046bo.isNullOrNil(c13185a.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + c13185a.field_type + "\">");
            stringBuilder.append("<id>" + C5046bo.ani(c13185a.field_productid) + "</id>");
            stringBuilder.append("<title>" + C5046bo.ani(c13185a.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + C5046bo.ani(c13185a.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + C5046bo.ani(c13185a.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + C5046bo.ani(c13185a.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + C5046bo.ani(c13185a.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + C5046bo.ani(c13185a.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + C5046bo.ani(c13185a.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + C5046bo.ani(c13185a.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + C5046bo.ani(c13185a.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + C5046bo.ani(c13185a.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + C5046bo.ani(c13185a.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + C5046bo.ani(c13185a.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + C5046bo.ani(c13185a.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + c13185a.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (c13185a.field_xml == null) {
            C4990ab.m7412e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            str = "";
            AppMethodBeat.m2505o(81481);
            return str;
        } else if (c13185a.field_xml.startsWith("<productInfo")) {
            str = c13185a.field_xml;
            AppMethodBeat.m2505o(81481);
            return str;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(c13185a.field_xml);
            stringBuilder.append("<functionType>" + c13185a.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(81481);
        return str;
    }

    /* renamed from: a */
    public static int m77714a(int i, String str, C13161i c13161i, int i2, C21729a c21729a, int i3, int i4, boolean z) {
        AppMethodBeat.m2504i(81482);
        if (str == null || c13161i.chu() == null || c13161i.chu().getContext() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(str == null);
            C4990ab.m7413e(str2, str3, objArr);
            AppMethodBeat.m2505o(81482);
            return 2;
        }
        int Wn = C43494o.m77710Wn(str);
        C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", Integer.valueOf(Wn));
        Intent intent;
        if (Wn == 1) {
            C39641c Wo = C43494o.m77711Wo(str);
            if (Wo == null || C5046bo.isNullOrNil(Wo.username)) {
                C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                AppMethodBeat.m2505o(81482);
                return 2;
            }
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(Wo.username);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                c13161i.chu().mo25203a(Wo.username, 1, i3, i4, c21729a);
                AppMethodBeat.m2505o(81482);
                return 1;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", aoO.field_username);
            intent2.setFlags(65536);
            C28892c.gkE.mo38912c(intent2, c13161i.chu().getContext());
            AppMethodBeat.m2505o(81482);
            return 0;
        } else if (Wn == 2) {
            C43495b Wp = C43494o.m77712Wp(str);
            if (Wp == null || C5046bo.isNullOrNil(Wp.link)) {
                C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                AppMethodBeat.m2505o(81482);
                return 2;
            }
            C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", Wp.link);
            if (i == 5) {
                ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(c13161i.chu().getContext(), Wp.link, z ? FilterEnum4Shaka.MIC_SHAKA_ADD_13 : 1025, null);
                AppMethodBeat.m2505o(81482);
                return 0;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", Wp.link);
            intent.setFlags(65536);
            C28892c.gkE.mo38924i(intent, c13161i.chu().getContext());
            AppMethodBeat.m2505o(81482);
            return 0;
        } else if (Wn == 3 || Wn == 4) {
            C4990ab.m7411d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", Integer.valueOf(i2), Boolean.TRUE);
            intent = new Intent();
            intent.setClass(c13161i.chu().getContext(), ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", str);
            intent.putExtra("key_Product_funcType", i2);
            intent.putExtra("key_ProductUI_addToDB", true);
            intent.putExtra("key_need_add_to_history", true);
            intent.putExtra("key_is_from_barcode", true);
            c13161i.chu().getContext().startActivity(intent);
            AppMethodBeat.m2505o(81482);
            return 0;
        } else {
            C4990ab.m7420w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            C4990ab.m7419v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str);
            AppMethodBeat.m2505o(81482);
            return 2;
        }
    }
}
