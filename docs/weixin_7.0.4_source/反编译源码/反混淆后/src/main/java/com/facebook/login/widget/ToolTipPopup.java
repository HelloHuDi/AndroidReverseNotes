package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = DEFAULT_POPUP_DISPLAY_TIME;
    private PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final OnScrollChangedListener mScrollListener = new C254931();
    private Style mStyle = Style.BLUE;
    private final String mText;

    class PopupContentView extends FrameLayout {
        private View bodyFrame;
        private ImageView bottomArrow;
        private ImageView topArrow;
        private ImageView xOut;

        public PopupContentView(Context context) {
            super(context);
            AppMethodBeat.m2504i(92714);
            init();
            AppMethodBeat.m2505o(92714);
        }

        private void init() {
            AppMethodBeat.m2504i(92715);
            LayoutInflater.from(getContext()).inflate(2130969171, this);
            this.topArrow = (ImageView) findViewById(2131822900);
            this.bottomArrow = (ImageView) findViewById(2131822903);
            this.bodyFrame = findViewById(2131822899);
            this.xOut = (ImageView) findViewById(2131822901);
            AppMethodBeat.m2505o(92715);
        }

        public void showTopArrow() {
            AppMethodBeat.m2504i(92716);
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
            AppMethodBeat.m2505o(92716);
        }

        public void showBottomArrow() {
            AppMethodBeat.m2504i(92717);
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
            AppMethodBeat.m2505o(92717);
        }
    }

    /* renamed from: com.facebook.login.widget.ToolTipPopup$2 */
    class C86112 implements Runnable {
        C86112() {
        }

        public void run() {
            AppMethodBeat.m2504i(92712);
            ToolTipPopup.this.dismiss();
            AppMethodBeat.m2505o(92712);
        }
    }

    /* renamed from: com.facebook.login.widget.ToolTipPopup$1 */
    class C254931 implements OnScrollChangedListener {
        C254931() {
        }

        public void onScrollChanged() {
            AppMethodBeat.m2504i(92711);
            if (!(ToolTipPopup.this.mAnchorViewRef.get() == null || ToolTipPopup.this.mPopupWindow == null || !ToolTipPopup.this.mPopupWindow.isShowing())) {
                if (ToolTipPopup.this.mPopupWindow.isAboveAnchor()) {
                    ToolTipPopup.this.mPopupContent.showBottomArrow();
                    AppMethodBeat.m2505o(92711);
                    return;
                }
                ToolTipPopup.this.mPopupContent.showTopArrow();
            }
            AppMethodBeat.m2505o(92711);
        }
    }

    /* renamed from: com.facebook.login.widget.ToolTipPopup$3 */
    class C254943 implements OnClickListener {
        C254943() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(92713);
            ToolTipPopup.this.dismiss();
            AppMethodBeat.m2505o(92713);
        }
    }

    public enum Style {
        BLUE,
        BLACK;

        static {
            AppMethodBeat.m2505o(92720);
        }
    }

    public ToolTipPopup(String str, View view) {
        AppMethodBeat.m2504i(92721);
        this.mText = str;
        this.mAnchorViewRef = new WeakReference(view);
        this.mContext = view.getContext();
        AppMethodBeat.m2505o(92721);
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        AppMethodBeat.m2504i(92722);
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new PopupContentView(this.mContext);
            ((TextView) this.mPopupContent.findViewById(2131822902)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.bodyFrame.setBackgroundResource(C25738R.drawable.a_g);
                this.mPopupContent.bottomArrow.setImageResource(C25738R.drawable.a_h);
                this.mPopupContent.topArrow.setImageResource(C25738R.drawable.a_i);
                this.mPopupContent.xOut.setImageResource(C25738R.drawable.a_j);
            } else {
                this.mPopupContent.bodyFrame.setBackgroundResource(C25738R.drawable.a_c);
                this.mPopupContent.bottomArrow.setImageResource(C25738R.drawable.a_d);
                this.mPopupContent.topArrow.setImageResource(C25738R.drawable.a_e);
                this.mPopupContent.xOut.setImageResource(C25738R.drawable.a_f);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(MeasureSpec.makeMeasureSpec(width, C8415j.INVALID_ID), MeasureSpec.makeMeasureSpec(height, C8415j.INVALID_ID));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown((View) this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new C86112(), this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new C254943());
        }
        AppMethodBeat.m2505o(92722);
    }

    public void setNuxDisplayTime(long j) {
        this.mNuxDisplayTime = j;
    }

    private void updateArrows() {
        AppMethodBeat.m2504i(92723);
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.showBottomArrow();
                AppMethodBeat.m2505o(92723);
                return;
            }
            this.mPopupContent.showTopArrow();
        }
        AppMethodBeat.m2505o(92723);
    }

    public void dismiss() {
        AppMethodBeat.m2504i(92724);
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
        AppMethodBeat.m2505o(92724);
    }

    private void registerObserver() {
        AppMethodBeat.m2504i(92725);
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.m2505o(92725);
    }

    private void unregisterObserver() {
        AppMethodBeat.m2504i(92726);
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.m2505o(92726);
    }
}
