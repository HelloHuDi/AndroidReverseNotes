package com.tencent.p177mm.plugin.account.bind.p271ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18288hy;
import com.tencent.p177mm.p230g.p231a.C6494hz;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15494b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.account.bind.p1217a.C26547b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.protocal.protobuf.C35929jr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI */
public class VerifyQQUI extends MMWizardActivity implements C1202f {
    private String cCU;
    private String cCW;
    private byte[] frt = null;
    private SecurityImage gue = null;
    private long gut = 0;
    private String guu = "";
    private String guv = "";
    private String guw;
    private C9870b gux = new C9870b(this);
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$1 */
    class C19791 implements OnMenuItemClickListener {
        C19791() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13777);
            VerifyQQUI.this.aqX();
            VerifyQQUI.m42409a(VerifyQQUI.this);
            AppMethodBeat.m2505o(13777);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$b */
    static class C9870b implements OnMenuItemClickListener {
        WeakReference<VerifyQQUI> bSI;

        protected C9870b(VerifyQQUI verifyQQUI) {
            AppMethodBeat.m2504i(13784);
            this.bSI = new WeakReference(verifyQQUI);
            AppMethodBeat.m2505o(13784);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(13785);
            VerifyQQUI verifyQQUI = (VerifyQQUI) this.bSI.get();
            if (verifyQQUI == null || verifyQQUI.isFinishing()) {
                AppMethodBeat.m2505o(13785);
            } else {
                EditText editText = (EditText) verifyQQUI.findViewById(2131821783);
                String trim = ((EditText) verifyQQUI.findViewById(2131821782)).getText().toString().trim();
                verifyQQUI.guu = editText.getText().toString().trim();
                try {
                    verifyQQUI.gut = C5046bo.getLong(trim, 0);
                    if (verifyQQUI.gut < 10000) {
                        C30379h.m48467g(verifyQQUI.mController.ylL, C25738R.string.a8q, C25738R.string.a8o);
                        AppMethodBeat.m2505o(13785);
                    } else if (verifyQQUI.guu.equals("")) {
                        C30379h.m48467g(verifyQQUI.mController.ylL, C25738R.string.a8p, C25738R.string.a8o);
                        AppMethodBeat.m2505o(13785);
                    } else {
                        verifyQQUI.aqX();
                        final C1207m c26547b = new C26547b(verifyQQUI.gut, verifyQQUI.guu, "", "", "", verifyQQUI.cCU, verifyQQUI.cCW, false);
                        C1720g.m3540Rg().mo14541a(c26547b, 0);
                        Context context = verifyQQUI.mController.ylL;
                        verifyQQUI.getString(C25738R.string.a8s);
                        verifyQQUI.tipDialog = C30379h.m48458b(context, verifyQQUI.getString(C25738R.string.a8j), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(13783);
                                C1720g.m3540Rg().mo14547c(c26547b);
                                AppMethodBeat.m2505o(13783);
                            }
                        });
                        AppMethodBeat.m2505o(13785);
                    }
                } catch (Exception e) {
                    C30379h.m48467g(verifyQQUI.mController.ylL, C25738R.string.a8q, C25738R.string.a8o);
                    AppMethodBeat.m2505o(13785);
                }
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$a */
    class C26568a extends C15494b {
        C26568a() {
        }

