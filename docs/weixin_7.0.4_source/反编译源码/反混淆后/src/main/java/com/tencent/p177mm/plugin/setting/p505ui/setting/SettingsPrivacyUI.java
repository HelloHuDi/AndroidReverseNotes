package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18643z;
import com.tencent.p177mm.model.C26432y;
import com.tencent.p177mm.p612ui.C5510e.C5501h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.p1347g.C40871a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.protocal.protobuf.ccl;
import com.tencent.p177mm.protocal.protobuf.cfc;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI */
public class SettingsPrivacyUI extends MMPreference {
    private String ecX = "";
    private C15541f ehK;
    boolean eio = false;
    private HashMap<Integer, Integer> gsc = new HashMap();
    private boolean qmw = false;
    private boolean qop = true;
    private boolean qoq = false;
    private boolean qor = false;
    private boolean qos = false;
    private boolean qot = false;
    private boolean qou = true;
    private boolean qov = true;
    private cfc qow = null;
    private int qox = C5501h.yfZ;
    private int status;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI$3 */
    class C348833 implements OnMenuItemClickListener {
        C348833() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127410);
            SettingsPrivacyUI.this.aqX();
            SettingsPrivacyUI.this.finish();
            AppMethodBeat.m2505o(127410);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsPrivacyUI() {
        AppMethodBeat.m2504i(127411);
        AppMethodBeat.m2505o(127411);
    }

    /* renamed from: i */
    static /* synthetic */ void m57293i(SettingsPrivacyUI settingsPrivacyUI) {
        AppMethodBeat.m2504i(127423);
        settingsPrivacyUI.cbv();
        AppMethodBeat.m2505o(127423);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(127412);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(127412);
        return c41341a;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8538bm;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(127413);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.status = C1853r.m3822YD();
        this.ecX = C1853r.m3846Yz();
        this.qou = C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(68384, null), true);
        this.qow = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUserInfo();
        this.qov = this.qow.xeE == 0;
        this.qox = getIntent().getIntExtra("enter_scene", C5501h.yfZ);
        C4990ab.m7411d("MicroMsg.SettingPrivacy", "sns Notify:%s, story Notify:%s", Boolean.valueOf(this.qou), Boolean.valueOf(this.qov));
        initView();
        C7060h.pYm.mo8381e(14098, Integer.valueOf(9));
        if (this.qox == C5501h.yga || this.qox == C5501h.ygb) {
            ccl ccl = new ccl();
            if (C21877n.qFy != null) {
                ccl = C21877n.qFy.mo47111WX(this.ecX);
            }
            if (ccl != null) {
                int i = ccl.xbQ;
                int i2 = ccl.xbR;
                boolean z2 = i2 == 4320 && (i & 4096) > 0;
                this.qoq = z2;
                if (i2 != 72 || (i & 4096) <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.qor = z2;
                if (i2 != 720 || (i & 4096) <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.qot = z2;
                if ((i & 2048) <= 0) {
                    z = false;
                }
                this.qos = z;
            }
            cja();
        }
        AppMethodBeat.m2505o(127413);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127414);
        super.onResume();
        this.status = C1853r.m3822YD();
        cbv();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!C5046bo.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(127407);
                        View a = ((C41341a) SettingsPrivacyUI.this.ehK).mo65995a(aqQ, SettingsPrivacyUI.this.nDp);
                        if (a != null) {
                            C40871a.m70821a(SettingsPrivacyUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.m2505o(127407);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.m2505o(127414);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127415);
        super.onPause();
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.m2505o(127415);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127416);
        super.onDestroy();
        AppMethodBeat.m2505o(127416);
    }

