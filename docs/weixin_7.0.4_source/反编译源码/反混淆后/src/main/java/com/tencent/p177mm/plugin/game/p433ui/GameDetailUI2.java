package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p181af.C32225q.C25748a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C20998j.C20997a;
import com.tencent.p177mm.plugin.game.model.C21003k;
import com.tencent.p177mm.plugin.game.model.C28219aa;
import com.tencent.p177mm.plugin.game.model.C41287z;
import com.tencent.p177mm.plugin.game.model.C41287z.C39217a;
import com.tencent.p177mm.plugin.game.model.C41287z.C41288b;
import com.tencent.p177mm.plugin.game.model.C43187am;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p1649b.C45984a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.GameDetailRankUI.C34304a;
import com.tencent.p177mm.plugin.game.p731d.C34270bw;
import com.tencent.p177mm.plugin.game.p731d.C34275da;
import com.tencent.p177mm.plugin.game.p731d.C43174v;
import com.tencent.p177mm.plugin.game.widget.TextProgressBar;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2 */
public class GameDetailUI2 extends MMActivity implements C1202f {
    private String appId = null;
    private Dialog lud;
    private C20992c mVZ = null;
    private int mXC = 0;
    private String ngJ = null;
    private String ngK = null;
    private int ngM = 18;
    private boolean ngN;
    private boolean ngO;
    private String ngP = null;
    private C20997a ngQ = null;
    private C46016d ngR = null;
    private C21003k ngS = null;
    private ViewGroup ngT;
    private ImageView ngU;
    private ImageView ngV;
    private TextView ngW;
    private Button ngX;
    private TextProgressBar ngY;
    private TextView ngZ;
    private C34275da nhA;
    private OnClickListener nhB = new C3922115();
    private View.OnClickListener nhC = new C3430516();
    private View.OnClickListener nhD = new C3430617();
    private View.OnClickListener nhE = new C282442();
    private View.OnClickListener nhF = new C121793();
    private View.OnClickListener nhG = new C431984();
    private View.OnClickListener nhH = new C431965();
    private LinearLayout nha;
    private GameDetailAutoScrollView nhb;
    private LinearLayout nhc;
    private TextView nhd;
    private LinearLayout nhe;
    private TextView nhf;
    private LinearLayout nhg;
    private ImageView nhh;
    private View nhi;
    private TextView nhj;
    private TextView nhk;
    private View nhl;
    private TextView nhm;
    private ImageView nhn;
    private TextView nho;
    private TextView nhp;
    private LinearLayout nhq;
    private GameMediaList nhr;
    private TextView nhs;
    private TextView nht;
    private TextView nhu;
    private boolean nhv = false;
    private LinearLayout nhw;
    private TextView nhx;
    private LinearLayout nhy;
    private TextView nhz;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$13 */
    class C324813 implements OnMenuItemClickListener {
        C324813() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111853);
            GameDetailUI2.m76783a(GameDetailUI2.this, GameDetailUI2.this.nhA);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1207, 1, 2, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111853);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$11 */
    class C1217811 implements View.OnClickListener {
        C1217811() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111850);
            if (GameDetailUI2.this.nhv) {
                GameDetailUI2.this.nht.setMaxLines(3);
                GameDetailUI2.this.nhu.setText(GameDetailUI2.this.getResources().getText(C25738R.string.c4u));
                GameDetailUI2.this.nhv = false;
                AppMethodBeat.m2505o(111850);
                return;
            }
            GameDetailUI2.this.nht.setMaxLines(100);
            GameDetailUI2.this.nhu.setText(GameDetailUI2.this.getResources().getText(C25738R.string.c4v));
            GameDetailUI2.this.nhv = true;
            AppMethodBeat.m2505o(111850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$3 */
    class C121793 implements View.OnClickListener {
        C121793() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111842);
            C46001c.m85453a(view, GameDetailUI2.this);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1205, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111842);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$1 */
    class C210181 implements OnMenuItemClickListener {
        C210181() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(111840);
            GameDetailUI2.m76782a(GameDetailUI2.this);
            AppMethodBeat.m2505o(111840);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$2 */
    class C282442 implements View.OnClickListener {
        C282442() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111841);
            C46001c.m85453a(view, GameDetailUI2.this);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1204, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$16 */
    class C3430516 implements View.OnClickListener {
        C3430516() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111857);
            if (GameDetailUI2.this.mVZ == null) {
                C4990ab.m7412e("MicroMsg.GameDetailUI2", "Null appInfo");
                AppMethodBeat.m2505o(111857);
            } else if (GameDetailUI2.this.ngS == null) {
                C4990ab.m7412e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
                AppMethodBeat.m2505o(111857);
            } else {
                GameDetailUI2.this.ngS.mo36321ei(GameDetailUI2.this.mController.ylL);
                GameDetailUI2.this.ngR.mo73916a(GameDetailUI2.this.mVZ, GameDetailUI2.this.ngS);
                AppMethodBeat.m2505o(111857);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$17 */
    class C3430617 implements View.OnClickListener {
        C3430617() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111858);
            if (view.getTag() instanceof String) {
                C46001c.m85453a(view, GameDetailUI2.this);
                C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1203, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
                AppMethodBeat.m2505o(111858);
                return;
            }
            C34304a c34304a = new C34304a();
            c34304a.ngJ = GameDetailUI2.this.ngJ;
            c34304a.ngK = GameDetailUI2.this.ngK;
            c34304a.ngL = GameDetailUI2.this.mVZ;
            String nW = C37922v.m64078nW("rankData");
            C37922v.m64076Zp().mo60676y(nW, true).mo53356j(GameDetailRankUI.ngH, c34304a);
            Intent intent = new Intent(GameDetailUI2.this.mController.ylL, GameDetailRankUI.class);
            intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, nW);
            GameDetailUI2.this.startActivity(intent);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1203, 999, 6, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111858);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$15 */
    class C3922115 implements OnClickListener {
        C3922115() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111856);
            GameDetailUI2.this.ngS.biT();
            GameDetailUI2.this.ngR.mo73915a(GameDetailUI2.this.ngY, GameDetailUI2.this.ngX, GameDetailUI2.this.mVZ, GameDetailUI2.this.ngS);
            AppMethodBeat.m2505o(111856);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$6 */
    class C392226 implements C20997a {
        C392226() {
        }

        /* renamed from: f */
        public final void mo36316f(int i, String str, boolean z) {
            AppMethodBeat.m2504i(111845);
            if (GameDetailUI2.this.mVZ != null) {
                GameDetailUI2.this.ngS.mo36321ei(GameDetailUI2.this);
                GameDetailUI2.this.ngS.biT();
                if (z) {
                    GameDetailUI2.this.ngR.mo73915a(GameDetailUI2.this.ngY, GameDetailUI2.this.ngX, GameDetailUI2.this.mVZ, GameDetailUI2.this.ngS);
                }
            }
            AppMethodBeat.m2505o(111845);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$8 */
    class C392238 implements C5279d {
        C392238() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(111847);
            switch (menuItem.getItemId()) {
                case 0:
                    GameDetailUI2.m76804p(GameDetailUI2.this);
                    AppMethodBeat.m2505o(111847);
                    return;
                case 1:
                    GameDetailUI2.m76805q(GameDetailUI2.this);
                    break;
            }
            AppMethodBeat.m2505o(111847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$5 */
    class C431965 implements View.OnClickListener {
        C431965() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111844);
            C46001c.m85453a(view, GameDetailUI2.this);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1206, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111844);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$10 */
    class C4319710 implements OnGlobalLayoutListener {
        C4319710() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(111849);
            if (GameDetailUI2.this.nht.getLineCount() > 3) {
                GameDetailUI2.this.nhu.setVisibility(0);
                AppMethodBeat.m2505o(111849);
                return;
            }
            GameDetailUI2.this.nhu.setVisibility(8);
            AppMethodBeat.m2505o(111849);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailUI2$4 */
    class C431984 implements View.OnClickListener {
        C431984() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111843);
            C46001c.m85453a(view, GameDetailUI2.this);
            C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1205, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.m2505o(111843);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameDetailUI2() {
        AppMethodBeat.m2504i(111859);
        AppMethodBeat.m2505o(111859);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(111860);
        super.onCreate(bundle);
        if (C1720g.m3531RK()) {
            boolean z;
            this.ngN = true;
            this.ngO = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (C5046bo.isNullOrNil(this.appId)) {
                C4990ab.m7412e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            initView();
            C1720g.m3540Rg().mo14539a(1217, (C1202f) this);
            final byte[] NK = ((C45983c) C1720g.m3528K(C45983c.class)).bCZ().mo54825NK(this.appId);
            if (NK == null || NK.length == 0) {
                C4990ab.m7416i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(111852);
                        final C41287z c41287z = new C41287z(NK);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(111851);
                                GameDetailUI2.m76784a(GameDetailUI2.this, c41287z);
                                AppMethodBeat.m2505o(111851);
                            }
                        });
                        AppMethodBeat.m2505o(111852);
                    }
                });
                z = true;
            }
            if (!z) {
                this.lud = C46001c.m85459ej(this);
                this.lud.show();
            }
            C1720g.m3540Rg().mo14541a(new C43187am(C4988aa.dor(), this.appId, C46494g.m87757u(this, this.appId)), 0);
            AppMethodBeat.m2505o(111860);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
        AppMethodBeat.m2505o(111860);
    }

    public final int getLayoutId() {
        return 2130969688;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(111861);
        super.onResume();
        if (!(this.mVZ == null || this.ngS == null)) {
            this.ngS.biT();
            this.ngR.mo73915a(this.ngY, this.ngX, this.mVZ, this.ngS);
        }
        if (this.ngN) {
            this.ngN = false;
            AppMethodBeat.m2505o(111861);
            return;
        }
        m76788b(new C28219aa(this.appId));
        AppMethodBeat.m2505o(111861);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(111862);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1217, (C1202f) this);
        if (this.ngQ != null) {
            C20998j.m32288b(this.ngQ);
        }
        AppMethodBeat.m2505o(111862);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(111863);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.m2505o(111863);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(111863);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(111864);
        bFl();
        finish();
        AppMethodBeat.m2505o(111864);
    }

    private void bFl() {
        AppMethodBeat.m2504i(111865);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!C5046bo.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        AppMethodBeat.m2505o(111865);
    }

    public final void initView() {
        AppMethodBeat.m2504i(111866);
        setMMTitle((int) C25738R.string.c59);
        setBackBtn(new C210181());
        this.ngT = (ViewGroup) findViewById(2131824419);
        this.ngU = (ImageView) findViewById(2131824420);
        this.ngV = (ImageView) findViewById(2131821535);
        this.ngW = (TextView) findViewById(2131821537);
        this.ngZ = (TextView) findViewById(2131824409);
        this.ngX = (Button) findViewById(2131824441);
        this.ngY = (TextProgressBar) findViewById(2131824442);
        this.ngY.setTextSize(this.ngM);
        this.nha = (LinearLayout) findViewById(2131824413);
        this.nhb = (GameDetailAutoScrollView) findViewById(2131824421);
        this.nhc = (LinearLayout) findViewById(2131824422);
        this.nhd = (TextView) findViewById(2131824414);
        this.nhe = (LinearLayout) findViewById(2131824423);
        this.nhf = (TextView) findViewById(2131824424);
        this.nhg = (LinearLayout) findViewById(2131824425);
        this.nhh = (ImageView) findViewById(2131824426);
        this.nhi = findViewById(2131824427);
        this.nhj = (TextView) findViewById(2131824428);
        this.nhk = (TextView) findViewById(2131824429);
        this.nhl = findViewById(2131824432);
        this.nhm = (TextView) findViewById(2131824433);
        this.nhn = (ImageView) findViewById(2131824434);
        this.nho = (TextView) findViewById(2131824435);
        this.nhp = (TextView) findViewById(2131824436);
        this.nhq = (LinearLayout) findViewById(2131824430);
        this.nhr = (GameMediaList) findViewById(2131824416);
        this.nhr.mo46131l(this, this.appId, this.mXC);
        this.nhr.setItemLayout(2130969747);
        this.nhs = (TextView) findViewById(2131824415);
        this.nht = (TextView) findViewById(2131824418);
        this.nht.getViewTreeObserver().addOnGlobalLayoutListener(new C4319710());
        this.nhu = (TextView) findViewById(2131824431);
        this.nhu.setOnClickListener(new C1217811());
        this.nhw = (LinearLayout) findViewById(2131824437);
        this.nhx = (TextView) findViewById(2131824438);
        this.nhy = (LinearLayout) findViewById(2131824439);
        this.nhz = (TextView) findViewById(2131824440);
        AppMethodBeat.m2505o(111866);
    }

    /* renamed from: a */
    private void m76781a(C41287z c41287z) {
        AppMethodBeat.m2504i(111868);
        LinkedList linkedList = null;
        if (c41287z.mXN.mXO == null || c41287z.mXN.mXO.size() == 0) {
            linkedList = c41287z.mXK.nbK;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.nha.setVisibility(8);
            AppMethodBeat.m2505o(111868);
            return;
        }
        this.nha.setVisibility(0);
        this.nha.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C43174v c43174v = (C43174v) it.next();
            View inflate = LayoutInflater.from(this.mController.ylL).inflate(2130969699, this.nha, false);
            ImageView imageView = (ImageView) inflate.findViewById(2131824465);
            TextView textView = (TextView) inflate.findViewById(2131824466);
            TextView textView2 = (TextView) inflate.findViewById(2131824467);
            if (C5046bo.isNullOrNil(c43174v.jBB)) {
                C17927a c17927a = new C17927a();
                c17927a.eQf = true;
                C32291o.ahp().mo43766a(c43174v.mZs, imageView, c17927a.ahG());
            } else {
                C40460b.m69433a(imageView, c43174v.jBB, 0.5f, false);
            }
            textView.setText(c43174v.Title);
            textView2.setText(c43174v.naq);
            this.nha.addView(inflate);
        }
        AppMethodBeat.m2505o(111868);
    }

    /* renamed from: b */
    private void m76789b(C41287z c41287z) {
        AppMethodBeat.m2504i(111869);
        if (c41287z.bEA() == null || c41287z.bEA().isEmpty()) {
            this.nhe.setVisibility(8);
            AppMethodBeat.m2505o(111869);
            return;
        }
        int i;
        C39217a c39217a;
        this.nhe.setVisibility(0);
        if (C5046bo.isNullOrNil(c41287z.bEz())) {
            this.nhf.setVisibility(8);
        } else {
            this.nhf.setVisibility(0);
            this.nhf.setText(c41287z.bEz());
        }
        this.nhg.removeAllViews();
        if (c41287z.bEB() == 1) {
            this.nhg.setOrientation(1);
            this.nhh.setVisibility(8);
            i = 2130969691;
        } else {
            this.nhg.setOrientation(0);
            this.nhh.setVisibility(0);
            i = 2130969690;
        }
        LinkedList bEA = c41287z.bEA();
        if (bEA != null) {
            Iterator it = bEA.iterator();
            while (it.hasNext()) {
                C41288b c41288b = (C41288b) it.next();
                View inflate = LayoutInflater.from(this.mController.ylL).inflate(i, this.nhg, false);
                C32291o.ahp().mo43765a(c41288b.cIY, (ImageView) inflate.findViewById(2131824445));
                if (c41287z.bEB() == 1) {
                    ((TextView) inflate.findViewById(2131824447)).setText(c41288b.title);
                }
                ((TextView) inflate.findViewById(2131824446)).setText(c41288b.desc);
                if (c41287z.bEB() == 1) {
                    inflate.setTag(c41288b.url);
                    inflate.setOnClickListener(this.nhE);
                }
                this.nhg.addView(inflate);
            }
        }
        if (c41287z.mXK.nbS != null) {
            c39217a = new C39217a();
            c39217a.title = c41287z.mXK.nbS.summary;
            c39217a.desc = c41287z.mXK.nbS.desc;
            c39217a.url = c41287z.mXK.nbS.url;
        } else if (c41287z.mXK.nbN == null || C5046bo.isNullOrNil(c41287z.mXK.nbN.ncA) || C5046bo.isNullOrNil(c41287z.mXK.nbN.ncB)) {
            c39217a = null;
        } else {
            c39217a = new C39217a();
            c39217a.title = c41287z.mXK.nbN.ncA;
            c39217a.url = c41287z.mXK.nbN.ncB;
        }
        if (c39217a != null) {
            this.nhi.setVisibility(0);
            this.nhj.setText(c39217a.title);
            if (C5046bo.isNullOrNil(c39217a.desc)) {
                this.nhk.setVisibility(8);
            } else {
                this.nhk.setVisibility(0);
                this.nhk.setText(c39217a.desc);
            }
            this.nhi.setTag(c39217a.url);
            this.nhi.setOnClickListener(this.nhE);
            AppMethodBeat.m2505o(111869);
            return;
        }
        this.nhi.setVisibility(8);
        AppMethodBeat.m2505o(111869);
    }

    /* renamed from: c */
    private void m76791c(C41287z c41287z) {
        AppMethodBeat.m2504i(111870);
        if (c41287z.bEG() == null || c41287z.bEG().isEmpty()) {
            this.nhw.setVisibility(8);
            AppMethodBeat.m2505o(111870);
            return;
        }
        Pair pair;
        this.nhw.setVisibility(0);
        if (C5046bo.isNullOrNil(c41287z.bEF())) {
            this.nhx.setVisibility(8);
        } else {
            this.nhx.setVisibility(0);
            this.nhx.setText(c41287z.bEF());
        }
        this.nhy.removeAllViews();
        this.nhy.setOnClickListener(null);
        Iterator it = c41287z.bEG().iterator();
        while (it.hasNext()) {
            C34270bw c34270bw = (C34270bw) it.next();
            View inflate = LayoutInflater.from(this.mController.ylL).inflate(2130969692, this.nhy, false);
            TextView textView = (TextView) inflate.findViewById(2131824449);
            TextView textView2 = (TextView) inflate.findViewById(2131824450);
            ImageView imageView = (ImageView) inflate.findViewById(2131824451);
            ((TextView) inflate.findViewById(2131824448)).setText(c34270bw.ncF);
            textView.setText(c34270bw.Title);
            textView2.setText(c34270bw.naq);
            C32291o.ahp().mo43765a(c34270bw.ncC, imageView);
            inflate.setTag(c34270bw.mZm);
            inflate.setOnClickListener(this.nhF);
            this.nhy.addView(inflate);
        }
        if (c41287z.mXK.nbN == null) {
            pair = null;
        } else if (C5046bo.isNullOrNil(c41287z.mXK.nbM.Title) || C5046bo.isNullOrNil(c41287z.mXK.nbM.ncB)) {
            pair = null;
        } else {
            pair = new Pair(c41287z.mXK.nbM.ncA, c41287z.mXK.nbM.ncB);
        }
        if (pair != null) {
            this.nhz.setVisibility(0);
            this.nhz.setText((CharSequence) pair.first);
            this.nhz.setTag(pair.second);
            this.nhz.setOnClickListener(this.nhG);
            AppMethodBeat.m2505o(111870);
            return;
        }
        this.nhz.setVisibility(8);
        AppMethodBeat.m2505o(111870);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(111871);
        if (i == 0 && i2 == 0) {
            switch (c1207m.getType()) {
                case 1217:
                    final C1331a c1331a = ((C43187am) c1207m).lty.fsH.fsP;
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(111855);
                            final C41287z c41287z = new C41287z(c1331a);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(111854);
                                    GameDetailUI2.m76784a(GameDetailUI2.this, c41287z);
                                    if (GameDetailUI2.this.lud != null) {
                                        GameDetailUI2.this.lud.dismiss();
                                    }
                                    AppMethodBeat.m2505o(111854);
                                }
                            });
                            AppMethodBeat.m2505o(111855);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(111871);
            return;
        }
        if (!C45984a.gkF.mo38859a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(C25738R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.m2505o(111871);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(111872);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                switch (i2) {
                    case 0:
                        AppMethodBeat.m2505o(111872);
                        return;
                    case 2:
                        if (!(this.mVZ == null || this.ngS == null)) {
                            this.ngS.bEj();
                            this.ngR.mo73916a(this.mVZ, this.ngS);
                            AppMethodBeat.m2505o(111872);
                            return;
                        }
                    case 3:
                        if (this.ngS != null) {
                            this.ngS.biT();
                            AppMethodBeat.m2505o(111872);
                            return;
                        }
                        break;
                    default:
                        AppMethodBeat.m2505o(111872);
                        return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        String str = this.nhA.mZs;
                        if (C5046bo.isNullOrNil(str)) {
                            str = this.mVZ.field_appIconUrl;
                        }
                        C23281a.vlq.mo30687a(this.mController, this.nhA.ndx, str, this.nhA.ndy, true, getResources().getString(C25738R.string.f9221tf), new C30111a() {
                            /* renamed from: a */
                            public final void mo6399a(boolean z, String str, int i) {
                                AppMethodBeat.m2504i(111848);
                                if (z) {
                                    GameDetailUI2.m76785a(GameDetailUI2.this, stringExtra, str);
                                    C30379h.m48465bQ(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(C25738R.string.ate));
                                    C34277b.m56211a(GameDetailUI2.this.mController.ylL, 12, 1207, 2, 14, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
                                    AppMethodBeat.m2505o(111848);
                                    return;
                                }
                                AppMethodBeat.m2505o(111848);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(111872);
                    return;
                }
                break;
            case 3:
                if (i2 == -1) {
                    C34277b.m56211a(this.mController.ylL, 12, 1207, 2, 15, this.appId, this.mXC, null);
                    AppMethodBeat.m2505o(111872);
                    return;
                }
                break;
            default:
                C4990ab.m7412e("MicroMsg.GameDetailUI2", "error request code");
                AppMethodBeat.m2505o(111872);
                return;
        }
        AppMethodBeat.m2505o(111872);
    }

    /* renamed from: b */
    private void m76788b(C28219aa c28219aa) {
        int i = 0;
        AppMethodBeat.m2504i(111867);
        List list = c28219aa.mXO;
        if (list == null || list.size() == 0) {
            this.nhc.setVisibility(8);
            this.nhd.setVisibility(8);
            AppMethodBeat.m2505o(111867);
            return;
        }
        this.nhc.setVisibility(0);
        if (list.size() > 3) {
            this.nhd.setVisibility(0);
        } else {
            this.nhd.setVisibility(8);
        }
        this.nhc.removeAllViews();
        C12202i c12202i = new C12202i(this.mController.ylL);
        c12202i.f2909Rt = 2130969696;
        c12202i.mo24034a(c28219aa);
        c12202i.mXC = this.mXC;
        while (i < list.size() && i < 3) {
            this.nhc.addView(c12202i.getView(i, null, this.nha));
            i++;
        }
        AppMethodBeat.m2505o(111867);
    }

    /* renamed from: p */
    static /* synthetic */ void m76804p(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.m2504i(111876);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
        C25985d.m41466b((Context) gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.mController.ylL.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
        AppMethodBeat.m2505o(111876);
    }

    /* renamed from: q */
    static /* synthetic */ void m76805q(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.m2504i(111877);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.nhA.ndz);
        String str = gameDetailUI2.nhA.mZs;
        if (C5046bo.isNullOrNil(str)) {
            str = gameDetailUI2.mVZ.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.nhA.mZm);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = C37922v.m64078nW("game_center");
        C37922v.m64076Zp().mo60676y(str, true).mo53356j("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        C25985d.m41468b(gameDetailUI2.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 3);
        AppMethodBeat.m2505o(111877);
    }

    /* renamed from: a */
    static /* synthetic */ void m76785a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        AppMethodBeat.m2504i(111878);
        C8910b c8910b = new C8910b();
        c8910b.title = gameDetailUI2.nhA.ndx;
        c8910b.description = gameDetailUI2.nhA.ndy;
        c8910b.type = 5;
        if (C5046bo.isNullOrNil(gameDetailUI2.nhA.mZs)) {
            c8910b.thumburl = gameDetailUI2.mVZ.field_appIconUrl;
        } else {
            c8910b.thumburl = gameDetailUI2.nhA.mZs;
        }
        c8910b.url = gameDetailUI2.nhA.mZm;
        if (C25748a.m40880XD() != null) {
            C25748a.m40880XD().mo30686a(c8910b, gameDetailUI2.appId, gameDetailUI2.mVZ.field_appName, str, null, null);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            C18372qb c18372qb = new C18372qb();
            c18372qb.cMq.cMr = str;
            c18372qb.cMq.content = str2;
            c18372qb.cMq.type = C1855t.m3925nK(str);
            c18372qb.cMq.flags = 0;
            C4879a.xxA.mo10055m(c18372qb);
        }
        AppMethodBeat.m2505o(111878);
    }
}
