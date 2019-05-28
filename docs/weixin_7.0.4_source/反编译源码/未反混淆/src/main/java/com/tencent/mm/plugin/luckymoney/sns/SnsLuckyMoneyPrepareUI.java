package com.tencent.mm.plugin.luckymoney.sns;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.plugin.luckymoney.ui.h.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements g {
    private ap gGo = null;
    protected Dialog gII = null;
    private ScrollView hJh;
    protected TextView kGm = null;
    private TextView kGq;
    protected Button leS = null;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private i nSs;
    protected LuckyMoneyNumInputView nTd = null;
    protected LuckyMoneyTextInputView nTf = null;
    protected Button nTg = null;
    protected View nTi;
    private TextView nTl;
    private b nTn = new b();
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
    private com.tencent.mm.wallet_core.ui.a obM;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsLuckyMoneyPrepareUI() {
        AppMethodBeat.i(42532);
        AppMethodBeat.o(42532);
    }

    static /* synthetic */ int d(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(42544);
        int bMh = snsLuckyMoneyPrepareUI.bMh();
        AppMethodBeat.o(42544);
        return bMh;
    }

    static /* synthetic */ void n(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(42546);
        snsLuckyMoneyPrepareUI.bMp();
        AppMethodBeat.o(42546);
    }

    static /* synthetic */ void o(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(42547);
        snsLuckyMoneyPrepareUI.bMp();
        AppMethodBeat.o(42547);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42533);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.obG = getIntent().getIntExtra("key_way", 3);
        this.obJ = getIntent().getIntExtra("key_from", 0) == 1;
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        b(new ag("v1.0", 0, (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        ab.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.obJ + ", config " + this.nSs);
        initView();
        h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(1));
        AppMethodBeat.o(42533);
    }

    public final void initView() {
        AppMethodBeat.i(42534);
        getResources().getDrawable(R.drawable.b8e);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42508);
                SnsLuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(42508);
                return true;
            }
        });
        this.obD = findViewById(R.id.czk);
        this.obE = findViewById(R.id.czp);
        this.leS = (Button) findViewById(R.id.czo);
        this.nTf = (LuckyMoneyTextInputView) findViewById(R.id.cz9);
        this.nTf.setHintText(getString(R.string.cqe));
        this.nTg = (Button) findViewById(R.id.czh);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        this.kGq = (TextView) findViewById(R.id.cz6);
        this.nTd = (LuckyMoneyNumInputView) findViewById(R.id.cz7);
        this.obC = (LuckyMoneyMoneyInputView) findViewById(R.id.cz5);
        this.kGm = (TextView) findViewById(R.id.czg);
        this.obF = (ViewGroup) findViewById(R.id.czj);
        this.hJh = (ScrollView) findViewById(R.id.cz3);
        this.nTl = (TextView) findViewById(R.id.cz4);
        if (this.mType == 1) {
            this.obC.setTitle(getString(R.string.cto));
            this.obC.setShowGroupIcon(true);
        } else {
            this.obC.setTitle(getString(R.string.ctp));
            this.obC.setShowGroupIcon(false);
        }
        this.obC.setOnInputValidChangerListener(this);
        this.nTd.setOnInputValidChangerListener(this);
        this.nTf.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.obC.findViewById(R.id.cwy);
        final EditText editText2 = (EditText) this.nTd.findViewById(R.id.cwy);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42529);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42529);
            }
        });
        TextView textView = (TextView) this.obC.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42530);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                    SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                    SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(42530);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42531);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.obC, 2);
                SnsLuckyMoneyPrepareUI.this.V(SnsLuckyMoneyPrepareUI.this.nTd, 0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42531);
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
        ab.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.nTd.getInput());
        this.obC.setMaxLen(12);
        if (this.obJ) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(R.string.crb);
                String string2 = getString(R.string.cr9);
                String string3 = getString(R.string.cra);
                String string4 = getString(R.string.cr_);
                final SpannableString spannableString = new SpannableString(string + string2);
                j jVar = new j(this);
                spannableString.setSpan(jVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                j jVar2 = new j(this);
                spannableString2.setSpan(jVar2, string3.length(), string3.length() + string4.length(), 33);
                jVar.tHw = new j.a() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42520);
                        int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 0;
                        SnsLuckyMoneyPrepareUI.this.obC.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.obC.setShowGroupIcon(false);
                        SnsLuckyMoneyPrepareUI.this.obC.setTitle(SnsLuckyMoneyPrepareUI.this.getString(R.string.ctp));
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.obC.setAmount(e.F(input2 / ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.obC.setMaxAmount(SnsLuckyMoneyPrepareUI.this.nSs.nRP);
                        SnsLuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                        h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(3));
                        AppMethodBeat.o(42520);
                    }
                };
                jVar2.tHw = new j.a() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42524);
                        int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 1;
                        SnsLuckyMoneyPrepareUI.this.obC.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.obC.setTitle(SnsLuckyMoneyPrepareUI.this.getString(R.string.cto));
                        SnsLuckyMoneyPrepareUI.this.obC.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.obC.setAmount(e.F(input2 * ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.obC.setMaxAmount(SnsLuckyMoneyPrepareUI.this.nSs.nRR);
                        SnsLuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                        h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(2));
                        AppMethodBeat.o(42524);
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
        this.nTg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42526);
                h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(4));
                if (SnsLuckyMoneyPrepareUI.this.obC.bKW() != 0) {
                    t.makeText(SnsLuckyMoneyPrepareUI.this.mController.ylL, R.string.f9y, 0).show();
                    AppMethodBeat.o(42526);
                    return;
                }
                long H;
                m aoVar;
                int input = SnsLuckyMoneyPrepareUI.this.nTd.getInput();
                double input2 = SnsLuckyMoneyPrepareUI.this.obC.getInput();
                long j = 0;
                if (SnsLuckyMoneyPrepareUI.this.mType == 1) {
                    H = e.H(input2);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(356354, Integer.valueOf(input));
                } else {
                    H = e.H(((double) input) * input2);
                    j = e.H(input2);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(356353, Integer.valueOf(input));
                }
                String input3 = SnsLuckyMoneyPrepareUI.this.nTf.getInput();
                if (bo.isNullOrNil(input3)) {
                    input3 = SnsLuckyMoneyPrepareUI.this.getString(R.string.cqe);
                }
                String stringExtra = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
                if (!SnsLuckyMoneyPrepareUI.this.obJ || bo.isNullOrNil(stringExtra)) {
                    aoVar = new ao(input, H, j, SnsLuckyMoneyPrepareUI.this.mType, input3, x.bLC(), null, null, r.Yz(), r.YB(), SnsLuckyMoneyPrepareUI.this.obG, "");
                } else {
                    aoVar = new ao(input, H, j, SnsLuckyMoneyPrepareUI.this.mType, input3, x.bLC(), stringExtra, x.mI(stringExtra), r.Yz(), r.YB(), SnsLuckyMoneyPrepareUI.this.obG, "");
                }
                SnsLuckyMoneyPrepareUI.this.b(aoVar, false);
                if (SnsLuckyMoneyPrepareUI.this.gII != null) {
                    SnsLuckyMoneyPrepareUI.this.gII.show();
                    AppMethodBeat.o(42526);
                    return;
                }
                SnsLuckyMoneyPrepareUI.this.gII = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(42525);
                        if (SnsLuckyMoneyPrepareUI.this.gII != null && SnsLuckyMoneyPrepareUI.this.gII.isShowing()) {
                            SnsLuckyMoneyPrepareUI.this.gII.hide();
                        }
                        if (SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || SnsLuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                            ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                            SnsLuckyMoneyPrepareUI.this.finish();
                        }
                        SnsLuckyMoneyPrepareUI.this.ocz.bLz();
                        AppMethodBeat.o(42525);
                    }
                });
                AppMethodBeat.o(42526);
            }
        });
        this.kGm.setText(e.G(0.0d));
        this.nTn.a(this.nTd);
        this.nTn.a(this.obC);
        this.nTn.a(this.nTf);
        this.nTn.i((TextView) findViewById(R.id.czq));
        if (this.obJ && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(R.id.cz8);
            textView2.setText(getString(R.string.cs0, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.gGo = new ap(new ap.a() {
            public final boolean BI() {
                double d;
                AppMethodBeat.i(42527);
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
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + SnsLuckyMoneyPrepareUI.this.nTn.bMz());
                SnsLuckyMoneyPrepareUI.this.gGo.doT();
                AppMethodBeat.o(42527);
                return false;
            }
        }, false);
        if (this.hJh != null) {
            this.hJh.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(42528);
                    if (motionEvent.getAction() == 0) {
                        SnsLuckyMoneyPrepareUI.this.aoB();
                        SnsLuckyMoneyPrepareUI.this.aqX();
                    }
                    AppMethodBeat.o(42528);
                    return false;
                }
            });
        }
        this.obC.setType(this.mType);
        if (this.obJ && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.obC.requestFocus();
            AppMethodBeat.o(42534);
            return;
        }
        this.nTd.requestFocus();
        AppMethodBeat.o(42534);
    }

    public void onDestroy() {
        AppMethodBeat.i(42535);
        super.onDestroy();
        this.nTn.clear();
        this.gGo.doT();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        AppMethodBeat.o(42535);
    }

    public final int getLayoutId() {
        return R.layout.aai;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(42536);
        if (keyEvent.getKeyCode() == 4 && this.obD.getVisibility() == 0) {
            this.obD.setVisibility(8);
            bMp();
            AppMethodBeat.o(42536);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(42536);
        return dispatchKeyEvent;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42537);
        if (mVar instanceof ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.hide();
            }
            if (i == 0 && i2 == 0) {
                ao aoVar = (ao) mVar;
                this.obI = aoVar.kCd;
                this.obH = aoVar.nSX;
                this.obK = aoVar.nYY;
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = aoVar.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                AppMethodBeat.o(42537);
                return true;
            } else if (i2 == 401) {
                this.nTg.setEnabled(false);
                this.nTg.setClickable(false);
                this.gGo.ae(5000, 5000);
                com.tencent.mm.ui.base.h.bQ(this, str);
                AppMethodBeat.o(42537);
                return true;
            } else {
                com.tencent.mm.ui.base.h.bQ(this, str);
                AppMethodBeat.o(42537);
                return true;
            }
        }
        if (mVar instanceof ar) {
            if (i == 0 && i2 == 0) {
                if (this.obJ) {
                    com.tencent.mm.ui.base.h.bQ(this, getString(R.string.cbn));
                    finish();
                } else {
                    bMq();
                    this.obE.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42509);
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            SnsLuckyMoneyPrepareUI.this.mController.ylL.startActivity(intent);
                            SnsLuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.o(42509);
                        }
                    }, 1000);
                }
                AppMethodBeat.o(42537);
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.h.d(this.mController.ylL, str, "", getString(R.string.ct5), getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42510);
                        Intent intent = new Intent();
                        intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        SnsLuckyMoneyPrepareUI.this.startActivity(intent);
                        AppMethodBeat.o(42510);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(42537);
                return true;
            }
        } else if (mVar instanceof ag) {
            if (i == 0 && i2 == 0) {
                final ag agVar = (ag) mVar;
                com.tencent.mm.plugin.luckymoney.b.a.bKN();
                this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
                ab.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nSs);
                if (this.mType == 1) {
                    this.obC.setMaxAmount(this.nSs.nRR);
                } else {
                    this.obC.setMaxAmount(this.nSs.nRP);
                }
                this.obC.setMinAmount(this.nSs.nRQ);
                this.nTd.setMaxNum(this.nSs.nRO);
                if (agVar.nYE && this.obJ) {
                    TextView textView = (TextView) findViewById(R.id.czi);
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42511);
                            h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(9));
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyCanShareListUI.class);
                            SnsLuckyMoneyPrepareUI.this.startActivity(intent);
                            AppMethodBeat.o(42511);
                        }
                    });
                    h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(8));
                    textView.setVisibility(0);
                }
                if (bo.isNullOrNil(agVar.kCx)) {
                    this.nTl.setVisibility(8);
                } else {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + agVar.kCx);
                    this.nTl.setText(agVar.kCx);
                    if (!bo.isNullOrNil(agVar.nYG)) {
                        this.nTl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42512);
                                e.n(SnsLuckyMoneyPrepareUI.this.mController.ylL, agVar.nYG, false);
                                AppMethodBeat.o(42512);
                            }
                        });
                    }
                    this.nTl.setVisibility(0);
                }
                c cVar = new c();
                cVar.textColor = getResources().getColor(R.color.a4m);
                com.tencent.mm.plugin.luckymoney.ui.h.a(this, this.obF, agVar.nYI, cVar);
            }
            AppMethodBeat.o(42537);
            return true;
        }
        AppMethodBeat.o(42537);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(42538);
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(5));
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.obJ && !bo.isNullOrNil(stringExtra)) {
                        com.tencent.mm.ui.base.h.bQ(this, getString(R.string.cbn));
                        Map z = br.z(this.obK, "msg");
                        if (z != null) {
                            str = (String) z.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.b.a.bKN().bKQ().Qh(str)) {
                                ab.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!x.E(this.obK, stringExtra, 1)) {
                                    ab.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    com.tencent.mm.plugin.luckymoney.b.a.bKN().bKQ().Qi(str);
                                }
                            } else {
                                ab.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        }
                        ab.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        AppMethodBeat.o(42538);
                        return;
                    }
                    bMq();
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42513);
                            SnsLuckyMoneyPrepareUI.this.obD.setVisibility(0);
                            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(800);
                            scaleAnimation.setStartOffset(200);
                            scaleAnimation.setInterpolator(new BounceInterpolator());
                            SnsLuckyMoneyPrepareUI.this.findViewById(R.id.czl).startAnimation(scaleAnimation);
                            AppMethodBeat.o(42513);
                        }
                    }, 200);
                    this.leS.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42515);
                            h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.d(SnsLuckyMoneyPrepareUI.this)), Integer.valueOf(6));
                            x.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.this.mType, SnsLuckyMoneyPrepareUI.this.obI, false);
                            SnsLuckyMoneyPrepareUI.this.obD.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(42514);
                                    SnsLuckyMoneyPrepareUI.this.obD.setVisibility(8);
                                    SnsLuckyMoneyPrepareUI.n(SnsLuckyMoneyPrepareUI.this);
                                    AppMethodBeat.o(42514);
                                }
                            }, 100);
                            AppMethodBeat.o(42515);
                        }
                    });
                    ((ImageView) findViewById(R.id.czn)).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42516);
                            SnsLuckyMoneyPrepareUI.this.obD.setVisibility(8);
                            SnsLuckyMoneyPrepareUI.o(SnsLuckyMoneyPrepareUI.this);
                            AppMethodBeat.o(42516);
                        }
                    });
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
                h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(7), str);
                if (!bo.isNullOrNil(str)) {
                    n(new ar(str.replaceAll(",", "|"), this.obH, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(42538);
    }

    /* Access modifiers changed, original: protected|final */
    public final void V(View view, final int i) {
        AppMethodBeat.i(42539);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        final EditText editText = (EditText) view.findViewById(R.id.cwy);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.o(42539);
            return;
        }
        e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(42519);
                if (!view.isFocused() || this.gnT) {
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42518);
                            SnsLuckyMoneyPrepareUI.this.aoB();
                            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(42518);
                        }
                    }, 200);
                    AppMethodBeat.o(42519);
                    return;
                }
                ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42517);
                        if (!SnsLuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                        }
                        SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i);
                        SnsLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(42517);
                    }
                }, 300);
                AppMethodBeat.o(42519);
            }
        });
        editText.setOnClickListener(new OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.i(42521);
                if (SnsLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        SnsLuckyMoneyPrepareUI.this.aoB();
                        ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.o(42521);
                    return;
                }
                SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i);
                AppMethodBeat.o(42521);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(42522);
                    if (SnsLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (this.gnT) {
                            SnsLuckyMoneyPrepareUI.this.aoB();
                            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                        AppMethodBeat.o(42522);
                        return;
                    }
                    SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                    SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.this, i);
                    AppMethodBeat.o(42522);
                }
            });
        }
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42523);
                SnsLuckyMoneyPrepareUI.this.aoB();
                AppMethodBeat.o(42523);
            }
        });
        AppMethodBeat.o(42539);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(42540);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            aoB();
            AppMethodBeat.o(42540);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(42540);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.i(42541);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            this.obM.ic(false);
        }
        AppMethodBeat.o(42541);
    }

    public final void bLa() {
        double d;
        double d2;
        int input;
        AppMethodBeat.i(42542);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
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
                this.nTn.Dv(getString(R.string.ctn, new Object[]{Math.round(this.nSs.nRR), bo.bc(this.nSs.nRU, "")}));
                input = 1;
            } else if (d > 0.0d) {
                int i;
                boolean i2;
                if (this.mType == 0) {
                    if (d > this.nSs.nRP && this.nSs.nRP > 0.0d) {
                        this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(this.nSs.nRP), bo.bc(this.nSs.nRU, "")}));
                        i2 = 1;
                    }
                    i2 = false;
                } else {
                    if (d > this.nSs.nRS && this.nSs.nRS > 0.0d) {
                        this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(this.nSs.nRS), bo.bc(this.nSs.nRU, "")}));
                        this.nTd.onError();
                        this.obC.onError();
                        i2 = 1;
                    }
                    i2 = false;
                }
                if (i2 == 0) {
                    if (this.mType == 0) {
                        if (d < this.nSs.nRQ) {
                            this.nTn.Dv(getString(R.string.csd, new Object[]{e.F(this.nSs.nRQ), bo.bc(this.nSs.nRU, "")}));
                            input = 1;
                        }
                    } else if (d < 0.01d) {
                        this.nTn.Dv(getString(R.string.csd, new Object[]{"0.01", bo.bc(this.nSs.nRU, "")}));
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
        this.kGm.setText(e.G(d2));
        AppMethodBeat.o(42542);
    }

    private int bMh() {
        AppMethodBeat.i(42543);
        if (!this.obJ) {
            AppMethodBeat.o(42543);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.o(42543);
            return 2;
        } else {
            AppMethodBeat.o(42543);
            return 1;
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        AppMethodBeat.i(42545);
        if (!(snsLuckyMoneyPrepareUI.nTi == null || snsLuckyMoneyPrepareUI.nTi.isShown())) {
            snsLuckyMoneyPrepareUI.nTi.setVisibility(0);
            snsLuckyMoneyPrepareUI.obM.ic(true);
        }
        AppMethodBeat.o(42545);
    }

    static /* synthetic */ void b(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, int i) {
        AppMethodBeat.i(42548);
        snsLuckyMoneyPrepareUI.mKeyboard.setXMode(i);
        AppMethodBeat.o(42548);
    }
}
