package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.util.Arrays;

public final class k extends l {
    private final char[] aLL;

    static class a extends i {
        private final char[] aLL;
        private int aLM;

        /* synthetic */ a(Writer writer, char[] cArr, byte b) {
            this(writer, cArr);
        }

        private a(Writer writer, char[] cArr) {
            super(writer);
            this.aLL = cArr;
        }

        /* Access modifiers changed, original: protected|final */
        public final void pr() {
            AppMethodBeat.i(70597);
            this.aLM++;
            this.writer.write(91);
            py();
            AppMethodBeat.o(70597);
        }

        /* Access modifiers changed, original: protected|final */
        public final void ps() {
            AppMethodBeat.i(70598);
            this.aLM--;
            py();
            this.writer.write(93);
            AppMethodBeat.o(70598);
        }

        /* Access modifiers changed, original: protected|final */
        public final void pt() {
            AppMethodBeat.i(70599);
            this.writer.write(44);
            if (!py()) {
                this.writer.write(32);
            }
            AppMethodBeat.o(70599);
        }

        /* Access modifiers changed, original: protected|final */
        public final void pu() {
            AppMethodBeat.i(70600);
            this.aLM++;
            this.writer.write(123);
            py();
            AppMethodBeat.o(70600);
        }

        /* Access modifiers changed, original: protected|final */
        public final void pv() {
            AppMethodBeat.i(70601);
            this.aLM--;
            py();
            this.writer.write(125);
            AppMethodBeat.o(70601);
        }

        /* Access modifiers changed, original: protected|final */
        public final void pw() {
            AppMethodBeat.i(70602);
            this.writer.write(58);
            this.writer.write(32);
            AppMethodBeat.o(70602);
        }

        /* Access modifiers changed, original: protected|final */
        public final void px() {
            AppMethodBeat.i(70603);
            this.writer.write(44);
            if (!py()) {
                this.writer.write(32);
            }
            AppMethodBeat.o(70603);
        }

        private boolean py() {
            int i = 0;
            AppMethodBeat.i(70604);
            if (this.aLL == null) {
                AppMethodBeat.o(70604);
                return false;
            }
            this.writer.write(10);
            while (i < this.aLM) {
                this.writer.write(this.aLL);
                i++;
            }
            AppMethodBeat.o(70604);
            return true;
        }
    }

    private k(char[] cArr) {
        this.aLL = cArr;
    }

    public static k du(int i) {
        AppMethodBeat.i(70605);
        if (i < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("number is negative");
            AppMethodBeat.o(70605);
            throw illegalArgumentException;
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        k kVar = new k(cArr);
        AppMethodBeat.o(70605);
        return kVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final i a(Writer writer) {
        AppMethodBeat.i(70606);
        a aVar = new a(writer, this.aLL, (byte) 0);
        AppMethodBeat.o(70606);
        return aVar;
    }
}
