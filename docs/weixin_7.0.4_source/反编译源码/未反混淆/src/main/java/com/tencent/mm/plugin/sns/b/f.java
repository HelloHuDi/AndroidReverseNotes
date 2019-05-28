package com.tencent.mm.plugin.sns.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.storage.az;

public interface f {
    String a(bau bau);

    void a(bau bau, View view, int i, az azVar);

    void ab(Activity activity);

    Bitmap b(bau bau);

    void b(bau bau, View view, int i, az azVar);

    void cmm();

    void dz(View view);

    void pause();

    void start();
}
