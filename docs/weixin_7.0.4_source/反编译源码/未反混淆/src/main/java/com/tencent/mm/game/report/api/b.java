package com.tencent.mm.game.report.api;

public abstract class b {
    public static b eBF;

    public abstract void a(long j, a aVar);

    public abstract void a(String str, int i, int i2, long j, long j2, long j3, String str2, int i3, int i4, String str3, long j4, int i5, long j5, String str4, int i6);

    public abstract void a(String str, int i, int i2, String str2, String str3, String str4, String str5);

    public abstract a eZ(long j);

    public abstract void j(String str, long j);

    public final void a(String str, int i, int i2, long j, String str2, String str3) {
        a(str, i, i2, 0, 0, 0, "", 0, 0, str2, 0, 0, j, str3, 0);
    }

    public final void a(String str, int i, long j, String str2, long j2, int i2) {
        a(str, 0, i, 0, 0, 0, "", 0, 0, str2, j2, 0, j, "", i2);
    }
}
