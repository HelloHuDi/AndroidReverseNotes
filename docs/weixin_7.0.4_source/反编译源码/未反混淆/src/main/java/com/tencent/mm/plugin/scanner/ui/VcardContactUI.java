package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.scanner.a.r;
import com.tencent.mm.plugin.scanner.a.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.List;

public class VcardContactUI extends MMPreference {
    private static ArrayList<String> qgT = new ArrayList();
    private static int qgV = 1;
    private static int qgW = 1;
    private f ehK;
    private r qgS;
    private r qgU;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(81359);
        AppMethodBeat.o(81359);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(81349);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(81349);
    }

    public final int JC() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(81351);
        this.qgU = new r(this);
        this.ehK = this.yCw;
        this.qgS = r.qaD;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(81347);
                VcardContactUI.this.finish();
                AppMethodBeat.o(81347);
                return true;
            }
        });
        setMMTitle("");
        aqI();
        AppMethodBeat.o(81351);
    }

    private void aqI() {
        VcardContactLinkPreference vcardContactLinkPreference;
        KeyValuePreference keyValuePreference;
        AppMethodBeat.i(81352);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.cn);
        VcardContactUserHeaderPreference vcardContactUserHeaderPreference = (VcardContactUserHeaderPreference) this.ehK.aqO("v_contact_info_header");
        if (vcardContactUserHeaderPreference != null) {
            vcardContactUserHeaderPreference.a(this.qgS);
        }
        this.ehK.aqP("c_contact_info_wx_id");
        if (bo.isNullOrNil(this.qgS.hHN)) {
            this.ehK.aqP("v_contact_info_photo_uri");
            this.ehK.aqP("v_category_photo_uri");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_photo_uri");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.hHN);
                vcardContactLinkPreference.qi(false);
                vcardContactLinkPreference.yCj = false;
                qgV += 2;
                qgW += 2;
            }
        }
        chN();
        chM();
        if (bo.isNullOrNil(this.qgS.hHW)) {
            this.ehK.aqP("v_contact_info_org");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_org");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.hHW);
                keyValuePreference.qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (bo.isNullOrNil(this.qgS.qaB)) {
            this.ehK.aqP("v_contact_info_agent");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_agent");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaB);
                keyValuePreference.qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (bo.isNullOrNil(this.qgS.url)) {
            this.ehK.aqP("v_contact_info_home_page");
            this.ehK.aqP("v_category_home_page");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_home_page");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.url);
                vcardContactLinkPreference.qi(false);
                vcardContactLinkPreference.yCj = true;
            }
        }
        if (bo.isNullOrNil(this.qgS.dtV)) {
            this.ehK.aqP("v_contact_info_email");
        } else {
            vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_email");
            if (vcardContactLinkPreference != null) {
                vcardContactLinkPreference.setSummary((CharSequence) this.qgS.dtV);
                vcardContactLinkPreference.qi(false);
                vcardContactLinkPreference.yCj = true;
            }
        }
        if (bo.isNullOrNil(this.qgS.qaq)) {
            this.ehK.aqP("v_contact_info_birthday");
            this.ehK.aqP("v_category_birthday");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_birthday");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaq);
                keyValuePreference.qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (bo.isNullOrNil(this.qgS.qaC)) {
            this.ehK.aqP("v_contact_info_remark");
            this.ehK.aqP("v_category_remark");
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("v_contact_info_remark");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.qgS.qaC);
                keyValuePreference.qi(false);
                keyValuePreference.yCj = true;
            }
        }
        if (this.qgS.qao == null || !this.qgS.qao.qaG.contains(ShareConstants.MEDIA_URI)) {
            this.ehK.aqP("v_contact_info_logo");
            this.ehK.aqP("v_category_logo");
            AppMethodBeat.o(81352);
            return;
        }
        vcardContactLinkPreference = (VcardContactLinkPreference) this.ehK.aqO("v_contact_info_logo");
        vcardContactLinkPreference.setSummary((CharSequence) this.qgS.qao.qaH);
        vcardContactLinkPreference.yCj = false;
        vcardContactLinkPreference.qi(false);
        AppMethodBeat.o(81352);
    }

    private void chM() {
        AppMethodBeat.i(81353);
        List list = this.qgS.qax;
        if (list != null && list.size() > 0) {
            b(list, "WorkTel", this.mController.ylL.getString(R.string.f0e));
        }
        list = this.qgS.qaw;
        if (list != null && list.size() > 0) {
            b(list, "HomeTel", this.mController.ylL.getString(R.string.f03));
        }
        list = this.qgS.qay;
        if (list != null && list.size() > 0) {
            b(list, "VideoTEL", this.mController.ylL.getString(R.string.f0b));
        }
        list = this.qgS.qaz;
        if (list != null && list.size() > 0) {
            b(list, "NormalTel", this.mController.ylL.getString(R.string.f06));
        }
        list = this.qgS.qav;
        if (list != null && list.size() > 0) {
            b(list, "CellTel", this.mController.ylL.getString(R.string.ezz));
        }
        AppMethodBeat.o(81353);
    }

    private void chN() {
        AppMethodBeat.i(81354);
        a aVar = this.qgS.qat;
        if (aVar != null && aVar.aDu().length() > 0) {
            fS(aVar.aDu(), this.mController.ylL.getString(R.string.f01));
        }
        aVar = this.qgS.qau;
        if (aVar != null && aVar.aDu().length() > 0) {
            fS(aVar.aDu(), this.mController.ylL.getString(R.string.f0d));
        }
        aVar = this.qgS.qar;
        if (aVar != null && aVar.aDu().length() > 0) {
            fS(aVar.aDu(), this.mController.ylL.getString(R.string.ezw));
        }
        aVar = this.qgS.qas;
        if (aVar != null && aVar.aDu().length() > 0) {
            fS(aVar.aDu(), this.mController.ylL.getString(R.string.ezw));
        }
        AppMethodBeat.o(81354);
    }

    private void b(List<String> list, String str, String str2) {
        AppMethodBeat.i(81355);
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                VcardContactLinkPreference vcardContactLinkPreference = new VcardContactLinkPreference(this);
                vcardContactLinkPreference.setKey(str + String.valueOf(str3));
                if (!qgT.contains(str + String.valueOf(str3))) {
                    qgT.add(str + String.valueOf(str3));
                }
                vcardContactLinkPreference.setTitle((CharSequence) str2);
                vcardContactLinkPreference.setLayoutResource(R.layout.ae4);
                vcardContactLinkPreference.setSummary((CharSequence) str3);
                vcardContactLinkPreference.qi(false);
                vcardContactLinkPreference.yCj = true;
                vcardContactLinkPreference.dAD();
                this.ehK.a(vcardContactLinkPreference, qgV);
            }
        }
        AppMethodBeat.o(81355);
    }

    private void fS(String str, String str2) {
        AppMethodBeat.i(81356);
        KeyValuePreference keyValuePreference = new KeyValuePreference(this);
        keyValuePreference.setTitle((CharSequence) str2);
        keyValuePreference.setLayoutResource(R.layout.ae4);
        keyValuePreference.qi(false);
        keyValuePreference.setSummary((CharSequence) str);
        keyValuePreference.yCj = false;
        keyValuePreference.dAD();
        this.ehK.a(keyValuePreference, qgW);
        AppMethodBeat.o(81356);
    }

    private static void a(List<String> list, Intent intent, int i, int i2) {
        AppMethodBeat.i(81357);
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
        AppMethodBeat.o(81357);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(81350);
        if (preference.mKey.equals("add_vcard_contact")) {
            h.a((Context) this, "", new String[]{getString(R.string.ezv), getString(R.string.ezu)}, "", new c() {
                public final void iE(int i) {
                    AppMethodBeat.i(81348);
                    Intent intent;
                    switch (i) {
                        case 0:
                            bv.aaq().c(10238, Integer.valueOf(1));
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            AppMethodBeat.o(81348);
                            return;
                        case 1:
                            bv.aaq().c(10239, Integer.valueOf(1));
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            VcardContactUI.a(VcardContactUI.this, intent);
                            VcardContactUI.this.startActivity(intent);
                            break;
                    }
                    AppMethodBeat.o(81348);
                }
            });
            AppMethodBeat.o(81350);
            return true;
        }
        String str;
        if (preference.mKey.equals("v_contact_info_photo_uri") || preference.mKey.equals("v_contact_info_home_page") || preference.mKey.equals("v_contact_info_logo")) {
            String charSequence = preference.getSummary().toString();
            if (charSequence != null && charSequence.length() > 0) {
                com.tencent.mm.ai.f fVar2 = this.qgU;
                if (!fVar2.ppI.doT()) {
                    ab.e("MicroMsg.scanner.ViewMMURL", "already running, skipped");
                } else if (charSequence == null || charSequence.length() == 0) {
                    ab.e("MicroMsg.scanner.ViewMMURL", "go fail, qqNum is null");
                } else {
                    fVar2.url = charSequence;
                    str = (String) g.RP().Ry().get(46, null);
                    if (str == null || str.length() == 0) {
                        fVar2.c(charSequence, (int) System.currentTimeMillis(), new byte[0]);
                    } else {
                        g.Rg().a((int) d.MIC_PTU_MEISHI, fVar2);
                        fVar2.qhf = new com.tencent.mm.modelsimple.h(charSequence, null, 4, 0, (int) System.currentTimeMillis(), new byte[0]);
                        g.Rg().a(fVar2.qhf, 0);
                        fVar2.ppI.ae(3000, 3000);
                    }
                }
                AppMethodBeat.o(81350);
                return true;
            }
        } else if (qgT.contains(preference.mKey) && !preference.mKey.toLowerCase().contains("fax")) {
            str = preference.getSummary().toString().trim();
            if (str != null && str.length() > 0) {
                h.a((Context) this, "", new String[]{getString(R.string.avl)}, "", new c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(81345);
                        switch (i) {
                            case 0:
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setFlags(268435456);
                                intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                                VcardContactUI.this.startActivity(intent);
                                break;
                        }
                        AppMethodBeat.o(81345);
                    }
                });
                AppMethodBeat.o(81350);
                return true;
            }
        } else if (preference.mKey.equals("v_contact_info_email")) {
            str = preference.getSummary().toString();
            h.a((Context) this, "", new String[]{this.mController.ylL.getString(R.string.e37), this.mController.ylL.getString(R.string.e36)}, "", new c() {
                public final void iE(int i) {
                    AppMethodBeat.i(81346);
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent();
                            String[] strArr = new String[]{str + " " + str};
                            intent.putExtra("composeType", 4);
                            intent.putExtra("toList", strArr);
                            com.tencent.mm.bp.d.b(VcardContactUI.this, "qqmail", ".ui.ComposeUI", intent);
                            AppMethodBeat.o(81346);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.SEND");
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
                            VcardContactUI.this.startActivity(intent);
                            break;
                    }
                    AppMethodBeat.o(81346);
                }
            });
        }
        AppMethodBeat.o(81350);
        return false;
    }
}
