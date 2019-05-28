package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.au.b;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.j;
import com.tencent.view.d;

public class BindMContactIntroUI extends MMWizardActivity implements f {
    private String cFl;
    private boolean gqB = false;
    private ImageView gri;
    private TextView grj;
    private TextView grk;
    private Button grl;
    private Button grm;
    private a grn;
    private i gro;
    private String grp = null;
    private String grq = null;
    private int grr;
    private int grs = 0;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(13450);
        bindMContactIntroUI.aoZ();
        AppMethodBeat.o(13450);
    }

    public final int getLayoutId() {
        return R.layout.gh;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13438);
        super.onCreate(bundle);
        g.Rg().a(132, (f) this);
        g.Rg().a(255, (f) this);
        g.Rg().a((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        setMMTitle((int) R.string.a7a);
        AppMethodBeat.o(13438);
    }

    public void onDestroy() {
        AppMethodBeat.i(13439);
        g.Rg().b(132, (f) this);
        g.Rg().b(255, (f) this);
        g.Rg().b((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        if (this.gro != null) {
            this.gro.recycle();
        }
        super.onDestroy();
        AppMethodBeat.o(13439);
    }

    public void onResume() {
        AppMethodBeat.i(13440);
        super.onResume();
        initView();
        AppMethodBeat.o(13440);
    }

    public final void initView() {
        AppMethodBeat.i(13441);
        this.grr = getIntent().getIntExtra("bind_scene", 0);
        this.gqB = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.grs = getIntent().getIntExtra("key_upload_scene", 0);
        this.grn = l.apS();
        ab.d("MicroMsg.BindMContactIntroUI", "state " + this.grn);
        this.cFl = (String) g.RP().Ry().get(6, null);
        if (this.cFl == null || this.cFl.equals("")) {
            this.cFl = (String) g.RP().Ry().get(4097, null);
        }
        this.gri = (ImageView) findViewById(R.id.a5x);
        this.grj = (TextView) findViewById(R.id.a5y);
        this.grk = (TextView) findViewById(R.id.a5z);
        this.grl = (Button) findViewById(R.id.a60);
        this.grm = (Button) findViewById(R.id.a61);
        this.grl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13422);
                BindMContactIntroUI.a(BindMContactIntroUI.this);
                AppMethodBeat.o(13422);
            }
        });
        this.grm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(13426);
                BindMContactIntroUI.b(BindMContactIntroUI.this);
                AppMethodBeat.o(13426);
            }
        });
        if (getIntent().getBooleanExtra("skip", false)) {
            addTextOptionMenu(0, getString(R.string.r7), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(13429);
                    BindMContactIntroUI.c(BindMContactIntroUI.this);
                    AppMethodBeat.o(13429);
                    return true;
                }
            });
        } else {
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(13430);
                    BindMContactIntroUI.c(BindMContactIntroUI.this);
                    AppMethodBeat.o(13430);
                    return true;
                }
            });
        }
        if (this.grn == a.SUCC_UNLOAD || this.grn == a.SUCC) {
            String value = com.tencent.mm.m.g.Nu().getValue("ShowUnbindPhone");
            int i = 2;
            if (!bo.isNullOrNil(value)) {
                i = bo.ank(value);
            }
            if (i != 0) {
                addIconOptionMenu(1, R.drawable.uu, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(13433);
                        j jVar = new j(BindMContactIntroUI.this.mController.ylL);
                        jVar.rBl = new c() {
                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                AppMethodBeat.i(13431);
                                lVar.setHeaderTitle((int) R.string.a6z);
                                if ((i & 2) != 0) {
                                    lVar.hi(0, R.string.a7h);
                                }
                                if ((i & 1) != 0) {
                                    lVar.hi(1, R.string.a6e);
                                }
                                AppMethodBeat.o(13431);
                            }
                        };
                        jVar.rBm = new n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(13432);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        BindMContactIntroUI.d(BindMContactIntroUI.this);
                                        AppMethodBeat.o(13432);
                                        return;
                                    case 1:
                                        Intent intent = new Intent();
                                        intent.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                                        com.tencent.mm.bp.d.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                                        break;
                                }
                                AppMethodBeat.o(13432);
                            }
                        };
                        jVar.cuu();
                        AppMethodBeat.o(13433);
                        return false;
                    }
                });
            }
        }
        cu();
        AppMethodBeat.o(13441);
    }

    private void cu() {
        AppMethodBeat.i(13442);
        switch (this.grn) {
            case NO_INIT:
                showOptionMenu(1, false);
                this.gri.setImageResource(R.raw.mobile_unbind_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(8);
                this.grj.setText(R.string.a6u);
                this.grk.setText(R.string.a6t);
                this.grl.setText(R.string.a65);
                AppMethodBeat.o(13442);
                return;
            case SET_MOBILE:
                showOptionMenu(1, false);
                this.gri.setImageResource(R.raw.mobile_unbind_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(R.string.a7l);
                this.grl.setText(R.string.a7p);
                this.grm.setText(R.string.a6f);
                AppMethodBeat.o(13442);
                return;
            case SUCC_UNLOAD:
                showOptionMenu(1, true);
                this.gri.setImageResource(R.raw.mobile_binded_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(R.string.a6b);
                this.grl.setText(R.string.a7m);
                this.grm.setText(R.string.a6d);
                AppMethodBeat.o(13442);
                return;
            case SUCC:
                showOptionMenu(1, true);
                this.gri.setImageResource(R.raw.mobile_binded_icon);
                this.grk.setVisibility(0);
                this.grm.setVisibility(0);
                this.grj.setText(String.format(getString(R.string.a7v), new Object[]{this.cFl}));
                this.grk.setText(R.string.a6b);
                this.grl.setText(R.string.a6s);
                this.grm.setText(R.string.a6d);
                break;
        }
        AppMethodBeat.o(13442);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(13443);
        if (i == 4) {
            aoZ();
            AppMethodBeat.o(13443);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(13443);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.i(13444);
        aqX();
        if (this.grr == 2) {
            cancel();
            finish();
            AppMethodBeat.o(13444);
            return;
        }
        Ni(1);
        AppMethodBeat.o(13444);
    }

    private void dj(boolean z) {
        AppMethodBeat.i(13445);
        Intent intent = new Intent(this, BindMContactUI.class);
        if (z) {
            intent.putExtra("bind_scene", 3);
        } else {
            intent.putExtra("bind_scene", 0);
        }
        String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
        if (!bo.isNullOrNil(simCountryIso)) {
            b.a k = b.k(this, simCountryIso, getString(R.string.b3_));
            if (k != null) {
                intent.putExtra("country_name", k.fHE);
                intent.putExtra("couttry_code", k.fHD);
            }
        }
        MMWizardActivity.J(this, intent);
        AppMethodBeat.o(13445);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(13446);
        ab.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + mVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() == 132 && i == 0 && i2 == 0) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((x) mVar).Ah() == 3) {
                ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
                if (bo.isNullOrNil(this.grq)) {
                    MMWizardActivity.J(this, new Intent(this, BindMContactStatusUI.class));
                } else {
                    h.a((Context) this, this.grq, "", getString(R.string.r4), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(13436);
                            MMWizardActivity.J(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
                            AppMethodBeat.o(13436);
                        }
                    });
                    AppMethodBeat.o(13446);
                    return;
                }
            }
            AppMethodBeat.o(13446);
            return;
        }
        Object obj;
        if (!com.tencent.mm.plugin.account.a.a.gkF.a((Context) this, i, i2, str)) {
            obj = null;
            switch (i2) {
                case -214:
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                    }
                    obj = 1;
                    break;
                case -43:
                    Toast.makeText(this, R.string.a6h, 0).show();
                    obj = 1;
                    break;
                case -41:
                    Toast.makeText(this, R.string.a6j, 0).show();
                    obj = 1;
                    break;
                case -36:
                    Toast.makeText(this, R.string.a6m, 0).show();
                    obj = 1;
                    break;
                case -35:
                    Toast.makeText(this, R.string.a6i, 0).show();
                    obj = 1;
                    break;
                case -34:
                    Toast.makeText(this, R.string.a6k, 0).show();
                    obj = 1;
                    break;
            }
        }
        obj = 1;
        if (obj != null) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            AppMethodBeat.o(13446);
            return;
        }
        final m xVar;
        Context context;
        if (mVar.getType() == d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0) {
                this.grq = ((y) mVar).aqe().vZs;
                this.grp = ((y) mVar).aqd();
                if (bo.isNullOrNil(this.grq)) {
                    g.Rg().a(new r(2), 0);
                    AppMethodBeat.o(13446);
                    return;
                }
                xVar = new x(this.cFl, 3, "", 0, "");
                g.Rg().a(xVar, 0);
                context = this.mController.ylL;
                getString(R.string.tz);
                this.tipDialog = h.b(context, getString(R.string.a7k), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(13437);
                        g.Rg().c(xVar);
                        AppMethodBeat.o(13437);
                    }
                });
                AppMethodBeat.o(13446);
                return;
            } else if (i2 == -3) {
                ab.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13423);
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.ecb));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bp.d.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(13423);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -81) {
                h.a((Context) this, (int) R.string.e4q, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -82) {
                h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -83) {
                h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -84) {
                h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -85) {
                h.a((Context) this, (int) R.string.e4l, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -86) {
                h.a((Context) this, (int) R.string.e4t, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        if (mVar.getType() == 255) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i2 == 0) {
                xVar = new x(this.cFl, 3, "", 0, "");
                g.Rg().a(xVar, 0);
                context = this.mController.ylL;
                getString(R.string.tz);
                this.tipDialog = h.b(context, getString(R.string.a7k), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(13424);
                        g.Rg().c(xVar);
                        AppMethodBeat.o(13424);
                    }
                });
            } else {
                ab.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
                h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(13425);
                        Intent intent = new Intent();
                        intent.putExtra("kintent_hint", BindMContactIntroUI.this.getString(R.string.ecb));
                        intent.putExtra("from_unbind", true);
                        com.tencent.mm.bp.d.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
                        AppMethodBeat.o(13425);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        if (mVar.getType() == 132) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (((x) mVar).Ah() == 3) {
                if (i2 == -82) {
                    h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13446);
                    return;
                } else if (i2 == -83) {
                    h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13446);
                    return;
                } else if (i2 == -84) {
                    h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13446);
                    return;
                } else if (i2 == -85) {
                    h.a((Context) this, (int) R.string.e4l, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(13446);
                    return;
                } else {
                    Toast.makeText(this, getString(R.string.a7g, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
        AppMethodBeat.o(13446);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(13447);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    ab.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.cFl);
                    g.Rg().a(new y(y.gvW), 0);
                    getString(R.string.tz);
                    this.tipDialog = h.b((Context) this, getString(R.string.rd), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(13447);
    }

    static /* synthetic */ void a(BindMContactIntroUI bindMContactIntroUI) {
        boolean z = false;
        AppMethodBeat.i(13448);
        switch (bindMContactIntroUI.grn) {
            case NO_INIT:
                bindMContactIntroUI.dj(false);
                AppMethodBeat.o(13448);
                return;
            case SET_MOBILE:
                final String str = bindMContactIntroUI.cFl;
                if (bindMContactIntroUI.gro == null) {
                    bindMContactIntroUI.gro = new i(i.b.BINDMOBILE, bindMContactIntroUI, new i.a() {
                        public final void e(int i, Bundle bundle) {
                            AppMethodBeat.i(13435);
                            Intent intent;
                            if (i == 2) {
                                if (BindMContactIntroUI.this.grr == 1) {
                                    if (!com.tencent.mm.model.r.YH()) {
                                        tt ttVar = new tt();
                                        ttVar.cPS.cPT = true;
                                        ttVar.cPS.cPU = true;
                                        com.tencent.mm.sdk.b.a.xxA.m(ttVar);
                                    }
                                    BindMContactIntroUI.g(BindMContactIntroUI.this);
                                    intent = new Intent();
                                    intent.addFlags(67108864);
                                    com.tencent.mm.plugin.account.a.a.gkE.e(BindMContactIntroUI.this, intent);
                                    AppMethodBeat.o(13435);
                                    return;
                                }
                                MMWizardActivity.J(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class).putExtra("bind_scene", BindMContactIntroUI.this.grr));
                                if (BindMContactIntroUI.this.gqB) {
                                    if (BindMContactIntroUI.this.grr == 2) {
                                        com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                                        AppMethodBeat.o(13435);
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(2));
                                    AppMethodBeat.o(13435);
                                    return;
                                }
                            } else if (i == 1) {
                                intent = new Intent(BindMContactIntroUI.this, BindMContactVerifyUI.class);
                                intent.putExtra("bindmcontact_mobile", str);
                                intent.putExtra("bind_scene", BindMContactIntroUI.this.grr);
                                intent.putExtra("KEnterFromBanner", BindMContactIntroUI.this.gqB);
                                MMWizardActivity.J(BindMContactIntroUI.this, intent);
                            }
                            AppMethodBeat.o(13435);
                        }
                    });
                }
                i iVar = bindMContactIntroUI.gro;
                if (bindMContactIntroUI.grr == 0 || bindMContactIntroUI.grr == 3) {
                    z = true;
                }
                iVar.gys = z;
                bindMContactIntroUI.gro.wn(str);
                AppMethodBeat.o(13448);
                return;
            case SUCC_UNLOAD:
                g.RP().Ry().set(12322, Boolean.FALSE);
                ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).showAddrBookUploadConfirm(bindMContactIntroUI, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(13427);
                        if (l.apQ()) {
                            BindMContactIntroUI.apa();
                            BindMContactIntroUI.this.grl.setText(BindMContactIntroUI.this.getString(R.string.a6s));
                            BindMContactIntroUI.this.grn = a.SUCC;
                            boolean a = bo.a((Boolean) g.RP().Ry().get(12322, Boolean.FALSE), false);
                            if (BindMContactIntroUI.this.gqB && a) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(3));
                            }
                        }
                        AppMethodBeat.o(13427);
                    }
                }, true, bindMContactIntroUI.grs);
                break;
            case SUCC:
                bindMContactIntroUI.startActivity(new Intent(bindMContactIntroUI, MobileFriendUI.class));
                AppMethodBeat.o(13448);
                return;
        }
        AppMethodBeat.o(13448);
    }

    static /* synthetic */ void b(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(13449);
        switch (bindMContactIntroUI.grn) {
            case NO_INIT:
                AppMethodBeat.o(13449);
                return;
            case SET_MOBILE:
                l.apT();
                bindMContactIntroUI.initView();
                AppMethodBeat.o(13449);
                return;
            case SUCC_UNLOAD:
                bindMContactIntroUI.dj(true);
                break;
            case SUCC:
                bindMContactIntroUI.dj(true);
                AppMethodBeat.o(13449);
                return;
        }
        AppMethodBeat.o(13449);
    }

    static /* synthetic */ void d(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(13451);
        h.d(bindMContactIntroUI.mController.ylL, bindMContactIntroUI.getString(R.string.a7e), bindMContactIntroUI.getString(R.string.a7f), bindMContactIntroUI.getString(R.string.or), bindMContactIntroUI.getString(R.string.a7d), null, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(13434);
                if (BindMContactIntroUI.this.cFl == null || BindMContactIntroUI.this.cFl.equals("")) {
                    AppMethodBeat.o(13434);
                    return;
                }
                g.Rg().a(new y(y.gvW), 0);
                BindMContactIntroUI bindMContactIntroUI = BindMContactIntroUI.this;
                Context context = BindMContactIntroUI.this;
                BindMContactIntroUI.this.getString(R.string.tz);
                bindMContactIntroUI.tipDialog = h.b(context, BindMContactIntroUI.this.getString(R.string.rd), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                AppMethodBeat.o(13434);
            }
        });
        AppMethodBeat.o(13451);
    }

    static /* synthetic */ void g(BindMContactIntroUI bindMContactIntroUI) {
        AppMethodBeat.i(13452);
        bindMContactIntroUI.Ni(1);
        AppMethodBeat.o(13452);
    }

    static /* synthetic */ void apa() {
        AppMethodBeat.i(13453);
        int YD = com.tencent.mm.model.r.YD();
        l.apP();
        g.RP().Ry().set(7, Integer.valueOf(YD & -131073));
        com.tencent.mm.plugin.account.a.a.gkF.BS();
        AppMethodBeat.o(13453);
    }
}
