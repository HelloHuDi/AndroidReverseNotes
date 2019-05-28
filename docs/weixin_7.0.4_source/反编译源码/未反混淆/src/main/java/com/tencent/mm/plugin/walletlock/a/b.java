package com.tencent.mm.plugin.walletlock.a;

import android.app.Activity;
import android.content.Intent;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
    }

    public interface b {
        boolean ae(Activity activity);
    }

    void HB(int i);

    void a(Activity activity, b bVar);

    void a(Activity activity, b bVar, a aVar);

    void ad(Activity activity);

    void b(Activity activity, int i, int i2);

    void b(Activity activity, Intent intent);

    void b(Activity activity, Intent intent, int i);

    b cTi();

    boolean cTj();

    boolean cTk();

    void h(Activity activity, int i);

    void i(Activity activity, int i);

    void init();
}
