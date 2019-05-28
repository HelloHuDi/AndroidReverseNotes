package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.da;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements f {
    private String appId = null;
    private Dialog lud;
    private c mVZ = null;
    private int mXC = 0;
    private String ngJ = null;
    private String ngK = null;
    private int ngM = 18;
    private boolean ngN;
    private boolean ngO;
    private String ngP = null;
    private a ngQ = null;
    private d ngR = null;
    private k ngS = null;
    private ViewGroup ngT;
    private ImageView ngU;
    private ImageView ngV;
    private TextView ngW;
    private Button ngX;
    private TextProgressBar ngY;
    private TextView ngZ;
    private da nhA;
    private OnClickListener nhB = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(111856);
            GameDetailUI2.this.ngS.biT();
            GameDetailUI2.this.ngR.a(GameDetailUI2.this.ngY, GameDetailUI2.this.ngX, GameDetailUI2.this.mVZ, GameDetailUI2.this.ngS);
            AppMethodBeat.o(111856);
        }
    };
    private View.OnClickListener nhC = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111857);
            if (GameDetailUI2.this.mVZ == null) {
                ab.e("MicroMsg.GameDetailUI2", "Null appInfo");
                AppMethodBeat.o(111857);
            } else if (GameDetailUI2.this.ngS == null) {
                ab.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
                AppMethodBeat.o(111857);
            } else {
                GameDetailUI2.this.ngS.ei(GameDetailUI2.this.mController.ylL);
                GameDetailUI2.this.ngR.a(GameDetailUI2.this.mVZ, GameDetailUI2.this.ngS);
                AppMethodBeat.o(111857);
            }
        }
    };
    private View.OnClickListener nhD = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111858);
            if (view.getTag() instanceof String) {
                com.tencent.mm.plugin.game.f.c.a(view, GameDetailUI2.this);
                b.a(GameDetailUI2.this.mController.ylL, 12, 1203, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
                AppMethodBeat.o(111858);
                return;
            }
            GameDetailRankUI.a aVar = new GameDetailRankUI.a();
            aVar.ngJ = GameDetailUI2.this.ngJ;
            aVar.ngK = GameDetailUI2.this.ngK;
            aVar.ngL = GameDetailUI2.this.mVZ;
            String nW = v.nW("rankData");
            v.Zp().y(nW, true).j(GameDetailRankUI.ngH, aVar);
            Intent intent = new Intent(GameDetailUI2.this.mController.ylL, GameDetailRankUI.class);
            intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, nW);
            GameDetailUI2.this.startActivity(intent);
            b.a(GameDetailUI2.this.mController.ylL, 12, 1203, 999, 6, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.o(111858);
        }
    };
    private View.OnClickListener nhE = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111841);
            com.tencent.mm.plugin.game.f.c.a(view, GameDetailUI2.this);
            b.a(GameDetailUI2.this.mController.ylL, 12, 1204, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.o(111841);
        }
    };
    private View.OnClickListener nhF = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111842);
            com.tencent.mm.plugin.game.f.c.a(view, GameDetailUI2.this);
            b.a(GameDetailUI2.this.mController.ylL, 12, 1205, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.o(111842);
        }
    };
    private View.OnClickListener nhG = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111843);
            com.tencent.mm.plugin.game.f.c.a(view, GameDetailUI2.this);
            b.a(GameDetailUI2.this.mController.ylL, 12, 1205, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.o(111843);
        }
    };
    private View.OnClickListener nhH = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111844);
            com.tencent.mm.plugin.game.f.c.a(view, GameDetailUI2.this);
            b.a(GameDetailUI2.this.mController.ylL, 12, 1206, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
            AppMethodBeat.o(111844);
        }
    };
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameDetailUI2() {
        AppMethodBeat.i(111859);
        AppMethodBeat.o(111859);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(111860);
        super.onCreate(bundle);
        if (g.RK()) {
            boolean z;
            this.ngN = true;
            this.ngO = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (bo.isNullOrNil(this.appId)) {
                ab.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.mXC = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            initView();
            g.Rg().a(1217, (f) this);
            final byte[] NK = ((com.tencent.mm.plugin.game.a.c) g.K(com.tencent.mm.plugin.game.a.c.class)).bCZ().NK(this.appId);
            if (NK == null || NK.length == 0) {
                ab.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(111852);
                        final z zVar = new z(NK);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111851);
                                GameDetailUI2.a(GameDetailUI2.this, zVar);
                                AppMethodBeat.o(111851);
                            }
                        });
                        AppMethodBeat.o(111852);
                    }
                });
                z = true;
            }
            if (!z) {
                this.lud = com.tencent.mm.plugin.game.f.c.ej(this);
                this.lud.show();
            }
            g.Rg().a(new am(aa.dor(), this.appId, com.tencent.mm.pluginsdk.model.app.g.u(this, this.appId)), 0);
            AppMethodBeat.o(111860);
            return;
        }
        ab.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
        AppMethodBeat.o(111860);
    }

    public final int getLayoutId() {
        return R.layout.a39;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.i(111861);
        super.onResume();
        if (!(this.mVZ == null || this.ngS == null)) {
            this.ngS.biT();
            this.ngR.a(this.ngY, this.ngX, this.mVZ, this.ngS);
        }
        if (this.ngN) {
            this.ngN = false;
            AppMethodBeat.o(111861);
            return;
        }
        b(new com.tencent.mm.plugin.game.model.aa(this.appId));
        AppMethodBeat.o(111861);
    }

    public void onDestroy() {
        AppMethodBeat.i(111862);
        super.onDestroy();
        g.Rg().b(1217, (f) this);
        if (this.ngQ != null) {
            j.b(this.ngQ);
        }
        AppMethodBeat.o(111862);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(111863);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(111863);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(111863);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(111864);
        bFl();
        finish();
        AppMethodBeat.o(111864);
    }

    private void bFl() {
        AppMethodBeat.i(111865);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bo.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        AppMethodBeat.o(111865);
    }

    public final void initView() {
        AppMethodBeat.i(111866);
        setMMTitle((int) R.string.c59);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(111840);
                GameDetailUI2.a(GameDetailUI2.this);
                AppMethodBeat.o(111840);
                return true;
            }
        });
        this.ngT = (ViewGroup) findViewById(R.id.c3q);
        this.ngU = (ImageView) findViewById(R.id.c3r);
        this.ngV = (ImageView) findViewById(R.id.zr);
        this.ngW = (TextView) findViewById(R.id.zt);
        this.ngZ = (TextView) findViewById(R.id.c3g);
        this.ngX = (Button) findViewById(R.id.c4b);
        this.ngY = (TextProgressBar) findViewById(R.id.c4c);
        this.ngY.setTextSize(this.ngM);
        this.nha = (LinearLayout) findViewById(R.id.c3k);
        this.nhb = (GameDetailAutoScrollView) findViewById(R.id.c3s);
        this.nhc = (LinearLayout) findViewById(R.id.c3t);
        this.nhd = (TextView) findViewById(R.id.c3l);
        this.nhe = (LinearLayout) findViewById(R.id.c3u);
        this.nhf = (TextView) findViewById(R.id.c3v);
        this.nhg = (LinearLayout) findViewById(R.id.c3w);
        this.nhh = (ImageView) findViewById(R.id.c3x);
        this.nhi = findViewById(R.id.c3y);
        this.nhj = (TextView) findViewById(R.id.c3z);
        this.nhk = (TextView) findViewById(R.id.c40);
        this.nhl = findViewById(R.id.c43);
        this.nhm = (TextView) findViewById(R.id.c44);
        this.nhn = (ImageView) findViewById(R.id.c45);
        this.nho = (TextView) findViewById(R.id.c46);
        this.nhp = (TextView) findViewById(R.id.c47);
        this.nhq = (LinearLayout) findViewById(R.id.c41);
        this.nhr = (GameMediaList) findViewById(R.id.c3n);
        this.nhr.l(this, this.appId, this.mXC);
        this.nhr.setItemLayout(R.layout.a4u);
        this.nhs = (TextView) findViewById(R.id.c3m);
        this.nht = (TextView) findViewById(R.id.c3p);
        this.nht.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(111849);
                if (GameDetailUI2.this.nht.getLineCount() > 3) {
                    GameDetailUI2.this.nhu.setVisibility(0);
                    AppMethodBeat.o(111849);
                    return;
                }
                GameDetailUI2.this.nhu.setVisibility(8);
                AppMethodBeat.o(111849);
            }
        });
        this.nhu = (TextView) findViewById(R.id.c42);
        this.nhu.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(111850);
                if (GameDetailUI2.this.nhv) {
                    GameDetailUI2.this.nht.setMaxLines(3);
                    GameDetailUI2.this.nhu.setText(GameDetailUI2.this.getResources().getText(R.string.c4u));
                    GameDetailUI2.this.nhv = false;
                    AppMethodBeat.o(111850);
                    return;
                }
                GameDetailUI2.this.nht.setMaxLines(100);
                GameDetailUI2.this.nhu.setText(GameDetailUI2.this.getResources().getText(R.string.c4v));
                GameDetailUI2.this.nhv = true;
                AppMethodBeat.o(111850);
            }
        });
        this.nhw = (LinearLayout) findViewById(R.id.c48);
        this.nhx = (TextView) findViewById(R.id.c49);
        this.nhy = (LinearLayout) findViewById(R.id.c4_);
        this.nhz = (TextView) findViewById(R.id.c4a);
        AppMethodBeat.o(111866);
    }

    private void a(z zVar) {
        AppMethodBeat.i(111868);
        LinkedList linkedList = null;
        if (zVar.mXN.mXO == null || zVar.mXN.mXO.size() == 0) {
            linkedList = zVar.mXK.nbK;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.nha.setVisibility(8);
            AppMethodBeat.o(111868);
            return;
        }
        this.nha.setVisibility(0);
        this.nha.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.d.v vVar = (com.tencent.mm.plugin.game.d.v) it.next();
            View inflate = LayoutInflater.from(this.mController.ylL).inflate(R.layout.a3j, this.nha, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.c4z);
            TextView textView = (TextView) inflate.findViewById(R.id.c50);
            TextView textView2 = (TextView) inflate.findViewById(R.id.c51);
            if (bo.isNullOrNil(vVar.jBB)) {
                com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                aVar.eQf = true;
                o.ahp().a(vVar.mZs, imageView, aVar.ahG());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, vVar.jBB, 0.5f, false);
            }
            textView.setText(vVar.Title);
            textView2.setText(vVar.naq);
            this.nha.addView(inflate);
        }
        AppMethodBeat.o(111868);
    }

    private void b(z zVar) {
        AppMethodBeat.i(111869);
        if (zVar.bEA() == null || zVar.bEA().isEmpty()) {
            this.nhe.setVisibility(8);
            AppMethodBeat.o(111869);
            return;
        }
        int i;
        z.a aVar;
        this.nhe.setVisibility(0);
        if (bo.isNullOrNil(zVar.bEz())) {
            this.nhf.setVisibility(8);
        } else {
            this.nhf.setVisibility(0);
            this.nhf.setText(zVar.bEz());
        }
        this.nhg.removeAllViews();
        if (zVar.bEB() == 1) {
            this.nhg.setOrientation(1);
            this.nhh.setVisibility(8);
            i = R.layout.a3b;
        } else {
            this.nhg.setOrientation(0);
            this.nhh.setVisibility(0);
            i = R.layout.a3a;
        }
        LinkedList bEA = zVar.bEA();
        if (bEA != null) {
            Iterator it = bEA.iterator();
            while (it.hasNext()) {
                z.b bVar = (z.b) it.next();
                View inflate = LayoutInflater.from(this.mController.ylL).inflate(i, this.nhg, false);
                o.ahp().a(bVar.cIY, (ImageView) inflate.findViewById(R.id.c4f));
                if (zVar.bEB() == 1) {
                    ((TextView) inflate.findViewById(R.id.c4h)).setText(bVar.title);
                }
                ((TextView) inflate.findViewById(R.id.c4g)).setText(bVar.desc);
                if (zVar.bEB() == 1) {
                    inflate.setTag(bVar.url);
                    inflate.setOnClickListener(this.nhE);
                }
                this.nhg.addView(inflate);
            }
        }
        if (zVar.mXK.nbS != null) {
            aVar = new z.a();
            aVar.title = zVar.mXK.nbS.summary;
            aVar.desc = zVar.mXK.nbS.desc;
            aVar.url = zVar.mXK.nbS.url;
        } else if (zVar.mXK.nbN == null || bo.isNullOrNil(zVar.mXK.nbN.ncA) || bo.isNullOrNil(zVar.mXK.nbN.ncB)) {
            aVar = null;
        } else {
            aVar = new z.a();
            aVar.title = zVar.mXK.nbN.ncA;
            aVar.url = zVar.mXK.nbN.ncB;
        }
        if (aVar != null) {
            this.nhi.setVisibility(0);
            this.nhj.setText(aVar.title);
            if (bo.isNullOrNil(aVar.desc)) {
                this.nhk.setVisibility(8);
            } else {
                this.nhk.setVisibility(0);
                this.nhk.setText(aVar.desc);
            }
            this.nhi.setTag(aVar.url);
            this.nhi.setOnClickListener(this.nhE);
            AppMethodBeat.o(111869);
            return;
        }
        this.nhi.setVisibility(8);
        AppMethodBeat.o(111869);
    }

    private void c(z zVar) {
        AppMethodBeat.i(111870);
        if (zVar.bEG() == null || zVar.bEG().isEmpty()) {
            this.nhw.setVisibility(8);
            AppMethodBeat.o(111870);
            return;
        }
        Pair pair;
        this.nhw.setVisibility(0);
        if (bo.isNullOrNil(zVar.bEF())) {
            this.nhx.setVisibility(8);
        } else {
            this.nhx.setVisibility(0);
            this.nhx.setText(zVar.bEF());
        }
        this.nhy.removeAllViews();
        this.nhy.setOnClickListener(null);
        Iterator it = zVar.bEG().iterator();
        while (it.hasNext()) {
            bw bwVar = (bw) it.next();
            View inflate = LayoutInflater.from(this.mController.ylL).inflate(R.layout.a3c, this.nhy, false);
            TextView textView = (TextView) inflate.findViewById(R.id.c4j);
            TextView textView2 = (TextView) inflate.findViewById(R.id.c4k);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.c4l);
            ((TextView) inflate.findViewById(R.id.c4i)).setText(bwVar.ncF);
            textView.setText(bwVar.Title);
            textView2.setText(bwVar.naq);
            o.ahp().a(bwVar.ncC, imageView);
            inflate.setTag(bwVar.mZm);
            inflate.setOnClickListener(this.nhF);
            this.nhy.addView(inflate);
        }
        if (zVar.mXK.nbN == null) {
            pair = null;
        } else if (bo.isNullOrNil(zVar.mXK.nbM.Title) || bo.isNullOrNil(zVar.mXK.nbM.ncB)) {
            pair = null;
        } else {
            pair = new Pair(zVar.mXK.nbM.ncA, zVar.mXK.nbM.ncB);
        }
        if (pair != null) {
            this.nhz.setVisibility(0);
            this.nhz.setText((CharSequence) pair.first);
            this.nhz.setTag(pair.second);
            this.nhz.setOnClickListener(this.nhG);
            AppMethodBeat.o(111870);
            return;
        }
        this.nhz.setVisibility(8);
        AppMethodBeat.o(111870);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(111871);
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case 1217:
                    final com.tencent.mm.bt.a aVar = ((am) mVar).lty.fsH.fsP;
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(111855);
                            final z zVar = new z(aVar);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(111854);
                                    GameDetailUI2.a(GameDetailUI2.this, zVar);
                                    if (GameDetailUI2.this.lud != null) {
                                        GameDetailUI2.this.lud.dismiss();
                                    }
                                    AppMethodBeat.o(111854);
                                }
                            });
                            AppMethodBeat.o(111855);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(111871);
            return;
        }
        if (!com.tencent.mm.plugin.game.b.a.gkF.a((Context) this, i, i2, str)) {
            Toast.makeText(this, getString(R.string.c6n, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.lud != null) {
            this.lud.cancel();
        }
        AppMethodBeat.o(111871);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(111872);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                switch (i2) {
                    case 0:
                        AppMethodBeat.o(111872);
                        return;
                    case 2:
                        if (!(this.mVZ == null || this.ngS == null)) {
                            this.ngS.bEj();
                            this.ngR.a(this.mVZ, this.ngS);
                            AppMethodBeat.o(111872);
                            return;
                        }
                    case 3:
                        if (this.ngS != null) {
                            this.ngS.biT();
                            AppMethodBeat.o(111872);
                            return;
                        }
                        break;
                    default:
                        AppMethodBeat.o(111872);
                        return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bo.isNullOrNil(stringExtra)) {
                        String str = this.nhA.mZs;
                        if (bo.isNullOrNil(str)) {
                            str = this.mVZ.field_appIconUrl;
                        }
                        t.a.vlq.a(this.mController, this.nhA.ndx, str, this.nhA.ndy, true, getResources().getString(R.string.tf), new q.a() {
                            public final void a(boolean z, String str, int i) {
                                AppMethodBeat.i(111848);
                                if (z) {
                                    GameDetailUI2.a(GameDetailUI2.this, stringExtra, str);
                                    h.bQ(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(R.string.ate));
                                    b.a(GameDetailUI2.this.mController.ylL, 12, 1207, 2, 14, GameDetailUI2.this.appId, GameDetailUI2.this.mXC, null);
                                    AppMethodBeat.o(111848);
                                    return;
                                }
                                AppMethodBeat.o(111848);
                            }
                        });
                    }
                    AppMethodBeat.o(111872);
                    return;
                }
                break;
            case 3:
                if (i2 == -1) {
                    b.a(this.mController.ylL, 12, 1207, 2, 15, this.appId, this.mXC, null);
                    AppMethodBeat.o(111872);
                    return;
                }
                break;
            default:
                ab.e("MicroMsg.GameDetailUI2", "error request code");
                AppMethodBeat.o(111872);
                return;
        }
        AppMethodBeat.o(111872);
    }

    private void b(com.tencent.mm.plugin.game.model.aa aaVar) {
        int i = 0;
        AppMethodBeat.i(111867);
        List list = aaVar.mXO;
        if (list == null || list.size() == 0) {
            this.nhc.setVisibility(8);
            this.nhd.setVisibility(8);
            AppMethodBeat.o(111867);
            return;
        }
        this.nhc.setVisibility(0);
        if (list.size() > 3) {
            this.nhd.setVisibility(0);
        } else {
            this.nhd.setVisibility(8);
        }
        this.nhc.removeAllViews();
        i iVar = new i(this.mController.ylL);
        iVar.Rt = R.layout.a3g;
        iVar.a(aaVar);
        iVar.mXC = this.mXC;
        while (i < list.size() && i < 3) {
            this.nhc.addView(iVar.getView(i, null, this.nha));
            i++;
        }
        AppMethodBeat.o(111867);
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.i(111876);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
        d.b((Context) gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.mController.ylL.overridePendingTransition(R.anim.cg, R.anim.b6);
        AppMethodBeat.o(111876);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.i(111877);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.nhA.ndz);
        String str = gameDetailUI2.nhA.mZs;
        if (bo.isNullOrNil(str)) {
            str = gameDetailUI2.mVZ.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.nhA.mZm);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = v.nW("game_center");
        v.Zp().y(str, true).j("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        d.b(gameDetailUI2.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 3);
        AppMethodBeat.o(111877);
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        AppMethodBeat.i(111878);
        com.tencent.mm.af.j.b bVar = new com.tencent.mm.af.j.b();
        bVar.title = gameDetailUI2.nhA.ndx;
        bVar.description = gameDetailUI2.nhA.ndy;
        bVar.type = 5;
        if (bo.isNullOrNil(gameDetailUI2.nhA.mZs)) {
            bVar.thumburl = gameDetailUI2.mVZ.field_appIconUrl;
        } else {
            bVar.thumburl = gameDetailUI2.nhA.mZs;
        }
        bVar.url = gameDetailUI2.nhA.mZm;
        if (com.tencent.mm.af.q.a.XD() != null) {
            com.tencent.mm.af.q.a.XD().a(bVar, gameDetailUI2.appId, gameDetailUI2.mVZ.field_appName, str, null, null);
        }
        if (!bo.isNullOrNil(str2)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str;
            qbVar.cMq.content = str2;
            qbVar.cMq.type = com.tencent.mm.model.t.nK(str);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        AppMethodBeat.o(111878);
    }
}
