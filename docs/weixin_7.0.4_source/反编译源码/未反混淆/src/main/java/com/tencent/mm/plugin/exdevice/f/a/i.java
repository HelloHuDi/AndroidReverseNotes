package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<apq, apr> {
    public String appName;
    private final WeakReference<b<i>> lqU;
    public String lvA;
    public List<cdo> lvB;
    public List<cyl> lvC;
    public cyk lvD;
    public ArrayList<String> lvE;
    public List<ach> lvF;
    public List<mq> lvG;
    public boolean lvH;
    public int lvI;
    public boolean lvJ;
    public String lvw;
    public String lvx;
    public String lvy;
    public String lvz;
    public String source;
    public String username;

    public final /* bridge */ /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
        apq apq = (apq) aVar;
        apq.lCH = this.appName;
        apq.username = this.username;
    }

    public i(String str, String str2, b<i> bVar) {
        AppMethodBeat.i(19454);
        ab.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", str2, str);
        this.username = str;
        this.appName = str2;
        this.lqU = new WeakReference(bVar);
        AppMethodBeat.o(19454);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19455);
        super.a(i, i2, i3, str, qVar, bArr);
        ab.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
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
            if (!(this.username == null || this.username.equalsIgnoreCase(r.Yz()))) {
                if (this.lvH) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a boY = ad.boY();
                    String str2 = this.username;
                    if (boY.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        boY.b((com.tencent.mm.sdk.e.c) cVar);
                    }
                } else {
                    ad.boY().Kq(this.username);
                }
            }
            if (apr.vEx != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = apr.vEx.iterator();
                while (it.hasNext()) {
                    ach ach = (ach) it.next();
                    aw.ZK();
                    if (com.tencent.mm.model.c.XM().aoJ(ach.username)) {
                        c cVar2 = new c();
                        cVar2.field_username = ach.username;
                        cVar2.field_step = ach.hzv;
                        arrayList.add(cVar2);
                    } else {
                        aw.Rg().a(new h(ach.username, null), 0);
                    }
                }
                ab.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", Integer.valueOf(arrayList.size()), arrayList.toString());
                if (r.Yz().equalsIgnoreCase(this.username)) {
                    ad.boY().by(arrayList);
                }
            }
            this.lvG = new ArrayList();
            if (apr.wtJ != null) {
                this.lvG.addAll(apr.wtJ);
            }
            this.lvH = apr.lvH;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.lvy;
            aVar.field_championUrl = this.lvx;
            aVar.field_username = this.username;
            ad.bpa().a(aVar);
        }
        b bVar = (b) this.lqU.get();
        if (bVar != null) {
            bVar.a(i2, i3, str, this);
        }
        AppMethodBeat.o(19455);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_SHAKA_ADD2_8;
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19456);
        apr apr = new apr();
        AppMethodBeat.o(19456);
        return apr;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19457);
        apq apq = new apq();
        AppMethodBeat.o(19457);
        return apq;
    }
}
