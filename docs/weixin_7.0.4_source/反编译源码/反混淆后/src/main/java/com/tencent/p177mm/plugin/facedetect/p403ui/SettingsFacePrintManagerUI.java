package com.tencent.p177mm.plugin.facedetect.p403ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C42541c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C27003i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42523ac;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C45616h;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.p966b.C27919q;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI */
public class SettingsFacePrintManagerUI extends MMPreference implements C1202f {
    private ProgressDialog ehJ = null;
    private C15541f ehK;
    private View iym;
    private FaceHeaderPreference lYQ;
    private boolean lYR = false;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI$5 */
    class C118175 implements OnClickListener {
        C118175() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(530);
            SettingsFacePrintManagerUI.m66304a(SettingsFacePrintManagerUI.this);
            AppMethodBeat.m2505o(530);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI$1 */
    class C341061 implements OnCancelListener {
        C341061() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI$2 */
    class C341072 implements OnCancelListener {
        C341072() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI$4 */
    class C341084 implements OnCancelListener {
        C341084() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI$3 */
    class C390253 implements OnMenuItemClickListener {
        C390253() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(C27003i.CTRL_INDEX);
            SettingsFacePrintManagerUI.this.finish();
            AppMethodBeat.m2505o(C27003i.CTRL_INDEX);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(531);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bl1);
        C1720g.m3540Rg().mo14539a(938, (C1202f) this);
        this.iym = findViewById(2131826069);
        initView();
        this.iym.setBackgroundResource(C25738R.color.a69);
        C43036p.m76428M(this);
        AppMethodBeat.m2505o(531);
    }

    public void onResume() {
        AppMethodBeat.m2504i(C42541c.CTRL_INDEX);
        super.onResume();
        if (this.lYR) {
            this.lYR = false;
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C341061());
            C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            C1720g.m3540Rg().mo14541a(new C27919q(1), 0);
        }
        AppMethodBeat.m2505o(C42541c.CTRL_INDEX);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(C42523ac.CTRL_INDEX);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(938, (C1202f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(C42523ac.CTRL_INDEX);
    }

    public final void initView() {
        AppMethodBeat.m2504i(C27067l.CTRL_INDEX);
        int g = C5046bo.m7550g(C1720g.m3536RP().mo5239Ry().get(40, Integer.valueOf(0)), 0);
        C4990ab.m7416i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + g + " " + (g & 4194304));
        this.ehK = this.yCw;
        this.lYQ = (FaceHeaderPreference) this.ehK.aqO("settings_faceprint_header");
        ((CheckBoxPreference) this.ehK.aqO("settings_faceprint_title")).mo74839qg(true);
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C341072());
        C1720g.m3540Rg().mo14541a(new C27919q(3), 0);
        this.ehK.mo27715ce("settings_faceprint_create", true);
        this.ehK.mo27715ce("settings_faceeprint_reset", true);
        this.ehK.mo27715ce("settings_faceprint_unlock", true);
        setBackBtn(new C390253());
        AppMethodBeat.m2505o(C27067l.CTRL_INDEX);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8542bq;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(536);
        C4990ab.m7411d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.getType()));
        if (i == 0 || i2 == 0) {
            if (c1207m.getType() == 938) {
                C27919q c27919q = (C27919q) c1207m;
                if (c27919q.lSY) {
                    int i3;
                    C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.ehK.mo27715ce("settings_faceprint_unlock", false);
                    this.ehK.notifyDataSetChanged();
                    int YF = C1853r.m3824YF();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_faceprint_title");
                    C4990ab.m7411d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", Boolean.valueOf(c27919q.lSZ));
                    if (c27919q.lSZ) {
                        C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.mo74839qg(true);
                        this.ehK.mo27715ce("settings_faceeprint_reset", false);
                        this.ehK.mo27715ce("settings_faceprint_unlock", false);
                        i3 = 4194304 | YF;
                        this.lYQ.mo73762ej(getString(C25738R.string.e6y), "");
                    } else {
                        C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.mo74839qg(false);
                        this.ehK.mo27715ce("settings_faceeprint_reset", true);
                        this.ehK.mo27715ce("settings_faceprint_unlock", true);
                        i3 = -4194305 & YF;
                        this.lYQ.mo73762ej(getString(C25738R.string.e6x), "");
                    }
                    C4990ab.m7417i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    C6665av.fly.mo14897ak("last_login_use_voice", String.valueOf(i3));
                    C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(i3));
                    this.ehK.mo27715ce("settings_faceprint_create", true);
                    this.ehK.mo27715ce("settings_faceprint_title", false);
                    this.lYQ.mo73761a(null);
                    this.ehK.notifyDataSetChanged();
                } else {
                    C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    C7060h.pYm.mo8381e(11390, Integer.valueOf(2));
                    this.ehK.mo27715ce("settings_faceprint_create", true);
                    this.ehK.mo27715ce("settings_faceprint_title", true);
                    this.ehK.mo27715ce("settings_faceprint_unlock", true);
                    this.ehK.mo27715ce("settings_faceeprint_reset", true);
                    this.lYQ.setTitle((CharSequence) getString(C25738R.string.e6t));
                    this.lYQ.mo73761a(new C118175());
                    this.ehK.notifyDataSetChanged();
                }
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.m2505o(536);
            return;
        }
        this.ehK.mo27715ce("settings_faceprint_create", true);
        this.ehK.mo27715ce("settings_faceprint_unlock", true);
        this.ehK.mo27715ce("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.ehK.aqO("settings_faceprint_title")).mo74839qg(false);
        this.lYQ.setTitle((CharSequence) getString(C25738R.string.e6x));
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(536);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(537);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.lYR = true;
            }
            C4990ab.m7417i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", Boolean.valueOf(this.lYR));
        }
        AppMethodBeat.m2505o(537);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(538);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(538);
            return;
        }
        C4990ab.m7417i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 23:
                if (!(iArr[0] == 0 && iArr[1] == 0)) {
                    C4990ab.m7420w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                    finish();
                    break;
                }
        }
        AppMethodBeat.m2505o(538);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(C45616h.CTRL_INDEX);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) c15541f.aqO("settings_faceprint_title");
            C4990ab.m7410d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.ehJ != null && this.ehJ.isShowing()) {
                this.ehJ.dismiss();
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f9260un), true, new C341084());
            if (checkBoxPreference.isChecked()) {
                C1720g.m3540Rg().mo14541a(new C27919q(1), 0);
            } else {
                C1720g.m3540Rg().mo14541a(new C27919q(2), 0);
            }
            AppMethodBeat.m2505o(C45616h.CTRL_INDEX);
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", C1853r.m3821YC());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            AppMethodBeat.m2505o(C45616h.CTRL_INDEX);
            return true;
        } else if (str.equals("settings_faceeprint_reset")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", C1853r.m3821YC());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(C45616h.CTRL_INDEX);
            return true;
        } else {
            AppMethodBeat.m2505o(C45616h.CTRL_INDEX);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m66304a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        AppMethodBeat.m2504i(539);
        C7060h.pYm.mo8381e(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", C1853r.m3821YC());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.lYR = false;
        AppMethodBeat.m2505o(539);
    }
}
