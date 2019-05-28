package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cdi;
import com.tencent.p177mm.protocal.protobuf.cdj;
import com.tencent.p177mm.protocal.protobuf.cdk;
import com.tencent.p177mm.protocal.protobuf.cdl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelsimple.y */
public final class C37951y extends C1207m implements C1918k {
    private static HashSet<Long> fPM = new HashSet();
    private final C7472b ehh;
    private C1202f ehi;
    private final String toUserName;

    static {
        AppMethodBeat.m2504i(78608);
        AppMethodBeat.m2505o(78608);
    }

    /* renamed from: ab */
    public static void m64163ab(String str, int i) {
        AppMethodBeat.m2504i(78601);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78601);
        } else if (!C1720g.m3534RN().mo5161QY() || (C1855t.m3923nI(str) && !C1855t.m3935nd(str))) {
            AppMethodBeat.m2505o(78601);
        } else {
            C1720g.m3535RO().eJo.mo14541a(new C37951y(str, i, 0, null), 0);
            AppMethodBeat.m2505o(78601);
        }
    }

    /* renamed from: C */
    public static void m64162C(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78602);
        C1720g.m3537RQ();
        if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            C4990ab.m7416i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]autoSyncState close");
            AppMethodBeat.m2505o(78602);
        } else if (fPM.contains(Long.valueOf(c7620bi.field_msgId))) {
            C4990ab.m7417i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd: has send cmd: msgSvrId:%d, msgLocalId:%d", Long.valueOf(c7620bi.field_msgId), Long.valueOf(c7620bi.field_msgId));
            AppMethodBeat.m2505o(78602);
        } else {
            fPM.add(Long.valueOf(c7620bi.field_msgId));
            if (C1720g.m3534RN().mo5161QY()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<![CDATA[<downloadList>");
                stringBuilder.append("<downloadItem>");
                stringBuilder.append("<username>");
                stringBuilder.append(c7620bi.field_talker);
                stringBuilder.append("</username>");
                stringBuilder.append("<msgsvrid>");
                stringBuilder.append(c7620bi.field_msgSvrId);
                stringBuilder.append("</msgsvrid>");
                stringBuilder.append("</downloadItem>");
                stringBuilder.append("</downloadList>]]>");
                String stringBuilder2 = stringBuilder.toString();
                C4990ab.m7417i("MicroMsg.NetSceneStatusNotify", "[MicroMsg.MultiTerminalSyncMgr]sendSyncMultiTerminalCmd:msgID:%d,  %s", Long.valueOf(c7620bi.field_msgId), stringBuilder);
                C1720g.m3535RO().eJo.mo14541a(new C37951y(C1853r.m3846Yz(), 11, "DownloadFile", stringBuilder2), 0);
                AppMethodBeat.m2505o(78602);
                return;
            }
            AppMethodBeat.m2505o(78602);
        }
    }

    /* renamed from: b */
    public static void m64164b(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(78603);
        if (C5046bo.isNullOrNil(str) || C1855t.m3923nI(str)) {
            AppMethodBeat.m2505o(78603);
        } else if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3535RO().eJo.mo14541a(new C37951y(str, i, str2, str3), 0);
            AppMethodBeat.m2505o(78603);
        } else {
            AppMethodBeat.m2505o(78603);
        }
    }

    public C37951y(String str, int i, int i2, LinkedList<cdl> linkedList) {
        AppMethodBeat.m2504i(78604);
        this.toUserName = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cdj();
        c1196a.fsK = new cdk();
        c1196a.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.ehh = c1196a.acD();
        cdj cdj = (cdj) this.ehh.fsG.fsP;
        cdj.ndG = C1853r.m3846Yz();
        cdj.xcZ = i;
        cdj.ndF = str;
        cdj.vFF = System.currentTimeMillis();
        if (linkedList != null && linkedList.size() == i2) {
            cdj.xda = i2;
            cdj.xdb.addAll(linkedList);
        }
        C4990ab.m7410d("MicroMsg.NetSceneStatusNotify", "summerstatus toUserName = " + str + " unreadChatListCount = " + cdj.xdb.size());
        AppMethodBeat.m2505o(78604);
    }

    private C37951y(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(78605);
        this.toUserName = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cdj();
        c1196a.fsK = new cdk();
        c1196a.uri = "/cgi-bin/micromsg-bin/statusnotify";
        this.ehh = c1196a.acD();
        cdj cdj = (cdj) this.ehh.fsG.fsP;
        cdj.ndG = C1853r.m3846Yz();
        cdj.xcZ = i;
        cdj.ndF = str;
        cdj.vFF = System.currentTimeMillis();
        cdj.xdc = new cdi();
        cdj.xdc.Name = str2;
        cdj.xdc.xcY = str3;
        AppMethodBeat.m2505o(78605);
    }

    public final int getType() {
        return 251;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78606);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78606);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78607);
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7410d("MicroMsg.NetSceneStatusNotify", "StatusNotify Error. userName=" + this.toUserName);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78607);
    }
}
