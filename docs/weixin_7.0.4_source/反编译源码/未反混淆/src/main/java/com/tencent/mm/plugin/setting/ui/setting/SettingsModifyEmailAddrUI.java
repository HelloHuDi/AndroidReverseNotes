package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
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
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.friend.a.aj;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.view.d;

public class SettingsModifyEmailAddrUI extends MMActivity implements f, b {
    private ProgressDialog ehJ;
    private String grp = null;
    private String grq = null;
    private EditText qnH;
    private String qnI;
    private String qnJ;
    private TextView qnK;
    private TextView qnL;
    private boolean qnM;
    private boolean qnN;
    private boolean qnO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.i(127302);
        settingsModifyEmailAddrUI.goBack();
        AppMethodBeat.o(127302);
    }

    static /* synthetic */ void b(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        AppMethodBeat.i(127303);
        settingsModifyEmailAddrUI.ciS();
        AppMethodBeat.o(127303);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127292);
        super.onCreate(bundle);
        initView();
        g.Rg().a(138, (f) this);
        g.Rg().a((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        g.Rg().a(256, (f) this);
        g.Rg().a(108, (f) this);
        g.Rg().a(255, (f) this);
        g.RP().Ry().a(this);
        AppMethodBeat.o(127292);
    }

    public final int getLayoutId() {
        return R.layout.aru;
    }

    public void onDestroy() {
        AppMethodBeat.i(127293);
        g.Rg().b(138, (f) this);
        g.Rg().b((int) d.MIC_PTU_ZIPAI_LIGHTRED, (f) this);
        g.Rg().b(256, (f) this);
        g.Rg().b(108, (f) this);
        g.Rg().b(255, (f) this);
        g.RP().Ry().b(this);
        super.onDestroy();
        AppMethodBeat.o(127293);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(127294);
        ab.d("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(bo.g(obj, 0)), nVar);
        if (nVar != g.RP().Ry() || r0 <= 0) {
            ab.e("MiroMsg.SettingsModifyEmailAddrUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(r0), nVar);
            AppMethodBeat.o(127294);
            return;
        }
        Integer num = (Integer) g.RP().Ry().get(7, null);
        this.qnI = (String) g.RP().Ry().get(5, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qnM = z;
        this.qnO = this.qnM;
        if (this.qnN) {
            ciR();
        }
        AppMethodBeat.o(127294);
    }

    public final void initView() {
        AppMethodBeat.i(127295);
        setMMTitle((int) R.string.e8i);
        this.qnH = (EditText) findViewById(R.id.e_8);
        this.qnK = (TextView) findViewById(R.id.e__);
        this.qnL = (TextView) findViewById(R.id.e_9);
        this.qnI = (String) g.RP().Ry().get(5, null);
        this.qnH.setText(this.qnI);
        Integer num = (Integer) g.RP().Ry().get(7, null);
        boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
        this.qnM = z;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127281);
                SettingsModifyEmailAddrUI.a(SettingsModifyEmailAddrUI.this);
                AppMethodBeat.o(127281);
                return true;
            }
        });
        this.qnN = true;
        ciR();
        AppMethodBeat.o(127295);
    }

    private void ciR() {
        AppMethodBeat.i(127296);
        if (this.qnM) {
            this.qnK.setVisibility(0);
            this.qnK.setText(getString(R.string.eca));
            this.qnL.setText(getString(R.string.e8j));
            this.qnL.setTextColor(getResources().getColor(R.color.ds));
            this.qnH.setEnabled(false);
            this.qnH.setFilters(new InputFilter[]{new InputFilter() {
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    AppMethodBeat.i(127282);
                    CharSequence subSequence;
                    if (charSequence.length() <= 0) {
                        subSequence = spanned.subSequence(i3, i4);
                        AppMethodBeat.o(127282);
                        return subSequence;
                    }
                    subSequence = "";
                    AppMethodBeat.o(127282);
                    return subSequence;
                }
            }});
            this.qnK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127284);
                    g.Rg().a(new y(y.gvY), 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    Context context = SettingsModifyEmailAddrUI.this;
                    SettingsModifyEmailAddrUI.this.getString(R.string.tz);
                    settingsModifyEmailAddrUI.ehJ = h.b(context, SettingsModifyEmailAddrUI.this.getString(R.string.ecf), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    SettingsModifyEmailAddrUI.this.aqX();
                    AppMethodBeat.o(127284);
                }
            });
            hideVKB(this.qnH);
            AppMethodBeat.o(127296);
        } else if (bo.isNullOrNil(this.qnI)) {
            ciS();
            AppMethodBeat.o(127296);
        } else {
            this.qnK.setVisibility(0);
            this.qnK.setText(getString(R.string.e49));
            this.qnL.setText(getString(R.string.e46));
            this.qnL.setTextColor(getResources().getColor(R.color.xy));
            this.qnH.setEnabled(false);
            this.qnH.setFilters(new InputFilter[]{new InputFilter() {
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    AppMethodBeat.i(127285);
                    CharSequence subSequence;
                    if (charSequence.length() <= 0) {
                        subSequence = spanned.subSequence(i3, i4);
                        AppMethodBeat.o(127285);
                        return subSequence;
                    }
                    subSequence = "";
                    AppMethodBeat.o(127285);
                    return subSequence;
                }
            }});
            this.qnK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127287);
                    final m ajVar = new aj((String) g.RP().Ry().get(2, null));
                    g.Rg().a(ajVar, 0);
                    SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                    Context context = SettingsModifyEmailAddrUI.this.mController.ylL;
                    SettingsModifyEmailAddrUI.this.getString(R.string.tz);
                    settingsModifyEmailAddrUI.ehJ = h.b(context, SettingsModifyEmailAddrUI.this.getString(R.string.e6g), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(127286);
                            g.Rg().c(ajVar);
                            AppMethodBeat.o(127286);
                        }
                    });
                    SettingsModifyEmailAddrUI.this.aqX();
                    AppMethodBeat.o(127287);
                }
            });
            addTextOptionMenu(0, getString(R.string.pg), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(127288);
                    SettingsModifyEmailAddrUI.b(SettingsModifyEmailAddrUI.this);
                    AppMethodBeat.o(127288);
                    return true;
                }
            });
            hideVKB(this.qnH);
            AppMethodBeat.o(127296);
        }
    }

    private void ciS() {
        AppMethodBeat.i(127297);
        this.qnK.setVisibility(8);
        this.qnK.setText(getString(R.string.eca));
        this.qnL.setText(getString(R.string.e8j));
        this.qnL.setTextColor(getResources().getColor(R.color.ds));
        this.qnH.setEnabled(true);
        this.qnH.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return null;
            }
        }});
        addTextOptionMenu(0, getString(R.string.tc), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127290);
                SettingsModifyEmailAddrUI.this.qnJ = SettingsModifyEmailAddrUI.this.qnH.getText().toString().trim();
                if (bo.amW(SettingsModifyEmailAddrUI.this.qnJ)) {
                    Integer num = (Integer) g.RP().Ry().get(7, null);
                    boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
                    Boolean valueOf = Boolean.valueOf(z);
                    if (SettingsModifyEmailAddrUI.this.qnJ.equals(SettingsModifyEmailAddrUI.this.qnI) && valueOf.booleanValue()) {
                        SettingsModifyEmailAddrUI.this.finish();
                    } else {
                        final m dVar = new com.tencent.mm.plugin.account.model.d(com.tencent.mm.plugin.account.model.d.gyK, SettingsModifyEmailAddrUI.this.qnJ);
                        g.Rg().a(dVar, 0);
                        SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = SettingsModifyEmailAddrUI.this;
                        Context context = SettingsModifyEmailAddrUI.this;
                        SettingsModifyEmailAddrUI.this.getString(R.string.tz);
                        settingsModifyEmailAddrUI.ehJ = h.b(context, SettingsModifyEmailAddrUI.this.getString(R.string.e62), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127289);
                                g.Rg().c(dVar);
                                AppMethodBeat.o(127289);
                            }
                        });
                        SettingsModifyEmailAddrUI.this.aqX();
                    }
                    AppMethodBeat.o(127290);
                } else {
                    h.g(SettingsModifyEmailAddrUI.this.mController.ylL, R.string.f0o, R.string.tz);
                    AppMethodBeat.o(127290);
                }
                return true;
            }
        });
        AppMethodBeat.o(127297);
    }

    private void goBack() {
        AppMethodBeat.i(127298);
        aqX();
        finish();
        if (this.qnO) {
            setResult(-1);
            AppMethodBeat.o(127298);
            return;
        }
        setResult(0);
        AppMethodBeat.o(127298);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127299);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(127299);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127299);
        return onKeyDown;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127300);
        ab.i("MiroMsg.SettingsModifyEmailAddrUI", "onSceneEnd: sceneType = " + mVar.getType() + " errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (com.tencent.mm.plugin.setting.b.gkF.a(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(127300);
            return;
        }
        if (mVar.getType() == d.MIC_PTU_ZIPAI_LIGHTRED) {
            if (i == 0 && i2 == 0) {
                this.grq = ((y) mVar).aqe().vZs;
                this.grp = ((y) mVar).aqd();
                if (bo.isNullOrNil(this.grq)) {
                    g.Rg().a(new r(2), 0);
                    AppMethodBeat.o(127300);
                    return;
                }
                g.Rg().a(new com.tencent.mm.plugin.account.model.d(com.tencent.mm.plugin.account.model.d.gyL, this.qnH.getText().toString().trim()), 0);
                AppMethodBeat.o(127300);
                return;
            }
            if (this.ehJ != null) {
                this.ehJ.dismiss();
                this.ehJ = null;
            }
            if (i2 == -3) {
                ab.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
                h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127291);
                        Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
                        intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.ecb));
                        intent.putExtra("from_unbind", true);
                        SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
                        AppMethodBeat.o(127291);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            } else if (i2 == -82) {
                h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            } else if (i2 == -83) {
                h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            } else if (i2 == -84) {
                h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            } else if (i2 == -85) {
                h.a((Context) this, (int) R.string.e4i, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            }
        } else if (mVar.getType() == 256) {
            com.tencent.mm.plugin.setting.b.gkF.BS();
            if (((com.tencent.mm.plugin.account.model.d) mVar).Ah() == com.tencent.mm.plugin.account.model.d.gyK) {
                if (i == 0 && i2 == 0) {
                    h.a(this.mController.ylL, (int) R.string.e6f, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                }
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i2 == -82) {
                    h.a((Context) this, (int) R.string.e4r, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                } else if (i2 == -83) {
                    h.a((Context) this, (int) R.string.e4o, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                } else if (i2 == -84) {
                    h.a((Context) this, (int) R.string.e4p, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                } else if (i2 == -85) {
                    h.a((Context) this, (int) R.string.e4i, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                } else if (i2 == -86) {
                    h.a((Context) this, (int) R.string.e4t, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                } else {
                    h.a(this.mController.ylL, getString(R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                }
            } else if (((com.tencent.mm.plugin.account.model.d) mVar).Ah() == com.tencent.mm.plugin.account.model.d.gyL) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i == 0 && i2 == 0) {
                    g.RP().Ry().set(7, Integer.valueOf(((Integer) g.RP().Ry().get(7, null)).intValue() | 2));
                    if (bo.isNullOrNil(this.grq)) {
                        h.a(this.mController.ylL, (int) R.string.e4k, (int) R.string.tz, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(127300);
                        return;
                    }
                    h.a(this.mController.ylL, this.grq, "", getString(R.string.r4), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                }
            }
        } else if (mVar.getType() != 138) {
            if (mVar.getType() == 108) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (i == 0 && i2 == 0) {
                    h.a(this.mController.ylL, (int) R.string.e6f, (int) R.string.tz, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(127300);
                    return;
                }
                h.a(this.mController.ylL, getString(R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.string.tz), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(127300);
                return;
            } else if (mVar.getType() == 255) {
                if (i2 == 0) {
                    g.Rg().a(new com.tencent.mm.plugin.account.model.d(com.tencent.mm.plugin.account.model.d.gyL, this.qnH.getText().toString().trim()), 0);
                    AppMethodBeat.o(127300);
                    return;
                }
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                h.a(this.mController.ylL, getString(R.string.ecd), null, getString(R.string.ece), getString(R.string.ecc), true, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127283);
                        Intent intent = new Intent(SettingsModifyEmailAddrUI.this, RegByMobileSetPwdUI.class);
                        intent.putExtra("kintent_hint", SettingsModifyEmailAddrUI.this.getString(R.string.ecb));
                        intent.putExtra("from_unbind", true);
                        SettingsModifyEmailAddrUI.this.startActivityForResult(intent, 1);
                        AppMethodBeat.o(127283);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
        AppMethodBeat.o(127300);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127301);
        super.onActivityResult(i, i2, intent);
        ab.d("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    ab.i("MiroMsg.SettingsModifyEmailAddrUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again oldEmail: " + this.qnI + " newEmail: " + this.qnJ);
                    g.Rg().a(new y(y.gvY), 0);
                    getString(R.string.tz);
                    this.ehJ = h.b((Context) this, getString(R.string.e7z), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    break;
                }
                break;
        }
        AppMethodBeat.o(127301);
    }
}
