package com.tencent.p177mm.plugin.appbrand.game.p295e.p296a;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.C16003g;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.C42449a;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.C42449a.C33207a;
import com.tencent.p177mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w.C33636e;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42744p;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42744p.C38603a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45720aj;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33624b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C45723b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e */
public final class C33199e extends C10296a<C19722s> {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final C45561c hsr = new C45561c();
    final C26887a hss = new C26887a();
    final C41230b hst = new C41230b();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$3 */
    class C192383 extends C16003g {
        final /* synthetic */ C19722s hsj;

        C192383(C19722s c19722s) {
            this.hsj = c19722s;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(130207);
            if (C45720aj.m84473D(editable)) {
                AppMethodBeat.m2505o(130207);
                return;
            }
            C33199e.this.hsr.mo73369a(editable.toString(), this.hsj);
            AppMethodBeat.m2505o(130207);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$2 */
    class C268882 extends C38603a {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ C19722s hsj;

        C268882(WAGamePanelInputEditText wAGamePanelInputEditText, C19722s c19722s) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = c19722s;
        }

        /* renamed from: JX */
        public final void mo11316JX() {
            AppMethodBeat.m2504i(130206);
            C33199e.this.hsr.mo73369a(this.hsA.getEditableText().toString(), this.hsj);
            AppMethodBeat.m2505o(130206);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$4 */
    class C332004 implements C45723b {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ C19722s hsj;

        C332004(WAGamePanelInputEditText wAGamePanelInputEditText, C19722s c19722s) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = c19722s;
        }

        public final void aAL() {
            AppMethodBeat.m2504i(130208);
            C33199e.this.hsr.mo73369a(this.hsA.getEditableText().toString(), this.hsj);
            AppMethodBeat.m2505o(130208);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$5 */
    class C332015 implements OnClickListener {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ C42449a hsB;
        final /* synthetic */ C19722s hsj;
        final /* synthetic */ boolean hsx;

        C332015(WAGamePanelInputEditText wAGamePanelInputEditText, C19722s c19722s, boolean z, C42449a c42449a) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = c19722s;
            this.hsx = z;
            this.hsB = c42449a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(130209);
            C33199e.this.hst.mo65881a(this.hsA.getEditableText().toString(), this.hsj);
            C33199e.this.hsr.mo73369a(this.hsA.getEditableText().toString(), this.hsj);
            if (!this.hsx) {
                this.hsB.hide();
            }
            AppMethodBeat.m2505o(130209);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$6 */
    class C332026 implements C33636e {
        final /* synthetic */ int eIl;
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ C42449a hsB;
        final /* synthetic */ float hsC;
        final /* synthetic */ C19722s hsj;

        C332026(WAGamePanelInputEditText wAGamePanelInputEditText, C19722s c19722s, C42449a c42449a, float f, int i) {
            this.hsA = wAGamePanelInputEditText;
            this.hsj = c19722s;
            this.hsB = c42449a;
            this.hsC = f;
            this.eIl = i;
        }

        /* renamed from: nS */
        public final void mo35132nS(int i) {
            AppMethodBeat.m2504i(130210);
            if (2 == i) {
                C26887a c26887a = C33199e.this.hss;
                String obj = this.hsA.getEditableText().toString();
                C19722s c19722s = this.hsj;
                HashMap hashMap = new HashMap(2);
                hashMap.put("errMsg", "ok");
                hashMap.put("value", obj);
                c26887a.mo34958t(hashMap).mo61031i(c19722s).aCj();
                AppMethodBeat.m2505o(130210);
                return;
            }
            C4990ab.m7417i("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", Integer.valueOf(this.hsB.getHeight()), Float.valueOf(this.hsC));
            HashMap hashMap2 = new HashMap(1);
            hashMap2.put("height", Float.valueOf(((float) r0) / this.hsC));
            this.hsj.mo6107M(this.eIl, C33199e.this.mo73394j("ok", hashMap2));
            AppMethodBeat.m2505o(130210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.e.a.e$7 */
    class C332037 implements OnEditorActionListener {
        final /* synthetic */ WAGamePanelInputEditText hsA;
        final /* synthetic */ C19722s hsj;
        final /* synthetic */ boolean hsx;

        C332037(boolean z, WAGamePanelInputEditText wAGamePanelInputEditText, C19722s c19722s) {
            this.hsx = z;
            this.hsA = wAGamePanelInputEditText;
            this.hsj = c19722s;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(130211);
            if (this.hsx) {
                C33199e.this.hst.mo65881a(this.hsA.getEditableText().toString(), this.hsj);
                AppMethodBeat.m2505o(130211);
                return true;
            }
            AppMethodBeat.m2505o(130211);
            return false;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130213);
        final C19722s c19722s = (C19722s) c2241c;
        final String optString = jSONObject.optString("defaultValue");
        int optInt = jSONObject.optInt("maxLength", 140);
        if (optInt <= 0) {
            optInt = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        final boolean optBoolean = jSONObject.optBoolean("multiple", false);
        final boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
        final C33624b EI = C33624b.m54895EI(jSONObject.optString("confirmType"));
        final int i2 = i;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130205);
                C33199e c33199e = C33199e.this;
                C19722s c19722s = c19722s;
                CharSequence charSequence = optString;
                int i = optInt;
                boolean z = optBoolean;
                boolean z2 = optBoolean2;
                C33624b c33624b = EI;
                int i2 = i2;
                if (c19722s.isRunning()) {
                    C27242w aun = c19722s.aun();
                    if (aun != null) {
                        float density = C1338a.getDensity(aun.mContext);
                        C42449a cl = C42449a.m75190cl(aun.getContentView());
                        WAGamePanelInputEditText attachedEditText = cl.getAttachedEditText();
                        if (C5046bo.isNullOrNil(charSequence)) {
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
                        C7357c PM = C42744p.m75759a(attachedEditText).mo15877PM(i);
                        PM.zIx = false;
                        PM.jeZ = C5583a.MODE_CHINESE_AS_1;
                        PM.mo15879a(new C268882(attachedEditText, c19722s));
                        attachedEditText.addTextChangedListener(new C192383(c19722s));
                        attachedEditText.setComposingDismissedListener(new C332004(attachedEditText, c19722s));
                        cl.setOnConfirmClickListener(new C332015(attachedEditText, c19722s, z2, cl));
                        cl.setOnVisibilityChangedListener(new C332026(attachedEditText, c19722s, cl, density, i2));
                        if (!z) {
                            attachedEditText.setOnEditorActionListener(new C332037(z2, attachedEditText, c19722s));
                        }
                        C26839b dI = C26835a.m42717t(c19722s.getRuntime().atM()).mo44610dI(C26835a.ayQ());
                        MMActivity atM = c19722s.getRuntime().atM();
                        C33207a c33207a = cl.hur;
                        int fr = C5222ae.m7944fr(atM);
                        C4990ab.m7417i("MicroMsg.WAGameInputPanel", "orientation: %s", dI);
                        if (dI == C26839b.LANDSCAPE_SENSOR || dI == C26839b.LANDSCAPE_LOCKED || C26839b.LANDSCAPE_LEFT == dI || C26839b.LANDSCAPE_RIGHT == dI) {
                            LayoutParams layoutParams = (LayoutParams) c33207a.huw.getLayoutParams();
                            C4990ab.m7417i("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", Integer.valueOf(fr), Integer.valueOf(layoutParams.rightMargin));
                            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fr + layoutParams.rightMargin, layoutParams.bottomMargin);
                            c33207a.huw.setLayoutParams(layoutParams);
                        }
                        C33624b c33624b2 = c33624b == null ? C33624b.DONE : c33624b;
                        cl.getAttachedEditText().setImeOptions(c33624b2.jjd);
                        cl.getAttachedEditText().setFocusable(true);
                        cl.getAttachedEditText().setFocusableInTouchMode(true);
                        cl.show();
                        switch (c33624b2) {
                            case DONE:
                                ((Button) cl.hur.getConfirmButton()).setText(C25738R.string.f9276v8);
                                AppMethodBeat.m2505o(130205);
                                return;
                            case SEARCH:
                                ((Button) cl.hur.getConfirmButton()).setText(C25738R.string.f9279va);
                                AppMethodBeat.m2505o(130205);
                                return;
                            case NEXT:
                                ((Button) cl.hur.getConfirmButton()).setText(C25738R.string.f9278v_);
                                AppMethodBeat.m2505o(130205);
                                return;
                            case GO:
                                ((Button) cl.hur.getConfirmButton()).setText(C25738R.string.f9277v9);
                                AppMethodBeat.m2505o(130205);
                                return;
                            case SEND:
                                ((Button) cl.hur.getConfirmButton()).setText(C25738R.string.f9280vb);
                                break;
                        }
                        AppMethodBeat.m2505o(130205);
                        return;
                    }
                }
                AppMethodBeat.m2505o(130205);
            }
        });
        AppMethodBeat.m2505o(130213);
    }

    public C33199e() {
        AppMethodBeat.m2504i(130212);
        AppMethodBeat.m2505o(130212);
    }
}
