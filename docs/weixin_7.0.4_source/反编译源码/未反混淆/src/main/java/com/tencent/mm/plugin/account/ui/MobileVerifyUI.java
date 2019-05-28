package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI extends MMActivity {
    String bCu;
    protected String cFl;
    protected ProgressDialog ehJ = null;
    int fPA;
    private c gCd;
    private int gDW;
    protected boolean gDc = false;
    protected String gDy;
    protected MMFormInputView gEV;
    protected TextView gEW;
    protected TextView gEX;
    protected TextView gEY;
    protected Button gEZ;
    String gEk;
    int gEs;
    protected int gEu;
    protected ScrollView gFa;
    private long gFb = 0;
    private boolean gFc = false;
    private String[] gFd;
    private boolean gFe = false;
    Boolean gFf;
    private int gFg = 30;
    protected boolean gFh = false;
    protected boolean gFi = false;
    protected int gFj = -1;
    private b gFk;
    String gFl;
    protected String gFm;
    protected EditText grL;
    protected TextView grM;
    String gsF;
    SecurityImage gue = null;
    private Timer mTimer;

    public interface b {
        void a(MobileVerifyUI mobileVerifyUI);

        boolean a(a aVar);

        void start();

        void stop();
    }

    protected enum a {
        GoBack,
        GoNext,
        DoSend,
        DoProcessSMS;

        static {
            AppMethodBeat.o(125281);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(125297);
        mobileVerifyUI.ari();
        AppMethodBeat.o(125297);
    }

    static /* synthetic */ void g(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(125298);
        mobileVerifyUI.arj();
        AppMethodBeat.o(125298);
    }

    static /* synthetic */ void i(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(125299);
        mobileVerifyUI.goBack();
        AppMethodBeat.o(125299);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125282);
        super.onCreate(bundle);
        this.gEs = getIntent().getIntExtra("key_reg_style", 1);
        this.gDW = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.gFl = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.gEk = getIntent().getStringExtra("kintent_password");
        this.bCu = getIntent().getStringExtra("kintent_nickname");
        this.gFf = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.gDc = getIntent().getBooleanExtra("from_deep_link", false);
        this.gDy = getIntent().getStringExtra("regsession_id");
        this.gFm = getIntent().getStringExtra("reg_3d_app_ticket");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        switch (this.gDW) {
            case 2:
                this.gFk = new o();
                if (this.gEk != null && this.gEk.length() >= 8) {
                    this.fPA = 1;
                    break;
                } else {
                    this.fPA = 4;
                    break;
                }
            case 3:
            case 5:
                this.gFk = new m(this.gDW);
                break;
            case 4:
                this.gFk = new n();
                break;
            default:
                ab.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", Integer.valueOf(this.gDW));
                finish();
                AppMethodBeat.o(125282);
                return;
        }
        String string = getString(R.string.a7b);
        if (d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        this.gFg = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.gFh = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.gFi = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        initView();
        this.gFk.a(this);
        if (this.gFl != null) {
            this.grL.setText(this.gFl);
            ari();
        } else if (this.gDW == 5) {
            this.gFk.a(a.DoSend);
        }
        this.gCd = new c();
        AppMethodBeat.o(125282);
    }

    public void onDestroy() {
        AppMethodBeat.i(125283);
        if (this.gCd != null) {
            this.gCd.close();
        }
        super.onDestroy();
        AppMethodBeat.o(125283);
    }

    public void onResume() {
        AppMethodBeat.i(125284);
        super.onResume();
        this.gFk.start();
        AppMethodBeat.o(125284);
    }

    public void onPause() {
        AppMethodBeat.i(125285);
        super.onPause();
        this.gFk.stop();
        AppMethodBeat.o(125285);
    }

    public final int getLayoutId() {
        return R.layout.ah5;
    }

    private void arh() {
        AppMethodBeat.i(125286);
        if (!this.gFc) {
            this.mTimer = new Timer();
            this.gFc = true;
            this.gFb = (long) this.gFg;
            this.mTimer.schedule(new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(125269);
                    MobileVerifyUI.this.gEX.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(125268);
                            MobileVerifyUI.this.gFb = MobileVerifyUI.this.gFb - 1;
                            if (MobileVerifyUI.this.gFb >= 0) {
                                MobileVerifyUI.this.gEX.setText(MobileVerifyUI.this.getResources().getQuantityString(R.plurals.t, (int) MobileVerifyUI.this.gFb, new Object[]{Integer.valueOf((int) MobileVerifyUI.this.gFb)}));
                                AppMethodBeat.o(125268);
                                return;
                            }
                            MobileVerifyUI.this.gEX.setVisibility(8);
                            MobileVerifyUI.this.gEW.setVisibility(0);
                            MobileVerifyUI.d(MobileVerifyUI.this);
                            MobileVerifyUI.this.gEW.setEnabled(true);
                            MobileVerifyUI.this.gEW.setText(MobileVerifyUI.this.getString(R.string.d0t));
                            AppMethodBeat.o(125268);
                        }
                    });
                    AppMethodBeat.o(125269);
                }
            }, 1000, 1000);
        }
        AppMethodBeat.o(125286);
    }

    public final void initView() {
        AppMethodBeat.i(125288);
        ab.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.cFl);
        this.gEV = (MMFormInputView) findViewById(R.id.a65);
        this.gEV.setImeOption(5);
        this.gEV.setInputType(3);
        this.grL = this.gEV.getContentEditText();
        this.gEW = (TextView) findViewById(R.id.dc1);
        this.gEX = (TextView) findViewById(R.id.dc2);
        this.grM = (TextView) findViewById(R.id.a63);
        this.grM.setText(this.cFl);
        this.cFl = av.amN(this.cFl);
        this.gEW.setText(getString(R.string.d0u));
        this.gEY = (TextView) findViewById(R.id.dc0);
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.gFa = (ScrollView) findViewById(R.id.em);
        this.gFd = getResources().getStringArray(R.array.ao);
        this.gEY.setText(Html.fromHtml(getString(R.string.dl5)));
        InputFilter[] inputFilterArr = new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                AppMethodBeat.i(125270);
                CharSequence ad = bo.ad(charSequence);
                AppMethodBeat.o(125270);
                return ad;
            }
        }};
        this.gEX.setVisibility(0);
        this.gEX.setText(getResources().getQuantityString(R.plurals.t, this.gFg, new Object[]{Integer.valueOf(this.gFg)}));
        arh();
        this.gFe = false;
        this.grL.setFilters(inputFilterArr);
        this.grL.addTextChangedListener(new MMEditText.c(this.grL, null, 12));
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125271);
                MobileVerifyUI.e(MobileVerifyUI.this);
                AppMethodBeat.o(125271);
            }
        });
        this.gEZ.setEnabled(false);
        this.grL.setTextSize(15.0f);
        this.grL.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125272);
                if (bo.isNullOrNil(MobileVerifyUI.this.grL.getText().toString())) {
                    MobileVerifyUI.this.grL.setTextSize(15.0f);
                    MobileVerifyUI.this.grL.setGravity(16);
                } else {
                    MobileVerifyUI.this.grL.setTextSize(24.0f);
                    MobileVerifyUI.this.grL.setGravity(16);
                }
                if (MobileVerifyUI.this.grL.getText() == null || MobileVerifyUI.this.grL.getText().toString().length() <= 0) {
                    MobileVerifyUI.this.gEZ.setEnabled(false);
                    AppMethodBeat.o(125272);
                    return;
                }
                MobileVerifyUI.this.gEZ.setEnabled(true);
                AppMethodBeat.o(125272);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.gEW.setOnClickListener(new OnClickListener() {
            private final int gFp = 0;
            private final int gFq = 1;
            private final int gFr = 2;

            public final void onClick(View view) {
                AppMethodBeat.i(125275);
                j jVar = new j(MobileVerifyUI.this);
                jVar.rBl = new n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(125273);
                        lVar.e(0, MobileVerifyUI.this.getString(R.string.d0u));
                        if (com.tencent.mm.au.b.sM(MobileVerifyUI.this.cFl)) {
                            lVar.e(1, MobileVerifyUI.this.getString(R.string.a82));
                        }
                        if (MobileVerifyUI.this.gDW == 2 && MobileVerifyUI.this.gFi) {
                            lVar.e(2, MobileVerifyUI.this.getString(R.string.dl9));
                        }
                        AppMethodBeat.o(125273);
                    }
                };
                jVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(125274);
                        switch (menuItem.getItemId()) {
                            case 0:
                                MobileVerifyUI.g(MobileVerifyUI.this);
                                AppMethodBeat.o(125274);
                                return;
                            case 1:
                                MobileVerifyUI.this.aqX();
                                if (MobileVerifyUI.this.gDW == 2) {
                                    com.tencent.mm.plugin.b.a.wA("R200_500");
                                } else if (MobileVerifyUI.this.gDW == 3) {
                                    com.tencent.mm.plugin.b.a.wA("F200_300");
                                }
                                Intent intent = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("bindmcontact_mobile", MobileVerifyUI.this.cFl);
                                bundle.putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
                                intent.putExtras(bundle);
                                MobileVerifyUI.this.startActivity(intent);
                                break;
                        }
                        AppMethodBeat.o(125274);
                    }
                };
                jVar.cuu();
                AppMethodBeat.o(125275);
            }
        });
        this.gEW.setEnabled(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125276);
                MobileVerifyUI.i(MobileVerifyUI.this);
                AppMethodBeat.o(125276);
                return true;
            }
        });
        this.grL.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125277);
                if (i == 6 || i == 5) {
                    MobileVerifyUI.e(MobileVerifyUI.this);
                    AppMethodBeat.o(125277);
                    return true;
                }
                AppMethodBeat.o(125277);
                return false;
            }
        });
        this.grL.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125278);
                if (66 == i && keyEvent.getAction() == 0) {
                    MobileVerifyUI.e(MobileVerifyUI.this);
                    AppMethodBeat.o(125278);
                    return true;
                }
                AppMethodBeat.o(125278);
                return false;
            }
        });
        AppMethodBeat.o(125288);
    }

    private void ari() {
        AppMethodBeat.i(125289);
        aqX();
        if (this.grL.getText().toString().trim().equals("")) {
            h.g(this, R.string.a7z, R.string.tz);
            AppMethodBeat.o(125289);
            return;
        }
        this.gFk.a(a.GoNext);
        AppMethodBeat.o(125289);
    }

    private void arj() {
        AppMethodBeat.i(125290);
        this.gFe = false;
        this.gEW.setEnabled(false);
        this.gEX.setVisibility(0);
        this.gEX.setText(getResources().getQuantityString(R.plurals.t, this.gFg, new Object[]{Integer.valueOf(this.gFg)}));
        this.gEW.setVisibility(8);
        arh();
        this.gFk.a(a.DoSend);
        h.bQ(this, getString(R.string.d06));
        AppMethodBeat.o(125290);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125291);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(125291);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125291);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(125292);
        com.tencent.mm.plugin.b.a.wA(this.gsF);
        if (this.gFk.a(a.GoBack)) {
            AppMethodBeat.o(125292);
            return;
        }
        finish();
        AppMethodBeat.o(125292);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(125293);
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            ab.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", stringExtra);
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                arj();
            }
        }
        AppMethodBeat.o(125293);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:13:0x0041, code skipped:
            com.tencent.mm.platformtools.z.cu(r8);
            com.tencent.matrix.trace.core.AppMethodBeat.o(125294);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(int i, int i2, String str) {
        AppMethodBeat.i(125294);
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
        if (jY != null) {
            jY.a(this, null, null);
            AppMethodBeat.o(125294);
            return true;
        }
        int i3;
        if (i == 4) {
            switch (i2) {
                case -75:
                    break;
                case -1:
                    if (g.Rg().acS() == 5) {
                        h.g(this, R.string.d5n, R.string.d5m);
                        AppMethodBeat.o(125294);
                        return true;
                    }
                    break;
            }
        }
        switch (i2) {
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                String an;
                com.tencent.mm.kernel.a.hold();
                Context context = this.mController.ylL;
                g.RN();
                if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QH())) {
                    an = com.tencent.mm.bz.a.an(this.mController.ylL, R.string.cvw);
                } else {
                    g.RN();
                    an = com.tencent.mm.kernel.a.QH();
                }
                h.a(context, an, this.mController.ylL.getString(R.string.tz), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                i3 = 1;
                break;
            case -43:
                Toast.makeText(this, R.string.a6h, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.string.a6j, 0).show();
                i3 = 1;
                break;
            case -36:
                Toast.makeText(this, R.string.a6m, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.string.a6k, 0).show();
                i3 = 1;
                break;
            case -33:
                h.a((Context) this, (int) R.string.a7s, (int) R.string.a7y, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                i3 = 1;
                break;
            case -32:
                h.a((Context) this, getString(R.string.a7u), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0) {
            AppMethodBeat.o(125294);
            return true;
        }
        if (this.gCd.a(this, new ag(i, i2, str))) {
            AppMethodBeat.o(125294);
            return true;
        }
        AppMethodBeat.o(125294);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dq(boolean z) {
        AppMethodBeat.i(125295);
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.string.e8s));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
        AppMethodBeat.o(125295);
    }

    public final void onKeyboardStateChanged() {
        AppMethodBeat.i(125287);
        if (this.mController.ymc == 1) {
            this.gFa.scrollTo(0, this.gFa.getChildAt(0).getMeasuredHeight() - this.gFa.getMeasuredHeight());
            AppMethodBeat.o(125287);
            return;
        }
        this.gFa.scrollTo(0, 0);
        AppMethodBeat.o(125287);
    }

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(125296);
        mobileVerifyUI.gFc = false;
        if (mobileVerifyUI.mTimer != null) {
            mobileVerifyUI.mTimer.cancel();
        }
        AppMethodBeat.o(125296);
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.gDW) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }
}
