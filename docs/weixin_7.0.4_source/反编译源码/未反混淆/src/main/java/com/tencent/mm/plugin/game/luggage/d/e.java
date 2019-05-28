package com.tencent.mm.plugin.game.luggage.d;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.mm.plugin.game.luggage.b;
import com.tencent.mm.plugin.game.luggage.e.a;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public class e extends d {
    public boolean mTI = false;
    protected GameWebPerformanceInfo mUN;
    private View mUV;
    private GameMenuImageButton mUW;
    private String mUX;
    public c mUY = new c() {
        public final void I(Bundle bundle) {
            AppMethodBeat.i(135963);
            f.a("com.tencent.mm", bundle, a.class, null);
            AppMethodBeat.o(135963);
        }
    };
    private long mUZ;
    private boolean mVa;
    private boolean mVb;
    private g mVc;

    public e(com.tencent.luggage.d.g gVar, k kVar, Bundle bundle) {
        super(gVar, kVar, bundle);
        AppMethodBeat.i(135968);
        ab.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", Long.valueOf(System.currentTimeMillis()));
        String string = bundle.getString("rawUrl");
        this.mUN = GameWebPerformanceInfo.kU(string);
        this.mUN.eBJ = bDI();
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc = NR(string);
        AppMethodBeat.o(135968);
    }

    public View wR() {
        AppMethodBeat.i(135969);
        View wR = super.wR();
        this.mUV = LayoutInflater.from(this.mContext).inflate(R.layout.a4r, this.uia, false);
        this.mUV.setVisibility(8);
        this.uia.addView(this.mUV, new LayoutParams(-2, -2, 17));
        ab.i("MicroMsg.GameWebPage", "create vie end, time: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(135969);
        return wR;
    }

    public final View bDD() {
        AppMethodBeat.i(135970);
        this.uhT = new c(this);
        com.tencent.mm.plugin.webview.luggage.k kVar = this.uhT;
        AppMethodBeat.o(135970);
        return kVar;
    }

    /* Access modifiers changed, original: protected */
    public g NR(String str) {
        AppMethodBeat.i(135971);
        g agh = g.agh(str);
        AppMethodBeat.o(135971);
        return agh;
    }

    public boolean NS(String str) {
        AppMethodBeat.i(135972);
        if (NQ(str) && b.bDp()) {
            ab.i("MicroMsg.GameWebPage", "isWePkg and has valid cache");
            if (this.mUN.eCh == 0) {
                this.mUN.eBO = 1;
            }
            this.mVb = true;
            AppMethodBeat.o(135972);
            return false;
        }
        this.mVb = false;
        if (str.equals(cWL()) && this.mUN.eCh == 0) {
            this.mUN.eCh = System.currentTimeMillis();
            ab.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", str, Long.valueOf(this.mUN.eCh));
        }
        boolean NS = super.NS(str);
        AppMethodBeat.o(135972);
        return NS;
    }

    public final void bDy() {
        AppMethodBeat.i(135973);
        this.uhT.bDy();
        AppMethodBeat.o(135973);
    }

    public void wU() {
        AppMethodBeat.i(135974);
        ab.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        if (this.mUN.eCa == 0) {
            this.mUN.eCa = System.currentTimeMillis();
        }
        this.mUZ = System.currentTimeMillis();
        this.mUY.uDp.onResume();
        super.wU();
        AppMethodBeat.o(135974);
    }

    public final void wW() {
        AppMethodBeat.i(135975);
        ab.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        this.mUZ = System.currentTimeMillis();
        this.mUY.uDp.onPause();
        int indexOf = this.bPe.xh().indexOf(this);
        if (indexOf <= 1 || !(((com.tencent.luggage.d.e) this.bPe.xh().get(indexOf - 1)) instanceof a)) {
            super.wW();
            AppMethodBeat.o(135975);
            return;
        }
        AppMethodBeat.o(135975);
    }

    public final void onDestroy() {
        AppMethodBeat.i(135976);
        ab.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        super.onDestroy();
        c.a(c.this);
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        this.mUN.eCk = System.currentTimeMillis();
        if (!this.bPP.getBoolean("from_bag", false)) {
            com.tencent.mm.game.report.api.c cVar = com.tencent.mm.game.report.api.c.eBG;
            if (cVar != null) {
                cVar.a(this.mUN);
            }
            com.tencent.mm.plugin.webview.ui.tools.game.e.agf(cWL());
        }
        GameWebPerformanceInfo.kW(cWL());
        g.agi(cWL());
        AppMethodBeat.o(135976);
    }

    public final void reload() {
        AppMethodBeat.i(135977);
        this.mVa = true;
        super.reload();
        AppMethodBeat.o(135977);
    }

    public void hK(boolean z) {
        AppMethodBeat.i(135978);
        super.hK(z);
        if (isFullScreen()) {
            this.mUX = this.bPP.getString("game_hv_menu_appid");
            if (bo.isNullOrNil(this.mUX)) {
                this.uhZ.setVisibility(0);
            } else {
                if (this.mUW == null) {
                    this.mUW = new GameMenuImageButton(this.mContext);
                    this.mUW.a(this.odV, new GameMenuImageButton.a() {
                        public final void bDJ() {
                            AppMethodBeat.i(135964);
                            e.this.bDy();
                            AppMethodBeat.o(135964);
                        }
                    });
                }
                this.uhZ.setVisibility(8);
                AppMethodBeat.o(135978);
                return;
            }
        }
        AppMethodBeat.o(135978);
    }

    public final void bDE() {
        AppMethodBeat.i(135979);
        if (!this.uio) {
            this.uiq = this.bPP.getInt("customize_status_bar_color");
            if (this.uiq != 0) {
                this.uir = this.bPP.getString("status_bar_style");
            } else {
                dd bDg = com.tencent.mm.plugin.game.commlib.a.bDg();
                if (!(bDg == null || bo.isNullOrNil(bDg.color))) {
                    try {
                        this.uiq = Color.parseColor(bDg.color);
                    } catch (IllegalArgumentException e) {
                        ab.e("MicroMsg.GameWebPage", "parse color: " + e.getMessage());
                    }
                    if (this.uiq == 0) {
                        this.uiq = android.support.v4.content.b.i(this.mContext, R.color.dt);
                    } else {
                        this.uir = bDg.mYo;
                    }
                }
            }
        }
        bDF();
        AppMethodBeat.o(135979);
    }

    public final void bDF() {
        AppMethodBeat.i(135980);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(135965);
                    e.this.bDF();
                    AppMethodBeat.o(135965);
                }
            });
            AppMethodBeat.o(135980);
        } else if (this.mContext instanceof LuggageGameWebViewUI) {
            if (((LuggageGameWebViewUI) this.mContext).W(this.uiq, bo.nullAsNil(this.uir).equals("black"))) {
                cWE();
                AppMethodBeat.o(135980);
                return;
            }
            this.uiq = this.mContext.getResources().getColor(R.color.l8);
            this.uir = "";
            cWE();
            AppMethodBeat.o(135980);
        } else if (com.tencent.mm.plugin.webview.luggage.c.a.a(this.mContext, this.uiq, this.uir)) {
            cWE();
            AppMethodBeat.o(135980);
        } else {
            this.uiq = this.mContext.getResources().getColor(R.color.l8);
            this.uir = "";
            cWE();
            AppMethodBeat.o(135980);
        }
    }

    public final boolean NQ(String str) {
        AppMethodBeat.i(135981);
        boolean NQ = ((d) this.uhQ).NQ(str);
        AppMethodBeat.o(135981);
        return NQ;
    }

    public void bDv() {
        AppMethodBeat.i(135982);
        this.mUV.setVisibility(0);
        AppMethodBeat.o(135982);
    }

    public final void bDG() {
        AppMethodBeat.i(135983);
        this.mUV.setVisibility(8);
        AppMethodBeat.o(135983);
    }

    public void g(String str, Bundle bundle) {
        AppMethodBeat.i(135984);
        ab.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        if (this.mVc.uDL == 0) {
            this.mVc.uDL = System.currentTimeMillis();
        }
        super.g(str, bundle);
        AppMethodBeat.o(135984);
    }

    public final void NT(String str) {
        AppMethodBeat.i(135985);
        super.NT(str);
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = System.currentTimeMillis();
        }
        AppMethodBeat.o(135985);
    }

    public final void bE(String str) {
        AppMethodBeat.i(135986);
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
        super.bE(str);
        if (this.mUN.eCf == 0) {
            this.mUN.eCf = currentTimeMillis;
        }
        if (this.mVc.uDM == 0) {
            this.mVc.uDM = currentTimeMillis;
        }
        String anh = bo.anh(str);
        if (this.mVb || (anh != null && anh.equals("game.weixin.qq.com"))) {
            this.bPN.bPC = com.tencent.luggage.d.a.a.bPT;
        } else {
            this.bPN.bPC = this.uik;
        }
        this.mUY.uDp.dbY();
        AppMethodBeat.o(135986);
    }

    public void bF(String str) {
        AppMethodBeat.i(135987);
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
        super.bF(str);
        if (this.mUN.eCg == 0) {
            this.mUN.eCg = currentTimeMillis;
        }
        if (this.mVc.uDN == 0) {
            this.mVc.uDN = currentTimeMillis;
        }
        if (this.mVb) {
            k kVar = this.bPN;
            if (kVar != null) {
                if (b.mHeaders != null) {
                    String str2 = "." + bo.anB(b.mTH);
                    String anB = bo.anB(b.mTH);
                    com.tencent.xweb.c.jx(ah.getContext());
                    com.tencent.xweb.b dTR = com.tencent.xweb.b.dTR();
                    for (String str3 : b.mHeaders.keySet()) {
                        dTR.setCookie(anB, str3 + "=" + ((String) b.mHeaders.get(str3)));
                    }
                    dTR.setCookie(anB, "httponly");
                    dTR.setCookie(str2, "httponly");
                    com.tencent.xweb.c.dTT();
                    com.tencent.xweb.c.sync();
                    ab.i("MicroMsg.LuggageGameUinKeyHolder", "cookies:%s", dTR.getCookie(anB));
                    b.mTI = true;
                }
                kVar.a(new com.tencent.luggage.d.c() {
                    public final String name() {
                        return "onGetA8KeyUrl";
                    }

                    public final JSONObject wQ() {
                        AppMethodBeat.i(135807);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", b.mTH);
                            jSONObject.put("set_cookie", b.mTI ? 1 : 0);
                        } catch (Exception e) {
                            ab.e("MicroMsg.LuggageGameUinKeyHolder", "onGetA8Key, e:" + e.getMessage());
                        }
                        AppMethodBeat.o(135807);
                        return jSONObject;
                    }
                });
            }
        } else if (this.mVa && NQ(str)) {
            n(this.mTH, this.uil);
        }
        this.mUY.uDp.dbZ();
        AppMethodBeat.o(135987);
    }

    public final void NN(String str) {
        AppMethodBeat.i(135988);
        super.NN(str);
        if (this.mVc.uDO == 0) {
            this.mVc.uDO = System.currentTimeMillis();
        }
        AppMethodBeat.o(135988);
    }

    public void e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(135989);
        super.e(str, str2, map);
        d dVar = (d) this.bPN.xr();
        dVar.mTH = str2;
        dVar.mUG = map;
        if (bo.isNullOrNil(str2)) {
            ab.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
        } else if (Uri.parse(str2).getHost().equals("game.weixin.qq.com")) {
            b.mTH = str2;
            b.mHeaders = map;
            b.JQ = System.currentTimeMillis() / 1000;
        } else {
            ab.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (str.equals(cWL())) {
            ab.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", Long.valueOf(currentTimeMillis));
            this.mUN.eCi = currentTimeMillis;
        }
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = currentTimeMillis;
        }
        if (this.mVc.uDP == 0) {
            this.mVc.uDP = System.currentTimeMillis();
        }
        if (NQ(str)) {
            n(str2, map);
        }
        AppMethodBeat.o(135989);
    }

    private void n(final String str, final Map<String, String> map) {
        AppMethodBeat.i(135990);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameWebPage", "fullUrl is null, return");
            AppMethodBeat.o(135990);
            return;
        }
        this.mHandler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135967);
                if (!(map == null || map.size() == 0)) {
                    e.this.mTI = true;
                    com.tencent.xweb.c.jx(e.this.mContext);
                    com.tencent.xweb.b dTR = com.tencent.xweb.b.dTR();
                    for (String str : map.keySet()) {
                        dTR.setCookie(bo.anB(str), str + "=" + ((String) map.get(str)));
                    }
                    dTR.setCookie(bo.anB(str), "httponly");
                    com.tencent.xweb.c.dTT();
                    com.tencent.xweb.c.sync();
                    ab.i("MicroMsg.GameWebPage", "cookies:%s", dTR.getCookie(bo.anB(e.this.mTH)));
                }
                e.this.bPN.a(new com.tencent.luggage.d.c() {
                    public final String name() {
                        return "onGetA8KeyUrl";
                    }

                    public final JSONObject wQ() {
                        AppMethodBeat.i(135966);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            String str = "set_cookie";
                            int i = (map == null || map.size() == 0) ? 0 : 1;
                            jSONObject.put(str, i);
                        } catch (Exception e) {
                            ab.e("MicroMsg.GameWebPage", "onGetA8Key, e:" + e.getMessage());
                        }
                        AppMethodBeat.o(135966);
                        return jSONObject;
                    }
                });
                AppMethodBeat.o(135967);
            }
        });
        AppMethodBeat.o(135990);
    }

    public final com.tencent.mm.plugin.wepkg.c bDH() {
        AppMethodBeat.i(135991);
        com.tencent.mm.plugin.wepkg.c wePkgPlugin = ((d) this.uhQ).getWePkgPlugin();
        AppMethodBeat.o(135991);
        return wePkgPlugin;
    }

    public final String bDI() {
        AppMethodBeat.i(135992);
        String str = (hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (cWL().hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(135992);
        return str;
    }

    public final boolean wD(int i) {
        AppMethodBeat.i(135993);
        if (this.bPN.xp() == com.tencent.luggage.d.a.a.bPT) {
            AppMethodBeat.o(135993);
            return true;
        } else if (this.bPN.xp() == com.tencent.luggage.d.a.a.bPU) {
            AppMethodBeat.o(135993);
            return false;
        } else {
            boolean wD = super.wD(i);
            AppMethodBeat.o(135993);
            return wD;
        }
    }
}
