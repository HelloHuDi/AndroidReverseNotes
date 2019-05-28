package com.tencent.p177mm.plugin.p500s;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C6616b;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.model.C26408ad.C26410a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26152hh;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.pluginsdk.model.app.C14883d;
import com.tencent.p177mm.pluginsdk.model.app.C14884k;
import com.tencent.p177mm.pluginsdk.model.app.C30066c;
import com.tencent.p177mm.pluginsdk.model.app.C30067e;
import com.tencent.p177mm.pluginsdk.model.app.C35796i;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C41337h;
import com.tencent.p177mm.pluginsdk.model.app.C4730ab;
import com.tencent.p177mm.pluginsdk.model.app.C4735m;
import com.tencent.p177mm.protocal.protobuf.C40512dl;
import com.tencent.p177mm.protocal.protobuf.C46533dm;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.s.a */
public class C34832a implements C18523a, C6616b, C9562c, C1673e, C6617c {
    private static HashMap<Integer, C1366d> eaA;
    private static volatile C34832a pbq;
    private C30066c pbr;
    private C30067e pbs;
    private C41337h pbt;
    private C35796i pbu;
    private C14884k pbv;
    private C4735m pbw;
    private C14883d pbx;
    private C4884c pby = new C216734();

    /* renamed from: com.tencent.mm.plugin.s.a$3 */
    static class C70643 implements C1366d {
        C70643() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35796i.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.s.a$2 */
    static class C131132 implements C1366d {
        C131132() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30066c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.s.a$1 */
    class C168461 implements C13114a {
        C168461() {
        }

        /* renamed from: Uq */
        public final C40439f mo25133Uq(String str) {
            AppMethodBeat.m2504i(79114);
            C40439f aiJ = C34832a.bYJ().aiJ(str);
            AppMethodBeat.m2505o(79114);
            return aiJ;
        }

        /* renamed from: Ur */
        public final C40439f mo25134Ur(String str) {
            AppMethodBeat.m2504i(79115);
            C34832a.bYI();
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(79115);
                return null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            C4730ab c4730ab = new C4730ab(linkedList);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C40512dl();
            c1196a.fsK = new C46533dm();
            c1196a.uri = "/cgi-bin/micromsg-bin/appcenter";
            c1196a.fsI = 452;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            C40512dl c40512dl = (C40512dl) acD.fsG.fsP;
            byte[] dhj = c4730ab.dhj();
            if (dhj != null) {
                c40512dl.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
            }
            c40512dl.jCt = 7;
            C37441a c = C8920x.m16082c(acD);
            C4990ab.m7413e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode));
            if (c.errType == 0 && c.errCode == 0) {
                c4730ab.mo9871bG(C1946aa.m4150a(((C46533dm) c.fsy).vFq));
                c4730ab.mo4498a(0, c.errType, c.errCode, c.aIm, acD, new byte[0]);
                C13114a bYQ = C3753a.bYQ();
                if (bYQ == null) {
                    C4990ab.m7412e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
                    AppMethodBeat.m2505o(79115);
                    return null;
                }
                C40439f Uq = bYQ.mo25133Uq(str);
                AppMethodBeat.m2505o(79115);
                return Uq;
            }
            AppMethodBeat.m2505o(79115);
            return null;
        }

        public final Cursor bYN() {
            AppMethodBeat.m2504i(79116);
            Cursor rawQuery = C34832a.bYJ().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
            if (rawQuery == null) {
                C4990ab.m7412e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                AppMethodBeat.m2505o(79116);
                return null;
            }
            AppMethodBeat.m2505o(79116);
            return rawQuery;
        }

        /* renamed from: x */
        public final Cursor mo25146x(int[] iArr) {
            AppMethodBeat.m2504i(79117);
            C35796i bYJ = C34832a.bYJ();
            String str = "select * from AppInfo where ";
            for (int i = 0; i <= 0; i++) {
                str = str + " status = " + iArr[0];
            }
            Cursor rawQuery = bYJ.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
            if (rawQuery == null) {
                C4990ab.m7412e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                AppMethodBeat.m2505o(79117);
                return null;
            }
            AppMethodBeat.m2505o(79117);
            return rawQuery;
        }

