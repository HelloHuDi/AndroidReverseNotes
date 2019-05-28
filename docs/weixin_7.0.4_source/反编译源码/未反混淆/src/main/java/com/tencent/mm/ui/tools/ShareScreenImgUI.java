package com.tencent.mm.ui.tools;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenImgUI extends MMActivity {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34966);
            ShareScreenImgUI.a(ShareScreenImgUI.this);
            if (bo.isNullOrNil(ShareScreenImgUI.this.filePath)) {
                ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                ShareScreenImgUI.b(ShareScreenImgUI.this);
                ShareScreenImgUI.this.finish();
                AppMethodBeat.o(34966);
                return;
            }
            ShareScreenImgUI.c(ShareScreenImgUI.this);
            AppMethodBeat.o(34966);
        }
    };
    private Intent intent = null;
    Uri uri = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareScreenImgUI() {
        AppMethodBeat.i(34967);
        AppMethodBeat.o(34967);
    }

    static /* synthetic */ void c(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(34975);
        shareScreenImgUI.dJW();
        AppMethodBeat.o(34975);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34968);
        super.onCreate(bundle);
        setMMTitle("");
        int a = w.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.Io();
                initView();
                AppMethodBeat.o(34968);
                return;
            case 1:
                finish();
                AppMethodBeat.o(34968);
                return;
            default:
                ab.e("MicroMsg.ShareScreenImgUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.o(34968);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    private void dJW() {
        AppMethodBeat.i(34970);
        ab.i("MicroMsg.ShareScreenImgUI", "filepath:[%s]", this.filePath);
        Intent intent = getIntent();
        int asc = asc(intent.resolveType(this));
        if (asc == -1) {
            ab.e("MicroMsg.ShareScreenImgUI", "launch, msgType is invalid");
            finish();
            AppMethodBeat.o(34970);
            return;
        }
        if (!w.a(getIntent(), "Intro_Switch", false) && aw.ZM() && !aw.QT()) {
            intent.setData(this.uri);
            intent.setClass(this, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", this.filePath);
            intent.putExtra("Retr_Msg_Type", asc);
            intent.putExtra("Retr_Scene", 1);
            intent.putExtra("Retr_start_where_you_are", false);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (bo.isNullOrNil(this.filePath)) {
            dJX();
        } else {
            intent = new Intent(this, ShareImgUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.addFlags(67108864);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
        AppMethodBeat.o(34970);
    }

    private static int asc(String str) {
        AppMethodBeat.i(34971);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ShareScreenImgUI", "map : mimeType is null");
            AppMethodBeat.o(34971);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || (VERSION.SDK_INT >= 28 && toLowerCase.contains("heic"))) {
            AppMethodBeat.o(34971);
            return 0;
        }
        ab.d("MicroMsg.ShareScreenImgUI", "map : unknown mimetype, send as file");
        AppMethodBeat.o(34971);
        return 3;
    }

    private void dJX() {
        AppMethodBeat.i(34972);
        Toast.makeText(this, R.string.eh8, 1).show();
        AppMethodBeat.o(34972);
    }

    public final void initView() {
        AppMethodBeat.i(34969);
        this.intent = getIntent();
        if (this.intent == null) {
            ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, intent is null");
            dJX();
            finish();
            AppMethodBeat.o(34969);
            return;
        }
        ab.i("MicroMsg.ShareScreenImgUI", "intent = " + this.intent);
        String action = this.intent.getAction();
        this.uri = this.intent.getData();
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, action is null");
            dJX();
            finish();
            AppMethodBeat.o(34969);
        } else if (action.equals("android.intent.action.VIEW")) {
            ab.i("MicroMsg.ShareScreenImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null || !bo.v(this.uri)) {
                ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, not accepted: %s", this.uri);
                dJX();
                finish();
                AppMethodBeat.o(34969);
                return;
            }
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            this.filePath = bo.h(this, this.uri);
            if (bo.isNullOrNil(this.filePath) || !r.amn(this.filePath)) {
                ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
                dJX();
                finish();
                AppMethodBeat.o(34969);
                return;
            }
            dJW();
            AppMethodBeat.o(34969);
        } else {
            ab.e("MicroMsg.ShareScreenImgUI", "launch : fail, uri is null");
            dJX();
            finish();
            AppMethodBeat.o(34969);
        }
    }

    static /* synthetic */ void a(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(34973);
        if (shareScreenImgUI.ehJ != null && shareScreenImgUI.ehJ.isShowing()) {
            shareScreenImgUI.ehJ.dismiss();
        }
        AppMethodBeat.o(34973);
    }

    static /* synthetic */ void b(ShareScreenImgUI shareScreenImgUI) {
        AppMethodBeat.i(34974);
        shareScreenImgUI.dJX();
        AppMethodBeat.o(34974);
    }
}
