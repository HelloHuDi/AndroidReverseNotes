package com.tencent.mm.plugin.backup.b;

public final class e {
    public int jqW = -100;
    public int jqX;
    public int jqY;
    public int jqZ;
    public long jra;
    public long jrb;
    public long jrc;

    public final void O(int i, int i2, int i3) {
        this.jqW = i;
        this.jqX = i2;
        this.jqY = i3;
    }

    public final void a(int i, int i2, int i3, long j, long j2) {
        this.jqW = i;
        this.jqX = i2;
        this.jqY = i3;
        this.jra = j;
        this.jrb = j2;
    }

    public final int aSD() {
        if (this.jrb == 0) {
            return 1;
        }
        double d = (double) ((this.jra * 100) / this.jrb);
        if (d <= 5.0d) {
            d *= 4.0d;
        } else {
            d = (((d - 5.0d) * 80.0d) / 95.0d) + 20.0d;
        }
        return (int) d;
    }
}
