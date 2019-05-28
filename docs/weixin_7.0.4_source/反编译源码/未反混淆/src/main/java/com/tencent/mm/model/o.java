package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.qe;
import java.util.ArrayList;
import java.util.List;

public final class o implements b {
    public final List<String> my(String str) {
        AppMethodBeat.i(5547);
        List my = n.my(str);
        AppMethodBeat.o(5547);
        return my;
    }

    public final int mA(String str) {
        AppMethodBeat.i(5548);
        int mA = n.mA(str);
        AppMethodBeat.o(5548);
        return mA;
    }

    public final boolean a(String str, ArrayList<String> arrayList, String str2) {
        AppMethodBeat.i(5549);
        boolean a = n.a(str, (ArrayList) arrayList, str2);
        AppMethodBeat.o(5549);
        return a;
    }

    public final String U(List<String> list) {
        AppMethodBeat.i(5550);
        String f = n.f((List) list, -1);
        AppMethodBeat.o(5550);
        return f;
    }

    public final boolean N(String str, int i) {
        AppMethodBeat.i(5551);
        boolean N = n.N(str, i);
        AppMethodBeat.o(5551);
        return N;
    }

    public final boolean a(String str, String str2, qe qeVar, String str3, a aVar, com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(5552);
        boolean a = n.a(str, str2, qeVar, 0, str3, aVar, bVar);
        AppMethodBeat.o(5552);
        return a;
    }
}
