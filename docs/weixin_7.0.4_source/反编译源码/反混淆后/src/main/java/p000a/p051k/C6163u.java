package p000a.p051k;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C31585ab;
import p000a.p005f.p007b.C25052j;
import p000a.p050j.C17348n;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\b\u001a\u0019\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\b\u001a)\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\b\u001a\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\b\u001a!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\b\u001a\n\u0010\u0016\u001a\u00020\u0002*\u00020\u0002\u001a\u0015\u0010\u0017\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\b\u001a\u0015\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0010H\b\u001a\u001d\u0010\u001a\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\b\u001a\u001c\u0010\u001d\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0015\u0010!\u001a\u00020 *\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\b\u001a\u0015\u0010!\u001a\u00020 *\u00020\u00022\u0006\u0010\"\u001a\u00020#H\b\u001a\n\u0010$\u001a\u00020\u0002*\u00020\u0002\u001a\u001c\u0010%\u001a\u00020 *\u00020\u00022\u0006\u0010&\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a \u0010'\u001a\u00020 *\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a2\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*2\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\b¢\u0006\u0002\u0010.\u001a*\u0010(\u001a\u00020\u0002*\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\b¢\u0006\u0002\u0010/\u001a:\u0010(\u001a\u00020\u0002*\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\b¢\u0006\u0002\u00100\u001a2\u0010(\u001a\u00020\u0002*\u00020\u00032\u0006\u0010(\u001a\u00020\u00022\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0,\"\u0004\u0018\u00010-H\b¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\b\u001a\n\u00103\u001a\u00020 *\u00020#\u001a\u001d\u00104\u001a\u00020\u0010*\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\b\u001a\u001d\u00104\u001a\u00020\u0010*\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010H\b\u001a\u001d\u00109\u001a\u00020\u0010*\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0010H\b\u001a\u001d\u00109\u001a\u00020\u0010*\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010H\b\u001a\u001d\u0010:\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\b\u001a4\u0010<\u001a\u00020 *\u00020#2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a4\u0010<\u001a\u00020 *\u00020\u00022\u0006\u0010=\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0012\u0010?\u001a\u00020\u0002*\u00020#2\u0006\u0010@\u001a\u00020\u0010\u001a$\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010F\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\"\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020H*\u00020#2\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010K\u001a\u00020\u0010\u001a\u001c\u0010L\u001a\u00020 *\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020 \u001a$\u0010L\u001a\u00020 *\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020 \u001a\u0015\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010N\u001a\u00020\u0010H\b\u001a\u001d\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010N\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\b\u001a\u0017\u0010P\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000eH\b\u001a\r\u0010Q\u001a\u00020\u0013*\u00020\u0002H\b\u001a3\u0010Q\u001a\u00020\u0013*\u00020\u00022\u0006\u0010R\u001a\u00020\u00132\b\b\u0002\u0010S\u001a\u00020\u00102\b\b\u0002\u0010N\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0010H\b\u001a\r\u0010T\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*H\b\u001a\u0017\u0010U\u001a\u00020J*\u00020\u00022\b\b\u0002\u0010V\u001a\u00020\u0010H\b\u001a\r\u0010W\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010W\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020*H\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006X"}, dWq = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "contentEquals", "charSequence", "", "decapitalize", "endsWith", "suffix", "equals", "format", "locale", "Ljava/util/Locale;", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "startIndex", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.k.u */
public class C6163u extends C0218t {
    /* renamed from: I */
    public static final boolean m9833I(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(56352);
        boolean equalsIgnoreCase;
        if (str == null) {
            if (str2 == null) {
                AppMethodBeat.m2505o(56352);
                return true;
            }
            AppMethodBeat.m2505o(56352);
            return false;
        } else if (z) {
            equalsIgnoreCase = str.equalsIgnoreCase(str2);
            AppMethodBeat.m2505o(56352);
            return equalsIgnoreCase;
        } else {
            equalsIgnoreCase = str.equals(str2);
            AppMethodBeat.m2505o(56352);
            return equalsIgnoreCase;
        }
    }

    /* renamed from: a */
    public static final String m9834a(String str, char c, char c2) {
        AppMethodBeat.m2504i(56353);
        C25052j.m39376p(str, "receiver$0");
        String replace = str.replace(c, c2);
        C25052j.m39375o(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
        AppMethodBeat.m2505o(56353);
        return replace;
    }

    /* renamed from: i */
    public static final String m9838i(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(56354);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "oldValue");
        C25052j.m39376p(str3, "newValue");
        String a = C17348n.m26857a(C31820v.m51520a((CharSequence) str, new String[]{str2}, z, 4), (CharSequence) str3);
        AppMethodBeat.m2505o(56354);
        return a;
    }

