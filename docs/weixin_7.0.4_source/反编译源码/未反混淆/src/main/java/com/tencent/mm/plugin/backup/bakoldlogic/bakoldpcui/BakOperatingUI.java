package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public class BakOperatingUI extends MMWizardActivity implements d {
    private ak handler = new ak(Looper.getMainLooper());
    private TextView jAA = null;
    private TextView jAB = null;
    private boolean jAC = false;
    private int jAD = 0;
    private boolean jAE = false;
    private int jAt = -1;
    private boolean jAx = false;
    private ProgressBar jAy = null;
    private TextView jAz = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakOperatingUI() {
        AppMethodBeat.i(17945);
        AppMethodBeat.o(17945);
    }

    static /* synthetic */ void e(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17962);
        bakOperatingUI.aUV();
        AppMethodBeat.o(17962);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(17946);
        ab.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            ab.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", Integer.valueOf(this.jAt));
            AppMethodBeat.o(17946);
            return;
        }
        a.aUB().aUC().a((d) this);
        a.aUB().aUC().fr(true);
        this.jAC = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.jAC) {
            int i = a.aUB().aUC().jzL;
            if (2 == i || a.aUB().aUC().jzK == 2) {
                this.jAt = 1;
                this.jAD = a.aUB().aUC().aUM();
            } else if (4 == i) {
                this.jAt = 6;
                this.jAD = a.aUB().aUC().aUM();
            } else if (5 == i) {
                this.jAt = 6;
                this.jAx = true;
                com.tencent.mm.plugin.backup.a.gkE.BV();
                a.aUB().aUC().aSL();
            }
        } else {
            this.jAt = getIntent().getIntExtra("cmd", 6);
        }
        if (this.jAt == 6 && a.aUB().aUC().jzE.jzV) {
            this.jAx = true;
            com.tencent.mm.plugin.backup.a.gkE.BV();
            a.aUB().aUC().aSL();
        }
        ab.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", Integer.valueOf(this.jAt), Boolean.valueOf(this.jAC), Integer.valueOf(a.aUB().aUC().jzL), Integer.valueOf(this.jAD));
        initView();
        if (a.aUB().aUC().jzK == 2) {
            this.jAA.setText(getString(R.string.a2p));
            this.jAz.setText(getString(R.string.a2e) + this.jAD + "%");
            this.jAB.setText(getString(R.string.a2o));
            AppMethodBeat.o(17946);
        } else if (6 != this.jAt) {
            if (1 == this.jAt) {
                this.jAA.setText(getString(R.string.a2j));
                this.jAz.setText(getString(R.string.a29) + this.jAD + "%");
                this.jAB.setText(getString(R.string.a2o));
            }
            AppMethodBeat.o(17946);
        } else if (this.jAx) {
            this.jAA.setText(getString(R.string.a2n));
            this.jAB.setText(getString(R.string.a2m));
            this.jAz.setText(getString(R.string.a2d) + this.jAD + "%");
            AppMethodBeat.o(17946);
        } else {
            this.jAA.setText(getString(R.string.a2q));
            this.jAz.setText(getString(R.string.a2f) + this.jAD + "%");
            this.jAB.setText(getString(R.string.a2o));
            AppMethodBeat.o(17946);
        }
    }

    public final void initView() {
        AppMethodBeat.i(17947);
        setMMTitle((int) R.string.a2v);
        if (!this.jAx) {
            if (6 == this.jAt) {
                addTextOptionMenu(0, getString(R.string.a2g), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(17933);
                        if (BakOperatingUI.this.jAx) {
                            AppMethodBeat.o(17933);
                        } else {
                            BakOperatingUI.this.jAE = true;
                            BakOperatingUI.c(BakOperatingUI.this);
                            AppMethodBeat.o(17933);
                        }
                        return true;
                    }
                });
            } else if (1 == this.jAt) {
                addTextOptionMenu(0, getString(R.string.a1z), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(17936);
                        if (BakOperatingUI.this.jAx) {
                            AppMethodBeat.o(17936);
                        } else {
                            BakOperatingUI.this.jAE = true;
                            BakOperatingUI.d(BakOperatingUI.this);
                            AppMethodBeat.o(17936);
                        }
                        return true;
                    }
                });
            } else {
                ab.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(17937);
                if (BakOperatingUI.this.jAx) {
                    BakOperatingUI.e(BakOperatingUI.this);
                    AppMethodBeat.o(17937);
                    return false;
                }
                BakOperatingUI.this.jAE = true;
                BakOperatingUI.f(BakOperatingUI.this);
                AppMethodBeat.o(17937);
                return true;
            }
        });
        this.jAy = (ProgressBar) findViewById(R.id.a26);
        this.jAy.setProgress(this.jAD);
        this.jAA = (TextView) findViewById(R.id.a28);
        this.jAB = (TextView) findViewById(R.id.a29);
        this.jAz = (TextView) findViewById(R.id.a27);
        AppMethodBeat.o(17947);
    }

    public final int getLayoutId() {
        return R.layout.fl;
    }

    private void aUV() {
        AppMethodBeat.i(17948);
        a.aUB().aUC().pause();
        c a = h.a((Context) this, (int) R.string.a2h, 0, (int) R.string.up, (int) R.string.s2, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(17938);
                e aUC = a.aUB().aUC();
                aUC.jzD.cancel();
                aUC.jzE.cancel();
                if (aUC.jzH == 1 || aUC.jzL == 2) {
                    e.rF(4);
                } else if (aUC.jzH == 6 || aUC.jzL == 4 || aUC.jzL == 6) {
                    e.rF(7);
                }
                a.aUB().aUC().jzK = -1;
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c aUD = a.aUB().aUD();
                aUD.jzp++;
                BakOperatingUI.this.jAE = true;
                BakOperatingUI.g(BakOperatingUI.this);
                AppMethodBeat.o(17938);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(17939);
                e aUC = a.aUB().aUC();
                if (aUC.jzH == 1) {
                    aUC.jzD.resume();
                    AppMethodBeat.o(17939);
                } else if (aUC.jzH == 6) {
                    aUC.jzE.resume();
                    AppMethodBeat.o(17939);
                } else {
                    ab.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", Integer.valueOf(aUC.jzH));
                    AppMethodBeat.o(17939);
                }
            }
        });
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
        AppMethodBeat.o(17948);
    }

    public void onDestroy() {
        AppMethodBeat.i(17949);
        super.onDestroy();
        a.aUB().aUC().a(null);
        a.aUB().aUC().fr(false);
        ab.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.o(17949);
    }

    public void onStart() {
        AppMethodBeat.i(17950);
        super.onStart();
        AppMethodBeat.o(17950);
    }

    public void onResume() {
        AppMethodBeat.i(17951);
        a.aUB().aUC().fr(true);
        a.aUB().aUC().a((d) this);
        ab.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", Integer.valueOf(this.jAt));
        super.onResume();
        AppMethodBeat.o(17951);
    }

    public void onPause() {
        AppMethodBeat.i(17952);
        a.aUB().aUC().fr(false);
        super.onPause();
        ab.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.o(17952);
    }

    public final synchronized void rI(final int i) {
        AppMethodBeat.i(17953);
        ab.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", Integer.valueOf(i), Boolean.valueOf(this.jAE));
        if (this.jAE) {
            AppMethodBeat.o(17953);
        } else {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17940);
                    if (BakOperatingUI.this.jAy != null) {
                        BakOperatingUI.this.jAy.setProgress(i);
                    }
                    if (BakOperatingUI.this.jAz != null) {
                        int i = R.string.a29;
                        int i2 = R.string.a2j;
                        if (6 == BakOperatingUI.this.jAt) {
                            i = R.string.a2f;
                            i2 = R.string.a2q;
                        }
                        BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(i) + i + "%");
                        BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(i2));
                    }
                    AppMethodBeat.o(17940);
                }
            });
            AppMethodBeat.o(17953);
        }
    }

    public final synchronized void rJ(final int i) {
        AppMethodBeat.i(17954);
        if (this.jAE) {
            AppMethodBeat.o(17954);
        } else {
            ab.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", Integer.valueOf(i));
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17941);
                    if (BakOperatingUI.this.jAy != null) {
                        BakOperatingUI.this.jAy.setProgress(i);
                    }
                    if (!(BakOperatingUI.this.jAz == null || BakOperatingUI.this.jAA == null)) {
                        BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(R.string.a2d) + i + "%");
                        BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(R.string.a2n));
                    }
                    AppMethodBeat.o(17941);
                }
            });
            AppMethodBeat.o(17954);
        }
    }

    public final synchronized void aUP() {
        AppMethodBeat.i(17955);
        ab.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.jAt));
        if (this.jAE) {
            AppMethodBeat.o(17955);
        } else {
            if (6 == this.jAt || 5 == a.aUB().aUC().jzL) {
                this.jAt = 6;
                this.jAx = true;
                com.tencent.mm.plugin.backup.a.gkE.BV();
                a.aUB().aUC().aSL();
            } else {
                ab.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.jAt));
            }
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17943);
                    if (6 == BakOperatingUI.this.jAt) {
                        BakOperatingUI.this.handler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(17942);
                                BakOperatingUI.this.showOptionMenu(false);
                                if (BakOperatingUI.this.jAy != null) {
                                    BakOperatingUI.this.jAy.setProgress(0);
                                }
                                if (BakOperatingUI.this.jAA != null) {
                                    BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(R.string.a2n));
                                }
                                if (BakOperatingUI.this.jAB != null) {
                                    BakOperatingUI.this.jAB.setText(BakOperatingUI.this.getString(R.string.a2m));
                                }
                                if (BakOperatingUI.this.jAz != null) {
                                    BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(R.string.a2d) + "0%");
                                }
                                AppMethodBeat.o(17942);
                            }
                        });
                        AppMethodBeat.o(17943);
                        return;
                    }
                    if (1 == BakOperatingUI.this.jAt) {
                        Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                        intent.putExtra("cmd", BakOperatingUI.this.jAt);
                        MMWizardActivity.J(BakOperatingUI.this, intent);
                    }
                    AppMethodBeat.o(17943);
                }
            });
            AppMethodBeat.o(17955);
        }
    }

    public final synchronized void aSt() {
        AppMethodBeat.i(17956);
        if (this.jAE) {
            AppMethodBeat.o(17956);
        } else {
            this.jAx = false;
            ab.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", Integer.valueOf(this.jAt));
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17944);
                    Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                    intent.putExtra("cmd", BakOperatingUI.this.jAt);
                    MMWizardActivity.J(BakOperatingUI.this, intent);
                    AppMethodBeat.o(17944);
                }
            });
            AppMethodBeat.o(17956);
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(17957);
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
                AppMethodBeat.o(17957);
            } else if (this.jAx) {
                aUV();
                a.aUB().aUC().pause();
                AppMethodBeat.o(17957);
            } else {
                ab.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", Integer.valueOf(this.jAt));
                this.jAE = true;
                a.aUB().aUC().fr(false);
                Ni(1);
                AppMethodBeat.o(17957);
            }
        }
        return z;
    }

    public final void onError(final int i) {
        AppMethodBeat.i(17958);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17934);
                ab.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", Integer.valueOf(i));
                if (i == 15) {
                    BakOperatingUI.n(BakOperatingUI.this);
                    AppMethodBeat.o(17934);
                    return;
                }
                MMWizardActivity.J(BakOperatingUI.this, new Intent(BakOperatingUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(17934);
            }
        });
        AppMethodBeat.o(17958);
    }

    public final void aUQ() {
        AppMethodBeat.i(17959);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17935);
                ab.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
                BakOperatingUI.o(BakOperatingUI.this);
                AppMethodBeat.o(17935);
            }
        });
        AppMethodBeat.o(17959);
    }

    static /* synthetic */ void c(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17960);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17960);
    }

    static /* synthetic */ void d(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17961);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17961);
    }

    static /* synthetic */ void f(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17963);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17963);
    }

    static /* synthetic */ void g(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17964);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17964);
    }

    static /* synthetic */ void n(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17965);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17965);
    }

    static /* synthetic */ void o(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(17966);
        bakOperatingUI.Ni(1);
        AppMethodBeat.o(17966);
    }
}
