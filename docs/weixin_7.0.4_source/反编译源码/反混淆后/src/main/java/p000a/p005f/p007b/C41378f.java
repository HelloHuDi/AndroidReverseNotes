package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p000a.C0220l;
import p000a.C44941v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"})
/* renamed from: a.f.b.f */
public final class C41378f {
    private static final Object[] euk = new Object[0];

    /* renamed from: a */
    public static final Object[] m72157a(Collection<?> collection, Object[] objArr) {
        int i = 0;
        AppMethodBeat.m2504i(56234);
        C25052j.m39376p(collection, "collection");
        Throwable nullPointerException;
        if (objArr == null) {
            nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(56234);
            throw nullPointerException;
        }
        int size = collection.size();
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            AppMethodBeat.m2505o(56234);
            return objArr;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            Object[] objArr2;
            if (size <= objArr.length) {
                objArr2 = objArr;
            } else {
                Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                if (newInstance == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    AppMethodBeat.m2505o(56234);
                    throw c44941v;
                }
                objArr2 = (Object[]) newInstance;
            }
            while (true) {
                int i2 = i + 1;
                objArr2[i] = it.next();
                if (i2 >= objArr2.length) {
                    if (it.hasNext()) {
                        i = ((i2 * 3) + 1) >>> 1;
                        if (i <= i2) {
                            if (i2 >= 2147483645) {
                                nullPointerException = new OutOfMemoryError();
                                AppMethodBeat.m2505o(56234);
                                throw nullPointerException;
                            }
                            i = 2147483645;
                        }
                        objArr2 = Arrays.copyOf(objArr2, i);
                        C25052j.m39375o(objArr2, "Arrays.copyOf(result, newSize)");
                        i = i2;
                    } else {
                        AppMethodBeat.m2505o(56234);
                        return objArr2;
                    }
                } else if (it.hasNext()) {
                    i = i2;
                } else if (objArr2 == objArr) {
                    objArr[i2] = null;
                    AppMethodBeat.m2505o(56234);
                    return objArr;
                } else {
                    objArr = Arrays.copyOf(objArr2, i2);
                    C25052j.m39375o(objArr, "Arrays.copyOf(result, size)");
                    AppMethodBeat.m2505o(56234);
                    return objArr;
                }
            }
        }
        if (objArr.length > 0) {
            objArr[0] = null;
        }
        AppMethodBeat.m2505o(56234);
        return objArr;
    }

    /* renamed from: j */
    public static final Object[] m72158j(Collection<?> collection) {
        AppMethodBeat.m2504i(56233);
        C25052j.m39376p(collection, "collection");
        int size = collection.size();
        Object[] objArr;
        if (size == 0) {
            objArr = euk;
            AppMethodBeat.m2505o(56233);
            return objArr;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            Object[] objArr2 = new Object[size];
            size = 0;
            objArr = objArr2;
            while (true) {
                int i = size + 1;
                objArr[size] = it.next();
                if (i >= objArr.length) {
                    if (it.hasNext()) {
                        size = ((i * 3) + 1) >>> 1;
                        if (size <= i) {
                            if (i >= 2147483645) {
                                Throwable outOfMemoryError = new OutOfMemoryError();
                                AppMethodBeat.m2505o(56233);
                                throw outOfMemoryError;
                            }
                            size = 2147483645;
                        }
                        objArr = Arrays.copyOf(objArr, size);
                        C25052j.m39375o(objArr, "Arrays.copyOf(result, newSize)");
                        size = i;
                    } else {
                        AppMethodBeat.m2505o(56233);
                        return objArr;
                    }
                } else if (it.hasNext()) {
                    size = i;
                } else {
                    objArr = Arrays.copyOf(objArr, i);
                    C25052j.m39375o(objArr, "Arrays.copyOf(result, size)");
                    AppMethodBeat.m2505o(56233);
                    return objArr;
                }
            }
        }
        objArr = euk;
        AppMethodBeat.m2505o(56233);
        return objArr;
    }
}
