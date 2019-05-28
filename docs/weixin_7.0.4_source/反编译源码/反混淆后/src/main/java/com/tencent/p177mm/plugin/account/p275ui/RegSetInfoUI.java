package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C26472s;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.platformtools.C32889i;
import com.tencent.p177mm.platformtools.C45475ag;
import com.tencent.p177mm.platformtools.C45476c;
import com.tencent.p177mm.plugin.account.bind.p271ui.FindMContactAlertUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.FindMContactIntroUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C1990t.C1992b;
import com.tencent.p177mm.plugin.account.friend.p272a.C6717ad;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C4842v.C4843a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI */
public class RegSetInfoUI extends MMActivity implements C1202f {
    private String bCu;
    private ProgressDialog ehJ = null;
    private String elr;
    private C42085ba gBm = new C42085ba();
    private C45476c gCd;
    private String gDy;
    private int gEm;
    private int gEs;
    private int gEu;
    private boolean gFM = false;
    private String gFm;
    private EditText gGu;
    private ProgressBar gHA;
    private String gHB = "";
    private ImageView gHC;
    private View gHD;
    private TextView gHE;
    private String gHF = null;
    private boolean gHG = false;
    private C46633o gHH;
    private View gHI;
    private boolean gHJ = false;
    private String gHK;
    private C7564ap gHL = new C7564ap(Looper.myLooper(), new C99941(), true);
    private EditText gHm;
    private Button gHn;
    private String gHo;
    private String gHp;
    private int gHq;
    private String gHr;
    private String gHs;
    private TextView gHt;
    private View gHu;
    private boolean gHv = false;
    private ImageView gHw;
    private int gHx = 3;
    private LinkedList<String> gHy = new LinkedList();
    private ImageView gHz;
    private SecurityImage gue = null;
    private int sceneType = 0;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$30 */
    class C202930 implements OnFocusChangeListener {
        C202930() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(125535);
            if (z) {
                RegSetInfoUI.this.gHJ = true;
                RegSetInfoUI.this.gHL.mo16770ae(200, 200);
            }
            AppMethodBeat.m2505o(125535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$11 */
    class C999311 implements OnDismissListener {
        C999311() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125517);
            RegSetInfoUI.this.gue = null;
            AppMethodBeat.m2505o(125517);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$1 */
    class C99941 implements C5015a {
        C99941() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            String str;
            AppMethodBeat.m2504i(125507);
            String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
            String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
            if (C5046bo.isNullOrNil(trim) && !C5046bo.isNullOrNil(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (C5046bo.isNullOrNil(trim) || !C5046bo.isNullOrNil(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!C5046bo.isNullOrNil(trim) && RegSetInfoUI.m53972c(RegSetInfoUI.this) && RegSetInfoUI.m53973d(RegSetInfoUI.this)) {
                int e = RegSetInfoUI.m53974e(RegSetInfoUI.this);
                String f = RegSetInfoUI.m53975f(RegSetInfoUI.this);
                C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                C1720g.m3540Rg().mo14541a(new C6717ad(f, RegSetInfoUI.this.elr, e, str, trim, "", ""), 0);
                RegSetInfoUI.this.gHA.setVisibility(0);
            }
            AppMethodBeat.m2505o(125507);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$20 */
    class C999520 implements OnCancelListener {
        C999520() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$31 */
    class C999631 implements TextWatcher {

        /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$31$1 */
        class C99971 implements Runnable {
            C99971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(125536);
                RegSetInfoUI.this.gHm.clearFocus();
                RegSetInfoUI.this.gHm.requestFocus();
                AppMethodBeat.m2505o(125536);
            }
        }

        C999631() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125537);
            if (!RegSetInfoUI.this.gHL.doT()) {
                RegSetInfoUI.this.gHL.stopTimer();
            }
            String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
            if (C5046bo.isNullOrNil(trim)) {
                RegSetInfoUI.this.gHt.setText(RegSetInfoUI.this.getString(C25738R.string.dn5));
                RegSetInfoUI.m53990s(RegSetInfoUI.this);
                if (RegSetInfoUI.this.gHH != null) {
                    RegSetInfoUI.this.gHH.dismiss();
                    RegSetInfoUI.this.gHH = null;
                }
                RegSetInfoUI.this.gHm.postDelayed(new C99971(), 50);
            }
            if (!C5046bo.isNullOrNil(trim) && (RegSetInfoUI.m53972c(RegSetInfoUI.this) || !trim.equals(RegSetInfoUI.this.gHB))) {
                RegSetInfoUI.m53990s(RegSetInfoUI.this);
                RegSetInfoUI.this.gHL.mo16770ae(500, 500);
            }
            RegSetInfoUI.this.gHB = trim;
            AppMethodBeat.m2505o(125537);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$3 */
    class C99983 implements OnEditorActionListener {
        C99983() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125509);
            if (i == 6 || i == 5) {
                RegSetInfoUI.m53987p(RegSetInfoUI.this);
                AppMethodBeat.m2505o(125509);
                return true;
            }
            AppMethodBeat.m2505o(125509);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$25 */
    class C1892525 implements OnClickListener {
        C1892525() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$26 */
    class C1892626 implements OnClickListener {
        C1892626() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125532);
            C42756a.m75796wA("R500_100");
            Intent intent = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
            intent.addFlags(67108864);
            RegSetInfoUI.this.startActivity(intent);
            RegSetInfoUI.this.finish();
            AppMethodBeat.m2505o(125532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$27 */
    class C1892727 implements OnClickListener {
        C1892727() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$28 */
    class C1892828 implements TextWatcher {
        C1892828() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125533);
            String trim = RegSetInfoUI.this.gGu.getText().toString().trim();
            if (trim == null || trim.length() <= 16) {
                if (!RegSetInfoUI.this.gHL.doT()) {
                    RegSetInfoUI.this.gHL.stopTimer();
                }
                RegSetInfoUI.m53984n(RegSetInfoUI.this);
                if (!RegSetInfoUI.this.gHJ) {
                    RegSetInfoUI.this.gHm.setText(trim);
                }
                AppMethodBeat.m2505o(125533);
                return;
            }
            RegSetInfoUI.this.gGu.setText(trim.substring(0, 16));
            AppMethodBeat.m2505o(125533);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$33 */
    class C1892933 implements OnEditorActionListener {
        C1892933() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125539);
            if (i == 6 || i == 5) {
                RegSetInfoUI.m53987p(RegSetInfoUI.this);
                AppMethodBeat.m2505o(125539);
                return true;
            }
            AppMethodBeat.m2505o(125539);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$12 */
    class C2664312 implements Runnable {
        C2664312() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125518);
            RegSetInfoUI.this.gHw.requestFocus();
            RegSetInfoUI.this.gGu.clearFocus();
            AppMethodBeat.m2505o(125518);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$14 */
    class C2664414 implements Runnable {
        C2664414() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125520);
            RegSetInfoUI.this.gHm.clearFocus();
            RegSetInfoUI.this.gHm.requestFocus();
            AppMethodBeat.m2505o(125520);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$2 */
    class C266472 implements OnKeyListener {
        C266472() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125508);
            if (66 == i && keyEvent.getAction() == 0) {
                RegSetInfoUI.m53987p(RegSetInfoUI.this);
                AppMethodBeat.m2505o(125508);
                return true;
            }
            AppMethodBeat.m2505o(125508);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$32 */
    class C2664832 implements OnMenuItemClickListener {
        C2664832() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125538);
            RegSetInfoUI.m53994w(RegSetInfoUI.this);
            AppMethodBeat.m2505o(125538);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$16 */
    class C3301316 implements OnDismissListener {
        C3301316() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125523);
            RegSetInfoUI.this.gue = null;
            AppMethodBeat.m2505o(125523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$22 */
    class C3301622 implements OnClickListener {
        C3301622() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$29 */
    class C3301729 implements View.OnClickListener {
        C3301729() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125534);
            RegSetInfoUI.m53987p(RegSetInfoUI.this);
            AppMethodBeat.m2505o(125534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$5 */
    class C330185 implements View.OnClickListener {
        C330185() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125511);
            RegSetInfoUI.m53995x(RegSetInfoUI.this);
            AppMethodBeat.m2505o(125511);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$23 */
    class C3301923 implements C5002a {
        String gHT;
        Bitmap mBitmap;

        C3301923() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(125528);
            if (!C5046bo.isNullOrNil(this.gHT) && C5046bo.isNullOrNil((RegSetInfoUI.this.gGu.getText()).trim())) {
                RegSetInfoUI.this.gGu.setText(this.gHT);
            }
            if (C1445f.m3070Mn()) {
                if (!(this.mBitmap == null || this.mBitmap.isRecycled() || RegSetInfoUI.this.gFM)) {
                    RegSetInfoUI.this.gHw.setImageBitmap(this.mBitmap);
                    RegSetInfoUI.this.gFM = true;
                    RegSetInfoUI.this.gHC.setVisibility(0);
                }
                AppMethodBeat.m2505o(125528);
                return true;
            }
            C4990ab.m7412e("MiroMsg.RegSetInfoUI", "SDcard is not available");
            AppMethodBeat.m2505o(125528);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(125529);
            try {
                this.gHT = C32889i.m53829cj(RegSetInfoUI.this);
                this.mBitmap = C32889i.m53830ck(RegSetInfoUI.this);
            } catch (Exception e) {
                C4990ab.m7412e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
            }
            if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                try {
                    C5056d.m7625a(this.mBitmap, 100, CompressFormat.PNG, C6457e.euY + "temp.avatar", false);
                } catch (Exception e2) {
                    C4990ab.m7412e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                    C4990ab.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(125529);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(125530);
            String str = super.toString() + "|initView";
            AppMethodBeat.m2505o(125530);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$24 */
    class C3302024 implements OnClickListener {
        C3302024() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125531);
            C42756a.m75796wA("R400_100_signup");
            Intent intent = new Intent(RegSetInfoUI.this, LoginUI.class);
            intent.addFlags(67108864);
            RegSetInfoUI.this.startActivity(intent);
            RegSetInfoUI.this.finish();
            AppMethodBeat.m2505o(125531);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$6 */
    class C330216 implements OnCancelListener {
        C330216() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$19 */
    class C3302619 implements OnClickListener {
        C3302619() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$21 */
    class C3302721 implements OnClickListener {
        C3302721() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent;
            AppMethodBeat.m2504i(125527);
            if (RegSetInfoUI.this.gEs == 2) {
                intent = new Intent(RegSetInfoUI.this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
            } else {
                intent = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
            }
            intent.addFlags(67108864);
            RegSetInfoUI.this.startActivity(intent);
            RegSetInfoUI.this.finish();
            AppMethodBeat.m2505o(125527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$4 */
    class C330284 implements OnKeyListener {
        C330284() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(125510);
            if (66 == i && keyEvent.getAction() == 0) {
                RegSetInfoUI.m53987p(RegSetInfoUI.this);
                AppMethodBeat.m2505o(125510);
                return true;
            }
            AppMethodBeat.m2505o(125510);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RegSetInfoUI() {
        AppMethodBeat.m2504i(125540);
        AppMethodBeat.m2505o(125540);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m53972c(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125556);
        boolean ary = regSetInfoUI.ary();
        AppMethodBeat.m2505o(125556);
        return ary;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m53973d(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125557);
        boolean arB = regSetInfoUI.arB();
        AppMethodBeat.m2505o(125557);
        return arB;
    }

    /* renamed from: e */
    static /* synthetic */ int m53974e(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125558);
        int arH = regSetInfoUI.arH();
        AppMethodBeat.m2505o(125558);
        return arH;
    }

    /* renamed from: f */
    static /* synthetic */ String m53975f(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125559);
        String arI = regSetInfoUI.arI();
        AppMethodBeat.m2505o(125559);
        return arI;
    }

    /* renamed from: n */
    static /* synthetic */ void m53984n(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125560);
        regSetInfoUI.arz();
        AppMethodBeat.m2505o(125560);
    }

    /* renamed from: s */
    static /* synthetic */ void m53990s(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125562);
        regSetInfoUI.m53985o(false, false);
        AppMethodBeat.m2505o(125562);
    }

    /* renamed from: w */
    static /* synthetic */ void m53994w(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125563);
        regSetInfoUI.aoZ();
        AppMethodBeat.m2505o(125563);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125541);
        super.onCreate(bundle);
        String string = getString(C25738R.string.dn6);
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        C24679a.gkF.mo38846BV();
        this.gHo = getIntent().getStringExtra("regsetinfo_user");
        this.gHp = getIntent().getStringExtra("regsetinfo_bind_email");
        this.elr = getIntent().getStringExtra("regsetinfo_ticket");
        this.gHr = getIntent().getStringExtra("regsetinfo_pwd");
        this.gHs = getIntent().getStringExtra("regsetinfo_binduin");
        this.gEm = getIntent().getIntExtra("mobile_check_type", 0);
        if (!C5046bo.isNullOrNil(this.gHs)) {
            this.gHq = C1183p.m2611cB(this.gHs);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.gHv = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.gHx = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.gDy = getIntent().getStringExtra("regsession_id");
        this.gFm = getIntent().getStringExtra("reg_3d_app_ticket");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        initView();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",1").toString());
            C42756a.m75798wz("R200_900_phone");
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R4_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R4_QQ")).append(",1").toString());
            C42756a.m75798wz("R4_QQ");
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_email,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_900_email")).append(",1").toString());
            C42756a.m75798wz("R200_900_email");
        }
        this.gHJ = false;
        this.gCd = new C45476c();
        AppMethodBeat.m2505o(125541);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125542);
        super.onResume();
        this.gGu.postDelayed(new C2664312(), 500);
        AppMethodBeat.m2505o(125542);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125543);
        super.onDestroy();
        StringBuilder stringBuilder;
        if (this.sceneType == 1) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",2").toString());
        } else if (this.sceneType == 2) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R4_QQ,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R4_QQ")).append(",2").toString());
        } else if (this.sceneType == 3) {
            stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_email,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_900_email")).append(",2").toString());
        }
        if (this.gCd != null) {
            this.gCd.close();
        }
        AppMethodBeat.m2505o(125543);
    }

    public final void initView() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(125544);
        this.gHI = findViewById(2131826957);
        this.gHD = findViewById(2131826927);
        this.gHw = (ImageView) findViewById(2131826928);
        this.gGu = (EditText) findViewById(2131826956);
        this.gHE = (TextView) findViewById(2131826955);
        this.gHm = (EditText) findViewById(2131826959);
        this.gHt = (TextView) findViewById(2131826961);
        this.gHu = findViewById(2131826958);
        this.gHz = (ImageView) findViewById(2131826960);
        this.gHA = (ProgressBar) findViewById(2131826908);
        this.gHC = (ImageView) findViewById(2131826929);
        this.gHn = (Button) findViewById(2131822846);
        this.gHz.setVisibility(8);
        this.gHA.setVisibility(8);
        this.gHC.setVisibility(8);
        this.gFM = false;
        this.gHG = false;
        this.gHD.setVisibility(arA() ? 0 : 8);
        View view = this.gHu;
        if (arB()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        TextView textView = this.gHt;
        if (!arB()) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (arA() && arB()) {
            this.gHE.setText(getString(C25738R.string.dn3));
        } else if (arA() && !arB()) {
            this.gHE.setText(getString(C25738R.string.dn1));
        } else if (arA() || !arB()) {
            this.gHE.setText(getString(C25738R.string.dn0));
        } else {
            this.gHE.setText(getString(C25738R.string.dn2));
        }
        C1720g.m3539RS().mo10300a(new C3301923());
        this.gGu.addTextChangedListener(new C1892828());
        this.gHn.setOnClickListener(new C3301729());
        this.gHm.setOnFocusChangeListener(new C202930());
        this.gHm.addTextChangedListener(new C999631());
        setBackBtn(new C2664832());
        this.gGu.setOnEditorActionListener(new C1892933());
        this.gGu.setOnKeyListener(new C266472());
        this.gHm.setOnEditorActionListener(new C99983());
        this.gHm.setOnKeyListener(new C330284());
        this.gHw.setOnClickListener(new C330185());
        C5728b c5728b = new C5728b(C6457e.euY);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        arz();
        AppMethodBeat.m2505o(125544);
    }

    private void arx() {
        C1207m c26472s;
        AppMethodBeat.m2504i(125545);
        int arH = arH();
        C1720g.m3540Rg().mo14539a(126, (C1202f) this);
        if (arB()) {
            int i;
            if (this.gHy == null || this.gHy.size() == 0) {
                i = 0;
            } else if (this.gHy.contains(this.gHK)) {
                i = 1;
            } else {
                i = 2;
            }
            c26472s = new C26472s("", this.gHr, this.bCu, this.gHq, this.gHp, this.gHo, "", "", this.elr, arH, this.gHK, "", "", this.gHv, this.gFM);
            ((C4843a) c26472s.ftU.acF()).vyI.wHX = i;
        } else {
            c26472s = new C26472s("", this.gHr, this.bCu, this.gHq, this.gHp, this.gHo, "", "", this.elr, arH, "", "", "", this.gHv, this.gFM);
        }
        c26472s.mo44236ts(this.gDy);
        c26472s.mo44237tt(this.gFm);
        c26472s.mo44235lX(this.gEm);
        C1720g.m3540Rg().mo14541a(c26472s, 0);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.dmm), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125512);
                C1720g.m3540Rg().mo14547c(c26472s);
                C1720g.m3540Rg().mo14546b(126, RegSetInfoUI.this);
                AppMethodBeat.m2505o(125512);
            }
        });
        AppMethodBeat.m2505o(125545);
    }

