package com.tencent.p177mm.plugin.game.luggage.p432d;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.content.C0380b;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C41709g;
import com.tencent.luggage.p146d.C8860e;
import com.tencent.luggage.p146d.p1171a.C25685a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.luggage.C28211b;
import com.tencent.p177mm.plugin.game.luggage.C28211b.C247731;
import com.tencent.p177mm.plugin.game.luggage.LuggageGameWebViewUI;
import com.tencent.p177mm.plugin.game.luggage.p1271e.C20980a;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C46417a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C14610c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43961e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43963g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.GameMenuImageButton;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.GameMenuImageButton.C14615a;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.d.e */
public class C12140e extends C24905d {
    public boolean mTI = false;
    protected GameWebPerformanceInfo mUN;
    private View mUV;
    private GameMenuImageButton mUW;
    private String mUX;
    public C14610c mUY = new C121411();
    private long mUZ;
    private boolean mVa;
    private boolean mVb;
    private C43963g mVc;

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.e$3 */
    class C121393 implements Runnable {
        C121393() {
        }

        public final void run() {
            AppMethodBeat.m2504i(135965);
            C12140e.this.bDF();
            AppMethodBeat.m2505o(135965);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.e$1 */
    class C121411 extends C14610c {
        C121411() {
        }

        /* renamed from: I */
        public final void mo9702I(Bundle bundle) {
            AppMethodBeat.m2504i(135963);
            C9549f.m17012a("com.tencent.mm", bundle, C20980a.class, null);
            AppMethodBeat.m2505o(135963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.luggage.d.e$2 */
    class C121422 implements C14615a {
        C121422() {
        }

        public final void bDJ() {
            AppMethodBeat.m2504i(135964);
            C12140e.this.bDy();
            AppMethodBeat.m2505o(135964);
        }
    }

    public C12140e(C41709g c41709g, C32186k c32186k, Bundle bundle) {
        super(c41709g, c32186k, bundle);
        AppMethodBeat.m2504i(135968);
        C4990ab.m7417i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", Long.valueOf(System.currentTimeMillis()));
        String string = bundle.getString("rawUrl");
        this.mUN = GameWebPerformanceInfo.m63878kU(string);
        this.mUN.eBJ = bDI();
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc = mo23965NR(string);
        AppMethodBeat.m2505o(135968);
    }

    /* renamed from: wR */
    public View mo20042wR() {
        AppMethodBeat.m2504i(135969);
        View wR = super.mo20042wR();
        this.mUV = LayoutInflater.from(this.mContext).inflate(2130969744, this.uia, false);
        this.mUV.setVisibility(8);
        this.uia.addView(this.mUV, new LayoutParams(-2, -2, 17));
        C4990ab.m7417i("MicroMsg.GameWebPage", "create vie end, time: %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(135969);
        return wR;
    }

    public final View bDD() {
        AppMethodBeat.m2504i(135970);
        this.uhT = new C24775c(this);
        C22857k c22857k = this.uhT;
        AppMethodBeat.m2505o(135970);
        return c22857k;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: NR */
    public C43963g mo23965NR(String str) {
        AppMethodBeat.m2504i(135971);
        C43963g agh = C43963g.agh(str);
        AppMethodBeat.m2505o(135971);
        return agh;
    }

    /* renamed from: NS */
    public boolean mo23966NS(String str) {
        AppMethodBeat.m2504i(135972);
        if (mo23964NQ(str) && C28211b.bDp()) {
            C4990ab.m7416i("MicroMsg.GameWebPage", "isWePkg and has valid cache");
            if (this.mUN.eCh == 0) {
                this.mUN.eBO = 1;
            }
            this.mVb = true;
            AppMethodBeat.m2505o(135972);
            return false;
        }
        this.mVb = false;
        if (str.equals(cWL()) && this.mUN.eCh == 0) {
            this.mUN.eCh = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", str, Long.valueOf(this.mUN.eCh));
        }
        boolean NS = super.mo23966NS(str);
        AppMethodBeat.m2505o(135972);
        return NS;
    }

    public final void bDy() {
        AppMethodBeat.m2504i(135973);
        this.uhT.bDy();
        AppMethodBeat.m2505o(135973);
    }

    /* renamed from: wU */
    public void mo20045wU() {
        AppMethodBeat.m2504i(135974);
        C4990ab.m7417i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        if (this.mUN.eCa == 0) {
            this.mUN.eCa = System.currentTimeMillis();
        }
        this.mUZ = System.currentTimeMillis();
        this.mUY.uDp.onResume();
        super.mo20045wU();
        AppMethodBeat.m2505o(135974);
    }

    /* renamed from: wW */
    public final void mo20047wW() {
        AppMethodBeat.m2504i(135975);
        C4990ab.m7417i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        this.mUZ = System.currentTimeMillis();
        this.mUY.uDp.onPause();
        int indexOf = this.bPe.mo43476xh().indexOf(this);
        if (indexOf <= 1 || !(((C8860e) this.bPe.mo43476xh().get(indexOf - 1)) instanceof C39210a)) {
            super.mo20047wW();
            AppMethodBeat.m2505o(135975);
            return;
        }
        AppMethodBeat.m2505o(135975);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(135976);
        C4990ab.m7417i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        super.onDestroy();
        C14610c.m22839a(C14610c.this);
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        this.mUN.eCk = System.currentTimeMillis();
        if (!this.bPP.getBoolean("from_bag", false)) {
            C37860c c37860c = C37860c.eBG;
            if (c37860c != null) {
                c37860c.mo60577a(this.mUN);
            }
            C43961e.agf(cWL());
        }
        GameWebPerformanceInfo.m63880kW(cWL());
        C43963g.agi(cWL());
        AppMethodBeat.m2505o(135976);
    }

    public final void reload() {
        AppMethodBeat.m2504i(135977);
        this.mVa = true;
        super.reload();
        AppMethodBeat.m2505o(135977);
    }

    /* renamed from: hK */
    public void mo23979hK(boolean z) {
        AppMethodBeat.m2504i(135978);
        super.mo23979hK(z);
        if (isFullScreen()) {
            this.mUX = this.bPP.getString("game_hv_menu_appid");
            if (C5046bo.isNullOrNil(this.mUX)) {
                this.uhZ.setVisibility(0);
            } else {
                if (this.mUW == null) {
                    this.mUW = new GameMenuImageButton(this.mContext);
                    this.mUW.mo26872a(this.odV, new C121422());
                }
                this.uhZ.setVisibility(8);
                AppMethodBeat.m2505o(135978);
                return;
            }
        }
        AppMethodBeat.m2505o(135978);
    }

    public final void bDE() {
        AppMethodBeat.m2504i(135979);
        if (!this.uio) {
            this.uiq = this.bPP.getInt("customize_status_bar_color");
            if (this.uiq != 0) {
                this.uir = this.bPP.getString("status_bar_style");
            } else {
                C39197dd bDg = C45985a.bDg();
                if (!(bDg == null || C5046bo.isNullOrNil(bDg.color))) {
                    try {
                        this.uiq = Color.parseColor(bDg.color);
                    } catch (IllegalArgumentException e) {
                        C4990ab.m7412e("MicroMsg.GameWebPage", "parse color: " + e.getMessage());
                    }
                    if (this.uiq == 0) {
                        this.uiq = C0380b.m652i(this.mContext, C25738R.color.f11695dt);
                    } else {
                        this.uir = bDg.mYo;
                    }
                }
            }
        }
        bDF();
        AppMethodBeat.m2505o(135979);
    }

    public final void bDF() {
        AppMethodBeat.m2504i(135980);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new C121393());
            AppMethodBeat.m2505o(135980);
        } else if (this.mContext instanceof LuggageGameWebViewUI) {
            if (((LuggageGameWebViewUI) this.mContext).mo62087W(this.uiq, C5046bo.nullAsNil(this.uir).equals("black"))) {
                cWE();
                AppMethodBeat.m2505o(135980);
                return;
            }
            this.uiq = this.mContext.getResources().getColor(C25738R.color.f11906l8);
            this.uir = "";
            cWE();
            AppMethodBeat.m2505o(135980);
        } else if (C46417a.m87413a(this.mContext, this.uiq, this.uir)) {
            cWE();
            AppMethodBeat.m2505o(135980);
        } else {
            this.uiq = this.mContext.getResources().getColor(C25738R.color.f11906l8);
            this.uir = "";
            cWE();
            AppMethodBeat.m2505o(135980);
        }
    }

    /* renamed from: NQ */
    public final boolean mo23964NQ(String str) {
        AppMethodBeat.m2504i(135981);
        boolean NQ = ((C3228d) this.uhQ).mo7542NQ(str);
        AppMethodBeat.m2505o(135981);
        return NQ;
    }

    public void bDv() {
        AppMethodBeat.m2504i(135982);
        this.mUV.setVisibility(0);
        AppMethodBeat.m2505o(135982);
    }

    public final void bDG() {
        AppMethodBeat.m2504i(135983);
        this.mUV.setVisibility(8);
        AppMethodBeat.m2505o(135983);
    }

    /* renamed from: g */
    public void mo20038g(String str, Bundle bundle) {
        AppMethodBeat.m2504i(135984);
        C4990ab.m7417i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
        if (this.mVc.uDL == 0) {
            this.mVc.uDL = System.currentTimeMillis();
        }
        super.mo20038g(str, bundle);
        AppMethodBeat.m2505o(135984);
    }

    /* renamed from: NT */
    public final void mo23967NT(String str) {
        AppMethodBeat.m2504i(135985);
        super.mo23967NT(str);
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(135985);
    }

    /* renamed from: bE */
    public final void mo23976bE(String str) {
        AppMethodBeat.m2504i(135986);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
        super.mo23976bE(str);
        if (this.mUN.eCf == 0) {
            this.mUN.eCf = currentTimeMillis;
        }
        if (this.mVc.uDM == 0) {
            this.mVc.uDM = currentTimeMillis;
        }
        String anh = C5046bo.anh(str);
        if (this.mVb || (anh != null && anh.equals("game.weixin.qq.com"))) {
            this.bPN.bPC = C25685a.bPT;
        } else {
            this.bPN.bPC = this.uik;
        }
        this.mUY.uDp.dbY();
        AppMethodBeat.m2505o(135986);
    }

    /* renamed from: bF */
    public void mo23977bF(String str) {
        AppMethodBeat.m2504i(135987);
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
        super.mo23977bF(str);
        if (this.mUN.eCg == 0) {
            this.mUN.eCg = currentTimeMillis;
        }
        if (this.mVc.uDN == 0) {
            this.mVc.uDN = currentTimeMillis;
        }
        if (this.mVb) {
            C32186k c32186k = this.bPN;
            if (c32186k != null) {
                if (C28211b.mHeaders != null) {
                    String str2 = "." + C5046bo.anB(C28211b.mTH);
                    String anB = C5046bo.anB(C28211b.mTH);
                    C24526c.m38159jx(C4996ah.getContext());
                    C44576b dTR = C44576b.dTR();
                    for (String str3 : C28211b.mHeaders.keySet()) {
                        dTR.setCookie(anB, str3 + "=" + ((String) C28211b.mHeaders.get(str3)));
                    }
                    dTR.setCookie(anB, "httponly");
                    dTR.setCookie(str2, "httponly");
                    C24526c.dTT();
                    C24526c.sync();
                    C4990ab.m7417i("MicroMsg.LuggageGameUinKeyHolder", "cookies:%s", dTR.getCookie(anB));
                    C28211b.mTI = true;
                }
                c32186k.mo52826a(new C247731());
            }
        } else if (this.mVa && mo23964NQ(str)) {
            m20067n(this.mTH, this.uil);
        }
        this.mUY.uDp.dbZ();
        AppMethodBeat.m2505o(135987);
    }

    /* renamed from: NN */
    public final void mo23963NN(String str) {
        AppMethodBeat.m2504i(135988);
        super.mo23963NN(str);
        if (this.mVc.uDO == 0) {
            this.mVc.uDO = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(135988);
    }

    /* renamed from: e */
    public void mo23978e(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(135989);
        super.mo23978e(str, str2, map);
        C3228d c3228d = (C3228d) this.bPN.mo52835xr();
        c3228d.mTH = str2;
        c3228d.mUG = map;
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7416i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
        } else if (Uri.parse(str2).getHost().equals("game.weixin.qq.com")) {
            C28211b.mTH = str2;
            C28211b.mHeaders = map;
            C28211b.f13696JQ = System.currentTimeMillis() / 1000;
        } else {
            C4990ab.m7416i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (str.equals(cWL())) {
            C4990ab.m7417i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", Long.valueOf(currentTimeMillis));
            this.mUN.eCi = currentTimeMillis;
        }
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = currentTimeMillis;
        }
        if (this.mVc.uDP == 0) {
            this.mVc.uDP = System.currentTimeMillis();
        }
        if (mo23964NQ(str)) {
            m20067n(str2, map);
        }
        AppMethodBeat.m2505o(135989);
    }

    /* renamed from: n */
    private void m20067n(final String str, final Map<String, String> map) {
        AppMethodBeat.m2504i(135990);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameWebPage", "fullUrl is null, return");
            AppMethodBeat.m2505o(135990);
            return;
        }
        this.mHandler.post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.game.luggage.d.e$4$1 */
            class C32391 extends C17817c {
                C32391() {
                }

                public final String name() {
                    return "onGetA8KeyUrl";
                }

                /* renamed from: wQ */
                public final JSONObject mo7075wQ() {
                    AppMethodBeat.m2504i(135966);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", str);
                        String str = "set_cookie";
                        int i = (map == null || map.size() == 0) ? 0 : 1;
                        jSONObject.put(str, i);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.GameWebPage", "onGetA8Key, e:" + e.getMessage());
                    }
                    AppMethodBeat.m2505o(135966);
                    return jSONObject;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(135967);
                if (!(map == null || map.size() == 0)) {
                    C12140e.this.mTI = true;
                    C24526c.m38159jx(C12140e.this.mContext);
                    C44576b dTR = C44576b.dTR();
                    for (String str : map.keySet()) {
                        dTR.setCookie(C5046bo.anB(str), str + "=" + ((String) map.get(str)));
                    }
                    dTR.setCookie(C5046bo.anB(str), "httponly");
                    C24526c.dTT();
                    C24526c.sync();
                    C4990ab.m7417i("MicroMsg.GameWebPage", "cookies:%s", dTR.getCookie(C5046bo.anB(C12140e.this.mTH)));
                }
                C12140e.this.bPN.mo52826a(new C32391());
                AppMethodBeat.m2505o(135967);
            }
        });
        AppMethodBeat.m2505o(135990);
    }

    public final C30003c bDH() {
        AppMethodBeat.m2504i(135991);
        C30003c wePkgPlugin = ((C3228d) this.uhQ).getWePkgPlugin();
        AppMethodBeat.m2505o(135991);
        return wePkgPlugin;
    }

    public final String bDI() {
        AppMethodBeat.m2504i(135992);
        String str = (hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (cWL().hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.m2505o(135992);
        return str;
    }

    /* renamed from: wD */
    public final boolean mo23981wD(int i) {
        AppMethodBeat.m2504i(135993);
        if (this.bPN.mo52833xp() == C25685a.bPT) {
            AppMethodBeat.m2505o(135993);
            return true;
        } else if (this.bPN.mo52833xp() == C25685a.bPU) {
            AppMethodBeat.m2505o(135993);
            return false;
        } else {
            boolean wD = super.mo23981wD(i);
            AppMethodBeat.m2505o(135993);
            return wD;
        }
    }
}
