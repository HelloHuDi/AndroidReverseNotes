package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.b;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.wxmm.v2helper;
import java.io.File;

public class FaceDebugUI extends MMPreference {
    private f ehK;
    private View iym;
    private CheckBoxPreference lWd = null;
    private CheckBoxPreference lWe = null;
    private CheckBoxPreference lWf = null;
    private CheckBoxPreference lWg = null;
    private CheckBoxPreference lWh = null;
    private CheckBoxPreference lWi = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(357);
        super.onCreate(bundle);
        this.iym = findViewById(R.id.dac);
        this.iym.setBackgroundResource(R.color.a69);
        btf();
        setMMTitle(getString(R.string.bk1));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(356);
                FaceDebugUI.this.finish();
                AppMethodBeat.o(356);
                return false;
            }
        });
        AppMethodBeat.o(357);
    }

    public void onResume() {
        AppMethodBeat.i(359);
        super.onResume();
        btg();
        AppMethodBeat.o(359);
    }

    public void onStop() {
        AppMethodBeat.i(v2helper.VOIP_ENC_HEIGHT_LV1);
        super.onStop();
        AppMethodBeat.o(v2helper.VOIP_ENC_HEIGHT_LV1);
    }

    private void btg() {
        AppMethodBeat.i(361);
        boolean bst = e.bst();
        boolean bsv = e.bsv();
        boolean bsw = e.bsw();
        boolean bsx = e.bsx();
        boolean bsy = e.bsy();
        boolean bsu = e.bsu();
        if (bst) {
            this.lWd.qg(true);
            this.ehK.ce("face_debug_save_pic_switch", false);
            this.ehK.ce("face_debug_save_final_switch", false);
            this.ehK.ce("face_debug_save_lipreading_switch", false);
            this.ehK.ce("face_debug_save_voice_switch", false);
            this.ehK.ce("face_debug_force_upload_video", false);
            this.lWe.qg(bsv);
            this.lWf.qg(bsw);
            this.lWg.qg(bsx);
            this.lWh.qg(bsy);
            this.lWi.qg(bsu);
        } else {
            this.lWd.qg(false);
            this.ehK.ce("face_debug_save_pic_switch", true);
            this.ehK.ce("face_debug_save_final_switch", true);
            this.ehK.ce("face_debug_save_lipreading_switch", true);
            this.ehK.ce("face_debug_save_voice_switch", true);
            this.ehK.ce("face_debug_force_upload_video", true);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(361);
    }

    public final int JC() {
        return R.xml.ap;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(362);
        btf();
        File file;
        if ("face_debug_switch".equals(preference.mKey)) {
            e.gU(this.lWd.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.mKey)) {
            e.gV(this.lWe.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.mKey)) {
            e.gW(this.lWf.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.mKey)) {
            e.gX(this.lWg.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.mKey)) {
            e.gY(this.lWh.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.mKey)) {
            e.gZ(this.lWi.isChecked());
            btg();
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_clear_resource".equals(preference.mKey)) {
            file = new File(p.vo(0));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(p.vo(1));
            if (file2.exists()) {
                file2.delete();
            }
            av.fly.ak("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            av.fly.ak("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            AppMethodBeat.o(362);
            return true;
        } else if ("face_debug_check_resource".equals(preference.mKey)) {
            file = new File(p.vo(0));
            File file3 = new File(p.vo(1));
            t.makeText(this.mController.ylL, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(file.exists()), Boolean.valueOf(file3.exists())}), 0).show();
            ab.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", g.v(file));
            ab.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", g.v(file3));
            AppMethodBeat.o(362);
            return true;
        } else {
            AppMethodBeat.o(362);
            return false;
        }
    }

    private void btf() {
        AppMethodBeat.i(b.CTRL_INDEX);
        this.ehK = this.yCw;
        this.lWd = (CheckBoxPreference) this.ehK.aqO("face_debug_switch");
        this.lWe = (CheckBoxPreference) this.ehK.aqO("face_debug_save_pic_switch");
        this.lWf = (CheckBoxPreference) this.ehK.aqO("face_debug_save_final_switch");
        this.lWg = (CheckBoxPreference) this.ehK.aqO("face_debug_save_lipreading_switch");
        this.lWh = (CheckBoxPreference) this.ehK.aqO("face_debug_save_voice_switch");
        this.lWi = (CheckBoxPreference) this.ehK.aqO("face_debug_force_upload_video");
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(b.CTRL_INDEX);
    }
}
