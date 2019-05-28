package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C11647f;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C45882d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34029d;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C38937e;
import com.tencent.p177mm.protocal.protobuf.ach;
import com.tencent.p177mm.protocal.protobuf.aps;
import com.tencent.p177mm.protocal.protobuf.apt;
import com.tencent.p177mm.protocal.protobuf.cyi;
import com.tencent.p177mm.protocal.protobuf.cyj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.j */
public final class C34023j extends C45874a<aps, apt> {
    public String appName;
    public String lvA;
    public boolean lvJ;
    public boolean lvK;
    public String lvL;
    public String lvM;
    public C11646a lvN;
    public ArrayList<C34029d> lvO;
    public ArrayList<C34028c> lvP;
    public ArrayList<C38937e> lvQ;
    public ArrayList<String> lvR;
    public String lvS;
    public String lvT;
    public boolean lvU;
    public boolean lvV;
    public String lvW;
    private final WeakReference<C38927b<C34023j>> lvX;
    public C34024a lvY;
    public String lvz;

    /* renamed from: com.tencent.mm.plugin.exdevice.f.a.j$a */
    public interface C34024a {
        /* renamed from: a */
        void mo30743a(C34023j c34023j);
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo7173g(C1331a c1331a) {
        aps aps = (aps) c1331a;
        aps.lCH = this.appName;
        aps.fha = this.lvL;
        aps.wtL = this.lvK;
        aps.wtM = this.lvM;
    }

    public C34023j(String str, String str2, String str3, boolean z, C38927b<C34023j> c38927b) {
        AppMethodBeat.m2504i(19458);
        this.lvX = new WeakReference(c38927b);
        this.lvS = str;
        this.lvL = str;
        this.appName = C5046bo.nullAsNil(str2);
        this.lvK = z;
        this.lvM = str3;
        AppMethodBeat.m2505o(19458);
    }

    public final int getType() {
        return 1042;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19459);
        C4990ab.m7411d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            C11646a c11646a;
            apt apt = (apt) aTS();
            String str5 = "";
            this.lvP = new ArrayList();
            if (apt.vEx != null) {
                it = apt.vEx.iterator();
                while (it.hasNext()) {
                    ach ach = (ach) it.next();
                    C9638aw.m17190ZK();
                    if (C18628c.m29078XM().aoJ(ach.username)) {
                        str2 = apt.fha;
                        str3 = this.appName;
                        if (C5046bo.isNullOrNil(str2) || ach == null) {
                            C4990ab.m7420w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            C34028c c34028c = new C34028c();
                            c34028c.field_rankID = str2;
                            c34028c.field_username = ach.username;
                            c34028c.field_step = ach.hzv;
                            c34028c.field_appusername = str3;
                            C34028c obj2 = c34028c;
                        }
                        if (obj2 != null) {
                            this.lvP.add(obj2);
                        }
                    } else {
                        C9638aw.m17182Rg().mo14541a(new C20473h(ach.username, null), 0);
                    }
                }
            }
            this.lvO = new ArrayList();
            if (apt.wtN != null) {
                it = apt.wtN.iterator();
                while (it.hasNext()) {
                    C34029d c34029d;
                    cyi cyi = (cyi) it.next();
                    str2 = apt.fha;
                    str3 = this.appName;
                    if (C5046bo.isNullOrNil(str2) || cyi == null) {
                        C4990ab.m7420w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        c34029d = null;
                    } else {
                        c34029d = new C34029d();
                        c34029d.field_appusername = str3;
                        c34029d.field_rankID = str2;
                        c34029d.field_likecount = cyi.xtH;
                        c34029d.field_ranknum = cyi.xtG;
                        c34029d.field_score = cyi.score;
                        c34029d.field_selfLikeState = cyi.xtI;
                        c34029d.field_username = cyi.username;
                    }
                    if (c34029d != null) {
                        if (c34029d.field_ranknum == 1) {
                            str4 = c34029d.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.lvO.add(c34029d);
                        str5 = str4;
                    }
                }
            }
            this.lvQ = new ArrayList();
            if (apt.wtO != null) {
                it = apt.wtO.iterator();
                while (it.hasNext()) {
                    cyj cyj = (cyj) it.next();
                    str2 = apt.fha;
                    str3 = this.appName;
                    if (C5046bo.isNullOrNil(str2) || cyj == null) {
                        C4990ab.m7420w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj2 = null;
                    } else {
                        C38937e c38937e = new C38937e();
                        c38937e.field_appusername = str3;
                        c38937e.field_rankID = str2;
                        c38937e.field_timestamp = cyj.timestamp;
                        c38937e.field_username = cyj.username;
                        C38937e c38937e2 = c38937e;
                    }
                    if (obj2 != null) {
                        this.lvQ.add(obj2);
                    }
                }
            }
            this.lvR = new ArrayList();
            if (apt.wtG != null) {
                Iterator it2 = apt.wtG.iterator();
                while (it2.hasNext()) {
                    this.lvR.add((String) it2.next());
                }
            }
            if (!C5046bo.isNullOrNil(this.lvM)) {
                str5 = this.lvM;
            }
            String str6 = apt.wtP;
            String str7 = apt.wtQ;
            if (C5046bo.isNullOrNil(str5)) {
                C4990ab.m7420w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                c11646a = null;
            } else {
                c11646a = new C11646a();
                c11646a.field_username = str5;
                c11646a.field_championUrl = str6;
                c11646a.field_championMotto = str7;
            }
            this.lvN = c11646a;
            this.lvS = apt.fha;
            this.lvA = apt.wtI;
            this.lvz = apt.wtH;
            this.lvT = apt.wtR;
            this.lvU = apt.lvU;
            this.lvV = apt.wtU == 1;
            this.lvW = apt.wtV;
            this.lvJ = apt.wtK;
            C4990ab.m7410d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.lvL == null || !this.lvL.equals(this.lvS)) {
                C11647f c11647f = C45891ad.bpe().lwf;
                if (c11647f != null) {
                    c11647f.mo23403Ko(this.lvS);
                }
            }
            if (this.lvY != null && this.lvK) {
                this.lvY.mo30743a(this);
            }
            if (this.lvK) {
                C45891ad.boY().mo54566by(this.lvP);
            }
            C45882d boX = C45891ad.boX();
            if (C5046bo.isNullOrNil(this.lvS)) {
                C4990ab.m7420w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = boX.bSd.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.lvS});
                C4990ab.m7417i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", str4, Integer.valueOf(delete));
            }
            C45891ad.boX().mo73715g(this.lvS, this.lvO);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.lvU);
            objArr[1] = Integer.valueOf(this.lvP != null ? this.lvP.size() : 0);
            objArr[2] = Integer.valueOf(this.lvO != null ? this.lvO.size() : 0);
            objArr[3] = Integer.valueOf(this.lvQ != null ? this.lvQ.size() : 0);
            C4990ab.m7417i(str4, str5, objArr);
            C45891ad.bpb().mo35790a(this.lvS, this.appName, this.lvQ);
            if (this.lvN != null) {
                C45891ad.bpa().mo61825a(this.lvN);
            }
        }
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C38927b c38927b = (C38927b) this.lvX.get();
        if (c38927b != null) {
            c38927b.mo23473a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19459);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19460);
        apt apt = new apt();
        AppMethodBeat.m2505o(19460);
        return apt;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19461);
        aps aps = new aps();
        AppMethodBeat.m2505o(19461);
        return aps;
    }
}
