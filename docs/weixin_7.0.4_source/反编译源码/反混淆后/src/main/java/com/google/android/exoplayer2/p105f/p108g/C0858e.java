package com.google.android.exoplayer2.p105f.p108g;

import android.support.p057v4.widget.C8415j;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p105f.C32044a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.g.e */
final class C0858e extends C32044a {
    public final long endTime;
    public final long startTime;

    /* renamed from: com.google.android.exoplayer2.f.g.e$a */
    public static final class C0859a {
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

        public C0859a() {
            AppMethodBeat.m2504i(95726);
            reset();
            AppMethodBeat.m2505o(95726);
        }

        public final void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.boD = null;
            this.bkV = null;
            this.bkW = Float.MIN_VALUE;
            this.lineType = C8415j.INVALID_ID;
            this.bkX = C8415j.INVALID_ID;
            this.bkY = Float.MIN_VALUE;
            this.bkZ = C8415j.INVALID_ID;
            this.width = Float.MIN_VALUE;
        }

        /* renamed from: tc */
        public final C0858e mo2580tc() {
            AppMethodBeat.m2504i(95727);
            if (this.bkY != Float.MIN_VALUE && this.bkZ == C8415j.INVALID_ID) {
                m1962td();
            }
            C0858e c0858e = new C0858e(this.startTime, this.endTime, this.boD, this.bkV, this.bkW, this.lineType, this.bkX, this.bkY, this.bkZ, this.width);
            AppMethodBeat.m2505o(95727);
            return c0858e;
        }

        /* renamed from: td */
        private C0859a m1962td() {
            AppMethodBeat.m2504i(95728);
            if (this.bkV != null) {
                switch (C08601.boC[this.bkV.ordinal()]) {
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
            this.bkZ = C8415j.INVALID_ID;
            AppMethodBeat.m2505o(95728);
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.f.g.e$1 */
    static /* synthetic */ class C08601 {
        static final /* synthetic */ int[] boC = new int[Alignment.values().length];

        static {
            AppMethodBeat.m2504i(95725);
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
                AppMethodBeat.m2505o(95725);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(95725);
            }
        }
    }

    public C0858e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private C0858e(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, C8415j.INVALID_ID, C8415j.INVALID_ID, Float.MIN_VALUE, C8415j.INVALID_ID, Float.MIN_VALUE);
    }

    public C0858e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.startTime = j;
        this.endTime = j2;
    }
}
