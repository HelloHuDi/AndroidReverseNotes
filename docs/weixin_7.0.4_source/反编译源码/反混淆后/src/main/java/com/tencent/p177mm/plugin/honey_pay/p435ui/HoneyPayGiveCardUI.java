package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import java.math.RoundingMode;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI */
public class HoneyPayGiveCardUI extends HoneyPayBaseUI {
    private String igi;
    private ImageView kEn;
    private String kGE;
    private String kWC;
    private long nrO = 100000;
    private long nrP = 0;
    private String nsb;
    private int nsd;
    private ScrollView nsk;
    private WalletFormView nsl;
    private TextView nsm;
    private TextView nsn;
    private TextView nso;
    private TextView nsp;
    private TextView nsq;
    private CdnImageView nsr;
    private MMEditText nss;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$1 */
    class C32911 implements TextWatcher {
        C32911() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(41859);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            HoneyPayGiveCardUI.m66871a(HoneyPayGiveCardUI.this);
            AppMethodBeat.m2505o(41859);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$3 */
    class C32923 implements OnClickListener {
        C32923() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41861);
            HoneyPayGiveCardUI.this.nsp.setVisibility(8);
            HoneyPayGiveCardUI.this.nsl.setVisibility(0);
            HoneyPayGiveCardUI.this.nsl.mo64601f(HoneyPayGiveCardUI.this);
            AppMethodBeat.m2505o(41861);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$4 */
    class C32934 implements OnClickListener {
        C32934() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41862);
            C4990ab.m7410d(HoneyPayGiveCardUI.this.TAG, "click give btn");
            if (HoneyPayGiveCardUI.m66871a(HoneyPayGiveCardUI.this)) {
                HoneyPayGiveCardUI.this.aoB();
                HoneyPayGiveCardUI.m66874d(HoneyPayGiveCardUI.this);
                AppMethodBeat.m2505o(41862);
                return;
            }
            C4990ab.m7420w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
            AppMethodBeat.m2505o(41862);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$9 */
    class C283019 implements C35502a {
        C283019() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41867);
            HoneyPayGiveCardUI.this.aoB();
            HoneyPayGiveCardUI.this.nsq.setVisibility(8);
            HoneyPayGiveCardUI.this.nss.setVisibility(0);
            HoneyPayGiveCardUI.this.nss.requestFocus();
            HoneyPayGiveCardUI.this.showVKB();
            AppMethodBeat.m2505o(41867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$2 */
    class C343462 implements OnClickListener {
        C343462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41860);
            HoneyPayGiveCardUI.this.nsl.mo64601f(HoneyPayGiveCardUI.this);
            AppMethodBeat.m2505o(41860);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$5 */
    class C343475 implements OnEditorActionListener {
        C343475() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(41863);
            if (i == 6 || i == 5) {
                HoneyPayGiveCardUI.this.nsb = HoneyPayGiveCardUI.this.nss.getText().toString();
                HoneyPayGiveCardUI.this.aqX();
                HoneyPayGiveCardUI.m66876f(HoneyPayGiveCardUI.this);
            }
            AppMethodBeat.m2505o(41863);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$6 */
    class C343486 implements OnFocusChangeListener {
        C343486() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(41864);
            if (!z) {
                HoneyPayGiveCardUI.this.nsb = HoneyPayGiveCardUI.this.nss.getText().toString();
                HoneyPayGiveCardUI.m66876f(HoneyPayGiveCardUI.this);
            }
            AppMethodBeat.m2505o(41864);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$7 */
    class C343497 implements C40947a {
        C343497() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(41865);
            if (z) {
                HoneyPayGiveCardUI.m66870a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.this.nsk, HoneyPayGiveCardUI.this.nso);
                AppMethodBeat.m2505o(41865);
                return;
            }
            HoneyPayGiveCardUI.this.nsk.scrollTo(0, 0);
            HoneyPayGiveCardUI.this.nsl.cex();
            if (C5046bo.isNullOrNil(HoneyPayGiveCardUI.this.nsl.getText())) {
                HoneyPayGiveCardUI.this.nsl.setVisibility(8);
                HoneyPayGiveCardUI.this.nsp.setVisibility(0);
                HoneyPayGiveCardUI.m66880i(HoneyPayGiveCardUI.this);
                HoneyPayGiveCardUI.m66883j(HoneyPayGiveCardUI.this);
            }
            AppMethodBeat.m2505o(41865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI$8 */
    class C343508 implements Runnable {
        C343508() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41866);
            HoneyPayGiveCardUI.this.nsl.mo64601f(HoneyPayGiveCardUI.this);
            AppMethodBeat.m2505o(41866);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m66870a(HoneyPayGiveCardUI honeyPayGiveCardUI, View view, View view2) {
        AppMethodBeat.m2504i(41879);
        honeyPayGiveCardUI.mo39974b(view, view2, 10);
        AppMethodBeat.m2505o(41879);
    }

    /* renamed from: f */
    static /* synthetic */ void m66876f(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.m2504i(41878);
        honeyPayGiveCardUI.bGe();
        AppMethodBeat.m2505o(41878);
    }

    /* renamed from: i */
    static /* synthetic */ void m66880i(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.m2504i(41880);
        honeyPayGiveCardUI.m66881ia(false);
        AppMethodBeat.m2505o(41880);
    }

    /* renamed from: j */
    static /* synthetic */ void m66883j(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.m2504i(41881);
        honeyPayGiveCardUI.m66879hZ(false);
        AppMethodBeat.m2505o(41881);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41868);
        this.nqT = C25738R.color.f12094s2;
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(C25738R.color.a69);
        this.nrO = getIntent().getLongExtra("key_max_credit_line", 0);
        this.nrP = getIntent().getLongExtra("key_min_credit_line", 0);
        this.kGE = getIntent().getStringExtra("key_true_name");
        this.igi = getIntent().getStringExtra("key_username");
        this.nsb = getIntent().getStringExtra("key_wishing");
        this.kWC = getIntent().getStringExtra("key_icon_url");
        this.nsd = getIntent().getIntExtra("key_cardtype", 0);
        if (this.nsd == 0) {
            C4990ab.m7420w(this.TAG, "error card type!!");
            finish();
        }
        initView();
        setMMTitle((int) C25738R.string.ccf);
        AppMethodBeat.m2505o(41868);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41869);
        this.nsk = (ScrollView) findViewById(2131824903);
        this.nsl = (WalletFormView) findViewById(2131824911);
        this.nsm = (TextView) findViewById(2131824906);
        this.nsn = (TextView) findViewById(2131824914);
        this.kEn = (ImageView) findViewById(2131824905);
        this.nso = (TextView) findViewById(2131824913);
        this.nsp = (TextView) findViewById(2131824912);
        this.nsq = (TextView) findViewById(2131824907);
        this.nss = (MMEditText) findViewById(2131824908);
        C40460b.m69433a(this.kEn, this.igi, 0.06f, false);
        CharSequence eL = C36391e.m60008eL(this.igi, 10);
        if (!C5046bo.isNullOrNil(this.kGE)) {
            eL = String.format("%s(%s)", new Object[]{eL, this.kGE});
        }
        this.nsm.setText(C44089j.m79293b(this.mController.ylL, eL, this.nsm.getTextSize()));
        this.nsl.dOP();
        this.nsl.getTitleTv().setText(C44423ae.dOd());
        this.nsl.mo64594a(new C32911());
        this.nsl.setOnClickListener(new C343462());
        this.nsp.setOnClickListener(new C32923());
        this.nso.setClickable(true);
        this.nso.setOnClickListener(new C32934());
        this.nsq.setClickable(true);
        this.nsq.setOnTouchListener(new C30132m(this));
        this.nss.setOnEditorActionListener(new C343475());
        this.nss.setOnFocusChangeListener(new C343486());
        bGe();
        this.obM = new C343497();
        mo39989e(this.nsl, 2, false);
        this.nsl.postDelayed(new C343508(), 100);
        this.nsr = (CdnImageView) findViewById(2131824909);
        if (C5046bo.isNullOrNil(this.kWC)) {
            this.nsr.setImageResource(C28289c.bFX());
            AppMethodBeat.m2505o(41869);
            return;
        }
        this.nsr.mo38952eb(this.kWC, C28289c.bFX());
        AppMethodBeat.m2505o(41869);
    }

    private void bGe() {
        AppMethodBeat.m2504i(41870);
        this.nsq.setVisibility(0);
        this.nss.setVisibility(8);
        this.nss.setText(this.nsb);
        this.nss.setSelection(this.nsb.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getString(C25738R.string.ccw);
        SpannableString b = C44089j.m79293b(this.mController.ylL, this.nsb, this.nsq.getTextSize());
        spannableStringBuilder.append(b);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new C35503o(new C283019()), b.length() + 1, spannableStringBuilder.length(), 34);
        this.nsq.setText(spannableStringBuilder);
        AppMethodBeat.m2505o(41870);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41871);
        super.onDestroy();
        AppMethodBeat.m2505o(41871);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130969830;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41872);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41872);
    }

