package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C31586ag;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C0014z;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C17238a;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C31696y;
import p000a.p010i.p011b.p012a.p015c.p033e.C37009a.C37018w;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C31706a.C31229a;
import p000a.p010i.p011b.p012a.p015c.p033e.p034b.C31706a.C31707c;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C31698a;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C44899j;
import p000a.p010i.p011b.p012a.p015c.p033e.p776a.C8167d;
import p000a.p010i.p011b.p012a.p015c.p035g.C37026o;

/* renamed from: a.i.b.a.c.e.b.a.k */
public final class C17262k {
    public static final C17262k ByH = new C17262k(C31586ag.emptyMap(), new C37020a(C17115v.AUP), "EMPTY");
    public static final C17262k ByI = new C17262k(C31586ag.emptyMap(), new C37020a(C17115v.AUP), "CORRUPTED");
    public static final C8172a ByJ = new C8172a();
    public final Map<String, C17264m> ByE;
    private final C37020a ByF;
    private final String ByG;

    /* renamed from: a.i.b.a.c.e.b.a.k$a */
    public static final class C8172a {
        private C8172a() {
        }

        public /* synthetic */ C8172a(byte b) {
            this();
        }

        /* renamed from: a */
        public static C17262k m14425a(byte[] bArr, String str, C17126b<? super C41421g, C37091y> c17126b) {
            AppMethodBeat.m2504i(121339);
            C25052j.m39376p(str, "debugName");
            C25052j.m39376p(c17126b, "reportIncompatibleVersionError");
            C17262k c17262k;
            if (bArr == null) {
                c17262k = C17262k.ByH;
                AppMethodBeat.m2505o(121339);
                return c17262k;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            try {
                int readInt = dataInputStream.readInt();
                int[] iArr = new int[readInt];
                for (int i = 0; i < readInt; i++) {
                    iArr[i] = dataInputStream.readInt();
                }
                C41421g c41421g = new C41421g(Arrays.copyOf(iArr, readInt));
                if (c41421g.ehy()) {
                    C41421g c41421g2 = new C41421g(iArr, ((C44899j.m82119a((C31698a) c41421g) ? dataInputStream.readInt() : 0) & 1) != 0);
                    if (c41421g2.ehy()) {
                        C31229a Q = C31229a.m50362Q(dataInputStream);
                        if (Q == null) {
                            c17262k = C17262k.ByH;
                            AppMethodBeat.m2505o(121339);
                            return c17262k;
                        }
                        Map map;
                        C17264m c17264m;
                        String str2;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (C31707c c31707c : Q.Bxl) {
                            List list;
                            Integer num;
                            C25052j.m39375o(c31707c, "proto");
                            String egA = c31707c.egA();
                            map = linkedHashMap;
                            C25052j.m39375o(egA, "packageFqName");
                            C17264m c17264m2 = map.get(egA);
                            if (c17264m2 == null) {
                                c17264m2 = new C17264m(egA);
                                map.put(egA, c17264m2);
                                c17264m = c17264m2;
                            } else {
                                c17264m = c17264m2;
                            }
                            C17264m c17264m3 = c17264m;
                            C37026o<String> c37026o = c31707c.Bxs;
                            C25052j.m39375o(c37026o, "proto.shortClassNameList");
                            int i2 = 0;
                            for (String str3 : c37026o) {
                                list = c31707c.Bxt;
                                C25052j.m39375o(list, "proto.multifileFacadeShortNameIdList");
                                num = (Integer) C25035t.m39361x(list, i2);
                                num = num != null ? Integer.valueOf(num.intValue() - 1) : null;
                                if (num != null) {
                                    C37026o c37026o2 = c31707c.Bxv;
                                    C25052j.m39375o(c37026o2, "proto.multifileFacadeShortNameList");
                                    str2 = (String) C25035t.m39361x(c37026o2, num.intValue());
                                } else {
                                    str2 = null;
                                }
                                str2 = str2 != null ? C17263l.m26731iX(egA, str2) : null;
                                C25052j.m39375o(str3, "partShortName");
                                c17264m3.mo31331iY(C17263l.m26731iX(egA, str3), str2);
                                i2++;
                            }
                            c37026o = c31707c.Bxw;
                            C25052j.m39375o(c37026o, "proto.classWithJvmPackageNameShortNameList");
                            readInt = 0;
                            for (String str32 : c37026o) {
                                list = c31707c.Bxx;
                                C25052j.m39375o(list, "proto.classWithJvmPackageNamePackageIdList");
                                num = (Integer) C25035t.m39361x(list, readInt);
                                if (num == null) {
                                    list = c31707c.Bxx;
                                    C25052j.m39375o(list, "proto.classWithJvmPackageNamePackageIdList");
                                    num = (Integer) C25035t.m39340fM(list);
                                }
                                if (num != null) {
                                    int intValue = num.intValue();
                                    C37026o c37026o3 = Q.Bxn;
                                    C25052j.m39375o(c37026o3, "moduleProto.jvmPackageNameList");
                                    str2 = (String) C25035t.m39361x(c37026o3, intValue);
                                    if (str2 != null) {
                                        C25052j.m39375o(str32, "partShortName");
                                        c17264m3.mo31331iY(C17263l.m26731iX(str2, str32), null);
                                    }
                                }
                                readInt++;
                            }
                        }
                        for (C31707c c31707c2 : Q.Bxm) {
                            map = linkedHashMap;
                            C25052j.m39375o(c31707c2, "proto");
                            String egA2 = c31707c2.egA();
                            C25052j.m39375o(egA2, "proto.packageFqName");
                            C17264m c17264m4 = map.get(egA2);
                            if (c17264m4 == null) {
                                String egA3 = c31707c2.egA();
                                C25052j.m39375o(egA3, "proto.packageFqName");
                                c17264m4 = new C17264m(egA3);
                                map.put(egA2, c17264m4);
                                c17264m = c17264m4;
                            } else {
                                c17264m = c17264m4;
                            }
                            c17264m = c17264m;
                            C37026o<String> c37026o4 = c31707c2.Bxs;
                            C25052j.m39375o(c37026o4, "proto.shortClassNameList");
                            for (String str22 : c37026o4) {
                                C25052j.m39376p(str22, "shortName");
                                Set set = c17264m.ByL;
                                if (set == null) {
                                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
                                    AppMethodBeat.m2505o(121339);
                                    throw c44941v;
                                }
                                C0014z.m6dr(set).add(str22);
                            }
                        }
                        C31696y c31696y = Q.Bxo;
                        C25052j.m39375o(c31696y, "moduleProto.stringTable");
                        C37018w c37018w = Q.Bxp;
                        C25052j.m39375o(c37018w, "moduleProto.qualifiedNameTable");
                        C8167d c8167d = new C8167d(c31696y, c37018w);
                        List list2 = Q.BvA;
                        C25052j.m39375o(list2, "moduleProto.annotationList");
                        Iterable<C17238a> iterable = list2;
                        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
                        for (C17238a c17238a : iterable) {
                            C25052j.m39375o(c17238a, "proto");
                            arrayList.add(c8167d.mo17959Uh(c17238a.BsE));
                        }
                        c17262k = new C17262k(linkedHashMap, new C37020a((List) arrayList), str, (byte) 0);
                        AppMethodBeat.m2505o(121339);
                        return c17262k;
                    }
                    c17126b.mo50am(c41421g2);
                    c17262k = C17262k.ByH;
                    AppMethodBeat.m2505o(121339);
                    return c17262k;
                }
                c17126b.mo50am(c41421g);
                c17262k = C17262k.ByH;
                AppMethodBeat.m2505o(121339);
                return c17262k;
            } catch (IOException e) {
                c17262k = C17262k.ByI;
                AppMethodBeat.m2505o(121339);
                return c17262k;
            }
        }
    }

    private C17262k(Map<String, C17264m> map, C37020a c37020a, String str) {
        this.ByE = map;
        this.ByF = c37020a;
        this.ByG = str;
    }

    public /* synthetic */ C17262k(Map map, C37020a c37020a, String str, byte b) {
        this(map, c37020a, str);
    }

    public final String toString() {
        return this.ByG;
    }

    static {
        AppMethodBeat.m2504i(121340);
        AppMethodBeat.m2505o(121340);
    }
}
