package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.content.C37116d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.FacebookException;
import com.facebook.common.C25486R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeActionController.CreationCallback;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.share.internal.LikeButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

@Deprecated
public class LikeView extends FrameLayout {
    private static final int NO_FOREGROUND_COLOR = -1;
    private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    private LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private boolean explicitlyDisabled = true;
    private int foregroundColor = -1;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private Style likeViewStyle = Style.DEFAULT;
    private String objectId;
    private ObjectType objectType;
    private OnErrorListener onErrorListener;
    private FragmentWrapper parentFragment;
    private TextView socialSentenceView;

    class LikeControllerBroadcastReceiver extends BroadcastReceiver {
        private LikeControllerBroadcastReceiver() {
        }

        /* synthetic */ LikeControllerBroadcastReceiver(LikeView likeView, C176251 c176251) {
            this();
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = 1;
            AppMethodBeat.m2504i(97637);
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(LikeActionController.ACTION_OBJECT_ID_KEY);
                if (!(Utility.isNullOrEmpty(string) || Utility.areObjectsEqual(LikeView.this.objectId, string))) {
                    obj = null;
                }
            }
            if (obj == null) {
                AppMethodBeat.m2505o(97637);
            } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED.equals(action)) {
                LikeView.access$700(LikeView.this);
                AppMethodBeat.m2505o(97637);
            } else {
                if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR.equals(action)) {
                    if (LikeView.this.onErrorListener != null) {
                        LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(extras));
                        AppMethodBeat.m2505o(97637);
                        return;
                    }
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET.equals(action)) {
                    LikeView.access$1000(LikeView.this, LikeView.this.objectId, LikeView.this.objectType);
                    LikeView.access$700(LikeView.this);
                }
                AppMethodBeat.m2505o(97637);
            }
        }
    }

    @Deprecated
    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        static Style DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = STANDARD;
            AppMethodBeat.m2505o(97646);
        }

        static Style fromInt(int i) {
            AppMethodBeat.m2504i(97644);
            for (Style style : values()) {
                if (style.getValue() == i) {
                    AppMethodBeat.m2505o(97644);
                    return style;
                }
            }
            AppMethodBeat.m2505o(97644);
            return null;
        }

        private Style(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    class LikeActionControllerCreationCallback implements CreationCallback {
        private boolean isCancelled;

        private LikeActionControllerCreationCallback() {
        }

        /* synthetic */ LikeActionControllerCreationCallback(LikeView likeView, C176251 c176251) {
            this();
        }

        public void cancel() {
            this.isCancelled = true;
        }

        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            AppMethodBeat.m2504i(97636);
            if (this.isCancelled) {
                AppMethodBeat.m2505o(97636);
                return;
            }
            if (likeActionController != null) {
                if (!likeActionController.shouldEnableView()) {
                    facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                }
                LikeView.access$1100(LikeView.this, likeActionController);
                LikeView.access$700(LikeView.this);
            }
            if (!(facebookException == null || LikeView.this.onErrorListener == null)) {
                LikeView.this.onErrorListener.onError(facebookException);
            }
            LikeView.this.creationCallback = null;
            AppMethodBeat.m2505o(97636);
        }
    }

    @Deprecated
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE("page", 2);
        
        public static ObjectType DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = UNKNOWN;
            AppMethodBeat.m2505o(97641);
        }

        public static ObjectType fromInt(int i) {
            AppMethodBeat.m2504i(97640);
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i) {
                    AppMethodBeat.m2505o(97640);
                    return objectType;
                }
            }
            AppMethodBeat.m2505o(97640);
            return null;
        }

        private ObjectType(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    /* renamed from: com.facebook.share.widget.LikeView$1 */
    class C176251 implements OnClickListener {
        C176251() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(97624);
            LikeView.access$300(LikeView.this);
            AppMethodBeat.m2505o(97624);
        }
    }

    @Deprecated
    public enum AuxiliaryViewPosition {
        BOTTOM("bottom", 0),
        INLINE("inline", 1),
        TOP("top", 2);
        
        static AuxiliaryViewPosition DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = BOTTOM;
            AppMethodBeat.m2505o(97630);
        }

        static AuxiliaryViewPosition fromInt(int i) {
            AppMethodBeat.m2504i(97628);
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i) {
                    AppMethodBeat.m2505o(97628);
                    return auxiliaryViewPosition;
                }
            }
            AppMethodBeat.m2505o(97628);
            return null;
        }

        private AuxiliaryViewPosition(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT("left", 1),
        RIGHT("right", 2);
        
        static HorizontalAlignment DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = CENTER;
            AppMethodBeat.m2505o(97635);
        }

        static HorizontalAlignment fromInt(int i) {
            AppMethodBeat.m2504i(97633);
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i) {
                    AppMethodBeat.m2505o(97633);
                    return horizontalAlignment;
                }
            }
            AppMethodBeat.m2505o(97633);
            return null;
        }

        private HorizontalAlignment(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public final String toString() {
            return this.stringValue;
        }

        private int getValue() {
            return this.intValue;
        }
    }

    static /* synthetic */ void access$1000(LikeView likeView, String str, ObjectType objectType) {
        AppMethodBeat.m2504i(97674);
        likeView.setObjectIdAndTypeForced(str, objectType);
        AppMethodBeat.m2505o(97674);
    }

    static /* synthetic */ void access$1100(LikeView likeView, LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97675);
        likeView.associateWithLikeActionController(likeActionController);
        AppMethodBeat.m2505o(97675);
    }

    static /* synthetic */ void access$300(LikeView likeView) {
        AppMethodBeat.m2504i(97672);
        likeView.toggleLike();
        AppMethodBeat.m2505o(97672);
    }

    static /* synthetic */ void access$700(LikeView likeView) {
        AppMethodBeat.m2504i(97673);
        likeView.updateLikeStateAndLayout();
        AppMethodBeat.m2505o(97673);
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        AppMethodBeat.m2504i(97647);
        initialize(context);
        AppMethodBeat.m2505o(97647);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(97648);
        parseAttributes(attributeSet);
        initialize(context);
        AppMethodBeat.m2505o(97648);
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType) {
        AppMethodBeat.m2504i(97649);
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        if (objectType == null) {
            objectType = ObjectType.DEFAULT;
        }
        if (!(Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.objectId) && objectType == this.objectType)) {
            setObjectIdAndTypeForced(coerceValueIfNullOrEmpty, objectType);
            updateLikeStateAndLayout();
        }
        AppMethodBeat.m2505o(97649);
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        AppMethodBeat.m2504i(97650);
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.likeViewStyle != style) {
            this.likeViewStyle = style;
            updateLayout();
        }
        AppMethodBeat.m2505o(97650);
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        AppMethodBeat.m2504i(97651);
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.auxiliaryViewPosition != auxiliaryViewPosition) {
            this.auxiliaryViewPosition = auxiliaryViewPosition;
            updateLayout();
        }
        AppMethodBeat.m2505o(97651);
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        AppMethodBeat.m2504i(97652);
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.DEFAULT;
        }
        if (this.horizontalAlignment != horizontalAlignment) {
            this.horizontalAlignment = horizontalAlignment;
            updateLayout();
        }
        AppMethodBeat.m2505o(97652);
    }

    @Deprecated
    public void setForegroundColor(int i) {
        AppMethodBeat.m2504i(97653);
        if (this.foregroundColor != i) {
            this.socialSentenceView.setTextColor(i);
        }
        AppMethodBeat.m2505o(97653);
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    @Deprecated
    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        AppMethodBeat.m2504i(97654);
        this.parentFragment = new FragmentWrapper(fragment);
        AppMethodBeat.m2505o(97654);
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        AppMethodBeat.m2504i(97655);
        this.parentFragment = new FragmentWrapper(fragment);
        AppMethodBeat.m2505o(97655);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(97656);
        this.explicitlyDisabled = true;
        updateLikeStateAndLayout();
        AppMethodBeat.m2505o(97656);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(97657);
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(97657);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        AppMethodBeat.m2504i(97658);
        if (attributeSet == null || getContext() == null) {
            AppMethodBeat.m2505o(97658);
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C25486R.styleable.com_facebook_like_view);
        if (obtainStyledAttributes == null) {
            AppMethodBeat.m2505o(97658);
            return;
        }
        this.objectId = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(1), null);
        this.objectType = ObjectType.fromInt(obtainStyledAttributes.getInt(2, ObjectType.DEFAULT.getValue()));
        this.likeViewStyle = Style.fromInt(obtainStyledAttributes.getInt(3, Style.access$000(Style.DEFAULT)));
        IllegalArgumentException illegalArgumentException;
        if (this.likeViewStyle == null) {
            illegalArgumentException = new IllegalArgumentException("Unsupported value for LikeView 'style'");
            AppMethodBeat.m2505o(97658);
            throw illegalArgumentException;
        }
        this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(4, AuxiliaryViewPosition.access$100(AuxiliaryViewPosition.DEFAULT)));
        if (this.auxiliaryViewPosition == null) {
            illegalArgumentException = new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            AppMethodBeat.m2505o(97658);
            throw illegalArgumentException;
        }
        this.horizontalAlignment = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(5, HorizontalAlignment.access$200(HorizontalAlignment.DEFAULT)));
        if (this.horizontalAlignment == null) {
            illegalArgumentException = new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
            AppMethodBeat.m2505o(97658);
            throw illegalArgumentException;
        }
        this.foregroundColor = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(97658);
    }

    private void initialize(Context context) {
        AppMethodBeat.m2504i(97659);
        this.edgePadding = getResources().getDimensionPixelSize(C25738R.dimen.f10315xp);
        this.internalPadding = getResources().getDimensionPixelSize(C25738R.dimen.f10316xq);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(C25738R.color.f11898l0);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(context);
        this.containerView.setLayoutParams(new LayoutParams(-2, -2));
        initializeLikeButton(context);
        initializeSocialSentenceView(context);
        initializeLikeCountView(context);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdAndTypeForced(this.objectId, this.objectType);
        updateLikeStateAndLayout();
        AppMethodBeat.m2505o(97659);
    }

    private void initializeLikeButton(Context context) {
        AppMethodBeat.m2504i(97660);
        boolean z = this.likeActionController != null && this.likeActionController.isObjectLiked();
        this.likeButton = new LikeButton(context, z);
        this.likeButton.setOnClickListener(new C176251());
        this.likeButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AppMethodBeat.m2505o(97660);
    }

    private void initializeSocialSentenceView(Context context) {
        AppMethodBeat.m2504i(97661);
        this.socialSentenceView = new TextView(context);
        this.socialSentenceView.setTextSize(0, getResources().getDimension(C25738R.dimen.f10317xr));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        this.socialSentenceView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        AppMethodBeat.m2505o(97661);
    }

    private void initializeLikeCountView(Context context) {
        AppMethodBeat.m2504i(97662);
        this.likeBoxCountView = new LikeBoxCountView(context);
        this.likeBoxCountView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        AppMethodBeat.m2505o(97662);
    }

    private void toggleLike() {
        AppMethodBeat.m2504i(97663);
        if (this.likeActionController != null) {
            Activity activity = null;
            if (this.parentFragment == null) {
                activity = getActivity();
            }
            this.likeActionController.toggleLike(activity, this.parentFragment, getAnalyticsParameters());
        }
        AppMethodBeat.m2505o(97663);
    }

    private Activity getActivity() {
        AppMethodBeat.m2504i(97664);
        Context context = getContext();
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            AppMethodBeat.m2505o(97664);
            return activity;
        }
        FacebookException facebookException = new FacebookException("Unable to get Activity.");
        AppMethodBeat.m2505o(97664);
        throw facebookException;
    }

    private Bundle getAnalyticsParameters() {
        AppMethodBeat.m2504i(97665);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.likeViewStyle.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_AUXILIARY_POSITION, this.auxiliaryViewPosition.toString());
        bundle.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_HORIZONTAL_ALIGNMENT, this.horizontalAlignment.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        bundle.putString("object_type", this.objectType.toString());
        AppMethodBeat.m2505o(97665);
        return bundle;
    }

    private void setObjectIdAndTypeForced(String str, ObjectType objectType) {
        AppMethodBeat.m2504i(97666);
        tearDownObjectAssociations();
        this.objectId = str;
        this.objectType = objectType;
        if (Utility.isNullOrEmpty(str)) {
            AppMethodBeat.m2505o(97666);
            return;
        }
        this.creationCallback = new LikeActionControllerCreationCallback(this, null);
        if (!isInEditMode()) {
            LikeActionController.getControllerForObjectId(str, objectType, this.creationCallback);
        }
        AppMethodBeat.m2505o(97666);
    }

    private void associateWithLikeActionController(LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97667);
        this.likeActionController = likeActionController;
        this.broadcastReceiver = new LikeControllerBroadcastReceiver(this, null);
        C37116d S = C37116d.m62125S(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        S.mo59171a(this.broadcastReceiver, intentFilter);
        AppMethodBeat.m2505o(97667);
    }

    private void tearDownObjectAssociations() {
        AppMethodBeat.m2504i(97668);
        if (this.broadcastReceiver != null) {
            C37116d.m62125S(getContext()).unregisterReceiver(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        if (this.creationCallback != null) {
            this.creationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
        AppMethodBeat.m2505o(97668);
    }

    private void updateLikeStateAndLayout() {
        AppMethodBeat.m2504i(97669);
        boolean z = !this.explicitlyDisabled;
        if (this.likeActionController == null) {
            this.likeButton.setSelected(false);
            this.socialSentenceView.setText(null);
            this.likeBoxCountView.setText(null);
        } else {
            this.likeButton.setSelected(this.likeActionController.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
            z &= this.likeActionController.shouldEnableView();
        }
        super.setEnabled(z);
        this.likeButton.setEnabled(z);
        updateLayout();
        AppMethodBeat.m2505o(97669);
    }

    private void updateLayout() {
        View view;
        int i = 1;
        AppMethodBeat.m2504i(97670);
        LayoutParams layoutParams = (LayoutParams) this.containerView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        int i2 = this.horizontalAlignment == HorizontalAlignment.LEFT ? 3 : this.horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i2 | 48;
        layoutParams2.gravity = i2;
        this.socialSentenceView.setVisibility(8);
        this.likeBoxCountView.setVisibility(8);
        if (this.likeViewStyle == Style.STANDARD && this.likeActionController != null && !Utility.isNullOrEmpty(this.likeActionController.getSocialSentence())) {
            view = this.socialSentenceView;
        } else if (this.likeViewStyle != Style.BOX_COUNT || this.likeActionController == null || Utility.isNullOrEmpty(this.likeActionController.getLikeCountString())) {
            AppMethodBeat.m2505o(97670);
            return;
        } else {
            updateBoxCountCaretPosition();
            view = this.likeBoxCountView;
        }
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i2;
        LinearLayout linearLayout = this.containerView;
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) {
            i = 0;
        }
        linearLayout.setOrientation(i);
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.TOP || (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE && this.horizontalAlignment == HorizontalAlignment.RIGHT)) {
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        } else {
            this.containerView.removeView(view);
            this.containerView.addView(view);
        }
        switch (this.auxiliaryViewPosition) {
            case TOP:
                view.setPadding(this.edgePadding, this.edgePadding, this.edgePadding, this.internalPadding);
                AppMethodBeat.m2505o(97670);
                return;
            case BOTTOM:
                view.setPadding(this.edgePadding, this.internalPadding, this.edgePadding, this.edgePadding);
                AppMethodBeat.m2505o(97670);
                return;
            case INLINE:
                if (this.horizontalAlignment != HorizontalAlignment.RIGHT) {
                    view.setPadding(this.internalPadding, this.edgePadding, this.edgePadding, this.edgePadding);
                    break;
                }
                view.setPadding(this.edgePadding, this.edgePadding, this.internalPadding, this.edgePadding);
                AppMethodBeat.m2505o(97670);
                return;
        }
        AppMethodBeat.m2505o(97670);
    }

    private void updateBoxCountCaretPosition() {
        LikeBoxCountView likeBoxCountView;
        LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition;
        AppMethodBeat.m2504i(97671);
        switch (this.auxiliaryViewPosition) {
            case TOP:
                likeBoxCountView = this.likeBoxCountView;
                likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.BOTTOM;
                break;
            case BOTTOM:
                likeBoxCountView = this.likeBoxCountView;
                likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.TOP;
                break;
            case INLINE:
                likeBoxCountView = this.likeBoxCountView;
                if (this.horizontalAlignment != HorizontalAlignment.RIGHT) {
                    likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.LEFT;
                    break;
                } else {
                    likeBoxCountViewCaretPosition = LikeBoxCountViewCaretPosition.RIGHT;
                    break;
                }
            default:
                AppMethodBeat.m2505o(97671);
        }
        likeBoxCountView.setCaretPosition(likeBoxCountViewCaretPosition);
        AppMethodBeat.m2505o(97671);
    }
}
