package com.tencent.mm.roomsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class b {
    private static b xuV = new b();
    private HashMap<String, a> xuU = new HashMap();

    public b() {
        AppMethodBeat.i(80238);
        AppMethodBeat.o(80238);
    }

    static {
        AppMethodBeat.i(80241);
        AppMethodBeat.o(80241);
    }

    public static a alY(String str) {
        AppMethodBeat.i(80239);
        int indexOf = str.indexOf("@");
        if (indexOf < 0) {
            ab.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", str);
            com.tencent.mm.roomsdk.a.a.b bVar = new com.tencent.mm.roomsdk.a.a.b();
            AppMethodBeat.o(80239);
            return bVar;
        }
        a aVar;
        String substring = str.substring(indexOf);
        b bVar2 = xuV;
        if (bVar2.xuU.containsKey(substring)) {
            aVar = (a) bVar2.xuU.get(substring);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            aVar = new com.tencent.mm.roomsdk.a.a.b();
            AppMethodBeat.o(80239);
            return aVar;
        }
        AppMethodBeat.o(80239);
        return aVar;
    }

    public static void a(String str, a aVar) {
        Object str2;
        AppMethodBeat.i(80240);
        int indexOf = str2.indexOf("@");
        if (indexOf >= 0) {
            str2 = str2.substring(indexOf);
        }
        b bVar = xuV;
        if (!bVar.xuU.containsKey(str2)) {
            bVar.xuU.put(str2, aVar);
        }
        AppMethodBeat.o(80240);
    }
}
