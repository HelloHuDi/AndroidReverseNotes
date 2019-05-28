package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p612ui.widget.edittext.PasterEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C44005b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40378c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C46456b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4670d;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17003m;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C23185t;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29992n;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29993u;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C40387k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C44009i;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C46458g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText */
public class WXRTEditText extends PasterEditText implements SpanWatcher {
    public int aaF = 0;
    private C7564ap gyS = null;
    public boolean uOb = false;
    public int uOd = 0;
    C40378c uPG;
    private int uPH = -1;
    private int uPI = -1;
    private boolean uPJ = false;
    private boolean uPK;
    private int uPL;
    private int uPM;
    private String uPN;
    public String uPO = "";
    private Spannable uPP;
    int uPQ = 0;
    private WXRTEditText uPR = null;
    public C41531v uPS;
    private boolean uPT;
    private boolean uPU;
    private boolean uPV;
    private boolean uPW;
    private boolean uPX;
    private boolean uPY = false;
    private boolean uPZ;
    private C40383j uQa;
    public boolean uQb = false;
    public boolean uQc = false;
    private int uQd = -1;
    private Paint uQe = null;
    private C46456b uQf = null;
    private boolean uQg = false;
    private Path uQh = null;
    private int uQi = -1;
    private int uQj = -1;
    private int uQk = -1;
    private boolean uQl = false;
    TextWatcher uQm = new C357432();
    int uQn = 0;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText$1 */
    class C357421 implements Callback {
        C357421() {
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
        }

        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText$2 */
    class C357432 implements TextWatcher {
        C357432() {
        }

        public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(26785);
            Object obj;
            if (WXRTEditText.this.uPN == null) {
                obj = "";
            } else {
                obj = WXRTEditText.this.uPN;
            }
            if (!(WXRTEditText.this.uPK || charSequence.toString().equals(obj))) {
                WXRTEditText.this.uPL = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.uPM = WXRTEditText.this.getSelectionEnd();
                WXRTEditText.this.uPN = charSequence.toString();
                WXRTEditText.this.uPO = WXRTEditText.this.uPN;
                WXRTEditText.this.uPP = WXRTEditText.this.deK();
            }
            AppMethodBeat.m2505o(26785);
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(26786);
            WXRTEditText.this.uPZ = true;
            AppMethodBeat.m2505o(26786);
        }

        public final synchronized void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(26787);
            C4990ab.m7410d("noteeditor.WXRTEditText", "afterTextChanged");
            String obj = editable.toString();
            String str;
            if (WXRTEditText.this.uPO == null) {
                str = "";
            } else {
                str = WXRTEditText.this.uPO;
            }
            if (WXRTEditText.this.uPQ != 0) {
                WXRTEditText.this.uPO = "";
            }
            if (!WXRTEditText.this.uPK && WXRTEditText.this.getSelection().aqm == WXRTEditText.this.getSelection().f4406Ls && (((!str.endsWith(IOUtils.LINE_SEPARATOR_UNIX) && (str + IOUtils.LINE_SEPARATOR_UNIX).equals(obj)) || (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX) && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) WXRTEditText.this.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
                int selectionStart = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.uPK = true;
                WXRTEditText.this.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
                WXRTEditText.this.uPK = false;
                WXRTEditText.this.setSelection(selectionStart);
            }
            if (!(WXRTEditText.this.uPG == null || WXRTEditText.this.uPK || str.equals(obj))) {
                Spannable deK = WXRTEditText.this.deK();
                WXRTEditText.this.uPO = obj;
                C40378c g = WXRTEditText.this.uPG;
                WXRTEditText h = WXRTEditText.this.uPR;
                Spannable i = WXRTEditText.this.uPP;
                WXRTEditText.this.uPL;
                WXRTEditText.this.uPM;
                WXRTEditText.this.getSelectionStart();
                g.mo63737a(h, i, deK, WXRTEditText.this.getSelectionEnd());
            }
            WXRTEditText.this.uPZ = true;
            WXRTEditText.this.uPT = true;
            WXRTEditText.m58591m(WXRTEditText.this);
            WXRTEditText.m58592n(WXRTEditText.this);
            AppMethodBeat.m2505o(26787);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText$3 */
    class C357443 implements C5015a {
        C357443() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26788);
            if (WXRTEditText.this.uQf != null && WXRTEditText.this.uQf.getType() == 1) {
                int i = WXRTEditText.this.uQf.uQW;
                WXRTEditText.m58594p(WXRTEditText.this);
                WXRTEditText.this.mo56474ax(i, false);
            }
            AppMethodBeat.m2505o(26788);
            return true;
        }
    }

