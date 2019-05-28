package com.tencent.p177mm.plugin.traceroute.p745ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.MMProgressBar;
import com.tencent.p177mm.p612ui.base.MMProgressBar.C30370a;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a.C22428c;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a.C22429d;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a.C22430e;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a.C22431j;
import com.tencent.p177mm.plugin.traceroute.p1043b.C43709a.C29465b;
import com.tencent.p177mm.plugin.traceroute.p1043b.C46314c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI */
public class NetworkDiagnoseUI extends MMActivity {
    private C7306ak handler = new C294672();
    private TextView mnA;
    private int oAI = 0;
    private final int sJo = 100;
    private int sJp = 0;
    private C43709a sJq;
    private MMProgressBar sJr;
    private C7564ap sJs = new C7564ap(new C400091(), true);

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$5 */
    class C140085 implements Runnable {
        C140085() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26027);
            NetworkDiagnoseUI.m78352h(NetworkDiagnoseUI.this);
            AppMethodBeat.m2505o(26027);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$3 */
    class C224363 implements C30370a {
        C224363() {
        }

        /* renamed from: FO */
        public final void mo37987FO(int i) {
            AppMethodBeat.m2504i(26025);
            if (i < 5) {
                NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(C25738R.string.ats));
                AppMethodBeat.m2505o(26025);
            } else if (i < 5 || i >= 95) {
                NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(C25738R.string.ezd));
                AppMethodBeat.m2505o(26025);
            } else {
                NetworkDiagnoseUI.this.mnA.setText(NetworkDiagnoseUI.this.getString(C25738R.string.c9u));
                AppMethodBeat.m2505o(26025);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$2 */
    class C294672 extends C7306ak {
        C294672() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(26024);
            switch (message.what) {
                case 1:
                    NetworkDiagnoseUI.m78349e(NetworkDiagnoseUI.this);
                    if (NetworkDiagnoseUI.this.sJp < 95) {
                        NetworkDiagnoseUI.this.sJr.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.sJq.cHv();
                    AppMethodBeat.m2505o(26024);
                    return;
                case 2:
                    if (NetworkDiagnoseUI.this.sJp < 95) {
                        NetworkDiagnoseUI.this.sJr.setProgress(95);
                    }
                    NetworkDiagnoseUI.this.sJq.cHv();
                    AppMethodBeat.m2505o(26024);
                    return;
                case 3:
                    NetworkDiagnoseUI.this.sJr.setProgress(100);
                    NetworkDiagnoseUI.m78344a(NetworkDiagnoseUI.this, false);
                    AppMethodBeat.m2505o(26024);
                    return;
                case 4:
                    NetworkDiagnoseUI.this.sJr.setProgress(100);
                    NetworkDiagnoseUI.m78344a(NetworkDiagnoseUI.this, true);
                    break;
            }
            AppMethodBeat.m2505o(26024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$4 */
    class C294684 implements OnMenuItemClickListener {
        C294684() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(26026);
            NetworkDiagnoseUI.m78351g(NetworkDiagnoseUI.this);
            AppMethodBeat.m2505o(26026);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$1 */
    class C400091 implements C5015a {
        C400091() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26023);
            NetworkDiagnoseUI.this.sJp = NetworkDiagnoseUI.this.oAI + 1;
            NetworkDiagnoseUI.this.oAI = NetworkDiagnoseUI.this.sJp;
            if (NetworkDiagnoseUI.this.sJp < 100) {
                NetworkDiagnoseUI.this.sJr.setProgress(NetworkDiagnoseUI.this.sJp);
                AppMethodBeat.m2505o(26023);
                return true;
            }
            NetworkDiagnoseUI.this.sJr.setProgress(100);
            AppMethodBeat.m2505o(26023);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$6 */
    class C437106 implements C1835a {

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$6$3 */
        class C224373 implements C29465b {
            C224373() {
            }

            public final void cHx() {
                AppMethodBeat.m2504i(26030);
                NetworkDiagnoseUI.this.handler.sendEmptyMessage(3);
                AppMethodBeat.m2505o(26030);
            }
        }

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$6$1 */
        class C294691 implements C22429d {
            C294691() {
            }

            public final void arL() {
                AppMethodBeat.m2504i(26028);
                NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(2, 500);
                AppMethodBeat.m2505o(26028);
            }
        }

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$6$2 */
        class C294702 implements C22430e {
            C294702() {
            }

            public final void cHz() {
                AppMethodBeat.m2504i(26029);
                NetworkDiagnoseUI.this.handler.sendEmptyMessageDelayed(1, 500);
                AppMethodBeat.m2505o(26029);
            }
        }

        /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$6$4 */
        class C400104 implements C22428c {
            C400104() {
            }

            public final void cHy() {
                AppMethodBeat.m2504i(26031);
                NetworkDiagnoseUI.this.handler.sendEmptyMessage(4);
                AppMethodBeat.m2505o(26031);
            }
        }

        C437106() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(26032);
            if (c1902e == null) {
                AppMethodBeat.m2505o(26032);
                return;
            }
            NetworkDiagnoseUI.this.sJq = new C43709a(C1853r.m3846Yz());
            NetworkDiagnoseUI.this.sJq.mo69392c(c1902e.getIPsString(true), true);
            NetworkDiagnoseUI.this.sJq.mo69392c(c1902e.getIPsString(false), false);
            NetworkDiagnoseUI.this.sJq.sIz = new C294691();
            NetworkDiagnoseUI.this.sJq.sIy = new C294702();
            NetworkDiagnoseUI.this.sJq.sIB = new C224373();
            NetworkDiagnoseUI.this.sJq.sIA = new C400104();
            C43709a d = NetworkDiagnoseUI.this.sJq;
            if (d.sIx == null || d.sIx.size() == 0) {
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "no iplist");
            } else {
                if (C43709a.sIt == null) {
                    C43709a.sIt = new C46314c();
                }
                C7305d.post(new C22431j(d, (byte) 0), "MMTraceRoute_start");
            }
            NetworkDiagnoseUI.this.sJs.mo16770ae(1200, 1200);
            AppMethodBeat.m2505o(26032);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$7 */
    class C437117 implements OnClickListener {
        C437117() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(26033);
            NetworkDiagnoseUI.m78349e(NetworkDiagnoseUI.this);
            NetworkDiagnoseUI.this.finish();
            AppMethodBeat.m2505o(26033);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.ui.NetworkDiagnoseUI$8 */
    class C437128 implements OnClickListener {
        C437128() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NetworkDiagnoseUI() {
        AppMethodBeat.m2504i(26034);
        AppMethodBeat.m2505o(26034);
    }

    /* renamed from: g */
    static /* synthetic */ void m78351g(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.m2504i(26043);
        networkDiagnoseUI.cHA();
        AppMethodBeat.m2505o(26043);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(26035);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(26035);
    }

    public final void initView() {
        AppMethodBeat.m2504i(26036);
        this.mnA = (TextView) findViewById(2131826338);
        this.sJr = (MMProgressBar) findViewById(2131826337);
        this.sJr.setOnProgressChangedListener(new C224363());
        setMMTitle("");
        setBackBtn(new C294684());
        new C7306ak().postDelayed(new C140085(), 200);
        AppMethodBeat.m2505o(26036);
    }

    public final int getLayoutId() {
        return 2130970299;
    }

    public void onPause() {
        AppMethodBeat.m2504i(26037);
        this.sJr.setAutoProgress(false);
        super.onPause();
        AppMethodBeat.m2505o(26037);
    }

    public void onResume() {
        AppMethodBeat.m2504i(26038);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            this.sJr.setAutoProgress(true);
            super.onResume();
            AppMethodBeat.m2505o(26038);
            return;
        }
        C23639t.m36492hO(this);
        AppMethodBeat.m2505o(26038);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(26039);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            cHA();
            AppMethodBeat.m2505o(26039);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(26039);
        return onKeyDown;
    }

    private void cHA() {
        AppMethodBeat.m2504i(26040);
        C30379h.m48428a((Context) this, (int) C25738R.string.at6, (int) C25738R.string.b5f, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new C437117(), new C437128());
        AppMethodBeat.m2505o(26040);
    }

    /* renamed from: e */
    static /* synthetic */ void m78349e(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.m2504i(26041);
        networkDiagnoseUI.sJs.stopTimer();
        if (networkDiagnoseUI.sJq != null) {
            networkDiagnoseUI.sJq.stop();
        }
        AppMethodBeat.m2505o(26041);
    }

    /* renamed from: h */
    static /* synthetic */ void m78352h(NetworkDiagnoseUI networkDiagnoseUI) {
        AppMethodBeat.m2504i(26044);
        C9638aw.m17182Rg().mo14541a(new C6668bk(new C437106()), 0);
        AppMethodBeat.m2505o(26044);
    }
}
