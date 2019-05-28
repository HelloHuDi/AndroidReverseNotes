package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.ci.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.AnonymousClass2;
import com.tencent.mm.storage.r.AnonymousClass3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public final class l extends m implements k {
    private final b ehh;
    private f ehi;

    public l(LinkedList<jy> linkedList) {
        AppMethodBeat.i(13858);
        a aVar = new a();
        aVar.fsJ = new cgz();
        aVar.fsK = new cha();
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_comment_reward_stat";
        this.ehh = aVar.acD();
        ((cgz) this.ehh.fsG.fsP).xfT = linkedList;
        ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "NetSceneTimelineGetCommentReward %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(13858);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13859);
        ab.i("MicroMsg.NetSceneTimelineGetCommentReward", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            cha cha = (cha) this.ehh.fsH.fsP;
            if (cha != null) {
                HashMap hashMap = new HashMap();
                if (!bo.ek(cha.vGJ)) {
                    Iterator it = cha.vGJ.iterator();
                    while (it.hasNext()) {
                        eu euVar = (eu) it.next();
                        ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "client_msg_id=%d, fans_read_cnt=%d", Long.valueOf(euVar.vGH), Integer.valueOf(euVar.vGI));
                        if (euVar.vGH > 0 && euVar.vGI > 0) {
                            if (!hashMap.containsKey(Long.valueOf(euVar.vGH))) {
                                hashMap.put(Long.valueOf(euVar.vGH), new ev());
                            }
                            ((ev) hashMap.get(Long.valueOf(euVar.vGH))).vGJ.add(euVar);
                        }
                    }
                    LinkedList linkedList = new LinkedList();
                    for (Entry entry : hashMap.entrySet()) {
                        ev evVar = (ev) entry.getValue();
                        com.tencent.mm.storage.q B = z.aeX().B(((Long) entry.getKey()).longValue(), "msgId");
                        if (!(B == null || c.b(B.field_appMsgStatInfoProto, evVar))) {
                            B.field_appMsgStatInfoProto = evVar;
                            linkedList.add(B);
                        }
                    }
                    r aeX = z.aeX();
                    if (!bo.ek(linkedList)) {
                        g.dOW().h(new AnonymousClass3(linkedList)).b(new AnonymousClass2(linkedList));
                    }
                }
                if (cha.xfU > 0) {
                    com.tencent.mm.plugin.brandservice.ui.b.a.jYZ = cha.xfU;
                }
            }
        }
        AppMethodBeat.o(13859);
    }

    public final int getType() {
        return 2571;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13860);
        this.ehi = fVar;
        ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13860);
        return a;
    }
}
