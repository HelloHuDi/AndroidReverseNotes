package com.google.android.exoplayer2.c;

public interface l {

    public static final class a implements l {
        private final long aOz;

        public a(long j) {
            this.aOz = j;
        }

        public final boolean qX() {
            return false;
        }

        public final long getDurationUs() {
            return this.aOz;
        }

        public final long M(long j) {
            return 0;
        }
    }

    long M(long j);

    long getDurationUs();

    boolean qX();
}
