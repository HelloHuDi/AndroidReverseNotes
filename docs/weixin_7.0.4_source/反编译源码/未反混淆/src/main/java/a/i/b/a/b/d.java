package a.i.b.a.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, dWq = {"tryLoadClass", "Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "fqName", "", "descriptors.runtime"})
public final class d {
    public static final Class<?> a(ClassLoader classLoader, String str) {
        Class<?> loadClass;
        AppMethodBeat.i(119031);
        j.p(classLoader, "receiver$0");
        j.p(str, "fqName");
        try {
            loadClass = classLoader.loadClass(str);
        } catch (ClassNotFoundException e) {
            loadClass = null;
        }
        AppMethodBeat.o(119031);
        return loadClass;
    }
}
