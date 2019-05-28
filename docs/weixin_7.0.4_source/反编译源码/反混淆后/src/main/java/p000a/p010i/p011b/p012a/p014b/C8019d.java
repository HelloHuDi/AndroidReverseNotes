package p000a.p010i.p011b.p012a.p014b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, dWq = {"tryLoadClass", "Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "fqName", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.d */
public final class C8019d {
    /* renamed from: a */
    public static final Class<?> m14203a(ClassLoader classLoader, String str) {
        Class<?> loadClass;
        AppMethodBeat.m2504i(119031);
        C25052j.m39376p(classLoader, "receiver$0");
        C25052j.m39376p(str, "fqName");
        try {
            loadClass = classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            loadClass = null;
        }
        AppMethodBeat.m2505o(119031);
        return loadClass;
    }
}
