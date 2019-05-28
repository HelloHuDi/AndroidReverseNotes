package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.view.C31128d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI */
public class ContactProfileMoreUI extends MMPreference implements C28114l {
    private String edV;
    C7577u eih;
    private String ejD;
    boolean ejU = false;
    private C15541f iFE;
    private C7616ad ldh;
    private C43387b pkh;

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI$1 */
    class C286831 implements OnMenuItemClickListener {
        C286831() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23422);
            ContactProfileMoreUI.this.finish();
            AppMethodBeat.m2505o(23422);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8499aj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String str;
        CharSequence optString;
        Throwable e;
        String str2 = null;
        AppMethodBeat.m2504i(23424);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f9169rn);
        setBackBtn(new C286831());
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejD = getIntent().getStringExtra("Contact_ChatRoomId");
        this.edV = getIntent().getStringExtra("Contact_User");
        C9638aw.m17190ZK();
        this.ldh = C18628c.m29078XM().aoO(this.edV);
        if (!C5046bo.isNullOrNil(this.ejD)) {
            C9638aw.m17190ZK();
            this.eih = C18628c.m29087XV().mo14885oa(this.ejD);
        }
        this.pkh = new C43387b(this, this.ldh);
        C40675h c40675h = this.yCw;
        this.iFE = c40675h;
        C7616ad c7616ad = this.ldh;
        Preference aqO = c40675h.aqO("common_chatroom");
        boolean z = C7616ad.aox(c7616ad.field_username) || c7616ad.field_username.equals(C1853r.m3846Yz());
        if (z) {
            c40675h.mo27715ce("common_chatroom", true);
        } else {
            if (c7616ad.dtS == 1) {
                aqO.setTitle((int) C25738R.string.avc);
            } else if (c7616ad.dtS == 2) {
                aqO.setTitle((int) C25738R.string.avb);
            } else {
                aqO.setTitle((int) C25738R.string.avg);
            }
            C20846i c20846i = new C20846i();
            c20846i.query = c7616ad.field_username;
            c20846i.mEw = this;
            c20846i.handler = new C7306ak(Looper.getMainLooper());
            c20846i.hbo = 5;
            ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        }
        Preference aqO2 = this.iFE.aqO("friend_source");
        switch (this.ldh.getSource()) {
            case 1:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1c);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1d);
                    break;
                }
            case 3:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1f);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1g);
                    break;
                }
            case 4:
            case 12:
                aqO2.setSummary((int) C25738R.string.bw3);
                break;
            case 8:
            case 14:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b0x);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b0y);
                    break;
                }
            case 10:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1l);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1m);
                    break;
                }
            case 13:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1l);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1m);
                    break;
                }
            case 15:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1_);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1a);
                    break;
                }
            case 17:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b0r);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b0u);
                    break;
                }
            case 18:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b11);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b12);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b1i);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b1j);
                    break;
                }
            case 25:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b0o);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b0p);
                    break;
                }
            case 30:
                if (this.ldh.mo16709Ol() <= 1000000) {
                    aqO2.setSummary((int) C25738R.string.b16);
                    break;
                } else {
                    aqO2.setSummary((int) C25738R.string.b17);
                    break;
                }
            case 34:
                aqO2.setSummary((int) C25738R.string.b0m);
                break;
            case 48:
                aqO2.setSummary((int) C25738R.string.b19);
                break;
            case C42464aa.CTRL_INDEX /*58*/:
            case C2206au.CTRL_INDEX /*59*/:
            case 60:
                aqO2.setSummary((int) C25738R.string.c8k);
                break;
            case 76:
                aqO2.setSummary((int) C25738R.string.b14);
                break;
            default:
                aqO2.setSummary((CharSequence) str2);
                break;
        }
        if (C5046bo.m7519ac(aqO2.getSummary())) {
            c40675h.mo27715ce("friend_source", true);
        }
        Preference aqO3 = c40675h.aqO("district");
        StringBuilder append = new StringBuilder().append(C1854s.m3868mL(this.ldh.getProvince()));
        if (C5046bo.isNullOrNil(this.ldh.getCity())) {
            str = "";
        } else {
            str = "  " + this.ldh.getCity();
        }
        aqO3.setSummary(append.append(str).toString());
        if (C5046bo.m7519ac(aqO3.getSummary())) {
            c40675h.mo27715ce("district", true);
        }
        aqO2 = c40675h.aqO("signature");
        aqO2.setSummary(C44089j.m79292b((Context) this, this.ldh.signature));
        if (C5046bo.m7519ac(aqO2.getSummary())) {
            c40675h.mo27715ce("district", true);
        }
        C7616ad c7616ad2 = this.ldh;
        aqO = c40675h.aqO("weishop");
        if (C1853r.m3846Yz().equals(c7616ad2.field_username)) {
            C9638aw.m17190ZK();
            str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) str2);
        } else {
            str = c7616ad2.duq;
        }
        Object optString2;
        if (C5046bo.isNullOrNil(str)) {
            str = str2;
            optString2 = str2;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str = jSONObject.optString("ShopUrl");
                try {
                    optString2 = jSONObject.optString("ShopName");
                } catch (JSONException e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.ContactProfileMoreUI", e, "", new Object[0]);
                    optString2 = str2;
                    if (!C5046bo.isNullOrNil(str)) {
                    }
                    if (C5046bo.m7519ac(aqO.getSummary())) {
                    }
                    ((CheckBoxPreference) c40675h.aqO("add_to_black")).uOT = this.ldh.mo16698Oa();
                    AppMethodBeat.m2505o(23424);
                }
            } catch (JSONException e3) {
                e = e3;
                str = str2;
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            aqO.setSummary(optString2);
            aqO.ksd = getResources().getColor(C25738R.color.a87);
            aqO.getExtras().putString("shopUrl", str);
        }
        if (C5046bo.m7519ac(aqO.getSummary())) {
            c40675h.mo27715ce("weishop", true);
            c40675h.mo27715ce("contact_info_category_1", true);
        } else {
            c40675h.mo27715ce("contact_info_category_1", false);
        }
        ((CheckBoxPreference) c40675h.aqO("add_to_black")).uOT = this.ldh.mo16698Oa();
        AppMethodBeat.m2505o(23424);
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        AppMethodBeat.m2504i(23425);
        Preference aqO = this.iFE.aqO("common_chatroom");
        if (c28109j.bFZ == 0) {
            aqO.setSummary(getString(C25738R.string.avf, new Object[]{Integer.valueOf(((Integer) ((C45966l) c28109j.mEy.get(0)).userData).intValue())}));
            aqO.getExtras().putInt("count", r0);
        } else {
            aqO.setSummary(getString(C25738R.string.avf, new Object[]{Integer.valueOf(0)}));
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.m2505o(23425);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(23423);
        if (preference.mKey.equals("common_chatroom")) {
            int i = preference.getExtras().getInt("count", 0);
            C3163e.m5424vW(i);
            if (i > 0) {
                Intent intent = new Intent(this, CommonChatroomInfoUI.class);
                intent.putExtra("Select_Talker_Name", this.ldh.field_username);
                startActivity(intent);
            }
            AppMethodBeat.m2505o(23423);
            return true;
        }
        if (preference.mKey.equals("weishop")) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", preference.getExtras().getString("shopUrl"));
            intent2.putExtra("geta8key_username", C1853r.m3846Yz());
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (preference.mKey.equals("send_to_friend")) {
            this.pkh.caw();
        } else if (preference.mKey.equals("add_to_black")) {
            this.pkh.mo68929jL(false);
        } else if (preference.mKey.equals("expose")) {
            this.pkh.cax();
        } else if (preference.mKey.equals("delete_contact")) {
            this.pkh.cav();
        }
        AppMethodBeat.m2505o(23423);
        return false;
    }
}
