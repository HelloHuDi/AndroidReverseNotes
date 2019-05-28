package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsVoicePrintUI extends MMPreference implements f {
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private View iym;
    private boolean lYR = false;
    private VoiceHeaderPreference sMc;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsVoicePrintUI settingsVoicePrintUI) {
        AppMethodBeat.i(26158);
        settingsVoicePrintUI.cHZ();
        AppMethodBeat.o(26158);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26149);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ecs);
        aw.Rg().a((int) c.CTRL_INDEX, (f) this);
        this.iym = findViewById(R.id.dac);
        initView();
        this.iym.setBackgroundResource(R.color.a69);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
        ab.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
        AppMethodBeat.o(26149);
    }

    public void onResume() {
        AppMethodBeat.i(26150);
        super.onResume();
        if (this.lYR) {
            this.lYR = false;
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            ab.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            aw.Rg().a(new i(1), 0);
        }
        AppMethodBeat.o(26150);
    }

    public void onDestroy() {
        AppMethodBeat.i(26151);
        super.onDestroy();
        aw.Rg().b((int) c.CTRL_INDEX, (f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(26151);
    }

    public final void initView() {
        AppMethodBeat.i(26152);
        aw.ZK();
        int g = bo.g(com.tencent.mm.model.c.Ry().get(40, Integer.valueOf(0)), 0);
        ab.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + g + " " + (g & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        this.ehK = this.yCw;
        this.sMc = (VoiceHeaderPreference) this.ehK.aqO("settings_voiceprint_header");
        ((CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title")).qg(true);
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        aw.Rg().a(new i(0), 0);
        this.ehK.ce("settings_voiceprint_unlock", true);
        this.ehK.ce("settings_voiceprint_reset", true);
        this.ehK.ce("settings_voiceprint_create", true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26145);
                SettingsVoicePrintUI.this.finish();
                AppMethodBeat.o(26145);
                return true;
            }
        });
        AppMethodBeat.o(26152);
    }

    public final int JC() {
        return R.xml.ca;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26154);
        ab.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.getType()));
        if (i == 0 || i2 == 0) {
            if (mVar.getType() == c.CTRL_INDEX) {
                i iVar = (i) mVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    ab.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.ehK.ce("settings_voiceprint_unlock", false);
                    this.ehK.notifyDataSetChanged();
                    int YF = r.YF();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title");
                    ab.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", Integer.valueOf(iVar.sLm));
                    if (iVar.sLm > 0) {
                        ab.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.qg(true);
                        this.ehK.ce("settings_voiceprint_reset", false);
                        this.ehK.ce("settings_voiceprint_unlock", false);
                        i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | YF;
                        this.sMc.ej(getString(R.string.f3a), "");
                    } else {
                        ab.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.qg(false);
                        this.ehK.ce("settings_voiceprint_reset", true);
                        this.ehK.ce("settings_voiceprint_unlock", true);
                        i3 = -131073 & YF;
                        this.sMc.ej(getString(R.string.f39), "");
                    }
                    ab.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    av.fly.ak("last_login_use_voice", String.valueOf(i3));
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(40, Integer.valueOf(i3));
                    this.ehK.ce("settings_voiceprint_create", true);
                    this.ehK.ce("settings_voiceprint_title", false);
                    this.sMc.a(null);
                    this.ehK.notifyDataSetChanged();
                } else {
                    ab.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    com.tencent.mm.plugin.report.service.h.pYm.e(11390, Integer.valueOf(2));
                    this.ehK.ce("settings_voiceprint_unlock", true);
                    this.ehK.ce("settings_voiceprint_reset", true);
                    this.ehK.ce("settings_voiceprint_create", true);
                    this.ehK.ce("settings_voiceprint_title", true);
                    this.sMc.ej(getString(R.string.f3c), getString(R.string.f3b));
                    this.sMc.a(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(26146);
                            ab.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")), bo.dpG(), SettingsVoicePrintUI.this);
                            if (b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                                SettingsVoicePrintUI.a(SettingsVoicePrintUI.this);
                                AppMethodBeat.o(26146);
                                return;
                            }
                            AppMethodBeat.o(26146);
                        }
                    });
                    this.ehK.notifyDataSetChanged();
                }
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.o(26154);
            return;
        }
        this.ehK.ce("settings_voiceprint_unlock", true);
        this.ehK.ce("settings_voiceprint_reset", true);
        this.ehK.ce("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title")).qg(false);
        this.sMc.ej(getString(R.string.f39), "");
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(26154);
    }

    private void cHZ() {
        AppMethodBeat.i(26155);
        com.tencent.mm.plugin.report.service.h.pYm.e(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.lYR = false;
        AppMethodBeat.o(26155);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(26156);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.lYR = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
        AppMethodBeat.o(26156);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(26157);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(26157);
            return;
        }
        ab.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dc0), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26147);
                            dialogInterface.dismiss();
                            SettingsVoicePrintUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(26147);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26148);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(26148);
                        }
                    });
                    break;
                }
                cHZ();
                AppMethodBeat.o(26157);
                return;
        }
        AppMethodBeat.o(26157);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(26153);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.aqO("settings_voiceprint_title");
            ab.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(R.string.tz);
            this.ehJ = h.b(context, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                aw.Rg().a(new i(1), 0);
            } else {
                aw.Rg().a(new i(2), 0);
            }
            AppMethodBeat.o(26153);
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            AppMethodBeat.o(26153);
            return true;
        } else if (str.equals("settings_voiceprint_reset")) {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            AppMethodBeat.o(26153);
            return true;
        } else {
            AppMethodBeat.o(26153);
            return false;
        }
    }
}
