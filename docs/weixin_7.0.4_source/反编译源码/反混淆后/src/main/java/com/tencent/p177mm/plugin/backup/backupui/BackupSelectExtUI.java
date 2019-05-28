package com.tencent.p177mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.DatePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.RadioCheckPreference;
import com.tencent.p177mm.p612ui.widget.C30801e;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI */
public class BackupSelectExtUI extends MMPreference {
    private int aPA = 0;
    private C15541f ehK;
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

    /* renamed from: com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI$2 */
    class C26422 implements OnMenuItemClickListener {
        C26422() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17727);
            BackupSelectExtUI.this.finish();
            AppMethodBeat.m2505o(17727);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backupui.BackupSelectExtUI$3 */
    class C111033 implements OnMenuItemClickListener {
        C111033() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17728);
            if (BackupSelectExtUI.this.juK != 1 || BackupSelectExtUI.this.startTime < BackupSelectExtUI.this.endTime) {
                Intent intent = new Intent();
                intent.putExtra("BACKUP_SELECT_TIME_MODE", BackupSelectExtUI.this.juK);
                intent.putExtra("BACKUP_SELECT_CONTENT_TYPE", BackupSelectExtUI.this.aPA);
                intent.putExtra("BACKUP_SELECT_TIME_START_TIME", BackupSelectExtUI.this.startTime);
                intent.putExtra("BACKUP_SELECT_TIME_END_TIME", BackupSelectExtUI.this.endTime);
                BackupSelectExtUI.this.setResult(-1, intent);
                BackupSelectExtUI.this.finish();
                AppMethodBeat.m2505o(17728);
            } else {
                if (BackupSelectExtUI.this.jqS == 1) {
                    C30379h.m48461b(BackupSelectExtUI.this.mController.ylL, BackupSelectExtUI.this.getString(C25738R.string.f9431zt), "", true);
                } else if (BackupSelectExtUI.this.jqS == 2) {
                    C30379h.m48461b(BackupSelectExtUI.this.mController.ylL, BackupSelectExtUI.this.getString(C25738R.string.f9359xq), "", true);
                }
                AppMethodBeat.m2505o(17728);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BackupSelectExtUI() {
        AppMethodBeat.m2504i(17729);
        AppMethodBeat.m2505o(17729);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17730);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        initView();
        AppMethodBeat.m2505o(17730);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8473m;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(final int i) {
        AppMethodBeat.m2504i(17732);
        Calendar instance = Calendar.getInstance();
        switch (i) {
            case 1:
                instance.setTimeInMillis(this.startTime == 0 ? C5046bo.anU() : this.startTime);
                break;
            case 2:
                instance.setTimeInMillis(this.endTime == 0 ? C5046bo.anU() : this.endTime - 86400000);
                break;
        }
        C30801e c30801e = new C30801e(this.mController.ylL, new OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AppMethodBeat.m2504i(17726);
                StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
                long Ff;
                BackupSelectExtUI backupSelectExtUI;
                boolean z;
                switch (i) {
                    case 1:
                        Ff = C38635g.m65508Ff(append.append("000000").toString());
                        BackupSelectExtUI.this.startTime = (Ff / 1000) * 1000;
                        BackupSelectExtUI.this.jyP.setSummary(BackupSelectExtUI.this.juL.format(new Date(Ff)));
                        BackupSelectExtUI.this.ehK.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        AppMethodBeat.m2505o(17726);
                        return;
                    case 2:
                        Ff = C38635g.m65508Ff(append.append("000000").toString());
                        BackupSelectExtUI.this.endTime = ((Ff / 1000) * 1000) + 86400000;
                        BackupSelectExtUI.this.jyO.setSummary(BackupSelectExtUI.this.juL.format(new Date(Ff)));
                        BackupSelectExtUI.this.ehK.notifyDataSetChanged();
                        backupSelectExtUI = BackupSelectExtUI.this;
                        z = (BackupSelectExtUI.this.startTime == 0 || BackupSelectExtUI.this.endTime == 0) ? false : true;
                        backupSelectExtUI.enableOptionMenu(z);
                        break;
                }
                AppMethodBeat.m2505o(17726);
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        c30801e.setCanceledOnTouchOutside(false);
        long anU = (((C5046bo.anU() / 86400000) * 86400000) + 57600000) - 1;
        long j = (((this.jsU / 86400000) * 86400000) + 57600000) - 86400000;
        if (anU > j) {
            try {
                c30801e.mo49242nx(j);
                c30801e.mo49241nw(anU);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BackupSelectExtUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j), Long.valueOf(anU), e);
            }
        }
        AppMethodBeat.m2505o(17732);
        return c30801e;
    }

    public final void initView() {
        AppMethodBeat.m2504i(17733);
        this.jqS = getIntent().getIntExtra("BACKUP_MODE", 0);
        setMMTitle((int) C25738R.string.a1k);
        this.juK = getIntent().getIntExtra("BACKUP_SELECT_TIME_MODE", 0);
        this.jyQ = getIntent().getBooleanExtra("BACKUP_SELECT_SUPPORT_CONTENT_TYPE", false);
        this.aPA = getIntent().getIntExtra("BACKUP_SELECT_CONTENT_TYPE", 0);
        this.startTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_START_TIME", 0);
        this.endTime = getIntent().getLongExtra("BACKUP_SELECT_TIME_END_TIME", 0);
        this.jsU = getIntent().getLongExtra("BACKUP_SELECT_TIME_MIN_CONVERSATION_TIME", 0);
        m18805cu();
        setBackBtn(new C26422());
        mo17379a(0, getString(C25738R.string.a27), (OnMenuItemClickListener) new C111033(), C5535b.GREEN);
        AppMethodBeat.m2505o(17733);
    }

