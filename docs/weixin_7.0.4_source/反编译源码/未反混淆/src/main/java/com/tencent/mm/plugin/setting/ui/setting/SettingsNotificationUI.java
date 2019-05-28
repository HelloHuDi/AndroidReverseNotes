package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.y;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.d;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.c;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsNotificationUI extends MMPreference {
    private f ehK;
    private HashMap<Integer, Integer> gsc = new HashMap();
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsNotificationUI() {
        AppMethodBeat.i(127356);
        AppMethodBeat.o(127356);
    }

    public final int JC() {
        return R.xml.c1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127357);
        super.onCreate(bundle);
        this.status = r.YD();
        setMMTitle((int) R.string.e9j);
        AppMethodBeat.o(127357);
    }

    public void onPause() {
        AppMethodBeat.i(127359);
        super.onPause();
        g.RP().Ry().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((j) g.K(j.class)).XL().c(new a(23, act));
            ab.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.o(127359);
    }

    public void onResume() {
        AppMethodBeat.i(127360);
        super.onResume();
        initView();
        AppMethodBeat.o(127360);
    }

    public void onDestroy() {
        AppMethodBeat.i(127362);
        super.onDestroy();
        au.kB(3);
        AppMethodBeat.o(127362);
    }

    private void a(d dVar) {
        AppMethodBeat.i(127363);
        Intent intent = new Intent();
        if (!com.tencent.mm.compatible.util.d.iW(26)) {
            if (com.tencent.mm.compatible.util.d.iW(21)) {
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
            AppMethodBeat.o(127363);
        } else if (!b.dqw() || (b.dqv() && (!b.dqv() || b.dqx()))) {
            ab.i("MicroMsg.SettingsNotificationUI", "openSysSetting() native notificationchannel jump");
            if (y.L(this.mController.ylL).areNotificationsEnabled()) {
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.CHANNEL_ID", com.tencent.mm.bo.a.My());
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
            com.tencent.mm.pluginsdk.permission.b.a(intent, dVar);
            AppMethodBeat.o(127363);
        } else {
            ab.i("MicroMsg.SettingsNotificationUI", "openSysSetting() ifNotificationChannelSupportNativeActionJump = false");
            intent = new Intent("android.intent.action.MAIN");
            intent.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
            intent.putExtra("appName", ah.getContext().getResources().getString(R.string.ru));
            intent.putExtra(DownloadInfoColumns.PACKAGENAME, getPackageName());
            com.tencent.mm.pluginsdk.permission.b.a(intent, dVar);
            AppMethodBeat.o(127363);
        }
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.i(127358);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.c1);
        if (com.tencent.mm.compatible.util.d.iW(26)) {
            this.ehK.ce("settings_notification_top", true);
            this.ehK.ce("settings_notification_title", false);
            this.ehK.ce("settings_notification_sound_shake", false);
            this.ehK.ce("settings_voip_sound_and_shake", false);
        } else {
            this.ehK.ce("settings_notification_top", false);
            this.ehK.ce("settings_notification_title", true);
            this.ehK.ce("settings_notification_sound_shake", true);
            this.ehK.ce("settings_voip_sound_and_shake", true);
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_new_msg_notification");
        if (com.tencent.mm.compatible.util.d.iW(26)) {
            boolean z2;
            if (com.tencent.mm.m.a.MC() && com.tencent.mm.m.a.MD()) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBoxPreference.uOT = z2;
        } else {
            checkBoxPreference.uOT = com.tencent.mm.m.a.MC();
        }
        ((CheckBoxPreference) this.ehK.aqO("settings_new_voip_msg_notification")).uOT = com.tencent.mm.m.a.ME();
        if (checkBoxPreference.isChecked()) {
            String str;
            if (com.tencent.mm.compatible.util.d.iW(26)) {
                this.ehK.ce("settings_notification_sound_and_shake", false);
                this.ehK.ce("settings_sound", true);
                this.ehK.ce("settings_shake", true);
                this.ehK.ce("settings_notification_ringtone", true);
                com.tencent.mm.m.a.MQ();
                ab.i("MicroMsg.SettingsNotificationUI", "initView() mSpecialSceneSwitchEnable:%s", Integer.valueOf(com.tencent.mm.m.a.MP()));
                f fVar = this.ehK;
                str = "settings_special_scene_notification_sound_and_shake";
                if (com.tencent.mm.m.a.MP() != 1) {
                    z = true;
                }
                fVar.ce(str, z);
            } else {
                checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_sound");
                checkBoxPreference.uOT = com.tencent.mm.m.a.MG();
                if (checkBoxPreference.isChecked()) {
                    Preference aqO = this.ehK.aqO("settings_notification_ringtone");
                    if (com.tencent.mm.compatible.util.d.iW(26)) {
                        str = com.tencent.mm.m.a.MK();
                        if (str != com.tencent.mm.m.f.evO) {
                            aqO.setSummary(RingtoneManager.getRingtone(this, Uri.parse(str)).getTitle(this));
                        } else {
                            aqO.setSummary(getString(R.string.e9l));
                        }
                    } else if (aqO != null) {
                        aqO.setSummary(this.ehZ.getString("settings.ringtone.name", getString(R.string.e9l)));
                    }
                } else {
                    this.ehK.aqP("settings_notification_ringtone");
                }
                ((CheckBoxPreference) this.ehK.aqO("settings_shake")).uOT = com.tencent.mm.m.a.MI();
                this.ehK.ce("settings_notification_sound_and_shake", true);
                this.ehK.ce("settings_special_scene_notification_title", true);
                this.ehK.ce("settings_specail_scene_sound", true);
                this.ehK.ce("settings_specail_scene_shake", true);
                this.ehK.ce("settings_special_scene_notification_sound_and_shake", true);
            }
            ((CheckBoxPreference) this.ehK.aqO("settings_show_detail")).uOT = com.tencent.mm.m.a.MF();
        } else {
            this.ehK.aqP("settings_show_detail");
            this.ehK.aqP("settings_sound");
            this.ehK.aqP("settings_notification_ringtone");
            this.ehK.aqP("settings_shake");
            this.ehK.aqP("settings_active_time");
            this.ehK.aqP("settings_notification_sound_and_shake");
            this.ehK.aqP("settings_special_scene_notification_sound_and_shake");
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127351);
                SettingsNotificationUI.this.aqX();
                SettingsNotificationUI.this.finish();
                AppMethodBeat.o(127351);
                return true;
            }
        });
        AppMethodBeat.o(127358);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127361);
        String str = preference.mKey;
        if (str.equals("settings_new_msg_notification")) {
            if (!com.tencent.mm.compatible.util.d.iW(26) || com.tencent.mm.m.a.MD()) {
                com.tencent.mm.m.f.bL(((CheckBoxPreference) preference).isChecked());
                initView();
                if (((CheckBoxPreference) preference).isChecked()) {
                    h.pYm.a(500, 0, 1, false);
                } else {
                    h.pYm.a(500, 1, 1, false);
                }
                au.k(true, false);
                AppMethodBeat.o(127361);
                return true;
            }
            e.a aVar = new e.a(this.mController.ylL);
            aVar.asL(getString(R.string.e47)).re(false);
            aVar.c(new c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(127353);
                    if (z) {
                        SettingsNotificationUI.a(SettingsNotificationUI.this, new d() {
                            public final void Cp(int i) {
                                AppMethodBeat.i(127352);
                                if (com.tencent.mm.m.a.MD()) {
                                    com.tencent.mm.m.f.bL(true);
                                    SettingsNotificationUI.this.initView();
                                    h.pYm.a(500, 0, 1, false);
                                    au.k(true, false);
                                    AppMethodBeat.o(127352);
                                    return;
                                }
                                SettingsNotificationUI.this.initView();
                                AppMethodBeat.o(127352);
                            }
                        });
                        AppMethodBeat.o(127353);
                        return;
                    }
                    SettingsNotificationUI.this.initView();
                    AppMethodBeat.o(127353);
                }
            }).show();
        }
        boolean isChecked;
        Intent intent;
        if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.m.f.bM(true);
                h.pYm.a(500, 2, 1, false);
                au.k(false, true);
                initView();
            } else {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, false, this.mController.ylL.getString(R.string.e9f), "", this.mController.ylL.getString(R.string.e9e), this.mController.ylL.getString(R.string.e83), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127354);
                        com.tencent.mm.m.f.bM(false);
                        bi biVar = new bi();
                        biVar.hO(2);
                        biVar.eJ(System.currentTimeMillis());
                        biVar.setType(1);
                        biVar.ju("weixin");
                        biVar.setContent(SettingsNotificationUI.this.mController.ylL.getString(R.string.e9h, new Object[]{Build.MODEL}));
                        bf.l(biVar);
                        ak aoZ = ((j) g.K(j.class)).XR().aoZ("weixin");
                        if (aoZ != null) {
                            aoZ.setContent(SettingsNotificationUI.this.mController.ylL.getString(R.string.e9h, new Object[]{Build.MODEL}));
                            aoZ.hM(aoZ.field_unReadCount + 1);
                            ((j) g.K(j.class)).XR().a(aoZ, "weixin");
                        } else {
                            aoZ = new ak();
                            aoZ.setContent(SettingsNotificationUI.this.mController.ylL.getString(R.string.e9h, new Object[]{Build.MODEL}));
                            aoZ.setUsername("weixin");
                            aoZ.hM(1);
                            ((j) g.K(j.class)).XR().d(aoZ);
                        }
                        SettingsNotificationUI.this.initView();
                        h.pYm.a(500, 3, 1, false);
                        au.k(false, true);
                        AppMethodBeat.o(127354);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127355);
                        com.tencent.mm.m.f.bM(true);
                        ((CheckBoxPreference) SettingsNotificationUI.this.ehK.aqO("settings_new_voip_msg_notification")).uOT = true;
                        SettingsNotificationUI.this.initView();
                        au.k(false, true);
                        AppMethodBeat.o(127355);
                    }
                }, R.color.ei, 0);
            }
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            g.RP().Ry().set(73217, Boolean.valueOf(isChecked));
            g.RP().Ry().set(73218, Boolean.valueOf(isChecked));
            h.pYm.a(500, isChecked ? 8 : 9, 1, false);
            ab.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(isChecked));
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.m.f.bO(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                h.pYm.a(500, 10, 1, false);
            } else {
                h.pYm.a(500, 11, 1, false);
            }
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.m.f.bP(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                h.pYm.a(500, 16, 1, false);
            } else {
                h.pYm.a(500, 17, 1, false);
            }
            bo.z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_show_detail")) {
            isChecked = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.m.f.bN(isChecked);
            if (isChecked) {
                isChecked = false;
            } else {
                isChecked = true;
            }
            ab.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + isChecked + " item value = 2048 functionId = 10");
            if (isChecked) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.gsc.put(Integer.valueOf(10), Integer.valueOf(isChecked ? 1 : 2));
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.mController.ylL, SettingsRingtoneUI.class));
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_notification_sound_and_shake")) {
            a(new d() {
                public final void Cp(int i) {
                }
            });
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_special_scene_notification_sound_and_shake")) {
            intent = new Intent();
            intent.setClass(this, SettingsSpecialSceneNotificationUI.class);
            startActivity(intent);
            AppMethodBeat.o(127361);
            return true;
        } else if (str.equals("settings_voip_sound_and_shake")) {
            intent = new Intent();
            intent.setClass(this, SettingsVoipSoundVibrateUI.class);
            startActivity(intent);
            AppMethodBeat.o(127361);
            return true;
        } else {
            AppMethodBeat.o(127361);
            return false;
        }
    }
}
