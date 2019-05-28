package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.x.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@i
public class CardHomePageUI extends CardBaseUI implements d, a {
    private int fromScene = 0;
    private b kha;
    private boolean khn = false;
    private boolean khp = true;
    private boolean khr = false;
    private String khs = "";
    private boolean kht = false;
    private boolean khu = false;
    private long khy = 0;
    boolean khz = false;
    private i klI;
    private f klJ;
    private f klK;
    private boolean klL = true;
    private boolean klM = false;
    private TextView klN;
    private LinearLayout klO;
    private long mStartTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(88517);
        cardHomePageUI.bdh();
        AppMethodBeat.o(88517);
    }

    static /* synthetic */ void d(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(88519);
        cardHomePageUI.aZt();
        AppMethodBeat.o(88519);
    }

    static /* synthetic */ void h(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(88520);
        cardHomePageUI.bdf();
        AppMethodBeat.o(88520);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88492);
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.khy = currentTimeMillis;
        initView();
        am.bba().a(this.klI);
        g.RO().eJo.a(1164, (f) this);
        g.RO().eJo.a(984, (f) this);
        am.bbd().bbr();
        am.baV();
        com.tencent.mm.plugin.card.b.b.sO(1);
        bbW();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(88491);
                if (CardHomePageUI.this.kha != null) {
                    CardHomePageUI.this.kha;
                    if (b.bbA()) {
                        ab.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                        CardHomePageUI.h(CardHomePageUI.this);
                    }
                }
                AppMethodBeat.o(88491);
                return false;
            }
        });
        am.bbd().a((d) this);
        am.baW().c(this);
        ((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).eA(8, 2);
        AppMethodBeat.o(88492);
    }

    public final int getLayoutId() {
        return R.layout.j6;
    }

    public void onDestroy() {
        AppMethodBeat.i(88493);
        if (this.klM) {
            aZv();
        }
        am.bba().b(this.klI);
        this.kha.kfs = null;
        g.RO().eJo.b(1164, (f) this);
        g.RO().eJo.b(984, (f) this);
        am.bbd().b(this);
        am.baW().d(this);
        k.baK();
        b.bbx();
        long currentTimeMillis = System.currentTimeMillis() - this.khy;
        h.pYm.e(13219, "CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis));
        super.onDestroy();
        AppMethodBeat.o(88493);
    }

    public void onResume() {
        AppMethodBeat.i(88494);
        ab.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", Boolean.valueOf(this.klM), Boolean.valueOf(this.khz), Boolean.valueOf(this.khn));
        if (this.klM) {
            if (this.khz && this.khn) {
                this.khs = "";
                this.kht = false;
                aZu();
            }
        } else if (this.khn) {
            this.khs = "";
            bbT();
        }
        this.khn = false;
        cu();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(1);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.pYm.b(arrayList, true);
            this.mStartTime = 0;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88483);
                am.bbm().a(q.EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD);
                AppMethodBeat.o(88483);
            }
        });
        super.onResume();
        AppMethodBeat.o(88494);
    }

    public void onPause() {
        AppMethodBeat.i(88495);
        super.onPause();
        AppMethodBeat.o(88495);
    }

    public final void initView() {
        AppMethodBeat.i(88496);
        ab.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.klM = r0;
        if (this.klM) {
            bbN();
        } else {
            ab.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            bbT();
        }
        super.initView();
        AppMethodBeat.o(88496);
    }

    public final void aZp() {
        AppMethodBeat.i(88497);
        setMMTitle((int) R.string.aev);
        addTextOptionMenu(0, getString(R.string.ag6), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88484);
                com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, true);
                h.pYm.e(11582, "CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", "");
                AppMethodBeat.o(88484);
                return true;
            }
        });
        this.kha = new b(this);
        this.kha.init();
        if (this.klI == null) {
            this.klI = new i(this, this.mController.contentView);
            i iVar = this.klI;
            iVar.kmK = View.inflate(iVar.jiE, R.layout.jl, null);
            iVar.kmK.setVisibility(8);
            iVar.kmL = (TextView) iVar.kmK.findViewById(R.id.ahw);
            iVar.kmM = (ImageView) iVar.kmK.findViewById(R.id.ahv);
            iVar.kmK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88588);
                    com.tencent.mm.plugin.card.d.b.a(i.this.jiE, false);
                    am.bba().baJ();
                    i.this.bdm();
                    h.pYm.e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "");
                    AppMethodBeat.o(88588);
                }
            });
            iVar.bdm();
            if (iVar.kmN == null) {
                iVar.kmN = ((ViewStub) iVar.jcl.findViewById(R.id.ag4)).inflate();
                iVar.kmN.setVisibility(8);
                iVar.kmO = (TextView) iVar.kmN.findViewById(R.id.ahw);
                iVar.kmP = (ImageView) iVar.kmN.findViewById(R.id.ahv);
                iVar.kmN.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(88589);
                        com.tencent.mm.plugin.card.d.b.a(i.this.jiE, false);
                        am.bba().baJ();
                        i.this.bdm();
                        h.pYm.e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), "");
                        AppMethodBeat.o(88589);
                    }
                });
            }
            this.klI.khF = true;
        }
        if (this.klJ == null) {
            this.klJ = new f(this, findViewById(R.id.ag8), 1, this.kha);
        }
        if (this.klK == null) {
            this.klK = new f(this, findViewById(R.id.ag9), 3, this.kha);
        }
        if (this.klJ != null) {
            this.klJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88488);
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    CardHomePageUI.this.startActivity(intent);
                    h.pYm.e(11324, "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(88488);
                }
            });
        }
        if (this.klK != null) {
            this.klK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88489);
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 3);
                    CardHomePageUI.this.startActivity(intent);
                    h.pYm.e(11324, "ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(88489);
                }
            });
        }
        this.klO = (LinearLayout) findViewById(R.id.ag_);
        ol bdg = bdg();
        if (bdg != null) {
            a(bdg);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88485);
                if (CardHomePageUI.this.fromScene == 1 || CardHomePageUI.this.fromScene == 2) {
                    CardHomePageUI.b(CardHomePageUI.this);
                } else {
                    CardHomePageUI.this.finish();
                }
                AppMethodBeat.o(88485);
                return true;
            }
        });
        AppMethodBeat.o(88497);
    }

    public final n.a aZq() {
        return n.a.HOME_MEMBER_CARD_TYPE;
    }

    private void bbN() {
        AppMethodBeat.i(88498);
        ab.d("MicroMsg.CardHomePageUI", "initLocation");
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88486);
                CardHomePageUI.c(CardHomePageUI.this);
                CardHomePageUI.d(CardHomePageUI.this);
                CardHomePageUI.this.khz = true;
                ab.d("MicroMsg.CardHomePageUI", "initLocation end");
                AppMethodBeat.o(88486);
            }
        });
        AppMethodBeat.o(88498);
    }

    public final void aZy() {
        AppMethodBeat.i(88499);
        ab.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.klM);
        if (!this.klM) {
            this.klM = true;
            bbN();
        }
        AppMethodBeat.o(88499);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(88500);
        super.onNewIntent(intent);
        setIntent(intent);
        bbW();
        this.khn = true;
        this.klL = true;
        AppMethodBeat.o(88500);
    }

    private void cu() {
        AppMethodBeat.i(88501);
        ab.i("MicroMsg.CardHomePageUI", "updateView()");
        this.klI.bdm();
        bdf();
        this.klK.cu();
        AppMethodBeat.o(88501);
    }

    private void bdf() {
        AppMethodBeat.i(88502);
        ab.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        c cVar = (c) this.kan;
        if (this.klN == null) {
            this.klN = (TextView) findViewById(R.id.ag7);
            this.klN.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88487);
                    Intent intent = new Intent(CardHomePageUI.this, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    CardHomePageUI.this.startActivity(intent);
                    h.pYm.e(11324, "GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
                    AppMethodBeat.o(88487);
                }
            });
        }
        if (cVar.getCount() > 0) {
            this.klN.setVisibility(0);
            this.klN.setText(getString(R.string.ahp, new Object[]{Integer.valueOf(b.bbs())}));
        } else {
            this.klN.setVisibility(0);
            this.klN.setText(getString(R.string.ahp, new Object[]{Integer.valueOf(b.bbs())}));
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ag6);
            if (linearLayout != null) {
                LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 29);
                layoutParams.bottomMargin = com.tencent.mm.bz.a.fromDPToPix(this, 29);
                linearLayout.setLayoutParams(layoutParams);
            }
        }
        this.klJ.bde();
        AppMethodBeat.o(88502);
    }

    public final void aZz() {
        AppMethodBeat.i(88503);
        bdf();
        AppMethodBeat.o(88503);
    }

    public final void aZw() {
        AppMethodBeat.i(88504);
        if (this.kht) {
            ab.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.klM) {
                aZv();
            }
            AppMethodBeat.o(88504);
            return;
        }
        ab.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.kht = true;
        bbT();
        aZv();
        AppMethodBeat.o(88504);
    }

    public final void aZx() {
        AppMethodBeat.i(88505);
        if (this.khu || this.kht) {
            aZv();
            AppMethodBeat.o(88505);
            return;
        }
        this.khu = true;
        ab.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        bbT();
        AppMethodBeat.o(88505);
    }

    private void bbT() {
        AppMethodBeat.i(88506);
        ab.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        bbU();
        if (l.beC()) {
            com.tencent.mm.plugin.card.b.b.baj();
        } else {
            ab.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        am.bbc().s("", "", 4);
        AppMethodBeat.o(88506);
    }

    private void bbU() {
        AppMethodBeat.i(88507);
        if (!this.klL) {
            ab.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
            AppMethodBeat.o(88507);
        } else if (this.khr) {
            ab.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.o(88507);
        } else {
            if (this.khp && !bo.isNullOrNil(this.khs)) {
                this.khs = "";
            }
            this.khr = true;
            this.klL = false;
            g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.bbc().ecs, (double) am.bbc().ect, this.khs), 0);
            AppMethodBeat.o(88507);
        }
    }

    public final boolean aZr() {
        AppMethodBeat.i(88508);
        boolean aZr = super.aZr();
        AppMethodBeat.o(88508);
        return aZr;
    }

    public final boolean aZs() {
        return true;
    }

    public final void b(com.tencent.mm.plugin.card.base.b bVar, int i) {
        AppMethodBeat.i(88509);
        super.b(bVar, i);
        AppMethodBeat.o(88509);
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88510);
        super.a(bVar);
        AppMethodBeat.o(88510);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88511);
        super.onSceneEnd(i, i2, str, mVar);
        if (i != 0 || i2 != 0) {
            if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.khr = false;
            }
            ab.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (mVar instanceof ad) {
            bdf();
            this.kat.ZZ();
            this.klK.cu();
            a(((ad) mVar).kej);
            AppMethodBeat.o(88511);
            return;
        } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) mVar;
            this.khr = false;
            this.khs = bVar.kfA;
            this.kha.at(bVar.kdS, this.khp);
            if (!(b.bby() && b.bbz())) {
                this.khp = false;
            }
            ab.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            cu();
            AppMethodBeat.o(88511);
            return;
        }
        AppMethodBeat.o(88511);
    }

    private static ol bdg() {
        AppMethodBeat.i(88512);
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, null);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(88512);
            return null;
        }
        ol olVar = new ol();
        try {
            olVar.parseFrom(str.getBytes("ISO-8859-1"));
            AppMethodBeat.o(88512);
            return olVar;
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.CardHomePageUI", e, "", new Object[0]);
            AppMethodBeat.o(88512);
            return null;
        }
    }

    private void a(ol olVar) {
        AppMethodBeat.i(88513);
        this.klO.removeAllViews();
        if (!(olVar == null || olVar.vUN == null || olVar.vUN.isEmpty())) {
            Iterator it = olVar.vUN.iterator();
            while (it.hasNext()) {
                final oa oaVar = (oa) it.next();
                View inflate = LayoutInflater.from(this.mController.ylL).inflate(R.layout.it, this.klO, false);
                new f(this, inflate, 4, this.kha, oaVar).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(88490);
                        if (oaVar.vTw == 1) {
                            com.tencent.mm.plugin.card.d.b.a(CardHomePageUI.this, oaVar.vTx, 0);
                            AppMethodBeat.o(88490);
                            return;
                        }
                        if (oaVar.vTw == 2) {
                            if (oaVar.vTy != null) {
                                se seVar = new se();
                                seVar.cOf.userName = oaVar.vTy.tzW;
                                seVar.cOf.cOh = bo.bc(oaVar.vTy.ttg, "");
                                seVar.cOf.scene = 1028;
                                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                                AppMethodBeat.o(88490);
                                return;
                            }
                        } else if (oaVar.vTw != 3) {
                            ab.w("MicroMsg.CardHomePageUI", "unknown op action: %s", Integer.valueOf(oaVar.vTw));
                        } else if ("weixin://wccard/sharecarddetail".equals(oaVar.vTz)) {
                            ab.d("MicroMsg.CardHomePageUI", "go to share card ui");
                            Intent intent = new Intent(CardHomePageUI.this, ShareCardListUI.class);
                            intent.putExtra("key_layout_buff", CardHomePageUI.this.khs);
                            CardHomePageUI.this.klL = true;
                            CardHomePageUI.this.startActivity(intent);
                            h.pYm.e(11324, "ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0));
                            AppMethodBeat.o(88490);
                            return;
                        }
                        AppMethodBeat.o(88490);
                    }
                });
                this.klO.addView(inflate);
            }
        }
        AppMethodBeat.o(88513);
    }

    private void bbW() {
        AppMethodBeat.i(88514);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean bX = c.PK().bX(262152, 266256);
        boolean bY = c.PK().bY(262152, 266256);
        boolean a = c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ac.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null));
        if (bX) {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        } else if (bY) {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        } else if (a && !a2) {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        } else if (a && a2) {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        } else if (a2) {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        } else {
            h.pYm.e(11324, "CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), nullAsNil);
            AppMethodBeat.o(88514);
        }
    }

    public final void bag() {
        this.khn = true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        this.khn = true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88515);
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                bdh();
            } else {
                finish();
            }
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(88515);
        return onKeyUp;
    }

    private void bdh() {
        AppMethodBeat.i(88516);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.bp.d.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        AppMethodBeat.o(88516);
    }

    static /* synthetic */ void c(CardHomePageUI cardHomePageUI) {
        AppMethodBeat.i(88518);
        cardHomePageUI.fwu = com.tencent.mm.modelgeo.d.agz();
        AppMethodBeat.o(88518);
    }
}