    /* renamed from: o */
    private void m53985o(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.m2504i(125546);
        if (C5046bo.isNullOrNil(this.gHm.getText().toString().trim())) {
            z = false;
        }
        this.gHz.setImageResource(z2 ? C25738R.drawable.aon : C25738R.drawable.aok);
        this.gHz.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.gHG = z3;
        AppMethodBeat.m2505o(125546);
    }

    private boolean ary() {
        AppMethodBeat.m2504i(125547);
        if (this.gHz.getVisibility() == 8 || this.gHG) {
            AppMethodBeat.m2505o(125547);
            return true;
        }
        AppMethodBeat.m2505o(125547);
        return false;
    }

    private void arz() {
        AppMethodBeat.m2504i(125548);
        this.gHn.setEnabled(!C5046bo.isNullOrNil(this.gGu.getText().toString().trim()));
        AppMethodBeat.m2505o(125548);
    }

    private boolean arA() {
        return (this.gHx & 1) > 0;
    }

    private boolean arB() {
        return (this.gHx & 2) > 0;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(125549);
        C4990ab.m7417i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null || i != 300) {
            Bitmap a = C24679a.gkF.mo38851a((Activity) this, i, i2, intent);
            if (a != null) {
                this.gHw.setImageBitmap(a);
                this.gFM = true;
                this.gHC.setVisibility(0);
            }
            AppMethodBeat.m2505o(125549);
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
            arx();
        }
        AppMethodBeat.m2505o(125549);
    }

