package a.i.b.a.c.d.b;

import a.a.t;
import a.aa;
import a.f.a.q;
import a.f.b.j;
import a.i.b.a.c.a.f;
import a.i.b.a.c.a.g;
import a.i.b.a.c.a.k;
import a.i.b.a.c.b.ab;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.h;
import a.i.b.a.c.b.l;
import a.i.b.a.c.d.a.f.s;
import a.i.b.a.c.f.a;
import a.i.b.a.c.i.d.b;
import a.i.b.a.c.i.d.c;
import a.i.b.a.c.l.an;
import a.i.b.a.c.l.ap;
import a.i.b.a.c.l.av;
import a.i.b.a.c.l.ba;
import a.i.b.a.c.l.p;
import a.i.b.a.c.l.w;
import a.i.b.a.c.n.d;
import a.k.u;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class y {
    private static final <T> T a(k<T> kVar, T t, boolean z) {
        AppMethodBeat.i(120329);
        if (z) {
            Object dJ = kVar.dJ(t);
            AppMethodBeat.o(120329);
            return dJ;
        }
        AppMethodBeat.o(120329);
        return t;
    }

    public static /* synthetic */ Object a(w wVar, k kVar, w wVar2, u uVar) {
        AppMethodBeat.i(120331);
        Object a = a(wVar, kVar, wVar2, uVar, null, d.ekw(), false);
        AppMethodBeat.o(120331);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x004d A:{SYNTHETIC} */
    /* JADX WARNING: Missing block: B:46:0x0130, code skipped:
            if (r2 == null) goto L_0x0132;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(w wVar, k<T> kVar, w wVar2, u<? extends T> uVar, h<T> hVar, q<? super w, ? super T, ? super w, a.y> qVar, boolean z) {
        Object wVar3;
        e eVar;
        h dYs;
        T avN;
        v vVar;
        AppMethodBeat.i(120330);
        k kVar2 = kVar;
        while (true) {
            j.p(wVar3, "kotlinType");
            j.p(kVar2, "factory");
            j.p(wVar2, "mode");
            j.p(uVar, "typeMappingConfiguration");
            j.p(qVar, "writeGenericType");
            if (f.e(wVar3)) {
                wVar3 = k.F(wVar3);
            } else {
                Object avN2;
                h dYs2 = wVar3.ejw().dYs();
                if (!(dYs2 instanceof e)) {
                    dYs2 = null;
                }
                eVar = (e) dYs2;
                if (eVar != null) {
                    if (eVar == k.dXU()) {
                        avN2 = kVar2.avN(rM(false));
                    } else if (j.j(eVar, k.dXV())) {
                        avN2 = kVar2.avN(rM(true));
                    } else {
                        a.i.b.a.c.a.h d = g.d((l) eVar);
                        String str;
                        if (d != null) {
                            c d2 = c.d(d);
                            j.o(d2, "JvmPrimitiveType.get(primitiveType)");
                            str = d2.desc;
                            j.o(str, "JvmPrimitiveType.get(primitiveType).desc");
                            Object avM = kVar2.avM(str);
                            boolean z2 = av.aB(wVar3) || s.U(wVar3);
                            avN2 = a(kVar2, avM, z2);
                        } else {
                            d = g.e((l) eVar);
                            if (d != null) {
                                StringBuilder stringBuilder = new StringBuilder("[");
                                c d3 = c.d(d);
                                j.o(d3, "JvmPrimitiveType.get(arrayElementType)");
                                avN2 = kVar2.avM(stringBuilder.append(d3.desc).toString());
                            } else if (g.c((l) eVar)) {
                                a.i.b.a.c.a.b.c cVar = a.i.b.a.c.a.b.c.Bdq;
                                a c = a.i.b.a.c.a.b.c.c(a.i.b.a.c.i.c.a.q(eVar));
                                if (c != null) {
                                    if (!wVar2.BrR) {
                                        a.i.b.a.c.a.b.c cVar2 = a.i.b.a.c.a.b.c.Bdq;
                                        Iterable<a.i.b.a.c.a.b.c.a> dYB = a.i.b.a.c.a.b.c.dYB();
                                        if (!((dYB instanceof Collection) && ((Collection) dYB).isEmpty())) {
                                            for (a.i.b.a.c.a.b.c.a aVar : dYB) {
                                                if (j.j(aVar.Bdr, c)) {
                                                    avN2 = 1;
                                                    break;
                                                }
                                            }
                                        }
                                        avN2 = null;
                                    }
                                    b h = b.h(c);
                                    j.o(h, "JvmClassName.byClassId(classId)");
                                    str = h.BrD;
                                    j.o(str, "JvmClassName.byClassId(classId).internalName");
                                    avN2 = kVar2.avN(str);
                                }
                            }
                        }
                    }
                    if (avN2 == null) {
                        avN2 = a(kVar2, avN2, wVar2.BrM);
                        qVar.g(wVar3, avN2, wVar2);
                        AppMethodBeat.o(120330);
                        return avN2;
                    }
                    an ejw = wVar3.ejw();
                    if (ejw instanceof a.i.b.a.c.l.v) {
                        Set set = ((a.i.b.a.c.l.v) ejw).BJH;
                        j.o(set, "constructor.supertypes");
                        wVar3 = a.i.b.a.c.l.c.a.aN(uVar.m(set));
                    } else {
                        dYs = ejw.dYs();
                        Throwable unsupportedOperationException;
                        if (dYs == null) {
                            unsupportedOperationException = new UnsupportedOperationException("no descriptor for type constructor of ".concat(String.valueOf(wVar3)));
                            AppMethodBeat.o(120330);
                            throw unsupportedOperationException;
                        }
                        j.o(dYs, "constructor.declarationD…structor of $kotlinType\")");
                        w dZS;
                        if (p.L(dYs)) {
                            avN = kVar2.avN("error/NonExistentClass");
                            if (dYs == null) {
                                vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                                AppMethodBeat.o(120330);
                                throw vVar;
                            }
                            uVar.a(wVar3, (e) dYs);
                            if (hVar != null) {
                                hVar.dH(avN);
                            }
                            AppMethodBeat.o(120330);
                            return avN;
                        } else if ((dYs instanceof e) && g.n(wVar3)) {
                            if (wVar3.ejt().size() != 1) {
                                unsupportedOperationException = new UnsupportedOperationException("arrays must have one type argument");
                                AppMethodBeat.o(120330);
                                throw unsupportedOperationException;
                            }
                            ap apVar = (ap) wVar3.ejt().get(0);
                            dZS = apVar.dZS();
                            j.o(dZS, "memberProjection.type");
                            if (apVar.ekq() == ba.IN_VARIANCE) {
                                avN2 = kVar2.avN("java/lang/Object");
                                if (hVar != null) {
                                    hVar.ecs();
                                    hVar.dH(avN2);
                                }
                            } else {
                                w wVar4;
                                if (hVar != null) {
                                    hVar.ecs();
                                }
                                ba ekq = apVar.ekq();
                                j.o(ekq, "memberProjection.projectionKind");
                                j.p(ekq, "effectiveVariance");
                                switch (x.eQZ[ekq.ordinal()]) {
                                    case 1:
                                        wVar4 = wVar2.BrS;
                                        if (wVar4 == null) {
                                            wVar4 = wVar2;
                                            break;
                                        }
                                        break;
                                    case 2:
                                        wVar4 = wVar2.BrT;
                                        if (wVar4 == null) {
                                            wVar4 = wVar2;
                                            break;
                                        }
                                        break;
                                    default:
                                        wVar4 = wVar2.BrQ;
                                        if (wVar4 == null) {
                                            wVar4 = wVar2;
                                            break;
                                        }
                                        break;
                                }
                                avN2 = a(dZS, kVar2, wVar4, uVar, hVar, qVar, z);
                            }
                            avN = kVar2.avM("[" + kVar2.toString(avN2));
                            AppMethodBeat.o(120330);
                            return avN;
                        } else if (dYs instanceof e) {
                            if (!((e) dYs).dYj() || wVar2.BrN) {
                                break;
                            }
                            j.p(wVar3, "inlineClassType");
                            dZS = a(wVar3, new HashSet());
                            if (dZS == null) {
                                break;
                            }
                            wVar2 = new w(wVar2.BrM, true, wVar2.BoY, wVar2.BrO, wVar2.BrP, wVar2.BrQ, wVar2.BrR, wVar2.BrS, wVar2.BrT);
                            wVar3 = dZS;
                        } else if (dYs instanceof ar) {
                            avN = a(c((ar) dYs), kVar2, wVar2, uVar, null, d.ekw(), z);
                            if (hVar != null) {
                                a.i.b.a.c.f.f dZg = dYs.dZg();
                                j.o(dZg, "descriptor.getName()");
                                j.p(dZg, "name");
                                j.p(avN, "type");
                                hVar.dI(avN);
                            }
                            AppMethodBeat.o(120330);
                            return avN;
                        } else {
                            unsupportedOperationException = new UnsupportedOperationException("Unknown type ".concat(String.valueOf(wVar3)));
                            AppMethodBeat.o(120330);
                            throw unsupportedOperationException;
                        }
                    }
                }
                avN2 = null;
                if (avN2 == null) {
                }
            }
        }
        if (wVar2.BoY && g.g((e) dYs)) {
            avN = kVar2.ecu();
        } else {
            eVar = ((e) dYs).dZm();
            j.o(eVar, "descriptor.original");
            uVar.t(eVar);
            if (((e) dYs).dYc() == a.i.b.a.c.b.f.ENUM_ENTRY) {
                l dXW = ((e) dYs).dXW();
                if (dXW == null) {
                    vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    AppMethodBeat.o(120330);
                    throw vVar;
                }
                eVar = (e) dXW;
            } else {
                eVar = (e) dYs;
            }
            eVar = eVar.dZm();
            j.o(eVar, "enumClassIfEnumEntry.original");
            avN = kVar2.avN(a(eVar, (u) uVar, z));
        }
        qVar.g(wVar3, avN, wVar2);
        AppMethodBeat.o(120330);
        return avN;
    }

    private static final String rM(boolean z) {
        a.i.b.a.c.f.b bVar;
        AppMethodBeat.i(120332);
        if (z) {
            bVar = a.i.b.a.c.i.d.BDW;
        } else {
            bVar = a.i.b.a.c.i.d.BDV;
        }
        b h = b.h(a.n(bVar));
        j.o(h, "JvmClassName.byClassId(ClassId.topLevel(fqName))");
        String str = h.BrD;
        j.o(str, "JvmClassName.byClassId(C…vel(fqName)).internalName");
        AppMethodBeat.o(120332);
        return str;
    }

    private static w a(w wVar, HashSet<h> hashSet) {
        AppMethodBeat.i(120333);
        j.p(wVar, "kotlinType");
        j.p(hashSet, "visitedClassifiers");
        h dYs = wVar.ejw().dYs();
        if (dYs == null) {
            Throwable assertionError = new AssertionError("Type with a declaration expected: ".concat(String.valueOf(wVar)));
            AppMethodBeat.o(120333);
            throw assertionError;
        }
        j.o(dYs, "kotlinType.constructor.d…n expected: $kotlinType\")");
        w a;
        if (!hashSet.add(dYs)) {
            AppMethodBeat.o(120333);
            return null;
        } else if (dYs instanceof ar) {
            a = a(c((ar) dYs), hashSet);
            if (a == null) {
                AppMethodBeat.o(120333);
                return null;
            } else if (a.i.b.a.c.l.y.am(a) || !wVar.eci()) {
                AppMethodBeat.o(120333);
                return a;
            } else {
                wVar = a.i.b.a.c.l.c.a.az(a);
                AppMethodBeat.o(120333);
                return wVar;
            }
        } else if ((dYs instanceof e) && ((e) dYs).dYj()) {
            a = a.i.b.a.c.i.f.ac(wVar);
            if (a == null) {
                AppMethodBeat.o(120333);
                return null;
            }
            a = a(a, hashSet);
            if (a == null) {
                AppMethodBeat.o(120333);
                return null;
            } else if (!wVar.eci()) {
                AppMethodBeat.o(120333);
                return a;
            } else if (a.i.b.a.c.l.y.am(a)) {
                AppMethodBeat.o(120333);
                return wVar;
            } else if (g.p(a)) {
                AppMethodBeat.o(120333);
                return wVar;
            } else {
                wVar = a.i.b.a.c.l.c.a.az(a);
                AppMethodBeat.o(120333);
                return wVar;
            }
        } else {
            AppMethodBeat.o(120333);
            return wVar;
        }
    }

    public static final String a(e eVar, u<?> uVar, boolean z) {
        AppMethodBeat.i(120334);
        j.p(eVar, "klass");
        j.p(uVar, "typeMappingConfiguration");
        Object i = z ? i(eVar.dXW()) : eVar.dXW();
        a.i.b.a.c.f.f w = a.i.b.a.c.f.h.w(eVar.dZg());
        j.o(w, "SpecialNames.safeIdentifier(klass.name)");
        String ehN = w.ehN();
        j.o(ehN, "SpecialNames.safeIdentifier(klass.name).identifier");
        String str;
        if (i instanceof ab) {
            a.i.b.a.c.f.b dZF = ((ab) i).dZF();
            if (dZF.ByQ.ByV.isEmpty()) {
                AppMethodBeat.o(120334);
                return ehN;
            }
            StringBuilder stringBuilder = new StringBuilder();
            str = dZF.ByQ.ByV;
            j.o(str, "fqName.asString()");
            str = stringBuilder.append(u.a(str, '.', IOUtils.DIR_SEPARATOR_UNIX)).append(IOUtils.DIR_SEPARATOR_UNIX).append(ehN).toString();
            AppMethodBeat.o(120334);
            return str;
        }
        Object obj;
        if (i instanceof e) {
            obj = i;
        } else {
            obj = null;
        }
        e eVar2 = (e) obj;
        if (eVar2 == null) {
            Throwable illegalArgumentException = new IllegalArgumentException("Unexpected container: " + i + " for " + eVar);
            AppMethodBeat.o(120334);
            throw illegalArgumentException;
        }
        uVar.u(eVar2);
        str = a(eVar2, (u) uVar, z) + '$' + ehN;
        AppMethodBeat.o(120334);
        return str;
    }

    private static final l i(l lVar) {
        l lVar2 = null;
        AppMethodBeat.i(120335);
        while (true) {
            l lVar3;
            e eVar = (e) (!(lVar instanceof e) ? null : lVar);
            if (eVar != null) {
                lVar3 = eVar;
            } else {
                lVar3 = (ab) (!(lVar instanceof ab) ? null : lVar);
            }
            if (lVar3 == null) {
                if (lVar == null) {
                    break;
                }
                lVar = lVar.dXW();
            } else {
                lVar2 = lVar3;
                break;
            }
        }
        AppMethodBeat.o(120335);
        return lVar2;
    }

    private static w c(ar arVar) {
        AppMethodBeat.i(120336);
        j.p(arVar, "descriptor");
        List dWP = arVar.dWP();
        j.o(dWP, "descriptor.upperBounds");
        Object obj = !dWP.isEmpty() ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Upper bounds should not be empty: ".concat(String.valueOf(arVar)));
            AppMethodBeat.o(120336);
            throw assertionError;
        }
        for (Object next : dWP) {
            h dYs = ((w) next).ejw().dYs();
            if (!(dYs instanceof e)) {
                dYs = null;
            }
            e eVar = (e) dYs;
            if (eVar == null || eVar.dYc() == a.i.b.a.c.b.f.INTERFACE || eVar.dYc() == a.i.b.a.c.b.f.ANNOTATION_CLASS) {
                obj = null;
                continue;
            } else {
                int i = 1;
                continue;
            }
            if (obj != null) {
                obj = next;
                break;
            }
        }
        obj = null;
        w wVar = (w) obj;
        if (wVar == null) {
            obj = t.fJ(dWP);
            j.o(obj, "upperBounds.first()");
            wVar = (w) obj;
        }
        AppMethodBeat.o(120336);
        return wVar;
    }
}
