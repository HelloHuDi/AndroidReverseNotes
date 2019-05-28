package p000a.p051k;

import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, dWq = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.k.t */
public class C0218t extends C16500s {
    public static final Integer awy(String str) {
        AppMethodBeat.m2504i(56284);
        C25052j.m39376p(str, "receiver$0");
        Integer eX = C0218t.m309eX(str, 10);
        AppMethodBeat.m2505o(56284);
        return eX;
    }

    /* renamed from: eX */
    public static final Integer m309eX(String str, int i) {
        int i2 = -2147483647;
        int i3 = 0;
        AppMethodBeat.m2504i(56285);
        C25052j.m39376p(str, "receiver$0");
        C17354b.m26870UW(i);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.m2505o(56285);
            return null;
        }
        int i4;
        int i5;
        char charAt = str.charAt(0);
        if (charAt >= '0') {
            i4 = 0;
            i5 = 0;
        } else if (length == 1) {
            AppMethodBeat.m2505o(56285);
            return null;
        } else if (charAt == '-') {
            i2 = C8415j.INVALID_ID;
            i4 = 1;
            i5 = 1;
        } else if (charAt == '+') {
            i4 = 1;
            i5 = 0;
        } else {
            AppMethodBeat.m2505o(56285);
            return null;
        }
        int i6 = i2 / i;
        length--;
        if (i4 <= length) {
            while (true) {
                int digit = Character.digit(str.charAt(i4), i);
                if (digit >= 0) {
                    if (i3 >= i6) {
                        i3 *= i;
                        if (i3 >= i2 + digit) {
                            i3 -= digit;
                            if (i4 == length) {
                                break;
                            }
                            i4++;
                        } else {
                            AppMethodBeat.m2505o(56285);
                            return null;
                        }
                    }
                    AppMethodBeat.m2505o(56285);
                    return null;
                }
                AppMethodBeat.m2505o(56285);
                return null;
            }
        }
        Integer valueOf;
        if (i5 != 0) {
            valueOf = Integer.valueOf(i3);
            AppMethodBeat.m2505o(56285);
            return valueOf;
        }
        valueOf = Integer.valueOf(-i3);
        AppMethodBeat.m2505o(56285);
        return valueOf;
    }

    public static final Long awz(String str) {
        AppMethodBeat.m2504i(56286);
        C25052j.m39376p(str, "receiver$0");
        Long eY = C0218t.m310eY(str, 10);
        AppMethodBeat.m2505o(56286);
        return eY;
    }

    /* renamed from: eY */
    public static final Long m310eY(String str, int i) {
        AppMethodBeat.m2504i(56287);
        C25052j.m39376p(str, "receiver$0");
        C17354b.m26870UW(i);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.m2505o(56287);
            return null;
        }
        int i2;
        Object obj;
        long j;
        char charAt = str.charAt(0);
        if (charAt >= '0') {
            i2 = 0;
            obj = null;
            j = -9223372036854775807L;
        } else if (length == 1) {
            AppMethodBeat.m2505o(56287);
            return null;
        } else {
            i2 = 1;
            if (charAt == '-') {
                obj = 1;
                j = Long.MIN_VALUE;
            } else if (charAt == '+') {
                obj = null;
                j = -9223372036854775807L;
            } else {
                AppMethodBeat.m2505o(56287);
                return null;
            }
        }
        long j2 = j / ((long) i);
        long j3 = 0;
        length--;
        if (i2 <= length) {
            while (true) {
                int digit = Character.digit(str.charAt(i2), i);
                if (digit >= 0) {
                    if (j3 >= j2) {
                        j3 *= (long) i;
                        if (j3 >= ((long) digit) + j) {
                            j3 -= (long) digit;
                            if (i2 == length) {
                                break;
                            }
                            i2++;
                        } else {
                            AppMethodBeat.m2505o(56287);
                            return null;
                        }
                    }
                    AppMethodBeat.m2505o(56287);
                    return null;
                }
                AppMethodBeat.m2505o(56287);
                return null;
            }
        }
        Long valueOf;
        if (obj != null) {
            valueOf = Long.valueOf(j3);
            AppMethodBeat.m2505o(56287);
            return valueOf;
        }
        valueOf = Long.valueOf(-j3);
        AppMethodBeat.m2505o(56287);
        return valueOf;
    }
}
