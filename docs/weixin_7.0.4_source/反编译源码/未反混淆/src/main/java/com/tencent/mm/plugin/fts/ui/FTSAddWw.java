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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.xweb.util.d;
import java.util.List;

@a(3)
public class FTSAddWw extends FTSBaseUI {
    private String hcl = "";
    private long iYa;
    private String kPJ = "";
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
    int mIa = -1;
    private bvk mIf;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(61776);
        fTSAddWw.bAN();
        AppMethodBeat.o(61776);
    }

    static /* synthetic */ void d(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(61777);
        fTSAddWw.bAO();
        AppMethodBeat.o(61777);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(61760);
        super.onCreate(bundle);
        this.hcl = d.x((System.currentTimeMillis()).getBytes());
        e.mCM = aa.HP(16);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        xE(this.mController.ylL.getResources().getColor(R.color.vy));
        dyb();
        setHint(this.mController.ylL.getResources().getString(R.string.b2m));
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
                AppMethodBeat.i(61753);
                FTSAddWw.this.mIr.getFtsEditText().bBo();
                FTSAddWw.this.mIr.getFtsEditText().bBn();
                AppMethodBeat.o(61753);
            }
        }, 128);
        this.mHF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(61754);
                FTSAddWw.this.finish();
                AppMethodBeat.o(61754);
            }
        });
        AppMethodBeat.o(61760);
    }

    public void onClickBackBtn(View view) {
        AppMethodBeat.i(61761);
        super.onClickBackBtn(view);
        u uVar = new u();
        uVar.eP(this.hcl);
        uVar.cXR = 2;
        uVar.ajK();
        AppMethodBeat.o(61761);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAP() {
        AppMethodBeat.i(61762);
        super.bAP();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(61755);
                u uVar = new u();
                uVar.eP(FTSAddWw.this.hcl);
                uVar.cXR = 2;
                uVar.ajK();
                FTSAddWw.this.finish();
                AppMethodBeat.o(61755);
                return true;
            }
        });
        AppMethodBeat.o(61762);
    }

    public void onResume() {
        AppMethodBeat.i(61763);
        super.onResume();
        aa.cVe();
        AppMethodBeat.o(61763);
    }

    public void onBackPressed() {
        AppMethodBeat.i(61764);
        u uVar = new u();
        uVar.eP(this.hcl);
        uVar.cXR = 2;
        uVar.ajK();
        finish();
        AppMethodBeat.o(61764);
    }

    /* Access modifiers changed, original: protected|final */
    public final d a(e eVar) {
        AppMethodBeat.i(61765);
        if (this.mHW == null) {
            this.mHW = new c(eVar);
        }
        c cVar = this.mHW;
        AppMethodBeat.o(61765);
        return cVar;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(61766);
        if (aVar instanceof com.tencent.mm.plugin.fts.ui.a.a) {
            if (System.currentTimeMillis() - this.iYa <= 1000) {
                AppMethodBeat.o(61766);
                return;
            }
            this.iYa = System.currentTimeMillis();
            this.kPJ = aVar.mDz.mDY;
            Nt(aVar.mDz.mDY);
            u uVar = new u();
            uVar.eP(this.hcl);
            uVar.cXR = 1;
            uVar.ajK();
        }
        AppMethodBeat.o(61766);
    }

    public final void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(61767);
        super.a(str, str2, list, bVar);
        this.mHS = false;
        AppMethodBeat.o(61767);
    }

    public final int getLayoutId() {
        return R.layout.a11;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.i(61769);
        super.bAM();
        this.mHG.setVisibility(8);
        AppMethodBeat.o(61769);
    }

    /* Access modifiers changed, original: protected|final */
    public final void stopSearch() {
        AppMethodBeat.i(61770);
        super.stopSearch();
        u uVar = new u();
        uVar.eP(this.hcl);
        uVar.cXR = 3;
        uVar.ajK();
        this.mHG.setVisibility(8);
        AppMethodBeat.o(61770);
    }

    private void bAN() {
        AppMethodBeat.i(61771);
        String str = this.mIf.jBB;
        if (bo.nullAsNil(str).length() > 0) {
            if (2 == this.mIf.wWh) {
                this.mIa = 15;
            } else if (1 == this.mIf.wWh) {
                this.mIa = 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra(com.tencent.mm.ui.e.b.yfT, this.mIf.wlF);
            if (this.mIa == 15 && 2 == this.mIf.wWh) {
                intent.putExtra("Contact_Search_Mobile", this.kPJ.trim());
            }
            intent.putExtra("key_add_contact_openim_appid", this.mIf.fKh);
            intent.putExtra("Contact_Nick", this.mIf.jCH);
            intent.putExtra("Contact_PyInitial", this.mIf.wbs);
            intent.putExtra("Contact_QuanPin", this.mIf.wbt);
            intent.putExtra("Contact_Sex", this.mIf.guN);
            intent.putExtra("key_add_contact_custom_detail_visible", this.mIf.wWy.wKo);
            intent.putExtra("key_add_contact_custom_detail", this.mIf.wWy.naq);
            intent.putExtra("Contact_Scene", this.mIa);
            intent.putExtra("key_ww_add_session_id", this.hcl);
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.bp.d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(61771);
    }

    public void onDestroy() {
        AppMethodBeat.i(61772);
        super.onDestroy();
        if (this.mHS && !this.mHT) {
            an.l(this.query, this.mHU, 3, 16);
        }
        AppMethodBeat.o(61772);
    }

    private void Nt(String str) {
        AppMethodBeat.i(61773);
        this.mHS = true;
        this.mHT = false;
        this.mHU = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.o(61773);
            return;
        }
        this.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        final f anonymousClass5 = new f() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(61757);
                g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX, (f) this);
                FTSAddWw.d(FTSAddWw.this);
                u uVar;
                if (i == 0 && i2 == 0) {
                    FTSAddWw.this.mIf = ((n) mVar).gfg;
                    FTSAddWw.this.mHX = 1;
                    uVar = new u();
                    uVar.eP(FTSAddWw.this.hcl);
                    uVar.cXR = 0;
                    uVar.cXS = 1;
                    uVar.ajK();
                } else {
                    switch (i2) {
                        case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                            com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                            if (jY == null) {
                                FTSAddWw.this.mHQ.setText(R.string.d7i);
                                break;
                            } else {
                                FTSAddWw.this.mHQ.setText(jY.desc);
                                break;
                            }
                        case -4:
                            if (i != 4) {
                                FTSAddWw.this.mHQ.setText(FTSAddWw.this.getString(R.string.dzs));
                                break;
                            }
                        default:
                            FTSAddWw.this.mHQ.setText(R.string.d7i);
                            break;
                    }
                    FTSAddWw.this.mHX = -1;
                    FTSAddWw.this.mHY = 1;
                    uVar = new u();
                    uVar.eP(FTSAddWw.this.hcl);
                    uVar.cXR = 0;
                    uVar.cXS = 2;
                    uVar.ajK();
                }
                FTSAddWw.g(FTSAddWw.this);
                AppMethodBeat.o(61757);
            }
        };
        this.mHX = 0;
        this.mHY = 0;
        g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX, anonymousClass5);
        final m nVar = new n(str);
        g.Rg().a(nVar, 0);
        getString(R.string.tz);
        this.lud = h.b((Context) this, getString(R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(61758);
                g.Rg().c(nVar);
                g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.b.a.CTRL_INDEX, anonymousClass5);
                FTSAddWw.this.lud = null;
                AppMethodBeat.o(61758);
            }
        });
        AppMethodBeat.o(61773);
    }

    private void bAO() {
        AppMethodBeat.i(61774);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(61759);
                if (FTSAddWw.this.lud != null) {
                    FTSAddWw.this.lud.dismiss();
                    FTSAddWw.this.lud = null;
                }
                AppMethodBeat.o(61759);
            }
        });
        AppMethodBeat.o(61774);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(61775);
        super.onClickClearTextBtn(view);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.o(61775);
    }

    public final boolean aMo() {
        AppMethodBeat.i(61768);
        Nt(this.query);
        aqX();
        AppMethodBeat.o(61768);
        return true;
    }

    static /* synthetic */ void g(FTSAddWw fTSAddWw) {
        AppMethodBeat.i(61778);
        if (fTSAddWw.mHX != 0) {
            fTSAddWw.bAO();
            if (fTSAddWw.mHX > 0) {
                fTSAddWw.mHT = true;
                fTSAddWw.bAN();
                AppMethodBeat.o(61778);
                return;
            } else if (fTSAddWw.mHX > 0) {
                bvk bvk = fTSAddWw.mIf;
                String str = bvk.jBB;
                String str2 = bvk.jCH;
                fTSAddWw.mIn.setVisibility(8);
                fTSAddWw.mHG.setVisibility(0);
                fTSAddWw.mHH.setVisibility(0);
                fTSAddWw.mHL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(61756);
                        if (!bo.isNullOrNil(FTSAddWw.this.query)) {
                            FTSAddWw.this.mHT = true;
                            an.l(FTSAddWw.this.query, FTSAddWw.this.mHU, 1, 16);
                        }
                        FTSAddWw.c(FTSAddWw.this);
                        AppMethodBeat.o(61756);
                    }
                });
                fTSAddWw.mHN.setText(str2);
                fTSAddWw.mHO.setText("");
                com.tencent.mm.pluginsdk.ui.a.b.b(fTSAddWw.mHM, str);
                fTSAddWw.mHI.setVisibility(8);
                fTSAddWw.mHJ.setVisibility(8);
                fTSAddWw.mHK.setVisibility(8);
                fTSAddWw.mHV.setVisibility(8);
                AppMethodBeat.o(61778);
                return;
            } else {
                fTSAddWw.mIn.setVisibility(8);
                fTSAddWw.mHG.setVisibility(0);
                fTSAddWw.mHH.setVisibility(8);
                fTSAddWw.mHI.setVisibility(0);
                fTSAddWw.mHJ.setVisibility(8);
                fTSAddWw.mHK.setVisibility(8);
                fTSAddWw.mHV.setVisibility(8);
            }
        }
        AppMethodBeat.o(61778);
    }
}
