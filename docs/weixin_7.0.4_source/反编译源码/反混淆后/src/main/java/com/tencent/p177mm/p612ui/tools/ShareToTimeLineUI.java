package com.tencent.p177mm.p612ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.modelsimple.C37946d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5510e.C5504k;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.pluginsdk.p1082i.C14864e;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.protocal.protobuf.C35949rt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.ui.tools.ShareToTimeLineUI */
public class ShareToTimeLineUI extends AutoLoginActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private Intent intent;
    private Intent zHq;

    /* renamed from: com.tencent.mm.ui.tools.ShareToTimeLineUI$1 */
    class C240411 implements OnCancelListener {
        C240411() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34980);
            ShareToTimeLineUI.this.finish();
            AppMethodBeat.m2505o(34980);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final boolean bVD() {
        AppMethodBeat.m2504i(34982);
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7420w("MicroMsg.ShareToTimeLine", "not login");
            dJW();
            AppMethodBeat.m2505o(34982);
            return true;
        }
        AppMethodBeat.m2505o(34982);
        return false;
    }

    private void dJW() {
        AppMethodBeat.m2504i(34983);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShareToTimeLine", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34983);
            return;
        }
        String action = intent.getAction();
        Bundle aM = C5068w.m7684aM(intent);
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.ShareToTimeLine", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34983);
            return;
        }
        String n = C5068w.m7689n(intent, C5504k.ygd);
        String resolveType = getIntent().resolveType(this);
        if (C5046bo.isNullOrNil(resolveType)) {
            dJw();
            finish();
            AppMethodBeat.m2505o(34983);
        } else if (!resolveType.contains("image")) {
            dJw();
            finish();
            AppMethodBeat.m2505o(34983);
        } else if (!action.equals("android.intent.action.SEND") || aM == null) {
            C4990ab.m7412e("MicroMsg.ShareToTimeLine", "launch : fail, uri is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34983);
        } else {
            C4990ab.m7416i("MicroMsg.ShareToTimeLine", "send signal: ".concat(String.valueOf(action)));
            Parcelable parcelable = aM.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                Uri uri = (Uri) parcelable;
                if (C5046bo.m7585v(uri)) {
                    String h = C5046bo.m7568h(this, uri);
                    if (C5046bo.isNullOrNil(h) || !new C5728b(h).exists()) {
                        action = C14864e.m23126a(getContentResolver(), uri, 2);
                    } else {
                        action = h;
                    }
                    if (C5046bo.isNullOrNil(action) || !C5046bo.anx(action)) {
                        if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                            m37000Q(action, n, 4);
                            AppMethodBeat.m2505o(34983);
                            return;
                        }
                        dJw();
                        finish();
                        AppMethodBeat.m2505o(34983);
                        return;
                    } else if (ShareToTimeLineUI.asl(action)) {
                        m37000Q(action, n, 0);
                        AppMethodBeat.m2505o(34983);
                        return;
                    } else {
                        dJw();
                        finish();
                        AppMethodBeat.m2505o(34983);
                        return;
                    }
                }
                C4990ab.m7413e("MicroMsg.ShareToTimeLine", "deal : fail, not accept, %s", uri);
                dJw();
                finish();
                AppMethodBeat.m2505o(34983);
            } else if (intent.getBooleanExtra("Ksnsupload_empty_img", false)) {
                m37000Q(null, n, 4);
                AppMethodBeat.m2505o(34983);
            } else {
                dJw();
                finish();
                AppMethodBeat.m2505o(34983);
            }
        }
    }

    private static boolean asl(String str) {
        AppMethodBeat.m2504i(34984);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(34984);
            return false;
        }
        boolean amn = C5063r.amn(str);
        AppMethodBeat.m2505o(34984);
        return amn;
    }

    /* renamed from: Q */
    private void m37000Q(String str, String str2, int i) {
        AppMethodBeat.m2504i(34985);
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
            arrayList.add(str);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            intent.putExtra(C5504k.ygd, str2);
        }
        if (i == 4 && C5046bo.isNullOrNil(str) && !C5046bo.isNullOrNil(str2)) {
            arrayList.add(str2);
        }
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            if (C5046bo.isNullOrNil(str)) {
                dJw();
            } else {
                intent = new Intent(this, ShareToTimeLineUI.class);
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
                intent.addFlags(32768).addFlags(268435456);
                intent.setType("image/*");
                intent.setAction("android.intent.action.SEND");
                MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class).addFlags(268435456).addFlags(32768), intent);
            }
            finish();
            AppMethodBeat.m2505o(34985);
            return;
        }
        intent.putExtra("K_go_to_SnsTimeLineUI", true);
        intent.putExtra("Ksnsupload_source", 12);
        if (i == 0) {
            intent.putExtra("KBlockAdd", true);
        }
        intent.setClassName(this, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
        this.zHq = intent;
        C1207m c1207m = null;
        switch (i) {
            case 0:
                c1207m = new C37946d(1, arrayList, dyh());
                break;
            case 4:
                c1207m = new C37946d(5, arrayList, dyh());
                break;
        }
        if (c1207m != null) {
            C9638aw.m17182Rg().mo14539a(837, (C1202f) this);
            C1720g.m3540Rg().mo14541a(c1207m, 0);
            showDialog();
        }
        AppMethodBeat.m2505o(34985);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34986);
        C9638aw.m17182Rg().mo14546b(837, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(34986);
    }

    private void dJw() {
        AppMethodBeat.m2504i(34987);
        Toast.makeText(this, C25738R.string.eh_, 1).show();
        AppMethodBeat.m2505o(34987);
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    private void showDialog() {
        AppMethodBeat.m2504i(34988);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C240411());
        AppMethodBeat.m2505o(34988);
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(34989);
        switch (c4737a) {
            case LOGIN_OK:
                this.intent = intent;
                C4990ab.m7417i("MicroMsg.ShareToTimeLine", "now permission = %d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("SystemShareControlBitset"), 0)));
                if ((C5046bo.getInt(C26373g.m41964Nu().getValue("SystemShareControlBitset"), 0) & 2) > 0) {
                    C4990ab.m7412e("MicroMsg.ShareToTimeLine", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.m2505o(34989);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ShareToTimeLine", "postLogin, text = %s", C5068w.m7689n(intent, "android.intent.extra.TEXT"));
                if (C5046bo.isNullOrNil(C5068w.m7689n(intent, "android.intent.extra.TEXT"))) {
                    dJW();
                    AppMethodBeat.m2505o(34989);
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                C9638aw.m17182Rg().mo14539a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
                C9638aw.m17182Rg().mo14541a(new C26475z(format, 15, null), 0);
                AppMethodBeat.m2505o(34989);
                return;
            default:
                finish();
                AppMethodBeat.m2505o(34989);
                return;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34990);
        C4990ab.m7417i("MicroMsg.ShareToTimeLine", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        C9638aw.m17182Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (!(c1207m instanceof C26475z)) {
            if (c1207m instanceof C37946d) {
                if (!(i == 0 && i2 == 0)) {
                    if (c1207m.ftl != null) {
                        C35949rt c35949rt = (C35949rt) ((C7472b) c1207m.ftl).fsH.fsP;
                        if (!(c35949rt == null || C5046bo.isNullOrNil(c35949rt.vZf))) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", c35949rt.vZf);
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            intent.putExtra("needRedirect", false);
                            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    }
                }
                startActivity(this.zHq);
            }
            AppMethodBeat.m2505o(34990);
        } else if (i == 0 && i2 == 0) {
            dJW();
            AppMethodBeat.m2505o(34990);
            return;
        } else {
            dJw();
        }
        finish();
        AppMethodBeat.m2505o(34990);
    }
}
