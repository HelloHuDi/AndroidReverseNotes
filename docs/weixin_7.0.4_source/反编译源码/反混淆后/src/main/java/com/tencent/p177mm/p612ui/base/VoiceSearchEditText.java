package com.tencent.p177mm.p612ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.VoiceSearchEditText */
public class VoiceSearchEditText extends EditText {
    private Context context;
    public String jjo = "";
    private OnClickListener qqV;
    final Drawable yAZ = getResources().getDrawable(C25738R.drawable.a50);
    final Drawable yBa = null;
    final Drawable yBb = getResources().getDrawable(C25738R.drawable.f7034z7);
    private C23628a yBc;
    private boolean yBd = true;
    private boolean yBe = false;
    private boolean yBf = false;

    /* renamed from: com.tencent.mm.ui.base.VoiceSearchEditText$1 */
    class C236251 implements OnTouchListener {
        C236251() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107088);
            VoiceSearchEditText voiceSearchEditText = VoiceSearchEditText.this;
            if (voiceSearchEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.m2505o(107088);
                return false;
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(107088);
                return true;
            } else {
                VoiceSearchEditText.this.yBf = true;
                if (VoiceSearchEditText.this.yBd && VoiceSearchEditText.this.yBe && voiceSearchEditText.getText().toString().equals("")) {
                    if (motionEvent.getX() <= ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - VoiceSearchEditText.this.yAZ.getIntrinsicWidth()) - C1338a.fromDPToPix(voiceSearchEditText.context, 25)))) {
                        voiceSearchEditText.requestFocus();
                        if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                            MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                        }
                        if (VoiceSearchEditText.this.qqV != null) {
                            VoiceSearchEditText.this.qqV.onClick(null);
                        }
                    } else if (VoiceSearchEditText.this.qqV != null) {
                        C4990ab.m7416i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                        if (VoiceSearchEditText.this.getContext() instanceof MMActivity) {
                            ((MMActivity) VoiceSearchEditText.this.getContext()).hideVKB(voiceSearchEditText);
                        }
                        VoiceSearchEditText.this.qqV.onClick(VoiceSearchEditText.this);
                        AppMethodBeat.m2505o(107088);
                        return true;
                    }
                } else if (voiceSearchEditText.getText().toString().length() > 0) {
                    if (motionEvent.getX() > ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - VoiceSearchEditText.this.yBb.getIntrinsicWidth()) - C1338a.fromDPToPix(voiceSearchEditText.context, 25)))) {
                        voiceSearchEditText.setText("");
                        if (VoiceSearchEditText.this.yBc != null) {
                            VoiceSearchEditText.this.yBc;
                        }
                        VoiceSearchEditText.m36474f(VoiceSearchEditText.this);
                    } else if (!voiceSearchEditText.isFocused()) {
                        voiceSearchEditText.requestFocus();
                        if (VoiceSearchEditText.this.getContext() instanceof Activity) {
                            MMActivity.showVKB((Activity) VoiceSearchEditText.this.getContext());
                        }
                    }
                } else if (VoiceSearchEditText.this.qqV != null) {
                    VoiceSearchEditText.this.qqV.onClick(null);
                }
                AppMethodBeat.m2505o(107088);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.base.VoiceSearchEditText$2 */
    class C236262 implements TextWatcher {
        C236262() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(107089);
            VoiceSearchEditText.this.yBf = true;
            VoiceSearchEditText.m36474f(VoiceSearchEditText.this);
            AppMethodBeat.m2505o(107089);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.VoiceSearchEditText$3 */
    class C236273 implements OnFocusChangeListener {
        C236273() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(107090);
            C4990ab.m7411d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", Boolean.valueOf(z), Boolean.valueOf(VoiceSearchEditText.this.yBf));
            if (!z && VoiceSearchEditText.this.yBf) {
                VoiceSearchEditText.m36474f(VoiceSearchEditText.this);
                VoiceSearchEditText.this.yBf = false;
            }
            AppMethodBeat.m2505o(107090);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.VoiceSearchEditText$a */
    public interface C23628a {
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107091);
        init(context);
        AppMethodBeat.m2505o(107091);
    }

    public void setNeedIcon(boolean z) {
    }

    public VoiceSearchEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107092);
        init(context);
        AppMethodBeat.m2505o(107092);
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(107093);
        this.qqV = onClickListener;
        this.yBe = true;
        dAv();
        AppMethodBeat.m2505o(107093);
    }

    public void setOnContentClearListener(C23628a c23628a) {
        this.yBc = c23628a;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(107094);
        this.context = context;
        this.yBe = false;
        this.yAZ.setBounds(0, 0, this.yAZ.getIntrinsicWidth(), this.yAZ.getIntrinsicHeight());
        this.yBb.setBounds(0, 0, this.yBb.getIntrinsicWidth(), this.yBb.getIntrinsicHeight());
        dAv();
        setOnTouchListener(new C236251());
        addTextChangedListener(new C236262());
        setOnFocusChangeListener(new C236273());
        if (context instanceof Activity) {
            View currentFocus = ((Activity) context).getCurrentFocus();
            if (currentFocus == null || currentFocus != this) {
                this.yBf = false;
            } else {
                this.yBf = true;
            }
        }
        requestFocus();
        AppMethodBeat.m2505o(107094);
    }

    private void dAv() {
        AppMethodBeat.m2504i(107095);
        this.yBd = true;
        if (this.yBe) {
            setCompoundDrawables(this.yBa, getCompoundDrawables()[1], this.yAZ, getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107095);
        } else if (getText().toString().length() > 0) {
            setCompoundDrawables(this.yBa, getCompoundDrawables()[1], this.yBb, getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107095);
        } else {
            setCompoundDrawables(this.yBa, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107095);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m36474f(VoiceSearchEditText voiceSearchEditText) {
        AppMethodBeat.m2504i(107096);
        C4990ab.m7410d("MicroMsg.VoiceSearchEditText", "checkView");
        if (voiceSearchEditText.getText().toString().equals("") && voiceSearchEditText.yBe) {
            voiceSearchEditText.yBd = true;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yBa, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yAZ, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107096);
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yBa, voiceSearchEditText.getCompoundDrawables()[1], voiceSearchEditText.yBb, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107096);
        } else {
            voiceSearchEditText.yBd = false;
            voiceSearchEditText.setCompoundDrawables(voiceSearchEditText.yBa, voiceSearchEditText.getCompoundDrawables()[1], null, voiceSearchEditText.getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(107096);
        }
    }
}
