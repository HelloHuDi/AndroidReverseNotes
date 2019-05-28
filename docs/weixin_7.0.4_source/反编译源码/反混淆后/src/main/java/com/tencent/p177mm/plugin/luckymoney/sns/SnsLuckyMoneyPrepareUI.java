package com.tencent.p177mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.luckymoney.model.C12426ao;
import com.tencent.p177mm.plugin.luckymoney.model.C21198ar;
import com.tencent.p177mm.plugin.luckymoney.model.C21200i;
import com.tencent.p177mm.plugin.luckymoney.model.C3381ag;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C12472g;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C21249h.C21253c;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43281b;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyCanShareListUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyIndexUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyMoneyInputView;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyMyRecordUI;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyNumInputView;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyTextInputView;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI */
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements C12472g {
    private C7564ap gGo = null;
    protected Dialog gII = null;
    private ScrollView hJh;
    protected TextView kGm = null;
    private TextView kGq;
    protected Button leS = null;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private C21200i nSs;
    protected LuckyMoneyNumInputView nTd = null;
    protected LuckyMoneyTextInputView nTf = null;
    protected Button nTg = null;
    protected View nTi;
    private TextView nTl;
    private C43281b nTn = new C43281b();
    protected LuckyMoneyMoneyInputView obC = null;
    private View obD;
    private View obE;
    private ViewGroup obF;
    private int obG;
    private String obH;
    private int obI;
    private boolean obJ;
    private String obK;
    private int obL;
    private C40947a obM;

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$16 */
    class C1678016 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$16$1 */
        class C167811 implements OnCancelListener {
            C167811() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(42525);
                if (SnsLuckyMoneyPrepareUI.this.gII != null && SnsLuckyMoneyPrepareUI.this.gII.isShowing()) {
                    SnsLuckyMoneyPrepareUI.this.gII.hide();
                }
                if (SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                    SnsLuckyMoneyPrepareUI.this.finish();
                }
                SnsLuckyMoneyPrepareUI.this.ocz.bLz();
                AppMethodBeat.m2505o(42525);
            }
        }

        C1678016() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42526);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.m25862d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4));
            if (SnsLuckyMoneyPrepareUI.this.obC.bKW() != 0) {
                C23639t.makeText(SnsLuckyMoneyPrepareUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                AppMethodBeat.m2505o(42526);
                return;
            }
            long H;
            C1207m c12426ao;
            int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
            double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
            long j = 0;
            if (SnsLuckyMoneyPrepareUI.this.mType == 1) {
                H = C36391e.m59973H(input2);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(356354, Integer.valueOf(input));
            } else {
                H = C36391e.m59973H(((double) input) * input2);
                j = C36391e.m59973H(input2);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(356353, Integer.valueOf(input));
            }
            String input3 = SnsLuckyMoneyPrepareUI.this.nTf.getInput();
            if (C5046bo.isNullOrNil(input3)) {
                input3 = SnsLuckyMoneyPrepareUI.this.getString(C25738R.string.cqe);
            }
            String stringExtra = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
            if (!SnsLuckyMoneyPrepareUI.this.obJ || C5046bo.isNullOrNil(stringExtra)) {
                c12426ao = new C12426ao(input, H, j, SnsLuckyMoneyPrepareUI.this.mType, input3, C46063x.bLC(), null, null, C1853r.m3846Yz(), C1853r.m3820YB(), SnsLuckyMoneyPrepareUI.this.obG, "");
            } else {
                c12426ao = new C12426ao(input, H, j, SnsLuckyMoneyPrepareUI.this.mType, input3, C46063x.bLC(), stringExtra, C46063x.m85824mI(stringExtra), C1853r.m3846Yz(), C1853r.m3820YB(), SnsLuckyMoneyPrepareUI.this.obG, "");
            }
            SnsLuckyMoneyPrepareUI.this.mo24301b(c12426ao, false);
            if (SnsLuckyMoneyPrepareUI.this.gII != null) {
                SnsLuckyMoneyPrepareUI.this.gII.show();
                AppMethodBeat.m2505o(42526);
                return;
            }
            SnsLuckyMoneyPrepareUI.this.gII = C30901g.m49317a(SnsLuckyMoneyPrepareUI.this.mController.ylL, true, new C167811());
            AppMethodBeat.m2505o(42526);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$17 */
    class C1678217 implements C5015a {
        C1678217() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            double d;
            AppMethodBeat.m2504i(42527);
            if (SnsLuckyMoneyPrepareUI.this.obC.bKW() == 3 || SnsLuckyMoneyPrepareUI.this.nTd.bKW() == 3) {
                d = 0.0d;
            } else {
                int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                d = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                if (SnsLuckyMoneyPrepareUI.this.mType == 0) {
                    d *= (double) input;
                }
            }
            if (d == 0.0d || d > SnsLuckyMoneyPrepareUI.this.nSs.nRR || SnsLuckyMoneyPrepareUI.this.nTn.bMz()) {
                SnsLuckyMoneyPrepareUI.this.nTg.setClickable(false);
                SnsLuckyMoneyPrepareUI.this.nTg.setEnabled(false);
            } else {
                SnsLuckyMoneyPrepareUI.this.nTg.setClickable(true);
                SnsLuckyMoneyPrepareUI.this.nTg.setEnabled(true);
            }
            C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + SnsLuckyMoneyPrepareUI.this.nTn.bMz());
            SnsLuckyMoneyPrepareUI.this.gGo.doT();
            AppMethodBeat.m2505o(42527);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$18 */
    class C1678318 implements OnTouchListener {
        C1678318() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42528);
            if (motionEvent.getAction() == 0) {
                SnsLuckyMoneyPrepareUI.this.aoB();
                SnsLuckyMoneyPrepareUI.this.aqX();
            }
            AppMethodBeat.m2505o(42528);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$4 */
    class C167844 implements DialogInterface.OnClickListener {
        C167844() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$5 */
    class C167855 implements OnClickListener {
        C167855() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42511);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.m25862d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9));
            Intent intent = new Intent();
            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyCanShareListUI.class);
            SnsLuckyMoneyPrepareUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42511);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$3 */
    class C167903 implements DialogInterface.OnClickListener {
        C167903() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42510);
            Intent intent = new Intent();
            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
            intent.putExtra("key_type", 1);
            SnsLuckyMoneyPrepareUI.this.startActivity(intent);
            AppMethodBeat.m2505o(42510);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$2 */
    class C167942 implements Runnable {
        C167942() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42509);
            Intent intent = new Intent();
            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyIndexUI.class);
            intent.addFlags(67108864);
            SnsLuckyMoneyPrepareUI.this.mController.ylL.startActivity(intent);
            SnsLuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42509);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$14 */
    class C1679614 implements OnClickListener {
        C1679614() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42523);
            SnsLuckyMoneyPrepareUI.this.aoB();
            AppMethodBeat.m2505o(42523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$7 */
    class C167987 implements Runnable {
        C167987() {
        }

        public final void run() {
            AppMethodBeat.m2504i(42513);
            SnsLuckyMoneyPrepareUI.this.obD.setVisibility(0);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(800);
            scaleAnimation.setStartOffset(200);
            scaleAnimation.setInterpolator(new BounceInterpolator());
            SnsLuckyMoneyPrepareUI.this.findViewById(2131825634).startAnimation(scaleAnimation);
            AppMethodBeat.m2505o(42513);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$8 */
    class C167998 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$8$1 */
        class C168001 implements Runnable {
            C168001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(42514);
                SnsLuckyMoneyPrepareUI.this.obD.setVisibility(8);
                SnsLuckyMoneyPrepareUI.m25872n(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.m2505o(42514);
            }
        }

        C167998() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42515);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.m25862d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6));
            C46063x.m85804a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.this.mType, SnsLuckyMoneyPrepareUI.this.obI, false);
            SnsLuckyMoneyPrepareUI.this.obD.postDelayed(new C168001(), 100);
            AppMethodBeat.m2505o(42515);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$9 */
    class C168019 implements OnClickListener {
        C168019() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42516);
            SnsLuckyMoneyPrepareUI.this.obD.setVisibility(8);
            SnsLuckyMoneyPrepareUI.m25873o(SnsLuckyMoneyPrepareUI.this);
            AppMethodBeat.m2505o(42516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$1 */
    class C168031 implements OnMenuItemClickListener {
        C168031() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42508);
            SnsLuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42508);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsLuckyMoneyPrepareUI() {
        AppMethodBeat.m2504i(42532);
        AppMethodBeat.m2505o(42532);
    }

    /* renamed from: d */
    static /* synthetic */ int m25862d(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(42544);
        int bMh = snsLuckyMoneyPrepareUI.bMh();
        AppMethodBeat.m2505o(42544);
        return bMh;
    }

    /* renamed from: n */
    static /* synthetic */ void m25872n(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(42546);
        snsLuckyMoneyPrepareUI.bMp();
        AppMethodBeat.m2505o(42546);
    }

    /* renamed from: o */
    static /* synthetic */ void m25873o(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(42547);
        snsLuckyMoneyPrepareUI.bMp();
        AppMethodBeat.m2505o(42547);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42533);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.obG = getIntent().getIntExtra("key_way", 3);
        this.obJ = getIntent().getIntExtra("key_from", 0) == 1;
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        mo24301b(new C3381ag("v1.0", 0, (byte) 0), false);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        C4990ab.m7410d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.obJ + ", config " + this.nSs);
        initView();
        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(1));
        AppMethodBeat.m2505o(42533);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42534);
        getResources().getDrawable(C25738R.drawable.b8e);
        setBackBtn(new C168031());
        this.obD = findViewById(2131825633);
        this.obE = findViewById(2131825638);
        this.leS = (Button) findViewById(2131825637);
        this.nTf = (LuckyMoneyTextInputView) findViewById(2131825621);
        this.nTf.setHintText(getString(C25738R.string.cqe));
        this.nTg = (Button) findViewById(2131825630);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        this.kGq = (TextView) findViewById(2131825618);
        this.nTd = (LuckyMoneyNumInputView) findViewById(2131825619);
        this.obC = (LuckyMoneyMoneyInputView) findViewById(2131825617);
        this.kGm = (TextView) findViewById(2131825629);
        this.obF = (ViewGroup) findViewById(2131825632);
        this.hJh = (ScrollView) findViewById(2131825615);
        this.nTl = (TextView) findViewById(2131825616);
        if (this.mType == 1) {
            this.obC.setTitle(getString(C25738R.string.cto));
            this.obC.setShowGroupIcon(true);
        } else {
            this.obC.setTitle(getString(C25738R.string.ctp));
            this.obC.setShowGroupIcon(false);
        }
        this.obC.setOnInputValidChangerListener(this);
        this.nTd.setOnInputValidChangerListener(this);
        this.nTf.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.obC.findViewById(2131825536);
        final EditText editText2 = (EditText) this.nTd.findViewById(2131825536);
        C36391e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42529);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.m2505o(42529);
            }
        });
        TextView textView = (TextView) this.obC.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42530);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                    SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                    AppMethodBeat.m2505o(42530);
                }
            });
        }
        C36391e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42531);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                SnsLuckyMoneyPrepareUI.this.mo30771V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.m2505o(42531);
            }
        });
        if (this.nSs != null) {
            if (this.mType == 1) {
                this.obC.setMaxAmount(this.nSs.nRR);
            } else {
                this.obC.setMaxAmount(this.nSs.nRP);
            }
            this.obC.setMinAmount(this.nSs.nRQ);
        }
        if (!this.obJ || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.nTd.setNum("");
        } else {
            this.nTd.setNum("1");
        }
        this.nTd.setMaxNum(this.nSs.nRO);
        this.nTd.setMinNum(1);
        C4990ab.m7410d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.nTd.getInput());
        this.obC.setMaxLen(12);
        if (this.obJ) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(C25738R.string.crb);
                String string2 = getString(C25738R.string.cr9);
                String string3 = getString(C25738R.string.cra);
                String string4 = getString(C25738R.string.cr_);
                final SpannableString spannableString = new SpannableString(string + string2);
                C46373j c46373j = new C46373j(this);
                spannableString.setSpan(c46373j, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                C46373j c46373j2 = new C46373j(this);
                spannableString2.setSpan(c46373j2, string3.length(), string3.length() + string4.length(), 33);
                c46373j.tHw = new C29672a() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42520);
                        int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 0;
                        SnsLuckyMoneyPrepareUI.this.obC.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.obC.setShowGroupIcon(false);
                        SnsLuckyMoneyPrepareUI.this.obC.setTitle(SnsLuckyMoneyPrepareUI.this.getString(C25738R.string.ctp));
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.obC.setAmount(C36391e.m59971F(input2 / ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.obC.setMaxAmount(SnsLuckyMoneyPrepareUI.this.nSs.nRP);
                        SnsLuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.m25862d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3));
                        AppMethodBeat.m2505o(42520);
                    }
                };
                c46373j2.tHw = new C29672a() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(42524);
                        int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 1;
                        SnsLuckyMoneyPrepareUI.this.obC.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.obC.setTitle(SnsLuckyMoneyPrepareUI.this.getString(C25738R.string.cto));
                        SnsLuckyMoneyPrepareUI.this.obC.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.obC.setAmount(C36391e.m59971F(input2 * ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.obC.setMaxAmount(SnsLuckyMoneyPrepareUI.this.nSs.nRR);
                        SnsLuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.m25862d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2));
                        AppMethodBeat.m2505o(42524);
                    }
                };
                this.kGq.setMovementMethod(LinkMovementMethod.getInstance());
                this.kGq.setText(spannableString);
                this.kGq.setVisibility(0);
            } else {
                this.nTd.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.kGq.setText(this.nSs.nWH);
            this.kGq.setVisibility(0);
        } else if (this.mType == 0) {
            this.kGq.setText(this.nSs.nWI);
            this.kGq.setVisibility(0);
        }
        this.nTg.setOnClickListener(new C1678016());
        this.kGm.setText(C36391e.m59972G(0.0d));
        this.nTn.mo68830a(this.nTd);
        this.nTn.mo68830a(this.obC);
        this.nTn.mo68830a(this.nTf);
        this.nTn.mo68834i((TextView) findViewById(2131825639));
        if (this.obJ && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(2131825620);
            textView2.setText(getString(C25738R.string.cs0, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.gGo = new C7564ap(new C1678217(), false);
        if (this.hJh != null) {
            this.hJh.setOnTouchListener(new C1678318());
        }
        this.obC.setType(this.mType);
        if (this.obJ && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.obC.requestFocus();
            AppMethodBeat.m2505o(42534);
            return;
        }
        this.nTd.requestFocus();
        AppMethodBeat.m2505o(42534);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42535);
        super.onDestroy();
        this.nTn.clear();
        this.gGo.doT();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        AppMethodBeat.m2505o(42535);
    }

    public final int getLayoutId() {
        return 2130969994;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(42536);
        if (keyEvent.getKeyCode() == 4 && this.obD.getVisibility() == 0) {
            this.obD.setVisibility(8);
            bMp();
            AppMethodBeat.m2505o(42536);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(42536);
        return dispatchKeyEvent;
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42537);
        if (c1207m instanceof C12426ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.hide();
            }
            if (i == 0 && i2 == 0) {
                C12426ao c12426ao = (C12426ao) c1207m;
                this.obI = c12426ao.kCd;
                this.obH = c12426ao.nSX;
                this.obK = c12426ao.nYY;
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = c12426ao.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                C35899h.m58853a(this, payInfo, 1);
                AppMethodBeat.m2505o(42537);
                return true;
            } else if (i2 == 401) {
                this.nTg.setEnabled(false);
                this.nTg.setClickable(false);
                this.gGo.mo16770ae(5000, 5000);
                C30379h.m48465bQ(this, str);
                AppMethodBeat.m2505o(42537);
                return true;
            } else {
                C30379h.m48465bQ(this, str);
                AppMethodBeat.m2505o(42537);
                return true;
            }
        }
        if (c1207m instanceof C21198ar) {
            if (i == 0 && i2 == 0) {
                if (this.obJ) {
                    C30379h.m48465bQ(this, getString(C25738R.string.cbn));
                    finish();
                } else {
                    bMq();
                    this.obE.postDelayed(new C167942(), 1000);
                }
                AppMethodBeat.m2505o(42537);
                return true;
            } else if (i2 == 402) {
                C30379h.m48466d(this.mController.ylL, str, "", getString(C25738R.string.ct5), getString(C25738R.string.f9076or), new C167903(), new C167844());
                AppMethodBeat.m2505o(42537);
                return true;
            }
        } else if (c1207m instanceof C3381ag) {
            if (i == 0 && i2 == 0) {
                final C3381ag c3381ag = (C3381ag) c1207m;
                C6964a.bKN();
                this.nSs = C6964a.bKO().bLu();
                C4990ab.m7410d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nSs);
                if (this.mType == 1) {
                    this.obC.setMaxAmount(this.nSs.nRR);
                } else {
                    this.obC.setMaxAmount(this.nSs.nRP);
                }
                this.obC.setMinAmount(this.nSs.nRQ);
                this.nTd.setMaxNum(this.nSs.nRO);
                if (c3381ag.nYE && this.obJ) {
                    TextView textView = (TextView) findViewById(2131825631);
                    textView.setOnClickListener(new C167855());
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(8));
                    textView.setVisibility(0);
                }
                if (C5046bo.isNullOrNil(c3381ag.kCx)) {
                    this.nTl.setVisibility(8);
                } else {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + c3381ag.kCx);
                    this.nTl.setText(c3381ag.kCx);
                    if (!C5046bo.isNullOrNil(c3381ag.nYG)) {
                        this.nTl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(42512);
                                C36391e.m60016n(SnsLuckyMoneyPrepareUI.this.mController.ylL, c3381ag.nYG, false);
                                AppMethodBeat.m2505o(42512);
                            }
                        });
                    }
                    this.nTl.setVisibility(0);
                }
                C21253c c21253c = new C21253c();
                c21253c.textColor = getResources().getColor(C25738R.color.a4m);
                C21249h.m32619a(this, this.obF, c3381ag.nYI, c21253c);
            }
            AppMethodBeat.m2505o(42537);
            return true;
        }
        AppMethodBeat.m2505o(42537);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42538);
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(5));
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.obJ && !C5046bo.isNullOrNil(stringExtra)) {
                        C30379h.m48465bQ(this, getString(C25738R.string.cbn));
                        Map z = C5049br.m7595z(this.obK, "msg");
                        if (z != null) {
                            str = (String) z.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (C6964a.bKN().bKQ().mo36579Qh(str)) {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!C46063x.m85797E(this.obK, stringExtra, 1)) {
                                    C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    C6964a.bKN().bKQ().mo36580Qi(str);
                                }
                            } else {
                                C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        AppMethodBeat.m2505o(42538);
                        return;
                    }
                    bMq();
                    new C7306ak().postDelayed(new C167987(), 200);
                    this.leS.setOnClickListener(new C167998());
                    ((ImageView) findViewById(2131825636)).setOnClickListener(new C168019());
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.mController.ylL, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                C7060h.pYm.mo8381e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(7), str);
                if (!C5046bo.isNullOrNil(str)) {
                    mo24304n(new C21198ar(str.replaceAll(",", "|"), this.obH, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(42538);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: V */
    public final void mo30771V(View view, final int i) {
        AppMethodBeat.m2504i(42539);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        final EditText editText = (EditText) view.findViewById(2131825536);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.m2505o(42539);
            return;
        }
        C36391e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;

            /* renamed from: com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI$10$2 */
            class C167872 implements Runnable {
                C167872() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(42518);
                    SnsLuckyMoneyPrepareUI.this.aoB();
                    ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    AppMethodBeat.m2505o(42518);
                }
            }

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.m2504i(42519);
                if (!view.isFocused() || this.gnT) {
                    new C7306ak().postDelayed(new C167872(), 200);
                    AppMethodBeat.m2505o(42519);
                    return;
                }
                ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42517);
                        if (!SnsLuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                        }
                        SnsLuckyMoneyPrepareUI.m25860b(SnsLuckyMoneyPrepareUI.this, i);
                        SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.m2505o(42517);
                    }
                }, 300);
                AppMethodBeat.m2505o(42519);
            }
        });
        editText.setOnClickListener(new OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(42521);
                if (SnsLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        SnsLuckyMoneyPrepareUI.this.aoB();
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.m2505o(42521);
                    return;
                }
                SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                SnsLuckyMoneyPrepareUI.m25860b(SnsLuckyMoneyPrepareUI.this, i);
                AppMethodBeat.m2505o(42521);
            }
        });
        TextView textView = (TextView) view.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42522);
                    if (SnsLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (this.gnT) {
                            SnsLuckyMoneyPrepareUI.this.aoB();
                            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        AppMethodBeat.m2505o(42522);
                        return;
                    }
                    SnsLuckyMoneyPrepareUI.m25869k(SnsLuckyMoneyPrepareUI.this);
                    SnsLuckyMoneyPrepareUI.m25860b(SnsLuckyMoneyPrepareUI.this, i);
                    AppMethodBeat.m2505o(42522);
                }
            });
        }
        findViewById.setOnClickListener(new C1679614());
        AppMethodBeat.m2505o(42539);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(42540);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            aoB();
            AppMethodBeat.m2505o(42540);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(42540);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.m2504i(42541);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            this.obM.mo9448ic(false);
        }
        AppMethodBeat.m2505o(42541);
    }

    public final void bLa() {
        double d;
        double d2;
        int input;
        AppMethodBeat.m2504i(42542);
        C6964a.bKN();
        this.nSs = C6964a.bKO().bLu();
        if (this.obC.bKW() == 3 || this.nTd.bKW() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            input = this.nTd.getInput();
            d2 = this.obC.getInput();
            if (this.mType == 0) {
                d2 *= (double) input;
                d = this.obC.getInput();
            } else {
                d = input > 0 ? this.obC.getInput() / ((double) input) : 0.0d;
            }
        }
        if (this.nTn.bMy()) {
            this.nTg.setClickable(false);
            this.nTg.setEnabled(false);
        } else {
            if (d2 == 0.0d || d == 0.0d) {
                input = 1;
            } else if (d2 > this.nSs.nRR && this.nSs.nRR > 0.0d) {
                this.nTn.mo68829Dv(getString(C25738R.string.ctn, new Object[]{Math.round(this.nSs.nRR), C5046bo.m7532bc(this.nSs.nRU, "")}));
                input = 1;
            } else if (d > 0.0d) {
                int i;
                boolean i2;
                if (this.mType == 0) {
                    if (d > this.nSs.nRP && this.nSs.nRP > 0.0d) {
                        this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(this.nSs.nRP), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        i2 = 1;
                    }
                    i2 = false;
                } else {
                    if (d > this.nSs.nRS && this.nSs.nRS > 0.0d) {
                        this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(this.nSs.nRS), C5046bo.m7532bc(this.nSs.nRU, "")}));
                        this.nTd.onError();
                        this.obC.onError();
                        i2 = 1;
                    }
                    i2 = false;
                }
                if (i2 == 0) {
                    if (this.mType == 0) {
                        if (d < this.nSs.nRQ) {
                            this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{C36391e.m59971F(this.nSs.nRQ), C5046bo.m7532bc(this.nSs.nRU, "")}));
                            input = 1;
                        }
                    } else if (d < 0.01d) {
                        this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{"0.01", C5046bo.m7532bc(this.nSs.nRU, "")}));
                        this.nTd.onError();
                        this.obC.onError();
                        input = 1;
                    }
                }
                input = i2;
            } else {
                boolean z = false;
            }
            if (input != 0) {
                this.nTg.setClickable(false);
                this.nTg.setEnabled(false);
            } else {
                this.nTg.setClickable(true);
                this.nTg.setEnabled(true);
            }
        }
        this.kGm.setText(C36391e.m59972G(d2));
        AppMethodBeat.m2505o(42542);
    }

    private int bMh() {
        AppMethodBeat.m2504i(42543);
        if (!this.obJ) {
            AppMethodBeat.m2505o(42543);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.m2505o(42543);
            return 2;
        } else {
            AppMethodBeat.m2505o(42543);
            return 1;
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m25869k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.m2504i(42545);
        if (!(snsLuckyMoneyPrepareUI.nTi == null || snsLuckyMoneyPrepareUI.nTi.isShown())) {
            snsLuckyMoneyPrepareUI.nTi.setVisibility(0);
            snsLuckyMoneyPrepareUI.obM.mo9448ic(true);
        }
        AppMethodBeat.m2505o(42545);
    }

    /* renamed from: b */
    static /* synthetic */ void m25860b(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, int i) {
        AppMethodBeat.m2504i(42548);
        snsLuckyMoneyPrepareUI.mKeyboard.setXMode(i);
        AppMethodBeat.m2505o(42548);
    }
}
