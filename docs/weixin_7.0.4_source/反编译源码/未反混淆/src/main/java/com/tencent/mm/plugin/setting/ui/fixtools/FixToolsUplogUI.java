package com.tencent.mm.plugin.setting.ui.fixtools;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI extends MMWizardActivity {
    private static String qkq;
    private LinearLayout juE;
    private SimpleDateFormat juL = new SimpleDateFormat("yyyyMMdd");
    private Button qko;
    private TextView qkp;
    private SimpleDateFormat qkr = new SimpleDateFormat("yyyy.MM.dd");

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FixToolsUplogUI() {
        AppMethodBeat.i(126898);
        AppMethodBeat.o(126898);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126899);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(126899);
            return;
        }
        h.pYm.a(873, (long) getIntent().getIntExtra("entry_fix_tools_uplog", 5), 1, false);
        h.pYm.a(873, 8, 1, false);
        initView();
        AppMethodBeat.o(126899);
    }

    public final int getLayoutId() {
        return R.layout.zz;
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(final int i) {
        AppMethodBeat.i(126900);
        Calendar instance = Calendar.getInstance();
        long anU = bo.anU();
        instance.setTimeInMillis(anU);
        final long j = (((anU / 86400000) * 86400000) + 57600000) - 1;
        long j2 = (((anU / 86400000) * 86400000) + 57600000) - 864000000;
        e eVar = new e(this.mController.ylL, new OnDateSetListener() {
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AppMethodBeat.i(126894);
                switch (i) {
                    case 1:
                        FixToolsUplogUI.this.qkp.setText(new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(".").append(String.format("%02d", new Object[]{Integer.valueOf(i3)})));
                        FixToolsUplogUI.qkq = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)})).toString();
                        ab.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", Long.valueOf(j), FixToolsUplogUI.qkq);
                        break;
                }
                AppMethodBeat.o(126894);
            }
        }, instance.get(1), instance.get(2), instance.get(5), instance.getTimeInMillis(), (byte) 0);
        eVar.setCanceledOnTouchOutside(false);
        try {
            eVar.nx(j2 > 0 ? j2 : 0);
            eVar.nw(j);
        } catch (Exception e) {
            ab.e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", Long.valueOf(j2), Long.valueOf(j), e);
        }
        AppMethodBeat.o(126900);
        return eVar;
    }

    public final void initView() {
        AppMethodBeat.i(126901);
        setMMTitle((int) R.string.bvo);
        this.qko = (Button) findViewById(R.id.bu8);
        this.juE = (LinearLayout) findViewById(R.id.bu5);
        this.qkp = (TextView) findViewById(R.id.bu7);
        this.qkp.setText(this.qkr.format(new Date()));
        qkq = this.juL.format(new Date());
        this.qko.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126895);
                h.pYm.a(873, 16, 1, false);
                Intent intent = new Intent(FixToolsUplogUI.this.mController.ylL, FixToolsUpLogUploadingUI.class);
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE, FixToolsUplogUI.qkq);
                MMWizardActivity.J(FixToolsUplogUI.this, intent);
                AppMethodBeat.o(126895);
            }
        });
        this.juE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126896);
                FixToolsUplogUI.this.showDialog(1);
                AppMethodBeat.o(126896);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126897);
                FixToolsUplogUI.this.finish();
                AppMethodBeat.o(126897);
                return true;
            }
        });
        AppMethodBeat.o(126901);
    }
}
