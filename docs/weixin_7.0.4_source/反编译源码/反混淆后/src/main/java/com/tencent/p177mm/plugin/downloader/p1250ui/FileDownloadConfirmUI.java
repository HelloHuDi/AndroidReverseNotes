package com.tencent.p177mm.plugin.downloader.p1250ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI */
public class FileDownloadConfirmUI extends MMBaseActivity {
    private C5653c ggF = null;

    /* renamed from: com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI$2 */
    class C203282 implements OnClickListener {
        C203282() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI$3 */
    class C203303 implements OnDismissListener {
        C203303() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(2517);
            FileDownloadConfirmUI.this.finish();
            AppMethodBeat.m2505o(2517);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(2518);
        super.onCreate(bundle);
        setContentView(2130969389);
        if (C1443d.m3068iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        OnClickListener c203291 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(2516);
                C2896d.bij().mo7047hl(longExtra);
                C4990ab.m7417i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", Long.valueOf(longExtra));
                AppMethodBeat.m2505o(2516);
            }
        };
        OnClickListener c203282 = new C203282();
        OnDismissListener c203303 = new C203303();
        C5652a c5652a = new C5652a(this);
        c5652a.asD("");
        c5652a.mo11450PZ(C25738R.string.bsm);
        c5652a.mo11453Qc(C25738R.string.f9262up).mo11457a(c203291);
        c5652a.mo11454Qd(C25738R.string.f9183s2).mo11476b(c203282);
        c5652a.mo11458a(c203303);
        this.ggF = c5652a.aMb();
        this.ggF.show();
        C4990ab.m7416i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
        AppMethodBeat.m2505o(2518);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(2519);
        C4990ab.m7416i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
        AppMethodBeat.m2505o(2519);
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        AppMethodBeat.m2504i(2520);
        super.onStop();
        this.ggF.dismiss();
        AppMethodBeat.m2505o(2520);
    }
}
