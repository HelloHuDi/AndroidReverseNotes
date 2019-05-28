package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.k;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34976);
        super.onCreate(bundle);
        setMMTitle("");
        int a = w.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.Io();
                aw.Rg().a(new bk(new bk.a() {
                    public final void a(e eVar) {
                    }
                }), 0);
                initView();
                AppMethodBeat.o(34976);
                return;
            case 1:
                finish();
                AppMethodBeat.o(34976);
                return;
            default:
                ab.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.o(34976);
                return;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void initView() {
        AppMethodBeat.i(34977);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.o(34977);
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.o(34977);
            return;
        }
        String n = w.n(intent, k.ygd);
        String resolveType = getIntent().resolveType(this);
        if (bo.isNullOrNil(resolveType)) {
            dJw();
            finish();
            AppMethodBeat.o(34977);
            return;
        }
        if (VERSION.SDK_INT >= 28) {
            if (!(resolveType.contains("heic") || resolveType.contains("image"))) {
                dJw();
                finish();
                AppMethodBeat.o(34977);
                return;
            }
        } else if (!resolveType.contains("image")) {
            dJw();
            finish();
            AppMethodBeat.o(34977);
            return;
        }
        if (action.equals("android.intent.action.VIEW")) {
            ab.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: ".concat(String.valueOf(action)));
            if (bo.v(this.uri)) {
                this.filePath = bo.h(this, this.uri);
                if (bo.isNullOrNil(this.filePath) || !bo.anx(this.filePath)) {
                    if (w.a(intent, "Ksnsupload_empty_img", false)) {
                        ip(this.filePath, n);
                        AppMethodBeat.o(34977);
                        return;
                    }
                    dJw();
                    finish();
                    AppMethodBeat.o(34977);
                    return;
                } else if (r.amn(this.filePath)) {
                    ip(this.filePath, n);
                    AppMethodBeat.o(34977);
                    return;
                } else {
                    dJw();
                    finish();
                    AppMethodBeat.o(34977);
                    return;
                }
            }
            ab.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", this.uri);
            dJw();
            finish();
            AppMethodBeat.o(34977);
            return;
        }
        ab.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
        dJw();
        finish();
        AppMethodBeat.o(34977);
    }

    private void ip(String str, String str2) {
        AppMethodBeat.i(34978);
        Intent intent = new Intent();
        if (!bo.isNullOrNil(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!bo.isNullOrNil(str2)) {
            intent.putExtra(k.ygd, str2);
        }
        if (aw.ZM() && !aw.QT()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            d.b((Context) this, "sns", ".ui.SnsUploadUI", intent);
        } else if (bo.isNullOrNil(str)) {
            dJw();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(32768).addFlags(268435456);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        }
        finish();
        AppMethodBeat.o(34978);
    }

    private void dJw() {
        AppMethodBeat.i(34979);
        Toast.makeText(this, R.string.eh_, 1).show();
        AppMethodBeat.o(34979);
    }
}
