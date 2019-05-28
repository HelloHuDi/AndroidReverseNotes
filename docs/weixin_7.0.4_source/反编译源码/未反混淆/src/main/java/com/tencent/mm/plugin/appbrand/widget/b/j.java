package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.DialogInterface;
import android.view.View;

public interface j extends DialogInterface {
    void a(k kVar);

    boolean aKP();

    View getContentView();

    int getPosition();

    boolean isCancelable();

    void onCancel();

    void pF(int i);
}
