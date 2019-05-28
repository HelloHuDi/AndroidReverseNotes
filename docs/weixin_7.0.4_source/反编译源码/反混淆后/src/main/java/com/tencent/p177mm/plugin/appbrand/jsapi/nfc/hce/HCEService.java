package com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@TargetApi(19)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService */
public class HCEService extends HostApduService {
    private String mAppId = null;

    public void onCreate() {
        AppMethodBeat.m2504i(137907);
        super.onCreate();
        C4990ab.m7416i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        AppMethodBeat.m2505o(137907);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(137908);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        C2326b.hSG.aEx();
        AppMethodBeat.m2505o(137908);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(137909);
        C4990ab.m7416i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", Long.valueOf(currentTimeMillis));
        int onStartCommand;
        if (intent == null) {
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.m2505o(137909);
            return onStartCommand;
        }
        try {
            C2326b c2326b = C2326b.hSG;
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("HCE_Result_Receiver");
            C4990ab.m7416i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
            c2326b.hSF = this;
            c2326b.f1248JF = resultReceiver;
            this.mAppId = intent.getStringExtra("key_appid");
            C2326b c2326b2 = C2326b.hSG;
            c2326b2.hSf = intent.getIntExtra("key_time_limit", 1500);
            if (c2326b2.hSf < 1500) {
                C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", Integer.valueOf(c2326b2.hSf), Integer.valueOf(1500));
                c2326b2.hSf = 1500;
            }
            if (c2326b2.hSf > 60000) {
                C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", Integer.valueOf(c2326b2.hSf), Integer.valueOf(60000));
                c2326b2.hSf = 60000;
            }
            C4990ab.m7417i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", Integer.valueOf(c2326b2.hSf));
            c2326b2 = C2326b.hSG;
            String str = this.mAppId;
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_aid_list");
            c2326b2.mAppId = str;
            c2326b2.hSx = stringArrayListExtra;
            C2326b.hSG.aEw();
            C2326b.hSG.hSy = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.HCEService", e, "under dos attack(?): invalid key_result_receiver", new Object[0]);
        }
        onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.m2505o(137909);
        return onStartCommand;
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        AppMethodBeat.m2504i(137910);
        C4990ab.m7417i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", C10498c.m18207ak(bArr));
        byte[] encode = Base64.encode(bArr, 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_apdu_command", new String(encode, StandardCharsets.UTF_8));
        C2326b.hSG.mo6199a(31, this.mAppId, bundle2);
        AppMethodBeat.m2505o(137910);
        return null;
    }

    public void onDeactivated(int i) {
        AppMethodBeat.m2504i(137911);
        C4990ab.m7417i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", Integer.valueOf(i));
        C2326b.hSG.hSA = false;
        C2326b.hSG.hSB = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i);
        C2326b.hSG.mo6202b(this.mAppId, 41, bundle);
        AppMethodBeat.m2505o(137911);
    }
}
