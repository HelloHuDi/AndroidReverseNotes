package com.tencent.mm.plugin.traceroute.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMProgressBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class NetworkDiagnoseUI extends MMActivity {
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26024);
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                    if (NetworkDiagnoseUI.this.sJp < 95) {
                        NetworkDiagnoseUI.this.sJr.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.sJq.cHv();
                    AppMethodBeat.o(26024);
                    return;
                case 2:
                    if (NetworkDiagnoseUI.this.sJp < 95) {
                        NetworkDiagnoseUI.this.sJr.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.sJq.cHv();
                    AppMethodBeat.o(26024);
                    return;
                case 3:
                    NetworkDiagnoseUI.this.sJr.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, false);
                    AppMethodBeat.o(26024);
                    return;
                case 4:
                    NetworkDiagnoseUI.this.sJr.setProgress(100);
                    NetworkDiagnoseUI.a(NetworkDiagnoseUI.this, true);
                    break;
            }
            AppMethodBeat.o(26024);
        }
    };
    private TextView mnA;
    private int oAI = 0;
    private final int sJo = 100;
    private int sJp = 0;
    private a sJq;
    private MMProgressBar sJr;
    private ap sJs = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(26023);
            NetworkDiagnoseUI.this.sJp = NetworkDiagnoseUI.this.oAI + 1;
            NetworkDiagnoseUI.this.oAI = NetworkDiagnoseUI.this.sJp;
            if (NetworkDiagnoseUI.this.sJp < 100) {
                NetworkDiagnoseUI.this.sJr.setProgress(NetworkDiagnoseUI.this.sJp);
                AppMethodBeat.o(26023);
                return true;
            }
            NetworkDiagnoseUI.this.sJr.setProgress(100);
            AppMethodBeat.o(26023);
            return false;
        }
    }, true);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NetworkDiagnoseUI() {
        AppMethodBeat.i(26034);
        AppMethodBeat.o(26034);
    }

    static /* synthetic */ void g(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(26043);
        networkDiagnoseUI.cHA();
        AppMethodBeat.o(26043);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26035);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(26035);
    }

    public final void initView() {
        AppMethodBeat.i(26036);
        this.mnA = (TextView) findViewById(R.id.dhm);
        this.sJr = (MMProgressBar) findViewById(R.id.dhl);
        this.sJr.setOnProgressChangedListener(new MMProgressBar.a() {
            public final void FO(int i) {
                AppMethodBeat.i(26025);
                if (i < 5) {
                    NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(R.string.ats));
                    AppMethodBeat.o(26025);
                } else if (i < 5 || i >= 95) {
                    NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(R.string.ezd));
                    AppMethodBeat.o(26025);
                } else {
                    NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(R.string.c9u));
                    AppMethodBeat.o(26025);
                }
            }
        });
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26026);
                NetworkDiagnoseUI.g(NetworkDiagnoseUI.this);
                AppMethodBeat.o(26026);
                return true;
            }
        });
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26027);
                NetworkDiagnoseUI.h(NetworkDiagnoseUI.this);
                AppMethodBeat.o(26027);
            }
        }, 200);
        AppMethodBeat.o(26036);
    }

    public final int getLayoutId() {
        return R.layout.air;
    }

    public void onPause() {
        AppMethodBeat.i(26037);
        this.sJr.setAutoProgress(false);
        super.onPause();
        AppMethodBeat.o(26037);
    }

    public void onResume() {
        AppMethodBeat.i(26038);
        aw.ZK();
        if (c.isSDCardAvailable()) {
            this.sJr.setAutoProgress(true);
            super.onResume();
            AppMethodBeat.o(26038);
            return;
        }
        t.hO(this);
        AppMethodBeat.o(26038);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(26039);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            cHA();
            AppMethodBeat.o(26039);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(26039);
        return onKeyDown;
    }

    private void cHA() {
        AppMethodBeat.i(26040);
        h.a((Context) this, (int) R.string.at6, (int) R.string.b5f, (int) R.string.up, (int) R.string.s2, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(26033);
                NetworkDiagnoseUI.e(NetworkDiagnoseUI.this);
                NetworkDiagnoseUI.this.finish();
                AppMethodBeat.o(26033);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(26040);
    }

    static /* synthetic */ void e(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(26041);
        networkDiagnoseUI.sJs.stopTimer();
        if (networkDiagnoseUI.sJq != null) {
            networkDiagnoseUI.sJq.stop();
        }
        AppMethodBeat.o(26041);
    }

    static /* synthetic */ void h(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.i(26044);
        aw.Rg().a(new bk(new bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(26032);
                if (eVar == null) {
                    AppMethodBeat.o(26032);
                    return;
                }
                NetworkDiagnoseUI.this.sJq = new a(r.Yz());
                NetworkDiagnoseUI.this.sJq.c(eVar.getIPsString(true), true);
                NetworkDiagnoseUI.this.sJq.c(eVar.getIPsString(false), false);
                NetworkDiagnoseUI.this.sJq.sIz = new d() {
                    public final void arL() {
                        AppMethodBeat.i(26028);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(2, 500);
                        AppMethodBeat.o(26028);
                    }
                };
                NetworkDiagnoseUI.this.sJq.sIy = new a.e() {
                    public final void cHz() {
                        AppMethodBeat.i(26029);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(1, 500);
                        AppMethodBeat.o(26029);
                    }
                };
                NetworkDiagnoseUI.this.sJq.sIB = new b() {
                    public final void cHx() {
                        AppMethodBeat.i(26030);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessage(3);
                        AppMethodBeat.o(26030);
                    }
                };
                NetworkDiagnoseUI.this.sJq.sIA = new a.c() {
                    public final void cHy() {
                        AppMethodBeat.i(26031);
                        NetworkDiagnoseUI.this.handler.sendEmptyMessage(4);
                        AppMethodBeat.o(26031);
                    }
                };
                a d = NetworkDiagnoseUI.this.sJq;
                if (d.sIx == null || d.sIx.size() == 0) {
                    ab.e("MicroMsg.MMTraceRoute", "no iplist");
                } else {
                    if (a.sIt == null) {
                        a.sIt = new com.tencent.mm.plugin.traceroute.b.c();
                    }
                    com.tencent.mm.sdk.g.d.post(new j(d, (byte) 0), "MMTraceRoute_start");
                }
                NetworkDiagnoseUI.this.sJs.ae(1200, 1200);
                AppMethodBeat.o(26032);
            }
        }), 0);
        AppMethodBeat.o(26044);
    }
}
