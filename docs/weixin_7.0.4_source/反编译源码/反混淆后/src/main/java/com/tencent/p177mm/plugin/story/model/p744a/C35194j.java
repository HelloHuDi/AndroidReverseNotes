package com.tencent.p177mm.plugin.story.model.p744a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.story.model.C22241k;
import com.tencent.p177mm.plugin.story.model.C29310n;
import com.tencent.p177mm.plugin.story.model.C29310n.C29311a;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.protocal.protobuf.cer;
import com.tencent.p177mm.protocal.protobuf.cfd;
import com.tencent.p177mm.protocal.protobuf.cfe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020\bJ>\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010+¨\u0006F"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", "isSelf", "", "mRoomId", "source", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "forSameMd5Count", "fp", "getFp", "()Z", "setFp", "(Z)V", "setSelf", "getMRoomId", "()Ljava/lang/String;", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getSource", "()I", "sourceType", "getUserName", "setUserName", "(Ljava/lang/String;)V", "deleteDeprecatedData", "", "storyId", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getInfo", "getType", "insertList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryUserPageResponse;", "isFavSelectSource", "isFavSource", "isProfileSource", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.a.j */
public final class C35194j extends C1207m implements C1918k {
    private static final String TAG = TAG;
    private static final Vector<String> qKd = new Vector();
    public static final C35195a rVc = new C35195a();
    public final int cvd;
    private int cvp;
    private boolean czr;
    private C7472b ehh;
    private C1202f ehi;
    private final String ejD;
    public boolean qIW;
    private long qIX;
    private long qIY;
    private String qJA;
    private int qJa;
    public long qKi;
    private long rUP;
    public String userName;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryUserPage$Companion;", "", "()V", "TAG", "", "userPageLock", "Ljava/util/Vector;", "addStoryUserReq", "", "muserName", "removeUserReq", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.a.j$a */
    public static final class C35195a {
        private C35195a() {
        }

        public /* synthetic */ C35195a(byte b) {
            this();
        }
    }

