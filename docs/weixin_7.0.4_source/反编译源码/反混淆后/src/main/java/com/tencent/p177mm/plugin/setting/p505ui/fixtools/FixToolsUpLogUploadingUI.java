package com.tencent.p177mm.plugin.setting.p505ui.fixtools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.model.C28929a;
import com.tencent.p177mm.plugin.setting.model.C28929a.C131892;
import com.tencent.p177mm.plugin.setting.model.C28929a.C289301;
import com.tencent.p177mm.plugin.setting.model.C28929a.C3778a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI */
public class FixToolsUpLogUploadingUI extends MMWizardActivity {
    private Button ixU;
    public C3778a qjB = new C168623();
    private TextView qkk;
    private ImageView qkl;
    protected ProgressBar qkm;

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI$2 */
    class C131942 implements OnMenuItemClickListener {
        C131942() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126887);
            FixToolsUpLogUploadingUI.m26019b(FixToolsUpLogUploadingUI.this);
            AppMethodBeat.m2505o(126887);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI$3 */
    class C168623 implements C3778a {
        C168623() {
        }

        /* renamed from: Ci */
        public final void mo8450Ci(int i) {
            AppMethodBeat.m2504i(126888);
            C4990ab.m7417i("MicroMsg.FixToolsUpLogUploadingUI", "fixToolsUplogProgressCallback percent:%d", Integer.valueOf(i));
            if (i < 0) {
                C7060h.pYm.mo8378a(873, 18, 1, false);
                FixToolsUpLogUploadingUI.this.qkl.setImageResource(C1318a.fix_tools_failed);
                FixToolsUpLogUploadingUI.this.qkk.setText(C25738R.string.bvq);
                FixToolsUpLogUploadingUI.this.qkm.setVisibility(8);
                FixToolsUpLogUploadingUI.this.ixU.setVisibility(0);
                AppMethodBeat.m2505o(126888);
            } else if (i >= 100) {
                C7060h.pYm.mo8378a(873, 17, 1, false);
                FixToolsUpLogUploadingUI.this.qkl.setImageResource(C1318a.fix_tools_finish);
                FixToolsUpLogUploadingUI.this.qkk.setText(C25738R.string.bvr);
                FixToolsUpLogUploadingUI.this.qkm.setVisibility(8);
                FixToolsUpLogUploadingUI.this.ixU.setVisibility(0);
                AppMethodBeat.m2505o(126888);
            } else {
                FixToolsUpLogUploadingUI.this.qkm.setProgress(i);
                AppMethodBeat.m2505o(126888);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUpLogUploadingUI$1 */
    class C168631 implements OnClickListener {
        C168631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(126886);
            FixToolsUpLogUploadingUI.m26018a(FixToolsUpLogUploadingUI.this);
            AppMethodBeat.m2505o(126886);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FixToolsUpLogUploadingUI() {
        AppMethodBeat.m2504i(126889);
        AppMethodBeat.m2505o(126889);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126890);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            AppMethodBeat.m2505o(126890);
            return;
        }
        setMMTitle((int) C25738R.string.bvo);
        this.qkk = (TextView) findViewById(2131824069);
        this.qkl = (ImageView) findViewById(2131824068);
        this.ixU = (Button) findViewById(2131824071);
        this.qkm = (ProgressBar) findViewById(2131824070);
        this.qkl.setImageResource(C1318a.fix_tools_uplog);
        this.qkk.setText(C25738R.string.bvu);
        this.ixU.setOnClickListener(new C168631());
        setBackBtn(new C131942());
        this.qkm.setVisibility(0);
        this.ixU.setVisibility(8);
        String stringExtra = getIntent().getStringExtra(FFmpegMetadataRetriever.METADATA_KEY_DATE);
        C28929a cir = C28929a.cir();
        C28929a.qjB = this.qjB;
        C4990ab.m7417i("MicroMsg.FixToolsUplogModel", "startUplog, date:%s, isUploading:%b", stringExtra, Boolean.valueOf(cir.fPO));
        if (!cir.fPO) {
            cir.fPO = true;
            String str = "weixin";
            if (C1720g.m3531RK()) {
                str = C1853r.m3846Yz();
            }
            C4990ab.m7417i("MicroMsg.FixToolsUplogModel", "startNewUplog, chooseTime:%d, time:%d", Long.valueOf(C28929a.m45955Ff(new StringBuffer(stringExtra).append("000000").toString())), Integer.valueOf((int) ((((((C5046bo.anU() / 86400000) * 86400000) + 57600000) - 1) - C28929a.m45955Ff(new StringBuffer(stringExtra).append("000000").toString())) / 86400000)));
            C1720g.m3540Rg().mo14541a(new C6668bk(new C289301(str, r1)), 0);
            C1682b.m3429a(new C131892());
        }
        AppMethodBeat.m2505o(126890);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(126891);
        if (i == 4) {
            mo27541Ni(1);
            AppMethodBeat.m2505o(126891);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(126891);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130969568;
    }

    /* renamed from: a */
    static /* synthetic */ void m26018a(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
        AppMethodBeat.m2504i(126892);
        fixToolsUpLogUploadingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(126892);
    }

    /* renamed from: b */
    static /* synthetic */ void m26019b(FixToolsUpLogUploadingUI fixToolsUpLogUploadingUI) {
        AppMethodBeat.m2504i(126893);
        fixToolsUpLogUploadingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(126893);
    }
}
