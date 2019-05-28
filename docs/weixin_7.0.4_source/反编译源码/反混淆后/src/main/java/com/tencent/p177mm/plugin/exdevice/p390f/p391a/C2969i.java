package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.exdevice.model.C45891ad;
import com.tencent.p177mm.plugin.exdevice.p1545a.C38927b;
import com.tencent.p177mm.plugin.exdevice.p1545a.C45874a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.C45883b;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p1256b.C34030a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C11646a;
import com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a.C34028c;
import com.tencent.p177mm.protocal.protobuf.C44146mq;
import com.tencent.p177mm.protocal.protobuf.ach;
import com.tencent.p177mm.protocal.protobuf.apq;
import com.tencent.p177mm.protocal.protobuf.apr;
import com.tencent.p177mm.protocal.protobuf.cdo;
import com.tencent.p177mm.protocal.protobuf.cyk;
import com.tencent.p177mm.protocal.protobuf.cyl;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.i */
public final class C2969i extends C45874a<apq, apr> {
    public String appName;
    private final WeakReference<C38927b<C2969i>> lqU;
    public String lvA;
    public List<cdo> lvB;
    public List<cyl> lvC;
    public cyk lvD;
    public ArrayList<String> lvE;
    public List<ach> lvF;
    public List<C44146mq> lvG;
    public boolean lvH;
    public int lvI;
    public boolean lvJ;
    public String lvw;
    public String lvx;
    public String lvy;
    public String lvz;
    public String source;
    public String username;

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo7173g(C1331a c1331a) {
        apq apq = (apq) c1331a;
        apq.lCH = this.appName;
        apq.username = this.username;
    }

    public C2969i(String str, String str2, C38927b<C2969i> c38927b) {
        AppMethodBeat.m2504i(19454);
        C4990ab.m7411d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", str2, str);
        this.username = str;
        this.appName = str2;
        this.lqU = new WeakReference(c38927b);
        AppMethodBeat.m2505o(19454);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19455);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        C4990ab.m7411d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            apr apr = (apr) aTS();
            this.lvx = apr.wtC;
            this.lvy = apr.lvy;
            this.lvC = apr.wtF;
            this.lvD = apr.wtD;
            this.lvz = apr.wtH;
            this.source = apr.source;
            this.lvA = apr.wtI;
            this.lvB = apr.vFi;
            this.lvH = apr.lvH;
            this.lvF = apr.vEx;
            this.lvG = apr.wtJ;
            this.lvE = new ArrayList();
            this.lvI = apr.lCg;
            this.lvJ = apr.wtK;
            this.lvw = apr.lvw;
            if (apr.wtG != null) {
                this.lvE.addAll(apr.wtG);
            }
            this.lvB = new LinkedList();
            if (apr.vFi != null) {
                this.lvB.addAll(apr.vFi);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(C1853r.m3846Yz()))) {
                if (this.lvH) {
                    C34030a boY = C45891ad.boY();
                    String str2 = this.username;
                    if (boY.mo54563a(new C45883b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        C34028c c34028c = new C34028c();
                        c34028c.field_rankID = "hardcode_rank_id";
                        c34028c.field_appusername = "hardcode_app_name";
                        c34028c.field_username = str2;
                        c34028c.field_step = 0;
                        boY.mo10101b((C4925c) c34028c);
                    }
                } else {
                    C45891ad.boY().mo54562Kq(this.username);
                }
            }
            if (apr.vEx != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = apr.vEx.iterator();
                while (it.hasNext()) {
                    ach ach = (ach) it.next();
                    C9638aw.m17190ZK();
                    if (C18628c.m29078XM().aoJ(ach.username)) {
                        C34028c c34028c2 = new C34028c();
                        c34028c2.field_username = ach.username;
                        c34028c2.field_step = ach.hzv;
                        arrayList.add(c34028c2);
                    } else {
                        C9638aw.m17182Rg().mo14541a(new C20473h(ach.username, null), 0);
                    }
                }
                C4990ab.m7411d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", Integer.valueOf(arrayList.size()), arrayList.toString());
                if (C1853r.m3846Yz().equalsIgnoreCase(this.username)) {
                    C45891ad.boY().mo54566by(arrayList);
                }
            }
            this.lvG = new ArrayList();
            if (apr.wtJ != null) {
                this.lvG.addAll(apr.wtJ);
            }
            this.lvH = apr.lvH;
            C11646a c11646a = new C11646a();
            c11646a.field_championMotto = this.lvy;
            c11646a.field_championUrl = this.lvx;
            c11646a.field_username = this.username;
            C45891ad.bpa().mo61825a(c11646a);
        }
        C38927b c38927b = (C38927b) this.lqU.get();
        if (c38927b != null) {
            c38927b.mo23473a(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19455);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
    }

    public final /* synthetic */ C1331a boo() {
        AppMethodBeat.m2504i(19456);
        apr apr = new apr();
        AppMethodBeat.m2505o(19456);
        return apr;
    }

    public final /* synthetic */ C1331a bon() {
        AppMethodBeat.m2504i(19457);
        apq apq = new apq();
        AppMethodBeat.m2505o(19457);
        return apq;
    }
}
