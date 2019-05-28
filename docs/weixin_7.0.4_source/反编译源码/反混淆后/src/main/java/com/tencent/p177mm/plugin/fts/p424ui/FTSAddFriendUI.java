package com.tencent.p177mm.plugin.fts.p424ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C32250j;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45309aj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20866a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSLocalPageRelevantView;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buu;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.IOException;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI */
public class FTSAddFriendUI extends FTSBaseUI {
    private final C1202f ehi = new C208595();
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
    private C16767c mHW;
    private int mHX;
    private int mHY;
    private String mHZ;
    int mIa = -1;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$1 */
    class C208541 implements Runnable {
        C208541() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61725);
            FTSAddFriendUI.this.mIr.getFtsEditText().bBo();
            FTSAddFriendUI.this.mIr.getFtsEditText().bBn();
            AppMethodBeat.m2505o(61725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$2 */
    class C208552 implements OnClickListener {
        C208552() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61726);
            FTSAddFriendUI.this.finish();
            AppMethodBeat.m2505o(61726);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$8 */
    class C208568 implements Runnable {
        C208568() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61732);
            if (FTSAddFriendUI.this.lud != null) {
                FTSAddFriendUI.this.lud.dismiss();
                FTSAddFriendUI.this.lud = null;
            }
            AppMethodBeat.m2505o(61732);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$3 */
    class C208573 implements OnClickListener {
        C208573() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61727);
            FTSAddFriendUI.m32076a(FTSAddFriendUI.this);
            AppMethodBeat.m2505o(61727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$4 */
    class C208584 implements OnClickListener {
        C208584() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61728);
            if (!C5046bo.isNullOrNil(FTSAddFriendUI.this.query)) {
                FTSAddFriendUI.this.mHT = true;
                C14423an.m22656l(FTSAddFriendUI.this.query, FTSAddFriendUI.this.mHU, 1, 16);
            }
            FTSAddFriendUI.m32079c(FTSAddFriendUI.this);
            AppMethodBeat.m2505o(61728);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddFriendUI$5 */
    class C208595 implements C1202f {
        C208595() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(61729);
            C1720g.m3540Rg().mo14546b(106, (C1202f) this);
            FTSAddFriendUI.m32080d(FTSAddFriendUI.this);
            if (i == 0 && i2 == 0) {
                String a;
                FTSAddFriendUI.this.lPE = ((C12518f) c1207m).bOj();
                FTSAddFriendUI fTSAddFriendUI = FTSAddFriendUI.this;
                buu buu = (buu) ((C12518f) c1207m).ehh.fsG.fsP;
                if (buu != null) {
                    a = C1946aa.m4148a(buu.wcB);
                } else {
                    a = "";
                }
                fTSAddFriendUI.mHZ = a;
                if (FTSAddFriendUI.this.lPE.wod > 0) {
                    if (FTSAddFriendUI.this.lPE.woe.isEmpty()) {
                        C30379h.m48433a(FTSAddFriendUI.this, (int) C25738R.string.dzx, 0, true, null);
                        AppMethodBeat.m2505o(61729);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("add_more_friend_search_scene", 3);
                    if (FTSAddFriendUI.this.lPE.woe.size() > 1) {
                        try {
                            intent.putExtra("result", FTSAddFriendUI.this.lPE.toByteArray());
                            C25985d.m41467b(FTSAddFriendUI.this.mController.ylL, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent);
                            AppMethodBeat.m2505o(61729);
                            return;
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSAddFriendUI", e, "", new Object[0]);
                            AppMethodBeat.m2505o(61729);
                            return;
                        }
                    }
                    ((C32250j) C1720g.m3528K(C32250j.class)).mo20991a(intent, (but) FTSAddFriendUI.this.lPE.woe.getFirst(), FTSAddFriendUI.this.mIa);
                }
                FTSAddFriendUI.this.mHX = 1;
                FTSAddFriendUI.m32083g(FTSAddFriendUI.this);
            } else {
                switch (i2) {
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        C42124a jY = C42124a.m74268jY(str);
                        if (jY == null) {
                            FTSAddFriendUI.this.mHQ.setText(C25738R.string.d7i);
                            break;
                        } else {
                            FTSAddFriendUI.this.mHQ.setText(jY.desc);
                            break;
                        }
                    case -4:
                        if (i != 4) {
                            FTSAddFriendUI.this.mHQ.setText(FTSAddFriendUI.this.getString(C25738R.string.dzs));
                            break;
                        }
                    default:
                        FTSAddFriendUI.this.mHQ.setText(C25738R.string.d7i);
                        break;
                }
                FTSAddFriendUI.this.mHX = -1;
                FTSAddFriendUI.this.mHY = 1;
            }
            FTSAddFriendUI.m32084h(FTSAddFriendUI.this);
            AppMethodBeat.m2505o(61729);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FTSAddFriendUI() {
        AppMethodBeat.m2504i(61733);
        AppMethodBeat.m2505o(61733);
    }

    /* renamed from: c */
    static /* synthetic */ void m32079c(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.m2504i(61749);
        fTSAddFriendUI.bAN();
        AppMethodBeat.m2505o(61749);
    }

    /* renamed from: d */
    static /* synthetic */ void m32080d(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.m2504i(61750);
        fTSAddFriendUI.bAO();
        AppMethodBeat.m2505o(61750);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61734);
        super.onCreate(bundle);
        C3163e.mCM = C46400aa.m87299HP(16);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        setHint(this.mController.ylL.getResources().getString(C25738R.string.b2f));
        this.mHF = findViewById(2131824197);
        this.mHG = findViewById(2131824184);
        this.mHH = findViewById(2131824185);
        this.mHL = findViewById(2131824186);
        this.mHI = findViewById(2131824190);
        this.mHJ = findViewById(2131824192);
        this.mHK = findViewById(2131824193);
        this.mHV = (FTSLocalPageRelevantView) findViewById(2131824196);
        this.mHM = (ImageView) findViewById(2131824187);
        this.mHN = (TextView) findViewById(2131824188);
        this.mHO = (TextView) findViewById(2131824189);
        this.mHP = (TextView) findViewById(2131824194);
        this.mHQ = (TextView) findViewById(2131824191);
        this.mHR = (TextView) findViewById(2131824195);
        try {
            C4990ab.m7417i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", C29736ac.adL("webSearchBar").optString("wording"));
            this.mHR.setText(r0);
        } catch (Exception e) {
        }
        this.mController.contentView.postDelayed(new C208541(), 128);
        this.mHF.setOnClickListener(new C208552());
        AppMethodBeat.m2505o(61734);
    }

    public void onResume() {
        AppMethodBeat.m2504i(61735);
        super.onResume();
        C46400aa.cVe();
        AppMethodBeat.m2505o(61735);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(61736);
        finish();
        AppMethodBeat.m2505o(61736);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61737);
        if (this.mHW == null) {
            this.mHW = new C16767c(c28149e);
        }
        C16767c c16767c = this.mHW;
        AppMethodBeat.m2505o(61737);
        return c16767c;
    }

    /* renamed from: a */
    public final void mo7441a(C3154a c3154a) {
        AppMethodBeat.m2504i(61738);
        if (c3154a instanceof C20866a) {
            if (System.currentTimeMillis() - this.iYa <= 1000) {
                AppMethodBeat.m2505o(61738);
                return;
            } else {
                this.iYa = System.currentTimeMillis();
                m32072Nt(c3154a.mDz.mDY);
            }
        }
        AppMethodBeat.m2505o(61738);
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(61739);
        super.mo6403a(str, str2, list, c20890b);
        this.mHS = false;
        AppMethodBeat.m2505o(61739);
    }

    public final int getLayoutId() {
        return 2130969606;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.m2504i(61741);
        super.bAM();
        this.mHG.setVisibility(8);
        AppMethodBeat.m2505o(61741);
    }

    /* Access modifiers changed, original: protected|final */
    public final void stopSearch() {
        AppMethodBeat.m2504i(61742);
        super.stopSearch();
        this.mHG.setVisibility(8);
        AppMethodBeat.m2505o(61742);
    }

    private void bAN() {
        AppMethodBeat.m2504i(61743);
        if (C5046bo.nullAsNil(C1946aa.m4148a(this.lPE.wcB)).length() > 0) {
            if (2 == this.lPE.wWh) {
                this.mIa = 15;
            } else if (1 == this.lPE.wWh) {
                this.mIa = 1;
            }
            Intent intent = new Intent();
            ((C32250j) C1720g.m3528K(C32250j.class)).mo20992a(intent, this.lPE, this.mIa);
            if (this.mIa == 15 && 2 == this.lPE.wWh) {
                intent.putExtra("Contact_Search_Mobile", this.mHZ);
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.m2505o(61743);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61744);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(106, this.ehi);
        if (this.mHS && !this.mHT) {
            C14423an.m22656l(this.query, this.mHU, 3, 16);
        }
        AppMethodBeat.m2505o(61744);
    }

    /* renamed from: Nt */
    private void m32072Nt(String str) {
        AppMethodBeat.m2504i(61745);
        this.mHS = true;
        this.mHT = false;
        this.mHU = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.m2505o(61745);
            return;
        }
        this.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        this.mHX = 0;
        this.mHY = 0;
        C1720g.m3540Rg().mo14539a(106, this.ehi);
        final C1207m c12518f = new C12518f(str, 3);
        C1720g.m3540Rg().mo14541a(c12518f, 0);
        getString(C25738R.string.f9238tz);
        this.lud = C30379h.m48458b((Context) this, getString(C25738R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(61730);
                C1720g.m3540Rg().mo14547c(c12518f);
                C1720g.m3540Rg().mo14546b(106, FTSAddFriendUI.this.ehi);
                FTSAddFriendUI.this.lud = null;
                AppMethodBeat.m2505o(61730);
            }
        });
        AppMethodBeat.m2505o(61745);
    }

    private void bAO() {
        AppMethodBeat.m2504i(61746);
        C5004al.m7441d(new C208568());
        AppMethodBeat.m2505o(61746);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.m2504i(61747);
        super.onClickClearTextBtn(view);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.m2505o(61747);
    }

    public final boolean aMo() {
        AppMethodBeat.m2504i(61740);
        m32072Nt(this.query);
        aqX();
        AppMethodBeat.m2505o(61740);
        return true;
    }

    /* renamed from: g */
    static /* synthetic */ void m32083g(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.m2504i(61751);
        final C45309aj c45309aj = new C45309aj();
        c45309aj.cth.context = fTSAddFriendUI;
        c45309aj.cth.fromScene = 16;
        c45309aj.cth.ctj = fTSAddFriendUI.query;
        c45309aj.cth.ctl = false;
        c45309aj.cth.title = fTSAddFriendUI.getString(C25738R.string.dzy);
        c45309aj.cth.ctk = 1;
        C208617 c208617 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(61731);
                FTSAddFriendUI.m32080d(FTSAddFriendUI.this);
                if (c45309aj.cti.ctn) {
                    FTSAddFriendUI.this.mHY = 1;
                } else {
                    FTSAddFriendUI.this.mHY = -1;
                }
                FTSAddFriendUI.m32084h(FTSAddFriendUI.this);
                AppMethodBeat.m2505o(61731);
            }
        };
        c45309aj.cth.ctm = c208617;
        c45309aj.cth.action = 1;
        if (!C4879a.xxA.mo10055m(c45309aj)) {
            c45309aj.cti.ctn = false;
            c208617.run();
        }
        AppMethodBeat.m2505o(61751);
    }

    /* renamed from: h */
    static /* synthetic */ void m32084h(FTSAddFriendUI fTSAddFriendUI) {
        AppMethodBeat.m2504i(61752);
        if (fTSAddFriendUI.mHX == 0 || fTSAddFriendUI.mHY == 0) {
            AppMethodBeat.m2505o(61752);
            return;
        }
        fTSAddFriendUI.bAO();
        if (fTSAddFriendUI.mHX <= 0 || fTSAddFriendUI.mHY >= 0) {
            if (fTSAddFriendUI.mHX > 0) {
                buv buv = fTSAddFriendUI.lPE;
                String a = C1946aa.m4148a(buv.wcB);
                String a2 = C1946aa.m4148a(buv.wyX);
                String str = buv.guQ;
                fTSAddFriendUI.mIn.setVisibility(8);
                fTSAddFriendUI.mHG.setVisibility(0);
                fTSAddFriendUI.mHH.setVisibility(0);
                fTSAddFriendUI.mHL.setOnClickListener(new C208584());
                fTSAddFriendUI.mHN.setText(a2);
                fTSAddFriendUI.mHO.setText(str);
                C40460b.m69434b(fTSAddFriendUI.mHM, a);
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
                fTSAddFriendUI.mHP.setText(C34204f.m56087a(fTSAddFriendUI.getString(C25738R.string.c28), "", C39127d.m66573b(fTSAddFriendUI.query, fTSAddFriendUI.query)).mDR);
                fTSAddFriendUI.mHU = 2;
                fTSAddFriendUI.mHK.setOnClickListener(new C208573());
                AppMethodBeat.m2505o(61752);
                return;
            }
            fTSAddFriendUI.mHJ.setVisibility(8);
            fTSAddFriendUI.mHK.setVisibility(8);
            fTSAddFriendUI.mHV.setVisibility(8);
            AppMethodBeat.m2505o(61752);
            return;
        }
        fTSAddFriendUI.mHT = true;
        fTSAddFriendUI.bAN();
        AppMethodBeat.m2505o(61752);
    }
}
