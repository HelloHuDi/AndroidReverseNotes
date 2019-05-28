package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import java.lang.ref.WeakReference;

public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private long mNuxDisplayTime = DEFAULT_POPUP_DISPLAY_TIME;
    private PopupContentView mPopupContent;
    private PopupWindow mPopupWindow;
    private final OnScrollChangedListener mScrollListener = new OnScrollChangedListener() {
        public void onScrollChanged() {
            AppMethodBeat.i(92711);
            if (!(ToolTipPopup.this.mAnchorViewRef.get() == null || ToolTipPopup.this.mPopupWindow == null || !ToolTipPopup.this.mPopupWindow.isShowing())) {
                if (ToolTipPopup.this.mPopupWindow.isAboveAnchor()) {
                    ToolTipPopup.this.mPopupContent.showBottomArrow();
                    AppMethodBeat.o(92711);
                    return;
                }
                ToolTipPopup.this.mPopupContent.showTopArrow();
            }
            AppMethodBeat.o(92711);
        }
    };
    private Style mStyle = Style.BLUE;
    private final String mText;

    class PopupContentView extends FrameLayout {
        private View bodyFrame;
        private ImageView bottomArrow;
        private ImageView topArrow;
        private ImageView xOut;

        public PopupContentView(Context context) {
            super(context);
            AppMethodBeat.i(92714);
            init();
            AppMethodBeat.o(92714);
        }

        private void init() {
            AppMethodBeat.i(92715);
            LayoutInflater.from(getContext()).inflate(R.layout.pb, this);
            this.topArrow = (ImageView) findViewById(R.id.azo);
            this.bottomArrow = (ImageView) findViewById(R.id.azr);
            this.bodyFrame = findViewById(R.id.azn);
            this.xOut = (ImageView) findViewById(R.id.azp);
            AppMethodBeat.o(92715);
        }

        public void showTopArrow() {
            AppMethodBeat.i(92716);
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
            AppMethodBeat.o(92716);
        }

        public void showBottomArrow() {
            AppMethodBeat.i(92717);
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
            AppMethodBeat.o(92717);
        }
    }

    public enum Style {
        BLUE,
        BLACK;

        static {
            AppMethodBeat.o(92720);
        }
    }

    public ToolTipPopup(String str, View view) {
        AppMethodBeat.i(92721);
        this.mText = str;
        this.mAnchorViewRef = new WeakReference(view);
        this.mContext = view.getContext();
        AppMethodBeat.o(92721);
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        AppMethodBeat.i(92722);
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new PopupContentView(this.mContext);
            ((TextView) this.mPopupContent.findViewById(R.id.azq)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.a_g);
                this.mPopupContent.bottomArrow.setImageResource(R.drawable.a_h);
                this.mPopupContent.topArrow.setImageResource(R.drawable.a_i);
                this.mPopupContent.xOut.setImageResource(R.drawable.a_j);
            } else {
                this.mPopupContent.bodyFrame.setBackgroundResource(R.drawable.a_c);
                this.mPopupContent.bottomArrow.setImageResource(R.drawable.a_d);
                this.mPopupContent.topArrow.setImageResource(R.drawable.a_e);
                this.mPopupContent.xOut.setImageResource(R.drawable.a_f);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(MeasureSpec.makeMeasureSpec(width, j.INVALID_ID), MeasureSpec.makeMeasureSpec(height, j.INVALID_ID));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown((View) this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(92712);
                        ToolTipPopup.this.dismiss();
                        AppMethodBeat.o(92712);
                    }
                }, this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(92713);
                    ToolTipPopup.this.dismiss();
                    AppMethodBeat.o(92713);
                }
            });
        }
        AppMethodBeat.o(92722);
    }

    public void setNuxDisplayTime(long j) {
        this.mNuxDisplayTime = j;
    }

    private void updateArrows() {
        AppMethodBeat.i(92723);
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.showBottomArrow();
                AppMethodBeat.o(92723);
                return;
            }
            this.mPopupContent.showTopArrow();
        }
        AppMethodBeat.o(92723);
    }

    public void dismiss() {
        AppMethodBeat.i(92724);
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
        AppMethodBeat.o(92724);
    }

    private void registerObserver() {
        AppMethodBeat.i(92725);
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.o(92725);
    }

    private void unregisterObserver() {
        AppMethodBeat.i(92726);
        if (this.mAnchorViewRef.get() != null) {
            ((View) this.mAnchorViewRef.get()).getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
        AppMethodBeat.o(92726);
    }
}
