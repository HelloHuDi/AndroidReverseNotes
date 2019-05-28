package com.tencent.p177mm.plugin.wear.model.p575e;

import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C45163c;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p230g.p231a.C42073vg;
import com.tencent.p177mm.p230g.p231a.C42076vi;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.plugin.wear.model.p576f.C40186d;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.C15324cdn;
import com.tencent.p177mm.protocal.protobuf.ctv;
import com.tencent.p177mm.protocal.protobuf.cup;
import com.tencent.p177mm.protocal.protobuf.cuq;
import com.tencent.p177mm.protocal.protobuf.cur;
import com.tencent.p177mm.protocal.protobuf.cus;
import com.tencent.p177mm.protocal.protobuf.cuw;
import com.tencent.p177mm.protocal.protobuf.cwb;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ugc.TXRecordCommon;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.m */
public final class C4505m extends C46394a {

    /* renamed from: com.tencent.mm.plugin.wear.model.e.m$a */
    static class C4506a extends C40186d {
        private cus tYB;

        public C4506a(cus cus) {
            this.tYB = cus;
        }

        public final void execute() {
            AppMethodBeat.m2504i(26411);
            String uP = C32850q.m53729uP(this.tYB.wyw);
            C4990ab.m7417i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", uP);
            C4990ab.m7417i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", C32850q.m53707U(uP, false));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.tYB.vHn.toByteArray());
            C45163c c45163c = new C45163c(TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_16000);
            c45163c.mo43824eo(r0);
            byte[] bArr = new byte[320];
            int i = 0;
            while (true) {
                try {
                    i = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e) {
                }
                if (i > 0) {
                    c45163c.mo43823a(new C32305a(bArr, i), 0, false);
                } else {
                    c45163c.mo43820Fe();
                    C4990ab.m7416i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    C32850q.m53717ah(uP, (int) this.tYB.xqQ);
                    C26500m.amc().run();
                    C4990ab.m7416i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().apb(this.tYB.wyw);
                    AppMethodBeat.m2505o(26411);
                    return;
                }
            }
        }

        public final String getName() {
            return "SendVioceMsgTask";
        }
    }

    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26412);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        AppMethodBeat.m2505o(26412);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HJ */
    public final boolean mo9570HJ(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26413);
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT /*11022*/:
                cus cus = new cus();
                try {
                    cus.parseFrom(bArr);
                } catch (IOException e) {
                }
                C43841a.cUn().tXz.mo69532a(new C4506a(cus));
                C43841a.cUn().tXv.adt(cus.wyw);
                C46393a.m87276gn(2, cus.Scene);
                C46393a.m87275HH(2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
                cur cur = new cur();
                try {
                    cur.parseFrom(bArr);
                } catch (IOException e2) {
                }
                C12519g.bOk().mo46456F(cur.wyw, cur.wdK, C1855t.m3925nK(cur.wyw));
                C9638aw.m17190ZK();
                C18628c.m29083XR().apb(cur.wyw);
                C46393a.m87276gn(3, cur.Scene);
                C46393a.m87275HH(5);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER /*11024*/:
                cup cup = new cup();
                try {
                    cup.parseFrom(bArr);
                } catch (IOException e3) {
                }
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(C4996ah.getContext(), cup.wyw, cup.wdO);
                C9638aw.m17190ZK();
                C18628c.m29083XR().apb(cup.wyw);
                C46393a.m87276gn(7, cup.Scene);
                C46393a.m87275HH(3);
                break;
            case 11025:
                cuq cuq = new cuq();
                try {
                    cuq.parseFrom(bArr);
                } catch (IOException e4) {
                }
                C12519g.bOk().mo46456F(cuq.wyw, cuq.wdK, C1855t.m3925nK(cuq.wyw));
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(C4996ah.getContext(), cuq.wyw, cuq.wdO);
                C9638aw.m17190ZK();
                C18628c.m29083XR().apb(cuq.wyw);
                C46393a.m87276gn(8, cuq.Scene);
                C46393a.m87275HH(4);
                break;
            case 11026:
                cuw cuw = new cuw();
                try {
                    cuw.parseFrom(bArr);
                } catch (IOException e5) {
                }
                C43841a.cUn();
                ctv ctv = C43841a.cUn().tXt.tXK.tYz;
                if (ctv != null) {
                    C4990ab.m7417i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", Integer.valueOf(cuw.xqV), C14835h.formatTime("yyyy-MM-dd HH:mm:ss", cuw.xqW / 1000));
                    cwb cwb = new cwb();
                    C15324cdn c15324cdn = new C15324cdn();
                    c15324cdn.jCs = cuw.xqV > 0 ? cuw.xqV : 0;
                    c15324cdn.Timestamp = (int) (cuw.xqW / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(cuw.xqW);
                    c15324cdn.xdi = instance.get(1);
                    c15324cdn.xdj = instance.get(2) + 1;
                    c15324cdn.xdk = instance.get(5);
                    c15324cdn.xdl = instance.get(11);
                    c15324cdn.xdm = instance.get(12);
                    c15324cdn.xdn = instance.get(13);
                    cwb.xrV.add(c15324cdn);
                    C42076vi c42076vi = new C42076vi();
                    try {
                        c42076vi.cSq.data = cwb.toByteArray();
                    } catch (IOException e6) {
                    }
                    c42076vi.cSq.cuy = 4;
                    c42076vi.cSq.ceI = ctv.xqs;
                    c42076vi.cSq.cws = "gh_43f2581f6fd6";
                    C4879a.xxA.mo10055m(c42076vi);
                    break;
                }
                C4990ab.m7412e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (C43841a.cUn().tXt.cUs() && C26373g.m41964Nu().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    C4883b c42073vg = new C42073vg();
                    c42073vg.cSe.action = 1;
                    c42073vg.cSe.cuQ = j;
                    C4879a.xxA.mo10048a(c42073vg, Looper.getMainLooper());
                    C46393a.m87276gn(11, 0);
                    C46393a.m87275HH(11);
                    break;
                }
                AppMethodBeat.m2505o(26413);
                return null;
        }
        AppMethodBeat.m2505o(26413);
        return null;
    }
}
