package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.u;

public interface ab {

    public interface c {
        void aQS();
    }

    public interface a {
        void gY();
    }

    public interface b {
        boolean qy(int i);
    }

    void N(float f, float f2);

    void a(OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(c cVar);

    boolean aQP();

    boolean aQQ();

    boolean aQT();

    void aRi();

    void aRj();

    void aRk();

    void addTextChangedListener(TextWatcher textWatcher);

    void b(OnFocusChangeListener onFocusChangeListener);

    void destroy();

    com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController();

    Context getContext();

    int getInputId();

    View getInputPanel();

    char getLastKeyPressed();

    CharSequence getText();

    View getView();

    int qI(int i);

    void setFixed(boolean z);

    void setInputId(int i);

    void setOnKeyUpPostImeListener(b bVar);

    void y(u uVar);

    void z(u uVar);
}
