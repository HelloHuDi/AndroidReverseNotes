package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.Writer;

/* renamed from: com.eclipsesource.a.i */
class C0804i {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] aLE = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, '\"'};
    private static final char[] aLF = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_WINDOWS};
    private static final char[] aLG = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 'n'};
    private static final char[] aLH = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 'r'};
    private static final char[] aLI = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 't'};
    private static final char[] aLJ = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 'u', '2', '0', '2', '8'};
    private static final char[] aLK = new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 'u', '2', '0', '2', '9'};
    protected final Writer writer;

    C0804i(Writer writer) {
        this.writer = writer;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: an */
    public final void mo2369an(String str) {
        AppMethodBeat.m2504i(70584);
        this.writer.write(str);
        AppMethodBeat.m2505o(70584);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ao */
    public final void mo2370ao(String str) {
        AppMethodBeat.m2504i(70585);
        this.writer.write(str);
        AppMethodBeat.m2505o(70585);
    }

    /* Access modifiers changed, original: protected|final */
    public final void writeString(String str) {
        AppMethodBeat.m2504i(70586);
        this.writer.write(34);
        m1886aq(str);
        this.writer.write(34);
        AppMethodBeat.m2505o(70586);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pr */
    public void mo2372pr() {
        AppMethodBeat.m2504i(70587);
        this.writer.write(91);
        AppMethodBeat.m2505o(70587);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ps */
    public void mo2373ps() {
        AppMethodBeat.m2504i(70588);
        this.writer.write(93);
        AppMethodBeat.m2505o(70588);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pt */
    public void mo2374pt() {
        AppMethodBeat.m2504i(70589);
        this.writer.write(44);
        AppMethodBeat.m2505o(70589);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pu */
    public void mo2375pu() {
        AppMethodBeat.m2504i(70590);
        this.writer.write(123);
        AppMethodBeat.m2505o(70590);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pv */
    public void mo2376pv() {
        AppMethodBeat.m2504i(70591);
        this.writer.write(125);
        AppMethodBeat.m2505o(70591);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ap */
    public final void mo2371ap(String str) {
        AppMethodBeat.m2504i(70592);
        this.writer.write(34);
        m1886aq(str);
        this.writer.write(34);
        AppMethodBeat.m2505o(70592);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pw */
    public void mo2377pw() {
        AppMethodBeat.m2504i(70593);
        this.writer.write(58);
        AppMethodBeat.m2505o(70593);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: px */
    public void mo2378px() {
        AppMethodBeat.m2504i(70594);
        this.writer.write(44);
        AppMethodBeat.m2505o(70594);
    }

    /* renamed from: aq */
    private void m1886aq(String str) {
        AppMethodBeat.m2504i(70595);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char[] c = C0804i.m1887c(str.charAt(i2));
            if (c != null) {
                this.writer.write(str, i, i2 - i);
                this.writer.write(c);
                i = i2 + 1;
            }
        }
        this.writer.write(str, i, length - i);
        AppMethodBeat.m2505o(70595);
    }

    /* renamed from: c */
    private static char[] m1887c(char c) {
        if (c > IOUtils.DIR_SEPARATOR_WINDOWS) {
            if (c < 8232 || c > 8233) {
                return null;
            }
            return c == 8232 ? aLJ : aLK;
        } else if (c == IOUtils.DIR_SEPARATOR_WINDOWS) {
            return aLF;
        } else {
            if (c > '\"') {
                return null;
            }
            if (c == '\"') {
                return aLE;
            }
            if (c > 31) {
                return null;
            }
            if (c == 10) {
                return aLG;
            }
            if (c == 13) {
                return aLH;
            }
            if (c == 9) {
                return aLI;
            }
            return new char[]{IOUtils.DIR_SEPARATOR_WINDOWS, 'u', '0', '0', HEX_DIGITS[(c >> 4) & 15], HEX_DIGITS[c & 15]};
        }
    }
}
