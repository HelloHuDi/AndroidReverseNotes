package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C37974a;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C44181vy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bfz;
import com.tencent.p177mm.protocal.protobuf.bgf;
import com.tencent.p177mm.protocal.protobuf.bgy;
import com.tencent.p177mm.protocal.protobuf.bgz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.Iterator;

/* renamed from: com.tencent.mm.openim.b.r */
public final class C45466r extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C45466r() {
        AppMethodBeat.m2504i(78884);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bgy();
        c1196a.fsK = new bgz();
        c1196a.uri = "/cgi-bin/micromsg-bin/openimsync";
        this.ehh = c1196a.acD();
        ((bgy) this.ehh.fsG.fsP).fHJ = 2097152;
        C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "opim sync init:%d", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(78884);
    }

    public final int acn() {
        return 20;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 810;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78885);
        C1720g.m3537RQ();
        byte[] anf = C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)));
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(anf);
        ((bgy) this.ehh.fsG.fsP).wKr = sKBuiltinBuffer_t;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78885);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78886);
        C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        if (i2 == 0 && i3 == 0) {
            bgy bgy = (bgy) this.ehh.fsG.fsP;
            bgz bgz = (bgz) this.ehh.fsH.fsP;
            if (bgz.wKs != null && bgz.wKs.jBw.size() > 0) {
                C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd, cmd size:%d", Integer.valueOf(bgz.wKs.jBw.size()));
                Iterator it = bgz.wKs.jBw.iterator();
                while (it.hasNext()) {
                    C40573tb c40573tb = (C40573tb) it.next();
                    bgf bgf;
                    if (c40573tb.wat == 400) {
                        bgf = new bgf();
                        try {
                            bgf.parseFrom(c40573tb.wau.getBufferToBytes());
                            C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact %s", bgf.geZ);
                            C7616ad a = C37976s.m64267a(bgf);
                            C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", a.field_username, a.field_nickname, a.field_conRemark, Integer.valueOf(a.getSource()), Integer.valueOf(a.dtS), a.field_openImAppid, a.duw, Integer.valueOf(a.duv), Integer.valueOf(a.field_type), a.field_descWordingId);
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(a);
                            if (a.mo16702Oe()) {
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(a.field_username);
                            }
                            ((C32873b) C1720g.m3528K(C32873b.class)).mo44303aZ(bgf.app_id, bgf.wKh);
                            C37976s.m64268b(bgf);
                            C1720g.m3537RQ();
                            C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(a.field_username);
                            if (!(RB == null || C5046bo.isNullOrNil(RB.field_encryptUsername))) {
                                ((C37974a) C1720g.m3528K(C37974a.class)).mo5376ah(a.field_username, RB.field_conRemark);
                                C1720g.m3537RQ();
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15365RC(a.field_username);
                                a.mo14729iz(RB.field_conRemark);
                                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15701Y(a);
                            }
                        } catch (IOException e) {
                            C4990ab.m7413e("MicroMsg.Openim.NetsceneOpenIMSync", "processModContact error:%s", e);
                        }
                    } else if (c40573tb.wat == 402) {
                        C44181vy c44181vy = new C44181vy();
                        try {
                            c44181vy.parseFrom(c40573tb.wau.getBufferToBytes());
                            C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact user:%s", c44181vy.geZ);
                            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX(c44181vy.geZ);
                            C1855t.m3933nb(c44181vy.geZ);
                        } catch (IOException e2) {
                            C4990ab.m7413e("MicroMsg.Openim.NetsceneOpenIMSync", "processDelContact error:%s", e2);
                        }
                    } else if (c40573tb.wat == 403) {
                        try {
                            bfz bfz = new bfz();
                            bfz.parseFrom(c40573tb.wau.getBufferToBytes());
                            C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact %s", bfz.gfa);
                            C42249a.m74599b(bfz);
                        } catch (IOException e22) {
                            C4990ab.m7413e("MicroMsg.Openim.NetsceneOpenIMSync", "processModChatroomContact error:%s", e22);
                        }
                    } else if (c40573tb.wat == 404) {
                        bgf = new bgf();
                        try {
                            bgf.parseFrom(c40573tb.wau.getBufferToBytes());
                            C4990ab.m7417i("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact %s", bgf.geZ);
                            C1720g.m3535RO().eJo.mo14541a(new C32877h(bgf.geZ, "", ""), 0);
                        } catch (IOException e222) {
                            C4990ab.m7413e("MicroMsg.Openim.NetsceneOpenIMSync", "processNeedGetContact error:%s", e222);
                        }
                    }
                }
            }
            byte[] toByteArray = bgz.wKr.getBuffer().toByteArray();
            C1720g.m3537RQ();
            byte[] j = C44098aa.m79382j(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null))), toByteArray);
            if (j != null && j.length > 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(8195, C5046bo.m7543cd(j));
            }
            if ((bgy.fHJ & bgz.wKt) == 0) {
                C4990ab.m7416i("MicroMsg.Openim.NetsceneOpenIMSync", "onGYNetEnd end");
                this.ehi.onSceneEnd(0, 0, "", this);
                AppMethodBeat.m2505o(78886);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(78886);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78886);
    }
}
