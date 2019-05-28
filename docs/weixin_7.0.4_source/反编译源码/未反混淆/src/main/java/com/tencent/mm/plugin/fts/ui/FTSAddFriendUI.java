package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.api.j;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.IOException;
import java.util.List;

@a(3)
public class FTSAddFriendUI extends FTSBaseUI {
    private final f ehi = new f() {
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(61729);
            g.Rg().b(106, (f) this);
            FTSAddFriendUI.d(FTSAddFriendUI.this);
            if (i == 0 && i2 == 0) {
                String a;
                FTSAddFriendUI.this.lPE = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                FTSAddFriendUI fTSAddFriendUI = FTSAddFriendUI.this;
                buu buu = (buu) ((com.tencent.mm.plugin.messenger.a.f) mVar).ehh.fsG.fsP;
                if (buu != null) {
                    a = aa.a(buu.wcB);
                } else {
                    a = "";
                }
                fTSAddFriendUI.mHZ = a;
                if (FTSAddFriendUI.this.lPE.wod > 0) {
                    if (FTSAddFriendUI.this.lPE.woe.isEmpty()) {
                        h.a(FTSAddFriendUI.this, (int) R.string.dzx, 0, true, null);
                        AppMethodBeat.o(61729);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("add_more_friend_search_scene", 3);
                    if (FTSAddFriendUI.this.lPE.woe.size() > 1) {
                        try {
                            intent.putExtra("result", FTSAddFriendUI.this.lPE.toByteArray());
                            d.b(FTSAddFriendUI.this.mController.ylL, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent);
                            AppMethodBeat.o(61729);
                            return;
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", e, "", new Object[0]);
                            AppMethodBeat.o(61729);
                            return;
                        }
                    }
                    ((j) g.K(j.class)).a(intent, (but) FTSAddFriendUI.this.lPE.woe.getFirst(), FTSAddFriendUI.this.mIa);
                }
                FTSAddFriendUI.this.mHX = 1;
                FTSAddFriendUI.g(FTSAddFriendUI.this);
            } else {
                switch (i2) {
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                        if (jY == null) {
                            FTSAddFriendUI.this.mHQ.setText(R.string.d7i);
                            break;
                        } else {
                            FTSAddFriendUI.this.mHQ.setText(jY.desc);
                            break;
                        }
                    case -4:
                        if (i != 4) {
                            FTSAddFriendUI.this.mHQ.setText(FTSAddFriendUI.this.getString(R.string.dzs));
                            break;
                        }
                    default:
                        FTSAddFriendUI.this.mHQ.setText(R.string.d7i);
                        break;
                }
                FTSAddFriendUI.this.mHX = -1;
                FTSAddFriendUI.this.mHY = 1;
            }
            FTSAddFriendUI.h(FTSAddFriendUI.this);
            AppMethodBeat.o(61729);
        }
    };
    private long iYa;
    private long ijU;
    private buv lPE;
    private Dialog lud;
    private View mHF;
    private View mHG;
    private View mHH;
    private View mHI;
    private View mHJ;
    private View mHK;
    private View mHL;
    private ImageView mHM;
    private TextView mHN;
    private TextView mHO;
    private TextView mHP;
    private TextView mHQ;
    private TextView mHR;
    private boolean mHS;
    protected boolean mHT;
    private int mHU = 1;
    private FTSLocalPageRelevantView mHV;
    private c mHW;
    private int mHX;
    private int mHY;
    private String mHZ;
    int mIa = -1;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSAddFriendUI() {
        AppMethodBeat.i(61733);
        AppMethodBeat.o(61733);
    }

    static /* synthetic */ void c(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(61749);
        fTSAddFriendUI.bAN();
        AppMethodBeat.o(61749);
    }

