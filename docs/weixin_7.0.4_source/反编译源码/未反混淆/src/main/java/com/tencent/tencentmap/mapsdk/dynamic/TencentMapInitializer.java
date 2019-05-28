package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentMapInitializer implements IInitializer {
    private static volatile TencentMapInitializer b;
    private IInitializer a;

    private TencentMapInitializer(Context context) {
        AppMethodBeat.i(101278);
        this.a = a.a(context);
        AppMethodBeat.o(101278);
    }

    public static TencentMapInitializer getInstance(Context context) {
        AppMethodBeat.i(101279);
        if (b == null) {
            synchronized (TencentMapInitializer.class) {
                try {
                    if (b == null) {
                        b = new TencentMapInitializer(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(101279);
                    }
                }
            }
        }
        TencentMapInitializer tencentMapInitializer = b;
        AppMethodBeat.o(101279);
        return tencentMapInitializer;
    }

    public void downLoadVectorMapResource() {
        AppMethodBeat.i(101280);
        if (this.a == null) {
            AppMethodBeat.o(101280);
            return;
        }
        this.a.downLoadVectorMapResource();
        AppMethodBeat.o(101280);
    }

    public boolean isVectorMapValid() {
        AppMethodBeat.i(101281);
        if (this.a == null) {
            AppMethodBeat.o(101281);
            return false;
        }
        boolean isVectorMapValid = this.a.isVectorMapValid();
        AppMethodBeat.o(101281);
        return isVectorMapValid;
    }
}
