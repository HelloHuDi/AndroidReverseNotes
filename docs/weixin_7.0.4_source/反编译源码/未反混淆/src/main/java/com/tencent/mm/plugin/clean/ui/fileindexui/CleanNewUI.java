package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;
    private c kyA = new c() {
        public final void dN(int i, int i2) {
            AppMethodBeat.i(18817);
            if (!CleanNewUI.this.kyu) {
                CleanNewUI.this.dQ(i, i2);
            }
            AppMethodBeat.o(18817);
        }

        public final void a(long j, long j2, long j3, HashSet<String> hashSet, HashMap<String, Long> hashMap) {
            AppMethodBeat.i(18818);
            CleanNewUI.this.kyz = bo.anU();
            CleanNewUI cleanNewUI = CleanNewUI.this;
            j.bgd().kvV = j;
            j.bgd().kvW = j2;
            j.bgd().kvX = j3;
            j.bgd().kwI = hashMap;
            j.bgd().kww = hashSet;
            al.d(new AnonymousClass8(j));
            h.pYm.a(714, 53, 1, false);
            long g = CleanNewUI.this.kyx - CleanNewUI.this.kyw;
            long i = CleanNewUI.this.kyz - CleanNewUI.this.kyy;
            ab.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", Long.valueOf(CleanNewUI.this.kyx), Long.valueOf(CleanNewUI.this.kyw), Long.valueOf(g), Long.valueOf(CleanNewUI.this.kyz), Long.valueOf(CleanNewUI.this.kyy), Long.valueOf(i), Long.valueOf(g + i));
            h.pYm.e(14556, Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.kyw), Long.valueOf(CleanNewUI.this.kyx), Long.valueOf(g));
            h.pYm.e(14556, Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.kyy), Long.valueOf(CleanNewUI.this.kyz), Long.valueOf(i));
            h.pYm.e(14556, Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(g + i));
            AppMethodBeat.o(18818);
        }
    };
    private com.tencent.mm.sdk.b.c<ju> kyB = new com.tencent.mm.sdk.b.c<ju>() {
        {
            AppMethodBeat.i(18821);
            this.xxI = ju.class.getName().hashCode();
            AppMethodBeat.o(18821);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(18822);
            ju juVar = (ju) bVar;
            if (juVar == null || juVar.cES == null) {
                AppMethodBeat.o(18822);
            } else {
                ab.i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.a(CleanNewUI.this), Long.valueOf(juVar.cES.progress), Long.valueOf(juVar.cES.cET), Boolean.valueOf(juVar.cES.cco));
                if (juVar.cES.cco) {
                    CleanNewUI.this.kyx = bo.anU();
                    CleanNewUI.l(CleanNewUI.this);
                    h.pYm.a(714, 51, 1, false);
                } else {
                    int i = (int) (((((float) juVar.cES.progress) * 1.0f) / ((float) juVar.cES.cET)) * 100.0f);
                    CleanNewUI cleanNewUI = CleanNewUI.this;
                    if (i <= 0) {
                        i = 0;
                    }
                    cleanNewUI.dQ(i, 100);
                }
                AppMethodBeat.o(18822);
            }
            return false;
        }
    };
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
    private a kyv;
    private long kyw = 0;
    private long kyx = 0;
    private long kyy = 0;
    private long kyz = 0;

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ long kyE;

        AnonymousClass8(long j) {
            this.kyE = j;
        }

        public final void run() {
            AppMethodBeat.i(18820);
            CleanNewUI cleanNewUI = CleanNewUI.this;
            long j = this.kyE;
            j.bgd();
            CleanNewUI.a(cleanNewUI, j, j.bfL());
            AppMethodBeat.o(18820);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CleanNewUI() {
        AppMethodBeat.i(18823);
        AppMethodBeat.o(18823);
    }

    static /* synthetic */ String a(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18835);
        String aZk = cleanNewUI.aZk();
        AppMethodBeat.o(18835);
        return aZk;
    }

    static /* synthetic */ void a(CleanNewUI cleanNewUI, long j, long j2) {
        AppMethodBeat.i(18838);
        cleanNewUI.E(j, j2);
        AppMethodBeat.o(18838);
    }

    static /* synthetic */ boolean b(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18836);
        boolean bgf = cleanNewUI.bgf();
        AppMethodBeat.o(18836);
        return bgf;
    }

    static /* synthetic */ boolean c(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18837);
        boolean bgg = cleanNewUI.bgg();
        AppMethodBeat.o(18837);
        return bgg;
    }

    static /* synthetic */ void l(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18839);
        cleanNewUI.bgl();
        AppMethodBeat.o(18839);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18824);
        super.onCreate(bundle);
        setMMTitle((int) R.string.aqb);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18811);
                CleanNewUI.this.finish();
                AppMethodBeat.o(18811);
                return false;
            }
        });
        this.kyj = (LinearLayout) findViewById(R.id.ax0);
        this.kyk = (TextView) findViewById(R.id.ax1);
        this.kyl = (TextView) findViewById(R.id.ax2);
        this.kym = (Button) findViewById(R.id.ax3);
        this.kym.setEnabled(false);
        this.kyn = (Button) findViewById(R.id.ax4);
        this.kyn.setVisibility(8);
        this.kyo = (TextView) findViewById(R.id.awb);
        this.kym.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18812);
                ab.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", CleanNewUI.a(CleanNewUI.this));
                h.pYm.a(714, 2, 1, false);
                CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
                AppMethodBeat.o(18812);
            }
        });
        this.kyn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18813);
                ab.i("MicroMsg.CleanNewUI", "clean wechat cache");
                AppMethodBeat.o(18813);
            }
        });
        this.kyp = (LinearLayout) findViewById(R.id.ax5);
        this.kyq = (TextView) findViewById(R.id.ax6);
        this.kyr = (TextView) findViewById(R.id.ax7);
        this.kys = (Button) findViewById(R.id.ax8);
        this.kyt = findViewById(R.id.ax9);
        this.kys.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18815);
                ab.i("MicroMsg.CleanNewUI", "qq mgr btn click");
                h.pYm.a(714, 3, 1, false);
                if (!CleanNewUI.b(CleanNewUI.this)) {
                    if (CleanNewUI.c(CleanNewUI.this)) {
                        com.tencent.mm.ui.base.h.d(CleanNewUI.this, CleanNewUI.this.getString(R.string.aq4, new Object[]{bo.my(CleanNewUI.this.kwP)}), "", CleanNewUI.this.getString(R.string.p_), CleanNewUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(18814);
                                try {
                                    ab.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new URL(CleanNewUI.this.kwT.getString("url")), CleanNewUI.this.kwT.getString("md5"));
                                    e.a aVar = new e.a();
                                    aVar.Iv("wesecure.apk");
                                    aVar.It(r0.toString());
                                    aVar.ga(true);
                                    aVar.Iw(r1);
                                    aVar.tN(1);
                                    d.bij().a(aVar.kNl);
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                                }
                                h.pYm.a(714, 4, 1, false);
                                AppMethodBeat.o(18814);
                            }
                        }, null);
                        AppMethodBeat.o(18815);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.b(CleanNewUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    h.pYm.a(714, 5, 1, false);
                }
                AppMethodBeat.o(18815);
            }
        });
        if (bq.dpN() || g.cdf == 1) {
            this.kys.setVisibility(8);
            this.kyt.setVisibility(0);
        }
        j.bgd();
        long bfL = j.bfL();
        j.bgd();
        this.kyq.setText(bo.ga(bfL - j.bfM()));
        this.kyr.setText(getString(R.string.aq9, new Object[]{bo.ga(r2)}));
        com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        try {
            com.tencent.mm.sdk.c.b.b bVar = new com.tencent.mm.sdk.c.b.b();
            bVar.xxO = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new com.tencent.mm.sdk.c.b.c("") {
                public final void onComplete() {
                    AppMethodBeat.i(18816);
                    ab.d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                        AppMethodBeat.o(18816);
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        h.pYm.a(714, 6, 1, false);
                        AppMethodBeat.o(18816);
                    }
                }
            }, new ak());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        if (com.tencent.mm.plugin.f.b.aZc().aZg()) {
            ab.i("MicroMsg.CleanNewUI", "%s it scan finish", aZk());
            this.kyu = false;
            bgl();
            this.kyo.setText(getString(R.string.fp, new Object[]{"0%"}));
            h.pYm.a(714, 50, 1, false);
        } else {
            ab.w("MicroMsg.CleanNewUI", "%s it scan not finish", aZk());
            this.kyw = bo.anU();
            this.kyu = true;
            com.tencent.mm.sdk.b.a.xxA.b(this.kyB);
            com.tencent.mm.plugin.f.b.aZc().fD(true);
            bgj();
            dQ(0, 100);
        }
        h.pYm.a(714, 1, 1, false);
        AppMethodBeat.o(18824);
    }

    public void onResume() {
        AppMethodBeat.i(18825);
        super.onResume();
        if (this.kyz > 0 && j.bgd().kvV != 0) {
            long j = j.bgd().kvV;
            j.bgd();
            E(j, j.bfL());
        }
        AppMethodBeat.o(18825);
    }

    public void onDestroy() {
        boolean z = false;
        AppMethodBeat.i(18826);
        super.onDestroy();
        ab.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", aZk(), Boolean.valueOf(this.kyu));
        if (this.kyu) {
            com.tencent.mm.sdk.b.a.xxA.d(this.kyB);
            com.tencent.mm.plugin.f.b aZc = com.tencent.mm.plugin.f.b.aZc();
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = aZc.aZk();
            if (aZc.jZM != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            aZc.f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18586);
                    b.this.jZL = false;
                    if (b.this.jZM != null) {
                        if (b.this.jZH != null) {
                            b.this.jZH;
                            al.af(b.this.jZM);
                        }
                        b.this.jZM.isStop = true;
                        b.this.jZM = null;
                        h.pYm.a(664, 8, 1, false);
                    }
                    AppMethodBeat.o(18586);
                }
            });
        }
        if (this.kyv != null) {
            this.kyv.stop();
        }
        AppMethodBeat.o(18826);
    }

    private void E(long j, long j2) {
        AppMethodBeat.i(18827);
        bgk();
        this.kym.setEnabled(true);
        this.kyk.setText(bo.ga(j));
        if (((int) ((100 * j) / j2)) > 0) {
            this.kyl.setText(getString(R.string.aqu, new Object[]{r0 + "%"}));
            AppMethodBeat.o(18827);
            return;
        }
        this.kyl.setText(R.string.aqv);
        AppMethodBeat.o(18827);
    }

    private void bgj() {
        AppMethodBeat.i(18828);
        this.kyn.setEnabled(false);
        this.kyk.setVisibility(8);
        this.kyl.setVisibility(8);
        this.kyo.setVisibility(0);
        AppMethodBeat.o(18828);
    }

    private void bgk() {
        AppMethodBeat.i(18829);
        this.kyn.setEnabled(true);
        this.kyo.setVisibility(8);
        this.kyk.setVisibility(0);
        this.kyl.setVisibility(0);
        AppMethodBeat.o(18829);
    }

    private void bgl() {
        AppMethodBeat.i(18830);
        this.kyv = new a(this.kyA);
        this.kyy = bo.anU();
        com.tencent.mm.sdk.g.d.post(this.kyv, "cleanUI_calc");
        bgj();
        h.pYm.a(714, 52, 1, false);
        AppMethodBeat.o(18830);
    }

    public final int getLayoutId() {
        return R.layout.oo;
    }

    private boolean bgg() {
        AppMethodBeat.i(18831);
        aw.ZK();
        String str = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18831);
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
            AppMethodBeat.o(18831);
            return true;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            AppMethodBeat.o(18831);
            return false;
        }
    }

    private boolean bgf() {
        AppMethodBeat.i(18832);
        bgg();
        if (p.u(this.mController.ylL, this.kwQ)) {
            Signature[] bx = p.bx(this, this.kwQ);
            if (!(bx == null || bx[0] == null)) {
                String x = com.tencent.mm.a.g.x(bx[0].toByteArray());
                if (x != null && x.equalsIgnoreCase(this.kwR)) {
                    try {
                        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.kwQ);
                        if (launchIntentForPackage != null) {
                            Bundle bundle = new Bundle();
                            p.j(bundle, this.kwS);
                            launchIntentForPackage.putExtras(bundle);
                            launchIntentForPackage.addFlags(268435456);
                            startActivity(launchIntentForPackage);
                            h.pYm.a(714, 7, 1, false);
                            AppMethodBeat.o(18832);
                            return true;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(18832);
                    return true;
                }
            }
            AppMethodBeat.o(18832);
            return false;
        }
        AppMethodBeat.o(18832);
        return false;
    }

    public final void dQ(final int i, final int i2) {
        AppMethodBeat.i(18833);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18819);
                CleanNewUI.this.kyo.setText(CleanNewUI.this.getString(R.string.fp, new Object[]{((i * 100) / i2) + "%"}));
                AppMethodBeat.o(18819);
            }
        });
        AppMethodBeat.o(18833);
    }

    private String aZk() {
        AppMethodBeat.i(18834);
        String str = hashCode();
        AppMethodBeat.o(18834);
        return str;
    }
}
