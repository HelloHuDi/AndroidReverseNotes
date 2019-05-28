package com.tencent.p177mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.cwx;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.o */
public class C10183o extends C7563j<WxaAttributes> {
    public static final String[] fjY = new String[]{C7563j.m13217a(WxaAttributes.gSs, "WxaAttributesTable")};
    final C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo16762b(C4925c c4925c, boolean z, String[] strArr) {
        AppMethodBeat.m2504i(94149);
        WxaAttributes wxaAttributes = (WxaAttributes) c4925c;
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        boolean b = super.mo16762b(wxaAttributes, z, strArr);
        AppMethodBeat.m2505o(94149);
        return b;
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10102b(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(94150);
        boolean a = m17802a((WxaAttributes) c4925c, strArr);
        AppMethodBeat.m2505o(94150);
        return a;
    }

    static {
        AppMethodBeat.m2504i(94153);
        AppMethodBeat.m2505o(94153);
    }

    public C10183o(C4927e c4927e) {
        super(c4927e, WxaAttributes.gSs, "WxaAttributesTable", WxaAttributes.diI);
        this.bSd = c4927e;
    }

    public final boolean ayG() {
        AppMethodBeat.m2504i(94137);
        if (this.bSd == null || this.bSd.dpU()) {
            AppMethodBeat.m2505o(94137);
            return false;
        }
        AppMethodBeat.m2505o(94137);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ze */
    public final long mo21575ze(String str) {
        AppMethodBeat.m2504i(94138);
        WxaAttributes d = mo21572d(str, "syncTimeSecond");
        if (d == null) {
            AppMethodBeat.m2505o(94138);
            return 0;
        }
        long j = d.field_syncTimeSecond;
        AppMethodBeat.m2505o(94138);
        return j;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zf */
    public final C1332b mo21576zf(String str) {
        byte[] bArr;
        AppMethodBeat.m2504i(94139);
        WxaAttributes d = mo21572d(str, "syncVersion");
        if (d == null) {
            bArr = new byte[0];
        } else {
            bArr = C5046bo.anf(C5046bo.nullAsNil(d.field_syncVersion));
        }
        C1332b c1332b = new C1332b(bArr);
        AppMethodBeat.m2505o(94139);
        return c1332b;
    }

    /* renamed from: zg */
    public final boolean mo21577zg(String str) {
        AppMethodBeat.m2504i(94140);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WxaAttrStorage", "delete with invalid username");
            AppMethodBeat.m2505o(94140);
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        boolean a = m17801a(wxaAttributes, false, new String[0]);
        AppMethodBeat.m2505o(94140);
        return a;
    }

    /* renamed from: d */
    public final WxaAttributes mo21572d(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.m2504i(94141);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(94141);
        } else if (str.endsWith("@app")) {
            Cursor a = this.bSd.mo10105a("WxaAttributesTable", C5046bo.m7510Q(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(94141);
            } else {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.mo8995d(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
                AppMethodBeat.m2505o(94141);
            }
        } else {
            AppMethodBeat.m2505o(94141);
        }
        return wxaAttributes;
    }

    /* renamed from: e */
    public final WxaAttributes mo21573e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.m2504i(94142);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(94142);
        } else {
            Cursor a = this.bSd.mo10105a("WxaAttributesTable", C5046bo.m7510Q(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(94142);
            } else {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.mo8995d(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
                AppMethodBeat.m2505o(94142);
            }
        }
        return wxaAttributes;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: k */
    public boolean mo21574k(String str, int i, boolean z) {
        AppMethodBeat.m2504i(94143);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(94143);
            return false;
        }
        WxaAttributes d = mo21572d(str, "appOpt");
        if (d == null) {
            AppMethodBeat.m2505o(94143);
            return false;
        }
        int i2 = d.field_appOpt;
        if (z) {
            i2 |= i;
        } else {
            i2 &= i ^ -1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i2));
        if (this.bSd.update("WxaAttributesTable", contentValues, String.format("%s=?", new Object[]{"username"}), new String[]{str}) > 0) {
            AppMethodBeat.m2505o(94143);
            return true;
        }
        AppMethodBeat.m2505o(94143);
        return false;
    }

    /* renamed from: a */
    public boolean mo21570a(String str, C1332b c1332b, List<cwx> list) {
        AppMethodBeat.m2504i(94144);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(94144);
            return false;
        }
        int i;
        byte[] bArr;
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (m17802a(wxaAttributes, "username")) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        int i3 = 0;
        for (cwx cwx : list) {
            if (cwx != null) {
                i3 = mo21569a(wxaAttributes, cwx) | i3;
            }
        }
        if (i3 != 0) {
            if (i2 != 0) {
                mo10101b((C4925c) wxaAttributes);
            } else {
                mo10103c(wxaAttributes, "username");
            }
        }
        wxaAttributes.field_syncTimeSecond = C5046bo.anT();
        if (c1332b == null) {
            bArr = new byte[0];
        } else {
            bArr = c1332b.f1226wR;
        }
        wxaAttributes.field_syncVersion = C5046bo.m7543cd(bArr);
        mo10103c(wxaAttributes, "username");
        AppMethodBeat.m2505o(94144);
        return i3;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public boolean mo21569a(WxaAttributes wxaAttributes, cwx cwx) {
        AppMethodBeat.m2504i(94145);
        if ("NickName".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = C5046bo.nullAsNil(cwx.pXM);
            AppMethodBeat.m2505o(94145);
            return true;
        } else if ("BrandIconURL".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = cwx.pXM;
            AppMethodBeat.m2505o(94145);
            return true;
        } else if ("BigHeadImgUrl".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = cwx.pXM;
            AppMethodBeat.m2505o(94145);
            return true;
        } else if ("SmallHeadImgUrl".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = cwx.pXM;
            AppMethodBeat.m2505o(94145);
            return true;
        } else if (!"Signature".equals(cwx.vMU) || C10183o.m17803bH(cwx.pXM, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(cwx.vMU)) {
                int i = C5046bo.getInt(cwx.pXM, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    AppMethodBeat.m2505o(94145);
                    return true;
                }
            }
            if ("RegisterSource".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = cwx.pXM;
                AppMethodBeat.m2505o(94145);
                return true;
            } else if ("WxaAppInfo".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = cwx.pXM;
                try {
                    JSONObject jSONObject = new JSONObject(cwx.pXM);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    wxaAttributes.field_roundedSquareIconURL = jSONObject.getString("RoundedSquareIconUrl");
                    wxaAttributes.field_shortNickname = jSONObject.optString("ShortNickName");
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(94145);
                return true;
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = cwx.pXM;
                AppMethodBeat.m2505o(94145);
                return true;
            } else if ("BindWxaInfo".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = cwx.pXM;
                AppMethodBeat.m2505o(94145);
                return true;
            } else if ("WxaAppDynamic".equals(cwx.vMU) && !C10183o.m17803bH(cwx.pXM, wxaAttributes.field_dynamicInfo)) {
                wxaAttributes.field_dynamicInfo = cwx.pXM;
                AppMethodBeat.m2505o(94145);
                return true;
            } else if (!"MMBizMenu".equals(cwx.vMU) || C10183o.m17803bH(cwx.pXM, wxaAttributes.field_bizMenu)) {
                AppMethodBeat.m2505o(94145);
                return false;
            } else {
                wxaAttributes.field_bizMenu = cwx.pXM;
                AppMethodBeat.m2505o(94145);
                return true;
            }
        } else {
            wxaAttributes.field_signature = cwx.pXM;
            AppMethodBeat.m2505o(94145);
            return true;
        }
    }

    /* renamed from: bH */
    private static boolean m17803bH(String str, String str2) {
        AppMethodBeat.m2504i(94146);
        boolean equals = C5046bo.nullAsNil(str).equals(C5046bo.nullAsNil(str2));
        AppMethodBeat.m2505o(94146);
        return equals;
    }

    /* renamed from: a */
    private boolean m17802a(WxaAttributes wxaAttributes, String... strArr) {
        AppMethodBeat.m2504i(94147);
        if (!C5046bo.m7510Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        boolean b = super.mo10102b((C4925c) wxaAttributes, strArr);
        AppMethodBeat.m2505o(94147);
        return b;
    }

    /* renamed from: a */
    private boolean m17801a(WxaAttributes wxaAttributes, boolean z, String... strArr) {
        AppMethodBeat.m2504i(94148);
        if (!C5046bo.isNullOrNil(wxaAttributes.field_username)) {
            wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        }
        boolean a = super.mo10100a((C4925c) wxaAttributes, z, strArr);
        AppMethodBeat.m2505o(94148);
        return a;
    }
}
