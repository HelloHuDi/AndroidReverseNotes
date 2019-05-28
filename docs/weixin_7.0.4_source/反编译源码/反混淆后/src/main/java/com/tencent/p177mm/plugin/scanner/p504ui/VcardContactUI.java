package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r;
import com.tencent.p177mm.plugin.scanner.p740a.C39626r.C13118a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.ui.VcardContactUI */
public class VcardContactUI extends MMPreference {
    private static ArrayList<String> qgT = new ArrayList();
    private static int qgV = 1;
    private static int qgW = 1;
    private C15541f ehK;
    private C39626r qgS;
    private C28914r qgU;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.VcardContactUI$3 */
    class C217243 implements OnMenuItemClickListener {
        C217243() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(81347);
            VcardContactUI.this.finish();
            AppMethodBeat.m2505o(81347);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.VcardContactUI$4 */
    class C217254 implements C30391c {
        C217254() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(81348);
            Intent intent;
            switch (i) {
                case 0:
                    C37907bv.aaq().mo60662c(10238, Integer.valueOf(1));
                    intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                    VcardContactUI.m33261a(VcardContactUI.this, intent);
                    VcardContactUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(81348);
                    return;
                case 1:
                    C37907bv.aaq().mo60662c(10239, Integer.valueOf(1));
                    intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                    intent.setType("vnd.android.cursor.item/person");
                    VcardContactUI.m33261a(VcardContactUI.this, intent);
                    VcardContactUI.this.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(81348);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static {
        AppMethodBeat.m2504i(81359);
        AppMethodBeat.m2505o(81359);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(81349);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(81349);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(81351);
        this.qgU = new C28914r(this);
        this.ehK = this.yCw;
        this.qgS = C39626r.qaD;
        setBackBtn(new C217243());
        setMMTitle("");
        aqI();
        AppMethodBeat.m2505o(81351);
    }

    private void aqI() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        AppMethodBeat.m2504i(81352);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8574cn);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.ehK.aqO("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            vcardContactUserHeaderPreference.mo62587a(this.qgS);
        }
        this.ehK.aqP("c_contact_info_wx_id");
        if (C5046bo.isNullOrNil(this.qgS.hHN)) {
            this.ehK.aqP("v_contact_info_photo_uri");
            this.ehK.aqP("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.hHN);
                vcardContactLinkPreference.mo41844qi(false);
                vcardContactLinkPreference.yCj = false;
                qgV += 2;
                qgW += 2;
            }
        }
        chN();
        chM();
        if (C5046bo.isNullOrNil(this.qgS.hHW)) {
            this.ehK.aqP("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.hHW);
                keyValuePreference.mo41844qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (C5046bo.isNullOrNil(this.qgS.qaB)) {
            this.ehK.aqP("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaB);
                keyValuePreference.mo41844qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (C5046bo.isNullOrNil(this.qgS.url)) {
            this.ehK.aqP("v_contact_info_home_page");
            this.ehK.aqP("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.url);
                vcardContactLinkPreference.mo41844qi(false);
                vcardContactLinkPreference.yCj = true;
            }
        }
        if (C5046bo.isNullOrNil(this.qgS.dtV)) {
            this.ehK.aqP("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.dtV);
                vcardContactLinkPreference.mo41844qi(false);
                vcardContactLinkPreference.yCj = true;
            }
        }
        if (C5046bo.isNullOrNil(this.qgS.qaq)) {
            this.ehK.aqP("v_contact_info_birthday");
            this.ehK.aqP("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaq);
                keyValuePreference.mo41844qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (C5046bo.isNullOrNil(this.qgS.qaC)) {
            this.ehK.aqP("v_contact_info_remark");
            this.ehK.aqP("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaC);
                keyValuePreference.mo41844qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (this.qgS.qao == null || !this.qgS.qao.qaG.contains(ShareConstants.MEDIA_URI)) {
            this.ehK.aqP("v_contact_info_logo");
            this.ehK.aqP("v_category_logo");
            AppMethodBeat.m2505o(81352);
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_logo");
        vcardContactLinkPreference.setSummary((CharSequence) this.qgS.qao.qaH);
        vcardContactLinkPreference.yCj = false;
        vcardContactLinkPreference.mo41844qi(false);
        AppMethodBeat.m2505o(81352);
    }

    private void chM() {
        AppMethodBeat.m2504i(81353);
        List list = this.qgS.qax;
        if (list != null && list.size() > 0) {
            m33263b(list, "WorkTel", this.mController.ylL.getString(C25738R.string.f0e));
        }
        list = this.qgS.qaw;
        if (list != null && list.size() > 0) {
            m33263b(list, "HomeTel", this.mController.ylL.getString(C25738R.string.f03));
        }
        list = this.qgS.qay;
        if (list != null && list.size() > 0) {
            m33263b(list, "VideoTEL", this.mController.ylL.getString(C25738R.string.f0b));
        }
        list = this.qgS.qaz;
        if (list != null && list.size() > 0) {
            m33263b(list, "NormalTel", this.mController.ylL.getString(C25738R.string.f06));
        }
        list = this.qgS.qav;
        if (list != null && list.size() > 0) {
            m33263b(list, "CellTel", this.mController.ylL.getString(C25738R.string.ezz));
        }
        AppMethodBeat.m2505o(81353);
    }

    private void chN() {
        AppMethodBeat.m2504i(81354);
        C13118a c13118a = this.qgS.qat;
        if (c13118a != null && c13118a.aDu().length() > 0) {
            m33264fS(c13118a.aDu(), this.mController.ylL.getString(C25738R.string.f01));
        }
        c13118a = this.qgS.qau;
        if (c13118a != null && c13118a.aDu().length() > 0) {
            m33264fS(c13118a.aDu(), this.mController.ylL.getString(C25738R.string.f0d));
        }
        c13118a = this.qgS.qar;
        if (c13118a != null && c13118a.aDu().length() > 0) {
            m33264fS(c13118a.aDu(), this.mController.ylL.getString(C25738R.string.ezw));
        }
        c13118a = this.qgS.qas;
        if (c13118a != null && c13118a.aDu().length() > 0) {
            m33264fS(c13118a.aDu(), this.mController.ylL.getString(C25738R.string.ezw));
        }
        AppMethodBeat.m2505o(81354);
    }

    /* renamed from: b */
    private void m33263b(List<String> list, String str, String str2) {
        AppMethodBeat.m2504i(81355);
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                VcardContactLinkPreference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!qgT.contains(str + String.valueOf(str3))) {
                    qgT.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle((CharSequence) str2);
                vcardContactLinkPreference.setLayoutResource(2130970127);
                vcardContactLinkPreference.setSummary((CharSequence) str3);
                vcardContactLinkPreference.mo41844qi(false);
                vcardContactLinkPreference.yCj = true;
                vcardContactLinkPreference.dAD();
                this.ehK.mo27708a(vcardContactLinkPreference, qgV);
            }
        }
        AppMethodBeat.m2505o(81355);
    }

    /* renamed from: fS */
    private void m33264fS(String str, String str2) {
        AppMethodBeat.m2504i(81356);
        KeyValuePreference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle((CharSequence) str2);
        keyValuePreference.setLayoutResource(2130970127);
        keyValuePreference.mo41844qi(false);
        keyValuePreference.setSummary((CharSequence) str);
        keyValuePreference.yCj = false;
        keyValuePreference.dAD();
        this.ehK.mo27708a(keyValuePreference, qgW);
        AppMethodBeat.m2505o(81356);
    }

    /* renamed from: a */
    private static void m33262a(List<String> list, Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(81357);
        for (String str : list) {
            if (i2 == 1) {
                intent.putExtra("phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 2) {
                intent.putExtra("secondary_phone", str);
                intent.putExtra("phone_type", i);
            } else if (i2 == 3) {
                intent.putExtra("tertiary_phone", str);
                intent.putExtra("phone_type", i);
            }
        }
        AppMethodBeat.m2505o(81357);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(81350);
        if (preference.mKey.equals("add_vcard_contact")) {
            C30379h.m48422a((Context) this, "", new String[]{getString(C25738R.string.ezv), getString(C25738R.string.ezu)}, "", new C217254());
            AppMethodBeat.m2505o(81350);
            return true;
        }
        String str;
        if (preference.mKey.equals("v_contact_info_photo_uri") || preference.mKey.equals("v_contact_info_home_page") || preference.mKey.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                C1202f c1202f = this.qgU;
                if (!c1202f.ppI.doT()) {
                    C4990ab.m7412e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    C4990ab.m7412e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    c1202f.url = charSequence;
                    str = (String) C1720g.m3536RP().mo5239Ry().get(46, null);
                    if (str == null || str.length() == 0) {
                        c1202f.mo47030c(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, c1202f);
                        c1202f.qhf = new C6681h(charSequence, null, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                        C1720g.m3540Rg().mo14541a(c1202f.qhf, 0);
                        c1202f.ppI.mo16770ae(3000, 3000);
                    }
                }
                AppMethodBeat.m2505o(81350);
                return true;
            }
        } else if (qgT.contains(preference.mKey) && !preference.mKey.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                C30379h.m48422a((Context) this, "", new String[]{getString(C25738R.string.avl)}, "", new C30391c() {
                    /* renamed from: iE */
                    public final void mo7700iE(int i) {
                        AppMethodBeat.m2504i(81345);
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                                VcardContactUI.this.startActivity(intent);
                                break;
                        }
                        AppMethodBeat.m2505o(81345);
                    }
                });
                AppMethodBeat.m2505o(81350);
                return true;
            }
        } else if (preference.mKey.equals("v_contact_info_email")) {
            str = preference.getSummary().toString();
            C30379h.m48422a((Context) this, "", new String[]{this.mController.ylL.getString(C25738R.string.e37), this.mController.ylL.getString(C25738R.string.e36)}, "", new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(81346);
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent();
                            String[] strArr = new String[]{str + " " + str};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            C25985d.m41467b(VcardContactUI.this, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.m2505o(81346);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
                            VcardContactUI.this.startActivity(intent);
                            break;
                    }
                    AppMethodBeat.m2505o(81346);
                }
            });
        }
        AppMethodBeat.m2505o(81350);
        return false;
    }
}
