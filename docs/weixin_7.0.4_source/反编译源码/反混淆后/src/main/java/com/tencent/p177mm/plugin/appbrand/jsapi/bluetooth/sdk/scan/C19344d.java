package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.d */
final class C19344d {
    static String toString(Object obj) {
        AppMethodBeat.m2504i(94309);
        String str;
        if (obj == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(94309);
            return str;
        }
        str = obj.toString();
        AppMethodBeat.m2505o(94309);
        return str;
    }

    static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.m2504i(94310);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(94310);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.m2505o(94310);
            return true;
        } else {
            AppMethodBeat.m2505o(94310);
            return false;
        }
    }

    static boolean deepEquals(Object obj, Object obj2) {
        AppMethodBeat.m2504i(94311);
        boolean deepEquals;
        if (obj == null || obj2 == null) {
            if (obj == obj2) {
                AppMethodBeat.m2505o(94311);
                return true;
            }
            AppMethodBeat.m2505o(94311);
            return false;
        } else if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
            deepEquals = Arrays.deepEquals((Object[]) obj, (Object[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
            deepEquals = Arrays.equals((boolean[]) obj, (boolean[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            deepEquals = Arrays.equals((byte[]) obj, (byte[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
            deepEquals = Arrays.equals((char[]) obj, (char[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
            deepEquals = Arrays.equals((double[]) obj, (double[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
            deepEquals = Arrays.equals((float[]) obj, (float[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
            deepEquals = Arrays.equals((int[]) obj, (int[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
            deepEquals = Arrays.equals((long[]) obj, (long[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
            deepEquals = Arrays.equals((short[]) obj, (short[]) obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        } else {
            deepEquals = obj.equals(obj2);
            AppMethodBeat.m2505o(94311);
            return deepEquals;
        }
    }
}
