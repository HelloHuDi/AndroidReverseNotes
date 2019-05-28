package com.tencent.p177mm.plugin.story.model.p744a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43647q;
import com.tencent.p177mm.plugin.story.model.C43647q.C39911a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.p531g.C39877f;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35187c;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.protocal.protobuf.cel;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cev;
import com.tencent.p177mm.protocal.protobuf.cew;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable.Columns;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010 \u001a\u00020\u0007J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J>\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000102H\u0002R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.h */
public final class C7140h extends C1207m implements C1918k {
    private final String TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    public int cNE;
    private final C7472b ehh;
    private C1202f ehi;
    private long rUJ;

    public C7140h(String str, String str2, int i) {
        C25052j.m39376p(str, C8741b.CONTENT);
        C25052j.m39376p(str2, Columns.CLIENTID);
        AppMethodBeat.m2504i(109238);
        this.cNE = i;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cev());
        c1196a.mo4446b(new cew());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstorypost");
        c1196a.mo4447kU(351);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        if (acz == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
            AppMethodBeat.m2505o(109238);
            throw c44941v;
        }
        cev cev = (cev) acz;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        byte[] bytes = str.getBytes(C17355d.UTF_8);
        C25052j.m39375o(bytes, "(this as java.lang.String).getBytes(charset)");
        sKBuiltinBuffer_t.setBuffer(bytes);
        cev.xen = sKBuiltinBuffer_t;
        cev.ptv = str2;
        cev.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        AppMethodBeat.m2505o(109238);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109235);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        C4990ab.m7410d(this.TAG, "doScene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109235);
        return a;
    }

    public final int getType() {
        return 351;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109236);
        C4990ab.m7410d(this.TAG, "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        C1331a acA = this.ehh.acA();
        C44941v c44941v;
        if (acA == null) {
            c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
            AppMethodBeat.m2505o(109236);
            throw c44941v;
        }
        cew cew = (cew) acA;
        C4133a c4133a;
        C39879j Fe;
        C1202f c1202f;
        if (i2 == 4) {
            c4133a = C43644j.rST;
            Fe = C4133a.cxT().mo74397Fe(this.cNE);
            if (Fe != null) {
                try {
                    acA = new cel().parseFrom(Fe.field_postBuf);
                    if (acA == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
                        AppMethodBeat.m2505o(109236);
                        throw c44941v;
                    }
                    cel cel = (cel) acA;
                    cel.wFm = i3;
                    byte[] toByteArray = cel.toByteArray();
                    C25052j.m39375o(toByteArray, "postinfo.toByteArray()");
                    Fe.mo63083bk(toByteArray);
                    Fe.cqY();
                    c4133a = C43644j.rST;
                    C4133a.cxT().mo74398a(this.cNE, Fe);
                    c4133a = C43644j.rST;
                    C4133a.cyb().mo55851CT(this.cNE);
                } catch (Exception e) {
                }
            }
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109236);
        } else if (i3 != 0) {
            c4133a = C43644j.rST;
            C4133a.cyb().mo55851CT(this.cNE);
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109236);
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
            C4990ab.m7410d(str2, append.append(z).toString());
            if (cew.xdJ == null || cew.xdJ.xen == null || cew.xdJ.xen.getBuffer() == null) {
                C4990ab.m7412e(this.TAG, "err respone buffer is null ignore");
                c4133a = C43644j.rST;
                C4133a.cxT().mo74394DL(this.cNE);
                c1202f = this.ehi;
                if (c1202f == null) {
                    C25052j.avw("callback");
                }
                c1202f.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(109236);
                return;
            }
            C39877f c39877f = C39877f.sbT;
            C39877f.cAi();
            byte[] toByteArray2 = cew.xdJ.xen.getBuffer().toByteArray();
            C25052j.m39375o(toByteArray2, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
            str2 = new String(toByteArray2, C17355d.UTF_8);
            C4990ab.m7410d(this.TAG, "resp.xml:\n ".concat(String.valueOf(str2)));
            C39911a c39911a = C43647q.rTk;
            cfb aaE = C39911a.aaE(str2);
            if (aaE == null) {
                c1202f = this.ehi;
                if (c1202f == null) {
                    C25052j.avw("callback");
                }
                c1202f.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(109236);
                return;
            }
            C4133a c4133a2 = C43644j.rST;
            Fe = C4133a.cxT().mo74397Fe(this.cNE);
            if (Fe == null) {
                Fe = new C39879j();
            }
            m11949a(cew.xdJ.vQE, Fe.cBR(), aaE);
            C35184a c35184a;
            if (cew.xdJ.xek == 1) {
                c35184a = C35183a.sdm;
                Fe.mo63080Fc(C35183a.sde);
            } else {
                c35184a = C35183a.sdm;
                Fe.mo63081Fd(C35183a.sde);
            }
            Fe.field_createTime = cew.xdJ.pcX;
            Fe.mo63084c(aaE);
            int i4 = Fe.field_localFlag;
            C35187c c35187c = C35187c.sds;
            Fe.field_localFlag = i4 & (C35187c.cBu() ^ -1);
            Fe.field_storyID = cew.xdJ.vQE;
            cer cer = cew.xdJ;
            cer.xen.setBuffer(new byte[0]);
            this.rUJ = cew.xdJ.vQE;
            Fe.field_attrBuf = cer.toByteArray();
            Fe.cqX();
            c4133a = C43644j.rST;
            C4133a.cxT().mo74398a(this.cNE, Fe);
            c4133a = C43644j.rST;
            C4133a.cyb().mo55851CT(this.cNE);
            c4133a = C43644j.rST;
            C4133a.cya().checkPost();
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109236);
        }
    }

    /* renamed from: a */
    private final boolean m11949a(long j, cfb cfb, cfb cfb2) {
        boolean z = false;
        AppMethodBeat.m2504i(109237);
        if (cfb == null || cfb2 == null || cfb.xeA == null || cfb2.xeA == null) {
            AppMethodBeat.m2505o(109237);
            return false;
        }
        C4133a c4133a = C43644j.rST;
        C4133a.getAccStoryPath();
        String str = cfb2.jBB;
        while (true) {
            boolean z2 = z;
            if (z2 >= cfb.xeA.wbK.size() || z2 >= cfb2.xeA.wbK.size()) {
                AppMethodBeat.m2505o(109237);
            } else {
                cek cek = (cek) cfb.xeA.wbK.get(z2);
                cek cek2 = (cek) cfb2.xeA.wbK.get(z2);
                C29309l c29309l = C29309l.rTg;
                String aas = C29309l.aas(cek.f4416Id);
                C29309l c29309l2 = C29309l.rTg;
                String aat = C29309l.aat(cek.f4416Id);
                c29309l2 = C29309l.rTg;
                String gx = C29309l.m46528gx(cek2.Url, str);
                C29309l c29309l3 = C29309l.rTg;
                String gy = C29309l.m46529gy(cek2.Url, str);
                C4990ab.m7410d(this.TAG, "updateMediaFileName " + aas + " to " + gx);
                C4990ab.m7410d(this.TAG, "updateMediaFileName " + aat + " to " + gy);
                C5730e.m8643tf(C5730e.atb(gy));
                C5730e.m8623aQ(aas, gx);
                C5730e.m8644y(aat, gy);
                C43649s c43649s = C43649s.rTV;
                C25052j.m39375o(cek2, "mediaObjCnt");
                C25052j.m39376p(cek2, "media");
                aat = C43649s.m78155a(cek2, str);
                int asZ = (int) C5730e.asZ(aat);
                C4133a c4133a2 = C43644j.rST;
                if (C4133a.cxX().mo25976lz(j) == null) {
                    C29298n c29298n = new C29298n();
                    c29298n.field_storyId = j;
                    c29298n.field_url = cek2.Url;
                    c29298n.field_cacheSize = asZ;
                    c29298n.field_totalSize = asZ;
                    c29298n.field_filePath = aat;
                    C4133a c4133a3 = C43644j.rST;
                    C4133a.cxX().mo25973a(c29298n);
                }
                z = z2 + 1;
            }
        }
        AppMethodBeat.m2505o(109237);
        return true;
    }
}
