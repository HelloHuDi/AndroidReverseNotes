package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.backup.C42757a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e.C11116d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C38643c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI */
public class BakOperatingUI extends MMWizardActivity implements C11116d {
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private TextView jAA = null;
    private TextView jAB = null;
    private boolean jAC = false;
    private int jAD = 0;
    private boolean jAE = false;
    private int jAt = -1;
    private boolean jAx = false;
    private ProgressBar jAy = null;
    private TextView jAz = null;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$10 */
    class C1111810 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$10$1 */
        class C111191 implements Runnable {
            C111191() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17942);
                BakOperatingUI.this.showOptionMenu(false);
                if (BakOperatingUI.this.jAy != null) {
                    BakOperatingUI.this.jAy.setProgress(0);
                }
                if (BakOperatingUI.this.jAA != null) {
                    BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(C25738R.string.a2n));
                }
                if (BakOperatingUI.this.jAB != null) {
                    BakOperatingUI.this.jAB.setText(BakOperatingUI.this.getString(C25738R.string.a2m));
                }
                if (BakOperatingUI.this.jAz != null) {
                    BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(C25738R.string.a2d) + "0%");
                }
                AppMethodBeat.m2505o(17942);
            }
        }

        C1111810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17943);
            if (6 == BakOperatingUI.this.jAt) {
                BakOperatingUI.this.handler.post(new C111191());
                AppMethodBeat.m2505o(17943);
                return;
            }
            if (1 == BakOperatingUI.this.jAt) {
                Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                intent.putExtra("cmd", BakOperatingUI.this.jAt);
                MMWizardActivity.m23791J(BakOperatingUI.this, intent);
            }
            AppMethodBeat.m2505o(17943);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$4 */
    class C199654 implements OnMenuItemClickListener {
        C199654() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17936);
            if (BakOperatingUI.this.jAx) {
                AppMethodBeat.m2505o(17936);
            } else {
                BakOperatingUI.this.jAE = true;
                BakOperatingUI.m65538d(BakOperatingUI.this);
                AppMethodBeat.m2505o(17936);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$6 */
    class C199666 implements OnClickListener {
        C199666() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(17938);
            C27460e aUC = C41257a.aUB().aUC();
            aUC.jzD.cancel();
            aUC.jzE.cancel();
            if (aUC.jzH == 1 || aUC.jzL == 2) {
                C27460e.m43573rF(4);
            } else if (aUC.jzH == 6 || aUC.jzL == 4 || aUC.jzL == 6) {
                C27460e.m43573rF(7);
            }
            C41257a.aUB().aUC().jzK = -1;
            C38643c aUD = C41257a.aUB().aUD();
            aUD.jzp++;
            BakOperatingUI.this.jAE = true;
            BakOperatingUI.m65541g(BakOperatingUI.this);
            AppMethodBeat.m2505o(17938);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$5 */
    class C274695 implements OnMenuItemClickListener {
        C274695() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17937);
            if (BakOperatingUI.this.jAx) {
                BakOperatingUI.m65539e(BakOperatingUI.this);
                AppMethodBeat.m2505o(17937);
                return false;
            }
            BakOperatingUI.this.jAE = true;
            BakOperatingUI.m65540f(BakOperatingUI.this);
            AppMethodBeat.m2505o(17937);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$7 */
    class C274707 implements OnClickListener {
        C274707() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(17939);
            C27460e aUC = C41257a.aUB().aUC();
            if (aUC.jzH == 1) {
                aUC.jzD.resume();
                AppMethodBeat.m2505o(17939);
            } else if (aUC.jzH == 6) {
                aUC.jzE.resume();
                AppMethodBeat.m2505o(17939);
            } else {
                C4990ab.m7413e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", Integer.valueOf(aUC.jzH));
                AppMethodBeat.m2505o(17939);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$1 */
    class C386451 implements OnMenuItemClickListener {
        C386451() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(17933);
            if (BakOperatingUI.this.jAx) {
                AppMethodBeat.m2505o(17933);
            } else {
                BakOperatingUI.this.jAE = true;
                BakOperatingUI.m65537c(BakOperatingUI.this);
                AppMethodBeat.m2505o(17933);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$3 */
    class C386463 implements Runnable {
        C386463() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17935);
            C4990ab.m7410d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
            BakOperatingUI.m65549o(BakOperatingUI.this);
            AppMethodBeat.m2505o(17935);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI$11 */
    class C3864811 implements Runnable {
        C3864811() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17944);
            Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
            intent.putExtra("cmd", BakOperatingUI.this.jAt);
            MMWizardActivity.m23791J(BakOperatingUI.this, intent);
            AppMethodBeat.m2505o(17944);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BakOperatingUI() {
        AppMethodBeat.m2504i(17945);
        AppMethodBeat.m2505o(17945);
    }

    /* renamed from: e */
    static /* synthetic */ void m65539e(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17962);
        bakOperatingUI.aUV();
        AppMethodBeat.m2505o(17962);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(17946);
        C4990ab.m7416i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            C4990ab.m7417i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", Integer.valueOf(this.jAt));
            AppMethodBeat.m2505o(17946);
            return;
        }
        C41257a.aUB().aUC().mo45238a((C11116d) this);
        C41257a.aUB().aUC().mo45246fr(true);
        this.jAC = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.jAC) {
            int i = C41257a.aUB().aUC().jzL;
            if (2 == i || C41257a.aUB().aUC().jzK == 2) {
                this.jAt = 1;
                this.jAD = C41257a.aUB().aUC().aUM();
            } else if (4 == i) {
                this.jAt = 6;
                this.jAD = C41257a.aUB().aUC().aUM();
            } else if (5 == i) {
                this.jAt = 6;
                this.jAx = true;
                C42757a.gkE.mo38889BV();
                C41257a.aUB().aUC().aSL();
            }
        } else {
            this.jAt = getIntent().getIntExtra("cmd", 6);
        }
        if (this.jAt == 6 && C41257a.aUB().aUC().jzE.jzV) {
            this.jAx = true;
            C42757a.gkE.mo38889BV();
            C41257a.aUB().aUC().aSL();
        }
        C4990ab.m7417i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", Integer.valueOf(this.jAt), Boolean.valueOf(this.jAC), Integer.valueOf(C41257a.aUB().aUC().jzL), Integer.valueOf(this.jAD));
        initView();
        if (C41257a.aUB().aUC().jzK == 2) {
            this.jAA.setText(getString(C25738R.string.a2p));
            this.jAz.setText(getString(C25738R.string.a2e) + this.jAD + "%");
            this.jAB.setText(getString(C25738R.string.a2o));
            AppMethodBeat.m2505o(17946);
        } else if (6 != this.jAt) {
            if (1 == this.jAt) {
                this.jAA.setText(getString(C25738R.string.a2j));
                this.jAz.setText(getString(C25738R.string.a29) + this.jAD + "%");
                this.jAB.setText(getString(C25738R.string.a2o));
            }
            AppMethodBeat.m2505o(17946);
        } else if (this.jAx) {
            this.jAA.setText(getString(C25738R.string.a2n));
            this.jAB.setText(getString(C25738R.string.a2m));
            this.jAz.setText(getString(C25738R.string.a2d) + this.jAD + "%");
            AppMethodBeat.m2505o(17946);
        } else {
            this.jAA.setText(getString(C25738R.string.a2q));
            this.jAz.setText(getString(C25738R.string.a2f) + this.jAD + "%");
            this.jAB.setText(getString(C25738R.string.a2o));
            AppMethodBeat.m2505o(17946);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(17947);
        setMMTitle((int) C25738R.string.a2v);
        if (!this.jAx) {
            if (6 == this.jAt) {
                addTextOptionMenu(0, getString(C25738R.string.a2g), new C386451());
            } else if (1 == this.jAt) {
                addTextOptionMenu(0, getString(C25738R.string.a1z), new C199654());
            } else {
                C4990ab.m7412e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new C274695());
        this.jAy = (ProgressBar) findViewById(2131821624);
        this.jAy.setProgress(this.jAD);
        this.jAA = (TextView) findViewById(2131821626);
        this.jAB = (TextView) findViewById(2131821627);
        this.jAz = (TextView) findViewById(2131821625);
        AppMethodBeat.m2505o(17947);
    }

    public final int getLayoutId() {
        return 2130968809;
    }

    private void aUV() {
        AppMethodBeat.m2504i(17948);
        C41257a.aUB().aUC().pause();
        C5653c a = C30379h.m48428a((Context) this, (int) C25738R.string.a2h, 0, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new C199666(), new C274707());
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
        AppMethodBeat.m2505o(17948);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(17949);
        super.onDestroy();
        C41257a.aUB().aUC().mo45238a(null);
        C41257a.aUB().aUC().mo45246fr(false);
        C4990ab.m7417i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.m2505o(17949);
    }

    public void onStart() {
        AppMethodBeat.m2504i(17950);
        super.onStart();
        AppMethodBeat.m2505o(17950);
    }

    public void onResume() {
        AppMethodBeat.m2504i(17951);
        C41257a.aUB().aUC().mo45246fr(true);
        C41257a.aUB().aUC().mo45238a((C11116d) this);
        C4990ab.m7417i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", Integer.valueOf(this.jAt));
        super.onResume();
        AppMethodBeat.m2505o(17951);
    }

    public void onPause() {
        AppMethodBeat.m2504i(17952);
        C41257a.aUB().aUC().mo45246fr(false);
        super.onPause();
        C4990ab.m7417i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", Integer.valueOf(this.jAt));
        AppMethodBeat.m2505o(17952);
    }

    /* renamed from: rI */
    public final synchronized void mo22819rI(final int i) {
        AppMethodBeat.m2504i(17953);
        C4990ab.m7411d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", Integer.valueOf(i), Boolean.valueOf(this.jAE));
        if (this.jAE) {
            AppMethodBeat.m2505o(17953);
        } else {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17940);
                    if (BakOperatingUI.this.jAy != null) {
                        BakOperatingUI.this.jAy.setProgress(i);
                    }
                    if (BakOperatingUI.this.jAz != null) {
                        int i = C25738R.string.a29;
                        int i2 = C25738R.string.a2j;
                        if (6 == BakOperatingUI.this.jAt) {
                            i = C25738R.string.a2f;
                            i2 = C25738R.string.a2q;
                        }
                        BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(i) + i + "%");
                        BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(i2));
                    }
                    AppMethodBeat.m2505o(17940);
                }
            });
            AppMethodBeat.m2505o(17953);
        }
    }

    /* renamed from: rJ */
    public final synchronized void mo22820rJ(final int i) {
        AppMethodBeat.m2504i(17954);
        if (this.jAE) {
            AppMethodBeat.m2505o(17954);
        } else {
            C4990ab.m7411d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", Integer.valueOf(i));
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17941);
                    if (BakOperatingUI.this.jAy != null) {
                        BakOperatingUI.this.jAy.setProgress(i);
                    }
                    if (!(BakOperatingUI.this.jAz == null || BakOperatingUI.this.jAA == null)) {
                        BakOperatingUI.this.jAz.setText(BakOperatingUI.this.getString(C25738R.string.a2d) + i + "%");
                        BakOperatingUI.this.jAA.setText(BakOperatingUI.this.getString(C25738R.string.a2n));
                    }
                    AppMethodBeat.m2505o(17941);
                }
            });
            AppMethodBeat.m2505o(17954);
        }
    }

    public final synchronized void aUP() {
        AppMethodBeat.m2504i(17955);
        C4990ab.m7411d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.jAt));
        if (this.jAE) {
            AppMethodBeat.m2505o(17955);
        } else {
            if (6 == this.jAt || 5 == C41257a.aUB().aUC().jzL) {
                this.jAt = 6;
                this.jAx = true;
                C42757a.gkE.mo38889BV();
                C41257a.aUB().aUC().aSL();
            } else {
                C4990ab.m7413e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.jAt));
            }
            this.handler.post(new C1111810());
            AppMethodBeat.m2505o(17955);
        }
    }

    public final synchronized void aSt() {
        AppMethodBeat.m2504i(17956);
        if (this.jAE) {
            AppMethodBeat.m2505o(17956);
        } else {
            this.jAx = false;
            C4990ab.m7411d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", Integer.valueOf(this.jAt));
            this.handler.post(new C3864811());
            AppMethodBeat.m2505o(17956);
        }
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(17957);
            if (i != 4) {
                z = super.onKeyDown(i, keyEvent);
                AppMethodBeat.m2505o(17957);
            } else if (this.jAx) {
                aUV();
                C41257a.aUB().aUC().pause();
                AppMethodBeat.m2505o(17957);
            } else {
                C4990ab.m7411d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", Integer.valueOf(this.jAt));
                this.jAE = true;
                C41257a.aUB().aUC().mo45246fr(false);
                mo27541Ni(1);
                AppMethodBeat.m2505o(17957);
            }
        }
        return z;
    }

    public final void onError(final int i) {
        AppMethodBeat.m2504i(17958);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17934);
                C4990ab.m7417i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", Integer.valueOf(i));
                if (i == 15) {
                    BakOperatingUI.m65548n(BakOperatingUI.this);
                    AppMethodBeat.m2505o(17934);
                    return;
                }
                MMWizardActivity.m23791J(BakOperatingUI.this, new Intent(BakOperatingUI.this, BakConnErrorUI.class));
                AppMethodBeat.m2505o(17934);
            }
        });
        AppMethodBeat.m2505o(17958);
    }

    public final void aUQ() {
        AppMethodBeat.m2504i(17959);
        this.handler.post(new C386463());
        AppMethodBeat.m2505o(17959);
    }

    /* renamed from: c */
    static /* synthetic */ void m65537c(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17960);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17960);
    }

    /* renamed from: d */
    static /* synthetic */ void m65538d(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17961);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17961);
    }

    /* renamed from: f */
    static /* synthetic */ void m65540f(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17963);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17963);
    }

    /* renamed from: g */
    static /* synthetic */ void m65541g(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17964);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17964);
    }

    /* renamed from: n */
    static /* synthetic */ void m65548n(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17965);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17965);
    }

    /* renamed from: o */
    static /* synthetic */ void m65549o(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.m2504i(17966);
        bakOperatingUI.mo27541Ni(1);
        AppMethodBeat.m2505o(17966);
    }
}
