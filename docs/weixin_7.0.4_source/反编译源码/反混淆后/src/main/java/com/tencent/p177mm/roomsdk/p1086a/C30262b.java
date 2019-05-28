package com.tencent.p177mm.roomsdk.p1086a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.roomsdk.p1086a.p1340a.C23479a;
import com.tencent.p177mm.roomsdk.p1086a.p1340a.C24946b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.roomsdk.a.b */
public final class C30262b {
    private static C30262b xuV = new C30262b();
    private HashMap<String, C23479a> xuU = new HashMap();

    public C30262b() {
        AppMethodBeat.m2504i(80238);
        AppMethodBeat.m2505o(80238);
    }

    static {
        AppMethodBeat.m2504i(80241);
        AppMethodBeat.m2505o(80241);
    }

    public static C23479a alY(String str) {
        AppMethodBeat.m2504i(80239);
        int indexOf = str.indexOf("@");
        if (indexOf < 0) {
            C4990ab.m7413e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", str);
            C24946b c24946b = new C24946b();
            AppMethodBeat.m2505o(80239);
            return c24946b;
        }
        C23479a c23479a;
        String substring = str.substring(indexOf);
        C30262b c30262b = xuV;
        if (c30262b.xuU.containsKey(substring)) {
            c23479a = (C23479a) c30262b.xuU.get(substring);
        } else {
            c23479a = null;
        }
        if (c23479a == null) {
            c23479a = new C24946b();
            AppMethodBeat.m2505o(80239);
            return c23479a;
        }
        AppMethodBeat.m2505o(80239);
        return c23479a;
    }

    /* renamed from: a */
    public static void m48141a(String str, C23479a c23479a) {
        Object str2;
        AppMethodBeat.m2504i(80240);
        int indexOf = str2.indexOf("@");
        if (indexOf >= 0) {
            str2 = str2.substring(indexOf);
        }
        C30262b c30262b = xuV;
        if (!c30262b.xuU.containsKey(str2)) {
            c30262b.xuU.put(str2, c23479a);
        }
        AppMethodBeat.m2505o(80240);
    }
}
