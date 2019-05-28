package com.tencent.mm.v;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/executor/FunctionExecutorFactory;", "", "()V", "FUNCTION_MSG_OP_DELAY", "", "FUNCTION_MSG_OP_DELETE", "FUNCTION_MSG_OP_SHOW", "FUNCTION_MSG_OP_UPDATE", "FUNCTION_MSG_OP_UPDATE_BUT_NO_SHOW", "get", "Lcom/tencent/mm/executor/IOpExecutor;", "op", "plugin-functionmsg_release"})
public final class a {
    public static final a eAM = new a();

    static {
        AppMethodBeat.i(35475);
        AppMethodBeat.o(35475);
    }

    private a() {
    }

    public static b jo(int i) {
        AppMethodBeat.i(35474);
        b gVar;
        switch (i) {
            case 0:
                gVar = new g();
                AppMethodBeat.o(35474);
                return gVar;
            case 1:
                gVar = new d();
                AppMethodBeat.o(35474);
                return gVar;
            case 2:
                gVar = new e();
                AppMethodBeat.o(35474);
                return gVar;
            case 3:
                gVar = new f();
                AppMethodBeat.o(35474);
                return gVar;
            case 101:
                gVar = new c();
                AppMethodBeat.o(35474);
                return gVar;
            default:
                AppMethodBeat.o(35474);
                return null;
        }
    }
}
