package com.google.android.exoplayer2.f.g;

import android.support.v4.widget.j;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e extends com.google.android.exoplayer2.f.a {
    public final long endTime;
    public final long startTime;

    public static final class a {
        Alignment bkV;
        float bkW;
        int bkX;
        float bkY;
        int bkZ;
        SpannableStringBuilder boD;
        long endTime;
        int lineType;
        long startTime;
        float width;

        public a() {
            AppMethodBeat.i(95726);
            reset();
            AppMethodBeat.o(95726);
        }

        public final void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.boD = null;
            this.bkV = null;
            this.bkW = Float.MIN_VALUE;
            this.lineType = j.INVALID_ID;
            this.bkX = j.INVALID_ID;
            this.bkY = Float.MIN_VALUE;
            this.bkZ = j.INVALID_ID;
            this.width = Float.MIN_VALUE;
        }

        public final e tc() {
            AppMethodBeat.i(95727);
            if (this.bkY != Float.MIN_VALUE && this.bkZ == j.INVALID_ID) {
                td();
            }
            e eVar = new e(this.startTime, this.endTime, this.boD, this.bkV, this.bkW, this.lineType, this.bkX, this.bkY, this.bkZ, this.width);
            AppMethodBeat.o(95727);
            return eVar;
        }

        private a td() {
            AppMethodBeat.i(95728);
            if (this.bkV != null) {
                switch (AnonymousClass1.boC[this.bkV.ordinal()]) {
                    case 1:
                        this.bkZ = 0;
                        break;
                    case 2:
                        this.bkZ = 1;
                        break;
                    case 3:
                        this.bkZ = 2;
                        break;
                    default:
                        new StringBuilder("Unrecognized alignment: ").append(this.bkV);
                        this.bkZ = 0;
                        break;
                }
            }
            this.bkZ = j.INVALID_ID;
            AppMethodBeat.o(95728);
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.g.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] boC = new int[Alignment.values().length];

        static {
            AppMethodBeat.i(95725);
            try {
                boC[Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                boC[Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                boC[Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
                AppMethodBeat.o(95725);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(95725);
            }
        }
    }

    public e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private e(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, j.INVALID_ID, j.INVALID_ID, Float.MIN_VALUE, j.INVALID_ID, Float.MIN_VALUE);
    }

    public e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.startTime = j;
        this.endTime = j2;
    }
}
