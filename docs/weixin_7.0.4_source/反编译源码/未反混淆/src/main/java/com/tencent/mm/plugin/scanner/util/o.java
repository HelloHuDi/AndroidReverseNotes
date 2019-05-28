package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;
import java.util.Map;

public final class o {

    public static class a {
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
        public LinkedList<com.tencent.mm.plugin.scanner.a.a> qiL;
        public a qiM;

        public static class a {
            public LinkedList<a> qiN;
            public LinkedList<b> qiO;

            public static class b {
                public String desc;
                public String title;
            }

            public static class a {
                public String link;
            }
        }

        public final void n(Map<String, String> map, String str) {
            AppMethodBeat.i(81474);
            if (map != null) {
                String str2;
                this.qiM = new a();
                this.qiM.qiN = new LinkedList();
                String str3 = str + ".bannerlist.banner";
                int i = 0;
                while (i < 1000) {
                    str2 = (String) map.get((str3 + (i > 0 ? Integer.valueOf(i) : "")) + ".link");
                    if (bo.isNullOrNil(str2)) {
                        break;
                    }
                    a aVar = new a();
                    aVar.link = str2;
                    this.qiM.qiN.add(aVar);
                    i++;
                }
                this.qiM.qiO = new LinkedList();
                str3 = str + ".detaillist.detail";
                i = 0;
                while (i < 1000) {
                    String str4 = str3 + (i > 0 ? Integer.valueOf(i) : "");
                    str2 = (String) map.get(str4 + ".title");
                    str4 = (String) map.get(str4 + ".desc");
                    if (bo.isNullOrNil(str2) && bo.isNullOrNil(str4)) {
                        break;
                    }
                    b bVar = new b();
                    bVar.title = str2;
                    bVar.desc = str4;
                    this.qiM.qiO.add(bVar);
                    i++;
                }
            }
            AppMethodBeat.o(81474);
        }
    }

    public static class c {
        public String nickname;
        public String username;

        public c(String str, String str2) {
            this.username = str;
            this.nickname = str2;
        }
    }

    public static class b {
        public String link;

        public b(String str) {
            this.link = str;
        }
    }

    public static String T(Context context, int i) {
        AppMethodBeat.i(81475);
        String str;
        if (context == null || i < 0) {
            str = "";
            AppMethodBeat.o(81475);
            return str;
        }
        if (i == 0) {
            context.getString(R.string.dyq);
        } else if (i == 1) {
            context.getString(R.string.dyj);
        } else if (i == 2) {
            context.getString(R.string.dyp);
        } else if (i == 3) {
            context.getString(R.string.dyk);
        }
        str = context.getString(R.string.dyq);
        AppMethodBeat.o(81475);
        return str;
    }

    public static int Wn(String str) {
        AppMethodBeat.i(81476);
        if (str == null) {
            AppMethodBeat.o(81476);
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            AppMethodBeat.o(81476);
            return 1;
        } else if (trim.startsWith("<url")) {
            AppMethodBeat.o(81476);
            return 2;
        } else if (trim.startsWith("<product")) {
            AppMethodBeat.o(81476);
            return 3;
        } else if (trim.startsWith("<search")) {
            AppMethodBeat.o(81476);
            return 4;
        } else {
            AppMethodBeat.o(81476);
            return 0;
        }
    }

    public static c Wo(String str) {
        AppMethodBeat.i(81477);
        if (str == null) {
            AppMethodBeat.o(81477);
            return null;
        }
        Map z = br.z(str, "user");
        if (z == null) {
            AppMethodBeat.o(81477);
            return null;
        }
        c cVar = new c(bo.nullAsNil((String) z.get(".user.username")), bo.nullAsNil((String) z.get(".user.nickname")));
        AppMethodBeat.o(81477);
        return cVar;
    }

    public static b Wp(String str) {
        AppMethodBeat.i(81478);
        if (str == null) {
            AppMethodBeat.o(81478);
            return null;
        }
        Map z = br.z(str, "url");
        if (z == null) {
            AppMethodBeat.o(81478);
            return null;
        }
        b bVar = new b(bo.nullAsNil((String) z.get(".url.link")));
        AppMethodBeat.o(81478);
        return bVar;
    }

