package com.tencent.p177mm.plugin.setting.p505ui.fixtools;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.C30801e;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI */
public class FixToolsUplogUI extends MMWizardActivity {
    private static String qkq;
    private LinearLayout juE;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyyMMdd");
    private Button qko;
    private TextView qkp;
    private SimpleDateFormat qkr = new SimpleDateFormat("yyyy.MM.dd");

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI$2 */
    class C217402 implements OnClickListener {
        C217402() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126895);
            C7060h.pYm.mo8378a(873, 16, 1, false);
            Intent intent = new Intent(FixToolsUplogUI.this.mController.ylL, FixToolsUpLogUploadingUI.class);
            intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE, FixToolsUplogUI.qkq);
            MMWizardActivity.m23791J(FixToolsUplogUI.this, intent);
            AppMethodBeat.m2505o(126895);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI$3 */
    class C348503 implements OnClickListener {
        C348503() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126896);
            FixToolsUplogUI.this.showDialog(1);
            AppMethodBeat.m2505o(126896);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI$4 */
    class C348514 implements OnMenuItemClickListener {
        C348514() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126897);
            FixToolsUplogUI.this.finish();
            AppMethodBeat.m2505o(126897);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FixToolsUplogUI() {
        AppMethodBeat.m2504i(126898);
        AppMethodBeat.m2505o(126898);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126899);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(126899);
            return;
        }
        C7060h.pYm.mo8378a(873, (long) getIntent().getIntExtra("entry_fix_tools_uplog", 5), 1, false);
        C7060h.pYm.mo8378a(873, 8, 1, false);
        initView();
        AppMethodBeat.m2505o(126899);
    }

    public final int getLayoutId() {
        return 2130969567;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(final int i) {
        AppMethodBeat.m2504i(126900);
        Calendar instance = Calendar.getInstance();
        long anU = C5046bo.anU();
        instance.setTimeInMillis(anU);
        final long j = (((anU / 86400000) * 86400000) + 57600000) - 1;
        long j2 = (((anU / 86400000) * 86400000) + 57600000) - 864000000;
        C30801e c30801e = new C30801e(this.mController.ylL, new OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AppMethodBeat.m2504i(126894);
                switch (i) {
                    case 1:
                        FixToolsUplogUI.this.qkp.setText(new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i3)})));
                        FixToolsUplogUI.qkq = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)})).toString();
                        C4990ab.m7417i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", Long.valueOf(j), FixToolsUplogUI.qkq);
                        break;
                }
                AppMethodBeat.m2505o(126894);
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        c30801e.setCanceledOnTouchOutside(false);
        try {
            c30801e.mo49242nx(j2 > 0 ? j2 : 0);
            c30801e.mo49241nw(j);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j2), Long.valueOf(j), e);
        }
        AppMethodBeat.m2505o(126900);
        return c30801e;
    }

    public final void initView() {
        AppMethodBeat.m2504i(126901);
        setMMTitle((int) C25738R.string.bvo);
        this.qko = (Button) findViewById(2131824067);
        this.juE = (LinearLayout) findViewById(2131824064);
        this.qkp = (TextView) findViewById(2131824066);
        this.qkp.setText(this.qkr.format(new Date()));
        qkq = this.juL.format(new Date());
        this.qko.setOnClickListener(new C217402());
        this.juE.setOnClickListener(new C348503());
        setBackBtn(new C348514());
        AppMethodBeat.m2505o(126901);
    }
}
