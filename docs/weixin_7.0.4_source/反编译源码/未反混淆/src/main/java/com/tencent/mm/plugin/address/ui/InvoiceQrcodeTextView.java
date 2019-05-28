package com.tencent.mm.plugin.address.ui;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

public class InvoiceQrcodeTextView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener gJD;
    private TextView gJE;
    private ImageView gJG;
    private String gJH;
    private String gJI;
    private int gJJ;
    private int gJK;
    public boolean gJL;
    private int gJM;
    public boolean gJN;
    private int gJO;
    private int gJP;
    private boolean gJQ;
    private OnClickListener gJR;
    private String gJS;
    public boolean gJU;
    private int gJY;
    public boolean gJZ;
    private a gKo;
    private c gKp;
    private b gKq;
    TextView gKr;
    private int gravity;
    private int imeOptions;
    private int inputType;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    static /* synthetic */ void a(InvoiceQrcodeTextView invoiceQrcodeTextView, boolean z) {
        AppMethodBeat.i(16907);
        invoiceQrcodeTextView.dr(z);
        AppMethodBeat.o(16907);
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(16886);
        this.gJU = false;
        this.gJH = "";
        this.gJI = "";
        this.inputType = 1;
        this.gJY = 0;
        this.gravity = 19;
        this.gJJ = -1;
        this.background = -1;
        this.gJK = -1;
        this.gJL = true;
        this.gJZ = true;
        this.gJN = false;
        this.gJO = 0;
        this.gJP = 100;
        this.gJQ = true;
        this.gJR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16885);
                if (InvoiceQrcodeTextView.this.gJG.getVisibility() == 0) {
                    if (InvoiceQrcodeTextView.this.gJL && InvoiceQrcodeTextView.this.gJJ != 2 && !bo.isNullOrNil(InvoiceQrcodeTextView.this.getText())) {
                        InvoiceQrcodeTextView.this.gKr.setText("");
                        InvoiceQrcodeTextView.a(InvoiceQrcodeTextView.this, InvoiceQrcodeTextView.this.gKr.isFocused());
                        AppMethodBeat.o(16885);
                        return;
                    } else if (InvoiceQrcodeTextView.this.gKo != null) {
                        InvoiceQrcodeTextView.this.gKo;
                    }
                }
                AppMethodBeat.o(16885);
            }
        };
        this.gJS = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.InvoiceEditView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.gJH = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.gJI = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(3, 1);
        this.gJJ = obtainStyledAttributes.getInteger(7, 0);
        this.gJL = obtainStyledAttributes.getBoolean(10, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(4, 5);
        this.background = obtainStyledAttributes.getResourceId(1, R.drawable.a8g);
        this.gJM = obtainStyledAttributes.getResourceId(12, -1);
        this.gJK = obtainStyledAttributes.getResourceId(9, R.drawable.a8g);
        this.gJQ = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.a8d, this, true);
        this.gKr = (TextView) inflate.findViewById(R.id.n1);
        this.gKr.setTextSize(0, (float) com.tencent.mm.bz.a.al(context, R.dimen.m5));
        this.gJE = (TextView) inflate.findViewById(R.id.n0);
        this.gJG = (ImageView) inflate.findViewById(R.id.n2);
        this.gJG.setOnClickListener(this.gJR);
        this.gKr.setImeOptions(this.imeOptions);
        if (!bo.isNullOrNil(this.gJH)) {
            this.gKr.setHint(this.gJH);
        }
        if (!bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        Rect rect = new Rect();
        i(this.gKr, rect);
        j(this.gKr, rect);
        setPadding(com.tencent.mm.bz.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        if (this.gJM != -1) {
            this.gJG.setImageResource(this.gJM);
        }
        if (!this.gJQ) {
            this.gKr.setSingleLine(false);
        }
        this.gKr.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                AppMethodBeat.i(16884);
                final ClipboardManager clipboardManager = (ClipboardManager) ah.getContext().getSystemService("clipboard");
                final TextView textView = (TextView) view;
                if (!(textView.getText() == null || clipboardManager == null)) {
                    final CharSequence text = textView.getText();
                    SpannableString spannableString = new SpannableString(text);
                    spannableString.setSpan(new BackgroundColorSpan(textView.getContext().getResources().getColor(R.color.sz)), 0, text.length(), 33);
                    textView.setText(spannableString);
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(textView.getContext(), textView);
                    aVar.zRZ = new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(16881);
                            contextMenu.add(textView.getContext().getString(R.string.oy));
                            AppMethodBeat.o(16881);
                        }
                    };
                    aVar.rBm = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(16882);
                            if (i == 0) {
                                clipboardManager.setText(textView.getText().toString());
                                h.bP(textView.getContext(), textView.getContext().getString(R.string.oz));
                            }
                            AppMethodBeat.o(16882);
                        }
                    };
                    aVar.zHM = new OnDismissListener() {
                        public final void onDismiss() {
                            AppMethodBeat.i(16883);
                            textView.setText(text);
                            AppMethodBeat.o(16883);
                        }
                    };
                    aVar.dn(0, 0);
                }
                AppMethodBeat.o(16884);
                return false;
            }
        });
        AppMethodBeat.o(16886);
    }

    public InvoiceQrcodeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void asd() {
        AppMethodBeat.i(16887);
        setBackgroundResource(0);
        this.gJE.setTextColor(getResources().getColor(R.color.z6));
        this.gKr.setTextColor(getResources().getColor(R.color.h4));
        this.gKr.setInputType(0);
        this.gKr.clearFocus();
        this.gKr.setSingleLine(false);
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.gKr.getWindowToken(), 0);
        AppMethodBeat.o(16887);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.gKp = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.gKq = bVar;
    }

    public String getText() {
        AppMethodBeat.i(16888);
        String charSequence = this.gKr.getText().toString();
        AppMethodBeat.o(16888);
        return charSequence;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(16889);
        this.gKr.setEllipsize(truncateAt);
        AppMethodBeat.o(16889);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(16890);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.o(16890);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(16891);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.o(16891);
                return true;
            }
        }
        AppMethodBeat.o(16891);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(16892);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(16892);
    }

    private void dr(boolean z) {
        AppMethodBeat.i(16893);
        if (!this.gJL || bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 0:
                case 1:
                case 4:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16893);
                    return;
                case 2:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(R.string.dm));
                    AppMethodBeat.o(16893);
                    return;
                case 3:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(R.string.e8));
                    AppMethodBeat.o(16893);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16893);
                    return;
            }
        }
        this.gJG.setImageResource(R.drawable.r8);
        this.gJG.setContentDescription(getContext().getString(R.string.aqw));
        switch (this.gJJ) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.gJG.setVisibility(0);
                    AppMethodBeat.o(16893);
                    return;
                }
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16893);
                return;
            case 2:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(R.string.dm));
                AppMethodBeat.o(16893);
                return;
            case 3:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(R.string.e8));
                AppMethodBeat.o(16893);
                return;
            default:
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16893);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(16894);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.o(16894);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.gKo = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(16895);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        ab.d("MicroMsg.InvoiceEditView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.gJN) {
            this.gJE.setEnabled(true);
        } else {
            this.gJE.setEnabled(false);
        }
        if (view == this.gKr) {
            Rect rect = new Rect();
            i(this, rect);
            if (z) {
                setBackgroundResource(R.drawable.b77);
            } else {
                setBackgroundResource(R.drawable.b78);
            }
            j(this, rect);
        }
        dr(z);
        AppMethodBeat.o(16895);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(16896);
        this.gKr.setHint(str);
        AppMethodBeat.o(16896);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(16897);
        this.gJE.setText(str);
        AppMethodBeat.o(16897);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(16898);
        this.gKr.setText(str);
        this.gJS = str;
        AppMethodBeat.o(16898);
    }

    public void setBankNumberValStr(String str) {
        CharSequence str2;
        AppMethodBeat.i(16899);
        if (this.gJJ == 5) {
            String replace = str2.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < replace.length() / 4; i++) {
                    stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                }
                str2 = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
            }
        }
        this.gKr.setText(str2);
        AppMethodBeat.o(16899);
    }

    public void setEditBG(int i) {
        AppMethodBeat.i(16900);
        if (this.gKr != null) {
            Rect rect = new Rect();
            i(this.gKr, rect);
            this.gKr.setBackgroundResource(i);
            j(this.gKr, rect);
        }
        AppMethodBeat.o(16900);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.i(16901);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.o(16901);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.i(16902);
        this.gKr.setImeOptions(i);
        AppMethodBeat.o(16902);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.i(16903);
        this.gJG.setVisibility(i);
        AppMethodBeat.o(16903);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(16904);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(16904);
        return rect;
    }

    private static void i(View view, Rect rect) {
        AppMethodBeat.i(16905);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(16905);
    }

    private static void j(View view, Rect rect) {
        AppMethodBeat.i(16906);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(16906);
    }
}