    public static a cW(String str, int i) {
        AppMethodBeat.i(81479);
        if (str == null) {
            AppMethodBeat.o(81479);
            return null;
        }
        int i2;
        Map z;
        String str2 = "";
        if (str.startsWith("<productInfo")) {
            str2 = ".productInfo";
            i2 = 1;
            z = br.z(str, "productInfo");
        } else {
            z = br.z(str, "product");
            i2 = 0;
        }
        if (z == null) {
            AppMethodBeat.o(81479);
            return null;
        }
        a aVar = new a();
        if (bo.isNullOrNil((String) z.get(str2 + ".product.$type"))) {
            aVar.field_type = 0;
        } else {
            aVar.field_type = Integer.valueOf((String) z.get(str2 + ".product.$type")).intValue();
        }
        aVar.field_productid = bo.nullAsNil((String) z.get(str2 + ".product.id"));
        aVar.field_subtitle = bo.nullAsNil((String) z.get(str2 + ".product.subtitle"));
        aVar.field_shareurl = bo.nullAsNil((String) z.get(str2 + ".product.shareurl"));
        aVar.field_playurl = bo.nullAsNil((String) z.get(str2 + ".product.playurl"));
        aVar.field_xmlType = 3;
        aVar.field_title = bo.nullAsNil((String) z.get(str2 + ".product.title"));
        aVar.field_thumburl = bo.nullAsNil((String) z.get(str2 + ".product.thumburl"));
        aVar.field_source = bo.nullAsNil((String) z.get(str2 + ".product.source"));
        aVar.field_feedbackurl = bo.nullAsNil((String) z.get(str2 + ".product.feedbackurl"));
        aVar.field_extinfo = bo.nullAsNil((String) z.get(str2 + ".product.extinfo"));
        aVar.field_introtitle = bo.nullAsNil((String) z.get(str2 + ".product.introtitle"));
        aVar.field_introlink = bo.nullAsNil((String) z.get(str2 + ".product.introlink"));
        aVar.field_getaction = bo.getInt((String) z.get(str2 + ".product.getaction"), 0);
        aVar.field_certification = bo.nullAsNil((String) z.get(str2 + ".product.certification"));
        aVar.field_headerbackgroundurl = bo.nullAsNil((String) z.get(str2 + ".product.headerbackgroundurl"));
        aVar.field_headermask = bo.nullAsNil((String) z.get(str2 + ".product.headermask"));
        aVar.field_detailurl = bo.nullAsNil((String) z.get(str2 + ".product.detailurl"));
        aVar.field_certificationurl = bo.nullAsNil((String) z.get(str2 + ".product.certificationurl"));
        aVar.field_exposeurl = bo.nullAsNil((String) z.get(str2 + ".product.exposeurl"));
        aVar.qiL = com.tencent.mm.plugin.scanner.a.a.l(z, str2 + ".product");
        aVar.n(z, str2 + ".product");
        String str3 = (String) z.get(str2 + ".functionType");
        if (bo.isNullOrNil(str3)) {
            aVar.field_functionType = i;
        } else {
            aVar.field_functionType = Integer.valueOf(str3).intValue();
        }
        if (i2 != 0) {
            aVar.field_xml = str;
        } else {
            StringBuilder stringBuilder = new StringBuilder(256);
            stringBuilder.append("<productInfo>");
            stringBuilder.append(str);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
            aVar.field_xml = stringBuilder.toString();
        }
        AppMethodBeat.o(81479);
        return aVar;
    }

    public static a Wq(String str) {
        AppMethodBeat.i(81480);
        if (str == null) {
            AppMethodBeat.o(81480);
            return null;
        }
        Map z = br.z(str, com.google.firebase.analytics.FirebaseAnalytics.a.SEARCH);
        if (z == null) {
            AppMethodBeat.o(81480);
            return null;
        }
        a aVar = new a();
        aVar.field_xmlType = 4;
        aVar.field_xml = str;
        aVar.qiL = com.tencent.mm.plugin.scanner.a.a.l(z, ".search");
        AppMethodBeat.o(81480);
        return aVar;
    }

