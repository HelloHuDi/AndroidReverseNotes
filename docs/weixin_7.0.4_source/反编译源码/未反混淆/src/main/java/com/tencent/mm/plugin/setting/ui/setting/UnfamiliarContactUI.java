package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI extends MMPreference {
    private boolean qjN;
    private boolean qjO;
    private boolean qjP;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127685);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127685);
    }

    public final int JC() {
        return R.xml.c_;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127686);
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
            TextButtonPreference textButtonPreference = (TextButtonPreference) fVar.aqO("settings_next_step");
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
        fVar.notifyDataSetChanged();
        AppMethodBeat.o(127686);
        return true;
    }

    public final void initView() {
        AppMethodBeat.i(127687);
        super.initView();
        setMMTitle((int) R.string.ecg);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127684);
                UnfamiliarContactUI.this.finish();
                AppMethodBeat.o(127684);
                return true;
            }
        });
        ((CheckPreference) this.yCw.aqO("settings_half_year_not_chat")).yBr = 0;
        ((CheckPreference) this.yCw.aqO("settings_has_not_same_chatroom")).yBr = 0;
        ((CheckPreference) this.yCw.aqO("settings_half_year_not_response")).yBr = 0;
        ((TextButtonPreference) this.yCw.aqO("settings_next_step")).setEnabled(false);
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.o(127687);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127688);
        if (i == 4) {
            onBackPressed();
            AppMethodBeat.o(127688);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127688);
        return onKeyDown;
    }
}
