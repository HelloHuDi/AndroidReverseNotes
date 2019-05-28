package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.model.C28221ac;
import com.tencent.p177mm.plugin.game.model.C28221ac.C12157a;
import com.tencent.p177mm.plugin.game.model.C39214ax;
import com.tencent.p177mm.plugin.game.model.C46008an;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C46000a.C3220a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.GameBlockView.C210081;
import com.tencent.p177mm.plugin.game.p433ui.GameBlockView.C21009a;
import com.tencent.p177mm.plugin.game.p433ui.GameIndexSearchView.C32571;
import com.tencent.p177mm.plugin.game.p433ui.GameIndexWxagView.C121821;
import com.tencent.p177mm.plugin.game.p433ui.GameIndexWxagView.C12183a;
import com.tencent.p177mm.plugin.game.p731d.C12115by;
import com.tencent.p177mm.plugin.game.p731d.C28191ct;
import com.tencent.p177mm.plugin.game.p731d.C39184ah;
import com.tencent.p177mm.plugin.game.p731d.C43162be;
import com.tencent.p177mm.plugin.game.p731d.C45993cp;
import com.tencent.p177mm.plugin.game.p731d.C6932am;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameCenterUI5 */
public class GameCenterUI5 extends GameCenterBaseUI implements C1202f {
    private boolean exX = true;
    private Dialog lud;
    private GameNewTopBannerView nfM;
    private GameIndexSearchView nfN;
    private GameIndexWxagView nfO;
    private GameMessageBubbleView nfP;
    private GameBlockView nfQ;
    private GameRecomBlockView nfR;
    private GameNewClassifyView nfS;
    private GameIndexListView nfT;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCenterUI5$3 */
    class C392183 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameCenterUI5$3$1 */
        class C282391 implements Runnable {
            C282391() {
            }

            public final void run() {
                AppMethodBeat.m2504i(111790);
                if (GameCenterUI5.this.isFinishing()) {
                    AppMethodBeat.m2505o(111790);
                    return;
                }
                GameCenterUI5.this.lud = C46001c.m85459ej(GameCenterUI5.this);
                GameCenterUI5.this.lud.show();
                AppMethodBeat.m2505o(111790);
            }
        }

