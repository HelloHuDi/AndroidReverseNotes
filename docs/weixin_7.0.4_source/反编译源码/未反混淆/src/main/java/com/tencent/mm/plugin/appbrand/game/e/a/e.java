package com.tencent.mm.plugin.appbrand.game.e.a;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.aj;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.g;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a<s> {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final c hsr = new c();
    final a hss = new a();
    final b hst = new b();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$3 */
    class AnonymousClass3 extends g {
        final /* synthetic */ s hsj;

        AnonymousClass3(s sVar) {
            this.hsj = sVar;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(130207);
            if (aj.D(editable)) {
                AppMethodBeat.o(130207);
                return;
            }
            e.this.hsr.a(editable.toString(), this.hsj);
            AppMethodBeat.o(130207);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$2 */
    class AnonymousClass2 extends p.a {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ s hsj;

        AnonymousClass2(WAGamePanelInputEditText wAGamePanelInputEditText, s sVar) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = sVar;
        }

        public final void JX() {
            AppMethodBeat.i(130206);
            e.this.hsr.a(this.hsA.getEditableText().toString(), this.hsj);
            AppMethodBeat.o(130206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$4 */
    class AnonymousClass4 implements b {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ s hsj;

        AnonymousClass4(WAGamePanelInputEditText wAGamePanelInputEditText, s sVar) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = sVar;
        }

        public final void aAL() {
            AppMethodBeat.i(130208);
            e.this.hsr.a(this.hsA.getEditableText().toString(), this.hsj);
            AppMethodBeat.o(130208);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$5 */
    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.game.widget.input.a hsB;
        final /* synthetic */ s hsj;
        final /* synthetic */ boolean hsx;

        AnonymousClass5(WAGamePanelInputEditText wAGamePanelInputEditText, s sVar, boolean z, com.tencent.mm.plugin.appbrand.game.widget.input.a aVar) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = sVar;
            this.hsx = z;
            this.hsB = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(130209);
            e.this.hst.a(this.hsA.getEditableText().toString(), this.hsj);
            e.this.hsr.a(this.hsA.getEditableText().toString(), this.hsj);
            if (!this.hsx) {
                this.hsB.hide();
            }
            AppMethodBeat.o(130209);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$6 */
    class AnonymousClass6 implements com.tencent.mm.plugin.appbrand.widget.input.w.e {
        final /* synthetic */ int eIl;
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.game.widget.input.a hsB;
        final /* synthetic */ float hsC;
        final /* synthetic */ s hsj;

        AnonymousClass6(WAGamePanelInputEditText wAGamePanelInputEditText, s sVar, com.tencent.mm.plugin.appbrand.game.widget.input.a aVar, float f, int i) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = sVar;
            this.hsB = aVar;
            this.hsC = f;
            this.eIl = i;
        }

        public final void nS(int i) {
            AppMethodBeat.i(130210);
            if (2 == i) {
                a aVar = e.this.hss;
                String obj = this.hsA.getEditableText().toString();
                s sVar = this.hsj;
                HashMap hashMap = new HashMap(2);
                hashMap.put("errMsg", "ok");
                hashMap.put("value", obj);
                aVar.t(hashMap).i(sVar).aCj();
                AppMethodBeat.o(130210);
                return;
            }
            ab.i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", Integer.valueOf(this.hsB.getHeight()), Float.valueOf(this.hsC));
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("height", Float.valueOf(((float) r0) / this.hsC));
            this.hsj.M(this.eIl, e.this.j("ok", hashMap2));
            AppMethodBeat.o(130210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$7 */
    class AnonymousClass7 implements OnEditorActionListener {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ s hsj;
        final /* synthetic */ boolean hsx;

        AnonymousClass7(boolean z, WAGamePanelInputEditText wAGamePanelInputEditText, s sVar) {
            this.hsx = z;
            this.hsA = wAGamePanelInputEditText;
            this.hsj = sVar;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.i(130211);
            if (this.hsx) {
                e.this.hst.a(this.hsA.getEditableText().toString(), this.hsj);
                AppMethodBeat.o(130211);
                return true;
            }
            AppMethodBeat.o(130211);
            return false;
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130213);
        final s sVar = (s) cVar;
        final String optString = jSONObject.optString("defaultValue");
        int optInt = jSONObject.optInt("maxLength", 140);
        if (optInt <= 0) {
            optInt = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        final boolean optBoolean = jSONObject.optBoolean("multiple", false);
        final boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
        final com.tencent.mm.plugin.appbrand.widget.input.d.b EI = com.tencent.mm.plugin.appbrand.widget.input.d.b.EI(jSONObject.optString("confirmType"));
        final int i2 = i;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130205);
                e eVar = e.this;
                s sVar = sVar;
                CharSequence charSequence = optString;
                int i = optInt;
                boolean z = optBoolean;
                boolean z2 = optBoolean2;
                com.tencent.mm.plugin.appbrand.widget.input.d.b bVar = EI;
                int i2 = i2;
                if (sVar.isRunning()) {
                    w aun = sVar.aun();
                    if (aun != null) {
                        float density = com.tencent.mm.bz.a.getDensity(aun.mContext);
                        com.tencent.mm.plugin.appbrand.game.widget.input.a cl = com.tencent.mm.plugin.appbrand.game.widget.input.a.cl(aun.getContentView());
                        WAGamePanelInputEditText attachedEditText = cl.getAttachedEditText();
                        if (bo.isNullOrNil(charSequence)) {
                            attachedEditText.setText("");
                        } else {
                            if (charSequence.length() > i) {
                                charSequence = charSequence.substring(0, i);
                            }
                            attachedEditText.setText(charSequence);
                            attachedEditText.setSelection(attachedEditText.getText().length());
                        }
                        attachedEditText.setSingleLine(!z);
                        attachedEditText.setMaxLength(i);
                        com.tencent.mm.ui.tools.b.c PM = p.a(attachedEditText).PM(i);
                        PM.zIx = false;
                        PM.jeZ = f.a.MODE_CHINESE_AS_1;
                        PM.a(new AnonymousClass2(attachedEditText, sVar));
                        attachedEditText.addTextChangedListener(new AnonymousClass3(sVar));
                        attachedEditText.setComposingDismissedListener(new AnonymousClass4(attachedEditText, sVar));
                        cl.setOnConfirmClickListener(new AnonymousClass5(attachedEditText, sVar, z2, cl));
                        cl.setOnVisibilityChangedListener(new AnonymousClass6(attachedEditText, sVar, cl, density, i2));
                        if (!z) {
                            attachedEditText.setOnEditorActionListener(new AnonymousClass7(z2, attachedEditText, sVar));
                        }
                        com.tencent.mm.plugin.appbrand.config.a.a.b dI = com.tencent.mm.plugin.appbrand.config.a.a.t(sVar.getRuntime().atM()).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
                        MMActivity atM = sVar.getRuntime().atM();
                        com.tencent.mm.plugin.appbrand.game.widget.input.a.a aVar = cl.hur;
                        int fr = ae.fr(atM);
                        ab.i("MicroMsg.WAGameInputPanel", "orientation: %s", dI);
                        if (dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED || com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT == dI || com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT == dI) {
                            LayoutParams layoutParams = (LayoutParams) aVar.huw.getLayoutParams();
                            ab.i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", Integer.valueOf(fr), Integer.valueOf(layoutParams.rightMargin));
                            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fr + layoutParams.rightMargin, layoutParams.bottomMargin);
                            aVar.huw.setLayoutParams(layoutParams);
                        }
                        com.tencent.mm.plugin.appbrand.widget.input.d.b bVar2 = bVar == null ? com.tencent.mm.plugin.appbrand.widget.input.d.b.DONE : bVar;
                        cl.getAttachedEditText().setImeOptions(bVar2.jjd);
                        cl.getAttachedEditText().setFocusable(true);
                        cl.getAttachedEditText().setFocusableInTouchMode(true);
                        cl.show();
                        switch (bVar2) {
                            case DONE:
                                ((Button) cl.hur.getConfirmButton()).setText(R.string.v8);
                                AppMethodBeat.o(130205);
                                return;
                            case SEARCH:
                                ((Button) cl.hur.getConfirmButton()).setText(R.string.va);
                                AppMethodBeat.o(130205);
                                return;
                            case NEXT:
                                ((Button) cl.hur.getConfirmButton()).setText(R.string.v_);
                                AppMethodBeat.o(130205);
                                return;
                            case GO:
                                ((Button) cl.hur.getConfirmButton()).setText(R.string.v9);
                                AppMethodBeat.o(130205);
                                return;
                            case SEND:
                                ((Button) cl.hur.getConfirmButton()).setText(R.string.vb);
                                break;
                        }
                        AppMethodBeat.o(130205);
                        return;
                    }
                }
                AppMethodBeat.o(130205);
            }
        });
        AppMethodBeat.o(130213);
    }

    public e() {
        AppMethodBeat.i(130212);
        AppMethodBeat.o(130212);
    }
}
