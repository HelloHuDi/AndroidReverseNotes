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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.openim.p716b.C6700n;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C32678u;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C33251a;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20866a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView.C20890b;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSLocalPageRelevantView;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C29736ac;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.xweb.util.C6037d;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw */
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
    private C16767c mHW;
    private int mHX;
    private int mHY;
    int mIa = -1;
    private bvk mIf;

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$5 */
    class C120595 implements C1202f {
        C120595() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(61757);
            C1720g.m3540Rg().mo14546b((int) C33251a.CTRL_INDEX, (C1202f) this);
            FTSAddWw.m66597d(FTSAddWw.this);
            C32678u c32678u;
            if (i == 0 && i2 == 0) {
                FTSAddWw.this.mIf = ((C6700n) c1207m).gfg;
                FTSAddWw.this.mHX = 1;
                c32678u = new C32678u();
                c32678u.mo53209eP(FTSAddWw.this.hcl);
                c32678u.cXR = 0;
                c32678u.cXS = 1;
                c32678u.ajK();
            } else {
                switch (i2) {
                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                        C42124a jY = C42124a.m74268jY(str);
                        if (jY == null) {
                            FTSAddWw.this.mHQ.setText(C25738R.string.d7i);
                            break;
                        } else {
                            FTSAddWw.this.mHQ.setText(jY.desc);
                            break;
                        }
                    case -4:
                        if (i != 4) {
                            FTSAddWw.this.mHQ.setText(FTSAddWw.this.getString(C25738R.string.dzs));
                            break;
                        }
                    default:
                        FTSAddWw.this.mHQ.setText(C25738R.string.d7i);
                        break;
                }
                FTSAddWw.this.mHX = -1;
                FTSAddWw.this.mHY = 1;
                c32678u = new C32678u();
                c32678u.mo53209eP(FTSAddWw.this.hcl);
                c32678u.cXR = 0;
                c32678u.cXS = 2;
                c32678u.ajK();
            }
            FTSAddWw.m66600g(FTSAddWw.this);
            AppMethodBeat.m2505o(61757);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$7 */
    class C208627 implements Runnable {
        C208627() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61759);
            if (FTSAddWw.this.lud != null) {
                FTSAddWw.this.lud.dismiss();
                FTSAddWw.this.lud = null;
            }
            AppMethodBeat.m2505o(61759);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$4 */
    class C281374 implements OnClickListener {
        C281374() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61756);
            if (!C5046bo.isNullOrNil(FTSAddWw.this.query)) {
                FTSAddWw.this.mHT = true;
                C14423an.m22656l(FTSAddWw.this.query, FTSAddWw.this.mHU, 1, 16);
            }
            FTSAddWw.m66596c(FTSAddWw.this);
            AppMethodBeat.m2505o(61756);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$1 */
    class C391391 implements Runnable {
        C391391() {
        }

        public final void run() {
            AppMethodBeat.m2504i(61753);
            FTSAddWw.this.mIr.getFtsEditText().bBo();
            FTSAddWw.this.mIr.getFtsEditText().bBn();
            AppMethodBeat.m2505o(61753);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$3 */
    class C391403 implements OnMenuItemClickListener {
        C391403() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(61755);
            C32678u c32678u = new C32678u();
            c32678u.mo53209eP(FTSAddWw.this.hcl);
            c32678u.cXR = 2;
            c32678u.ajK();
            FTSAddWw.this.finish();
            AppMethodBeat.m2505o(61755);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.FTSAddWw$2 */
    class C391412 implements OnClickListener {
        C391412() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(61754);
            FTSAddWw.this.finish();
            AppMethodBeat.m2505o(61754);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m66596c(FTSAddWw fTSAddWw) {
        AppMethodBeat.m2504i(61776);
        fTSAddWw.bAN();
        AppMethodBeat.m2505o(61776);
    }

    /* renamed from: d */
    static /* synthetic */ void m66597d(FTSAddWw fTSAddWw) {
        AppMethodBeat.m2504i(61777);
        fTSAddWw.bAO();
        AppMethodBeat.m2505o(61777);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(61760);
        super.onCreate(bundle);
        this.hcl = C6037d.m9506x((System.currentTimeMillis()).getBytes());
        C3163e.mCM = C46400aa.m87299HP(16);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f12206vy));
        dyb();
        setHint(this.mController.ylL.getResources().getString(C25738R.string.b2m));
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
        this.mController.contentView.postDelayed(new C391391(), 128);
        this.mHF.setOnClickListener(new C391412());
        AppMethodBeat.m2505o(61760);
    }

    public void onClickBackBtn(View view) {
        AppMethodBeat.m2504i(61761);
        super.onClickBackBtn(view);
        C32678u c32678u = new C32678u();
        c32678u.mo53209eP(this.hcl);
        c32678u.cXR = 2;
        c32678u.ajK();
        AppMethodBeat.m2505o(61761);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAP() {
        AppMethodBeat.m2504i(61762);
        super.bAP();
        setBackBtn(new C391403());
        AppMethodBeat.m2505o(61762);
    }

    public void onResume() {
        AppMethodBeat.m2504i(61763);
        super.onResume();
        C46400aa.cVe();
        AppMethodBeat.m2505o(61763);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(61764);
        C32678u c32678u = new C32678u();
        c32678u.mo53209eP(this.hcl);
        c32678u.cXR = 2;
        c32678u.ajK();
        finish();
        AppMethodBeat.m2505o(61764);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C12067d mo7440a(C28149e c28149e) {
        AppMethodBeat.m2504i(61765);
        if (this.mHW == null) {
            this.mHW = new C16767c(c28149e);
        }
        C16767c c16767c = this.mHW;
        AppMethodBeat.m2505o(61765);
        return c16767c;
    }

    /* renamed from: a */
    public final void mo7441a(C3154a c3154a) {
        AppMethodBeat.m2504i(61766);
        if (c3154a instanceof C20866a) {
            if (System.currentTimeMillis() - this.iYa <= 1000) {
                AppMethodBeat.m2505o(61766);
                return;
            }
            this.iYa = System.currentTimeMillis();
            this.kPJ = c3154a.mDz.mDY;
            m66591Nt(c3154a.mDz.mDY);
            C32678u c32678u = new C32678u();
            c32678u.mo53209eP(this.hcl);
            c32678u.cXR = 1;
            c32678u.ajK();
        }
        AppMethodBeat.m2505o(61766);
    }

    /* renamed from: a */
    public final void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(61767);
        super.mo6403a(str, str2, list, c20890b);
        this.mHS = false;
        AppMethodBeat.m2505o(61767);
    }

    public final int getLayoutId() {
        return 2130969606;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAM() {
        AppMethodBeat.m2504i(61769);
        super.bAM();
        this.mHG.setVisibility(8);
        AppMethodBeat.m2505o(61769);
    }

    /* Access modifiers changed, original: protected|final */
    public final void stopSearch() {
        AppMethodBeat.m2504i(61770);
        super.stopSearch();
        C32678u c32678u = new C32678u();
        c32678u.mo53209eP(this.hcl);
        c32678u.cXR = 3;
        c32678u.ajK();
        this.mHG.setVisibility(8);
        AppMethodBeat.m2505o(61770);
    }

    private void bAN() {
        AppMethodBeat.m2504i(61771);
        String str = this.mIf.jBB;
        if (C5046bo.nullAsNil(str).length() > 0) {
            if (2 == this.mIf.wWh) {
                this.mIa = 15;
            } else if (1 == this.mIf.wWh) {
                this.mIa = 1;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra(C5495b.yfT, this.mIf.wlF);
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
            C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.m2505o(61771);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(61772);
        super.onDestroy();
        if (this.mHS && !this.mHT) {
            C14423an.m22656l(this.query, this.mHU, 3, 16);
        }
        AppMethodBeat.m2505o(61772);
    }

    /* renamed from: Nt */
    private void m66591Nt(String str) {
        AppMethodBeat.m2504i(61773);
        this.mHS = true;
        this.mHT = false;
        this.mHU = 1;
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            AppMethodBeat.m2505o(61773);
            return;
        }
        this.mIa = Character.isDigit(str.charAt(0)) ? 15 : 3;
        final C1202f c120595 = new C120595();
        this.mHX = 0;
        this.mHY = 0;
        C1720g.m3540Rg().mo14539a((int) C33251a.CTRL_INDEX, c120595);
        final C1207m c6700n = new C6700n(str);
        C1720g.m3540Rg().mo14541a(c6700n, 0);
        getString(C25738R.string.f9238tz);
        this.lud = C30379h.m48458b((Context) this, getString(C25738R.string.dzr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(61758);
                C1720g.m3540Rg().mo14547c(c6700n);
                C1720g.m3540Rg().mo14546b((int) C33251a.CTRL_INDEX, c120595);
                FTSAddWw.this.lud = null;
                AppMethodBeat.m2505o(61758);
            }
        });
        AppMethodBeat.m2505o(61773);
    }

    private void bAO() {
        AppMethodBeat.m2504i(61774);
        C5004al.m7441d(new C208627());
        AppMethodBeat.m2505o(61774);
    }

    public void onClickClearTextBtn(View view) {
        AppMethodBeat.m2504i(61775);
        super.onClickClearTextBtn(view);
        if (!this.mIr.getFtsEditText().mLL.hasFocus()) {
            this.mIr.getFtsEditText().bBo();
            showVKB();
        }
        AppMethodBeat.m2505o(61775);
    }

    public final boolean aMo() {
        AppMethodBeat.m2504i(61768);
        m66591Nt(this.query);
        aqX();
        AppMethodBeat.m2505o(61768);
        return true;
    }

    /* renamed from: g */
    static /* synthetic */ void m66600g(FTSAddWw fTSAddWw) {
        AppMethodBeat.m2504i(61778);
        if (fTSAddWw.mHX != 0) {
            fTSAddWw.bAO();
            if (fTSAddWw.mHX > 0) {
                fTSAddWw.mHT = true;
                fTSAddWw.bAN();
                AppMethodBeat.m2505o(61778);
                return;
            } else if (fTSAddWw.mHX > 0) {
                bvk bvk = fTSAddWw.mIf;
                String str = bvk.jBB;
                String str2 = bvk.jCH;
                fTSAddWw.mIn.setVisibility(8);
                fTSAddWw.mHG.setVisibility(0);
                fTSAddWw.mHH.setVisibility(0);
                fTSAddWw.mHL.setOnClickListener(new C281374());
                fTSAddWw.mHN.setText(str2);
                fTSAddWw.mHO.setText("");
                C40460b.m69434b(fTSAddWw.mHM, str);
                fTSAddWw.mHI.setVisibility(8);
                fTSAddWw.mHJ.setVisibility(8);
                fTSAddWw.mHK.setVisibility(8);
                fTSAddWw.mHV.setVisibility(8);
                AppMethodBeat.m2505o(61778);
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
        AppMethodBeat.m2505o(61778);
    }
}
