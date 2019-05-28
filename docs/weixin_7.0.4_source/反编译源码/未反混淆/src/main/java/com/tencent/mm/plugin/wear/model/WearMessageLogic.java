package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.AnonymousClass1;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.io.IOException;

public class WearMessageLogic extends BroadcastReceiver {

    class b extends d {
        public int ctE;
        public int tXY;
        public int tXZ;
        public byte[] tYa;

        private b() {
        }

        /* synthetic */ b(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.i(26323);
            switch (this.tXZ) {
                case CdnLogic.kMediaLittleAppPacket /*30001*/:
                    p pVar = a.cUn().tXt.tXM;
                    int i = this.ctE;
                    byte[] bArr = this.tYa;
                    if (!pVar.hkE.contains(Integer.valueOf(i))) {
                        cux cux = new cux();
                        try {
                            cux.parseFrom(bArr);
                        } catch (IOException e) {
                        }
                        if (pVar.tYH != i) {
                            pVar.reset();
                            pVar.tYH = i;
                            ab.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", Integer.valueOf(pVar.tYH));
                            e.deleteFile(p.tYC);
                            if (pVar.tYF == null) {
                                pVar.tYF = new com.tencent.mm.audio.d.d();
                                pVar.tYF.eo(p.tYC);
                            }
                            if (pVar.tYE == null) {
                                pVar.tYE = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
                                if (pVar.tYE.dPU() != 0) {
                                    pVar.tYI = -2;
                                    AppMethodBeat.o(26323);
                                    return;
                                }
                            }
                            String str = cux.wyw;
                            if (pVar.tYD == null) {
                                al.d(new AnonymousClass1(str));
                            }
                            pVar.a(i, cux);
                            break;
                        } else if (cux.xqY) {
                            ab.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", Integer.valueOf(i));
                            pVar.reset();
                            AppMethodBeat.o(26323);
                            return;
                        } else if (cux.xqX) {
                            pVar.a(i, cux);
                            if (pVar.tYF != null) {
                                pVar.tYF.Fe();
                                pVar.tYF = null;
                                ab.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (pVar.tYE != null) {
                                pVar.tYE.stop();
                                pVar.tYE = null;
                                ab.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (pVar.tYD != null) {
                                pVar.tYD.fZa = true;
                                if (!pVar.cRY) {
                                    aw.Rg().a(pVar.tYD, 0);
                                }
                                pVar.tYD = null;
                                ab.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                            }
                            AppMethodBeat.o(26323);
                            return;
                        } else {
                            pVar.a(i, cux);
                            AppMethodBeat.o(26323);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(26323);
        }

        public final String getName() {
            return "LongConnectTask";
        }
    }

    class a extends d {
        public int ctE;
        public int tXY;
        public int tXZ;
        public byte[] tYa;

        private a() {
        }

        /* synthetic */ a(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.i(26321);
            ab.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", toString());
            com.tencent.mm.plugin.wear.model.e.a HL = a.cUn().tXr.HL(this.tXZ);
            if (HL != null) {
                HL.d(this.tXY, this.ctE, this.tXZ, this.tYa);
            }
            AppMethodBeat.o(26321);
        }

        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            AppMethodBeat.i(26322);
            String format = String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.tXY), Integer.valueOf(this.tXZ), Integer.valueOf(this.ctE)});
            AppMethodBeat.o(26322);
            return format;
        }
    }

    class c extends d {
        private c() {
        }

        /* synthetic */ c(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final String getName() {
            return "RefreshConnectTask";
        }

        public final void execute() {
            AppMethodBeat.i(26324);
            if (a.cUn().tXt.cUt() != null) {
                a.cUn().tXt.cUt().cUv();
            }
            AppMethodBeat.o(26324);
        }
    }

    public WearMessageLogic() {
        AppMethodBeat.i(26325);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        ah.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
        AppMethodBeat.o(26325);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        AppMethodBeat.i(26326);
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                a aVar = new a(this, (byte) 0);
                aVar.tXY = i;
                aVar.tXZ = extras.getInt("key_funid");
                aVar.ctE = extras.getInt("key_sessionid");
                aVar.tYa = extras.getByteArray("key_data");
                com.tencent.mm.plugin.wear.model.e.a HL = a.cUn().tXr.HL(aVar.tXZ);
                if (HL != null) {
                    b = HL.HK(aVar.tXZ);
                }
                if (b != (byte) 0) {
                    al.d(aVar);
                    AppMethodBeat.o(26326);
                    return;
                }
                com.tencent.mm.sdk.g.d.post(aVar, "WearHttpMessageTask_" + aVar.tXZ);
                AppMethodBeat.o(26326);
                return;
            } else if (i == 2) {
                b bVar = new b(this, (byte) 0);
                bVar.tXY = i;
                bVar.tXZ = extras.getInt("key_funid");
                bVar.ctE = extras.getInt("key_sessionid");
                bVar.tYa = extras.getByteArray("key_data");
                a.cUn().tXz.a(bVar);
                AppMethodBeat.o(26326);
                return;
            } else if (i == 3) {
                a.cUn().tXz.a(new c(this, (byte) 0));
            }
        }
        AppMethodBeat.o(26326);
    }
}
