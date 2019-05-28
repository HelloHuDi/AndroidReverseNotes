package a.i.b.a.c.i.d;

import a.i.b.a.c.a.h;
import a.i.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum c {
    BOOLEAN(h.BOOLEAN, DownloadSetting.TYPE_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(h.CHAR, "char", "C", "java.lang.Character"),
    BYTE(h.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(h.SHORT, "short", "S", "java.lang.Short"),
    INT(h.INT, "int", "I", "java.lang.Integer"),
    FLOAT(h.FLOAT, "float", "F", "java.lang.Float"),
    LONG(h.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(h.DOUBLE, "double", QLog.TAG_REPORTLEVEL_DEVELOPER, "java.lang.Double");
    
    private static final Set<b> BFm = null;
    private static final Map<String, c> BFn = null;
    private static final Map<h, c> BFo = null;
    private static final Map<String, c> BFp = null;
    public final h BFq;
    public final b BFr;
    public final String desc;
    public final String name;

    static {
        BFm = new HashSet();
        BFn = new HashMap();
        BFo = new EnumMap(h.class);
        BFp = new HashMap();
        c[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            c cVar = values[i];
            BFm.add(cVar.BFr);
            BFn.put(cVar.name, cVar);
            BFo.put(cVar.BFq, cVar);
            BFp.put(cVar.desc, cVar);
            i++;
        }
        AppMethodBeat.o(122167);
    }

    public static c awk(String str) {
        AppMethodBeat.i(122164);
        c cVar = (c) BFn.get(str);
        if (cVar == null) {
            AssertionError assertionError = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(str)));
            AppMethodBeat.o(122164);
            throw assertionError;
        }
        AppMethodBeat.o(122164);
        return cVar;
    }

    public static c d(h hVar) {
        AppMethodBeat.i(122165);
        c cVar = (c) BFo.get(hVar);
        AppMethodBeat.o(122165);
        return cVar;
    }

    private c(h hVar, String str, String str2, String str3) {
        AppMethodBeat.i(122166);
        this.BFq = hVar;
        this.name = str;
        this.desc = str2;
        this.BFr = new b(str3);
        AppMethodBeat.o(122166);
    }
}
