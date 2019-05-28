package com.tencent.mm.plugin.remittance.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import d.a.a.c;

@a(19)
public class RemittanceResultNewUI extends RemittanceResultUI {
    private static int[] pWN = null;
    private int jLX;
    private int jLY;
    private com.tencent.mm.ui.widget.b.a jMO = null;
    private d lCi = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(45117);
            ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            CharSequence charSequence = "";
            if (bo.gW(RemittanceResultNewUI.this.pVv, R.id.e0c)) {
                charSequence = RemittanceResultNewUI.this.pUJ.getText().toString().trim();
            } else if (bo.gW(RemittanceResultNewUI.this.pVv, R.id.e2g)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceResultNewUI.this.pUK.getText().toString().trim() + " ");
                String trim = RemittanceResultNewUI.this.pUM.getText().toString().trim();
                if (trim.endsWith(RemittanceResultNewUI.this.getString(R.string.n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, charSequence));
            h.bQ(RemittanceResultNewUI.this, RemittanceResultNewUI.this.getString(R.string.oz));
            AppMethodBeat.o(45117);
        }
    };
    private OnTouchListener mlU = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(45118);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceResultNewUI.this.jLX = (int) motionEvent.getRawX();
                    RemittanceResultNewUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(45118);
            return false;
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(45119);
            ab.d("MicroMsg.RemittanceResultNewUI", "onLongClick");
            if (RemittanceResultNewUI.this.jMO == null) {
                RemittanceResultNewUI.this.jMO = new com.tencent.mm.ui.widget.b.a(RemittanceResultNewUI.this.mController.ylL);
            }
            RemittanceResultNewUI.this.jMO.a(view, RemittanceResultNewUI.this, RemittanceResultNewUI.this.lCi, RemittanceResultNewUI.this.jLX, RemittanceResultNewUI.this.jLY);
            RemittanceResultNewUI.this.pVv = view.getId();
            AppMethodBeat.o(45119);
            return true;
        }
    };
    private PayInfo pGr;
    private int pQY;
    private LinearLayout pRn;
    private c pSK;
    private WalletSuccPageAwardWidget pSL;
    private boolean pSQ = false;
    private com.tencent.mm.sdk.b.c<uv> pSR = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(45114);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(45114);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(45115);
            uv uvVar = (uv) bVar;
            ab.i("MicroMsg.RemittanceResultNewUI", "receive pay result event, do finish");
            if (uvVar.cRF.cRG == 1000 || uvVar.cRF.cRG == 1001) {
                ab.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
                com.tencent.mm.wallet_core.c dOD = RemittanceResultNewUI.this.dOD();
                if (dOD != null) {
                    dOD.aF(RemittanceResultNewUI.this);
                }
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45113);
                        RemittanceResultNewUI.this.finish();
                        AppMethodBeat.o(45113);
                    }
                }, 100);
            }
            AppMethodBeat.o(45115);
            return false;
        }
    };
    private LinearLayout pUF;
    private LinearLayout pUG;
    private LinearLayout pUH;
    private TextView pUI;
    private TextView pUJ;
    private TextView pUK;
    private TextView pUL;
    private TextView pUM;
    private int pVv = 0;
    private boolean pWA;
    private TextView pWB;
    private ViewGroup pWC;
    private TextView pWD;
    private WalletTextView pWE;
    private ViewGroup pWF;
    private ViewGroup pWG;
    private ViewGroup pWH;
    private TextView pWI;
    private TextView pWJ;
    private WalletTextView pWK;
    private ow pWL;
    private Button pWM;
    private Orders pWy;
    private String pWz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceResultNewUI() {
        AppMethodBeat.i(45123);
        AppMethodBeat.o(45123);
    }

    static /* synthetic */ void a(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.i(45143);
        remittanceResultNewUI.cgd();
        AppMethodBeat.o(45143);
    }

    static /* synthetic */ void j(RemittanceResultNewUI remittanceResultNewUI) {
        AppMethodBeat.i(45144);
        remittanceResultNewUI.cge();
        AppMethodBeat.o(45144);
    }

    public void finish() {
        AppMethodBeat.i(45124);
        ab.i("MicroMsg.RemittanceResultNewUI", "finish this %s %s", this, bo.dpG());
        if (this.pSQ) {
            AppMethodBeat.o(45124);
            return;
        }
        super.finish();
        this.pSQ = true;
        AppMethodBeat.o(45124);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45125);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.iW(21)) {
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.pSR.dnU();
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pGr = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        if (this.pGr == null) {
            ab.e("MicroMsg.RemittanceResultNewUI", "payInfo is null!!!");
            finish();
            AppMethodBeat.o(45125);
            return;
        }
        String str = "";
        String str2 = "";
        if (this.pGr.vwh != null) {
            this.pWA = this.pGr.vwh.getBoolean("extinfo_key_4");
            str = this.pGr.vwh.getString("extinfo_key_1");
            str2 = this.pGr.vwh.getString("extinfo_key_16");
        }
        this.pQY = this.pGr.cIf;
        this.pWz = str;
        ab.i("MicroMsg.RemittanceResultNewUI", "payScene: %s", Integer.valueOf(r2));
        initView();
        if (this.pQY == 31) {
            ab.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str2);
            com.tencent.mm.plugin.remittance.a.c.ceW().ceZ().fN(str2, this.pWz);
        }
        AppMethodBeat.o(45125);
    }

    public final int getLayoutId() {
        return R.layout.aom;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45126);
        if (i == 4) {
            cgd();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45126);
        return onKeyUp;
    }

    public final void initView() {
        AppMethodBeat.i(45127);
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        this.pWB = (TextView) findViewById(R.id.dyq);
        this.pWC = (ViewGroup) findViewById(R.id.e29);
        this.pWD = (TextView) findViewById(R.id.e2_);
        this.pWE = (WalletTextView) findViewById(R.id.e2a);
        this.pWF = (ViewGroup) findViewById(R.id.e2h);
        this.pWG = (ViewGroup) findViewById(R.id.dyy);
        this.pWH = (ViewGroup) findViewById(R.id.e2b);
        this.pWI = (TextView) findViewById(R.id.e2c);
        this.pWJ = (TextView) findViewById(R.id.e2d);
        this.pWK = (WalletTextView) findViewById(R.id.e2e);
        this.pWM = (Button) findViewById(R.id.e2n);
        this.pWM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45116);
                RemittanceResultNewUI.a(RemittanceResultNewUI.this);
                AppMethodBeat.o(45116);
            }
        });
        this.pSL = (WalletSuccPageAwardWidget) findViewById(R.id.dze);
        this.pUF = (LinearLayout) findViewById(R.id.e0_);
        this.pUG = (LinearLayout) findViewById(R.id.ay5);
        this.pRn = (LinearLayout) findViewById(R.id.e0d);
        this.pUH = (LinearLayout) findViewById(R.id.e2g);
        this.pUI = (TextView) findViewById(R.id.e0b);
        this.pUJ = (TextView) findViewById(R.id.e0c);
        this.pUK = (TextView) findViewById(R.id.e0g);
        this.pUL = (TextView) findViewById(R.id.e0h);
        this.pUM = (TextView) findViewById(R.id.e0i);
        cfY();
        cgf();
        AppMethodBeat.o(45127);
    }

    private void cfY() {
        AppMethodBeat.i(45128);
        String mJ = e.mJ(this.pWz);
        if (this.pQY == 31 || this.pQY == 5) {
            this.pWJ.setText(e.atq(this.pWy.pcl));
            this.pWK.setText(e.F(this.pWy.pTN));
            if (this.pQY == 31) {
                CharSequence string = getString(R.string.dq9, new Object[]{mJ});
                if (bo.isNullOrNil(string)) {
                    this.pWI.setVisibility(8);
                } else {
                    this.pWI.setText(j.b((Context) this, string, this.pWI.getTextSize()));
                }
            } else {
                boolean z;
                if (this.pGr.vwh == null || !this.pGr.vwh.getBoolean("extinfo_key_10")) {
                    z = false;
                } else {
                    z = true;
                }
                ab.i("MicroMsg.RemittanceResultNewUI", "isEmojiReward: %s", Boolean.valueOf(z));
                if (z) {
                    this.pWI.setText(getString(R.string.dp7));
                } else if (!(this.pWy.tAq == null || this.pWy.tAq.get(0) == null || TextUtils.isEmpty(((Commodity) this.pWy.tAq.get(0)).pca))) {
                    this.pWI.setText(((Commodity) this.pWy.tAq.get(0)).pca);
                }
            }
            this.pWH.setVisibility(0);
            if (this.pWy.pPp > 0.0d) {
                cgc();
                ((MarginLayoutParams) this.pWF.getLayoutParams()).topMargin = com.tencent.mm.bz.a.fromDPToPix(this, 20);
                this.pWF.setVisibility(0);
                this.pWG.setVisibility(0);
            }
            AppMethodBeat.o(45128);
            return;
        }
        byte[] byteArray = this.mBundle.getByteArray("key_succpage_resp");
        if (byteArray != null) {
            this.pWL = new ow();
            try {
                this.pWL.parseFrom(byteArray);
                this.pSK = this.pWL.tBw;
            } catch (Exception e) {
                this.pWL = null;
                this.pSK = null;
                ab.printErrStackTrace("MicroMsg.RemittanceResultNewUI", e, "parse f2FPaySucPageResp error: %s", e.getMessage());
            }
        }
        cfZ();
        AppMethodBeat.o(45128);
    }

    public static int n(Context context, String str, int i) {
        int i2 = 1;
        AppMethodBeat.i(45129);
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 16);
        if (pWN == null) {
            pWN = w.db(context);
        }
        fromDPToPix = ((pWN[0] - com.tencent.mm.bz.a.fromDPToPix(context, 88)) - i) / fromDPToPix;
        int length = str.length();
        int i3 = length / fromDPToPix;
        if (i3 <= 2 && (i3 != 2 || length % fromDPToPix <= 0)) {
            i2 = 0;
        }
        if (i2 != 0) {
            i2 = (fromDPToPix * 2) - 5;
            AppMethodBeat.o(45129);
            return i2;
        }
        i2 = str.length();
        AppMethodBeat.o(45129);
        return i2;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(45130);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.oy));
        AppMethodBeat.o(45130);
    }

    private void cfZ() {
        AppMethodBeat.i(45131);
        String mJ = e.mJ(this.pWz);
        this.pWD.setText(e.atq(this.pWy.pcl));
        this.pWE.setText(e.F(this.pWy.pTN));
        this.pWG.removeAllViews();
        if (this.pQY == 32 || this.pQY == 33 || this.pQY == 48) {
            String str;
            boolean z;
            String str2 = "";
            if (this.pGr.vwh != null) {
                str2 = this.pGr.vwh.getString("extinfo_key_2");
            }
            if (mJ != null && mJ.length() > 10) {
                mJ = mJ.substring(0, 10) + "...";
            }
            if (bo.isNullOrNil(str2)) {
                str = mJ;
            } else if (bo.isNullOrNil(mJ)) {
                str = str2;
            } else {
                str = mJ + "(" + e.att(str2) + ")";
            }
            View cga = cga();
            View cgb = cgb();
            View cgc = cgc();
            if (cga == null && cgb == null && cgc == null) {
                z = true;
            } else {
                z = false;
            }
            this.pWF.setVisibility(0);
            this.pWG.setVisibility(0);
            if (WalletSuccPageAwardWidget.a(this.pSK)) {
                String str3 = "";
                if (this.pWy.tAq.size() > 0) {
                    str3 = ((Commodity) this.pWy.tAq.get(0)).cAa;
                }
                ab.i("MicroMsg.RemittanceResultNewUI", "transId: %s", str3);
                this.pSL.a(this, this.pSK, str3, true, (ImageView) findViewById(R.id.btd));
                this.pSL.init();
                this.pSL.setVisibility(0);
                bd(str, false);
            } else {
                this.pSL.setVisibility(8);
                bd(str, z);
            }
            if (cga != null) {
                this.pWG.addView(cga);
            }
            if (cgb != null) {
                this.pWG.addView(cgb);
            }
            if (cgc != null) {
                this.pWG.addView(cgc);
            }
        }
        this.pWC.setVisibility(0);
        AppMethodBeat.o(45131);
    }

    private ViewGroup bd(String str, boolean z) {
        AppMethodBeat.i(45132);
        ab.i("MicroMsg.RemittanceResultNewUI", "setF2FNameView");
        ViewGroup viewGroup;
        TextView textView;
        if (z) {
            viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.x1, this.pWG, false);
            textView = (TextView) viewGroup.findViewById(R.id.ble);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) viewGroup.findViewById(R.id.bld), this.pWz, 0.06f, false);
            textView.setText(str);
            this.pWG.addView(viewGroup);
            AppMethodBeat.o(45132);
            return viewGroup;
        }
        viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.x0, this.pWG, false);
        textView = (TextView) viewGroup.findViewById(R.id.ble);
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) viewGroup.findViewById(R.id.bld), this.pWz, 0.06f, false);
        textView.setText(str);
        this.pWG.addView(viewGroup);
        AppMethodBeat.o(45132);
        return viewGroup;
    }

    private View cga() {
        AppMethodBeat.i(45133);
        ab.i("MicroMsg.RemittanceResultNewUI", "setF2FReceiverRemarkView");
        String string = this.pGr.vwh.getString("extinfo_key_3");
        String string2 = this.pGr.vwh.getString("extinfo_key_8");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(45133);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.wz, this.pWG, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.qm);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.ld);
        if (bo.isNullOrNil(string2)) {
            textView.setText(getString(R.string.arp));
        } else {
            textView.setText(string2);
        }
        textView2.setText(string);
        AppMethodBeat.o(45133);
        return viewGroup;
    }

    private View cgb() {
        AppMethodBeat.i(45134);
        ab.i("MicroMsg.RemittanceResultNewUI", "setF2FPayerRemarkView");
        String string = this.pGr.vwh.getString("extinfo_key_6");
        String string2 = this.pGr.vwh.getString("extinfo_key_7");
        if (bo.isNullOrNil(string2)) {
            AppMethodBeat.o(45134);
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.wz, this.pWG, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.qm);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.ld);
        if (bo.isNullOrNil(string)) {
            textView.setText(getString(R.string.aro));
        } else {
            textView.setText(string);
        }
        textView2.setText(string2);
        AppMethodBeat.o(45134);
        return viewGroup;
    }

    private View cgc() {
        boolean z = true;
        AppMethodBeat.i(45135);
        if (this.pWy != null) {
            String str = "MicroMsg.RemittanceResultNewUI";
            String str2 = "need set charge fee: %s";
            Object[] objArr = new Object[1];
            if (this.pWy.pPp <= 0.0d) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            if (this.pWy.pPp > 0.0d) {
                String string = getString(R.string.dq6);
                String e = e.e(this.pWy.pPp, this.pWy.pcl);
                ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.wy, this.pWG, false);
                ImageView imageView = (ImageView) viewGroup.findViewById(R.id.qk);
                TextView textView = (TextView) viewGroup.findViewById(R.id.ld);
                ((TextView) viewGroup.findViewById(R.id.qm)).setText(string);
                imageView.setVisibility(8);
                textView.setText(e);
                this.pWG.addView(viewGroup);
                AppMethodBeat.o(45135);
                return viewGroup;
            }
        }
        AppMethodBeat.o(45135);
        return null;
    }

    private void cgd() {
        AppMethodBeat.i(45136);
        ab.i("MicroMsg.RemittanceResultNewUI", "endRemittance");
        if (this.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45120);
                        RemittanceResultNewUI.j(RemittanceResultNewUI.this);
                        AppMethodBeat.o(45120);
                    }
                });
                realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45121);
                        RemittanceResultNewUI.j(RemittanceResultNewUI.this);
                        AppMethodBeat.o(45121);
                    }
                });
                this.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(45136);
            return;
        }
        cge();
        AppMethodBeat.o(45136);
    }

    private void cge() {
        AppMethodBeat.i(45137);
        ab.i("MicroMsg.RemittanceResultNewUI", "doEndRemittance");
        dOD().b(this, this.mBundle);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45122);
                if (RemittanceResultNewUI.this.pQY == 33 || RemittanceResultNewUI.this.pQY == 32 || RemittanceResultNewUI.this.pQY == 48) {
                    RemittanceResultNewUI.this.finish();
                    AppMethodBeat.o(45122);
                } else if (bo.isNullOrNil(RemittanceResultNewUI.this.pWz) || RemittanceResultNewUI.this.pWA) {
                    RemittanceResultNewUI.this.finish();
                    AppMethodBeat.o(45122);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", RemittanceResultNewUI.this.pWz);
                    intent.putExtra("finish_direct", false);
                    com.tencent.mm.bp.d.f(RemittanceResultNewUI.this, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(45122);
                }
            }
        }, 100);
        AppMethodBeat.o(45137);
    }

    private void cgf() {
        AppMethodBeat.i(45138);
        ((i) g.K(i.class)).g(this);
        AppMethodBeat.o(45138);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45139);
        boolean c;
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            c = this.pSL.c(i, i2, str, mVar);
            AppMethodBeat.o(45139);
            return c;
        }
        c = super.c(i, i2, str, mVar);
        AppMethodBeat.o(45139);
        return c;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean cgg() {
        return false;
    }

    public void onResume() {
        AppMethodBeat.i(45141);
        super.onResume();
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            this.pSL.onResume();
        }
        AppMethodBeat.o(45141);
    }

    public void onDestroy() {
        AppMethodBeat.i(45142);
        super.onDestroy();
        this.pSR.dead();
        if (WalletSuccPageAwardWidget.a(this.pSK)) {
            this.pSL.onDestroy();
        }
        AppMethodBeat.o(45142);
    }

    public final void AM(int i) {
        AppMethodBeat.i(45140);
        this.mController.contentView.setVisibility(i);
        AppMethodBeat.o(45140);
    }
}
