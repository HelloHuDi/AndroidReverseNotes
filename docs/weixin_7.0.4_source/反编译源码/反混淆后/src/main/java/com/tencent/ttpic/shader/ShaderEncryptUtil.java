package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShaderEncryptUtil {
    private static final String TAG = ShaderEncryptUtil.class.getSimpleName();

    static {
        AppMethodBeat.m2504i(83734);
        AppMethodBeat.m2505o(83734);
    }

    public static String decrypt(String str) {
        int i = 3;
        AppMethodBeat.m2504i(83733);
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        if (length < 3) {
            AppMethodBeat.m2505o(83733);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int i2;
        int i3;
        int parseInt;
        if (toCharArray[0] == 'h' && toCharArray[1] == 'f' && toCharArray[2] == 'e') {
            String str2 = "cdbhil";
            i2 = 3;
            while (i2 < length && toCharArray[i2] != 'f') {
                stringBuilder2.append(toCharArray[i2]);
                i2++;
            }
            Integer.parseInt(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            i3 = i2 + 1;
            while (i3 < length) {
                i2 = -1;
                while (i2 < 6 && toCharArray[i3] != str2.charAt(i2)) {
                    i2++;
                }
                if (i2 == 6) {
                    stringBuilder3.append(toCharArray[i3]);
                } else {
                    for (char c : getChars(Integer.parseInt(stringBuilder3.toString()) - i2)) {
                        if (c != 0) {
                            stringBuilder.append(c);
                        }
                    }
                    stringBuilder3 = new StringBuilder();
                }
                i3++;
            }
            str = new String(stringBuilder);
            AppMethodBeat.m2505o(83733);
            return str;
        } else if (toCharArray[0] == 'm' && toCharArray[1] == 'e' && toCharArray[2] == 'e') {
            while (i < length && toCharArray[i] != 'x') {
                stringBuilder2.append(toCharArray[i]);
                i++;
            }
            parseInt = Integer.parseInt(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            i2 = 0;
            int i4 = i + 1;
            while (i4 < length) {
                if (toCharArray[i4] == 'x') {
                    char[] chars = getChars(Integer.parseInt(stringBuilder2.toString()));
                    i = parseInt - i2 >= 4 ? 4 : parseInt - i2;
                    for (i3 = 0; i3 < i; i3++) {
                        stringBuilder.append(chars[i3]);
                    }
                    i = i2 + 4;
                    stringBuilder2 = new StringBuilder();
                } else {
                    stringBuilder2.append(toCharArray[i4]);
                    i = i2;
                }
                i4++;
                i2 = i;
            }
            str = new String(stringBuilder);
            AppMethodBeat.m2505o(83733);
            return str;
        } else {
            AppMethodBeat.m2505o(83733);
            return str;
        }
    }

    private static char[] getChars(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[i2] = (char) ((i >>> (i2 * 8)) & 255);
        }
        return cArr;
    }
}
