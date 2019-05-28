package com.tencent.mm.plugin.honey_pay.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(HoneyPayGiveCardUI honeyPayGiveCardUI, View view, View view2) {
        AppMethodBeat.i(41879);
        honeyPayGiveCardUI.b(view, view2, 10);
        AppMethodBeat.o(41879);
    }

    static /* synthetic */ void f(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(41878);
        honeyPayGiveCardUI.bGe();
        AppMethodBeat.o(41878);
    }

    static /* synthetic */ void i(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(41880);
        honeyPayGiveCardUI.ia(false);
        AppMethodBeat.o(41880);
    }

    static /* synthetic */ void j(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(41881);
        honeyPayGiveCardUI.hZ(false);
        AppMethodBeat.o(41881);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41868);
        this.nqT = R.color.s2;
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.a69);
        this.nrO = getIntent().getLongExtra("key_max_credit_line", 0);
        this.nrP = getIntent().getLongExtra("key_min_credit_line", 0);
        this.kGE = getIntent().getStringExtra("key_true_name");
        this.igi = getIntent().getStringExtra("key_username");
        this.nsb = getIntent().getStringExtra("key_wishing");
        this.kWC = getIntent().getStringExtra("key_icon_url");
        this.nsd = getIntent().getIntExtra("key_cardtype", 0);
        if (this.nsd == 0) {
            ab.w(this.TAG, "error card type!!");
            finish();
        }
        initView();
        setMMTitle((int) R.string.ccf);
        AppMethodBeat.o(41868);
    }

    public final void initView() {
        AppMethodBeat.i(41869);
        this.nsk = (ScrollView) findViewById(R.id.cft);
        this.nsl = (WalletFormView) findViewById(R.id.cg1);
        this.nsm = (TextView) findViewById(R.id.cfw);
        this.nsn = (TextView) findViewById(R.id.cg4);
        this.kEn = (ImageView) findViewById(R.id.cfv);
        this.nso = (TextView) findViewById(R.id.cg3);
        this.nsp = (TextView) findViewById(R.id.cg2);
        this.nsq = (TextView) findViewById(R.id.cfx);
        this.nss = (MMEditText) findViewById(R.id.cfy);
        b.a(this.kEn, this.igi, 0.06f, false);
        CharSequence eL = e.eL(this.igi, 10);
        if (!bo.isNullOrNil(this.kGE)) {
            eL = String.format("%s(%s)", new Object[]{eL, this.kGE});
        }
        this.nsm.setText(j.b(this.mController.ylL, eL, this.nsm.getTextSize()));
        this.nsl.dOP();
        this.nsl.getTitleTv().setText(ae.dOd());
        this.nsl.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(41859);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(41859);
            }
        });
        this.nsl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41860);
                HoneyPayGiveCardUI.this.nsl.f(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(41860);
            }
        });
        this.nsp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41861);
                HoneyPayGiveCardUI.this.nsp.setVisibility(8);
                HoneyPayGiveCardUI.this.nsl.setVisibility(0);
                HoneyPayGiveCardUI.this.nsl.f(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(41861);
            }
        });
        this.nso.setClickable(true);
        this.nso.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41862);
                ab.d(HoneyPayGiveCardUI.this.TAG, "click give btn");
                if (HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this)) {
                    HoneyPayGiveCardUI.this.aoB();
                    HoneyPayGiveCardUI.d(HoneyPayGiveCardUI.this);
                    AppMethodBeat.o(41862);
                    return;
                }
                ab.w(HoneyPayGiveCardUI.this.TAG, "over limit when click");
                AppMethodBeat.o(41862);
            }
        });
        this.nsq.setClickable(true);
        this.nsq.setOnTouchListener(new m(this));
        this.nss.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(41863);
                if (i == 6 || i == 5) {
                    HoneyPayGiveCardUI.this.nsb = HoneyPayGiveCardUI.this.nss.getText().toString();
                    HoneyPayGiveCardUI.this.aqX();
                    HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(41863);
                return false;
            }
        });
        this.nss.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(41864);
                if (!z) {
                    HoneyPayGiveCardUI.this.nsb = HoneyPayGiveCardUI.this.nss.getText().toString();
                    HoneyPayGiveCardUI.f(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(41864);
            }
        });
        bGe();
        this.obM = new a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(41865);
                if (z) {
                    HoneyPayGiveCardUI.a(HoneyPayGiveCardUI.this, HoneyPayGiveCardUI.this.nsk, HoneyPayGiveCardUI.this.nso);
                    AppMethodBeat.o(41865);
                    return;
                }
                HoneyPayGiveCardUI.this.nsk.scrollTo(0, 0);
                HoneyPayGiveCardUI.this.nsl.cex();
                if (bo.isNullOrNil(HoneyPayGiveCardUI.this.nsl.getText())) {
                    HoneyPayGiveCardUI.this.nsl.setVisibility(8);
                    HoneyPayGiveCardUI.this.nsp.setVisibility(0);
                    HoneyPayGiveCardUI.i(HoneyPayGiveCardUI.this);
                    HoneyPayGiveCardUI.j(HoneyPayGiveCardUI.this);
                }
                AppMethodBeat.o(41865);
            }
        };
        e(this.nsl, 2, false);
        this.nsl.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41866);
                HoneyPayGiveCardUI.this.nsl.f(HoneyPayGiveCardUI.this);
                AppMethodBeat.o(41866);
            }
        }, 100);
        this.nsr = (CdnImageView) findViewById(R.id.cfz);
        if (bo.isNullOrNil(this.kWC)) {
            this.nsr.setImageResource(c.bFX());
            AppMethodBeat.o(41869);
            return;
        }
        this.nsr.eb(this.kWC, c.bFX());
        AppMethodBeat.o(41869);
    }

    private void bGe() {
        AppMethodBeat.i(41870);
        this.nsq.setVisibility(0);
        this.nss.setVisibility(8);
        this.nss.setText(this.nsb);
        this.nss.setSelection(this.nsb.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = getString(R.string.ccw);
        SpannableString b = j.b(this.mController.ylL, this.nsb, this.nsq.getTextSize());
        spannableStringBuilder.append(b);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.append(string);
        spannableStringBuilder.setSpan(new o(new o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41867);
                HoneyPayGiveCardUI.this.aoB();
                HoneyPayGiveCardUI.this.nsq.setVisibility(8);
                HoneyPayGiveCardUI.this.nss.setVisibility(0);
                HoneyPayGiveCardUI.this.nss.requestFocus();
                HoneyPayGiveCardUI.this.showVKB();
                AppMethodBeat.o(41867);
            }
        }), b.length() + 1, spannableStringBuilder.length(), 34);
        this.nsq.setText(spannableStringBuilder);
        AppMethodBeat.o(41870);
    }

    public void onDestroy() {
        AppMethodBeat.i(41871);
        super.onDestroy();
        AppMethodBeat.o(41871);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.a73;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41872);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(41872);
    }

    private void hZ(boolean z) {
        AppMethodBeat.i(41873);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.o(41873);
            return;
        }
        String str = ae.dOd() + e.b(this.nrP, "100", RoundingMode.HALF_UP);
        this.nsn.setText(getString(R.string.cct, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.o(41873);
    }

    private void ia(boolean z) {
        AppMethodBeat.i(41874);
        if (!z || this.nsn.isShown()) {
            if (!z && this.nsn.isShown()) {
                this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
                this.nsn.setVisibility(8);
            }
            AppMethodBeat.o(41874);
            return;
        }
        String str = ae.dOd() + e.a(this.nrO, "100", 2, RoundingMode.HALF_UP).toString();
        this.nsn.setText(getString(R.string.ccp, new Object[]{str}));
        this.nsn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
        this.nsn.setVisibility(0);
        AppMethodBeat.o(41874);
    }

    private void ib(boolean z) {
        AppMethodBeat.i(41875);
        this.nso.setEnabled(z);
        AppMethodBeat.o(41875);
    }

    static /* synthetic */ boolean a(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(41876);
        if (bo.isNullOrNil(honeyPayGiveCardUI.nsl.getText())) {
            ab.d(honeyPayGiveCardUI.TAG, "no input, hide alert");
            honeyPayGiveCardUI.ia(false);
            honeyPayGiveCardUI.hZ(false);
            honeyPayGiveCardUI.ib(false);
            AppMethodBeat.o(41876);
            return false;
        }
        int iy = e.iy(honeyPayGiveCardUI.nsl.getText(), "100");
        ab.d(honeyPayGiveCardUI.TAG, "current fen: %s", Integer.valueOf(iy));
        if (((long) iy) < honeyPayGiveCardUI.nrP) {
            honeyPayGiveCardUI.hZ(true);
            honeyPayGiveCardUI.ib(false);
            AppMethodBeat.o(41876);
            return false;
        } else if (((long) iy) > honeyPayGiveCardUI.nrO) {
            honeyPayGiveCardUI.ia(true);
            honeyPayGiveCardUI.ib(false);
            AppMethodBeat.o(41876);
            return false;
        } else if (iy == 0) {
            honeyPayGiveCardUI.ib(false);
            AppMethodBeat.o(41876);
            return false;
        } else {
            honeyPayGiveCardUI.ia(false);
            honeyPayGiveCardUI.hZ(false);
            honeyPayGiveCardUI.ib(true);
            AppMethodBeat.o(41876);
            return true;
        }
    }

    static /* synthetic */ void d(HoneyPayGiveCardUI honeyPayGiveCardUI) {
        AppMethodBeat.i(41877);
        ab.i(honeyPayGiveCardUI.TAG, "go to pwd ui");
        long iz = e.iz(honeyPayGiveCardUI.nsl.getText(), "100");
        String stringExtra = honeyPayGiveCardUI.getIntent().getStringExtra("key_take_message");
        Intent intent = new Intent(honeyPayGiveCardUI.mController.ylL, HoneyPayCheckPwdUI.class);
        intent.putExtra("key_scene", 1);
        intent.putExtra("key_credit_line", iz);
        intent.putExtra("key_take_message", stringExtra);
        intent.putExtra("key_username", honeyPayGiveCardUI.igi);
        intent.putExtra("key_wishing", honeyPayGiveCardUI.nsb);
        intent.putExtra("key_cardtype", honeyPayGiveCardUI.nsd);
        honeyPayGiveCardUI.startActivity(intent);
        AppMethodBeat.o(41877);
    }
}
