package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.plugin.topstory.ui.webview.e;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
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

public class b implements a {
    boolean cAY = false;
    protected chn cPu;
    private n fyJ = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            AppMethodBeat.i(1584);
            try {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(2185);
                        a.a(e.this, "onNetWorkChange", "");
                        AppMethodBeat.o(2185);
                    }
                });
                AppMethodBeat.o(1584);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "", new Object[0]);
                AppMethodBeat.o(1584);
            }
        }
    };
    protected ThreeDotsLoadingView iNB;
    protected FrameLayout raJ;
    List<a> rsl = new ArrayList();
    protected MMActivity sBH;
    protected boolean sBI;
    protected c sBJ;
    protected TopStoryWebView sBK;
    protected e sBL;
    protected View sBM;
    protected View sBN;
    protected List<com.tencent.mm.plugin.topstory.ui.c.b> sBO = new ArrayList();
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
    protected com.tencent.mm.sdk.b.c<te> sCd = new com.tencent.mm.sdk.b.c<te>() {
        {
            AppMethodBeat.i(1571);
            this.xxI = te.class.getName().hashCode();
            AppMethodBeat.o(1571);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(1572);
            te teVar = (te) bVar;
            switch (teVar.cPr.actionType) {
                case 1:
                    teVar.cPs.cPt = true;
                    break;
                case 2:
                    b.this.sBH.finish();
                    break;
                case 3:
                    teVar.cPs.cPu = b.this.cPu;
                    break;
            }
            AppMethodBeat.o(1572);
            return true;
        }
    };
    protected com.tencent.mm.plugin.topstory.a.e.a sCe = new com.tencent.mm.plugin.topstory.a.e.a() {
        public final void a(final int i, String str, final String str2, int i2, int i3, String str3) {
            AppMethodBeat.i(1578);
            if (b.this.sBL != null) {
                b.this.sBL.c(str, str2, i2, i3, i, str3);
            }
            for (final com.tencent.mm.plugin.topstory.ui.c.b bVar : b.this.sBO) {
                if (bVar.category == 110) {
                    b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1573);
                            bVar.bn(i, str2);
                            AppMethodBeat.o(1573);
                        }
                    });
                    if (!b.this.cAY) {
                        an.a(((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW(), 107, 2, i, 0, "");
                    }
                }
            }
            AppMethodBeat.o(1578);
        }

        public final void as(final String str, long j) {
            AppMethodBeat.i(1579);
            if (b.this.sBL != null) {
                b.this.sBL.aw(str, j);
            }
            Iterator it = b.this.sBO.iterator();
            if (it.hasNext()) {
                final com.tencent.mm.plugin.topstory.ui.c.b bVar = (com.tencent.mm.plugin.topstory.ui.c.b) it.next();
                if (bVar.category == 110) {
                    b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1574);
                            bVar.bo(1, str);
                            AppMethodBeat.o(1574);
                        }
                    });
                    if (!b.this.cAY && bVar.sBv <= 0) {
                        an.a(((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP(), 107, 1, 0, 0, "");
                    }
                }
            }
            AppMethodBeat.o(1579);
        }

        public final void a(final int i, String str, final String str2, int i2, int i3, String str3, boolean z) {
            AppMethodBeat.i(1580);
            if (z && b.this.sBL != null) {
                b.this.sBL.c(str, str2, i2, i3, i, str3);
            }
            for (final com.tencent.mm.plugin.topstory.ui.c.b bVar : b.this.sBO) {
                if (bVar.category == 110) {
                    b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1575);
                            bVar.bn(i, str2);
                            AppMethodBeat.o(1575);
                        }
                    });
                    if (i > 0 && !b.this.cAY) {
                        an.a(((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW(), 107, 2, bVar.sBv, 0, "");
                        AppMethodBeat.o(1580);
                        return;
                    }
                    AppMethodBeat.o(1580);
                }
            }
            AppMethodBeat.o(1580);
        }

        public final void cFk() {
            AppMethodBeat.i(1581);
            for (final com.tencent.mm.plugin.topstory.ui.c.b bVar : b.this.sBO) {
                if (bVar.category == 110) {
                    b.this.sBH.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1576);
                            bVar.bo(0, "");
                            AppMethodBeat.o(1576);
                        }
                    });
                    AppMethodBeat.o(1581);
                    return;
                }
            }
            AppMethodBeat.o(1581);
        }

        public final void aby(String str) {
            AppMethodBeat.i(1582);
            if (b.this.sBL != null) {
                e eVar = b.this.sBL;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("params", str);
                } catch (JSONException e) {
                    ab.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendNotifyReddotExtMsg json exception: " + e.getMessage());
                }
                al.d(new com.tencent.mm.plugin.topstory.ui.webview.e.AnonymousClass2(jSONObject.toString()));
            }
            AppMethodBeat.o(1582);
        }

        public final void at(final String str, final long j) {
            AppMethodBeat.i(1583);
            b.this.sBH.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(1577);
                    b.this.av(str, j);
                    AppMethodBeat.o(1577);
                }
            });
            AppMethodBeat.o(1583);
        }
    };

    static class a {
        View sCu;
        FrameLayout sCv;
        ImageView sCw;
        int sCx = 0;

        a() {
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(1624);
        bVar.cFD();
        AppMethodBeat.o(1624);
    }

    public b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(1601);
        this.sBH = mMActivity;
        this.sBI = z;
        AppMethodBeat.o(1601);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(1602);
        ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onCreate");
        this.sBH.getSupportActionBar().hide();
        this.cPu = new chn();
        try {
            this.cPu.parseFrom(this.sBH.getIntent().getByteArrayExtra("key_context"));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "initData use intent", new Object[0]);
            if (bundle != null) {
                try {
                    this.cPu.parseFrom(bundle.getByteArray("key_context"));
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e2, "initData use savedInstanceState", new Object[0]);
                }
            }
        }
        if (bo.isNullOrNil(this.cPu.xgj)) {
            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Fail");
            this.sBH.finish();
        } else {
            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Success %s", this.cPu.xgj);
        }
        this.sBO = com.tencent.mm.plugin.topstory.ui.c.abB(this.sBH.getIntent().getStringExtra("key_tabconfig"));
        if (!this.sBO.isEmpty()) {
            ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().a(this.sCe);
        }
        this.sCd.dnU();
        g.RO().a(this.fyJ);
        ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).setHaokanEventListener(new com.tencent.mm.plugin.topstory.ui.a.a() {
            public final void abA(String str) {
                AppMethodBeat.i(1566);
                if (b.this.sBL != null) {
                    e eVar = b.this.sBL;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("params", str);
                    } catch (JSONException e) {
                        ab.w("MicroMsg.TopStory.TopStoryWebViewJSApi", "onWebRecommendInfoUpdate json exception: " + e.getMessage());
                    }
                    al.d(new com.tencent.mm.plugin.topstory.ui.webview.e.AnonymousClass12(jSONObject.toString()));
                }
                AppMethodBeat.o(1566);
            }
        });
        an.Il(17);
        this.sBV = LayoutInflater.from(this.sBH).inflate(R.layout.b0d, null);
        this.raJ = (FrameLayout) this.sBV.findViewById(R.id.eyd);
        if (((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr() != null) {
            if (!((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().sDf) {
                ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().a(this.cPu, true);
            }
            ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).getWebViewMgr().b(this);
        } else {
            d dVar = new d();
            dVar.a(this.cPu, true);
            dVar.b(this);
        }
        this.sBM = this.sBV.findViewById(R.id.eye);
        this.iNB = (ThreeDotsLoadingView) this.sBV.findViewById(R.id.ue);
        if (VERSION.SDK_INT >= 21 && !com.tencent.mm.sdk.h.b.Mt()) {
            this.sBH.getWindow().setStatusBarColor(this.sBH.getResources().getColor(R.color.x));
            this.sBH.dxW();
        }
        TextView textView = (TextView) this.sBH.findViewById(R.id.ey5);
        View findViewById = this.sBH.findViewById(R.id.kw);
        View findViewById2 = this.sBH.findViewById(R.id.ey8);
        this.sBP = this.sBH.findViewById(R.id.ey9);
        View findViewById3 = this.sBH.findViewById(R.id.ey2);
        this.sBN = this.sBH.findViewById(R.id.ey3);
        this.sBU = (TopStoryViewPager) this.sBH.findViewById(R.id.ey4);
        this.sBT = (LinearLayout) this.sBH.findViewById(R.id.ey1);
        if (this.sBO.isEmpty()) {
            this.sBU.setVisibility(8);
            this.sBT.addView(this.sBV, -1, -1);
            textView.setText(this.cPu.xgm);
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            findViewById3.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(1587);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - b.this.sBR < 300) {
                        try {
                            if (!(b.this.sBK == null || b.this.sBK.getView() == null)) {
                                b.this.sBK.getView().scrollTo(b.this.sBK.getView().getScrollX(), 0);
                            }
                        } catch (Throwable th) {
                        }
                    }
                    b.this.sBR = currentTimeMillis;
                    AppMethodBeat.o(1587);
                }
            });
        } else {
            int i;
            final TabLayout tabLayout = (TabLayout) this.sBH.findViewById(R.id.ey7);
            for (com.tencent.mm.plugin.topstory.ui.c.b bVar : this.sBO) {
                bVar.sBy = tabLayout.cp();
                bVar.sBy.aj(R.layout.b0c);
                bVar.gne = (TextView) bVar.sBy.sQ.findViewById(R.id.ey_);
                bVar.sBz = bVar.sBy.sQ.findViewById(R.id.eyc);
                bVar.sBA = (TextView) bVar.sBy.sQ.findViewById(R.id.eya);
                bVar.sBB = bVar.sBy.sQ.findViewById(R.id.eyb);
                bVar.gne.setText(bVar.cEh);
                if (bVar.sBv > 0) {
                    CharSequence charSequence = bVar.sBv;
                    if (bVar.sBv > 99) {
                        charSequence = "99+";
                    }
                    bVar.sBA.setText(charSequence);
                    bVar.sBA.setVisibility(0);
                    bVar.sBB.setVisibility(8);
                } else if (bVar.sBu > 0) {
                    bVar.sBA.setText("");
                    bVar.sBA.setVisibility(4);
                    bVar.sBB.setVisibility(0);
                }
                tabLayout.a(bVar.sBy, false);
            }
            tabLayout.a(new android.support.design.widget.TabLayout.b() {
                public final void f(TabLayout.e eVar) {
                    AppMethodBeat.i(1590);
                    for (int i = 0; i < b.this.sBO.size(); i++) {
                        com.tencent.mm.plugin.topstory.ui.c.b bVar = (com.tencent.mm.plugin.topstory.ui.c.b) b.this.sBO.get(i);
                        if (bVar.sBy.equals(eVar)) {
                            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab selected, " + bVar.cEh);
                            bVar.gne.setTextColor(b.this.sBH.getResources().getColor(R.color.a3i));
                            bVar.sBz.setBackgroundColor(b.this.sBH.getResources().getColor(R.color.h4));
                            b.this.al(i, false);
                            b.this.sBU.setCurrentItem(i);
                            if (bVar.category == 100 && bVar.sBu > 0) {
                                bVar.bo(0, "");
                                ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFd();
                            }
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, Integer.valueOf(bVar.category));
                            b.this.sBQ = bVar.category;
                            AppMethodBeat.o(1590);
                            return;
                        }
                    }
                    AppMethodBeat.o(1590);
                }

                public final void g(TabLayout.e eVar) {
                    AppMethodBeat.i(1591);
                    for (com.tencent.mm.plugin.topstory.ui.c.b bVar : b.this.sBO) {
                        if (bVar.sBy.equals(eVar)) {
                            b.this.sBX = bVar.category;
                            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab unselected, " + bVar.cEh);
                            bVar.gne.setTextColor(b.this.sBH.getResources().getColor(R.color.a3j));
                            bVar.sBz.setBackgroundColor(b.this.sBH.getResources().getColor(R.color.a3p));
                            AppMethodBeat.o(1591);
                            return;
                        }
                    }
                    AppMethodBeat.o(1591);
                }

                public final void h(TabLayout.e eVar) {
                    AppMethodBeat.i(1592);
                    for (com.tencent.mm.plugin.topstory.ui.c.b bVar : b.this.sBO) {
                        if (bVar.sBy.equals(eVar)) {
                            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "tab reselected, " + bVar.cEh);
                            bVar.gne.setTextColor(b.this.sBH.getResources().getColor(R.color.a3i));
                            bVar.sBz.setBackgroundColor(b.this.sBH.getResources().getColor(R.color.h4));
                            b.this.sBL.aj(bVar.sBt, bVar.sBu, bVar.sBv);
                            if (bVar.category == 100 && bVar.sBu > 0) {
                                bVar.bo(0, "");
                                ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFd();
                            }
                            an.b(bVar.category, b.this.sBQ, bo.isNullOrNil(bVar.sBx) ? bVar.sBw : bVar.sBx, b.this.cPu.hlm, false);
                            b.this.sBQ = bVar.category;
                            AppMethodBeat.o(1592);
                            return;
                        }
                    }
                    AppMethodBeat.o(1592);
                }
            });
            this.sBU.setVisibility(0);
            for (i = 0; i < this.sBO.size(); i++) {
                a aVar = new a();
                aVar.sCu = LayoutInflater.from(this.sBH).inflate(R.layout.b0_, null);
                aVar.sCw = (ImageView) aVar.sCu.findViewById(R.id.ey0);
                aVar.sCv = (FrameLayout) aVar.sCu.findViewById(R.id.exz);
                this.rsl.add(aVar);
            }
            this.sBU.setAdapter(new p() {
                public final int getCount() {
                    AppMethodBeat.i(1593);
                    int size = b.this.sBO.size();
                    AppMethodBeat.o(1593);
                    return size;
                }

                public final boolean isViewFromObject(View view, Object obj) {
                    return view == obj;
                }

                public final Object instantiateItem(ViewGroup viewGroup, int i) {
                    AppMethodBeat.i(1594);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "instantiateItem pos:%s, v:%s", Integer.valueOf(i), Integer.valueOf(((a) b.this.rsl.get(i)).sCu.hashCode()));
                    viewGroup.addView(((a) b.this.rsl.get(i)).sCu, new LayoutParams(-1, -1));
                    View view = ((a) b.this.rsl.get(i)).sCu;
                    AppMethodBeat.o(1594);
                    return view;
                }

                public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
                    AppMethodBeat.i(1595);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "destroyItem pos:%s, v:%s", Integer.valueOf(i), Integer.valueOf(obj.hashCode()));
                    viewGroup.removeView((View) obj);
                    AppMethodBeat.o(1595);
                }
            });
            this.sBU.addOnPageChangeListener(new OnPageChangeListener() {
                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    AppMethodBeat.i(1597);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageSelected:".concat(String.valueOf(i)));
                    b.this.al(i, true);
                    if (!tabLayout.ac(i).isSelected()) {
                        tabLayout.ac(i).select();
                    }
                    AppMethodBeat.o(1597);
                }

                public final void onPageScrollStateChanged(int i) {
                    AppMethodBeat.i(1598);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(i)));
                    if (i == 0) {
                        if (b.this.sBZ) {
                            final int i2 = b.this.sBW;
                            b.this.sBU.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(1596);
                                    if (i2 == b.this.sBW) {
                                        ((a) b.this.rsl.get(b.this.sBW)).sCw.setVisibility(8);
                                        ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.this.sBW);
                                    }
                                    AppMethodBeat.o(1596);
                                }
                            }, 100);
                            AppMethodBeat.o(1598);
                            return;
                        }
                        b.this.sBZ = true;
                    }
                    AppMethodBeat.o(1598);
                }
            });
            this.sBK.zNv = new d() {
                public final void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
                    AppMethodBeat.i(1599);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onWebViewScrollChanged %s,   %s", Integer.valueOf(i2), Integer.valueOf(i4));
                    a aVar = (a) b.this.rsl.get(b.this.sBW);
                    aVar.sCx--;
                    AppMethodBeat.o(1599);
                }
            };
            i = this.sBH.getIntent().getIntExtra("key_chosetab", 0);
            for (com.tencent.mm.plugin.topstory.ui.c.b bVar2 : this.sBO) {
                if (bVar2.category == i) {
                    bVar2.sBy.select();
                }
            }
            if (tabLayout.getSelectedTabPosition() < 0) {
                tabLayout.ac(0).select();
            }
            textView.setText("");
            String dor = aa.dor();
            if (!(dor.equals("zh_TW") || dor.equals("zh_HK") || dor.equals("zh_CN"))) {
                this.sBH.findViewById(R.id.ey6).setVisibility(8);
            }
        }
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(1588);
                b.this.onBackBtnClick();
                AppMethodBeat.o(1588);
            }
        });
        ((ImageView) this.sBH.findViewById(R.id.kx)).getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        this.iNB.dKS();
        if (cFE()) {
            String cFe = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFe();
            if (bo.isNullOrNil(cFe)) {
                this.sBP.setVisibility(8);
            } else {
                av(cFe, ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFf());
            }
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(1589);
                    if (b.this.sBY) {
                        AppMethodBeat.o(1589);
                        return;
                    }
                    b.this.sBY = true;
                    b.this.fR(36, 3);
                    com.tencent.mm.plugin.report.e.pXa.e(15449, Integer.valueOf(0));
                    if (b.this.sBP.getVisibility() == 0) {
                        b.this.sBP.setVisibility(8);
                        cht cht = new cht();
                        cht.cJb = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFe();
                        cht.xgz = ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFf();
                        an.a(cht, 106, 5, 0, System.currentTimeMillis() / 1000, "");
                        ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFh();
                    }
                    AppMethodBeat.o(1589);
                }
            });
        } else {
            findViewById2.setVisibility(8);
        }
        com.tencent.mm.plugin.topstory.ui.c.c(this.cPu, "uiOnCreate", System.currentTimeMillis());
        AppMethodBeat.o(1602);
    }

    public final void fR(int i, int i2) {
        AppMethodBeat.i(1603);
        an.l("", 0, 0, i);
        String HP = com.tencent.mm.plugin.websearch.api.aa.HP(i);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("topStoryScene", String.valueOf(this.cPu.scene));
            hashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("from", URLEncoder.encode(this.sBH.getString(R.string.ewq), "utf8"));
            String str = OpenSDKTool4Assistant.EXTRA_UIN;
            g.RN();
            hashMap.put(str, com.tencent.mm.kernel.a.QG());
            hashMap.put("timeZone", URLEncoder.encode(bo.dpA(), "utf8"));
            hashMap.put("ostype", com.tencent.mm.protocal.d.vxk);
            hashMap.put("subScene", String.valueOf(i2));
            hashMap.put(IssueStorage.COLUMN_EXT_INFO, ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cFg());
        } catch (Exception e) {
        }
        int i3 = i;
        ((j) g.K(j.class)).a(this.sBH, i3, "", HP, hashMap, this.sBH.getResources().getString(R.string.ex6), this.sBH.getResources().getColor(R.color.x));
        AppMethodBeat.o(1603);
    }

    public final void cFB() {
        AppMethodBeat.i(1604);
        if (!this.sBZ || this.rsl.size() <= 0) {
            this.sBZ = true;
            AppMethodBeat.o(1604);
            return;
        }
        final int i = this.sBW;
        this.sBU.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1600);
                if (i == b.this.sBW) {
                    ((a) b.this.rsl.get(b.this.sBW)).sCw.setVisibility(8);
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onH5RenderFinished hide fakeIv " + b.this.sBW);
                }
                AppMethodBeat.o(1600);
            }
        }, 100);
        AppMethodBeat.o(1604);
    }

    public final int cFC() {
        return this.sBX;
    }

    public final boolean FA(int i) {
        AppMethodBeat.i(1605);
        if (i == 4) {
            onBackBtnClick();
            AppMethodBeat.o(1605);
            return true;
        }
        AppMethodBeat.o(1605);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBackBtnClick() {
        AppMethodBeat.i(1606);
        if (this.sBS) {
            cFD();
            AppMethodBeat.o(1606);
            return;
        }
        if (this.sCb) {
            h.a(this.cPu, "uiBackBtnClick", System.currentTimeMillis());
        } else if (!this.sCa) {
            h.a(this.cPu, "uiBackBtnClickWithoutGetSearchData", System.currentTimeMillis());
        } else if (this.sCc) {
            h.a(this.cPu, "uiBackBtnClickWithoutH5Ready", System.currentTimeMillis());
        } else {
            h.a(this.cPu, "uiBackBtnClickWithoutDataReady", System.currentTimeMillis());
        }
        an.Il(19);
        if (this.sBI) {
            this.sBH.finish();
            AppMethodBeat.o(1606);
            return;
        }
        this.sBH.moveTaskToBack(true);
        AppMethodBeat.o(1606);
    }

    /* Access modifiers changed, original: final */
    public final void cFD() {
        AppMethodBeat.i(1607);
        if (this.sBL != null) {
            this.sBL.cHo();
            cFA();
        }
        AppMethodBeat.o(1607);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onResume() {
        AppMethodBeat.i(1608);
        h.a(this.cPu, "uiOnResume", System.currentTimeMillis());
        this.sBL.abN("onResume");
        if (this.sBK != null) {
            this.sBK.onResume();
        }
        com.tencent.mm.cj.c.atF("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        for (com.tencent.mm.plugin.topstory.ui.c.b bVar : this.sBO) {
            if (bVar.sBv > 0) {
                if (bVar.category == 110) {
                    an.a(((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEW(), 107, 2, bVar.sBv, 0, "");
                }
            } else if (bVar.sBu > 0) {
                if (bVar.category == 110) {
                    an.a(((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cEP(), 107, 1, 0, 0, "");
                } else if (bVar.category == 100) {
                    cht cht = new cht();
                    cht.cJb = bVar.sBw;
                    an.a(cht, 107, 3, 0, 0, "");
                }
            }
        }
        this.cAY = false;
        this.sBY = false;
        AppMethodBeat.o(1608);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPause() {
        AppMethodBeat.i(1609);
        h.a(this.cPu, "uiOnPause", System.currentTimeMillis());
        this.sBL.abN("onPause");
        if (this.sBK != null) {
            this.sBK.onPause();
        }
        this.cAY = true;
        AppMethodBeat.o(1609);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDestroy() {
        AppMethodBeat.i(1610);
        try {
            if (this.cPu.cdf == 100 && this.sBL != null) {
                com.tencent.mm.plugin.topstory.ui.webview.a.a(this.sBL, "onWebCommendLeaveFromFindPage", "");
            }
            if (this.sBK.getParent() != null && this.sBK.getParent().equals(this.raJ)) {
                ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "webViewContainer remove topstoryWebview");
                this.raJ.removeView(this.sBK);
            }
        } catch (Exception e) {
        }
        if (this.sBK != null) {
            this.sBK.onDestroy();
        }
        chn chn = this.cPu;
        if (this.sBH.dyi() > 0) {
            ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(chn.scene), Long.valueOf(this.sBH.dyi()), Integer.valueOf(chn.cdf), Integer.valueOf(chn.xgl)}));
            com.tencent.mm.plugin.report.service.h.pYm.X(15018, r0);
        }
        h.a(this.cPu, "uiOnDestroy", System.currentTimeMillis());
        an.Il(18);
        f fVar = this.sBJ;
        fVar.sHt = null;
        fVar.sHv = null;
        g.Rg().b(1943, fVar);
        g.Rg().b(2582, fVar.sHA);
        g.Rg().b(2802, fVar.sEu);
        g.Rg().b(2906, fVar.sHz);
        this.sCd.dead();
        g.RO().b(this.fyJ);
        ((com.tencent.mm.plugin.topstory.ui.a) g.M(com.tencent.mm.plugin.topstory.ui.a.class)).setHaokanEventListener(null);
        ((com.tencent.mm.plugin.topstory.a.b) g.M(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().b(this.sCe);
        AppMethodBeat.o(1610);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(1611);
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
        this.cPu.xgn = com.tencent.mm.plugin.websearch.api.aa.bVP();
        h.a(this.cPu, "uiOnNewIntent", System.currentTimeMillis());
        an.Il(20);
        this.sBL.abN("onNewIntent");
        AppMethodBeat.o(1611);
    }

    public final MMActivity bKU() {
        return this.sBH;
    }

    public final void cFy() {
        this.sCa = true;
    }

    public final void cFz() {
        AppMethodBeat.i(1612);
        this.sCb = true;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1567);
                b.this.iNB.dKT();
                b.this.sBM.setVisibility(8);
                b.this.sBK.setVisibility(0);
                AppMethodBeat.o(1567);
            }
        });
        AppMethodBeat.o(1612);
    }

    /* Access modifiers changed, original: protected */
    public boolean cFE() {
        return true;
    }

    public final void abD(String str) {
        AppMethodBeat.i(1613);
        for (a aVar : this.rsl) {
            if (aVar.sCw != null) {
                aVar.sCx = 0;
                ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "invalid cache when onSearchDataReady");
            }
        }
        this.sCc = true;
        this.sBL.abD(str);
        AppMethodBeat.o(1613);
    }

    public final void abE(String str) {
        AppMethodBeat.i(1614);
        al.d(new com.tencent.mm.plugin.topstory.ui.webview.e.AnonymousClass7(str));
        AppMethodBeat.o(1614);
    }

    public final void abF(String str) {
        AppMethodBeat.i(1615);
        al.d(new com.tencent.mm.plugin.topstory.ui.webview.e.AnonymousClass10(str));
        AppMethodBeat.o(1615);
    }

    public final void abG(String str) {
        AppMethodBeat.i(1616);
        al.d(new com.tencent.mm.plugin.topstory.ui.webview.e.AnonymousClass9(str));
        AppMethodBeat.o(1616);
    }

    public final void fQ(final int i, final int i2) {
        AppMethodBeat.i(1617);
        this.sBH.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1569);
                ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "showNavBarShadow %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                int i = i + (16581375 * i2);
                b.this.sBN.setBackgroundColor(i);
                b.this.sBN.setVisibility(0);
                if (VERSION.SDK_INT >= 21 && !com.tencent.mm.sdk.h.b.Mt()) {
                    b.this.sBH.getWindow().setStatusBarColor(ah.s(i, b.this.sBH.getResources().getColor(R.color.x)));
                }
                b.this.sBS = true;
                b.this.sBN.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(1568);
                        b.a(b.this);
                        AppMethodBeat.o(1568);
                    }
                });
                if (b.this.sBU != null) {
                    b.this.sBU.setScrollEnable(false);
                }
                AppMethodBeat.o(1569);
            }
        });
        AppMethodBeat.o(1617);
    }

    public final void cFA() {
        AppMethodBeat.i(1618);
        this.sBH.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(1570);
                ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "hideNavBarShadow");
                b.this.sBN.setVisibility(8);
                if (VERSION.SDK_INT >= 21 && !com.tencent.mm.sdk.h.b.Mt()) {
                    b.this.sBH.getWindow().setStatusBarColor(b.this.sBH.getResources().getColor(R.color.x));
                }
                b.this.sBS = false;
                if (b.this.sBU != null) {
                    b.this.sBU.setScrollEnable(true);
                }
                AppMethodBeat.o(1570);
            }
        });
        AppMethodBeat.o(1618);
    }

    public final void a(c cVar, TopStoryWebView topStoryWebView, e eVar, chn chn) {
        AppMethodBeat.i(1619);
        this.sBJ = cVar;
        this.sBK = topStoryWebView;
        this.sBL = eVar;
        this.sBL.sHt = this;
        this.cPu = chn;
        c cVar2 = this.sBJ;
        cVar2.sHt = this;
        g.Rg().a(2582, cVar2.sHA);
        g.Rg().a(2802, cVar2.sEu);
        g.Rg().a(2906, cVar2.sHz);
        this.raJ.addView(this.sBK, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(1619);
    }

    /* Access modifiers changed, original: final */
    public final void av(String str, long j) {
        AppMethodBeat.i(1620);
        this.sBP.setVisibility(0);
        cht cht = new cht();
        cht.cJb = str;
        cht.xgz = j;
        an.a(cht, 107, 5, 0, 0, "");
        AppMethodBeat.o(1620);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(1621);
        try {
            bundle.putByteArray("key_context", this.cPu.toByteArray());
            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onSaveInstanceState %s", this.cPu.xgj);
            AppMethodBeat.o(1621);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "onSaveInstanceState", new Object[0]);
            AppMethodBeat.o(1621);
        }
    }

    static Bitmap a(TopStoryWebView topStoryWebView, int i, int i2) {
        Bitmap createBitmap;
        AppMethodBeat.i(1622);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            createBitmap = Bitmap.createBitmap(i, i2, Config.RGB_565);
            topStoryWebView.drawCanvas(new Canvas(createBitmap));
            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "captureWebView success, cost:" + (System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mm.plugin.topstory.a.a.b.cFr();
        } catch (Throwable th) {
            Throwable th2 = th;
            createBitmap = null;
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", th2, "captureWebView error", new Object[0]);
            com.tencent.mm.plugin.topstory.a.a.b.cFr();
        }
        AppMethodBeat.o(1622);
        return createBitmap;
    }

    public final synchronized void al(int i, boolean z) {
        Object obj = null;
        synchronized (this) {
            AppMethodBeat.i(1623);
            ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView, from " + (z ? "viewpager" : "tab"));
            if (i == this.sBW) {
                ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView return");
                AppMethodBeat.o(1623);
            } else {
                final int i2 = i == 0 ? 1 : 0;
                this.sBW = i;
                final a aVar = (a) this.rsl.get(i2);
                if (this.sBV.getParent() == ((a) this.rsl.get(i2)).sCv) {
                    Object obj2;
                    if (aVar.sCx <= 0) {
                        obj2 = 1;
                    } else {
                        aVar.sCw.setVisibility(0);
                        ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "changeView cacheworked");
                        obj2 = null;
                    }
                    aVar.sCx = 2;
                    obj = obj2;
                } else {
                    aVar.sCw.setVisibility(0);
                }
                final com.tencent.mm.plugin.topstory.ui.c.b bVar = (com.tencent.mm.plugin.topstory.ui.c.b) this.sBO.get(this.sBW);
                this.sBZ = false;
                if (obj != null) {
                    com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(1586);
                            final Bitmap a = b.a(b.this.sBK, aVar.sCv.getWidth(), aVar.sCv.getHeight());
                            b.this.sBH.runOnUiThread(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(1585);
                                    if (a != null) {
                                        aVar.sCw.setImageBitmap(a);
                                    } else {
                                        aVar.sCw.setImageDrawable(b.this.sBH.getResources().getDrawable(R.color.z));
                                        aVar.sCx = 0;
                                    }
                                    aVar.sCw.setVisibility(0);
                                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "layout %s,%s, fakeIv %s,%s", Integer.valueOf(aVar.sCv.getWidth()), Integer.valueOf(aVar.sCv.getHeight()), Integer.valueOf(aVar.sCw.getWidth()), Integer.valueOf(aVar.sCw.getHeight()));
                                    if (b.this.sBV.getParent() != null) {
                                        ((ViewGroup) b.this.sBV.getParent()).removeView(b.this.sBV);
                                        ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "remove view from:" + i2);
                                    }
                                    ((a) b.this.rsl.get(b.this.sBW)).sCv.addView(b.this.sBV, new FrameLayout.LayoutParams(-1, -1));
                                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "add view to:" + b.this.sBW);
                                    b.this.sBL.aj(bVar.sBt, bVar.sBu, bVar.sBv);
                                    AppMethodBeat.o(1585);
                                }
                            });
                            AppMethodBeat.o(1586);
                        }
                    }, "CaptureWebViewTask");
                } else {
                    if (this.sBV.getParent() != null) {
                        ((ViewGroup) this.sBV.getParent()).removeView(this.sBV);
                        ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "remove view from:".concat(String.valueOf(i2)));
                    }
                    ((a) this.rsl.get(this.sBW)).sCv.addView(this.sBV, new FrameLayout.LayoutParams(-1, -1));
                    ab.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "add view to:" + this.sBW);
                    this.sBL.aj(bVar.sBt, bVar.sBu, bVar.sBv);
                }
                an.b(bVar.category, this.sBQ, bo.isNullOrNil(bVar.sBx) ? bVar.sBw : bVar.sBx, this.cPu.hlm, z);
                AppMethodBeat.o(1623);
            }
        }
    }
}
