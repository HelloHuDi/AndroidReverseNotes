package com.tencent.p177mm.plugin.pwdgroup.p1013ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMScrollGridView;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.pwdgroup.C12867a;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMCallBackScrollView;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMCallBackScrollView.C21512a;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMKeyBoardView;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMKeyBoardView.C21513a;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMPwdInputView;
import com.tencent.p177mm.plugin.pwdgroup.p1013ui.widget.MMPwdInputView.C43395a;
import com.tencent.p177mm.plugin.pwdgroup.p1500a.C34741a;
import com.tencent.p177mm.pluginsdk.model.lbs.Location;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.aan;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.ActUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI */
public class FacingCreateChatRoomAllInOneUI extends MMActivity implements C1202f {
    private C42206a ecy = new C2870616();
    private String elr;
    private ProgressDialog gqo;
    private boolean jIN = false;
    private C7306ak mHandler = new C2871111();
    private boolean nPX;
    private C26443d pqN;
    private boolean pqO = false;
    private boolean pqP;
    private boolean pqQ;
    private boolean pqR;
    private boolean pqS = false;
    private Location pqT;
    private String pqU;
    private MMPwdInputView pqV;
    private View pqW;
    private ProgressBar pqX;
    private TextView pqY;
    private MMKeyBoardView pqZ;
    private OnClickListener prA = new C2871714();
    public C21513a prB = new C2150715();
    private C7564ap prC = new C7564ap(new C1286817(), false);
    private TextView pra;
    private boolean prb = false;
    private boolean prc = false;
    private LinkedList<aan> prd = new LinkedList();
    private HashMap<String, aan> pre = new HashMap();
    private LinkedList<aan> prf = new LinkedList();
    private C28720a prg;
    private View prh;
    private TextView pri;
    private MMScrollGridView prj;
    private View prk;
    private View prl;
    private Button prm;
    private MMCallBackScrollView prn;
    private TextView pro;
    private boolean prp = false;
    private C5004al prq = new C5004al();
    private C7564ap prr = new C7564ap(new C287131(), false);
    private C34741a prs;
    private C34741a prt;
    private int pru;
    private Animation prv;
    private AnimationSet prw;
    private Animation prx;
    public OnMenuItemClickListener pry = new C2871212();
    public C43395a prz = new C2871613();

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$17 */
    class C1286817 implements C5015a {
        C1286817() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(24002);
            FacingCreateChatRoomAllInOneUI.this.pqP = false;
            FacingCreateChatRoomAllInOneUI.m45611a(FacingCreateChatRoomAllInOneUI.this, C21511a.Unknow);
            AppMethodBeat.m2505o(24002);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$15 */
    class C2150715 implements C21513a {
        C2150715() {
        }

        public final void input(String str) {
            AppMethodBeat.m2504i(23997);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                if (FacingCreateChatRoomAllInOneUI.this.pqO || FacingCreateChatRoomAllInOneUI.this.pqS) {
                    MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.pqV;
                    g.axQ();
                    g.input(str);
                    FacingCreateChatRoomAllInOneUI.m45611a(FacingCreateChatRoomAllInOneUI.this, C21511a.Normal);
                    AppMethodBeat.m2505o(23997);
                    return;
                }
                FacingCreateChatRoomAllInOneUI.this.pqV.input(str);
            }
            AppMethodBeat.m2505o(23997);
        }

        public final void axQ() {
            AppMethodBeat.m2504i(23998);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
            }
            AppMethodBeat.m2505o(23998);
        }

