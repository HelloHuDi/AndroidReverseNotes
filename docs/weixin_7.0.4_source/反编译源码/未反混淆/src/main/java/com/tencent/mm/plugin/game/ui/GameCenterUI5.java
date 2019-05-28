package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.d.ah;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.be;
import com.tencent.mm.plugin.game.d.by;
import com.tencent.mm.plugin.game.d.cp;
import com.tencent.mm.plugin.game.d.ct;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ax;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class GameCenterUI5 extends GameCenterBaseUI implements f {
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111793);
        super.onCreate(bundle);
        if (g.RK()) {
            GameIndexListView.setSourceScene(this.mXC);
            g.Rg().a(2994, (f) this);
            initView();
            c.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111792);
                    byte[] NK = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().NK("pb_index_4");
                    if (NK == null) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111790);
                                if (GameCenterUI5.this.isFinishing()) {
                                    AppMethodBeat.o(111790);
                                    return;
                                }
                                GameCenterUI5.this.lud = c.ej(GameCenterUI5.this);
                                GameCenterUI5.this.lud.show();
                                AppMethodBeat.o(111790);
                            }
                        });
                    } else {
                        final ac acVar = new ac(NK);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111791);
                                GameCenterUI5.a(GameCenterUI5.this, acVar, 1);
                                AppMethodBeat.o(111791);
                            }
                        });
                    }
                    ((b) g.K(b.class)).bCV().init(GameCenterUI5.this);
                    c.ab(e.bDR());
                    g.Rg().a(new an(aa.dor(), e.bDR(), GameCenterUI5.this.nfw, GameCenterUI5.this.nfx, GameCenterUI5.this.nfy, GameCenterUI5.this.nfv), 0);
                    e.dY(GameCenterUI5.this.mController.ylL);
                    e.bDW();
                    a.nnu.bFC();
                    AppMethodBeat.o(111792);
                }
            });
            ab.i("MicroMsg.GameCenterUI5", "fromScene = %d", Integer.valueOf(this.mXC));
            AppMethodBeat.o(111793);
            return;
        }
        ab.e("MicroMsg.GameCenterUI5", "account not ready");
        finish();
        AppMethodBeat.o(111793);
    }

    public void onResume() {
        AppMethodBeat.i(111794);
        super.onResume();
        if (g.RK()) {
            if (!this.exX) {
                ((b) g.K(b.class)).bCV().init(this);
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
                int iQ = linearLayoutManager.iQ();
                gameIndexListView.njg.ar(iQ, (linearLayoutManager.iS() - iQ) + 1);
            }
            this.exX = false;
            AppMethodBeat.o(111794);
            return;
        }
        ab.e("MicroMsg.GameCenterUI5", "account not ready");
        AppMethodBeat.o(111794);
    }

    public void onDestroy() {
        AppMethodBeat.i(111795);
        ab.i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (g.RK()) {
            a.nnu.clearCache();
            g.Rg().b(2994, (f) this);
            ((b) g.K(b.class)).bCV().clearCache();
            ax.bEU();
            ax.bEW();
            AppMethodBeat.o(111795);
            return;
        }
        ab.e("MicroMsg.GameCenterUI5", "account not ready");
        AppMethodBeat.o(111795);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.i(111796);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111787);
                GameCenterUI5.this.finish();
                AppMethodBeat.o(111787);
                return true;
            }
        });
        setMMTitle((int) R.string.c8c);
        this.nfT = (GameIndexListView) findViewById(R.id.c1_);
        this.nfT.setVisibility(8);
        View inflate = getLayoutInflater().inflate(R.layout.a4a, this.nfT, false);
        this.nfT.addHeaderView(inflate);
        this.nfM = (GameNewTopBannerView) inflate.findViewById(R.id.c6u);
        this.nfN = (GameIndexSearchView) inflate.findViewById(R.id.c6w);
        this.nfO = (GameIndexWxagView) inflate.findViewById(R.id.c6x);
        this.nfP = (GameMessageBubbleView) inflate.findViewById(R.id.c1e);
        this.nfQ = (GameBlockView) inflate.findViewById(R.id.c6y);
        this.nfR = (GameRecomBlockView) inflate.findViewById(R.id.c6z);
        this.nfS = (GameNewClassifyView) inflate.findViewById(R.id.c70);
        AppMethodBeat.o(111796);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(111797);
        ab.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(mVar.hashCode()));
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 2994:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bt.a aVar = ((an) mVar).lty.fsH.fsP;
                    c.aNS().aa(new Runnable() {
                        public final void run() {
                            be beVar;
                            AppMethodBeat.i(111789);
                            if (aVar == null) {
                                beVar = new be();
                            } else {
                                beVar = (be) aVar;
                                ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().b("pb_index_4", beVar);
                            }
                            final ac acVar = new ac(beVar);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(111788);
                                    try {
                                        GameCenterUI5.a(GameCenterUI5.this, acVar, 2);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", e.getMessage());
                                        GameCenterUI5.this.finish();
                                    }
                                    if (GameCenterUI5.this.lud != null) {
                                        GameCenterUI5.this.lud.dismiss();
                                    }
                                    ab.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(111788);
                                }
                            });
                            AppMethodBeat.o(111789);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(111797);
            return;
        }
        if (!com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.o(111797);
    }

    public final int getLayoutId() {
        return R.layout.a2m;
    }

    static /* synthetic */ void a(GameCenterUI5 gameCenterUI5, ac acVar, int i) {
        AppMethodBeat.i(111798);
        if (gameCenterUI5.isFinishing()) {
            ab.w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
            AppMethodBeat.o(111798);
        } else if (acVar == null) {
            ab.e("MicroMsg.GameCenterUI5", "Null data");
            AppMethodBeat.o(111798);
        } else {
            ImageView imageView;
            TextView textView;
            View childAt;
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.nfM;
            by byVar = acVar.mXV;
            int i2 = gameCenterUI5.mXC;
            boolean z = gameCenterUI5.nfz;
            if (byVar == null || byVar.ncK == null || bo.isNullOrNil(byVar.ncK.nap)) {
                GameNewTopBannerView.bFw();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.mXC = i2;
                gameNewTopBannerView.hxK = byVar.ncJ != null ? com.tencent.mm.plugin.game.e.a.kY(byVar.ncJ.mZL) : null;
                if (!gameNewTopBannerView.nly.equals(byVar.ncK.nap)) {
                    gameNewTopBannerView.nly = byVar.ncK.nap;
                    com.tencent.mm.plugin.game.f.e.bFH().h(gameNewTopBannerView.nfK, byVar.ncK.nap);
                    gameNewTopBannerView.nlw = gameNewTopBannerView.b(gameNewTopBannerView.nfK, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.kf), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.ke));
                    if (gameNewTopBannerView.nlw > 0) {
                        if (i == 2) {
                            com.tencent.mm.plugin.game.e.b.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.mXC, 0, null, null, gameNewTopBannerView.hxK);
                        }
                        if (gameNewTopBannerView.nlw <= 0 || byVar.ncJ == null || bo.isNullOrNil(byVar.ncJ.mZi)) {
                            gameNewTopBannerView.nfJ.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.f.e.bFH().h(gameNewTopBannerView.nfJ, byVar.ncJ.mZi);
                            gameNewTopBannerView.nlx = gameNewTopBannerView.b(gameNewTopBannerView.nfJ, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.kc), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.ke));
                            if (gameNewTopBannerView.nlx > 0) {
                                gameNewTopBannerView.nfJ.setVisibility(0);
                                gameNewTopBannerView.nfJ.setTag(byVar.ncJ.mZj);
                                gameNewTopBannerView.nfJ.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.nfJ.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.nfJ.getVisibility() == 0) {
                            if (byVar.ncJ.ndE == e.ee(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.setInitPadding(gameNewTopBannerView.nlw - gameNewTopBannerView.nlx);
                                gameNewTopBannerView.nfJ.setImageAlpha(0);
                            } else {
                                gameNewTopBannerView.nfK.setImageAlpha(0);
                                e.N(gameNewTopBannerView.mContext, byVar.ncJ.ndE);
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
                    com.tencent.mm.plugin.game.e.b.a(gameNewTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameNewTopBannerView.mXC, 0, null, null, gameNewTopBannerView.hxK);
                }
            }
            GameIndexSearchView gameIndexSearchView = gameCenterUI5.nfN;
            by byVar2 = acVar.mXV;
            int i3 = gameCenterUI5.mXC;
            if (byVar2 == null || byVar2.ncK == null || byVar2.ncK.ndj == null) {
                gameIndexSearchView.setVisibility(8);
            } else {
                gameIndexSearchView.removeAllViews();
                cp cpVar = byVar2.ncK.ndj;
                gameIndexSearchView.setVisibility(0);
                gameIndexSearchView.mInflater.inflate(R.layout.a4c, gameIndexSearchView, true);
                imageView = (ImageView) gameIndexSearchView.findViewById(R.id.c2y);
                textView = (TextView) gameIndexSearchView.findViewById(R.id.c71);
                com.tencent.mm.plugin.game.f.e.a.a aVar = new com.tencent.mm.plugin.game.f.e.a.a();
                if (bo.isNullOrNil(cpVar.IconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    com.tencent.mm.plugin.game.f.e.bFH().a(imageView, cpVar.IconUrl, aVar.bFI());
                }
                if (bo.isNullOrNil(cpVar.Title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(cpVar.Title);
                }
                gameIndexSearchView.setTag(cpVar.mZj);
                gameIndexSearchView.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameIndexSearchView.AnonymousClass1(i3));
            }
            GameIndexWxagView gameIndexWxagView = gameCenterUI5.nfO;
            am amVar = acVar.mXZ;
            int i4 = gameCenterUI5.mXC;
            if (amVar == null) {
                gameIndexWxagView.setVisibility(8);
            } else {
                gameIndexWxagView.mXC = i4;
                gameIndexWxagView.setVisibility(0);
                gameIndexWxagView.mContainer.removeAllViews();
                if (bo.ek(amVar.nbc) && amVar.nbd == null) {
                    gameIndexWxagView.setVisibility(8);
                } else {
                    int i5;
                    int i6;
                    if (i == 2) {
                        com.tencent.mm.plugin.game.e.a.a(gameIndexWxagView.getContext(), 10, 1025, 0, null, i4, com.tencent.mm.plugin.game.e.a.kY(amVar.mZL));
                    }
                    gameIndexWxagView.mInflater.inflate(R.layout.a2o, gameIndexWxagView, true);
                    TextView textView2 = (TextView) gameIndexWxagView.findViewById(R.id.c1c);
                    LinearLayout linearLayout = (LinearLayout) gameIndexWxagView.findViewById(R.id.c1d);
                    if (bo.isNullOrNil(amVar.Title)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(amVar.Title);
                    }
                    i2 = 0;
                    while (true) {
                        i5 = i2;
                        if (i5 >= 4) {
                            break;
                        }
                        linearLayout.addView((LinearLayout) gameIndexWxagView.mInflater.inflate(R.layout.a2n, gameIndexWxagView, false), new LayoutParams(-1, -2, 1.0f));
                        i2 = i5 + 1;
                    }
                    i5 = 0;
                    if (!bo.ek(amVar.nbc)) {
                        i2 = 0;
                        while (true) {
                            int i7 = i2;
                            i6 = i5;
                            if (i7 >= amVar.nbc.size()) {
                                break;
                            }
                            ct ctVar = (ct) amVar.nbc.get(i7);
                            if (!(ctVar == null || ctVar.ndn == null || ctVar.ndn.ndN == null)) {
                                View childAt2 = linearLayout.getChildAt(i6);
                                textView = (TextView) childAt2.findViewById(R.id.c1b);
                                com.tencent.mm.plugin.game.f.e.bFH().h((ImageView) childAt2.findViewById(R.id.c1a), ctVar.ndn.ndN.IconUrl);
                                textView.setText(ctVar.ndn.ndN.ncH);
                                if (i == 2) {
                                    com.tencent.mm.plugin.game.e.a.a(gameIndexWxagView.getContext(), 10, 1025, i6 + 1, ctVar.ndn.ndN.fKh, i4, null);
                                }
                                childAt2.setTag(new a(i6 + 1, ctVar.ndn.ndN));
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
                    if (amVar.nbd != null) {
                        childAt = linearLayout.getChildAt(i6);
                        textView = (TextView) childAt.findViewById(R.id.c1b);
                        com.tencent.mm.plugin.game.f.e.bFH().h((ImageView) childAt.findViewById(R.id.c1a), amVar.nbd.IconUrl);
                        textView.setText(amVar.nbd.ncH);
                        childAt.setTag(amVar.nbd);
                        childAt.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameIndexWxagView.AnonymousClass1(i4));
                    }
                    View view = new View(gameIndexWxagView.getContext());
                    view.setBackgroundColor(gameIndexWxagView.getContext().getResources().getColor(R.color.pr));
                    gameIndexWxagView.addView(view, new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(gameIndexWxagView.getContext(), 5)));
                }
            }
            if (gameCenterUI5.nfv) {
                gameCenterUI5.nfP.bFu();
            }
            GameBlockView gameBlockView = gameCenterUI5.nfQ;
            ac.a aVar2 = acVar.mXW;
            i4 = gameCenterUI5.mXC;
            if (aVar2 == null) {
                gameBlockView.setVisibility(8);
            } else {
                gameBlockView.neZ.setSourceScene(i4);
                gameBlockView.setVisibility(0);
                gameBlockView.mpt.removeAllViews();
                if (aVar2.mYa == null || bo.isNullOrNil(aVar2.mYa.field_appId) || bo.isNullOrNil(aVar2.mYa.field_appName)) {
                    gameBlockView.setVisibility(8);
                } else {
                    View findViewById;
                    if (i == 2) {
                        com.tencent.mm.plugin.game.e.a.a(gameBlockView.getContext(), 10, 1002, 0, aVar2.mYa.field_appId, i4, null);
                    }
                    com.tencent.mm.plugin.game.model.c cVar = aVar2.mYa;
                    gameBlockView.nfa = new a();
                    childAt = gameBlockView.mInflater.inflate(R.layout.a2i, gameBlockView.mpt, false);
                    gameBlockView.nfa.nfd = (ViewGroup) childAt.findViewById(R.id.c0y);
                    gameBlockView.nfa.neO = (ImageView) childAt.findViewById(R.id.zr);
                    gameBlockView.nfa.neP = (TextView) childAt.findViewById(R.id.zt);
                    gameBlockView.nfa.nfe = (TextView) childAt.findViewById(R.id.c10);
                    gameBlockView.nfa.nff = (GameDownloadView) childAt.findViewById(R.id.c0z);
                    com.tencent.mm.plugin.game.f.e.bFH().a(gameBlockView.nfa.neO, cVar.field_appId, com.tencent.mm.bz.a.getDensity(gameBlockView.getContext()));
                    CharSequence charSequence = cVar.field_appName;
                    if (!bo.isNullOrNil(cVar.field_appName) && cVar.field_appName.length() > 8) {
                        charSequence = cVar.field_appName.substring(0, 7) + "...";
                    }
                    gameBlockView.nfa.neP.setText(charSequence);
                    if (bo.isNullOrNil(cVar.mVk)) {
                        gameBlockView.nfa.nfe.setVisibility(8);
                    } else {
                        gameBlockView.nfa.nfe.setText(cVar.mVk);
                        gameBlockView.nfa.nfe.setVisibility(0);
                    }
                    gameBlockView.nfa.nff.setDownloadInfo(new k(cVar));
                    gameBlockView.nfa.nfd.setOnClickListener(gameBlockView.neZ);
                    gameBlockView.nfa.nfd.setTag(cVar);
                    gameBlockView.mpt.addView(childAt);
                    f fVar = new f(gameBlockView.getContext());
                    fVar.a(aVar2.mYc, aVar2.mYa.field_appId, i, i4);
                    gameBlockView.mpt.addView(fVar, gameBlockView.neY);
                    e eVar = new e(gameBlockView.getContext());
                    eVar.a(aVar2.mYb, aVar2.mYa.field_appId, i, i4);
                    gameBlockView.mpt.addView(eVar, gameBlockView.neY);
                    if (aVar2.mYd != null) {
                        imageView = (ImageView) gameBlockView.mInflater.inflate(R.layout.a3m, gameBlockView, false);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                        marginLayoutParams.leftMargin = com.tencent.mm.bz.a.fromDPToPix(gameBlockView.getContext(), 20);
                        imageView.setLayoutParams(marginLayoutParams);
                        gameBlockView.addView(imageView);
                        gameBlockView.mInflater.inflate(R.layout.a2j, gameBlockView, true);
                        findViewById = gameBlockView.findViewById(R.id.q7);
                        ((TextView) gameBlockView.findViewById(R.id.c11)).setText(aVar2.mYd.Desc);
                        findViewById.setTag(aVar2.mYd.mZj);
                        findViewById.setOnClickListener(new com.tencent.mm.plugin.game.ui.GameBlockView.AnonymousClass1(i4));
                    }
                    LinearLayout linearLayout2 = gameBlockView.mpt;
                    findViewById = new View(gameBlockView.getContext());
                    findViewById.setBackgroundColor(gameBlockView.getContext().getResources().getColor(R.color.pr));
                    linearLayout2.addView(findViewById, new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(gameBlockView.getContext(), 5)));
                }
            }
            GameRecomBlockView gameRecomBlockView = gameCenterUI5.nfR;
            ah ahVar = acVar.mXX;
            int i8 = gameCenterUI5.mXC;
            if (ahVar == null) {
                gameRecomBlockView.setVisibility(8);
            } else {
                gameRecomBlockView.mXC = i8;
                gameRecomBlockView.setVisibility(0);
                gameRecomBlockView.a(ahVar, i, i8);
            }
            gameCenterUI5.nfS.a(acVar.mXY, i, gameCenterUI5.mXC);
            gameCenterUI5.nfT.setVisibility(0);
            AppMethodBeat.o(111798);
        }
    }
}
