package p000a.p051k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
/* renamed from: a.k.l */
final class C8308l {
    public static final C25274k BPi;
    public static final C8308l BPj = new C8308l();

    static {
        AppMethodBeat.m2504i(56362);
        String str = "(\\p{Digit}+)";
        String str2 = "(\\p{XDigit}+)";
        String concat = "[eE][+-]?".concat(String.valueOf(str));
        BPi = new C25274k("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("(" + str + "(\\.)?(" + str + "?)(" + concat + ")?)|(\\.(" + str + ")(" + concat + ")?)|((" + ("(0[xX]" + str2 + "(\\.)?)|(0[xX]" + str2 + "?(\\.)" + str2 + ')') + ")[pP][+-]?" + str + ')') + ")[fFdD]?))[\\x00-\\x20]*");
        AppMethodBeat.m2505o(56362);
    }

    private C8308l() {
    }
}
