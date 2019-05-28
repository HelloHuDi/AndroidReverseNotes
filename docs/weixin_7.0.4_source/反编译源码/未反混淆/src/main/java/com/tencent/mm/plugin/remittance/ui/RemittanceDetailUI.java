package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.od;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.rtmp.TXLiveConstants;

public class RemittanceDetailUI extends WalletBaseUI {
    private int jLX;
    private int jLY;
    private a jMO = null;
    private d lCi = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(45006);
            ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
            CharSequence charSequence = "";
            StringBuilder stringBuilder;
            String trim;
            if (bo.gW(RemittanceDetailUI.this.pVv, R.id.e0c)) {
                charSequence = RemittanceDetailUI.this.pUJ.getText().toString().trim();
            } else if (bo.gW(RemittanceDetailUI.this.pVv, R.id.e0f)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceDetailUI.this.pUK.getText().toString().trim() + " ");
                trim = RemittanceDetailUI.this.pUM.getText().toString().trim();
                if (trim.endsWith(RemittanceDetailUI.this.getString(R.string.n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            } else if (bo.gW(RemittanceDetailUI.this.pVv, R.id.e0u)) {
                charSequence = RemittanceDetailUI.this.pVf.getText().toString().trim();
            } else if (bo.gW(RemittanceDetailUI.this.pVv, R.id.e0x)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(RemittanceDetailUI.this.pVg.getText().toString().trim() + " ");
                trim = RemittanceDetailUI.this.pVi.getText().toString().trim();
                if (trim.endsWith(RemittanceDetailUI.this.getString(R.string.n6))) {
                    stringBuilder.append(trim.substring(0, trim.length() - 4));
                } else {
                    stringBuilder.append(trim);
                }
                charSequence = stringBuilder.toString();
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, charSequence));
            h.bQ(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(R.string.oz));
            AppMethodBeat.o(45006);
        }
    };
    private OnTouchListener mlU = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(45007);
            switch (motionEvent.getAction()) {
                case 0:
                    RemittanceDetailUI.this.jLX = (int) motionEvent.getRawX();
                    RemittanceDetailUI.this.jLY = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(45007);
            return false;
        }
    };
    private OnLongClickListener mlV = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            AppMethodBeat.i(45011);
            ab.d("MicroMsg.RemittanceDetailUI", "onLongClick");
            if (RemittanceDetailUI.this.jMO == null) {
                RemittanceDetailUI.this.jMO = new a(RemittanceDetailUI.this.mController.ylL);
            }
            RemittanceDetailUI.this.jMO.a(view, RemittanceDetailUI.this, RemittanceDetailUI.this.lCi, RemittanceDetailUI.this.jLX, RemittanceDetailUI.this.jLY);
            RemittanceDetailUI.this.pVv = view.getId();
            AppMethodBeat.o(45011);
            return true;
        }
    };
    protected TextView ocV = null;
    private int pRA;
    protected String pRG = null;
    private LinearLayout pRn;
    private String pRz = null;
    protected TextView pUA = null;
    protected TextView pUB = null;
    protected TextView pUC = null;
    protected Button pUD = null;
    protected LinearLayout pUE;
    private LinearLayout pUF;
    private LinearLayout pUG;
    private LinearLayout pUH;
    private TextView pUI;
    private TextView pUJ;
    private TextView pUK;
    private TextView pUL;
    private TextView pUM;
    protected RelativeLayout pUN;
    protected ImageView pUO;
    protected TextView pUP;
    protected TextView pUQ;
    protected ImageView pUR;
    protected Button pUS;
    protected TextView pUT;
    protected View pUU;
    protected View pUV;
    protected View pUW;
    protected Button pUX = null;
    protected TextView pUY = null;
    protected LinearLayout pUZ;
    protected ImageView pUy = null;
    protected TextView pUz = null;
    private LinearLayout pVa;
    private LinearLayout pVb;
    private LinearLayout pVc;
    private LinearLayout pVd;
    private TextView pVe;
    private TextView pVf;
    private TextView pVg;
    private TextView pVh;
    private TextView pVi;
    protected int pVj;
    protected int pVk;
    public String pVl = null;
    public String pVm = null;
    protected String pVn = null;
    protected int pVo = 3;
    protected boolean pVp = false;
    protected int pVq;
    private int pVr;
    private u pVs;
    private c<od> pVt = new c<od>() {
        {
            AppMethodBeat.i(44993);
            this.xxI = od.class.getName().hashCode();
            AppMethodBeat.o(44993);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(44994);
            final od odVar = (od) bVar;
            if (!(bo.isNullOrNil(odVar.cKt.cAa) || bo.isNullOrNil(odVar.cKt.cEa))) {
                h.d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(R.string.dok, new Object[]{RemittanceDetailUI.bc(RemittanceDetailUI.this.pcH, false)}), RemittanceDetailUI.this.getString(R.string.t6), RemittanceDetailUI.this.getString(R.string.dop), RemittanceDetailUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(44992);
                        m uVar = new u(odVar.cKt.cAa, odVar.cKt.cEa, odVar.cKt.cKu, "refuse", odVar.cKt.cKv, odVar.cKt.cKw);
                        uVar.eHT = "RemittanceProcess";
                        RemittanceDetailUI.this.a(uVar, true, true);
                        AppMethodBeat.o(44992);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            AppMethodBeat.o(44994);
            return false;
        }
    };
    private c<oc> pVu = new c<oc>() {
        {
            AppMethodBeat.i(45009);
            this.xxI = oc.class.getName().hashCode();
            AppMethodBeat.o(45009);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(45010);
            ab.i("MicroMsg.RemittanceDetailUI", "RemittanceDetailUIFinishEvent");
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(45008);
                    RemittanceDetailUI.this.finish();
                    AppMethodBeat.o(45008);
                }
            }, 500);
            AppMethodBeat.o(45010);
            return false;
        }
    };
    private int pVv = 0;
    private String pcA;
    private String pcH;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemittanceDetailUI() {
        AppMethodBeat.i(45027);
        AppMethodBeat.o(45027);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45028);
        super.onCreate(bundle);
        this.pVj = getIntent().getIntExtra("invalid_time", 0);
        this.pVk = getIntent().getIntExtra("appmsg_type", 0);
        this.pVl = getIntent().getStringExtra(FirebaseAnalytics.b.TRANSACTION_ID);
        this.pVn = getIntent().getStringExtra("bill_id");
        this.pRG = getIntent().getStringExtra("transfer_id");
        this.pVm = getIntent().getStringExtra("sender_name");
        this.pVo = getIntent().getIntExtra("effective_date", 3);
        this.pVp = getIntent().getBooleanExtra("is_sender", false);
        this.pVq = getIntent().getIntExtra("total_fee", 0);
        initView();
        BK(0);
        getIntent();
        com.tencent.mm.sdk.b.a.xxA.c(this.pVt);
        this.pVu.dnU();
        AppMethodBeat.o(45028);
    }

    public void onDestroy() {
        AppMethodBeat.i(45029);
        com.tencent.mm.sdk.b.a.xxA.d(this.pVt);
        if (this.pVu != null) {
            this.pVu.dead();
        }
        super.onDestroy();
        AppMethodBeat.o(45029);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45030);
        ab.i("MicroMsg.RemittanceDetailUI", "onActivityResult %s %s %s", Integer.valueOf(i), Integer.valueOf(i2), intent);
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            BK(0);
        }
        AppMethodBeat.o(45030);
    }

    /* Access modifiers changed, original: protected */
    public void BK(int i) {
        AppMethodBeat.i(45031);
        a(new NetSceneTenpayRemittanceQuery(i, this.pVl, this.pRG, this.pVj), true, false);
        AppMethodBeat.o(45031);
    }

    public final void initView() {
        AppMethodBeat.i(45032);
        setMMTitle("");
        dyb();
        xE(getResources().getColor(R.color.d4));
        this.pUy = (ImageView) findViewById(R.id.e03);
        this.pUz = (TextView) findViewById(R.id.e04);
        this.pUA = (TextView) findViewById(R.id.e05);
        this.pUD = (Button) findViewById(R.id.e08);
        this.ocV = (TextView) findViewById(R.id.e09);
        this.pUE = (LinearLayout) findViewById(R.id.e07);
        this.pUF = (LinearLayout) findViewById(R.id.e0_);
        this.pUG = (LinearLayout) findViewById(R.id.ay5);
        this.pRn = (LinearLayout) findViewById(R.id.e0d);
        this.pUH = (LinearLayout) findViewById(R.id.e0f);
        this.pUI = (TextView) findViewById(R.id.e0b);
        this.pUJ = (TextView) findViewById(R.id.e0c);
        this.pUK = (TextView) findViewById(R.id.e0g);
        this.pUL = (TextView) findViewById(R.id.e0h);
        this.pUM = (TextView) findViewById(R.id.e0i);
        this.pUN = (RelativeLayout) findViewById(R.id.e0k);
        this.pUO = (ImageView) findViewById(R.id.e0l);
        this.pUP = (TextView) findViewById(R.id.e0m);
        this.pUQ = (TextView) findViewById(R.id.e0n);
        this.pUR = (ImageView) findViewById(R.id.e0o);
        this.pUS = (Button) findViewById(R.id.ay8);
        this.pUT = (TextView) findViewById(R.id.e14);
        this.pUU = findViewById(R.id.e0p);
        this.pUV = findViewById(R.id.e0a);
        this.pUW = findViewById(R.id.e0j);
        this.pUX = (Button) findViewById(R.id.e11);
        this.pUY = (TextView) findViewById(R.id.e12);
        this.pUZ = (LinearLayout) findViewById(R.id.e0q);
        this.pVa = (LinearLayout) findViewById(R.id.e0r);
        this.pVb = (LinearLayout) findViewById(R.id.e0s);
        this.pVc = (LinearLayout) findViewById(R.id.e0v);
        this.pVd = (LinearLayout) findViewById(R.id.e0x);
        this.pVe = (TextView) findViewById(R.id.e0t);
        this.pVf = (TextView) findViewById(R.id.e0u);
        this.pVg = (TextView) findViewById(R.id.e0y);
        this.pVh = (TextView) findViewById(R.id.e0z);
        this.pVi = (TextView) findViewById(R.id.e10);
        this.pUB = (TextView) findViewById(R.id.e15);
        this.pUC = (TextView) findViewById(R.id.e16);
        AppMethodBeat.o(45032);
    }

    /* Access modifiers changed, original: protected */
    public void BL(int i) {
        m hVar;
        AppMethodBeat.i(45033);
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new com.tencent.mm.plugin.order.model.h(this.pVl, this.pVn, i);
        } else {
            hVar = new com.tencent.mm.plugin.order.model.h(this.pRG, this.pVn, i);
        }
        hVar.eHT = "RemittanceProcess";
        a(hVar, true, true);
        AppMethodBeat.o(45033);
    }

    /* Access modifiers changed, original: protected */
    public void an(Intent intent) {
        AppMethodBeat.i(45034);
        com.tencent.mm.bp.d.b((Context) this, "remittance", ".ui.RemittanceResendMsgUI", intent);
        AppMethodBeat.o(45034);
    }

    /* Access modifiers changed, original: protected */
    public void cfV() {
        AppMethodBeat.i(45035);
        m uVar = new u(this.pVl, this.pRG, this.pVq, "confirm", this.pVm, this.pVj);
        uVar.eHT = "RemittanceProcess";
        a(uVar, true, true);
        AppMethodBeat.o(45035);
    }

    /* Access modifiers changed, original: protected */
    public void cfW() {
        AppMethodBeat.i(45036);
        m uVar = new u(this.pVl, this.pRG, this.pVq, "refuse", this.pVm, this.pVj);
        uVar.eHT = "RemittanceProcess";
        a(uVar, true, true);
        AppMethodBeat.o(45036);
    }

    private void a(boolean z, boolean z2, final NetSceneTenpayRemittanceQuery netSceneTenpayRemittanceQuery) {
        AppMethodBeat.i(45037);
        if (z) {
            this.pUE.setVisibility(8);
            this.pUZ.setVisibility(0);
            if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                this.pVa.setVisibility(8);
            } else {
                this.pVa.setVisibility(0);
                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.desc)) {
                    this.pVb.setVisibility(8);
                } else {
                    this.pVb.setVisibility(0);
                    this.pVf.setText(netSceneTenpayRemittanceQuery.desc);
                    this.pVf.setOnLongClickListener(this.mlV);
                    this.pVf.setOnTouchListener(this.mlU);
                }
                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                    this.pVc.setVisibility(8);
                } else {
                    this.pVc.setVisibility(0);
                    this.pVg.setText(netSceneTenpayRemittanceQuery.pQm.pQs + "  " + netSceneTenpayRemittanceQuery.pQm.gyD);
                    this.pVe.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(45026);
                            int n = RemittanceResultNewUI.n(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQm.fBg, RemittanceDetailUI.this.pVe.getWidth());
                            if (bo.gW(n, netSceneTenpayRemittanceQuery.pQm.fBg.length())) {
                                RemittanceDetailUI.this.pVh.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                                RemittanceDetailUI.this.pVi.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                            } else {
                                String string = RemittanceDetailUI.this.getString(R.string.n_);
                                String str = netSceneTenpayRemittanceQuery.pQm.fBg.substring(0, n) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                com.tencent.mm.plugin.order.c.a aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(45024);
                                        RemittanceDetailUI.this.pVh.setVisibility(8);
                                        RemittanceDetailUI.this.pVi.setVisibility(0);
                                        com.tencent.mm.ui.tools.m.a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.ih), RemittanceDetailUI.this.findViewById(R.id.e02), RemittanceDetailUI.this.findViewById(R.id.e06), RemittanceDetailUI.this.findViewById(R.id.e13));
                                        AppMethodBeat.o(45024);
                                    }
                                };
                                spannableString.setSpan(aVar, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pVh.setOnTouchListener(a.cfs());
                                RemittanceDetailUI.this.pVh.setText(spannableString);
                                str = RemittanceDetailUI.this.getString(R.string.n6);
                                string = netSceneTenpayRemittanceQuery.pQm.fBg + "  ";
                                spannableString = new SpannableString(string + str);
                                aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(45025);
                                        RemittanceDetailUI.this.pVh.setVisibility(0);
                                        RemittanceDetailUI.this.pVi.setVisibility(8);
                                        com.tencent.mm.ui.tools.m.a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.ih), RemittanceDetailUI.this.findViewById(R.id.e02), RemittanceDetailUI.this.findViewById(R.id.e06), RemittanceDetailUI.this.findViewById(R.id.e13));
                                        AppMethodBeat.o(45025);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pVi.setOnTouchListener(a.cfs());
                                RemittanceDetailUI.this.pVi.setText(spannableString);
                            }
                            RemittanceDetailUI.this.pVh.setVisibility(0);
                            RemittanceDetailUI.this.pVi.setVisibility(8);
                            RemittanceDetailUI.this.pVd.setOnLongClickListener(RemittanceDetailUI.this.mlV);
                            RemittanceDetailUI.this.pVd.setOnTouchListener(RemittanceDetailUI.this.mlU);
                            AppMethodBeat.o(45026);
                        }
                    });
                }
            }
        } else {
            this.pUE.setVisibility(0);
            this.pUZ.setVisibility(8);
            if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                this.pUV.setVisibility(8);
                this.pUG.setVisibility(8);
                this.pRn.setVisibility(8);
                this.pUW.setVisibility(8);
                this.pUF.setVisibility(8);
            } else {
                this.pUF.setVisibility(0);
                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.desc)) {
                    this.pUG.setVisibility(8);
                } else {
                    this.pUG.setVisibility(0);
                    this.pUJ.setText(netSceneTenpayRemittanceQuery.desc);
                    this.pUJ.setOnLongClickListener(this.mlV);
                    this.pUJ.setOnTouchListener(this.mlU);
                }
                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQm.pQs)) {
                    this.pRn.setVisibility(8);
                } else {
                    this.pRn.setVisibility(0);
                    this.pUK.setText(netSceneTenpayRemittanceQuery.pQm.pQs + "  " + netSceneTenpayRemittanceQuery.pQm.gyD);
                    this.pUI.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44997);
                            int n = RemittanceResultNewUI.n(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQm.fBg, RemittanceDetailUI.this.pUI.getWidth());
                            if (bo.gW(n, netSceneTenpayRemittanceQuery.pQm.fBg.length())) {
                                RemittanceDetailUI.this.pUL.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                                RemittanceDetailUI.this.pUM.setText(netSceneTenpayRemittanceQuery.pQm.fBg);
                            } else {
                                String string = RemittanceDetailUI.this.getString(R.string.n_);
                                String str = netSceneTenpayRemittanceQuery.pQm.fBg.substring(0, n) + "... ";
                                SpannableString spannableString = new SpannableString(str + string);
                                com.tencent.mm.plugin.order.c.a aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(44995);
                                        RemittanceDetailUI.this.pUL.setVisibility(8);
                                        RemittanceDetailUI.this.pUM.setVisibility(0);
                                        com.tencent.mm.ui.tools.m.a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.ih), RemittanceDetailUI.this.findViewById(R.id.e02), RemittanceDetailUI.this.findViewById(R.id.e06), RemittanceDetailUI.this.findViewById(R.id.e13));
                                        AppMethodBeat.o(44995);
                                    }
                                };
                                spannableString.setSpan(aVar, str.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pUL.setOnTouchListener(a.cfs());
                                RemittanceDetailUI.this.pUL.setText(spannableString);
                                str = RemittanceDetailUI.this.getString(R.string.n6);
                                string = netSceneTenpayRemittanceQuery.pQm.fBg + "  ";
                                spannableString = new SpannableString(string + str);
                                aVar = new com.tencent.mm.plugin.order.c.a(RemittanceDetailUI.this);
                                aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(44996);
                                        RemittanceDetailUI.this.pUL.setVisibility(0);
                                        RemittanceDetailUI.this.pUM.setVisibility(8);
                                        com.tencent.mm.ui.tools.m.a(RemittanceDetailUI.this, (ScrollView) RemittanceDetailUI.this.findViewById(R.id.ih), RemittanceDetailUI.this.findViewById(R.id.e02), RemittanceDetailUI.this.findViewById(R.id.e06), RemittanceDetailUI.this.findViewById(R.id.e13));
                                        AppMethodBeat.o(44996);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), str.length() + string.length(), 33);
                                RemittanceDetailUI.this.pUM.setOnTouchListener(a.cfs());
                                RemittanceDetailUI.this.pUM.setText(spannableString);
                            }
                            RemittanceDetailUI.this.pUL.setVisibility(0);
                            RemittanceDetailUI.this.pUM.setVisibility(8);
                            RemittanceDetailUI.this.pUH.setOnLongClickListener(RemittanceDetailUI.this.mlV);
                            RemittanceDetailUI.this.pUH.setOnTouchListener(RemittanceDetailUI.this.mlU);
                            AppMethodBeat.o(44997);
                        }
                    });
                }
            }
        }
        if (!z2 || bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQn.cIY)) {
            this.pUW.setVisibility(8);
            this.pUN.setVisibility(8);
            this.pUU.setVisibility(8);
        } else {
            this.pUE.setVisibility(0);
            this.pUF.setVisibility(0);
            this.pUW.setVisibility(0);
            this.pUN.setVisibility(0);
            this.pUU.setVisibility(0);
            com.tencent.mm.at.a.a.ahv().a(netSceneTenpayRemittanceQuery.pQn.cIY, this.pUO);
            this.pUP.setText(netSceneTenpayRemittanceQuery.pQn.name);
            this.pUQ.setText(netSceneTenpayRemittanceQuery.pQn.cEh);
            if (netSceneTenpayRemittanceQuery.pQn.pQt > 0) {
                this.pUS.setText(netSceneTenpayRemittanceQuery.pQn.pQu);
                this.pUR.setVisibility(8);
                this.pUS.setVisibility(0);
                this.pUS.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44998);
                        RemittanceDetailUI.a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.o(44998);
                    }
                });
            } else {
                this.pUR.setVisibility(0);
                this.pUS.setVisibility(8);
                this.pUR.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(44999);
                        RemittanceDetailUI.a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.o(44999);
                    }
                });
                this.pUN.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45000);
                        RemittanceDetailUI.a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQn.pQv, netSceneTenpayRemittanceQuery, 11);
                        AppMethodBeat.o(45000);
                    }
                });
            }
        }
        if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQo.cEh)) {
            this.pUT.setVisibility(8);
        } else {
            this.pUT.setText(netSceneTenpayRemittanceQuery.pQo.cEh);
            this.pUT.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45001);
                    RemittanceDetailUI.a(RemittanceDetailUI.this, netSceneTenpayRemittanceQuery.pQo.pQv, netSceneTenpayRemittanceQuery, 12);
                    AppMethodBeat.o(45001);
                }
            });
            this.pUT.setVisibility(0);
        }
        com.tencent.mm.ui.tools.m.a(this, (ScrollView) findViewById(R.id.ih), findViewById(R.id.e02), findViewById(R.id.e06), findViewById(R.id.e13));
        AppMethodBeat.o(45037);
    }

    private void a(Dialog dialog) {
        AppMethodBeat.i(45038);
        if (dialog != null) {
            dialog.dismiss();
        }
        Intent intent = new Intent(this, WalletLqtDetailUI.class);
        intent.putExtra("key_account_type", 0);
        startActivityForResult(intent, 2);
        AppMethodBeat.o(45038);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(45039);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.oy));
        AppMethodBeat.o(45039);
    }

    private void cfE() {
        AppMethodBeat.i(45040);
        if (this.pVr == 0 || this.pRA != 1 || bo.isNullOrNil(this.pRz)) {
            ab.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", Integer.valueOf(this.pVr), Boolean.valueOf(bo.isNullOrNil(this.pRz)));
            this.mController.removeAllOptionMenu();
            AppMethodBeat.o(45040);
            return;
        }
        addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45012);
                e.n(RemittanceDetailUI.this.mController.ylL, RemittanceDetailUI.this.pRz, false);
                AppMethodBeat.o(45012);
                return false;
            }
        });
        AppMethodBeat.o(45040);
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x07c2  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0792  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45041);
        if (mVar instanceof NetSceneTenpayRemittanceQuery) {
            final NetSceneTenpayRemittanceQuery netSceneTenpayRemittanceQuery = (NetSceneTenpayRemittanceQuery) mVar;
            if (i == 0 && i2 == 0) {
                if (netSceneTenpayRemittanceQuery != null) {
                    if (netSceneTenpayRemittanceQuery.nsL) {
                        this.pcH = r.Yz();
                        this.pcA = this.pVm;
                    } else {
                        this.pcH = this.pVm;
                        this.pcA = r.Yz();
                    }
                    boolean equals = r.Yz().equals(this.pcA);
                    this.pUD.setVisibility(8);
                    this.pUA.setText(e.e(netSceneTenpayRemittanceQuery.kCJ, netSceneTenpayRemittanceQuery.pcl));
                    CharSequence charSequence = netSceneTenpayRemittanceQuery.pQj;
                    if (!bo.isNullOrNil(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", bc(this.pcA, true));
                    }
                    CharSequence charSequence2 = netSceneTenpayRemittanceQuery.pQk;
                    Object bundle = new Bundle();
                    bundle.putString(FirebaseAnalytics.b.TRANSACTION_ID, this.pVl);
                    bundle.putString("receiver_name", this.pcA);
                    bundle.putString("transfer_id", this.pRG);
                    bundle.putInt("total_fee", this.pVq);
                    bundle.putString("sender_name", this.pVm);
                    bundle.putInt("invalid_time", this.pVj);
                    bundle.putParcelable("resend_msg_info", netSceneTenpayRemittanceQuery.pQp);
                    this.ocV.setClickable(true);
                    this.pUz.setClickable(true);
                    this.pUY.setClickable(true);
                    int i3 = netSceneTenpayRemittanceQuery.status;
                    ab.d("MicroMsg.RemittanceDetailUI", "status: %d", Integer.valueOf(i3));
                    String string;
                    String string2;
                    switch (i3) {
                        case 2000:
                            SpannableString spannableString;
                            com.tencent.mm.plugin.order.c.a aVar;
                            if (equals) {
                                this.pUy.setImageResource(R.raw.remittance_wait);
                                this.pUX.setVisibility(0);
                                this.pUX.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(45018);
                                        ((com.tencent.mm.pluginsdk.wallet.b) g.K(com.tencent.mm.pluginsdk.wallet.b.class)).eA(9, 4);
                                        com.tencent.mm.plugin.wallet_core.model.r.cPD();
                                        MMActivity mMActivity = RemittanceDetailUI.this;
                                        com.tencent.mm.wallet_core.d.e c = RemittanceDetailUI.this.Ahr;
                                        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a() {
                                            public final boolean c(int i, int i2, String str, boolean z) {
                                                AppMethodBeat.i(45017);
                                                if (i == 2) {
                                                    RemittanceDetailUI.this.cfV();
                                                    AppMethodBeat.o(45017);
                                                } else {
                                                    if (i == 0 && z) {
                                                        RemittanceDetailUI.this.cfV();
                                                    }
                                                    AppMethodBeat.o(45017);
                                                }
                                                return true;
                                            }
                                        };
                                        if (!com.tencent.mm.plugin.wallet_core.model.r.a(mMActivity, c)) {
                                            RemittanceDetailUI.this.cfV();
                                        }
                                        AppMethodBeat.o(45018);
                                    }
                                });
                                if (bo.isNullOrNil(charSequence) || bo.isNullOrNil(charSequence2)) {
                                    this.pUz.setText(R.string.dow);
                                    if (netSceneTenpayRemittanceQuery.pQl == 0) {
                                        string = getString(R.string.doz, new Object[]{Integer.valueOf(this.pVo)});
                                    } else if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                        ab.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = netSceneTenpayRemittanceQuery.pQl == 1 ? "24" : "2";
                                        string = getString(R.string.doy, new Object[]{string}) + getString(R.string.doz, new Object[]{Integer.valueOf(this.pVo)});
                                    } else {
                                        string = netSceneTenpayRemittanceQuery.pQk;
                                    }
                                    string2 = getString(R.string.doo);
                                    spannableString = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.i(45020);
                                            h.d(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(R.string.dok, new Object[]{RemittanceDetailUI.bc(netSceneTenpayRemittanceQuery.pQh, false)}), RemittanceDetailUI.this.getString(R.string.t6), RemittanceDetailUI.this.getString(R.string.dop), RemittanceDetailUI.this.getString(R.string.or), new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    AppMethodBeat.i(45019);
                                                    RemittanceDetailUI.this.cfW();
                                                    AppMethodBeat.o(45019);
                                                }
                                            }, new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            });
                                            AppMethodBeat.o(45020);
                                        }
                                    };
                                    spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.pUY.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.pUY.setText(spannableString);
                                } else {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUY.setText(j.a((Context) this, charSequence2, (int) this.pUY.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                    this.pUY.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                }
                                a(true, false, netSceneTenpayRemittanceQuery);
                            } else {
                                if (bo.isNullOrNil(charSequence) || bo.isNullOrNil(charSequence2)) {
                                    this.pUz.setText(j.b((Context) this, getString(R.string.dox, new Object[]{bc(this.pcA, true)}), this.pUz.getTextSize()));
                                    string = getString(R.string.dp3, new Object[]{Integer.valueOf(this.pVo)});
                                    string2 = getString(R.string.g8r);
                                    spannableString = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.i(45016);
                                            new d(RemittanceDetailUI.this).a(netSceneTenpayRemittanceQuery.pQp, new com.tencent.mm.ui.widget.a.e.c() {
                                                public final void d(boolean z, String str) {
                                                    AppMethodBeat.i(45015);
                                                    if (z) {
                                                        Intent intent = new Intent();
                                                        intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, RemittanceDetailUI.this.pVl);
                                                        intent.putExtra("transfer_id", RemittanceDetailUI.this.pRG);
                                                        intent.putExtra("receiver_name", RemittanceDetailUI.this.pcA);
                                                        intent.putExtra("resend_msg_from_flag", 3);
                                                        RemittanceDetailUI.this.an(intent);
                                                    }
                                                    AppMethodBeat.o(45015);
                                                }
                                            });
                                            AppMethodBeat.o(45016);
                                        }
                                    };
                                    spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableString);
                                } else {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                    this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                }
                                a(false, false, netSceneTenpayRemittanceQuery);
                            }
                            this.pUy.setImageResource(R.raw.remittance_wait);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setVisibility(8);
                            break;
                        case 2001:
                            this.pUy.setImageResource(R.raw.remittance_received);
                            if (!bo.isNullOrNil(charSequence) && !bo.isNullOrNil(charSequence2)) {
                                this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                            } else if (equals) {
                                this.pUz.setText(R.string.dor);
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.do9));
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(this);
                                aVar2.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(45021);
                                        com.tencent.mm.pluginsdk.wallet.h.ak(RemittanceDetailUI.this, 0);
                                        AppMethodBeat.o(45021);
                                    }
                                };
                                spannableStringBuilder.setSpan(aVar2, 0, spannableStringBuilder.length(), 18);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableStringBuilder);
                                this.ocV.setVisibility(0);
                            } else {
                                this.pUz.setText(j.b((Context) this, bc(this.pcA, true) + getString(R.string.dor), this.pUz.getTextSize()));
                                this.ocV.setText(R.string.dp2);
                                this.ocV.setVisibility(0);
                            }
                            if (equals) {
                                a(false, true, netSceneTenpayRemittanceQuery);
                            } else {
                                a(false, false, netSceneTenpayRemittanceQuery);
                            }
                            this.pUB.setText(getString(R.string.dp5, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(R.string.dog, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUy.setImageResource(R.raw.remittance_refunded);
                                if (!bo.isNullOrNil(charSequence)) {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                } else if (equals) {
                                    this.pUz.setText(R.string.dot);
                                } else {
                                    this.pUz.setText(j.b((Context) this, bc(this.pcA, true) + getString(R.string.dot), this.pUz.getTextSize()));
                                }
                            } else {
                                this.pUy.setImageResource(R.raw.remittance_timed_out);
                                if (bo.isNullOrNil(charSequence)) {
                                    this.pUz.setText(R.string.dov);
                                } else {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                }
                            }
                            if (equals) {
                                this.ocV.setVisibility(8);
                            } else {
                                if (!bo.isNullOrNil(charSequence2)) {
                                    this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                } else if ("CFT".equals(netSceneTenpayRemittanceQuery.pcJ) || "LQT".equals(netSceneTenpayRemittanceQuery.pcJ)) {
                                    final boolean equals2 = "LQT".equals(netSceneTenpayRemittanceQuery.pcJ);
                                    string2 = equals2 ? getString(R.string.don) : getString(R.string.dol);
                                    if (equals2) {
                                        string = getString(R.string.dob);
                                    } else {
                                        string = getString(R.string.do9);
                                    }
                                    SpannableString spannableString2 = new SpannableString(string2 + string);
                                    com.tencent.mm.plugin.order.c.a aVar3 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar3.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.i(45022);
                                            if (equals2) {
                                                com.tencent.mm.bp.d.H(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                                AppMethodBeat.o(45022);
                                                return;
                                            }
                                            com.tencent.mm.pluginsdk.wallet.h.ak(RemittanceDetailUI.this, 0);
                                            AppMethodBeat.o(45022);
                                        }
                                    };
                                    spannableString2.setSpan(aVar3, string2.length(), string.length() + string2.length(), 33);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableString2);
                                } else {
                                    this.ocV.setText(R.string.dom);
                                }
                                this.ocV.setVisibility(0);
                            }
                            a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(R.string.doj, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case 2004:
                            if (equals) {
                                this.pUy.setImageResource(R.raw.remittance_wait);
                                if (bo.isNullOrNil(charSequence) || bo.isNullOrNil(charSequence2)) {
                                    if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                        this.pUz.setText(R.string.dos);
                                    } else {
                                        this.pUz.setText(netSceneTenpayRemittanceQuery.pQj);
                                    }
                                    if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                        this.ocV.setText(R.string.doi);
                                    } else {
                                        this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                    }
                                } else {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                    this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                }
                            } else {
                                this.pUy.setImageResource(R.raw.remittance_wait);
                                if (bo.isNullOrNil(charSequence) || bo.isNullOrNil(charSequence2)) {
                                    if (!bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                        try {
                                            this.pUz.setText(String.format(netSceneTenpayRemittanceQuery.pQj, new Object[]{bc(this.pcA, true)}));
                                        } catch (Exception e) {
                                            ab.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                            this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                        } else {
                                            this.ocV.setText("");
                                        }
                                    }
                                    this.pUz.setText(getString(R.string.dou, new Object[]{bc(this.pcA, true)}));
                                    if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                    }
                                } else {
                                    this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                    this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                    this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                    this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                }
                            }
                            a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(R.string.dog, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                            this.pUy.setImageResource(R.raw.remittance_cancle);
                            if (bo.isNullOrNil(charSequence) || bo.isNullOrNil(charSequence2)) {
                                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQj)) {
                                    this.pUz.setText(R.string.doq);
                                } else {
                                    this.pUz.setText(netSceneTenpayRemittanceQuery.pQj);
                                }
                                if (bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQk)) {
                                    if (equals) {
                                        this.ocV.setText(R.string.doh);
                                    } else {
                                        this.ocV.setText(R.string.dp1);
                                    }
                                } else if ("CFT".equals(netSceneTenpayRemittanceQuery.pcJ) || "LQT".equals(netSceneTenpayRemittanceQuery.pcJ)) {
                                    equals = "LQT".equals(netSceneTenpayRemittanceQuery.pcJ);
                                    String str2 = netSceneTenpayRemittanceQuery.pQk;
                                    if (equals) {
                                        charSequence = getString(R.string.dob);
                                    } else {
                                        charSequence = getString(R.string.do9);
                                    }
                                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                                    spannableStringBuilder2.append(str2);
                                    spannableStringBuilder2.append(charSequence);
                                    com.tencent.mm.plugin.order.c.a aVar4 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar4.peT = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            AppMethodBeat.i(45023);
                                            if (equals) {
                                                com.tencent.mm.bp.d.H(RemittanceDetailUI.this, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                                AppMethodBeat.o(45023);
                                                return;
                                            }
                                            com.tencent.mm.pluginsdk.wallet.h.ak(RemittanceDetailUI.this, 0);
                                            AppMethodBeat.o(45023);
                                        }
                                    };
                                    spannableStringBuilder2.setSpan(aVar4, str2.length(), spannableStringBuilder2.length(), 18);
                                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.ocV.setText(spannableStringBuilder2);
                                } else {
                                    this.ocV.setText(netSceneTenpayRemittanceQuery.pQk);
                                }
                            } else {
                                this.pUz.setText(j.a((Context) this, charSequence, (int) this.pUz.getTextSize(), bundle));
                                this.ocV.setText(j.a((Context) this, charSequence2, (int) this.ocV.getTextSize(), bundle));
                                this.pUz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                                this.ocV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m());
                            }
                            a(false, false, netSceneTenpayRemittanceQuery);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQf)}));
                            this.pUB.setVisibility(0);
                            if (netSceneTenpayRemittanceQuery.pQi <= 0) {
                                this.pUC.setVisibility(8);
                                break;
                            }
                            this.pUC.setText(getString(R.string.do8, new Object[]{e.kC(netSceneTenpayRemittanceQuery.pQi)}));
                            this.pUC.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    if (!bo.isNullOrNil(netSceneTenpayRemittanceQuery.pQq)) {
                        e.a((TextView) findViewById(R.id.a2f), "7", netSceneTenpayRemittanceQuery.pQq, netSceneTenpayRemittanceQuery.pQr);
                    }
                }
                this.pVr = netSceneTenpayRemittanceQuery.pQl;
                g.RQ();
                this.pRz = (String) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, (Object) "");
                g.RQ();
                this.pRA = ((Integer) g.RP().Ry().get(ac.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, Integer.valueOf(0))).intValue();
                if (bo.isNullOrNil(this.pRz)) {
                    ae.a(true, this.Ahr);
                } else {
                    ae.a(false, this.Ahr);
                }
                cfE();
                if (netSceneTenpayRemittanceQuery.pcT == 1) {
                    g.RQ();
                    if (((String) g.RP().Ry().get(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        int i4;
                        Context context = this.mController.ylL;
                        if (r.YM()) {
                            i4 = R.string.alf;
                        } else {
                            i4 = R.string.frh;
                        }
                        h.a(context, i4, (int) R.string.fri, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(45013);
                                h.bQ(RemittanceDetailUI.this.mController.ylL, RemittanceDetailUI.this.getString(R.string.doe));
                                AppMethodBeat.o(45013);
                            }
                        });
                        g.RQ();
                        g.RP().Ry().set(327729, (Object) "1");
                    } else if (this.pVr == 0) {
                        h.bQ(this.mController.ylL, getString(R.string.doe));
                    }
                }
                AppMethodBeat.o(45041);
                return true;
            }
        } else if (mVar instanceof u) {
            if (i == 0 && i2 == 0) {
                this.pVs = (u) mVar;
                if (this.pVs.bLD() && this.pVs.nYe.a((Activity) this, new f() {
                    public final void bMI() {
                        AppMethodBeat.i(45014);
                        RemittanceDetailUI.a(RemittanceDetailUI.this, RemittanceDetailUI.this.pVs);
                        AppMethodBeat.o(45014);
                    }
                })) {
                    AppMethodBeat.o(45041);
                    return true;
                }
                a(this.pVs);
                AppMethodBeat.o(45041);
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                boolean a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, i2, mVar, bundle2, 1008);
                AppMethodBeat.o(45041);
                return a;
            } else {
                aZ(i2, str);
                AppMethodBeat.o(45041);
                return true;
            }
        } else if (mVar instanceof ae) {
            if (i == 0 && i2 == 0) {
                this.pRz = ((ae) mVar).tuE;
                this.pRA = ((ae) mVar).tuF;
                cfE();
            } else {
                ab.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            AppMethodBeat.o(45041);
            return true;
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            AppMethodBeat.o(45041);
            return true;
        }
        AppMethodBeat.o(45041);
        return false;
    }

    private void a(u uVar) {
        AppMethodBeat.i(45042);
        if ("confirm".equals(uVar.pPk)) {
            BK(1);
            AppMethodBeat.o(45042);
            return;
        }
        aZ(0, getResources().getString(R.string.dof));
        AppMethodBeat.o(45042);
    }

    public final int getLayoutId() {
        return R.layout.aof;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aZ(int i, String str) {
        AppMethodBeat.i(45043);
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
        AppMethodBeat.o(45043);
    }

    public void finish() {
        AppMethodBeat.i(45044);
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.pVs == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, this.pVs, bundle, true, 1008)) {
            super.finish();
            AppMethodBeat.o(45044);
            return;
        }
        this.pVs = null;
        AppMethodBeat.o(45044);
    }

    public static String bc(String str, boolean z) {
        AppMethodBeat.i(45045);
        String mJ = e.mJ(str);
        if (mJ == null) {
            mJ = "";
            AppMethodBeat.o(45045);
            return mJ;
        }
        if (mJ.length() > 10 && z) {
            mJ = mJ.substring(0, 8) + "...";
        }
        AppMethodBeat.o(45045);
        return mJ;
    }
}
