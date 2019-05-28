package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends com.tencent.mm.plugin.exdevice.a.a<aps, apt> {
    public String appName;
    public String lvA;
    public boolean lvJ;
    public boolean lvK;
    public String lvL;
    public String lvM;
    public com.tencent.mm.plugin.exdevice.f.b.a.a lvN;
    public ArrayList<d> lvO;
    public ArrayList<c> lvP;
    public ArrayList<e> lvQ;
    public ArrayList<String> lvR;
    public String lvS;
    public String lvT;
    public boolean lvU;
    public boolean lvV;
    public String lvW;
    private final WeakReference<b<j>> lvX;
    public a lvY;
    public String lvz;

    public interface a {
        void a(j jVar);
    }

    public final /* bridge */ /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
        aps aps = (aps) aVar;
        aps.lCH = this.appName;
        aps.fha = this.lvL;
        aps.wtL = this.lvK;
        aps.wtM = this.lvM;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        AppMethodBeat.i(19458);
        this.lvX = new WeakReference(bVar);
        this.lvS = str;
        this.lvL = str;
        this.appName = bo.nullAsNil(str2);
        this.lvK = z;
        this.lvM = str3;
        AppMethodBeat.o(19458);
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19459);
        ab.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            apt apt = (apt) aTS();
            String str5 = "";
            this.lvP = new ArrayList();
            if (apt.vEx != null) {
                it = apt.vEx.iterator();
                while (it.hasNext()) {
                    ach ach = (ach) it.next();
                    aw.ZK();
                    if (com.tencent.mm.model.c.XM().aoJ(ach.username)) {
                        str2 = apt.fha;
                        str3 = this.appName;
                        if (bo.isNullOrNil(str2) || ach == null) {
                            ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = ach.username;
                            cVar.field_step = ach.hzv;
                            cVar.field_appusername = str3;
                            c obj2 = cVar;
                        }
                        if (obj2 != null) {
                            this.lvP.add(obj2);
                        }
                    } else {
                        aw.Rg().a(new h(ach.username, null), 0);
                    }
                }
            }
            this.lvO = new ArrayList();
            if (apt.wtN != null) {
                it = apt.wtN.iterator();
                while (it.hasNext()) {
                    d dVar;
                    cyi cyi = (cyi) it.next();
                    str2 = apt.fha;
                    str3 = this.appName;
                    if (bo.isNullOrNil(str2) || cyi == null) {
                        ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = cyi.xtH;
                        dVar.field_ranknum = cyi.xtG;
                        dVar.field_score = cyi.score;
                        dVar.field_selfLikeState = cyi.xtI;
                        dVar.field_username = cyi.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.lvO.add(dVar);
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
                    if (bo.isNullOrNil(str2) || cyj == null) {
                        ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj2 = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = cyj.timestamp;
                        eVar.field_username = cyj.username;
                        e eVar2 = eVar;
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
            if (!bo.isNullOrNil(this.lvM)) {
                str5 = this.lvM;
            }
            String str6 = apt.wtP;
            String str7 = apt.wtQ;
            if (bo.isNullOrNil(str5)) {
                ab.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.lvN = aVar;
            this.lvS = apt.fha;
            this.lvA = apt.wtI;
            this.lvz = apt.wtH;
            this.lvT = apt.wtR;
            this.lvU = apt.lvU;
            this.lvV = apt.wtU == 1;
            this.lvW = apt.wtV;
            this.lvJ = apt.wtK;
            ab.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.lvL == null || !this.lvL.equals(this.lvS)) {
                f fVar = ad.bpe().lwf;
                if (fVar != null) {
                    fVar.Ko(this.lvS);
                }
            }
            if (this.lvY != null && this.lvK) {
                this.lvY.a(this);
            }
            if (this.lvK) {
                ad.boY().by(this.lvP);
            }
            com.tencent.mm.plugin.exdevice.f.b.b.d boX = ad.boX();
            if (bo.isNullOrNil(this.lvS)) {
                ab.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = boX.bSd.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.lvS});
                ab.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", str4, Integer.valueOf(delete));
            }
            ad.boX().g(this.lvS, this.lvO);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.lvU);
            objArr[1] = Integer.valueOf(this.lvP != null ? this.lvP.size() : 0);
            objArr[2] = Integer.valueOf(this.lvO != null ? this.lvO.size() : 0);
            objArr[3] = Integer.valueOf(this.lvQ != null ? this.lvQ.size() : 0);
            ab.i(str4, str5, objArr);
            ad.bpb().a(this.lvS, this.appName, this.lvQ);
            if (this.lvN != null) {
                ad.bpa().a(this.lvN);
            }
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lvX.get();
        if (bVar != null) {
            bVar.a(i2, i3, str, this);
        }
        AppMethodBeat.o(19459);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19460);
        apt apt = new apt();
        AppMethodBeat.o(19460);
        return apt;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19461);
        aps aps = new aps();
        AppMethodBeat.o(19461);
        return aps;
    }
}
