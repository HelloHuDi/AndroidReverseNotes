package com.tencent.mm.plugin.story.model.a;

import a.a.t;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.cb;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ>\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010+¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "deleteDeprecatedData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class j extends m implements k {
    private static final String TAG = TAG;
    private static final Vector<String> qKd = new Vector();
    public static final a rVc = new a();
    public final int cvd;
    private int cvp;
    private boolean czr;
    private b ehh;
    private f ehi;
    private final String ejD;
    public boolean qIW;
    private long qIX;
    private long qIY;
    private String qJA;
    private int qJa;
    public long qKi;
    private long rUP;
    public String userName;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public j(String str, long j, boolean z, String str2, int i) {
        int cAO;
        a.f.b.j.p(str, "userName");
        a.f.b.j.p(str2, "mRoomId");
        AppMethodBeat.i(109256);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        this.ejD = str2;
        this.cvd = i;
        this.qJA = "";
        if (this.qIX == 0) {
            ab.i(TAG, "fp mUserName " + this.userName);
        } else {
            ab.i(TAG, "np mUserName " + this.userName);
        }
        com.tencent.mm.plugin.story.h.a.a aVar;
        if (this.czr) {
            aVar = com.tencent.mm.plugin.story.h.a.sdm;
            cAO = com.tencent.mm.plugin.story.h.a.scw;
        } else {
            aVar = com.tencent.mm.plugin.story.h.a.sdm;
            cAO = com.tencent.mm.plugin.story.h.a.scx;
        }
        this.cvp = cAO;
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.a(new cfd());
        aVar2.b(new cfe());
        aVar2.qq("/cgi-bin/micromsg-bin/mmstoryuserpage");
        aVar2.kU(273);
        aVar2.kV(400);
        aVar2.kW(1000000400);
        b acD = aVar2.acD();
        a.f.b.j.o(acD, "builder.buildInstance()");
        this.ehh = acD;
        com.tencent.mm.bt.a acz = this.ehh.acz();
        v vVar;
        if (acz == null) {
            vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
            AppMethodBeat.o(109256);
            throw vVar;
        }
        String str3;
        int a;
        String substring;
        cfd cfd = (cfd) acz;
        cfd.jBB = this.userName;
        cfd.wZU = this.qIX;
        cfd.vFH = this.cvd;
        this.qIW = this.qIX == 0;
        cfd.xbw = 0;
        if (a.k.v.a((CharSequence) this.ejD, "@", 0, false, 6) > 0) {
            str3 = this.ejD;
            a = a.k.v.a((CharSequence) this.ejD, "@", 0, false, 6);
            if (str3 == null) {
                vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(109256);
                throw vVar;
            }
            substring = str3.substring(0, a);
            a.f.b.j.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cfd.xeF = bo.anl(substring);
        }
        cfd.xbx = 0;
        cfd.vEf = this.ejD;
        if (this.qIW) {
            a = this.cvd;
            com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
            com.tencent.mm.plugin.story.model.j.a aVar4;
            if (a == com.tencent.mm.plugin.story.h.a.sdl) {
                aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                str3 = this.userName;
                a.f.b.j.p(str3, "userName");
                substring = cxU.aaU(str3).field_favoriteMd5;
                if (substring == null) {
                    substring = "";
                }
            } else {
                aVar4 = com.tencent.mm.plugin.story.model.j.rST;
                substring = com.tencent.mm.plugin.story.model.j.a.cxU().aaV(this.userName);
            }
            this.qJA = substring;
            if (this.qJA == null) {
                this.qJA = "";
            }
            cfd.wZT = this.qJA;
        }
        this.rUP = this.qIX;
        ab.i(TAG, this + " req.mUserName:" + cfd.jBB + " req.MaxId:" + cfd.wZU + " req.MinFilterId:" + cfd.xbw + " req.LastRequestTime:" + cfd.xbx + " ChatRoomName " + this.ejD + " req.FirstPageMd5:" + cfd.wZT + " souorce:" + this.cvd);
        AppMethodBeat.o(109256);
    }

    public /* synthetic */ j(String str, boolean z, String str2) {
        com.tencent.mm.plugin.story.h.a.a aVar = com.tencent.mm.plugin.story.h.a.sdm;
        this(str, 0, z, str2, com.tencent.mm.plugin.story.h.a.sdi);
        AppMethodBeat.i(109257);
        AppMethodBeat.o(109257);
    }

    static {
        AppMethodBeat.i(109258);
        AppMethodBeat.o(109258);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(109254);
        a.f.b.j.p(eVar, "dispatcher");
        a.f.b.j.p(fVar, "callback");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(109254);
        return a;
    }

    public final int getType() {
        return 273;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(109255);
        ab.i(TAG, this + " netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " source:" + this.cvd);
        com.tencent.mm.bt.a acA = this.ehh.acA();
        if (acA == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
            AppMethodBeat.o(109255);
            throw vVar;
        }
        cfe cfe = (cfe) acA;
        this.qKi = cfe.xdM;
        f fVar;
        if (i2 == 0 || i2 == 4) {
            Object obj;
            com.tencent.mm.plugin.story.model.j.a aVar;
            int i4;
            String str2 = cfe.wZT;
            if (str2 == null) {
                str2 = "";
            }
            ab.i(TAG, "onGYNetEnd resp: ObjCount " + cfe.xeG + ", size " + cfe.xeH.size() + "; md5 req " + this.qJA + ", resp " + str2 + ", source: " + this.cvd + ", expiredTime:" + cfe.vAR);
            if (i2 == 0) {
                CharSequence charSequence = this.qJA;
                obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                if (obj == null) {
                    if ((((CharSequence) str2).length() == 0 ? 1 : null) == null && bo.isEqual(this.qJA, str2)) {
                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                        this.qIY = com.tencent.mm.plugin.story.model.j.a.cxT().b(this.qIW ? 0 : this.rUP, this.qJa, this.userName, this.czr);
                        ab.i(TAG, "md5 is nochange");
                        obj = 1;
                    }
                }
                i4 = this.cvd;
                com.tencent.mm.plugin.story.h.a.a aVar2 = com.tencent.mm.plugin.story.h.a.sdm;
                if (i4 == com.tencent.mm.plugin.story.h.a.sdl) {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cxU().gC(this.userName, str2);
                    obj = null;
                } else {
                    aVar = com.tencent.mm.plugin.story.model.j.rST;
                    com.tencent.mm.plugin.story.model.j.a.cxU().gB(this.userName, str2);
                    obj = null;
                }
            } else {
                if (i2 == 4) {
                    com.tencent.mm.plugin.story.h.a.a aVar3 = com.tencent.mm.plugin.story.h.a.sdm;
                    if (i3 == com.tencent.mm.plugin.story.h.a.scH) {
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                fVar = this.ehi;
                if (fVar == null) {
                    a.f.b.j.avw("callback");
                }
                fVar.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(109255);
                return;
            }
            LinkedList linkedList = cfe.xeH;
            a.f.b.j.o(linkedList, "resp.ObjList");
            cer cer = (cer) t.fK(linkedList);
            this.qIX = cer != null ? cer.vQE : 0;
            linkedList = cfe.xeH;
            a.f.b.j.o(linkedList, "resp.ObjList");
            cer = (cer) t.fM(linkedList);
            this.qIY = cer != null ? cer.vQE : 0;
            ab.i(TAG, "onGYNetEnd replace insert " + cfe.xeH.size() + ", max " + this.qIX + ", min " + this.qIY);
            ab.i(TAG, "determin clear fav: " + this.cvd + ", " + i3 + ", " + this.qIW);
            i4 = this.cvd;
            com.tencent.mm.plugin.story.h.a.a aVar4 = com.tencent.mm.plugin.story.h.a.sdm;
            com.tencent.mm.plugin.story.model.n.a aVar5;
            if (i4 == com.tencent.mm.plugin.story.h.a.sdl && this.qIW) {
                ab.i(TAG, "fetch first page, clear all fav");
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                str2 = this.userName;
                String str3 = this.userName;
                com.tencent.mm.plugin.story.model.j.a aVar6 = com.tencent.mm.plugin.story.model.j.rST;
                for (com.tencent.mm.plugin.story.h.j jVar : cxT.bx(str2, bo.isEqual(str3, com.tencent.mm.plugin.story.model.j.a.cnk()))) {
                    com.tencent.mm.plugin.story.model.n.a aVar7 = n.rTi;
                    com.tencent.mm.plugin.story.model.n.a.fK((int) jVar.xDa, 0);
                }
                aVar5 = n.rTi;
                com.tencent.mm.plugin.story.model.n.a.b(this.userName, cfe.xeH, this.cvp);
            } else {
                i4 = this.cvd;
                aVar4 = com.tencent.mm.plugin.story.h.a.sdm;
                if (i4 == com.tencent.mm.plugin.story.h.a.sdi) {
                    List a;
                    if (this.czr) {
                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                        a = com.tencent.mm.plugin.story.model.j.a.cxT().a(this.userName, true, cb.aaF() - 86400, true);
                    } else {
                        aVar = com.tencent.mm.plugin.story.model.j.rST;
                        a = com.tencent.mm.plugin.story.model.j.a.cxT().bw(this.userName, false);
                    }
                    for (com.tencent.mm.plugin.story.h.j jVar2 : a) {
                        if (jVar2.field_storyID != 0) {
                            linkedList = cfe.xeH;
                            a.f.b.j.o(linkedList, "resp.ObjList");
                            Iterable<cer> iterable = linkedList;
                            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                                for (cer cer2 : iterable) {
                                    if (cer2.vQE == jVar2.field_storyID) {
                                        obj = 1;
                                        continue;
                                    } else {
                                        obj = null;
                                        continue;
                                    }
                                    if (obj != null) {
                                        obj = null;
                                        break;
                                    }
                                }
                            }
                            obj = 1;
                            if (!(obj == null || jVar2.cBW())) {
                                aVar = com.tencent.mm.plugin.story.model.j.rST;
                                com.tencent.mm.plugin.story.model.j.a.cxT().lw(jVar2.field_storyID);
                            }
                        }
                    }
                    aVar5 = n.rTi;
                    com.tencent.mm.plugin.story.h.j jVar3 = (com.tencent.mm.plugin.story.h.j) t.x(com.tencent.mm.plugin.story.model.n.a.b(this.userName, cfe.xeH, this.cvp), 0);
                    if (jVar3 == null) {
                        ab.i(TAG, "onGYNetEnd clear ext sync");
                        com.tencent.mm.plugin.story.model.k kVar = com.tencent.mm.plugin.story.model.k.rTc;
                        com.tencent.mm.plugin.story.model.k.aan(this.userName);
                    } else {
                        ab.i(TAG, "onGYNetEnd update ext sync, " + jVar3.field_storyID + ' ' + jVar3.field_createTime);
                        com.tencent.mm.plugin.story.model.k kVar2 = com.tencent.mm.plugin.story.model.k.rTc;
                        com.tencent.mm.plugin.story.model.k.a(this.userName, jVar3);
                    }
                }
            }
            fVar = this.ehi;
            if (fVar == null) {
                a.f.b.j.avw("callback");
            }
            fVar.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(109255);
            return;
        }
        ab.w(TAG, "onGYNetEnd errorType:" + i2 + " errorCode:" + i3 + ", return");
        fVar = this.ehi;
        if (fVar == null) {
            a.f.b.j.avw("callback");
        }
        fVar.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(109255);
    }

    public final String getInfo() {
        return this.userName;
    }
}
