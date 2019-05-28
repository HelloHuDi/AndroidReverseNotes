package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDropdownView */
public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private Context mContext;
    private C39225b nid;
    private LinkedList<String> nie;
    private int nif = 0;
    private int nig = 0;
    private C39226a nih = null;
    private View nii = null;
    private OnClickListener nij = new C282481();

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDropdownView$1 */
    class C282481 implements OnClickListener {
        C282481() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111913);
            if (GameDropdownView.this.nid.getContentView() == null || !(GameDropdownView.this.nid.getContentView() instanceof ViewGroup)) {
                GameDropdownView.this.nid.dismiss();
                AppMethodBeat.m2505o(111913);
                return;
            }
            GameDropdownView.m66831a(GameDropdownView.this, ((ViewGroup) GameDropdownView.this.nid.getContentView()).indexOfChild(view));
            GameDropdownView.this.nid.dismiss();
            AppMethodBeat.m2505o(111913);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDropdownView$b */
    static class C39225b extends PopupWindow {

        /* renamed from: com.tencent.mm.plugin.game.ui.GameDropdownView$b$1 */
        class C392241 implements OnTouchListener {
            C392241() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(111914);
                if (motionEvent.getAction() == 4) {
                    C39225b.this.dismiss();
                    AppMethodBeat.m2505o(111914);
                    return true;
                }
                AppMethodBeat.m2505o(111914);
                return false;
            }
        }

        public C39225b(Context context) {
            super(context);
            AppMethodBeat.m2504i(111915);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new C392241());
            setAnimationStyle(C25738R.anim.f8338ba);
            AppMethodBeat.m2505o(111915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDropdownView$a */
    public interface C39226a {
        /* renamed from: wI */
        void mo62105wI(int i);
    }

    /* renamed from: a */
    static /* synthetic */ void m66831a(GameDropdownView gameDropdownView, int i) {
        AppMethodBeat.m2504i(111921);
        gameDropdownView.setCurrentSelection(i);
        AppMethodBeat.m2505o(111921);
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111916);
        this.mContext = context;
        this.nid = new C39225b(context);
        setOnClickListener(this);
        AppMethodBeat.m2505o(111916);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111917);
        super.onFinishInflate();
        setVisibility(8);
        AppMethodBeat.m2505o(111917);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111918);
        if (this.nid.isShowing()) {
            this.nid.dismiss();
            AppMethodBeat.m2505o(111918);
        } else if (this.nii == null) {
            this.nid.showAsDropDown(this);
            AppMethodBeat.m2505o(111918);
        } else {
            this.nid.showAsDropDown(this.nii);
            AppMethodBeat.m2505o(111918);
        }
    }

    public void onDismiss() {
    }

    public void setAnchorView(View view) {
        this.nii = view;
    }

    /* renamed from: e */
    public final void mo62099e(LinkedList<String> linkedList, int i) {
        AppMethodBeat.m2504i(111919);
        if (linkedList.size() == 0) {
            C4990ab.m7416i("MicroMsg.GameDropdownView", "No menu item");
            AppMethodBeat.m2505o(111919);
            return;
        }
        this.nie = linkedList;
        this.nig = linkedList.size() - 1;
        if (i < 0 || i > this.nig) {
            this.nif = 0;
        } else {
            this.nif = i;
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(2130969735, null);
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str = (String) linkedList.get(i2);
            TextView textView = (TextView) layoutInflater.inflate(2130969736, linearLayout, false);
            textView.setText(str);
            textView.setOnClickListener(this.nij);
            if (i2 == this.nif) {
                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
                setText(str);
            }
            linearLayout.addView(textView);
        }
        this.nid.setContentView(linearLayout);
        setVisibility(0);
        AppMethodBeat.m2505o(111919);
    }

    private void setCurrentSelection(int i) {
        AppMethodBeat.m2504i(111920);
        if (this.nid.getContentView() == null || !(this.nid.getContentView() instanceof ViewGroup)) {
            AppMethodBeat.m2505o(111920);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.nid.getContentView();
        if (i > this.nig || this.nif > this.nig || !(viewGroup.getChildAt(i) instanceof TextView) || !(viewGroup.getChildAt(this.nif) instanceof TextView)) {
            AppMethodBeat.m2505o(111920);
            return;
        }
        ((TextView) viewGroup.getChildAt(this.nif)).setTextColor(this.mContext.getResources().getColor(C25738R.color.f12092s0));
        ((TextView) viewGroup.getChildAt(i)).setTextColor(this.mContext.getResources().getColor(C25738R.color.f12212w4));
        setText((CharSequence) this.nie.get(i));
        if (!(this.nih == null || this.nif == i)) {
            this.nih.mo62105wI(i);
        }
        this.nif = i;
        AppMethodBeat.m2505o(111920);
    }

    public void setOnSelectionChangedListener(C39226a c39226a) {
        this.nih = c39226a;
    }
}
