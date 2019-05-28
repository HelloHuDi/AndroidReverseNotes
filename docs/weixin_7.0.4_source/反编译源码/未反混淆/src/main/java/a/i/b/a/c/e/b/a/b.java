package a.i.b.a.c.e.b.a;

import a.aa;
import a.f.b.j;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public class b {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private static final boolean Byl;

    static {
        Object property;
        AppMethodBeat.i(121302);
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException e) {
            property = null;
        }
        Byl = "true".equals(property);
        AppMethodBeat.o(121302);
    }

    private b() {
    }

    private static void cv(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((bArr[i] + d.MIC_SketchMark) & d.MIC_SketchMark);
        }
    }

    public static byte[] af(String[] strArr) {
        int i = 0;
        AppMethodBeat.i(121299);
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                int i2;
                String[] ag = ag(strArr);
                j.p(ag, "strings");
                int i3 = 0;
                for (String length : ag) {
                    i3 += length.length();
                }
                byte[] bArr = new byte[i3];
                int length2 = ag.length;
                int i4 = 0;
                i3 = 0;
                while (i4 < length2) {
                    int i5;
                    String str = ag[i4];
                    int length3 = str.length() - 1;
                    if (length3 >= 0) {
                        i2 = 0;
                        while (true) {
                            i5 = i3 + 1;
                            bArr[i3] = (byte) str.charAt(i2);
                            if (i2 == length3) {
                                break;
                            }
                            i2++;
                            i3 = i5;
                        }
                    } else {
                        i5 = i3;
                    }
                    i4++;
                    i3 = i5;
                }
                if (i3 == bArr.length) {
                    i = 1;
                }
                if (aa.AUz && i == 0) {
                    Throwable assertionError = new AssertionError("Should have reached the end");
                    AppMethodBeat.o(121299);
                    throw assertionError;
                }
                AppMethodBeat.o(121299);
                return bArr;
            } else if (charAt == 65535) {
                strArr = ag(strArr);
            }
        }
        byte[] ah = ah(strArr);
        cv(ah);
        ah = cw(ah);
        AppMethodBeat.o(121299);
        return ah;
    }

    private static String[] ag(String[] strArr) {
        AppMethodBeat.i(121300);
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        AppMethodBeat.o(121300);
        return strArr2;
    }

    private static byte[] ah(String[] strArr) {
        AppMethodBeat.i(121301);
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if ($assertionsDisabled || str.length() <= CdnLogic.kBizGeneric) {
                i2 += str.length();
                i++;
            } else {
                AssertionError assertionError = new AssertionError("String is too long: " + str.length());
                AppMethodBeat.o(121301);
                throw assertionError;
            }
        }
        byte[] bArr = new byte[i2];
        i = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            length = 0;
            while (length < length2) {
                int i3 = i + 1;
                bArr[i] = (byte) str2.charAt(length);
                length++;
                i = i3;
            }
        }
        AppMethodBeat.o(121301);
        return bArr;
    }

    private static byte[] cw(byte[] bArr) {
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2++;
            bArr2[i3] = (byte) (((bArr[i2] & 255) >>> i) + ((bArr[i2] & ((1 << (i + 1)) - 1)) << (7 - i)));
            if (i == 6) {
                i2++;
                i = 0;
            } else {
                i++;
            }
        }
        return bArr2;
    }
}