    public static String c(a aVar) {
        String str;
        AppMethodBeat.i(81481);
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!bo.isNullOrNil(aVar.field_productid)) {
            stringBuilder.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            stringBuilder.append("<id>" + bo.ani(aVar.field_productid) + "</id>");
            stringBuilder.append("<title>" + bo.ani(aVar.field_title) + "</title>");
            stringBuilder.append("<subtitle>" + bo.ani(aVar.field_subtitle) + "</subtitle>");
            stringBuilder.append("<thumburl>" + bo.ani(aVar.field_thumburl) + "</thumburl>");
            stringBuilder.append("<source>" + bo.ani(aVar.field_source) + "</source>");
            stringBuilder.append("<shareurl>" + bo.ani(aVar.field_shareurl) + "</shareurl>");
            stringBuilder.append("<playurl>" + bo.ani(aVar.field_playurl) + "</playurl>");
            stringBuilder.append("<extinfo>" + bo.ani(aVar.field_extinfo) + "</extinfo>");
            stringBuilder.append("<getaction>" + bo.ani(aVar.field_getaction) + "</getaction>");
            stringBuilder.append("<certification>" + bo.ani(aVar.field_certification) + "</certification>");
            stringBuilder.append("<headerbackgroundurl>" + bo.ani(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            stringBuilder.append("<headermask>" + bo.ani(aVar.field_headermask) + "</headermask>");
            stringBuilder.append("<detailurl>" + bo.ani(aVar.field_detailurl) + "</detailurl>");
            stringBuilder.append("<certificationurl>" + bo.ani(aVar.field_certificationurl) + "</certificationurl>");
            stringBuilder.append("</product>");
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            ab.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            str = "";
            AppMethodBeat.o(81481);
            return str;
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            str = aVar.field_xml;
            AppMethodBeat.o(81481);
            return str;
        } else {
            stringBuilder.append("<productInfo>");
            stringBuilder.append(aVar.field_xml);
            stringBuilder.append("<functionType>" + aVar.field_functionType + "</functionType>");
            stringBuilder.append("</productInfo>");
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(81481);
        return str;
    }

    public static int a(int i, String str, i iVar, int i2, com.tencent.mm.plugin.scanner.util.e.a aVar, int i3, int i4, boolean z) {
        AppMethodBeat.i(81482);
        if (str == null || iVar.chu() == null || iVar.chu().getContext() == null) {
            String str2 = "MicroMsg.Scanner.ScanXmlHelper";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(str == null);
            ab.e(str2, str3, objArr);
            AppMethodBeat.o(81482);
            return 2;
        }
        int Wn = Wn(str);
        ab.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", Integer.valueOf(Wn));
        Intent intent;
        if (Wn == 1) {
            c Wo = Wo(str);
            if (Wo == null || bo.isNullOrNil(Wo.username)) {
                ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                AppMethodBeat.o(81482);
                return 2;
            }
            ad aoO = ((j) g.K(j.class)).XM().aoO(Wo.username);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                iVar.chu().a(Wo.username, 1, i3, i4, aVar);
                AppMethodBeat.o(81482);
                return 1;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", aoO.field_username);
            intent2.setFlags(65536);
            com.tencent.mm.plugin.scanner.c.gkE.c(intent2, iVar.chu().getContext());
            AppMethodBeat.o(81482);
            return 0;
        } else if (Wn == 2) {
            b Wp = Wp(str);
            if (Wp == null || bo.isNullOrNil(Wp.link)) {
                ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                AppMethodBeat.o(81482);
                return 2;
            }
            ab.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", Wp.link);
            if (i == 5) {
                ((f) g.K(f.class)).b(iVar.chu().getContext(), Wp.link, z ? FilterEnum4Shaka.MIC_SHAKA_ADD_13 : 1025, null);
                AppMethodBeat.o(81482);
                return 0;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", Wp.link);
            intent.setFlags(65536);
            com.tencent.mm.plugin.scanner.c.gkE.i(intent, iVar.chu().getContext());
            AppMethodBeat.o(81482);
            return 0;
        } else if (Wn == 3 || Wn == 4) {
            ab.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", Integer.valueOf(i2), Boolean.TRUE);
            intent = new Intent();
            intent.setClass(iVar.chu().getContext(), ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", str);
            intent.putExtra("key_Product_funcType", i2);
            intent.putExtra("key_ProductUI_addToDB", true);
            intent.putExtra("key_need_add_to_history", true);
            intent.putExtra("key_is_from_barcode", true);
            iVar.chu().getContext().startActivity(intent);
            AppMethodBeat.o(81482);
            return 0;
        } else {
            ab.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            ab.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str);
            AppMethodBeat.o(81482);
            return 2;
        }
    }
}
