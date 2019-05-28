package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class NetworkDiagnoseAllInOneUI extends MMActivity implements OnClickListener {
    private ImageView cAw;
    private a ecy;
    private Button grC;
    private ap gyS;
    private boolean nPX;
    private d nQL;
    private int sIN;
    private TextView sIO;
    private TextView sIP;
    private TextView sIQ;
    private TextView sIR;
    private p sIS;
    private int sIT;
    private String sIU;
    private c<kr> sIV;
    private boolean sIW;
    private boolean sIX;
    private boolean sIY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        AppMethodBeat.i(26010);
        networkDiagnoseAllInOneUI.ard();
        AppMethodBeat.o(26010);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26002);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.cg, R.anim.s);
        setMMTitle("");
        getSupportActionBar().hide();
        Intent intent = getIntent();
        this.sIN = intent.getIntExtra("diagnose_state", 0);
        this.sIT = intent.getIntExtra("diagnose_percent", 1);
        this.sIU = intent.getStringExtra("diagnose_kvInfo");
        ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get state: %d percent: %d, kv: %s", Integer.valueOf(this.sIN), Integer.valueOf(this.sIT), this.sIU);
        if (this.sIN == 0) {
            this.sIN = 1;
            ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "start diagnose");
            aw.Rg().a(new bk(new bk.a() {
                public final void a(e eVar) {
                    AppMethodBeat.i(25999);
                    if (eVar == null) {
                        AppMethodBeat.o(25999);
                        return;
                    }
                    try {
                        eVar.adj();
                        AppMethodBeat.o(25999);
                    } catch (Exception e) {
                        AppMethodBeat.o(25999);
                    }
                }
            }), 0);
        }
        this.grC = (Button) findViewById(R.id.dh_);
        this.sIO = (TextView) findViewById(R.id.dh6);
        this.sIP = (TextView) findViewById(R.id.dha);
        this.cAw = (ImageView) findViewById(R.id.dh7);
        this.sIQ = (TextView) findViewById(R.id.dh8);
        this.sIR = (TextView) findViewById(R.id.dh9);
        this.sIO.setOnClickListener(this);
        this.grC.setOnClickListener(this);
        this.sIP.setOnClickListener(this);
        ard();
        this.sIV = new c<kr>() {
            {
                AppMethodBeat.i(25993);
                this.xxI = kr.class.getName().hashCode();
                AppMethodBeat.o(25993);
            }

            public final /* synthetic */ boolean a(b bVar) {
                int i;
                boolean z = true;
                AppMethodBeat.i(25994);
                kr krVar = (kr) bVar;
                ab.v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", Integer.valueOf(krVar.cGB.cGC), Integer.valueOf(krVar.cGB.status));
                NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI;
                if (krVar.cGB.cGC == 0) {
                    NetworkDiagnoseAllInOneUI.this.sIT = 33;
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (krVar.cGB.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.sIW = z;
                } else if (krVar.cGB.cGC == 1) {
                    NetworkDiagnoseAllInOneUI.this.sIT = 66;
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (krVar.cGB.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.sIX = z;
                } else if (krVar.cGB.cGC == 2) {
                    networkDiagnoseAllInOneUI = NetworkDiagnoseAllInOneUI.this;
                    if (krVar.cGB.status != 0) {
                        z = false;
                    }
                    networkDiagnoseAllInOneUI.sIY = z;
                }
                int a = NetworkDiagnoseAllInOneUI.this.sIN;
                if (krVar.cGB.cGD) {
                    NetworkDiagnoseAllInOneUI.this.sIT = 100;
                    i = 1000;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(25991);
                            NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                            AppMethodBeat.o(25991);
                        }
                    });
                    NetworkDiagnoseAllInOneUI.this.sIU = krVar.cGB.cGE;
                    if (NetworkDiagnoseAllInOneUI.this.sIW) {
                        a = 2;
                    } else if (NetworkDiagnoseAllInOneUI.this.sIX) {
                        a = 4;
                    } else if (NetworkDiagnoseAllInOneUI.this.sIY) {
                        a = 5;
                    } else {
                        a = 3;
                    }
                } else {
                    i = 0;
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25992);
                        NetworkDiagnoseAllInOneUI.this.sIN = a;
                        NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                        AppMethodBeat.o(25992);
                    }
                }, (long) i);
                AppMethodBeat.o(25994);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.b(this.sIV);
        this.ecy = new a() {
            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                String str;
                AppMethodBeat.i(25997);
                ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", Boolean.valueOf(z));
                if (NetworkDiagnoseAllInOneUI.this.nQL != null) {
                    NetworkDiagnoseAllInOneUI.this.nQL.c(NetworkDiagnoseAllInOneUI.this.ecy);
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(25995);
                        NetworkDiagnoseAllInOneUI.this.grC.setEnabled(true);
                        if (NetworkDiagnoseAllInOneUI.this.sIS != null && NetworkDiagnoseAllInOneUI.this.sIS.isShowing()) {
                            NetworkDiagnoseAllInOneUI.this.sIS.dismiss();
                        }
                        NetworkDiagnoseAllInOneUI.this.sIN = 6;
                        NetworkDiagnoseAllInOneUI.b(NetworkDiagnoseAllInOneUI.this);
                        AppMethodBeat.o(25995);
                    }
                });
                NetworkDiagnoseAllInOneUI.this.sIU;
                if (z) {
                    str = (String.valueOf(f2) + "-" + String.valueOf(f)) + "," + NetworkDiagnoseAllInOneUI.this.sIU;
                } else {
                    if (!(NetworkDiagnoseAllInOneUI.this.nPX || d.agA())) {
                        NetworkDiagnoseAllInOneUI.this.nPX = true;
                        h.a(NetworkDiagnoseAllInOneUI.this, NetworkDiagnoseAllInOneUI.this.getString(R.string.c9z), NetworkDiagnoseAllInOneUI.this.getString(R.string.tz), NetworkDiagnoseAllInOneUI.this.getString(R.string.ckr), NetworkDiagnoseAllInOneUI.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(25996);
                                d.bX(NetworkDiagnoseAllInOneUI.this);
                                AppMethodBeat.o(25996);
                            }
                        }, null);
                    }
                    ab.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
                    str = "," + NetworkDiagnoseAllInOneUI.this.sIU;
                }
                com.tencent.mm.plugin.report.service.h.pYm.X(14533, str);
                AppMethodBeat.o(25997);
                return false;
            }
        };
        this.gyS = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(25998);
                NetworkDiagnoseAllInOneUI.this.sIT = NetworkDiagnoseAllInOneUI.this.sIT + 1;
                ab.v("MicroMsg.NetworkDiagnoseAllInOneUI", "timer fired, percent:%d", Integer.valueOf(NetworkDiagnoseAllInOneUI.this.sIT));
                if (NetworkDiagnoseAllInOneUI.this.sIT > 99) {
                    AppMethodBeat.o(25998);
                    return false;
                }
                if (NetworkDiagnoseAllInOneUI.this.sIN == 1) {
                    NetworkDiagnoseAllInOneUI.this.sIQ.setText(NetworkDiagnoseAllInOneUI.this.getString(R.string.b5p, new Object[]{Integer.valueOf(NetworkDiagnoseAllInOneUI.this.sIT)}));
                }
                AppMethodBeat.o(25998);
                return true;
            }
        }, true);
        if (this.sIN == 0 || this.sIN == 1) {
            this.gyS.ae(1000, 1000);
        }
        AppMethodBeat.o(26002);
    }

    public void finish() {
        AppMethodBeat.i(26003);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.ce);
        AppMethodBeat.o(26003);
    }

    public final int getLayoutId() {
        return R.layout.aio;
    }

    private void ard() {
        AppMethodBeat.i(26004);
        ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "refreshUI, state:%d", Integer.valueOf(this.sIN));
        switch (this.sIN) {
            case 0:
            case 1:
                this.cAw.setImageResource(R.raw.network_diagnose_work);
                this.sIQ.setText(getString(R.string.b5p, new Object[]{Integer.valueOf(this.sIT)}));
                this.sIR.setText(R.string.b5h);
                this.grC.setVisibility(4);
                this.sIP.setVisibility(4);
                AppMethodBeat.o(26004);
                return;
            case 2:
                this.cAw.setImageResource(R.raw.network_diagnose_work);
                this.sIQ.setText(R.string.b5t);
                this.sIR.setText(R.string.b5k);
                this.grC.setVisibility(0);
                this.sIP.setVisibility(4);
                AppMethodBeat.o(26004);
                return;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("title", R.string.d5l);
                intent.putExtra("rawUrl", getString(R.string.d5i));
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                mg(false);
                finish();
                AppMethodBeat.o(26004);
                return;
            case 4:
                this.cAw.setImageResource(R.raw.network_diagnose_fail);
                this.sIQ.setText(R.string.b5s);
                this.sIR.setText(R.string.b5i);
                this.grC.setVisibility(0);
                this.grC.setText(R.string.b5e);
                this.sIP.setVisibility(0);
                AppMethodBeat.o(26004);
                return;
            case 5:
                this.cAw.setImageResource(R.raw.network_diagnose_fail);
                this.sIQ.setText(R.string.b5q);
                this.sIR.setText(R.string.b5i);
                this.grC.setVisibility(0);
                this.grC.setText(R.string.b5e);
                this.sIP.setVisibility(0);
                AppMethodBeat.o(26004);
                return;
            case 6:
                this.cAw.setImageResource(R.raw.network_diagnose_feedback);
                this.sIQ.setText(R.string.b5r);
                this.sIR.setText(R.string.b5j);
                this.grC.setVisibility(0);
                this.grC.setText(R.string.b5d);
                this.sIP.setVisibility(4);
                break;
        }
        AppMethodBeat.o(26004);
    }

    private void beo() {
        AppMethodBeat.i(26005);
        if (this.nQL == null) {
            this.nQL = d.agz();
        }
        this.nQL.a(this.ecy, true);
        AppMethodBeat.o(26005);
    }

    private void mg(boolean z) {
        AppMethodBeat.i(26006);
        if (bo.isNullOrNil(this.sIU)) {
            AppMethodBeat.o(26006);
            return;
        }
        ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "submit action, bSendLoaction:%b", Boolean.valueOf(z));
        if (z) {
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 71, "", "")) {
                getString(R.string.tz);
                this.sIS = h.b((Context) this, getString(R.string.b5v), true, null);
                this.grC.setEnabled(false);
                beo();
            }
            AppMethodBeat.o(26006);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.X(14533, "," + this.sIU);
        AppMethodBeat.o(26006);
    }

    public void onClick(View view) {
        AppMethodBeat.i(26007);
        if ((this.sIN == 5 || this.sIN == 4) && view == this.grC) {
            mg(true);
            AppMethodBeat.o(26007);
            return;
        }
        mg(false);
        finish();
        AppMethodBeat.o(26007);
    }

    public void onDestroy() {
        AppMethodBeat.i(26008);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.sIV);
        if (this.nQL != null) {
            this.nQL.c(this.ecy);
            this.nQL = null;
        }
        if (this.gyS != null) {
            this.gyS.stopTimer();
            this.gyS = null;
        }
        AppMethodBeat.o(26008);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(26009);
        ab.i("MicroMsg.NetworkDiagnoseAllInOneUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 71:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.dbt), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26000);
                            NetworkDiagnoseAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(26000);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(26001);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(26001);
                        }
                    });
                    break;
                }
                mg(true);
                AppMethodBeat.o(26009);
                return;
        }
        AppMethodBeat.o(26009);
    }
}
