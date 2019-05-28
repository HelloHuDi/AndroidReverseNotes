package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42808a;
import com.tencent.p177mm.protocal.protobuf.C15337eu;
import com.tencent.p177mm.protocal.protobuf.C15338ev;
import com.tencent.p177mm.protocal.protobuf.C35930jy;
import com.tencent.p177mm.protocal.protobuf.cgz;
import com.tencent.p177mm.protocal.protobuf.cha;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C40635r.C154453;
import com.tencent.p177mm.storage.C40635r.C303082;
import com.tencent.p177mm.storage.C46627q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.brandservice.b.l */
public final class C42796l extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C42796l(LinkedList<C35930jy> linkedList) {
        AppMethodBeat.m2504i(13858);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cgz();
        c1196a.fsK = new cha();
        c1196a.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_comment_reward_stat";
        this.ehh = c1196a.acD();
        ((cgz) this.ehh.fsG.fsP).xfT = linkedList;
        C4990ab.m7411d("MicroMsg.NetSceneTimelineGetCommentReward", "NetSceneTimelineGetCommentReward %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(13858);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13859);
        C4990ab.m7417i("MicroMsg.NetSceneTimelineGetCommentReward", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            cha cha = (cha) this.ehh.fsH.fsP;
            if (cha != null) {
                HashMap hashMap = new HashMap();
                if (!C5046bo.m7548ek(cha.vGJ)) {
                    Iterator it = cha.vGJ.iterator();
                    while (it.hasNext()) {
                        C15337eu c15337eu = (C15337eu) it.next();
                        C4990ab.m7411d("MicroMsg.NetSceneTimelineGetCommentReward", "client_msg_id=%d, fans_read_cnt=%d", Long.valueOf(c15337eu.vGH), Integer.valueOf(c15337eu.vGI));
                        if (c15337eu.vGH > 0 && c15337eu.vGI > 0) {
                            if (!hashMap.containsKey(Long.valueOf(c15337eu.vGH))) {
                                hashMap.put(Long.valueOf(c15337eu.vGH), new C15338ev());
                            }
                            ((C15338ev) hashMap.get(Long.valueOf(c15337eu.vGH))).vGJ.add(c15337eu);
                        }
                    }
                    LinkedList linkedList = new LinkedList();
                    for (Entry entry : hashMap.entrySet()) {
                        C15338ev c15338ev = (C15338ev) entry.getValue();
                        C46627q B = C41747z.aeX().mo64097B(((Long) entry.getKey()).longValue(), "msgId");
                        if (!(B == null || C38689c.m65625b(B.field_appMsgStatInfoProto, c15338ev))) {
                            B.field_appMsgStatInfoProto = c15338ev;
                            linkedList.add(B);
                        }
                    }
                    C40635r aeX = C41747z.aeX();
                    if (!C5046bo.m7548ek(linkedList)) {
                        C41930g.dOW().mo60492h(new C154453(linkedList)).mo60487b(new C303082(linkedList));
                    }
                }
                if (cha.xfU > 0) {
                    C42808a.jYZ = cha.xfU;
                }
            }
        }
        AppMethodBeat.m2505o(13859);
    }

    public final int getType() {
        return 2571;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13860);
        this.ehi = c1202f;
        C4990ab.m7410d("MicroMsg.NetSceneTimelineGetCommentReward", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13860);
        return a;
    }
}
