package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.p057v4.app.C17432y;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18611au;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.permission.C35808d;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI */
public class SettingsNotificationUI extends MMPreference {
    private C15541f ehK;
    private HashMap<Integer, Integer> gsc = new HashMap();
    private int status;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$5 */
    class C38045 implements C35808d {
        C38045() {
        }

        /* renamed from: Cp */
        public final void mo8477Cp(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$1 */
    class C38051 implements OnMenuItemClickListener {
        C38051() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127351);
            SettingsNotificationUI.this.aqX();
            SettingsNotificationUI.this.finish();
            AppMethodBeat.m2505o(127351);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$3 */
    class C38063 implements OnClickListener {
        C38063() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127354);
            C18559f.m28889bM(false);
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14781hO(2);
            c7620bi.mo14775eJ(System.currentTimeMillis());
            c7620bi.setType(1);
            c7620bi.mo14794ju("weixin");
            c7620bi.setContent(SettingsNotificationUI.this.mController.ylL.getString(C25738R.string.e9h, new Object[]{Build.MODEL}));
            C1829bf.m3752l(c7620bi);
            C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ("weixin");
            if (aoZ != null) {
                aoZ.setContent(SettingsNotificationUI.this.mController.ylL.getString(C25738R.string.e9h, new Object[]{Build.MODEL}));
                aoZ.mo14748hM(aoZ.field_unReadCount + 1);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, "weixin");
            } else {
                aoZ = new C7617ak();
                aoZ.setContent(SettingsNotificationUI.this.mController.ylL.getString(C25738R.string.e9h, new Object[]{Build.MODEL}));
                aoZ.setUsername("weixin");
                aoZ.mo14748hM(1);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(aoZ);
            }
            SettingsNotificationUI.this.initView();
            C7060h.pYm.mo8378a(500, 3, 1, false);
            C18611au.m29047k(false, true);
            AppMethodBeat.m2505o(127354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$2 */
    class C38072 implements C5662c {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$2$1 */
        class C38081 implements C35808d {
            C38081() {
            }

            /* renamed from: Cp */
            public final void mo8477Cp(int i) {
                AppMethodBeat.m2504i(127352);
                if (C37885a.m63951MD()) {
                    C18559f.m28888bL(true);
                    SettingsNotificationUI.this.initView();
                    C7060h.pYm.mo8378a(500, 0, 1, false);
                    C18611au.m29047k(true, false);
                    AppMethodBeat.m2505o(127352);
                    return;
                }
                SettingsNotificationUI.this.initView();
                AppMethodBeat.m2505o(127352);
            }
        }

        C38072() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(127353);
            if (z) {
                SettingsNotificationUI.m6111a(SettingsNotificationUI.this, new C38081());
                AppMethodBeat.m2505o(127353);
                return;
            }
            SettingsNotificationUI.this.initView();
            AppMethodBeat.m2505o(127353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI$4 */
    class C38094 implements OnClickListener {
        C38094() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127355);
            C18559f.m28889bM(true);
            ((CheckBoxPreference) SettingsNotificationUI.this.ehK.aqO("settings_new_voip_msg_notification")).uOT = true;
            SettingsNotificationUI.this.initView();
            C18611au.m29047k(false, true);
            AppMethodBeat.m2505o(127355);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsNotificationUI() {
        AppMethodBeat.m2504i(127356);
        AppMethodBeat.m2505o(127356);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8553c1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127357);
        super.onCreate(bundle);
        this.status = C1853r.m3822YD();
        setMMTitle((int) C25738R.string.e9j);
        AppMethodBeat.m2505o(127357);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127359);
        super.onPause();
        C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.m2505o(127359);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127360);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(127360);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127362);
        super.onDestroy();
        C18611au.m29048kB(3);
        AppMethodBeat.m2505o(127362);
    }

