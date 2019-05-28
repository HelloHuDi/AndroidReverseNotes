package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.v4.view.s;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.g;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

public abstract class i implements aa<y> {
    public volatile c jdM;
    private volatile a jdN;
    public volatile b jdO;
    final OnFocusChangeListener jdP = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(123627);
            if (z) {
                o.b((u) i.this.jdV.get(), i.this);
            }
            i.a(i.this, z);
            Object obj = (!z || (i.this.jdT.jjl && !n.ct(i.this.jdW))) ? null : 1;
            if (!(obj == null || i.this.jdW == null || i.this.jdX == null)) {
                i.this.jdW.requestFocus();
                i.this.jdX.show();
            }
            AppMethodBeat.o(123627);
        }
    };
    private int jdQ = -1;
    private int jdR = -1;
    d jdS = null;
    public e jdT;
    public int jdU;
    protected WeakReference<u> jdV;
    public y jdW;
    w jdX;
    private v jdY;
    private final Runnable jdZ = new Runnable() {
        public final void run() {
            AppMethodBeat.i(123637);
            i.this.aQA();
            AppMethodBeat.o(123637);
        }
    };
    private final com.tencent.mm.ui.tools.b.c.a jdp = new com.tencent.mm.plugin.appbrand.widget.input.p.a() {
        public final void JX() {
            AppMethodBeat.i(123636);
            if (i.this.jdW != null) {
                try {
                    i.this.jea.a(i.this.jdW.getEditableText(), false);
                    AppMethodBeat.o(123636);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(123636);
        }
    };
    public final com.tencent.mm.plugin.appbrand.widget.input.c.a jea = new com.tencent.mm.plugin.appbrand.widget.input.c.a();
    boolean jeb = false;
    final ak jec = new ak(Looper.getMainLooper());
    final Runnable jed = new Runnable() {
        public final void run() {
            i.this.jeb = false;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.w.d jee = new com.tencent.mm.plugin.appbrand.widget.input.w.d() {
        public final boolean EH(String str) {
            AppMethodBeat.i(123631);
            if (i.this.jdW != null) {
                y yVar;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    yVar = i.this.jdW;
                    if (yVar.jfF == null) {
                        yVar.dispatchKeyEvent(new KeyEvent(0, 67));
                        yVar.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!bo.ac(yVar.getEditableText())) {
                        yVar.jfF.deleteSurroundingText(yVar.getEditableText().length(), yVar.getEditableText().length() - 1);
                    }
                } else {
                    yVar = i.this.jdW;
                    f.aQv();
                    if (yVar.getEditableText() == null) {
                        yVar.setText(str, BufferType.EDITABLE);
                    } else {
                        yVar.getEditableText().append(str);
                    }
                    yVar.setSelection(yVar.getEditableText().length());
                }
            }
            AppMethodBeat.o(123631);
            return true;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.w.c jef = new com.tencent.mm.plugin.appbrand.widget.input.w.c() {
        public final void fd(boolean z) {
            AppMethodBeat.i(123632);
            if (z) {
                i.this.jdS = d.CONFIRM_CLICKED;
            }
            i.f(i.this);
            i.this.jdS = null;
            AppMethodBeat.o(123632);
        }
    };
    private final w.e jkt = new w.e() {
        public final void nS(int i) {
            AppMethodBeat.i(123633);
            ab.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", Integer.valueOf(i));
            if (i != 2) {
                if (i == 0 && i.this.jdW != null) {
                    i.this.jdW.requestFocus();
                }
                i.this.aQH();
                if (!(i.this.jdV == null || i.this.jdV.get() == null)) {
                    o.a((u) i.this.jdV.get(), i.this.jdW);
                    AppMethodBeat.o(123633);
                    return;
                }
            }
            i.this.jdS = d.PANEL_HIDDEN;
            i.f(i.this);
            i.this.jdS = null;
            AppMethodBeat.o(123633);
        }
    };

    public interface a {
    }

    public interface b {
        void a(aa aaVar, int i);
    }

    public interface c {
        void db(int i, int i2);
    }

    enum d {
        PANEL_HIDDEN,
        CONFIRM_CLICKED;

        static {
            AppMethodBeat.o(123645);
        }
    }

    public abstract void Ba(String str);

    public abstract void aDA();

    public abstract void aDB();

    public abstract void b(String str, int i, boolean z, boolean z2);

    static /* synthetic */ void f(i iVar) {
        boolean z = iVar.jdS == d.CONFIRM_CLICKED && aj.g(iVar.jdT.jjL);
        if (!z) {
            if (iVar.aQG() != null) {
                iVar.jdX.hide();
            } else if (iVar.jdV != null) {
                u uVar = (u) iVar.jdV.get();
                if (uVar != null) {
                    ad aJw = uVar.aJw();
                    if (aJw != null) {
                        aJw.aqX();
                    }
                }
            }
            k.a(iVar.jdV).qB(iVar.jdU);
        }
        if (iVar.jdW != null) {
            if (iVar.jdW.hasFocus()) {
                iVar.fc(z);
            }
            if (!z) {
                iVar.jdW.b(iVar.jdP);
                if (iVar.jdX != null && iVar.jdX.b(iVar.jdW)) {
                    iVar.jdX.hide();
                }
                iVar.jdW.setFocusable(false);
                iVar.jdW.setFocusableInTouchMode(false);
                if (iVar.jdT.jjl) {
                    iVar.aQC();
                }
            }
        }
    }

    public final boolean s(u uVar) {
        return (uVar == null || this.jdV == null || uVar != this.jdV.get()) ? false : true;
    }

    public final boolean aQt() {
        boolean z;
        if (this.jdW == null || (!this.jdW.isFocused() && (aQG() == null || aQG().getAttachedEditText() != this.jdW))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            w aQG = aQG();
            if (aQG != null) {
                aQG.setVisibility(8);
            }
        } else {
            ab.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
        }
        return true;
    }

    public final void a(String str, Integer num) {
        if (this.jdW != null) {
            this.jdW.B(str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            dq(valueOf.intValue(), valueOf.intValue());
            aQz();
        }
    }

    public final boolean aQn() {
        Object obj;
        if (this.jdW == null || this.jdV == null || this.jdV.get() == null) {
            obj = null;
        } else {
            this.jdW.destroy();
            g gVar = (g) ((u) this.jdV.get()).aAY();
            if (gVar == null) {
                obj = null;
            } else {
                if (this.jdW.hasFocus()) {
                    if (this.jdY != null) {
                        this.jdY.setVisibility(8);
                    }
                    aQG();
                    if (this.jdX != null) {
                        this.jdX.setVisibility(8);
                    }
                }
                gVar.cF(this.jdW);
                int obj2 = 1;
            }
        }
        if (obj2 == null) {
            return false;
        }
        onDestroy();
        return true;
    }

    public final <P extends View & ac> P getInputPanel() {
        return this.jdX;
    }

    public final boolean aQr() {
        return this.jdT != null && aj.g(this.jdT.jjM);
    }

    public final int aQs() {
        if (this.jdT != null && this.jdT.jjJ != null) {
            return this.jdT.jjJ.intValue();
        }
        if (this.jdW == null || !this.jdW.aQP()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.jdW = null;
        com.tencent.mm.plugin.appbrand.s.e.at(this);
    }

    public final int getInputId() {
        return this.jdU;
    }

    public final void qx(int i) {
        b bVar = this.jdO;
        if (bVar != null) {
            bVar.a(this, i);
        }
    }

    public final void aQq() {
        if (this.jdW != null && aj.g(this.jdT.jjH) && aj.g(this.jdT.jjF)) {
            ((q) this.jdW).setAutoHeight(true);
            int lineHeight = this.jdW.getLineHeight();
            int aRh = this.jdW.aRh();
            int intValue = (this.jdT.jjt == null || this.jdT.jjt.intValue() <= 0) ? lineHeight : this.jdT.jjt.intValue();
            lineHeight = (this.jdT.jju == null || this.jdT.jju.intValue() <= 0) ? BaseClientBuilder.API_PRIORITY_OTHER : Math.max(this.jdT.jju.intValue(), lineHeight);
            this.jdW.setMinHeight(intValue);
            this.jdW.setMaxHeight(lineHeight);
            this.jdT.jjq = Integer.valueOf(Math.max(intValue, Math.min(aRh, lineHeight)));
            b(this.jdW, this.jdT);
        }
    }

    public final void aQy() {
        b.a(this.jdW, this.jdT);
        if (this.jdT.jjy == null) {
            this.jdT.jjy = Integer.valueOf(140);
        } else if (this.jdT.jjy.intValue() <= 0) {
            this.jdT.jjy = Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER);
        }
        com.tencent.mm.ui.tools.b.c PM = p.a(this.jdW).PM(this.jdT.jjy.intValue());
        PM.zIx = false;
        PM.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_1;
        PM.a(this.jdp);
        this.jdW.setPasswordMode(this.jdT.jjk);
        if (aj.g(this.jdT.jjD)) {
            this.jdW.setEnabled(false);
            this.jdW.setFocusable(false);
            this.jdW.setFocusableInTouchMode(false);
            this.jdW.setClickable(false);
        } else {
            this.jdW.setEnabled(true);
            this.jdW.setClickable(true);
        }
        if (this.jdW instanceof q) {
            if (this.jdT.jjN != null) {
                ((q) this.jdW).setLineSpace((float) this.jdT.jjN.intValue());
            }
            if (this.jdT.jjO != null) {
                ((q) this.jdW).setLineHeight((float) this.jdT.jjO.intValue());
            }
        }
    }

    private void dq(int i, int i2) {
        b.a(this.jdW, i, i2);
        aQA();
    }

    public final void aQz() {
        if (this.jdW != null) {
            if (this.jdW.getLineCount() != this.jdQ || this.jdW.aRh() != this.jdR) {
                Object obj = this.jdQ == -1 ? 1 : null;
                this.jdQ = this.jdW.getLineCount();
                this.jdR = this.jdW.aRh();
                if (this.jdM != null) {
                    this.jdM.db(this.jdQ, this.jdR);
                }
                if (this.jdT.jjF.booleanValue() && obj == null) {
                    aQq();
                    aQA();
                }
            }
        }
    }

    private void aQA() {
        if (this.jdT.jjF.booleanValue() && this.jdX != null && this.jdX.isShown() && this.jdW != null && this.jdW == this.jdX.getAttachedEditText()) {
            k.a(this.jdV).qA(this.jdU);
        }
    }

    private void aQB() {
        if (this.jdT.jjF.booleanValue()) {
            aQG();
        }
        if (this.jdX != null && this.jdW != null) {
            this.jdX.jfW = this.jdW;
            this.jdX.setShowDoneButton(aj.g(this.jdT.jjG));
            aQE();
            if (n.ct(this.jdW) && this.jdW.hasFocus()) {
                this.jdX.show();
            }
        }
    }

    private void aQC() {
        this.jdX.b(this.jdW);
        a(this.jdW);
        this.jdW.destroy();
        onDestroy();
    }

    public final void ds(int i, int i2) {
        this.jdV = this.jdT.jdm;
        u uVar = this.jdV == null ? null : (u) this.jdV.get();
        if (uVar == null || uVar.aJz() == null) {
            ab.e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
            aDB();
            return;
        }
        y qVar;
        if (aj.g(this.jdT.jjF)) {
            qVar = new q(uVar.mContext);
        } else {
            qVar = new t(uVar.mContext);
        }
        this.jdW = qVar;
        this.jdU = this.jdT.jdk;
        this.jdW.setInputId(this.jdU);
        o.b(uVar, (aa) this);
        aQy();
        this.jdW.setText(bo.nullAsNil(this.jdT.jjo));
        if (aj.g(this.jdT.jjH)) {
            aQz();
        }
        this.jdW.addTextChangedListener(new g() {
            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(123638);
                if (i.this.jdV == null || i.this.jdV.get() == null || i.this.jdW == null) {
                    AppMethodBeat.o(123638);
                    return;
                }
                i.this.aQz();
                if (aj.D(editable)) {
                    ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                    AppMethodBeat.o(123638);
                    return;
                }
                ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
                i.this.jea.a(i.this.jdW.getEditableText(), i.this.jeb);
                AppMethodBeat.o(123638);
            }
        });
        this.jdW.setOnComposingDismissedListener(new com.tencent.mm.plugin.appbrand.widget.input.c.b() {
            public final void aAL() {
                AppMethodBeat.i(123639);
                if (i.this.jdW == null) {
                    AppMethodBeat.o(123639);
                    return;
                }
                ab.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", i.this.jdW.getEditableText());
                i.this.jea.a(i.this.jdW.getEditableText(), false);
                AppMethodBeat.o(123639);
            }
        });
        this.jdW.setOnKeyUpPostImeListener(new com.tencent.mm.plugin.appbrand.widget.input.ab.b() {
            public final boolean qy(int i) {
                AppMethodBeat.i(123640);
                if (i != 67) {
                    AppMethodBeat.o(123640);
                    return false;
                } else if (aj.D(i.this.jdW.getText())) {
                    AppMethodBeat.o(123640);
                    return false;
                } else {
                    i.this.Ba(i.this.jdW.getText().toString());
                    AppMethodBeat.o(123640);
                    return true;
                }
            }
        });
        if (a(this.jdW, this.jdT)) {
            if (!(this.jdT.jjn == null || bo.ek(this.jdT.jjn.jiX))) {
                com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(uVar, this.jdW, this.jdT.jjn);
            }
            if (!aj.g(this.jdT.jjF)) {
                b.a(this.jdW, i, i2);
            }
            if (aj.g(this.jdT.jjF)) {
                this.jdW.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(123641);
                        i.this.aQz();
                        AppMethodBeat.o(123641);
                    }
                });
            }
            if ("text".equalsIgnoreCase(this.jdT.jjj) || "emoji".equalsIgnoreCase(this.jdT.jjj)) {
                aQF();
            } else {
                Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[]{this.jdT.jjj}), true);
                aQF();
            }
            this.jdW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(123642);
                    if (i.this.jdW == null) {
                        AppMethodBeat.o(123642);
                    } else if (i.this.jdW.hasFocus()) {
                        i.this.aQB();
                        AppMethodBeat.o(123642);
                    } else {
                        if (i.this.jdW == view) {
                            i.this.aQD();
                        }
                        AppMethodBeat.o(123642);
                    }
                }
            });
            aDA();
            return;
        }
        ab.e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
        aDB();
    }

    private void aQD() {
        boolean z;
        boolean z2 = true;
        u uVar = this.jdV == null ? null : (u) this.jdV.get();
        if (this.jdX == null) {
            aQG();
        }
        String str = "MicroMsg.AppBrandInputInvokeHandler";
        String str2 = "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]";
        Object[] objArr = new Object[3];
        if (this.jdW == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        if (uVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.jdX != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        ab.i(str, str2, objArr);
        if (uVar != null && this.jdW != null && this.jdX != null) {
            o.a(uVar, this.jdW);
            final PBool pBool = new PBool();
            pBool.value = false;
            final AnonymousClass2 anonymousClass2 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123628);
                    ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
                    pBool.value = true;
                    u uVar = i.this.jdV == null ? null : (u) i.this.jdV.get();
                    if (uVar == null || i.this.jdW == null) {
                        AppMethodBeat.o(123628);
                    } else if (o.x(uVar) != i.this) {
                        AppMethodBeat.o(123628);
                    } else {
                        ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
                        h.aQx().c(uVar.aJz());
                        aj.cT(i.this.jdW);
                        if (i.this.jdX != null && i.this.jdX.b(null)) {
                            i.this.jdX.hide();
                        }
                        i.this.jdW.a(i.this.jdP);
                        i.this.jdW.setFocusable(true);
                        i.this.jdW.setFocusableInTouchMode(true);
                        i.this.jdX.jfW = i.this.jdW;
                        i.this.jdW.requestFocus();
                        aj.cT(i.this.jdW);
                        if (i.this.jdX != null) {
                            i.this.jdX.show();
                        }
                        AppMethodBeat.o(123628);
                    }
                }
            };
            Activity cY = com.tencent.mm.ui.statusbar.d.cY(uVar.mContext);
            if (!(cY == null || cY.getCurrentFocus() == null)) {
                View currentFocus = cY.getCurrentFocus();
                boolean isActive = aj.cS(currentFocus).isActive(currentFocus);
                boolean f = aj.f(uVar.aJz().getWrapperView(), currentFocus);
                if (isActive && f) {
                    ab.i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
                    this.jdX.setOnVisibilityChangedListener(new w.e() {
                        public final void nS(int i) {
                            AppMethodBeat.i(123629);
                            if (pBool.value || i != 2) {
                                AppMethodBeat.o(123629);
                                return;
                            }
                            anonymousClass2.run();
                            AppMethodBeat.o(123629);
                        }
                    });
                    com.tencent.mm.sdk.g.d.xDG.q(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(123630);
                            if (pBool.value) {
                                AppMethodBeat.o(123630);
                                return;
                            }
                            anonymousClass2.run();
                            AppMethodBeat.o(123630);
                        }
                    }, 100);
                    return;
                }
            }
            anonymousClass2.run();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean a(y yVar, e eVar) {
        if (yVar == null || this.jdV == null || this.jdV.get() == null) {
            return false;
        }
        g gVar = (g) ((u) this.jdV.get()).aAY();
        if (gVar != null) {
            if (gVar.a(((u) this.jdV.get()).aJz(), yVar, eVar.jjp.intValue(), eVar.jjq.intValue(), eVar.jjs.intValue(), eVar.jjr.intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean b(y yVar, e eVar) {
        if (yVar == null || this.jdV == null || this.jdV.get() == null) {
            return false;
        }
        g gVar = (g) ((u) this.jdV.get()).aAY();
        if (gVar != null) {
            if (gVar.c(((u) this.jdV.get()).aJz(), yVar, eVar.jjp.intValue(), eVar.jjq.intValue(), eVar.jjs.intValue(), eVar.jjr.intValue())) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(y yVar) {
        if (yVar != null) {
            yVar.b(this.jdP);
            u uVar = this.jdV == null ? null : (u) this.jdV.get();
            if (uVar != null) {
                g gVar = (g) uVar.aAY();
                if (gVar != null) {
                    gVar.cF(yVar);
                }
            }
        }
    }

    private void aQE() {
        if (this.jdX != null) {
            this.jdX.setOnSmileyChosenListener(this.jee);
            this.jdX.setOnDoneListener(this.jef);
            this.jdX.setOnVisibilityChangedListener(this.jkt);
        }
    }

    private void aQF() {
        u uVar = (u) this.jdV.get();
        if (s.av(uVar.getContentView())) {
            this.jdX = w.cO(uVar.getContentView());
            if (this.jdT.jjl) {
                aQE();
                aQH();
            }
            this.jdW.a(this.jdP);
            this.jdW.setOnKeyListener(new OnKeyListener() {
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    boolean z;
                    AppMethodBeat.i(123634);
                    i iVar = i.this;
                    if (67 == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    iVar.jeb = z;
                    if (i.this.jeb) {
                        i.this.jec.removeCallbacks(i.this.jed);
                        i.this.jec.postDelayed(i.this.jed, 1000);
                    } else {
                        i.this.jed.run();
                    }
                    AppMethodBeat.o(123634);
                    return false;
                }
            });
            if (this.jdT.jjl) {
                o.a((u) this.jdV.get(), this.jdW);
            }
            w wVar = this.jdX;
            boolean z = !this.jdT.jjk && "emoji".equals(this.jdT.jjj);
            wVar.setCanSmileyInput(z);
            if (this.jdT.jjF.booleanValue()) {
                this.jdW.setOnEditorActionListener(null);
                this.jdW.setImeOptions(0);
            } else {
                com.tencent.mm.plugin.appbrand.widget.input.d.b aRI;
                if (this.jdT.jjK == null) {
                    aRI = com.tencent.mm.plugin.appbrand.widget.input.d.b.aRI();
                } else {
                    aRI = this.jdT.jjK;
                }
                final int i = aRI.jjd;
                this.jdW.setImeOptions(i);
                this.jdW.setOnEditorActionListener(new OnEditorActionListener() {
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(123635);
                        if (i == i) {
                            i.this.jdS = d.CONFIRM_CLICKED;
                            i.f(i.this);
                            i.this.jdS = null;
                            AppMethodBeat.o(123635);
                            return true;
                        }
                        AppMethodBeat.o(123635);
                        return false;
                    }
                });
            }
            this.jdX.setShowDoneButton(this.jdT.jjG.booleanValue());
            this.jdX.jfW = this.jdW;
            if (this.jdT.jjl) {
                aQD();
            } else {
                this.jdW.setFocusable(false);
                this.jdW.setFocusableInTouchMode(false);
                this.jdX.hide();
            }
            if (this.jdT.jjl) {
                k.a(this.jdV).qA(this.jdU);
            }
        }
    }

    private void fc(boolean z) {
        if (this.jdW != null) {
            b(this.jdW.getText().toString(), this.jdW.getSelectionEnd(), this.jdS == d.CONFIRM_CLICKED, z);
        }
    }

    private w aQG() {
        if (this.jdX != null) {
            return this.jdX;
        }
        if (this.jdV != null) {
            u uVar = (u) this.jdV.get();
            if (uVar != null) {
                w cN = w.cN(uVar.getContentView());
                this.jdX = cN;
                return cN;
            }
        }
        return null;
    }

    private v aQu() {
        if (this.jdY != null) {
            return this.jdY;
        }
        if (this.jdV != null) {
            u uVar = (u) this.jdV.get();
            if (uVar != null) {
                v cL = v.cL(uVar.getContentView());
                this.jdY = cL;
                return cL;
            }
        }
        return null;
    }

    private void aQH() {
        if (aQu() != null) {
            this.jdY.setVisibility(8);
        }
    }

    public final boolean dr(int i, int i2) {
        if (!(this.jdW == null || this.jdV == null || this.jdV.get() == null)) {
            this.jdW.performClick();
        }
        dq(i, i2);
        return true;
    }

    public final /* bridge */ /* synthetic */ EditText aQo() {
        return this.jdW;
    }
}
