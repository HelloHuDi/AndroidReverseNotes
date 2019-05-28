package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private Context mContext;
    private b nid;
    private LinkedList<String> nie;
    private int nif = 0;
    private int nig = 0;
    private a nih = null;
    private View nii = null;
    private OnClickListener nij = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(111913);
            if (GameDropdownView.this.nid.getContentView() == null || !(GameDropdownView.this.nid.getContentView() instanceof ViewGroup)) {
                GameDropdownView.this.nid.dismiss();
                AppMethodBeat.o(111913);
                return;
            }
            GameDropdownView.a(GameDropdownView.this, ((ViewGroup) GameDropdownView.this.nid.getContentView()).indexOfChild(view));
            GameDropdownView.this.nid.dismiss();
            AppMethodBeat.o(111913);
        }
    };

    static class b extends PopupWindow {
        public b(Context context) {
            super(context);
            AppMethodBeat.i(111915);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(111914);
                    if (motionEvent.getAction() == 4) {
                        b.this.dismiss();
                        AppMethodBeat.o(111914);
                        return true;
                    }
                    AppMethodBeat.o(111914);
                    return false;
                }
            });
            setAnimationStyle(R.anim.ba);
            AppMethodBeat.o(111915);
        }
    }

    public interface a {
        void wI(int i);
    }

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i) {
        AppMethodBeat.i(111921);
        gameDropdownView.setCurrentSelection(i);
        AppMethodBeat.o(111921);
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111916);
        this.mContext = context;
        this.nid = new b(context);
        setOnClickListener(this);
        AppMethodBeat.o(111916);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111917);
        super.onFinishInflate();
        setVisibility(8);
        AppMethodBeat.o(111917);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111918);
        if (this.nid.isShowing()) {
            this.nid.dismiss();
            AppMethodBeat.o(111918);
        } else if (this.nii == null) {
            this.nid.showAsDropDown(this);
            AppMethodBeat.o(111918);
        } else {
            this.nid.showAsDropDown(this.nii);
            AppMethodBeat.o(111918);
        }
    }

    public void onDismiss() {
    }

    public void setAnchorView(View view) {
        this.nii = view;
    }

    public final void e(LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(111919);
        if (linkedList.size() == 0) {
            ab.i("MicroMsg.GameDropdownView", "No menu item");
            AppMethodBeat.o(111919);
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
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.a4i, null);
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            String str = (String) linkedList.get(i2);
            TextView textView = (TextView) layoutInflater.inflate(R.layout.a4j, linearLayout, false);
            textView.setText(str);
            textView.setOnClickListener(this.nij);
            if (i2 == this.nif) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.w4));
                setText(str);
            }
            linearLayout.addView(textView);
        }
        this.nid.setContentView(linearLayout);
        setVisibility(0);
        AppMethodBeat.o(111919);
    }

    private void setCurrentSelection(int i) {
        AppMethodBeat.i(111920);
        if (this.nid.getContentView() == null || !(this.nid.getContentView() instanceof ViewGroup)) {
            AppMethodBeat.o(111920);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.nid.getContentView();
        if (i > this.nig || this.nif > this.nig || !(viewGroup.getChildAt(i) instanceof TextView) || !(viewGroup.getChildAt(this.nif) instanceof TextView)) {
            AppMethodBeat.o(111920);
            return;
        }
        ((TextView) viewGroup.getChildAt(this.nif)).setTextColor(this.mContext.getResources().getColor(R.color.s0));
        ((TextView) viewGroup.getChildAt(i)).setTextColor(this.mContext.getResources().getColor(R.color.w4));
        setText((CharSequence) this.nie.get(i));
        if (!(this.nih == null || this.nif == i)) {
            this.nih.wI(i);
        }
        this.nif = i;
        AppMethodBeat.o(111920);
    }

    public void setOnSelectionChangedListener(a aVar) {
        this.nih = aVar;
    }
}
