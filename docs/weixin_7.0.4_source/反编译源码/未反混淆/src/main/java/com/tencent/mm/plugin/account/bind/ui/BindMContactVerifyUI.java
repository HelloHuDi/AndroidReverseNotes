package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.au.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactVerifyUI extends MMWizardActivity {
    private String cFl;
    private SharedPreferences ehZ;
    private int fromScene = 0;
    private boolean gqB = false;
    private EditText grL;
    private TextView grM;
    private Button grN;
    private i grO;
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(13492);
        bindMContactVerifyUI.goBack();
        AppMethodBeat.o(13492);
    }

    static /* synthetic */ void f(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(13494);
        bindMContactVerifyUI.Ni(-1);
        AppMethodBeat.o(13494);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13486);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a7b);
        this.ehZ = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = r.YD();
        initView();
        AppMethodBeat.o(13486);
    }

    public void onDestroy() {
        AppMethodBeat.i(13487);
        super.onDestroy();
        AppMethodBeat.o(13487);
    }

    public final int getLayoutId() {
        return R.layout.gj;
    }

    public final void initView() {
        AppMethodBeat.i(13488);
        this.cFl = (String) g.RP().Ry().get(4097, null);
        this.grL = (EditText) findViewById(R.id.a65);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(R.id.a66);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(6, null);
        }
        this.grL.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                AppMethodBeat.i(13479);
                CharSequence ad = bo.ad(charSequence);
                AppMethodBeat.o(13479);
                return ad;
            }
        }});
        this.grN = (Button) findViewById(R.id.a56);
        this.grM = (TextView) findViewById(R.id.a63);
        this.grM.setText(getString(R.string.a6y, new Object[]{this.cFl}));
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13480);
                String trim = BindMContactVerifyUI.this.grL.getText().toString().trim();
                if (bo.isNullOrNil(trim)) {
                    h.g(BindMContactVerifyUI.this, R.string.a7z, R.string.tz);
                    AppMethodBeat.o(13480);
                    return;
                }
                BindMContactVerifyUI.this.aqX();
                BindMContactVerifyUI.a(BindMContactVerifyUI.this, trim);
                AppMethodBeat.o(13480);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13481);
                BindMContactVerifyUI.b(BindMContactVerifyUI.this);
                AppMethodBeat.o(13481);
                return true;
            }
        });
        this.grN.setVisibility(b.sM(this.cFl) ? 0 : 8);
        this.grN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13482);
                BindMContactVerifyUI.this.aqX();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.this.cFl);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                a.gkE.f(BindMContactVerifyUI.this, intent);
                AppMethodBeat.o(13482);
            }
        });
        AppMethodBeat.o(13488);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13489);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(13489);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13489);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(13490);
        if (this.grO != null) {
            this.grO.recycle();
        }
        Ni(1);
        AppMethodBeat.o(13490);
    }

    static /* synthetic */ void a(BindMContactVerifyUI bindMContactVerifyUI, String str) {
        boolean z;
        AppMethodBeat.i(13491);
        i.b bVar = i.b.BINDMOBILE;
        if (bindMContactVerifyUI.fromScene == 3) {
            bVar = i.b.CHANGEMOBILE;
        }
        bindMContactVerifyUI.grO = new i(bVar, bindMContactVerifyUI, new i.a() {
            public final void e(int i, Bundle bundle) {
                AppMethodBeat.i(13485);
                if (i == 2) {
                    Intent intent;
                    switch (BindMContactVerifyUI.this.fromScene) {
                        case 1:
                            ab.i("MicroMsg.BindMContactVerifyUI", "to startMySafedeviceListUI");
                            if (!r.YH()) {
                                tt ttVar = new tt();
                                ttVar.cPS.cPT = true;
                                ttVar.cPS.cPU = true;
                                com.tencent.mm.sdk.b.a.xxA.m(ttVar);
                            }
                            BindMContactVerifyUI.e(BindMContactVerifyUI.this);
                            intent = new Intent();
                            intent.addFlags(67108864);
                            a.gkE.e(BindMContactVerifyUI.this, intent);
                            AppMethodBeat.o(13485);
                            return;
                        case 3:
                            ab.i("MicroMsg.BindMContactVerifyUI", "to BindMContactStatusUI for change mobile");
                            if (bundle.getBoolean("restart_wechat", false)) {
                                ab.i("MicroMsg.BindMContactVerifyUI", "restart after change mobile!");
                                h.a(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.g6c), BindMContactVerifyUI.this.getString(R.string.tz), false, new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        AppMethodBeat.i(13483);
                                        Intent intent = new Intent();
                                        intent.addFlags(67108864);
                                        intent.putExtra("exit_and_restart", true);
                                        a.gkE.p(intent, BindMContactVerifyUI.this);
                                        AppMethodBeat.o(13483);
                                    }
                                });
                                AppMethodBeat.o(13485);
                                return;
                            }
                            h.bQ(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.qt));
                            MMWizardActivity.J(BindMContactVerifyUI.this, new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class));
                            AppMethodBeat.o(13485);
                            return;
                        case 4:
                            ab.i("MicroMsg.BindMContactVerifyUI", "to RegByMobileSetPwdUI for reset pwd");
                            BindMContactVerifyUI.this.finish();
                            intent = new Intent();
                            intent.addFlags(603979776);
                            intent.putExtra("setpwd_ticket", bundle.getString("setpwd_ticket", ""));
                            d.b(BindMContactVerifyUI.this, "account", ".ui.RegByMobileSetPwdUI", intent);
                            AppMethodBeat.o(13485);
                            return;
                        case 5:
                            ab.i("MicroMsg.BindMContactVerifyUI", "to finish  finishWizard for get phone number");
                            BindMContactVerifyUI.f(BindMContactVerifyUI.this);
                            AppMethodBeat.o(13485);
                            return;
                        default:
                            if (BindMContactVerifyUI.this.gqB) {
                                if (BindMContactVerifyUI.this.fromScene == 2) {
                                    com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                                } else {
                                    com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                                }
                            }
                            if (BindMContactVerifyUI.this.fromScene != 0 || !bundle.getBoolean("restart_wechat", false)) {
                                MMWizardActivity.J(BindMContactVerifyUI.this, new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class));
                                break;
                            }
                            ab.i("MicroMsg.BindMContactVerifyUI", "restart after bind mobile!");
                            h.a(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.g6c), BindMContactVerifyUI.this.getString(R.string.tz), false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(13484);
                                    Intent intent = new Intent();
                                    intent.addFlags(67108864);
                                    intent.putExtra("exit_and_restart", true);
                                    a.gkE.p(intent, BindMContactVerifyUI.this);
                                    AppMethodBeat.o(13484);
                                }
                            });
                            AppMethodBeat.o(13485);
                            return;
                    }
                }
                AppMethodBeat.o(13485);
            }
        });
        i iVar = bindMContactVerifyUI.grO;
        if (bindMContactVerifyUI.fromScene == 0 || bindMContactVerifyUI.fromScene == 3) {
            z = true;
        } else {
            z = false;
        }
        iVar.gys = z;
        f fVar = bindMContactVerifyUI.grO;
        if (fVar.tipDialog != null) {
            fVar.tipDialog.setCancelable(true);
        }
        if (fVar.gyt == i.b.BINDMOBILE || fVar.gyt == i.b.CHANGEMOBILE) {
            g.Rg().a(132, fVar);
            hy hyVar = new hy();
            hyVar.cCS.context = fVar.mContext;
            com.tencent.mm.sdk.b.a.xxA.m(hyVar);
            String str2 = hyVar.cCT.cCU;
            hz hzVar = new hz();
            com.tencent.mm.sdk.b.a.xxA.m(hzVar);
            String str3 = hzVar.cCV.cCW;
            int i = 2;
            if (fVar.gyt == i.b.CHANGEMOBILE) {
                i = 19;
            }
            fVar.eVT = false;
            fVar.gyq = new x(fVar.cFl, i, str, "", str2, str3);
            g.Rg().a(fVar.gyq, 0);
            if (fVar.tipDialog != null) {
                fVar.tipDialog.dismiss();
            }
            fVar.tipDialog = h.b(fVar.mContext, fVar.mContext.getString(R.string.a7n), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    i.this.eVT = true;
                }
            });
        }
        AppMethodBeat.o(13491);
    }

    static /* synthetic */ void e(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(13493);
        bindMContactVerifyUI.Ni(1);
        AppMethodBeat.o(13493);
    }
}
