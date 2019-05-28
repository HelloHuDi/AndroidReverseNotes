package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import com.tencent.view.d;

public class BindQQUI extends MMWizardActivity implements f {
    private String grp = null;
    private String grq = null;
    p tipDialog;
    private int type = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13554);
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
        g.Rg().a((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        g.Rg().a(255, (f) this);
        AppMethodBeat.o(13554);
    }

    public void onDestroy() {
        AppMethodBeat.i(13555);
        g.Rg().b((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        g.Rg().b(255, (f) this);
        super.onDestroy();
        AppMethodBeat.o(13555);
    }

    public void onResume() {
        AppMethodBeat.i(13556);
        super.onResume();
        initView();
        AppMethodBeat.o(13556);
    }

    public final int getLayoutId() {
        return R.layout.gm;
    }

    public final void initView() {
        AppMethodBeat.i(13557);
        long longValue = new com.tencent.mm.a.p(bo.h((Integer) g.RP().Ry().get(9, null))).longValue();
        if (longValue == 0) {
            apf();
        } else {
            gd(longValue);
        }
        if (this.type == 1) {
            addTextOptionMenu(0, getString(R.string.r7), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(13546);
                    BindQQUI.a(BindQQUI.this);
                    AppMethodBeat.o(13546);
                    return true;
                }
            });
            AppMethodBeat.o(13557);
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13547);
                BindQQUI.this.aqX();
                BindQQUI.this.finish();
                AppMethodBeat.o(13547);
                return true;
            }
        });
        AppMethodBeat.o(13557);
    }

    private void apf() {
        AppMethodBeat.i(13558);
        setMMTitle((int) R.string.a8h);
        TextView textView = (TextView) findViewById(R.id.a6d);
        textView.setVisibility(8);
        textView.setText(R.string.a8f);
        ((TextView) findViewById(R.id.a6c)).setVisibility(8);
        Button button = (Button) findViewById(R.id.a6e);
        button.setVisibility(0);
        button.setText(R.string.a8e);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13548);
                MMWizardActivity.J(BindQQUI.this, new Intent(BindQQUI.this, VerifyQQUI.class));
                AppMethodBeat.o(13548);
            }
        });
        removeOptionMenu(1);
        AppMethodBeat.o(13558);
    }

    private void gd(long j) {
        AppMethodBeat.i(13559);
        setMMTitle((int) R.string.a8d);
        TextView textView = (TextView) findViewById(R.id.a6d);
        textView.setVisibility(8);
        textView.setText(R.string.a8b);
        textView = (TextView) findViewById(R.id.a6c);
        textView.setVisibility(0);
        textView.setText(getString(R.string.a8c) + j);
        Button button = (Button) findViewById(R.id.a6e);
        button.setVisibility(8);
        button.setText(R.string.caq);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        addIconOptionMenu(1, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13551);
                j jVar = new j(BindQQUI.this.mController.ylL);
                jVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(13549);
                        lVar.setHeaderTitle((int) R.string.a6z);
                        lVar.hi(0, R.string.ey9);
                        AppMethodBeat.o(13549);
                    }
                };
                jVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(13550);
                        switch (menuItem.getItemId()) {
                            case 0:
                                Context context = BindQQUI.this;
                                g.Rg().a(new y(y.gvV), 0);
                                context.getString(R.string.tz);
                                context.tipDialog = h.b(context, context.getString(R.string.rd), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(13550);
                    }
                };
                jVar.cuu();
                AppMethodBeat.o(13551);
                return false;
            }
        });
        AppMethodBeat.o(13559);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13560);
        ab.d("MicroMsg.BindQQUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (mVar.getType() == d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (i == 0 && i2 == 0) {
                this.grp = ((y) mVar).aqd();
                if (this.grp != null && this.grp.length() > 0) {
                    g.RP().Ry().set(102407, this.grp);
                }
                if (bo.isNullOrNil(this.grq)) {
                    g.Rg().a(new r(2), 0);
                    AppMethodBeat.o(13560);
                    return;
                }
                Intent intent = new Intent(this, StartUnbindQQ.class);
                intent.putExtra("notice", this.grq);
                MMWizardActivity.J(this, intent);
                AppMethodBeat.o(13560);
                return;
            }
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == -3) {
                ab.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13552);
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindQQUI.this.getString(R.string.ecb));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bp.d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(13552);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -81) {
                h.a((Context) this, (int) R.string.e4q, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -82) {
                h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -83) {
                h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -84) {
                h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -85) {
                h.a((Context) this, (int) R.string.e4n, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            } else if (i2 == -86) {
                h.a((Context) this, (int) R.string.e4t, (int) R.string.tz, null);
                AppMethodBeat.o(13560);
                return;
            }
        } else if (mVar.getType() == 255) {
            if (i2 == 0) {
                MMWizardActivity.J(this, new Intent(this, StartUnbindQQ.class));
                AppMethodBeat.o(13560);
                return;
            }
            h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13553);
                    Intent intent = new Intent();
                    intent.putExtra("kintent_hint", BindQQUI.this.getString(R.string.ecb));
                    intent.putExtra("from_unbind", true);
                    com.tencent.mm.bp.d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                    AppMethodBeat.o(13553);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(13560);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13561);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    ab.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
                    g.Rg().a(new y(y.gvV), 0);
                    getString(R.string.tz);
                    this.tipDialog = h.b((Context) this, getString(R.string.rd), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(13561);
    }

    static /* synthetic */ void a(BindQQUI bindQQUI) {
        AppMethodBeat.i(13562);
        bindQQUI.Ni(1);
        AppMethodBeat.o(13562);
    }
}
