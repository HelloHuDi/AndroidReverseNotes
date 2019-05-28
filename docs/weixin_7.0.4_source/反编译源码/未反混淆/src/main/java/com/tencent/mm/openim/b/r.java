package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgy;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.util.Iterator;

public final class r extends m implements k {
    private final b ehh;
    private f ehi;

    public r() {
        AppMethodBeat.i(78884);
        a aVar = new a();
        aVar.fsJ = new bgy();
        aVar.fsK = new bgz();
        aVar.uri = "/cgi-bin/micromsg-bin/openimsync";
        this.ehh = aVar.acD();
        ((bgy) this.ehh.fsG.fsP).fHJ = 2097152;
        ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(78884);
    }

    public final int acn() {
        return 20;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 810;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78885);
        g.RQ();
        byte[] anf = bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        ((bgy) this.ehh.fsG.fsP).wKr = sKBuiltinBuffer_t;
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78885);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78886);
        ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        if (i2 == 0 && i3 == 0) {
            bgy bgy = (bgy) this.ehh.fsG.fsP;
            bgz bgz = (bgz) this.ehh.fsH.fsP;
            if (bgz.wKs != null && bgz.wKs.jBw.size() > 0) {
                ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", Integer.valueOf(bgz.wKs.jBw.size()));
                Iterator it = bgz.wKs.jBw.iterator();
                while (it.hasNext()) {
                    tb tbVar = (tb) it.next();
                    bgf bgf;
                    if (tbVar.wat == 400) {
                        bgf = new bgf();
                        try {
                            bgf.parseFrom(tbVar.wau.getBufferToBytes());
                            ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", bgf.geZ);
                            ad a = s.a(bgf);
                            ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a.field_username, a.field_nickname, a.field_conRemark, Integer.valueOf(a.getSource()), Integer.valueOf(a.dtS), a.field_openImAppid, a.duw, Integer.valueOf(a.duv), Integer.valueOf(a.field_type), a.field_descWordingId);
                            ((j) g.K(j.class)).XM().Y(a);
                            if (a.Oe()) {
                                ((j) g.K(j.class)).XR().apf(a.field_username);
                            }
                            ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).aZ(bgf.app_id, bgf.wKh);
                            s.b(bgf);
                            g.RQ();
                            bv RB = ((j) g.K(j.class)).XN().RB(a.field_username);
                            if (!(RB == null || bo.isNullOrNil(RB.field_encryptUsername))) {
                                ((com.tencent.mm.openim.a.a) g.K(com.tencent.mm.openim.a.a.class)).ah(a.field_username, RB.field_conRemark);
                                g.RQ();
                                ((j) g.K(j.class)).XN().RC(a.field_username);
                                a.iz(RB.field_conRemark);
                                ((j) g.K(j.class)).XM().Y(a);
                            }
                        } catch (IOException e) {
                            ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", e);
                        }
                    } else if (tbVar.wat == 402) {
                        vy vyVar = new vy();
                        try {
                            vyVar.parseFrom(tbVar.wau.getBufferToBytes());
                            ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", vyVar.geZ);
                            ((j) g.K(j.class)).XR().aoX(vyVar.geZ);
                            t.nb(vyVar.geZ);
                        } catch (IOException e2) {
                            ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", e2);
                        }
                    } else if (tbVar.wat == 403) {
                        try {
                            bfz bfz = new bfz();
                            bfz.parseFrom(tbVar.wau.getBufferToBytes());
                            ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", bfz.gfa);
                            com.tencent.mm.openim.room.a.a.b(bfz);
                        } catch (IOException e22) {
                            ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", e22);
                        }
                    } else if (tbVar.wat == 404) {
                        bgf = new bgf();
                        try {
                            bgf.parseFrom(tbVar.wau.getBufferToBytes());
                            ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", bgf.geZ);
                            g.RO().eJo.a(new h(bgf.geZ, "", ""), 0);
                        } catch (IOException e222) {
                            ab.e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", e222);
                        }
                    }
                }
            }
            byte[] toByteArray = bgz.wKr.getBuffer().toByteArray();
            g.RQ();
            byte[] j = aa.j(bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null))), toByteArray);
            if (j != null && j.length > 0) {
                g.RQ();
                g.RP().Ry().set(8195, bo.cd(j));
            }
            if ((bgy.fHJ & bgz.wKt) == 0) {
                ab.i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
                this.ehi.onSceneEnd(0, 0, "", this);
                AppMethodBeat.o(78886);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(78886);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78886);
    }
}
