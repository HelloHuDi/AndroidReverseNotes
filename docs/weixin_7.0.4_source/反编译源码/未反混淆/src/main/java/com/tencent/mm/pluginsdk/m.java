package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ai.g;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi.a;

@Deprecated
public interface m {
    String B(String str, String str2);

    void BS();

    void BU();

    void BV();

    Intent BW();

    boolean BX();

    void BY();

    boolean BZ();

    Bitmap a(Activity activity, int i, int i2, Intent intent);

    com.tencent.mm.ai.m a(g gVar);

    void a(Context context, ad adVar, a aVar, Bundle bundle, String str);

    void a(Context context, a aVar, Bundle bundle);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5);

    void a(Intent intent, String str);

    void a(bbv bbv, String str);

    void a(String str, String str2, String str3, long j);

    boolean a(Context context, int i, int i2, String str);

    boolean a(ad adVar);

    boolean b(Context context, int i, int i2, String str);

    void bc(Context context);

    com.tencent.mm.ai.m bj(boolean z);

    String df(String str);

    boolean dg(String str);

    boolean dk(String str);

    void dl(String str);

    String f(Context context, String str, String str2);

    void gk(int i);

    boolean o(Activity activity);

    void p(Activity activity);

    String t(Context context, String str);

    String t(String str, int i);

    boolean u(Context context, String str);
}
