package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView */
public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater ezi;
    private View jWH;
    private LinearLayout jXw;
    private int padding;
    private HorizontalScrollView vhW;
    private View vhX;
    public MMEditText vhY;
    private List<String> vhZ;
    private Animation vib;
    private int vic;
    private C35818a vid;
    private C40457b vie;
    private C44075c vif;
    private List<View> vig;
    boolean vih;

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$2 */
    class C149022 implements OnKeyListener {
        C149022() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(105159);
            if (i == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.this.vhY.getSelectionStart() == 0 && MultiSelectContactView.this.vhY.getSelectionEnd() == 0) {
                MultiSelectContactView.m79240d(MultiSelectContactView.this);
            }
            AppMethodBeat.m2505o(105159);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$1 */
    class C300961 implements TextWatcher {
        C300961() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(105158);
            MultiSelectContactView.m79234a(MultiSelectContactView.this);
            if (MultiSelectContactView.this.vie != null) {
                MultiSelectContactView.this.vie.mo39660Qa(charSequence.toString());
            }
            AppMethodBeat.m2505o(105158);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$3 */
    class C358173 implements OnFocusChangeListener {
        C358173() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(105160);
            if (z) {
                MultiSelectContactView.this.jWH.setBackgroundResource(C25738R.drawable.b77);
                MultiSelectContactView.this.jWH.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
            } else {
                MultiSelectContactView.this.jWH.setBackgroundResource(C25738R.drawable.b78);
                MultiSelectContactView.this.jWH.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
            }
            if (MultiSelectContactView.this.vif != null) {
                MultiSelectContactView.this.vif.dji();
            }
            AppMethodBeat.m2505o(105160);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$a */
    public interface C35818a {
        /* renamed from: vI */
        void mo7901vI(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$4 */
    class C404534 implements OnClickListener {
        C404534() {
        }

        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$7 */
    class C404567 implements Runnable {
        C404567() {
        }

        public final void run() {
            AppMethodBeat.m2504i(105164);
            MultiSelectContactView.this.vhW.scrollTo(MultiSelectContactView.this.jXw.getMeasuredWidth(), 0);
            AppMethodBeat.m2505o(105164);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$b */
    public interface C40457b {
        /* renamed from: Qa */
        void mo39660Qa(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$5 */
    class C440745 implements OnClickListener {
        C440745() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(105161);
            MultiSelectContactView.m79236a(MultiSelectContactView.this, view);
            AppMethodBeat.m2505o(105161);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$c */
    public interface C44075c {
        void dji();
    }

    /* renamed from: a */
    static /* synthetic */ void m79234a(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.m2504i(105179);
        multiSelectContactView.djf();
        AppMethodBeat.m2505o(105179);
    }

    /* renamed from: i */
    static /* synthetic */ void m79245i(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.m2504i(105183);
        multiSelectContactView.djh();
        AppMethodBeat.m2505o(105183);
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105165);
        this.vic = 0;
        this.padding = 0;
        this.vih = false;
        this.padding = getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
        this.ezi = LayoutInflater.from(context);
        this.ezi.inflate(2130970276, this, true);
        this.vhW = (HorizontalScrollView) findViewById(2131826271);
        this.vhY = (MMEditText) findViewById(2131823253);
        this.jXw = (LinearLayout) findViewById(2131826272);
        this.vhX = findViewById(2131823252);
        this.vhZ = new LinkedList();
        this.vib = AnimationUtils.loadAnimation(context, C25738R.anim.f8332b5);
        C7357c.m12555d(this.vhY).mo15877PM(100).mo15879a(null);
        this.jWH = findViewById(2131820987);
        this.vhY.addTextChangedListener(new C300961());
        this.vhY.setOnKeyListener(new C149022());
        this.vig = new ArrayList();
        this.vhY.clearFocus();
        this.vhY.setOnFocusChangeListener(new C358173());
        setBackgroundColor(-201326593);
        setOnClickListener(new C404534());
        AppMethodBeat.m2505o(105165);
    }

    public int getSelectedCount() {
        AppMethodBeat.m2504i(105166);
        int childCount = this.jXw.getChildCount();
        AppMethodBeat.m2505o(105166);
        return childCount;
    }

    public void setOnContactDeselectListener(C35818a c35818a) {
        this.vid = c35818a;
    }

    public void setOnSearchTextChangeListener(C40457b c40457b) {
        this.vie = c40457b;
    }

    public void setOnSearchTextFouceChangeListener(C44075c c44075c) {
        this.vif = c44075c;
    }

    public void setFixedUserList(List<String> list) {
        AppMethodBeat.m2504i(105167);
        if (list == null) {
            AppMethodBeat.m2505o(105167);
            return;
        }
        this.vhZ.addAll(list);
        AppMethodBeat.m2505o(105167);
    }

    public void clearFocus() {
        AppMethodBeat.m2504i(105168);
        this.vhY.clearFocus();
        djf();
        AppMethodBeat.m2505o(105168);
    }

    public final void ajq(String str) {
        AppMethodBeat.m2504i(105169);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105169);
        } else if (this.vhZ.contains(str)) {
            C4990ab.m7416i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
            AppMethodBeat.m2505o(105169);
        } else {
            djf();
            View ajs = ajs(str);
            if (ajs != null) {
                m79239c(ajs, false, false);
                AppMethodBeat.m2505o(105169);
                return;
            }
            mo69767bU(str, true);
            AppMethodBeat.m2505o(105169);
        }
    }

    public final void ajr(String str) {
        AppMethodBeat.m2504i(105170);
        View ajs = ajs(str);
        if (ajs != null) {
            m79239c(ajs, false, false);
            AppMethodBeat.m2505o(105170);
            return;
        }
        AppMethodBeat.m2505o(105170);
    }

    private void djf() {
        AppMethodBeat.m2504i(105171);
        if (this.jXw.getChildCount() == 0) {
            AppMethodBeat.m2505o(105171);
            return;
        }
        if (this.vih) {
            View childAt = this.jXw.getChildAt(this.jXw.getChildCount() - 1);
            this.vih = false;
            childAt.findViewById(2131827308).setVisibility(8);
        }
        AppMethodBeat.m2505o(105171);
    }

    /* renamed from: bU */
    public final void mo69767bU(String str, boolean z) {
        AppMethodBeat.m2504i(105172);
        m79233KN(this.jXw.getChildCount() + 1);
        View inflate = this.ezi.inflate(2130970584, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(2131823704);
        C40460b.m69434b(imageView, str);
        imageView.setContentDescription(((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new C440745());
        if (z) {
            inflate.startAnimation(this.vib);
        }
        this.jXw.addView(inflate);
        djh();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f9765f1);
        layoutParams.width = getResources().getDimensionPixelSize(C25738R.dimen.f9765f1);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
        inflate.setLayoutParams(layoutParams);
        djg();
        AppMethodBeat.m2505o(105172);
    }

    /* renamed from: c */
    private void m79239c(final View view, boolean z, boolean z2) {
        AppMethodBeat.m2504i(105173);
        if (z && this.vid != null) {
            this.vid.mo7901vI(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8333b6);
            loadAnimation.setAnimationListener(new AnimationListener() {

                /* renamed from: com.tencent.mm.pluginsdk.ui.MultiSelectContactView$6$1 */
                class C404541 implements Runnable {
                    C404541() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(105162);
                        MultiSelectContactView.this.jXw.removeView(view);
                        MultiSelectContactView.m79245i(MultiSelectContactView.this);
                        MultiSelectContactView.m79235a(MultiSelectContactView.this, MultiSelectContactView.this.jXw.getChildCount());
                        AppMethodBeat.m2505o(105162);
                    }
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(105163);
                    view.post(new C404541());
                    AppMethodBeat.m2505o(105163);
                }
            });
            view.startAnimation(loadAnimation);
            AppMethodBeat.m2505o(105173);
            return;
        }
        this.jXw.removeView(view);
        djh();
        m79233KN(this.jXw.getChildCount());
        AppMethodBeat.m2505o(105173);
    }

    private void djg() {
        AppMethodBeat.m2504i(105174);
        this.jXw.post(new C404567());
        AppMethodBeat.m2505o(105174);
    }

    /* renamed from: KN */
    private void m79233KN(int i) {
        int measureText;
        AppMethodBeat.m2504i(105175);
        if (this.vic <= 0) {
            this.vic += getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
            int b = C4977b.m7371b(getContext(), 40.0f);
            measureText = (int) this.vhY.getPaint().measureText(getContext().getString(C25738R.string.f9220te));
            this.vic = Math.max(b, measureText) + this.vic;
        }
        if (this.vic <= 0) {
            AppMethodBeat.m2505o(105175);
            return;
        }
        measureText = this.jWH.getWidth();
        C4990ab.m7419v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(C25738R.dimen.f9765f1) + getResources().getDimensionPixelSize(C25738R.dimen.f9723do))), Integer.valueOf(this.vic));
        LayoutParams layoutParams = (LayoutParams) this.vhW.getLayoutParams();
        if (measureText - (i * (getResources().getDimensionPixelSize(C25738R.dimen.f9765f1) + getResources().getDimensionPixelSize(C25738R.dimen.f9723do))) > this.vic) {
            layoutParams.width = -2;
            AppMethodBeat.m2505o(105175);
            return;
        }
        layoutParams.width = measureText - this.vic;
        AppMethodBeat.m2505o(105175);
    }

    private void djh() {
        AppMethodBeat.m2504i(105176);
        if (this.jXw.getChildCount() == 0) {
            this.vhX.setVisibility(0);
            AppMethodBeat.m2505o(105176);
            return;
        }
        this.vhX.setVisibility(8);
        AppMethodBeat.m2505o(105176);
    }

    public String getSearchContent() {
        AppMethodBeat.m2504i(105177);
        String obj = this.vhY.getText().toString();
        AppMethodBeat.m2505o(105177);
        return obj;
    }

    private View ajs(String str) {
        AppMethodBeat.m2504i(105178);
        int childCount = this.jXw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jXw.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                AppMethodBeat.m2505o(105178);
                return childAt;
            }
        }
        AppMethodBeat.m2505o(105178);
        return null;
    }

    public EditText getInputText() {
        return this.vhY;
    }

    /* renamed from: d */
    static /* synthetic */ void m79240d(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.m2504i(105180);
        if (multiSelectContactView.jXw.getChildCount() != 0) {
            View childAt = multiSelectContactView.jXw.getChildAt(multiSelectContactView.jXw.getChildCount() - 1);
            if (multiSelectContactView.vih) {
                multiSelectContactView.m79239c(childAt, true, false);
                multiSelectContactView.vih = false;
            } else {
                multiSelectContactView.vih = true;
                multiSelectContactView.djg();
                childAt.findViewById(2131827308).setVisibility(0);
            }
            multiSelectContactView.vhY.requestFocus();
        }
        AppMethodBeat.m2505o(105180);
    }
}
