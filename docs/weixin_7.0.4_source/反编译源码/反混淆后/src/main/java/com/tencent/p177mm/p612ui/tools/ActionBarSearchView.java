package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.tools.C5608s.C5607b;
import com.tencent.p177mm.p612ui.tools.SearchViewNotRealTimeHelper.C5576a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.AutoMatchKeywordEditText;
import com.tencent.p177mm.p612ui.widget.AutoMatchKeywordEditText.C5619a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView */
public class ActionBarSearchView extends LinearLayout implements C5582d {
    private boolean qlP = false;
    private TextWatcher vog = new C55471();
    private ImageButton zAa;
    private C5555c zAb = C5555c.CLEAR;
    private boolean zAc = false;
    private C5608s zAd;
    private C5554b zAe;
    private C5553a zAf;
    private OnFocusChangeListener zAg = new C55482();
    private OnFocusChangeListener zAh;
    private OnClickListener zAi = new C55493();
    private OnClickListener zAj = new C55504();
    private View zzY;
    protected ActionBarEditText zzZ;

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$1 */
    class C55471 implements TextWatcher {
        C55471() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(107549);
            ActionBarSearchView.m12539a(ActionBarSearchView.this);
            C5608s b = ActionBarSearchView.this.zAd;
            if (b.zIe) {
                EditText editText = (EditText) b.zIc.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.mText == null || b.mText.length() == 0)) || !(b.mText == null || charSequence == null || !b.mText.equals(charSequence.toString()))) {
                        C4990ab.m7411d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.mText);
                    } else {
                        b.mText = charSequence != null ? charSequence.toString() : "";
                        b.zIb = C5608s.m8404m(b.mText, b.zId);
                        if (C5608s.m8403a(editText, b.zId)) {
                            C4990ab.m7410d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (ActionBarSearchView.this.zAe != null) {
                ActionBarSearchView.this.zAe.mo11263Qa(charSequence == null ? "" : charSequence.toString());
            }
            AppMethodBeat.m2505o(107549);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$2 */
    class C55482 implements OnFocusChangeListener {
        C55482() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(107550);
            C4990ab.m7419v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (ActionBarSearchView.this.zAh != null) {
                ActionBarSearchView.this.zAh.onFocusChange(view, z);
            }
            AppMethodBeat.m2505o(107550);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$3 */
    class C55493 implements OnClickListener {
        C55493() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107551);
            if (C5555c.CLEAR == ActionBarSearchView.this.zAb) {
                C4990ab.m7410d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                ActionBarSearchView.this.mo11323qO(true);
                if (ActionBarSearchView.this.zAe != null) {
                    ActionBarSearchView.this.zAe.apq();
                    AppMethodBeat.m2505o(107551);
                    return;
                }
            }
            C4990ab.m7410d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (ActionBarSearchView.this.zAe != null) {
                ActionBarSearchView.this.zAe.bKu();
            }
            AppMethodBeat.m2505o(107551);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$4 */
    class C55504 implements OnClickListener {
        C55504() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107552);
            if (ActionBarSearchView.this.zAf != null) {
                ActionBarSearchView.this.zAf.bKv();
            }
            AppMethodBeat.m2505o(107552);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$5 */
    class C55515 implements Runnable {
        C55515() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107553);
            ActionBarSearchView.this.zzZ.setText("");
            if (ActionBarSearchView.this.zAe != null) {
                ActionBarSearchView.this.zAe.bKt();
            }
            AppMethodBeat.m2505o(107553);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$6 */
    class C55526 implements OnKeyListener {
        C55526() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(107554);
            if (i == 67) {
                C4990ab.m7410d("MicroMsg.ActionBarSearchView", "on back key click.");
                C5608s b = ActionBarSearchView.this.zAd;
                if (b.zIe) {
                    EditText editText = (EditText) b.zIc.get();
                    if (!(editText == null || b.zIb == null)) {
                        Editable text = editText.getText();
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart == editText.getSelectionEnd()) {
                            C5607b PK = b.mo11379PK(selectionStart);
                            if (PK != null && PK.zIh) {
                                text.delete(PK.start, PK.start + PK.length);
                                editText.setTextKeepState(text);
                                editText.setSelection(PK.start);
                                AppMethodBeat.m2505o(107554);
                                return true;
                            }
                        }
                        AppMethodBeat.m2505o(107554);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(107554);
                return false;
            }
            AppMethodBeat.m2505o(107554);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$a */
    public interface C5553a {
        void bKv();
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$b */
    public interface C5554b {
        /* renamed from: Qa */
        void mo11263Qa(String str);

        void apq();

        void bKt();

        void bKu();
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$c */
    enum C5555c {
        CLEAR,
        VOICE_SEARCH;

        static {
            AppMethodBeat.m2505o(107559);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$d */
    class C5556d extends Drawable {
        private String mText;
        /* renamed from: nI */
        private RectF f1325nI;
        private Paint zAp;
        private int zAq = C4977b.m7371b(C4996ah.getContext(), 2.0f);
        private float zAr;
        private float zAs;

        C5556d(EditText editText, String str) {
            AppMethodBeat.m2504i(107560);
            this.zAp = new Paint(editText.getPaint());
            this.mText = str;
            this.zAp.setColor(C4996ah.getResources().getColor(C25738R.color.f11795hi));
            this.zAr = this.zAp.measureText(this.mText);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.zAs = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) (((this.zAr + ((float) (this.zAq * 2))) + ((float) (this.zAq * 2))) + 2.0f), (int) this.zAs);
            AppMethodBeat.m2505o(107560);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(107561);
            FontMetricsInt fontMetricsInt = this.zAp.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = bounds.right;
            i = bounds.left;
            float f = this.f1325nI.right;
            f = this.f1325nI.left;
            canvas.drawText(this.mText, (float) (bounds.left + 2), (float) ((bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.zAp);
            AppMethodBeat.m2505o(107561);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(107562);
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.f1325nI = new RectF((float) (this.zAq + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.zAq), (float) i4);
            invalidateSelf();
            AppMethodBeat.m2505o(107562);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$7 */
    class C73567 implements C5619a {
        C73567() {
        }

        /* renamed from: b */
        public final void mo11388b(EditText editText, int i, int i2) {
            AppMethodBeat.m2504i(107555);
            C4990ab.m7411d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
            C5608s b = ActionBarSearchView.this.zAd;
            if (b.zIe) {
                EditText editText2 = (EditText) b.zIc.get();
                if (editText2 != null && editText == editText2) {
                    Editable text = editText2.getText();
                    int selectionStart = editText2.getSelectionStart();
                    int selectionEnd = editText2.getSelectionEnd();
                    if (selectionStart < 0 || selectionEnd < selectionStart) {
                        AppMethodBeat.m2505o(107555);
                        return;
                    } else if (selectionStart == selectionEnd) {
                        C5607b PK = b.mo11379PK(selectionStart);
                        if (PK != null && PK.zIh) {
                            editText2.setTextKeepState(text);
                            editText2.setSelection(PK.length + PK.start);
                        }
                        AppMethodBeat.m2505o(107555);
                        return;
                    } else {
                        C5607b PK2 = b.mo11379PK(selectionStart);
                        if (PK2 != null && PK2.zIh) {
                            selectionStart = PK2.start + PK2.length;
                        }
                        if (selectionStart >= selectionEnd) {
                            editText2.setTextKeepState(text);
                            editText2.setSelection(selectionStart);
                            AppMethodBeat.m2505o(107555);
                            return;
                        }
                        C5607b PK3 = b.mo11379PK(selectionEnd);
                        if (PK3 != null && PK3.zIh) {
                            int i3 = PK3.start;
                            editText2.setTextKeepState(text);
                            editText2.setSelection(selectionStart, i3);
                        }
                        AppMethodBeat.m2505o(107555);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(107555);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText */
    public static class ActionBarEditText extends AutoMatchKeywordEditText {
        private ActionBarSearchView zAl;

        public ActionBarEditText(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public ActionBarEditText(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setSearchView(ActionBarSearchView actionBarSearchView) {
            this.zAl = actionBarSearchView;
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(107556);
            C4990ab.m7418v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    C4990ab.m7418v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    AppMethodBeat.m2505o(107556);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    C4990ab.m7418v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        C4990ab.m7418v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.zAl.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        AppMethodBeat.m2505o(107556);
                        return true;
                    }
                }
            }
            boolean onKeyPreIme = super.onKeyPreIme(i, keyEvent);
            AppMethodBeat.m2505o(107556);
            return onKeyPreIme;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m12539a(ActionBarSearchView actionBarSearchView) {
        AppMethodBeat.m2504i(107585);
        actionBarSearchView.dJq();
        AppMethodBeat.m2505o(107585);
    }

    public void setFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.zAh = onFocusChangeListener;
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107563);
        init();
        AppMethodBeat.m2505o(107563);
    }

    public ActionBarSearchView(Context context) {
        super(context);
        AppMethodBeat.m2504i(107564);
        init();
        AppMethodBeat.m2505o(107564);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return 2130968616;
    }

    private void init() {
        AppMethodBeat.m2504i(107565);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
        this.zzY = findViewById(2131820977);
        this.zzY.setOnClickListener(this.zAj);
        this.zzZ = (ActionBarEditText) findViewById(2131820980);
        this.zAd = new C5608s(this.zzZ);
        this.zzZ.setSearchView(this);
        this.zzZ.post(new C55515());
        this.zAa = (ImageButton) findViewById(2131820981);
        this.zzZ.addTextChangedListener(this.vog);
        this.zzZ.setOnKeyListener(new C55526());
        this.zzZ.setOnSelectionChangeListener(new C73567());
        this.zzZ.setOnFocusChangeListener(this.zAg);
        C7357c.m12555d(this.zzZ).mo15877PM(100).mo15879a(null);
        this.zAa.setOnClickListener(this.zAi);
        AppMethodBeat.m2505o(107565);
    }

    public String getSearchContent() {
        AppMethodBeat.m2504i(107566);
        String obj;
        if (this.zzZ.getEditableText() != null) {
            obj = this.zzZ.getEditableText().toString();
            AppMethodBeat.m2505o(107566);
            return obj;
        }
        obj = "";
        AppMethodBeat.m2505o(107566);
        return obj;
    }

    public void setCallBack(C5554b c5554b) {
        this.zAe = c5554b;
    }

    public void setBackClickCallback(C5553a c5553a) {
        this.zAf = c5553a;
    }

    public void setSearchContent(String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(107567);
        if (str2 == null) {
            str2 = "";
        }
        this.zzZ.setText(str2);
        this.zzZ.setSelection(str2.length());
        AppMethodBeat.m2505o(107567);
    }

    public void setHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(107568);
        this.zzZ.setHint(charSequence);
        AppMethodBeat.m2505o(107568);
    }

    /* renamed from: qN */
    public final void mo11322qN(boolean z) {
        AppMethodBeat.m2504i(107569);
        this.zAc = z;
        dJq();
        AppMethodBeat.m2505o(107569);
    }

    public void setEditTextEnabled(boolean z) {
        AppMethodBeat.m2504i(107570);
        this.zzZ.setEnabled(z);
        AppMethodBeat.m2505o(107570);
    }

    public void setStatusBtnEnabled(boolean z) {
        AppMethodBeat.m2504i(107571);
        this.zAa.setEnabled(z);
        AppMethodBeat.m2505o(107571);
    }

    /* renamed from: hu */
    private void m12545hu(int i, int i2) {
        AppMethodBeat.m2504i(107572);
        this.zAa.setImageResource(i);
        this.zAa.setBackgroundResource(0);
        if (i == C25738R.drawable.a50) {
            this.zAa.setContentDescription(getContext().getString(C25738R.string.f1z));
        } else {
            this.zAa.setContentDescription(getContext().getString(C25738R.string.aqw));
        }
        LayoutParams layoutParams = this.zAa.getLayoutParams();
        layoutParams.width = i2;
        this.zAa.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(107572);
    }

    private void dJq() {
        AppMethodBeat.m2504i(107573);
        if (this.zzZ.getEditableText() != null && !C5046bo.isNullOrNil(this.zzZ.getEditableText().toString())) {
            m12545hu(C25738R.drawable.f7034z7, getResources().getDimensionPixelSize(C25738R.dimen.f9977m2));
            this.zAb = C5555c.CLEAR;
            AppMethodBeat.m2505o(107573);
        } else if (this.zAc) {
            m12545hu(C25738R.drawable.a50, getResources().getDimensionPixelSize(C25738R.dimen.f9977m2));
            this.zAb = C5555c.VOICE_SEARCH;
            AppMethodBeat.m2505o(107573);
        } else {
            m12545hu(0, 0);
            this.zAb = C5555c.CLEAR;
            AppMethodBeat.m2505o(107573);
        }
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.m2504i(107574);
        this.zzZ.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.m2505o(107574);
    }

    /* renamed from: qO */
    public final void mo11323qO(boolean z) {
        AppMethodBeat.m2504i(107575);
        if (z) {
            this.zzZ.setText("");
            AppMethodBeat.m2505o(107575);
            return;
        }
        this.zzZ.removeTextChangedListener(this.vog);
        this.zzZ.setText("");
        this.zzZ.addTextChangedListener(this.vog);
        AppMethodBeat.m2505o(107575);
    }

    public final void dJr() {
        AppMethodBeat.m2504i(107576);
        this.zzZ.clearFocus();
        AppMethodBeat.m2505o(107576);
    }

    public void setNotRealCallBack(C5576a c5576a) {
    }

    public final boolean dJs() {
        AppMethodBeat.m2504i(107577);
        if (this.zzZ != null) {
            boolean hasFocus = this.zzZ.hasFocus();
            AppMethodBeat.m2505o(107577);
            return hasFocus;
        }
        AppMethodBeat.m2505o(107577);
        return false;
    }

    public final boolean dJt() {
        AppMethodBeat.m2504i(107578);
        if (this.zzZ != null) {
            boolean requestFocus = this.zzZ.requestFocus();
            AppMethodBeat.m2505o(107578);
            return requestFocus;
        }
        AppMethodBeat.m2505o(107578);
        return false;
    }

    public void setEditTextClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(107579);
        if (this.zzZ != null) {
            this.zzZ.setFocusable(false);
            this.zzZ.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(107579);
    }

    public void setKeywords(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(107580);
        if (this.zAd != null) {
            C5608s c5608s = this.zAd;
            c5608s.zId = arrayList;
            if (c5608s.zIe) {
                EditText editText = (EditText) c5608s.zIc.get();
                if (editText != null) {
                    C5608s.m8403a(editText, c5608s.zId);
                }
            }
        }
        AppMethodBeat.m2505o(107580);
    }

    public void setAutoMatchKeywords(boolean z) {
        if (this.zAd != null) {
            this.zAd.zIe = z;
        }
    }

    public void setSearchTipIcon(int i) {
        AppMethodBeat.m2504i(107581);
        if (this.zzZ != null) {
            this.zzZ.setCompoundDrawables(C4996ah.getResources().getDrawable(i), null, null, null);
        }
        AppMethodBeat.m2505o(107581);
    }

    public void setSelectedTag(String str) {
        AppMethodBeat.m2504i(107582);
        if (this.zzZ != null) {
            this.zzZ.setCompoundDrawables(new C5556d(this.zzZ, str), null, null, null);
            this.zzZ.setHint("");
        }
        AppMethodBeat.m2505o(107582);
    }

    public int getSelectionStart() {
        AppMethodBeat.m2504i(107583);
        if (this.zzZ != null) {
            int selectionStart = this.zzZ.getSelectionStart();
            AppMethodBeat.m2505o(107583);
            return selectionStart;
        }
        AppMethodBeat.m2505o(107583);
        return -1;
    }

    public int getSelectionEnd() {
        AppMethodBeat.m2504i(107584);
        if (this.zzZ != null) {
            int selectionEnd = this.zzZ.getSelectionEnd();
            AppMethodBeat.m2505o(107584);
            return selectionEnd;
        }
        AppMethodBeat.m2505o(107584);
        return -1;
    }
}
