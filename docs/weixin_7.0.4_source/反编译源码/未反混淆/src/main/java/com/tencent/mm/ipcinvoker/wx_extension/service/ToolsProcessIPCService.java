package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;

public class ToolsProcessIPCService extends BaseIPCService {
    static int eGQ = 0;

    public final String getProcessName() {
        return "com.tencent.mm:tools";
    }

    public static boolean Qb() {
        AppMethodBeat.i(126226);
        if (eGQ == 0) {
            int i;
            a aVar = b.eGM;
            c ll = a.ll("100488");
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
            AppMethodBeat.o(126226);
            return true;
        }
        AppMethodBeat.o(126226);
        return false;
    }

    public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType inputType, Class<T> cls) {
        AppMethodBeat.i(126227);
        if (ah.amz(ah.getPackageName() + ":tools")) {
            boolean a = f.a("com.tencent.mm:tools", inputType, cls, null);
            AppMethodBeat.o(126227);
            return a;
        }
        AppMethodBeat.o(126227);
        return false;
    }

    public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType inputType, Class<T> cls) {
        AppMethodBeat.i(126228);
        boolean a = f.a("com.tencent.mm:tools", inputType, cls, null);
        if (!Qb()) {
            a = f.a("com.tencent.mm:toolsmp", inputType, cls, null) && a;
        }
        AppMethodBeat.o(126228);
        return a;
    }

    public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType inputType, Class<T> cls, com.tencent.mm.ipcinvoker.c<ResultType> cVar) {
        AppMethodBeat.i(126229);
        boolean a = f.a("com.tencent.mm:tools", inputType, cls, cVar);
        AppMethodBeat.o(126229);
        return a;
    }
}
