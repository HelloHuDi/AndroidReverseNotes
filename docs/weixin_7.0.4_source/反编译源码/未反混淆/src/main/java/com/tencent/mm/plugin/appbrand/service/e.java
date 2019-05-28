package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public interface e extends a {
    void a(Context context, String str, int i, String str2, AppBrandStatObject appBrandStatObject, String str3, String str4);

    void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject);

    void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject, String str4);

    void a(Context context, String str, String str2, String str3, int i);

    void a(Context context, String str, String str2, String str3, String str4, int i, int i2);

    void a(Context context, String str, String str2, boolean z, b bVar);

    void a(Context context, String str, String str2, boolean z, b bVar, Bundle bundle);

    void b(Context context, String str, String str2, String str3, int i, String str4, int i2);
}
