package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI */
public class ContactSocialInfoUI extends MMPreference {
    private String cIS;
    private C15541f iFE;
    private C7616ad ldh;
    private long pmc;
    private String pmd;
    private C18817a pmm;
    private String pmn;
    private String pmo;
    private String pmp;
    private String pmq;
    private String pmr;
    private String pms;
    private String pmt;
    private JSONObject pmu;

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI$4 */
    class C214694 implements OnClickListener {
        C214694() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23443);
            ContactSocialInfoUI.m45581d(ContactSocialInfoUI.this);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, Integer.valueOf(1));
            AppMethodBeat.m2505o(23443);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI$1 */
    class C286851 implements OnMenuItemClickListener {
        C286851() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23440);
            ContactSocialInfoUI.this.finish();
            AppMethodBeat.m2505o(23440);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ void m45581d(ContactSocialInfoUI contactSocialInfoUI) {
        AppMethodBeat.m2504i(23455);
        contactSocialInfoUI.caS();
        AppMethodBeat.m2505o(23455);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8500ak;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23444);
        super.onCreate(bundle);
        this.cIS = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        C9638aw.m17190ZK();
        this.ldh = C18628c.m29078XM().aoO(this.cIS);
        initView();
        AppMethodBeat.m2505o(23444);
    }

    public final void initView() {
        AppMethodBeat.m2504i(23445);
        setMMTitle((int) C25738R.string.b0i);
        setBackBtn(new C286851());
        this.iFE = this.yCw;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (C5046bo.isNullOrNil(stringExtra) && C5046bo.isNullOrNil(stringExtra2)) {
            if (C5046bo.isNullOrNil(this.ldh.field_username)) {
                this.pmm = C32923a.getAddrUploadStg().mo34089vT(this.cIS);
            } else {
                this.pmm = C32923a.getAddrUploadStg().mo34089vT(this.ldh.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.pmm = C32923a.getAddrUploadStg().mo34092vW(stringExtra);
            if (this.pmm == null || this.pmm.mo34067Aq() == null || this.pmm.mo34067Aq().length() <= 0) {
                this.pmm = C32923a.getAddrUploadStg().mo34092vW(stringExtra2);
                if (!(this.pmm == null || this.pmm.mo34067Aq() == null)) {
                    this.pmm.mo34067Aq().length();
                }
            }
        }
        if (this.pmm == null || this.pmm.mo34067Aq() == null || this.pmm.mo34067Aq().length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.pmn);
        } else {
            this.pmo = C5046bo.nullAsNil(this.pmm.apA()) + " " + C5046bo.nullAsNil(this.pmm.apG()).replace(" ", "");
        }
        m45584s("contact_info_social_mobile", this.pmo, true);
        C9638aw.m17190ZK();
        int h = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(9, null));
        this.pmc = getIntent().getLongExtra("Contact_Uin", 0);
        this.pmd = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.pmc == 0 || h == 0)) {
            if (this.pmd == null || this.pmd.length() == 0) {
                C9878ao jx = ContactSocialInfoUI.m45582jx(this.pmc);
                if (jx != null) {
                    this.pmd = jx.getDisplayName();
                }
            }
            this.pmp = C5046bo.nullAsNil(this.pmd);
            this.pmp += " " + new C1183p(this.pmc).longValue();
        }
        m45584s("contact_info_social_qq", this.pmp, true);
        stringExtra = C26373g.m41964Nu().getValue("LinkedinPluginClose");
        boolean z = C5046bo.isNullOrNil(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || C5046bo.isNullOrNil(this.ldh.dun)) {
            this.pmq = "";
        } else {
            this.pmq = this.ldh.duo;
        }
        m45584s("contact_info_social_linkedin", this.pmq, true);
        m45584s("contact_info_social_facebook", this.pmr, false);
        this.pmt = C5046bo.m7532bc(getIntent().getStringExtra("verify_gmail"), "");
        this.pms = C5046bo.m7532bc(getIntent().getStringExtra("profileName"), C5046bo.anu(this.pmt));
        if (C5046bo.isNullOrNil(this.pmt) || C5046bo.isNullOrNil(this.pms)) {
            m45584s("contact_info_social_googlecontacts", "", false);
        } else {
            m45584s("contact_info_social_googlecontacts", this.pms + 10 + this.pmt, false);
        }
        if (C1853r.m3846Yz().equals(this.ldh.field_username)) {
            C9638aw.m17190ZK();
            stringExtra = (String) C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_STRING, null);
            C4990ab.m7417i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", stringExtra);
        } else {
            stringExtra = this.ldh.duq;
            C4990ab.m7417i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", stringExtra);
        }
        if (!C5046bo.isNullOrNil(stringExtra)) {
            try {
                this.pmu = new JSONObject(stringExtra);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e, "", new Object[0]);
                this.pmu = null;
            }
        }
        if (this.pmu != null) {
            m45584s("contact_info_social_weishop", this.pmu.optString("ShopName"), true);
            AppMethodBeat.m2505o(23445);
            return;
        }
        m45584s("contact_info_social_weishop", "", false);
        AppMethodBeat.m2505o(23445);
    }

    /* renamed from: jx */
    private static C9878ao m45582jx(long j) {
        AppMethodBeat.m2504i(23446);
        C9878ao ge = C32923a.getQQListStg().mo73284ge(j);
        if (ge == null) {
            AppMethodBeat.m2505o(23446);
            return null;
        }
        AppMethodBeat.m2505o(23446);
        return ge;
    }

    /* renamed from: s */
    private void m45584s(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(23447);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
            this.iFE.aqP(str);
            AppMethodBeat.m2505o(23447);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.iFE.aqO(str);
        if (keyValuePreference != null) {
            keyValuePreference.dAB();
            if (z) {
                keyValuePreference.ksd = getResources().getColor(C25738R.color.f12123t7);
            }
            keyValuePreference.setSummary((CharSequence) str2);
            keyValuePreference.mo41844qi(false);
        }
        AppMethodBeat.m2505o(23447);
    }

    /* renamed from: q */
    private boolean m45583q(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(23449);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a = C38033l.m64344a(str, this.mController.ylL, byteArrayOutputStream.toByteArray());
            AppMethodBeat.m2505o(23449);
            return a;
        }
        AppMethodBeat.m2505o(23449);
        return false;
    }

    /* renamed from: UP */
    private void m45574UP(String str) {
        AppMethodBeat.m2504i(23450);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        startActivity(intent);
        AppMethodBeat.m2505o(23450);
    }

    private void caS() {
        AppMethodBeat.m2504i(23451);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pmu.optString("ShopUrl"));
        intent.putExtra("geta8key_username", C1853r.m3846Yz());
        C25985d.m41467b(this.mController.ylL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(23451);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(23448);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.pmm == null || this.ldh == null)) {
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().aoJ(this.pmm.getUsername())) {
                    String[] stringArray;
                    if (this.pmm == null || C5046bo.isNullOrNil(this.pmm.frQ)) {
                        stringArray = getResources().getStringArray(C25738R.array.f12626a_);
                    } else {
                        stringArray = getResources().getStringArray(C25738R.array.f12625a9);
                    }
                    if (C39503b.gkF.mo38848BX()) {
                        ArrayList P = C5046bo.m7508P(stringArray);
                        P.add(getResources().getString(C25738R.string.anc));
                        stringArray = (String[]) P.toArray(new String[P.size()]);
                        C7060h.pYm.mo8381e(11621, Integer.valueOf(2), Integer.valueOf(3));
                    }
                    C30379h.m48422a((Context) this, null, stringArray, null, new C30391c() {
                        /* renamed from: iE */
                        public final void mo7700iE(int i) {
                            AppMethodBeat.m2504i(23441);
                            switch (i) {
                                case 0:
                                    if (ContactSocialInfoUI.this.pmo == null || ContactSocialInfoUI.this.pmo.length() == 0) {
                                        AppMethodBeat.m2505o(23441);
                                        return;
                                    }
                                    int lastIndexOf = ContactSocialInfoUI.this.pmo.lastIndexOf(32) + 1;
                                    if (lastIndexOf > 0) {
                                        ContactSocialInfoUI.m45576a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.pmo.substring(lastIndexOf));
                                        AppMethodBeat.m2505o(23441);
                                        return;
                                    }
                                    break;
                                case 1:
                                    if (ContactSocialInfoUI.this.pmo == null || ContactSocialInfoUI.this.pmo.length() == 0) {
                                        AppMethodBeat.m2505o(23441);
                                        return;
                                    }
                                    String substring = ContactSocialInfoUI.this.pmo.substring(0, ContactSocialInfoUI.this.pmo.lastIndexOf(32));
                                    if (substring == null || substring.length() == 0) {
                                        AppMethodBeat.m2505o(23441);
                                        return;
                                    }
                                    C1855t.m3887b(ContactSocialInfoUI.this.ldh, substring.trim());
                                    AppMethodBeat.m2505o(23441);
                                    return;
                                case 2:
                                    if (stringArray == null || stringArray.length <= 2 || ContactSocialInfoUI.this.pmm == null || ContactSocialInfoUI.this.ldh == null) {
                                        AppMethodBeat.m2505o(23441);
                                        return;
                                    } else if (!(ContactSocialInfoUI.this.pmm == null || C5046bo.isNullOrNil(ContactSocialInfoUI.this.pmm.frQ))) {
                                        ContactSocialInfoUI.m45577a(ContactSocialInfoUI.this, ContactSocialInfoUI.this.ldh.field_username, ContactSocialInfoUI.this.pmm.frQ);
                                        AppMethodBeat.m2505o(23441);
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
                            C39503b.gkE.mo38925j(intent, ContactSocialInfoUI.this);
                            AppMethodBeat.m2505o(23441);
                        }
                    });
                } else if (!(this.pmo == null || this.pmo.length() == 0)) {
                    int lastIndexOf = this.pmo.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        m45574UP(this.pmo.substring(lastIndexOf));
                    }
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                str = this.ldh.dup;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.pmu == null)) {
                C9638aw.m17190ZK();
                if (C18628c.m29072Ry().get(C5127a.USERINFO_PROFILE_WEIDIANINFO_ALERT_INT, null) == null) {
                    C30379h.m48432a((Context) this, (int) C25738R.string.b0k, (int) C25738R.string.f9238tz, new C214694(), null);
                } else {
                    caS();
                }
            }
        }
        AppMethodBeat.m2505o(23448);
        return false;
    }
}
