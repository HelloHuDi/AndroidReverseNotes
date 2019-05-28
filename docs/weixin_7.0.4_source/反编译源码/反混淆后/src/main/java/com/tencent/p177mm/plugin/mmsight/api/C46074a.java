package com.tencent.p177mm.plugin.mmsight.api;

import android.graphics.Bitmap;

/* renamed from: com.tencent.mm.plugin.mmsight.api.a */
public abstract class C46074a {
    public static C43300b osX = null;

    /* renamed from: com.tencent.mm.plugin.mmsight.api.a$a */
    public interface C43299a {
        Bitmap bPh();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.api.a$b */
    public interface C43300b {
        /* renamed from: a */
        C46074a mo21395a(int i, String str, String str2, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        C46074a mo21396a(int i, String str, String str2, int i2, int i3, int i4, int i5, long j, long j2);

        /* renamed from: a */
        C46074a mo21397a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2);

        /* renamed from: b */
        C46074a mo21398b(String str, String str2, int i, int i2, int i3, int i4);
    }

    /* renamed from: Va */
    public abstract int mo46469Va();

    public abstract int getType();

    /* renamed from: r */
    public abstract void mo46471r(Bitmap bitmap);
}
