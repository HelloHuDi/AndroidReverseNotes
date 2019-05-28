package a.f.b;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"})
public final class f {
    private static final Object[] euk = new Object[0];

    public static final Object[] a(Collection<?> collection, Object[] objArr) {
        int i = 0;
        AppMethodBeat.i(56234);
        j.p(collection, "collection");
        Throwable nullPointerException;
        if (objArr == null) {
            nullPointerException = new NullPointerException();
            AppMethodBeat.o(56234);
            throw nullPointerException;
        }
        int size = collection.size();
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            AppMethodBeat.o(56234);
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
                    v vVar = new v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    AppMethodBeat.o(56234);
                    throw vVar;
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
                                AppMethodBeat.o(56234);
                                throw nullPointerException;
                            }
                            i = 2147483645;
                        }
                        objArr2 = Arrays.copyOf(objArr2, i);
                        j.o(objArr2, "Arrays.copyOf(result, newSize)");
                        i = i2;
                    } else {
                        AppMethodBeat.o(56234);
                        return objArr2;
                    }
                } else if (it.hasNext()) {
                    i = i2;
                } else if (objArr2 == objArr) {
                    objArr[i2] = null;
                    AppMethodBeat.o(56234);
                    return objArr;
                } else {
                    objArr = Arrays.copyOf(objArr2, i2);
                    j.o(objArr, "Arrays.copyOf(result, size)");
                    AppMethodBeat.o(56234);
                    return objArr;
                }
            }
        }
        if (objArr.length > 0) {
            objArr[0] = null;
        }
        AppMethodBeat.o(56234);
        return objArr;
    }

    public static final Object[] j(Collection<?> collection) {
        AppMethodBeat.i(56233);
        j.p(collection, "collection");
        int size = collection.size();
        Object[] objArr;
        if (size == 0) {
            objArr = euk;
            AppMethodBeat.o(56233);
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
                                AppMethodBeat.o(56233);
                                throw outOfMemoryError;
                            }
                            size = 2147483645;
                        }
                        objArr = Arrays.copyOf(objArr, size);
                        j.o(objArr, "Arrays.copyOf(result, newSize)");
                        size = i;
                    } else {
                        AppMethodBeat.o(56233);
                        return objArr;
                    }
                } else if (it.hasNext()) {
                    size = i;
                } else {
                    objArr = Arrays.copyOf(objArr, i);
                    j.o(objArr, "Arrays.copyOf(result, size)");
                    AppMethodBeat.o(56233);
                    return objArr;
                }
            }
        }
        objArr = euk;
        AppMethodBeat.o(56233);
        return objArr;
    }
}
