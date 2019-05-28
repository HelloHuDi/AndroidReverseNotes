package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C16666c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voiceprint.model.C43718i;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI */
public class SettingsVoicePrintUI extends MMPreference implements C1202f {
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private View iym;
    private boolean lYR = false;
    private VoiceHeaderPreference sMc;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$7 */
    class C140217 implements OnClickListener {
        C140217() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26148);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(26148);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$2 */
    class C140222 implements OnCancelListener {
        C140222() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$1 */
    class C140231 implements OnCancelListener {
        C140231() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$3 */
    class C140243 implements OnMenuItemClickListener {
        C140243() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26145);
            SettingsVoicePrintUI.this.finish();
            AppMethodBeat.m2505o(26145);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$5 */
    class C140255 implements View.OnClickListener {
        C140255() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26146);
            C4990ab.m7417i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")), C5046bo.dpG(), SettingsVoicePrintUI.this);
            if (C35805b.m58707a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                SettingsVoicePrintUI.m22160a(SettingsVoicePrintUI.this);
                AppMethodBeat.m2505o(26146);
                return;
            }
            AppMethodBeat.m2505o(26146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$4 */
    class C140264 implements OnCancelListener {
        C140264() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI$6 */
    class C140276 implements OnClickListener {
        C140276() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26147);
            dialogInterface.dismiss();
            SettingsVoicePrintUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(26147);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m22160a(SettingsVoicePrintUI settingsVoicePrintUI) {
        AppMethodBeat.m2504i(26158);
        settingsVoicePrintUI.cHZ();
        AppMethodBeat.m2505o(26158);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26149);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ecs);
        C9638aw.m17182Rg().mo14539a((int) C16666c.CTRL_INDEX, (C1202f) this);
        this.iym = findViewById(2131826069);
        initView();
        this.iym.setBackgroundResource(C25738R.color.a69);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERFINO_VOICEPRINT_SETTING_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
        C4990ab.m7416i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
        AppMethodBeat.m2505o(26149);
    }

    public void onResume() {
        AppMethodBeat.m2504i(26150);
        super.onResume();
        if (this.lYR) {
            this.lYR = false;
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C140231());
            C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            C9638aw.m17182Rg().mo14541a(new C43718i(1), 0);
        }
        AppMethodBeat.m2505o(26150);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26151);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b((int) C16666c.CTRL_INDEX, (C1202f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(26151);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26152);
        C9638aw.m17190ZK();
        int g = C5046bo.m7550g(C18628c.m29072Ry().get(40, Integer.valueOf(0)), 0);
        C4990ab.m7416i("MicroMsg.VoiceSettingsUI", "plugSwitch " + g + " " + (g & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        this.ehK = this.yCw;
        this.sMc = (VoiceHeaderPreference) this.ehK.aqO("settings_voiceprint_header");
        ((CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title")).mo74839qg(true);
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C140222());
        C9638aw.m17182Rg().mo14541a(new C43718i(0), 0);
        this.ehK.mo27715ce("settings_voiceprint_unlock", true);
        this.ehK.mo27715ce("settings_voiceprint_reset", true);
        this.ehK.mo27715ce("settings_voiceprint_create", true);
        setBackBtn(new C140243());
        AppMethodBeat.m2505o(26152);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8562ca;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26154);
        C4990ab.m7411d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.getType()));
        if (i == 0 || i2 == 0) {
            if (c1207m.getType() == C16666c.CTRL_INDEX) {
                C43718i c43718i = (C43718i) c1207m;
                if (c43718i.mStatus == 1) {
                    int i3;
                    C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.ehK.mo27715ce("settings_voiceprint_unlock", false);
                    this.ehK.notifyDataSetChanged();
                    int YF = C1853r.m3824YF();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title");
                    C4990ab.m7411d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", Integer.valueOf(c43718i.sLm));
                    if (c43718i.sLm > 0) {
                        C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.mo74839qg(true);
                        this.ehK.mo27715ce("settings_voiceprint_reset", false);
                        this.ehK.mo27715ce("settings_voiceprint_unlock", false);
                        i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | YF;
                        this.sMc.mo47728ej(getString(C25738R.string.f3a), "");
                    } else {
                        C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.mo74839qg(false);
                        this.ehK.mo27715ce("settings_voiceprint_reset", true);
                        this.ehK.mo27715ce("settings_voiceprint_unlock", true);
                        i3 = -131073 & YF;
                        this.sMc.mo47728ej(getString(C25738R.string.f39), "");
                    }
                    C4990ab.m7417i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    C6665av.fly.mo14897ak("last_login_use_voice", String.valueOf(i3));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(40, Integer.valueOf(i3));
                    this.ehK.mo27715ce("settings_voiceprint_create", true);
                    this.ehK.mo27715ce("settings_voiceprint_title", false);
                    this.sMc.mo47727a(null);
                    this.ehK.notifyDataSetChanged();
                } else {
                    C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    C7060h.pYm.mo8381e(11390, Integer.valueOf(2));
                    this.ehK.mo27715ce("settings_voiceprint_unlock", true);
                    this.ehK.mo27715ce("settings_voiceprint_reset", true);
                    this.ehK.mo27715ce("settings_voiceprint_create", true);
                    this.ehK.mo27715ce("settings_voiceprint_title", true);
                    this.sMc.mo47728ej(getString(C25738R.string.f3c), getString(C25738R.string.f3b));
                    this.sMc.mo47727a(new C140255());
                    this.ehK.notifyDataSetChanged();
                }
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.m2505o(26154);
            return;
        }
        this.ehK.mo27715ce("settings_voiceprint_unlock", true);
        this.ehK.mo27715ce("settings_voiceprint_reset", true);
        this.ehK.mo27715ce("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.ehK.aqO("settings_voiceprint_title")).mo74839qg(false);
        this.sMc.mo47728ej(getString(C25738R.string.f39), "");
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(26154);
    }

    private void cHZ() {
        AppMethodBeat.m2504i(26155);
        C7060h.pYm.mo8381e(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.lYR = false;
        AppMethodBeat.m2505o(26155);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(26156);
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.lYR = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
        AppMethodBeat.m2505o(26156);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(26157);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(26157);
            return;
        }
        C4990ab.m7417i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dc0), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C140276(), new C140217());
                    break;
                }
                cHZ();
                AppMethodBeat.m2505o(26157);
                return;
        }
        AppMethodBeat.m2505o(26157);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(26153);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) c15541f.aqO("settings_voiceprint_title");
            C4990ab.m7410d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C140264());
            if (checkBoxPreference.isChecked()) {
                C9638aw.m17182Rg().mo14541a(new C43718i(1), 0);
            } else {
                C9638aw.m17182Rg().mo14541a(new C43718i(2), 0);
            }
            AppMethodBeat.m2505o(26153);
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            AppMethodBeat.m2505o(26153);
            return true;
        } else if (str.equals("settings_voiceprint_reset")) {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(26153);
            return true;
        } else {
            AppMethodBeat.m2505o(26153);
            return false;
        }
    }
}
