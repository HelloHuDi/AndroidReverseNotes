package com.tencent.mm.plugin.mmsight.api;

import android.graphics.Bitmap;

public abstract class a {
    public static b osX = null;

    public interface a {
        Bitmap bPh();
    }

    public interface b {
        a a(int i, String str, String str2, int i2, int i3, int i4, int i5);

        a a(int i, String str, String str2, int i2, int i3, int i4, int i5, long j, long j2);

        a a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2);

        a b(String str, String str2, int i, int i2, int i3, int i4);
    }

    public abstract int Va();

    public abstract int getType();

    public abstract void r(Bitmap bitmap);
}
