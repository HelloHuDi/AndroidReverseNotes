package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.cb.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.i;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    public int aaF = 0;
    private ap gyS = null;
    public boolean uOb = false;
    public int uOd = 0;
    c uPG;
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
    public v uPS;
    private boolean uPT;
    private boolean uPU;
    private boolean uPV;
    private boolean uPW;
    private boolean uPX;
    private boolean uPY = false;
    private boolean uPZ;
    private j uQa;
    public boolean uQb = false;
    public boolean uQc = false;
    private int uQd = -1;
    private Paint uQe = null;
    private b uQf = null;
    private boolean uQg = false;
    private Path uQh = null;
    private int uQi = -1;
    private int uQj = -1;
    private int uQk = -1;
    private boolean uQl = false;
    TextWatcher uQm = new TextWatcher() {
        public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(26785);
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
            AppMethodBeat.o(26785);
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(26786);
            WXRTEditText.this.uPZ = true;
            AppMethodBeat.o(26786);
        }

        public final synchronized void afterTextChanged(Editable editable) {
            AppMethodBeat.i(26787);
            ab.d("noteeditor.WXRTEditText", "afterTextChanged");
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
            if (!WXRTEditText.this.uPK && WXRTEditText.this.getSelection().aqm == WXRTEditText.this.getSelection().Ls && (((!str.endsWith(IOUtils.LINE_SEPARATOR_UNIX) && (str + IOUtils.LINE_SEPARATOR_UNIX).equals(obj)) || (str.endsWith(IOUtils.LINE_SEPARATOR_UNIX) && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) WXRTEditText.this.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
                int selectionStart = WXRTEditText.this.getSelectionStart();
                WXRTEditText.this.uPK = true;
                WXRTEditText.this.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
                WXRTEditText.this.uPK = false;
                WXRTEditText.this.setSelection(selectionStart);
            }
            if (!(WXRTEditText.this.uPG == null || WXRTEditText.this.uPK || str.equals(obj))) {
                Spannable deK = WXRTEditText.this.deK();
                WXRTEditText.this.uPO = obj;
                c g = WXRTEditText.this.uPG;
                WXRTEditText h = WXRTEditText.this.uPR;
                Spannable i = WXRTEditText.this.uPP;
                WXRTEditText.this.uPL;
                WXRTEditText.this.uPM;
                WXRTEditText.this.getSelectionStart();
                g.a(h, i, deK, WXRTEditText.this.getSelectionEnd());
            }
            WXRTEditText.this.uPZ = true;
            WXRTEditText.this.uPT = true;
            WXRTEditText.m(WXRTEditText.this);
            WXRTEditText.n(WXRTEditText.this);
            AppMethodBeat.o(26787);
        }
    };
    int uQn = 0;

    static /* synthetic */ void m(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(26824);
        wXRTEditText.setParagraphsAreUp2Date(false);
        AppMethodBeat.o(26824);
    }

    static /* synthetic */ void n(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(26825);
        wXRTEditText.deP();
        AppMethodBeat.o(26825);
    }

    static /* synthetic */ void p(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(26826);
        wXRTEditText.deR();
        AppMethodBeat.o(26826);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26789);
        init();
        AppMethodBeat.o(26789);
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(26790);
        init();
        AppMethodBeat.o(26790);
    }

    public void setMaxHeight(int i) {
        AppMethodBeat.i(26791);
        super.setMaxHeight(i);
        AppMethodBeat.o(26791);
    }

    private void init() {
        AppMethodBeat.i(26792);
        this.uPR = this;
        removeTextChangedListener(this.uQm);
        addTextChangedListener(this.uQm);
        setMovementMethod(i.dfD());
        this.uQd = -1;
        this.uQe = new Paint(1);
        this.uQe.setColor(1347529272);
        this.uQf = new b();
        this.uQh = new Path();
        this.uQi = -1;
        this.uQj = -1;
        this.uQk = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new Callback() {
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
            });
        }
        AppMethodBeat.o(26792);
    }

    public void setRichTextEditing(String str) {
        AppMethodBeat.i(26793);
        deL();
        if (bo.isNullOrNil(str)) {
            setText("");
        } else {
            setSpannableText(a.ahb(str));
        }
        deM();
        AppMethodBeat.o(26793);
    }

    public void setSpannableText(Spanned spanned) {
        AppMethodBeat.i(26794);
        deL();
        deN();
        super.setText(spanned, BufferType.EDITABLE);
        deO();
        deP();
        u.a(this, new t[0]);
        deM();
        AppMethodBeat.o(26794);
    }

    public void setText(String str) {
        AppMethodBeat.i(26795);
        deL();
        super.setText(str);
        deM();
        AppMethodBeat.o(26795);
    }

    public void setTextWithoutIgnore(String str) {
        AppMethodBeat.i(26796);
        super.setText(str);
        AppMethodBeat.o(26796);
    }

    public final void deJ() {
        AppMethodBeat.i(26797);
        if (this.uPG != null) {
            this.uPG.g(true, 50);
            this.uPG.Kb(1);
        }
        AppMethodBeat.o(26797);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(26798);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(26798);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AppMethodBeat.i(26799);
        this.uQl = false;
        this.uPH = -1;
        this.uPI = -1;
        super.onFocusChanged(z, i, rect);
        if (this.uPG != null) {
            this.uPG.a(this, z, getRecyclerItemPosition());
        }
        if (z && !this.uQl) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
        AppMethodBeat.o(26799);
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:8:0x0012, code skipped:
            r5.uQl = true;
     */
    /* JADX WARNING: Missing block: B:9:0x0014, code skipped:
            if (r6 >= 0) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:10:0x0016, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(26800);
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
            com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(r5, new com.tencent.mm.plugin.wenote.model.nativenote.spans.t[0]);
            r5.uPX = false;
            setParagraphsAreUp2Date(true);
     */
    /* JADX WARNING: Missing block: B:28:0x004a, code skipped:
            if (r5.uPG == null) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:29:0x004c, code skipped:
            r5.uPY = true;
            r5.uPG.a(r5, r6, r7);
            r5.uPY = false;
     */
    /* JADX WARNING: Missing block: B:31:0x0059, code skipped:
            if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled() == false) goto L_0x008b;
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
            gI(r6, r7);
     */
    /* JADX WARNING: Missing block: B:39:0x0076, code skipped:
            if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.dfb().Kh(r5.uQd) != 1) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:40:0x0078, code skipped:
            r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.dfb();
     */
    /* JADX WARNING: Missing block: B:41:0x007e, code skipped:
            if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit == false) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:42:0x0080, code skipped:
            r0.h(true, 0);
            r0.dfj();
            r0.dfh();
     */
    /* JADX WARNING: Missing block: B:43:0x008b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(26800);
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
        AppMethodBeat.i(26800);
        synchronized (this) {
            try {
                if (this.uPJ) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26800);
            }
        }
    }

    public final Spannable deK() {
        AppMethodBeat.i(26801);
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        a aVar = new a(text);
        AppMethodBeat.o(26801);
        return aVar;
    }

    public String getSelectedText() {
        AppMethodBeat.i(26802);
        Editable text = getText();
        e selection = getSelection();
        if (selection.aqm < 0 || selection.Ls < 0 || selection.Ls > text.length()) {
            AppMethodBeat.o(26802);
            return null;
        }
        String charSequence = text.subSequence(selection.aqm, selection.Ls).toString();
        AppMethodBeat.o(26802);
        return charSequence;
    }

    public e getSelection() {
        AppMethodBeat.i(26803);
        e eVar = new e(getSelectionStart(), getSelectionEnd());
        AppMethodBeat.o(26803);
        return eVar;
    }

    public final String a(i iVar) {
        AppMethodBeat.i(26804);
        String obj;
        if (iVar == i.uQq) {
            obj = getText().toString();
            AppMethodBeat.o(26804);
            return obj;
        } else if (iVar == i.uQr) {
            obj = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
            AppMethodBeat.o(26804);
            return obj;
        } else {
            obj = "";
            AppMethodBeat.o(26804);
            return obj;
        }
    }

    public int getRecyclerItemPosition() {
        AppMethodBeat.i(26805);
        if (this.uPS.ki() == -1) {
            AppMethodBeat.o(26805);
            return 0;
        }
        int ki = this.uPS.ki();
        AppMethodBeat.o(26805);
        return ki;
    }

    public int getEditTextType() {
        return this.uPQ;
    }

    public void setEditTextType(int i) {
        this.uPQ = i;
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.i(26806);
        if (i == 16908319) {
            this.uPG.dei();
            AppMethodBeat.o(26806);
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            f.clearData();
        } else if (i == 16908322) {
            getContext();
            int deC = f.deC();
            if (deC == 2) {
                f.clearData();
            } else if (deC == 3) {
                this.uPG.b(this);
                AppMethodBeat.o(26806);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.uQn = 0;
                try {
                    b(getText());
                } catch (IndexOutOfBoundsException e) {
                    ab.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", Integer.valueOf(this.uQn));
                    if (this.uQn < 3) {
                        this.uQn++;
                        b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        AppMethodBeat.o(26806);
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.uOb) {
                if (this.uPG != null) {
                    this.uPG.g(false, 0);
                    this.uPG.Kb(0);
                }
                this.uOb = false;
            }
            AppMethodBeat.o(26806);
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            ab.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", e2);
            AppMethodBeat.o(26806);
            return false;
        }
    }

    private void b(Spannable spannable) {
        AppMethodBeat.i(26807);
        int selectionStart = getSelectionStart();
        g dqQ = g.dqQ();
        getContext();
        setSpannableText(dqQ.b(spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.o(26807);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(26807);
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
        AppMethodBeat.i(26808);
        this.uPT = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(26808);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        AppMethodBeat.i(26809);
        this.uPT = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(26809);
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(26810);
        this.uPT = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
        AppMethodBeat.o(26810);
    }

    public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> tVar, V v) {
        AppMethodBeat.i(26811);
        if (this.uPY || this.uPV) {
            AppMethodBeat.o(26811);
            return;
        }
        Spannable deK = this.uPK ? null : deK();
        tVar.a(this, v);
        synchronized (this) {
            try {
                if (!(this.uPG == null || this.uPK)) {
                    Spannable deK2 = deK();
                    c cVar = this.uPG;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, deK, deK2, getSelectionEnd());
                }
                this.uPZ = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26811);
            }
        }
    }

    private void deP() {
        AppMethodBeat.i(26812);
        Editable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
        AppMethodBeat.o(26812);
    }

    private synchronized void setParagraphsAreUp2Date(boolean z) {
        if (!this.uPX) {
            this.uPW = z;
        }
    }

    public e getParagraphsInSelection() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(26813);
        j rTLayout = getRTLayout();
        e eVar = new e(this);
        int lineForOffset = rTLayout.getLineForOffset(eVar.aqm);
        if (eVar.isEmpty()) {
            i = eVar.Ls;
        } else {
            i = eVar.Ls - 1;
        }
        int lineForOffset2 = rTLayout.getLineForOffset(i);
        if (rTLayout.uQt == 0 || lineForOffset < 0) {
            lineForOffset = 0;
        } else if (lineForOffset < rTLayout.uQt) {
            lineForOffset = ((n) rTLayout.uQu.get(lineForOffset)).aqm;
        } else {
            lineForOffset = ((n) rTLayout.uQu.get(rTLayout.uQt - 1)).Ls - 1;
        }
        if (rTLayout.uQt != 0 && lineForOffset2 >= 0) {
            i2 = lineForOffset2 < rTLayout.uQt ? ((n) rTLayout.uQu.get(lineForOffset2)).Ls : ((n) rTLayout.uQu.get(rTLayout.uQt - 1)).Ls - 1;
        }
        e eVar2 = new e(lineForOffset, i2);
        AppMethodBeat.o(26813);
        return eVar2;
    }

    public ArrayList<n> getParagraphs() {
        AppMethodBeat.i(26814);
        ArrayList arrayList = getRTLayout().uQu;
        AppMethodBeat.o(26814);
        return arrayList;
    }

    private j getRTLayout() {
        j jVar;
        AppMethodBeat.i(26815);
        synchronized (this) {
            try {
                if (this.uQa == null || this.uPZ) {
                    this.uQa = new j(getText());
                    this.uPZ = false;
                }
                jVar = this.uQa;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(26815);
            }
        }
        return jVar;
    }

    public String getCurrentEditorCursorParagraphStr() {
        AppMethodBeat.i(26816);
        e paragraphsInSelection = getParagraphsInSelection();
        String trim = getText().subSequence(paragraphsInSelection.aqm, paragraphsInSelection.Ls).toString().trim();
        AppMethodBeat.o(26816);
        return trim;
    }

    public m[] getCurrentEditorCursorNumberSpan() {
        AppMethodBeat.i(26817);
        e paragraphsInSelection = getParagraphsInSelection();
        m[] mVarArr = (m[]) getText().getSpans(paragraphsInSelection.aqm, paragraphsInSelection.Ls, m.class);
        AppMethodBeat.o(26817);
        return mVarArr;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(26818);
        if (e.isEnabled() && this.uPQ == 0) {
            Editable text = getText();
            if (text != null) {
                Layout layout;
                d dfd = e.dfb().dfd();
                int i = -1;
                Object obj = null;
                Object obj2;
                int i2;
                int obj22;
                switch (e.dfb().Kh(this.uQd)) {
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
                                    ab.e("noteeditor.WXRTEditText", "tryDrawCover: ", e);
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
        AppMethodBeat.o(26818);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(26819);
        if (e.isEnabled()) {
            Editable text = getText();
            if (text == null) {
                deR();
                AppMethodBeat.o(26819);
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                deR();
                AppMethodBeat.o(26819);
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    length = (int) motionEvent.getY();
                    Layout layout = getLayout();
                    length = layout.getOffsetForHorizontal(layout.getLineForVertical(length), (float) x);
                    k[] kVarArr = (k[]) getText().getSpans(length, length + 1, k.class);
                    if (e.dfb().isEditable() && x < b.del() && kVarArr.length != 0) {
                        ab.i("noteeditor.WXRTEditText", "clicked todo");
                        this.uPG.deg();
                        kVarArr[0].a(this, text, motionEvent, kVarArr[0]);
                        break;
                    }
                    deR();
                    this.uQf.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                    deQ();
                    this.gyS.ae(500, 0);
                    break;
                    break;
                case 1:
                    deQ();
                    if (this.uQf != null) {
                        b bVar = this.uQf;
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        float x2 = motionEvent.getX();
                        float y = motionEvent.getY();
                        bVar.uQX = rawX;
                        bVar.uQY = rawY;
                        bVar.uQZ = x2;
                        bVar.uRa = y;
                        if (bVar.klY == 1) {
                            bVar.uRb = offsetForPosition;
                        } else {
                            bVar.uRb = 0;
                        }
                        length = this.uQf.getType();
                        deR();
                        if (length == 2) {
                            if (!e.dfb().isEditable()) {
                                d dfd = e.dfb().dfd();
                                if (e.dfb().dfi() && dfd.dfa() == 1 && dfd.coc == this.uQd && dfd.startOffset == offsetForPosition) {
                                    z = true;
                                }
                                gI(offsetForPosition, offsetForPosition);
                                e dfb = e.dfb();
                                if (e.mHasInit) {
                                    dfb.dfj();
                                    dfb.dfh();
                                    dfb.h(true, 50);
                                    dfb.oq(true);
                                    dfb.op(z);
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
                                this.uPG.g(true, 50);
                                this.uPG.Kb(1);
                            }
                            gI(offsetForPosition, offsetForPosition);
                            e.dfb().ab(z3, z2);
                            break;
                        }
                    }
                    break;
                case 3:
                    deR();
                    deQ();
                    break;
            }
            AppMethodBeat.o(26819);
            return true;
        }
        if (motionEvent.getAction() == 1 && this.uPG != null) {
            this.uPG.g(true, 300);
            this.uPG.Kb(1);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(26819);
        return onTouchEvent;
    }

    private void deQ() {
        AppMethodBeat.i(26820);
        if (this.gyS == null) {
            this.gyS = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(26788);
                    if (WXRTEditText.this.uQf != null && WXRTEditText.this.uQf.getType() == 1) {
                        int i = WXRTEditText.this.uQf.uQW;
                        WXRTEditText.p(WXRTEditText.this);
                        WXRTEditText.this.ax(i, false);
                    }
                    AppMethodBeat.o(26788);
                    return true;
                }
            }, false);
            AppMethodBeat.o(26820);
            return;
        }
        this.gyS.stopTimer();
        AppMethodBeat.o(26820);
    }

    public final void ax(int i, boolean z) {
        AppMethodBeat.i(26821);
        Editable text = getText();
        if (text == null) {
            AppMethodBeat.o(26821);
            return;
        }
        Layout layout = getLayout();
        if (layout == null) {
            AppMethodBeat.o(26821);
            return;
        }
        int length = text.length();
        if (i < 0 || i > length) {
            AppMethodBeat.o(26821);
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
            AppMethodBeat.o(26821);
            return;
        }
        if (e.dfb().isEditable()) {
            requestFocus();
            setIgnoreSelectChangeByMultiSelect(true);
            setSelection(i3, i2);
            setIgnoreSelectChangeByMultiSelect(false);
            if (this.uPG != null) {
                this.uPG.g(true, 50);
                this.uPG.Kb(1);
            }
        }
        gI(i3, i2);
        e.dfb().ab(true, true);
        AppMethodBeat.o(26821);
    }

    private void deR() {
        AppMethodBeat.i(26822);
        if (this.uQf == null) {
            this.uQf = new b();
            AppMethodBeat.o(26822);
            return;
        }
        this.uQf.reset();
        AppMethodBeat.o(26822);
    }

    private void gI(int i, int i2) {
        AppMethodBeat.i(26823);
        if (this.uPQ == 2) {
            e.dfb().H(this.uQd, 1, this.uQd, 1);
            AppMethodBeat.o(26823);
        } else if (this.uPQ == 1) {
            e.dfb().H(this.uQd, 0, this.uQd, 0);
            AppMethodBeat.o(26823);
        } else {
            e dfb = e.dfb();
            int i3 = this.uQd;
            dfb.H(i3, i, i3, i2);
            AppMethodBeat.o(26823);
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
