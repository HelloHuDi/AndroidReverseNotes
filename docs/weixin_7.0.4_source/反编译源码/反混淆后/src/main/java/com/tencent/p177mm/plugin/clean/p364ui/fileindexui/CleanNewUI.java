package com.tencent.p177mm.plugin.clean.p364ui.fileindexui;

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
import com.tencent.p177mm.p230g.p231a.C18305ju;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.clean.p1246b.C20226c;
import com.tencent.p177mm.plugin.clean.p1246b.C38796a;
import com.tencent.p177mm.plugin.clean.p362c.C6826j;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.p398f.C45913b;
import com.tencent.p177mm.plugin.p398f.C45913b.C279137;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p601c.C35980b.C35981b;
import com.tencent.p177mm.sdk.p601c.C35980b.C35983c;
import com.tencent.p177mm.sdk.p601c.C36863a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C46614bq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI */
public class CleanNewUI extends MMActivity {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;
    private C20226c kyA = new C276536();
    private C4884c<C18305ju> kyB = new C68279();
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
    private boolean kyu = false;
    private C38796a kyv;
    private long kyw = 0;
    private long kyx = 0;
    private long kyy = 0;
    private long kyz = 0;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$8 */
    class C28118 implements Runnable {
        final /* synthetic */ long kyE;

        C28118(long j) {
            this.kyE = j;
        }