    public final int getLayoutId() {
        return 2130970501;
    }

    private boolean arC() {
        return this.sceneType == 1;
    }

    private boolean arD() {
        return this.sceneType == 2;
    }

    private boolean arE() {
        return this.sceneType == 0;
    }

    private boolean arF() {
        return this.sceneType == 4;
    }

    private boolean arG() {
        return this.sceneType == 3;
    }

    private int arH() {
        AppMethodBeat.m2504i(125550);
        if (arC()) {
            AppMethodBeat.m2505o(125550);
            return 4;
        } else if (arD()) {
            AppMethodBeat.m2505o(125550);
            return 2;
        } else if (arG()) {
            AppMethodBeat.m2505o(125550);
            return 6;
        } else if (arF()) {
            AppMethodBeat.m2505o(125550);
            return 1;
        } else {
            AppMethodBeat.m2505o(125550);
            return 2;
        }
    }

    private String arI() {
        AppMethodBeat.m2504i(125551);
        String str;
        if (arC() || arF()) {
            str = this.gHo;
            AppMethodBeat.m2505o(125551);
            return str;
        } else if (arG()) {
            str = this.gHp;
            AppMethodBeat.m2505o(125551);
            return str;
        } else {
            str = this.gHs;
            AppMethodBeat.m2505o(125551);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int ank;
        C42124a jY;
        final C1207m c1207m2;
        AppMethodBeat.m2504i(125552);
        C4990ab.m7416i("MiroMsg.RegSetInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() == 126) {
            C1720g.m3540Rg().mo14546b(126, (C1202f) this);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i == 0 && i2 == 0) {
                String str2;
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 6;
                this.gBm.ajK();
                this.gHF = null;
                final String arI = arI();
                final String ajy = ((C26472s) c1207m).ajy();
                final int ajz = ((C26472s) c1207m).ajz();
                String str3 = null;
                String str4 = null;
                boolean z = false;
                Map z2 = C5049br.m7595z(((C26472s) c1207m).ajA(), "wording");
                if (z2 != null) {
                    String str5 = (String) z2.get(".wording.switch");
                    if (C5046bo.isNullOrNil(str5)) {
                        z = true;
                    } else {
                        ank = C5046bo.ank(str5);
                        if (ank == 0) {
                            z = false;
                        } else if (ank == 1) {
                            z = true;
                        }
                    }
                    if (z) {
                        str5 = (String) z2.get(".wording.title");
                        if (!C5046bo.isNullOrNil(str5)) {
                            str3 = str5;
                        }
                        str5 = (String) z2.get(".wording.desc");
                        if (C5046bo.isNullOrNil(str5)) {
                            str2 = str3;
                        } else {
                            str4 = str5;
                            str2 = str3;
                        }
                        C4990ab.m7411d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                        C1668a.unhold();
                        C1668a.m3401cm(true);
                        if (this.gFM) {
                            this.elr = ((C26472s) c1207m).ajw();
                            C6665av.fly.mo14897ak("login_user_name", arI);
                            Intent bh;
                            if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                bh = C24679a.gkE.mo38909bh(this);
                                bh.addFlags(67108864);
                                bh.putExtra("LauncherUI.enter_from_reg", true);
                                startActivity(bh);
                                StringBuilder stringBuilder = new StringBuilder();
                                C1720g.m3534RN();
                                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_900_phone,");
                                C1720g.m3534RN();
                                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                finish();
                            } else {
                                C42756a.m75796wA("R300_100_phone");
                                if (z) {
                                    bh = new Intent(this, FindMContactAlertUI.class);
                                    bh.putExtra("alert_title", str2);
                                    bh.putExtra("alert_message", str4);
                                } else {
                                    bh = new Intent(this, FindMContactIntroUI.class);
                                }
                                bh.addFlags(67108864);
                                bh.putExtra("regsetinfo_ticket", this.elr);
                                bh.putExtra("regsetinfo_NextStep", ajy);
                                bh.putExtra("regsetinfo_NextStyle", ajz);
                                Intent bh2 = C24679a.gkE.mo38909bh(this);
                                bh2.addFlags(67108864);
                                bh2.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.m23792b(this, bh, bh2);
                                finish();
                            }
                        } else {
                            String str6 = C6457e.euY + "temp.avatar";
                            str5 = C6457e.euY + "temp.avatar.hd";
                            C5730e.m8623aQ(str6, str5);
                            C5730e.deleteFile(str6);
                            C5056d.m7656c(str5, 96, 96, CompressFormat.JPEG, 90, str6);
                            final C1207m c1207m3 = c1207m;
                            final String str7 = arI;
                            final String str8 = ajy;
                            final boolean z3 = z;
                            final C1207m c1207m4 = c1207m;
                            final String str9 = str2;
                            final String str10 = str4;
                            final int i3 = ajz;
                            new C37439m(this, C6457e.euY + "temp.avatar").mo60329a(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(125513);
                                    RegSetInfoUI.this.elr = ((C26472s) c1207m3).ajw();
                                    C6665av.fly.mo14897ak("login_user_name", str7);
                                    C5730e.deleteFile(C6457e.euY + "temp.avatar");
                                    Intent bh;
                                    if (str8 == null || !str8.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        bh = C24679a.gkE.mo38909bh(RegSetInfoUI.this);
                                        bh.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(bh);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        C1720g.m3534RN();
                                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
                                        C1720g.m3534RN();
                                        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                        RegSetInfoUI.this.finish();
                                        AppMethodBeat.m2505o(125513);
                                        return;
                                    }
                                    C42756a.m75796wA("R300_100_phone");
                                    if (z3) {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        bh.putExtra("alert_title", str2);
                                        bh.putExtra("alert_message", str4);
                                    } else {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    bh.addFlags(67108864);
                                    bh.putExtra("regsetinfo_ticket", RegSetInfoUI.this.elr);
                                    bh.putExtra("regsetinfo_NextStep", str8);
                                    bh.putExtra("regsetinfo_NextStyle", ajz);
                                    Intent bh2 = C24679a.gkE.mo38909bh(RegSetInfoUI.this);
                                    bh2.addFlags(67108864);
                                    MMWizardActivity.m23792b(RegSetInfoUI.this, bh, bh2);
                                    RegSetInfoUI.this.finish();
                                    AppMethodBeat.m2505o(125513);
                                }
                            }, new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(125514);
                                    RegSetInfoUI.this.elr = ((C26472s) c1207m4).ajw();
                                    C6665av.fly.mo14897ak("login_user_name", arI);
                                    Intent bh;
                                    if (ajy == null || !ajy.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                        bh = C24679a.gkE.mo38909bh(RegSetInfoUI.this);
                                        bh.addFlags(67108864);
                                        RegSetInfoUI.this.startActivity(bh);
                                        StringBuilder stringBuilder = new StringBuilder();
                                        C1720g.m3534RN();
                                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(RegSetInfoUI.this.getClass().getName()).append(",R200_900_phone,");
                                        C1720g.m3534RN();
                                        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_900_phone")).append(",4").toString());
                                        RegSetInfoUI.this.finish();
                                        AppMethodBeat.m2505o(125514);
                                        return;
                                    }
                                    C42756a.m75796wA("R300_100_phone");
                                    if (z) {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactAlertUI.class);
                                        bh.putExtra("alert_title", str9);
                                        bh.putExtra("alert_message", str10);
                                    } else {
                                        bh = new Intent(RegSetInfoUI.this, FindMContactIntroUI.class);
                                    }
                                    bh.addFlags(67108864);
                                    bh.putExtra("regsetinfo_ticket", RegSetInfoUI.this.elr);
                                    bh.putExtra("regsetinfo_NextStep", ajy);
                                    bh.putExtra("regsetinfo_NextStyle", i3);
                                    Intent bh2 = C24679a.gkE.mo38909bh(RegSetInfoUI.this);
                                    bh2.addFlags(67108864);
                                    MMWizardActivity.m23792b(RegSetInfoUI.this, bh, bh2);
                                    RegSetInfoUI.this.finish();
                                    AppMethodBeat.m2505o(125514);
                                }
                            });
                        }
                    }
                }
                str2 = null;
                C4990ab.m7411d("MiroMsg.RegSetInfoUI", "mShowStyleContactUploadWordings , %s", r4);
                C1668a.unhold();
                C1668a.m3401cm(true);
                if (this.gFM) {
                }
            }
            if (i2 != -6 && i2 != -311 && i2 != -310) {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this, null, null);
                    AppMethodBeat.m2505o(125552);
                    return;
                } else if (m53979j(i, i2, str)) {
                    AppMethodBeat.m2505o(125552);
                    return;
                }
            } else if (this.gue == null) {
                c1207m2 = c1207m;
                c1207m2 = c1207m;
                this.gue = C15492a.m23811a(this.mController.ylL, 0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(125516);
                        String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
                        if (trim2 == null || trim2.length() <= 0) {
                            C30379h.m48467g(RegSetInfoUI.this, C25738R.string.f0j, C25738R.string.dln);
                            AppMethodBeat.m2505o(125516);
                            return;
                        }
                        int e = RegSetInfoUI.m53974e(RegSetInfoUI.this);
                        C1720g.m3540Rg().mo14539a(126, RegSetInfoUI.this);
                        final C1207m c26472s = new C26472s("", RegSetInfoUI.this.gHr, trim2, RegSetInfoUI.this.gHq, RegSetInfoUI.this.gHp, RegSetInfoUI.this.gHo, "", "", RegSetInfoUI.this.elr, e, trim, ((C26472s) c1207m2).ajn(), RegSetInfoUI.this.gue.getSecImgCode(), RegSetInfoUI.this.gHv, RegSetInfoUI.this.gFM);
                        c26472s.mo44236ts(RegSetInfoUI.this.gDy);
                        c26472s.mo44237tt(RegSetInfoUI.this.gFm);
                        c26472s.mo44235lX(RegSetInfoUI.this.gEm);
                        C1720g.m3540Rg().mo14541a(c26472s, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(C25738R.string.f9238tz);
                        regSetInfoUI.ehJ = C30379h.m48458b(context, RegSetInfoUI.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(125515);
                                C1720g.m3540Rg().mo14547c(c26472s);
                                C1720g.m3540Rg().mo14546b(126, RegSetInfoUI.this);
                                AppMethodBeat.m2505o(125515);
                            }
                        });
                        AppMethodBeat.m2505o(125516);
                    }
                }, null, new C999311(), new C15494b() {
                    public final void apw() {
                        AppMethodBeat.m2504i(125519);
                        RegSetInfoUI.this.aqX();
                        String trim = RegSetInfoUI.this.gHm.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gGu.getText().toString().trim();
                        int e = RegSetInfoUI.m53974e(RegSetInfoUI.this);
                        C1720g.m3540Rg().mo14539a(126, RegSetInfoUI.this);
                        C1207m c26472s = new C26472s("", RegSetInfoUI.this.gHr, trim2, RegSetInfoUI.this.gHq, RegSetInfoUI.this.gHp, RegSetInfoUI.this.gHo, "", "", RegSetInfoUI.this.elr, e, trim, ((C26472s) c1207m2).ajn(), "", RegSetInfoUI.this.gHv, RegSetInfoUI.this.gFM);
                        c26472s.mo44236ts(RegSetInfoUI.this.gDy);
                        c26472s.mo44237tt(RegSetInfoUI.this.gFm);
                        c26472s.mo44235lX(RegSetInfoUI.this.gEm);
                        C1720g.m3540Rg().mo14541a(c26472s, 0);
                        AppMethodBeat.m2505o(125519);
                    }
                });
                AppMethodBeat.m2505o(125552);
                return;
            } else {
                this.gue.mo27573b(0, ((C26472s) c1207m).ajo(), ((C26472s) c1207m).ajn(), "");
                AppMethodBeat.m2505o(125552);
                return;
            }
        }
        if (c1207m.getType() == v2helper.EMethodSetIosMicAbCheckOff) {
            C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetIosMicAbCheckOff, (C1202f) this);
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            this.gHA.setVisibility(8);
            if (i == 0 && i2 == 0) {
                this.gHF = null;
                ank = ((C1992b) ((C6717ad) c1207m).ftU.mo5618ZS()).gvJ.wsP;
                C4990ab.m7411d("MiroMsg.RegSetInfoUI", "UsernameRet %d", Integer.valueOf(ank));
                if (ank == -14 || ank == -10 || ank == -7) {
                    LinkedList linkedList = ((C1992b) ((C6717ad) c1207m).ftU.mo5618ZS()).gvJ.jBw;
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        this.gHt.setText(jY.desc);
                    }
                    this.gHy.clear();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size() > 3 ? 3 : linkedList.size();
                        final String[] strArr = new String[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            strArr[i4] = ((bts) linkedList.get(i4)).wVI;
                            this.gHy.add(strArr[i4]);
                        }
                        if (this.gHJ) {
                            if (this.gHH != null) {
                                this.gHH.dismiss();
                                this.gHH = null;
                            }
                            this.gHH = C18969p.m29542a(this, this.gHI, strArr, new OnItemClickListener() {

                                /* renamed from: com.tencent.mm.plugin.account.ui.RegSetInfoUI$18$1 */
                                class C330151 implements Runnable {
                                    C330151() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(125525);
                                        RegSetInfoUI.this.gHm.clearFocus();
                                        RegSetInfoUI.this.gHm.requestFocus();
                                        AppMethodBeat.m2505o(125525);
                                    }
                                }

                                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                    AppMethodBeat.m2504i(125526);
                                    if (RegSetInfoUI.this.gHH != null) {
                                        RegSetInfoUI.this.gHH.dismiss();
                                        RegSetInfoUI.this.gHH = null;
                                    }
                                    RegSetInfoUI.this.gHm.setText(strArr[i]);
                                    RegSetInfoUI.this.gHm.postDelayed(new C330151(), 50);
                                    RegSetInfoUI.this.gHt.setText(RegSetInfoUI.this.getString(C25738R.string.dn5));
                                    AppMethodBeat.m2505o(125526);
                                }
                            });
                        }
                    }
                    m53985o(true, true);
                    AppMethodBeat.m2505o(125552);
                    return;
                } else if (C5046bo.isNullOrNil(this.gHm.getText().toString().trim())) {
                    m53985o(false, false);
                    AppMethodBeat.m2505o(125552);
                    return;
                } else {
                    m53985o(true, false);
                    this.gHt.setText(getString(C25738R.string.dn5));
                    if (this.gHH != null) {
                        this.gHH.dismiss();
                        this.gHH = null;
                    }
                    this.gHm.postDelayed(new C2664414(), 50);
                    AppMethodBeat.m2505o(125552);
                    return;
                }
            } else if (i2 != -6 && i2 != -311 && i2 != -310) {
                m53985o(true, true);
            } else if (this.gue == null) {
                c1207m2 = c1207m;
                c1207m2 = c1207m;
                this.gue = C15492a.m23811a(this.mController.ylL, 0, ((C6717ad) c1207m).ajo(), ((C6717ad) c1207m).ajn(), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(125522);
                        String trim = RegSetInfoUI.this.gGu.getText().toString().trim();
                        String trim2 = RegSetInfoUI.this.gHm.getText().toString().trim();
                        if (trim == null || trim.length() <= 0) {
                            C30379h.m48467g(RegSetInfoUI.this, C25738R.string.f0j, C25738R.string.dln);
                            AppMethodBeat.m2505o(125522);
                            return;
                        }
                        RegSetInfoUI.this.aqX();
                        int e = RegSetInfoUI.m53974e(RegSetInfoUI.this);
                        String f = RegSetInfoUI.m53975f(RegSetInfoUI.this);
                        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                        final C1207m c6717ad = new C6717ad(f, RegSetInfoUI.this.elr, e, trim, trim2, ((C6717ad) c1207m2).ajn(), RegSetInfoUI.this.gue.getSecImgCode());
                        C1720g.m3540Rg().mo14541a(c6717ad, 0);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        Context context = RegSetInfoUI.this;
                        RegSetInfoUI.this.getString(C25738R.string.f9238tz);
                        regSetInfoUI.ehJ = C30379h.m48458b(context, RegSetInfoUI.this.getString(C25738R.string.dmm), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(125521);
                                C1720g.m3540Rg().mo14547c(c6717ad);
                                C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                                AppMethodBeat.m2505o(125521);
                            }
                        });
                        AppMethodBeat.m2505o(125522);
                    }
                }, null, new C3301316(), new C15494b() {
                    public final void apw() {
                        AppMethodBeat.m2504i(125524);
                        RegSetInfoUI.this.aqX();
                        int e = RegSetInfoUI.m53974e(RegSetInfoUI.this);
                        String f = RegSetInfoUI.m53975f(RegSetInfoUI.this);
                        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                        C1720g.m3540Rg().mo14541a(new C6717ad(f, RegSetInfoUI.this.elr, e, "", "", ((C6717ad) c1207m2).ajn(), ""), 0);
                        AppMethodBeat.m2505o(125524);
                    }
                });
                AppMethodBeat.m2505o(125552);
                return;
            } else {
                this.gue.mo27573b(0, ((C6717ad) c1207m).ajo(), ((C6717ad) c1207m).ajn(), "");
                AppMethodBeat.m2505o(125552);
                return;
            }
        }
        if (m53979j(i, i2, str)) {
            AppMethodBeat.m2505o(125552);
        } else if (i == 8) {
            this.gHF = getString(C25738R.string.bx8, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            Toast.makeText(this, this.gHF, 0).show();
            AppMethodBeat.m2505o(125552);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(C25738R.string.byf, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.m2505o(125552);
        }
    }

    /* renamed from: j */
    private boolean m53979j(int i, int i2, String str) {
        AppMethodBeat.m2504i(125553);
        if (this.gCd.mo73273a(this, new C45475ag(i, i2, str))) {
            AppMethodBeat.m2505o(125553);
            return true;
        } else if (C24679a.gkF.mo38859a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(125553);
            return true;
        } else {
            switch (i2) {
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    String an;
                    C1668a.hold();
                    Context context = this.mController.ylL;
                    C1720g.m3534RN();
                    if (TextUtils.isEmpty(C1668a.m3385QH())) {
                        an = C1338a.m2858an(this.mController.ylL, C25738R.string.cvw);
                    } else {
                        C1720g.m3534RN();
                        an = C1668a.m3385QH();
                    }
                    C30379h.m48439a(context, an, this.mController.ylL.getString(C25738R.string.f9238tz), new C3302619(), new C999520());
                    AppMethodBeat.m2505o(125553);
                    return true;
                case -75:
                    C30379h.m48467g(this, C25738R.string.f8810fn, C25738R.string.djw);
                    AppMethodBeat.m2505o(125553);
                    return true;
                case -48:
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                    } else {
                        C30379h.m48461b((Context) this, getString(C25738R.string.dn4), "", true);
                    }
                    AppMethodBeat.m2505o(125553);
                    return true;
                case -10:
                case -7:
                    C30379h.m48467g(this, C25738R.string.djv, C25738R.string.djw);
                    AppMethodBeat.m2505o(125553);
                    return true;
                default:
                    AppMethodBeat.m2505o(125553);
                    return false;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125554);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(125554);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125554);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(125555);
        aqX();
        if (arC()) {
            C30379h.m48440a((Context) this, getString(C25738R.string.dmy), "", new C3302721(), new C3301622());
            AppMethodBeat.m2505o(125555);
            return;
        }
        if (!arD()) {
            if (arE()) {
                C30379h.m48440a((Context) this, getString(C25738R.string.dmx), "", new C3302024(), new C1892525());
                AppMethodBeat.m2505o(125555);
                return;
            } else if (arG()) {
                C30379h.m48440a((Context) this, getString(C25738R.string.dmx), "", new C1892626(), new C1892727());
                AppMethodBeat.m2505o(125555);
                return;
            } else {
                C42756a.m75796wA("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                startActivity(intent);
                finish();
            }
        }
        AppMethodBeat.m2505o(125555);
    }

    /* renamed from: p */
    static /* synthetic */ void m53987p(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125561);
        regSetInfoUI.bCu = regSetInfoUI.gGu.getText().toString().trim();
        regSetInfoUI.gHK = regSetInfoUI.gHm.getText().toString().trim();
        String charSequence;
        if (C5046bo.isNullOrNil(regSetInfoUI.bCu)) {
            C30379h.m48467g(regSetInfoUI, C25738R.string.f0j, C25738R.string.dln);
            AppMethodBeat.m2505o(125561);
        } else if (regSetInfoUI.gHA.getVisibility() == 0) {
            regSetInfoUI.getString(C25738R.string.f9238tz);
            regSetInfoUI.ehJ = C30379h.m48458b((Context) regSetInfoUI, regSetInfoUI.getString(C25738R.string.dmm), true, new C330216());
            AppMethodBeat.m2505o(125561);
        } else if (regSetInfoUI.ary() && regSetInfoUI.arB() && !C5046bo.isNullOrNil(regSetInfoUI.gHK)) {
            charSequence = regSetInfoUI.gHt.getText().toString();
            if (C5046bo.isNullOrNil(charSequence) || charSequence.equals(regSetInfoUI.getString(C25738R.string.dn5))) {
                if (C5046bo.isNullOrNil(regSetInfoUI.gHF)) {
                    charSequence = regSetInfoUI.getString(C25738R.string.dn8);
                } else {
                    charSequence = regSetInfoUI.gHF;
                }
            }
            C30379h.m48461b((Context) regSetInfoUI, charSequence, "", true);
            AppMethodBeat.m2505o(125561);
        } else {
            boolean z;
            regSetInfoUI.aqX();
            charSequence = C5025av.m7481Ps(regSetInfoUI.gHo);
            C4990ab.m7417i("MiroMsg.RegSetInfoUI", "countryCode %s", charSequence);
            if (C5046bo.isNullOrNil(charSequence) || !C17950b.m28217sP(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (C5046bo.m7510Q(regSetInfoUI.gHo, regSetInfoUI.gDy)) {
                    Intent intent = new Intent(regSetInfoUI, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 2);
                    intent.addFlags(67108864);
                    regSetInfoUI.startActivity(intent);
                    regSetInfoUI.finish();
                    AppMethodBeat.m2505o(125561);
                    return;
                }
                C32921a.m53856b(regSetInfoUI, regSetInfoUI.getString(C25738R.string.g7m, new Object[]{regSetInfoUI.gHo, regSetInfoUI.gDy, C4988aa.dor()}), 300, false);
                AppMethodBeat.m2505o(125561);
                return;
            }
            regSetInfoUI.arx();
            AppMethodBeat.m2505o(125561);
        }
    }

    /* renamed from: x */
    static /* synthetic */ boolean m53995x(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.m2504i(125564);
        boolean o = C24679a.gkF.mo38870o(regSetInfoUI);
        AppMethodBeat.m2505o(125564);
        return o;
    }
}
