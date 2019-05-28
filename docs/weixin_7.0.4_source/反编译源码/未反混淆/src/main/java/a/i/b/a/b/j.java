package a.i.b.a.b;

import a.a.t;
import a.a.v;
import a.f.b.k;
import a.i.b.a.c.d.b.s;
import a.i.b.a.c.e.b.a.g;
import a.i.b.a.c.e.b.a.m;
import a.l;
import a.y;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/PackagePartProvider;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "packageParts", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/HashMap;", "visitedModules", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "findPackageParts", "", "packageFqName", "getAnnotationsOnBinaryModule", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "moduleName", "registerModule", "", "EmptyEnumeration", "descriptors.runtime"})
public final class j implements s {
    private final HashSet<String> AZA = new HashSet();
    private final HashMap<String, LinkedHashSet<String>> AZB = new HashMap();
    private final ClassLoader AZr;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "version", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"})
    static final class b extends k implements a.f.a.b<g, y> {
        public static final b AZD = new b();

        static {
            AppMethodBeat.i(119053);
            AppMethodBeat.o(119053);
        }

        b() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(119052);
            g gVar = (g) obj;
            a.f.b.j.p(gVar, "version");
            Throwable unsupportedOperationException = new UnsupportedOperationException("Module was compiled with an incompatible version of Kotlin. The binary version of its metadata is " + gVar + ", expected version is " + g.Byu + ". Please update Kotlin to the latest version");
            AppMethodBeat.o(119052);
            throw unsupportedOperationException;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider$EmptyEnumeration;", "Ljava/util/Enumeration;", "", "()V", "hasMoreElements", "", "nextElement", "descriptors.runtime"})
    static final class a implements Enumeration {
        public static final a AZC = new a();

        static {
            AppMethodBeat.i(119051);
            AppMethodBeat.o(119051);
        }

        private a() {
        }

        public final boolean hasMoreElements() {
            return false;
        }

        public final /* synthetic */ Object nextElement() {
            AppMethodBeat.i(119050);
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(119050);
            throw noSuchElementException;
        }
    }

    public j(ClassLoader classLoader) {
        a.f.b.j.p(classLoader, "classLoader");
        AppMethodBeat.i(119056);
        this.AZr = classLoader;
        AppMethodBeat.o(119056);
    }

    public final synchronized void ar(String str) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(119054);
        a.f.b.j.p(str, "moduleName");
        if (this.AZA.add(str)) {
            Object resources;
            String str2 = "META-INF/" + str + ".kotlin_module";
            try {
                resources = this.AZr.getResources(str2);
            } catch (IOException e) {
                Enumeration resources2 = a.AZC;
            }
            a.f.b.j.o(resources2, "resources");
            a.f.b.j.p(resources2, "receiver$0");
            Iterator aVar = new a.a.n.a(resources2);
            while (aVar.hasNext()) {
                try {
                    InputStream openStream = ((URL) aVar.next()).openStream();
                    if (openStream != null) {
                        Closeable closeable = openStream;
                        try {
                            InputStream inputStream = (InputStream) closeable;
                            a.i.b.a.c.e.b.a.k.a aVar2 = a.i.b.a.c.e.b.a.k.ByJ;
                            a.f.b.j.p(inputStream, "receiver$0");
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(Utility.DEFAULT_STREAM_BUFFER_SIZE, inputStream.available()));
                            a.e.a.d(inputStream, byteArrayOutputStream);
                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                            a.f.b.j.o(toByteArray, "buffer.toByteArray()");
                            a.i.b.a.c.j.a.j jVar = a.i.b.a.c.j.a.j.a.BHa;
                            a.f.a.b bVar = b.AZD;
                            a.f.b.j.p(aVar2, "receiver$0");
                            a.f.b.j.p(str2, "debugName");
                            a.f.b.j.p(jVar, "configuration");
                            a.f.b.j.p(bVar, "reportIncompatibleVersionError");
                            for (Entry entry : a.i.b.a.c.e.b.a.k.a.a(toByteArray, str2, bVar).ByE.entrySet()) {
                                LinkedHashSet linkedHashSet;
                                String str3 = (String) entry.getKey();
                                m mVar = (m) entry.getValue();
                                Map map = this.AZB;
                                LinkedHashSet linkedHashSet2 = map.get(str3);
                                if (linkedHashSet2 == null) {
                                    linkedHashSet2 = new LinkedHashSet();
                                    map.put(str3, linkedHashSet2);
                                    linkedHashSet = linkedHashSet2;
                                } else {
                                    linkedHashSet = linkedHashSet2;
                                }
                                linkedHashSet.addAll(mVar.ehA());
                            }
                            y yVar = y.AUy;
                            a.e.b.a(closeable, null);
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            a.e.b.a(closeable, th2);
                            AppMethodBeat.o(119054);
                            throw th;
                        }
                    }
                    continue;
                } catch (UnsupportedOperationException e2) {
                    Throwable th4 = e2;
                    AppMethodBeat.o(119054);
                    throw th4;
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.o(119054);
        } else {
            AppMethodBeat.o(119054);
        }
    }

    public final synchronized List<String> avA(String str) {
        List<String> m;
        AppMethodBeat.i(119055);
        a.f.b.j.p(str, "packageFqName");
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.AZB.get(str);
        if (linkedHashSet != null) {
            m = t.m(linkedHashSet);
        } else {
            m = null;
        }
        if (m == null) {
            m = v.AUP;
        }
        AppMethodBeat.o(119055);
        return m;
    }
}
