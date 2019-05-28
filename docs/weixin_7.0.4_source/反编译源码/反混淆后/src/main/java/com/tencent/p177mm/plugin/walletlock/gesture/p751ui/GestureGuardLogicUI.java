package com.tencent.p177mm.plugin.walletlock.gesture.p751ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsimple.C37951y;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p232b.p233a.C42088bj;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C14393f;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C14394g;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40175b;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C40176d;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C46391e;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.widget.PatternLockView;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.widget.PatternLockView.C29720a;
import com.tencent.p177mm.plugin.walletlock.gesture.p751ui.widget.PatternLockView.C43837b;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40172i;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46388h;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bfo;
import com.tencent.p177mm.protocal.protobuf.bfp;
import com.tencent.p177mm.protocal.protobuf.bil;
import com.tencent.p177mm.protocal.protobuf.bim;
import com.tencent.p177mm.protocal.protobuf.bqz;
import com.tencent.p177mm.protocal.protobuf.bra;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI */
public class GestureGuardLogicUI extends MMActivity implements OnClickListener, C29720a {
    private String gtl = null;
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    private int mStatus;
    private int tVF = 0;
    private int tVG = 0;
    private int tVH = 0;
    private C22725a[] tVI = null;
    private Animation tVJ = null;
    private List<C14393f> tVK = null;
    private List<C14393f> tVL = null;
    private boolean tVM = false;
    private int tVN = 0;
    private C1207m tVO = null;
    private C1207m tVP = null;
    private String tVQ = null;
    private ViewFlipper tVR = null;
    private Dialog tVS = null;
    private boolean tVT = true;
    private boolean tVU = false;
    private String tVV;
    private int tVw = -1;

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$10 */
    class C1439510 implements OnCancelListener {
        C1439510() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51595);
            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
            if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                C1720g.m3540Rg().mo14547c(GestureGuardLogicUI.this.tVP);
            }
            AppMethodBeat.m2505o(51595);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$17 */
    class C1439617 implements DialogInterface.OnClickListener {
        C1439617() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51602);
            dialogInterface.dismiss();
            GestureGuardLogicUI.m58367t(GestureGuardLogicUI.this);
            GestureGuardLogicUI.this.finish();
            AppMethodBeat.m2505o(51602);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$18 */
    class C1439718 implements DialogInterface.OnClickListener {
        C1439718() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51603);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(51603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$21 */
    class C1439821 implements C1224a {
        C1439821() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51606);
            if (i2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9l), 0).show();
                C7060h.pYm.mo8381e(11474, new Object[0]);
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
            }
            GestureGuardLogicUI.this.gtl = null;
            GestureGuardLogicUI.this.tVK = null;
            GestureGuardLogicUI.this.finish();
            AppMethodBeat.m2505o(51606);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$22 */
    class C1439922 implements C1224a {
        C1439922() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51607);
            if (i2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9l), 0).show();
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
            }
            GestureGuardLogicUI.this.tVL = null;
            GestureGuardLogicUI.this.tVK = null;
            GestureGuardLogicUI.this.finish();
            AppMethodBeat.m2505o(51607);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$6 */
    class C144016 implements OnCancelListener {
        C144016() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51591);
            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
            if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                C1720g.m3540Rg().mo14547c(GestureGuardLogicUI.this.tVP);
            }
            AppMethodBeat.m2505o(51591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$a */
    interface C14402a {
        void onDone();
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$24 */
    class C2272324 implements C1224a {
        C2272324() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51609);
            if (i2 == 0) {
                C40176d.m68915lK(SystemClock.elapsedRealtime());
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9l), 0).show();
                GestureGuardLogicUI.m58352e(GestureGuardLogicUI.this);
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
            }
            GestureGuardLogicUI.this.gtl = null;
            GestureGuardLogicUI.this.tVK = null;
            AppMethodBeat.m2505o(51609);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$19 */
    class C2971519 implements DialogInterface.OnClickListener {
        C2971519() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51604);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(51604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$23 */
    class C2971623 implements C1224a {
        C2971623() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51608);
            GestureGuardLogicUI.this.gtl = null;
            GestureGuardLogicUI.this.tVK = null;
            if (i2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9k), 0).show();
                GestureGuardLogicUI.m58341a(GestureGuardLogicUI.this, -1, 0, "open gesture ok");
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
                GestureGuardLogicUI.m58341a(GestureGuardLogicUI.this, -1, -1, "open gesture failed");
            }
            AppMethodBeat.m2505o(51608);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$4 */
    class C297194 implements OnCancelListener {
        C297194() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51589);
            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
            if (!(GestureGuardLogicUI.this.tVO == null || GestureGuardLogicUI.this.tVO.bqV)) {
                C1720g.m3540Rg().mo14547c(GestureGuardLogicUI.this.tVO);
            }
            AppMethodBeat.m2505o(51589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$12 */
    class C3553812 implements C1224a {
        C3553812() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51597);
            if (i2 == 0) {
                C40176d.cTI();
                C40176d.cTC();
                C40176d.cTE();
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9j), 0).show();
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
            }
            GestureGuardLogicUI.this.gtl = null;
            GestureGuardLogicUI.this.tVQ = null;
            GestureGuardLogicUI.this.finish();
            AppMethodBeat.m2505o(51597);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$13 */
    class C3553913 implements OnCancelListener {
        C3553913() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51598);
            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
            if (!(GestureGuardLogicUI.this.tVO == null || GestureGuardLogicUI.this.tVO.bqV)) {
                C1720g.m3540Rg().mo14547c(GestureGuardLogicUI.this.tVO);
            }
            AppMethodBeat.m2505o(51598);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$16 */
    class C3554016 implements DialogInterface.OnClickListener {
        C3554016() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51601);
            dialogInterface.dismiss();
            GestureGuardLogicUI.this.onClick(GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWf);
            AppMethodBeat.m2505o(51601);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$1 */
    class C355441 implements OnMenuItemClickListener {
        C355441() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(51586);
            if (GestureGuardLogicUI.m58346a(GestureGuardLogicUI.this)) {
                AppMethodBeat.m2505o(51586);
            } else {
                GestureGuardLogicUI.m58341a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
                AppMethodBeat.m2505o(51586);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$26 */
    class C3554526 implements C1224a {
        C3554526() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(51612);
            if (i2 == 0) {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c9j), 0).show();
            } else {
                Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c92), 0).show();
            }
            GestureGuardLogicUI.this.tVL = null;
            GestureGuardLogicUI.this.finish();
            AppMethodBeat.m2505o(51612);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$8 */
    class C355468 implements OnCancelListener {
        C355468() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(51593);
            GestureGuardLogicUI.this.tVI[GestureGuardLogicUI.this.tVH].tWe.cTT();
            if (!(GestureGuardLogicUI.this.tVP == null || GestureGuardLogicUI.this.tVP.bqV)) {
                C1720g.m3540Rg().mo14547c(GestureGuardLogicUI.this.tVP);
            }
            AppMethodBeat.m2505o(51593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$20 */
    class C3554720 implements DialogInterface.OnClickListener {
        C3554720() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(51605);
            dialogInterface.dismiss();
            GestureGuardLogicUI.m58367t(GestureGuardLogicUI.this);
            GestureGuardLogicUI.m58341a(GestureGuardLogicUI.this, 0, 4, "user cancel when setting gesture");
            AppMethodBeat.m2505o(51605);
        }
    }

    public GestureGuardLogicUI() {
        AppMethodBeat.m2504i(51614);
        AppMethodBeat.m2505o(51614);
    }

    /* renamed from: a */
    static /* synthetic */ void m58341a(GestureGuardLogicUI gestureGuardLogicUI, int i, int i2, String str) {
        AppMethodBeat.m2504i(51641);
        gestureGuardLogicUI.m58368w(i, i2, str);
        AppMethodBeat.m2505o(51641);
    }

    /* renamed from: e */
    static /* synthetic */ void m58352e(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.m2504i(51642);
        gestureGuardLogicUI.cTL();
        AppMethodBeat.m2505o(51642);
    }

    /* renamed from: g */
    static /* synthetic */ void m58354g(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.m2504i(51643);
        gestureGuardLogicUI.m58347aq(1, true);
        AppMethodBeat.m2505o(51643);
    }

    /* renamed from: h */
    static /* synthetic */ void m58355h(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.m2504i(51644);
        gestureGuardLogicUI.cTK();
        AppMethodBeat.m2505o(51644);
    }

    /* renamed from: k */
    static /* synthetic */ int m58358k(GestureGuardLogicUI gestureGuardLogicUI) {
        int i = gestureGuardLogicUI.tVN + 1;
        gestureGuardLogicUI.tVN = i;
        return i;
    }

    /* renamed from: o */
    static /* synthetic */ void m58362o(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.m2504i(51645);
        gestureGuardLogicUI.aDw();
        AppMethodBeat.m2505o(51645);
    }

    /* renamed from: t */
    static /* synthetic */ void m58367t(GestureGuardLogicUI gestureGuardLogicUI) {
        AppMethodBeat.m2504i(51647);
        gestureGuardLogicUI.cTM();
        AppMethodBeat.m2505o(51647);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(51615);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!C4996ah.getPackageName().equals(intent.getPackage()) || C5046bo.isNullOrNil(intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION)) || C5046bo.isNullOrNil(intent.getStringExtra("next_action"))) {
            C4990ab.m7420w("MicroMsg.GestureGuardLogicUI", "Intent started this activity has no valid action desc.");
            finish();
            AppMethodBeat.m2505o(51615);
            return;
        }
        this.tVR = new ViewFlipper(this);
        this.tVI = new C22725a[]{new C22725a(this), new C22725a(this), new C22725a(this)};
        C22725a[] c22725aArr = this.tVI;
        int length = c22725aArr.length;
        while (i < length) {
            C22725a c22725a = c22725aArr[i];
            this.tVR.addView(c22725a.mView);
            c22725a.tWe.setOnPatternListener(this);
            c22725a.tWf.setOnClickListener(this);
            i++;
        }
        setContentView((View) this.tVR);
        this.gtl = getIntent().getStringExtra("token");
        this.tVQ = getIntent().getStringExtra("type");
        this.tVV = getIntent().getStringExtra("verify_title");
        this.tVw = getIntent().getIntExtra("scene", -1);
        if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
            C46388h.cUc();
        }
        initView();
        AppMethodBeat.m2505o(51615);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARNING: Missing block: B:9:0x003b, code skipped:
            if (r7.tVN == -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        AppMethodBeat.m2504i(51616);
        super.onResume();
        if (this.mStatus == 0) {
            int i;
            C14394g cTD = C40176d.cTD();
            if (cTD.tVD != -1) {
                C46391e.m87260a(cTD);
                if (cTD.tVE / 1000 < 600) {
                    C40176d.m68914ad(cTD.tVD, cTD.tVE);
                    i = 1;
                    if (i != 0) {
                        this.tVN = C40176d.cTH();
                    }
                    this.tVN = 0;
                } else {
                    C40176d.cTE();
                }
            }
            i = 0;
            if (i != 0) {
            }
            this.tVN = 0;
        }
        AppMethodBeat.m2505o(51616);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(51617);
        super.onDestroy();
        if (this.tVO != null) {
            C1720g.m3540Rg().mo14547c(this.tVO);
            this.tVO = null;
        }
        if (this.tVP != null) {
            C1720g.m3540Rg().mo14547c(this.tVP);
            this.tVP = null;
        }
        if (this.tVS != null && this.tVS.isShowing()) {
            this.tVS.dismiss();
        }
        if (this.tVR != null) {
            this.tVR.removeAllViews();
            this.tVR = null;
        }
        for (int i = 0; i < this.tVI.length; i++) {
            C22725a c22725a = this.tVI[i];
            c22725a.tWe.setOnClickListener(null);
            c22725a.tWf.setOnClickListener(null);
            c22725a.mView = null;
            c22725a.tWc = null;
            c22725a.tWd = null;
            c22725a.tWe = null;
            c22725a.tWf = null;
            this.tVI[i] = null;
        }
        this.tVI = null;
        AppMethodBeat.m2505o(51617);
    }

    public final void initView() {
        AppMethodBeat.m2504i(51618);
        aqX();
        setMMSubTitle((int) C25738R.string.g0d);
        this.tVJ = AnimationUtils.loadAnimation(this, C25738R.anim.f8392cz);
        this.tVF = getResources().getColor(C25738R.color.f12066r5);
        this.tVG = getResources().getColor(C25738R.color.f12067r6);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(NativeProtocol.WEB_DIALOG_ACTION);
        intent.getStringExtra("next_action");
        if ("action.switch_on_pattern".equals(stringExtra)) {
            this.mStatus = 16;
            m58347aq(1, false);
        } else if ("action.verify_pattern".equals(stringExtra)) {
            if (C40175b.cTA()) {
                this.tVM = true;
                this.mStatus = 20;
            } else {
                this.tVM = false;
                this.mStatus = 0;
            }
            m58347aq(0, false);
        }
        setBackBtn(new C355441());
        C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("GuestureGuardLogicUI, initView done, before doRestBehavior. mStatus=%d", new Object[]{Integer.valueOf(this.mStatus)}));
        cTK();
        AppMethodBeat.m2505o(51618);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(51619);
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent == null) {
                C4990ab.m7412e("MicroMsg.GestureGuardLogicUI", "hy: Intent data is null.");
                AppMethodBeat.m2505o(51619);
                return;
            }
            int intExtra = intent.getIntExtra("key_err_code", 0);
            if (intExtra == 0) {
                this.gtl = intent.getStringExtra("key_token");
                this.tVQ = intent.getStringExtra("key_type");
                String stringExtra = getIntent().getStringExtra("next_action");
                if ("next_action.goto_protected_page".equals(stringExtra) || "next_action.modify_pattern".equals(stringExtra)) {
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        this.tVU = true;
                    }
                    this.tVT = false;
                    setBackBtn(null);
                    mo17427pP(false);
                    this.mStatus = 16;
                    m58347aq(1, false);
                } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                    String str = this.gtl;
                    final C3553812 c3553812 = new C3553812();
                    m58350c(new C3553913());
                    if (str == null) {
                        aDw();
                        c3553812.mo4496a(3, -6, getString(C25738R.string.c94), null, null);
                    } else {
                        C1196a c1196a = new C1196a();
                        c1196a.fsJ = new bqz();
                        c1196a.fsK = new bra();
                        c1196a.fsI = 688;
                        c1196a.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
                        C7472b acD = c1196a.acD();
                        bqz bqz = (bqz) acD.fsG.fsP;
                        bqz.wTq = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
                        bqz.f16205Cn = 3;
                        C1226w.m2655a(acD, new C1224a() {
                            /* renamed from: a */
                            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                                AppMethodBeat.m2504i(51599);
                                C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                                GestureGuardLogicUI.m58362o(GestureGuardLogicUI.this);
                                if (i == 0 && i2 == 0) {
                                    C40176d.m68911a(((bra) c7472b.fsH.fsP).wJw);
                                    C40171g c40171g = C40171g.tWY;
                                    C40171g.m68900nx(false);
                                    GestureGuardLogicUI.cTQ();
                                }
                                C40172i.tXc.cUf();
                                if (c3553812 != null) {
                                    int a = c3553812.mo4496a(i, i2, str, c7472b, c1207m);
                                    AppMethodBeat.m2505o(51599);
                                    return a;
                                }
                                AppMethodBeat.m2505o(51599);
                                return 0;
                            }
                        }, false);
                    }
                } else {
                    this.mStatus = 1;
                }
                cTK();
                AppMethodBeat.m2505o(51619);
                return;
            } else if (intExtra == -1) {
                Toast.makeText(this, getString(C25738R.string.c92), 0).show();
            }
        }
        AppMethodBeat.m2505o(51619);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(51620);
        if (view.getId() == 2131825012) {
            Intent intent = new Intent();
            intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_paypwd");
            intent.putExtra("key_wallet_lock_type", 1);
            C25985d.m41468b((Context) this, "wallet", ".pwd.ui.WalletLockCheckPwdUI", intent, 1001);
        }
        AppMethodBeat.m2505o(51620);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(51621);
        if (i != 4) {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(51621);
            return onKeyDown;
        } else if (cTJ()) {
            AppMethodBeat.m2505o(51621);
            return false;
        } else {
            m58368w(0, 4, "user cancel when setting gesture");
            AppMethodBeat.m2505o(51621);
            return false;
        }
    }

    /* renamed from: w */
    private void m58368w(int i, int i2, String str) {
        AppMethodBeat.m2504i(51622);
        C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", "alvinluo gesture finishWithResult");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        setResult(i, intent);
        finish();
        AppMethodBeat.m2505o(51622);
    }

    private boolean cTJ() {
        AppMethodBeat.m2504i(51623);
        if (this.mStatus == 20 || this.mStatus == 0 || this.mStatus == 2 || this.mStatus == 1) {
            cTM();
            AppMethodBeat.m2505o(51623);
            return false;
        }
        if (this.tVT) {
            cTP();
        } else {
            cTO();
        }
        AppMethodBeat.m2505o(51623);
        return true;
    }

    private void cTK() {
        AppMethodBeat.m2504i(51624);
        while (true) {
            final C22725a c22725a = this.tVI[this.tVH];
            String stringExtra;
            long elapsedRealtime;
            C42088bj c42088bj;
            switch (this.mStatus) {
                case 0:
                    setMMTitle(getString(C25738R.string.c9f));
                    this.tVM = false;
                    c22725a.tWe.setEnableInput(true);
                    c22725a.tWe.setOnPatternListener(this);
                    if (!"next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        c22725a.tWc.setText(getString(C25738R.string.c9d));
                    } else if (C5046bo.isNullOrNil(this.tVV)) {
                        c22725a.tWc.setText(getString(C25738R.string.c9e));
                    } else {
                        c22725a.tWc.setText(this.tVV);
                    }
                    c22725a.tWc.setTextColor(this.tVF);
                    if (c22725a.tWf.getVisibility() != 0) {
                        c22725a.tWf.setVisibility(0);
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 1:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        c22725a.tWe.cTT();
                        m58347aq(1, true);
                        this.mStatus = 16;
                    } else if ("next_action.switch_off_pattern".equals(stringExtra)) {
                        m58344a(this.tVL, new C3554526());
                        AppMethodBeat.m2505o(51624);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra)) {
                        C40176d.m68915lK(SystemClock.elapsedRealtime());
                        cTL();
                        C46388h.m87250am(this.tVw, 1, 0);
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 2:
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    C40176d.m68914ad(elapsedRealtime, 0);
                    C40176d.m68910HD(this.tVN);
                    C40176d.cTq();
                    if (this.tVN == 5) {
                        this.tVM = true;
                        C40176d.m68913ac(elapsedRealtime, 0);
                        c22725a.tWe.cTT();
                        c22725a.tWe.setEnableInput(false);
                        this.mStatus = 20;
                        cTK();
                        cTN();
                    } else {
                        c22725a.tWe.setEnableInput(false);
                        c22725a.tWe.setDisplayMode(C43837b.Wrong);
                        m58342a(String.format(getResources().getString(C25738R.string.c95), new Object[]{Integer.valueOf(5 - this.tVN)}), new C14402a() {
                            public final void onDone() {
                                AppMethodBeat.m2504i(51613);
                                GestureGuardLogicUI.this.mStatus = 0;
                                c22725a.tWe.cTT();
                                c22725a.tWe.setEnableInput(true);
                                AppMethodBeat.m2505o(51613);
                            }
                        });
                    }
                    C4990ab.m7417i("MicroMsg.GestureGuardLogicUI", "alvinluo nextAction: %s", getIntent().getStringExtra("next_action"));
                    if ("next_action.goto_protected_page".equals(getIntent().getStringExtra("next_action"))) {
                        if (this.tVN != 5) {
                            C46388h.m87250am(this.tVw, 1, 1);
                            break;
                        }
                        C46388h.m87250am(this.tVw, 1, 2);
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 16:
                    stringExtra = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra)) {
                        setMMTitle(getString(C25738R.string.c9g));
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 5;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                    } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                        setMMTitle(getString(C25738R.string.c9h));
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 4;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                    } else {
                        setMMTitle(getString(C25738R.string.c9g));
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 5;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                    }
                    this.tVM = false;
                    c22725a.tWe.setEnableInput(true);
                    c22725a.tWe.setOnPatternListener(this);
                    c22725a.tWc.setText(getString(C25738R.string.c9c));
                    c22725a.tWc.setTextColor(getResources().getColor(C25738R.color.f12066r5));
                    if (c22725a.tWf.getVisibility() != 8) {
                        c22725a.tWf.setVisibility(8);
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 17:
                    c22725a.tWc.setText(getResources().getString(C25738R.string.c9a));
                    c22725a.tWc.setTextColor(this.tVF);
                    c22725a.tWe.cTT();
                    c22725a.tWe.setEnableInput(true);
                    if (c22725a.tWf.getVisibility() != 8) {
                        c22725a.tWf.setVisibility(8);
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 18:
                    String stringExtra2 = getIntent().getStringExtra("next_action");
                    if ("next_action.modify_pattern".equals(stringExtra2)) {
                        if (this.tVU) {
                            this.tVU = false;
                            m58343a(this.gtl, this.tVK, new C1439821());
                            AppMethodBeat.m2505o(51624);
                            return;
                        }
                        m58345a(this.tVL, this.tVK, new C1439922());
                        AppMethodBeat.m2505o(51624);
                        return;
                    } else if ("next_action.switch_on_pattern".equals(stringExtra2)) {
                        m58343a(this.gtl, this.tVK, new C2971623());
                        AppMethodBeat.m2505o(51624);
                        return;
                    } else if ("next_action.goto_protected_page".equals(stringExtra2)) {
                        m58343a(this.gtl, this.tVK, new C2272324());
                        AppMethodBeat.m2505o(51624);
                        return;
                    }
                    break;
                case 19:
                    c22725a.tWe.setEnableInput(false);
                    c22725a.tWe.setDisplayMode(C43837b.Wrong);
                    m58342a(getResources().getString(C25738R.string.c9b), new C14402a() {

                        /* renamed from: com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI$25$1 */
                        class C297181 implements Runnable {
                            C297181() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(51610);
                                GestureGuardLogicUI.this.mHandler.removeCallbacks(this);
                                c22725a.tWe.cTT();
                                GestureGuardLogicUI.this.mStatus = 16;
                                GestureGuardLogicUI.m58354g(GestureGuardLogicUI.this);
                                GestureGuardLogicUI.m58355h(GestureGuardLogicUI.this);
                                AppMethodBeat.m2505o(51610);
                            }
                        }

                        public final void onDone() {
                            AppMethodBeat.m2504i(51611);
                            GestureGuardLogicUI.this.mHandler.postDelayed(new C297181(), 500);
                            AppMethodBeat.m2505o(51611);
                        }
                    });
                    AppMethodBeat.m2505o(51624);
                    return;
                case 20:
                    setMMTitle(getString(C25738R.string.c9f));
                    setMMTitle(getString(C25738R.string.c9g));
                    if (this.tVw == 1) {
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 8;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                    } else if (this.tVw == 2) {
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 10;
                        c42088bj.dcm = 1;
                        c42088bj.ajK();
                    }
                    this.tVM = true;
                    c22725a.tWe.setEnableInput(false);
                    c22725a.tWe.setOnPatternListener(null);
                    elapsedRealtime = (long) Math.ceil(((double) (600 - (C40176d.cTB().tVE / 1000))) / 60.0d);
                    c22725a.tWc.setText(String.format(getString(C25738R.string.c99), new Object[]{Long.valueOf(elapsedRealtime)}));
                    c22725a.tWc.setTextColor(getResources().getColor(C25738R.color.f12067r6));
                    AppMethodBeat.m2505o(51624);
                    return;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(51624);
    }

    /* renamed from: a */
    public final void mo47953a(final PatternLockView patternLockView, final List<C14393f> list) {
        int i = 1;
        AppMethodBeat.m2504i(51625);
        if (this.mStatus == 16) {
            if (list.size() < 4) {
                patternLockView.setEnableInput(false);
                patternLockView.setDisplayMode(C43837b.Wrong);
                m58342a(String.format(getString(C25738R.string.c96), new Object[]{Integer.valueOf(4)}), new C14402a() {
                    public final void onDone() {
                        AppMethodBeat.m2504i(51587);
                        patternLockView.cTT();
                        patternLockView.setEnableInput(true);
                        AppMethodBeat.m2505o(51587);
                    }
                });
                AppMethodBeat.m2505o(51625);
                return;
            }
            this.tVK = list;
            patternLockView.cTT();
            this.mStatus = 17;
            m58347aq(2, true);
        } else if (this.mStatus == 0) {
            final C227243 c227243 = new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(51588);
                    if (i2 == 0) {
                        GestureGuardLogicUI.this.tVM = false;
                        GestureGuardLogicUI.this.tVN = 0;
                        C40176d.cTI();
                        C40176d.cTC();
                        C40176d.cTE();
                        GestureGuardLogicUI.this.tVL = list;
                        GestureGuardLogicUI.this.mStatus = 1;
                        GestureGuardLogicUI.m58355h(GestureGuardLogicUI.this);
                    } else if (i2 == -3) {
                        GestureGuardLogicUI.m58358k(GestureGuardLogicUI.this);
                        GestureGuardLogicUI.this.mStatus = 2;
                        GestureGuardLogicUI.m58355h(GestureGuardLogicUI.this);
                    } else {
                        Toast.makeText(GestureGuardLogicUI.this, GestureGuardLogicUI.this.getString(C25738R.string.c93), 0).show();
                    }
                    AppMethodBeat.m2505o(51588);
                    return 0;
                }
            };
            bim cTG = C40176d.cTG();
            bil cTF = C40176d.cTF();
            C7060h.pYm.mo8381e(11453, new Object[0]);
            m58350c(new C144016());
            boolean z = C46391e.m87261b(cTF) ? C46391e.m87262b(cTG) ? cTF.version < cTG.wLR : false : true;
            C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("isInfoValid:%b, isBuffValid:%b, verify by server:%b", new Object[]{Boolean.valueOf(C46391e.m87262b(cTG)), Boolean.valueOf(C46391e.m87261b(cTF)), Boolean.valueOf(z)}));
            if (z) {
                C1196a c1196a = new C1196a();
                c1196a.fsJ = new bfo();
                c1196a.fsK = new bfp();
                c1196a.fsI = 689;
                c1196a.uri = "/cgi-bin/micromsg-bin/oppatternlock";
                C7472b acD = c1196a.acD();
                bfo bfo = (bfo) acD.fsG.fsP;
                bfo.f4413Cn = 2;
                bfo.wJu = new SKBuiltinBuffer_t().setBuffer(C46391e.m87265dX(list));
                C1226w.m2655a(acD, new C1224a() {
                    /* renamed from: a */
                    public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                        AppMethodBeat.m2504i(51592);
                        C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("Scene verifyPattern, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                        GestureGuardLogicUI.m58362o(GestureGuardLogicUI.this);
                        if (i == 0 && i2 == 0) {
                            C40176d.m68911a(((bfp) c7472b.fsH.fsP).wJw);
                            C42088bj c42088bj;
                            if (GestureGuardLogicUI.this.mStatus != 0) {
                                String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                                if ("next_action.modify_pattern".equals(stringExtra)) {
                                    c42088bj = new C42088bj();
                                    c42088bj.cVT = 5;
                                    c42088bj.dcm = 2;
                                    c42088bj.ajK();
                                } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                                    c42088bj = new C42088bj();
                                    c42088bj.cVT = 4;
                                    c42088bj.dcm = 2;
                                    c42088bj.ajK();
                                } else {
                                    c42088bj = new C42088bj();
                                    c42088bj.cVT = 5;
                                    c42088bj.dcm = 2;
                                    c42088bj.ajK();
                                }
                            } else if (GestureGuardLogicUI.this.tVw == 1) {
                                c42088bj = new C42088bj();
                                c42088bj.cVT = 8;
                                c42088bj.dcm = 2;
                                c42088bj.ajK();
                            } else if (GestureGuardLogicUI.this.tVw == 2) {
                                c42088bj = new C42088bj();
                                c42088bj.cVT = 10;
                                c42088bj.dcm = 2;
                                c42088bj.ajK();
                            }
                        }
                        if (c227243 != null) {
                            int a = c227243.mo4496a(i, i2, str, c7472b, c1207m);
                            AppMethodBeat.m2505o(51592);
                            return a;
                        }
                        AppMethodBeat.m2505o(51592);
                        return 0;
                    }
                }, false);
                AppMethodBeat.m2505o(51625);
                return;
            }
            aDw();
            bil cTF2 = C40176d.cTF();
            if (cTF2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder.append(new C1183p(C1668a.m3383QF()).longValue());
                stringBuilder.append('_');
                stringBuilder.append(new String(C46391e.m87265dX(list)));
                i = new String(cTF2.wLO.getBufferToBytes()).equals(C1178g.m2591x(stringBuilder.toString().getBytes()));
            }
            if (i != 0) {
                c227243.mo4496a(3, 0, null, null, null);
                AppMethodBeat.m2505o(51625);
                return;
            }
            c227243.mo4496a(3, -3, null, null, null);
            AppMethodBeat.m2505o(51625);
            return;
        } else {
            if (this.mStatus == 17) {
                if (this.tVK.equals(list)) {
                    patternLockView.cTT();
                    this.tVM = false;
                    this.tVN = 0;
                    C40176d.cTI();
                    C40176d.cTC();
                    C40176d.cTE();
                    C40176d.cTq();
                    this.mStatus = 18;
                } else {
                    this.mStatus = 19;
                }
            }
            AppMethodBeat.m2505o(51625);
        }
        cTK();
        AppMethodBeat.m2505o(51625);
    }

    /* renamed from: a */
    private void m58343a(String str, List<C14393f> list, final C1224a c1224a) {
        AppMethodBeat.m2504i(51626);
        m58350c(new C297194());
        if (str == null) {
            aDw();
            c1224a.mo4496a(3, -6, getString(C25738R.string.c94), null, null);
            AppMethodBeat.m2505o(51626);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bqz();
        c1196a.fsK = new bra();
        c1196a.fsI = 688;
        c1196a.uri = "/cgi-bin/micromsg-bin/registernewpatternlock";
        C7472b acD = c1196a.acD();
        bqz bqz = (bqz) acD.fsG.fsP;
        bqz.wTq = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
        bqz.wTr = new SKBuiltinBuffer_t().setBuffer(C46391e.m87265dX(list));
        C1226w.m2655a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(51590);
                C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.m58362o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    C40176d.m68911a(((bra) c7472b.fsH.fsP).wJw);
                    GestureGuardLogicUI.cTQ();
                    ((C40167b) C1720g.m3528K(C40167b.class)).mo38285HB(1);
                }
                C40172i.tXc.cUf();
                if (c1224a != null) {
                    int a = c1224a.mo4496a(i, i2, str, c7472b, c1207m);
                    AppMethodBeat.m2505o(51590);
                    return a;
                }
                AppMethodBeat.m2505o(51590);
                return 0;
            }
        }, false);
        AppMethodBeat.m2505o(51626);
    }

    /* renamed from: a */
    private void m58345a(List<C14393f> list, List<C14393f> list2, final C1224a c1224a) {
        AppMethodBeat.m2504i(51627);
        C1196a c1196a = new C1196a();
        m58350c(new C355468());
        c1196a.fsJ = new bfo();
        c1196a.fsK = new bfp();
        c1196a.fsI = 689;
        c1196a.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        C7472b acD = c1196a.acD();
        bfo bfo = (bfo) acD.fsG.fsP;
        bfo.f4413Cn = 1;
        bfo.wJu = new SKBuiltinBuffer_t().setBuffer(C46391e.m87265dX(list));
        bfo.wJv = new SKBuiltinBuffer_t().setBuffer(C46391e.m87265dX(list2));
        C1226w.m2655a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(51594);
                C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("Scene doModify, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.m58362o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    C40176d.m68911a(((bfp) c7472b.fsH.fsP).wJw);
                    GestureGuardLogicUI.cTQ();
                    C42088bj c42088bj;
                    if (GestureGuardLogicUI.this.mStatus != 0) {
                        String stringExtra = GestureGuardLogicUI.this.getIntent().getStringExtra("next_action");
                        if ("next_action.modify_pattern".equals(stringExtra)) {
                            c42088bj = new C42088bj();
                            c42088bj.cVT = 5;
                            c42088bj.dcm = 2;
                            c42088bj.ajK();
                        } else if ("next_action.switch_on_pattern".equals(stringExtra)) {
                            c42088bj = new C42088bj();
                            c42088bj.cVT = 4;
                            c42088bj.dcm = 2;
                            c42088bj.ajK();
                        } else {
                            c42088bj = new C42088bj();
                            c42088bj.cVT = 5;
                            c42088bj.dcm = 2;
                            c42088bj.ajK();
                        }
                    } else if (GestureGuardLogicUI.this.tVw == 1) {
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 8;
                        c42088bj.dcm = 2;
                        c42088bj.ajK();
                    } else if (GestureGuardLogicUI.this.tVw == 2) {
                        c42088bj = new C42088bj();
                        c42088bj.cVT = 10;
                        c42088bj.dcm = 2;
                        c42088bj.ajK();
                    }
                }
                C40172i.tXc.cUf();
                if (c1224a != null) {
                    int a = c1224a.mo4496a(i, i2, str, c7472b, c1207m);
                    AppMethodBeat.m2505o(51594);
                    return a;
                }
                AppMethodBeat.m2505o(51594);
                return 0;
            }
        }, false);
        AppMethodBeat.m2505o(51627);
    }

    /* renamed from: a */
    private void m58344a(List<C14393f> list, final C1224a c1224a) {
        AppMethodBeat.m2504i(51628);
        m58350c(new C1439510());
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bfo();
        c1196a.fsK = new bfp();
        c1196a.fsI = 689;
        c1196a.uri = "/cgi-bin/micromsg-bin/oppatternlock";
        C7472b acD = c1196a.acD();
        bfo bfo = (bfo) acD.fsG.fsP;
        bfo.f4413Cn = 3;
        bfo.wJu = new SKBuiltinBuffer_t().setBuffer(C46391e.m87265dX(list));
        C1226w.m2655a(acD, new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(51596);
                C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOff, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
                GestureGuardLogicUI.m58362o(GestureGuardLogicUI.this);
                if (i == 0 && i2 == 0) {
                    C40176d.m68911a(((bfp) c7472b.fsH.fsP).wJw);
                    C40171g c40171g = C40171g.tWY;
                    C40171g.m68900nx(false);
                    GestureGuardLogicUI.this.tVM = false;
                    GestureGuardLogicUI.cTQ();
                }
                if (c1224a != null) {
                    int a = c1224a.mo4496a(i, i2, str, c7472b, c1207m);
                    AppMethodBeat.m2505o(51596);
                    return a;
                }
                AppMethodBeat.m2505o(51596);
                return 0;
            }
        }, false);
        AppMethodBeat.m2505o(51628);
    }

    private void cTL() {
        AppMethodBeat.m2504i(51629);
        Intent intent = (Intent) getIntent().getParcelableExtra("page_intent");
        if (intent != null) {
            C40172i.tXc.mo63515nB(true);
            C40172i.tXc.mo63516nC(true);
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            startActivity(intent);
        } else {
            C4990ab.m7416i("MicroMsg.GestureGuardLogicUI", "Protected page's intent not found, finish myself only.");
        }
        finish();
        AppMethodBeat.m2505o(51629);
    }

    private void cTM() {
        AppMethodBeat.m2504i(51630);
        String stringExtra = getIntent().getStringExtra("next_action");
        if (this.mStatus == 20 || "next_action.goto_protected_page".equals(stringExtra)) {
            C40172i.tXc.cUg();
        }
        AppMethodBeat.m2505o(51630);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.m2504i(51631);
        C22725a c22725a = this.tVI[this.tVH];
        if (c22725a.tWe != null) {
            PatternLockView patternLockView = c22725a.tWe;
            boolean z2 = z && !this.tVM;
            patternLockView.setEnableInput(z2);
        }
        AppMethodBeat.m2503at(this, z);
        AppMethodBeat.m2505o(51631);
    }

    /* renamed from: a */
    public final void mo47952a(PatternLockView patternLockView) {
        AppMethodBeat.m2504i(51632);
        patternLockView.setDisplayMode(C43837b.Correct);
        AppMethodBeat.m2505o(51632);
    }

    /* renamed from: aq */
    private void m58347aq(int i, boolean z) {
        AppMethodBeat.m2504i(51633);
        int i2 = i - this.tVH;
        if (i2 == 0) {
            AppMethodBeat.m2505o(51633);
            return;
        }
        this.tVH = i;
        if (!z) {
            this.tVR.setInAnimation(null);
            this.tVR.setOutAnimation(null);
        } else if (i2 > 0) {
            this.tVR.setInAnimation(this, C25738R.anim.f8403df);
            this.tVR.setOutAnimation(this, C25738R.anim.f8402dc);
        } else {
            this.tVR.setInAnimation(this, C25738R.anim.f8401db);
            this.tVR.setOutAnimation(this, C25738R.anim.f8404dg);
        }
        if (i2 > 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.tVR.showNext();
            }
            AppMethodBeat.m2505o(51633);
            return;
        }
        while (i2 < 0) {
            this.tVR.showPrevious();
            i2++;
        }
        AppMethodBeat.m2505o(51633);
    }

    /* renamed from: a */
    private void m58342a(String str, final C14402a c14402a) {
        AppMethodBeat.m2504i(51634);
        TextView textView = this.tVI[this.tVH].tWc;
        textView.getText().toString();
        textView.setText(str);
        textView.setTextColor(this.tVG);
        textView.startAnimation(this.tVJ);
        this.tVJ.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(51600);
                GestureGuardLogicUI.this.tVJ.setAnimationListener(null);
                if (c14402a != null) {
                    c14402a.onDone();
                }
                AppMethodBeat.m2505o(51600);
            }
        });
        AppMethodBeat.m2505o(51634);
    }

    private void cTN() {
        AppMethodBeat.m2504i(51635);
        C5652a c5652a = new C5652a(this);
        c5652a.mo11482rc(false).asE(String.format(getString(C25738R.string.c8y), new Object[]{Long.valueOf(10)}));
        c5652a.mo11453Qc(C25738R.string.c8u).mo11457a(new C3554016());
        c5652a.mo11454Qd(C25738R.string.c8t).mo11476b(new C1439617());
        c5652a.aMb().show();
        AppMethodBeat.m2505o(51635);
    }

    private void cTO() {
        AppMethodBeat.m2504i(51636);
        new C5652a(this).mo11482rc(true).mo11450PZ(C25738R.string.c91).mo11453Qc(C25738R.string.c8w).mo11457a(new C1439718()).aMb().show();
        AppMethodBeat.m2505o(51636);
    }

    private void cTP() {
        AppMethodBeat.m2504i(51637);
        String stringExtra = getIntent().getStringExtra("next_action");
        if ("next_action.modify_pattern".equals(stringExtra) || !"next_action.switch_on_pattern".equals(stringExtra)) {
            stringExtra = getString(C25738R.string.c8z);
        } else {
            stringExtra = getString(C25738R.string.c90);
        }
        new C5652a(this).mo11482rc(false).asE(stringExtra).mo11453Qc(C25738R.string.c8x).mo11457a(new C3554720()).mo11454Qd(C25738R.string.c8v).mo11476b(new C2971519()).aMb().show();
        AppMethodBeat.m2505o(51637);
    }

    /* renamed from: c */
    private void m58350c(OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(51638);
        if (this.tVS == null) {
            this.tVS = C30379h.m48458b((Context) this, getString(C25738R.string.c97), false, onCancelListener);
            AppMethodBeat.m2505o(51638);
            return;
        }
        this.tVS.show();
        AppMethodBeat.m2505o(51638);
    }

    private void aDw() {
        AppMethodBeat.m2504i(51639);
        if (this.tVS != null && this.tVS.isShowing()) {
            this.tVS.dismiss();
        }
        AppMethodBeat.m2505o(51639);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void cTQ() {
        AppMethodBeat.m2504i(51646);
        C37951y.m64164b(C1853r.m3846Yz(), 9, "PatternLockUpdate", "");
        C7060h.pYm.mo8381e(11473, new Object[0]);
        AppMethodBeat.m2505o(51646);
    }
}
