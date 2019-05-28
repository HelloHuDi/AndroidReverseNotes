package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private String cIS;
    private f iFE;
    private ad ldh;
    private long pmc;
    private String pmd;
    private a pmm;
    private String pmn;
    private String pmo;
    private String pmp;
    private String pmq;
    private String pmr;
    private String pms;
    private String pmt;
    private JSONObject pmu;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(ContactSocialInfoUI contactSocialInfoUI) {
        AppMethodBeat.i(23455);
        contactSocialInfoUI.caS();
        AppMethodBeat.o(23455);
    }

    public final int JC() {
        return R.xml.ak;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23444);
        super.onCreate(bundle);
        this.cIS = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        aw.ZK();
        this.ldh = c.XM().aoO(this.cIS);
        initView();
        AppMethodBeat.o(23444);
    }

    public final void initView() {
        AppMethodBeat.i(23445);
        setMMTitle((int) R.string.b0i);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23440);
                ContactSocialInfoUI.this.finish();
                AppMethodBeat.o(23440);
                return true;
            }
        });
        this.iFE = this.yCw;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (bo.isNullOrNil(stringExtra) && bo.isNullOrNil(stringExtra2)) {
            if (bo.isNullOrNil(this.ldh.field_username)) {
                this.pmm = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.cIS);
            } else {
                this.pmm = com.tencent.mm.plugin.account.a.getAddrUploadStg().vT(this.ldh.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.pmm = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra);
            if (this.pmm == null || this.pmm.Aq() == null || this.pmm.Aq().length() <= 0) {
                this.pmm = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(stringExtra2);
                if (!(this.pmm == null || this.pmm.Aq() == null)) {
                    this.pmm.Aq().length();
                }
            }
        }
        if (this.pmm == null || this.pmm.Aq() == null || this.pmm.Aq().length() <= 0) {
            ab.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.pmn);
        } else {
            this.pmo = bo.nullAsNil(this.pmm.apA()) + " " + bo.nullAsNil(this.pmm.apG()).replace(" ", "");
        }
        s("contact_info_social_mobile", this.pmo, true);
        aw.ZK();
        int h = bo.h((Integer) c.Ry().get(9, null));
        this.pmc = getIntent().getLongExtra("Contact_Uin", 0);
        this.pmd = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.pmc == 0 || h == 0)) {
            if (this.pmd == null || this.pmd.length() == 0) {
                ao jx = jx(this.pmc);
                if (jx != null) {
                    this.pmd = jx.getDisplayName();
                }
            }
            this.pmp = bo.nullAsNil(this.pmd);
            this.pmp += " " + new p(this.pmc).longValue();
        }
        s("contact_info_social_qq", this.pmp, true);
        stringExtra = g.Nu().getValue("LinkedinPluginClose");
        boolean z = bo.isNullOrNil(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || bo.isNullOrNil(this.ldh.dun)) {
            this.pmq = "";
        } else {
            this.pmq = this.ldh.duo;
        }
        s("contact_info_social_linkedin", this.pmq, true);
        s("contact_info_social_facebook", this.pmr, false);
        this.pmt = bo.bc(getIntent().getStringExtra("verify_gmail"), "");
        this.pms = bo.bc(getIntent().getStringExtra("profileName"), bo.anu(this.pmt));
        if (bo.isNullOrNil(this.pmt) || bo.isNullOrNil(this.pms)) {
            s("contact_info_social_googlecontacts", "", false);
        } else {
            s("contact_info_social_googlecontacts", this.pms + 10 + this.pmt, false);
        }
        if (r.Yz().equals(this.ldh.field_username)) {
            aw.ZK();
            stringExtra = (String) c.Ry().get(ac.a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
            ab.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", stringExtra);
        } else {
            stringExtra = this.ldh.duq;
            ab.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", stringExtra);
        }
        if (!bo.isNullOrNil(stringExtra)) {
            try {
                this.pmu = new JSONObject(stringExtra);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e, "", new Object[0]);
                this.pmu = null;
            }
        }
        if (this.pmu != null) {
            s("contact_info_social_weishop", this.pmu.optString("ShopName"), true);
            AppMethodBeat.o(23445);
            return;
        }
        s("contact_info_social_weishop", "", false);
        AppMethodBeat.o(23445);
    }

    private static ao jx(long j) {
        AppMethodBeat.i(23446);
        ao ge = com.tencent.mm.plugin.account.a.getQQListStg().ge(j);
        if (ge == null) {
            AppMethodBeat.o(23446);
            return null;
        }
        AppMethodBeat.o(23446);
        return ge;
    }

    private void s(String str, String str2, boolean z) {
        AppMethodBeat.i(23447);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
            this.iFE.aqP(str);
            AppMethodBeat.o(23447);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.iFE.aqO(str);
        if (keyValuePreference != null) {
            keyValuePreference.dAB();
            if (z) {
                keyValuePreference.ksd = getResources().getColor(R.color.t7);
            }
            keyValuePreference.setSummary((CharSequence) str2);
            keyValuePreference.qi(false);
        }
        AppMethodBeat.o(23447);
    }

    private boolean q(String str, Bitmap bitmap) {
        AppMethodBeat.i(23449);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a = l.a(str, this.mController.ylL, byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(23449);
            return a;
        }
        AppMethodBeat.o(23449);
        return false;
    }

    private void UP(String str) {
        AppMethodBeat.i(23450);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        startActivity(intent);
        AppMethodBeat.o(23450);
    }

    private void caS() {
        AppMethodBeat.i(23451);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pmu.optString("ShopUrl"));
        intent.putExtra("geta8key_username", r.Yz());
        d.b(this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(23451);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(23448);
        String str = preference.mKey;
        ab.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.pmm == null || this.ldh == null)) {
                aw.ZK();
                if (c.XM().aoJ(this.pmm.getUsername())) {
                    String[] stringArray;
                    if (this.pmm == null || bo.isNullOrNil(this.pmm.frQ)) {
                        stringArray = getResources().getStringArray(R.array.a_);
                    } else {
                        stringArray = getResources().getStringArray(R.array.a9);
                    }
                    if (b.gkF.BX()) {
                        ArrayList P = bo.P(stringArray);
                        P.add(getResources().getString(R.string.anc));
                        stringArray = (String[]) P.toArray(new String[P.size()]);
                        h.pYm.e(11621, Integer.valueOf(2), Integer.valueOf(3));
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, null, stringArray, null, new com.tencent.mm.ui.base.h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(23441);
                            switch (i) {
                                case 0:
                                    if (ContactSocialInfoUI.this.pmo == null || ContactSocialInfoUI.this.pmo.length() == 0) {
                                        AppMethodBeat.o(23441);
                                        return;
                                    }
                                    int lastIndexOf = ContactSocialInfoUI.this.pmo.lastIndexOf(32) + 1;
                                    if (lastIndexOf > 0) {
                                        ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.pmo.substring(lastIndexOf));
                                        AppMethodBeat.o(23441);
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (ContactSocialInfoUI.this.pmo == null || ContactSocialInfoUI.this.pmo.length() == 0) {
                                        AppMethodBeat.o(23441);
                                        return;
                                    }
                                    String substring = ContactSocialInfoUI.this.pmo.substring(0, ContactSocialInfoUI.this.pmo.lastIndexOf(32));
                                    if (substring == null || substring.length() == 0) {
                                        AppMethodBeat.o(23441);
                                        return;
                                    }
                                    t.b(ContactSocialInfoUI.this.ldh, substring.trim());
                                    AppMethodBeat.o(23441);
                                    return;
                                case 2:
                                    if (stringArray == null || stringArray.length <= 2 || ContactSocialInfoUI.this.pmm == null || ContactSocialInfoUI.this.ldh == null) {
                                        AppMethodBeat.o(23441);
                                        return;
                                    } else if (!(ContactSocialInfoUI.this.pmm == null || bo.isNullOrNil(ContactSocialInfoUI.this.pmm.frQ))) {
                                        ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.ldh.field_username, ContactSocialInfoUI.this.pmm.frQ);
                                        AppMethodBeat.o(23441);
                                        return;
                                    }
                                    break;
                                case 3:
                                    break;
                            }
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putInt("fromScene", 2);
                            intent.putExtra("reportArgs", bundle);
                            b.gkE.j(intent, ContactSocialInfoUI.this);
                            AppMethodBeat.o(23441);
                        }
                    });
                } else if (!(this.pmo == null || this.pmo.length() == 0)) {
                    int lastIndexOf = this.pmo.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        UP(this.pmo.substring(lastIndexOf));
                    }
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                str = this.ldh.dup;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", r.Yz());
                    d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.pmu == null)) {
                aw.ZK();
                if (c.Ry().get(ac.a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, null) == null) {
                    com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.b0k, (int) R.string.tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23443);
                            ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                            aw.ZK();
                            c.Ry().set(ac.a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, Integer.valueOf(1));
                            AppMethodBeat.o(23443);
                        }
                    }, null);
                } else {
                    caS();
                }
            }
        }
        AppMethodBeat.o(23448);
        return false;
    }
}
