package com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33382a;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C38362b;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b */
public final class C2326b {
    private static final byte[] hSE = new byte[]{(byte) 0, (byte) 0};
    public static C2326b hSG;
    private static long mStartTime = -1;
    /* renamed from: JF */
    ResultReceiver f1248JF;
    boolean hSA = false;
    boolean hSB = false;
    private C33382a hSC = new C2328a(this, (byte) 0);
    private C38362b hSD = new C2327b(this, (byte) 0);
    HostApduService hSF;
    int hSf;
    ArrayList<String> hSx;
    boolean hSy = false;
    private boolean hSz = true;
    String mAppId = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b$b */
    class C2327b implements C38362b {
        private C2327b() {
        }

        /* synthetic */ C2327b(C2326b c2326b, byte b) {
            this();
        }

        public final void onCreate() {
            AppMethodBeat.m2504i(137915);
            C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onCreate");
            AppMethodBeat.m2505o(137915);
        }

        public final void onResume() {
            AppMethodBeat.m2504i(137916);
            C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (C2326b.this.hSy) {
                C2326b.this.aEw();
                C2326b.this.hSy = false;
            }
            AppMethodBeat.m2505o(137916);
        }

        public final void onPause() {
            AppMethodBeat.m2504i(137917);
            C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onPause");
            C2326b.this.aEx();
            C2326b.this.hSy = true;
            AppMethodBeat.m2505o(137917);
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(137918);
            C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCELifeCycle AppBrandUI onDestroy");
            AppMethodBeat.m2505o(137918);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b$a */
    class C2328a implements C33382a {

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b$a$1 */
        class C23291 implements Runnable {
            C23291() {
            }

            public final void run() {
                AppMethodBeat.m2504i(137912);
                C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", Integer.valueOf(C2326b.this.hSf), Boolean.valueOf(C2326b.this.hSz));
                C2326b.this.hSB = true;
                C2326b.m4545a(C2326b.this, C2326b.hSE, true, C2326b.this.hSF);
                AppMethodBeat.m2505o(137912);
            }
        }

        private C2328a() {
        }

        /* synthetic */ C2328a(C2326b c2326b, byte b) {
            this();
        }

        /* renamed from: cl */
        public final void mo6207cl(String str, String str2) {
            AppMethodBeat.m2504i(137913);
            C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", str, str2);
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                C4990ab.m7412e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
                AppMethodBeat.m2505o(137913);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", str2);
            C2326b.this.mo6202b(str, 31, bundle);
            C2326b.this.hSz = true;
            if (C2326b.this.hSA) {
                if (C2326b.this.hSB) {
                    C4990ab.m7420w("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
                    C2326b.m4545a(C2326b.this, C2326b.hSE, true, C2326b.this.hSF);
                    C2326b.this.hSB = false;
                }
                AppMethodBeat.m2505o(137913);
                return;
            }
            C2326b.this.hSA = true;
            C2326b.this.hSB = false;
            C2326b.mStartTime = System.currentTimeMillis();
            C45673m.aNS().mo10310m(new C23291(), (long) C2326b.this.hSf);
            AppMethodBeat.m2505o(137913);
        }

        /* renamed from: cm */
        public final void mo6208cm(String str, String str2) {
            AppMethodBeat.m2504i(137914);
            if (C2326b.this.mAppId == null || !C2326b.this.mAppId.equals(str) || C5046bo.isNullOrNil(str2)) {
                C4990ab.m7413e("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", C2326b.this.mAppId, str, str2);
                AppMethodBeat.m2505o(137914);
                return;
            }
            C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", str, str2, C10498c.m18207ak(Base64.decode(str2, 2)), Boolean.valueOf(C2326b.this.hSz));
            C2326b.m4545a(C2326b.this, r0, false, C2326b.this.hSF);
            AppMethodBeat.m2505o(137914);
        }
    }

    public C2326b() {
        AppMethodBeat.m2504i(137919);
        AppMethodBeat.m2505o(137919);
    }

    /* renamed from: a */
    static /* synthetic */ void m4545a(C2326b c2326b, byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.m2504i(137927);
        c2326b.m4546a(bArr, z, hostApduService);
        AppMethodBeat.m2505o(137927);
    }

    static {
        AppMethodBeat.m2504i(137928);
        hSG = null;
        hSG = new C2326b();
        AppMethodBeat.m2505o(137928);
    }

    /* renamed from: a */
    public final void mo6199a(int i, String str, Bundle bundle) {
        AppMethodBeat.m2504i(137920);
        C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", Integer.valueOf(i));
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
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
            case 22:
                if (this.hSD != null) {
                    this.hSD.onResume();
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
            case 23:
                if (this.hSD != null) {
                    this.hSD.onPause();
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
            case 24:
                if (this.hSD != null) {
                    this.hSD.onDestroy();
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
            case 31:
                if (this.hSC != null) {
                    this.hSC.mo6207cl(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
            case 32:
                if (this.hSC != null) {
                    this.hSC.mo6208cm(str, bundle.getString("key_apdu_command"));
                    AppMethodBeat.m2505o(137920);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(137920);
    }

    @TargetApi(21)
    public final void aEw() {
        AppMethodBeat.m2504i(137921);
        if (this.hSx == null || this.hSF == null) {
            C4990ab.m7412e("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
            AppMethodBeat.m2505o(137921);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.hSF);
        if (defaultAdapter == null) {
            C4990ab.m7412e("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
            AppMethodBeat.m2505o(137921);
        } else if (VERSION.SDK_INT < 21) {
            C4990ab.m7413e("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", Integer.valueOf(VERSION.SDK_INT));
            AppMethodBeat.m2505o(137921);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this.hSF, this.hSF.getClass());
                    C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", Boolean.valueOf(instance.registerAidsForService(componentName, "payment", this.hSx)));
                    if (instance.registerAidsForService(componentName, "payment", this.hSx)) {
                        m4554ep(true);
                        List aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i = 0; i < aidsForService.size(); i++) {
                                C4990ab.m7412e("MicroMsg.HCEServiceMgr", "dynamicAIDList aid=" + ((String) aidsForService.get(i)));
                            }
                        }
                        AppMethodBeat.m2505o(137921);
                        return;
                    }
                    m4554ep(false);
                    AppMethodBeat.m2505o(137921);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.HCEServiceMgr", e, "alvinluo HCEService register aid exception", new Object[0]);
                    m4554ep(false);
                }
            }
            AppMethodBeat.m2505o(137921);
        }
    }

    /* renamed from: ep */
    private void m4554ep(boolean z) {
        AppMethodBeat.m2504i(137922);
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        mo6202b(this.mAppId, 12, bundle);
        AppMethodBeat.m2505o(137922);
    }

    /* renamed from: b */
    public final void mo6202b(String str, int i, Bundle bundle) {
        AppMethodBeat.m2504i(137923);
        bundle.putString("key_appid", str);
        bundle.putInt("key_event_type", i);
        m4544B(bundle);
        AppMethodBeat.m2505o(137923);
    }

    @TargetApi(21)
    public final void aEx() {
        AppMethodBeat.m2504i(137924);
        if (this.hSF == null) {
            C4990ab.m7412e("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
            AppMethodBeat.m2505o(137924);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.hSF);
        if (defaultAdapter == null) {
            AppMethodBeat.m2505o(137924);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(137924);
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this.hSF, this.hSF.getClass());
                C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
            AppMethodBeat.m2505o(137924);
        }
    }

    /* renamed from: a */
    private synchronized void m4546a(byte[] bArr, boolean z, HostApduService hostApduService) {
        AppMethodBeat.m2504i(137925);
        C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", Boolean.valueOf(z), Boolean.valueOf(this.hSz));
        if (this.hSz) {
            this.hSz = false;
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send response command time: %d, cost: %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime));
            if (hostApduService != null) {
                hostApduService.sendResponseApdu(bArr);
            } else {
                C4990ab.m7412e("MicroMsg.HCEServiceMgr", "alvinluo sendResponseCommandToSystem hceService is null");
            }
            if (z) {
                C4990ab.m7417i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", this.mAppId);
                ((C33458b) C37384e.m62986C(C33458b.class)).mo53943X(14838, r1);
            }
        }
        AppMethodBeat.m2505o(137925);
    }

    /* renamed from: B */
    private void m4544B(Bundle bundle) {
        AppMethodBeat.m2504i(137926);
        C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
        if (this.f1248JF != null) {
            this.f1248JF.send(10002, bundle);
        }
        AppMethodBeat.m2505o(137926);
    }
}
