package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class d {

    public static final class a extends p {
        private static final int CTRL_INDEX = 207;
        public static final String NAME = "onKeyboardDropdownOperate";
    }

    public static <Input extends EditText & ab> void a(u uVar, Input input, com.tencent.mm.plugin.appbrand.widget.input.d.a.a aVar) {
        AppMethodBeat.i(123904);
        if (((ab) input).aQQ()) {
            final WeakReference weakReference = new WeakReference(uVar);
            final WeakReference weakReference2 = new WeakReference(input);
            h anonymousClass1 = new h() {
                public final void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
                    AppMethodBeat.i(123903);
                    EditText editText = (EditText) weakReference2.get();
                    u uVar = (u) weakReference.get();
                    if (editText == null || uVar == null) {
                        AppMethodBeat.o(123903);
                        return;
                    }
                    int inputId = ((ab) editText).getInputId();
                    a aVar2 = new a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("id", str);
                    hashMap.put("type", aVar.name().toLowerCase());
                    hashMap.put("inputId", Integer.valueOf(inputId));
                    aVar2.i(uVar).t(hashMap).aCj();
                    AppMethodBeat.o(123903);
                }
            };
            b autoFillController = ((ab) input).getAutoFillController();
            autoFillController.s(aVar.jiX);
            autoFillController.a(anonymousClass1);
            autoFillController.a("screen".equalsIgnoreCase(aVar.jiW) ? f.SCREEN : f.VIEW);
            AppMethodBeat.o(123904);
            return;
        }
        AppMethodBeat.o(123904);
    }
}
