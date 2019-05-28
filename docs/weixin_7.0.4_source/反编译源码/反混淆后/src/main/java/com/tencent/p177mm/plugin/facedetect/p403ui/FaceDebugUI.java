package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C38360b;
import com.tencent.p177mm.plugin.facedetect.model.C27932e;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDebugUI */
public class FaceDebugUI extends MMPreference {
    private C15541f ehK;
    private View iym;
    private CheckBoxPreference lWd = null;
    private CheckBoxPreference lWe = null;
    private CheckBoxPreference lWf = null;
    private CheckBoxPreference lWg = null;
    private CheckBoxPreference lWh = null;
    private CheckBoxPreference lWi = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDebugUI$1 */
    class C118131 implements OnMenuItemClickListener {
        C118131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(356);
            FaceDebugUI.this.finish();
            AppMethodBeat.m2505o(356);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(357);
        super.onCreate(bundle);
        this.iym = findViewById(2131826069);
        this.iym.setBackgroundResource(C25738R.color.a69);
        btf();
        setMMTitle(getString(C25738R.string.bk1));
        setBackBtn(new C118131());
        AppMethodBeat.m2505o(357);
    }

    public void onResume() {
        AppMethodBeat.m2504i(359);
        super.onResume();
        btg();
        AppMethodBeat.m2505o(359);
    }

    public void onStop() {
        AppMethodBeat.m2504i(v2helper.VOIP_ENC_HEIGHT_LV1);
        super.onStop();
        AppMethodBeat.m2505o(v2helper.VOIP_ENC_HEIGHT_LV1);
    }

    private void btg() {
        AppMethodBeat.m2504i(361);
        boolean bst = C27932e.bst();
        boolean bsv = C27932e.bsv();
        boolean bsw = C27932e.bsw();
        boolean bsx = C27932e.bsx();
        boolean bsy = C27932e.bsy();
        boolean bsu = C27932e.bsu();
        if (bst) {
            this.lWd.mo74839qg(true);
            this.ehK.mo27715ce("face_debug_save_pic_switch", false);
            this.ehK.mo27715ce("face_debug_save_final_switch", false);
            this.ehK.mo27715ce("face_debug_save_lipreading_switch", false);
            this.ehK.mo27715ce("face_debug_save_voice_switch", false);
            this.ehK.mo27715ce("face_debug_force_upload_video", false);
            this.lWe.mo74839qg(bsv);
            this.lWf.mo74839qg(bsw);
            this.lWg.mo74839qg(bsx);
            this.lWh.mo74839qg(bsy);
            this.lWi.mo74839qg(bsu);
        } else {
            this.lWd.mo74839qg(false);
            this.ehK.mo27715ce("face_debug_save_pic_switch", true);
            this.ehK.mo27715ce("face_debug_save_final_switch", true);
            this.ehK.mo27715ce("face_debug_save_lipreading_switch", true);
            this.ehK.mo27715ce("face_debug_save_voice_switch", true);
            this.ehK.mo27715ce("face_debug_force_upload_video", true);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(361);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8505ap;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(362);
        btf();
        File file;
        if ("face_debug_switch".equals(preference.mKey)) {
            C27932e.m44461gU(this.lWd.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.mKey)) {
            C27932e.m44462gV(this.lWe.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.mKey)) {
            C27932e.m44463gW(this.lWf.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.mKey)) {
            C27932e.m44464gX(this.lWg.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.mKey)) {
            C27932e.m44465gY(this.lWh.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.mKey)) {
            C27932e.m44466gZ(this.lWi.isChecked());
            btg();
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_clear_resource".equals(preference.mKey)) {
            file = new File(C43036p.m76436vo(0));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(C43036p.m76436vo(1));
            if (file2.exists()) {
                file2.delete();
            }
            C6665av.fly.mo14897ak("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            C6665av.fly.mo14897ak("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            AppMethodBeat.m2505o(362);
            return true;
        } else if ("face_debug_check_resource".equals(preference.mKey)) {
            file = new File(C43036p.m76436vo(0));
            File file3 = new File(C43036p.m76436vo(1));
            C23639t.makeText(this.mController.ylL, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(file.exists()), Boolean.valueOf(file3.exists())}), 0).show();
            C4990ab.m7417i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", C1178g.m2589v(file));
            C4990ab.m7417i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", C1178g.m2589v(file3));
            AppMethodBeat.m2505o(362);
            return true;
        } else {
            AppMethodBeat.m2505o(362);
            return false;
        }
    }

    private void btf() {
        AppMethodBeat.m2504i(C38360b.CTRL_INDEX);
        this.ehK = this.yCw;
        this.lWd = (CheckBoxPreference) this.ehK.aqO("face_debug_switch");
        this.lWe = (CheckBoxPreference) this.ehK.aqO("face_debug_save_pic_switch");
        this.lWf = (CheckBoxPreference) this.ehK.aqO("face_debug_save_final_switch");
        this.lWg = (CheckBoxPreference) this.ehK.aqO("face_debug_save_lipreading_switch");
        this.lWh = (CheckBoxPreference) this.ehK.aqO("face_debug_save_voice_switch");
        this.lWi = (CheckBoxPreference) this.ehK.aqO("face_debug_force_upload_video");
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(C38360b.CTRL_INDEX);
    }
}
