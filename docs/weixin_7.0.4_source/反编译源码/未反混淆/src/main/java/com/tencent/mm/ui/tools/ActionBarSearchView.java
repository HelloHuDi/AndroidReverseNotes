package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.AutoMatchKeywordEditText;
import java.util.ArrayList;

public class ActionBarSearchView extends LinearLayout implements d {
    private boolean qlP = false;
    private TextWatcher vog = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(107549);
            ActionBarSearchView.a(ActionBarSearchView.this);
            s b = ActionBarSearchView.this.zAd;
            if (b.zIe) {
                EditText editText = (EditText) b.zIc.get();
                if (editText != null) {
                    if (((charSequence == null || charSequence.toString() == null || charSequence.toString().length() == 0) && (b.mText == null || b.mText.length() == 0)) || !(b.mText == null || charSequence == null || !b.mText.equals(charSequence.toString()))) {
                        ab.d("MicroMsg.WordsChecker", "text not change, new : %s, old : %s", charSequence, b.mText);
                    } else {
                        b.mText = charSequence != null ? charSequence.toString() : "";
                        b.zIb = s.m(b.mText, b.zId);
                        if (s.a(editText, b.zId)) {
                            ab.d("MicroMsg.WordsChecker", "decorate text succ.");
                        }
                    }
                }
            }
            if (ActionBarSearchView.this.zAe != null) {
                ActionBarSearchView.this.zAe.Qa(charSequence == null ? "" : charSequence.toString());
            }
            AppMethodBeat.o(107549);
        }

        public final void afterTextChanged(Editable editable) {
        }
    };
    private ImageButton zAa;
    private c zAb = c.CLEAR;
    private boolean zAc = false;
    private s zAd;
    private b zAe;
    private a zAf;
    private OnFocusChangeListener zAg = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(107550);
            ab.v("MicroMsg.ActionBarSearchView", "on edittext focus changed, hasFocus %B", Boolean.valueOf(z));
            if (ActionBarSearchView.this.zAh != null) {
                ActionBarSearchView.this.zAh.onFocusChange(view, z);
            }
            AppMethodBeat.o(107550);
        }
    };
    private OnFocusChangeListener zAh;
    private OnClickListener zAi = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(107551);
            if (c.CLEAR == ActionBarSearchView.this.zAb) {
                ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is clear");
                ActionBarSearchView.this.qO(true);
                if (ActionBarSearchView.this.zAe != null) {
                    ActionBarSearchView.this.zAe.apq();
                    AppMethodBeat.o(107551);
                    return;
                }
            }
            ab.d("MicroMsg.ActionBarSearchView", "on status btn click, cur status is voice search");
            if (ActionBarSearchView.this.zAe != null) {
                ActionBarSearchView.this.zAe.bKu();
            }
            AppMethodBeat.o(107551);
        }
    };
    private OnClickListener zAj = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(107552);
            if (ActionBarSearchView.this.zAf != null) {
                ActionBarSearchView.this.zAf.bKv();
            }
            AppMethodBeat.o(107552);
        }
    };
    private View zzY;
    protected ActionBarEditText zzZ;

    public interface a {
        void bKv();
    }

    public interface b {
        void Qa(String str);

        void apq();

        void bKt();

        void bKu();
    }

    enum c {
        CLEAR,
        VOICE_SEARCH;

        static {
            AppMethodBeat.o(107559);
        }
    }

    class d extends Drawable {
        private String mText;
        private RectF nI;
        private Paint zAp;
        private int zAq = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ah.getContext(), 2.0f);
        private float zAr;
        private float zAs;

        d(EditText editText, String str) {
            AppMethodBeat.i(107560);
            this.zAp = new Paint(editText.getPaint());
            this.mText = str;
            this.zAp.setColor(ah.getResources().getColor(R.color.hi));
            this.zAr = this.zAp.measureText(this.mText);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.zAs = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) (((this.zAr + ((float) (this.zAq * 2))) + ((float) (this.zAq * 2))) + 2.0f), (int) this.zAs);
            AppMethodBeat.o(107560);
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(107561);
            FontMetricsInt fontMetricsInt = this.zAp.getFontMetricsInt();
            Rect bounds = getBounds();
            int i = bounds.right;
            i = bounds.left;
            float f = this.nI.right;
            f = this.nI.left;
            canvas.drawText(this.mText, (float) (bounds.left + 2), (float) ((bounds.top + ((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.zAp);
            AppMethodBeat.o(107561);
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(107562);
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.zAp.getFontMetrics();
            this.nI = new RectF((float) (this.zAq + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - this.zAq), (float) i4);
            invalidateSelf();
            AppMethodBeat.o(107562);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -3;
        }
    }

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
            AppMethodBeat.i(107556);
            ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme");
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action down");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    AppMethodBeat.o(107556);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up");
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        ab.v("MicroMsg.ActionBarSearchView", "on onKeyPreIme action up is tracking");
                        this.zAl.clearFocus();
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                        }
                        AppMethodBeat.o(107556);
                        return true;
                    }
                }
            }
            boolean onKeyPreIme = super.onKeyPreIme(i, keyEvent);
            AppMethodBeat.o(107556);
            return onKeyPreIme;
        }
    }

    static /* synthetic */ void a(ActionBarSearchView actionBarSearchView) {
        AppMethodBeat.i(107585);
        actionBarSearchView.dJq();
        AppMethodBeat.o(107585);
    }

    public void setFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.zAh = onFocusChangeListener;
    }

    public ActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107563);
        init();
        AppMethodBeat.o(107563);
    }

    public ActionBarSearchView(Context context) {
        super(context);
        AppMethodBeat.i(107564);
        init();
        AppMethodBeat.o(107564);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return R.layout.ad;
    }

    private void init() {
        AppMethodBeat.i(107565);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(getLayoutId(), this, true);
        this.zzY = findViewById(R.id.l0);
        this.zzY.setOnClickListener(this.zAj);
        this.zzZ = (ActionBarEditText) findViewById(R.id.l3);
        this.zAd = new s(this.zzZ);
        this.zzZ.setSearchView(this);
        this.zzZ.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(107553);
                ActionBarSearchView.this.zzZ.setText("");
                if (ActionBarSearchView.this.zAe != null) {
                    ActionBarSearchView.this.zAe.bKt();
                }
                AppMethodBeat.o(107553);
            }
        });
        this.zAa = (ImageButton) findViewById(R.id.l4);
        this.zzZ.addTextChangedListener(this.vog);
        this.zzZ.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(107554);
                if (i == 67) {
                    ab.d("MicroMsg.ActionBarSearchView", "on back key click.");
                    s b = ActionBarSearchView.this.zAd;
                    if (b.zIe) {
                        EditText editText = (EditText) b.zIc.get();
                        if (!(editText == null || b.zIb == null)) {
                            Editable text = editText.getText();
                            int selectionStart = editText.getSelectionStart();
                            if (selectionStart == editText.getSelectionEnd()) {
                                b PK = b.PK(selectionStart);
                                if (PK != null && PK.zIh) {
                                    text.delete(PK.start, PK.start + PK.length);
                                    editText.setTextKeepState(text);
                                    editText.setSelection(PK.start);
                                    AppMethodBeat.o(107554);
                                    return true;
                                }
                            }
                            AppMethodBeat.o(107554);
                            return false;
                        }
                    }
                    AppMethodBeat.o(107554);
                    return false;
                }
                AppMethodBeat.o(107554);
                return false;
            }
        });
        this.zzZ.setOnSelectionChangeListener(new com.tencent.mm.ui.widget.AutoMatchKeywordEditText.a() {
            public final void b(EditText editText, int i, int i2) {
                AppMethodBeat.i(107555);
                ab.d("MicroMsg.ActionBarSearchView", "start : %d, stop : %d", Integer.valueOf(i), Integer.valueOf(i2));
                s b = ActionBarSearchView.this.zAd;
                if (b.zIe) {
                    EditText editText2 = (EditText) b.zIc.get();
                    if (editText2 != null && editText == editText2) {
                        Editable text = editText2.getText();
                        int selectionStart = editText2.getSelectionStart();
                        int selectionEnd = editText2.getSelectionEnd();
                        if (selectionStart < 0 || selectionEnd < selectionStart) {
                            AppMethodBeat.o(107555);
                            return;
                        } else if (selectionStart == selectionEnd) {
                            b PK = b.PK(selectionStart);
                            if (PK != null && PK.zIh) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(PK.length + PK.start);
                            }
                            AppMethodBeat.o(107555);
                            return;
                        } else {
                            b PK2 = b.PK(selectionStart);
                            if (PK2 != null && PK2.zIh) {
                                selectionStart = PK2.start + PK2.length;
                            }
                            if (selectionStart >= selectionEnd) {
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart);
                                AppMethodBeat.o(107555);
                                return;
                            }
                            b PK3 = b.PK(selectionEnd);
                            if (PK3 != null && PK3.zIh) {
                                int i3 = PK3.start;
                                editText2.setTextKeepState(text);
                                editText2.setSelection(selectionStart, i3);
                            }
                            AppMethodBeat.o(107555);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(107555);
            }
        });
        this.zzZ.setOnFocusChangeListener(this.zAg);
        com.tencent.mm.ui.tools.b.c.d(this.zzZ).PM(100).a(null);
        this.zAa.setOnClickListener(this.zAi);
        AppMethodBeat.o(107565);
    }

    public String getSearchContent() {
        AppMethodBeat.i(107566);
        String obj;
        if (this.zzZ.getEditableText() != null) {
            obj = this.zzZ.getEditableText().toString();
            AppMethodBeat.o(107566);
            return obj;
        }
        obj = "";
        AppMethodBeat.o(107566);
        return obj;
    }

    public void setCallBack(b bVar) {
        this.zAe = bVar;
    }

    public void setBackClickCallback(a aVar) {
        this.zAf = aVar;
    }

    public void setSearchContent(String str) {
        CharSequence str2;
        AppMethodBeat.i(107567);
        if (str2 == null) {
            str2 = "";
        }
        this.zzZ.setText(str2);
        this.zzZ.setSelection(str2.length());
        AppMethodBeat.o(107567);
    }

    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(107568);
        this.zzZ.setHint(charSequence);
        AppMethodBeat.o(107568);
    }

    public final void qN(boolean z) {
        AppMethodBeat.i(107569);
        this.zAc = z;
        dJq();
        AppMethodBeat.o(107569);
    }

    public void setEditTextEnabled(boolean z) {
        AppMethodBeat.i(107570);
        this.zzZ.setEnabled(z);
        AppMethodBeat.o(107570);
    }

    public void setStatusBtnEnabled(boolean z) {
        AppMethodBeat.i(107571);
        this.zAa.setEnabled(z);
        AppMethodBeat.o(107571);
    }

    private void hu(int i, int i2) {
        AppMethodBeat.i(107572);
        this.zAa.setImageResource(i);
        this.zAa.setBackgroundResource(0);
        if (i == R.drawable.a50) {
            this.zAa.setContentDescription(getContext().getString(R.string.f1z));
        } else {
            this.zAa.setContentDescription(getContext().getString(R.string.aqw));
        }
        LayoutParams layoutParams = this.zAa.getLayoutParams();
        layoutParams.width = i2;
        this.zAa.setLayoutParams(layoutParams);
        AppMethodBeat.o(107572);
    }

    private void dJq() {
        AppMethodBeat.i(107573);
        if (this.zzZ.getEditableText() != null && !bo.isNullOrNil(this.zzZ.getEditableText().toString())) {
            hu(R.drawable.z7, getResources().getDimensionPixelSize(R.dimen.m2));
            this.zAb = c.CLEAR;
            AppMethodBeat.o(107573);
        } else if (this.zAc) {
            hu(R.drawable.a50, getResources().getDimensionPixelSize(R.dimen.m2));
            this.zAb = c.VOICE_SEARCH;
            AppMethodBeat.o(107573);
        } else {
            hu(0, 0);
            this.zAb = c.CLEAR;
            AppMethodBeat.o(107573);
        }
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(107574);
        this.zzZ.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(107574);
    }

    public final void qO(boolean z) {
        AppMethodBeat.i(107575);
        if (z) {
            this.zzZ.setText("");
            AppMethodBeat.o(107575);
            return;
        }
        this.zzZ.removeTextChangedListener(this.vog);
        this.zzZ.setText("");
        this.zzZ.addTextChangedListener(this.vog);
        AppMethodBeat.o(107575);
    }

    public final void dJr() {
        AppMethodBeat.i(107576);
        this.zzZ.clearFocus();
        AppMethodBeat.o(107576);
    }

    public void setNotRealCallBack(com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a aVar) {
    }

    public final boolean dJs() {
        AppMethodBeat.i(107577);
        if (this.zzZ != null) {
            boolean hasFocus = this.zzZ.hasFocus();
            AppMethodBeat.o(107577);
            return hasFocus;
        }
        AppMethodBeat.o(107577);
        return false;
    }

    public final boolean dJt() {
        AppMethodBeat.i(107578);
        if (this.zzZ != null) {
            boolean requestFocus = this.zzZ.requestFocus();
            AppMethodBeat.o(107578);
            return requestFocus;
        }
        AppMethodBeat.o(107578);
        return false;
    }

    public void setEditTextClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(107579);
        if (this.zzZ != null) {
            this.zzZ.setFocusable(false);
            this.zzZ.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(107579);
    }

    public void setKeywords(ArrayList<String> arrayList) {
        AppMethodBeat.i(107580);
        if (this.zAd != null) {
            s sVar = this.zAd;
            sVar.zId = arrayList;
            if (sVar.zIe) {
                EditText editText = (EditText) sVar.zIc.get();
                if (editText != null) {
                    s.a(editText, sVar.zId);
                }
            }
        }
        AppMethodBeat.o(107580);
    }

    public void setAutoMatchKeywords(boolean z) {
        if (this.zAd != null) {
            this.zAd.zIe = z;
        }
    }

    public void setSearchTipIcon(int i) {
        AppMethodBeat.i(107581);
        if (this.zzZ != null) {
            this.zzZ.setCompoundDrawables(ah.getResources().getDrawable(i), null, null, null);
        }
        AppMethodBeat.o(107581);
    }

    public void setSelectedTag(String str) {
        AppMethodBeat.i(107582);
        if (this.zzZ != null) {
            this.zzZ.setCompoundDrawables(new d(this.zzZ, str), null, null, null);
            this.zzZ.setHint("");
        }
        AppMethodBeat.o(107582);
    }

    public int getSelectionStart() {
        AppMethodBeat.i(107583);
        if (this.zzZ != null) {
            int selectionStart = this.zzZ.getSelectionStart();
            AppMethodBeat.o(107583);
            return selectionStart;
        }
        AppMethodBeat.o(107583);
        return -1;
    }

    public int getSelectionEnd() {
        AppMethodBeat.i(107584);
        if (this.zzZ != null) {
            int selectionEnd = this.zzZ.getSelectionEnd();
            AppMethodBeat.o(107584);
            return selectionEnd;
        }
        AppMethodBeat.o(107584);
        return -1;
    }
}
