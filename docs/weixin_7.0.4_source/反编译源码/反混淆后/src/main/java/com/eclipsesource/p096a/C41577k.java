package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

/* renamed from: com.eclipsesource.a.k */
public final class C41577k extends C45009l {
    private final char[] aLL;

    /* renamed from: com.eclipsesource.a.k$a */
    static class C17568a extends C0804i {
        private final char[] aLL;
        private int aLM;

        /* synthetic */ C17568a(Writer writer, char[] cArr, byte b) {
            this(writer, cArr);
        }

        private C17568a(Writer writer, char[] cArr) {
            super(writer);
            this.aLL = cArr;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: pr */
        public final void mo2372pr() {
            AppMethodBeat.m2504i(70597);
            this.aLM++;
            this.writer.write(91);
            m27424py();
            AppMethodBeat.m2505o(70597);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ps */
        public final void mo2373ps() {
            AppMethodBeat.m2504i(70598);
            this.aLM--;
            m27424py();
            this.writer.write(93);
            AppMethodBeat.m2505o(70598);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: pt */
        public final void mo2374pt() {
            AppMethodBeat.m2504i(70599);
            this.writer.write(44);
            if (!m27424py()) {
                this.writer.write(32);
            }
            AppMethodBeat.m2505o(70599);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: pu */
        public final void mo2375pu() {
            AppMethodBeat.m2504i(70600);
            this.aLM++;
            this.writer.write(123);
            m27424py();
            AppMethodBeat.m2505o(70600);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: pv */
        public final void mo2376pv() {
            AppMethodBeat.m2504i(70601);
            this.aLM--;
            m27424py();
            this.writer.write(125);
            AppMethodBeat.m2505o(70601);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: pw */
        public final void mo2377pw() {
            AppMethodBeat.m2504i(70602);
            this.writer.write(58);
            this.writer.write(32);
            AppMethodBeat.m2505o(70602);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: px */
        public final void mo2378px() {
            AppMethodBeat.m2504i(70603);
            this.writer.write(44);
            if (!m27424py()) {
                this.writer.write(32);
            }
            AppMethodBeat.m2505o(70603);
        }

        /* renamed from: py */
        private boolean m27424py() {
            int i = 0;
            AppMethodBeat.m2504i(70604);
            if (this.aLL == null) {
                AppMethodBeat.m2505o(70604);
                return false;
            }
            this.writer.write(10);
            while (i < this.aLM) {
                this.writer.write(this.aLL);
                i++;
            }
            AppMethodBeat.m2505o(70604);
            return true;
        }
    }

    private C41577k(char[] cArr) {
        this.aLL = cArr;
    }

    /* renamed from: du */
    public static C41577k m72800du(int i) {
        AppMethodBeat.m2504i(70605);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("number is negative");
            AppMethodBeat.m2505o(70605);
            throw illegalArgumentException;
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        C41577k c41577k = new C41577k(cArr);
        AppMethodBeat.m2505o(70605);
        return c41577k;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C0804i mo2380a(Writer writer) {
        AppMethodBeat.m2504i(70606);
        C17568a c17568a = new C17568a(writer, this.aLL, (byte) 0);
        AppMethodBeat.m2505o(70606);
        return c17568a;
    }
}
