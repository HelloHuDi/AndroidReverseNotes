package org.apache.commons.p703b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: org.apache.commons.b.a */
public final class C16470a {
    public static final short[] AxX = new short[0];
    public static final Object[] BWE = new Object[0];
    public static final Class[] BWF = new Class[0];
    public static final Long[] BWG = new Long[0];
    public static final Integer[] BWH = new Integer[0];
    public static final Short[] BWI = new Short[0];
    public static final Byte[] BWJ = new Byte[0];
    public static final Double[] BWK = new Double[0];
    public static final Float[] BWL = new Float[0];
    public static final Boolean[] BWM = new Boolean[0];
    public static final char[] BWN = new char[0];
    public static final Character[] BWO = new Character[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int[] bxu = new int[0];
    public static final long[] bxv = new long[0];
    public static final float[] bxw = new float[0];
    public static final double[] bxx = new double[0];
    public static final boolean[] bxy = new boolean[0];

    public static boolean contains(Object[] objArr, Object obj) {
        int i;
        AppMethodBeat.m2504i(116927);
        if (objArr != null) {
            if (obj != null) {
                if (objArr.getClass().getComponentType().isInstance(obj)) {
                    i = 0;
                    while (i < objArr.length) {
                        if (obj.equals(objArr[i])) {
                            break;
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
                while (i < objArr.length) {
                    if (objArr[i] == null) {
                        break;
                    }
                    i++;
                }
            }
        }
        i = -1;
        if (i != -1) {
            AppMethodBeat.m2505o(116927);
            return true;
        }
        AppMethodBeat.m2505o(116927);
        return false;
    }
}
