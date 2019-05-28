package com.tencent.mm.aj;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.hf;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends j<b> implements f {
    public static final String[] fnj = new String[]{j.a(b.ccO, "BizEnterprise")};
    public static hf fuK;
    private e bSd;
    private final l<a, a> fuL = new l<a, a>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11250);
            ((a) obj).a((a) obj2);
            AppMethodBeat.o(11250);
        }
    };

    public interface a {

        public static class a {
            public b fuN;
            public String fuO;
            public b fuP;
        }

        public enum b {
            INSERT,
            DELETE,
            UPDATE;

            static {
                AppMethodBeat.o(11253);
            }
        }

        void a(a aVar);
    }

    static {
        AppMethodBeat.i(11270);
        AppMethodBeat.o(11270);
    }

    public c(e eVar) {
        super(eVar, b.ccO, "BizEnterprise", null);
        AppMethodBeat.i(11254);
        this.bSd = eVar;
        eVar.hY("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        g.RO().eJo.a(1343, (f) this);
        g.RO().eJo.a(1228, (f) this);
        AppMethodBeat.o(11254);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(11255);
        this.fuL.a(aVar, looper);
        AppMethodBeat.o(11255);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11256);
        if (this.fuL != null) {
            this.fuL.remove(aVar);
        }
        AppMethodBeat.o(11256);
    }

    public final b qC(String str) {
        AppMethodBeat.i(11257);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11257);
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            AppMethodBeat.o(11257);
            return bVar;
        }
        a(str, null);
        AppMethodBeat.o(11257);
        return null;
    }

    public final b qD(String str) {
        AppMethodBeat.i(11258);
        b qC = qC(str);
        if (qC == null) {
            qC = new b();
            qC.field_userName = str;
            qC.field_qyUin = 0;
            qC.field_userUin = 0;
            qC.field_userFlag = 0;
            qC.field_wwExposeTimes = 0;
            qC.field_wwMaxExposeTimes = 0;
            qC.field_wwUserVid = 0;
            qC.field_wwCorpId = 0;
            qC.field_chatOpen = false;
            qC.field_wwUnreadCnt = 0;
            AppMethodBeat.o(11258);
            return qC;
        }
        AppMethodBeat.o(11258);
        return qC;
    }

    public final int qE(String str) {
        AppMethodBeat.i(11259);
        b qC = qC(str);
        if (qC == null) {
            AppMethodBeat.o(11259);
            return 0;
        }
        int i = qC.field_qyUin;
        AppMethodBeat.o(11259);
        return i;
    }

    public final boolean pI(String str) {
        boolean z = false;
        AppMethodBeat.i(11260);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11260);
        } else {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_userName = str;
            z = super.a(bVar, "userName");
            if (z) {
                a aVar = new a();
                aVar.fuO = str;
                aVar.fuN = b.DELETE;
                aVar.fuP = bVar;
                this.fuL.cF(aVar);
                this.fuL.doNotify();
            }
            AppMethodBeat.o(11260);
        }
        return z;
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(11261);
        if (bVar == null) {
            AppMethodBeat.o(11261);
            return false;
        }
        boolean b = super.b((com.tencent.mm.sdk.e.c) bVar);
        b bVar2 = b.INSERT;
        if (!b) {
            b = super.a(bVar);
            bVar2 = b.UPDATE;
        }
        if (b) {
            a aVar = new a();
            aVar.fuO = bVar.field_userName;
            aVar.fuN = bVar2;
            aVar.fuP = bVar;
            this.fuL.cF(aVar);
            this.fuL.doNotify();
        }
        AppMethodBeat.o(11261);
        return b;
    }

    private boolean a(km kmVar) {
        AppMethodBeat.i(11262);
        b qD = qD(kmVar.vNb);
        qD.field_userName = kmVar.vNb;
        qD.field_qyUin = kmVar.vNt;
        qD.field_userUin = kmVar.vNu;
        qD.field_wwMaxExposeTimes = kmVar.vNw;
        qD.field_wwUserVid = kmVar.vNx;
        qD.field_wwCorpId = kmVar.vNy;
        qD.field_userType = kmVar.vNz;
        qD.field_chatOpen = kmVar.vNA;
        qD.field_wwUnreadCnt = kmVar.vNB;
        qD.field_show_confirm = kmVar.vNC;
        qD.field_use_preset_banner_tips = kmVar.vNE;
        fuK = kmVar.vND;
        if (kmVar.vNx == 0 && kmVar.vNy == 0 && kmVar.vNt != 0) {
            qD.field_wwUserVid = (long) kmVar.vNu;
            qD.field_wwCorpId = (long) kmVar.vNt;
        }
        kmVar.vNv &= -9;
        qD.field_userFlag = kmVar.vNv | (qD.field_userFlag & 8);
        boolean a = a(qD);
        AppMethodBeat.o(11262);
        return a;
    }

    public static boolean a(String str, f fVar) {
        AppMethodBeat.i(11263);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11263);
            return false;
        }
        int i;
        if (f.rc(str)) {
            i = 1;
        } else if (f.rb(str)) {
            i = 2;
        } else {
            AppMethodBeat.o(11263);
            return false;
        }
        boolean a = g.RO().eJo.a(new s(str, i, fVar), 0);
        AppMethodBeat.o(11263);
        return a;
    }

    public static y a(String str, boolean z, f fVar) {
        AppMethodBeat.i(11264);
        km kmVar = new km();
        kmVar.vNb = str;
        kmVar.vNv = z ? 1 : 0;
        kmVar.vNt = 0;
        m yVar = new y(kmVar, fVar);
        if (g.RO().eJo.a(yVar, 0)) {
            AppMethodBeat.o(11264);
            return yVar;
        }
        AppMethodBeat.o(11264);
        return null;
    }

    public final void qF(String str) {
        AppMethodBeat.i(11265);
        b qD = qD(str);
        if (qD.field_wwExposeTimes >= qD.field_wwMaxExposeTimes) {
            AppMethodBeat.o(11265);
            return;
        }
        qD.field_wwExposeTimes++;
        a(qD);
        AppMethodBeat.o(11265);
    }

    public static void a(y yVar) {
        AppMethodBeat.i(11266);
        g.RO().eJo.c((m) yVar);
        yVar.data = null;
        AppMethodBeat.o(11266);
    }

    public final boolean qG(String str) {
        AppMethodBeat.i(11267);
        b qC = qC(str);
        if (qC == null || (qC.field_userFlag & 1) == 0) {
            AppMethodBeat.o(11267);
            return false;
        }
        AppMethodBeat.o(11267);
        return true;
    }

    public static String lb(int i) {
        AppMethodBeat.i(11268);
        String str = null;
        if (fuK == null) {
            fuK = new hf();
        }
        switch (i) {
            case 0:
                str = fuK.vJP;
                break;
            case 1:
                str = fuK.vJQ;
                break;
            case 2:
                str = fuK.vJR;
                break;
        }
        AppMethodBeat.o(11268);
        return str;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = -1;
        AppMethodBeat.i(11269);
        if (i == 0 && i2 == 0) {
            f fVar;
            if (mVar instanceof s) {
                afu afu;
                s sVar = (s) mVar;
                if (sVar.ehh == null || sVar.ehh.fsH.fsP == null) {
                    afu = null;
                } else {
                    afu = (afu) sVar.ehh.fsH.fsP;
                }
                if (afu == null || afu.vNh == null || afu.vNh.ret != 0 || afu.wmX == null) {
                    AppMethodBeat.o(11269);
                    return;
                }
                if (!a(afu.wmX)) {
                    i2 = -1;
                }
                fVar = (f) sVar.data;
                if (fVar != null) {
                    fVar.onSceneEnd(i, i2, str, mVar);
                }
            }
            if (mVar instanceof y) {
                bxq bxq;
                y yVar = (y) mVar;
                if (yVar.ehh == null || yVar.ehh.fsH.fsP == null) {
                    bxq = null;
                } else {
                    bxq = (bxq) yVar.ehh.fsH.fsP;
                }
                if (bxq == null || bxq.vNh == null || bxq.vNh.ret != 0 || bxq.wmX == null) {
                    AppMethodBeat.o(11269);
                    return;
                }
                if (a(bxq.wmX)) {
                    i3 = i2;
                }
                fVar = (f) yVar.data;
                if (fVar != null) {
                    fVar.onSceneEnd(i, i3, str, mVar);
                }
            }
            AppMethodBeat.o(11269);
            return;
        }
        AppMethodBeat.o(11269);
    }
}
