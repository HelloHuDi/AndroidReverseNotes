package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    private a vid;
    private b vie;
    private c vif;
    private List<View> vig;
    boolean vih;

    public interface a {
        void vI(String str);
    }

    public interface b {
        void Qa(String str);
    }

    public interface c {
        void dji();
    }

    static /* synthetic */ void a(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(105179);
        multiSelectContactView.djf();
        AppMethodBeat.o(105179);
    }

    static /* synthetic */ void i(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(105183);
        multiSelectContactView.djh();
        AppMethodBeat.o(105183);
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105165);
        this.vic = 0;
        this.padding = 0;
        this.vih = false;
        this.padding = getResources().getDimensionPixelSize(R.dimen.f15do);
        this.ezi = LayoutInflater.from(context);
        this.ezi.inflate(R.layout.ai5, this, true);
        this.vhW = (HorizontalScrollView) findViewById(R.id.dft);
        this.vhY = (MMEditText) findViewById(R.id.b98);
        this.jXw = (LinearLayout) findViewById(R.id.dfu);
        this.vhX = findViewById(R.id.b97);
        this.vhZ = new LinkedList();
        this.vib = AnimationUtils.loadAnimation(context, R.anim.b5);
        com.tencent.mm.ui.tools.b.c.d(this.vhY).PM(100).a(null);
        this.jWH = findViewById(R.id.l_);
        this.vhY.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(105158);
                MultiSelectContactView.a(MultiSelectContactView.this);
                if (MultiSelectContactView.this.vie != null) {
                    MultiSelectContactView.this.vie.Qa(charSequence.toString());
                }
                AppMethodBeat.o(105158);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.vhY.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(105159);
                if (i == 67 && keyEvent.getAction() == 0 && MultiSelectContactView.this.vhY.getSelectionStart() == 0 && MultiSelectContactView.this.vhY.getSelectionEnd() == 0) {
                    MultiSelectContactView.d(MultiSelectContactView.this);
                }
                AppMethodBeat.o(105159);
                return false;
            }
        });
        this.vig = new ArrayList();
        this.vhY.clearFocus();
        this.vhY.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(105160);
                if (z) {
                    MultiSelectContactView.this.jWH.setBackgroundResource(R.drawable.b77);
                    MultiSelectContactView.this.jWH.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
                } else {
                    MultiSelectContactView.this.jWH.setBackgroundResource(R.drawable.b78);
                    MultiSelectContactView.this.jWH.setPadding(MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding, MultiSelectContactView.this.padding);
                }
                if (MultiSelectContactView.this.vif != null) {
                    MultiSelectContactView.this.vif.dji();
                }
                AppMethodBeat.o(105160);
            }
        });
        setBackgroundColor(-201326593);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        AppMethodBeat.o(105165);
    }

    public int getSelectedCount() {
        AppMethodBeat.i(105166);
        int childCount = this.jXw.getChildCount();
        AppMethodBeat.o(105166);
        return childCount;
    }

    public void setOnContactDeselectListener(a aVar) {
        this.vid = aVar;
    }

    public void setOnSearchTextChangeListener(b bVar) {
        this.vie = bVar;
    }

    public void setOnSearchTextFouceChangeListener(c cVar) {
        this.vif = cVar;
    }

    public void setFixedUserList(List<String> list) {
        AppMethodBeat.i(105167);
        if (list == null) {
            AppMethodBeat.o(105167);
            return;
        }
        this.vhZ.addAll(list);
        AppMethodBeat.o(105167);
    }

    public void clearFocus() {
        AppMethodBeat.i(105168);
        this.vhY.clearFocus();
        djf();
        AppMethodBeat.o(105168);
    }

    public final void ajq(String str) {
        AppMethodBeat.i(105169);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105169);
        } else if (this.vhZ.contains(str)) {
            ab.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
            AppMethodBeat.o(105169);
        } else {
            djf();
            View ajs = ajs(str);
            if (ajs != null) {
                c(ajs, false, false);
                AppMethodBeat.o(105169);
                return;
            }
            bU(str, true);
            AppMethodBeat.o(105169);
        }
    }

    public final void ajr(String str) {
        AppMethodBeat.i(105170);
        View ajs = ajs(str);
        if (ajs != null) {
            c(ajs, false, false);
            AppMethodBeat.o(105170);
            return;
        }
        AppMethodBeat.o(105170);
    }

    private void djf() {
        AppMethodBeat.i(105171);
        if (this.jXw.getChildCount() == 0) {
            AppMethodBeat.o(105171);
            return;
        }
        if (this.vih) {
            View childAt = this.jXw.getChildAt(this.jXw.getChildCount() - 1);
            this.vih = false;
            childAt.findViewById(R.id.e7u).setVisibility(8);
        }
        AppMethodBeat.o(105171);
    }

    public final void bU(String str, boolean z) {
        AppMethodBeat.i(105172);
        KN(this.jXw.getChildCount() + 1);
        View inflate = this.ezi.inflate(R.layout.aqf, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bke);
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
        imageView.setContentDescription(((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(105161);
                MultiSelectContactView.a(MultiSelectContactView.this, view);
                AppMethodBeat.o(105161);
            }
        });
        if (z) {
            inflate.startAnimation(this.vib);
        }
        this.jXw.addView(inflate);
        djh();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(R.dimen.f1);
        layoutParams.width = getResources().getDimensionPixelSize(R.dimen.f1);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.f15do);
        inflate.setLayoutParams(layoutParams);
        djg();
        AppMethodBeat.o(105172);
    }

    private void c(final View view, boolean z, boolean z2) {
        AppMethodBeat.i(105173);
        if (z && this.vid != null) {
            this.vid.vI(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.b6);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(105163);
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105162);
                            MultiSelectContactView.this.jXw.removeView(view);
                            MultiSelectContactView.i(MultiSelectContactView.this);
                            MultiSelectContactView.a(MultiSelectContactView.this, MultiSelectContactView.this.jXw.getChildCount());
                            AppMethodBeat.o(105162);
                        }
                    });
                    AppMethodBeat.o(105163);
                }
            });
            view.startAnimation(loadAnimation);
            AppMethodBeat.o(105173);
            return;
        }
        this.jXw.removeView(view);
        djh();
        KN(this.jXw.getChildCount());
        AppMethodBeat.o(105173);
    }

    private void djg() {
        AppMethodBeat.i(105174);
        this.jXw.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(105164);
                MultiSelectContactView.this.vhW.scrollTo(MultiSelectContactView.this.jXw.getMeasuredWidth(), 0);
                AppMethodBeat.o(105164);
            }
        });
        AppMethodBeat.o(105174);
    }

    private void KN(int i) {
        int measureText;
        AppMethodBeat.i(105175);
        if (this.vic <= 0) {
            this.vic += getResources().getDimensionPixelSize(R.dimen.l8);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 40.0f);
            measureText = (int) this.vhY.getPaint().measureText(getContext().getString(R.string.te));
            this.vic = Math.max(b, measureText) + this.vic;
        }
        if (this.vic <= 0) {
            AppMethodBeat.o(105175);
            return;
        }
        measureText = this.jWH.getWidth();
        ab.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(R.dimen.f1) + getResources().getDimensionPixelSize(R.dimen.f15do))), Integer.valueOf(this.vic));
        LayoutParams layoutParams = (LayoutParams) this.vhW.getLayoutParams();
        if (measureText - (i * (getResources().getDimensionPixelSize(R.dimen.f1) + getResources().getDimensionPixelSize(R.dimen.f15do))) > this.vic) {
            layoutParams.width = -2;
            AppMethodBeat.o(105175);
            return;
        }
        layoutParams.width = measureText - this.vic;
        AppMethodBeat.o(105175);
    }

    private void djh() {
        AppMethodBeat.i(105176);
        if (this.jXw.getChildCount() == 0) {
            this.vhX.setVisibility(0);
            AppMethodBeat.o(105176);
            return;
        }
        this.vhX.setVisibility(8);
        AppMethodBeat.o(105176);
    }

    public String getSearchContent() {
        AppMethodBeat.i(105177);
        String obj = this.vhY.getText().toString();
        AppMethodBeat.o(105177);
        return obj;
    }

    private View ajs(String str) {
        AppMethodBeat.i(105178);
        int childCount = this.jXw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jXw.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                AppMethodBeat.o(105178);
                return childAt;
            }
        }
        AppMethodBeat.o(105178);
        return null;
    }

    public EditText getInputText() {
        return this.vhY;
    }

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        AppMethodBeat.i(105180);
        if (multiSelectContactView.jXw.getChildCount() != 0) {
            View childAt = multiSelectContactView.jXw.getChildAt(multiSelectContactView.jXw.getChildCount() - 1);
            if (multiSelectContactView.vih) {
                multiSelectContactView.c(childAt, true, false);
                multiSelectContactView.vih = false;
            } else {
                multiSelectContactView.vih = true;
                multiSelectContactView.djg();
                childAt.findViewById(R.id.e7u).setVisibility(0);
            }
            multiSelectContactView.vhY.requestFocus();
        }
        AppMethodBeat.o(105180);
    }
}
