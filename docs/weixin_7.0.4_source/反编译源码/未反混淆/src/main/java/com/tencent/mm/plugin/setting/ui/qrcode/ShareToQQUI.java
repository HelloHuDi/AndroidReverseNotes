package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.model.h;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.view.d;

public class ShareToQQUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private EditText pwu;
    private TextView qkx;
    private int qky;
    private boolean qkz = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.t_;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126926);
        super.onCreate(bundle);
        g.Rg().a(26, (f) this);
        initView();
        if (r.Za()) {
            c cVar = new c(getString(R.string.g7d));
            cVar.arX(bo.nullAsNil((String) g.RP().Ry().get(65830, null)));
            new h(cVar, new i() {
                public final void p(Bundle bundle) {
                    AppMethodBeat.i(126923);
                    super.p(bundle);
                    AppMethodBeat.o(126923);
                }

                public final void onError(int i, String str) {
                    AppMethodBeat.i(126924);
                    super.onError(i, str);
                    if (i == 3) {
                        ShareToQQUI.d(ShareToQQUI.this);
                    }
                    AppMethodBeat.o(126924);
                }
            }).apm();
        }
        AppMethodBeat.o(126926);
    }

    public void onDestroy() {
        AppMethodBeat.i(126927);
        g.Rg().b(26, (f) this);
        super.onDestroy();
        AppMethodBeat.o(126927);
    }

    public final void initView() {
        AppMethodBeat.i(126928);
        setMMTitle((int) R.string.e3f);
        this.pwu = (EditText) findViewById(R.id.m5);
        this.qkx = (TextView) findViewById(R.id.b5v);
        this.pwu.addTextChangedListener(new MMEditText.c(this.pwu, this.qkx, d.MIC_PTU_TRANS_XINXIAN));
        this.qky = getIntent().getIntExtra("show_to", 2);
        if (this.qky == 4) {
            this.pwu.setText(R.string.e2q);
        } else {
            this.pwu.setText(R.string.e2s);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126916);
                ShareToQQUI.this.aqX();
                ShareToQQUI.this.finish();
                AppMethodBeat.o(126916);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.tl), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                m vVar;
                AppMethodBeat.i(126920);
                ShareToQQUI.this.qkz = true;
                if (ShareToQQUI.this.qky == 2 || ShareToQQUI.this.qky == 1) {
                    boolean z;
                    boolean z2;
                    String obj = ShareToQQUI.this.pwu.getText().toString();
                    if (ShareToQQUI.this.qky == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (ShareToQQUI.this.qky == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    vVar = new v(obj, z, z2);
                } else if (ShareToQQUI.this.qky == 4) {
                    long c = bo.c((Long) g.RP().Ry().get(65831, null));
                    String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(65830, null));
                    if (bo.gb(c) > 86400000 && nullAsNil.length() > 0) {
                        c cVar = new c(ShareToQQUI.this.getString(R.string.g7d));
                        cVar.arX(nullAsNil);
                        new h(cVar, new i() {
                            public final void p(Bundle bundle) {
                                AppMethodBeat.i(126917);
                                super.p(bundle);
                                AppMethodBeat.o(126917);
                            }

                            public final void onError(int i, String str) {
                                AppMethodBeat.i(126918);
                                super.onError(i, str);
                                AppMethodBeat.o(126918);
                            }
                        }).apm();
                    }
                    vVar = new v(ShareToQQUI.this.pwu.getText().toString());
                } else {
                    com.tencent.mm.ui.base.h.g(ShareToQQUI.this.mController.ylL, R.string.egs, R.string.tz);
                    AppMethodBeat.o(126920);
                    return true;
                }
                g.Rg().a(vVar, 0);
                ShareToQQUI shareToQQUI = ShareToQQUI.this;
                Context context = ShareToQQUI.this.mController.ylL;
                ShareToQQUI.this.getString(R.string.tz);
                shareToQQUI.ehJ = com.tencent.mm.ui.base.h.b(context, ShareToQQUI.this.getString(R.string.th), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(126919);
                        g.Rg().c(vVar);
                        AppMethodBeat.o(126919);
                    }
                });
                AppMethodBeat.o(126920);
                return true;
            }
        });
        AppMethodBeat.o(126928);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(126929);
        ab.i("MicroMsg.ShareToQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 26) {
            AppMethodBeat.o(126929);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -68) {
            if (bo.isNullOrNil(str)) {
                str = "error";
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, getString(R.string.tz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(126921);
                    Intent intent = new Intent(ShareToQQUI.this.mController.ylL, FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    ShareToQQUI.this.mController.ylL.startActivity(intent);
                    ShareToQQUI.this.aqX();
                    ShareToQQUI.this.finish();
                    AppMethodBeat.o(126921);
                }
            }, null);
            AppMethodBeat.o(126929);
        } else if (i == 0 && i2 == 0) {
            aqX();
            String string = getString(R.string.egv);
            AnonymousClass4 anonymousClass4 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(126922);
                    ShareToQQUI.this.finish();
                    AppMethodBeat.o(126922);
                }
            };
            com.tencent.mm.ui.base.h.bQ(this, string);
            AppMethodBeat.o(126929);
        } else {
            this.qkz = false;
            if (b.gkF.a(this.mController.ylL, i, i2, str)) {
                AppMethodBeat.o(126929);
                return;
            }
            Toast.makeText(this, getString(R.string.egu, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(126929);
        }
    }

    static /* synthetic */ void d(ShareToQQUI shareToQQUI) {
        AppMethodBeat.i(126930);
        ab.e("MicroMsg.ShareToQQUI", "dealWithRefreshTokenFail");
        if (!shareToQQUI.qkz) {
            String string = shareToQQUI.mController.ylL.getString(R.string.tz);
            com.tencent.mm.ui.base.h.a(shareToQQUI.mController.ylL, shareToQQUI.mController.ylL.getString(R.string.bmb), string, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(126925);
                    Intent intent = new Intent(ShareToQQUI.this.mController.ylL, FacebookAuthUI.class);
                    intent.putExtra("is_force_unbind", true);
                    ShareToQQUI.this.mController.ylL.startActivityForResult(intent, 8);
                    AppMethodBeat.o(126925);
                }
            }, null);
        }
        AppMethodBeat.o(126930);
    }
}