        public final void delete() {
            AppMethodBeat.m2504i(23999);
            if (FacingCreateChatRoomAllInOneUI.this.pqV != null) {
                if (FacingCreateChatRoomAllInOneUI.this.pqO || FacingCreateChatRoomAllInOneUI.this.pqS) {
                    FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
                    FacingCreateChatRoomAllInOneUI.m45611a(FacingCreateChatRoomAllInOneUI.this, C21511a.Normal);
                    AppMethodBeat.m2505o(23999);
                    return;
                }
                MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.pqV;
                if (g.mbi > 0) {
                    g.enD.deleteCharAt(g.mbi - 1);
                }
                g.btM();
                g.cbX();
            }
            AppMethodBeat.m2505o(23999);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$5 */
    class C215085 implements OnCancelListener {
        C215085() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(23988);
            FacingCreateChatRoomAllInOneUI.cbW();
            AppMethodBeat.m2505o(23988);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$6 */
    class C215096 implements DialogInterface.OnClickListener {
        C215096() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$a */
    enum C21511a {
        Normal,
        Loading,
        ToSimple,
        Unknow;

        static {
            AppMethodBeat.m2505o(24006);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$16 */
    class C2870616 implements C42206a {

        /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$16$1 */
        class C287071 implements DialogInterface.OnClickListener {
            C287071() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24000);
                C26443d.m42103bX(FacingCreateChatRoomAllInOneUI.this);
                AppMethodBeat.m2505o(24000);
            }
        }

        C2870616() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(24001);
            C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.dhR()) {
                    FacingCreateChatRoomAllInOneUI.this.pqT = location;
                    FacingCreateChatRoomAllInOneUI.this.pqQ = true;
                    FacingCreateChatRoomAllInOneUI.m45617e(FacingCreateChatRoomAllInOneUI.this);
                }
            } else {
                if (!(FacingCreateChatRoomAllInOneUI.this.nPX || C26443d.agA())) {
                    FacingCreateChatRoomAllInOneUI.this.nPX = true;
                    C30379h.m48445a(FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(C25738R.string.c9z), FacingCreateChatRoomAllInOneUI.this.getString(C25738R.string.f9238tz), FacingCreateChatRoomAllInOneUI.this.getString(C25738R.string.ckr), FacingCreateChatRoomAllInOneUI.this.getString(C25738R.string.f9076or), false, new C287071(), null);
                }
                FacingCreateChatRoomAllInOneUI.this.pqQ = false;
            }
            AppMethodBeat.m2505o(24001);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$18 */
    class C2870818 implements DialogInterface.OnClickListener {
        C2870818() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24003);
            FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FacingCreateChatRoomAllInOneUI.this.finish();
            AppMethodBeat.m2505o(24003);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$9 */
    class C287109 implements AnimationListener {
        C287109() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(23991);
            if (FacingCreateChatRoomAllInOneUI.this.pqZ != null) {
                FacingCreateChatRoomAllInOneUI.this.pqZ.setKeyBoardEnable(true);
            }
            AppMethodBeat.m2505o(23991);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$11 */
    class C2871111 extends C7306ak {
        C2871111() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(23993);
            switch (message.what) {
                case 10001:
                    if (FacingCreateChatRoomAllInOneUI.this.prg != null) {
                        FacingCreateChatRoomAllInOneUI.this.prg.setData(FacingCreateChatRoomAllInOneUI.this.prd);
                        AppMethodBeat.m2505o(23993);
                        return;
                    }
                    break;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.m45616d(FacingCreateChatRoomAllInOneUI.this);
                    break;
            }
            AppMethodBeat.m2505o(23993);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$12 */
    class C2871212 implements OnMenuItemClickListener {
        C2871212() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23994);
            FacingCreateChatRoomAllInOneUI.this.finish();
            AppMethodBeat.m2505o(23994);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$1 */
    class C287131 implements C5015a {
        C287131() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(23983);
            FacingCreateChatRoomAllInOneUI.m45610a(FacingCreateChatRoomAllInOneUI.this);
            AppMethodBeat.m2505o(23983);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$2 */
    class C287142 implements DialogInterface.OnClickListener {
        C287142() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23984);
            FacingCreateChatRoomAllInOneUI.this.finish();
            AppMethodBeat.m2505o(23984);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$3 */
    class C287153 implements C21512a {
        C287153() {
        }

        /* renamed from: cm */
        public final void mo36983cm(int i) {
            AppMethodBeat.m2504i(23985);
            if (FacingCreateChatRoomAllInOneUI.this.prl != null) {
                if (i == 0) {
                    FacingCreateChatRoomAllInOneUI.this.prl.setVisibility(4);
                    AppMethodBeat.m2505o(23985);
                    return;
                }
                FacingCreateChatRoomAllInOneUI.this.prl.setVisibility(0);
            }
            AppMethodBeat.m2505o(23985);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$13 */
    class C2871613 implements C43395a {
        C2871613() {
        }

        /* renamed from: o */
        public final void mo46860o(boolean z, String str) {
            AppMethodBeat.m2504i(23995);
            C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", Boolean.valueOf(z), str);
            FacingCreateChatRoomAllInOneUI.this.pqU = str;
            if (z) {
                FacingCreateChatRoomAllInOneUI.this.pqP = true;
                FacingCreateChatRoomAllInOneUI.m45617e(FacingCreateChatRoomAllInOneUI.this);
            }
            AppMethodBeat.m2505o(23995);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$14 */
    class C2871714 implements OnClickListener {
        C2871714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23996);
            FacingCreateChatRoomAllInOneUI.this.prb = false;
            FacingCreateChatRoomAllInOneUI.m45616d(FacingCreateChatRoomAllInOneUI.this);
            AppMethodBeat.m2505o(23996);
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$4 */
    class C287184 implements AnimationListener {
        C287184() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(23986);
            FacingCreateChatRoomAllInOneUI.this.prh.setVisibility(4);
            AppMethodBeat.m2505o(23986);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(23987);
            FacingCreateChatRoomAllInOneUI.this.pro.setVisibility(8);
            FacingCreateChatRoomAllInOneUI.this.pqV.setVisibility(0);
            FacingCreateChatRoomAllInOneUI.this.prj.setVisibility(0);
            FacingCreateChatRoomAllInOneUI.this.prk.setVisibility(0);
            FacingCreateChatRoomAllInOneUI.this.prh.setVisibility(0);
            FacingCreateChatRoomAllInOneUI.this.pqW.setVisibility(8);
            FacingCreateChatRoomAllInOneUI.this.pqZ.setVisibility(8);
            FacingCreateChatRoomAllInOneUI.this.pqV.clearAnimation();
            FacingCreateChatRoomAllInOneUI.this.prj.clearAnimation();
            FacingCreateChatRoomAllInOneUI.this.prh.clearAnimation();
            AppMethodBeat.m2505o(23987);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FacingCreateChatRoomAllInOneUI() {
        AppMethodBeat.m2504i(24007);
        AppMethodBeat.m2505o(24007);
    }

    public final int getLayoutId() {
        return 2130969489;
    }

    private void aps() {
        AppMethodBeat.m2504i(24009);
        this.pqN = C26443d.agz();
        this.pqN.mo44204a(this.ecy, true);
        C9638aw.m17182Rg().mo14539a(653, (C1202f) this);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        initView();
        AppMethodBeat.m2505o(24009);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(24010);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(24010);
            return;
        }
        C4990ab.m7417i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C2870818(), new C287142());
                    break;
                }
                aps();
                AppMethodBeat.m2505o(24010);
                return;
        }
        AppMethodBeat.m2505o(24010);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24011);
        if (this.pqN != null) {
            this.pqN.mo44204a(this.ecy, true);
        }
        if (this.prp) {
            cbT();
        }
        super.onResume();
        AppMethodBeat.m2505o(24011);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24012);
        if (this.pqN != null) {
            this.pqN.mo44208c(this.ecy);
        }
        if (this.prp) {
            cbU();
        }
        super.onPause();
        AppMethodBeat.m2505o(24012);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24013);
        C9638aw.m17182Rg().mo14546b(653, (C1202f) this);
        if (this.pqN != null) {
            this.pqN.mo44208c(this.ecy);
        }
        if (!this.prc) {
            C9638aw.m17182Rg().cancel(653);
            if (this.pqT != null) {
                this.prt = new C34741a(2, this.pqU, "", this.pqT.fBr, this.pqT.fBs, this.pqT.accuracy, this.pqT.cGo, this.pqT.mac, this.pqT.cGq);
                C9638aw.m17182Rg().mo14541a(this.prt, 0);
            }
        }
        if (this.prp) {
            cbU();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(24013);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(24014);
        super.onActivityResult(i, i2, intent);
        if (i == 30764) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    finish();
                    AppMethodBeat.m2505o(24014);
                    return;
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                AppMethodBeat.m2505o(24014);
                return;
            }
            finish();
        }
        AppMethodBeat.m2505o(24014);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(24015);
        setMMTitle((int) C25738R.string.bts);
        setBackBtn(this.pry);
        mo17446xE(getResources().getColor(C25738R.color.a3p));
        this.pqW = findViewById(2131823871);
        this.pqX = (ProgressBar) findViewById(2131823872);
        this.pqY = (TextView) findViewById(2131823873);
        this.pqZ = (MMKeyBoardView) findViewById(2131823874);
        this.pra = (TextView) findViewById(2131823863);
        this.pqV = (MMPwdInputView) findViewById(2131823867);
        this.pqV.setOnFinishInputListener(this.prz);
        this.pqV.requestFocus();
        this.pqZ.setOnInputDeleteListener(this.prB);
        m45609a(C21511a.Normal);
        this.prh = findViewById(2131823868);
        this.pri = (TextView) findViewById(2131823869);
        this.prj = (MMScrollGridView) findViewById(2131823870);
        this.prj.setVisibility(4);
        this.prm = (Button) findViewById(2131823876);
        this.prm.setOnClickListener(this.prA);
        this.prk = findViewById(2131823865);
        this.prl = findViewById(2131823875);
        this.pri.setText(C25738R.string.bmz);
        this.prn = (MMCallBackScrollView) findViewById(2131823864);
        this.pro = (TextView) findViewById(2131823866);
        this.prn.setMMOnScrollListener(new C287153());
        this.prg = new C28720a(this);
        this.prj.setAdapter(this.prg);
        this.prg.setData(this.prd);
        AppMethodBeat.m2505o(24015);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24016);
        C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case 653:
                C34741a c34741a = (C34741a) c1207m;
                int i3 = c34741a.czW;
                if (i3 == 0) {
                    this.pqR = false;
                    if (this.prp) {
                        if (this.prr != null) {
                            this.prr.mo16770ae(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = c34741a.cbS().vEh;
                            this.prq.mo10302aa(new Runnable() {
                                public final void run() {
                                    int size;
                                    int i;
                                    aan aan;
                                    AppMethodBeat.m2504i(23989);
                                    if (FacingCreateChatRoomAllInOneUI.this.prf != null) {
                                        FacingCreateChatRoomAllInOneUI.this.prf.clear();
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pre != null) {
                                        FacingCreateChatRoomAllInOneUI.this.pre.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            aan = (aan) linkedList.get(i);
                                            if (!C5046bo.isNullOrNil(aan.wfK)) {
                                                FacingCreateChatRoomAllInOneUI.this.pre.put(aan.wfK, aan);
                                            }
                                        }
                                    }
                                    size = FacingCreateChatRoomAllInOneUI.this.prd.size();
                                    for (i = 0; i < size; i++) {
                                        aan = (aan) FacingCreateChatRoomAllInOneUI.this.prd.get(i);
                                        if (FacingCreateChatRoomAllInOneUI.this.pre.containsKey(aan.wfK)) {
                                            FacingCreateChatRoomAllInOneUI.this.pre.remove(aan.wfK);
                                        } else {
                                            C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", aan.wfK);
                                        }
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pre != null && FacingCreateChatRoomAllInOneUI.this.pre.size() > 0) {
                                        for (Entry value : FacingCreateChatRoomAllInOneUI.this.pre.entrySet()) {
                                            FacingCreateChatRoomAllInOneUI.this.prf.add((aan) value.getValue());
                                            C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", aan.wfK);
                                        }
                                    }
                                    FacingCreateChatRoomAllInOneUI.this.prd.addAll(FacingCreateChatRoomAllInOneUI.this.prf);
                                    FacingCreateChatRoomAllInOneUI.this.mHandler.sendEmptyMessage(10001);
                                    AppMethodBeat.m2505o(23989);
                                }
                            });
                            this.elr = c34741a.cbS().wdB;
                            AppMethodBeat.m2505o(24016);
                            return;
                        }
                    } else if (i == 0 && i2 == 0) {
                        m45609a(C21511a.Normal);
                        this.pru = this.pra.getHeight();
                        C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", Integer.valueOf(this.pru));
                        this.prv = AnimationUtils.loadAnimation(this, C25738R.anim.f8327ay);
                        this.prx = AnimationUtils.loadAnimation(this, C25738R.anim.f8320ar);
                        this.prw = new AnimationSet(true);
                        this.prw.addAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8390cx));
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.pru));
                        translateAnimation.setDuration(300);
                        this.prw.addAnimation(translateAnimation);
                        this.prv.setDuration(200);
                        this.prw.setDuration(300);
                        this.prx.setDuration(300);
                        this.prv.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prw.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prx.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prw.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.prw.setAnimationListener(new C287184());
                        this.pqV.setVisibility(4);
                        this.pqV.setAnimation(translateAnimation);
                        this.pqZ.startAnimation(this.prv);
                        this.pqW.startAnimation(this.prv);
                        this.pra.startAnimation(this.prv);
                        this.prk.startAnimation(this.prx);
                        this.prh.startAnimation(this.prw);
                        this.prk.setVisibility(4);
                        this.pqZ.setVisibility(8);
                        this.pra.setVisibility(8);
                        this.prp = true;
                        cbT();
                        AppMethodBeat.m2505o(24016);
                        return;
                    } else if (i2 == -431) {
                        this.pqO = true;
                        m45609a(C21511a.ToSimple);
                        AppMethodBeat.m2505o(24016);
                        return;
                    } else {
                        this.pqO = true;
                        m45609a(C21511a.Unknow);
                        AppMethodBeat.m2505o(24016);
                        return;
                    }
                } else if (i3 == 3) {
                    if (!(i == 0 && i2 == 0)) {
                        if (i2 == -431) {
                            m45609a(C21511a.ToSimple);
                            this.pqO = true;
                            AppMethodBeat.m2505o(24016);
                            return;
                        }
                        m45609a(C21511a.Unknow);
                        AppMethodBeat.m2505o(24016);
                        return;
                    }
                } else if (i3 != 1) {
                    bJc();
                    AppMethodBeat.m2505o(24016);
                    return;
                } else if (i == 0 && i2 == 0) {
                    bJc();
                    C4990ab.m7411d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", String.valueOf(c34741a.cbS().vEf));
                    this.prc = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    C12867a.gkE.mo38915d(intent, (Context) this);
                    AppMethodBeat.m2505o(24016);
                    return;
                } else if (i2 == -432 && !this.prb) {
                    this.prb = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    AppMethodBeat.m2505o(24016);
                    return;
                } else if (i2 == -23) {
                    bJc();
                    m45606JN(getString(C25738R.string.bn1));
                    if (this.prr != null) {
                        this.prr.mo16770ae(3000, 3000);
                        AppMethodBeat.m2505o(24016);
                        return;
                    }
                } else {
                    bJc();
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this.mController.ylL, null, null);
                    } else {
                        m45606JN(getString(C25738R.string.dh1));
                    }
                    if (this.prr != null) {
                        this.prr.mo16770ae(3000, 3000);
                    }
                    AppMethodBeat.m2505o(24016);
                    return;
                }
                break;
            default:
                C4990ab.m7420w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                break;
        }
        AppMethodBeat.m2505o(24016);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(24017);
        super.onBackPressed();
        finish();
        AppMethodBeat.m2505o(24017);
    }

    /* renamed from: jU */
    private void m45623jU(boolean z) {
        AppMethodBeat.m2504i(24018);
        if (this.pqZ != null) {
            this.pqZ.setKeyBoardEnable(z);
        }
        AppMethodBeat.m2505o(24018);
    }

    /* renamed from: a */
    private void m45609a(C21511a c21511a) {
        AppMethodBeat.m2504i(24019);
        if (this.pqY != null) {
            switch (c21511a) {
                case Normal:
                    m45623jU(true);
                    this.pqO = false;
                    this.pqS = false;
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(8);
                    AppMethodBeat.m2505o(24019);
                    return;
                case Loading:
                    m45623jU(false);
                    this.pqY.setText(C25738R.string.dh2);
                    this.pqX.setVisibility(0);
                    this.pqY.setVisibility(8);
                    AppMethodBeat.m2505o(24019);
                    return;
                case ToSimple:
                    m45623jU(true);
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(0);
                    this.pqY.setText(C25738R.string.dgz);
                    cbV();
                    AppMethodBeat.m2505o(24019);
                    return;
                case Unknow:
                    m45623jU(true);
                    this.pqX.setVisibility(8);
                    this.pqY.setVisibility(0);
                    this.pqY.setText(C25738R.string.dh1);
                    cbV();
                    AppMethodBeat.m2505o(24019);
                    return;
                default:
                    C4990ab.m7420w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    break;
            }
        }
        AppMethodBeat.m2505o(24019);
    }

    private void bJc() {
        AppMethodBeat.m2504i(24020);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(24020);
    }

    /* renamed from: JN */
    private void m45606JN(String str) {
        AppMethodBeat.m2504i(24021);
        C30379h.m48443a((Context) this, str, "", getString(C25738R.string.f9187s6), new C215096());
        AppMethodBeat.m2505o(24021);
    }

    private void cbT() {
        AppMethodBeat.m2504i(24022);
        this.jIN = false;
        if (this.prr != null) {
            this.prr.mo16770ae(0, 0);
        }
        AppMethodBeat.m2505o(24022);
    }

    private void cbU() {
        AppMethodBeat.m2504i(24023);
        this.jIN = true;
        if (this.prr != null) {
            this.prr.stopTimer();
        }
        C9638aw.m17182Rg().mo14547c(this.prs);
        AppMethodBeat.m2505o(24023);
    }

    private void cbV() {
        AppMethodBeat.m2504i(24024);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C25738R.anim.f8289o);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, C25738R.anim.f8288n);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(23990);
                FacingCreateChatRoomAllInOneUI.this.pqV.axQ();
                FacingCreateChatRoomAllInOneUI.this.pqV.startAnimation(loadAnimation2);
                AppMethodBeat.m2505o(23990);
            }
        });
        loadAnimation2.setAnimationListener(new C287109());
        if (this.pqV != null) {
            this.pqV.startAnimation(loadAnimation);
        }
        if (this.pqZ != null) {
            this.pqZ.setKeyBoardEnable(false);
        }
        AppMethodBeat.m2505o(24024);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24008);
        this.ylm = true;
        super.onCreate(bundle);
        if (!C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            C4990ab.m7417i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
            if (!C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                AppMethodBeat.m2505o(24008);
                return;
            }
        } else if (!C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                C35805b.m58709b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
                AppMethodBeat.m2505o(24008);
                return;
            }
            C32921a.m53856b(this, getString(C25738R.string.g7p, new Object[]{C4988aa.dor()}), 30764, true);
            AppMethodBeat.m2505o(24008);
            return;
        }
        aps();
        AppMethodBeat.m2505o(24008);
    }

    /* renamed from: d */
    static /* synthetic */ void m45616d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.m2504i(24026);
        facingCreateChatRoomAllInOneUI.getString(C25738R.string.f9238tz);
        facingCreateChatRoomAllInOneUI.gqo = C30379h.m48458b((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(C25738R.string.f9260un), true, new C215085());
        facingCreateChatRoomAllInOneUI.cbU();
        C9638aw.m17182Rg().mo14541a(new C34741a(1, facingCreateChatRoomAllInOneUI.pqU, facingCreateChatRoomAllInOneUI.elr, facingCreateChatRoomAllInOneUI.pqT.fBr, facingCreateChatRoomAllInOneUI.pqT.fBs, facingCreateChatRoomAllInOneUI.pqT.accuracy, facingCreateChatRoomAllInOneUI.pqT.cGo, facingCreateChatRoomAllInOneUI.pqT.mac, facingCreateChatRoomAllInOneUI.pqT.cGq), 0);
        AppMethodBeat.m2505o(24026);
    }

    /* renamed from: e */
    static /* synthetic */ void m45617e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.m2504i(24027);
        C4990ab.m7410d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.prC != null) {
            facingCreateChatRoomAllInOneUI.prC.stopTimer();
        }
        if (facingCreateChatRoomAllInOneUI.pqQ) {
            if (facingCreateChatRoomAllInOneUI.pqP) {
                facingCreateChatRoomAllInOneUI.m45609a(C21511a.Loading);
            }
            if (facingCreateChatRoomAllInOneUI.pqQ && facingCreateChatRoomAllInOneUI.pqP && !facingCreateChatRoomAllInOneUI.pqR) {
                C4990ab.m7410d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.pqR = true;
                facingCreateChatRoomAllInOneUI.pqP = false;
                facingCreateChatRoomAllInOneUI.prt = new C34741a(0, facingCreateChatRoomAllInOneUI.pqU, "", facingCreateChatRoomAllInOneUI.pqT.fBr, facingCreateChatRoomAllInOneUI.pqT.fBs, facingCreateChatRoomAllInOneUI.pqT.accuracy, facingCreateChatRoomAllInOneUI.pqT.cGo, facingCreateChatRoomAllInOneUI.pqT.mac, facingCreateChatRoomAllInOneUI.pqT.cGq);
                C9638aw.m17182Rg().mo14541a(facingCreateChatRoomAllInOneUI.prt, 0);
            }
            AppMethodBeat.m2505o(24027);
            return;
        }
        C4990ab.m7420w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.m45609a(C21511a.Loading);
        if (facingCreateChatRoomAllInOneUI.prC != null) {
            facingCreateChatRoomAllInOneUI.prC.mo16770ae(15000, 15000);
        }
        AppMethodBeat.m2505o(24027);
    }

    static /* synthetic */ void cbW() {
        AppMethodBeat.m2504i(24029);
        C9638aw.m17182Rg().cancel(653);
        AppMethodBeat.m2505o(24029);
    }
}
