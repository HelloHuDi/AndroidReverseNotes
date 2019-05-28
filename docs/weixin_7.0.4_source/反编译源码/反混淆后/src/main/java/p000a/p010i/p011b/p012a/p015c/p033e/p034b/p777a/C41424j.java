package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C31826o;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C25133aa;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31694o;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C36656u;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37000c;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37011e;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C6143s;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C8154ai;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0093e;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0096g;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0108c;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C0092b.C0111a;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f.C17260b;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a.C17259f.C17261a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C25151f;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31700b.C17254a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31702c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C41420h;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C8169g;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C25158c;
import p000a.p010i.p011b.p012a.p015c.p035g.C25155i.C8180f;
import p000a.p010i.p011b.p012a.p015c.p035g.C31715g;

/* renamed from: a.i.b.a.c.e.b.a.j */
public final class C41424j {
    private static final C31715g ByC;
    public static final C41424j ByD = new C41424j();

    static {
        AppMethodBeat.m2504i(121338);
        C31715g eie = C31715g.eie();
        C0092b.m142a(eie);
        C25052j.m39375o(eie, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        ByC = eie;
        AppMethodBeat.m2505o(121338);
    }

    private C41424j() {
    }

    public static C31715g ehz() {
        return ByC;
    }

    /* renamed from: d */
    public static final C31826o<C41422h, C37000c> m72247d(String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(121328);
        C25052j.m39376p(strArr, "data");
        C25052j.m39376p(strArr2, "strings");
        byte[] af = C37021b.m61933af(strArr);
        C25052j.m39375o(af, "BitEncoding.decodeBytes(data)");
        C25052j.m39376p(af, "bytes");
        C25052j.m39376p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(af);
        C31826o c31826o = new C31826o(C41424j.m72245a(byteArrayInputStream, strArr2), C37000c.m61823a((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.m2505o(121328);
        return c31826o;
    }

    /* renamed from: e */
    public static final C31826o<C41422h, C6143s> m72248e(String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(121329);
        C25052j.m39376p(strArr, "data");
        C25052j.m39376p(strArr2, "strings");
        byte[] af = C37021b.m61933af(strArr);
        C25052j.m39375o(af, "BitEncoding.decodeBytes(data)");
        C25052j.m39376p(af, "bytes");
        C25052j.m39376p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(af);
        C31826o c31826o = new C31826o(C41424j.m72245a(byteArrayInputStream, strArr2), C6143s.m9717c((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.m2505o(121329);
        return c31826o;
    }

    /* renamed from: f */
    public static final C31826o<C41422h, C31694o> m72249f(String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(121330);
        C25052j.m39376p(strArr, "data");
        C25052j.m39376p(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C37021b.m61933af(strArr));
        C31826o c31826o = new C31826o(C41424j.m72245a(byteArrayInputStream, strArr2), C31694o.m51264b((InputStream) byteArrayInputStream, ByC));
        AppMethodBeat.m2505o(121330);
        return c31826o;
    }

    /* renamed from: a */
    private static C41422h m72245a(InputStream inputStream, String[] strArr) {
        AppMethodBeat.m2504i(121331);
        C0096g e = C0096g.m166e(inputStream, ByC);
        C25052j.m39375o(e, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
        C41422h c41422h = new C41422h(e, strArr);
        AppMethodBeat.m2505o(121331);
        return c41422h;
    }

    /* renamed from: a */
    public static C17260b m72244a(C31694o c31694o, C31702c c31702c, C41420h c41420h) {
        int i;
        String b;
        AppMethodBeat.m2504i(121332);
        C25052j.m39376p(c31694o, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25158c c25158c = c31694o;
        C8180f c8180f = C0092b.BxA;
        C25052j.m39375o(c8180f, "JvmProtoBuf.methodSignature");
        C0108c c0108c = (C0108c) C25151f.m39618a(c25158c, c8180f);
        if (c0108c == null || !c0108c.edW()) {
            i = c31694o.Buf;
        } else {
            i = c0108c.Buf;
        }
        if (c0108c == null || !c0108c.egL()) {
            Collection dm = C7987l.m14171dm(C8169g.m14418b(c31694o, c41420h));
            List list = c31694o.BtO;
            C25052j.m39375o(list, "proto.valueParameterList");
            Iterable<C8154ai> iterable = list;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C8154ai c8154ai : iterable) {
                C25052j.m39375o(c8154ai, "it");
                arrayList.add(C8169g.m14413a(c8154ai, c41420h));
            }
            Iterable<C25133aa> b2 = C25035t.m39331b(dm, (Iterable) (List) arrayList);
            Collection arrayList2 = new ArrayList(C25034m.m39318d(b2));
            for (C25133aa b3 : b2) {
                b = C41424j.m72246b(b3, c31702c);
                if (b == null) {
                    AppMethodBeat.m2505o(121332);
                    return null;
                }
                arrayList2.add(b);
            }
            list = (List) arrayList2;
            String b4 = C41424j.m72246b(C8169g.m14414a(c31694o, c41420h), c31702c);
            if (b4 == null) {
                AppMethodBeat.m2505o(121332);
                return null;
            }
            b = C25035t.m39322a((Iterable) list, (CharSequence) "", (CharSequence) "(", (CharSequence) ")", 0, null, null, 56) + b4;
        } else {
            b = c31702c.getString(c0108c.BxN);
        }
        C17260b c17260b = new C17260b(c31702c.getString(i), b);
        AppMethodBeat.m2505o(121332);
        return c17260b;
    }

    /* renamed from: a */
    public static C17260b m72243a(C37011e c37011e, C31702c c31702c, C41420h c41420h) {
        String str;
        String b;
        AppMethodBeat.m2504i(121333);
        C25052j.m39376p(c37011e, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25158c c25158c = c37011e;
        C8180f c8180f = C0092b.Bxz;
        C25052j.m39375o(c8180f, "JvmProtoBuf.constructorSignature");
        C0108c c0108c = (C0108c) C25151f.m39618a(c25158c, c8180f);
        if (c0108c == null || !c0108c.edW()) {
            str = "<init>";
        } else {
            str = c31702c.getString(c0108c.Buf);
        }
        if (c0108c == null || !c0108c.egL()) {
            List list = c37011e.BtO;
            C25052j.m39375o(list, "proto.valueParameterList");
            Iterable<C8154ai> iterable = list;
            Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
            for (C8154ai c8154ai : iterable) {
                C25052j.m39375o(c8154ai, "it");
                b = C41424j.m72246b(C8169g.m14413a(c8154ai, c41420h), c31702c);
                if (b == null) {
                    AppMethodBeat.m2505o(121333);
                    return null;
                }
                arrayList.add(b);
            }
            b = C25035t.m39322a((Iterable) (List) arrayList, (CharSequence) "", (CharSequence) "(", (CharSequence) ")V", 0, null, null, 56);
        } else {
            b = c31702c.getString(c0108c.BxN);
        }
        C17260b c17260b = new C17260b(str, b);
        AppMethodBeat.m2505o(121333);
        return c17260b;
    }

    /* renamed from: a */
    public static C17261a m72242a(C36656u c36656u, C31702c c31702c, C41420h c41420h, boolean z) {
        AppMethodBeat.m2504i(121334);
        C25052j.m39376p(c36656u, "proto");
        C25052j.m39376p(c31702c, "nameResolver");
        C25052j.m39376p(c41420h, "typeTable");
        C25158c c25158c = c36656u;
        C8180f c8180f = C0092b.BxC;
        C25052j.m39375o(c8180f, "JvmProtoBuf.propertySignature");
        C0093e c0093e = (C0093e) C25151f.m39618a(c25158c, c8180f);
        if (c0093e == null) {
            AppMethodBeat.m2505o(121334);
            return null;
        }
        C0111a c0111a;
        if (c0093e.egW()) {
            c0111a = c0093e.BxQ;
        } else {
            c0111a = null;
        }
        if (c0111a == null && z) {
            AppMethodBeat.m2505o(121334);
            return null;
        }
        int i;
        String b;
        if (c0111a == null || !c0111a.edW()) {
            i = c36656u.Buf;
        } else {
            i = c0111a.Buf;
        }
        if (c0111a == null || !c0111a.egL()) {
            b = C41424j.m72246b(C8169g.m14415a(c36656u, c41420h), c31702c);
            if (b == null) {
                AppMethodBeat.m2505o(121334);
                return null;
            }
        }
        b = c31702c.getString(c0111a.BxN);
        C17261a c17261a = new C17261a(c31702c.getString(i), b);
        AppMethodBeat.m2505o(121334);
        return c17261a;
    }

    /* renamed from: b */
    private static String m72246b(C25133aa c25133aa, C31702c c31702c) {
        AppMethodBeat.m2504i(121336);
        if (c25133aa.efc()) {
            String avV = C25152c.avV(c31702c.mo17959Uh(c25133aa.Bve));
            AppMethodBeat.m2505o(121336);
            return avV;
        }
        AppMethodBeat.m2505o(121336);
        return null;
    }

    /* renamed from: f */
    public static final boolean m72250f(C36656u c36656u) {
        AppMethodBeat.m2504i(121337);
        C25052j.m39376p(c36656u, "proto");
        C31705e c31705e = C31705e.Bys;
        C17254a ehw = C31705e.ehw();
        Object e = c36656u.mo42019e(C0092b.BxD);
        C25052j.m39375o(e, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean Ug = ehw.mo31314Ug(((Number) e).intValue());
        C25052j.m39375o(Ug, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        boolean booleanValue = Ug.booleanValue();
        AppMethodBeat.m2505o(121337);
        return booleanValue;
    }
}
