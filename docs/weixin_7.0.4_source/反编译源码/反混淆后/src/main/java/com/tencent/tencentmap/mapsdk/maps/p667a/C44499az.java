package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41014c;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.az */
public abstract class C44499az {
    /* renamed from: a */
    protected final int f17400a;
    /* renamed from: b */
    protected final int f17401b;
    /* renamed from: c */
    protected Context f17402c;
    /* renamed from: d */
    protected String f17403d;

    /* renamed from: a */
    public abstract C36481aa mo41919a();

    /* renamed from: b */
    public abstract void mo41920b(boolean z);

    public C44499az(Context context, int i, int i2) {
        this.f17402c = context;
        this.f17400a = i2;
        this.f17401b = i;
    }

    /* renamed from: c */
    public final int mo70869c() {
        return this.f17400a;
    }

    /* renamed from: d */
    public final synchronized String mo70870d() {
        return this.f17403d;
    }

    /* renamed from: e */
    public final String mo70871e() {
        try {
            if (this.f17401b == 0) {
                return C36541t.m60530a(this.f17402c).mo57789e().mo70939b();
            }
            return C36541t.m60530a(this.f17402c).mo57789e().mo70938b(this.f17401b).mo70955b();
        } catch (Throwable th) {
            C16205ag.m24686c("imposiable comStrategy error:%s", th.toString());
            C16205ag.m24684a(th);
            return null;
        }
    }

    /* renamed from: a */
    public static C36481aa m80700a(int i, byte[] bArr) {
        try {
            return C24349e.m37574a(i, C41014c.m71224m(), bArr, 2, 3);
        } catch (Throwable th) {
            C16205ag.m24686c("imposiable comStrategy error:%s", th.toString());
            C16205ag.m24684a(th);
            return null;
        }
    }

    /* renamed from: b */
    public void mo70868b() {
        C16205ag.m24686c("encode failed, clear db data", new Object[0]);
    }
}
