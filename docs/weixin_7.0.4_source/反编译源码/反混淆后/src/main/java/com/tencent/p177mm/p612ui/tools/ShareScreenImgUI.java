package com.tencent.p177mm.p612ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;

@C5271a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.ui.tools.ShareScreenImgUI */
public class ShareScreenImgUI extends MMActivity {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private C7306ak handler = new C240371();
    private Intent intent = null;
    Uri uri = null;

    /* renamed from: com.tencent.mm.ui.tools.ShareScreenImgUI$1 */
    class C240371 extends C7306ak {
        C240371() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34966);
            ShareScreenImgUI.m59818a(ShareScreenImgUI.this);
            if (C5046bo.isNullOrNil(ShareScreenImgUI.this.filePath)) {
                C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                ShareScreenImgUI.m59819b(ShareScreenImgUI.this);
                ShareScreenImgUI.this.finish();
                AppMethodBeat.m2505o(34966);
                return;
            }
            ShareScreenImgUI.m59820c(ShareScreenImgUI.this);
            AppMethodBeat.m2505o(34966);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareScreenImgUI$2 */
    class C240382 implements OnCancelListener {
        C240382() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShareScreenImgUI() {
        AppMethodBeat.m2504i(34967);
        AppMethodBeat.m2505o(34967);
    }

    /* renamed from: c */
    static /* synthetic */ void m59820c(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.m2504i(34975);
        shareScreenImgUI.dJW();
        AppMethodBeat.m2505o(34975);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34968);
        super.onCreate(bundle);
        setMMTitle("");
        int a = C5068w.m7682a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.m41396Io();
                initView();
                AppMethodBeat.m2505o(34968);
                return;
            case 1:
                finish();
                AppMethodBeat.m2505o(34968);
                return;
            default:
                C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.m2505o(34968);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    private void dJW() {
        AppMethodBeat.m2504i(34970);
        C4990ab.m7417i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", this.filePath);
        Intent intent = getIntent();
        int asc = ShareScreenImgUI.asc(intent.resolveType(this));
        if (asc == -1) {
            C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            AppMethodBeat.m2505o(34970);
            return;
        }
        if (!C5068w.m7683a(getIntent(), "Intro_Switch", false) && C9638aw.m17192ZM() && !C9638aw.m17178QT()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", asc);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (C5046bo.isNullOrNil(this.filePath)) {
            dJX();
        } else {
            intent = new Intent(this, ShareImgUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.addFlags(67108864);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
        AppMethodBeat.m2505o(34970);
    }

    private static int asc(String str) {
        AppMethodBeat.m2504i(34971);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            AppMethodBeat.m2505o(34971);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || (VERSION.SDK_INT >= 28 && toLowerCase.contains("heic"))) {
            AppMethodBeat.m2505o(34971);
            return 0;
        }
        C4990ab.m7410d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
        AppMethodBeat.m2505o(34971);
        return 3;
    }

    private void dJX() {
        AppMethodBeat.m2504i(34972);
        Toast.makeText(this, C25738R.string.eh8, 1).show();
        AppMethodBeat.m2505o(34972);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34969);
        this.intent = getIntent();
        if (this.intent == null) {
            C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            dJX();
            finish();
            AppMethodBeat.m2505o(34969);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            dJX();
            finish();
            AppMethodBeat.m2505o(34969);
        } else if (action.equals("android.intent.action.VIEW")) {
            C4990ab.m7416i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null || !C5046bo.m7585v(this.uri)) {
                C4990ab.m7413e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", this.uri);
                dJX();
                finish();
                AppMethodBeat.m2505o(34969);
                return;
            }
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C240382());
            this.filePath = C5046bo.m7568h(this, this.uri);
            if (C5046bo.isNullOrNil(this.filePath) || !C5063r.amn(this.filePath)) {
                C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                dJX();
                finish();
                AppMethodBeat.m2505o(34969);
                return;
            }
            dJW();
            AppMethodBeat.m2505o(34969);
        } else {
            C4990ab.m7412e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            dJX();
            finish();
            AppMethodBeat.m2505o(34969);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m59818a(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.m2504i(34973);
        if (shareScreenImgUI.ehJ != null && shareScreenImgUI.ehJ.isShowing()) {
            shareScreenImgUI.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(34973);
    }

    /* renamed from: b */
    static /* synthetic */ void m59819b(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.m2504i(34974);
        shareScreenImgUI.dJX();
        AppMethodBeat.m2505o(34974);
    }
}
