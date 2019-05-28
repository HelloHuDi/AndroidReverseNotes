package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.view.View;
import android.widget.EditText;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.aa */
public interface C45718aa<Input extends EditText & C38595ab> {
    /* renamed from: a */
    void mo35097a(String str, Integer num);

    boolean aQn();

    Input aQo();

    boolean aQr();

    int aQs();

    boolean aQt();

    /* renamed from: dr */
    boolean mo35128dr(int i, int i2);

    int getInputId();

    <P extends View & C45719ac> P getInputPanel();

    /* renamed from: qx */
    void mo35109qx(int i);

    /* renamed from: s */
    boolean mo35110s(C44709u c44709u);
}
