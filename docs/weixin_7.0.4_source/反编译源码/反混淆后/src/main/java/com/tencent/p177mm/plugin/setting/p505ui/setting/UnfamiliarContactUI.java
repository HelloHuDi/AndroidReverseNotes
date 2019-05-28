package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.TextButtonPreference;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI */
public class UnfamiliarContactUI extends MMPreference {
    private boolean qjN;
    private boolean qjO;
    private boolean qjP;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactUI$1 */
    class C132421 implements OnMenuItemClickListener {
        C132421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127684);
            UnfamiliarContactUI.this.finish();
            AppMethodBeat.m2505o(127684);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127685);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127685);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8561c_;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127686);
        if (preference instanceof CheckPreference) {
            CheckPreference checkPreference = (CheckPreference) preference;
            boolean z2;
            boolean z3;
            if (preference.mKey.equals("settings_half_year_not_chat")) {
                if (this.qjN) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                checkPreference.uOT = z2;
                if (this.qjN) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                this.qjN = z3;
            } else if (preference.mKey.equals("settings_has_not_same_chatroom")) {
                if (this.qjP) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                checkPreference.uOT = z2;
                if (this.qjP) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                this.qjP = z3;
            } else if (preference.mKey.equals("settings_half_year_not_response")) {
                if (this.qjO) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                checkPreference.uOT = z2;
                if (this.qjO) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                this.qjO = z3;
            }
            TextButtonPreference textButtonPreference = (TextButtonPreference) c15541f.aqO("settings_next_step");
            if (this.qjN || this.qjP || this.qjO) {
                z = true;
            }
            textButtonPreference.setEnabled(z);
        } else if (preference.mKey.equals("settings_next_step")) {
            Intent intent = new Intent(this, UnfamiliarContactDetailUI.class);
            intent.putExtra("half_year_not_chat", this.qjN);
            intent.putExtra("half_year_not_response", this.qjO);
            intent.putExtra("has_not_same_chatroom", this.qjP);
            startActivityForResult(intent, 291);
        }
        c15541f.notifyDataSetChanged();
        AppMethodBeat.m2505o(127686);
        return true;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127687);
        super.initView();
        setMMTitle((int) C25738R.string.ecg);
        setBackBtn(new C132421());
        ((CheckPreference) this.yCw.aqO("settings_half_year_not_chat")).yBr = 0;
        ((CheckPreference) this.yCw.aqO("settings_has_not_same_chatroom")).yBr = 0;
        ((CheckPreference) this.yCw.aqO("settings_half_year_not_response")).yBr = 0;
        ((TextButtonPreference) this.yCw.aqO("settings_next_step")).setEnabled(false);
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(127687);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127688);
        if (i == 4) {
            onBackPressed();
            AppMethodBeat.m2505o(127688);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127688);
        return onKeyDown;
    }
}
