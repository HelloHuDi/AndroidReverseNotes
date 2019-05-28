package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class af {
    public static int a(Context context, av avVar) {
        AppMethodBeat.i(38468);
        int i;
        if (avVar == null) {
            AppMethodBeat.o(38468);
            return 0;
        } else if (avVar.jCt != 6) {
            i = avVar.Scene;
            AppMethodBeat.o(38468);
            return i;
        } else if (avVar.vCA == null) {
            AppMethodBeat.o(38468);
            return 0;
        } else if (a.gkF.u(context, avVar.vCy.fKh)) {
            i = avVar.vCA.vFo;
            AppMethodBeat.o(38468);
            return i;
        } else {
            i = avVar.vCA.vFp;
            AppMethodBeat.o(38468);
            return i;
        }
    }

    public static void a(Context context, av avVar, av avVar2) {
        AppMethodBeat.i(38469);
        if (!(avVar2 == null || avVar2.vCy == null)) {
            boolean z;
            String str = avVar2.vCy.fKh;
            if (bo.isNullOrNil(str)) {
                z = false;
            } else {
                f bT = g.bT(str, true);
                if (bT == null || bo.isNullOrNil(bT.field_appId)) {
                    z = false;
                } else {
                    if ((bT.field_appInfoFlag & 32) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ab.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", bT.field_appId, Boolean.valueOf(z));
                }
            }
            if (z) {
                avVar.rBh = false;
                String str2 = "";
                if (avVar2.vCC == null || avVar2.vCD == null) {
                    if (avVar2 == null) {
                        str = "";
                    } else if (avVar2.jCt != 6) {
                        str = avVar2.vCz;
                    } else if (avVar2.vCB == null) {
                        str = "";
                    } else if (a.gkF.u(context, avVar2.vCy.fKh)) {
                        str = avVar2.vCB.vFC;
                    } else {
                        str = avVar2.vCB.vFD;
                    }
                    try {
                        if (!bo.isNullOrNil(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    dt dtVar;
                    if (a.gkF.u(context, avVar2.vCy.fKh)) {
                        dtVar = avVar2.vCC;
                    } else {
                        dtVar = avVar2.vCD;
                    }
                    str2 = aa.dor();
                    if (str2.equals("zh_CN")) {
                        str = dtVar.vFA;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = dtVar.vFB;
                    } else {
                        str = dtVar.vFz;
                    }
                }
                switch (avVar2.jCt) {
                    case 4:
                        avVar.rBi = str;
                        avVar.rBh = true;
                        break;
                    case 5:
                        if (avVar2.Scene == 1) {
                            avVar.rBi = str;
                            avVar.rBh = true;
                            break;
                        }
                        break;
                    case 6:
                        avVar.rBi = str;
                        avVar.rBh = true;
                        break;
                    default:
                        avVar.rBh = false;
                        break;
                }
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.OpenActionContent", "text can not load ?");
                    avVar.rBh = false;
                }
                AppMethodBeat.o(38469);
                return;
            }
        }
        avVar.rBh = false;
        AppMethodBeat.o(38469);
    }
}