        public final void apw() {
            AppMethodBeat.m2504i(13782);
            C1720g.m3540Rg().mo14541a(new C26547b(VerifyQQUI.this.gut, VerifyQQUI.this.guu, VerifyQQUI.this.guv, "", VerifyQQUI.this.guw, 2, true), 0);
            AppMethodBeat.m2505o(13782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$2 */
    class C265692 implements OnClickListener {
        C265692() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13778);
            VerifyQQUI.m42410b(VerifyQQUI.this);
            AppMethodBeat.m2505o(13778);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$3 */
    class C265703 implements OnClickListener {
        C265703() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(13780);
            final C1207m c26547b = new C26547b(VerifyQQUI.this.gut, VerifyQQUI.this.guu, VerifyQQUI.this.gue.getSecImgSid(), VerifyQQUI.this.gue.getSecImgCode(), VerifyQQUI.this.gue.getSecImgEncryptKey(), VerifyQQUI.this.cCU, VerifyQQUI.this.cCW, true);
            C1720g.m3540Rg().mo14541a(c26547b, 0);
            VerifyQQUI verifyQQUI = VerifyQQUI.this;
            Context context = VerifyQQUI.this.mController.ylL;
            VerifyQQUI.this.getString(C25738R.string.a8s);
            verifyQQUI.tipDialog = C30379h.m48458b(context, VerifyQQUI.this.getString(C25738R.string.a8j), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(13779);
                    C1720g.m3540Rg().mo14547c(c26547b);
                    AppMethodBeat.m2505o(13779);
                }
            });
            AppMethodBeat.m2505o(13780);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.bind.ui.VerifyQQUI$4 */
    class C265724 implements OnDismissListener {
        C265724() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(13781);
            VerifyQQUI.this.gue = null;
            AppMethodBeat.m2505o(13781);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VerifyQQUI() {
        AppMethodBeat.m2504i(13786);
        AppMethodBeat.m2505o(13786);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(13787);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a(144, (C1202f) this);
        AppMethodBeat.m2505o(13787);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(13788);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(144, (C1202f) this);
        AppMethodBeat.m2505o(13788);
    }

    public void onResume() {
        AppMethodBeat.m2504i(13789);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(13789);
    }

    public final int getLayoutId() {
        return 2130968849;
    }

    public final boolean apx() {
        AppMethodBeat.m2504i(13790);
        aqX();
        finish();
        AppMethodBeat.m2505o(13790);
        return true;
    }

    public final void initView() {
        AppMethodBeat.m2504i(13791);
        C18288hy c18288hy = new C18288hy();
        c18288hy.cCS.context = this;
        C4879a.xxA.mo10055m(c18288hy);
        this.cCU = c18288hy.cCT.cCU;
        C6494hz c6494hz = new C6494hz();
        C4879a.xxA.mo10055m(c6494hz);
        this.cCW = c6494hz.cCV.cCW;
        setMMTitle((int) C25738R.string.a8w);
        setBackBtn(new C19791());
        findViewById(2131821782);
        findViewById(2131821783);
        addTextOptionMenu(0, getString(C25738R.string.f9142qt), this.gux);
        AppMethodBeat.m2505o(13791);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        byte[] a;
        AppMethodBeat.m2504i(13792);
        C4990ab.m7416i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        C26547b c26547b = (C26547b) c1207m;
        byte[] fs = C1720g.m3534RN().mo5158QR().mo4505fs(c26547b.fPN);
        C4990ab.m7417i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", Integer.valueOf(C5046bo.m7575l(fs, new byte[0]).length), Long.valueOf(c26547b.fPN));
        if (C5046bo.m7540cb(fs)) {
            a = C1946aa.m4150a(((C35929jr) c26547b.ehh.fsH.fsP).vEF);
        } else {
            a = fs;
        }
        this.frt = a;
        this.guv = ((C35929jr) ((C26547b) c1207m).ehh.fsH.fsP).vLX;
        if (this.frt != null) {
            C4990ab.m7410d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + C1447g.m3075Mq());
        }
        if (i == 0 && i2 == 0) {
            C24679a.gkF.mo38844BS();
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.a8r, (int) C25738R.string.a8s, new C265692());
            AppMethodBeat.m2505o(13792);
            return;
        }
        Object obj;
        if (i == 4) {
            C42124a jY;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    C4990ab.m7410d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + C1447g.m3075Mq());
                    if (!C1720g.m3531RK()) {
                        obj = 1;
                        break;
                    }
                    if (this.gue == null) {
                        this.gue = C15492a.m23811a(this.mController.ylL, 0, this.frt, this.guv, this.guw, new C265703(), null, new C265724(), new C26568a());
                    } else {
                        C4990ab.m7410d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + C1447g.m3075Mq());
                        this.gue.mo27573b(0, this.frt, this.guv, this.guw);
                    }
                    obj = 1;
                    break;
                case -72:
                    C30379h.m48467g(this.mController.ylL, C25738R.string.a8n, C25738R.string.f9238tz);
                    obj = 1;
                    break;
                case -34:
                    C30379h.m48467g(this.mController.ylL, C25738R.string.a8m, C25738R.string.f9238tz);
                    obj = 1;
                    break;
                case -12:
                    C30379h.m48467g(this.mController.ylL, C25738R.string.a8k, C25738R.string.a8o);
                    obj = 1;
                    break;
                case -5:
                    C30379h.m48467g(this.mController.ylL, C25738R.string.a8l, C25738R.string.f9238tz);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    jY = C42124a.m74268jY(str);
                    if (jY == null) {
                        C30379h.m48467g(this.mController.ylL, C25738R.string.a8t, C25738R.string.a8o);
                        obj = 1;
                        break;
                    }
                    jY.mo67668a(this, null, null);
                    obj = 1;
                    break;
                default:
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj != null) {
            AppMethodBeat.m2505o(13792);
            return;
        }
        Toast.makeText(this, getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(13792);
    }

    /* renamed from: a */
    static /* synthetic */ void m42409a(VerifyQQUI verifyQQUI) {
        AppMethodBeat.m2504i(13793);
        verifyQQUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13793);
    }

    /* renamed from: b */
    static /* synthetic */ void m42410b(VerifyQQUI verifyQQUI) {
        AppMethodBeat.m2504i(13794);
        verifyQQUI.mo27541Ni(1);
        AppMethodBeat.m2505o(13794);
    }
}
