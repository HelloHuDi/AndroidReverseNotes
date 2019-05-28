package com.tencent.p177mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.BaseIPCService;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService */
public class ToolsProcessIPCService extends BaseIPCService {
    static int eGQ = 0;

    public final String getProcessName() {
        return "com.tencent.mm:tools";
    }

    /* renamed from: Qb */
    public static boolean m63911Qb() {
        AppMethodBeat.m2504i(126226);
        if (eGQ == 0) {
            int i;
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100488");
            if (ll == null) {
                i = 0;
            } else {
                int i2;
                if (ll.isValid() && "1".equals(ll.dru().get("SAFEFLAG"))) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (ll.isValid() && "1".equals(ll.dru().get("TURNOFFTOOLMP"))) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i &= i2;
            }
            if (i != 0) {
                eGQ = 1;
            } else {
                eGQ = -1;
            }
        }
        if (eGQ > 0) {
            AppMethodBeat.m2505o(126226);
            return true;
        }
        AppMethodBeat.m2505o(126226);
        return false;
    }

    /* renamed from: a */
    public static <T extends C37866a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean m63912a(InputType inputType, Class<T> cls) {
        AppMethodBeat.m2504i(126227);
        if (C4996ah.amz(C4996ah.getPackageName() + ":tools")) {
            boolean a = C9549f.m17012a("com.tencent.mm:tools", inputType, cls, null);
            AppMethodBeat.m2505o(126227);
            return a;
        }
        AppMethodBeat.m2505o(126227);
        return false;
    }

    /* renamed from: b */
    public static <T extends C37866a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean m63914b(InputType inputType, Class<T> cls) {
        AppMethodBeat.m2504i(126228);
        boolean a = C9549f.m17012a("com.tencent.mm:tools", inputType, cls, null);
        if (!ToolsProcessIPCService.m63911Qb()) {
            a = C9549f.m17012a("com.tencent.mm:toolsmp", inputType, cls, null) && a;
        }
        AppMethodBeat.m2505o(126228);
        return a;
    }

    /* renamed from: a */
    public static <T extends C37866a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean m63913a(InputType inputType, Class<T> cls, C18507c<ResultType> c18507c) {
        AppMethodBeat.m2504i(126229);
        boolean a = C9549f.m17012a("com.tencent.mm:tools", inputType, cls, c18507c);
        AppMethodBeat.m2505o(126229);
        return a;
    }
}
