package p000a.p010i.p011b.p012a.p014b;

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
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p001a.C7988n.C7989a;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C36996s;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17262k;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17262k.C8172a;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17264m;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C41421g;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C37042j;
import p000a.p010i.p011b.p012a.p015c.p041j.p042a.C37042j.C37043a;
import p000a.p1582e.C41371a;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/PackagePartProvider;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "packageParts", "Ljava/util/HashMap;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/HashMap;", "visitedModules", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "findPackageParts", "", "packageFqName", "getAnnotationsOnBinaryModule", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "moduleName", "registerModule", "", "EmptyEnumeration", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.j */
public final class C44865j implements C36996s {
    private final HashSet<String> AZA = new HashSet();
    private final HashMap<String, LinkedHashSet<String>> AZB = new HashMap();
    private final ClassLoader AZr;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "version", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"})
    /* renamed from: a.i.b.a.b.j$b */
    static final class C0019b extends C25053k implements C17126b<C41421g, C37091y> {
        public static final C0019b AZD = new C0019b();

        static {
            AppMethodBeat.m2504i(119053);
            AppMethodBeat.m2505o(119053);
        }

        C0019b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(119052);
            C41421g c41421g = (C41421g) obj;
            C25052j.m39376p(c41421g, "version");
            Throwable unsupportedOperationException = new UnsupportedOperationException("Module was compiled with an incompatible version of Kotlin. The binary version of its metadata is " + c41421g + ", expected version is " + C41421g.Byu + ". Please update Kotlin to the latest version");
            AppMethodBeat.m2505o(119052);
            throw unsupportedOperationException;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lkotlin/reflect/jvm/internal/components/RuntimePackagePartProvider$EmptyEnumeration;", "Ljava/util/Enumeration;", "", "()V", "hasMoreElements", "", "nextElement", "descriptors.runtime"})
    /* renamed from: a.i.b.a.b.j$a */
    static final class C8023a implements Enumeration {
        public static final C8023a AZC = new C8023a();

        static {
            AppMethodBeat.m2504i(119051);
            AppMethodBeat.m2505o(119051);
        }

        private C8023a() {
        }

        public final boolean hasMoreElements() {
            return false;
        }

        public final /* synthetic */ Object nextElement() {
            AppMethodBeat.m2504i(119050);
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.m2505o(119050);
            throw noSuchElementException;
        }
    }

    public C44865j(ClassLoader classLoader) {
        C25052j.m39376p(classLoader, "classLoader");
        AppMethodBeat.m2504i(119056);
        this.AZr = classLoader;
        AppMethodBeat.m2505o(119056);
    }

    /* renamed from: ar */
    public final synchronized void mo72086ar(String str) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.m2504i(119054);
        C25052j.m39376p(str, "moduleName");
        if (this.AZA.add(str)) {
            Object resources;
            String str2 = "META-INF/" + str + ".kotlin_module";
            try {
                resources = this.AZr.getResources(str2);
            } catch (IOException e) {
                Enumeration resources2 = C8023a.AZC;
            }
            C25052j.m39375o(resources2, "resources");
            C25052j.m39376p(resources2, "receiver$0");
            Iterator c7989a = new C7989a(resources2);
            while (c7989a.hasNext()) {
                try {
                    InputStream openStream = ((URL) c7989a.next()).openStream();
                    if (openStream != null) {
                        Closeable closeable = openStream;
                        try {
                            InputStream inputStream = (InputStream) closeable;
                            C8172a c8172a = C17262k.ByJ;
                            C25052j.m39376p(inputStream, "receiver$0");
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(Utility.DEFAULT_STREAM_BUFFER_SIZE, inputStream.available()));
                            C41371a.m72154d(inputStream, byteArrayOutputStream);
                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                            C25052j.m39375o(toByteArray, "buffer.toByteArray()");
                            C37042j c37042j = C37043a.BHa;
                            C17126b c17126b = C0019b.AZD;
                            C25052j.m39376p(c8172a, "receiver$0");
                            C25052j.m39376p(str2, "debugName");
                            C25052j.m39376p(c37042j, "configuration");
                            C25052j.m39376p(c17126b, "reportIncompatibleVersionError");
                            for (Entry entry : C8172a.m14425a(toByteArray, str2, c17126b).ByE.entrySet()) {
                                LinkedHashSet linkedHashSet;
                                String str3 = (String) entry.getKey();
                                C17264m c17264m = (C17264m) entry.getValue();
                                Map map = this.AZB;
                                LinkedHashSet linkedHashSet2 = map.get(str3);
                                if (linkedHashSet2 == null) {
                                    linkedHashSet2 = new LinkedHashSet();
                                    map.put(str3, linkedHashSet2);
                                    linkedHashSet = linkedHashSet2;
                                } else {
                                    linkedHashSet = linkedHashSet2;
                                }
                                linkedHashSet.addAll(c17264m.ehA());
                            }
                            C37091y c37091y = C37091y.AUy;
                            C41372b.m72155a(closeable, null);
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            C41372b.m72155a(closeable, th2);
                            AppMethodBeat.m2505o(119054);
                            throw th;
                        }
                    }
                    continue;
                } catch (UnsupportedOperationException e2) {
                    Throwable th4 = e2;
                    AppMethodBeat.m2505o(119054);
                    throw th4;
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.m2505o(119054);
        } else {
            AppMethodBeat.m2505o(119054);
        }
    }

    public final synchronized List<String> avA(String str) {
        List<String> m;
        AppMethodBeat.m2504i(119055);
        C25052j.m39376p(str, "packageFqName");
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.AZB.get(str);
        if (linkedHashSet != null) {
            m = C25035t.m39352m(linkedHashSet);
        } else {
            m = null;
        }
        if (m == null) {
            m = C17115v.AUP;
        }
        AppMethodBeat.m2505o(119055);
        return m;
    }
}
