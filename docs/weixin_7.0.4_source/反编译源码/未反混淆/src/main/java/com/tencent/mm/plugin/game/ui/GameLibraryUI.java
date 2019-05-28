package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.plugin.game.ui.m.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements f {
    private View emz;
    private boolean exX = true;
    private Dialog lud;
    private boolean mGe = false;
    private int mXC = 0;
    private int mXJ = 0;
    private k neZ = new k();
    private ListView nfg;
    private l nfh;
    private boolean nfi = false;
    private boolean nfj = true;
    private a nfm = new a() {
        public final void wF(int i) {
            AppMethodBeat.i(112032);
            int firstVisiblePosition = GameLibraryUI.this.nfg.getFirstVisiblePosition() - GameLibraryUI.this.nkb;
            int lastVisiblePosition = GameLibraryUI.this.nfg.getLastVisiblePosition() - GameLibraryUI.this.nkb;
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                GameLibraryUI.this.nfh.U(GameLibraryUI.this.nfg.getChildAt(i - firstVisiblePosition), i);
            }
            AppMethodBeat.o(112032);
        }
    };
    private OnScrollListener nfn = new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.i(112038);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameLibraryUI.this.nfj || GameLibraryUI.this.nfi) {
                    AppMethodBeat.o(112038);
                    return;
                } else {
                    GameLibraryUI.this.emz.setVisibility(0);
                    GameLibraryUI.h(GameLibraryUI.this);
                }
            }
            AppMethodBeat.o(112038);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private GameBannerView njP;
    private GameLibraryCategoriesView njQ;
    private View njR;
    private TextView njS;
    private View njT;
    private GameDropdownView njU;
    private HashMap<Integer, String> njV;
    private int njW = 0;
    private View njX;
    private Button njY;
    private boolean njZ = false;
    private int nka = 990;
    private int nkb = 0;
    private OnClickListener nkc = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(112035);
            c.a(view, GameLibraryUI.this);
            b.a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_DARK, 999, 7, GameLibraryUI.this.mXC, null);
            AppMethodBeat.o(112035);
        }
    };
    private OnClickListener nkd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(112036);
            int i = 6;
            if (view.getTag() instanceof String) {
                c.a(view, GameLibraryUI.this);
                i = 7;
            } else {
                Intent intent = new Intent(GameLibraryUI.this, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", GameLibraryUI.this.getString(R.string.c66));
                intent.putExtra("game_report_from_scene", FaceManager.FACE_ACQUIRED_LEFT);
                GameLibraryUI.this.startActivity(intent);
            }
            b.a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_LEFT, 1, i, GameLibraryUI.this.mXC, null);
            AppMethodBeat.o(112036);
        }
    };
    private GameDropdownView.a nke = new GameDropdownView.a() {
        public final void wI(int i) {
            AppMethodBeat.i(112037);
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(GameLibraryUI.this.njV.keySet());
            if (i > linkedList.size() - 1) {
                AppMethodBeat.o(112037);
                return;
            }
            GameLibraryUI.this.njW = ((Integer) linkedList.get(i)).intValue();
            ab.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", Integer.valueOf(GameLibraryUI.this.njW));
            GameLibraryUI.this.mXJ = 0;
            GameLibraryUI.h(GameLibraryUI.this);
            b.a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_HACKER, GameLibraryUI.this.njW + GameLibraryUI.this.nka, 2, GameLibraryUI.this.mXC, null);
            AppMethodBeat.o(112037);
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameLibraryUI() {
        AppMethodBeat.i(112041);
        AppMethodBeat.o(112041);
    }

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.i(112053);
        gameLibraryUI.goBack();
        AppMethodBeat.o(112053);
    }

    static /* synthetic */ void h(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.i(112055);
        gameLibraryUI.bFq();
        AppMethodBeat.o(112055);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112042);
        super.onCreate(bundle);
        if (g.RK()) {
            int i;
            this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            g.Rg().a(1218, (f) this);
            initView();
            final byte[] NK = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().NK("pb_library");
            if (NK == null) {
                ab.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(112034);
                        final ae aeVar = new ae(NK);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(112033);
                                GameLibraryUI.a(GameLibraryUI.this, aeVar, false);
                                AppMethodBeat.o(112033);
                            }
                        });
                        AppMethodBeat.o(112034);
                    }
                });
                i = 1;
            }
            if (i == 0) {
                this.lud = c.ej(this);
                this.lud.show();
            }
            bFq();
            b.a(this, 11, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA, 0, 1, this.mXC, null);
            AppMethodBeat.o(112042);
            return;
        }
        ab.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
        AppMethodBeat.o(112042);
    }

    public void onResume() {
        AppMethodBeat.i(112043);
        super.onResume();
        if (g.RK()) {
            this.nfh.refresh();
            if (!(this.exX || this.njP == null)) {
                GameBannerView gameBannerView = this.njP;
                if (gameBannerView.neF != null && gameBannerView.neF.doT() && gameBannerView.neE.size() > 1) {
                    gameBannerView.neF.ae(5000, 5000);
                    ab.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.exX) {
                this.exX = false;
            }
            AppMethodBeat.o(112043);
            return;
        }
        ab.e("MicroMsg.GameLibraryUI", "account not ready");
        AppMethodBeat.o(112043);
    }

    public void onPause() {
        AppMethodBeat.i(112044);
        super.onPause();
        if (this.njP != null) {
            GameBannerView gameBannerView = this.njP;
            if (gameBannerView.neF != null) {
                gameBannerView.neF.stopTimer();
                ab.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
        AppMethodBeat.o(112044);
    }

    public void onDestroy() {
        AppMethodBeat.i(112045);
        ab.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        g.Rg().b(1218, (f) this);
        this.nfh.clear();
        if (this.njP != null) {
            this.njP.neF.stopTimer();
        }
        AppMethodBeat.o(112045);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112046);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(112046);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112046);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return R.layout.a4e;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.i(112047);
        setMMTitle((int) R.string.c63);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112030);
                GameLibraryUI.a(GameLibraryUI.this);
                AppMethodBeat.o(112030);
                return true;
            }
        });
        if (!bo.isNullOrNil(e.bEe())) {
            addIconOptionMenu(0, R.string.ewn, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(112031);
                    Intent intent = new Intent(GameLibraryUI.this, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", FaceManager.FACE_ACQUIRED_SHIFTING);
                    GameLibraryUI.this.startActivity(intent);
                    AppMethodBeat.o(112031);
                    return true;
                }
            });
        }
        this.nfg = (ListView) findViewById(R.id.c73);
        this.nfg.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nfg.setOnScrollListener(this.nfn);
        this.nfh = new l(this);
        this.nfh.setSourceScene(this.mXC);
        this.nfh.a(this.nfm);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.a4m, this.nfg, false);
        this.njP = (GameBannerView) inflate.findViewById(R.id.c7c);
        this.njP.setSourceScene(this.mXC);
        this.nfg.addHeaderView(inflate);
        this.nkb++;
        this.njQ = (GameLibraryCategoriesView) layoutInflater.inflate(R.layout.a4g, this.nfg, false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(this.njQ);
        this.nfg.addHeaderView(linearLayout);
        this.nkb++;
        this.njR = layoutInflater.inflate(R.layout.a4l, this.nfg, false);
        this.njR.setOnClickListener(this.nkc);
        this.njS = (TextView) this.njR.findViewById(R.id.c7b);
        this.njT = layoutInflater.inflate(R.layout.a4f, this.nfg, false);
        this.njT.setOnClickListener(null);
        this.njU = (GameDropdownView) this.njT.findViewById(R.id.c75);
        this.njU.setAnchorView(this.njT);
        this.njU.setOnSelectionChangedListener(this.nke);
        this.emz = layoutInflater.inflate(R.layout.a4o, this.nfg, false);
        this.emz.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.emz);
        this.nfg.addFooterView(linearLayout);
        this.njX = layoutInflater.inflate(R.layout.a4k, this.nfg, false);
        this.njX.setVisibility(8);
        this.njY = (Button) this.njX.findViewById(R.id.c7_);
        this.njY.setOnClickListener(this.nkd);
        this.nfg.addFooterView(this.njX);
        this.nfg.setAdapter(this.nfh);
        AppMethodBeat.o(112047);
    }

    private void goBack() {
        AppMethodBeat.i(112048);
        bFl();
        finish();
        AppMethodBeat.o(112048);
    }

    private void bFl() {
        AppMethodBeat.i(112049);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bo.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        AppMethodBeat.o(112049);
    }

    private void bFq() {
        AppMethodBeat.i(112050);
        g.Rg().a(new aq(this.mXJ, e.bDR(), this.njW, this.mXJ == 0), 0);
        this.nfi = true;
        AppMethodBeat.o(112050);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112051);
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 1218:
                    final com.tencent.mm.bt.a aVar = ((aq) mVar).lty.fsH.fsP;
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112040);
                            com.tencent.mm.bt.a aVar = aVar;
                            boolean z = GameLibraryUI.this.mXJ == 0 && !GameLibraryUI.this.mGe;
                            final ae aeVar = new ae(aVar, z, GameLibraryUI.this.mXJ);
                            GameLibraryUI.this.mGe = true;
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(112039);
                                    GameLibraryUI.a(GameLibraryUI.this, aeVar, GameLibraryUI.this.mXJ != 0);
                                    GameLibraryUI.this.nfi = false;
                                    GameLibraryUI.this.emz.setVisibility(8);
                                    GameLibraryUI.this.mXJ = GameLibraryUI.this.mXJ + 15;
                                    if (GameLibraryUI.this.lud != null) {
                                        GameLibraryUI.this.lud.dismiss();
                                    }
                                    AppMethodBeat.o(112039);
                                }
                            });
                            AppMethodBeat.o(112040);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(112051);
            return;
        }
        if (!com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.o(112051);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(112052);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            ab.e("MicroMsg.GameLibraryUI", "error request code");
            AppMethodBeat.o(112052);
            return;
        }
        AppMethodBeat.o(112052);
    }

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, ae aeVar, boolean z) {
        Pair pair = null;
        AppMethodBeat.i(112054);
        gameLibraryUI.nfj = aeVar.mYe.nct;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.nfh.Y(aeVar.mYg);
            ab.i("MicroMsg.GameLibraryUI", "Appending list size: %d", Integer.valueOf(linkedList.size()));
        } else {
            LinkedList linkedList2;
            Pair pair2;
            GameBannerView gameBannerView = gameLibraryUI.njP;
            if (aeVar.mYe.ncr == null || aeVar.mYe.ncr.ncU == null) {
                ab.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < aeVar.mYe.ncr.ncU.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    com.tencent.mm.plugin.game.d.b bVar = (com.tencent.mm.plugin.game.d.b) aeVar.mYe.ncr.ncU.get(i);
                    com.tencent.mm.plugin.game.model.c a = x.a(bVar.mZk);
                    if (a != null) {
                        d.a(a);
                        aVar.index = i;
                        aVar.neJ = a;
                        aVar.fqw = bVar.mZl;
                        aVar.mVm = bVar.mZm;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.setBannerList(linkedList);
            gameLibraryUI.njQ.setData(aeVar.bEP());
            gameLibraryUI.njQ.setSourceScene(gameLibraryUI.mXC);
            linkedList = new LinkedList();
            linkedList2 = aeVar.mYf;
            LinkedList linkedList3 = aeVar.mYg;
            linkedList.addAll(linkedList2);
            linkedList.addAll(linkedList3);
            gameLibraryUI.nfh.Z(linkedList);
            ab.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()));
            gameLibraryUI.njV = aeVar.bEO();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.njV.values());
            GameDropdownView gameDropdownView = gameLibraryUI.njU;
            LinkedList linkedList4 = new LinkedList();
            linkedList4.addAll(gameLibraryUI.njV.keySet());
            gameDropdownView.e(linkedList, linkedList4.indexOf(Integer.valueOf(gameLibraryUI.njW)));
            if (aeVar.mYe.ncr == null || aeVar.mYe.ncr.ncV == null) {
                pair2 = null;
            } else {
                pair2 = new Pair(aeVar.mYe.ncr.ncV.ndl, aeVar.mYe.ncr.ncV.ncB);
            }
            if (pair2 == null || bo.isNullOrNil((String) pair2.first) || bo.isNullOrNil((String) pair2.second)) {
                gameLibraryUI.njR.setTag(null);
                gameLibraryUI.njS.setVisibility(8);
            } else {
                gameLibraryUI.njR.setTag(pair2.second);
                gameLibraryUI.njS.setVisibility(0);
                gameLibraryUI.njS.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.njR);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.njT);
            gameLibraryUI.nfh.e(sparseArray);
            if (!(aeVar.mYe.ncr == null || aeVar.mYe.ncr.ncX == null)) {
                pair = new Pair(aeVar.mYe.ncr.ncX.nde, aeVar.mYe.ncr.ncX.mZm);
            }
            if (pair != null) {
                gameLibraryUI.njY.setText((CharSequence) pair.first);
                gameLibraryUI.njY.setTag(pair.second);
                gameLibraryUI.njZ = true;
            }
        }
        if (!gameLibraryUI.nfj && gameLibraryUI.njZ) {
            gameLibraryUI.njX.setVisibility(0);
        }
        AppMethodBeat.o(112054);
    }
}
