package com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class PopDialog extends Dialog {
    public static final int DIALOG_STYLE_MUL_BTN = 2;
    public static final int DIALOG_STYLE_SINGLE_BTN = 1;
    protected static final String TAG = "PopDialog";
    protected RelativeLayout contentLayout = null;
    protected TextView contentView = null;
    public ProgressBar downloadProgressBar = null;
    public TextView downloadText = null;
    protected Context mContext = null;
    private Button negativeBtn = null;
    protected Button positiveBtn = null;
    protected FrameLayout positiveLayout = null;
    public Res rTool = null;
    protected int style = 0;
    protected TextView titleView = null;

    public PopDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public PopDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public PopDialog(Context context, int i, int i2) {
        super(context, i);
        this.mContext = context;
        this.style = i2;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(75954);
        super.onCreate(bundle);
        this.rTool = new Res(this.mContext);
        super.setContentView(this.rTool.layout("com_tencent_tmassistant_sdk_white_list_dlg"));
        super.getWindow().setLayout(m25180px(662), m25180px(662));
        setCancelable(false);
        this.titleView = (TextView) findViewById(this.rTool.mo65235id("dlg_title_tv"));
        this.contentLayout = (RelativeLayout) findViewById(this.rTool.mo65235id(C8741b.CONTENT));
        this.contentView = (TextView) findViewById(this.rTool.mo65235id("dlg_body_tv"));
        this.positiveBtn = (Button) findViewById(this.rTool.mo65235id("positive_btn"));
        this.positiveLayout = (FrameLayout) findViewById(this.rTool.mo65235id("positive_btn_frame_layout"));
        this.downloadProgressBar = (ProgressBar) findViewById(this.rTool.mo65235id("download_pb"));
        this.downloadText = (TextView) findViewById(this.rTool.mo65235id("progress_txt_tv"));
        this.negativeBtn = (Button) findViewById(this.rTool.mo65235id("negtive_btn"));
        relayoutView();
        AppMethodBeat.m2505o(75954);
    }

    private void relayoutView() {
        AppMethodBeat.m2504i(75955);
        initHeaderView();
        switch (this.style) {
            case 1:
                initSingleDialog();
                AppMethodBeat.m2505o(75955);
                return;
            case 2:
                initMulDialog();
                break;
        }
        AppMethodBeat.m2505o(75955);
    }

    private void initHeaderView() {
        AppMethodBeat.m2504i(75956);
        this.titleView.setPadding(m25180px(30), 0, m25180px(30), 0);
        this.contentLayout.setPadding(m25180px(30), 0, m25180px(30), m25180px(30));
        this.contentView.setPadding(0, m25180px(30), 0, m25180px(30));
        AppMethodBeat.m2505o(75956);
    }

    private void initSingleDialog() {
        AppMethodBeat.m2504i(75957);
        this.positiveLayout.setVisibility(8);
        this.negativeBtn.setHeight(m25180px(78));
        this.negativeBtn.setText(this.mContext.getString(this.rTool.string("white_list_submit")));
        AppMethodBeat.m2505o(75957);
    }

    private void initMulDialog() {
        AppMethodBeat.m2504i(75958);
        this.negativeBtn.setHeight(m25180px(78));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.negativeBtn.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, m25180px(30), 0);
        this.negativeBtn.setLayoutParams(marginLayoutParams);
        this.positiveBtn.setHeight(m25180px(78));
        this.positiveBtn.setTextSize((float) m25180px(30));
        this.downloadProgressBar.setMinimumHeight(m25180px(78));
        this.downloadText.setHeight(m25180px(78));
        AppMethodBeat.m2505o(75958);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(75959);
        if (!TextUtils.isEmpty(str)) {
            this.titleView.setText(str);
        }
        AppMethodBeat.m2505o(75959);
    }

    public void setContent(String str) {
        AppMethodBeat.m2504i(75960);
        if (!TextUtils.isEmpty(str)) {
            this.contentView.setText(str);
        }
        AppMethodBeat.m2505o(75960);
    }

    public void setPositiveBtnTag(ActionButton actionButton) {
        AppMethodBeat.m2504i(75961);
        if (actionButton != null) {
            this.positiveBtn.setTag(actionButton);
        }
        AppMethodBeat.m2505o(75961);
    }

    public void setPositiveBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(75962);
        if (onClickListener != null) {
            this.positiveBtn.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(75962);
    }

    public void setPositiveBtnText(String str) {
        AppMethodBeat.m2504i(75963);
        if (!TextUtils.isEmpty(str)) {
            this.downloadText.setText(str);
        }
        AppMethodBeat.m2505o(75963);
    }

    public void setPositiveBtnBgResource(int i) {
        AppMethodBeat.m2504i(75964);
        if (i != 0) {
            this.positiveBtn.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(75964);
    }

    public void setPositiveBtnEnable(boolean z) {
        AppMethodBeat.m2504i(75965);
        if (this.positiveBtn != null) {
            this.positiveBtn.setEnabled(z);
        }
        AppMethodBeat.m2505o(75965);
    }

    public void setNegativeBtnText(String str) {
        AppMethodBeat.m2504i(75966);
        if (!TextUtils.isEmpty(str)) {
            this.negativeBtn.setText(str);
        }
        AppMethodBeat.m2505o(75966);
    }

    public void setNegativeBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(75967);
        if (onClickListener != null) {
            this.negativeBtn.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(75967);
    }

    public int getScreenWidth() {
        AppMethodBeat.m2504i(75968);
        if (this.mContext != null) {
            int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            AppMethodBeat.m2505o(75968);
            return i;
        }
        AppMethodBeat.m2505o(75968);
        return 0;
    }

    public int getScreenHeight() {
        AppMethodBeat.m2504i(75969);
        if (this.mContext != null) {
            int i = this.mContext.getResources().getDisplayMetrics().heightPixels;
            AppMethodBeat.m2505o(75969);
            return i;
        }
        AppMethodBeat.m2505o(75969);
        return 0;
    }

    /* renamed from: px */
    private int m25180px(int i) {
        AppMethodBeat.m2504i(75970);
        int screenHeight = getScreenHeight();
        int screenWidth = getScreenWidth();
        TMLog.m60588i(TAG, " width = " + screenWidth + "  height = " + screenHeight);
        if (screenHeight <= screenWidth) {
            screenHeight = screenWidth;
        }
        screenHeight = (int) (((((float) screenHeight) + 0.0f) * ((float) i)) / 1280.0f);
        TMLog.m60588i(TAG, "rtn" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + screenHeight);
        AppMethodBeat.m2505o(75970);
        return screenHeight;
    }
}
