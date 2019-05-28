package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class o extends j<WxaAttributes> {
    public static final String[] fjY = new String[]{j.a(WxaAttributes.gSs, "WxaAttributesTable")};
    final e bSd;

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        AppMethodBeat.i(94149);
        WxaAttributes wxaAttributes = (WxaAttributes) cVar;
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        boolean b = super.b(wxaAttributes, z, strArr);
        AppMethodBeat.o(94149);
        return b;
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        AppMethodBeat.i(94150);
        boolean a = a((WxaAttributes) cVar, strArr);
        AppMethodBeat.o(94150);
        return a;
    }

    static {
        AppMethodBeat.i(94153);
        AppMethodBeat.o(94153);
    }

    public o(e eVar) {
        super(eVar, WxaAttributes.gSs, "WxaAttributesTable", WxaAttributes.diI);
        this.bSd = eVar;
    }

    public final boolean ayG() {
        AppMethodBeat.i(94137);
        if (this.bSd == null || this.bSd.dpU()) {
            AppMethodBeat.o(94137);
            return false;
        }
        AppMethodBeat.o(94137);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final long ze(String str) {
        AppMethodBeat.i(94138);
        WxaAttributes d = d(str, "syncTimeSecond");
        if (d == null) {
            AppMethodBeat.o(94138);
            return 0;
        }
        long j = d.field_syncTimeSecond;
        AppMethodBeat.o(94138);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final b zf(String str) {
        byte[] bArr;
        AppMethodBeat.i(94139);
        WxaAttributes d = d(str, "syncVersion");
        if (d == null) {
            bArr = new byte[0];
        } else {
            bArr = bo.anf(bo.nullAsNil(d.field_syncVersion));
        }
        b bVar = new b(bArr);
        AppMethodBeat.o(94139);
        return bVar;
    }

    public final boolean zg(String str) {
        AppMethodBeat.i(94140);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
            AppMethodBeat.o(94140);
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        boolean a = a(wxaAttributes, false, new String[0]);
        AppMethodBeat.o(94140);
        return a;
    }

    public final WxaAttributes d(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(94141);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(94141);
        } else if (str.endsWith("@app")) {
            Cursor a = this.bSd.a("WxaAttributesTable", bo.Q(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"usernameHash"}), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.o(94141);
            } else {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.d(a);
                    wxaAttributes.field_username = str;
                }
                a.close();
                AppMethodBeat.o(94141);
            }
        } else {
            AppMethodBeat.o(94141);
        }
        return wxaAttributes;
    }

    public final WxaAttributes e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(94142);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(94142);
        } else {
            Cursor a = this.bSd.a("WxaAttributesTable", bo.Q(strArr) ? null : strArr, String.format(Locale.US, "%s=?", new Object[]{"appId"}), new String[]{str}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.o(94142);
            } else {
                if (a.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.d(a);
                    wxaAttributes.field_appId = str;
                }
                a.close();
                AppMethodBeat.o(94142);
            }
        }
        return wxaAttributes;
    }

    /* Access modifiers changed, original: protected */
    public boolean k(String str, int i, boolean z) {
        AppMethodBeat.i(94143);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(94143);
            return false;
        }
        WxaAttributes d = d(str, "appOpt");
        if (d == null) {
            AppMethodBeat.o(94143);
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
            AppMethodBeat.o(94143);
            return true;
        }
        AppMethodBeat.o(94143);
        return false;
    }

    public boolean a(String str, b bVar, List<cwx> list) {
        AppMethodBeat.i(94144);
        if (bo.ek(list)) {
            AppMethodBeat.o(94144);
            return false;
        }
        int i;
        byte[] bArr;
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        if (a(wxaAttributes, "username")) {
            boolean i2 = false;
        } else {
            i2 = 1;
        }
        int i3 = 0;
        for (cwx cwx : list) {
            if (cwx != null) {
                i3 = a(wxaAttributes, cwx) | i3;
            }
        }
        if (i3 != 0) {
            if (i2 != 0) {
                b((c) wxaAttributes);
            } else {
                c(wxaAttributes, "username");
            }
        }
        wxaAttributes.field_syncTimeSecond = bo.anT();
        if (bVar == null) {
            bArr = new byte[0];
        } else {
            bArr = bVar.wR;
        }
        wxaAttributes.field_syncVersion = bo.cd(bArr);
        c(wxaAttributes, "username");
        AppMethodBeat.o(94144);
        return i3;
    }

    /* Access modifiers changed, original: protected */
    public boolean a(WxaAttributes wxaAttributes, cwx cwx) {
        AppMethodBeat.i(94145);
        if ("NickName".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = bo.nullAsNil(cwx.pXM);
            AppMethodBeat.o(94145);
            return true;
        } else if ("BrandIconURL".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = cwx.pXM;
            AppMethodBeat.o(94145);
            return true;
        } else if ("BigHeadImgUrl".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = cwx.pXM;
            AppMethodBeat.o(94145);
            return true;
        } else if ("SmallHeadImgUrl".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = cwx.pXM;
            AppMethodBeat.o(94145);
            return true;
        } else if (!"Signature".equals(cwx.vMU) || bH(cwx.pXM, wxaAttributes.field_signature)) {
            if ("WxAppOpt".equals(cwx.vMU)) {
                int i = bo.getInt(cwx.pXM, 0);
                if (i != wxaAttributes.field_appOpt) {
                    wxaAttributes.field_appOpt = i;
                    AppMethodBeat.o(94145);
                    return true;
                }
            }
            if ("RegisterSource".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_registerSource)) {
                wxaAttributes.field_registerSource = cwx.pXM;
                AppMethodBeat.o(94145);
                return true;
            } else if ("WxaAppInfo".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_appInfo)) {
                wxaAttributes.field_appInfo = cwx.pXM;
                try {
                    JSONObject jSONObject = new JSONObject(cwx.pXM);
                    wxaAttributes.field_appId = jSONObject.getString("Appid");
                    wxaAttributes.field_roundedSquareIconURL = jSONObject.getString("RoundedSquareIconUrl");
                    wxaAttributes.field_shortNickname = jSONObject.optString("ShortNickName");
                } catch (Exception e) {
                }
                AppMethodBeat.o(94145);
                return true;
            } else if ("WxaAppVersionInfo".equalsIgnoreCase(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_versionInfo)) {
                wxaAttributes.field_versionInfo = cwx.pXM;
                AppMethodBeat.o(94145);
                return true;
            } else if ("BindWxaInfo".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_bindWxaInfo)) {
                wxaAttributes.field_bindWxaInfo = cwx.pXM;
                AppMethodBeat.o(94145);
                return true;
            } else if ("WxaAppDynamic".equals(cwx.vMU) && !bH(cwx.pXM, wxaAttributes.field_dynamicInfo)) {
                wxaAttributes.field_dynamicInfo = cwx.pXM;
                AppMethodBeat.o(94145);
                return true;
            } else if (!"MMBizMenu".equals(cwx.vMU) || bH(cwx.pXM, wxaAttributes.field_bizMenu)) {
                AppMethodBeat.o(94145);
                return false;
            } else {
                wxaAttributes.field_bizMenu = cwx.pXM;
                AppMethodBeat.o(94145);
                return true;
            }
        } else {
            wxaAttributes.field_signature = cwx.pXM;
            AppMethodBeat.o(94145);
            return true;
        }
    }

    private static boolean bH(String str, String str2) {
        AppMethodBeat.i(94146);
        boolean equals = bo.nullAsNil(str).equals(bo.nullAsNil(str2));
        AppMethodBeat.o(94146);
        return equals;
    }

    private boolean a(WxaAttributes wxaAttributes, String... strArr) {
        AppMethodBeat.i(94147);
        if (!bo.Q(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("username")) {
                    strArr[i] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                }
            }
        }
        boolean b = super.b((c) wxaAttributes, strArr);
        AppMethodBeat.o(94147);
        return b;
    }

    private boolean a(WxaAttributes wxaAttributes, boolean z, String... strArr) {
        AppMethodBeat.i(94148);
        if (!bo.isNullOrNil(wxaAttributes.field_username)) {
            wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        }
        boolean a = super.a((c) wxaAttributes, z, strArr);
        AppMethodBeat.o(94148);
        return a;
    }
}