        C392183() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111792);
            byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("pb_index_4");
            if (NK == null) {
                C5004al.m7441d(new C282391());
            } else {
                final C28221ac c28221ac = new C28221ac(NK);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(111791);
                        GameCenterUI5.m66828a(GameCenterUI5.this, c28221ac, 1);
                        AppMethodBeat.m2505o(111791);
                    }
                });
            }
            ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(GameCenterUI5.this);
            C46001c.m85454ab(C20993e.bDR());
            C1720g.m3540Rg().mo14541a(new C46008an(C4988aa.dor(), C20993e.bDR(), GameCenterUI5.this.nfw, GameCenterUI5.this.nfx, GameCenterUI5.this.nfy, GameCenterUI5.this.nfv), 0);
            C20993e.m32272dY(GameCenterUI5.this.mController.ylL);
            C20993e.bDW();
            C3220a.nnu.bFC();
            AppMethodBeat.m2505o(111792);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameCenterUI5$1 */
    class C392191 implements OnMenuItemClickListener {
        C392191() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111787);
            GameCenterUI5.this.finish();
            AppMethodBeat.m2505o(111787);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111793);
        super.onCreate(bundle);
        if (C1720g.m3531RK()) {
            GameIndexListView.setSourceScene(this.mXC);
            C1720g.m3540Rg().mo14539a(2994, (C1202f) this);
            initView();
            C46001c.aNS().mo10302aa(new C392183());
            C4990ab.m7417i("MicroMsg.GameCenterUI5", "fromScene = %d", Integer.valueOf(this.mXC));
            AppMethodBeat.m2505o(111793);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameCenterUI5", "account not ready");
        finish();
        AppMethodBeat.m2505o(111793);
    }

    public void onResume() {
        AppMethodBeat.m2504i(111794);
        super.onResume();
        if (C1720g.m3531RK()) {
            if (!this.exX) {
                ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(this);
                GameMessageBubbleView gameMessageBubbleView = this.nfP;
                gameMessageBubbleView.nle.setOnClickListener(null);
                gameMessageBubbleView.setVisibility(8);
                if (this.nfv) {
                    this.nfP.bFu();
                }
                GameBlockView gameBlockView = this.nfQ;
                if (gameBlockView.nfa != null) {
                    gameBlockView.nfa.nff.refresh();
                }
                GameIndexListView gameIndexListView = this.nfT;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) gameIndexListView.getLayoutManager();
                int iQ = linearLayoutManager.mo1780iQ();
                gameIndexListView.njg.mo66308ar(iQ, (linearLayoutManager.mo1782iS() - iQ) + 1);
            }
            this.exX = false;
            AppMethodBeat.m2505o(111794);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameCenterUI5", "account not ready");
        AppMethodBeat.m2505o(111794);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111795);
        C4990ab.m7416i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (C1720g.m3531RK()) {
            C3220a.nnu.clearCache();
            C1720g.m3540Rg().mo14546b(2994, (C1202f) this);
            ((C43156b) C1720g.m3528K(C43156b.class)).bCV().clearCache();
            C39214ax.bEU();
            C39214ax.bEW();
            AppMethodBeat.m2505o(111795);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameCenterUI5", "account not ready");
        AppMethodBeat.m2505o(111795);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(111796);
        setBackBtn(new C392191());
        setMMTitle((int) C25738R.string.c8c);
        this.nfT = (GameIndexListView) findViewById(2131824328);
        this.nfT.setVisibility(8);
        View inflate = getLayoutInflater().inflate(2130969727, this.nfT, false);
        this.nfT.addHeaderView(inflate);
        this.nfM = (GameNewTopBannerView) inflate.findViewById(2131824534);
        this.nfN = (GameIndexSearchView) inflate.findViewById(2131824536);
        this.nfO = (GameIndexWxagView) inflate.findViewById(2131824537);
        this.nfP = (GameMessageBubbleView) inflate.findViewById(2131824333);
        this.nfQ = (GameBlockView) inflate.findViewById(2131824538);
        this.nfR = (GameRecomBlockView) inflate.findViewById(2131824539);
        this.nfS = (GameNewClassifyView) inflate.findViewById(2131824540);
        AppMethodBeat.m2505o(111796);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(111797);
        C4990ab.m7417i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c1207m.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 2994:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final C1331a c1331a = ((C46008an) c1207m).lty.fsH.fsP;
                    C46001c.aNS().mo10302aa(new Runnable() {
                        public final void run() {
                            C43162be c43162be;
                            AppMethodBeat.m2504i(111789);
                            if (c1331a == null) {
                                c43162be = new C43162be();
                            } else {
                                c43162be = (C43162be) c1331a;
                                ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54826b("pb_index_4", c43162be);
                            }
                            final C28221ac c28221ac = new C28221ac(c43162be);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(111788);
                                    try {
                                        GameCenterUI5.m66828a(GameCenterUI5.this, c28221ac, 2);
                                    } catch (Exception e) {
                                        C4990ab.m7413e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", e.getMessage());
                                        GameCenterUI5.this.finish();
                                    }
                                    if (GameCenterUI5.this.lud != null) {
                                        GameCenterUI5.this.lud.dismiss();
                                    }
                                    C4990ab.m7417i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.m2505o(111788);
                                }
                            });
                            AppMethodBeat.m2505o(111789);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(111797);
            return;
        }
        if (!C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(C25738R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.m2505o(111797);
    }

    public final int getLayoutId() {
        return 2130969665;
    }

    /* renamed from: a */
    static /* synthetic */ void m66828a(GameCenterUI5 gameCenterUI5, C28221ac c28221ac, int i) {
        AppMethodBeat.m2504i(111798);
        if (gameCenterUI5.isFinishing()) {
            C4990ab.m7420w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
            AppMethodBeat.m2505o(111798);
        } else if (c28221ac == null) {
            C4990ab.m7412e("MicroMsg.GameCenterUI5", "Null data");
            AppMethodBeat.m2505o(111798);
        } else {
            ImageView imageView;
            TextView textView;
            View childAt;
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.nfM;
            C12115by c12115by = c28221ac.mXV;
            int i2 = gameCenterUI5.mXC;
            boolean z = gameCenterUI5.nfz;
            if (c12115by == null || c12115by.ncK == null || C5046bo.isNullOrNil(c12115by.ncK.nap)) {
                GameNewTopBannerView.bFw();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.mXC = i2;
                gameNewTopBannerView.hxK = c12115by.ncJ != null ? C34276a.m56208kY(c12115by.ncJ.mZL) : null;
                if (!gameNewTopBannerView.nly.equals(c12115by.ncK.nap)) {
                    gameNewTopBannerView.nly = c12115by.ncK.nap;
                    C28203e.bFH().mo46100h(gameNewTopBannerView.nfK, c12115by.ncK.nap);
                    gameNewTopBannerView.nlw = gameNewTopBannerView.mo68707b(gameNewTopBannerView.nfK, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9928kf), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9927ke));
                    if (gameNewTopBannerView.nlw > 0) {
                        if (i == 2) {
                            C34277b.m56210a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.mXC, 0, null, null, gameNewTopBannerView.hxK);
                        }
                        if (gameNewTopBannerView.nlw <= 0 || c12115by.ncJ == null || C5046bo.isNullOrNil(c12115by.ncJ.mZi)) {
                            gameNewTopBannerView.nfJ.setVisibility(8);
                        } else {
                            C28203e.bFH().mo46100h(gameNewTopBannerView.nfJ, c12115by.ncJ.mZi);
                            gameNewTopBannerView.nlx = gameNewTopBannerView.mo68707b(gameNewTopBannerView.nfJ, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9926kc), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9927ke));
                            if (gameNewTopBannerView.nlx > 0) {
                                gameNewTopBannerView.nfJ.setVisibility(0);
                                gameNewTopBannerView.nfJ.setTag(c12115by.ncJ.mZj);
                                gameNewTopBannerView.nfJ.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.nfJ.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.nfJ.getVisibility() == 0) {
                            if (c12115by.ncJ.ndE == C20993e.m32278ee(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.setInitPadding(gameNewTopBannerView.nlw - gameNewTopBannerView.nlx);
                                gameNewTopBannerView.nfJ.setImageAlpha(0);
                            } else {
                                gameNewTopBannerView.nfK.setImageAlpha(0);
                                C20993e.m32259N(gameNewTopBannerView.mContext, c12115by.ncJ.ndE);
                                GameIndexListView.setInitPadding(0);
                            }
                            GameIndexListView.setDefaultPadding(gameNewTopBannerView.nlw - gameNewTopBannerView.nlx);
                            GameIndexListView.setCanPulldown(true);
                        } else {
                            GameNewTopBannerView.bFw();
                        }
                        gameNewTopBannerView.setVisibility(0);
                    } else {
                        GameNewTopBannerView.bFw();
                        gameNewTopBannerView.setVisibility(8);
                    }
                } else if (i == 2) {
                    C34277b.m56210a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.mXC, 0, null, null, gameNewTopBannerView.hxK);
                }
            }
            GameIndexSearchView gameIndexSearchView = gameCenterUI5.nfN;
            C12115by c12115by2 = c28221ac.mXV;
            int i3 = gameCenterUI5.mXC;
            if (c12115by2 == null || c12115by2.ncK == null || c12115by2.ncK.ndj == null) {
                gameIndexSearchView.setVisibility(8);
            } else {
                gameIndexSearchView.removeAllViews();
                C45993cp c45993cp = c12115by2.ncK.ndj;
                gameIndexSearchView.setVisibility(0);
                gameIndexSearchView.mInflater.inflate(2130969729, gameIndexSearchView, true);
                imageView = (ImageView) gameIndexSearchView.findViewById(2131824390);
                textView = (TextView) gameIndexSearchView.findViewById(2131824541);
                C12125a c12125a = new C12125a();
                if (C5046bo.isNullOrNil(c45993cp.IconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    C28203e.bFH().mo46098a(imageView, c45993cp.IconUrl, c12125a.bFI());
                }
                if (C5046bo.isNullOrNil(c45993cp.Title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(c45993cp.Title);
                }
                gameIndexSearchView.setTag(c45993cp.mZj);
                gameIndexSearchView.setOnClickListener(new C32571(i3));
            }
            GameIndexWxagView gameIndexWxagView = gameCenterUI5.nfO;
            C6932am c6932am = c28221ac.mXZ;
            int i4 = gameCenterUI5.mXC;
            if (c6932am == null) {
                gameIndexWxagView.setVisibility(8);
            } else {
                gameIndexWxagView.mXC = i4;
                gameIndexWxagView.setVisibility(0);
                gameIndexWxagView.mContainer.removeAllViews();
                if (C5046bo.m7548ek(c6932am.nbc) && c6932am.nbd == null) {
                    gameIndexWxagView.setVisibility(8);
                } else {
                    int i5;
                    int i6;
                    if (i == 2) {
                        C34276a.m56205a(gameIndexWxagView.getContext(), 10, 1025, 0, null, i4, C34276a.m56208kY(c6932am.mZL));
                    }
                    gameIndexWxagView.mInflater.inflate(2130969667, gameIndexWxagView, true);
                    TextView textView2 = (TextView) gameIndexWxagView.findViewById(2131824331);
                    LinearLayout linearLayout = (LinearLayout) gameIndexWxagView.findViewById(2131824332);
                    if (C5046bo.isNullOrNil(c6932am.Title)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(c6932am.Title);
                    }
                    i2 = 0;
                    while (true) {
                        i5 = i2;
                        if (i5 >= 4) {
                            break;
                        }
                        linearLayout.addView((LinearLayout) gameIndexWxagView.mInflater.inflate(2130969666, gameIndexWxagView, false), new LayoutParams(-1, -2, 1.0f));
                        i2 = i5 + 1;
                    }
                    i5 = 0;
                    if (!C5046bo.m7548ek(c6932am.nbc)) {
                        i2 = 0;
                        while (true) {
                            int i7 = i2;
                            i6 = i5;
                            if (i7 >= c6932am.nbc.size()) {
                                break;
                            }
                            C28191ct c28191ct = (C28191ct) c6932am.nbc.get(i7);
                            if (!(c28191ct == null || c28191ct.ndn == null || c28191ct.ndn.ndN == null)) {
                                View childAt2 = linearLayout.getChildAt(i6);
                                textView = (TextView) childAt2.findViewById(2131824330);
                                C28203e.bFH().mo46100h((ImageView) childAt2.findViewById(2131824329), c28191ct.ndn.ndN.IconUrl);
                                textView.setText(c28191ct.ndn.ndN.ncH);
                                if (i == 2) {
                                    C34276a.m56205a(gameIndexWxagView.getContext(), 10, 1025, i6 + 1, c28191ct.ndn.ndN.fKh, i4, null);
                                }
                                childAt2.setTag(new C12183a(i6 + 1, c28191ct.ndn.ndN));
                                childAt2.setOnClickListener(gameIndexWxagView);
                                i6++;
                                if (i6 >= 3) {
                                    break;
                                }
                            }
                            i5 = i6;
                            i2 = i7 + 1;
                        }
                    } else {
                        i6 = 0;
                    }
                    if (c6932am.nbd != null) {
                        childAt = linearLayout.getChildAt(i6);
                        textView = (TextView) childAt.findViewById(2131824330);
                        C28203e.bFH().mo46100h((ImageView) childAt.findViewById(2131824329), c6932am.nbd.IconUrl);
                        textView.setText(c6932am.nbd.ncH);
                        childAt.setTag(c6932am.nbd);
                        childAt.setOnClickListener(new C121821(i4));
                    }
                    View view = new View(gameIndexWxagView.getContext());
                    view.setBackgroundColor(gameIndexWxagView.getContext().getResources().getColor(C25738R.color.f12022pr));
                    gameIndexWxagView.addView(view, new LayoutParams(-1, C1338a.fromDPToPix(gameIndexWxagView.getContext(), 5)));
                }
            }
            if (gameCenterUI5.nfv) {
                gameCenterUI5.nfP.bFu();
            }
            GameBlockView gameBlockView = gameCenterUI5.nfQ;
            C12157a c12157a = c28221ac.mXW;
            i4 = gameCenterUI5.mXC;
            if (c12157a == null) {
                gameBlockView.setVisibility(8);
            } else {
                gameBlockView.neZ.setSourceScene(i4);
                gameBlockView.setVisibility(0);
                gameBlockView.mpt.removeAllViews();
                if (c12157a.mYa == null || C5046bo.isNullOrNil(c12157a.mYa.field_appId) || C5046bo.isNullOrNil(c12157a.mYa.field_appName)) {
                    gameBlockView.setVisibility(8);
                } else {
                    View findViewById;
                    if (i == 2) {
                        C34276a.m56205a(gameBlockView.getContext(), 10, 1002, 0, c12157a.mYa.field_appId, i4, null);
                    }
                    C20992c c20992c = c12157a.mYa;
                    gameBlockView.nfa = new C21009a();
                    childAt = gameBlockView.mInflater.inflate(2130969661, gameBlockView.mpt, false);
                    gameBlockView.nfa.nfd = (ViewGroup) childAt.findViewById(2131824316);
                    gameBlockView.nfa.neO = (ImageView) childAt.findViewById(2131821535);
                    gameBlockView.nfa.neP = (TextView) childAt.findViewById(2131821537);
                    gameBlockView.nfa.nfe = (TextView) childAt.findViewById(2131824318);
                    gameBlockView.nfa.nff = (GameDownloadView) childAt.findViewById(2131824317);
                    C28203e.bFH().mo46096a(gameBlockView.nfa.neO, c20992c.field_appId, C1338a.getDensity(gameBlockView.getContext()));
                    CharSequence charSequence = c20992c.field_appName;
                    if (!C5046bo.isNullOrNil(c20992c.field_appName) && c20992c.field_appName.length() > 8) {
                        charSequence = c20992c.field_appName.substring(0, 7) + "...";
                    }
                    gameBlockView.nfa.neP.setText(charSequence);
                    if (C5046bo.isNullOrNil(c20992c.mVk)) {
                        gameBlockView.nfa.nfe.setVisibility(8);
                    } else {
                        gameBlockView.nfa.nfe.setText(c20992c.mVk);
                        gameBlockView.nfa.nfe.setVisibility(0);
                    }
                    gameBlockView.nfa.nff.setDownloadInfo(new C21003k(c20992c));
                    gameBlockView.nfa.nfd.setOnClickListener(gameBlockView.neZ);
                    gameBlockView.nfa.nfd.setTag(c20992c);
                    gameBlockView.mpt.addView(childAt);
                    C46017f c46017f = new C46017f(gameBlockView.getContext());
                    c46017f.mo73917a(c12157a.mYc, c12157a.mYa.field_appId, i, i4);
                    gameBlockView.mpt.addView(c46017f, gameBlockView.neY);
                    C39235e c39235e = new C39235e(gameBlockView.getContext());
                    c39235e.mo62129a(c12157a.mYb, c12157a.mYa.field_appId, i, i4);
                    gameBlockView.mpt.addView(c39235e, gameBlockView.neY);
                    if (c12157a.mYd != null) {
                        imageView = (ImageView) gameBlockView.mInflater.inflate(2130969702, gameBlockView, false);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.leftMargin = C1338a.fromDPToPix(gameBlockView.getContext(), 20);
                        imageView.setLayoutParams(marginLayoutParams);
                        gameBlockView.addView(imageView);
                        gameBlockView.mInflater.inflate(2130969662, gameBlockView, true);
                        findViewById = gameBlockView.findViewById(2131821169);
                        ((TextView) gameBlockView.findViewById(2131824319)).setText(c12157a.mYd.Desc);
                        findViewById.setTag(c12157a.mYd.mZj);
                        findViewById.setOnClickListener(new C210081(i4));
                    }
                    LinearLayout linearLayout2 = gameBlockView.mpt;
                    findViewById = new View(gameBlockView.getContext());
                    findViewById.setBackgroundColor(gameBlockView.getContext().getResources().getColor(C25738R.color.f12022pr));
                    linearLayout2.addView(findViewById, new LayoutParams(-1, C1338a.fromDPToPix(gameBlockView.getContext(), 5)));
                }
            }
            GameRecomBlockView gameRecomBlockView = gameCenterUI5.nfR;
            C39184ah c39184ah = c28221ac.mXX;
            int i8 = gameCenterUI5.mXC;
            if (c39184ah == null) {
                gameRecomBlockView.setVisibility(8);
            } else {
                gameRecomBlockView.mXC = i8;
                gameRecomBlockView.setVisibility(0);
                gameRecomBlockView.mo36357a(c39184ah, i, i8);
            }
            gameCenterUI5.nfS.mo68704a(c28221ac.mXY, i, gameCenterUI5.mXC);
            gameCenterUI5.nfT.setVisibility(0);
            AppMethodBeat.m2505o(111798);
        }
    }
}
