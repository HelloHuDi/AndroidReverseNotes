package com.tencent.p177mm.plugin.clean.p364ui.newui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.clean.p362c.C20227c;
import com.tencent.p177mm.plugin.clean.p362c.C27641b;
import com.tencent.p177mm.plugin.clean.p362c.C27642d;
import com.tencent.p177mm.plugin.clean.p362c.C33823g;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C11387b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.p601c.C35980b.C35981b;
import com.tencent.p177mm.sdk.p601c.C35980b.C35983c;
import com.tencent.p177mm.sdk.p601c.C36863a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C46614bq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI */
public class CleanNewUI extends MMActivity implements C33823g {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;
    private C20227c kyR;
    private LinearLayout kyj;
    private TextView kyk;
    private TextView kyl;
    private Button kym;
    private Button kyn;
    private TextView kyo;
    private LinearLayout kyp;
    private TextView kyq;
    private TextView kyr;
    private Button kys;
    private View kyt;

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI$1 */
    class C114091 implements OnMenuItemClickListener {
        C114091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18911);
            CleanNewUI.this.finish();
            AppMethodBeat.m2505o(18911);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI$3 */
    class C114103 implements OnClickListener {
        C114103() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18913);
            C4990ab.m7416i("MicroMsg.CleanNewUI", "clean wechat cache");
            AppMethodBeat.m2505o(18913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI$2 */
    class C276562 implements OnClickListener {
        C276562() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18912);
            C4990ab.m7416i("MicroMsg.CleanNewUI", "goto clean msg ui");
            CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
            AppMethodBeat.m2505o(18912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI$4 */
    class C276594 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.newui.CleanNewUI$4$1 */
        class C276571 implements DialogInterface.OnClickListener {
            C276571() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18914);
                try {
                    C4990ab.m7417i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new URL(CleanNewUI.this.kwT.getString("url")), CleanNewUI.this.kwT.getString("md5"));
                    C2901a c2901a = new C2901a();
                    c2901a.mo7057Iv("wesecure.apk");
                    c2901a.mo7055It(r0.toString());
                    c2901a.mo7063ga(true);
                    c2901a.mo7058Iw(r1);
                    c2901a.mo7069tN(1);
                    C2896d.bij().mo7042a(c2901a.kNl);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                }
                C7060h.pYm.mo8378a(282, 7, 1, false);
                AppMethodBeat.m2505o(18914);
            }
        }

        C276594() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18915);
            C4990ab.m7416i("MicroMsg.CleanNewUI", "qq mgr btn click");
            C7060h.pYm.mo8378a(282, 5, 1, false);
            if (!CleanNewUI.m43948a(CleanNewUI.this)) {
                if (CleanNewUI.m43949b(CleanNewUI.this)) {
                    C30379h.m48466d(CleanNewUI.this, CleanNewUI.this.getString(C25738R.string.aq4, new Object[]{C5046bo.m7580my(CleanNewUI.this.kwP)}), "", CleanNewUI.this.getString(C25738R.string.f9093p_), CleanNewUI.this.getString(C25738R.string.f9076or), new C276571(), null);
                    AppMethodBeat.m2505o(18915);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                intent.putExtra("show_bottom", false);
                intent.putExtra("showShare", false);
                C25985d.m41467b(CleanNewUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(18915);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m43948a(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18925);
        boolean bgf = cleanNewUI.bgf();
        AppMethodBeat.m2505o(18925);
        return bgf;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m43949b(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18926);
        boolean bgg = cleanNewUI.bgg();
        AppMethodBeat.m2505o(18926);
        return bgg;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18917);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.aqq);
        setBackBtn(new C114091());
        this.kyj = (LinearLayout) findViewById(2131822801);
        this.kyk = (TextView) findViewById(2131822802);
        this.kyl = (TextView) findViewById(2131822803);
        this.kym = (Button) findViewById(2131822804);
        this.kyn = (Button) findViewById(2131822805);
        this.kyn.setVisibility(8);
        this.kyo = (TextView) findViewById(2131822776);
        this.kym.setOnClickListener(new C276562());
        this.kyn.setOnClickListener(new C114103());
        this.kyp = (LinearLayout) findViewById(2131822806);
        this.kyq = (TextView) findViewById(2131822807);
        this.kyr = (TextView) findViewById(2131822808);
        this.kys = (Button) findViewById(2131822809);
        this.kyt = findViewById(2131822810);
        this.kys.setOnClickListener(new C276594());
        if (C46614bq.dpN() || C5059g.cdf == 1) {
            this.kys.setVisibility(8);
            this.kyt.setVisibility(0);
        }
        this.kyq.setText(C5046bo.m7565ga(C20227c.bfL() - C20227c.bfM()));
        this.kyr.setText(getString(C25738R.string.aq9, new Object[]{C5046bo.m7565ga(r2)}));
        C45287c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        try {
            C35981b c35981b = new C35981b();
            c35981b.xxO = "https://";
            c35981b.host = "jtool.qq.com";
            c35981b.uri = "/channel?productId=31&channelId=102133";
            new C36863a((HttpURLConnection) new URL(c35981b.getUrl()).openConnection()).mo56716a(c35981b, new C35983c("") {
                public final void onComplete() {
                    AppMethodBeat.m2504i(18916);
                    C4990ab.m7411d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                        AppMethodBeat.m2505o(18916);
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        C7060h.pYm.mo8378a(282, 8, 1, false);
                        AppMethodBeat.m2505o(18916);
                    }
                }
            }, new C7306ak());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        C27642d.m43916a(new C11387b());
        if (C27642d.bfS() == null) {
            C11387b bfQ = C27642d.bfQ();
            if (bfQ != null) {
                this.kyR = new C20227c(bfQ, this);
                C7305d.post(this.kyR, "CleanUI_clean");
                this.kyn.setEnabled(false);
                this.kyk.setVisibility(8);
                this.kyl.setVisibility(8);
                this.kyo.setVisibility(0);
                this.kyo.setText(getString(C25738R.string.f8811fp, new Object[]{"0%"}));
            }
        }
        AppMethodBeat.m2505o(18917);
    }

    public void onResume() {
        AppMethodBeat.m2504i(18918);
        super.onResume();
        if (C27642d.bfS() != null) {
            m43947E(C27642d.bfT(), C20227c.bfL());
        }
        AppMethodBeat.m2505o(18918);
    }

    /* renamed from: E */
    private void m43947E(long j, long j2) {
        AppMethodBeat.m2504i(18919);
        bgk();
        this.kyk.setText(C5046bo.m7565ga(j));
        int i = (int) ((100 * j) / j2);
        this.kyl.setText(getString(C25738R.string.aqu, new Object[]{i + "%"}));
        AppMethodBeat.m2505o(18919);
    }

    private void bgk() {
        AppMethodBeat.m2504i(18920);
        this.kyn.setEnabled(true);
        this.kyo.setVisibility(8);
        this.kyk.setVisibility(0);
        this.kyl.setVisibility(0);
        AppMethodBeat.m2505o(18920);
    }

    public final int getLayoutId() {
        return 2130969147;
    }

    /* renamed from: dO */
    public final void mo45501dO(int i, int i2) {
        AppMethodBeat.m2504i(18921);
        this.kyo.setText(getString(C25738R.string.f8811fp, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.m2505o(18921);
    }

    /* renamed from: a */
    public final void mo45500a(long j, long j2, long j3, ArrayList<C27641b> arrayList, long j4, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(18922);
        C4990ab.m7417i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        C27642d.m43921hg(j);
        C27642d.m43918hd(j2);
        C27642d.m43920hf(j4);
        C27642d.m43917b(hashSet);
        C27642d.m43919he(j3);
        C27642d.m43922u(arrayList);
        m43947E(C27642d.bfT(), C20227c.bfL());
        AppMethodBeat.m2505o(18922);
    }

    private boolean bgg() {
        AppMethodBeat.m2504i(18923);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18923);
            return false;
        }
        try {
            this.kwT = new JSONObject(str);
            this.kwQ = this.kwT.getString(DownloadInfoColumns.PACKAGENAME);
            this.kwT.get("md5");
            this.kwS = this.kwT.getString("launcherID");
            this.kwR = this.kwT.getString("signature");
            this.kwT.get("url");
            this.kwP = this.kwT.getLong("size");
            AppMethodBeat.m2505o(18923);
            return true;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(18923);
            return false;
        }
    }

    private boolean bgf() {
        AppMethodBeat.m2504i(18924);
        bgg();
        if (C35799p.m58695u(this.mController.ylL, this.kwQ)) {
            Signature[] bx = C35799p.m58691bx(this, this.kwQ);
            if (!(bx == null || bx[0] == null)) {
                String x = C1178g.m2591x(bx[0].toByteArray());
                if (x != null && x.equalsIgnoreCase(this.kwR)) {
                    try {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.kwQ);
                        if (launchIntentForPackage != null) {
                            Bundle bundle = new Bundle();
                            C35799p.m58694j(bundle, this.kwS);
                            launchIntentForPackage.putExtras(bundle);
                            launchIntentForPackage.addFlags(268435456);
                            startActivity(launchIntentForPackage);
                            C7060h.pYm.mo8378a(282, 6, 1, false);
                            AppMethodBeat.m2505o(18924);
                            return true;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(18924);
                    return true;
                }
            }
            AppMethodBeat.m2505o(18924);
            return false;
        }
        AppMethodBeat.m2505o(18924);
        return false;
    }
}
