package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.view.d;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactProfileMoreUI extends MMPreference implements l {
    private String edV;
    u eih;
    private String ejD;
    boolean ejU = false;
    private f iFE;
    private ad ldh;
    private b pkh;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.aj;
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
        AppMethodBeat.i(23424);
        super.onCreate(bundle);
        setMMTitle((int) R.string.rn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23422);
                ContactProfileMoreUI.this.finish();
                AppMethodBeat.o(23422);
                return true;
            }
        });
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejD = getIntent().getStringExtra("Contact_ChatRoomId");
        this.edV = getIntent().getStringExtra("Contact_User");
        aw.ZK();
        this.ldh = c.XM().aoO(this.edV);
        if (!bo.isNullOrNil(this.ejD)) {
            aw.ZK();
            this.eih = c.XV().oa(this.ejD);
        }
        this.pkh = new b(this, this.ldh);
        h hVar = this.yCw;
        this.iFE = hVar;
        ad adVar = this.ldh;
        Preference aqO = hVar.aqO("common_chatroom");
        boolean z = ad.aox(adVar.field_username) || adVar.field_username.equals(r.Yz());
        if (z) {
            hVar.ce("common_chatroom", true);
        } else {
            if (adVar.dtS == 1) {
                aqO.setTitle((int) R.string.avc);
            } else if (adVar.dtS == 2) {
                aqO.setTitle((int) R.string.avb);
            } else {
                aqO.setTitle((int) R.string.avg);
            }
            i iVar = new i();
            iVar.query = adVar.field_username;
            iVar.mEw = this;
            iVar.handler = new ak(Looper.getMainLooper());
            iVar.hbo = 5;
            ((n) g.M(n.class)).search(2, iVar);
        }
        Preference aqO2 = this.iFE.aqO("friend_source");
        switch (this.ldh.getSource()) {
            case 1:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1c);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1d);
                    break;
                }
            case 3:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1f);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1g);
                    break;
                }
            case 4:
            case 12:
                aqO2.setSummary((int) R.string.bw3);
                break;
            case 8:
            case 14:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b0x);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b0y);
                    break;
                }
            case 10:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1l);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1m);
                    break;
                }
            case 13:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1l);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1m);
                    break;
                }
            case 15:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1_);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1a);
                    break;
                }
            case 17:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b0r);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b0u);
                    break;
                }
            case 18:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b11);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b12);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b1i);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b1j);
                    break;
                }
            case 25:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b0o);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b0p);
                    break;
                }
            case 30:
                if (this.ldh.Ol() <= 1000000) {
                    aqO2.setSummary((int) R.string.b16);
                    break;
                } else {
                    aqO2.setSummary((int) R.string.b17);
                    break;
                }
            case 34:
                aqO2.setSummary((int) R.string.b0m);
                break;
            case 48:
                aqO2.setSummary((int) R.string.b19);
                break;
            case aa.CTRL_INDEX /*58*/:
            case au.CTRL_INDEX /*59*/:
            case 60:
                aqO2.setSummary((int) R.string.c8k);
                break;
            case 76:
                aqO2.setSummary((int) R.string.b14);
                break;
            default:
                aqO2.setSummary((CharSequence) str2);
                break;
        }
        if (bo.ac(aqO2.getSummary())) {
            hVar.ce("friend_source", true);
        }
        Preference aqO3 = hVar.aqO("district");
        StringBuilder append = new StringBuilder().append(s.mL(this.ldh.getProvince()));
        if (bo.isNullOrNil(this.ldh.getCity())) {
            str = "";
        } else {
            str = "  " + this.ldh.getCity();
        }
        aqO3.setSummary(append.append(str).toString());
        if (bo.ac(aqO3.getSummary())) {
            hVar.ce("district", true);
        }
        aqO2 = hVar.aqO("signature");
        aqO2.setSummary(j.b((Context) this, this.ldh.signature));
        if (bo.ac(aqO2.getSummary())) {
            hVar.ce("district", true);
        }
        ad adVar2 = this.ldh;
        aqO = hVar.aqO("weishop");
        if (r.Yz().equals(adVar2.field_username)) {
            aw.ZK();
            str = (String) c.Ry().get(a.USERINFO_PROFILE_WEIDIANINFO_STRING, (Object) str2);
        } else {
            str = adVar2.duq;
        }
        Object optString2;
        if (bo.isNullOrNil(str)) {
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
                    ab.printErrStackTrace("MicroMsg.ContactProfileMoreUI", e, "", new Object[0]);
                    optString2 = str2;
                    if (!bo.isNullOrNil(str)) {
                    }
                    if (bo.ac(aqO.getSummary())) {
                    }
                    ((CheckBoxPreference) hVar.aqO("add_to_black")).uOT = this.ldh.Oa();
                    AppMethodBeat.o(23424);
                }
            } catch (JSONException e3) {
                e = e3;
                str = str2;
            }
        }
        if (bo.isNullOrNil(str)) {
            aqO.setSummary(optString2);
            aqO.ksd = getResources().getColor(R.color.a87);
            aqO.getExtras().putString("shopUrl", str);
        }
        if (bo.ac(aqO.getSummary())) {
            hVar.ce("weishop", true);
            hVar.ce("contact_info_category_1", true);
        } else {
            hVar.ce("contact_info_category_1", false);
        }
        ((CheckBoxPreference) hVar.aqO("add_to_black")).uOT = this.ldh.Oa();
        AppMethodBeat.o(23424);
    }

    public final void b(com.tencent.mm.plugin.fts.a.a.j jVar) {
        AppMethodBeat.i(23425);
        Preference aqO = this.iFE.aqO("common_chatroom");
        if (jVar.bFZ == 0) {
            aqO.setSummary(getString(R.string.avf, new Object[]{Integer.valueOf(((Integer) ((com.tencent.mm.plugin.fts.a.a.l) jVar.mEy.get(0)).userData).intValue())}));
            aqO.getExtras().putInt("count", r0);
        } else {
            aqO.setSummary(getString(R.string.avf, new Object[]{Integer.valueOf(0)}));
        }
        this.iFE.notifyDataSetChanged();
        AppMethodBeat.o(23425);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(23423);
        if (preference.mKey.equals("common_chatroom")) {
            int i = preference.getExtras().getInt("count", 0);
            e.vW(i);
            if (i > 0) {
                Intent intent = new Intent(this, CommonChatroomInfoUI.class);
                intent.putExtra("Select_Talker_Name", this.ldh.field_username);
                startActivity(intent);
            }
            AppMethodBeat.o(23423);
            return true;
        }
        if (preference.mKey.equals("weishop")) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", preference.getExtras().getString("shopUrl"));
            intent2.putExtra("geta8key_username", r.Yz());
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (preference.mKey.equals("send_to_friend")) {
            this.pkh.caw();
        } else if (preference.mKey.equals("add_to_black")) {
            this.pkh.jL(false);
        } else if (preference.mKey.equals("expose")) {
            this.pkh.cax();
        } else if (preference.mKey.equals("delete_contact")) {
            this.pkh.cav();
        }
        AppMethodBeat.o(23423);
        return false;
    }
}
