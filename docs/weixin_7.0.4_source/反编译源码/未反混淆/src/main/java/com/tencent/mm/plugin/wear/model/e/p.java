package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.d.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public final class p implements f {
    public static final String tYC = (ac.eSj + "tmp_wearvoicetotext.spx");
    public boolean cRY = false;
    public LinkedList<Integer> hkE = new LinkedList();
    public c tYD;
    public com.tencent.qqpinyin.voicerecoapi.c tYE;
    public d tYF;
    private int tYG = 0;
    public int tYH;
    public int tYI;

    class a extends com.tencent.mm.plugin.wear.model.f.c {
        public int ctE;
        public int tXY = 2;
        public int tXZ;
        public cuy tYK;

        public a(int i, cuy cuy) {
            this.ctE = i;
            this.tXZ = CdnLogic.kMediaLittleAppPacket;
            this.tYK = cuy;
        }

        public final void send() {
            AppMethodBeat.i(26420);
            try {
                byte[] bC = com.tencent.mm.plugin.wear.model.a.cUn().tXt.bC(this.tYK.toByteArray());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.tXY);
                    dataOutputStream.writeInt(this.ctE);
                    dataOutputStream.writeInt(this.tXZ);
                    if (bC == null || bC.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(bC.length);
                        dataOutputStream.write(bC);
                    }
                    bC = byteArrayOutputStream.toByteArray();
                    ab.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.tXZ), Integer.valueOf(bC.length));
                    com.tencent.mm.plugin.wear.model.a.cUn().tXt.bA(byteArrayOutputStream.toByteArray());
                    AppMethodBeat.o(26420);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.tXY), Integer.valueOf(this.ctE), Integer.valueOf(this.tXZ));
                    AppMethodBeat.o(26420);
                }
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
                AppMethodBeat.o(26420);
            }
        }

        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e.p$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ewn;

        public AnonymousClass1(String str) {
            this.ewn = str;
        }

        public final void run() {
            AppMethodBeat.i(26419);
            p.this.tYD = new c(p.tYC, this.ewn, p.this.tYH);
            aw.Rg().a(349, p.this);
            ab.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
            AppMethodBeat.o(26419);
        }
    }

    public p() {
        AppMethodBeat.i(26421);
        AppMethodBeat.o(26421);
    }

    static {
        AppMethodBeat.i(26425);
        AppMethodBeat.o(26425);
    }

    public final void reset() {
        AppMethodBeat.i(26422);
        ab.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", Integer.valueOf(this.tYH));
        if (this.tYF != null) {
            this.tYF.Fe();
            this.tYF = null;
            ab.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.tYE != null) {
            this.tYE.stop();
            this.tYE = null;
            ab.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.tYD != null) {
            this.tYD.fZa = true;
            aw.Rg().b(349, (f) this);
            aw.Rg().c(this.tYD);
            this.tYD = null;
        }
        this.tYI = 0;
        this.cRY = false;
        this.tYG = 0;
        this.tYH = -1;
        this.hkE.clear();
        AppMethodBeat.o(26422);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26423);
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            cuy cuy;
            if (i != 0 || i2 != 0) {
                aw.Rg().b(349, (f) this);
                cuy = new cuy();
                cuy.wyw = cVar.talker;
                cuy.wdK = "";
                cuy.vAS = -1;
                cuy.xqZ = false;
                com.tencent.mm.plugin.wear.model.a.cUn().tXz.a(new a(cVar.ctE, cuy));
                AppMethodBeat.o(26423);
                return;
            } else if (cVar.tYt) {
                aw.Rg().b(349, (f) this);
                cuy = new cuy();
                cuy.wyw = cVar.talker;
                if (bo.isNullOrNil(cVar.tYs)) {
                    cuy.wdK = "";
                    cuy.vAS = -1;
                    cuy.xqZ = false;
                } else {
                    ab.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", cVar.tYs);
                    cuy.wdK = cVar.tYs;
                    cuy.vAS = 0;
                    cuy.xqZ = true;
                }
                com.tencent.mm.plugin.wear.model.a.cUn().tXz.a(new a(cVar.ctE, cuy));
            }
        }
        AppMethodBeat.o(26423);
    }

    public final void a(int i, cux cux) {
        AppMethodBeat.i(26424);
        if (cux.vHn == null) {
            ab.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            AppMethodBeat.o(26424);
            return;
        }
        byte[] toByteArray = cux.vHn.toByteArray();
        this.tYG += this.tYF.a(new com.tencent.mm.audio.b.g.a(toByteArray, cux.wdn), 0, false);
        ab.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", Integer.valueOf(this.tYG));
        short[] sArr = new short[(cux.wdn / 2)];
        for (int i2 = 0; i2 < cux.wdn / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
        this.tYE.a(sArr, cux.wdn / 2, aVar);
        ab.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + aVar.AqE);
        if (aVar.AqE == 2) {
            this.tYI = 1;
        } else if (aVar.AqE == 3) {
            this.tYI = 2;
        }
        if (this.tYI != 0) {
            if (this.tYI < 0) {
                if (this.hkE.size() > 10) {
                    this.hkE.removeLast();
                }
                this.hkE.addFirst(Integer.valueOf(i));
            }
            if (this.tYI == 1) {
                cuy cuy = new cuy();
                cuy.wyw = this.tYD.talker;
                cuy.wdK = "";
                cuy.vAS = this.tYI;
                cuy.xqZ = true;
                com.tencent.mm.plugin.wear.model.a.cUn().tXz.a(new a(this.tYD.ctE, cuy));
                this.tYI = 0;
            }
        }
        if (!this.cRY && this.tYG > 3300) {
            this.cRY = true;
            aw.Rg().a(this.tYD, 0);
        }
        AppMethodBeat.o(26424);
    }
}
