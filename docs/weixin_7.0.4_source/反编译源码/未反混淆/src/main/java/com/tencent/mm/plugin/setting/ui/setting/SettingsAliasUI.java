package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.q;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public class SettingsAliasUI extends MMActivity implements f {
    private String dFl;
    private ProgressDialog ehJ = null;
    private ImageView ejo;
    private TextView ejp;
    private TextView gGA;
    private EditText qmS;
    private d qmT;
    private boolean qmU = false;
    private TextView qmV;
    private f qmb = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127191);
        super.onCreate(bundle);
        this.qmU = getIntent().getBooleanExtra("KFromSetAliasTips", false);
        initView();
        g.Rg().a((int) ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, (f) this);
        AppMethodBeat.o(127191);
    }

    public final int getLayoutId() {
        return R.layout.aro;
    }

    public void onPause() {
        AppMethodBeat.i(127192);
        super.onPause();
        AppMethodBeat.o(127192);
    }

    public void onDestroy() {
        AppMethodBeat.i(127193);
        if (this.qmT != null) {
            g.Rg().c(this.qmT);
        }
        g.Rg().b((int) ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, (f) this);
        super.onDestroy();
        AppMethodBeat.o(127193);
    }

    public final void initView() {
        AppMethodBeat.i(127194);
        setMMTitle((int) R.string.d18);
        this.ejo = (ImageView) findViewById(R.id.qk);
        this.ejp = (TextView) findViewById(R.id.b6e);
        this.gGA = (TextView) findViewById(R.id.dw7);
        this.qmV = (TextView) findViewById(R.id.e9t);
        this.qmS = (EditText) findViewById(R.id.e9s);
        String Yz = r.Yz();
        if (!ad.aoA(Yz)) {
            this.qmS.setText(r.Yz());
            this.gGA.setText(getString(R.string.fr, new Object[]{Yz}));
        }
        this.qmS.setSelection(this.qmS.getText().length());
        this.qmS.setFocusable(true);
        this.qmS.setFocusableInTouchMode(true);
        this.qmS.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(127184);
                SettingsAliasUI settingsAliasUI = SettingsAliasUI.this;
                a aVar = new a();
                if (charSequence.length() < 6 || charSequence.length() > 20) {
                    aVar.aIm = settingsAliasUI.getString(R.string.f0k);
                    aVar.cxj = false;
                } else if (bo.z(charSequence.charAt(0))) {
                    int length = charSequence.length() - 1;
                    while (length > 0) {
                        char charAt = charSequence.charAt(length);
                        if (bo.z(charAt) || charAt == '-' || charAt == '_' || bo.A(charAt)) {
                            length--;
                        } else if (Character.isSpace(charAt)) {
                            aVar.aIm = settingsAliasUI.getString(R.string.f0h);
                            aVar.cxj = false;
                        } else if (bo.y(charAt)) {
                            aVar.aIm = settingsAliasUI.getString(R.string.f0f);
                            aVar.cxj = false;
                        } else {
                            aVar.aIm = settingsAliasUI.getString(R.string.f0k);
                            aVar.cxj = false;
                        }
                    }
                    aVar.aIm = settingsAliasUI.getString(R.string.d1a);
                    aVar.cxj = true;
                } else {
                    aVar.aIm = settingsAliasUI.getString(R.string.f0i);
                    aVar.cxj = false;
                }
                if (aVar.cxj) {
                    SettingsAliasUI.this.enableOptionMenu(true);
                    SettingsAliasUI.this.qmV.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(R.color.s0));
                } else {
                    SettingsAliasUI.this.enableOptionMenu(false);
                    SettingsAliasUI.this.qmV.setTextColor(SettingsAliasUI.this.getResources().getColorStateList(R.color.ze));
                }
                SettingsAliasUI.this.qmV.setText(aVar.aIm);
                SettingsAliasUI.this.gGA.setText(SettingsAliasUI.this.getString(R.string.fr, new Object[]{charSequence}));
                AppMethodBeat.o(127184);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.ejp.setText(j.b((Context) this, bo.nullAsNil(r.YB()), this.ejp.getTextSize()));
        b.b(this.ejo, Yz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127185);
                SettingsAliasUI.this.aqX();
                SettingsAliasUI.this.finish();
                AppMethodBeat.o(127185);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127187);
                SettingsAliasUI.this.dFl = SettingsAliasUI.this.qmS.getText().toString().trim();
                if (r.Yz().equalsIgnoreCase(SettingsAliasUI.this.dFl)) {
                    SettingsAliasUI.this.aqX();
                    SettingsAliasUI.this.finish();
                    AppMethodBeat.o(127187);
                } else {
                    h.a(SettingsAliasUI.this.mController.ylL, SettingsAliasUI.this.getString(R.string.d19, new Object[]{SettingsAliasUI.this.dFl}), SettingsAliasUI.this.getString(R.string.atj), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(127186);
                            SettingsAliasUI.e(SettingsAliasUI.this);
                            AppMethodBeat.o(127186);
                        }
                    }, null);
                    AppMethodBeat.o(127187);
                }
                return true;
            }
        }, q.b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.o(127194);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 1;
        AppMethodBeat.i(127195);
        if (i == 0 && i2 == 0) {
            if (this.qmU) {
                com.tencent.mm.plugin.report.service.h.pYm.X(10358, "1");
            }
            aqX();
            g.RP().Ry().set(42, this.dFl);
            p Rg = g.Rg();
            f anonymousClass5 = new f() {
                public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
                    AppMethodBeat.i(127190);
                    ab.d("MicroMsg.SettingsAliasUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
                    g.Rg().b(255, SettingsAliasUI.this.qmb);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127189);
                            if (SettingsAliasUI.this.ehJ != null) {
                                SettingsAliasUI.this.ehJ.dismiss();
                                SettingsAliasUI.this.ehJ = null;
                            }
                            SettingsAliasUI.this.qmb = null;
                            if (mVar.getType() == 255) {
                                boolean z = (i2 == -3 && i == 4) ? false : true;
                                Intent intent = new Intent(SettingsAliasUI.this, SettingsAliasResultUI.class);
                                intent.putExtra("has_pwd", z);
                                SettingsAliasUI.this.startActivity(intent);
                                SettingsAliasUI.this.finish();
                            }
                            AppMethodBeat.o(127189);
                        }
                    });
                    AppMethodBeat.o(127190);
                }
            };
            this.qmb = anonymousClass5;
            Rg.a(255, anonymousClass5);
            g.Rg().a(new com.tencent.mm.modelsimple.r(1), 0);
            AppMethodBeat.o(127195);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (!com.tencent.mm.plugin.setting.b.gkF.a(this.mController.ylL, i, i2, str)) {
            switch (i) {
                case 4:
                    if (i2 == -7 || i2 == -10) {
                        h.g(this.mController.ylL, R.string.djv, R.string.d1b);
                        break;
                    }
                default:
                    i3 = 0;
                    break;
            }
        }
        if (i3 != 0) {
            AppMethodBeat.o(127195);
        } else {
            AppMethodBeat.o(127195);
        }
    }

    static /* synthetic */ void e(SettingsAliasUI settingsAliasUI) {
        AppMethodBeat.i(127196);
        if (settingsAliasUI.dFl.equals(r.Yz())) {
            h.g(settingsAliasUI.mController.ylL, R.string.d1_, R.string.d18);
            AppMethodBeat.o(127196);
        } else if (bo.amX(settingsAliasUI.dFl)) {
            Context context = settingsAliasUI.mController.ylL;
            settingsAliasUI.getString(R.string.d18);
            settingsAliasUI.ehJ = h.b(context, settingsAliasUI.getString(R.string.d17), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(127188);
                    if (SettingsAliasUI.this.qmT != null) {
                        g.Rg().c(SettingsAliasUI.this.qmT);
                    }
                    AppMethodBeat.o(127188);
                }
            });
            if (settingsAliasUI.qmT != null) {
                g.Rg().c(settingsAliasUI.qmT);
            }
            settingsAliasUI.qmT = new d(settingsAliasUI.dFl);
            g.Rg().a(settingsAliasUI.qmT, 0);
            AppMethodBeat.o(127196);
        } else {
            h.g(settingsAliasUI.mController.ylL, R.string.f0k, R.string.djx);
            AppMethodBeat.o(127196);
        }
    }
}
