package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.c;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ugc.TXRecordCommon;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {

    static class a extends d {
        private cus tYB;

        public a(cus cus) {
            this.tYB = cus;
        }

        public final void execute() {
            AppMethodBeat.i(26411);
            String uP = q.uP(this.tYB.wyw);
            ab.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", uP);
            ab.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", q.U(uP, false));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.tYB.vHn.toByteArray());
            c cVar = new c(TXRecordCommon.AUDIO_SAMPLERATE_8000, TXRecordCommon.AUDIO_SAMPLERATE_16000);
            cVar.eo(r0);
            byte[] bArr = new byte[320];
            int i = 0;
            while (true) {
                try {
                    i = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e) {
                }
                if (i > 0) {
                    cVar.a(new com.tencent.mm.audio.b.g.a(bArr, i), 0, false);
                } else {
                    cVar.Fe();
                    ab.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    q.ah(uP, (int) this.tYB.xqQ);
                    com.tencent.mm.modelvoice.m.amc().run();
                    ab.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    aw.ZK();
                    com.tencent.mm.model.c.XR().apb(this.tYB.wyw);
                    AppMethodBeat.o(26411);
                    return;
                }
            }
        }

        public final String getName() {
            return "SendVioceMsgTask";
        }
    }

    public final List<Integer> cUA() {
        AppMethodBeat.i(26412);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        AppMethodBeat.o(26412);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HJ(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26413);
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_OUT /*11022*/:
                cus cus = new cus();
                try {
                    cus.parseFrom(bArr);
                } catch (IOException e) {
                }
                com.tencent.mm.plugin.wear.model.a.cUn().tXz.a(new a(cus));
                com.tencent.mm.plugin.wear.model.a.cUn().tXv.adt(cus.wyw);
                com.tencent.mm.plugin.wear.model.c.a.gn(2, cus.Scene);
                com.tencent.mm.plugin.wear.model.c.a.HH(2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_USERLIST /*11023*/:
                cur cur = new cur();
                try {
                    cur.parseFrom(bArr);
                } catch (IOException e2) {
                }
                g.bOk().F(cur.wyw, cur.wdK, t.nK(cur.wyw));
                aw.ZK();
                com.tencent.mm.model.c.XR().apb(cur.wyw);
                com.tencent.mm.plugin.wear.model.c.a.gn(3, cur.Scene);
                com.tencent.mm.plugin.wear.model.c.a.HH(5);
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_NEED_REENTER /*11024*/:
                cup cup = new cup();
                try {
                    cup.parseFrom(bArr);
                } catch (IOException e3) {
                }
                ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(ah.getContext(), cup.wyw, cup.wdO);
                aw.ZK();
                com.tencent.mm.model.c.XR().apb(cup.wyw);
                com.tencent.mm.plugin.wear.model.c.a.gn(7, cup.Scene);
                com.tencent.mm.plugin.wear.model.c.a.HH(3);
                break;
            case 11025:
                cuq cuq = new cuq();
                try {
                    cuq.parseFrom(bArr);
                } catch (IOException e4) {
                }
                g.bOk().F(cuq.wyw, cuq.wdK, t.nK(cuq.wyw));
                ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(ah.getContext(), cuq.wyw, cuq.wdO);
                aw.ZK();
                com.tencent.mm.model.c.XR().apb(cuq.wyw);
                com.tencent.mm.plugin.wear.model.c.a.gn(8, cuq.Scene);
                com.tencent.mm.plugin.wear.model.c.a.HH(4);
                break;
            case 11026:
                cuw cuw = new cuw();
                try {
                    cuw.parseFrom(bArr);
                } catch (IOException e5) {
                }
                com.tencent.mm.plugin.wear.model.a.cUn();
                ctv ctv = com.tencent.mm.plugin.wear.model.a.cUn().tXt.tXK.tYz;
                if (ctv != null) {
                    ab.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", Integer.valueOf(cuw.xqV), h.formatTime("yyyy-MM-dd HH:mm:ss", cuw.xqW / 1000));
                    cwb cwb = new cwb();
                    cdn cdn = new cdn();
                    cdn.jCs = cuw.xqV > 0 ? cuw.xqV : 0;
                    cdn.Timestamp = (int) (cuw.xqW / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(cuw.xqW);
                    cdn.xdi = instance.get(1);
                    cdn.xdj = instance.get(2) + 1;
                    cdn.xdk = instance.get(5);
                    cdn.xdl = instance.get(11);
                    cdn.xdm = instance.get(12);
                    cdn.xdn = instance.get(13);
                    cwb.xrV.add(cdn);
                    vi viVar = new vi();
                    try {
                        viVar.cSq.data = cwb.toByteArray();
                    } catch (IOException e6) {
                    }
                    viVar.cSq.cuy = 4;
                    viVar.cSq.ceI = ctv.xqs;
                    viVar.cSq.cws = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.xxA.m(viVar);
                    break;
                }
                ab.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (com.tencent.mm.plugin.wear.model.a.cUn().tXt.cUs() && com.tencent.mm.m.g.Nu().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    b vgVar = new vg();
                    vgVar.cSe.action = 1;
                    vgVar.cSe.cuQ = j;
                    com.tencent.mm.sdk.b.a.xxA.a(vgVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.gn(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.HH(11);
                    break;
                }
                AppMethodBeat.o(26413);
                return null;
        }
        AppMethodBeat.o(26413);
        return null;
    }
}
