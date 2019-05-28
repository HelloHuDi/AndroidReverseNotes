package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.k.d;
import a.l;
import a.v;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.a.c;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010 \u001a\u00020\u0007J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J>\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000102H\u0002R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class h extends m implements k {
    private final String TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    public int cNE;
    private final b ehh;
    private f ehi;
    private long rUJ;

    public h(String str, String str2, int i) {
        j.p(str, FirebaseAnalytics.b.CONTENT);
        j.p(str2, Columns.CLIENTID);
        AppMethodBeat.i(109238);
        this.cNE = i;
        a aVar = new a();
        aVar.a(new cev());
        aVar.b(new cew());
        aVar.qq("/cgi-bin/micromsg-bin/mmstorypost");
        aVar.kU(351);
        aVar.kV(0);
        aVar.kW(0);
        b acD = aVar.acD();
        j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        if (acz == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
            AppMethodBeat.o(109238);
            throw vVar;
        }
        cev cev = (cev) acz;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        byte[] bytes = str.getBytes(d.UTF_8);
        j.o(bytes, "(this as java.lang.String).getBytes(charset)");
        sKBuiltinBuffer_t.setBuffer(bytes);
        cev.xen = sKBuiltinBuffer_t;
        cev.ptv = str2;
        cev.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        AppMethodBeat.o(109238);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109235);
        j.p(eVar, "dispatcher");
        j.p(fVar, "callback");
        this.ehi = fVar;
        ab.d(this.TAG, "doScene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109235);
        return a;
    }

    public final int getType() {
        return 351;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109236);
        ab.d(this.TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        v vVar;
        if (acA == null) {
            vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
            AppMethodBeat.o(109236);
            throw vVar;
        }
        cew cew = (cew) acA;
        com.tencent.mm.plugin.story.model.j.a aVar;
        com.tencent.mm.plugin.story.h.j Fe;
        f fVar;
        if (i2 == 4) {
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(this.cNE);
            if (Fe != null) {
                try {
                    acA = new cel().parseFrom(Fe.field_postBuf);
                    if (acA == null) {
                        vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                        AppMethodBeat.o(109236);
                        throw vVar;
                    }
                    cel cel = (cel) acA;
                    cel.wFm = i3;
                    byte[] toByteArray = cel.toByteArray();
                    j.o(toByteArray, "postinfo.toByteArray()");
                    Fe.bk(toByteArray);
                    Fe.cqY();
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cxT().a(this.cNE, Fe);
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cyb().CT(this.cNE);
                } catch (Exception e) {
                }
            }
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109236);
        } else if (i3 != 0) {
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cyb().CT(this.cNE);
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109236);
        } else {
            boolean z;
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("resp.StoryObject==null ").append(cew.xdJ == null).append(" resp.StoryObject.ObjDesc==null ");
            if (cew.xdJ.xen == null) {
                z = true;
            } else {
                z = false;
            }
            append = append.append(z).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
            if (cew.xdJ.xen.getBuffer() == null) {
                z = true;
            } else {
                z = false;
            }
            ab.d(str2, append.append(z).toString());
            if (cew.xdJ == null || cew.xdJ.xen == null || cew.xdJ.xen.getBuffer() == null) {
                ab.e(this.TAG, "err respone buffer is null ignore");
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().DL(this.cNE);
                fVar = this.ehi;
                if (fVar == null) {
                    j.avw("callback");
                }
                fVar.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(109236);
                return;
            }
            com.tencent.mm.plugin.story.g.f fVar2 = com.tencent.mm.plugin.story.g.f.sbT;
            com.tencent.mm.plugin.story.g.f.cAi();
            byte[] toByteArray2 = cew.xdJ.xen.getBuffer().toByteArray();
            j.o(toByteArray2, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
            str2 = new String(toByteArray2, d.UTF_8);
            ab.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(str2)));
            com.tencent.mm.plugin.story.model.q.a aVar2 = com.tencent.mm.plugin.story.model.q.rTk;
            cfb aaE = com.tencent.mm.plugin.story.model.q.a.aaE(str2);
            if (aaE == null) {
                fVar = this.ehi;
                if (fVar == null) {
                    j.avw("callback");
                }
                fVar.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(109236);
                return;
            }
            com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
            Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(this.cNE);
            if (Fe == null) {
                Fe = new com.tencent.mm.plugin.story.h.j();
            }
            a(cew.xdJ.vQE, Fe.cBR(), aaE);
            com.tencent.mm.plugin.story.h.a.a aVar4;
            if (cew.xdJ.xek == 1) {
                aVar4 = com.tencent.mm.plugin.story.h.a.sdm;
                Fe.Fc(com.tencent.mm.plugin.story.h.a.sde);
            } else {
                aVar4 = com.tencent.mm.plugin.story.h.a.sdm;
                Fe.Fd(com.tencent.mm.plugin.story.h.a.sde);
            }
            Fe.field_createTime = cew.xdJ.pcX;
            Fe.c(aaE);
            int i4 = Fe.field_localFlag;
            c cVar = c.sds;
            Fe.field_localFlag = i4 & (c.cBu() ^ -1);
            Fe.field_storyID = cew.xdJ.vQE;
            cer cer = cew.xdJ;
            cer.xen.setBuffer(new byte[0]);
            this.rUJ = cew.xdJ.vQE;
            Fe.field_attrBuf = cer.toByteArray();
            Fe.cqX();
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().a(this.cNE, Fe);
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cyb().CT(this.cNE);
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().checkPost();
            fVar = this.ehi;
            if (fVar == null) {
                j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109236);
        }
    }

    private final boolean a(long j, cfb cfb, cfb cfb2) {
        boolean z = false;
        AppMethodBeat.i(109237);
        if (cfb == null || cfb2 == null || cfb.xeA == null || cfb2.xeA == null) {
            AppMethodBeat.o(109237);
            return false;
        }
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.getAccStoryPath();
        String str = cfb2.jBB;
        while (true) {
            boolean z2 = z;
            if (z2 >= cfb.xeA.wbK.size() || z2 >= cfb2.xeA.wbK.size()) {
                AppMethodBeat.o(109237);
            } else {
                cek cek = (cek) cfb.xeA.wbK.get(z2);
                cek cek2 = (cek) cfb2.xeA.wbK.get(z2);
                com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
                String aas = com.tencent.mm.plugin.story.model.l.aas(cek.Id);
                com.tencent.mm.plugin.story.model.l lVar2 = com.tencent.mm.plugin.story.model.l.rTg;
                String aat = com.tencent.mm.plugin.story.model.l.aat(cek.Id);
                lVar2 = com.tencent.mm.plugin.story.model.l.rTg;
                String gx = com.tencent.mm.plugin.story.model.l.gx(cek2.Url, str);
                com.tencent.mm.plugin.story.model.l lVar3 = com.tencent.mm.plugin.story.model.l.rTg;
                String gy = com.tencent.mm.plugin.story.model.l.gy(cek2.Url, str);
                ab.d(this.TAG, "updateMediaFileName " + aas + " to " + gx);
                ab.d(this.TAG, "updateMediaFileName " + aat + " to " + gy);
                com.tencent.mm.vfs.e.tf(com.tencent.mm.vfs.e.atb(gy));
                com.tencent.mm.vfs.e.aQ(aas, gx);
                com.tencent.mm.vfs.e.y(aat, gy);
                s sVar = s.rTV;
                j.o(cek2, "mediaObjCnt");
                j.p(cek2, "media");
                aat = s.a(cek2, str);
                int asZ = (int) com.tencent.mm.vfs.e.asZ(aat);
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                if (com.tencent.mm.plugin.story.model.j.a.cxX().lz(j) == null) {
                    n nVar = new n();
                    nVar.field_storyId = j;
                    nVar.field_url = cek2.Url;
                    nVar.field_cacheSize = asZ;
                    nVar.field_totalSize = asZ;
                    nVar.field_filePath = aat;
                    com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cxX().a(nVar);
                }
                z = z2 + 1;
            }
        }
        AppMethodBeat.o(109237);
        return true;
    }
}
