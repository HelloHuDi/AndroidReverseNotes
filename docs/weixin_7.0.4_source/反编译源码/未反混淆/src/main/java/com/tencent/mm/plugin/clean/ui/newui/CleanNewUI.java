package com.tencent.mm.plugin.clean.ui.newui;

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
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bq;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity implements g {
    private long kwP;
    private String kwQ = "com.tencent.qqpimsecure";
    private String kwR = "00B1208638DE0FCD3E920886D658DAF6";
    private String kwS = "11206657";
    private JSONObject kwT;
    private c kyR;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18925);
        boolean bgf = cleanNewUI.bgf();
        AppMethodBeat.o(18925);
        return bgf;
    }

    static /* synthetic */ boolean b(CleanNewUI cleanNewUI) {
        AppMethodBeat.i(18926);
        boolean bgg = cleanNewUI.bgg();
        AppMethodBeat.o(18926);
        return bgg;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18917);
        super.onCreate(bundle);
        setMMTitle((int) R.string.aqq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(18911);
                CleanNewUI.this.finish();
                AppMethodBeat.o(18911);
                return false;
            }
        });
        this.kyj = (LinearLayout) findViewById(R.id.ax0);
        this.kyk = (TextView) findViewById(R.id.ax1);
        this.kyl = (TextView) findViewById(R.id.ax2);
        this.kym = (Button) findViewById(R.id.ax3);
        this.kyn = (Button) findViewById(R.id.ax4);
        this.kyn.setVisibility(8);
        this.kyo = (TextView) findViewById(R.id.awb);
        this.kym.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18912);
                ab.i("MicroMsg.CleanNewUI", "goto clean msg ui");
                CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
                AppMethodBeat.o(18912);
            }
        });
        this.kyn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18913);
                ab.i("MicroMsg.CleanNewUI", "clean wechat cache");
                AppMethodBeat.o(18913);
            }
        });
        this.kyp = (LinearLayout) findViewById(R.id.ax5);
        this.kyq = (TextView) findViewById(R.id.ax6);
        this.kyr = (TextView) findViewById(R.id.ax7);
        this.kys = (Button) findViewById(R.id.ax8);
        this.kyt = findViewById(R.id.ax9);
        this.kys.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(18915);
                ab.i("MicroMsg.CleanNewUI", "qq mgr btn click");
                h.pYm.a(282, 5, 1, false);
                if (!CleanNewUI.a(CleanNewUI.this)) {
                    if (CleanNewUI.b(CleanNewUI.this)) {
                        com.tencent.mm.ui.base.h.d(CleanNewUI.this, CleanNewUI.this.getString(R.string.aq4, new Object[]{bo.my(CleanNewUI.this.kwP)}), "", CleanNewUI.this.getString(R.string.p_), CleanNewUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(18914);
                                try {
                                    ab.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new URL(CleanNewUI.this.kwT.getString("url")), CleanNewUI.this.kwT.getString("md5"));
                                    a aVar = new a();
                                    aVar.Iv("wesecure.apk");
                                    aVar.It(r0.toString());
                                    aVar.ga(true);
                                    aVar.Iw(r1);
                                    aVar.tN(1);
                                    d.bij().a(aVar.kNl);
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                                }
                                h.pYm.a(282, 7, 1, false);
                                AppMethodBeat.o(18914);
                            }
                        }, null);
                        AppMethodBeat.o(18915);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.b(CleanNewUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(18915);
            }
        });
        if (bq.dpN() || com.tencent.mm.sdk.platformtools.g.cdf == 1) {
            this.kys.setVisibility(8);
            this.kyt.setVisibility(0);
        }
        this.kyq.setText(bo.ga(c.bfL() - c.bfM()));
        this.kyr.setText(getString(R.string.aq9, new Object[]{bo.ga(r2)}));
        com.tencent.mm.cj.c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        try {
            b bVar = new b();
            bVar.xxO = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new com.tencent.mm.sdk.c.b.c("") {
                public final void onComplete() {
                    AppMethodBeat.i(18916);
                    ab.d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                        AppMethodBeat.o(18916);
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        h.pYm.a(282, 8, 1, false);
                        AppMethodBeat.o(18916);
                    }
                }
            }, new ak());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        com.tencent.mm.plugin.clean.c.d.a(new com.tencent.mm.plugin.clean.c.a.b());
        if (com.tencent.mm.plugin.clean.c.d.bfS() == null) {
            com.tencent.mm.plugin.clean.c.a.b bfQ = com.tencent.mm.plugin.clean.c.d.bfQ();
            if (bfQ != null) {
                this.kyR = new c(bfQ, this);
                com.tencent.mm.sdk.g.d.post(this.kyR, "CleanUI_clean");
                this.kyn.setEnabled(false);
                this.kyk.setVisibility(8);
                this.kyl.setVisibility(8);
                this.kyo.setVisibility(0);
                this.kyo.setText(getString(R.string.fp, new Object[]{"0%"}));
            }
        }
        AppMethodBeat.o(18917);
    }

    public void onResume() {
        AppMethodBeat.i(18918);
        super.onResume();
        if (com.tencent.mm.plugin.clean.c.d.bfS() != null) {
            E(com.tencent.mm.plugin.clean.c.d.bfT(), c.bfL());
        }
        AppMethodBeat.o(18918);
    }

    private void E(long j, long j2) {
        AppMethodBeat.i(18919);
        bgk();
        this.kyk.setText(bo.ga(j));
        int i = (int) ((100 * j) / j2);
        this.kyl.setText(getString(R.string.aqu, new Object[]{i + "%"}));
        AppMethodBeat.o(18919);
    }

    private void bgk() {
        AppMethodBeat.i(18920);
        this.kyn.setEnabled(true);
        this.kyo.setVisibility(8);
        this.kyk.setVisibility(0);
        this.kyl.setVisibility(0);
        AppMethodBeat.o(18920);
    }

    public final int getLayoutId() {
        return R.layout.oo;
    }

    public final void dO(int i, int i2) {
        AppMethodBeat.i(18921);
        this.kyo.setText(getString(R.string.fp, new Object[]{((i * 100) / i2) + "%"}));
        AppMethodBeat.o(18921);
    }

    public final void a(long j, long j2, long j3, ArrayList<com.tencent.mm.plugin.clean.c.b> arrayList, long j4, HashSet<String> hashSet) {
        AppMethodBeat.i(18922);
        ab.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        com.tencent.mm.plugin.clean.c.d.hg(j);
        com.tencent.mm.plugin.clean.c.d.hd(j2);
        com.tencent.mm.plugin.clean.c.d.hf(j4);
        com.tencent.mm.plugin.clean.c.d.b(hashSet);
        com.tencent.mm.plugin.clean.c.d.he(j3);
        com.tencent.mm.plugin.clean.c.d.u(arrayList);
        E(com.tencent.mm.plugin.clean.c.d.bfT(), c.bfL());
        AppMethodBeat.o(18922);
    }

    private boolean bgg() {
        AppMethodBeat.i(18923);
        aw.ZK();
        String str = (String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18923);
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
            AppMethodBeat.o(18923);
            return true;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            AppMethodBeat.o(18923);
            return false;
        }
    }

    private boolean bgf() {
        AppMethodBeat.i(18924);
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
                            h.pYm.a(282, 6, 1, false);
                            AppMethodBeat.o(18924);
                            return true;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                    }
                    AppMethodBeat.o(18924);
                    return true;
                }
            }
            AppMethodBeat.o(18924);
            return false;
        }
        AppMethodBeat.o(18924);
        return false;
    }
}
