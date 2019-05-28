package com.tencent.mm.plugin.setting.ui.fixtools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FixToolsUpLogUploadingUI extends MMWizardActivity {
    private Button ixU;
    public com.tencent.mm.plugin.setting.model.a.a qjB = new com.tencent.mm.plugin.setting.model.a.a() {
        public final void Ci(int i) {
            AppMethodBeat.i(126888);
            ab.i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", Integer.valueOf(i));
            if (i < 0) {
                h.pYm.a(873, 18, 1, false);
                FixToolsUpLogUploadingUI.this.qkl.setImageResource(R.raw.fix_tools_failed);
                FixToolsUpLogUploadingUI.this.qkk.setText(R.string.bvq);
                FixToolsUpLogUploadingUI.this.qkm.setVisibility(8);
                FixToolsUpLogUploadingUI.this.ixU.setVisibility(0);
                AppMethodBeat.o(126888);
            } else if (i >= 100) {
                h.pYm.a(873, 17, 1, false);
                FixToolsUpLogUploadingUI.this.qkl.setImageResource(R.raw.fix_tools_finish);
                FixToolsUpLogUploadingUI.this.qkk.setText(R.string.bvr);
                FixToolsUpLogUploadingUI.this.qkm.setVisibility(8);
                FixToolsUpLogUploadingUI.this.ixU.setVisibility(0);
                AppMethodBeat.o(126888);
            } else {
                FixToolsUpLogUploadingUI.this.qkm.setProgress(i);
                AppMethodBeat.o(126888);
            }
        }
    };
    private TextView qkk;
    private ImageView qkl;
    protected ProgressBar qkm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FixToolsUpLogUploadingUI() {
        AppMethodBeat.i(126889);
        AppMethodBeat.o(126889);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126890);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.o(126890);
            return;
        }
        setMMTitle((int) R.string.bvo);
        this.qkk = (TextView) findViewById(R.id.bu_);
        this.qkl = (ImageView) findViewById(R.id.bu9);
        this.ixU = (Button) findViewById(R.id.bub);
        this.qkm = (ProgressBar) findViewById(R.id.bua);
        this.qkl.setImageResource(R.raw.fix_tools_uplog);
        this.qkk.setText(R.string.bvu);
        this.ixU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126886);
                FixToolsUpLogUploadingUI.a(FixToolsUpLogUploadingUI.this);
                AppMethodBeat.o(126886);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126887);
                FixToolsUpLogUploadingUI.b(FixToolsUpLogUploadingUI.this);
                AppMethodBeat.o(126887);
                return true;
            }
        });
        this.qkm.setVisibility(0);
        this.ixU.setVisibility(8);
        String stringExtra = getIntent().getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE);
        com.tencent.mm.plugin.setting.model.a cir = com.tencent.mm.plugin.setting.model.a.cir();
        com.tencent.mm.plugin.setting.model.a.qjB = this.qjB;
        ab.i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", stringExtra, Boolean.valueOf(cir.fPO));
        if (!cir.fPO) {
            cir.fPO = true;
            String str = "weixin";
            if (g.RK()) {
                str = r.Yz();
            }
            ab.i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", Long.valueOf(com.tencent.mm.plugin.setting.model.a.Ff(new StringBuffer(stringExtra).append("000000").toString())), Integer.valueOf((int) ((((((bo.anU() / 86400000) * 86400000) + 57600000) - 1) - com.tencent.mm.plugin.setting.model.a.Ff(new StringBuffer(stringExtra).append("000000").toString())) / 86400000)));
            g.Rg().a(new bk(new com.tencent.mm.plugin.setting.model.a.AnonymousClass1(str, r1)), 0);
            b.a(new al() {
                public final void kx(int i) {
                    AppMethodBeat.i(126837);
                    if (i < 0 || i >= 100) {
                        b.a(null);
                        a.this.fPO = false;
                    }
                    ab.d("MicroMsg.FixToolsUplogModel", "ipxx progress:%d, isUploading:%b", Integer.valueOf(i), Boolean.valueOf(a.this.fPO));
                    a.qjB.Ci(i);
                    AppMethodBeat.o(126837);
                }
            });
        }
        AppMethodBeat.o(126890);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(126891);
        if (i == 4) {
            Ni(1);
            AppMethodBeat.o(126891);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(126891);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.a00;
    }

    static /* synthetic */ void a(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
        AppMethodBeat.i(126892);
        fixToolsUpLogUploadingUI.Ni(1);
        AppMethodBeat.o(126892);
    }

    static /* synthetic */ void b(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
        AppMethodBeat.i(126893);
        fixToolsUpLogUploadingUI.Ni(1);
        AppMethodBeat.o(126893);
    }
}
