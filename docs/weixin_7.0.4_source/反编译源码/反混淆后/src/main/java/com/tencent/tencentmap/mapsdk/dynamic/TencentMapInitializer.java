package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapInitializer implements IInitializer {
    /* renamed from: b */
    private static volatile TencentMapInitializer f4635b;
    /* renamed from: a */
    private IInitializer f4636a;

    private TencentMapInitializer(Context context) {
        AppMethodBeat.m2504i(101278);
        this.f4636a = C5849a.m8982a(context);
        AppMethodBeat.m2505o(101278);
    }

    public static TencentMapInitializer getInstance(Context context) {
        AppMethodBeat.m2504i(101279);
        if (f4635b == null) {
            synchronized (TencentMapInitializer.class) {
                try {
                    if (f4635b == null) {
                        f4635b = new TencentMapInitializer(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(101279);
                    }
                }
            }
        }
        TencentMapInitializer tencentMapInitializer = f4635b;
        AppMethodBeat.m2505o(101279);
        return tencentMapInitializer;
    }

    public void downLoadVectorMapResource() {
        AppMethodBeat.m2504i(101280);
        if (this.f4636a == null) {
            AppMethodBeat.m2505o(101280);
            return;
        }
        this.f4636a.downLoadVectorMapResource();
        AppMethodBeat.m2505o(101280);
    }

    public boolean isVectorMapValid() {
        AppMethodBeat.m2504i(101281);
        if (this.f4636a == null) {
            AppMethodBeat.m2505o(101281);
            return false;
        }
        boolean isVectorMapValid = this.f4636a.isVectorMapValid();
        AppMethodBeat.m2505o(101281);
        return isVectorMapValid;
    }
}
