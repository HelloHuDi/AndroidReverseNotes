package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.C44114dt;
import com.tencent.p177mm.protocal.protobuf.C7252av;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.af */
public final class C22055af {
    /* renamed from: a */
    public static int m33674a(Context context, C7252av c7252av) {
        AppMethodBeat.m2504i(38468);
        int i;
        if (c7252av == null) {
            AppMethodBeat.m2505o(38468);
            return 0;
        } else if (c7252av.jCt != 6) {
            i = c7252av.Scene;
            AppMethodBeat.m2505o(38468);
            return i;
        } else if (c7252av.vCA == null) {
            AppMethodBeat.m2505o(38468);
            return 0;
        } else if (C24826a.gkF.mo38874u(context, c7252av.vCy.fKh)) {
            i = c7252av.vCA.vFo;
            AppMethodBeat.m2505o(38468);
            return i;
        } else {
            i = c7252av.vCA.vFp;
            AppMethodBeat.m2505o(38468);
            return i;
        }
    }

    /* renamed from: a */
    public static void m33675a(Context context, C13633av c13633av, C7252av c7252av) {
        AppMethodBeat.m2504i(38469);
        if (!(c7252av == null || c7252av.vCy == null)) {
            boolean z;
            String str = c7252av.vCy.fKh;
            if (C5046bo.isNullOrNil(str)) {
                z = false;
            } else {
                C40439f bT = C46494g.m87739bT(str, true);
                if (bT == null || C5046bo.isNullOrNil(bT.field_appId)) {
                    z = false;
                } else {
                    if ((bT.field_appInfoFlag & 32) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C4990ab.m7419v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", bT.field_appId, Boolean.valueOf(z));
                }
            }
            if (z) {
                c13633av.rBh = false;
                String str2 = "";
                if (c7252av.vCC == null || c7252av.vCD == null) {
                    if (c7252av == null) {
                        str = "";
                    } else if (c7252av.jCt != 6) {
                        str = c7252av.vCz;
                    } else if (c7252av.vCB == null) {
                        str = "";
                    } else if (C24826a.gkF.mo38874u(context, c7252av.vCy.fKh)) {
                        str = c7252av.vCB.vFC;
                    } else {
                        str = c7252av.vCB.vFD;
                    }
                    try {
                        if (!C5046bo.isNullOrNil(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    C44114dt c44114dt;
                    if (C24826a.gkF.mo38874u(context, c7252av.vCy.fKh)) {
                        c44114dt = c7252av.vCC;
                    } else {
                        c44114dt = c7252av.vCD;
                    }
                    str2 = C4988aa.dor();
                    if (str2.equals("zh_CN")) {
                        str = c44114dt.vFA;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = c44114dt.vFB;
                    } else {
                        str = c44114dt.vFz;
                    }
                }
                switch (c7252av.jCt) {
                    case 4:
                        c13633av.rBi = str;
                        c13633av.rBh = true;
                        break;
                    case 5:
                        if (c7252av.Scene == 1) {
                            c13633av.rBi = str;
                            c13633av.rBh = true;
                            break;
                        }
                        break;
                    case 6:
                        c13633av.rBi = str;
                        c13633av.rBh = true;
                        break;
                    default:
                        c13633av.rBh = false;
                        break;
                }
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.OpenActionContent", "text can not load ?");
                    c13633av.rBh = false;
                }
                AppMethodBeat.m2505o(38469);
                return;
            }
        }
        c13633av.rBh = false;
        AppMethodBeat.m2505o(38469);
    }
}