    /* renamed from: a */
    private void m6112a(C35808d c35808d) {
        AppMethodBeat.m2504i(127363);
        Intent intent = new Intent();
        if (!C1443d.m3068iW(26)) {
            if (C1443d.m3068iW(21)) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", getPackageName());
                intent.putExtra("app_uid", getApplicationInfo().uid);
                intent.addFlags(268435456);
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                intent.addFlags(268435456);
            }
            startActivity(intent);
            AppMethodBeat.m2505o(127363);
        } else if (!C4971b.dqw() || (C4971b.dqv() && (!C4971b.dqv() || C4971b.dqx()))) {
            C4990ab.m7416i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
            if (C17432y.m27074L(this.mController.ylL).areNotificationsEnabled()) {
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.CHANNEL_ID", C45186a.m83261My());
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
            C35805b.m58704a(intent, c35808d);
            AppMethodBeat.m2505o(127363);
        } else {
            C4990ab.m7416i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
            intent = new Intent("android.intent.action.MAIN");
            intent.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
            intent.putExtra("appName", C4996ah.getContext().getResources().getString(C25738R.string.f9176ru));
            intent.putExtra(DownloadInfoColumns.PACKAGENAME, getPackageName());
            C35805b.m58704a(intent, c35808d);
            AppMethodBeat.m2505o(127363);
        }
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.m2504i(127358);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8553c1);
        if (C1443d.m3068iW(26)) {
            this.ehK.mo27715ce("settings_notification_top", true);
            this.ehK.mo27715ce("settings_notification_title", false);
            this.ehK.mo27715ce("settings_notification_sound_shake", false);
            this.ehK.mo27715ce("settings_voip_sound_and_shake", false);
        } else {
            this.ehK.mo27715ce("settings_notification_top", false);
            this.ehK.mo27715ce("settings_notification_title", true);
            this.ehK.mo27715ce("settings_notification_sound_shake", true);
            this.ehK.mo27715ce("settings_voip_sound_and_shake", true);
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_new_msg_notification");
        if (C1443d.m3068iW(26)) {
            boolean z2;
            if (C37885a.m63950MC() && C37885a.m63951MD()) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBoxPreference.uOT = z2;
        } else {
            checkBoxPreference.uOT = C37885a.m63950MC();
        }
        ((CheckBoxPreference) this.ehK.aqO("settings_new_voip_msg_notification")).uOT = C37885a.m63952ME();
        if (checkBoxPreference.isChecked()) {
            String str;
            if (C1443d.m3068iW(26)) {
                this.ehK.mo27715ce("settings_notification_sound_and_shake", false);
                this.ehK.mo27715ce("settings_sound", true);
                this.ehK.mo27715ce("settings_shake", true);
                this.ehK.mo27715ce("settings_notification_ringtone", true);
                C37885a.m63964MQ();
                C4990ab.m7417i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", Integer.valueOf(C37885a.m63963MP()));
                C15541f c15541f = this.ehK;
                str = "settings_special_scene_notification_sound_and_shake";
                if (C37885a.m63963MP() != 1) {
                    z = true;
                }
                c15541f.mo27715ce(str, z);
            } else {
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_sound");
                checkBoxPreference.uOT = C37885a.m63954MG();
                if (checkBoxPreference.isChecked()) {
                    Preference aqO = this.ehK.aqO("settings_notification_ringtone");
                    if (C1443d.m3068iW(26)) {
                        str = C37885a.m63958MK();
                        if (str != C18559f.evO) {
                            aqO.setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
                        } else {
                            aqO.setSummary(getString(C25738R.string.e9l));
                        }
                    } else if (aqO != null) {
                        aqO.setSummary(this.ehZ.getString("settings.ringtone.name", getString(C25738R.string.e9l)));
                    }
                } else {
                    this.ehK.aqP("settings_notification_ringtone");
                }
                ((CheckBoxPreference) this.ehK.aqO("settings_shake")).uOT = C37885a.m63956MI();
                this.ehK.mo27715ce("settings_notification_sound_and_shake", true);
                this.ehK.mo27715ce("settings_special_scene_notification_title", true);
                this.ehK.mo27715ce("settings_specail_scene_sound", true);
                this.ehK.mo27715ce("settings_specail_scene_shake", true);
                this.ehK.mo27715ce("settings_special_scene_notification_sound_and_shake", true);
            }
            ((CheckBoxPreference) this.ehK.aqO("settings_show_detail")).uOT = C37885a.m63953MF();
        } else {
            this.ehK.aqP("settings_show_detail");
            this.ehK.aqP("settings_sound");
            this.ehK.aqP("settings_notification_ringtone");
            this.ehK.aqP("settings_shake");
            this.ehK.aqP("settings_active_time");
            this.ehK.aqP("settings_notification_sound_and_shake");
            this.ehK.aqP("settings_special_scene_notification_sound_and_shake");
        }
        setBackBtn(new C38051());
        AppMethodBeat.m2505o(127358);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127361);
        String str = preference.mKey;
        if (str.equals("settings_new_msg_notification")) {
            if (!C1443d.m3068iW(26) || C37885a.m63951MD()) {
                C18559f.m28888bL(((CheckBoxPreference) preference).isChecked());
                initView();
                if (((CheckBoxPreference) preference).isChecked()) {
                    C7060h.pYm.mo8378a(500, 0, 1, false);
                } else {
                    C7060h.pYm.mo8378a(500, 1, 1, false);
                }
                C18611au.m29047k(true, false);
                AppMethodBeat.m2505o(127361);
                return true;
            }
            C5659a c5659a = new C5659a(this.mController.ylL);
            c5659a.asL(getString(C25738R.string.e47)).mo11526re(false);
            c5659a.mo11523c(new C38072()).show();
        }
        boolean isChecked;
        Intent intent;
        if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                C18559f.m28889bM(true);
                C7060h.pYm.mo8378a(500, 2, 1, false);
                C18611au.m29047k(false, true);
                initView();
            } else {
                C30379h.m48454a(this.mController.ylL, false, this.mController.ylL.getString(C25738R.string.e9f), "", this.mController.ylL.getString(C25738R.string.e9e), this.mController.ylL.getString(C25738R.string.e83), new C38063(), new C38094(), C25738R.color.f11717ei, 0);
            }
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            C1720g.m3536RP().mo5239Ry().set(73217, Boolean.valueOf(isChecked));
            C1720g.m3536RP().mo5239Ry().set(73218, Boolean.valueOf(isChecked));
            C7060h.pYm.mo8378a(500, isChecked ? 8 : 9, 1, false);
            C4990ab.m7417i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(isChecked));
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_sound")) {
            C18559f.m28891bO(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                C7060h.pYm.mo8378a(500, 10, 1, false);
            } else {
                C7060h.pYm.mo8378a(500, 11, 1, false);
            }
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_shake")) {
            C18559f.m28892bP(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                C7060h.pYm.mo8378a(500, 16, 1, false);
            } else {
                C7060h.pYm.mo8378a(500, 17, 1, false);
            }
            C5046bo.m7589z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_show_detail")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            C18559f.m28890bN(isChecked);
            if (isChecked) {
                isChecked = false;
            } else {
                isChecked = true;
            }
            C4990ab.m7410d("MicroMsg.SettingsNotificationUI", "switch change : open = " + isChecked + " item value = 2048 functionId = 10");
            if (isChecked) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.gsc.put(Integer.valueOf(10), Integer.valueOf(isChecked ? 1 : 2));
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.mController.ylL, SettingsRingtoneUI.class));
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_notification_sound_and_shake")) {
            m6112a(new C38045());
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_special_scene_notification_sound_and_shake")) {
            intent = new Intent();
            intent.setClass(this, SettingsSpecialSceneNotificationUI.class);
            startActivity(intent);
            AppMethodBeat.m2505o(127361);
            return true;
        } else if (str.equals("settings_voip_sound_and_shake")) {
            intent = new Intent();
            intent.setClass(this, SettingsVoipSoundVibrateUI.class);
            startActivity(intent);
            AppMethodBeat.m2505o(127361);
            return true;
        } else {
            AppMethodBeat.m2505o(127361);
            return false;
        }
    }
}
