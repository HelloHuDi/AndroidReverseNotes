package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;

public class VerifyQQUI extends MMWizardActivity implements f {
    private String cCU;
    private String cCW;
    private byte[] frt = null;
    private SecurityImage gue = null;
    private long gut = 0;
    private String guu = "";
    private String guv = "";
    private String guw;
    private b gux = new b(this);
    private p tipDialog = null;

    static class b implements OnMenuItemClickListener {
        WeakReference<VerifyQQUI> bSI;

        protected b(VerifyQQUI verifyQQUI) {
            AppMethodBeat.i(13784);
            this.bSI = new WeakReference(verifyQQUI);
            AppMethodBeat.o(13784);
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(13785);
            VerifyQQUI verifyQQUI = (VerifyQQUI) this.bSI.get();
            if (verifyQQUI == null || verifyQQUI.isFinishing()) {
                AppMethodBeat.o(13785);
            } else {
                EditText editText = (EditText) verifyQQUI.findViewById(R.id.a6g);
                String trim = ((EditText) verifyQQUI.findViewById(R.id.a6f)).getText().toString().trim();
                verifyQQUI.guu = editText.getText().toString().trim();
                try {
                    verifyQQUI.gut = bo.getLong(trim, 0);
                    if (verifyQQUI.gut < 10000) {
                        h.g(verifyQQUI.mController.ylL, R.string.a8q, R.string.a8o);
                        AppMethodBeat.o(13785);
                    } else if (verifyQQUI.guu.equals("")) {
                        h.g(verifyQQUI.mController.ylL, R.string.a8p, R.string.a8o);
                        AppMethodBeat.o(13785);
                    } else {
                        verifyQQUI.aqX();
                        final m bVar = new com.tencent.mm.plugin.account.bind.a.b(verifyQQUI.gut, verifyQQUI.guu, "", "", "", verifyQQUI.cCU, verifyQQUI.cCW, false);
                        g.Rg().a(bVar, 0);
                        Context context = verifyQQUI.mController.ylL;
                        verifyQQUI.getString(R.string.a8s);
                        verifyQQUI.tipDialog = h.b(context, verifyQQUI.getString(R.string.a8j), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(13783);
                                g.Rg().c(bVar);
                                AppMethodBeat.o(13783);
                            }
                        });
                        AppMethodBeat.o(13785);
                    }
                } catch (Exception e) {
                    h.g(verifyQQUI.mController.ylL, R.string.a8q, R.string.a8o);
                    AppMethodBeat.o(13785);
                }
            }
            return true;
        }
    }

    class a extends com.tencent.mm.ui.applet.SecurityImage.b {
        a() {
        }

        public final void apw() {
            AppMethodBeat.i(13782);
            g.Rg().a(new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.this.gut, VerifyQQUI.this.guu, VerifyQQUI.this.guv, "", VerifyQQUI.this.guw, 2, true), 0);
            AppMethodBeat.o(13782);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VerifyQQUI() {
        AppMethodBeat.i(13786);
        AppMethodBeat.o(13786);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13787);
        super.onCreate(bundle);
        g.Rg().a(144, (f) this);
        AppMethodBeat.o(13787);
    }

    public void onDestroy() {
        AppMethodBeat.i(13788);
        super.onDestroy();
        g.Rg().b(144, (f) this);
        AppMethodBeat.o(13788);
    }

    public void onResume() {
        AppMethodBeat.i(13789);
        super.onResume();
        initView();
        AppMethodBeat.o(13789);
    }

    public final int getLayoutId() {
        return R.layout.go;
    }

    public final boolean apx() {
        AppMethodBeat.i(13790);
        aqX();
        finish();
        AppMethodBeat.o(13790);
        return true;
    }

    public final void initView() {
        AppMethodBeat.i(13791);
        hy hyVar = new hy();
        hyVar.cCS.context = this;
        com.tencent.mm.sdk.b.a.xxA.m(hyVar);
        this.cCU = hyVar.cCT.cCU;
        hz hzVar = new hz();
        com.tencent.mm.sdk.b.a.xxA.m(hzVar);
        this.cCW = hzVar.cCV.cCW;
        setMMTitle((int) R.string.a8w);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(13777);
                VerifyQQUI.this.aqX();
                VerifyQQUI.a(VerifyQQUI.this);
                AppMethodBeat.o(13777);
                return true;
            }
        });
        findViewById(R.id.a6f);
        findViewById(R.id.a6g);
        addTextOptionMenu(0, getString(R.string.qt), this.gux);
        AppMethodBeat.o(13791);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        byte[] a;
        AppMethodBeat.i(13792);
        ab.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.plugin.account.bind.a.b bVar = (com.tencent.mm.plugin.account.bind.a.b) mVar;
        byte[] fs = g.RN().QR().fs(bVar.fPN);
        ab.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", Integer.valueOf(bo.l(fs, new byte[0]).length), Long.valueOf(bVar.fPN));
        if (bo.cb(fs)) {
            a = aa.a(((jr) bVar.ehh.fsH.fsP).vEF);
        } else {
            a = fs;
        }
        this.frt = a;
        this.guv = ((jr) ((com.tencent.mm.plugin.account.bind.a.b) mVar).ehh.fsH.fsP).vLX;
        if (this.frt != null) {
            ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + com.tencent.mm.compatible.util.g.Mq());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.account.a.a.gkF.BS();
            h.a(this.mController.ylL, (int) R.string.a8r, (int) R.string.a8s, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(13778);
                    VerifyQQUI.b(VerifyQQUI.this);
                    AppMethodBeat.o(13778);
                }
            });
            AppMethodBeat.o(13792);
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.h.a jY;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + com.tencent.mm.compatible.util.g.Mq());
                    if (!g.RK()) {
                        obj = 1;
                        break;
                    }
                    if (this.gue == null) {
                        this.gue = com.tencent.mm.ui.applet.SecurityImage.a.a(this.mController.ylL, 0, this.frt, this.guv, this.guw, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(13780);
                                final m bVar = new com.tencent.mm.plugin.account.bind.a.b(VerifyQQUI.this.gut, VerifyQQUI.this.guu, VerifyQQUI.this.gue.getSecImgSid(), VerifyQQUI.this.gue.getSecImgCode(), VerifyQQUI.this.gue.getSecImgEncryptKey(), VerifyQQUI.this.cCU, VerifyQQUI.this.cCW, true);
                                g.Rg().a(bVar, 0);
                                VerifyQQUI verifyQQUI = VerifyQQUI.this;
                                Context context = VerifyQQUI.this.mController.ylL;
                                VerifyQQUI.this.getString(R.string.a8s);
                                verifyQQUI.tipDialog = h.b(context, VerifyQQUI.this.getString(R.string.a8j), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(13779);
                                        g.Rg().c(bVar);
                                        AppMethodBeat.o(13779);
                                    }
                                });
                                AppMethodBeat.o(13780);
                            }
                        }, null, new OnDismissListener() {
                            public final void onDismiss(DialogInterface dialogInterface) {
                                AppMethodBeat.i(13781);
                                VerifyQQUI.this.gue = null;
                                AppMethodBeat.o(13781);
                            }
                        }, new a());
                    } else {
                        ab.d("MicroMsg.VerifyQQUI", "imgSid:" + this.guv + " img len" + this.frt.length + " " + com.tencent.mm.compatible.util.g.Mq());
                        this.gue.b(0, this.frt, this.guv, this.guw);
                    }
                    obj = 1;
                    break;
                case -72:
                    h.g(this.mController.ylL, R.string.a8n, R.string.tz);
                    obj = 1;
                    break;
                case -34:
                    h.g(this.mController.ylL, R.string.a8m, R.string.tz);
                    obj = 1;
                    break;
                case -12:
                    h.g(this.mController.ylL, R.string.a8k, R.string.a8o);
                    obj = 1;
                    break;
                case -5:
                    h.g(this.mController.ylL, R.string.a8l, R.string.tz);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY == null) {
                        h.g(this.mController.ylL, R.string.a8t, R.string.a8o);
                        obj = 1;
                        break;
                    }
                    jY.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj != null) {
            AppMethodBeat.o(13792);
            return;
        }
        Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(13792);
    }

    static /* synthetic */ void a(VerifyQQUI verifyQQUI) {
        AppMethodBeat.i(13793);
        verifyQQUI.Ni(1);
        AppMethodBeat.o(13793);
    }

    static /* synthetic */ void b(VerifyQQUI verifyQQUI) {
        AppMethodBeat.i(13794);
        verifyQQUI.Ni(1);
        AppMethodBeat.o(13794);
    }
}
