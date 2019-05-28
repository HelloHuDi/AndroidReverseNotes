package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.api.k;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.d;
import com.tencent.mm.plugin.luckymoney.model.f;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements g {
    private int cKs = 0;
    private int emC;
    private ap gGo = null;
    private Dialog gII = null;
    private TextView kGm = null;
    private TextView kGq;
    private EmojiInfo kZa;
    private Button leS = null;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private i nSs;
    private LuckyMoneyNumInputView nTd = null;
    private LuckyMoneyTextInputView nTf = null;
    private Button nTg = null;
    protected View nTi;
    private MMScrollView nTk;
    private TextView nTl;
    private b nTn = new b();
    private d nWN;
    private int nYN;
    private LuckyMoneyMoneyInputView obC = null;
    private View obD;
    private View obE;
    private ViewGroup obF;
    private int obG;
    private String obH;
    private int obI;
    private boolean obJ;
    private String obK;
    private int obL;
    private String ocI = "";
    private a odS;
    private View odT;
    private ChatFooterPanel odY;
    private ViewGroup oea;
    private aa oec;
    private int oef = 0;
    private int ogb = 1;
    private String ogi;
    private String ogm = "";
    private long ohA;
    private String ohB;
    private com.tencent.mm.ui.widget.d ohC;
    private boolean ohD = false;
    private boolean ohE = false;
    private boolean ohF = false;
    private boolean ohG = false;
    private c<qq> ohH = new c<qq>() {
        {
            AppMethodBeat.i(42960);
            this.xxI = qq.class.getName().hashCode();
            AppMethodBeat.o(42960);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(42961);
            final a aVar = ((qq) bVar).cMN.cMO;
            if (aVar != null && aVar.cPa()) {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
                LuckyMoneyPrepareUI.this.ohG = true;
                h.d(LuckyMoneyPrepareUI.this.mController.ylL, aVar.cEh, "", aVar.nZc, aVar.nZb, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42958);
                        ab.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", aVar.kCs);
                        e.n(LuckyMoneyPrepareUI.this.mController.ylL, aVar.kCs, false);
                        LuckyMoneyPrepareUI.this.ohG = false;
                        AppMethodBeat.o(42958);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42959);
                        LuckyMoneyPrepareUI.this.ohG = false;
                        AppMethodBeat.o(42959);
                    }
                });
            }
            AppMethodBeat.o(42961);
            return false;
        }
    };
    private Dialog ohk = null;
    private Dialog ohl = null;
    private RelativeLayout ohm;
    private TextView ohn;
    private ImageView oho;
    private TextView ohp;
    private int ohq = 1;
    private String ohr = e.atr("CNY");
    private String ohs = null;
    private RealnameGuideHelper oht;
    private String ohu;
    private com.tencent.mm.g.b.a.ab ohv;
    private int ohw;
    private String ohx;
    private int ohy;
    private long ohz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyPrepareUI() {
        AppMethodBeat.i(42993);
        AppMethodBeat.o(42993);
    }

    static /* synthetic */ int g(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(43022);
        int bMh = luckyMoneyPrepareUI.bMh();
        AppMethodBeat.o(43022);
        return bMh;
    }

    static /* synthetic */ void x(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(43025);
        luckyMoneyPrepareUI.yj(1);
        AppMethodBeat.o(43025);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42994);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.u4));
        Nc(WebView.NIGHT_MODE_COLOR);
        dyb();
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.obG = getIntent().getIntExtra("key_way", 3);
        this.emC = getIntent().getIntExtra("key_from", 0);
        this.obJ = this.emC == 1;
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        iN(false);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nWN = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLv();
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.obG + "mChannel:" + this.obL);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.obJ + ", config " + this.nSs);
        initView();
        com.tencent.mm.sdk.b.a.xxA.b(this.ohH);
        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(1));
        AppMethodBeat.o(42994);
    }

    public void onResume() {
        AppMethodBeat.i(42995);
        super.onResume();
        nf(1970);
        AppMethodBeat.o(42995);
    }

    public void onStop() {
        AppMethodBeat.i(42996);
        super.onStop();
        ng(1970);
        AppMethodBeat.o(42996);
    }

    public final void initView() {
        AppMethodBeat.i(42997);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42941);
                LuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(42941);
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
        this.nTk = (MMScrollView) findViewById(R.id.cz3);
        this.nTl = (TextView) findViewById(R.id.cz4);
        this.ohm = (RelativeLayout) findViewById(R.id.cz_);
        this.ohn = (TextView) findViewById(R.id.czf);
        this.oho = (ImageView) findViewById(R.id.czb);
        this.ohp = (TextView) findViewById(R.id.czd);
        this.odS = new a(this);
        this.odT = getLayoutInflater().inflate(R.layout.aa3, null);
        this.odS.setContentView(this.odT, new LayoutParams(-1, -1));
        this.odT.findViewById(R.id.cvw).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42952);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42952);
            }
        });
        this.odS.obT = new a() {
            public final void bMl() {
                AppMethodBeat.i(42966);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42966);
            }
        };
        this.oea = (ViewGroup) this.odT.findViewById(R.id.cvy);
        this.odY = com.tencent.mm.pluginsdk.ui.chat.e.vom.dF(this.mController.ylL);
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(this.odY);
        if (this.mType == 1) {
            setMMTitle((int) R.string.cr6);
            this.obC.setTitle(getString(R.string.cto));
            this.obC.setShowGroupIcon(true);
        } else {
            setMMTitle((int) R.string.crz);
            this.obC.setTitle(getString(R.string.ctp));
            this.obC.setShowGroupIcon(false);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.tencent.mm.bz.a.al(this, R.dimen.a4p));
        if (this.mType == 1) {
            layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 13);
            layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 13);
        } else {
            layoutParams.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 16);
            layoutParams2.topMargin = com.tencent.mm.bz.a.fromDPToPix(this.mController.ylL, 16);
        }
        this.nTf.setLayoutParams(layoutParams);
        this.ohm.setLayoutParams(layoutParams2);
        this.obC.setOnInputValidChangerListener(this);
        this.obC.setHint(getString(R.string.crl));
        this.nTd.setOnInputValidChangerListener(this);
        this.nTd.setHint(getString(R.string.cs1));
        this.nTf.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.obC.findViewById(R.id.cwy);
        final EditText editText2 = (EditText) this.nTd.findViewById(R.id.cwy);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(42950);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                editText.setContentDescription(editable.toString());
                AppMethodBeat.o(42950);
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(42951);
                editText2.setContentDescription(editable.toString());
                AppMethodBeat.o(42951);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42953);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.nTd, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.o(42953);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.obC.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42954);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.obC, 2);
                    LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.nTd, 0);
                    LuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                    AppMethodBeat.o(42954);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42955);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.nTd, 0);
                LuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.o(42955);
            }
        });
        ((MMEditText) this.nTf.findViewById(R.id.d0f)).setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(42956);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.obC, 2);
                LuckyMoneyPrepareUI.this.V(LuckyMoneyPrepareUI.this.nTd, 0);
                AppMethodBeat.o(42956);
            }
        });
        if (this.nSs != null) {
            if (this.mType == 1) {
                this.obC.setMaxAmount(this.nSs.nRR);
            } else {
                this.obC.setMaxAmount(this.nSs.nRP);
            }
            this.obC.setMinAmount(this.nSs.nRQ);
            if (this.nSs.kCv != 1) {
                eX(this.nSs.nRU, this.nSs.nRT);
            }
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
        if (bML()) {
            this.nTg.setText(getString(R.string.csl, new Object[]{this.nSs.nWL}));
        }
        if (this.obJ || this.emC == 2) {
            if (bML()) {
                setMMTitle(getString(R.string.ctm, new Object[]{this.nSs.nWL}));
            } else {
                setMMTitle((int) R.string.ctl);
            }
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.obJ && intExtra == 0) {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.nTd.setVisibility(8);
            } else {
                String str;
                String string = getString(R.string.cqu);
                String string2 = getString(R.string.cr9);
                String string3 = getString(R.string.cqo);
                String string4 = getString(R.string.cr_);
                if (!this.obJ || intExtra <= 0) {
                    if (this.emC == 2) {
                        ab.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                        this.nTf.setVisibility(8);
                    }
                    str = string;
                } else {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", Integer.valueOf(intExtra));
                    str = getString(R.string.crb);
                    string = getString(R.string.cra);
                    TextView textView2 = (TextView) findViewById(R.id.cz8);
                    textView2.setText(getString(R.string.cs0, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                }
                final j jVar = new j(this);
                jVar.mColor = getResources().getColor(R.color.ue);
                final SpannableString spannableString = new SpannableString(str + string2);
                spannableString.setSpan(jVar, str.length(), str.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                final j jVar2 = new j(this);
                jVar2.mColor = getResources().getColor(R.color.ue);
                spannableString2.setSpan(jVar2, string3.length(), string3.length() + string4.length(), 33);
                this.obC.setGroupIconIv(R.drawable.b9t);
                jVar.tHw = new j.a() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42980);
                        int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = LuckyMoneyPrepareUI.this.obC.getInput();
                        LuckyMoneyPrepareUI.this.mType = 0;
                        LuckyMoneyPrepareUI.this.obC.setType(LuckyMoneyPrepareUI.this.mType);
                        LuckyMoneyPrepareUI.this.obC.setShowGroupIcon(false);
                        LuckyMoneyPrepareUI.this.obC.setTitle(LuckyMoneyPrepareUI.this.getString(R.string.ctp));
                        if (input2 > 0.0d && input > 0) {
                            LuckyMoneyPrepareUI.this.obC.setAmount(e.F(input2 / ((double) input)));
                        }
                        LuckyMoneyPrepareUI.this.obC.setMaxAmount(LuckyMoneyPrepareUI.this.nSs.nRP);
                        LuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(3));
                        AppMethodBeat.o(42980);
                    }
                };
                jVar2.tHw = new j.a() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(42988);
                        int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                        double input2 = LuckyMoneyPrepareUI.this.obC.getInput();
                        LuckyMoneyPrepareUI.this.mType = 1;
                        LuckyMoneyPrepareUI.this.obC.setType(LuckyMoneyPrepareUI.this.mType);
                        LuckyMoneyPrepareUI.this.obC.setMaxAmount(LuckyMoneyPrepareUI.this.nSs.nRR);
                        LuckyMoneyPrepareUI.this.obC.setTitle(LuckyMoneyPrepareUI.this.getString(R.string.cto));
                        LuckyMoneyPrepareUI.this.obC.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            LuckyMoneyPrepareUI.this.obC.setAmount(e.F(input2 * ((double) input)));
                        }
                        LuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(2));
                        AppMethodBeat.o(42988);
                    }
                };
                this.kGq.setMovementMethod(LinkMovementMethod.getInstance());
                if (com.tencent.mm.ui.a.a.a.yqY.dzj()) {
                    this.kGq.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42989);
                            if (!com.tencent.mm.ui.a.a.a.yqY.dzj()) {
                                AppMethodBeat.o(42989);
                            } else if (LuckyMoneyPrepareUI.this.kGq.getText().toString().equals(spannableString.toString())) {
                                jVar.onClick(view);
                                AppMethodBeat.o(42989);
                            } else {
                                jVar2.onClick(view);
                                AppMethodBeat.o(42989);
                            }
                        }
                    });
                }
                this.kGq.setTextColor(getResources().getColor(R.color.h7));
                this.kGq.setText(spannableString);
                this.kGq.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.kGq.setText(this.nSs.nWH);
            this.kGq.setVisibility(0);
        } else if (this.mType == 0) {
            this.kGq.setText(this.nSs.nWI);
            this.kGq.setVisibility(0);
        }
        this.nTg.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(42990);
                LuckyMoneyPrepareUI.this.oec = new aa();
                LuckyMoneyPrepareUI.this.oec.cVT = 6;
                LuckyMoneyPrepareUI.this.oec.ajK();
                LuckyMoneyPrepareUI.i(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42990);
            }
        });
        this.nTn.a(this.nTd);
        this.nTn.a(this.obC);
        this.nTn.a(this.nTf);
        this.nTn.i((TextView) findViewById(R.id.czq));
        this.gGo = new ap(new ap.a() {
            public final boolean BI() {
                double d;
                AppMethodBeat.i(42991);
                if (LuckyMoneyPrepareUI.this.obC.bKW() == 3 || LuckyMoneyPrepareUI.this.nTd.bKW() == 3) {
                    d = 0.0d;
                } else {
                    int input = LuckyMoneyPrepareUI.this.nTd.getInput();
                    d = LuckyMoneyPrepareUI.this.obC.getInput();
                    if (LuckyMoneyPrepareUI.this.mType == 0) {
                        d *= (double) input;
                    }
                }
                if (d == 0.0d || d > LuckyMoneyPrepareUI.this.nSs.nRR || LuckyMoneyPrepareUI.this.nTn.bMz()) {
                    LuckyMoneyPrepareUI.this.nTg.setClickable(false);
                    LuckyMoneyPrepareUI.this.nTg.setEnabled(false);
                } else {
                    LuckyMoneyPrepareUI.this.nTg.setClickable(true);
                    LuckyMoneyPrepareUI.this.nTg.setEnabled(true);
                }
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + LuckyMoneyPrepareUI.this.nTn.bMz());
                LuckyMoneyPrepareUI.this.gGo.doT();
                AppMethodBeat.o(42991);
                return false;
            }
        }, false);
        if (this.nTk != null) {
            this.nTk.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(42992);
                    if (motionEvent.getAction() == 0) {
                        LuckyMoneyPrepareUI.this.aoB();
                        LuckyMoneyPrepareUI.this.aqX();
                    }
                    AppMethodBeat.o(42992);
                    return false;
                }
            });
        }
        this.obC.setType(this.mType);
        init();
        this.ohm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42947);
                ab.d("MicroMsg.LuckyMoneyPrepareUI", "click envelope layout");
                final Dialog er = x.er(LuckyMoneyPrepareUI.this.mController.ylL);
                f bLp = f.bLp();
                bLp.b(new com.tencent.mm.plugin.luckymoney.model.c(""));
                bLp.a(new com.tencent.mm.wallet_core.c.a.a<aoj>() {
                    public final /* synthetic */ void bX(Object obj) {
                        AppMethodBeat.i(42946);
                        aoj aoj = (aoj) obj;
                        if (er != null && er.isShowing()) {
                            er.dismiss();
                        }
                        ab.i("MicroMsg.LuckyMoneyPrepareUI", "do get show source net callback");
                        if (aoj != null) {
                            ab.i("MicroMsg.LuckyMoneyPrepareUI", "retcode: %s", Integer.valueOf(aoj.kCl));
                            if (aoj.kCl == 0) {
                                Intent intent = new Intent(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPickEnvelopeUI.class);
                                try {
                                    intent.putExtra(com.tencent.mm.ui.e.f.yfY, aoj.toByteArray());
                                } catch (Exception e) {
                                    ab.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", e, "", new Object[0]);
                                }
                                LuckyMoneyPrepareUI.this.startActivityForResult(intent, 5);
                                LuckyMoneyPrepareUI.this.ohp.setVisibility(8);
                                com.tencent.mm.x.c.PK().c(ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC);
                                AppMethodBeat.o(42946);
                                return;
                            }
                            e.atC(aoj.kCm);
                            AppMethodBeat.o(42946);
                            return;
                        }
                        e.aj(LuckyMoneyPrepareUI.this.mController.ylL, "");
                        AppMethodBeat.o(42946);
                    }

                    public final /* bridge */ /* synthetic */ void bY(Object obj) {
                    }
                });
                com.tencent.mm.plugin.report.service.h.pYm.e(16822, Integer.valueOf(1));
                AppMethodBeat.o(42947);
            }
        });
        if (com.tencent.mm.x.c.PK().a(ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_STRING_SYNC, ac.a.USERINFO_LUCKY_MONEY_FIRST_NEW_FLAG_HOME_STRING_SYNC)) {
            this.ohp.setVisibility(0);
        }
        if (this.nWN != null) {
            a(this.nWN.nWu);
        }
        AppMethodBeat.o(42997);
    }

    public void onBackPressed() {
        AppMethodBeat.i(42998);
        finish();
        AppMethodBeat.o(42998);
    }

    private void yj(int i) {
        AppMethodBeat.i(42999);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() userConfirmJump:%s", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(4));
        com.tencent.mm.plugin.report.service.h.pYm.e(15511, Integer.valueOf(this.ohq), Integer.valueOf(2));
        if (this.obC.bKW() != 0) {
            t.makeText(this.mController.ylL, R.string.f9y, 0).show();
            AppMethodBeat.o(42999);
            return;
        }
        long H;
        int input = this.nTd.getInput();
        double input2 = this.obC.getInput();
        long j = 0;
        if (this.mType == 1) {
            H = e.H(input2);
            g.RQ();
            g.RP().Ry().set(356354, Integer.valueOf(input));
        } else {
            H = e.H(((double) input) * input2);
            j = e.H(input2);
            g.RQ();
            g.RP().Ry().set(356353, Integer.valueOf(input));
        }
        String replace = this.nTf.getInput().replace("\r", "").replace(IOUtils.LINE_SEPARATOR_UNIX, "");
        if (bo.isNullOrNil(replace)) {
            replace = bo.isNullOrNil(this.ohs) ? getString(R.string.cqe) : this.ohs;
        }
        aoB();
        if (this.emC == 2) {
            b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(input, (int) H, this.mType, (int) j), false);
        } else {
            String stringExtra = getIntent().getStringExtra("key_username");
            if (this.ohq == 1) {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick() ifGetConfig=%s mUniqueId=%s waitingGetConfig=%s ifAutoRMBPrePareBtn=%s", Boolean.valueOf(this.ohD), bo.nullAsNil(this.ogi), Boolean.valueOf(this.ohE), Boolean.valueOf(this.ohF));
                if (this.ohD) {
                    a(i, stringExtra, input, H, j, replace);
                    AppMethodBeat.o(42999);
                    return;
                }
                this.ohF = true;
                this.ohw = i;
                this.ohx = stringExtra;
                this.ohy = input;
                this.ohz = H;
                this.ohA = j;
                this.ohB = replace;
                if (this.ohl != null) {
                    this.ohl.show();
                } else {
                    this.ohl = h.a((Context) this, 3, (int) R.style.kd, getString(R.string.cn5), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(42942);
                            ab.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
                            LuckyMoneyPrepareUI.this.ohF = false;
                            LuckyMoneyPrepareUI.this.ohE = false;
                            if (LuckyMoneyPrepareUI.this.ohl != null && LuckyMoneyPrepareUI.this.ohl.isShowing()) {
                                LuckyMoneyPrepareUI.this.ohl.dismiss();
                            }
                            if (LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                                ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                LuckyMoneyPrepareUI.this.finish();
                            }
                            LuckyMoneyPrepareUI.this.ocz.bLz();
                            AppMethodBeat.o(42942);
                        }
                    });
                }
                if (!this.ohE) {
                    iN(false);
                }
                AppMethodBeat.o(42999);
                return;
            }
            m ahVar;
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "currency=%s userConfiremJump:%s", Integer.valueOf(this.ohq), Integer.valueOf(i));
            nf(1647);
            if (!this.obJ || bo.isNullOrNil(stringExtra)) {
                ahVar = new ah(input, H, j, this.mType, replace, null, x.bLC(), r.Yz(), this.ohq);
            } else {
                ahVar = new ah(input, H, j, this.mType, replace, stringExtra, x.bLC(), r.Yz(), this.ohq);
            }
            b(ahVar, false);
        }
        bMK();
        AppMethodBeat.o(42999);
    }

    private void bMK() {
        AppMethodBeat.i(43000);
        if (this.gII != null) {
            this.gII.show();
            AppMethodBeat.o(43000);
            return;
        }
        this.gII = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42943);
                if (LuckyMoneyPrepareUI.this.gII != null && LuckyMoneyPrepareUI.this.gII.isShowing()) {
                    LuckyMoneyPrepareUI.this.gII.dismiss();
                }
                if (LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyPrepareUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                    LuckyMoneyPrepareUI.this.finish();
                }
                LuckyMoneyPrepareUI.this.ocz.bLz();
                AppMethodBeat.o(42943);
            }
        });
        AppMethodBeat.o(43000);
    }

    private void a(int i, String str, int i2, long j, long j2, String str2) {
        m aoVar;
        AppMethodBeat.i(43001);
        String str3 = "";
        int i3 = 0;
        if (this.kZa != null) {
            str3 = this.kZa.Aq();
            i3 = this.kZa.field_type;
        }
        String str4 = "";
        if (this.nWN != null) {
            str4 = this.nWN.nWv;
        }
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB. userConfirmJump:%s lastPayResult:%s mSendId:%s mUniqueId:%s", Integer.valueOf(i), Integer.valueOf(this.cKs), this.ocI, this.ogi);
        if (!this.obJ || bo.isNullOrNil(str)) {
            aoVar = new ao(i2, j, j2, this.mType, str2, x.bLC(), null, null, r.Yz(), r.YB(), this.obG, str4, this.ogi, i, this.cKs, this.ocI, str3, i3);
        } else {
            aoVar = new ao(i2, j, j2, this.mType, str2, x.bLC(), str, x.mI(str), r.Yz(), r.YB(), this.obG, str4, this.ogi, i, this.cKs, this.ocI, str3, i3);
        }
        b(aoVar, false);
        if (!bo.isNullOrNil(str4)) {
            com.tencent.mm.plugin.report.service.h.pYm.k(991, 11, 1);
        }
        bMK();
        AppMethodBeat.o(43001);
    }

    private void init() {
        AppMethodBeat.i(43002);
        if (this.ohq == 1) {
            addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(42944);
                    LuckyMoneyPrepareUI.u(LuckyMoneyPrepareUI.this);
                    AppMethodBeat.o(42944);
                    return true;
                }
            });
            AppMethodBeat.o(43002);
            return;
        }
        addIconOptionMenu(0, R.drawable.sc, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42945);
                if (LuckyMoneyPrepareUI.this.nSs == null || bo.isNullOrNil(LuckyMoneyPrepareUI.this.nSs.nWK)) {
                    e.n(LuckyMoneyPrepareUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                } else {
                    e.n(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPrepareUI.this.nSs.nWK, false);
                }
                AppMethodBeat.o(42945);
                return true;
            }
        });
        AppMethodBeat.o(43002);
    }

    private void a(atb atb) {
        AppMethodBeat.i(43003);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "update envelope");
        if (this.nWN == null || atb == null || this.emC == 2) {
            this.ohm.setVisibility(8);
        } else {
            this.ohm.setVisibility(0);
            if (this.nWN.nWw && !bo.isNullOrNil(this.nWN.nWx)) {
                List<String> hT = bo.hT((String) g.RP().Ry().get(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, (Object) ""), ",");
                for (String equals : hT) {
                    if (equals.equals(this.nWN.nWu.materialId)) {
                        ab.d("MicroMsg.LuckyMoneyPrepareUI", "has alert illegal: %s", (String) r2.next());
                        AppMethodBeat.o(43003);
                        return;
                    }
                }
                hT.add(this.nWN.nWu.materialId);
                g.RP().Ry().set(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_ILLEGAL_STRING_SYNC, bo.c((List) hT, ","));
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "show alert illegal: %s", this.nWN.nWu.materialId);
                h.a(this.mController.ylL, this.nWN.nWx, "", getString(R.string.g0z), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        if (atb == null || bo.isNullOrNil(atb.wwP)) {
            this.oho.setImageBitmap(null);
            this.ohn.setText("");
            AppMethodBeat.o(43003);
            return;
        }
        this.ohn.setText(atb.wwP);
        ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.oho, atb);
        AppMethodBeat.o(43003);
    }

    public void onDestroy() {
        AppMethodBeat.i(43004);
        super.onDestroy();
        this.nTn.clear();
        this.gGo.doT();
        if (this.gII != null && this.gII.isShowing()) {
            this.gII.dismiss();
        }
        if (this.odY != null) {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "commentfooter release");
            this.odY.onPause();
            this.odY.AC();
            this.odY.destroy();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.ohH);
        AppMethodBeat.o(43004);
    }

    private void iN(boolean z) {
        AppMethodBeat.i(43005);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "do get config");
        if (z) {
            this.ohk = x.er(this.mController.ylL);
        }
        this.ohE = true;
        b(new ag("v1.0", ((Integer) g.RP().Ry().get(ac.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(0))).intValue(), (byte) 0), false);
        AppMethodBeat.o(43005);
    }

    public final int getLayoutId() {
        return R.layout.aai;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(43006);
        if (keyEvent.getKeyCode() == 4 && this.obD.getVisibility() == 0) {
            this.obD.setVisibility(8);
            bMp();
            AppMethodBeat.o(43006);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(43006);
        return dispatchKeyEvent;
    }

    public final boolean c(int i, int i2, String str, final m mVar) {
        AppMethodBeat.i(43007);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + mVar.getType());
        if (mVar instanceof ao) {
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.dismiss();
            }
            if (this.ohG) {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                AppMethodBeat.o(43007);
                return true;
            }
            ao aoVar = (ao) mVar;
            if (i == 0 && i2 == 0) {
                this.obI = aoVar.kCd;
                this.obH = aoVar.nSX;
                this.obK = aoVar.nYY;
                this.ocI = aoVar.nSX;
                this.ohu = aoVar.nZe;
                if (((ao) mVar).bLD()) {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() NetScenePrepareLuckyMoney show JumpRemind Alert");
                    ((ao) mVar).nYe.a((Activity) this, new com.tencent.mm.wallet_core.c.g() {
                        public final void aQ(int i, String str) {
                            AppMethodBeat.i(42962);
                            ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onNext()");
                            if (bo.gW(i, 2) && bo.isEqual(str, "requestwxhb")) {
                                LuckyMoneyPrepareUI.x(LuckyMoneyPrepareUI.this);
                                AppMethodBeat.o(42962);
                                return;
                            }
                            if (bo.gW(i, 1)) {
                                com.tencent.mm.plugin.account.a.b.a.b(LuckyMoneyPrepareUI.this, str, 0, true);
                            }
                            AppMethodBeat.o(42962);
                        }

                        public final void onCancel() {
                            AppMethodBeat.i(42963);
                            ab.i("MicroMsg.LuckyMoneyPrepareUI", "onSceneEnd() scene:NetScenePrepareLuckyMoney JumpRemind:onCancel()");
                            AppMethodBeat.o(42963);
                        }
                    });
                    AppMethodBeat.o(43007);
                    return true;
                }
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = aoVar.nYX;
                payInfo.cIf = 37;
                payInfo.cIb = this.obL;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                AppMethodBeat.o(43007);
                return true;
            } else if (i2 == 401) {
                this.nTg.setEnabled(false);
                this.nTg.setClickable(false);
                this.gGo.ae(5000, 5000);
                h.bQ(this, str);
                AppMethodBeat.o(43007);
                return true;
            } else if (i2 == 268502454) {
                h.a((Context) this, str, "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42964);
                        if (ao.m(mVar)) {
                            LuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.o(42964);
                            return;
                        }
                        AppMethodBeat.o(42964);
                    }
                });
                AppMethodBeat.o(43007);
                return true;
            } else {
                this.cKs = 2;
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.fu2);
                }
                h.a((Context) this, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42957);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(42957);
                    }
                });
                AppMethodBeat.o(43007);
                return true;
            }
        }
        if (mVar instanceof ar) {
            if (i == 0 && i2 == 0) {
                if (this.obJ) {
                    com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42965);
                            LuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.o(42965);
                        }
                    }, 1800);
                } else {
                    bMq();
                    this.obE.setVisibility(0);
                    this.obE.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42967);
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            LuckyMoneyPrepareUI.this.mController.ylL.startActivity(intent);
                            LuckyMoneyPrepareUI.this.finish();
                            AppMethodBeat.o(42967);
                        }
                    }, 1000);
                }
                AppMethodBeat.o(43007);
                return true;
            } else if (i2 == 402) {
                h.d(this.mController.ylL, str, "", getString(R.string.ct5), getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(42968);
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        LuckyMoneyPrepareUI.this.startActivity(intent);
                        AppMethodBeat.o(42968);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(43007);
                return true;
            }
        } else if (mVar instanceof ag) {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (this.ohk != null && this.ohk.isShowing()) {
                this.ohk.dismiss();
            }
            if (this.ohl != null && this.ohl.isShowing()) {
                this.ohl.dismiss();
            }
            if (i == 0 && i2 == 0) {
                final ag agVar = (ag) mVar;
                this.ohD = true;
                this.nYN = agVar.nYN;
                if (bo.gW(agVar.nYO, 1)) {
                    this.nTf.iO(false);
                    if (!(this.kZa == null || bo.isNullOrNil(this.kZa.Aq()))) {
                        this.nTf.z(this.kZa);
                    }
                    this.nTf.setmOnEmojiSelectClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42971);
                            LuckyMoneyPrepareUI.this.oec = new aa();
                            LuckyMoneyPrepareUI.this.oec.cVT = 2;
                            LuckyMoneyPrepareUI.this.oec.ajK();
                            final boolean C = bo.C(view.getTag(), "delete");
                            if (C || bo.gW(agVar.nYN, 1)) {
                                com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(LuckyMoneyPrepareUI.this.mController.ylL, 1, false);
                                dVar.rBl = new n.c() {
                                    public final void a(l lVar) {
                                        AppMethodBeat.i(42969);
                                        if (C) {
                                            lVar.a(3, LuckyMoneyPrepareUI.this.getResources().getColor(R.color.ub), LuckyMoneyPrepareUI.this.mController.ylL.getString(R.string.cqf));
                                            AppMethodBeat.o(42969);
                                            return;
                                        }
                                        if (bo.gW(agVar.nYN, 1)) {
                                            lVar.hi(1, R.string.cry);
                                        }
                                        lVar.hi(2, R.string.csz);
                                        AppMethodBeat.o(42969);
                                    }
                                };
                                dVar.rBm = new n.d() {
                                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                        AppMethodBeat.i(42970);
                                        ab.i("MicroMsg.LuckyMoneyPrepareUI", "showLuckyHbDlg() onMMMenuItemSelected menuItemId:%s", Integer.valueOf(menuItem.getItemId()));
                                        switch (menuItem.getItemId()) {
                                            case 1:
                                                LuckyMoneyPrepareUI.this.oef = 1;
                                                com.tencent.mm.plugin.emojicapture.api.c.h(LuckyMoneyPrepareUI.this, null, 4);
                                                LuckyMoneyPrepareUI.this.oec = new aa();
                                                LuckyMoneyPrepareUI.this.oec.cVT = 4;
                                                LuckyMoneyPrepareUI.this.oec.ajK();
                                                AppMethodBeat.o(42970);
                                                return;
                                            case 2:
                                                LuckyMoneyPrepareUI.this.oef = 2;
                                                LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this);
                                                AppMethodBeat.o(42970);
                                                return;
                                            case 3:
                                                LuckyMoneyPrepareUI.this.ogb = 1;
                                                LuckyMoneyTextInputView A = LuckyMoneyPrepareUI.this.nTf;
                                                A.ohX.setTag("");
                                                A.ohY.setVisibility(0);
                                                A.ohZ.setVisibility(8);
                                                LuckyMoneyPrepareUI.this.kZa = null;
                                                LuckyMoneyPrepareUI.this.oec = new aa();
                                                LuckyMoneyPrepareUI.this.oec.cVT = 5;
                                                LuckyMoneyPrepareUI.this.oec.ajK();
                                                break;
                                        }
                                        AppMethodBeat.o(42970);
                                    }
                                };
                                dVar.cpD();
                                AppMethodBeat.o(42971);
                                return;
                            }
                            LuckyMoneyPrepareUI.this.oef = 2;
                            LuckyMoneyPrepareUI.y(LuckyMoneyPrepareUI.this);
                            AppMethodBeat.o(42971);
                        }
                    });
                } else {
                    this.nTf.iO(true);
                }
                com.tencent.mm.plugin.luckymoney.b.a.bKN();
                this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nSs);
                if (this.mType == 1) {
                    this.obC.setMaxAmount(this.nSs.nRR);
                } else {
                    this.obC.setMaxAmount(this.nSs.nRP);
                }
                this.obC.setMinAmount(this.nSs.nRQ);
                this.nTd.setMaxNum(this.nSs.nRO);
                this.ohr = agVar.nRT;
                this.ohq = agVar.kCv;
                this.ohs = agVar.nSd;
                if (bo.isNullOrNil(this.ogi)) {
                    this.ogi = agVar.few;
                }
                if (!(bo.isNullOrNil(this.ohs) || this.nTf == null)) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42972);
                            LuckyMoneyPrepareUI.this.nTf.setHintText(LuckyMoneyPrepareUI.this.ohs);
                            AppMethodBeat.o(42972);
                        }
                    });
                }
                if (agVar.nYE && this.obJ) {
                    TextView textView = (TextView) findViewById(R.id.czi);
                    textView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42973);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(9));
                            Intent intent = new Intent();
                            intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyCanShareListUI.class);
                            LuckyMoneyPrepareUI.this.startActivity(intent);
                            AppMethodBeat.o(42973);
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(8));
                    textView.setVisibility(8);
                }
                if (bo.isNullOrNil(agVar.kCx)) {
                    this.nTl.setVisibility(8);
                } else {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + agVar.kCx);
                    this.nTl.setText(agVar.kCx);
                    if (!bo.isNullOrNil(agVar.nYG)) {
                        this.nTl.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42974);
                                e.n(LuckyMoneyPrepareUI.this.mController.ylL, agVar.nYG, false);
                                AppMethodBeat.o(42974);
                            }
                        });
                    }
                    this.nTl.setVisibility(0);
                }
                h.c cVar = new h.c();
                if (agVar.nYI == null || bo.isNullOrNil(agVar.nYI.content)) {
                    cVar.textColor = getResources().getColor(R.color.rr);
                } else {
                    cVar.textColor = getResources().getColor(R.color.a4m);
                }
                this.obF.removeAllViews();
                h.a(this, this.obF, agVar.nYI, cVar);
                eX(agVar.nRU, agVar.nRT);
                c(this.obC.getInput(), this.ohr);
                com.tencent.mm.plugin.luckymoney.b.a.bKN();
                this.nWN = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLv();
                init();
                if (this.nWN != null) {
                    a(this.nWN.nWu);
                    com.tencent.mm.plugin.report.service.h.pYm.k(991, 10, 1);
                } else {
                    a(null);
                }
                if (this.ohF) {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "doRMBPrePareBtnClick()");
                    a(this.ohw, this.ohx, this.ohy, this.ohz, this.ohA, this.ohB);
                }
            } else if (this.ohF) {
                CharSequence str2;
                if (bo.isNullOrNil(str2)) {
                    str2 = getString(R.string.ps);
                }
                t.makeText(this, str2, 0).show();
            }
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig waitingGetConfig:%s ifAutoRMBPrePareBtn:%s", Boolean.valueOf(this.ohE), Boolean.valueOf(this.ohF));
            this.ohE = false;
            this.ohF = false;
            AppMethodBeat.o(43007);
            return true;
        } else if (mVar instanceof ah) {
            ng(1647);
            if (this.gII != null && this.gII.isShowing()) {
                this.gII.hide();
            }
            if (i == 0 && i2 == 0) {
                String str3 = ((ah) mVar).kCI;
                if (bo.isNullOrNil(str3)) {
                    ab.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                AppMethodBeat.o(43007);
                return true;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
            if (i == 0 && i2 == 0) {
                if (this.gII != null) {
                    this.gII.dismiss();
                }
                this.ocI = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) mVar).nSX;
                this.ohu = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) mVar).nUo;
                PayInfo payInfo2 = new PayInfo();
                payInfo2.czZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) mVar).czZ;
                payInfo2.cIf = 37;
                ad.o(37, payInfo2.czZ, i2);
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo2, 4);
            } else {
                ad.o(37, "", i2);
                if (!bo.isNullOrNil(str2)) {
                    h.b((Context) this, str2, getString(R.string.cq5), true);
                }
                this.gII.dismiss();
            }
            AppMethodBeat.o(43007);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.luckymoney.model.al) {
            AppMethodBeat.o(43007);
            return true;
        }
        AppMethodBeat.o(43007);
        return false;
    }

    private void z(EmojiInfo emojiInfo) {
        AppMethodBeat.i(43008);
        this.nTf.z(emojiInfo);
        if (this.oef == 0 || this.oef == 2) {
            if (com.tencent.mm.plugin.emoji.h.b.x(emojiInfo)) {
                this.ogb = 2;
            } else if (com.tencent.mm.plugin.emoji.h.b.w(emojiInfo)) {
                this.ogb = 4;
            } else {
                this.ogb = 3;
            }
        } else if (this.oef == 1) {
            this.ogb = 2;
        }
        this.oec = new aa();
        this.oec.cVT = 1;
        this.oec.ajK();
        AppMethodBeat.o(43008);
    }

    private void eX(String str, String str2) {
        AppMethodBeat.i(43009);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=".concat(String.valueOf(str)));
        TextView textView = (TextView) findViewById(R.id.cwz);
        if (bo.isNullOrNil(str)) {
            textView.setText(getString(R.string.cq3));
        } else {
            textView.setText(str);
        }
        if (bo.isNullOrNil(str2)) {
            c(0.0d, e.atr("CNY"));
            AppMethodBeat.o(43009);
            return;
        }
        c(0.0d, str2);
        AppMethodBeat.o(43009);
    }

    private void e(int i, Intent intent) {
        m alVar;
        AppMethodBeat.i(43010);
        String stringExtra = getIntent().getStringExtra("key_username");
        String Yz = r.Yz();
        if (i == -1) {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode == RESULT_OK");
            this.cKs = 1;
            this.ogm = "";
            alVar = new com.tencent.mm.plugin.luckymoney.model.al(this.ocI, this.ogi, 1, Yz, bo.nullAsNil(stringExtra));
        } else {
            if (intent != null) {
                this.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
            } else {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "doNetSceneLuckyMoneyReport() data == null");
                this.cKs = 3;
            }
            this.ogm = this.ocI;
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult() resultCode != RESULT_OK  payType:%s", Integer.valueOf(this.cKs));
            alVar = new com.tencent.mm.plugin.luckymoney.model.al(this.ocI, this.ogi, this.cKs, Yz, bo.nullAsNil(stringExtra));
        }
        g.RO().eJo.a(alVar, 0);
        AppMethodBeat.o(43010);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43011);
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.oht = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 != -1) {
                    if (!com.tencent.mm.plugin.wallet_core.utils.c.aw(intent)) {
                        if (!com.tencent.mm.plugin.wallet_core.utils.c.ax(intent)) {
                            e(i2, intent);
                            break;
                        } else {
                            AppMethodBeat.o(43011);
                            return;
                        }
                    }
                    finish();
                    AppMethodBeat.o(43011);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(5));
                String stringExtra = getIntent().getStringExtra("key_username");
                if (!this.obJ || bo.isNullOrNil(stringExtra)) {
                    bMq();
                    View findViewById = findViewById(R.id.czl);
                    this.obD.setVisibility(0);
                    x.a(findViewById, null);
                    this.leS.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42978);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.g(LuckyMoneyPrepareUI.this)), Integer.valueOf(6));
                            x.a(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.mType, LuckyMoneyPrepareUI.this.obI, true);
                            LuckyMoneyPrepareUI.this.obD.postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(42977);
                                    LuckyMoneyPrepareUI.this.obD.setVisibility(8);
                                    LuckyMoneyPrepareUI.this.bMp();
                                    AppMethodBeat.o(42977);
                                }
                            }, 100);
                            AppMethodBeat.o(42978);
                        }
                    });
                    ((ImageView) findViewById(R.id.czn)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(42979);
                            LuckyMoneyPrepareUI.this.obD.setVisibility(8);
                            LuckyMoneyPrepareUI.this.bMp();
                            AppMethodBeat.o(42979);
                        }
                    });
                    e(i2, intent);
                } else {
                    Map z = br.z(this.obK, "msg");
                    if (z == null) {
                        ab.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        AppMethodBeat.o(43011);
                        return;
                    }
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
                    e(i2, intent);
                    this.ohv = new com.tencent.mm.g.b.a.ab();
                    this.ohv.cYk = (long) this.ogb;
                    com.tencent.mm.g.b.a.ab abVar = this.ohv;
                    if (this.kZa == null) {
                        str = "";
                    } else {
                        str = this.kZa.Aq();
                    }
                    abVar.eW(str);
                    this.ohv.ajK();
                    finish();
                }
                str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                Qp(str);
                break;
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
                com.tencent.mm.plugin.report.service.h.pYm.e(11701, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bMh()), Integer.valueOf(7), str);
                if (!bo.isNullOrNil(str)) {
                    n(new ar(str.replaceAll(",", "|"), this.obH, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        ab.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = bo.getInt(bundleExtra.getString("payState", "2"), 0);
                    ab.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == -1) {
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    Qp(str);
                }
                finish();
                break;
            case 5:
                if (i2 != -1) {
                    iN(false);
                    com.tencent.mm.plugin.report.service.h.pYm.e(16822, Integer.valueOf(2));
                    break;
                }
                this.obF.removeAllViews();
                iN(true);
                if (intent != null) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra(com.tencent.mm.ui.e.f.yfX);
                    if (byteArrayExtra != null) {
                        atb atb = new atb();
                        try {
                            atb.parseFrom(byteArrayExtra);
                            a(atb);
                            break;
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.LuckyMoneyPrepareUI", e, "", new Object[0]);
                            break;
                        }
                    }
                }
                break;
            case FaceManager.FACE_ACQUIRED_HACKER /*1111*/:
                if (i2 != -1) {
                    ab.i("MicroMsg.LuckyMoneyPrepareUI", "go emoji capture failed!");
                    break;
                }
                str = "";
                if (intent != null) {
                    str = intent.getStringExtra("gif_md5");
                }
                if (!bo.isNullOrNil(str)) {
                    this.kZa = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(str);
                    z(this.kZa);
                    break;
                }
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "md5 == null go emoji capture failed!");
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(43011);
    }

    /* Access modifiers changed, original: protected|final */
    public final void V(final View view, final int i) {
        AppMethodBeat.i(43012);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        final EditText editText = (EditText) view.findViewById(R.id.cwy);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.o(43012);
            return;
        }
        e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;
            boolean ohP;

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(42983);
                if (!view.isFocused() || this.gnT) {
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42982);
                            LuckyMoneyPrepareUI.this.obF.setVisibility(0);
                            LuckyMoneyPrepareUI.this.aoB();
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(42982);
                        }
                    }, 200);
                    AppMethodBeat.o(42983);
                    return;
                }
                ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42981);
                        if (!LuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                            LuckyMoneyPrepareUI.this.obF.setVisibility(8);
                        }
                        LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, i);
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(42981);
                    }
                }, 300);
                AppMethodBeat.o(42983);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.i(42984);
                if (LuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        LuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                        LuckyMoneyPrepareUI.this.obF.setVisibility(0);
                        ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.o(42984);
                    return;
                }
                LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, i);
                AppMethodBeat.o(42984);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(42986);
                    if (!LuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (!LuckyMoneyPrepareUI.this.nTi.isShown() && !this.gnT) {
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new ak().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(42985);
                                    LuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                                    view.requestFocus();
                                    if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                                    }
                                    LuckyMoneyPrepareUI.c(LuckyMoneyPrepareUI.this, i);
                                    AppMethodBeat.o(42985);
                                }
                            }, 200);
                            AppMethodBeat.o(42986);
                            return;
                        } else if (this.gnT) {
                            LuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                            ((InputMethodManager) LuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (LuckyMoneyPrepareUI.this.mKeyboard != null) {
                        LuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        AppMethodBeat.o(42986);
                        return;
                    }
                    AppMethodBeat.o(42986);
                }
            });
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42987);
                LuckyMoneyPrepareUI.this.aoB();
                AppMethodBeat.o(42987);
            }
        });
        AppMethodBeat.o(43012);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43013);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            AppMethodBeat.o(43013);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(43013);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.i(43014);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
        }
        AppMethodBeat.o(43014);
    }

    public final void bLa() {
        double d;
        double d2;
        AppMethodBeat.i(43015);
        com.tencent.mm.plugin.luckymoney.b.a.bKN();
        this.nSs = com.tencent.mm.plugin.luckymoney.b.a.bKO().bLu();
        if (this.obC.bKW() == 3 || this.nTd.bKW() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int input = this.nTd.getInput();
            d2 = this.obC.getInput();
            if (this.mType == 0) {
                d2 *= (double) input;
                d = this.obC.getInput();
            } else {
                d = input > 0 ? this.obC.getInput() / ((double) input) : 0.0d;
            }
        }
        if (this.nTn.bMy()) {
            ab.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.nTg.setClickable(false);
            this.nTg.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.nSs.nRR && this.nSs.nRR > 0.0d) {
                this.nTn.Dv(getString(R.string.ctn, new Object[]{Math.round(this.nSs.nRR), bo.bc(this.nSs.nRU, "")}));
                z = true;
            } else if (d > 0.0d) {
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d)));
                if (this.mType == 0) {
                    if (d > this.nSs.nRP && this.nSs.nRP > 0.0d) {
                        if (bML()) {
                            this.nTn.Dv(getString(R.string.csc, new Object[]{this.nSs.nWL, Math.round(this.nSs.nRP), bo.bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(this.nSs.nRP), bo.bc(this.nSs.nRU, "")}));
                        }
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.nSs.nRS && this.nSs.nRS > 0.0d) {
                        if (this.nSs == null || bo.isNullOrNil(this.nSs.nWL)) {
                            this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(this.nSs.nRS), bo.bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.Dv(getString(R.string.csc, new Object[]{this.nSs.nWL, Math.round(this.nSs.nRS), bo.bc(this.nSs.nRU, "")}));
                        }
                        this.nTd.onError();
                        this.obC.onError();
                        z = true;
                    }
                    z = false;
                }
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d < this.nSs.nRQ) {
                            if (bML()) {
                                this.nTn.Dv(getString(R.string.cse, new Object[]{this.nSs.nWL, e.F(this.nSs.nRQ), bo.bc(this.nSs.nRU, "")}));
                            } else {
                                this.nTn.Dv(getString(R.string.csd, new Object[]{e.F(this.nSs.nRQ), bo.bc(this.nSs.nRU, "")}));
                            }
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        if (bML()) {
                            this.nTn.Dv(getString(R.string.cse, new Object[]{this.nSs.nWL, "0.01", bo.bc(this.nSs.nRU, "")}));
                        } else {
                            this.nTn.Dv(getString(R.string.csd, new Object[]{"0.01", bo.bc(this.nSs.nRU, "")}));
                        }
                        this.nTd.onError();
                        this.obC.onError();
                        z = true;
                    }
                }
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.nTg.setClickable(false);
                this.nTg.setEnabled(false);
            } else {
                this.nTg.setClickable(true);
                this.nTg.setEnabled(true);
            }
        }
        c(d2, this.ohr);
        AppMethodBeat.o(43015);
    }

    private boolean bML() {
        AppMethodBeat.i(43016);
        if (this.nSs == null || bo.isNullOrNil(this.nSs.nWL)) {
            AppMethodBeat.o(43016);
            return false;
        }
        AppMethodBeat.o(43016);
        return true;
    }

    private void c(double d, String str) {
        AppMethodBeat.i(43017);
        if (bo.isNullOrNil(str)) {
            this.kGm.setText(e.G(d));
            AppMethodBeat.o(43017);
            return;
        }
        this.kGm.setText(str + e.F(d));
        AppMethodBeat.o(43017);
    }

    private int bMh() {
        AppMethodBeat.i(43018);
        if (!this.obJ) {
            AppMethodBeat.o(43018);
            return 3;
        } else if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            AppMethodBeat.o(43018);
            return 2;
        } else {
            AppMethodBeat.o(43018);
            return 1;
        }
    }

    public void finish() {
        AppMethodBeat.i(43019);
        if (this.oht != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.oht);
            com.tencent.mm.bp.d.b((Context) this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
        AppMethodBeat.o(43019);
    }

    private void Qp(String str) {
        AppMethodBeat.i(43020);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        b(new ae(this.ocI, str, this.ohu), false);
        AppMethodBeat.o(43020);
    }

    static /* synthetic */ void i(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(43023);
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "doPrePareBtnClick()");
        luckyMoneyPrepareUI.yj(0);
        AppMethodBeat.o(43023);
    }

    static /* synthetic */ void u(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        AppMethodBeat.i(43024);
        luckyMoneyPrepareUI.ohC = new com.tencent.mm.ui.widget.d(luckyMoneyPrepareUI, 1, false);
        luckyMoneyPrepareUI.ohC.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(42948);
                lVar.add(0, 0, 0, LuckyMoneyPrepareUI.this.getString(R.string.cqc));
                lVar.add(0, 1, 0, LuckyMoneyPrepareUI.this.getString(R.string.fg9));
                AppMethodBeat.o(42948);
            }
        };
        luckyMoneyPrepareUI.ohC.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(42949);
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_type", 2);
                    LuckyMoneyPrepareUI.this.startActivity(intent);
                    AppMethodBeat.o(42949);
                    return;
                }
                if (i == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(15511, Integer.valueOf(LuckyMoneyPrepareUI.this.ohq), Integer.valueOf(1));
                    if (LuckyMoneyPrepareUI.this.ohq == 1) {
                        e.n(LuckyMoneyPrepareUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                        AppMethodBeat.o(42949);
                        return;
                    }
                    String str = "MicroMsg.LuckyMoneyPrepareUI";
                    String str2 = "show qa foreign, config url: %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = LuckyMoneyPrepareUI.this.nSs != null ? LuckyMoneyPrepareUI.this.nSs.nWK : "";
                    ab.i(str, str2, objArr);
                    if (LuckyMoneyPrepareUI.this.nSs == null || bo.isNullOrNil(LuckyMoneyPrepareUI.this.nSs.nWK)) {
                        e.n(LuckyMoneyPrepareUI.this.mController.ylL, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                    } else {
                        e.n(LuckyMoneyPrepareUI.this.mController.ylL, LuckyMoneyPrepareUI.this.nSs.nWK, false);
                        AppMethodBeat.o(42949);
                        return;
                    }
                }
                AppMethodBeat.o(42949);
            }
        };
        luckyMoneyPrepareUI.ohC.cpD();
        AppMethodBeat.o(43024);
    }

    static /* synthetic */ void y(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        int i;
        AppMethodBeat.i(43026);
        luckyMoneyPrepareUI.oec = new aa();
        luckyMoneyPrepareUI.oec.cVT = 3;
        luckyMoneyPrepareUI.oec.ajK();
        luckyMoneyPrepareUI.aoB();
        luckyMoneyPrepareUI.aqX();
        luckyMoneyPrepareUI.odS.show();
        if (bo.gW(luckyMoneyPrepareUI.nYN, 1)) {
            i = ChatFooterPanel.vhr;
        } else {
            i = ChatFooterPanel.vho;
        }
        com.tencent.mm.plugin.luckymoney.ui.a.a.a(luckyMoneyPrepareUI.oea, luckyMoneyPrepareUI.odY, i, new com.tencent.mm.api.t.a() {
            public final void a(k kVar) {
                AppMethodBeat.i(42975);
                ab.i("MicroMsg.LuckyMoneyPrepareUI", "[onSelectedEmoji] emojiInfo:%s", kVar);
                LuckyMoneyPrepareUI.this.kZa = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(kVar.Aq());
                LuckyMoneyPrepareUI.b(LuckyMoneyPrepareUI.this, LuckyMoneyPrepareUI.this.kZa);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(42975);
            }

            public final void onHide() {
                AppMethodBeat.i(138991);
                LuckyMoneyPrepareUI.a(LuckyMoneyPrepareUI.this);
                AppMethodBeat.o(138991);
            }
        });
        AppMethodBeat.o(43026);
    }
}
