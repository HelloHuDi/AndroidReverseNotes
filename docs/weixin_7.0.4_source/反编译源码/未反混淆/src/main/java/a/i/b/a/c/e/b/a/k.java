package a.i.b.a.c.e.b.a;

import a.a.ag;
import a.a.m;
import a.a.t;
import a.a.v;
import a.f.a.b;
import a.f.b.j;
import a.f.b.z;
import a.i.b.a.c.e.a.d;
import a.i.b.a.c.e.a.w;
import a.i.b.a.c.e.b.a.c;
import a.i.b.a.c.g.o;
import a.y;
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

public final class k {
    public static final k ByH = new k(ag.emptyMap(), new a(v.AUP), "EMPTY");
    public static final k ByI = new k(ag.emptyMap(), new a(v.AUP), "CORRUPTED");
    public static final a ByJ = new a();
    public final Map<String, m> ByE;
    private final a ByF;
    private final String ByG;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static k a(byte[] bArr, String str, b<? super g, y> bVar) {
            AppMethodBeat.i(121339);
            j.p(str, "debugName");
            j.p(bVar, "reportIncompatibleVersionError");
            k kVar;
            if (bArr == null) {
                kVar = k.ByH;
                AppMethodBeat.o(121339);
                return kVar;
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            try {
                int readInt = dataInputStream.readInt();
                int[] iArr = new int[readInt];
                for (int i = 0; i < readInt; i++) {
                    iArr[i] = dataInputStream.readInt();
                }
                g gVar = new g(Arrays.copyOf(iArr, readInt));
                if (gVar.ehy()) {
                    g gVar2 = new g(iArr, ((a.i.b.a.c.e.a.j.a((a.i.b.a.c.e.a.a) gVar) ? dataInputStream.readInt() : 0) & 1) != 0);
                    if (gVar2.ehy()) {
                        a.i.b.a.c.e.b.a.a Q = a.i.b.a.c.e.b.a.a.Q(dataInputStream);
                        if (Q == null) {
                            kVar = k.ByH;
                            AppMethodBeat.o(121339);
                            return kVar;
                        }
                        Map map;
                        m mVar;
                        String str2;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (c cVar : Q.Bxl) {
                            List list;
                            Integer num;
                            j.o(cVar, "proto");
                            String egA = cVar.egA();
                            map = linkedHashMap;
                            j.o(egA, "packageFqName");
                            m mVar2 = map.get(egA);
                            if (mVar2 == null) {
                                mVar2 = new m(egA);
                                map.put(egA, mVar2);
                                mVar = mVar2;
                            } else {
                                mVar = mVar2;
                            }
                            m mVar3 = mVar;
                            o<String> oVar = cVar.Bxs;
                            j.o(oVar, "proto.shortClassNameList");
                            int i2 = 0;
                            for (String str3 : oVar) {
                                list = cVar.Bxt;
                                j.o(list, "proto.multifileFacadeShortNameIdList");
                                num = (Integer) t.x(list, i2);
                                num = num != null ? Integer.valueOf(num.intValue() - 1) : null;
                                if (num != null) {
                                    o oVar2 = cVar.Bxv;
                                    j.o(oVar2, "proto.multifileFacadeShortNameList");
                                    str2 = (String) t.x(oVar2, num.intValue());
                                } else {
                                    str2 = null;
                                }
                                str2 = str2 != null ? l.iX(egA, str2) : null;
                                j.o(str3, "partShortName");
                                mVar3.iY(l.iX(egA, str3), str2);
                                i2++;
                            }
                            oVar = cVar.Bxw;
                            j.o(oVar, "proto.classWithJvmPackageNameShortNameList");
                            readInt = 0;
                            for (String str32 : oVar) {
                                list = cVar.Bxx;
                                j.o(list, "proto.classWithJvmPackageNamePackageIdList");
                                num = (Integer) t.x(list, readInt);
                                if (num == null) {
                                    list = cVar.Bxx;
                                    j.o(list, "proto.classWithJvmPackageNamePackageIdList");
                                    num = (Integer) t.fM(list);
                                }
                                if (num != null) {
                                    int intValue = num.intValue();
                                    o oVar3 = Q.Bxn;
                                    j.o(oVar3, "moduleProto.jvmPackageNameList");
                                    str2 = (String) t.x(oVar3, intValue);
                                    if (str2 != null) {
                                        j.o(str32, "partShortName");
                                        mVar3.iY(l.iX(str2, str32), null);
                                    }
                                }
                                readInt++;
                            }
                        }
                        for (c cVar2 : Q.Bxm) {
                            map = linkedHashMap;
                            j.o(cVar2, "proto");
                            String egA2 = cVar2.egA();
                            j.o(egA2, "proto.packageFqName");
                            m mVar4 = map.get(egA2);
                            if (mVar4 == null) {
                                String egA3 = cVar2.egA();
                                j.o(egA3, "proto.packageFqName");
                                mVar4 = new m(egA3);
                                map.put(egA2, mVar4);
                                mVar = mVar4;
                            } else {
                                mVar = mVar4;
                            }
                            mVar = mVar;
                            o<String> oVar4 = cVar2.Bxs;
                            j.o(oVar4, "proto.shortClassNameList");
                            for (String str22 : oVar4) {
                                j.p(str22, "shortName");
                                Set set = mVar.ByL;
                                if (set == null) {
                                    a.v vVar = new a.v("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
                                    AppMethodBeat.o(121339);
                                    throw vVar;
                                }
                                z.dr(set).add(str22);
                            }
                        }
                        a.i.b.a.c.e.a.y yVar = Q.Bxo;
                        j.o(yVar, "moduleProto.stringTable");
                        w wVar = Q.Bxp;
                        j.o(wVar, "moduleProto.qualifiedNameTable");
                        d dVar = new d(yVar, wVar);
                        List list2 = Q.BvA;
                        j.o(list2, "moduleProto.annotationList");
                        Iterable<a.i.b.a.c.e.a.a> iterable = list2;
                        Collection arrayList = new ArrayList(m.d(iterable));
                        for (a.i.b.a.c.e.a.a aVar : iterable) {
                            j.o(aVar, "proto");
                            arrayList.add(dVar.Uh(aVar.BsE));
                        }
                        kVar = new k(linkedHashMap, new a((List) arrayList), str, (byte) 0);
                        AppMethodBeat.o(121339);
                        return kVar;
                    }
                    bVar.am(gVar2);
                    kVar = k.ByH;
                    AppMethodBeat.o(121339);
                    return kVar;
                }
                bVar.am(gVar);
                kVar = k.ByH;
                AppMethodBeat.o(121339);
                return kVar;
            } catch (IOException e) {
                kVar = k.ByI;
                AppMethodBeat.o(121339);
                return kVar;
            }
        }
    }

    private k(Map<String, m> map, a aVar, String str) {
        this.ByE = map;
        this.ByF = aVar;
        this.ByG = str;
    }

    public /* synthetic */ k(Map map, a aVar, String str, byte b) {
        this(map, aVar, str);
    }

    public final String toString() {
        return this.ByG;
    }

    static {
        AppMethodBeat.i(121340);
        AppMethodBeat.o(121340);
    }
}
