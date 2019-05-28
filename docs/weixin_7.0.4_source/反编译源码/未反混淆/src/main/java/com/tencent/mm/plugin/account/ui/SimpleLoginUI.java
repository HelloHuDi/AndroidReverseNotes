package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleLoginUI extends MMWizardActivity implements f {
    private TextWatcher arx = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(125596);
            SimpleLoginUI.a(SimpleLoginUI.this);
            AppMethodBeat.o(125596);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String cOG = "";
    private ProgressDialog ehJ = null;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(125607);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(125607);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(125608);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(125608);
                return false;
            }
            ab.i("MicroMsg.SimpleLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(125608);
            return true;
        }
    };
    private f gBT = new f();
    private String gBV;
    private String gBW;
    private MMClearEditText gCS;
    private MMClearEditText gCT;
    private MMFormInputView gCU;
    private MMFormInputView gCV;
    private Button gCW;
    private ResizeLayout gCa;
    private MMKeyboardUperView gDb;
    private SecurityImage gue = null;
    private String gzO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SimpleLoginUI() {
        AppMethodBeat.i(125617);
        AppMethodBeat.o(125617);
    }

    static /* synthetic */ void b(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(125630);
        simpleLoginUI.aqU();
        AppMethodBeat.o(125630);
    }

    static /* synthetic */ void f(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(125631);
        simpleLoginUI.aoZ();
        AppMethodBeat.o(125631);
    }

    public final int getLayoutId() {
        return R.layout.a_a;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125618);
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = getSharedPreferences("system_config_prefs", h.Mu());
        if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
            sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
        }
        setMMTitle((int) R.string.ru);
        if (a.gkF != null) {
            a.gkF.BV();
        }
        initView();
        g.Rg().a(701, (f) this);
        g.Rg().a(252, (f) this);
        if (!com.tencent.mm.pluginsdk.permission.b.ai(this)) {
            new Intent().addFlags(67108864);
            a.gkE.p(new Intent(), this);
        }
        AppMethodBeat.o(125618);
    }

    public void onResume() {
        AppMethodBeat.i(125619);
        com.tencent.mm.sdk.b.a.xxA.c(this.gAY);
        super.onResume();
        AppMethodBeat.o(125619);
    }

    public void onDestroy() {
        AppMethodBeat.i(125620);
        g.Rg().b(701, (f) this);
        g.Rg().b(252, (f) this);
        super.onDestroy();
        AppMethodBeat.o(125620);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(125621);
        super.onNewIntent(intent);
        this.gzO = intent.getStringExtra("auth_ticket");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.gzO = extras.getString("auth_ticket");
        }
        if (!bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(bo.nullAsNil(f.ara()));
            this.gCT.setText(bo.nullAsNil(f.arb()));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125609);
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(125609);
                }
            }, 500);
        }
        AppMethodBeat.o(125621);
    }

    public final void initView() {
        AppMethodBeat.i(125622);
        this.gCU = (MMFormInputView) findViewById(R.id.cq_);
        this.gCV = (MMFormInputView) findViewById(R.id.cqa);
        this.gCS = (MMClearEditText) this.gCU.getContentEditText();
        this.gCS.setFocusableInTouchMode(false);
        this.gCS.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(125610);
                SimpleLoginUI.this.gCS.setFocusableInTouchMode(true);
                boolean onTouch = SimpleLoginUI.this.gCS.getDefaultOnTouchListener().onTouch(view, motionEvent);
                AppMethodBeat.o(125610);
                return onTouch;
            }
        });
        this.gCT = (MMClearEditText) this.gCV.getContentEditText();
        this.gCT.setFocusableInTouchMode(false);
        this.gCT.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(125611);
                SimpleLoginUI.this.gCT.setFocusableInTouchMode(true);
                SimpleLoginUI.this.gCS.setFocusableInTouchMode(false);
                boolean onTouch = SimpleLoginUI.this.gCT.getDefaultOnTouchListener().onTouch(view, motionEvent);
                AppMethodBeat.o(125611);
                return onTouch;
            }
        });
        com.tencent.mm.ui.tools.b.c.d(this.gCT).PM(16).a(null);
        this.gCW = (Button) findViewById(R.id.cqc);
        this.gCW.setEnabled(false);
        this.gCS.addTextChangedListener(this.arx);
        this.gCT.addTextChangedListener(this.arx);
        this.gCT.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125612);
                if (i == 6 || i == 5) {
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(125612);
                    return true;
                }
                AppMethodBeat.o(125612);
                return false;
            }
        });
        this.gCT.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(125613);
                if (66 == i && keyEvent.getAction() == 0) {
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(125613);
                    return true;
                }
                AppMethodBeat.o(125613);
                return false;
            }
        });
        this.gCa = (ResizeLayout) findViewById(R.id.cq9);
        this.gDb = (MMKeyboardUperView) findViewById(R.id.jh);
        this.gCa.setOnSizeChanged(new ResizeLayout.a() {
            public final void aqZ() {
                AppMethodBeat.i(125615);
                SimpleLoginUI.this.gDb.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(125614);
                        SimpleLoginUI.this.gDb.fullScroll(130);
                        AppMethodBeat.o(125614);
                    }
                });
                AppMethodBeat.o(125615);
            }
        });
        this.gDb.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(125616);
                SimpleLoginUI.this.aqX();
                AppMethodBeat.o(125616);
                return false;
            }
        });
        findViewById(R.id.cqb).setVisibility(8);
        setMMTitle((int) R.string.cp0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125597);
                SimpleLoginUI.f(SimpleLoginUI.this);
                AppMethodBeat.o(125597);
                return true;
            }
        });
        this.gzO = getIntent().getStringExtra("auth_ticket");
        if (!bo.isNullOrNil(this.gzO)) {
            this.gCS.setText(bo.nullAsNil(f.ara()));
            this.gCT.setText(bo.nullAsNil(f.arb()));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125598);
                    SimpleLoginUI.b(SimpleLoginUI.this);
                    AppMethodBeat.o(125598);
                }
            }, 500);
        }
        if (com.tencent.mm.sdk.platformtools.g.xyf) {
            a.gkF.p(this);
        }
        this.gCW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125599);
                SimpleLoginUI.b(SimpleLoginUI.this);
                AppMethodBeat.o(125599);
            }
        });
        AppMethodBeat.o(125622);
    }

    private void aoZ() {
        AppMethodBeat.i(125623);
        boolean booleanExtra = getIntent().getBooleanExtra("key_auto_login_wizard_exit", false);
        if (!booleanExtra) {
            cancel();
        }
        Ni(1);
        if (booleanExtra) {
            exit(1);
        }
        AppMethodBeat.o(125623);
    }

    private void aqU() {
        AppMethodBeat.i(125624);
        this.gBT.account = this.gCS.getText().toString().trim();
        this.gBT.guf = this.gCT.getText().toString();
        if (this.gBT.account.equals("")) {
            com.tencent.mm.ui.base.h.g(this, R.string.f0w, R.string.cog);
            AppMethodBeat.o(125624);
        } else if (this.gBT.guf.equals("")) {
            com.tencent.mm.ui.base.h.g(this, R.string.f0s, R.string.cog);
            AppMethodBeat.o(125624);
        } else {
            aqX();
            final m qVar = new q(this.gBT.account, this.gBT.guf, this.gzO, 0);
            g.Rg().a(qVar, 0);
            getString(R.string.tz);
            this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125600);
                    g.Rg().c(qVar);
                    AppMethodBeat.o(125600);
                }
            });
            AppMethodBeat.o(125624);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125625);
        if (i == 4) {
            aoZ();
            AppMethodBeat.o(125625);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125625);
        return onKeyDown;
    }

    public void onPause() {
        AppMethodBeat.i(125626);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        super.onPause();
        com.tencent.mm.sdk.b.a.xxA.d(this.gAY);
        AppMethodBeat.o(125626);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        Object obj;
        f cVar;
        AppMethodBeat.i(125627);
        ab.i("MicroMsg.SimpleLoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        ab.d("MicroMsg.SimpleLoginUI", "Scene Type " + mVar.getType());
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        this.cOG = ((q) mVar).ajm();
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            if (i2 == -205) {
                this.gzO = ((q) mVar).agh();
                this.gBV = ((q) mVar).ajq();
                this.gBW = ((q) mVar).ajt();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                g.Rg().a(new bk(new bk.a() {
                    public final void a(e eVar) {
                        AppMethodBeat.i(125604);
                        if (eVar == null) {
                            AppMethodBeat.o(125604);
                            return;
                        }
                        com.tencent.mm.network.c adg = eVar.adg();
                        byte[] bArr = new byte[0];
                        byte[] bArr2 = new byte[0];
                        byte[] bArr3 = new byte[0];
                        g.RN();
                        adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                        AppMethodBeat.o(125604);
                    }
                }), 0);
                if (obj == null || (i == 0 && i2 == 0)) {
                    com.tencent.mm.kernel.a.unhold();
                    w.cm(this);
                    z.vx(this.gBT.account);
                    cVar = new com.tencent.mm.plugin.account.model.c(this.mController.ylL, new com.tencent.mm.plugin.account.model.c.a() {
                        /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
                        /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void aqC() {
                            LinkedList linkedList;
                            LinkedList linkedList2;
                            Iterator it;
                            LinkedList linkedList3 = null;
                            AppMethodBeat.i(125606);
                            t wVar = new com.tencent.mm.pluginsdk.model.app.w(SimpleLoginUI.this, new com.tencent.mm.pluginsdk.model.app.w.a() {
                                public final void arL() {
                                    AppMethodBeat.i(125605);
                                    SimpleLoginUI.this.finish();
                                    AppMethodBeat.o(125605);
                                }
                            });
                            SharedPreferences doB = ah.doB();
                            if (doB != null) {
                                String string = doB.getString("key_app_ids_registion_while_not_login", "");
                                if (bo.isNullOrNil(string)) {
                                    ab.i("MicroMsg.AppUtil", "no saved appids while not login");
                                } else {
                                    String[] split = string.split("\\|");
                                    if (split != null && split.length > 0) {
                                        linkedList = new LinkedList();
                                        int i = 1;
                                        for (String str : split) {
                                            if (!bo.isNullOrNil(str)) {
                                                linkedList.add(str);
                                                i++;
                                            }
                                            if (i > 5) {
                                                break;
                                            }
                                        }
                                        linkedList2 = linkedList;
                                        if (!(linkedList2 == null || linkedList2.isEmpty())) {
                                            linkedList = new LinkedList();
                                            it = linkedList2.iterator();
                                            while (it.hasNext()) {
                                                String str2 = (String) it.next();
                                                com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str2, false);
                                                if (bT == null || bT.field_status == 0) {
                                                    linkedList.add(str2);
                                                }
                                            }
                                            linkedList3 = linkedList;
                                        }
                                        if (linkedList3 != null || linkedList3.isEmpty()) {
                                            ab.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
                                            p.dhI();
                                            if (wVar.vcm != null) {
                                                wVar.vcm.arL();
                                            }
                                            AppMethodBeat.o(125606);
                                        }
                                        ab.i("MicroMsg.LoadAppInfoAfterLogin", "now do batch get appinfos, appid liSst size is :%d", Integer.valueOf(linkedList3.size()));
                                        com.tencent.mm.plugin.s.a.bYM().a(7, wVar);
                                        com.tencent.mm.plugin.s.a.bYI().aC(linkedList3);
                                        if (wVar.mContext == null || ((Activity) wVar.mContext).isFinishing()) {
                                            if (wVar.vcm != null) {
                                                wVar.vcm.arL();
                                            }
                                            ab.e("MicroMsg.LoadAppInfoAfterLogin", "dz[loadAppInfo:catch the null window for progress bar");
                                            AppMethodBeat.o(125606);
                                            return;
                                        }
                                        Context context = wVar.mContext;
                                        wVar.mContext.getString(R.string.tz);
                                        wVar.tipDialog = com.tencent.mm.ui.base.h.b(context, wVar.mContext.getString(R.string.un), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(79364);
                                                ab.w("MicroMsg.LoadAppInfoAfterLogin", "do init canceled");
                                                g.Rg().c(w.this.cwn);
                                                com.tencent.mm.plugin.s.a.bYM().b(7, w.this);
                                                if (w.this.vcm != null) {
                                                    w.this.vcm.arL();
                                                }
                                                AppMethodBeat.o(79364);
                                            }
                                        });
                                        AppMethodBeat.o(125606);
                                        return;
                                    }
                                }
                            }
                            linkedList2 = null;
                            linkedList = new LinkedList();
                            it = linkedList2.iterator();
                            while (it.hasNext()) {
                            }
                            linkedList3 = linkedList;
                            if (linkedList3 != null) {
                            }
                            ab.i("MicroMsg.LoadAppInfoAfterLogin", "no saved appids, just callback");
                            p.dhI();
                            if (wVar.vcm != null) {
                            }
                            AppMethodBeat.o(125606);
                        }
                    });
                    cVar.cwn = a.gkF.a((com.tencent.mm.ai.g) cVar);
                    if (cVar.cwn != null) {
                        if (cVar.gyH != null) {
                            cVar.gyH.aqC();
                        }
                        AppMethodBeat.o(125627);
                        return;
                    }
                    if (cVar.cwn.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                        g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, cVar);
                    } else if (cVar.cwn.getType() == 138) {
                        g.Rg().a(138, cVar);
                    }
                    g.Rg().a(cVar.cwn, 0);
                    Context context = cVar.context;
                    cVar.context.getString(R.string.tz);
                    cVar.tipDialog = com.tencent.mm.ui.base.h.b(context, cVar.context.getString(R.string.re), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(124671);
                            ab.w("MicroMsg.DoInit", "do init canceled");
                            g.Rg().c(c.this.cwn);
                            if (c.this.cwn.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                                g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX, c.this);
                                AppMethodBeat.o(124671);
                                return;
                            }
                            if (c.this.cwn.getType() == 138) {
                                g.Rg().b(138, c.this);
                            }
                            AppMethodBeat.o(124671);
                        }
                    });
                    AppMethodBeat.o(125627);
                    return;
                } else if (i2 == -217) {
                    z.a(this, com.tencent.mm.platformtools.e.a((q) mVar), i2);
                    AppMethodBeat.o(125627);
                    return;
                } else {
                    if (a.gkF.a(this.mController.ylL, i, i2, str)) {
                        obj = 1;
                    } else {
                        if (i == 4) {
                            switch (i2) {
                                case -311:
                                case -310:
                                case -6:
                                    if (this.gue == null) {
                                        this.gue = SecurityImage.a.a(this.mController.ylL, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(125602);
                                                ab.d("MicroMsg.SimpleLoginUI", "imgSid:" + SimpleLoginUI.this.gBT.guh + " img len" + SimpleLoginUI.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                                final m qVar = new q(SimpleLoginUI.this.gBT.account, SimpleLoginUI.this.gBT.guf, SimpleLoginUI.this.gBT.gCL, SimpleLoginUI.this.gue.getSecImgCode(), SimpleLoginUI.this.gue.getSecImgSid(), SimpleLoginUI.this.gue.getSecImgEncryptKey(), 0, "", false, false);
                                                g.Rg().a(qVar, 0);
                                                SimpleLoginUI simpleLoginUI = SimpleLoginUI.this;
                                                Context context = SimpleLoginUI.this;
                                                SimpleLoginUI.this.getString(R.string.tz);
                                                simpleLoginUI.ehJ = com.tencent.mm.ui.base.h.b(context, SimpleLoginUI.this.getString(R.string.cou), true, new OnCancelListener() {
                                                    public final void onCancel(DialogInterface dialogInterface) {
                                                        AppMethodBeat.i(125601);
                                                        g.Rg().c(qVar);
                                                        AppMethodBeat.o(125601);
                                                    }
                                                });
                                                AppMethodBeat.o(125602);
                                            }
                                        }, null, new OnDismissListener() {
                                            public final void onDismiss(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(125603);
                                                SimpleLoginUI.this.gue = null;
                                                AppMethodBeat.o(125603);
                                            }
                                        }, this.gBT);
                                    } else {
                                        ab.d("MicroMsg.SimpleLoginUI", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                                        this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                                    }
                                    obj = 1;
                                    break;
                                case -205:
                                    ab.i("MicroMsg.SimpleLoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", bo.anv(this.gzO), this.gBW);
                                    f.a(this.gBT);
                                    Intent intent = new Intent();
                                    intent.putExtra("auth_ticket", this.gzO);
                                    intent.putExtra("binded_mobile", this.gBV);
                                    intent.putExtra("close_safe_device_style", this.gBW);
                                    intent.putExtra("from_source", 3);
                                    a.gkE.g((Context) this, intent);
                                    obj = 1;
                                    break;
                                case -140:
                                    if (!bo.isNullOrNil(this.cOG)) {
                                        z.o(this, str, this.cOG);
                                    }
                                    obj = 1;
                                    break;
                                case ZipJNI.UNZ_ERR_OPEN_WRITE /*-106*/:
                                    z.f(this, str, 0);
                                    obj = 1;
                                    break;
                                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                                    com.tencent.mm.kernel.a.hold();
                                    g.RN();
                                    com.tencent.mm.ui.base.h.a((Context) this, com.tencent.mm.kernel.a.QH(), getString(R.string.tz), new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    }, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    obj = 1;
                                    break;
                                case -75:
                                    z.cu(this.mController.ylL);
                                    obj = 1;
                                    break;
                                case -72:
                                    com.tencent.mm.ui.base.h.g(this.mController.ylL, R.string.dmb, R.string.tz);
                                    obj = 1;
                                    break;
                                case -30:
                                case -4:
                                case -3:
                                    com.tencent.mm.ui.base.h.g(this, R.string.be9, R.string.cog);
                                    obj = 1;
                                    break;
                                case -9:
                                    com.tencent.mm.ui.base.h.g(this, R.string.cof, R.string.cog);
                                    obj = 1;
                                    break;
                                case -1:
                                    if (g.Rg().acS() == 5) {
                                        com.tencent.mm.ui.base.h.g(this, R.string.d5n, R.string.d5m);
                                        obj = 1;
                                        break;
                                    }
                            }
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        AppMethodBeat.o(125627);
                        return;
                    }
                    com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                    if (jY == null || !jY.a(this, null, null)) {
                        Toast.makeText(this, getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        AppMethodBeat.o(125627);
                        return;
                    }
                    AppMethodBeat.o(125627);
                    return;
                }
            }
        }
        obj = null;
        if (obj == null) {
        }
        com.tencent.mm.kernel.a.unhold();
        w.cm(this);
        z.vx(this.gBT.account);
        cVar = new com.tencent.mm.plugin.account.model.c(this.mController.ylL, /* anonymous class already generated */);
        cVar.cwn = a.gkF.a((com.tencent.mm.ai.g) cVar);
        if (cVar.cwn != null) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        AppMethodBeat.i(125628);
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SimpleLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.d(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.SimpleLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bo.isNullOrNil(stringExtra));
            if (!bo.isNullOrNil(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            ab.d(str2, str3, objArr2);
            if (intExtra == -217) {
                aqU();
                AppMethodBeat.o(125628);
                return;
            }
        }
        AppMethodBeat.o(125628);
    }

    static /* synthetic */ void a(SimpleLoginUI simpleLoginUI) {
        AppMethodBeat.i(125629);
        if (bo.isNullOrNil(simpleLoginUI.gCS.getText().toString()) || bo.isNullOrNil(simpleLoginUI.gCT.getText().toString())) {
            simpleLoginUI.gCW.setEnabled(false);
            AppMethodBeat.o(125629);
            return;
        }
        simpleLoginUI.gCW.setEnabled(true);
        AppMethodBeat.o(125629);
    }
}
