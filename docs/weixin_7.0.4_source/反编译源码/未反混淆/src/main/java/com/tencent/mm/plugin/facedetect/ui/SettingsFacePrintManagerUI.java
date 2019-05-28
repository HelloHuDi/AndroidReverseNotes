package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.i.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.plugin.appbrand.jsapi.media.c;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import com.tencent.mm.plugin.facedetect.b.q;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsFacePrintManagerUI extends MMPreference implements f {
    private ProgressDialog ehJ = null;
    private com.tencent.mm.ui.base.preference.f ehK;
    private View iym;
    private FaceHeaderPreference lYQ;
    private boolean lYR = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(531);
        super.onCreate(bundle);
        setMMTitle((int) R.string.bl1);
        g.Rg().a(938, (f) this);
        this.iym = findViewById(R.id.dac);
        initView();
        this.iym.setBackgroundResource(R.color.a69);
        p.M(this);
        AppMethodBeat.o(531);
    }

    public void onResume() {
        AppMethodBeat.i(c.CTRL_INDEX);
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
            ab.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            g.Rg().a(new q(1), 0);
        }
        AppMethodBeat.o(c.CTRL_INDEX);
    }

    public void onDestroy() {
        AppMethodBeat.i(ac.CTRL_INDEX);
        super.onDestroy();
        g.Rg().b(938, (f) this);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(ac.CTRL_INDEX);
    }

    public final void initView() {
        AppMethodBeat.i(l.CTRL_INDEX);
        int g = bo.g(g.RP().Ry().get(40, Integer.valueOf(0)), 0);
        ab.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + g + " " + (g & 4194304));
        this.ehK = this.yCw;
        this.lYQ = (FaceHeaderPreference) this.ehK.aqO("settings_faceprint_header");
        ((CheckBoxPreference) this.ehK.aqO("settings_faceprint_title")).qg(true);
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
        g.Rg().a(new q(3), 0);
        this.ehK.ce("settings_faceprint_create", true);
        this.ehK.ce("settings_faceeprint_reset", true);
        this.ehK.ce("settings_faceprint_unlock", true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(i.CTRL_INDEX);
                SettingsFacePrintManagerUI.this.finish();
                AppMethodBeat.o(i.CTRL_INDEX);
                return true;
            }
        });
        AppMethodBeat.o(l.CTRL_INDEX);
    }

    public final int JC() {
        return R.xml.bq;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(536);
        ab.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.getType()));
        if (i == 0 || i2 == 0) {
            if (mVar.getType() == 938) {
                q qVar = (q) mVar;
                if (qVar.lSY) {
                    int i3;
                    ab.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.ehK.ce("settings_faceprint_unlock", false);
                    this.ehK.notifyDataSetChanged();
                    int YF = r.YF();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_faceprint_title");
                    ab.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", Boolean.valueOf(qVar.lSZ));
                    if (qVar.lSZ) {
                        ab.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.qg(true);
                        this.ehK.ce("settings_faceeprint_reset", false);
                        this.ehK.ce("settings_faceprint_unlock", false);
                        i3 = 4194304 | YF;
                        this.lYQ.ej(getString(R.string.e6y), "");
                    } else {
                        ab.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.qg(false);
                        this.ehK.ce("settings_faceeprint_reset", true);
                        this.ehK.ce("settings_faceprint_unlock", true);
                        i3 = -4194305 & YF;
                        this.lYQ.ej(getString(R.string.e6x), "");
                    }
                    ab.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", Integer.valueOf(i3));
                    av.fly.ak("last_login_use_voice", String.valueOf(i3));
                    g.RP().Ry().set(40, Integer.valueOf(i3));
                    this.ehK.ce("settings_faceprint_create", true);
                    this.ehK.ce("settings_faceprint_title", false);
                    this.lYQ.a(null);
                    this.ehK.notifyDataSetChanged();
                } else {
                    ab.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    com.tencent.mm.plugin.report.service.h.pYm.e(11390, Integer.valueOf(2));
                    this.ehK.ce("settings_faceprint_create", true);
                    this.ehK.ce("settings_faceprint_title", true);
                    this.ehK.ce("settings_faceprint_unlock", true);
                    this.ehK.ce("settings_faceeprint_reset", true);
                    this.lYQ.setTitle((CharSequence) getString(R.string.e6t));
                    this.lYQ.a(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(530);
                            SettingsFacePrintManagerUI.a(SettingsFacePrintManagerUI.this);
                            AppMethodBeat.o(530);
                        }
                    });
                    this.ehK.notifyDataSetChanged();
                }
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            AppMethodBeat.o(536);
            return;
        }
        this.ehK.ce("settings_faceprint_create", true);
        this.ehK.ce("settings_faceprint_unlock", true);
        this.ehK.ce("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.ehK.aqO("settings_faceprint_title")).qg(false);
        this.lYQ.setTitle((CharSequence) getString(R.string.e6x));
        this.ehK.notifyDataSetChanged();
        if (this.ehJ != null) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(536);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(537);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.lYR = true;
            }
            ab.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", Boolean.valueOf(this.lYR));
        }
        AppMethodBeat.o(537);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(538);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(538);
            return;
        }
        ab.i("MicroMsg.FaceSettingsManagerUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 23:
                if (!(iArr[0] == 0 && iArr[1] == 0)) {
                    ab.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                    finish();
                    break;
                }
        }
        AppMethodBeat.o(538);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX);
        String str = preference.mKey;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.aqO("settings_faceprint_title");
            ab.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
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
                g.Rg().a(new q(1), 0);
            } else {
                g.Rg().a(new q(2), 0);
            }
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX);
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", r.YC());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX);
            return true;
        } else if (str.equals("settings_faceeprint_reset")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", r.YC());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX);
            return true;
        } else {
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX);
            return false;
        }
    }

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        AppMethodBeat.i(539);
        com.tencent.mm.plugin.report.service.h.pYm.e(11390, Integer.valueOf(3));
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", r.YC());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.lYR = false;
        AppMethodBeat.o(539);
    }
}