    static /* synthetic */ void d(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(61750);
        fTSAddFriendUI.bAO();
        AppMethodBeat.o(61750);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61734);
        super.onCreate(bundle);
        e.mCM = com.tencent.mm.plugin.websearch.api.aa.HP(16);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        setHint(this.mController.ylL.getResources().getString(R.string.b2f));
        this.mHF = findViewById(R.id.bxq);
        this.mHG = findViewById(R.id.bxd);
        this.mHH = findViewById(R.id.bxe);
        this.mHL = findViewById(R.id.bxf);
        this.mHI = findViewById(R.id.bxj);
        this.mHJ = findViewById(R.id.bxl);
        this.mHK = findViewById(R.id.bxm);
        this.mHV = (FTSLocalPageRelevantView) findViewById(R.id.bxp);
        this.mHM = (ImageView) findViewById(R.id.bxg);
        this.mHN = (TextView) findViewById(R.id.bxh);
        this.mHO = (TextView) findViewById(R.id.bxi);
        this.mHP = (TextView) findViewById(R.id.bxn);
        this.mHQ = (TextView) findViewById(R.id.bxk);
        this.mHR = (TextView) findViewById(R.id.bxo);
        try {
            ab.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", ac.adL("webSearchBar").optString("wording"));
            this.mHR.setText(r0);
        } catch (Exception e) {
        }
        this.mController.contentView.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61725);
                FTSAddFriendUI.this.mIr.getFtsEditText().bBo();
                FTSAddFriendUI.this.mIr.getFtsEditText().bBn();
                AppMethodBeat.o(61725);
            }
        }, 128);
        this.mHF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(61726);
                FTSAddFriendUI.this.finish();
                AppMethodBeat.o(61726);
            }
        });
        AppMethodBeat.o(61734);
    }

    public void onResume() {
        AppMethodBeat.i(61735);
        super.onResume();
        com.tencent.mm.plugin.websearch.api.aa.cVe();
        AppMethodBeat.o(61735);
    }

    public void onBackPressed() {
        AppMethodBeat.i(61736);
        finish();
        AppMethodBeat.o(61736);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61737);
        if (this.mHW == null) {
            this.mHW = new c(eVar);
        }
        c cVar = this.mHW;
        AppMethodBeat.o(61737);
        return cVar;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(61738);
        if (aVar instanceof com.tencent.mm.plugin.fts.ui.a.a) {
            if (System.currentTimeMillis() - this.iYa <= 1000) {
                AppMethodBeat.o(61738);
                return;
            } else {
                this.iYa = System.currentTimeMillis();
                Nt(aVar.mDz.mDY);
            }
        }
        AppMethodBeat.o(61738);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(61739);
        super.a(str, str2, list, bVar);
        this.mHS = false;
        AppMethodBeat.o(61739);
    }

    public final int getLayoutId() {
        return R.layout.a11;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.i(61741);
        super.bAM();
        this.mHG.setVisibility(8);
        AppMethodBeat.o(61741);
    }

    /* Access modifiers changed, original: protected|final */
    public final void stopSearch() {
        AppMethodBeat.i(61742);
        super.stopSearch();
        this.mHG.setVisibility(8);
        AppMethodBeat.o(61742);
    }

    private void bAN() {
        AppMethodBeat.i(61743);
        if (bo.nullAsNil(aa.a(this.lPE.wcB)).length() > 0) {
            if (2 == this.lPE.wWh) {
                this.mIa = 15;
            } else if (1 == this.lPE.wWh) {
                this.mIa = 1;
            }
            Intent intent = new Intent();
            ((j) g.K(j.class)).a(intent, this.lPE, this.mIa);
            if (this.mIa == 15 && 2 == this.lPE.wWh) {
                intent.putExtra("Contact_Search_Mobile", this.mHZ);
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(61743);
    }

    public void onDestroy() {
        AppMethodBeat.i(61744);
        super.onDestroy();
        g.Rg().b(106, this.ehi);
        if (this.mHS && !this.mHT) {
            an.l(this.query, this.mHU, 3, 16);
        }
        AppMethodBeat.o(61744);
    }

    private void Nt(String str) {
        AppMethodBeat.i(61745);
        this.mHS = true;
        this.mHT = false;
        this.mHU = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.o(61745);
            return;
        }
        this.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        this.mHX = 0;
        this.mHY = 0;
        g.Rg().a(106, this.ehi);
        final m fVar = new com.tencent.mm.plugin.messenger.a.f(str, 3);
        g.Rg().a(fVar, 0);
        getString(R.string.tz);
        this.lud = h.b((Context) this, getString(R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(61730);
                g.Rg().c(fVar);
                g.Rg().b(106, FTSAddFriendUI.this.ehi);
                FTSAddFriendUI.this.lud = null;
                AppMethodBeat.o(61730);
            }
        });
        AppMethodBeat.o(61745);
    }

    private void bAO() {
        AppMethodBeat.i(61746);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61732);
                if (FTSAddFriendUI.this.lud != null) {
                    FTSAddFriendUI.this.lud.dismiss();
                    FTSAddFriendUI.this.lud = null;
                }
                AppMethodBeat.o(61732);
            }
        });
        AppMethodBeat.o(61746);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(61747);
        super.onClickClearTextBtn(view);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.o(61747);
    }

    public final boolean aMo() {
        AppMethodBeat.i(61740);
        Nt(this.query);
        aqX();
        AppMethodBeat.o(61740);
        return true;
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(61751);
        final aj ajVar = new aj();
        ajVar.cth.context = fTSAddFriendUI;
        ajVar.cth.fromScene = 16;
        ajVar.cth.ctj = fTSAddFriendUI.query;
        ajVar.cth.ctl = false;
        ajVar.cth.title = fTSAddFriendUI.getString(R.string.dzy);
        ajVar.cth.ctk = 1;
        AnonymousClass7 anonymousClass7 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(61731);
                FTSAddFriendUI.d(FTSAddFriendUI.this);
                if (ajVar.cti.ctn) {
                    FTSAddFriendUI.this.mHY = 1;
                } else {
                    FTSAddFriendUI.this.mHY = -1;
                }
                FTSAddFriendUI.h(FTSAddFriendUI.this);
                AppMethodBeat.o(61731);
            }
        };
        ajVar.cth.ctm = anonymousClass7;
        ajVar.cth.action = 1;
        if (!com.tencent.mm.sdk.b.a.xxA.m(ajVar)) {
            ajVar.cti.ctn = false;
            anonymousClass7.run();
        }
        AppMethodBeat.o(61751);
    }

    static /* synthetic */ void h(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.i(61752);
        if (fTSAddFriendUI.mHX == 0 || fTSAddFriendUI.mHY == 0) {
            AppMethodBeat.o(61752);
            return;
        }
        fTSAddFriendUI.bAO();
        if (fTSAddFriendUI.mHX <= 0 || fTSAddFriendUI.mHY >= 0) {
            if (fTSAddFriendUI.mHX > 0) {
                buv buv = fTSAddFriendUI.lPE;
                String a = aa.a(buv.wcB);
                String a2 = aa.a(buv.wyX);
                String str = buv.guQ;
                fTSAddFriendUI.mIn.setVisibility(8);
                fTSAddFriendUI.mHG.setVisibility(0);
                fTSAddFriendUI.mHH.setVisibility(0);
                fTSAddFriendUI.mHL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(61728);
                        if (!bo.isNullOrNil(FTSAddFriendUI.this.query)) {
                            FTSAddFriendUI.this.mHT = true;
                            an.l(FTSAddFriendUI.this.query, FTSAddFriendUI.this.mHU, 1, 16);
                        }
                        FTSAddFriendUI.c(FTSAddFriendUI.this);
                        AppMethodBeat.o(61728);
                    }
                });
                fTSAddFriendUI.mHN.setText(a2);
                fTSAddFriendUI.mHO.setText(str);
                com.tencent.mm.pluginsdk.ui.a.b.b(fTSAddFriendUI.mHM, a);
                fTSAddFriendUI.mHI.setVisibility(8);
                fTSAddFriendUI.mHJ.setVisibility(8);
                fTSAddFriendUI.mHK.setVisibility(8);
                fTSAddFriendUI.mHV.setVisibility(8);
            } else {
                fTSAddFriendUI.mIn.setVisibility(8);
                fTSAddFriendUI.mHG.setVisibility(0);
                fTSAddFriendUI.mHH.setVisibility(8);
                fTSAddFriendUI.mHI.setVisibility(0);
                fTSAddFriendUI.mHJ.setVisibility(8);
                fTSAddFriendUI.mHK.setVisibility(8);
                fTSAddFriendUI.mHV.setVisibility(8);
            }
            if (fTSAddFriendUI.mHY > 0) {
                fTSAddFriendUI.mHJ.setVisibility(0);
                fTSAddFriendUI.mHK.setVisibility(0);
                fTSAddFriendUI.mHP.setText(com.tencent.mm.plugin.fts.a.f.a(fTSAddFriendUI.getString(R.string.c28), "", com.tencent.mm.plugin.fts.a.a.d.b(fTSAddFriendUI.query, fTSAddFriendUI.query)).mDR);
                fTSAddFriendUI.mHU = 2;
                fTSAddFriendUI.mHK.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(61727);
                        FTSAddFriendUI.a(FTSAddFriendUI.this);
                        AppMethodBeat.o(61727);
                    }
                });
                AppMethodBeat.o(61752);
                return;
            }
            fTSAddFriendUI.mHJ.setVisibility(8);
            fTSAddFriendUI.mHK.setVisibility(8);
            fTSAddFriendUI.mHV.setVisibility(8);
            AppMethodBeat.o(61752);
            return;
        }
        fTSAddFriendUI.mHT = true;
        fTSAddFriendUI.bAN();
        AppMethodBeat.o(61752);
    }
}
