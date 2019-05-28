package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.game.model.C12159aq;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C39216x;
import com.tencent.p177mm.plugin.game.model.C46007ae;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.C43205m.C21032a;
import com.tencent.p177mm.plugin.game.p433ui.GameBannerView.C12176a;
import com.tencent.p177mm.plugin.game.p433ui.GameDropdownView.C39226a;
import com.tencent.p177mm.plugin.game.p731d.C20947b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI */
public class GameLibraryUI extends MMActivity implements C1202f {
    private View emz;
    private boolean exX = true;
    private Dialog lud;
    private boolean mGe = false;
    private int mXC = 0;
    private int mXJ = 0;
    private C21031k neZ = new C21031k();
    private ListView nfg;
    private C44745l nfh;
    private boolean nfi = false;
    private boolean nfj = true;
    private C21032a nfm = new C247773();
    private OnScrollListener nfn = new C432038();
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
    private OnClickListener nkc = new C210245();
    private OnClickListener nkd = new C282516();
    private C39226a nke = new C432027();

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$5 */
    class C210245 implements OnClickListener {
        C210245() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112035);
            C46001c.m85453a(view, GameLibraryUI.this);
            C34277b.m56209a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_DARK, 999, 7, GameLibraryUI.this.mXC, null);
            AppMethodBeat.m2505o(112035);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$3 */
    class C247773 implements C21032a {
        C247773() {
        }

        /* renamed from: wF */
        public final void mo36366wF(int i) {
            AppMethodBeat.m2504i(112032);
            int firstVisiblePosition = GameLibraryUI.this.nfg.getFirstVisiblePosition() - GameLibraryUI.this.nkb;
            int lastVisiblePosition = GameLibraryUI.this.nfg.getLastVisiblePosition() - GameLibraryUI.this.nkb;
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                GameLibraryUI.this.nfh.mo62134U(GameLibraryUI.this.nfg.getChildAt(i - firstVisiblePosition), i);
            }
            AppMethodBeat.m2505o(112032);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$6 */
    class C282516 implements OnClickListener {
        C282516() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112036);
            int i = 6;
            if (view.getTag() instanceof String) {
                C46001c.m85453a(view, GameLibraryUI.this);
                i = 7;
            } else {
                Intent intent = new Intent(GameLibraryUI.this, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", GameLibraryUI.this.getString(C25738R.string.c66));
                intent.putExtra("game_report_from_scene", FaceManager.FACE_ACQUIRED_LEFT);
                GameLibraryUI.this.startActivity(intent);
            }
            C34277b.m56209a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_LEFT, 1, i, GameLibraryUI.this.mXC, null);
            AppMethodBeat.m2505o(112036);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$2 */
    class C392292 implements OnMenuItemClickListener {
        C392292() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112031);
            Intent intent = new Intent(GameLibraryUI.this, GameSearchUI.class);
            intent.putExtra("game_report_from_scene", FaceManager.FACE_ACQUIRED_SHIFTING);
            GameLibraryUI.this.startActivity(intent);
            AppMethodBeat.m2505o(112031);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$7 */
    class C432027 implements C39226a {
        C432027() {
        }

        /* renamed from: wI */
        public final void mo62105wI(int i) {
            AppMethodBeat.m2504i(112037);
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(GameLibraryUI.this.njV.keySet());
            if (i > linkedList.size() - 1) {
                AppMethodBeat.m2505o(112037);
                return;
            }
            GameLibraryUI.this.njW = ((Integer) linkedList.get(i)).intValue();
            C4990ab.m7417i("MicroMsg.GameLibraryUI", "Selected SortType: %d", Integer.valueOf(GameLibraryUI.this.njW));
            GameLibraryUI.this.mXJ = 0;
            GameLibraryUI.m85532h(GameLibraryUI.this);
            C34277b.m56209a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_HACKER, GameLibraryUI.this.njW + GameLibraryUI.this.nka, 2, GameLibraryUI.this.mXC, null);
            AppMethodBeat.m2505o(112037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$8 */
    class C432038 implements OnScrollListener {
        C432038() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(112038);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameLibraryUI.this.nfj || GameLibraryUI.this.nfi) {
                    AppMethodBeat.m2505o(112038);
                    return;
                } else {
                    GameLibraryUI.this.emz.setVisibility(0);
                    GameLibraryUI.m85532h(GameLibraryUI.this);
                }
            }
            AppMethodBeat.m2505o(112038);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameLibraryUI$1 */
    class C460141 implements OnMenuItemClickListener {
        C460141() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112030);
            GameLibraryUI.m85523a(GameLibraryUI.this);
            AppMethodBeat.m2505o(112030);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameLibraryUI() {
        AppMethodBeat.m2504i(112041);
        AppMethodBeat.m2505o(112041);
    }

    /* renamed from: a */
    static /* synthetic */ void m85523a(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.m2504i(112053);
        gameLibraryUI.goBack();
        AppMethodBeat.m2505o(112053);
    }

    /* renamed from: h */
    static /* synthetic */ void m85532h(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.m2504i(112055);
        gameLibraryUI.bFq();
        AppMethodBeat.m2505o(112055);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112042);
        super.onCreate(bundle);
        if (C1720g.m3531RK()) {
            int i;
            this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            C1720g.m3540Rg().mo14539a(1218, (C1202f) this);
            initView();
            final byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK("pb_library");
            if (NK == null) {
                C4990ab.m7416i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(112034);
                        final C46007ae c46007ae = new C46007ae(NK);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(112033);
                                GameLibraryUI.m85524a(GameLibraryUI.this, c46007ae, false);
                                AppMethodBeat.m2505o(112033);
                            }
                        });
                        AppMethodBeat.m2505o(112034);
                    }
                });
                i = 1;
            }
            if (i == 0) {
                this.lud = C46001c.m85459ej(this);
                this.lud.show();
            }
            bFq();
            C34277b.m56209a(this, 11, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA, 0, 1, this.mXC, null);
            AppMethodBeat.m2505o(112042);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
        AppMethodBeat.m2505o(112042);
    }

    public void onResume() {
        AppMethodBeat.m2504i(112043);
        super.onResume();
        if (C1720g.m3531RK()) {
            this.nfh.refresh();
            if (!(this.exX || this.njP == null)) {
                GameBannerView gameBannerView = this.njP;
                if (gameBannerView.neF != null && gameBannerView.neF.doT() && gameBannerView.neE.size() > 1) {
                    gameBannerView.neF.mo16770ae(5000, 5000);
                    C4990ab.m7416i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.exX) {
                this.exX = false;
            }
            AppMethodBeat.m2505o(112043);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameLibraryUI", "account not ready");
        AppMethodBeat.m2505o(112043);
    }

    public void onPause() {
        AppMethodBeat.m2504i(112044);
        super.onPause();
        if (this.njP != null) {
            GameBannerView gameBannerView = this.njP;
            if (gameBannerView.neF != null) {
                gameBannerView.neF.stopTimer();
                C4990ab.m7416i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
        AppMethodBeat.m2505o(112044);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112045);
        C4990ab.m7416i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1218, (C1202f) this);
        this.nfh.clear();
        if (this.njP != null) {
            this.njP.neF.stopTimer();
        }
        AppMethodBeat.m2505o(112045);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112046);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(112046);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112046);
        return onKeyDown;
    }

    public final int getLayoutId() {
        return 2130969731;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(112047);
        setMMTitle((int) C25738R.string.c63);
        setBackBtn(new C460141());
        if (!C5046bo.isNullOrNil(C20993e.bEe())) {
            addIconOptionMenu(0, C25738R.string.ewn, C1318a.actionbar_icon_dark_search, new C392292());
        }
        this.nfg = (ListView) findViewById(2131824543);
        this.nfg.setOnItemClickListener(this.neZ);
        this.neZ.setSourceScene(this.mXC);
        this.nfg.setOnScrollListener(this.nfn);
        this.nfh = new C44745l(this);
        this.nfh.setSourceScene(this.mXC);
        this.nfh.mo62137a(this.nfm);
        LayoutInflater layoutInflater = (LayoutInflater) this.mController.ylL.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(2130969739, this.nfg, false);
        this.njP = (GameBannerView) inflate.findViewById(2131824553);
        this.njP.setSourceScene(this.mXC);
        this.nfg.addHeaderView(inflate);
        this.nkb++;
        this.njQ = (GameLibraryCategoriesView) layoutInflater.inflate(2130969733, this.nfg, false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(this.njQ);
        this.nfg.addHeaderView(linearLayout);
        this.nkb++;
        this.njR = layoutInflater.inflate(2130969738, this.nfg, false);
        this.njR.setOnClickListener(this.nkc);
        this.njS = (TextView) this.njR.findViewById(2131824552);
        this.njT = layoutInflater.inflate(2130969732, this.nfg, false);
        this.njT.setOnClickListener(null);
        this.njU = (GameDropdownView) this.njT.findViewById(2131824545);
        this.njU.setAnchorView(this.njT);
        this.njU.setOnSelectionChangedListener(this.nke);
        this.emz = layoutInflater.inflate(2130969741, this.nfg, false);
        this.emz.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.emz);
        this.nfg.addFooterView(linearLayout);
        this.njX = layoutInflater.inflate(2130969737, this.nfg, false);
        this.njX.setVisibility(8);
        this.njY = (Button) this.njX.findViewById(2131824550);
        this.njY.setOnClickListener(this.nkd);
        this.nfg.addFooterView(this.njX);
        this.nfg.setAdapter(this.nfh);
        AppMethodBeat.m2505o(112047);
    }

    private void goBack() {
        AppMethodBeat.m2504i(112048);
        bFl();
        finish();
        AppMethodBeat.m2505o(112048);
    }

    private void bFl() {
        AppMethodBeat.m2504i(112049);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!C5046bo.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        AppMethodBeat.m2505o(112049);
    }

    private void bFq() {
        AppMethodBeat.m2504i(112050);
        C1720g.m3540Rg().mo14541a(new C12159aq(this.mXJ, C20993e.bDR(), this.njW, this.mXJ == 0), 0);
        this.nfi = true;
        AppMethodBeat.m2505o(112050);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112051);
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 1218:
                    final C1331a c1331a = ((C12159aq) c1207m).lty.fsH.fsP;
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(112040);
                            C1331a c1331a = c1331a;
                            boolean z = GameLibraryUI.this.mXJ == 0 && !GameLibraryUI.this.mGe;
                            final C46007ae c46007ae = new C46007ae(c1331a, z, GameLibraryUI.this.mXJ);
                            GameLibraryUI.this.mGe = true;
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(112039);
                                    GameLibraryUI.m85524a(GameLibraryUI.this, c46007ae, GameLibraryUI.this.mXJ != 0);
                                    GameLibraryUI.this.nfi = false;
                                    GameLibraryUI.this.emz.setVisibility(8);
                                    GameLibraryUI.this.mXJ = GameLibraryUI.this.mXJ + 15;
                                    if (GameLibraryUI.this.lud != null) {
                                        GameLibraryUI.this.lud.dismiss();
                                    }
                                    AppMethodBeat.m2505o(112039);
                                }
                            });
                            AppMethodBeat.m2505o(112040);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(112051);
            return;
        }
        if (!C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(C25738R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.m2505o(112051);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(112052);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 1) {
            C4990ab.m7412e("MicroMsg.GameLibraryUI", "error request code");
            AppMethodBeat.m2505o(112052);
            return;
        }
        AppMethodBeat.m2505o(112052);
    }

    /* renamed from: a */
    static /* synthetic */ void m85524a(GameLibraryUI gameLibraryUI, C46007ae c46007ae, boolean z) {
        Pair pair = null;
        AppMethodBeat.m2504i(112054);
        gameLibraryUI.nfj = c46007ae.mYe.nct;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.nfh.mo24020Y(c46007ae.mYg);
            C4990ab.m7417i("MicroMsg.GameLibraryUI", "Appending list size: %d", Integer.valueOf(linkedList.size()));
        } else {
            LinkedList linkedList2;
            Pair pair2;
            GameBannerView gameBannerView = gameLibraryUI.njP;
            if (c46007ae.mYe.ncr == null || c46007ae.mYe.ncr.ncU == null) {
                C4990ab.m7412e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < c46007ae.mYe.ncr.ncU.size(); i++) {
                    C12176a c12176a = new C12176a();
                    C20947b c20947b = (C20947b) c46007ae.mYe.ncr.ncU.get(i);
                    C20992c a = C39216x.m66823a(c20947b.mZk);
                    if (a != null) {
                        C20964d.m32218a(a);
                        c12176a.index = i;
                        c12176a.neJ = a;
                        c12176a.fqw = c20947b.mZl;
                        c12176a.mVm = c20947b.mZm;
                        linkedList2.add(c12176a);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.setBannerList(linkedList);
            gameLibraryUI.njQ.setData(c46007ae.bEP());
            gameLibraryUI.njQ.setSourceScene(gameLibraryUI.mXC);
            linkedList = new LinkedList();
            linkedList2 = c46007ae.mYf;
            LinkedList linkedList3 = c46007ae.mYg;
            linkedList.addAll(linkedList2);
            linkedList.addAll(linkedList3);
            gameLibraryUI.nfh.mo24021Z(linkedList);
            C4990ab.m7417i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()));
            gameLibraryUI.njV = c46007ae.bEO();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.njV.values());
            GameDropdownView gameDropdownView = gameLibraryUI.njU;
            LinkedList linkedList4 = new LinkedList();
            linkedList4.addAll(gameLibraryUI.njV.keySet());
            gameDropdownView.mo62099e(linkedList, linkedList4.indexOf(Integer.valueOf(gameLibraryUI.njW)));
            if (c46007ae.mYe.ncr == null || c46007ae.mYe.ncr.ncV == null) {
                pair2 = null;
            } else {
                pair2 = new Pair(c46007ae.mYe.ncr.ncV.ndl, c46007ae.mYe.ncr.ncV.ncB);
            }
            if (pair2 == null || C5046bo.isNullOrNil((String) pair2.first) || C5046bo.isNullOrNil((String) pair2.second)) {
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
            gameLibraryUI.nfh.mo62138e(sparseArray);
            if (!(c46007ae.mYe.ncr == null || c46007ae.mYe.ncr.ncX == null)) {
                pair = new Pair(c46007ae.mYe.ncr.ncX.nde, c46007ae.mYe.ncr.ncX.mZm);
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
        AppMethodBeat.m2505o(112054);
    }
}
