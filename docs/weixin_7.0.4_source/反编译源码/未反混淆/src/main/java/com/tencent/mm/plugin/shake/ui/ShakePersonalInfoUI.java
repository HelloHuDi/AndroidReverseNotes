package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.d;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.cb;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24767);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(24767);
    }

    public final void initView() {
        AppMethodBeat.i(24769);
        setMMTitle((int) R.string.ef1);
        this.ehK = this.yCw;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("shake_item_sound");
        aw.ZK();
        if (c.Ry().get(4112, null) == null) {
            aw.ZK();
            c.Ry().set(4112, Boolean.TRUE);
        }
        aw.ZK();
        checkBoxPreference.uOT = bo.d((Boolean) c.Ry().get(4112, null));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24766);
                ShakePersonalInfoUI.this.finish();
                AppMethodBeat.o(24766);
                return true;
            }
        });
        if (!d.aim()) {
            this.ehK.aqP("shake_item_shake_music_list");
        }
        AppMethodBeat.o(24769);
    }

    public void onResume() {
        boolean z = false;
        AppMethodBeat.i(24770);
        super.onResume();
        if (aw.RK()) {
            a.gkF.BS();
        }
        if (this.ehK.aqO("shake_item_shake_tv_list") == null) {
            ab.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            AppMethodBeat.o(24770);
            return;
        }
        if (bo.getInt(g.Nv().O("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        ab.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(z)));
        if (!(z || ae.giq)) {
            this.ehK.ce("shake_item_shake_tv_list", true);
        }
        AppMethodBeat.o(24770);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(24771);
        if (i == 4) {
            finish();
            AppMethodBeat.o(24771);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(24771);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(24773);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(24773);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                StringBuilder stringBuilder = new StringBuilder();
                aw.ZK();
                intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.XW()).append("custom_shake_img_filename.jpg").toString());
                a.gkE.a(intent2, 2, (MMActivity) this, intent);
                AppMethodBeat.o(24773);
                return;
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(24773);
                    return;
                }
                Object stringExtra = intent.getStringExtra("CropImage_OutputPath");
                aw.ZK();
                c.Ry().set(4110, Boolean.FALSE);
                aw.ZK();
                c.Ry().set(4111, stringExtra);
                AppMethodBeat.o(24773);
                return;
            default:
                AppMethodBeat.o(24773);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(24768);
        a.gkF.BS();
        super.onDestroy();
        AppMethodBeat.o(24768);
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        AppMethodBeat.i(24772);
        String str = preference.mKey;
        if ("shake_item_default_bgimg".equals(str)) {
            aw.ZK();
            c.Ry().set(4110, Boolean.TRUE);
            h.bQ(this, getResources().getString(R.string.eg1));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            n.a((Activity) this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            aw.ZK();
            boolean d = bo.d((Boolean) c.Ry().get(4112, null));
            aw.ZK();
            c.Ry().set(4112, Boolean.valueOf(!d));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(R.string.ef0));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(R.string.egm));
            startActivity(intent);
        }
        AppMethodBeat.o(24772);
        return false;
    }
}
