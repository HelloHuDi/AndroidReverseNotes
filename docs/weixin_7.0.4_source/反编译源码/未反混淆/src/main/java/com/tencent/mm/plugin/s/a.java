package com.tencent.mm.plugin.s;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.x;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> eaA;
    private static volatile a pbq;
    private com.tencent.mm.pluginsdk.model.app.c pbr;
    private com.tencent.mm.pluginsdk.model.app.e pbs;
    private h pbt;
    private i pbu;
    private k pbv;
    private m pbw;
    private com.tencent.mm.pluginsdk.model.app.d pbx;
    private com.tencent.mm.sdk.b.c pby = new com.tencent.mm.sdk.b.c<hh>() {
        {
            AppMethodBeat.i(79128);
            this.xxI = hh.class.getName().hashCode();
            AppMethodBeat.o(79128);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(79129);
            a.bYL().wy(((hh) bVar).cCd.appId);
            AppMethodBeat.o(79129);
            return false;
        }
    };

    private a() {
        AppMethodBeat.i(79130);
        com.tencent.mm.plugin.s.a.a.a.a(new com.tencent.mm.plugin.s.a.a() {
            public final f Uq(String str) {
                AppMethodBeat.i(79114);
                f aiJ = a.bYJ().aiJ(str);
                AppMethodBeat.o(79114);
                return aiJ;
            }

            public final f Ur(String str) {
                AppMethodBeat.i(79115);
                a.bYI();
                if (str == null || str.length() == 0) {
                    AppMethodBeat.o(79115);
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(str);
                ab abVar = new ab(linkedList);
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.fsJ = new dl();
                aVar.fsK = new dm();
                aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
                aVar.fsI = 452;
                aVar.fsL = 0;
                aVar.fsM = 0;
                com.tencent.mm.ai.b acD = aVar.acD();
                dl dlVar = (dl) acD.fsG.fsP;
                byte[] dhj = abVar.dhj();
                if (dhj != null) {
                    dlVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
                }
                dlVar.jCt = 7;
                com.tencent.mm.ai.a.a c = x.c(acD);
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoService", "call getAppInfoList cgi result, errType = %d, errCode = %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode));
                if (c.errType == 0 && c.errCode == 0) {
                    abVar.bG(aa.a(((dm) c.fsy).vFq));
                    abVar.a(0, c.errType, c.errCode, c.aIm, acD, new byte[0]);
                    com.tencent.mm.plugin.s.a.a bYQ = com.tencent.mm.plugin.s.a.a.a.bYQ();
                    if (bYQ == null) {
                        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoService", "getISubCorePluginBase() == null");
                        AppMethodBeat.o(79115);
                        return null;
                    }
                    f Uq = bYQ.Uq(str);
                    AppMethodBeat.o(79115);
                    return Uq;
                }
                AppMethodBeat.o(79115);
                return null;
            }

            public final Cursor bYN() {
                AppMethodBeat.i(79116);
                Cursor rawQuery = a.bYJ().rawQuery("select * from AppInfo where status = 5 order by modifyTime asc", new String[0]);
                if (rawQuery == null) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                    AppMethodBeat.o(79116);
                    return null;
                }
                AppMethodBeat.o(79116);
                return rawQuery;
            }

            public final Cursor x(int[] iArr) {
                AppMethodBeat.i(79117);
                i bYJ = a.bYJ();
                String str = "select * from AppInfo where ";
                for (int i = 0; i <= 0; i++) {
                    str = str + " status = " + iArr[0];
                }
                Cursor rawQuery = bYJ.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
                if (rawQuery == null) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                    AppMethodBeat.o(79117);
                    return null;
                }
                AppMethodBeat.o(79117);
                return rawQuery;
            }

            public final Bitmap a(String str, int i, float f) {
                AppMethodBeat.i(79118);
                a.bYJ();
                Bitmap decodeResource;
                if (str == null || str.length() == 0) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                    AppMethodBeat.o(79118);
                    return null;
                } else if (str.equals("wx7fa037cc7dfabad5")) {
                    decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.awf);
                    AppMethodBeat.o(79118);
                    return decodeResource;
                } else {
                    String dY = i.dY(str, i);
                    if (com.tencent.mm.a.e.ct(dY)) {
                        decodeResource = BackwardSupportUtil.b.i(dY, f);
                        AppMethodBeat.o(79118);
                        return decodeResource;
                    }
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + dY + ", iconType = " + i);
                    AppMethodBeat.o(79118);
                    return null;
                }
            }

            public final void cN(String str, int i) {
                AppMethodBeat.i(79119);
                a.bYH().dW(str, i);
                AppMethodBeat.o(79119);
            }

            public final void Us(String str) {
                AppMethodBeat.i(79120);
                a.bYI().aiH(str);
                AppMethodBeat.o(79120);
            }

            public final void c(f fVar) {
                AppMethodBeat.i(79121);
                i bYJ = a.bYJ();
                if (!(fVar == null || fVar.field_status == 5)) {
                    fVar.field_status = 3;
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", fVar.field_packageName);
                    bYJ.a(fVar, new String[0]);
                }
                AppMethodBeat.o(79121);
            }

            public final void d(f fVar) {
                AppMethodBeat.i(79122);
                i bYJ = a.bYJ();
                if (fVar == null || fVar.field_status != 3) {
                    AppMethodBeat.o(79122);
                    return;
                }
                fVar.field_status = 4;
                bYJ.a(fVar, new String[0]);
                AppMethodBeat.o(79122);
            }

            public final void e(f fVar) {
                AppMethodBeat.i(79123);
                a.bYJ().a(fVar, new String[0]);
                AppMethodBeat.o(79123);
            }

            public final i bYO() {
                AppMethodBeat.i(79124);
                i bYJ = a.bYJ();
                AppMethodBeat.o(79124);
                return bYJ;
            }

            public final void ah(LinkedList<String> linkedList) {
                AppMethodBeat.i(79125);
                a.bYI().aC(linkedList);
                AppMethodBeat.o(79125);
            }

            public final Cursor eQ(int i, int i2) {
                AppMethodBeat.i(79126);
                Cursor eQ = a.bYJ().eQ(i, i2);
                AppMethodBeat.o(79126);
                return eQ;
            }

            public final Cursor bYP() {
                AppMethodBeat.i(79127);
                i bYJ = a.bYJ();
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("select * from AppInfo");
                stringBuilder.append(" where ");
                stringBuilder.append("serviceAppType > 0");
                Cursor rawQuery = bYJ.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery == null) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                    AppMethodBeat.o(79127);
                    return null;
                }
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
                AppMethodBeat.o(79127);
                return rawQuery;
            }
        });
        AppMethodBeat.o(79130);
    }

    public static a bYF() {
        AppMethodBeat.i(79131);
        if (pbq == null) {
            synchronized (a.class) {
                try {
                    if (pbq == null) {
                        pbq = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(79131);
                    }
                }
            }
        }
        a aVar = pbq;
        AppMethodBeat.o(79131);
        return aVar;
    }

    public List<String> collectStoragePaths() {
        AppMethodBeat.i(79132);
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        AppMethodBeat.o(79132);
        return linkedList;
    }

    public static String bYG() {
        AppMethodBeat.i(79133);
        String str = g.RP().eJM + "openapi/";
        AppMethodBeat.o(79133);
        return str;
    }

    public static com.tencent.mm.pluginsdk.model.app.c aUq() {
        AppMethodBeat.i(79134);
        g.RN().QU();
        if (bYF().pbr == null) {
            bYF().pbr = new com.tencent.mm.pluginsdk.model.app.c(g.RP().eJN);
        }
        com.tencent.mm.pluginsdk.model.app.c cVar = bYF().pbr;
        AppMethodBeat.o(79134);
        return cVar;
    }

    public static com.tencent.mm.pluginsdk.model.app.e bYH() {
        AppMethodBeat.i(79135);
        g.RN().QU();
        if (bYF().pbs == null) {
            bYF().pbs = new com.tencent.mm.pluginsdk.model.app.e();
        }
        com.tencent.mm.pluginsdk.model.app.e eVar = bYF().pbs;
        AppMethodBeat.o(79135);
        return eVar;
    }

    public static h bYI() {
        AppMethodBeat.i(79136);
        g.RN().QU();
        if (bYF().pbt == null) {
            bYF().pbt = new h();
        }
        h hVar = bYF().pbt;
        AppMethodBeat.o(79136);
        return hVar;
    }

    public static i bYJ() {
        AppMethodBeat.i(79137);
        g.RN().QU();
        if (bYF().pbu == null) {
            bYF().pbu = new i(g.RP().eJN);
        }
        i iVar = bYF().pbu;
        AppMethodBeat.o(79137);
        return iVar;
    }

    public static k bYK() {
        AppMethodBeat.i(79138);
        g.RN().QU();
        if (bYF().pbv == null) {
            bYF().pbv = new k(g.RP().eJN);
        }
        k kVar = bYF().pbv;
        AppMethodBeat.o(79138);
        return kVar;
    }

    public static m bYL() {
        AppMethodBeat.i(79139);
        g.RN().QU();
        if (bYF().pbw == null) {
            bYF().pbw = new m();
        }
        m mVar = bYF().pbw;
        AppMethodBeat.o(79139);
        return mVar;
    }

    public static com.tencent.mm.pluginsdk.model.app.d bYM() {
        AppMethodBeat.i(79140);
        g.RN().QU();
        if (bYF().pbx == null) {
            bYF().pbx = new com.tencent.mm.pluginsdk.model.app.d();
        }
        com.tencent.mm.pluginsdk.model.app.d dVar = bYF().pbx;
        AppMethodBeat.o(79140);
        return dVar;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(79141);
        com.tencent.mm.model.ad.a.fls = bYI();
        com.tencent.mm.sdk.b.a.xxA.c(this.pby);
        AppMethodBeat.o(79141);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(79142);
        com.tencent.mm.ai.f fVar = bYF().pbt;
        if (fVar != null) {
            g.RO().eJo.b(231, fVar);
            bYM().b(7, fVar);
        }
        com.tencent.mm.pluginsdk.model.app.e eVar = bYF().pbs;
        if (eVar != null) {
            eVar.vbN.clear();
            eVar.qoT.clear();
            eVar.hoQ.clear();
        }
        m mVar = bYF().pbw;
        if (mVar != null) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.AppSettingService", "stop service");
            mVar.vcj.clear();
            bYM().b(1, mVar);
        }
        if (this.pbx != null) {
            fVar = this.pbx;
            g.RO().eJo.b(452, fVar);
            fVar.ftE.clear();
        }
        if (bYF().pbu != null) {
            bYF().pbu.vcc.clear();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.pby);
        com.tencent.mm.sdk.platformtools.ab.i("XPinOpenApi", "onAccountRelease");
        AppMethodBeat.o(79142);
    }

    static {
        AppMethodBeat.i(79144);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.pluginsdk.model.app.c.fnj;
            }
        });
        eaA.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return i.fnj;
            }
        });
        AppMethodBeat.o(79144);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }

    public void onDataBaseOpened(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
    }

    public void onDataBaseClosed(com.tencent.mm.cd.h hVar, com.tencent.mm.cd.h hVar2) {
        AppMethodBeat.i(79143);
        this.pbr = null;
        this.pbu = null;
        com.tencent.mm.sdk.platformtools.ab.i("XPinOpenApi", "onDataBaseClosed");
        AppMethodBeat.o(79143);
    }
}
