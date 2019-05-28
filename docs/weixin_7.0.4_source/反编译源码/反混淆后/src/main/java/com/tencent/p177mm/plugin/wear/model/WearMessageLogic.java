package com.tencent.p177mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.wear.model.p575e.C40184p;
import com.tencent.p177mm.plugin.wear.model.p575e.C40184p.C401831;
import com.tencent.p177mm.plugin.wear.model.p575e.C46394a;
import com.tencent.p177mm.plugin.wear.model.p576f.C40186d;
import com.tencent.p177mm.protocal.protobuf.cux;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.qqpinyin.voicerecoapi.C16135c;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.WearMessageLogic */
public class WearMessageLogic extends BroadcastReceiver {

    /* renamed from: com.tencent.mm.plugin.wear.model.WearMessageLogic$b */
    class C40178b extends C40186d {
        public int ctE;
        public int tXY;
        public int tXZ;
        public byte[] tYa;

        private C40178b() {
        }

        /* synthetic */ C40178b(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.m2504i(26323);
            switch (this.tXZ) {
                case CdnLogic.kMediaLittleAppPacket /*30001*/:
                    C40184p c40184p = C43841a.cUn().tXt.tXM;
                    int i = this.ctE;
                    byte[] bArr = this.tYa;
                    if (!c40184p.hkE.contains(Integer.valueOf(i))) {
                        cux cux = new cux();
                        try {
                            cux.parseFrom(bArr);
                        } catch (IOException e) {
                        }
                        if (c40184p.tYH != i) {
                            c40184p.reset();
                            c40184p.tYH = i;
                            C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", Integer.valueOf(c40184p.tYH));
                            C1173e.deleteFile(C40184p.tYC);
                            if (c40184p.tYF == null) {
                                c40184p.tYF = new C41768d();
                                c40184p.tYF.mo43824eo(C40184p.tYC);
                            }
                            if (c40184p.tYE == null) {
                                c40184p.tYE = new C16135c(1500000);
                                if (c40184p.tYE.dPU() != 0) {
                                    c40184p.tYI = -2;
                                    AppMethodBeat.m2505o(26323);
                                    return;
                                }
                            }
                            String str = cux.wyw;
                            if (c40184p.tYD == null) {
                                C5004al.m7441d(new C401831(str));
                            }
                            c40184p.mo63522a(i, cux);
                            break;
                        } else if (cux.xqY) {
                            C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", Integer.valueOf(i));
                            c40184p.reset();
                            AppMethodBeat.m2505o(26323);
                            return;
                        } else if (cux.xqX) {
                            c40184p.mo63522a(i, cux);
                            if (c40184p.tYF != null) {
                                c40184p.tYF.mo43820Fe();
                                c40184p.tYF = null;
                                C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (c40184p.tYE != null) {
                                c40184p.tYE.stop();
                                c40184p.tYE = null;
                                C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (c40184p.tYD != null) {
                                c40184p.tYD.fZa = true;
                                if (!c40184p.cRY) {
                                    C9638aw.m17182Rg().mo14541a(c40184p.tYD, 0);
                                }
                                c40184p.tYD = null;
                                C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                            }
                            AppMethodBeat.m2505o(26323);
                            return;
                        } else {
                            c40184p.mo63522a(i, cux);
                            AppMethodBeat.m2505o(26323);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(26323);
        }

        public final String getName() {
            return "LongConnectTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.WearMessageLogic$a */
    class C40179a extends C40186d {
        public int ctE;
        public int tXY;
        public int tXZ;
        public byte[] tYa;

        private C40179a() {
        }

        /* synthetic */ C40179a(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final void execute() {
            AppMethodBeat.m2504i(26321);
            C4990ab.m7417i("MicroMsg.Wear.WearMessageLogic", "handle message %s", toString());
            C46394a HL = C43841a.cUn().tXr.mo74593HL(this.tXZ);
            if (HL != null) {
                HL.mo74592d(this.tXY, this.ctE, this.tXZ, this.tYa);
            }
            AppMethodBeat.m2505o(26321);
        }

        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            AppMethodBeat.m2504i(26322);
            String format = String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.tXY), Integer.valueOf(this.tXZ), Integer.valueOf(this.ctE)});
            AppMethodBeat.m2505o(26322);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.WearMessageLogic$c */
    class C40180c extends C40186d {
        private C40180c() {
        }

        /* synthetic */ C40180c(WearMessageLogic wearMessageLogic, byte b) {
            this();
        }

        public final String getName() {
            return "RefreshConnectTask";
        }

        public final void execute() {
            AppMethodBeat.m2504i(26324);
            if (C43841a.cUn().tXt.cUt() != null) {
                C43841a.cUn().tXt.cUt().cUv();
            }
            AppMethodBeat.m2505o(26324);
        }
    }

    public WearMessageLogic() {
        AppMethodBeat.m2504i(26325);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        C4996ah.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
        AppMethodBeat.m2505o(26325);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        AppMethodBeat.m2504i(26326);
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                C40179a c40179a = new C40179a(this, (byte) 0);
                c40179a.tXY = i;
                c40179a.tXZ = extras.getInt("key_funid");
                c40179a.ctE = extras.getInt("key_sessionid");
                c40179a.tYa = extras.getByteArray("key_data");
                C46394a HL = C43841a.cUn().tXr.mo74593HL(c40179a.tXZ);
                if (HL != null) {
                    b = HL.mo26668HK(c40179a.tXZ);
                }
                if (b != (byte) 0) {
                    C5004al.m7441d(c40179a);
                    AppMethodBeat.m2505o(26326);
                    return;
                }
                C7305d.post(c40179a, "WearHttpMessageTask_" + c40179a.tXZ);
                AppMethodBeat.m2505o(26326);
                return;
            } else if (i == 2) {
                C40178b c40178b = new C40178b(this, (byte) 0);
                c40178b.tXY = i;
                c40178b.tXZ = extras.getInt("key_funid");
                c40178b.ctE = extras.getInt("key_sessionid");
                c40178b.tYa = extras.getByteArray("key_data");
                C43841a.cUn().tXz.mo69532a(c40178b);
                AppMethodBeat.m2505o(26326);
                return;
            } else if (i == 3) {
                C43841a.cUn().tXz.mo69532a(new C40180c(this, (byte) 0));
            }
        }
        AppMethodBeat.m2505o(26326);
    }
}