    private void cja() {
        AppMethodBeat.m2504i(127418);
        ccl ccl = new ccl();
        if (C21877n.qFy != null) {
            ccl = C21877n.qFy.mo47111WX(this.ecX);
        }
        if (ccl == null) {
            C4990ab.m7412e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.m2505o(127418);
            return;
        }
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
        if (intValue > ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            cbv();
        }
        C5652a c5652a = new C5652a(this.mController.ylL);
        c5652a.mo11454Qd(C25738R.string.f9076or);
        c5652a.mo11446PV(C25738R.string.aw_);
        View inflate = View.inflate(this.mController.ylL, 2130970095, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131825985);
        C348812 c348812 = new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI$2$1 */
            class C348821 implements Runnable {
                C348821() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(127408);
                    ((Dialog) linearLayout.getTag()).dismiss();
                    SettingsPrivacyUI.m57293i(SettingsPrivacyUI.this);
                    AppMethodBeat.m2505o(127408);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(127409);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    TextView textView = (TextView) linearLayout.getChildAt(i);
                    if (2131823800 != textView.getId()) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_off, 0, 0, 0);
                    }
                }
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
                ccl ccl = new ccl();
                if (C21877n.qFy != null) {
                    ccl = C21877n.qFy.mo47111WX(SettingsPrivacyUI.this.ecX);
                }
                if (ccl == null) {
                    C4990ab.m7412e("MicroMsg.SettingPrivacy", "userinfo is null");
                    AppMethodBeat.m2505o(127409);
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                C4990ab.m7417i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue));
                if (intValue == 0) {
                    if (SettingsPrivacyUI.this.qox == C5501h.yga) {
                        C7060h.pYm.mo8381e(14090, Integer.valueOf(4));
                    }
                    SettingsPrivacyUI.this.qoq = false;
                    SettingsPrivacyUI.this.qor = true;
                    SettingsPrivacyUI.this.qot = false;
                    SettingsPrivacyUI.this.qos = true;
                } else if (intValue == 1) {
                    if (SettingsPrivacyUI.this.qox == C5501h.yga) {
                        C7060h.pYm.mo8381e(14090, Integer.valueOf(5));
                    }
                    SettingsPrivacyUI.this.qoq = true;
                    SettingsPrivacyUI.this.qor = false;
                    SettingsPrivacyUI.this.qot = false;
                    SettingsPrivacyUI.this.qos = true;
                } else if (intValue == 3) {
                    SettingsPrivacyUI.this.qoq = false;
                    SettingsPrivacyUI.this.qor = false;
                    SettingsPrivacyUI.this.qot = true;
                    SettingsPrivacyUI.this.qos = true;
                } else {
                    if (SettingsPrivacyUI.this.qox == C5501h.yga) {
                        C7060h.pYm.mo8381e(14090, Integer.valueOf(6));
                    }
                    SettingsPrivacyUI.this.qoq = false;
                    SettingsPrivacyUI.this.qor = false;
                    SettingsPrivacyUI.this.qot = false;
                    SettingsPrivacyUI.this.qos = true;
                }
                if (C21877n.qFy != null) {
                    C21877n.qFy.mo47113a(SettingsPrivacyUI.this.ecX, SettingsPrivacyUI.this.qoq, SettingsPrivacyUI.this.qor, SettingsPrivacyUI.this.qos, SettingsPrivacyUI.this.qot);
                }
                if (C21877n.qFy != null) {
                    ccl b = C21877n.qFy.mo47115b(SettingsPrivacyUI.this.ecX, SettingsPrivacyUI.this.qoq, SettingsPrivacyUI.this.qor, SettingsPrivacyUI.this.qos, SettingsPrivacyUI.this.qot);
                    if (b == null) {
                        C4990ab.m7412e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        AppMethodBeat.m2505o(127409);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(51, b));
                }
                view.post(new C348821());
                AppMethodBeat.m2505o(127409);
            }
        };
        m57281a(linearLayout, C25738R.string.awb, 1, this.qoq, c348812);
        m57281a(linearLayout, C25738R.string.g6k, 3, this.qot, c348812);
        m57281a(linearLayout, C25738R.string.awc, 0, this.qor, c348812);
        boolean z = (this.qoq || this.qor || this.qot) ? false : true;
        m57281a(linearLayout, C25738R.string.awa, 2, z, c348812);
        c5652a.mo11479fn(inflate);
        C5653c aMb = c5652a.aMb();
        linearLayout.setTag(aMb);
        aMb.show();
        addDialog(aMb);
        AppMethodBeat.m2505o(127418);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.m2504i(127420);
        setMMTitle((int) C25738R.string.e5_);
        setBackBtn(new C348833());
        C4990ab.m7418v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_need_verify");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = m57279Be(32);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.yDf = false;
        if (str == null || str.length() <= 0) {
            this.ehK.mo27716d(checkBoxPreference2);
        } else {
            boolean z2;
            if (m57279Be(256)) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference2.uOT = z2;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_google_contact");
        checkBoxPreference.yDf = false;
        if (!m57279Be(1048576)) {
            z = true;
        }
        checkBoxPreference.uOT = z;
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(208903, null);
        if (!C5046bo.m7558gT(this) || TextUtils.isEmpty(str2)) {
            this.ehK.mo27716d(checkBoxPreference);
        }
        if (!(((Boolean) C1720g.m3536RP().mo5239Ry().get(335873, Boolean.TRUE)).booleanValue() && C21877n.qFA.cmo())) {
            this.ehK.mo27715ce("edit_timeline_group", true);
        }
        this.ehK.mo27715ce("settings_unfamiliar_contact", true);
        Preference aqO = this.ehK.aqO("settings_privacy_agreements");
        str2 = getString(C25738R.string.dei);
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(C25738R.string.dej) + str2);
        newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(C25738R.color.f12123t7)), newSpannable.length() - str2.length(), newSpannable.length(), 33);
        aqO.setTitle(newSpannable);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127420);
    }

    /* renamed from: Be */
    private boolean m57279Be(int i) {
        return (this.status & i) != 0;
    }

    /* renamed from: g */
    private boolean m57291g(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(127421);
        C4990ab.m7410d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.m2505o(127421);
        return true;
    }

    private void cbv() {
        ccl WX;
        AppMethodBeat.m2504i(127422);
        ccl ccl = new ccl();
        cfc storyUserInfo = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUserInfo();
        if (C21877n.qFy != null) {
            WX = C21877n.qFy.mo47111WX(this.ecX);
        } else {
            WX = ccl;
        }
        if (WX == null) {
            C4990ab.m7412e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.m2505o(127422);
            return;
        }
        boolean z;
        int i = WX.xbQ;
        int i2 = WX.xbR;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("timeline_stranger_show");
        if (checkBoxPreference != null) {
            checkBoxPreference.yDf = false;
            this.qmw = (i & 1) > 0;
            if (this.qmw) {
                checkBoxPreference.uOT = false;
            } else {
                checkBoxPreference.uOT = true;
            }
        }
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("timeline_recent_show_select");
        if (iconPreference != null) {
            iconPreference.yDf = false;
            boolean z2 = i2 == 4320 && (i & 4096) > 0;
            this.qoq = z2;
            if (i2 != 72 || (i & 4096) <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.qor = z2;
            if (i2 != 720 || (i & 4096) <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.qot = z2;
            if ((i & 2048) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.qos = z2;
            if (this.qoq) {
                iconPreference.setSummary((int) C25738R.string.awb);
            } else if (this.qor) {
                iconPreference.setSummary((int) C25738R.string.awc);
            } else if (this.qot) {
                iconPreference.setSummary((int) C25738R.string.g6k);
            } else {
                iconPreference.setSummary((int) C25738R.string.awa);
            }
            C4990ab.m7417i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue()), Integer.valueOf(((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()));
            if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue() > ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                iconPreference.mo48765NN(0);
            } else {
                iconPreference.mo48765NN(8);
            }
        }
        if (C25985d.afj("sns") && (C1853r.m3829YK() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.qop = z;
        String str = "MicroMsg.SettingPrivacy";
        StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.qop).append(", install ").append(C25985d.afj("sns")).append(", flag ");
        if ((C1853r.m3829YK() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7416i(str, append.append(z).toString());
        if (this.qop) {
            this.ehK.mo27715ce("settings_sns_notify", false);
            this.ehK.mo27715ce("settings_story_notify", false);
        } else {
            this.ehK.mo27715ce("settings_sns_notify", true);
            this.ehK.mo27715ce("settings_story_notify", true);
        }
        if (this.qop) {
            checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_sns_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.yDf = false;
                this.qou = C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(68384, null), true);
                if (this.qou) {
                    checkBoxPreference.uOT = true;
                } else {
                    checkBoxPreference.uOT = false;
                }
            }
            checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_story_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.yDf = false;
                this.qov = storyUserInfo.xeE == 0;
                if (this.qov) {
                    checkBoxPreference.uOT = true;
                } else {
                    checkBoxPreference.uOT = false;
                }
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127422);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(127417);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        if (str.equals("settings_need_verify")) {
            z = m57291g(((CheckBoxPreference) c15541f.aqO("settings_need_verify")).isChecked(), 32, 4);
            AppMethodBeat.m2505o(127417);
            return z;
        } else if (str.equals("settings_recommend_mobilefriends_to_me")) {
            boolean z3;
            if (((CheckBoxPreference) c15541f.aqO("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            z = m57291g(z3, 256, 7);
            AppMethodBeat.m2505o(127417);
            return z;
        } else if (str.equals("settings_about_blacklist")) {
            C26432y nY = C18643z.m29128nY(getString(C25738R.string.c_1));
            Intent intent = new Intent();
            intent.putExtra("filter_type", nY.getType());
            intent.putExtra("titile", getString(C25738R.string.e_n));
            intent.putExtra("list_attr", 32768);
            C24824b.gkE.mo38922h((Context) this, intent);
            AppMethodBeat.m2505o(127417);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                C25985d.m41467b((Context) this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                C25985d.m41448H(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                C25985d.m41467b((Context) this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.qmw) {
                    z = false;
                }
                this.qmw = z;
                if (C21877n.qFy != null) {
                    C21877n.qFy.mo47116bh(this.ecX, this.qmw);
                }
                if (C21877n.qFy != null) {
                    ccl bi = C21877n.qFy.mo47117bi(this.ecX, this.qmw);
                    C21877n.qFy.mo47112a(this.ecX, bi);
                    if (bi == null) {
                        C4990ab.m7412e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        AppMethodBeat.m2505o(127417);
                        return false;
                    }
                    C4990ab.m7410d("MicroMsg.SettingPrivacy", "dancy userinfo " + bi.toString());
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(51, bi));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) c15541f.aqO("settings_find_google_contact")).isChecked()) {
                    z2 = true;
                }
                m57291g(z2, 1048576, 29);
                AppMethodBeat.m2505o(127417);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                AppMethodBeat.m2505o(127417);
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                cja();
            } else if (str.equals("settings_sns_notify")) {
                this.qou = !this.qou;
                if (this.qou) {
                    C7060h.pYm.mo8381e(14098, Integer.valueOf(3));
                } else {
                    C7060h.pYm.mo8381e(14098, Integer.valueOf(4));
                }
                C1720g.m3536RP().mo5239Ry().set(68384, Boolean.valueOf(this.qou));
                cbv();
                AppMethodBeat.m2505o(127417);
                return true;
            } else if (str.equals("settings_unfamiliar_contact")) {
                startActivity(new Intent(this, UnfamiliarContactUI.class));
            } else if (str.equals("settings_privacy_agreements")) {
                str = C1720g.m3536RP().mo5239Ry().get(274436, (Object) "").toString();
                if (C5046bo.isNullOrNil(str)) {
                    str = C4988aa.doq();
                }
                C32921a.m53856b(this, getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), str, "setting", Integer.valueOf(0), Integer.valueOf(0)}), 0, false);
            } else if (str.equals("settings_auth_manage")) {
                startActivity(new Intent(this, SettingsManageAuthUI.class));
            } else if (str.equals("settings_story_notify")) {
                this.qov = !this.qov;
                if (this.qov) {
                    this.qow.xeE = 0;
                } else {
                    this.qow.xeE = 1;
                }
                ((C35168e) C1720g.m3530M(C35168e.class)).updateStoryUserInfo(this.ecX, this.qow);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(71, this.qow));
                cbv();
                AppMethodBeat.m2505o(127417);
                return true;
            }
            AppMethodBeat.m2505o(127417);
            return false;
        }
    }

    /* renamed from: a */
    private void m57281a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(127419);
        TextView textView = (TextView) View.inflate(this.mController.ylL, 2130970442, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
        }
        AppMethodBeat.m2505o(127419);
    }
}
