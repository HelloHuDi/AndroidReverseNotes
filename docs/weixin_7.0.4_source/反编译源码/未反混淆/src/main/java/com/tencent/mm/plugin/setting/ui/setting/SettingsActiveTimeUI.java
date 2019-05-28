package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean csi = false;
    private f ehK;
    private Preference jyO;
    private Preference jyP;
    private int qmE;
    private int qmF;
    private int qmG;
    private int qmH;
    private boolean qmI = false;
    private final OnTimeSetListener qmJ = new OnTimeSetListener() {
        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            AppMethodBeat.i(127155);
            if (SettingsActiveTimeUI.this.qmI) {
                SettingsActiveTimeUI.this.qmE = i;
                SettingsActiveTimeUI.this.qmF = i2;
                SettingsActiveTimeUI.b(SettingsActiveTimeUI.this);
            } else {
                SettingsActiveTimeUI.this.qmG = i;
                SettingsActiveTimeUI.this.qmH = i2;
                SettingsActiveTimeUI.c(SettingsActiveTimeUI.this);
            }
            SettingsActiveTimeUI.this.initView();
            AppMethodBeat.o(127155);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsActiveTimeUI() {
        AppMethodBeat.i(127156);
        AppMethodBeat.o(127156);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127157);
        super.onCreate(bundle);
        setMMTitle((int) R.string.e5f);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(127157);
    }

    public final void initView() {
        AppMethodBeat.i(127158);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.bv);
        ciM();
        setActive();
        if (this.csi) {
            this.jyP.setEnabled(true);
            this.jyO.setEnabled(true);
        } else {
            this.jyP.setEnabled(false);
            this.jyO.setEnabled(false);
        }
        if (!this.csi) {
            this.ehK.d(this.jyP);
            this.ehK.d(this.jyO);
        }
        this.ehK.ce("settings_active_time_full", true);
        this.ehK.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127154);
                SettingsActiveTimeUI.this.aqX();
                SettingsActiveTimeUI.this.finish();
                AppMethodBeat.o(127154);
                return true;
            }
        });
        AppMethodBeat.o(127158);
    }

    public final int JC() {
        return R.xml.bv;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(127160);
        switch (i) {
            case 1:
                Dialog timePickerDialog;
                if (this.qmI) {
                    timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, this.qmE, this.qmF, false);
                    AppMethodBeat.o(127160);
                    return timePickerDialog;
                }
                timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, this.qmG, this.qmH, false);
                AppMethodBeat.o(127160);
                return timePickerDialog;
            default:
                AppMethodBeat.o(127160);
                return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        AppMethodBeat.i(127161);
        switch (i) {
            case 1:
                if (this.qmI) {
                    ((TimePickerDialog) dialog).updateTime(this.qmE, this.qmF);
                    AppMethodBeat.o(127161);
                    return;
                }
                ((TimePickerDialog) dialog).updateTime(this.qmG, this.qmH);
                AppMethodBeat.o(127161);
                return;
            default:
                AppMethodBeat.o(127161);
                return;
        }
    }

    private static String c(Context context, int i, int i2) {
        AppMethodBeat.i(127162);
        String h = aa.h(context.getSharedPreferences(ah.doA(), 0));
        String dor = aa.dor();
        if (h.equalsIgnoreCase("zh_CN") || (h.equalsIgnoreCase("language_default") && "zh_CN".equalsIgnoreCase(dor))) {
            int i3;
            if (i > 12) {
                i3 = i - 12;
            } else {
                i3 = i;
            }
            h = h.r(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            AppMethodBeat.o(127162);
            return h;
        }
        h = DateFormat.getTimeInstance(3, aa.amw(h)).format(new Time(i, i2, 0));
        AppMethodBeat.o(127162);
        return h;
    }

    private void ciM() {
        AppMethodBeat.i(127163);
        this.jyP = this.ehK.aqO("settings_active_begin_time");
        this.qmE = a.MT();
        this.qmF = a.MV();
        this.jyP.setSummary(c(this, this.qmE, this.qmF));
        this.jyO = this.ehK.aqO("settings_active_end_time");
        this.qmG = a.MS();
        this.qmH = a.MU();
        this.jyO.setSummary(c(this, this.qmG, this.qmH));
        AppMethodBeat.o(127163);
    }

    private void setActive() {
        AppMethodBeat.i(127164);
        this.csi = !a.MR();
        ((CheckBoxPreference) this.ehK.aqO("settings_active_silence_time")).uOT = this.csi;
        AppMethodBeat.o(127164);
    }

    public void onDestroy() {
        AppMethodBeat.i(127165);
        super.onDestroy();
        au.kB(2);
        AppMethodBeat.o(127165);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127159);
        if (preference.mKey.equals("settings_active_begin_time")) {
            this.qmI = true;
            showDialog(1);
            AppMethodBeat.o(127159);
            return true;
        } else if (preference.mKey.equals("settings_active_end_time")) {
            this.qmI = false;
            showDialog(1);
            AppMethodBeat.o(127159);
            return true;
        } else if (preference.mKey.equals("settings_active_silence_time")) {
            int i;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_active_silence_time");
            com.tencent.mm.m.f.bU(!checkBoxPreference.isChecked());
            PluginNotification.createActiveTimeNotification();
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            if (checkBoxPreference.isChecked()) {
                i = 1;
            } else {
                i = 2;
            }
            objArr[1] = Integer.valueOf(i);
            hVar.e(11351, objArr);
            initView();
            AppMethodBeat.o(127159);
            return true;
        } else {
            AppMethodBeat.o(127159);
            return false;
        }
    }

    static /* synthetic */ void b(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.i(127166);
        com.tencent.mm.m.f.bU(settingsActiveTimeUI.qmE, settingsActiveTimeUI.qmF);
        AppMethodBeat.o(127166);
    }

    static /* synthetic */ void c(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.i(127167);
        com.tencent.mm.m.f.bT(settingsActiveTimeUI.qmG, settingsActiveTimeUI.qmH);
        AppMethodBeat.o(127167);
    }
}
