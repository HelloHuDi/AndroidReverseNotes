package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@TargetApi(19)
public class HCEService extends HostApduService {
    private String mAppId = null;

    public void onCreate() {
        AppMethodBeat.i(137907);
        super.onCreate();
        ab.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        AppMethodBeat.o(137907);
    }

    public void onDestroy() {
        AppMethodBeat.i(137908);
        super.onDestroy();
        ab.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        b.hSG.aEx();
        AppMethodBeat.o(137908);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(137909);
        ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", Long.valueOf(currentTimeMillis));
        int onStartCommand;
        if (intent == null) {
            onStartCommand = super.onStartCommand(intent, i, i2);
            AppMethodBeat.o(137909);
            return onStartCommand;
        }
        try {
            b bVar = b.hSG;
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("HCE_Result_Receiver");
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
            bVar.hSF = this;
            bVar.JF = resultReceiver;
            this.mAppId = intent.getStringExtra("key_appid");
            b bVar2 = b.hSG;
            bVar2.hSf = intent.getIntExtra("key_time_limit", 1500);
            if (bVar2.hSf < 1500) {
                ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", Integer.valueOf(bVar2.hSf), Integer.valueOf(1500));
                bVar2.hSf = 1500;
            }
            if (bVar2.hSf > 60000) {
                ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", Integer.valueOf(bVar2.hSf), Integer.valueOf(60000));
                bVar2.hSf = 60000;
            }
            ab.i("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", Integer.valueOf(bVar2.hSf));
            bVar2 = b.hSG;
            String str = this.mAppId;
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_aid_list");
            bVar2.mAppId = str;
            bVar2.hSx = stringArrayListExtra;
            b.hSG.aEw();
            b.hSG.hSy = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.HCEService", e, "under dos attack(?): invalid key_result_receiver", new Object[0]);
        }
        onStartCommand = super.onStartCommand(intent, i, i2);
        AppMethodBeat.o(137909);
        return onStartCommand;
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        AppMethodBeat.i(137910);
        ab.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", c.ak(bArr));
        byte[] encode = Base64.encode(bArr, 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_apdu_command", new String(encode, StandardCharsets.UTF_8));
        b.hSG.a(31, this.mAppId, bundle2);
        AppMethodBeat.o(137910);
        return null;
    }

    public void onDeactivated(int i) {
        AppMethodBeat.i(137911);
        ab.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", Integer.valueOf(i));
        b.hSG.hSA = false;
        b.hSG.hSB = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i);
        b.hSG.b(this.mAppId, 41, bundle);
        AppMethodBeat.o(137911);
    }
}