    /* renamed from: m */
    static /* synthetic */ void m58591m(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(26824);
        wXRTEditText.setParagraphsAreUp2Date(false);
        AppMethodBeat.m2505o(26824);
    }

    /* renamed from: n */
    static /* synthetic */ void m58592n(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(26825);
        wXRTEditText.deP();
        AppMethodBeat.m2505o(26825);
    }

    /* renamed from: p */
    static /* synthetic */ void m58594p(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(26826);
        wXRTEditText.deR();
        AppMethodBeat.m2505o(26826);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(26789);
        init();
        AppMethodBeat.m2505o(26789);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(26790);
        init();
        AppMethodBeat.m2505o(26790);
    }

    public void setMaxHeight(int i) {
        AppMethodBeat.m2504i(26791);
        super.setMaxHeight(i);
        AppMethodBeat.m2505o(26791);
    }

    private void init() {
        AppMethodBeat.m2504i(26792);
        this.uPR = this;
        removeTextChangedListener(this.uQm);
        addTextChangedListener(this.uQm);
        setMovementMethod(C44009i.dfD());
        this.uQd = -1;
        this.uQe = new Paint(1);
        this.uQe.setColor(1347529272);
        this.uQf = new C46456b();
        this.uQh = new Path();
        this.uQi = -1;
        this.uQj = -1;
        this.uQk = -1;
        if (C4675e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new C357421());
        }
        AppMethodBeat.m2505o(26792);
    }

    public void setRichTextEditing(String str) {
        AppMethodBeat.m2504i(26793);
        deL();
        if (C5046bo.isNullOrNil(str)) {
            setText("");
        } else {
            setSpannableText(C14724a.ahb(str));
        }
        deM();
        AppMethodBeat.m2505o(26793);
    }

    public void setSpannableText(Spanned spanned) {
        AppMethodBeat.m2504i(26794);
        deL();
        deN();
        super.setText(spanned, BufferType.EDITABLE);
        deO();
        deP();
        C29993u.m47470a(this, new C23185t[0]);
        deM();
        AppMethodBeat.m2505o(26794);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(26795);
        deL();
        super.setText(str);
        deM();
        AppMethodBeat.m2505o(26795);
    }

    public void setTextWithoutIgnore(String str) {
        AppMethodBeat.m2504i(26796);
        super.setText(str);
        AppMethodBeat.m2505o(26796);
    }

    public final void deJ() {
        AppMethodBeat.m2504i(26797);
        if (this.uPG != null) {
            this.uPG.mo63742g(true, 50);
            this.uPG.mo63735Kb(1);
        }
        AppMethodBeat.m2505o(26797);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(26798);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(26798);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AppMethodBeat.m2504i(26799);
        this.uQl = false;
        this.uPH = -1;
        this.uPI = -1;
        super.onFocusChanged(z, i, rect);
        if (this.uPG != null) {
            this.uPG.mo63738a(this, z, getRecyclerItemPosition());
        }
        if (z && !this.uQl) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.m2505o(26799);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:8:0x0012, code skipped:
            r5.uQl = true;
     */
    /* JADX WARNING: Missing block: B:9:0x0014, code skipped:
            if (r6 >= 0) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:10:0x0016, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26800);
     */
    /* JADX WARNING: Missing block: B:16:0x0022, code skipped:
            if (r5.uPH != r6) goto L_0x0028;
     */
    /* JADX WARNING: Missing block: B:18:0x0026, code skipped:
            if (r5.uPI == r7) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:19:0x0028, code skipped:
            r5.uPH = r6;
            r5.uPI = r7;
            super.onSelectionChanged(r6, r7);
     */
    /* JADX WARNING: Missing block: B:20:0x002f, code skipped:
            if (r7 <= r6) goto L_0x008f;
     */
    /* JADX WARNING: Missing block: B:21:0x0031, code skipped:
            r0 = true;
     */
    /* JADX WARNING: Missing block: B:22:0x0032, code skipped:
            r5.uPU = r0;
     */
    /* JADX WARNING: Missing block: B:23:0x0036, code skipped:
            if (r5.uPV != false) goto L_0x0048;
     */
    /* JADX WARNING: Missing block: B:25:0x003a, code skipped:
            if (r5.uPW != false) goto L_0x0048;
     */
    /* JADX WARNING: Missing block: B:26:0x003c, code skipped:
            r5.uPX = true;
            com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29993u.m47470a(r5, new com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C23185t[0]);
            r5.uPX = false;
            setParagraphsAreUp2Date(true);
     */
    /* JADX WARNING: Missing block: B:28:0x004a, code skipped:
            if (r5.uPG == null) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:29:0x004c, code skipped:
            r5.uPY = true;
            r5.uPG.mo63736a(r5, r6, r7);
            r5.uPY = false;
     */
    /* JADX WARNING: Missing block: B:31:0x0059, code skipped:
            if (com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.isEnabled() == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:33:0x005d, code skipped:
            if (r5.uQg != false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:35:0x0063, code skipped:
            if (hasFocus() == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:37:0x0067, code skipped:
            if (r5.uQd < 0) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:38:0x0069, code skipped:
            m58585gI(r6, r7);
     */
    /* JADX WARNING: Missing block: B:39:0x0076, code skipped:
            if (com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.dfb().mo9778Kh(r5.uQd) != 1) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:40:0x0078, code skipped:
            r0 = com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.dfb();
     */
    /* JADX WARNING: Missing block: B:41:0x007e, code skipped:
            if (com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C4675e.mHasInit == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:42:0x0080, code skipped:
            r0.mo9790h(true, 0);
            r0.dfj();
            r0.dfh();
     */
    /* JADX WARNING: Missing block: B:43:0x008b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(26800);
     */
    /* JADX WARNING: Missing block: B:44:0x008f, code skipped:
            r0 = false;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSelectionChanged(int i, int i2) {
        AppMethodBeat.m2504i(26800);
        synchronized (this) {
            try {
                if (this.uPJ) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26800);
            }
        }
    }

    public final Spannable deK() {
        AppMethodBeat.m2504i(26801);
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        C35745a c35745a = new C35745a(text);
        AppMethodBeat.m2505o(26801);
        return c35745a;
    }

    public String getSelectedText() {
        AppMethodBeat.m2504i(26802);
        Editable text = getText();
        C23184e selection = getSelection();
        if (selection.aqm < 0 || selection.f4406Ls < 0 || selection.f4406Ls > text.length()) {
            AppMethodBeat.m2505o(26802);
            return null;
        }
        String charSequence = text.subSequence(selection.aqm, selection.f4406Ls).toString();
        AppMethodBeat.m2505o(26802);
        return charSequence;
    }

    public C23184e getSelection() {
        AppMethodBeat.m2504i(26803);
        C23184e c23184e = new C23184e(getSelectionStart(), getSelectionEnd());
        AppMethodBeat.m2505o(26803);
        return c23184e;
    }

    /* renamed from: a */
    public final String mo56472a(C44006i c44006i) {
        AppMethodBeat.m2504i(26804);
        String obj;
        if (c44006i == C44006i.uQq) {
            obj = getText().toString();
            AppMethodBeat.m2505o(26804);
            return obj;
        } else if (c44006i == C44006i.uQr) {
            obj = C44005b.m78993a(getText());
            AppMethodBeat.m2505o(26804);
            return obj;
        } else {
            obj = "";
            AppMethodBeat.m2505o(26804);
            return obj;
        }
    }

    public int getRecyclerItemPosition() {
        AppMethodBeat.m2504i(26805);
        if (this.uPS.mo66453ki() == -1) {
            AppMethodBeat.m2505o(26805);
            return 0;
        }
        int ki = this.uPS.mo66453ki();
        AppMethodBeat.m2505o(26805);
        return ki;
    }

    public int getEditTextType() {
        return this.uPQ;
    }

    public void setEditTextType(int i) {
        this.uPQ = i;
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.m2504i(26806);
        if (i == 16908319) {
            this.uPG.dei();
            AppMethodBeat.m2505o(26806);
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            C29989f.clearData();
        } else if (i == 16908322) {
            getContext();
            int deC = C29989f.deC();
            if (deC == 2) {
                C29989f.clearData();
            } else if (deC == 3) {
                this.uPG.mo63739b(this);
                AppMethodBeat.m2505o(26806);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.uQn = 0;
                try {
                    m58579b(getText());
                } catch (IndexOutOfBoundsException e) {
                    C4990ab.m7413e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", Integer.valueOf(this.uQn));
                    if (this.uQn < 3) {
                        this.uQn++;
                        m58579b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        AppMethodBeat.m2505o(26806);
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.uOb) {
                if (this.uPG != null) {
                    this.uPG.mo63742g(false, 0);
                    this.uPG.mo63735Kb(0);
                }
                this.uOb = false;
            }
            AppMethodBeat.m2505o(26806);
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            C4990ab.m7413e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e2);
            AppMethodBeat.m2505o(26806);
            return false;
        }
    }

    /* renamed from: b */
    private void m58579b(Spannable spannable) {
        AppMethodBeat.m2504i(26807);
        int selectionStart = getSelectionStart();
        C9212g dqQ = C9212g.dqQ();
        getContext();
        setSpannableText(dqQ.mo20622b(spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.m2505o(26807);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.m2505o(26807);
    }

    public final synchronized void deL() {
        this.uPK = true;
    }

    public final synchronized void deM() {
        this.uPK = false;
    }

    public final synchronized void deN() {
        this.uPJ = true;
    }

    public final synchronized void deO() {
        this.uPJ = false;
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        AppMethodBeat.m2504i(26808);
        this.uPT = true;
        if ((obj instanceof C46458g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.m2505o(26808);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        AppMethodBeat.m2504i(26809);
        this.uPT = true;
        if ((obj instanceof C46458g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.m2505o(26809);
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(26810);
        this.uPT = true;
        if ((obj instanceof C46458g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.m2505o(26810);
    }

    /* renamed from: a */
    public final <V, C extends C46458g<V>> void mo56473a(C23185t<V, C> c23185t, V v) {
        AppMethodBeat.m2504i(26811);
        if (this.uPY || this.uPV) {
            AppMethodBeat.m2505o(26811);
            return;
        }
        Spannable deK = this.uPK ? null : deK();
        c23185t.mo38810a(this, v);
        synchronized (this) {
            try {
                if (!(this.uPG == null || this.uPK)) {
                    Spannable deK2 = deK();
                    C40378c c40378c = this.uPG;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    c40378c.mo63737a(this, deK, deK2, getSelectionEnd());
                }
                this.uPZ = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26811);
            }
        }
    }

    private void deP() {
        AppMethodBeat.m2504i(26812);
        Editable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
        AppMethodBeat.m2505o(26812);
    }

    private synchronized void setParagraphsAreUp2Date(boolean z) {
        if (!this.uPX) {
            this.uPW = z;
        }
    }

    public C23184e getParagraphsInSelection() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(26813);
        C40383j rTLayout = getRTLayout();
        C23184e c23184e = new C23184e(this);
        int lineForOffset = rTLayout.getLineForOffset(c23184e.aqm);
        if (c23184e.isEmpty()) {
            i = c23184e.f4406Ls;
        } else {
            i = c23184e.f4406Ls - 1;
        }
        int lineForOffset2 = rTLayout.getLineForOffset(i);
        if (rTLayout.uQt == 0 || lineForOffset < 0) {
            lineForOffset = 0;
        } else if (lineForOffset < rTLayout.uQt) {
            lineForOffset = ((C29992n) rTLayout.uQu.get(lineForOffset)).aqm;
        } else {
            lineForOffset = ((C29992n) rTLayout.uQu.get(rTLayout.uQt - 1)).f4406Ls - 1;
        }
        if (rTLayout.uQt != 0 && lineForOffset2 >= 0) {
            i2 = lineForOffset2 < rTLayout.uQt ? ((C29992n) rTLayout.uQu.get(lineForOffset2)).f4406Ls : ((C29992n) rTLayout.uQu.get(rTLayout.uQt - 1)).f4406Ls - 1;
        }
        C23184e c23184e2 = new C23184e(lineForOffset, i2);
        AppMethodBeat.m2505o(26813);
        return c23184e2;
    }

    public ArrayList<C29992n> getParagraphs() {
        AppMethodBeat.m2504i(26814);
        ArrayList arrayList = getRTLayout().uQu;
        AppMethodBeat.m2505o(26814);
        return arrayList;
    }

    private C40383j getRTLayout() {
        C40383j c40383j;
        AppMethodBeat.m2504i(26815);
        synchronized (this) {
            try {
                if (this.uQa == null || this.uPZ) {
                    this.uQa = new C40383j(getText());
                    this.uPZ = false;
                }
                c40383j = this.uQa;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(26815);
            }
        }
        return c40383j;
    }

    public String getCurrentEditorCursorParagraphStr() {
        AppMethodBeat.m2504i(26816);
        C23184e paragraphsInSelection = getParagraphsInSelection();
        String trim = getText().subSequence(paragraphsInSelection.aqm, paragraphsInSelection.f4406Ls).toString().trim();
        AppMethodBeat.m2505o(26816);
        return trim;
    }

    public C17003m[] getCurrentEditorCursorNumberSpan() {
        AppMethodBeat.m2504i(26817);
        C23184e paragraphsInSelection = getParagraphsInSelection();
        C17003m[] c17003mArr = (C17003m[]) getText().getSpans(paragraphsInSelection.aqm, paragraphsInSelection.f4406Ls, C17003m.class);
        AppMethodBeat.m2505o(26817);
        return c17003mArr;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(26818);
        if (C4675e.isEnabled() && this.uPQ == 0) {
            Editable text = getText();
            if (text != null) {
                Layout layout;
                C4670d dfd = C4675e.dfb().dfd();
                int i = -1;
                Object obj = null;
                Object obj2;
                int i2;
                int obj22;
                switch (C4675e.dfb().mo9778Kh(this.uQd)) {
                    case 1:
                        if (dfd.startOffset != dfd.uRf) {
                            i = dfd.startOffset;
                            obj22 = null;
                            i2 = dfd.uRf;
                        }
                        break;
                    case 2:
                        i = 0;
                        obj = 1;
                        obj22 = 1;
                        i2 = text.length();
                        if (i >= 0 && i2 <= text.length() && i <= i2) {
                            layout = getLayout();
                            if (layout != null) {
                                if (this.uQi == -1) {
                                    this.uQi = getPaddingLeft();
                                }
                                if (this.uQj == -1) {
                                    this.uQj = getPaddingTop();
                                }
                                if (this.uQk == -1) {
                                    this.uQk = getPaddingBottom();
                                }
                                if (this.uQh == null) {
                                    this.uQh = new Path();
                                }
                                this.uQh.reset();
                                try {
                                    int lineForOffset = layout.getLineForOffset(i);
                                    int lineForOffset2 = layout.getLineForOffset(i2);
                                    if (lineForOffset <= lineForOffset2) {
                                        int width = layout.getWidth();
                                        float primaryHorizontal = layout.getPrimaryHorizontal(i) + ((float) this.uQi);
                                        float lineTop = (float) (layout.getLineTop(lineForOffset) + this.uQj);
                                        float lineBottom = (float) (layout.getLineBottom(lineForOffset) + this.uQj);
                                        float primaryHorizontal2 = layout.getPrimaryHorizontal(i2) + ((float) this.uQi);
                                        float lineTop2 = (float) (layout.getLineTop(lineForOffset2) + this.uQj);
                                        float lineBottom2 = (float) (layout.getLineBottom(lineForOffset2) + this.uQj);
                                        if (obj22 != null && obj != null) {
                                            this.uQh.addRect((float) this.uQi, 0.0f, (float) (this.uQi + width), lineBottom2 + ((float) this.uQk), Direction.CW);
                                        } else if (lineForOffset != lineForOffset2) {
                                            if (obj22 != null) {
                                                this.uQh.addRect((float) this.uQi, 0.0f, (float) (this.uQi + width), lineBottom, Direction.CW);
                                                this.uQh.addRect((float) this.uQi, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                            } else if (obj != null) {
                                                this.uQh.addRect(primaryHorizontal, lineTop, (float) (this.uQi + width), lineBottom, Direction.CW);
                                                this.uQh.addRect((float) this.uQi, lineTop2, (float) (this.uQi + width), lineBottom2 + ((float) this.uQk), Direction.CW);
                                            } else {
                                                this.uQh.addRect(primaryHorizontal, lineTop, (float) (this.uQi + width), lineBottom, Direction.CW);
                                                this.uQh.addRect((float) this.uQi, lineTop2, primaryHorizontal2, lineBottom2, Direction.CW);
                                            }
                                            if (lineForOffset2 - lineForOffset > 1) {
                                                this.uQh.addRect((float) this.uQi, lineBottom, (float) (this.uQi + width), lineTop2, Direction.CW);
                                            }
                                        } else if (obj22 != null) {
                                            this.uQh.addRect((float) this.uQi, 0.0f, primaryHorizontal2, lineBottom2, Direction.CW);
                                        } else if (obj != null) {
                                            this.uQh.addRect(primaryHorizontal, lineTop, (float) (this.uQi + width), lineBottom2 + ((float) this.uQk), Direction.CW);
                                        } else {
                                            this.uQh.addRect(primaryHorizontal, lineTop, primaryHorizontal2, lineBottom2, Direction.CW);
                                        }
                                        if (!this.uQh.isEmpty()) {
                                            if (this.uQe == null) {
                                                this.uQe = new Paint(1);
                                                this.uQe.setColor(1347529272);
                                            }
                                            canvas.drawPath(this.uQh, this.uQe);
                                            break;
                                        }
                                    }
                                } catch (Exception e) {
                                    C4990ab.m7413e("noteeditor.WXRTEditText", "tryDrawCover: ", e);
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        i = 0;
                        obj22 = 1;
                        i2 = dfd.uRf;
                        layout = getLayout();
                        if (layout != null) {
                        }
                        break;
                    case 4:
                        i = dfd.startOffset;
                        obj = 1;
                        obj22 = null;
                        i2 = text.length();
                        layout = getLayout();
                        if (layout != null) {
                        }
                        break;
                    default:
                        obj22 = null;
                        i2 = 0;
                }
                layout = getLayout();
                if (layout != null) {
                }
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.m2505o(26818);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(26819);
        if (C4675e.isEnabled()) {
            Editable text = getText();
            if (text == null) {
                deR();
                AppMethodBeat.m2505o(26819);
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                deR();
                AppMethodBeat.m2505o(26819);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    length = (int) motionEvent.getY();
                    Layout layout = getLayout();
                    length = layout.getOffsetForHorizontal(layout.getLineForVertical(length), (float) x);
                    C40387k[] c40387kArr = (C40387k[]) getText().getSpans(length, length + 1, C40387k.class);
                    if (C4675e.dfb().isEditable() && x < C35746b.del() && c40387kArr.length != 0) {
                        C4990ab.m7416i("noteeditor.WXRTEditText", "clicked todo");
                        this.uPG.deg();
                        c40387kArr[0].mo63784a(this, text, motionEvent, c40387kArr[0]);
                        break;
                    }
                    deR();
                    this.uQf.mo74678a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                    deQ();
                    this.gyS.mo16770ae(500, 0);
                    break;
                    break;
                case 1:
                    deQ();
                    if (this.uQf != null) {
                        C46456b c46456b = this.uQf;
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float x2 = motionEvent.getX();
                        float y = motionEvent.getY();
                        c46456b.uQX = rawX;
                        c46456b.uQY = rawY;
                        c46456b.uQZ = x2;
                        c46456b.uRa = y;
                        if (c46456b.klY == 1) {
                            c46456b.uRb = offsetForPosition;
                        } else {
                            c46456b.uRb = 0;
                        }
                        length = this.uQf.getType();
                        deR();
                        if (length == 2) {
                            if (!C4675e.dfb().isEditable()) {
                                C4670d dfd = C4675e.dfb().dfd();
                                if (C4675e.dfb().dfi() && dfd.dfa() == 1 && dfd.coc == this.uQd && dfd.startOffset == offsetForPosition) {
                                    z = true;
                                }
                                m58585gI(offsetForPosition, offsetForPosition);
                                C4675e dfb = C4675e.dfb();
                                if (C4675e.mHasInit) {
                                    dfb.dfj();
                                    dfb.dfh();
                                    dfb.mo9790h(true, 50);
                                    dfb.mo9794oq(true);
                                    dfb.mo9793op(z);
                                    break;
                                }
                            }
                            boolean z2;
                            boolean z3;
                            if (!hasFocus()) {
                                requestFocus();
                                z2 = false;
                                z3 = false;
                            } else if (getSelectionStart() == getSelectionEnd() && offsetForPosition == getSelectionStart()) {
                                z2 = true;
                                z3 = true;
                            } else {
                                z2 = false;
                                z3 = true;
                            }
                            setIgnoreSelectChangeByMultiSelect(true);
                            setSelection(offsetForPosition);
                            setIgnoreSelectChangeByMultiSelect(false);
                            if (this.uPG != null) {
                                this.uPG.mo63742g(true, 50);
                                this.uPG.mo63735Kb(1);
                            }
                            m58585gI(offsetForPosition, offsetForPosition);
                            C4675e.dfb().mo9781ab(z3, z2);
                            break;
                        }
                    }
                    break;
                case 3:
                    deR();
                    deQ();
                    break;
            }
            AppMethodBeat.m2505o(26819);
            return true;
        }
        if (motionEvent.getAction() == 1 && this.uPG != null) {
            this.uPG.mo63742g(true, 300);
            this.uPG.mo63735Kb(1);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(26819);
        return onTouchEvent;
    }

    private void deQ() {
        AppMethodBeat.m2504i(26820);
        if (this.gyS == null) {
            this.gyS = new C7564ap(new C357443(), false);
            AppMethodBeat.m2505o(26820);
            return;
        }
        this.gyS.stopTimer();
        AppMethodBeat.m2505o(26820);
    }

    /* renamed from: ax */
    public final void mo56474ax(int i, boolean z) {
        AppMethodBeat.m2504i(26821);
        Editable text = getText();
        if (text == null) {
            AppMethodBeat.m2505o(26821);
            return;
        }
        Layout layout = getLayout();
        if (layout == null) {
            AppMethodBeat.m2505o(26821);
            return;
        }
        int length = text.length();
        if (i < 0 || i > length) {
            AppMethodBeat.m2505o(26821);
            return;
        }
        int i2;
        int i3;
        if (length == 0) {
            i2 = 0;
            i3 = 0;
        } else {
            if (i < length) {
                if (z || text.charAt(i) != 10) {
                    i2 = layout.getOffsetToRightOf(i);
                    i3 = i;
                }
            } else if (i == length && z) {
                i3 = layout.getOffsetToLeftOf(i);
                i2 = i;
            }
            i2 = i;
            i3 = i;
        }
        if (i3 < 0 || i3 > length || i2 < 0 || i2 > length) {
            AppMethodBeat.m2505o(26821);
            return;
        }
        if (C4675e.dfb().isEditable()) {
            requestFocus();
            setIgnoreSelectChangeByMultiSelect(true);
            setSelection(i3, i2);
            setIgnoreSelectChangeByMultiSelect(false);
            if (this.uPG != null) {
                this.uPG.mo63742g(true, 50);
                this.uPG.mo63735Kb(1);
            }
        }
        m58585gI(i3, i2);
        C4675e.dfb().mo9781ab(true, true);
        AppMethodBeat.m2505o(26821);
    }

    private void deR() {
        AppMethodBeat.m2504i(26822);
        if (this.uQf == null) {
            this.uQf = new C46456b();
            AppMethodBeat.m2505o(26822);
            return;
        }
        this.uQf.reset();
        AppMethodBeat.m2505o(26822);
    }

    /* renamed from: gI */
    private void m58585gI(int i, int i2) {
        AppMethodBeat.m2504i(26823);
        if (this.uPQ == 2) {
            C4675e.dfb().mo9777H(this.uQd, 1, this.uQd, 1);
            AppMethodBeat.m2505o(26823);
        } else if (this.uPQ == 1) {
            C4675e.dfb().mo9777H(this.uQd, 0, this.uQd, 0);
            AppMethodBeat.m2505o(26823);
        } else {
            C4675e dfb = C4675e.dfb();
            int i3 = this.uQd;
            dfb.mo9777H(i3, i, i3, i2);
            AppMethodBeat.m2505o(26823);
        }
    }

    public int getPosInDataList() {
        return this.uQd;
    }

    public void setPosInDataList(int i) {
        this.uQd = i;
    }

    public void setIgnoreSelectChangeByMultiSelect(boolean z) {
        this.uQg = z;
    }
}
