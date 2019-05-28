package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
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
    public class AnonymousClass1 implements a {
        final /* synthetic */ a mtI;

        public AnonymousClass1(a aVar) {
            this.mtI = aVar;
        }

        public final void onSuccess() {
            AppMethodBeat.i(20564);
            ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", m.V(c.this.activity.getIntent()), Integer.valueOf(m.W(c.this.activity.getIntent())));
            this.mtI.onSuccess();
            AppMethodBeat.o(20564);
        }

        public final void onFail(int i) {
            AppMethodBeat.i(20565);
            ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", m.V(c.this.activity.getIntent()), Integer.valueOf(m.W(c.this.activity.getIntent())), Integer.valueOf(i));
            this.mtI.onFail(i);
            AppMethodBeat.o(20565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] mtK = new int[SupplicantState.values().length];

        static {
            AppMethodBeat.i(20567);
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
                AppMethodBeat.o(20567);
            } catch (NoSuchFieldError e13) {
                AppMethodBeat.o(20567);
            }
        }
    }

    public interface a {
        void onFail(int i);

        void onSuccess();
    }

    public c(String str, Activity activity, String str2) {
        AppMethodBeat.i(20568);
        this.activity = activity;
        this.ftP = 30000;
        this.ssid = str;
        this.gDC = str2;
        this.aCZ = new ReentrantLock();
        this.cbS = this.aCZ.newCondition();
        this.bJj = (WifiManager) ah.getContext().getSystemService("wifi");
        AppMethodBeat.o(20568);
    }

    public final void byc() {
        AppMethodBeat.i(20569);
        try {
            this.activity.unregisterReceiver(this.broadcastReceiver);
            AppMethodBeat.o(20569);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(20569);
        }
    }
}