    /* renamed from: hZ */
    private void m66879hZ(boolean z) {
        AppMethodBeat.m2504i(41873);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.m2505o(41873);
            return;
        }
        String str = C44423ae.dOd() + C36391e.m59996b(this.nrP, "100", RoundingMode.HALF_UP);
        this.nsn.setText(getString(C25738R.string.cct, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.m2505o(41873);
    }

    /* renamed from: ia */
    private void m66881ia(boolean z) {
        AppMethodBeat.m2504i(41874);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.m2505o(41874);
            return;
        }
        String str = C44423ae.dOd() + C36391e.m59981a(this.nrO, "100", 2, RoundingMode.HALF_UP).toString();
        this.nsn.setText(getString(C25738R.string.ccp, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.m2505o(41874);
    }

    /* renamed from: ib */
    private void m66882ib(boolean z) {
        AppMethodBeat.m2504i(41875);
        this.nso.setEnabled(z);
        AppMethodBeat.m2505o(41875);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m66871a(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.m2504i(41876);
        if (C5046bo.isNullOrNil(honeyPayGiveCardUI.nsl.getText())) {
            C4990ab.m7410d(honeyPayGiveCardUI.TAG, "no input, hide alert");
            honeyPayGiveCardUI.m66881ia(false);
            honeyPayGiveCardUI.m66879hZ(false);
            honeyPayGiveCardUI.m66882ib(false);
            AppMethodBeat.m2505o(41876);
            return false;
        }
        int iy = C36391e.m60012iy(honeyPayGiveCardUI.nsl.getText(), "100");
        C4990ab.m7411d(honeyPayGiveCardUI.TAG, "current fen: %s", Integer.valueOf(iy));
        if (((long) iy) < honeyPayGiveCardUI.nrP) {
            honeyPayGiveCardUI.m66879hZ(true);
            honeyPayGiveCardUI.m66882ib(false);
            AppMethodBeat.m2505o(41876);
            return false;
        } else if (((long) iy) > honeyPayGiveCardUI.nrO) {
            honeyPayGiveCardUI.m66881ia(true);
            honeyPayGiveCardUI.m66882ib(false);
            AppMethodBeat.m2505o(41876);
            return false;
        } else if (iy == 0) {
            honeyPayGiveCardUI.m66882ib(false);
            AppMethodBeat.m2505o(41876);
            return false;
        } else {
            honeyPayGiveCardUI.m66881ia(false);
            honeyPayGiveCardUI.m66879hZ(false);
            honeyPayGiveCardUI.m66882ib(true);
            AppMethodBeat.m2505o(41876);
            return true;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m66874d(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.m2504i(41877);
        C4990ab.m7416i(honeyPayGiveCardUI.TAG, "go to pwd ui");
        long iz = C36391e.m60013iz(honeyPayGiveCardUI.nsl.getText(), "100");
        String stringExtra = honeyPayGiveCardUI.getIntent().getStringExtra("key_take_message");
        Intent intent = new Intent(honeyPayGiveCardUI.mController.ylL, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_credit_line", iz);
        intent.putExtra("key_take_message", stringExtra);
        intent.putExtra("key_username", honeyPayGiveCardUI.igi);
        intent.putExtra("key_wishing", honeyPayGiveCardUI.nsb);
        intent.putExtra("key_cardtype", honeyPayGiveCardUI.nsd);
        honeyPayGiveCardUI.startActivity(intent);
        AppMethodBeat.m2505o(41877);
    }
}
