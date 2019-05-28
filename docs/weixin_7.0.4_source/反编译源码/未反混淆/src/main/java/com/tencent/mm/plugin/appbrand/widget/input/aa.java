package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.u;

public interface aa<Input extends EditText & ab> {
    void a(String str, Integer num);

    boolean aQn();

    Input aQo();

    boolean aQr();

    int aQs();

    boolean aQt();

    boolean dr(int i, int i2);

    int getInputId();

    <P extends View & ac> P getInputPanel();

    void qx(int i);

    boolean s(u uVar);
}
