package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cfc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsPrivacyUI extends MMPreference {
    private String ecX = "";
    private f ehK;
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
    private int qox = h.yfZ;
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsPrivacyUI() {
        AppMethodBeat.i(127411);
        AppMethodBeat.o(127411);
    }

    static /* synthetic */ void i(SettingsPrivacyUI settingsPrivacyUI) {
        AppMethodBeat.i(127423);
        settingsPrivacyUI.cbv();
        AppMethodBeat.o(127423);
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(127412);
        a aVar = new a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(127412);
        return aVar;
    }

    public final int JC() {
        return R.xml.bm;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(127413);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.status = r.YD();
        this.ecX = r.Yz();
        this.qou = bo.a((Boolean) g.RP().Ry().get(68384, null), true);
        this.qow = ((e) g.M(e.class)).getStoryUserInfo();
        this.qov = this.qow.xeE == 0;
        this.qox = getIntent().getIntExtra("enter_scene", h.yfZ);
        ab.d("MicroMsg.SettingPrivacy", "sns Notify:%s, story Notify:%s", Boolean.valueOf(this.qou), Boolean.valueOf(this.qov));
        initView();
        com.tencent.mm.plugin.report.service.h.pYm.e(14098, Integer.valueOf(9));
        if (this.qox == h.yga || this.qox == h.ygb) {
            ccl ccl = new ccl();
            if (n.qFy != null) {
                ccl = n.qFy.WX(this.ecX);
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
        AppMethodBeat.o(127413);
    }

    public void onResume() {
        AppMethodBeat.i(127414);
        super.onResume();
        this.status = r.YD();
        cbv();
        if (!this.eio) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bo.isNullOrNil(stringExtra)) {
                final int aqQ = this.ehK.aqQ(stringExtra);
                setSelection(aqQ - 3);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127407);
                        View a = ((a) SettingsPrivacyUI.this.ehK).a(aqQ, SettingsPrivacyUI.this.nDp);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.a(SettingsPrivacyUI.this.mController.ylL, a);
                        }
                        AppMethodBeat.o(127407);
                    }
                }, 10);
            }
            this.eio = true;
        }
        AppMethodBeat.o(127414);
    }

    public void onPause() {
        AppMethodBeat.i(127415);
        super.onPause();
        g.RP().Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            ab.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.o(127415);
    }

    public void onDestroy() {
        AppMethodBeat.i(127416);
        super.onDestroy();
        AppMethodBeat.o(127416);
    }

    private void cja() {
        AppMethodBeat.i(127418);
        ccl ccl = new ccl();
        if (n.qFy != null) {
            ccl = n.qFy.WX(this.ecX);
        }
        if (ccl == null) {
            ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.o(127418);
            return;
        }
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
        if (intValue > ((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
            g.RP().Ry().set(ac.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            cbv();
        }
        c.a aVar = new c.a(this.mController.ylL);
        aVar.Qd(R.string.or);
        aVar.PV(R.string.aw_);
        View inflate = View.inflate(this.mController.ylL, R.layout.ad9, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.d93);
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127409);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    TextView textView = (TextView) linearLayout.getChildAt(i);
                    if (R.id.bn0 != textView.getId()) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                    }
                }
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                ccl ccl = new ccl();
                if (n.qFy != null) {
                    ccl = n.qFy.WX(SettingsPrivacyUI.this.ecX);
                }
                if (ccl == null) {
                    ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
                    AppMethodBeat.o(127409);
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                ab.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue));
                if (intValue == 0) {
                    if (SettingsPrivacyUI.this.qox == h.yga) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14090, Integer.valueOf(4));
                    }
                    SettingsPrivacyUI.this.qoq = false;
                    SettingsPrivacyUI.this.qor = true;
                    SettingsPrivacyUI.this.qot = false;
                    SettingsPrivacyUI.this.qos = true;
                } else if (intValue == 1) {
                    if (SettingsPrivacyUI.this.qox == h.yga) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14090, Integer.valueOf(5));
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
                    if (SettingsPrivacyUI.this.qox == h.yga) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(14090, Integer.valueOf(6));
                    }
                    SettingsPrivacyUI.this.qoq = false;
                    SettingsPrivacyUI.this.qor = false;
                    SettingsPrivacyUI.this.qot = false;
                    SettingsPrivacyUI.this.qos = true;
                }
                if (n.qFy != null) {
                    n.qFy.a(SettingsPrivacyUI.this.ecX, SettingsPrivacyUI.this.qoq, SettingsPrivacyUI.this.qor, SettingsPrivacyUI.this.qos, SettingsPrivacyUI.this.qot);
                }
                if (n.qFy != null) {
                    ccl b = n.qFy.b(SettingsPrivacyUI.this.ecX, SettingsPrivacyUI.this.qoq, SettingsPrivacyUI.this.qor, SettingsPrivacyUI.this.qos, SettingsPrivacyUI.this.qot);
                    if (b == null) {
                        ab.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        AppMethodBeat.o(127409);
                        return;
                    }
                    ab.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                    ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(51, b));
                }
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127408);
                        ((Dialog) linearLayout.getTag()).dismiss();
                        SettingsPrivacyUI.i(SettingsPrivacyUI.this);
                        AppMethodBeat.o(127408);
                    }
                });
                AppMethodBeat.o(127409);
            }
        };
        a(linearLayout, R.string.awb, 1, this.qoq, anonymousClass2);
        a(linearLayout, R.string.g6k, 3, this.qot, anonymousClass2);
        a(linearLayout, R.string.awc, 0, this.qor, anonymousClass2);
        boolean z = (this.qoq || this.qor || this.qot) ? false : true;
        a(linearLayout, R.string.awa, 2, z, anonymousClass2);
        aVar.fn(inflate);
        c aMb = aVar.aMb();
        linearLayout.setTag(aMb);
        aMb.show();
        addDialog(aMb);
        AppMethodBeat.o(127418);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.i(127420);
        setMMTitle((int) R.string.e5_);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127410);
                SettingsPrivacyUI.this.aqX();
                SettingsPrivacyUI.this.finish();
                AppMethodBeat.o(127410);
                return true;
            }
        });
        ab.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_need_verify");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = Be(32);
        String str = (String) g.RP().Ry().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.yDf = false;
        if (str == null || str.length() <= 0) {
            this.ehK.d(checkBoxPreference2);
        } else {
            boolean z2;
            if (Be(256)) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference2.uOT = z2;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_google_contact");
        checkBoxPreference.yDf = false;
        if (!Be(1048576)) {
            z = true;
        }
        checkBoxPreference.uOT = z;
        String str2 = (String) g.RP().Ry().get(208903, null);
        if (!bo.gT(this) || TextUtils.isEmpty(str2)) {
            this.ehK.d(checkBoxPreference);
        }
        if (!(((Boolean) g.RP().Ry().get(335873, Boolean.TRUE)).booleanValue() && n.qFA.cmo())) {
            this.ehK.ce("edit_timeline_group", true);
        }
        this.ehK.ce("settings_unfamiliar_contact", true);
        Preference aqO = this.ehK.aqO("settings_privacy_agreements");
        str2 = getString(R.string.dei);
        CharSequence newSpannable = Factory.getInstance().newSpannable(getString(R.string.dej) + str2);
        newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.t7)), newSpannable.length() - str2.length(), newSpannable.length(), 33);
        aqO.setTitle(newSpannable);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127420);
    }

    private boolean Be(int i) {
        return (this.status & i) != 0;
    }

    private boolean g(boolean z, int i, int i2) {
        AppMethodBeat.i(127421);
        ab.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(127421);
        return true;
    }

    private void cbv() {
        ccl WX;
        AppMethodBeat.i(127422);
        ccl ccl = new ccl();
        cfc storyUserInfo = ((e) g.M(e.class)).getStoryUserInfo();
        if (n.qFy != null) {
            WX = n.qFy.WX(this.ecX);
        } else {
            WX = ccl;
        }
        if (WX == null) {
            ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
            AppMethodBeat.o(127422);
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
                iconPreference.setSummary((int) R.string.awb);
            } else if (this.qor) {
                iconPreference.setSummary((int) R.string.awc);
            } else if (this.qot) {
                iconPreference.setSummary((int) R.string.g6k);
            } else {
                iconPreference.setSummary((int) R.string.awa);
            }
            ab.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue()), Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()));
            if (((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue() > ((Integer) g.RP().Ry().get(ac.a.USERINFO_RECENT_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                iconPreference.NN(0);
            } else {
                iconPreference.NN(8);
            }
        }
        if (d.afj("sns") && (r.YK() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.qop = z;
        String str = "MicroMsg.SettingPrivacy";
        StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.qop).append(", install ").append(d.afj("sns")).append(", flag ");
        if ((r.YK() & 32768) == 0) {
            z = true;
        } else {
            z = false;
        }
        ab.i(str, append.append(z).toString());
        if (this.qop) {
            this.ehK.ce("settings_sns_notify", false);
            this.ehK.ce("settings_story_notify", false);
        } else {
            this.ehK.ce("settings_sns_notify", true);
            this.ehK.ce("settings_story_notify", true);
        }
        if (this.qop) {
            checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_sns_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.yDf = false;
                this.qou = bo.a((Boolean) g.RP().Ry().get(68384, null), true);
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
        AppMethodBeat.o(127422);
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(127417);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        if (str.equals("settings_need_verify")) {
            z = g(((CheckBoxPreference) fVar.aqO("settings_need_verify")).isChecked(), 32, 4);
            AppMethodBeat.o(127417);
            return z;
        } else if (str.equals("settings_recommend_mobilefriends_to_me")) {
            boolean z3;
            if (((CheckBoxPreference) fVar.aqO("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            z = g(z3, 256, 7);
            AppMethodBeat.o(127417);
            return z;
        } else if (str.equals("settings_about_blacklist")) {
            y nY = z.nY(getString(R.string.c_1));
            Intent intent = new Intent();
            intent.putExtra("filter_type", nY.getType());
            intent.putExtra("titile", getString(R.string.e_n));
            intent.putExtra("list_attr", 32768);
            b.gkE.h((Context) this, intent);
            AppMethodBeat.o(127417);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                d.b((Context) this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                d.H(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                d.b((Context) this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.qmw) {
                    z = false;
                }
                this.qmw = z;
                if (n.qFy != null) {
                    n.qFy.bh(this.ecX, this.qmw);
                }
                if (n.qFy != null) {
                    ccl bi = n.qFy.bi(this.ecX, this.qmw);
                    n.qFy.a(this.ecX, bi);
                    if (bi == null) {
                        ab.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        AppMethodBeat.o(127417);
                        return false;
                    }
                    ab.d("MicroMsg.SettingPrivacy", "dancy userinfo " + bi.toString());
                    ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(51, bi));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) fVar.aqO("settings_find_google_contact")).isChecked()) {
                    z2 = true;
                }
                g(z2, 1048576, 29);
                AppMethodBeat.o(127417);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                AppMethodBeat.o(127417);
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                cja();
            } else if (str.equals("settings_sns_notify")) {
                this.qou = !this.qou;
                if (this.qou) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14098, Integer.valueOf(3));
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(14098, Integer.valueOf(4));
                }
                g.RP().Ry().set(68384, Boolean.valueOf(this.qou));
                cbv();
                AppMethodBeat.o(127417);
                return true;
            } else if (str.equals("settings_unfamiliar_contact")) {
                startActivity(new Intent(this, UnfamiliarContactUI.class));
            } else if (str.equals("settings_privacy_agreements")) {
                str = g.RP().Ry().get(274436, (Object) "").toString();
                if (bo.isNullOrNil(str)) {
                    str = aa.doq();
                }
                com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.g7o, new Object[]{aa.dor(), str, "setting", Integer.valueOf(0), Integer.valueOf(0)}), 0, false);
            } else if (str.equals("settings_auth_manage")) {
                startActivity(new Intent(this, SettingsManageAuthUI.class));
            } else if (str.equals("settings_story_notify")) {
                this.qov = !this.qov;
                if (this.qov) {
                    this.qow.xeE = 0;
                } else {
                    this.qow.xeE = 1;
                }
                ((e) g.M(e.class)).updateStoryUserInfo(this.ecX, this.qow);
                ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(71, this.qow));
                cbv();
                AppMethodBeat.o(127417);
                return true;
            }
            AppMethodBeat.o(127417);
            return false;
        }
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        AppMethodBeat.i(127419);
        TextView textView = (TextView) View.inflate(this.mController.ylL, R.layout.aml, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
        }
        AppMethodBeat.o(127419);
    }
}
