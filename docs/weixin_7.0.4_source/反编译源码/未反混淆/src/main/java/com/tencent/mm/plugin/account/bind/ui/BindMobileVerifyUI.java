package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements f {
    private String cFl;
    private int fromScene;
    private EditText grL;
    private Button grN;
    private BindWordingContent grY;
    private int grZ;
    private boolean gsa;
    private boolean gsb;
    private TextView gsq;
    private TextView gsr;
    private Integer gss = Integer.valueOf(15);
    private Timer mTimer;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindMobileVerifyUI() {
        AppMethodBeat.i(13535);
        AppMethodBeat.o(13535);
    }

    static /* synthetic */ void f(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.i(13545);
        bindMobileVerifyUI.ape();
        AppMethodBeat.o(13545);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13536);
        super.onCreate(bundle);
        g.Rg().a(132, (f) this);
        setMMTitle((int) R.string.a7b);
        this.grY = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.grZ = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.gsa = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.gsb = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        initView();
        AppMethodBeat.o(13536);
    }

    public void onDestroy() {
        AppMethodBeat.i(13537);
        g.Rg().b(132, (f) this);
        super.onDestroy();
        AppMethodBeat.o(13537);
    }

    public void onStop() {
        AppMethodBeat.i(13538);
        ape();
        super.onStop();
        AppMethodBeat.o(13538);
    }

    public final int getLayoutId() {
        return R.layout.gj;
    }

    public final void initView() {
        AppMethodBeat.i(13539);
        this.cFl = (String) g.RP().Ry().get(4097, null);
        this.grL = (EditText) findViewById(R.id.a65);
        this.gsq = (TextView) findViewById(R.id.a64);
        this.gsr = (TextView) findViewById(R.id.a68);
        Button button = (Button) findViewById(R.id.a66);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(6, null);
        }
        if (this.cFl != null && this.cFl.length() > 0) {
            this.gsq.setVisibility(0);
            this.gsq.setText(this.cFl);
        }
        this.grL.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                AppMethodBeat.i(13528);
                CharSequence ad = bo.ad(charSequence);
                AppMethodBeat.o(13528);
                return ad;
            }
        }});
        this.grN = (Button) findViewById(R.id.a56);
        button.setVisibility(8);
        this.gsr.setText(getResources().getQuantityString(R.plurals.t, this.gss.intValue(), new Object[]{this.gss}));
        apd();
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13530);
                String trim = BindMobileVerifyUI.this.grL.getText().toString().trim();
                if (trim.equals("")) {
                    h.g(BindMobileVerifyUI.this, R.string.a7z, R.string.tz);
                    AppMethodBeat.o(13530);
                } else {
                    BindMobileVerifyUI.this.aqX();
                    hy hyVar = new hy();
                    hyVar.cCS.context = BindMobileVerifyUI.this;
                    a.xxA.m(hyVar);
                    String str = hyVar.cCT.cCU;
                    hz hzVar = new hz();
                    a.xxA.m(hzVar);
                    final m xVar = new x(BindMobileVerifyUI.this.cFl, 2, trim, "", str, hzVar.cCV.cCW);
                    g.Rg().a(xVar, 0);
                    BindMobileVerifyUI bindMobileVerifyUI = BindMobileVerifyUI.this;
                    Context context = BindMobileVerifyUI.this;
                    BindMobileVerifyUI.this.getString(R.string.tz);
                    bindMobileVerifyUI.tipDialog = h.b(context, BindMobileVerifyUI.this.getString(R.string.a7n), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(13529);
                            g.Rg().c(xVar);
                            AppMethodBeat.o(13529);
                        }
                    });
                    AppMethodBeat.o(13530);
                }
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13531);
                BindMobileVerifyUI.this.finish();
                AppMethodBeat.o(13531);
                return true;
            }
        });
        this.grN.setVisibility(b.sM(this.cFl) ? 0 : 8);
        this.grN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13532);
                BindMobileVerifyUI.this.aqX();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.this.cFl);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.account.a.a.gkE.f(BindMobileVerifyUI.this, intent);
                AppMethodBeat.o(13532);
            }
        });
        AppMethodBeat.o(13539);
    }

    private void apd() {
        AppMethodBeat.i(13540);
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            AnonymousClass5 anonymousClass5 = new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(13533);
                    if (BindMobileVerifyUI.this.gsr != null) {
                        BindMobileVerifyUI.d(BindMobileVerifyUI.this);
                    }
                    AppMethodBeat.o(13533);
                }
            };
            if (this.mTimer != null) {
                this.mTimer.schedule(anonymousClass5, 1000, 1000);
            }
        }
        AppMethodBeat.o(13540);
    }

    private void ape() {
        AppMethodBeat.i(13541);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        AppMethodBeat.o(13541);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13542);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Ni(1);
            AppMethodBeat.o(13542);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13542);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(13543);
        ab.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (((x) mVar).Ah() != 2) {
            AppMethodBeat.o(13543);
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        boolean z2;
        if (i == 0 && i2 == 0) {
            if (((x) mVar).Ah() == 2) {
                Intent intent;
                switch (this.fromScene) {
                    case 1:
                        if (!r.YH()) {
                            tt ttVar = new tt();
                            ttVar.cPS.cPT = true;
                            ttVar.cPS.cPU = true;
                            a.xxA.m(ttVar);
                        }
                        Ni(1);
                        intent = new Intent();
                        intent.addFlags(67108864);
                        com.tencent.mm.plugin.account.a.a.gkE.e((Context) this, intent);
                        AppMethodBeat.o(13543);
                        return;
                    case 6:
                        if (this.gsa) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (this.gsb) {
                            z = false;
                        }
                        BindMobileStatusUI.c(this, z2, z);
                        exit(-1);
                        AppMethodBeat.o(13543);
                        return;
                    default:
                        if (this.fromScene == 0 || this.fromScene == 3) {
                            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                        }
                        intent = new Intent(this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", this.grY);
                        intent.putExtra("kstyle_bind_recommend_show", this.grZ);
                        intent.putExtra("Kfind_friend_by_mobile_flag", this.gsa);
                        intent.putExtra("Krecom_friends_by_mobile_flag", this.gsb);
                        intent.putExtra("bind_scene", this.fromScene);
                        MMWizardActivity.J(this, intent);
                        break;
                }
            }
            AppMethodBeat.o(13543);
            return;
        }
        if (!com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            switch (i2) {
                case -214:
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                    }
                    z2 = true;
                    break;
                case -43:
                    Toast.makeText(this, R.string.a6h, 0).show();
                    z2 = true;
                    break;
                case -41:
                    Toast.makeText(this, R.string.a6j, 0).show();
                    z2 = true;
                    break;
                case -36:
                    Toast.makeText(this, R.string.a6m, 0).show();
                    z2 = true;
                    break;
                case -35:
                    Toast.makeText(this, R.string.a6i, 0).show();
                    z2 = true;
                    break;
                case -34:
                    Toast.makeText(this, R.string.a6k, 0).show();
                    z2 = true;
                    break;
                case -33:
                    h.a((Context) this, (int) R.string.a7s, (int) R.string.a7y, null);
                    z2 = true;
                    break;
                case -32:
                    h.a((Context) this, (int) R.string.a7t, (int) R.string.a7y, null);
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
        }
        z2 = true;
        if (z2) {
            AppMethodBeat.o(13543);
            return;
        }
        Toast.makeText(this, getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(13543);
    }

    static /* synthetic */ void d(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.i(13544);
        bindMobileVerifyUI.gsr.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(13534);
                BindMobileVerifyUI.this.gss;
                BindMobileVerifyUI.this.gss = Integer.valueOf(BindMobileVerifyUI.this.gss.intValue() - 1);
                if (BindMobileVerifyUI.this.gss.intValue() > 0) {
                    BindMobileVerifyUI.this.gsr.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.plurals.t, BindMobileVerifyUI.this.gss.intValue(), new Object[]{BindMobileVerifyUI.this.gss}));
                    AppMethodBeat.o(13534);
                    return;
                }
                BindMobileVerifyUI.this.gsr.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.plurals.t, 0, new Object[]{Integer.valueOf(0)}));
                BindMobileVerifyUI.f(BindMobileVerifyUI.this);
                AppMethodBeat.o(13534);
            }
        });
        AppMethodBeat.o(13544);
    }
}
