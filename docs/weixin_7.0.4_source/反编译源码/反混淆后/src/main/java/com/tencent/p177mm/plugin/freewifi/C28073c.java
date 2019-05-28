package com.tencent.p177mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.plugin.freewifi.c */
public final class C28073c {
    public Lock aCZ;
    public Activity activity;
    public WifiManager bJj;
    public BroadcastReceiver broadcastReceiver;
    public Condition cbS;
    public boolean connected = false;
    public long ftP;
    public String gDC;
    public boolean mtH = false;
    public String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.c$1 */
    public class C119551 implements C28074a {
        final /* synthetic */ C28074a mtI;

        public C119551(C28074a c28074a) {
            this.mtI = c28074a;
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(20564);
            C4990ab.m7417i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", C34189m.m56063V(C28073c.this.activity.getIntent()), Integer.valueOf(C34189m.m56064W(C28073c.this.activity.getIntent())));
            this.mtI.onSuccess();
            AppMethodBeat.m2505o(20564);
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(20565);
            C4990ab.m7417i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", C34189m.m56063V(C28073c.this.activity.getIntent()), Integer.valueOf(C34189m.m56064W(C28073c.this.activity.getIntent())), Integer.valueOf(i));
            this.mtI.onFail(i);
            AppMethodBeat.m2505o(20565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$2 */
    static /* synthetic */ class C119562 {
        static final /* synthetic */ int[] mtK = new int[SupplicantState.values().length];

        static {
            AppMethodBeat.m2504i(20567);
            try {
                mtK[SupplicantState.ASSOCIATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mtK[SupplicantState.ASSOCIATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mtK[SupplicantState.AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mtK[SupplicantState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                mtK[SupplicantState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mtK[SupplicantState.DORMANT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mtK[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                mtK[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                mtK[SupplicantState.INACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                mtK[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                mtK[SupplicantState.INVALID.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                mtK[SupplicantState.SCANNING.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                mtK[SupplicantState.UNINITIALIZED.ordinal()] = 13;
                AppMethodBeat.m2505o(20567);
            } catch (NoSuchFieldError e13) {
                AppMethodBeat.m2505o(20567);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$a */
    public interface C28074a {
        void onFail(int i);

        void onSuccess();
    }

    public C28073c(String str, Activity activity, String str2) {
        AppMethodBeat.m2504i(20568);
        this.activity = activity;
        this.ftP = 30000;
        this.ssid = str;
        this.gDC = str2;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        AppMethodBeat.m2505o(20568);
    }

    public final void byc() {
        AppMethodBeat.m2504i(20569);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.m2505o(20569);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.m2505o(20569);
        }
    }
}