        public final void run() {
            AppMethodBeat.m2504i(18820);
            CleanNewUI cleanNewUI = CleanNewUI.this;
            long j = this.kyE;
            C6826j.bgd();
            CleanNewUI.m43931a(cleanNewUI, j, C6826j.bfL());
            AppMethodBeat.m2505o(18820);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$9 */
    class C68279 extends C4884c<C18305ju> {
        C68279() {
            AppMethodBeat.m2504i(18821);
            this.xxI = C18305ju.class.getName().hashCode();
            AppMethodBeat.m2505o(18821);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18822);
            C18305ju c18305ju = (C18305ju) c4883b;
            if (c18305ju == null || c18305ju.cES == null) {
                AppMethodBeat.m2505o(18822);
            } else {
                C4990ab.m7417i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.m43930a(CleanNewUI.this), Long.valueOf(c18305ju.cES.progress), Long.valueOf(c18305ju.cES.cET), Boolean.valueOf(c18305ju.cES.cco));
                if (c18305ju.cES.cco) {
                    CleanNewUI.this.kyx = C5046bo.anU();
                    CleanNewUI.m43943l(CleanNewUI.this);
                    C7060h.pYm.mo8378a(714, 51, 1, false);
                } else {
                    int i = (int) (((((float) c18305ju.cES.progress) * 1.0f) / ((float) c18305ju.cES.cET)) * 100.0f);
                    CleanNewUI cleanNewUI = CleanNewUI.this;
                    if (i <= 0) {
                        i = 0;
                    }
                    cleanNewUI.mo45492dQ(i, 100);
                }
                AppMethodBeat.m2505o(18822);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$1 */
    class C276471 implements OnMenuItemClickListener {
        C276471() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(18811);
            CleanNewUI.this.finish();
            AppMethodBeat.m2505o(18811);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$2 */
    class C276492 implements OnClickListener {
        C276492() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18812);
            C4990ab.m7417i("MicroMsg.CleanNewUI", "%s goto clean msg ui", CleanNewUI.m43930a(CleanNewUI.this));
            C7060h.pYm.mo8378a(714, 2, 1, false);
            CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
            AppMethodBeat.m2505o(18812);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$3 */
    class C276503 implements OnClickListener {
        C276503() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18813);
            C4990ab.m7416i("MicroMsg.CleanNewUI", "clean wechat cache");
            AppMethodBeat.m2505o(18813);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$4 */
    class C276524 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$4$1 */
        class C276481 implements DialogInterface.OnClickListener {
            C276481() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(18814);
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
                C7060h.pYm.mo8378a(714, 4, 1, false);
                AppMethodBeat.m2505o(18814);
            }
        }

        C276524() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(18815);
            C4990ab.m7416i("MicroMsg.CleanNewUI", "qq mgr btn click");
            C7060h.pYm.mo8378a(714, 3, 1, false);
            if (!CleanNewUI.m43933b(CleanNewUI.this)) {
                if (CleanNewUI.m43934c(CleanNewUI.this)) {
                    C30379h.m48466d(CleanNewUI.this, CleanNewUI.this.getString(C25738R.string.aq4, new Object[]{C5046bo.m7580my(CleanNewUI.this.kwP)}), "", CleanNewUI.this.getString(C25738R.string.f9093p_), CleanNewUI.this.getString(C25738R.string.f9076or), new C276481(), null);
                    AppMethodBeat.m2505o(18815);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                intent.putExtra("show_bottom", false);
                intent.putExtra("showShare", false);
                C25985d.m41467b(CleanNewUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                C7060h.pYm.mo8378a(714, 5, 1, false);
            }
            AppMethodBeat.m2505o(18815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$6 */
    class C276536 implements C20226c {
        C276536() {
        }

        /* renamed from: dN */
        public final void mo35471dN(int i, int i2) {
            AppMethodBeat.m2504i(18817);
            if (!CleanNewUI.this.kyu) {
                CleanNewUI.this.mo45492dQ(i, i2);
            }
            AppMethodBeat.m2505o(18817);
        }

        /* renamed from: a */
        public final void mo35470a(long j, long j2, long j3, HashSet<String> hashSet, HashMap<String, Long> hashMap) {
            AppMethodBeat.m2504i(18818);
            CleanNewUI.this.kyz = C5046bo.anU();
            CleanNewUI cleanNewUI = CleanNewUI.this;
            C6826j.bgd().kvV = j;
            C6826j.bgd().kvW = j2;
            C6826j.bgd().kvX = j3;
            C6826j.bgd().kwI = hashMap;
            C6826j.bgd().kww = hashSet;
            C5004al.m7441d(new C28118(j));
            C7060h.pYm.mo8378a(714, 53, 1, false);
            long g = CleanNewUI.this.kyx - CleanNewUI.this.kyw;
            long i = CleanNewUI.this.kyz - CleanNewUI.this.kyy;
            C4990ab.m7411d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", Long.valueOf(CleanNewUI.this.kyx), Long.valueOf(CleanNewUI.this.kyw), Long.valueOf(g), Long.valueOf(CleanNewUI.this.kyz), Long.valueOf(CleanNewUI.this.kyy), Long.valueOf(i), Long.valueOf(g + i));
            C7060h.pYm.mo8381e(14556, Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.kyw), Long.valueOf(CleanNewUI.this.kyx), Long.valueOf(g));
            C7060h.pYm.mo8381e(14556, Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.kyy), Long.valueOf(CleanNewUI.this.kyz), Long.valueOf(i));
            C7060h.pYm.mo8381e(14556, Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(g + i));
            AppMethodBeat.m2505o(18818);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CleanNewUI() {
        AppMethodBeat.m2504i(18823);
        AppMethodBeat.m2505o(18823);
    }

    /* renamed from: a */
    static /* synthetic */ String m43930a(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18835);
        String aZk = cleanNewUI.aZk();
        AppMethodBeat.m2505o(18835);
        return aZk;
    }

    /* renamed from: a */
    static /* synthetic */ void m43931a(CleanNewUI cleanNewUI, long j, long j2) {
        AppMethodBeat.m2504i(18838);
        cleanNewUI.m43928E(j, j2);
        AppMethodBeat.m2505o(18838);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m43933b(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18836);
        boolean bgf = cleanNewUI.bgf();
        AppMethodBeat.m2505o(18836);
        return bgf;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m43934c(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18837);
        boolean bgg = cleanNewUI.bgg();
        AppMethodBeat.m2505o(18837);
        return bgg;
    }

    /* renamed from: l */
    static /* synthetic */ void m43943l(CleanNewUI cleanNewUI) {
        AppMethodBeat.m2504i(18839);
        cleanNewUI.bgl();
        AppMethodBeat.m2505o(18839);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18824);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.aqb);
        setBackBtn(new C276471());
        this.kyj = (LinearLayout) findViewById(2131822801);
        this.kyk = (TextView) findViewById(2131822802);
        this.kyl = (TextView) findViewById(2131822803);
        this.kym = (Button) findViewById(2131822804);
        this.kym.setEnabled(false);
        this.kyn = (Button) findViewById(2131822805);
        this.kyn.setVisibility(8);
        this.kyo = (TextView) findViewById(2131822776);
        this.kym.setOnClickListener(new C276492());
        this.kyn.setOnClickListener(new C276503());
        this.kyp = (LinearLayout) findViewById(2131822806);
        this.kyq = (TextView) findViewById(2131822807);
        this.kyr = (TextView) findViewById(2131822808);
        this.kys = (Button) findViewById(2131822809);
        this.kyt = findViewById(2131822810);
        this.kys.setOnClickListener(new C276524());
        if (C46614bq.dpN() || C5059g.cdf == 1) {
            this.kys.setVisibility(8);
            this.kyt.setVisibility(0);
        }
        C6826j.bgd();
        long bfL = C6826j.bfL();
        C6826j.bgd();
        this.kyq.setText(C5046bo.m7565ga(bfL - C6826j.bfM()));
        this.kyr.setText(getString(C25738R.string.aq9, new Object[]{C5046bo.m7565ga(r2)}));
        C45287c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        try {
            C35981b c35981b = new C35981b();
            c35981b.xxO = "https://";
            c35981b.host = "jtool.qq.com";
            c35981b.uri = "/channel?productId=31&channelId=102133";
            new C36863a((HttpURLConnection) new URL(c35981b.getUrl()).openConnection()).mo56716a(c35981b, new C35983c("") {
                public final void onComplete() {
                    AppMethodBeat.m2504i(18816);
                    C4990ab.m7411d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                        AppMethodBeat.m2505o(18816);
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        C7060h.pYm.mo8378a(714, 6, 1, false);
                        AppMethodBeat.m2505o(18816);
                    }
                }
            }, new C7306ak());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        if (C45913b.aZc().aZg()) {
            C4990ab.m7417i("MicroMsg.CleanNewUI", "%s it scan finish", aZk());
            this.kyu = false;
            bgl();
            this.kyo.setText(getString(C25738R.string.f8811fp, new Object[]{"0%"}));
            C7060h.pYm.mo8378a(714, 50, 1, false);
        } else {
            C4990ab.m7421w("MicroMsg.CleanNewUI", "%s it scan not finish", aZk());
            this.kyw = C5046bo.anU();
            this.kyu = true;
            C4879a.xxA.mo10051b(this.kyB);
            C45913b.aZc().mo73755fD(true);
            bgj();
            mo45492dQ(0, 100);
        }
        C7060h.pYm.mo8378a(714, 1, 1, false);
        AppMethodBeat.m2505o(18824);
    }

    public void onResume() {
        AppMethodBeat.m2504i(18825);
        super.onResume();
        if (this.kyz > 0 && C6826j.bgd().kvV != 0) {
            long j = C6826j.bgd().kvV;
            C6826j.bgd();
            m43928E(j, C6826j.bfL());
        }
        AppMethodBeat.m2505o(18825);
    }

    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.m2504i(18826);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", aZk(), Boolean.valueOf(this.kyu));
        if (this.kyu) {
            C4879a.xxA.mo10053d(this.kyB);
            C45913b aZc = C45913b.aZc();
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = aZc.aZk();
            if (aZc.jZM != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            aZc.mo73754f(new C279137());
        }
        if (this.kyv != null) {
            this.kyv.stop();
        }
        AppMethodBeat.m2505o(18826);
    }

    /* renamed from: E */
    private void m43928E(long j, long j2) {
        AppMethodBeat.m2504i(18827);
        bgk();
        this.kym.setEnabled(true);
        this.kyk.setText(C5046bo.m7565ga(j));
        if (((int) ((100 * j) / j2)) > 0) {
            this.kyl.setText(getString(C25738R.string.aqu, new Object[]{r0 + "%"}));
            AppMethodBeat.m2505o(18827);
            return;
        }
        this.kyl.setText(C25738R.string.aqv);
        AppMethodBeat.m2505o(18827);
    }

    private void bgj() {
        AppMethodBeat.m2504i(18828);
        this.kyn.setEnabled(false);
        this.kyk.setVisibility(8);
        this.kyl.setVisibility(8);
        this.kyo.setVisibility(0);
        AppMethodBeat.m2505o(18828);
    }

    private void bgk() {
        AppMethodBeat.m2504i(18829);
        this.kyn.setEnabled(true);
        this.kyo.setVisibility(8);
        this.kyk.setVisibility(0);
        this.kyl.setVisibility(0);
        AppMethodBeat.m2505o(18829);
    }

    private void bgl() {
        AppMethodBeat.m2504i(18830);
        this.kyv = new C38796a(this.kyA);
        this.kyy = C5046bo.anU();
        C7305d.post(this.kyv, "cleanUI_calc");
        bgj();
        C7060h.pYm.mo8378a(714, 52, 1, false);
        AppMethodBeat.m2505o(18830);
    }

    public final int getLayoutId() {
        return 2130969147;
    }

    private boolean bgg() {
        AppMethodBeat.m2504i(18831);
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18831);
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
            AppMethodBeat.m2505o(18831);
            return true;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(18831);
            return false;
        }
    }

    private boolean bgf() {
        AppMethodBeat.m2504i(18832);
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
                            C7060h.pYm.mo8378a(714, 7, 1, false);
                            AppMethodBeat.m2505o(18832);
                            return true;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(18832);
                    return true;
                }
            }
            AppMethodBeat.m2505o(18832);
            return false;
        }
        AppMethodBeat.m2505o(18832);
        return false;
    }

    /* renamed from: dQ */
    public final void mo45492dQ(final int i, final int i2) {
        AppMethodBeat.m2504i(18833);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18819);
                CleanNewUI.this.kyo.setText(CleanNewUI.this.getString(C25738R.string.f8811fp, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.m2505o(18819);
            }
        });
        AppMethodBeat.m2505o(18833);
    }

    private String aZk() {
        AppMethodBeat.m2504i(18834);
        String str = hashCode();
        AppMethodBeat.m2505o(18834);
        return str;
    }
}
