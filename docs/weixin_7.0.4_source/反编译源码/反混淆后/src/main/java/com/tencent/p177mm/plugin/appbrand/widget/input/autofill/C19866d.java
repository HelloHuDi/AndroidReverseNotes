package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C33622h.C27406a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33623a.C27408a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.d */
public final class C19866d {

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.d$a */
    public static final class C19868a extends C38369p {
        private static final int CTRL_INDEX = 207;
        public static final String NAME = "onKeyboardDropdownOperate";
    }

    /* renamed from: a */
    public static <Input extends EditText & C38595ab> void m30749a(C44709u c44709u, Input input, C27408a c27408a) {
        AppMethodBeat.m2504i(123904);
        if (((C38595ab) input).aQQ()) {
            final WeakReference weakReference = new WeakReference(c44709u);
            final WeakReference weakReference2 = new WeakReference(input);
            C33622h c198671 = new C33622h() {
                /* renamed from: a */
                public final void mo35093a(String str, C27406a c27406a) {
                    AppMethodBeat.m2504i(123903);
                    EditText editText = (EditText) weakReference2.get();
                    C44709u c44709u = (C44709u) weakReference.get();
                    if (editText == null || c44709u == null) {
                        AppMethodBeat.m2505o(123903);
                        return;
                    }
                    int inputId = ((C38595ab) editText).getInputId();
                    C19868a c19868a = new C19868a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("id", str);
                    hashMap.put("type", c27406a.name().toLowerCase());
                    hashMap.put("inputId", Integer.valueOf(inputId));
                    c19868a.mo61031i(c44709u).mo34958t(hashMap).aCj();
                    AppMethodBeat.m2505o(123903);
                }
            };
            C42736b autoFillController = ((C38595ab) input).getAutoFillController();
            autoFillController.mo68183s(c27408a.jiX);
            autoFillController.mo68180a(c198671);
            autoFillController.mo68179a("screen".equalsIgnoreCase(c27408a.jiW) ? C11014f.SCREEN : C11014f.VIEW);
            AppMethodBeat.m2505o(123904);
            return;
        }
        AppMethodBeat.m2505o(123904);
    }
}