    public C35194j(String str, long j, boolean z, String str2, int i) {
        int cAO;
        C25052j.m39376p(str, "userName");
        C25052j.m39376p(str2, "mRoomId");
        AppMethodBeat.m2504i(109256);
        this.userName = str;
        this.qIX = j;
        this.czr = z;
        this.ejD = str2;
        this.cvd = i;
        this.qJA = "";
        if (this.qIX == 0) {
            C4990ab.m7416i(TAG, "fp mUserName " + this.userName);
        } else {
            C4990ab.m7416i(TAG, "np mUserName " + this.userName);
        }
        C35184a c35184a;
        if (this.czr) {
            c35184a = C35183a.sdm;
            cAO = C35183a.scw;
        } else {
            c35184a = C35183a.sdm;
            cAO = C35183a.scx;
        }
        this.cvp = cAO;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(new cfd());
        c1196a.mo4446b(new cfe());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmstoryuserpage");
        c1196a.mo4447kU(273);
        c1196a.mo4448kV(400);
        c1196a.mo4449kW(1000000400);
        C7472b acD = c1196a.acD();
        C25052j.m39375o(acD, "builder.buildInstance()");
        this.ehh = acD;
        C1331a acz = this.ehh.acz();
        C44941v c44941v;
        if (acz == null) {
            c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageRequest");
            AppMethodBeat.m2505o(109256);
            throw c44941v;
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
        if (C31820v.m51518a((CharSequence) this.ejD, "@", 0, false, 6) > 0) {
            str3 = this.ejD;
            a = C31820v.m51518a((CharSequence) this.ejD, "@", 0, false, 6);
            if (str3 == null) {
                c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(109256);
                throw c44941v;
            }
            substring = str3.substring(0, a);
            C25052j.m39375o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cfd.xeF = C5046bo.anl(substring);
        }
        cfd.xbx = 0;
        cfd.vEf = this.ejD;
        if (this.qIW) {
            a = this.cvd;
            C35184a c35184a2 = C35183a.sdm;
            C4133a c4133a;
            if (a == C35183a.sdl) {
                c4133a = C43644j.rST;
                C29296g cxU = C4133a.cxU();
                str3 = this.userName;
                C25052j.m39376p(str3, "userName");
                substring = cxU.aaU(str3).field_favoriteMd5;
                if (substring == null) {
                    substring = "";
                }
            } else {
                c4133a = C43644j.rST;
                substring = C4133a.cxU().aaV(this.userName);
            }
            this.qJA = substring;
            if (this.qJA == null) {
                this.qJA = "";
            }
            cfd.wZT = this.qJA;
        }
        this.rUP = this.qIX;
        C4990ab.m7416i(TAG, this + " req.mUserName:" + cfd.jBB + " req.MaxId:" + cfd.wZU + " req.MinFilterId:" + cfd.xbw + " req.LastRequestTime:" + cfd.xbx + " ChatRoomName " + this.ejD + " req.FirstPageMd5:" + cfd.wZT + " souorce:" + this.cvd);
        AppMethodBeat.m2505o(109256);
    }

    public /* synthetic */ C35194j(String str, boolean z, String str2) {
        C35184a c35184a = C35183a.sdm;
        this(str, 0, z, str2, C35183a.sdi);
        AppMethodBeat.m2504i(109257);
        AppMethodBeat.m2505o(109257);
    }

    static {
        AppMethodBeat.m2504i(109258);
        AppMethodBeat.m2505o(109258);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(109254);
        C25052j.m39376p(c1902e, "dispatcher");
        C25052j.m39376p(c1202f, "callback");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(109254);
        return a;
    }

    public final int getType() {
        return 273;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(109255);
        C4990ab.m7416i(TAG, this + " netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " source:" + this.cvd);
        C1331a acA = this.ehh.acA();
        if (acA == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserPageResponse");
            AppMethodBeat.m2505o(109255);
            throw c44941v;
        }
        cfe cfe = (cfe) acA;
        this.qKi = cfe.xdM;
        C1202f c1202f;
        if (i2 == 0 || i2 == 4) {
            Object obj;
            C4133a c4133a;
            int i4;
            String str2 = cfe.wZT;
            if (str2 == null) {
                str2 = "";
            }
            C4990ab.m7416i(TAG, "onGYNetEnd resp: ObjCount " + cfe.xeG + ", size " + cfe.xeH.size() + "; md5 req " + this.qJA + ", resp " + str2 + ", source: " + this.cvd + ", expiredTime:" + cfe.vAR);
            if (i2 == 0) {
                CharSequence charSequence = this.qJA;
                obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
                if (obj == null) {
                    if ((((CharSequence) str2).length() == 0 ? 1 : null) == null && C5046bo.isEqual(this.qJA, str2)) {
                        c4133a = C43644j.rST;
                        this.qIY = C4133a.cxT().mo74404b(this.qIW ? 0 : this.rUP, this.qJa, this.userName, this.czr);
                        C4990ab.m7416i(TAG, "md5 is nochange");
                        obj = 1;
                    }
                }
                i4 = this.cvd;
                C35184a c35184a = C35183a.sdm;
                if (i4 == C35183a.sdl) {
                    c4133a = C43644j.rST;
                    C4133a.cxU().mo47506gC(this.userName, str2);
                    obj = null;
                } else {
                    c4133a = C43644j.rST;
                    C4133a.cxU().mo47505gB(this.userName, str2);
                    obj = null;
                }
            } else {
                if (i2 == 4) {
                    C35184a c35184a2 = C35183a.sdm;
                    if (i3 == C35183a.scH) {
                        obj = 1;
                    }
                }
                obj = null;
            }
            if (obj != null) {
                c1202f = this.ehi;
                if (c1202f == null) {
                    C25052j.avw("callback");
                }
                c1202f.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(109255);
                return;
            }
            LinkedList linkedList = cfe.xeH;
            C25052j.m39375o(linkedList, "resp.ObjList");
            cer cer = (cer) C25035t.m39338fK(linkedList);
            this.qIX = cer != null ? cer.vQE : 0;
            linkedList = cfe.xeH;
            C25052j.m39375o(linkedList, "resp.ObjList");
            cer = (cer) C25035t.m39340fM(linkedList);
            this.qIY = cer != null ? cer.vQE : 0;
            C4990ab.m7416i(TAG, "onGYNetEnd replace insert " + cfe.xeH.size() + ", max " + this.qIX + ", min " + this.qIY);
            C4990ab.m7416i(TAG, "determin clear fav: " + this.cvd + ", " + i3 + ", " + this.qIW);
            i4 = this.cvd;
            C35184a c35184a3 = C35183a.sdm;
            C29311a c29311a;
            if (i4 == C35183a.sdl && this.qIW) {
                C4990ab.m7416i(TAG, "fetch first page, clear all fav");
                c4133a = C43644j.rST;
                C46275k cxT = C4133a.cxT();
                str2 = this.userName;
                String str3 = this.userName;
                C4133a c4133a2 = C43644j.rST;
                for (C39879j c39879j : cxT.mo74407bx(str2, C5046bo.isEqual(str3, C4133a.cnk()))) {
                    C29311a c29311a2 = C29310n.rTi;
                    C29311a.m46538fK((int) c39879j.xDa, 0);
                }
                c29311a = C29310n.rTi;
                C29311a.m46534b(this.userName, cfe.xeH, this.cvp);
            } else {
                i4 = this.cvd;
                c35184a3 = C35183a.sdm;
                if (i4 == C35183a.sdi) {
                    List a;
                    if (this.czr) {
                        c4133a = C43644j.rST;
                        a = C4133a.cxT().mo74399a(this.userName, true, C1839cb.aaF() - 86400, true);
                    } else {
                        c4133a = C43644j.rST;
                        a = C4133a.cxT().mo74406bw(this.userName, false);
                    }
                    for (C39879j c39879j2 : a) {
                        if (c39879j2.field_storyID != 0) {
                            linkedList = cfe.xeH;
                            C25052j.m39375o(linkedList, "resp.ObjList");
                            Iterable<cer> iterable = linkedList;
                            if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                                for (cer cer2 : iterable) {
                                    if (cer2.vQE == c39879j2.field_storyID) {
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
                            if (!(obj == null || c39879j2.cBW())) {
                                c4133a = C43644j.rST;
                                C4133a.cxT().mo74416lw(c39879j2.field_storyID);
                            }
                        }
                    }
                    c29311a = C29310n.rTi;
                    C39879j c39879j3 = (C39879j) C25035t.m39361x(C29311a.m46534b(this.userName, cfe.xeH, this.cvp), 0);
                    if (c39879j3 == null) {
                        C4990ab.m7416i(TAG, "onGYNetEnd clear ext sync");
                        C22241k c22241k = C22241k.rTc;
                        C22241k.aan(this.userName);
                    } else {
                        C4990ab.m7416i(TAG, "onGYNetEnd update ext sync, " + c39879j3.field_storyID + ' ' + c39879j3.field_createTime);
                        C22241k c22241k2 = C22241k.rTc;
                        C22241k.m33918a(this.userName, c39879j3);
                    }
                }
            }
            c1202f = this.ehi;
            if (c1202f == null) {
                C25052j.avw("callback");
            }
            c1202f.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(109255);
            return;
        }
        C4990ab.m7420w(TAG, "onGYNetEnd errorType:" + i2 + " errorCode:" + i3 + ", return");
        c1202f = this.ehi;
        if (c1202f == null) {
            C25052j.avw("callback");
        }
        c1202f.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(109255);
    }

    public final String getInfo() {
        return this.userName;
    }
}
