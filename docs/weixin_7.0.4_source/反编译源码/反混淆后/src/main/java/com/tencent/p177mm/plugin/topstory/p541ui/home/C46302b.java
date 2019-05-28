package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C8334b;
import android.support.design.widget.TabLayout.C8338e;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C9477te;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMWebView.C15990d;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.p539a.C13943b;
import com.tencent.p177mm.plugin.topstory.p539a.C43691e.C35294a;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.topstory.p539a.p540a.C4203b;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c.C4211b;
import com.tencent.p177mm.plugin.topstory.p541ui.C7612a;
import com.tencent.p177mm.plugin.topstory.p541ui.C7612a.C7613a;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C13993a;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C13995c;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C224227;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C3531410;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C3531512;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C3999811;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C437019;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.C43702e.C437032;
import com.tencent.p177mm.plugin.topstory.p541ui.webview.TopStoryWebView;
import com.tencent.p177mm.plugin.topstory.p541ui.widget.TopStoryViewPager;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.chn;
import com.tencent.p177mm.protocal.protobuf.cht;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.b */
public class C46302b implements C39969a {
    boolean cAY = false;
    protected chn cPu;
    private C1923n fyJ = new C399727();
    protected ThreeDotsLoadingView iNB;
    protected FrameLayout raJ;
    List<C35302a> rsl = new ArrayList();
    protected MMActivity sBH;
    protected boolean sBI;
    protected C13995c sBJ;
    protected TopStoryWebView sBK;
    protected C43702e sBL;
    protected View sBM;
    protected View sBN;
    protected List<C4211b> sBO = new ArrayList();
    View sBP;
    int sBQ = 0;
    long sBR = 0;
    boolean sBS = false;
    private LinearLayout sBT;
    TopStoryViewPager sBU;
    View sBV;
    int sBW = -1;
    int sBX = 0;
    boolean sBY = false;
    boolean sBZ = true;
    private boolean sCa;
    private boolean sCb;
    private boolean sCc;
    protected C4884c<C9477te> sCd = new C399715();
    protected C35294a sCe = new C463006();

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$10 */
    class C422110 implements OnClickListener {
        C422110() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1588);
            C46302b.this.onBackBtnClick();
            AppMethodBeat.m2505o(1588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$11 */
    class C422211 implements OnClickListener {
        C422211() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1589);
            if (C46302b.this.sBY) {
                AppMethodBeat.m2505o(1589);
                return;
            }
            C46302b.this.sBY = true;
            C46302b.this.mo63186fR(36, 3);
            C7053e.pXa.mo8381e(15449, Integer.valueOf(0));
            if (C46302b.this.sBP.getVisibility() == 0) {
                C46302b.this.sBP.setVisibility(8);
                cht cht = new cht();
                cht.cJb = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFe();
                cht.xgz = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFf();
                C14423an.m22644a(cht, 106, 5, 0, System.currentTimeMillis() / 1000, "");
                ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFh();
            }
            AppMethodBeat.m2505o(1589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$12 */
    class C422312 implements C8334b {
        C422312() {
        }

        /* renamed from: f */
        public final void mo9140f(C8338e c8338e) {
            AppMethodBeat.m2504i(1590);
            for (int i = 0; i < C46302b.this.sBO.size(); i++) {
                C4211b c4211b = (C4211b) C46302b.this.sBO.get(i);
                if (c4211b.sBy.equals(c8338e)) {
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab selected, " + c4211b.cEh);
                    c4211b.gne.setTextColor(C46302b.this.sBH.getResources().getColor(C25738R.color.a3i));
                    c4211b.sBz.setBackgroundColor(C46302b.this.sBH.getResources().getColor(C25738R.color.f11782h4));
                    C46302b.this.mo74467al(i, false);
                    C46302b.this.sBU.setCurrentItem(i);
                    if (c4211b.category == 100 && c4211b.sBu > 0) {
                        c4211b.mo9130bo(0, "");
                        ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFd();
                    }
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, Integer.valueOf(c4211b.category));
                    C46302b.this.sBQ = c4211b.category;
                    AppMethodBeat.m2505o(1590);
                    return;
                }
            }
            AppMethodBeat.m2505o(1590);
        }

        /* renamed from: g */
        public final void mo9141g(C8338e c8338e) {
            AppMethodBeat.m2504i(1591);
            for (C4211b c4211b : C46302b.this.sBO) {
                if (c4211b.sBy.equals(c8338e)) {
                    C46302b.this.sBX = c4211b.category;
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab unselected, " + c4211b.cEh);
                    c4211b.gne.setTextColor(C46302b.this.sBH.getResources().getColor(C25738R.color.a3j));
                    c4211b.sBz.setBackgroundColor(C46302b.this.sBH.getResources().getColor(C25738R.color.a3p));
                    AppMethodBeat.m2505o(1591);
                    return;
                }
            }
            AppMethodBeat.m2505o(1591);
        }

        /* renamed from: h */
        public final void mo9142h(C8338e c8338e) {
            AppMethodBeat.m2504i(1592);
            for (C4211b c4211b : C46302b.this.sBO) {
                if (c4211b.sBy.equals(c8338e)) {
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab reselected, " + c4211b.cEh);
                    c4211b.gne.setTextColor(C46302b.this.sBH.getResources().getColor(C25738R.color.a3i));
                    c4211b.sBz.setBackgroundColor(C46302b.this.sBH.getResources().getColor(C25738R.color.f11782h4));
                    C46302b.this.sBL.mo69349aj(c4211b.sBt, c4211b.sBu, c4211b.sBv);
                    if (c4211b.category == 100 && c4211b.sBu > 0) {
                        c4211b.mo9130bo(0, "");
                        ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFd();
                    }
                    C14423an.m22649b(c4211b.category, C46302b.this.sBQ, C5046bo.isNullOrNil(c4211b.sBx) ? c4211b.sBw : c4211b.sBx, C46302b.this.cPu.hlm, false);
                    C46302b.this.sBQ = c4211b.category;
                    AppMethodBeat.m2505o(1592);
                    return;
                }
            }
            AppMethodBeat.m2505o(1592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$9 */
    class C42269 implements OnClickListener {
        C42269() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(1587);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - C46302b.this.sBR < 300) {
                try {
                    if (!(C46302b.this.sBK == null || C46302b.this.sBK.getView() == null)) {
                        C46302b.this.sBK.getView().scrollTo(C46302b.this.sBK.getView().getScrollX(), 0);
                    }
                } catch (Throwable th) {
                }
            }
            C46302b.this.sBR = currentTimeMillis;
            AppMethodBeat.m2505o(1587);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$2 */
    class C139502 implements Runnable {
        C139502() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1567);
            C46302b.this.iNB.dKT();
            C46302b.this.sBM.setVisibility(8);
            C46302b.this.sBK.setVisibility(0);
            AppMethodBeat.m2505o(1567);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$1 */
    class C294391 implements C7613a {
        C294391() {
        }

        public final void abA(String str) {
            AppMethodBeat.m2504i(1566);
            if (C46302b.this.sBL != null) {
                C43702e c43702e = C46302b.this.sBL;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("params", str);
                } catch (JSONException e) {
                    C4990ab.m7420w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + e.getMessage());
                }
                C5004al.m7441d(new C3531512(jSONObject.toString()));
            }
            AppMethodBeat.m2505o(1566);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$4 */
    class C294404 implements Runnable {
        C294404() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1570);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "hideNavBarShadow");
            C46302b.this.sBN.setVisibility(8);
            if (VERSION.SDK_INT >= 21 && !C4971b.m7364Mt()) {
                C46302b.this.sBH.getWindow().setStatusBarColor(C46302b.this.sBH.getResources().getColor(C25738R.color.f11636x));
            }
            C46302b.this.sBS = false;
            if (C46302b.this.sBU != null) {
                C46302b.this.sBU.setScrollEnable(true);
            }
            AppMethodBeat.m2505o(1570);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$13 */
    class C3529813 extends C25365p {
        C3529813() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(1593);
            int size = C46302b.this.sBO.size();
            AppMethodBeat.m2505o(1593);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(1594);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "instantiateItem pos:%s, v:%s", Integer.valueOf(i), Integer.valueOf(((C35302a) C46302b.this.rsl.get(i)).sCu.hashCode()));
            viewGroup.addView(((C35302a) C46302b.this.rsl.get(i)).sCu, new LayoutParams(-1, -1));
            View view = ((C35302a) C46302b.this.rsl.get(i)).sCu;
            AppMethodBeat.m2505o(1594);
            return view;
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(1595);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "destroyItem pos:%s, v:%s", Integer.valueOf(i), Integer.valueOf(obj.hashCode()));
            viewGroup.removeView((View) obj);
            AppMethodBeat.m2505o(1595);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$a */
    static class C35302a {
        View sCu;
        FrameLayout sCv;
        ImageView sCw;
        int sCx = 0;

        C35302a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$5 */
    class C399715 extends C4884c<C9477te> {
        C399715() {
            AppMethodBeat.m2504i(1571);
            this.xxI = C9477te.class.getName().hashCode();
            AppMethodBeat.m2505o(1571);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(1572);
            C9477te c9477te = (C9477te) c4883b;
            switch (c9477te.cPr.actionType) {
                case 1:
                    c9477te.cPs.cPt = true;
                    break;
                case 2:
                    C46302b.this.sBH.finish();
                    break;
                case 3:
                    c9477te.cPs.cPu = C46302b.this.cPu;
                    break;
            }
            AppMethodBeat.m2505o(1572);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$7 */
    class C399727 extends C1924a {
        C399727() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(1584);
            try {
                C5004al.m7441d(new C3999811());
                AppMethodBeat.m2505o(1584);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "", new Object[0]);
                AppMethodBeat.m2505o(1584);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$15 */
    class C4629915 implements C15990d {
        C4629915() {
        }

        public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(1599);
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onWebViewScrollChanged %s,   %s", Integer.valueOf(i2), Integer.valueOf(i4));
            C35302a c35302a = (C35302a) C46302b.this.rsl.get(C46302b.this.sBW);
            c35302a.sCx--;
            AppMethodBeat.m2505o(1599);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$6 */
    class C463006 implements C35294a {
        C463006() {
        }

        /* renamed from: a */
        public final void mo56005a(final int i, String str, final String str2, int i2, int i3, String str3) {
            AppMethodBeat.m2504i(1578);
            if (C46302b.this.sBL != null) {
                C46302b.this.sBL.mo69351c(str, str2, i2, i3, i, str3);
            }
            for (final C4211b c4211b : C46302b.this.sBO) {
                if (c4211b.category == 110) {
                    C46302b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1573);
                            c4211b.mo9129bn(i, str2);
                            AppMethodBeat.m2505o(1573);
                        }
                    });
                    if (!C46302b.this.cAY) {
                        C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW(), 107, 2, i, 0, "");
                    }
                }
            }
            AppMethodBeat.m2505o(1578);
        }

        /* renamed from: as */
        public final void mo56008as(final String str, long j) {
            AppMethodBeat.m2504i(1579);
            if (C46302b.this.sBL != null) {
                C46302b.this.sBL.mo69350aw(str, j);
            }
            Iterator it = C46302b.this.sBO.iterator();
            if (it.hasNext()) {
                final C4211b c4211b = (C4211b) it.next();
                if (c4211b.category == 110) {
                    C46302b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1574);
                            c4211b.mo9130bo(1, str);
                            AppMethodBeat.m2505o(1574);
                        }
                    });
                    if (!C46302b.this.cAY && c4211b.sBv <= 0) {
                        C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP(), 107, 1, 0, 0, "");
                    }
                }
            }
            AppMethodBeat.m2505o(1579);
        }

        /* renamed from: a */
        public final void mo56006a(final int i, String str, final String str2, int i2, int i3, String str3, boolean z) {
            AppMethodBeat.m2504i(1580);
            if (z && C46302b.this.sBL != null) {
                C46302b.this.sBL.mo69351c(str, str2, i2, i3, i, str3);
            }
            for (final C4211b c4211b : C46302b.this.sBO) {
                if (c4211b.category == 110) {
                    C46302b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1575);
                            c4211b.mo9129bn(i, str2);
                            AppMethodBeat.m2505o(1575);
                        }
                    });
                    if (i > 0 && !C46302b.this.cAY) {
                        C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW(), 107, 2, c4211b.sBv, 0, "");
                        AppMethodBeat.m2505o(1580);
                        return;
                    }
                    AppMethodBeat.m2505o(1580);
                }
            }
            AppMethodBeat.m2505o(1580);
        }

        public final void cFk() {
            AppMethodBeat.m2504i(1581);
            for (final C4211b c4211b : C46302b.this.sBO) {
                if (c4211b.category == 110) {
                    C46302b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1576);
                            c4211b.mo9130bo(0, "");
                            AppMethodBeat.m2505o(1576);
                        }
                    });
                    AppMethodBeat.m2505o(1581);
                    return;
                }
            }
            AppMethodBeat.m2505o(1581);
        }

        public final void aby(String str) {
            AppMethodBeat.m2504i(1582);
            if (C46302b.this.sBL != null) {
                C43702e c43702e = C46302b.this.sBL;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("params", str);
                } catch (JSONException e) {
                    C4990ab.m7420w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + e.getMessage());
                }
                C5004al.m7441d(new C437032(jSONObject.toString()));
            }
            AppMethodBeat.m2505o(1582);
        }

        /* renamed from: at */
        public final void mo56009at(final String str, final long j) {
            AppMethodBeat.m2504i(1583);
            C46302b.this.sBH.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(1577);
                    C46302b.this.mo74468av(str, j);
                    AppMethodBeat.m2505o(1577);
                }
            });
            AppMethodBeat.m2505o(1583);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m86889a(C46302b c46302b) {
        AppMethodBeat.m2504i(1624);
        c46302b.cFD();
        AppMethodBeat.m2505o(1624);
    }

    public C46302b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.m2504i(1601);
        this.sBH = mMActivity;
        this.sBI = z;
        AppMethodBeat.m2505o(1601);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1602);
        C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onCreate");
        this.sBH.getSupportActionBar().hide();
        this.cPu = new chn();
        try {
            this.cPu.parseFrom(this.sBH.getIntent().getByteArrayExtra("key_context"));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "initData use intent", new Object[0]);
            if (bundle != null) {
                try {
                    this.cPu.parseFrom(bundle.getByteArray("key_context"));
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e2, "initData use savedInstanceState", new Object[0]);
                }
            }
        }
        if (C5046bo.isNullOrNil(this.cPu.xgj)) {
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Fail");
            this.sBH.finish();
        } else {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Success %s", this.cPu.xgj);
        }
        this.sBO = C4210c.abB(this.sBH.getIntent().getStringExtra("key_tabconfig"));
        if (!this.sBO.isEmpty()) {
            ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56015a(this.sCe);
        }
        this.sCd.dnU();
        C1720g.m3535RO().mo5187a(this.fyJ);
        ((C7612a) C1720g.m3530M(C7612a.class)).setHaokanEventListener(new C294391());
        C14423an.m22640Il(17);
        this.sBV = LayoutInflater.from(this.sBH).inflate(2130970953, null);
        this.raJ = (FrameLayout) this.sBV.findViewById(2131828327);
        if (((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr() != null) {
            if (!((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().sDf) {
                ((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().mo9146a(this.cPu, true);
            }
            ((C7612a) C1720g.m3530M(C7612a.class)).getWebViewMgr().mo9147b(this);
        } else {
            C4227d c4227d = new C4227d();
            c4227d.mo9146a(this.cPu, true);
            c4227d.mo9147b(this);
        }
        this.sBM = this.sBV.findViewById(2131828328);
        this.iNB = (ThreeDotsLoadingView) this.sBV.findViewById(2131821325);
        if (VERSION.SDK_INT >= 21 && !C4971b.m7364Mt()) {
            this.sBH.getWindow().setStatusBarColor(this.sBH.getResources().getColor(C25738R.color.f11636x));
            this.sBH.dxW();
        }
        TextView textView = (TextView) this.sBH.findViewById(2131828318);
        View findViewById = this.sBH.findViewById(2131820973);
        View findViewById2 = this.sBH.findViewById(2131828321);
        this.sBP = this.sBH.findViewById(2131828322);
        View findViewById3 = this.sBH.findViewById(2131828315);
        this.sBN = this.sBH.findViewById(2131828316);
        this.sBU = (TopStoryViewPager) this.sBH.findViewById(2131828317);
        this.sBT = (LinearLayout) this.sBH.findViewById(2131828314);
        if (this.sBO.isEmpty()) {
            this.sBU.setVisibility(8);
            this.sBT.addView(this.sBV, -1, -1);
            textView.setText(this.cPu.xgm);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            findViewById3.setOnClickListener(new C42269());
        } else {
            int i;
            final TabLayout tabLayout = (TabLayout) this.sBH.findViewById(2131828320);
            for (C4211b c4211b : this.sBO) {
                c4211b.sBy = tabLayout.mo18211cp();
                c4211b.sBy.mo18252aj(2130970952);
                c4211b.gne = (TextView) c4211b.sBy.f2271sQ.findViewById(2131828323);
                c4211b.sBz = c4211b.sBy.f2271sQ.findViewById(2131828326);
                c4211b.sBA = (TextView) c4211b.sBy.f2271sQ.findViewById(2131828324);
                c4211b.sBB = c4211b.sBy.f2271sQ.findViewById(2131828325);
                c4211b.gne.setText(c4211b.cEh);
                if (c4211b.sBv > 0) {
                    CharSequence charSequence = c4211b.sBv;
                    if (c4211b.sBv > 99) {
                        charSequence = "99+";
                    }
                    c4211b.sBA.setText(charSequence);
                    c4211b.sBA.setVisibility(0);
                    c4211b.sBB.setVisibility(8);
                } else if (c4211b.sBu > 0) {
                    c4211b.sBA.setText("");
                    c4211b.sBA.setVisibility(4);
                    c4211b.sBB.setVisibility(0);
                }
                tabLayout.mo18201a(c4211b.sBy, false);
            }
            tabLayout.mo18200a(new C422312());
            this.sBU.setVisibility(0);
            for (i = 0; i < this.sBO.size(); i++) {
                C35302a c35302a = new C35302a();
                c35302a.sCu = LayoutInflater.from(this.sBH).inflate(2130970949, null);
                c35302a.sCw = (ImageView) c35302a.sCu.findViewById(2131828313);
                c35302a.sCv = (FrameLayout) c35302a.sCu.findViewById(2131828312);
                this.rsl.add(c35302a);
            }
            this.sBU.setAdapter(new C3529813());
            this.sBU.addOnPageChangeListener(new OnPageChangeListener() {
                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    AppMethodBeat.m2504i(1597);
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageSelected:".concat(String.valueOf(i)));
                    C46302b.this.mo74467al(i, true);
                    if (!tabLayout.mo18203ac(i).isSelected()) {
                        tabLayout.mo18203ac(i).select();
                    }
                    AppMethodBeat.m2505o(1597);
                }

                public final void onPageScrollStateChanged(int i) {
                    AppMethodBeat.m2504i(1598);
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(i)));
                    if (i == 0) {
                        if (C46302b.this.sBZ) {
                            final int i2 = C46302b.this.sBW;
                            C46302b.this.sBU.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(1596);
                                    if (i2 == C46302b.this.sBW) {
                                        ((C35302a) C46302b.this.rsl.get(C46302b.this.sBW)).sCw.setVisibility(8);
                                        C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + C46302b.this.sBW);
                                    }
                                    AppMethodBeat.m2505o(1596);
                                }
                            }, 100);
                            AppMethodBeat.m2505o(1598);
                            return;
                        }
                        C46302b.this.sBZ = true;
                    }
                    AppMethodBeat.m2505o(1598);
                }
            });
            this.sBK.zNv = new C4629915();
            i = this.sBH.getIntent().getIntExtra("key_chosetab", 0);
            for (C4211b c4211b2 : this.sBO) {
                if (c4211b2.category == i) {
                    c4211b2.sBy.select();
                }
            }
            if (tabLayout.getSelectedTabPosition() < 0) {
                tabLayout.mo18203ac(0).select();
            }
            textView.setText("");
            String dor = C4988aa.dor();
            if (!(dor.equals("zh_TW") || dor.equals("zh_HK") || dor.equals("zh_CN"))) {
                this.sBH.findViewById(2131828319).setVisibility(8);
            }
        }
        findViewById.setOnClickListener(new C422110());
        ((ImageView) this.sBH.findViewById(2131820974)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        this.iNB.dKS();
        if (cFE()) {
            String cFe = ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFe();
            if (C5046bo.isNullOrNil(cFe)) {
                this.sBP.setVisibility(8);
            } else {
                mo74468av(cFe, ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFf());
            }
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new C422211());
        } else {
            findViewById2.setVisibility(8);
        }
        C4210c.m6561c(this.cPu, "uiOnCreate", System.currentTimeMillis());
        AppMethodBeat.m2505o(1602);
    }

    /* renamed from: fR */
    public final void mo63186fR(int i, int i2) {
        AppMethodBeat.m2504i(1603);
        C14423an.m22656l("", 0, 0, i);
        String HP = C46400aa.m87299HP(i);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("topStoryScene", String.valueOf(this.cPu.scene));
            hashMap.put("deviceName", URLEncoder.encode(C7243d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("from", URLEncoder.encode(this.sBH.getString(C25738R.string.ewq), "utf8"));
            String str = OpenSDKTool4Assistant.EXTRA_UIN;
            C1720g.m3534RN();
            hashMap.put(str, C1668a.m3384QG());
            hashMap.put("timeZone", URLEncoder.encode(C5046bo.dpA(), "utf8"));
            hashMap.put("ostype", C7243d.vxk);
            hashMap.put("subScene", String.valueOf(i2));
            hashMap.put(IssueStorage.COLUMN_EXT_INFO, ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cFg());
        } catch (Exception e) {
        }
        int i3 = i;
        ((C22757j) C1720g.m3528K(C22757j.class)).mo38336a(this.sBH, i3, "", HP, hashMap, this.sBH.getResources().getString(C25738R.string.ex6), this.sBH.getResources().getColor(C25738R.color.f11636x));
        AppMethodBeat.m2505o(1603);
    }

    public final void cFB() {
        AppMethodBeat.m2504i(1604);
        if (!this.sBZ || this.rsl.size() <= 0) {
            this.sBZ = true;
            AppMethodBeat.m2505o(1604);
            return;
        }
        final int i = this.sBW;
        this.sBU.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(1600);
                if (i == C46302b.this.sBW) {
                    ((C35302a) C46302b.this.rsl.get(C46302b.this.sBW)).sCw.setVisibility(8);
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onH5RenderFinished hide fakeIv " + C46302b.this.sBW);
                }
                AppMethodBeat.m2505o(1600);
            }
        }, 100);
        AppMethodBeat.m2505o(1604);
    }

    public final int cFC() {
        return this.sBX;
    }

    /* renamed from: FA */
    public final boolean mo74465FA(int i) {
        AppMethodBeat.m2504i(1605);
        if (i == 4) {
            onBackBtnClick();
            AppMethodBeat.m2505o(1605);
            return true;
        }
        AppMethodBeat.m2505o(1605);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBackBtnClick() {
        AppMethodBeat.m2504i(1606);
        if (this.sBS) {
            cFD();
            AppMethodBeat.m2505o(1606);
            return;
        }
        if (this.sCb) {
            C46297h.m86861a(this.cPu, "uiBackBtnClick", System.currentTimeMillis());
        } else if (!this.sCa) {
            C46297h.m86861a(this.cPu, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
        } else if (this.sCc) {
            C46297h.m86861a(this.cPu, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
            C46297h.m86861a(this.cPu, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
        C14423an.m22640Il(19);
        if (this.sBI) {
            this.sBH.finish();
            AppMethodBeat.m2505o(1606);
            return;
        }
        this.sBH.moveTaskToBack(true);
        AppMethodBeat.m2505o(1606);
    }

    /* Access modifiers changed, original: final */
    public final void cFD() {
        AppMethodBeat.m2504i(1607);
        if (this.sBL != null) {
            this.sBL.cHo();
            cFA();
        }
        AppMethodBeat.m2505o(1607);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.m2504i(1608);
        C46297h.m86861a(this.cPu, "uiOnResume", System.currentTimeMillis());
        this.sBL.abN("onResume");
        if (this.sBK != null) {
            this.sBK.onResume();
        }
        C45287c.atF("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        for (C4211b c4211b : this.sBO) {
            if (c4211b.sBv > 0) {
                if (c4211b.category == 110) {
                    C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEW(), 107, 2, c4211b.sBv, 0, "");
                }
            } else if (c4211b.sBu > 0) {
                if (c4211b.category == 110) {
                    C14423an.m22644a(((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().cEP(), 107, 1, 0, 0, "");
                } else if (c4211b.category == 100) {
                    cht cht = new cht();
                    cht.cJb = c4211b.sBw;
                    C14423an.m22644a(cht, 107, 3, 0, 0, "");
                }
            }
        }
        this.cAY = false;
        this.sBY = false;
        AppMethodBeat.m2505o(1608);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.m2504i(1609);
        C46297h.m86861a(this.cPu, "uiOnPause", System.currentTimeMillis());
        this.sBL.abN("onPause");
        if (this.sBK != null) {
            this.sBK.onPause();
        }
        this.cAY = true;
        AppMethodBeat.m2505o(1609);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.m2504i(1610);
        try {
            if (this.cPu.cdf == 100 && this.sBL != null) {
                C13993a.m22130a(this.sBL, "onWebCommendLeaveFromFindPage", "");
            }
            if (this.sBK.getParent() != null && this.sBK.getParent().equals(this.raJ)) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "webViewContainer remove topstoryWebview");
                this.raJ.removeView(this.sBK);
            }
        } catch (Exception e) {
        }
        if (this.sBK != null) {
            this.sBK.onDestroy();
        }
        chn chn = this.cPu;
        if (this.sBH.dyi() > 0) {
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(chn.scene), Long.valueOf(this.sBH.dyi()), Integer.valueOf(chn.cdf), Integer.valueOf(chn.xgl)}));
            C7060h.pYm.mo8374X(15018, r0);
        }
        C46297h.m86861a(this.cPu, "uiOnDestroy", System.currentTimeMillis());
        C14423an.m22640Il(18);
        C1202f c1202f = this.sBJ;
        c1202f.sHt = null;
        c1202f.sHv = null;
        C1720g.m3540Rg().mo14546b(1943, c1202f);
        C1720g.m3540Rg().mo14546b(2582, c1202f.sHA);
        C1720g.m3540Rg().mo14546b(2802, c1202f.sEu);
        C1720g.m3540Rg().mo14546b(2906, c1202f.sHz);
        this.sCd.dead();
        C1720g.m3535RO().mo5188b(this.fyJ);
        ((C7612a) C1720g.m3530M(C7612a.class)).setHaokanEventListener(null);
        ((C13943b) C1720g.m3530M(C13943b.class)).getRedDotMgr().mo56017b(this.sCe);
        AppMethodBeat.m2505o(1610);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(1611);
        chn chn = new chn();
        try {
            chn.parseFrom(intent.getByteArrayExtra("key_context"));
        } catch (Exception e) {
            this.sBH.finish();
        }
        this.cPu.cvF = chn.cvF;
        this.cPu.cIy = chn.cIy;
        this.cPu.scene = chn.scene;
        this.cPu.nQB = chn.nQB;
        this.cPu.xgn = C46400aa.bVP();
        C46297h.m86861a(this.cPu, "uiOnNewIntent", System.currentTimeMillis());
        C14423an.m22640Il(20);
        this.sBL.abN("onNewIntent");
        AppMethodBeat.m2505o(1611);
    }

    public final MMActivity bKU() {
        return this.sBH;
    }

    public final void cFy() {
        this.sCa = true;
    }

    public final void cFz() {
        AppMethodBeat.m2504i(1612);
        this.sCb = true;
        C5004al.m7441d(new C139502());
        AppMethodBeat.m2505o(1612);
    }

    /* Access modifiers changed, original: protected */
    public boolean cFE() {
        return true;
    }

    public final void abD(String str) {
        AppMethodBeat.m2504i(1613);
        for (C35302a c35302a : this.rsl) {
            if (c35302a.sCw != null) {
                c35302a.sCx = 0;
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "invalid cache when onSearchDataReady");
            }
        }
        this.sCc = true;
        this.sBL.abD(str);
        AppMethodBeat.m2505o(1613);
    }

    public final void abE(String str) {
        AppMethodBeat.m2504i(1614);
        C5004al.m7441d(new C224227(str));
        AppMethodBeat.m2505o(1614);
    }

    public final void abF(String str) {
        AppMethodBeat.m2504i(1615);
        C5004al.m7441d(new C3531410(str));
        AppMethodBeat.m2505o(1615);
    }

    public final void abG(String str) {
        AppMethodBeat.m2504i(1616);
        C5004al.m7441d(new C437019(str));
        AppMethodBeat.m2505o(1616);
    }

    /* renamed from: fQ */
    public final void mo63185fQ(final int i, final int i2) {
        AppMethodBeat.m2504i(1617);
        this.sBH.runOnUiThread(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.topstory.ui.home.b$3$1 */
            class C139521 implements OnClickListener {
                C139521() {
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(1568);
                    C46302b.m86889a(C46302b.this);
                    AppMethodBeat.m2505o(1568);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(1569);
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "showNavBarShadow %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                int i = i + (16581375 * i2);
                C46302b.this.sBN.setBackgroundColor(i);
                C46302b.this.sBN.setVisibility(0);
                if (VERSION.SDK_INT >= 21 && !C4971b.m7364Mt()) {
                    C46302b.this.sBH.getWindow().setStatusBarColor(C5225ah.m7964s(i, C46302b.this.sBH.getResources().getColor(C25738R.color.f11636x)));
                }
                C46302b.this.sBS = true;
                C46302b.this.sBN.setOnClickListener(new C139521());
                if (C46302b.this.sBU != null) {
                    C46302b.this.sBU.setScrollEnable(false);
                }
                AppMethodBeat.m2505o(1569);
            }
        });
        AppMethodBeat.m2505o(1617);
    }

    public final void cFA() {
        AppMethodBeat.m2504i(1618);
        this.sBH.runOnUiThread(new C294404());
        AppMethodBeat.m2505o(1618);
    }

    /* renamed from: a */
    public final void mo74466a(C13995c c13995c, TopStoryWebView topStoryWebView, C43702e c43702e, chn chn) {
        AppMethodBeat.m2504i(1619);
        this.sBJ = c13995c;
        this.sBK = topStoryWebView;
        this.sBL = c43702e;
        this.sBL.sHt = this;
        this.cPu = chn;
        C13995c c13995c2 = this.sBJ;
        c13995c2.sHt = this;
        C1720g.m3540Rg().mo14539a(2582, c13995c2.sHA);
        C1720g.m3540Rg().mo14539a(2802, c13995c2.sEu);
        C1720g.m3540Rg().mo14539a(2906, c13995c2.sHz);
        this.raJ.addView(this.sBK, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.m2505o(1619);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: av */
    public final void mo74468av(String str, long j) {
        AppMethodBeat.m2504i(1620);
        this.sBP.setVisibility(0);
        cht cht = new cht();
        cht.cJb = str;
        cht.xgz = j;
        C14423an.m22644a(cht, 107, 5, 0, 0, "");
        AppMethodBeat.m2505o(1620);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(1621);
        try {
            bundle.putByteArray("key_context", this.cPu.toByteArray());
            C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onSaveInstanceState %s", this.cPu.xgj);
            AppMethodBeat.m2505o(1621);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "onSaveInstanceState", new Object[0]);
            AppMethodBeat.m2505o(1621);
        }
    }

    /* renamed from: a */
    static Bitmap m86888a(TopStoryWebView topStoryWebView, int i, int i2) {
        Bitmap createBitmap;
        AppMethodBeat.m2504i(1622);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            createBitmap = Bitmap.createBitmap(i, i2, Config.RGB_565);
            topStoryWebView.drawCanvas(new Canvas(createBitmap));
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - currentTimeMillis));
            C4203b.cFr();
        } catch (Throwable th) {
            Throwable th2 = th;
            createBitmap = null;
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", th2, "captureWebView error", new Object[0]);
            C4203b.cFr();
        }
        AppMethodBeat.m2505o(1622);
        return createBitmap;
    }

    /* renamed from: al */
    public final synchronized void mo74467al(int i, boolean z) {
        Object obj = null;
        synchronized (this) {
            AppMethodBeat.m2504i(1623);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView, from " + (z ? "viewpager" : "tab"));
            if (i == this.sBW) {
                C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView return");
                AppMethodBeat.m2505o(1623);
            } else {
                final int i2 = i == 0 ? 1 : 0;
                this.sBW = i;
                final C35302a c35302a = (C35302a) this.rsl.get(i2);
                if (this.sBV.getParent() == ((C35302a) this.rsl.get(i2)).sCv) {
                    Object obj2;
                    if (c35302a.sCx <= 0) {
                        obj2 = 1;
                    } else {
                        c35302a.sCw.setVisibility(0);
                        C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView cacheworked");
                        obj2 = null;
                    }
                    c35302a.sCx = 2;
                    obj = obj2;
                } else {
                    c35302a.sCw.setVisibility(0);
                }
                final C4211b c4211b = (C4211b) this.sBO.get(this.sBW);
                this.sBZ = false;
                if (obj != null) {
                    C7305d.xDG.mo10151b(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(1586);
                            final Bitmap a = C46302b.m86888a(C46302b.this.sBK, c35302a.sCv.getWidth(), c35302a.sCv.getHeight());
                            C46302b.this.sBH.runOnUiThread(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(1585);
                                    if (a != null) {
                                        c35302a.sCw.setImageBitmap(a);
                                    } else {
                                        c35302a.sCw.setImageDrawable(C46302b.this.sBH.getResources().getDrawable(C25738R.color.f11638z));
                                        c35302a.sCx = 0;
                                    }
                                    c35302a.sCw.setVisibility(0);
                                    C4990ab.m7417i("MicroMsg.TopStory.TopStoryUIComponentImpl", "layout %s,%s, fakeIv %s,%s", Integer.valueOf(c35302a.sCv.getWidth()), Integer.valueOf(c35302a.sCv.getHeight()), Integer.valueOf(c35302a.sCw.getWidth()), Integer.valueOf(c35302a.sCw.getHeight()));
                                    if (C46302b.this.sBV.getParent() != null) {
                                        ((ViewGroup) C46302b.this.sBV.getParent()).removeView(C46302b.this.sBV);
                                        C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "remove view from:" + i2);
                                    }
                                    ((C35302a) C46302b.this.rsl.get(C46302b.this.sBW)).sCv.addView(C46302b.this.sBV, new FrameLayout.LayoutParams(-1, -1));
                                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "add view to:" + C46302b.this.sBW);
                                    C46302b.this.sBL.mo69349aj(c4211b.sBt, c4211b.sBu, c4211b.sBv);
                                    AppMethodBeat.m2505o(1585);
                                }
                            });
                            AppMethodBeat.m2505o(1586);
                        }
                    }, "CaptureWebViewTask");
                } else {
                    if (this.sBV.getParent() != null) {
                        ((ViewGroup) this.sBV.getParent()).removeView(this.sBV);
                        C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "remove view from:".concat(String.valueOf(i2)));
                    }
                    ((C35302a) this.rsl.get(this.sBW)).sCv.addView(this.sBV, new FrameLayout.LayoutParams(-1, -1));
                    C4990ab.m7416i("MicroMsg.TopStory.TopStoryUIComponentImpl", "add view to:" + this.sBW);
                    this.sBL.mo69349aj(c4211b.sBt, c4211b.sBu, c4211b.sBv);
                }
                C14423an.m22649b(c4211b.category, this.sBQ, C5046bo.isNullOrNil(c4211b.sBx) ? c4211b.sBw : c4211b.sBx, this.cPu.hlm, z);
                AppMethodBeat.m2505o(1623);
            }
        }
    }
}
