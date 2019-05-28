package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18611au;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.notification.PluginNotification;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.sql.Time;
import java.text.DateFormat;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI */
public class SettingsActiveTimeUI extends MMPreference {
    private boolean csi = false;
    private C15541f ehK;
    private Preference jyO;
    private Preference jyP;
    private int qmE;
    private int qmF;
    private int qmG;
    private int qmH;
    private boolean qmI = false;
    private final OnTimeSetListener qmJ = new C348662();

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI$1 */
    class C132081 implements OnMenuItemClickListener {
        C132081() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127154);
            SettingsActiveTimeUI.this.aqX();
            SettingsActiveTimeUI.this.finish();
            AppMethodBeat.m2505o(127154);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI$2 */
    class C348662 implements OnTimeSetListener {
        C348662() {
        }

        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            AppMethodBeat.m2504i(127155);
            if (SettingsActiveTimeUI.this.qmI) {
                SettingsActiveTimeUI.this.qmE = i;
                SettingsActiveTimeUI.this.qmF = i2;
                SettingsActiveTimeUI.m57251b(SettingsActiveTimeUI.this);
            } else {
                SettingsActiveTimeUI.this.qmG = i;
                SettingsActiveTimeUI.this.qmH = i2;
                SettingsActiveTimeUI.m57254c(SettingsActiveTimeUI.this);
            }
            SettingsActiveTimeUI.this.initView();
            AppMethodBeat.m2505o(127155);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsActiveTimeUI() {
        AppMethodBeat.m2504i(127156);
        AppMethodBeat.m2505o(127156);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127157);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.e5f);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(127157);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127158);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8547bv);
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
            this.ehK.mo27716d(this.jyP);
            this.ehK.mo27716d(this.jyO);
        }
        this.ehK.mo27715ce("settings_active_time_full", true);
        this.ehK.notifyDataSetChanged();
        setBackBtn(new C132081());
        AppMethodBeat.m2505o(127158);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8547bv;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(127160);
        switch (i) {
            case 1:
                Dialog timePickerDialog;
                if (this.qmI) {
                    timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, this.qmE, this.qmF, false);
                    AppMethodBeat.m2505o(127160);
                    return timePickerDialog;
                }
                timePickerDialog = new TimePickerDialog(this.mController.ylL, this.qmJ, this.qmG, this.qmH, false);
                AppMethodBeat.m2505o(127160);
                return timePickerDialog;
            default:
                AppMethodBeat.m2505o(127160);
                return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        AppMethodBeat.m2504i(127161);
        switch (i) {
            case 1:
                if (this.qmI) {
                    ((TimePickerDialog) dialog).updateTime(this.qmE, this.qmF);
                    AppMethodBeat.m2505o(127161);
                    return;
                }
                ((TimePickerDialog) dialog).updateTime(this.qmG, this.qmH);
                AppMethodBeat.m2505o(127161);
                return;
            default:
                AppMethodBeat.m2505o(127161);
                return;
        }
    }

    /* renamed from: c */
    private static String m57253c(Context context, int i, int i2) {
        AppMethodBeat.m2504i(127162);
        String h = C4988aa.m7405h(context.getSharedPreferences(C4996ah.doA(), 0));
        String dor = C4988aa.dor();
        if (h.equalsIgnoreCase("zh_CN") || (h.equalsIgnoreCase("language_default") && "zh_CN".equalsIgnoreCase(dor))) {
            int i3;
            if (i > 12) {
                i3 = i - 12;
            } else {
                i3 = i;
            }
            h = C14835h.m23092r(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            AppMethodBeat.m2505o(127162);
            return h;
        }
        h = DateFormat.getTimeInstance(3, C4988aa.amw(h)).format(new Time(i, i2, 0));
        AppMethodBeat.m2505o(127162);
        return h;
    }

    private void ciM() {
        AppMethodBeat.m2504i(127163);
        this.jyP = this.ehK.aqO("settings_active_begin_time");
        this.qmE = C37885a.m63967MT();
        this.qmF = C37885a.m63969MV();
        this.jyP.setSummary(SettingsActiveTimeUI.m57253c(this, this.qmE, this.qmF));
        this.jyO = this.ehK.aqO("settings_active_end_time");
        this.qmG = C37885a.m63966MS();
        this.qmH = C37885a.m63968MU();
        this.jyO.setSummary(SettingsActiveTimeUI.m57253c(this, this.qmG, this.qmH));
        AppMethodBeat.m2505o(127163);
    }

    private void setActive() {
        AppMethodBeat.m2504i(127164);
        this.csi = !C37885a.m63965MR();
        ((CheckBoxPreference) this.ehK.aqO("settings_active_silence_time")).uOT = this.csi;
        AppMethodBeat.m2505o(127164);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127165);
        super.onDestroy();
        C18611au.m29048kB(2);
        AppMethodBeat.m2505o(127165);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127159);
        if (preference.mKey.equals("settings_active_begin_time")) {
            this.qmI = true;
            showDialog(1);
            AppMethodBeat.m2505o(127159);
            return true;
        } else if (preference.mKey.equals("settings_active_end_time")) {
            this.qmI = false;
            showDialog(1);
            AppMethodBeat.m2505o(127159);
            return true;
        } else if (preference.mKey.equals("settings_active_silence_time")) {
            int i;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_active_silence_time");
            C18559f.m28899bU(!checkBoxPreference.isChecked());
            PluginNotification.createActiveTimeNotification();
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            if (checkBoxPreference.isChecked()) {
                i = 1;
            } else {
                i = 2;
            }
            objArr[1] = Integer.valueOf(i);
            c7060h.mo8381e(11351, objArr);
            initView();
            AppMethodBeat.m2505o(127159);
            return true;
        } else {
            AppMethodBeat.m2505o(127159);
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m57251b(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.m2504i(127166);
        C18559f.m28898bU(settingsActiveTimeUI.qmE, settingsActiveTimeUI.qmF);
        AppMethodBeat.m2505o(127166);
    }

    /* renamed from: c */
    static /* synthetic */ void m57254c(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.m2504i(127167);
        C18559f.m28896bT(settingsActiveTimeUI.qmG, settingsActiveTimeUI.qmH);
        AppMethodBeat.m2505o(127167);
    }
}
