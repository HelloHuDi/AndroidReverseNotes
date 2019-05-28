package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.vfs.b;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareToTimeLineUI extends AutoLoginActivity implements f {
    private ProgressDialog ehJ = null;
    private Intent intent;
    private Intent zHq;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean bVD() {
        AppMethodBeat.i(34982);
        if (!aw.ZM() || aw.QT()) {
            ab.w("MicroMsg.ShareToTimeLine", "not login");
            dJW();
            AppMethodBeat.o(34982);
            return true;
        }
        AppMethodBeat.o(34982);
        return false;
    }

    private void dJW() {
        AppMethodBeat.i(34983);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.o(34983);
            return;
        }
        String action = intent.getAction();
        Bundle aM = w.aM(intent);
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.o(34983);
            return;
        }
        String n = w.n(intent, k.ygd);
        String resolveType = getIntent().resolveType(this);
        if (bo.isNullOrNil(resolveType)) {
            dJw();
            finish();
            AppMethodBeat.o(34983);
        } else if (!resolveType.contains("image")) {
            dJw();
            finish();
            AppMethodBeat.o(34983);
        } else if (!action.equals("android.intent.action.SEND") || aM == null) {
            ab.e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            dJw();
            finish();
            AppMethodBeat.o(34983);
        } else {
            ab.i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(action)));
            Parcelable parcelable = aM.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (bo.v(uri)) {
                    String h = bo.h(this, uri);
                    if (bo.isNullOrNil(h) || !new b(h).exists()) {
                        action = e.a(getContentResolver(), uri, 2);
                    } else {
                        action = h;
                    }
                    if (bo.isNullOrNil(action) || !bo.anx(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            Q(action, n, 4);
                            AppMethodBeat.o(34983);
                            return;
                        }
                        dJw();
                        finish();
                        AppMethodBeat.o(34983);
                        return;
                    } else if (asl(action)) {
                        Q(action, n, 0);
                        AppMethodBeat.o(34983);
                        return;
                    } else {
                        dJw();
                        finish();
                        AppMethodBeat.o(34983);
                        return;
                    }
                }
                ab.e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", uri);
                dJw();
                finish();
                AppMethodBeat.o(34983);
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                Q(null, n, 4);
                AppMethodBeat.o(34983);
            } else {
                dJw();
                finish();
                AppMethodBeat.o(34983);
            }
        }
    }

    private static boolean asl(String str) {
        AppMethodBeat.i(34984);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(34984);
            return false;
        }
        boolean amn = r.amn(str);
        AppMethodBeat.o(34984);
        return amn;
    }

    private void Q(String str, String str2, int i) {
        AppMethodBeat.i(34985);
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        if (!bo.isNullOrNil(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
            arrayList.add(str);
        }
        if (!bo.isNullOrNil(str2)) {
            intent.putExtra(k.ygd, str2);
        }
        if (i == 4 && bo.isNullOrNil(str) && !bo.isNullOrNil(str2)) {
            arrayList.add(str2);
        }
        if (!aw.ZM() || aw.QT()) {
            if (bo.isNullOrNil(str)) {
                dJw();
            } else {
                intent = new Intent(this, ShareToTimeLineUI.class);
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
                intent.addFlags(32768).addFlags(268435456);
                intent.setType("image/*");
                intent.setAction("android.intent.action.SEND");
                MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
            }
            finish();
            AppMethodBeat.o(34985);
            return;
        }
        intent.putExtra("K_go_to_SnsTimeLineUI", true);
        intent.putExtra("Ksnsupload_source", 12);
        if (i == 0) {
            intent.putExtra("KBlockAdd", true);
        }
        intent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
        this.zHq = intent;
        m mVar = null;
        switch (i) {
            case 0:
                mVar = new d(1, arrayList, dyh());
                break;
            case 4:
                mVar = new d(5, arrayList, dyh());
                break;
        }
        if (mVar != null) {
            aw.Rg().a(837, (f) this);
            g.Rg().a(mVar, 0);
            showDialog();
        }
        AppMethodBeat.o(34985);
    }

    public void onDestroy() {
        AppMethodBeat.i(34986);
        aw.Rg().b(837, (f) this);
        super.onDestroy();
        AppMethodBeat.o(34986);
    }

    private void dJw() {
        AppMethodBeat.i(34987);
        Toast.makeText(this, R.string.eh_, 1).show();
        AppMethodBeat.o(34987);
    }

    public final boolean O(Intent intent) {
        return true;
    }

    private void showDialog() {
        AppMethodBeat.i(34988);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34980);
                ShareToTimeLineUI.this.finish();
                AppMethodBeat.o(34980);
            }
        });
        AppMethodBeat.o(34988);
    }

    public final void a(a aVar, Intent intent) {
        AppMethodBeat.i(34989);
        switch (aVar) {
            case LOGIN_OK:
                this.intent = intent;
                ab.i("MicroMsg.ShareToTimeLine", "now permission = %d", Integer.valueOf(bo.getInt(com.tencent.mm.m.g.Nu().getValue("SystemShareControlBitset"), 0)));
                if ((bo.getInt(com.tencent.mm.m.g.Nu().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    ab.e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.o(34989);
                    return;
                }
                ab.i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", w.n(intent, "android.intent.extra.TEXT"));
                if (bo.isNullOrNil(w.n(intent, "android.intent.extra.TEXT"))) {
                    dJW();
                    AppMethodBeat.o(34989);
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                aw.Rg().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
                aw.Rg().a(new z(format, 15, null), 0);
                AppMethodBeat.o(34989);
                return;
            default:
                finish();
                AppMethodBeat.o(34989);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34990);
        ab.i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aw.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (!(mVar instanceof z)) {
            if (mVar instanceof d) {
                if (!(i == 0 && i2 == 0)) {
                    if (mVar.ftl != null) {
                        rt rtVar = (rt) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                        if (!(rtVar == null || bo.isNullOrNil(rtVar.vZf))) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", rtVar.vZf);
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            intent.putExtra("needRedirect", false);
                            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                }
                startActivity(this.zHq);
            }
            AppMethodBeat.o(34990);
        } else if (i == 0 && i2 == 0) {
            dJW();
            AppMethodBeat.o(34990);
            return;
        } else {
            dJw();
        }
        finish();
        AppMethodBeat.o(34990);
    }
}
