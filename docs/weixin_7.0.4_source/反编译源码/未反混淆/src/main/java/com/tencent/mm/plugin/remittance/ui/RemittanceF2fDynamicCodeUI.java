package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.plugin.collect.model.b;
import com.tencent.mm.plugin.wallet_core.utils.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class RemittanceF2fDynamicCodeUI extends WalletBaseUI {
    private static int pWe = 60000;
    private String czU;
    private String kGW;
    private com.tencent.mm.platformtools.x.a kHg = new com.tencent.mm.platformtools.x.a() {
        public final void m(String str, Bitmap bitmap) {
            AppMethodBeat.i(45051);
            if (str == null || RemittanceF2fDynamicCodeUI.this.kGW == null) {
                AppMethodBeat.o(45051);
                return;
            }
            if (str.equals(RemittanceF2fDynamicCodeUI.this.kGW)) {
                ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", RemittanceF2fDynamicCodeUI.this.kGW, str);
                RemittanceF2fDynamicCodeUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45050);
                        RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
                        AppMethodBeat.o(45050);
                    }
                });
            }
            AppMethodBeat.o(45051);
        }
    };
    private int nUf;
    private String nickname;
    private String pPJ;
    private Button pTi;
    private PayInfo pVL;
    private String pVM;
    private String pVN;
    private String pVO;
    private String pVP;
    private String pVQ;
    private String pVR;
    private String pVS;
    private List<zr> pVT = new ArrayList();
    private boolean pVU = false;
    private TextView pVV;
    private TextView pVW;
    private LinearLayout pVX;
    private ImageView pVY;
    private LinearLayout pVZ;
    private WalletTextView pWa;
    private boolean pWb = false;
    private long pWc = 0;
    private long pWd = 0;
    private ap pWf = new ap(new a(this, (byte) 0), true);
    private String pcI;
    private String username;

    class a implements com.tencent.mm.sdk.platformtools.ap.a {
        private a() {
        }

        /* synthetic */ a(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI, byte b) {
            this();
        }

        public final boolean BI() {
            AppMethodBeat.i(45058);
            ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "timer expired");
            if (RemittanceF2fDynamicCodeUI.this.pWb) {
                AppMethodBeat.o(45058);
            } else {
                RemittanceF2fDynamicCodeUI.this.pWc = System.currentTimeMillis();
                RemittanceF2fDynamicCodeUI.f(RemittanceF2fDynamicCodeUI.this);
                AppMethodBeat.o(45058);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceF2fDynamicCodeUI() {
        AppMethodBeat.i(45059);
        AppMethodBeat.o(45059);
    }

    static /* synthetic */ boolean c(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(45069);
        boolean cNR = remittanceF2fDynamicCodeUI.cNR();
        AppMethodBeat.o(45069);
        return cNR;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45060);
        super.onCreate(bundle);
        if (cfX()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.y3)));
                View customView = getSupportActionBar().getCustomView();
                if (customView != null) {
                    View findViewById = customView.findViewById(R.id.p3);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(getResources().getColor(R.color.rt));
                    }
                    customView = customView.findViewById(16908308);
                    if (customView != null && (customView instanceof TextView)) {
                        ((TextView) customView).setTextColor(getResources().getColor(R.color.h4));
                    }
                }
            }
            if (VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(j.INVALID_ID);
                window.setStatusBarColor(getResources().getColor(R.color.y3));
            }
            if (d.iW(21)) {
                if (d.iW(23)) {
                    getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                } else {
                    getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
                }
            }
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(45053);
                    if (RemittanceF2fDynamicCodeUI.c(RemittanceF2fDynamicCodeUI.this)) {
                        RemittanceF2fDynamicCodeUI.this.aqX();
                        RemittanceF2fDynamicCodeUI.this.showDialog(1000);
                    } else {
                        RemittanceF2fDynamicCodeUI.this.setResult(0, new Intent().putExtra("key_pay_reslut_type", 4));
                        RemittanceF2fDynamicCodeUI.this.finish();
                    }
                    AppMethodBeat.o(45053);
                    return true;
                }
            }, R.raw.back_icon_normal_black);
            nf(2736);
            setMMTitle((int) R.string.dnw);
            this.pVL = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
            if (this.pVL == null) {
                ab.e("MicroMsg.RemittanceF2fDynamicCodeUI", "payinfo is null");
                finish();
            }
            AM(4);
            this.nUf = this.pVL.vwh.getInt("extinfo_key_15");
            this.username = this.pVL.vwh.getString("extinfo_key_1");
            this.pcI = this.pVL.vwh.getString("extinfo_key_2");
            this.pVO = this.pVL.vwh.getString("extinfo_key_17");
            this.pVP = this.pVL.vwh.getString("extinfo_key_18");
            this.pVM = getIntent().getStringExtra("key_rcvr_open_id");
            this.pVQ = getIntent().getStringExtra("key_mch_info");
            this.pVN = getIntent().getStringExtra("key_transfer_qrcode_id");
            this.kGW = getIntent().getStringExtra("key_mch_photo");
            this.pPJ = getIntent().getStringExtra("show_paying_wording");
            this.pVR = getIntent().getStringExtra("dynamic_code_spam_wording");
            this.pVU = getIntent().getBooleanExtra("show_avatar_type", false);
            this.nickname = e.mJ(this.username);
            initView();
        }
        AppMethodBeat.o(45060);
    }

    public final void initView() {
        AppMethodBeat.i(45061);
        if (cfX()) {
            this.pVV = (TextView) findViewById(R.id.e1b);
            this.pVW = (TextView) findViewById(R.id.e1g);
            this.pTi = (Button) findViewById(R.id.e1h);
            this.pVY = (ImageView) findViewById(R.id.e1d);
            this.pVX = (LinearLayout) findViewById(R.id.e1e);
            this.pVZ = (LinearLayout) findViewById(R.id.e1f);
            this.pWa = (WalletTextView) findViewById(R.id.e1c);
            this.pWa.setText(getString(R.string.dqb, new Object[]{e.G(((double) this.nUf) / 100.0d)}));
            this.pTi.setOnClickListener(new s() {
                public final void bgW() {
                    AppMethodBeat.i(45054);
                    RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 2);
                    AppMethodBeat.o(45054);
                }
            });
            this.pVY.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(45055);
                    RemittanceF2fDynamicCodeUI.d(RemittanceF2fDynamicCodeUI.this);
                    AppMethodBeat.o(45055);
                    return false;
                }
            });
        }
        AppMethodBeat.o(45061);
    }

    public void onResume() {
        AppMethodBeat.i(45062);
        super.onResume();
        e.cfP().eL(this);
        if (cfX()) {
            this.pWd = this.pWc <= 0 ? 0 : ((long) pWe) - (System.currentTimeMillis() - this.pWc);
            ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "last time: %s, delay: %s", Long.valueOf(this.pWc), Long.valueOf(this.pWd));
            if (this.pWd < 0) {
                this.pWd = 0;
            }
            this.pWf.ae(this.pWd, (long) pWe);
            ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "start timer");
        }
        AppMethodBeat.o(45062);
    }

    public void onPause() {
        AppMethodBeat.i(45063);
        super.onPause();
        if (cfX()) {
            this.pWf.stopTimer();
            ab.d("MicroMsg.RemittanceF2fDynamicCodeUI", "stop timer");
        }
        AppMethodBeat.o(45063);
    }

    public void onDestroy() {
        AppMethodBeat.i(45064);
        if (cfX()) {
            ng(2736);
        }
        super.onDestroy();
        AppMethodBeat.o(45064);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        AppMethodBeat.i(45065);
        super.onActivityResult(i, i2, intent);
        if (cfX()) {
            ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "onActivityResult requestCode:%s resultCode:%s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
            if (i == 1) {
                ob obVar = new ob();
                com.tencent.mm.g.a.ob.a aVar = obVar.cKr;
                if (i2 != -1) {
                    z = false;
                }
                aVar.cwB = z;
                if (intent != null) {
                    obVar.cKr.cKs = intent.getIntExtra("key_pay_reslut_type", 3);
                } else {
                    obVar.cKr.cKs = 3;
                }
                com.tencent.mm.sdk.b.a.xxA.m(obVar);
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(45065);
                    return;
                } else if (c.aw(intent)) {
                    setResult(0, intent);
                    finish();
                    AppMethodBeat.o(45065);
                    return;
                } else if (c.ax(intent)) {
                    AppMethodBeat.o(45065);
                    return;
                } else {
                    fv fvVar = new fv();
                    fvVar.czR.czS = false;
                    com.tencent.mm.sdk.b.a.xxA.m(fvVar);
                }
            }
        }
        AppMethodBeat.o(45065);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45066);
        if (cfX() && (mVar instanceof com.tencent.mm.plugin.remittance.model.m)) {
            this.pWb = false;
            final com.tencent.mm.plugin.remittance.model.m mVar2 = (com.tencent.mm.plugin.remittance.model.m) mVar;
            AM(0);
            mVar2.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45052);
                    RemittanceF2fDynamicCodeUI.this.czU = mVar2.pPb.kCn;
                    RemittanceF2fDynamicCodeUI.this.pVS = mVar2.pPb.vVU;
                    RemittanceF2fDynamicCodeUI.this.pVT = mVar2.pPb.vVV;
                    RemittanceF2fDynamicCodeUI.b(RemittanceF2fDynamicCodeUI.this);
                    AppMethodBeat.o(45052);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        }
        AppMethodBeat.o(45066);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.aoh;
    }

    private boolean cfX() {
        AppMethodBeat.i(45067);
        boolean booleanExtra = getIntent().getBooleanExtra("from_patch_ui", false);
        AppMethodBeat.o(45067);
        return booleanExtra;
    }

    static /* synthetic */ void b(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(45068);
        remittanceF2fDynamicCodeUI.pVY.setImageBitmap(b.a(remittanceF2fDynamicCodeUI, remittanceF2fDynamicCodeUI.czU, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.pVL.pPV, remittanceF2fDynamicCodeUI.kGW, remittanceF2fDynamicCodeUI.kHg, remittanceF2fDynamicCodeUI.pVU));
        if (!bo.isNullOrNil(remittanceF2fDynamicCodeUI.pVS)) {
            remittanceF2fDynamicCodeUI.pVV.setText(remittanceF2fDynamicCodeUI.pVS);
        }
        if (bo.isNullOrNil(remittanceF2fDynamicCodeUI.pVR)) {
            remittanceF2fDynamicCodeUI.pVZ.setVisibility(8);
        } else {
            remittanceF2fDynamicCodeUI.pVW.setText(remittanceF2fDynamicCodeUI.pVR);
            remittanceF2fDynamicCodeUI.pVZ.setVisibility(0);
        }
        remittanceF2fDynamicCodeUI.pVX.removeAllViews();
        if (!remittanceF2fDynamicCodeUI.pVT.isEmpty()) {
            for (zr zrVar : remittanceF2fDynamicCodeUI.pVT) {
                F2fDynamicCodeItemLayout f2fDynamicCodeItemLayout = new F2fDynamicCodeItemLayout(remittanceF2fDynamicCodeUI);
                String str = zrVar.key;
                String str2 = zrVar.value;
                f2fDynamicCodeItemLayout.pQF.setText(str);
                f2fDynamicCodeItemLayout.kRK.setText(str2);
                remittanceF2fDynamicCodeUI.pVX.addView(f2fDynamicCodeItemLayout, new LayoutParams(-1, -2));
            }
        }
        remittanceF2fDynamicCodeUI.pVX.requestLayout();
        AppMethodBeat.o(45068);
    }

    static /* synthetic */ void d(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(45071);
        com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(remittanceF2fDynamicCodeUI.mController.ylL, 1, false);
        dVar.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(45056);
                lVar.clear();
                lVar.hi(0, R.string.dqa);
                AppMethodBeat.o(45056);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(45057);
                if (i == 0) {
                    RemittanceF2fDynamicCodeUI.a(RemittanceF2fDynamicCodeUI.this, 1);
                }
                AppMethodBeat.o(45057);
            }
        };
        dVar.cpD();
        dVar.zQf = new com.tencent.mm.ui.widget.a.d.a() {
            public final void onDismiss() {
            }
        };
        AppMethodBeat.o(45071);
    }

    static /* synthetic */ void f(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        AppMethodBeat.i(45072);
        ab.i("MicroMsg.RemittanceF2fDynamicCodeUI", "do get dynamic code %s", remittanceF2fDynamicCodeUI.pVQ);
        remittanceF2fDynamicCodeUI.pWb = true;
        remittanceF2fDynamicCodeUI.a(new com.tencent.mm.plugin.remittance.model.m(remittanceF2fDynamicCodeUI.nUf, remittanceF2fDynamicCodeUI.username, remittanceF2fDynamicCodeUI.pVM, remittanceF2fDynamicCodeUI.pVN, remittanceF2fDynamicCodeUI.pVO, remittanceF2fDynamicCodeUI.pVP, remittanceF2fDynamicCodeUI.pVQ, remittanceF2fDynamicCodeUI.nickname, remittanceF2fDynamicCodeUI.pcI), false, false);
        AppMethodBeat.o(45072);
    }
}