    /* renamed from: aI */
    public static final String m9836aI(String str, String str2, String str3) {
        AppMethodBeat.m2504i(56355);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "oldValue");
        C25052j.m39376p(str3, "newValue");
        int a = C31820v.m51518a((CharSequence) str, str2, 0, false, 2);
        if (a < 0) {
            AppMethodBeat.m2505o(56355);
            return str;
        }
        int length = a + str2.length();
        CharSequence charSequence = str;
        CharSequence charSequence2 = str3;
        C25052j.m39376p(charSequence, "receiver$0");
        C25052j.m39376p(charSequence2, "replacement");
        if (length < a) {
            Throwable indexOutOfBoundsException = new IndexOutOfBoundsException("End index (" + length + ") is less than start index (" + a + ").");
            AppMethodBeat.m2505o(56355);
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence, 0, a);
        stringBuilder.append(charSequence2);
        stringBuilder.append(charSequence, length, charSequence.length());
        str = stringBuilder.toString();
        AppMethodBeat.m2505o(56355);
        return str;
    }

    /* renamed from: jb */
    public static final boolean m9839jb(String str, String str2) {
        AppMethodBeat.m2504i(56356);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "prefix");
        boolean startsWith = str.startsWith(str2);
        AppMethodBeat.m2505o(56356);
        return startsWith;
    }

    /* renamed from: jc */
    public static final boolean m9840jc(String str, String str2) {
        AppMethodBeat.m2504i(56357);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, "suffix");
        boolean endsWith = str.endsWith(str2);
        AppMethodBeat.m2505o(56357);
        return endsWith;
    }

    /* renamed from: ar */
    public static final boolean m9837ar(CharSequence charSequence) {
        AppMethodBeat.m2504i(56358);
        C25052j.m39376p(charSequence, "receiver$0");
        if (charSequence.length() != 0) {
            Object obj;
            Iterator it = C31820v.m51529as(charSequence).iterator();
            while (it.hasNext()) {
                if (!C17354b.isWhitespace(charSequence.charAt(((C31585ab) it).nextInt()))) {
                    obj = null;
                    break;
                }
            }
            int obj2 = 1;
            if (obj2 == null) {
                AppMethodBeat.m2505o(56358);
                return false;
            }
        }
        AppMethodBeat.m2505o(56358);
        return true;
    }

    /* renamed from: a */
    public static final boolean m9835a(String str, String str2, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(56359);
        C25052j.m39376p(str, "receiver$0");
        C25052j.m39376p(str2, FacebookRequestErrorClassification.KEY_OTHER);
        boolean regionMatches;
        if (z) {
            regionMatches = str.regionMatches(z, 0, str2, i, i2);
            AppMethodBeat.m2505o(56359);
            return regionMatches;
        }
        regionMatches = str.regionMatches(0, str2, i, i2);
        AppMethodBeat.m2505o(56359);
        return regionMatches;
    }

    public static final String capitalize(String str) {
        AppMethodBeat.m2504i(56360);
        C25052j.m39376p(str, "receiver$0");
        if ((((CharSequence) str).length() > 0 ? 1 : 0) == 0 || !Character.isLowerCase(str.charAt(0))) {
            AppMethodBeat.m2505o(56360);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String substring = str.substring(0, 1);
        C25052j.m39375o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(56360);
            throw c44941v;
        }
        substring = substring.toUpperCase();
        C25052j.m39375o(substring, "(this as java.lang.String).toUpperCase()");
        stringBuilder = stringBuilder.append(substring);
        String substring2 = str.substring(1);
        C25052j.m39375o(substring2, "(this as java.lang.String).substring(startIndex)");
        str = stringBuilder.append(substring2).toString();
        AppMethodBeat.m2505o(56360);
        return str;
    }

    /* renamed from: s */
    public static final String m9841s(CharSequence charSequence, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(56361);
        C25052j.m39376p(charSequence, "receiver$0");
        if ((i >= 0 ? 1 : 0) == 0) {
            Throwable illegalArgumentException = new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
            AppMethodBeat.m2505o(56361);
            throw illegalArgumentException;
        }
        String str;
        switch (i) {
            case 0:
                str = "";
                AppMethodBeat.m2505o(56361);
                return str;
            case 1:
                str = charSequence.toString();
                AppMethodBeat.m2505o(56361);
                return str;
            default:
                switch (charSequence.length()) {
                    case 0:
                        str = "";
                        AppMethodBeat.m2505o(56361);
                        return str;
                    case 1:
                        char charAt = charSequence.charAt(0);
                        char[] cArr = new char[i];
                        int length = cArr.length;
                        for (i2 = 0; i2 < length; i2++) {
                            cArr[i2] = charAt;
                        }
                        str = new String(cArr);
                        AppMethodBeat.m2505o(56361);
                        return str;
                    default:
                        StringBuilder stringBuilder = new StringBuilder(charSequence.length() * i);
                        if (i > 0) {
                            while (true) {
                                stringBuilder.append(charSequence);
                                if (i2 != i) {
                                    i2++;
                                }
                            }
                        }
                        str = stringBuilder.toString();
                        C25052j.m39375o(str, "sb.toString()");
                        AppMethodBeat.m2505o(56361);
                        return str;
                }
        }
    }
}
