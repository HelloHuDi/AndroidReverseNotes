package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.DatePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.RadioCheckPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class BackupSelectExtUI extends MMPreference {
    private int aPA = 0;
    private f ehK;
    private long endTime = 0;
    private int jqS;
    private long jsU = 0;
    private int juK = 0;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyy.MM.dd");
    private RadioCheckPreference jyK;
    private RadioCheckPreference jyL;
    private RadioCheckPreference jyM;
    private RadioCheckPreference jyN;
    private Preference jyO;
    private Preference jyP;
    private boolean jyQ = false;
    private long startTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BackupSelectExtUI() {
        AppMethodBeat.i(17729);
        AppMethodBeat.o(17729);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17730);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.o(17730);
    }

    public final int JC() {
        return R.xml.m;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(final int i) {
        AppMethodBeat.i(17732);
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? bo.anU() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? bo.anU() : this.endTime - 86400000);
                break;
        }
        e eVar = new e(this.mController.ylL, new OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AppMethodBeat.i(17726);
                StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
                long Ff;
                BackupSelectExtUI backupSelectExtUI;
                boolean z;
                switch (i) {
                    case 1:
                        Ff = g.Ff(append.append("000000").toString());
                        BackupSelectExtUI.this.startTime = (Ff / 1000) * 1000;
                        BackupSelectExtUI.this.jyP.setSummary(BackupSelectExtUI.this.juL.format(new Date(Ff)));
                        BackupSelectExtUI.this.ehK.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        AppMethodBeat.o(17726);
                        return;
                    case 2:
                        Ff = g.Ff(append.append("000000").toString());
                        BackupSelectExtUI.this.endTime = ((Ff / 1000) * 1000) + 86400000;
                        BackupSelectExtUI.this.jyO.setSummary(BackupSelectExtUI.this.juL.format(new Date(Ff)));
                        BackupSelectExtUI.this.ehK.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        break;
                }
                AppMethodBeat.o(17726);
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        eVar.setCanceledOnTouchOutside(false);
        long anU = (((bo.anU() / 86400000) * 86400000) + 57600000) - 1;
        long j = (((this.jsU / 86400000) * 86400000) + 57600000) - 86400000;
        if (anU > j) {
            try {
                eVar.nx(j);
                eVar.nw(anU);
            } catch (Exception e) {
                ab.e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j), Long.valueOf(anU), e);
            }
        }
        AppMethodBeat.o(17732);
        return eVar;
    }

    public final void initView() {
        AppMethodBeat.i(17733);
        this.jqS = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle((int) R.string.a1k);
        this.juK = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.jyQ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.aPA = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.jsU = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        cu();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17727);
                BackupSelectExtUI.this.finish();
                AppMethodBeat.o(17727);
                return true;
            }
        });
        a(0, getString(R.string.a27), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17728);
                if (BackupSelectExtUI.this.juK != 1 || BackupSelectExtUI.this.startTime < BackupSelectExtUI.this.endTime) {
                    Intent intent = new Intent();
                    intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.this.juK);
                    intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.this.aPA);
                    intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.this.startTime);
                    intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.this.endTime);
                    BackupSelectExtUI.this.setResult(-1, intent);
                    BackupSelectExtUI.this.finish();
                    AppMethodBeat.o(17728);
                } else {
                    if (BackupSelectExtUI.this.jqS == 1) {
                        h.b(BackupSelectExtUI.this.mController.ylL, BackupSelectExtUI.this.getString(R.string.zt), "", true);
                    } else if (BackupSelectExtUI.this.jqS == 2) {
                        h.b(BackupSelectExtUI.this.mController.ylL, BackupSelectExtUI.this.getString(R.string.xq), "", true);
                    }
                    AppMethodBeat.o(17728);
                }
                return true;
            }
        }, b.GREEN);
        AppMethodBeat.o(17733);
    }

    private void aUv() {
        AppMethodBeat.i(17734);
        switch (this.juK) {
            case 0:
                this.jyK.qg(true);
                this.jyL.qg(false);
                this.ehK.d(this.jyP);
                this.ehK.d(this.jyO);
                enableOptionMenu(true);
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.o(17734);
                return;
            case 1:
                cu();
                break;
        }
        AppMethodBeat.o(17734);
    }

    private void aUw() {
        AppMethodBeat.i(17735);
        switch (this.aPA) {
            case 0:
                this.jyM.qg(true);
                this.jyN.qg(false);
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.o(17735);
                return;
            case 1:
                this.jyM.qg(false);
                this.jyN.qg(true);
                this.ehK.notifyDataSetChanged();
                break;
        }
        AppMethodBeat.o(17735);
    }

    private void cu() {
        AppMethodBeat.i(17736);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.m);
        this.jyK = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_time_all");
        this.jyL = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_time_some");
        this.jyP = this.ehK.aqO("backup_select_begin_time");
        this.jyO = this.ehK.aqO("backup_select_end_time");
        this.jyM = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_content_all_msg");
        this.jyN = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_content_text_only");
        if (!this.jyQ) {
            this.ehK.d(this.ehK.aqO("backup_select_ext_content_title"));
            this.ehK.d(this.jyM);
            this.ehK.d(this.jyN);
        }
        if (this.jqS == 1) {
            this.ehK.aqO("backup_select_ext_time_title").setTitle((int) R.string.a14);
            if (this.jyQ) {
                this.ehK.aqO("backup_select_ext_content_title").setTitle((int) R.string.a13);
            }
        } else if (this.jqS == 2) {
            this.ehK.aqO("backup_select_ext_time_title").setTitle((int) R.string.za);
            if (this.jyQ) {
                this.ehK.aqO("backup_select_ext_content_title").setTitle((int) R.string.z_);
            }
        }
        switch (this.juK) {
            case 0:
                this.jyK.qg(true);
                this.jyL.qg(false);
                this.jyP.setEnabled(false);
                this.jyO.setEnabled(false);
                this.ehK.d(this.jyP);
                this.ehK.d(this.jyO);
                enableOptionMenu(true);
                break;
            case 1:
                aUx();
                this.jyK.qg(false);
                this.jyL.qg(true);
                this.jyP.setEnabled(true);
                this.jyO.setEnabled(true);
                break;
        }
        if (this.jyQ) {
            switch (this.aPA) {
                case 0:
                    this.jyM.qg(true);
                    this.jyN.qg(false);
                    break;
                case 1:
                    this.jyM.qg(false);
                    this.jyN.qg(true);
                    break;
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(17736);
    }

    private void aUx() {
        boolean z;
        AppMethodBeat.i(17737);
        if (this.startTime == 0 || this.endTime == 0) {
            this.jyP.setSummary((int) R.string.a1n);
            this.jyO.setSummary((int) R.string.a1n);
        } else {
            this.jyP.setSummary(this.juL.format(new Date(this.startTime)));
            this.jyO.setSummary(this.juL.format(new Date(this.endTime - 86400000)));
            if (!(this.startTime == 0 || this.endTime == 0)) {
                z = true;
                enableOptionMenu(z);
                AppMethodBeat.o(17737);
            }
        }
        z = false;
        enableOptionMenu(z);
        AppMethodBeat.o(17737);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(17731);
        String str = preference.mKey;
        if (str.equals("backup_select_ext_time_all")) {
            this.juK = 0;
            aUv();
            AppMethodBeat.o(17731);
            return true;
        } else if (str.equals("backup_select_ext_time_some")) {
            this.juK = 1;
            aUv();
            AppMethodBeat.o(17731);
            return true;
        } else if (str.equals("backup_select_ext_content_all_msg")) {
            if (this.jyQ) {
                this.aPA = 0;
                aUw();
            } else {
                ab.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
            }
            AppMethodBeat.o(17731);
            return true;
        } else if (str.equals("backup_select_ext_content_text_only")) {
            if (this.jyQ) {
                this.aPA = 1;
                aUw();
            } else {
                ab.e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
            }
            AppMethodBeat.o(17731);
            return true;
        } else if (str.equals("backup_select_begin_time")) {
            showDialog(1);
            AppMethodBeat.o(17731);
            return true;
        } else if (str.equals("backup_select_end_time")) {
            showDialog(2);
            AppMethodBeat.o(17731);
            return true;
        } else {
            AppMethodBeat.o(17731);
            return false;
        }
    }
}
