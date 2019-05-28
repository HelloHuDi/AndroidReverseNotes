package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C42736b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ab */
public interface C38595ab {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ab$c */
    public interface C11008c {
        void aQS();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ab$a */
    public interface C27398a {
        /* renamed from: gY */
        void mo45133gY();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ab$b */
    public interface C27399b {
        /* renamed from: qy */
        boolean mo35115qy(int i);
    }

    /* renamed from: N */
    void mo6563N(float f, float f2);

    /* renamed from: a */
    void mo6564a(OnFocusChangeListener onFocusChangeListener);

    /* renamed from: a */
    void mo6565a(C27398a c27398a);

    /* renamed from: a */
    void mo6566a(C11008c c11008c);

    boolean aQP();

    boolean aQQ();

    boolean aQT();

    void aRi();

    void aRj();

    void aRk();

    void addTextChangedListener(TextWatcher textWatcher);

    /* renamed from: b */
    void mo6581b(OnFocusChangeListener onFocusChangeListener);

    void destroy();

    C42736b getAutoFillController();

    Context getContext();

    int getInputId();

    View getInputPanel();

    char getLastKeyPressed();

    CharSequence getText();

    View getView();

    /* renamed from: qI */
    int mo6598qI(int i);

    void setFixed(boolean z);

    void setInputId(int i);

    void setOnKeyUpPostImeListener(C27399b c27399b);

    /* renamed from: y */
    void mo6620y(C44709u c44709u);

    /* renamed from: z */
    void mo6621z(C44709u c44709u);
}
