package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import java.util.HashSet;
import java.util.LinkedList;

public final class y extends m implements k {
    private static HashSet<Long> fPM = new HashSet();
    private final b ehh;
    private f ehi;
    private final String toUserName;

    static {
        AppMethodBeat.i(78608);
        AppMethodBeat.o(78608);
    }

    public static void ab(String str, int i) {
        AppMethodBeat.i(78601);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(78601);
        } else if (!g.RN().QY() || (t.nI(str) && !t.nd(str))) {
            AppMethodBeat.o(78601);
        } else {
            g.RO().eJo.a(new y(str, i, 0, null), 0);
            AppMethodBeat.o(78601);
        }
    }

    public static void C(bi biVar) {
        AppMethodBeat.i(78602);
        g.RQ();
        if (!((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
            AppMethodBeat.o(78602);
        } else if (fPM.contains(Long.valueOf(biVar.field_msgId))) {
            ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", Long.valueOf(biVar.field_msgId), Long.valueOf(biVar.field_msgId));
            AppMethodBeat.o(78602);
        } else {
            fPM.add(Long.valueOf(biVar.field_msgId));
            if (g.RN().QY()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<![CDATA[<downloadList>");
                stringBuilder.append("<downloadItem>");
                stringBuilder.append("<username>");
                stringBuilder.append(biVar.field_talker);
                stringBuilder.append("</username>");
                stringBuilder.append("<msgsvrid>");
                stringBuilder.append(biVar.field_msgSvrId);
                stringBuilder.append("</msgsvrid>");
                stringBuilder.append("</downloadItem>");
                stringBuilder.append("</downloadList>]]>");
                String stringBuilder2 = stringBuilder.toString();
                ab.i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", Long.valueOf(biVar.field_msgId), stringBuilder);
                g.RO().eJo.a(new y(r.Yz(), 11, "DownloadFile", stringBuilder2), 0);
                AppMethodBeat.o(78602);
                return;
            }
            AppMethodBeat.o(78602);
        }
    }

    public static void b(String str, int i, String str2, String str3) {
        AppMethodBeat.i(78603);
        if (bo.isNullOrNil(str) || t.nI(str)) {
            AppMethodBeat.o(78603);
        } else if (g.RN().QY()) {
            g.RO().eJo.a(new y(str, i, str2, str3), 0);
            AppMethodBeat.o(78603);
        } else {
            AppMethodBeat.o(78603);
        }
    }

    public y(String str, int i, int i2, LinkedList<cdl> linkedList) {
        AppMethodBeat.i(78604);
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.fsJ = new cdj();
        aVar.fsK = new cdk();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.ehh = aVar.acD();
        cdj cdj = (cdj) this.ehh.fsG.fsP;
        cdj.ndG = r.Yz();
        cdj.xcZ = i;
        cdj.ndF = str;
        cdj.vFF = System.currentTimeMillis();
        if (linkedList != null && linkedList.size() == i2) {
            cdj.xda = i2;
            cdj.xdb.addAll(linkedList);
        }
        ab.d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + str + " unreadChatListCount = " + cdj.xdb.size());
        AppMethodBeat.o(78604);
    }

    private y(String str, int i, String str2, String str3) {
        AppMethodBeat.i(78605);
        this.toUserName = str;
        b.a aVar = new b.a();
        aVar.fsJ = new cdj();
        aVar.fsK = new cdk();
        aVar.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.ehh = aVar.acD();
        cdj cdj = (cdj) this.ehh.fsG.fsP;
        cdj.ndG = r.Yz();
        cdj.xcZ = i;
        cdj.ndF = str;
        cdj.vFF = System.currentTimeMillis();
        cdj.xdc = new cdi();
        cdj.xdc.Name = str2;
        cdj.xdc.xcY = str3;
        AppMethodBeat.o(78605);
    }

    public final int getType() {
        return 251;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78606);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78606);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78607);
        if (!(i2 == 0 && i3 == 0)) {
            ab.d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78607);
    }
}
