package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public final class b {
    private static final byte[] hSE = new byte[]{(byte) 0, (byte) 0};
    public static b hSG;
    private static long mStartTime = -1;
    ResultReceiver JF;
    boolean hSA = false;
    boolean hSB = false;
    private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a hSC = new a(this, (byte) 0);
    private com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b hSD = new b(this, (byte) 0);
    HostApduService hSF;
    int hSf;
    ArrayList<String> hSx;
    boolean hSy = false;
    private boolean hSz = true;
    String mAppId = null;

    class b implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.b {
        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final void onCreate() {
            AppMethodBeat.i(137915);
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
            AppMethodBeat.o(137915);
        }

        public final void onResume() {
            AppMethodBeat.i(137916);
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (b.this.hSy) {
                b.this.aEw();
                b.this.hSy = false;
            }
            AppMethodBeat.o(137916);
        }

        public final void onPause() {
            AppMethodBeat.i(137917);
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
            b.this.aEx();
            b.this.hSy = true;
            AppMethodBeat.o(137917);
        }

        public final void onDestroy() {
            AppMethodBeat.i(137918);
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
            AppMethodBeat.o(137918);
        }
    }

    class a implements com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void cl(String str, String str2) {
            AppMethodBeat.i(137913);
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", str, str2);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
                AppMethodBeat.o(137913);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", str2);
            b.this.b(str, 31, bundle);
            b.this.hSz = true;
            if (b.this.hSA) {
                if (b.this.hSB) {
                    ab.w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
                    b.a(b.this, b.hSE, true, b.this.hSF);
                    b.this.hSB = false;
                }
                AppMethodBeat.o(137913);
                return;
            }
            b.this.hSA = true;
            b.this.hSB = false;
            b.mStartTime = System.currentTimeMillis();
            m.aNS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137912);
                    ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", Integer.valueOf(b.this.hSf), Boolean.valueOf(b.this.hSz));
                    b.this.hSB = true;
                    b.a(b.this, b.hSE, true, b.this.hSF);
                    AppMethodBeat.o(137912);
                }
            }, (long) b.this.hSf);
            AppMethodBeat.o(137913);
        }

        public final void cm(String str, String str2) {
            AppMethodBeat.i(137914);
            if (b.this.mAppId == null || !b.this.mAppId.equals(str) || bo.isNullOrNil(str2)) {
                ab.e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", b.this.mAppId, str, str2);
                AppMethodBeat.o(137914);
                return;
            }
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", str, str2, c.ak(Base64.decode(str2, 2)), Boolean.valueOf(b.this.hSz));
            b.a(b.this, r0, false, b.this.hSF);
            AppMethodBeat.o(137914);
        }
    }

    public b() {
        AppMethodBeat.i(137919);
        AppMethodBeat.o(137919);
    }

    static /* synthetic */ void a(b bVar, byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.i(137927);
        bVar.a(bArr, z, hostApduService);
        AppMethodBeat.o(137927);
    }

    static {
        AppMethodBeat.i(137928);
        hSG = null;
        hSG = new b();
        AppMethodBeat.o(137928);
    }

    public final void a(int i, String str, Bundle bundle) {
        AppMethodBeat.i(137920);
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", Integer.valueOf(i));
        switch (i) {
            case 13:
                aEx();
                if (this.hSF != null) {
                    this.hSF.stopSelf();
                    break;
                }
                break;
            case 21:
                if (this.hSD != null) {
                    this.hSD.onCreate();
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
            case 22:
                if (this.hSD != null) {
                    this.hSD.onResume();
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
            case 23:
                if (this.hSD != null) {
                    this.hSD.onPause();
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
            case 24:
                if (this.hSD != null) {
                    this.hSD.onDestroy();
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
            case 31:
                if (this.hSC != null) {
                    this.hSC.cl(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
            case 32:
                if (this.hSC != null) {
                    this.hSC.cm(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.o(137920);
                    return;
                }
                break;
        }
        AppMethodBeat.o(137920);
    }

    @TargetApi(21)
    public final void aEw() {
        AppMethodBeat.i(137921);
        if (this.hSx == null || this.hSF == null) {
            ab.e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
            AppMethodBeat.o(137921);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.hSF);
        if (defaultAdapter == null) {
            ab.e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
            AppMethodBeat.o(137921);
        } else if (VERSION.SDK_INT < 21) {
            ab.e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.o(137921);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this.hSF, this.hSF.getClass());
                    ab.i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", Boolean.valueOf(instance.registerAidsForService(componentName, "payment", this.hSx)));
                    if (instance.registerAidsForService(componentName, "payment", this.hSx)) {
                        ep(true);
                        List aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i = 0; i < aidsForService.size(); i++) {
                                ab.e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + ((String) aidsForService.get(i)));
                            }
                        }
                        AppMethodBeat.o(137921);
                        return;
                    }
                    ep(false);
                    AppMethodBeat.o(137921);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.HCEServiceMgr", e, "alvinluo HCEService register aid exception", new Object[0]);
                    ep(false);
                }
            }
            AppMethodBeat.o(137921);
        }
    }

    private void ep(boolean z) {
        AppMethodBeat.i(137922);
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        b(this.mAppId, 12, bundle);
        AppMethodBeat.o(137922);
    }

    public final void b(String str, int i, Bundle bundle) {
        AppMethodBeat.i(137923);
        bundle.putString("key_appid", str);
        bundle.putInt("key_event_type", i);
        B(bundle);
        AppMethodBeat.o(137923);
    }

    @TargetApi(21)
    public final void aEx() {
        AppMethodBeat.i(137924);
        if (this.hSF == null) {
            ab.e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
            AppMethodBeat.o(137924);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.hSF);
        if (defaultAdapter == null) {
            AppMethodBeat.o(137924);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(137924);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this.hSF, this.hSF.getClass());
                ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
            AppMethodBeat.o(137924);
        }
    }

    private synchronized void a(byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.i(137925);
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", Boolean.valueOf(z), Boolean.valueOf(this.hSz));
        if (this.hSz) {
            this.hSz = false;
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send response command time: %d, cost: %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime));
            if (hostApduService != null) {
                hostApduService.sendResponseApdu(bArr);
            } else {
                ab.e("MicroMsg.HCEServiceMgr", "alvinluo sendResponseCommandToSystem hceService is null");
            }
            if (z) {
                ab.i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", this.mAppId);
                ((com.tencent.mm.plugin.appbrand.n.b) e.C(com.tencent.mm.plugin.appbrand.n.b.class)).X(14838, r1);
            }
        }
        AppMethodBeat.o(137925);
    }

    private void B(Bundle bundle) {
        AppMethodBeat.i(137926);
        ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
        if (this.JF != null) {
            this.JF.send(10002, bundle);
        }
        AppMethodBeat.o(137926);
    }
}
