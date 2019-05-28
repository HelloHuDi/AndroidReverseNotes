package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.bt.b;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class q extends o {
    public q(e eVar) {
        super(eVar);
        AppMethodBeat.i(129901);
        if (ayG()) {
            f fVar = (f) eVar;
            if (!g.RP().Ry().getBoolean(a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, false)) {
                ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
                Cursor a = fVar.a("select appInfo from WxaAttributesTable", null, 2);
                if (a == null || a.isClosed()) {
                    ab.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
                    AppMethodBeat.o(129901);
                    return;
                }
                if (a.moveToFirst()) {
                    LinkedList<Pair> linkedList = new LinkedList();
                    do {
                        String string = a.getString(0);
                        if (!bo.isNullOrNil(string)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                string = jSONObject.optString("Appid");
                                String optString = jSONObject.optString("RoundedSquareIconUrl");
                                if (!(bo.isNullOrNil(string) || bo.isNullOrNil(optString))) {
                                    ContentValues contentValues = new ContentValues(1);
                                    contentValues.put("roundedSquareIconURL", optString);
                                    linkedList.add(Pair.create(string, contentValues));
                                }
                            } catch (Exception e) {
                            }
                        }
                    } while (a.moveToNext());
                    a.close();
                    long iV = fVar.iV(Thread.currentThread().getId());
                    for (Pair pair : linkedList) {
                        String[] strArr = new String[]{(String) pair.first};
                        fVar.update("WxaAttributesTable", (ContentValues) ((Pair) r3.next()).second, "appId=?", strArr);
                    }
                    fVar.mB(iV);
                    ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
                } else {
                    ab.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
                }
                if (!a.isClosed()) {
                    a.close();
                }
                g.RP().Ry().set(a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, Boolean.TRUE);
            }
        }
        AppMethodBeat.o(129901);
    }

    public final boolean a(String str, b bVar, List<cwx> list) {
        AppMethodBeat.i(129902);
        boolean a = super.a(str, bVar, (List) list);
        WxaAttributes d = d(str, new String[0]);
        WxaAttributes.e ayL = d.ayL();
        if (ayL != null && ayL.bQl == 0) {
            com.tencent.mm.plugin.appbrand.app.f.auV().a(d.field_appId, d.ayL());
        }
        if (a) {
            try {
                if (g.RK()) {
                    int i;
                    com.tencent.mm.n.a adVar;
                    String str2 = d.field_username;
                    String str3 = d.field_nickname;
                    String str4 = d.field_bigHeadURL;
                    String str5 = d.field_smallHeadURL;
                    h qo = o.act().qo(str2);
                    if (qo == null) {
                        qo = new h();
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (!bo.nullAsNil(str5).equals(qo.acl())) {
                        qo.frV = str5;
                        i = 1;
                    }
                    if (!bo.nullAsNil(str4).equals(qo.ack())) {
                        qo.frW = str4;
                        i = 1;
                    }
                    if (i != 0) {
                        qo.username = str2;
                        qo.cB(true);
                        qo.bJt = 31;
                        o.act().b(qo);
                    }
                    com.tencent.mm.n.a aoO = ((j) g.K(j.class)).XM().aoO(str2);
                    if (aoO == null) {
                        adVar = new ad();
                    } else {
                        adVar = aoO;
                    }
                    if (((int) adVar.ewQ) == 0) {
                        adVar.setUsername(str2);
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (!str3.equals(adVar.field_nickname)) {
                        adVar.iB(str3);
                        try {
                            adVar.iC(com.tencent.mm.platformtools.g.vp(str3));
                        } catch (UnsatisfiedLinkError e) {
                        }
                        try {
                            adVar.iD(com.tencent.mm.platformtools.g.vo(str3));
                        } catch (UnsatisfiedLinkError e2) {
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        ((j) g.K(j.class)).XM().X(adVar);
                    }
                }
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.WxaAttrStorageWC", e3, "flushContactInMainDB", new Object[0]);
            }
        }
        AppMethodBeat.o(129902);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean k(String str, int i, boolean z) {
        AppMethodBeat.i(129903);
        boolean k = super.k(str, i, z);
        if (k) {
            WxaAttributes d = d(str, "appOpt");
            lo loVar = new lo();
            loVar.cHo.csl = str;
            loVar.cHo.cHp = d.field_appOpt;
            com.tencent.mm.sdk.b.a.xxA.m(loVar);
        }
        AppMethodBeat.o(129903);
        return k;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(WxaAttributes wxaAttributes, cwx cwx) {
        AppMethodBeat.i(129904);
        boolean a = super.a(wxaAttributes, cwx);
        if (a && "WxaAppInfo".equals(cwx.vMU)) {
            try {
                l.b(wxaAttributes.field_appId, m.m(new JSONObject(cwx.pXM)).vFu);
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(129904);
        return a;
    }
}