    private void aUv() {
        AppMethodBeat.m2504i(17734);
        switch (this.juK) {
            case 0:
                this.jyK.mo41847qg(true);
                this.jyL.mo41847qg(false);
                this.ehK.mo27716d(this.jyP);
                this.ehK.mo27716d(this.jyO);
                enableOptionMenu(true);
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.m2505o(17734);
                return;
            case 1:
                m18805cu();
                break;
        }
        AppMethodBeat.m2505o(17734);
    }

    private void aUw() {
        AppMethodBeat.m2504i(17735);
        switch (this.aPA) {
            case 0:
                this.jyM.mo41847qg(true);
                this.jyN.mo41847qg(false);
                this.ehK.notifyDataSetChanged();
                AppMethodBeat.m2505o(17735);
                return;
            case 1:
                this.jyM.mo41847qg(false);
                this.jyN.mo41847qg(true);
                this.ehK.notifyDataSetChanged();
                break;
        }
        AppMethodBeat.m2505o(17735);
    }

    /* renamed from: cu */
    private void m18805cu() {
        AppMethodBeat.m2504i(17736);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8473m);
        this.jyK = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_time_all");
        this.jyL = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_time_some");
        this.jyP = this.ehK.aqO("backup_select_begin_time");
        this.jyO = this.ehK.aqO("backup_select_end_time");
        this.jyM = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_content_all_msg");
        this.jyN = (RadioCheckPreference) this.ehK.aqO("backup_select_ext_content_text_only");
        if (!this.jyQ) {
            this.ehK.mo27716d(this.ehK.aqO("backup_select_ext_content_title"));
            this.ehK.mo27716d(this.jyM);
            this.ehK.mo27716d(this.jyN);
        }
        if (this.jqS == 1) {
            this.ehK.aqO("backup_select_ext_time_title").setTitle((int) C25738R.string.a14);
            if (this.jyQ) {
                this.ehK.aqO("backup_select_ext_content_title").setTitle((int) C25738R.string.a13);
            }
        } else if (this.jqS == 2) {
            this.ehK.aqO("backup_select_ext_time_title").setTitle((int) C25738R.string.f9416za);
            if (this.jyQ) {
                this.ehK.aqO("backup_select_ext_content_title").setTitle((int) C25738R.string.f9415z_);
            }
        }
        switch (this.juK) {
            case 0:
                this.jyK.mo41847qg(true);
                this.jyL.mo41847qg(false);
                this.jyP.setEnabled(false);
                this.jyO.setEnabled(false);
                this.ehK.mo27716d(this.jyP);
                this.ehK.mo27716d(this.jyO);
                enableOptionMenu(true);
                break;
            case 1:
                aUx();
                this.jyK.mo41847qg(false);
                this.jyL.mo41847qg(true);
                this.jyP.setEnabled(true);
                this.jyO.setEnabled(true);
                break;
        }
        if (this.jyQ) {
            switch (this.aPA) {
                case 0:
                    this.jyM.mo41847qg(true);
                    this.jyN.mo41847qg(false);
                    break;
                case 1:
                    this.jyM.mo41847qg(false);
                    this.jyN.mo41847qg(true);
                    break;
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(17736);
    }

    private void aUx() {
        boolean z;
        AppMethodBeat.m2504i(17737);
        if (this.startTime == 0 || this.endTime == 0) {
            this.jyP.setSummary((int) C25738R.string.a1n);
            this.jyO.setSummary((int) C25738R.string.a1n);
        } else {
            this.jyP.setSummary(this.juL.format(new Date(this.startTime)));
            this.jyO.setSummary(this.juL.format(new Date(this.endTime - 86400000)));
            if (!(this.startTime == 0 || this.endTime == 0)) {
                z = true;
                enableOptionMenu(z);
                AppMethodBeat.m2505o(17737);
            }
        }
        z = false;
        enableOptionMenu(z);
        AppMethodBeat.m2505o(17737);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(17731);
        String str = preference.mKey;
        if (str.equals("backup_select_ext_time_all")) {
            this.juK = 0;
            aUv();
            AppMethodBeat.m2505o(17731);
            return true;
        } else if (str.equals("backup_select_ext_time_some")) {
            this.juK = 1;
            aUv();
            AppMethodBeat.m2505o(17731);
            return true;
        } else if (str.equals("backup_select_ext_content_all_msg")) {
            if (this.jyQ) {
                this.aPA = 0;
                aUw();
            } else {
                C4990ab.m7412e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content all msg, but not support content type");
            }
            AppMethodBeat.m2505o(17731);
            return true;
        } else if (str.equals("backup_select_ext_content_text_only")) {
            if (this.jyQ) {
                this.aPA = 1;
                aUw();
            } else {
                C4990ab.m7412e("MicroMsg.BackupSelectExtUI", "onPreferenceTreeClick select ext content text only, but not support content type");
            }
            AppMethodBeat.m2505o(17731);
            return true;
        } else if (str.equals("backup_select_begin_time")) {
            showDialog(1);
            AppMethodBeat.m2505o(17731);
            return true;
        } else if (str.equals("backup_select_end_time")) {
            showDialog(2);
            AppMethodBeat.m2505o(17731);
            return true;
        } else {
            AppMethodBeat.m2505o(17731);
            return false;
        }
    }
}
