package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.io.File;

@C5271a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.ui.tools.ShareScreenToTimeLineUI */
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    /* renamed from: com.tencent.mm.ui.tools.ShareScreenToTimeLineUI$1 */
    class C240391 implements C1835a {
        C240391() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34976);
        super.onCreate(bundle);
        setMMTitle("");
        int a = C5068w.m7682a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.m41396Io();
                C9638aw.m17182Rg().mo14541a(new C6668bk(new C240391()), 0);
                initView();
                AppMethodBeat.m2505o(34976);
                return;
            case 1:
                finish();
                AppMethodBeat.m2505o(34976);
                return;
            default:
                C4990ab.m7412e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.m2505o(34976);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(34977);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34977);
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34977);
            return;
        }
        String n = C5068w.m7689n(intent, C5504k.ygd);
        String resolveType = getIntent().resolveType(this);
        if (C5046bo.isNullOrNil(resolveType)) {
            dJw();
            finish();
            AppMethodBeat.m2505o(34977);
            return;
        }
        if (VERSION.SDK_INT >= 28) {
            if (!(resolveType.contains("heic") || resolveType.contains("image"))) {
                dJw();
                finish();
                AppMethodBeat.m2505o(34977);
                return;
            }
        } else if (!resolveType.contains("image")) {
            dJw();
            finish();
            AppMethodBeat.m2505o(34977);
            return;
        }
        if (action.equals("android.intent.action.VIEW")) {
            C4990ab.m7416i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(action)));
            if (C5046bo.m7585v(this.uri)) {
                this.filePath = C5046bo.m7568h(this, this.uri);
                if (C5046bo.isNullOrNil(this.filePath) || !C5046bo.anx(this.filePath)) {
                    if (C5068w.m7683a(intent, "Ksnsupload_empty_img", false)) {
                        m36998ip(this.filePath, n);
                        AppMethodBeat.m2505o(34977);
                        return;
                    }
                    dJw();
                    finish();
                    AppMethodBeat.m2505o(34977);
                    return;
                } else if (C5063r.amn(this.filePath)) {
                    m36998ip(this.filePath, n);
                    AppMethodBeat.m2505o(34977);
                    return;
                } else {
                    dJw();
                    finish();
                    AppMethodBeat.m2505o(34977);
                    return;
                }
            }
            C4990ab.m7413e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", this.uri);
            dJw();
            finish();
            AppMethodBeat.m2505o(34977);
            return;
        }
        C4990ab.m7412e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
        dJw();
        finish();
        AppMethodBeat.m2505o(34977);
    }

    /* renamed from: ip */
    private void m36998ip(String str, String str2) {
        AppMethodBeat.m2504i(34978);
        Intent intent = new Intent();
        if (!C5046bo.isNullOrNil(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            intent.putExtra(C5504k.ygd, str2);
        }
        if (C9638aw.m17192ZM() && !C9638aw.m17178QT()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            C25985d.m41467b((Context) this, "sns", ".ui.SnsUploadUI", intent);
        } else if (C5046bo.isNullOrNil(str)) {
            dJw();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
        AppMethodBeat.m2505o(34978);
    }

    private void dJw() {
        AppMethodBeat.m2504i(34979);
        Toast.makeText(this, C25738R.string.eh_, 1).show();
        AppMethodBeat.m2505o(34979);
    }
}
