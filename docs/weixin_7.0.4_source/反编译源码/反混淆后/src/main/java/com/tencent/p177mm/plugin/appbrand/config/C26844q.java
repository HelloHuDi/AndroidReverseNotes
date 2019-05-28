package com.tencent.p177mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C37758lo;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.cwx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7293f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.q */
public final class C26844q extends C10183o {
    public C26844q(C4927e c4927e) {
        super(c4927e);
        AppMethodBeat.m2504i(129901);
        if (ayG()) {
            C7293f c7293f = (C7293f) c4927e;
            if (!C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, false)) {
                C4990ab.m7416i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
                Cursor a = c7293f.mo10104a("select appInfo from WxaAttributesTable", null, 2);
                if (a == null || a.isClosed()) {
                    C4990ab.m7412e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
                    AppMethodBeat.m2505o(129901);
                    return;
                }
                if (a.moveToFirst()) {
                    LinkedList<Pair> linkedList = new LinkedList();
                    do {
                        String string = a.getString(0);
                        if (!C5046bo.isNullOrNil(string)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                string = jSONObject.optString("Appid");
                                String optString = jSONObject.optString("RoundedSquareIconUrl");
                                if (!(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(optString))) {
                                    ContentValues contentValues = new ContentValues(1);
                                    contentValues.put("roundedSquareIconURL", optString);
                                    linkedList.add(Pair.create(string, contentValues));
                                }
                            } catch (Exception e) {
                            }
                        }
                    } while (a.moveToNext());
                    a.close();
                    long iV = c7293f.mo15639iV(Thread.currentThread().getId());
                    for (Pair pair : linkedList) {
                        String[] strArr = new String[]{(String) pair.first};
                        c7293f.update("WxaAttributesTable", (ContentValues) ((Pair) r3.next()).second, "appId=?", strArr);
                    }
                    c7293f.mo15640mB(iV);
                    C4990ab.m7416i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
                }
                if (!a.isClosed()) {
                    a.close();
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, Boolean.TRUE);
            }
        }
        AppMethodBeat.m2505o(129901);
    }

    /* renamed from: a */
    public final boolean mo21570a(String str, C1332b c1332b, List<cwx> list) {
        AppMethodBeat.m2504i(129902);
        boolean a = super.mo21570a(str, c1332b, (List) list);
        WxaAttributes d = mo21572d(str, new String[0]);
        C31283e ayL = d.ayL();
        if (ayL != null && ayL.bQl == 0) {
            C42340f.auV().mo60849a(d.field_appId, d.ayL());
        }
        if (a) {
            try {
                if (C1720g.m3531RK()) {
                    int i;
                    C7486a c7616ad;
                    String str2 = d.field_username;
                    String str3 = d.field_nickname;
                    String str4 = d.field_bigHeadURL;
                    String str5 = d.field_smallHeadURL;
                    C17880h qo = C17884o.act().mo33392qo(str2);
                    if (qo == null) {
                        qo = new C17880h();
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (!C5046bo.nullAsNil(str5).equals(qo.acl())) {
                        qo.frV = str5;
                        i = 1;
                    }
                    if (!C5046bo.nullAsNil(str4).equals(qo.ack())) {
                        qo.frW = str4;
                        i = 1;
                    }
                    if (i != 0) {
                        qo.username = str2;
                        qo.mo33385cB(true);
                        qo.bJt = 31;
                        C17884o.act().mo33391b(qo);
                    }
                    C7486a aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                    if (aoO == null) {
                        c7616ad = new C7616ad();
                    } else {
                        c7616ad = aoO;
                    }
                    if (((int) c7616ad.ewQ) == 0) {
                        c7616ad.setUsername(str2);
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (!str3.equals(c7616ad.field_nickname)) {
                        c7616ad.mo14703iB(str3);
                        try {
                            c7616ad.mo14704iC(C9790g.m17433vp(str3));
                        } catch (UnsatisfiedLinkError e) {
                        }
                        try {
                            c7616ad.mo14705iD(C9790g.m17432vo(str3));
                        } catch (UnsatisfiedLinkError e2) {
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15700X(c7616ad);
                    }
                }
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.WxaAttrStorageWC", e3, "flushContactInMainDB", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(129902);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: k */
    public final boolean mo21574k(String str, int i, boolean z) {
        AppMethodBeat.m2504i(129903);
        boolean k = super.mo21574k(str, i, z);
        if (k) {
            WxaAttributes d = mo21572d(str, "appOpt");
            C37758lo c37758lo = new C37758lo();
            c37758lo.cHo.csl = str;
            c37758lo.cHo.cHp = d.field_appOpt;
            C4879a.xxA.mo10055m(c37758lo);
        }
        AppMethodBeat.m2505o(129903);
        return k;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo21569a(WxaAttributes wxaAttributes, cwx cwx) {
        AppMethodBeat.m2504i(129904);
        boolean a = super.mo21569a(wxaAttributes, cwx);
        if (a && "WxaAppInfo".equals(cwx.vMU)) {
            try {
                C45535l.m83975b(wxaAttributes.field_appId, C38167m.m64603m(new JSONObject(cwx.pXM)).vFu);
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(129904);
        return a;
    }
}