        /* renamed from: a */
        public final Bitmap mo25136a(String str, int i, float f) {
            AppMethodBeat.m2504i(79118);
            C34832a.bYJ();
            Bitmap decodeResource;
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                AppMethodBeat.m2505o(79118);
                return null;
            } else if (str.equals("wx7fa037cc7dfabad5")) {
                decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.awf);
                AppMethodBeat.m2505o(79118);
                return decodeResource;
            } else {
                String dY = C35796i.m58670dY(str, i);
                if (C1173e.m2561ct(dY)) {
                    decodeResource = C4977b.m7374i(dY, f);
                    AppMethodBeat.m2505o(79118);
                    return decodeResource;
                }
                C4990ab.m7412e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + dY + ", iconType = " + i);
                AppMethodBeat.m2505o(79118);
                return null;
            }
        }

        /* renamed from: cN */
        public final void mo25142cN(String str, int i) {
            AppMethodBeat.m2504i(79119);
            C34832a.bYH().mo48331dW(str, i);
            AppMethodBeat.m2505o(79119);
        }

        /* renamed from: Us */
        public final void mo25135Us(String str) {
            AppMethodBeat.m2504i(79120);
            C34832a.bYI().aiH(str);
            AppMethodBeat.m2505o(79120);
        }

        /* renamed from: c */
        public final void mo25141c(C40439f c40439f) {
            AppMethodBeat.m2504i(79121);
            C35796i bYJ = C34832a.bYJ();
            if (!(c40439f == null || c40439f.field_status == 5)) {
                c40439f.field_status = 3;
                C4990ab.m7417i("MicroMsg.AppInfoStorage", "setBlack package name = %s", c40439f.field_packageName);
                bYJ.mo56566a(c40439f, new String[0]);
            }
            AppMethodBeat.m2505o(79121);
        }

        /* renamed from: d */
        public final void mo25143d(C40439f c40439f) {
            AppMethodBeat.m2504i(79122);
            C35796i bYJ = C34832a.bYJ();
            if (c40439f == null || c40439f.field_status != 3) {
                AppMethodBeat.m2505o(79122);
                return;
            }
            c40439f.field_status = 4;
            bYJ.mo56566a(c40439f, new String[0]);
            AppMethodBeat.m2505o(79122);
        }

        /* renamed from: e */
        public final void mo25144e(C40439f c40439f) {
            AppMethodBeat.m2504i(79123);
            C34832a.bYJ().mo56566a(c40439f, new String[0]);
            AppMethodBeat.m2505o(79123);
        }

        public final C35796i bYO() {
            AppMethodBeat.m2504i(79124);
            C35796i bYJ = C34832a.bYJ();
            AppMethodBeat.m2505o(79124);
            return bYJ;
        }

        /* renamed from: ah */
        public final void mo25137ah(LinkedList<String> linkedList) {
            AppMethodBeat.m2504i(79125);
            C34832a.bYI().mo65992aC(linkedList);
            AppMethodBeat.m2505o(79125);
        }

        /* renamed from: eQ */
        public final Cursor mo25145eQ(int i, int i2) {
            AppMethodBeat.m2504i(79126);
            Cursor eQ = C34832a.bYJ().mo56572eQ(i, i2);
            AppMethodBeat.m2505o(79126);
            return eQ;
        }

        public final Cursor bYP() {
            AppMethodBeat.m2504i(79127);
            C35796i bYJ = C34832a.bYJ();
            StringBuilder stringBuilder = new StringBuilder(256);
            stringBuilder.append("select * from AppInfo");
            stringBuilder.append(" where ");
            stringBuilder.append("serviceAppType > 0");
            Cursor rawQuery = bYJ.rawQuery(stringBuilder.toString(), new String[0]);
            if (rawQuery == null) {
                C4990ab.m7412e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                AppMethodBeat.m2505o(79127);
                return null;
            }
            C4990ab.m7411d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
            AppMethodBeat.m2505o(79127);
            return rawQuery;
        }
    }

    /* renamed from: com.tencent.mm.plugin.s.a$4 */
    class C216734 extends C4884c<C26152hh> {
        C216734() {
            AppMethodBeat.m2504i(79128);
            this.xxI = C26152hh.class.getName().hashCode();
            AppMethodBeat.m2505o(79128);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(79129);
            C34832a.bYL().mo9878wy(((C26152hh) c4883b).cCd.appId);
            AppMethodBeat.m2505o(79129);
            return false;
        }
    }

    private C34832a() {
        AppMethodBeat.m2504i(79130);
        C3753a.m6068a(new C168461());
        AppMethodBeat.m2505o(79130);
    }

    public static C34832a bYF() {
        AppMethodBeat.m2504i(79131);
        if (pbq == null) {
            synchronized (C34832a.class) {
                try {
                    if (pbq == null) {
                        pbq = new C34832a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(79131);
                    }
                }
            }
        }
        C34832a c34832a = pbq;
        AppMethodBeat.m2505o(79131);
        return c34832a;
    }

    public List<String> collectStoragePaths() {
        AppMethodBeat.m2504i(79132);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        AppMethodBeat.m2505o(79132);
        return linkedList;
    }

    public static String bYG() {
        AppMethodBeat.m2504i(79133);
        String str = C1720g.m3536RP().eJM + "openapi/";
        AppMethodBeat.m2505o(79133);
        return str;
    }

    public static C30066c aUq() {
        AppMethodBeat.m2504i(79134);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbr == null) {
            C34832a.bYF().pbr = new C30066c(C1720g.m3536RP().eJN);
        }
        C30066c c30066c = C34832a.bYF().pbr;
        AppMethodBeat.m2505o(79134);
        return c30066c;
    }

    public static C30067e bYH() {
        AppMethodBeat.m2504i(79135);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbs == null) {
            C34832a.bYF().pbs = new C30067e();
        }
        C30067e c30067e = C34832a.bYF().pbs;
        AppMethodBeat.m2505o(79135);
        return c30067e;
    }

    public static C41337h bYI() {
        AppMethodBeat.m2504i(79136);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbt == null) {
            C34832a.bYF().pbt = new C41337h();
        }
        C41337h c41337h = C34832a.bYF().pbt;
        AppMethodBeat.m2505o(79136);
        return c41337h;
    }

    public static C35796i bYJ() {
        AppMethodBeat.m2504i(79137);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbu == null) {
            C34832a.bYF().pbu = new C35796i(C1720g.m3536RP().eJN);
        }
        C35796i c35796i = C34832a.bYF().pbu;
        AppMethodBeat.m2505o(79137);
        return c35796i;
    }

    public static C14884k bYK() {
        AppMethodBeat.m2504i(79138);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbv == null) {
            C34832a.bYF().pbv = new C14884k(C1720g.m3536RP().eJN);
        }
        C14884k c14884k = C34832a.bYF().pbv;
        AppMethodBeat.m2505o(79138);
        return c14884k;
    }

    public static C4735m bYL() {
        AppMethodBeat.m2504i(79139);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbw == null) {
            C34832a.bYF().pbw = new C4735m();
        }
        C4735m c4735m = C34832a.bYF().pbw;
        AppMethodBeat.m2505o(79139);
        return c4735m;
    }

    public static C14883d bYM() {
        AppMethodBeat.m2504i(79140);
        C1720g.m3534RN().mo5159QU();
        if (C34832a.bYF().pbx == null) {
            C34832a.bYF().pbx = new C14883d();
        }
        C14883d c14883d = C34832a.bYF().pbx;
        AppMethodBeat.m2505o(79140);
        return c14883d;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(79141);
        C26410a.fls = C34832a.bYI();
        C4879a.xxA.mo10052c(this.pby);
        AppMethodBeat.m2505o(79141);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(79142);
        C1202f c1202f = C34832a.bYF().pbt;
        if (c1202f != null) {
            C1720g.m3535RO().eJo.mo14546b(231, c1202f);
            C34832a.bYM().mo27203b(7, c1202f);
        }
        C30067e c30067e = C34832a.bYF().pbs;
        if (c30067e != null) {
            c30067e.vbN.clear();
            c30067e.qoT.clear();
            c30067e.hoQ.clear();
        }
        C4735m c4735m = C34832a.bYF().pbw;
        if (c4735m != null) {
            C4990ab.m7410d("MicroMsg.AppSettingService", "stop service");
            c4735m.vcj.clear();
            C34832a.bYM().mo27203b(1, c4735m);
        }
        if (this.pbx != null) {
            c1202f = this.pbx;
            C1720g.m3535RO().eJo.mo14546b(452, c1202f);
            c1202f.ftE.clear();
        }
        if (C34832a.bYF().pbu != null) {
            C34832a.bYF().pbu.vcc.clear();
        }
        C4879a.xxA.mo10053d(this.pby);
        C4990ab.m7416i("XPinOpenApi", "onAccountRelease");
        AppMethodBeat.m2505o(79142);
    }

    static {
        AppMethodBeat.m2504i(79144);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new C131132());
        eaA.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new C70643());
        AppMethodBeat.m2505o(79144);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        return eaA;
    }

    public void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
    }

    public void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(79143);
        this.pbr = null;
        this.pbu = null;
        C4990ab.m7416i("XPinOpenApi", "onDataBaseClosed");
        AppMethodBeat.m2505o(79143);
    }
}
