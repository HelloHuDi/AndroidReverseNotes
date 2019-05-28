package p000a.p010i.p011b.p012a.p015c.p037i.p1366d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

/* renamed from: a.i.b.a.c.i.d.c */
public enum C25176c {
    BOOLEAN(C31622h.BOOLEAN, DownloadSetting.TYPE_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(C31622h.CHAR, "char", "C", "java.lang.Character"),
    BYTE(C31622h.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(C31622h.SHORT, "short", "S", "java.lang.Short"),
    INT(C31622h.INT, "int", "I", "java.lang.Integer"),
    FLOAT(C31622h.FLOAT, "float", "F", "java.lang.Float"),
    LONG(C31622h.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(C31622h.DOUBLE, "double", QLog.TAG_REPORTLEVEL_DEVELOPER, "java.lang.Double");
    
    private static final Set<C8174b> BFm = null;
    private static final Map<String, C25176c> BFn = null;
    private static final Map<C31622h, C25176c> BFo = null;
    private static final Map<String, C25176c> BFp = null;
    public final C31622h BFq;
    public final C8174b BFr;
    public final String desc;
    public final String name;

    static {
        BFm = new HashSet();
        BFn = new HashMap();
        BFo = new EnumMap(C31622h.class);
        BFp = new HashMap();
        C25176c[] values = C25176c.values();
        int length = values.length;
        int i;
        while (i < length) {
            C25176c c25176c = values[i];
            BFm.add(c25176c.BFr);
            BFn.put(c25176c.name, c25176c);
            BFo.put(c25176c.BFq, c25176c);
            BFp.put(c25176c.desc, c25176c);
            i++;
        }
        AppMethodBeat.m2505o(122167);
    }

    public static C25176c awk(String str) {
        AppMethodBeat.m2504i(122164);
        C25176c c25176c = (C25176c) BFn.get(str);
        if (c25176c == null) {
            AssertionError assertionError = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(122164);
            throw assertionError;
        }
        AppMethodBeat.m2505o(122164);
        return c25176c;
    }

    /* renamed from: d */
    public static C25176c m39661d(C31622h c31622h) {
        AppMethodBeat.m2504i(122165);
        C25176c c25176c = (C25176c) BFo.get(c31622h);
        AppMethodBeat.m2505o(122165);
        return c25176c;
    }

    private C25176c(C31622h c31622h, String str, String str2, String str3) {
        AppMethodBeat.m2504i(122166);
        this.BFq = c31622h;
        this.name = str;
        this.desc = str2;
        this.BFr = new C8174b(str3);
        AppMethodBeat.m2505o(122166);
    }
}
