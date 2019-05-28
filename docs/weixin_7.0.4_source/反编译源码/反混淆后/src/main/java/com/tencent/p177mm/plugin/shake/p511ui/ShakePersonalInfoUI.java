package com.tencent.p177mm.plugin.shake.p511ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI */
public class ShakePersonalInfoUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI$1 */
    class C132661 implements OnMenuItemClickListener {
        C132661() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24766);
            ShakePersonalInfoUI.this.finish();
            AppMethodBeat.m2505o(24766);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8563cb;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24767);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(24767);
    }

    public final void initView() {
        AppMethodBeat.m2504i(24769);
        setMMTitle((int) C25738R.string.ef1);
        this.ehK = this.yCw;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("shake_item_sound");
        C9638aw.m17190ZK();
        if (C18628c.m29072Ry().get(4112, null) == null) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4112, Boolean.TRUE);
        }
        C9638aw.m17190ZK();
        checkBoxPreference.uOT = C5046bo.m7545d((Boolean) C18628c.m29072Ry().get(4112, null));
        setBackBtn(new C132661());
        if (!C25847d.aim()) {
            this.ehK.aqP("shake_item_shake_music_list");
        }
        AppMethodBeat.m2505o(24769);
    }

    public void onResume() {
        boolean z = false;
        AppMethodBeat.m2504i(24770);
        super.onResume();
        if (C9638aw.m17179RK()) {
            C46193a.gkF.mo38844BS();
        }
        if (this.ehK.aqO("shake_item_shake_tv_list") == null) {
            C4990ab.m7412e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            AppMethodBeat.m2505o(24770);
            return;
        }
        if (C5046bo.getInt(C26373g.m41965Nv().mo5301O("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(z)));
        if (!(z || C1947ae.giq)) {
            this.ehK.mo27715ce("shake_item_shake_tv_list", true);
        }
        AppMethodBeat.m2505o(24770);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(24771);
        if (i == 4) {
            finish();
            AppMethodBeat.m2505o(24771);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(24771);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24773);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(24773);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                StringBuilder stringBuilder = new StringBuilder();
                C9638aw.m17190ZK();
                intent2.putExtra("CropImage_OutputPath", stringBuilder.append(C18628c.m29088XW()).append("custom_shake_img_filename.jpg").toString());
                C46193a.gkE.mo38894a(intent2, 2, (MMActivity) this, intent);
                AppMethodBeat.m2505o(24773);
                return;
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(24773);
                    return;
                }
                Object stringExtra = intent.getStringExtra("CropImage_OutputPath");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4110, Boolean.FALSE);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(4111, stringExtra);
                AppMethodBeat.m2505o(24773);
                return;
            default:
                AppMethodBeat.m2505o(24773);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24768);
        C46193a.gkF.mo38844BS();
        super.onDestroy();
        AppMethodBeat.m2505o(24768);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        Intent intent;
        AppMethodBeat.m2504i(24772);
        String str = preference.mKey;
        if ("shake_item_default_bgimg".equals(str)) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4110, Boolean.TRUE);
            C30379h.m48465bQ(this, getResources().getString(C25738R.string.eg1));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            C14987n.m23301a((Activity) this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            C9638aw.m17190ZK();
            boolean d = C5046bo.m7545d((Boolean) C18628c.m29072Ry().get(4112, null));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(4112, Boolean.valueOf(!d));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(C25738R.string.ef0));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(C25738R.string.egm));
            startActivity(intent);
        }
        AppMethodBeat.m2505o(24772);
        return false;
    }
}
