package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C41768d;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1321d.C35555c;
import com.tencent.p177mm.plugin.wear.model.p576f.C29724c;
import com.tencent.p177mm.protocal.protobuf.cux;
import com.tencent.p177mm.protocal.protobuf.cuy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.qqpinyin.voicerecoapi.C16135c;
import com.tencent.qqpinyin.voicerecoapi.C16135c.C16136a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wear.model.e.p */
public final class C40184p implements C1202f {
    public static final String tYC = (C5128ac.eSj + "tmp_wearvoicetotext.spx");
    public boolean cRY = false;
    public LinkedList<Integer> hkE = new LinkedList();
    public C35555c tYD;
    public C16135c tYE;
    public C41768d tYF;
    private int tYG = 0;
    public int tYH;
    public int tYI;

    /* renamed from: com.tencent.mm.plugin.wear.model.e.p$a */
    class C4507a extends C29724c {
        public int ctE;
        public int tXY = 2;
        public int tXZ;
        public cuy tYK;

        public C4507a(int i, cuy cuy) {
            this.ctE = i;
            this.tXZ = CdnLogic.kMediaLittleAppPacket;
            this.tYK = cuy;
        }

        public final void send() {
            AppMethodBeat.m2504i(26420);
            try {
                byte[] bC = C43841a.cUn().tXt.mo56292bC(this.tYK.toByteArray());
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
                    C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.tXZ), Integer.valueOf(bC.length));
                    C43841a.cUn().tXt.mo56290bA(byteArrayOutputStream.toByteArray());
                    AppMethodBeat.m2505o(26420);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.tXY), Integer.valueOf(this.ctE), Integer.valueOf(this.tXZ));
                    AppMethodBeat.m2505o(26420);
                }
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
                AppMethodBeat.m2505o(26420);
            }
        }

        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e.p$1 */
    public class C401831 implements Runnable {
        final /* synthetic */ String ewn;

        public C401831(String str) {
            this.ewn = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(26419);
            C40184p.this.tYD = new C35555c(C40184p.tYC, this.ewn, C40184p.this.tYH);
            C9638aw.m17182Rg().mo14539a(349, C40184p.this);
            C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
            AppMethodBeat.m2505o(26419);
        }
    }

    public C40184p() {
        AppMethodBeat.m2504i(26421);
        AppMethodBeat.m2505o(26421);
    }

    static {
        AppMethodBeat.m2504i(26425);
        AppMethodBeat.m2505o(26425);
    }

    public final void reset() {
        AppMethodBeat.m2504i(26422);
        C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", Integer.valueOf(this.tYH));
        if (this.tYF != null) {
            this.tYF.mo43820Fe();
            this.tYF = null;
            C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.tYE != null) {
            this.tYE.stop();
            this.tYE = null;
            C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.tYD != null) {
            this.tYD.fZa = true;
            C9638aw.m17182Rg().mo14546b(349, (C1202f) this);
            C9638aw.m17182Rg().mo14547c(this.tYD);
            this.tYD = null;
        }
        this.tYI = 0;
        this.cRY = false;
        this.tYG = 0;
        this.tYH = -1;
        this.hkE.clear();
        AppMethodBeat.m2505o(26422);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26423);
        if (c1207m instanceof C35555c) {
            C35555c c35555c = (C35555c) c1207m;
            cuy cuy;
            if (i != 0 || i2 != 0) {
                C9638aw.m17182Rg().mo14546b(349, (C1202f) this);
                cuy = new cuy();
                cuy.wyw = c35555c.talker;
                cuy.wdK = "";
                cuy.vAS = -1;
                cuy.xqZ = false;
                C43841a.cUn().tXz.mo69532a(new C4507a(c35555c.ctE, cuy));
                AppMethodBeat.m2505o(26423);
                return;
            } else if (c35555c.tYt) {
                C9638aw.m17182Rg().mo14546b(349, (C1202f) this);
                cuy = new cuy();
                cuy.wyw = c35555c.talker;
                if (C5046bo.isNullOrNil(c35555c.tYs)) {
                    cuy.wdK = "";
                    cuy.vAS = -1;
                    cuy.xqZ = false;
                } else {
                    C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", c35555c.tYs);
                    cuy.wdK = c35555c.tYs;
                    cuy.vAS = 0;
                    cuy.xqZ = true;
                }
                C43841a.cUn().tXz.mo69532a(new C4507a(c35555c.ctE, cuy));
            }
        }
        AppMethodBeat.m2505o(26423);
    }

    /* renamed from: a */
    public final void mo63522a(int i, cux cux) {
        AppMethodBeat.m2504i(26424);
        if (cux.vHn == null) {
            C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            AppMethodBeat.m2505o(26424);
            return;
        }
        byte[] toByteArray = cux.vHn.toByteArray();
        this.tYG += this.tYF.mo43823a(new C32305a(toByteArray, cux.wdn), 0, false);
        C4990ab.m7417i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", Integer.valueOf(this.tYG));
        short[] sArr = new short[(cux.wdn / 2)];
        for (int i2 = 0; i2 < cux.wdn / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        C16136a c16136a = new C16136a();
        this.tYE.mo28643a(sArr, cux.wdn / 2, c16136a);
        C4990ab.m7416i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + c16136a.AqE);
        if (c16136a.AqE == 2) {
            this.tYI = 1;
        } else if (c16136a.AqE == 3) {
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
                C43841a.cUn().tXz.mo69532a(new C4507a(this.tYD.ctE, cuy));
                this.tYI = 0;
            }
        }
        if (!this.cRY && this.tYG > 3300) {
            this.cRY = true;
            C9638aw.m17182Rg().mo14541a(this.tYD, 0);
        }
        AppMethodBeat.m2505o(26424);
    }
}
