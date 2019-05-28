package com.facebook.login.widget;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.C32004R;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ToolTipPopup.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LoginButton extends FacebookButtonBase {
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;
    private boolean confirmLogout;
    private String loginLogoutEventName = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    private LoginButtonProperties properties = new LoginButtonProperties();
    private boolean toolTipChecked;
    private long toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private Style toolTipStyle = Style.BLUE;

    protected class LoginClickListener implements OnClickListener {
        protected LoginClickListener() {
        }

        public void onClick(View view) {
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(92639);
            LoginButton.access$300(LoginButton.this, view);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (AccessToken.isCurrentAccessTokenActive()) {
                performLogout(LoginButton.this.getContext());
            } else {
                performLogin();
            }
            AppEventsLogger newLogger = AppEventsLogger.newLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            String str = "logging_in";
            if (currentAccessToken != null) {
                i = 0;
            } else {
                i = 1;
            }
            bundle.putInt(str, i);
            String str2 = "access_token_expired";
            if (!AccessToken.isCurrentAccessTokenActive()) {
                i2 = 0;
            }
            bundle.putInt(str2, i2);
            newLogger.logSdkEvent(LoginButton.this.loginLogoutEventName, null, bundle);
            AppMethodBeat.m2505o(92639);
        }

        /* Access modifiers changed, original: protected */
        public void performLogin() {
            AppMethodBeat.m2504i(92640);
            LoginManager loginManager = getLoginManager();
            if (LoginAuthorizationType.PUBLISH.equals(LoginButton.this.properties.authorizationType)) {
                if (LoginButton.this.getFragment() != null) {
                    loginManager.logInWithPublishPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.permissions);
                    AppMethodBeat.m2505o(92640);
                } else if (LoginButton.this.getNativeFragment() != null) {
                    loginManager.logInWithPublishPermissions(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions);
                    AppMethodBeat.m2505o(92640);
                } else {
                    loginManager.logInWithPublishPermissions(LoginButton.access$800(LoginButton.this), LoginButton.this.properties.permissions);
                    AppMethodBeat.m2505o(92640);
                }
            } else if (LoginButton.this.getFragment() != null) {
                loginManager.logInWithReadPermissions(LoginButton.this.getFragment(), LoginButton.this.properties.permissions);
                AppMethodBeat.m2505o(92640);
            } else if (LoginButton.this.getNativeFragment() != null) {
                loginManager.logInWithReadPermissions(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions);
                AppMethodBeat.m2505o(92640);
            } else {
                loginManager.logInWithReadPermissions(LoginButton.access$900(LoginButton.this), LoginButton.this.properties.permissions);
                AppMethodBeat.m2505o(92640);
            }
        }

        /* Access modifiers changed, original: protected */
        public void performLogout(Context context) {
            AppMethodBeat.m2504i(92641);
            final LoginManager loginManager = getLoginManager();
            if (LoginButton.this.confirmLogout) {
                CharSequence string;
                String string2 = LoginButton.this.getResources().getString(C25738R.string.f8623a5);
                String string3 = LoginButton.this.getResources().getString(C25738R.string.f8620a1);
                Profile currentProfile = Profile.getCurrentProfile();
                if (currentProfile == null || currentProfile.getName() == null) {
                    string = LoginButton.this.getResources().getString(C25738R.string.f8626a8);
                } else {
                    string = String.format(LoginButton.this.getResources().getString(C25738R.string.f8625a7), new Object[]{currentProfile.getName()});
                }
                Builder builder = new Builder(context);
                builder.setMessage(string).setCancelable(true).setPositiveButton(string2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(92638);
                        loginManager.logOut();
                        AppMethodBeat.m2505o(92638);
                    }
                }).setNegativeButton(string3, null);
                builder.create().show();
                AppMethodBeat.m2505o(92641);
                return;
            }
            loginManager.logOut();
            AppMethodBeat.m2505o(92641);
        }

        /* Access modifiers changed, original: protected */
        public LoginManager getLoginManager() {
            AppMethodBeat.m2504i(92642);
            LoginManager instance = LoginManager.getInstance();
            instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
            instance.setAuthType(LoginButton.this.getAuthType());
            AppMethodBeat.m2505o(92642);
            return instance;
        }
    }

    static class LoginButtonProperties {
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private LoginAuthorizationType authorizationType = null;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private List<String> permissions = Collections.emptyList();

        LoginButtonProperties() {
            AppMethodBeat.m2504i(92635);
            AppMethodBeat.m2505o(92635);
        }

        public void setDefaultAudience(DefaultAudience defaultAudience) {
            this.defaultAudience = defaultAudience;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public void setReadPermissions(List<String> list) {
            AppMethodBeat.m2504i(92636);
            if (LoginAuthorizationType.PUBLISH.equals(this.authorizationType)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
                AppMethodBeat.m2505o(92636);
                throw unsupportedOperationException;
            }
            this.permissions = list;
            this.authorizationType = LoginAuthorizationType.READ;
            AppMethodBeat.m2505o(92636);
        }

        public void setPublishPermissions(List<String> list) {
            AppMethodBeat.m2504i(92637);
            if (LoginAuthorizationType.READ.equals(this.authorizationType)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
                AppMethodBeat.m2505o(92637);
                throw unsupportedOperationException;
            } else if (Utility.isNullOrEmpty((Collection) list)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
                AppMethodBeat.m2505o(92637);
                throw illegalArgumentException;
            } else {
                this.permissions = list;
                this.authorizationType = LoginAuthorizationType.PUBLISH;
                AppMethodBeat.m2505o(92637);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public List<String> getPermissions() {
            return this.permissions;
        }

        public void clearPermissions() {
            this.permissions = null;
            this.authorizationType = null;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior) {
            this.loginBehavior = loginBehavior;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public String getAuthType() {
            return this.authType;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }
    }

    /* renamed from: com.facebook.login.widget.LoginButton$2 */
    class C320082 extends AccessTokenTracker {
        C320082() {
        }

        public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
            AppMethodBeat.m2504i(92633);
            LoginButton.access$200(LoginButton.this);
            AppMethodBeat.m2505o(92633);
        }
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode DEFAULT;
        private int intValue;
        private String stringValue;

        static {
            DEFAULT = AUTOMATIC;
            AppMethodBeat.m2505o(92646);
        }

        public static ToolTipMode fromInt(int i) {
            AppMethodBeat.m2504i(92645);
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i) {
                    AppMethodBeat.m2505o(92645);
                    return toolTipMode;
                }
            }
            AppMethodBeat.m2505o(92645);
            return null;
        }

        private ToolTipMode(String str, int i) {
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

    static /* synthetic */ void access$000(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        AppMethodBeat.m2504i(92681);
        loginButton.showToolTipPerSettings(fetchedAppSettings);
        AppMethodBeat.m2505o(92681);
    }

    static /* synthetic */ Activity access$100(LoginButton loginButton) {
        AppMethodBeat.m2504i(92682);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.m2505o(92682);
        return activity;
    }

    static /* synthetic */ void access$200(LoginButton loginButton) {
        AppMethodBeat.m2504i(92683);
        loginButton.setButtonText();
        AppMethodBeat.m2505o(92683);
    }

    static /* synthetic */ void access$300(LoginButton loginButton, View view) {
        AppMethodBeat.m2504i(92684);
        loginButton.callExternalOnClickListener(view);
        AppMethodBeat.m2505o(92684);
    }

    static /* synthetic */ Activity access$800(LoginButton loginButton) {
        AppMethodBeat.m2504i(92685);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.m2505o(92685);
        return activity;
    }

    static /* synthetic */ Activity access$900(LoginButton loginButton) {
        AppMethodBeat.m2504i(92686);
        Activity activity = loginButton.getActivity();
        AppMethodBeat.m2505o(92686);
        return activity;
    }

    static {
        AppMethodBeat.m2504i(92687);
        AppMethodBeat.m2505o(92687);
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.m2504i(92647);
        AppMethodBeat.m2505o(92647);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.m2504i(92648);
        AppMethodBeat.m2505o(92648);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        AppMethodBeat.m2504i(92649);
        AppMethodBeat.m2505o(92649);
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        AppMethodBeat.m2504i(92650);
        this.properties.setDefaultAudience(defaultAudience);
        AppMethodBeat.m2505o(92650);
    }

    public DefaultAudience getDefaultAudience() {
        AppMethodBeat.m2504i(92651);
        DefaultAudience defaultAudience = this.properties.getDefaultAudience();
        AppMethodBeat.m2505o(92651);
        return defaultAudience;
    }

    public void setReadPermissions(List<String> list) {
        AppMethodBeat.m2504i(92652);
        this.properties.setReadPermissions(list);
        AppMethodBeat.m2505o(92652);
    }

    public void setReadPermissions(String... strArr) {
        AppMethodBeat.m2504i(92653);
        this.properties.setReadPermissions(Arrays.asList(strArr));
        AppMethodBeat.m2505o(92653);
    }

    public void setPublishPermissions(List<String> list) {
        AppMethodBeat.m2504i(92654);
        this.properties.setPublishPermissions(list);
        AppMethodBeat.m2505o(92654);
    }

    public void setPublishPermissions(String... strArr) {
        AppMethodBeat.m2504i(92655);
        this.properties.setPublishPermissions(Arrays.asList(strArr));
        AppMethodBeat.m2505o(92655);
    }

    public void clearPermissions() {
        AppMethodBeat.m2504i(92656);
        this.properties.clearPermissions();
        AppMethodBeat.m2505o(92656);
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        AppMethodBeat.m2504i(92657);
        this.properties.setLoginBehavior(loginBehavior);
        AppMethodBeat.m2505o(92657);
    }

    public LoginBehavior getLoginBehavior() {
        AppMethodBeat.m2504i(92658);
        LoginBehavior loginBehavior = this.properties.getLoginBehavior();
        AppMethodBeat.m2505o(92658);
        return loginBehavior;
    }

    public String getAuthType() {
        AppMethodBeat.m2504i(92659);
        String authType = this.properties.getAuthType();
        AppMethodBeat.m2505o(92659);
        return authType;
    }

    public void setAuthType(String str) {
        AppMethodBeat.m2504i(92660);
        this.properties.setAuthType(str);
        AppMethodBeat.m2505o(92660);
    }

    public void setToolTipStyle(Style style) {
        this.toolTipStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.toolTipMode = toolTipMode;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public void dismissToolTip() {
        AppMethodBeat.m2504i(92661);
        if (this.toolTipPopup != null) {
            this.toolTipPopup.dismiss();
            this.toolTipPopup = null;
        }
        AppMethodBeat.m2505o(92661);
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.m2504i(92662);
        getLoginManager().registerCallback(callbackManager, facebookCallback);
        AppMethodBeat.m2505o(92662);
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        AppMethodBeat.m2504i(92663);
        getLoginManager().unregisterCallback(callbackManager);
        AppMethodBeat.m2505o(92663);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(92664);
        super.onAttachedToWindow();
        if (!(this.accessTokenTracker == null || this.accessTokenTracker.isTracking())) {
            this.accessTokenTracker.startTracking();
            setButtonText();
        }
        AppMethodBeat.m2505o(92664);
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(92665);
        super.onDraw(canvas);
        if (!(this.toolTipChecked || isInEditMode())) {
            this.toolTipChecked = true;
            checkToolTipSettings();
        }
        AppMethodBeat.m2505o(92665);
    }

    private void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        AppMethodBeat.m2504i(92666);
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayToolTip(fetchedAppSettings.getNuxContent());
        }
        AppMethodBeat.m2505o(92666);
    }

    private void displayToolTip(String str) {
        AppMethodBeat.m2504i(92667);
        this.toolTipPopup = new ToolTipPopup(str, this);
        this.toolTipPopup.setStyle(this.toolTipStyle);
        this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
        this.toolTipPopup.show();
        AppMethodBeat.m2505o(92667);
    }

    private void checkToolTipSettings() {
        AppMethodBeat.m2504i(92668);
        switch (this.toolTipMode) {
            case AUTOMATIC:
                final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                FacebookSdk.getExecutor().execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(92632);
                        final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                        LoginButton.access$100(LoginButton.this).runOnUiThread(new Runnable() {
                            public void run() {
                                AppMethodBeat.m2504i(92631);
                                LoginButton.access$000(LoginButton.this, queryAppSettings);
                                AppMethodBeat.m2505o(92631);
                            }
                        });
                        AppMethodBeat.m2505o(92632);
                    }
                });
                AppMethodBeat.m2505o(92668);
                return;
            case DISPLAY_ALWAYS:
                displayToolTip(getResources().getString(C25738R.string.f8632af));
                break;
        }
        AppMethodBeat.m2505o(92668);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(92669);
        super.onLayout(z, i, i2, i3, i4);
        setButtonText();
        AppMethodBeat.m2505o(92669);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(92670);
        super.onDetachedFromWindow();
        if (this.accessTokenTracker != null) {
            this.accessTokenTracker.stopTracking();
        }
        dismissToolTip();
        AppMethodBeat.m2505o(92670);
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(92671);
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            dismissToolTip();
        }
        AppMethodBeat.m2505o(92671);
    }

    /* Access modifiers changed, original: 0000 */
    public List<String> getPermissions() {
        AppMethodBeat.m2504i(92672);
        List permissions = this.properties.getPermissions();
        AppMethodBeat.m2505o(92672);
        return permissions;
    }

    /* Access modifiers changed, original: 0000 */
    public void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        AppMethodBeat.m2504i(92673);
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getNewLoginClickListener());
        parseLoginButtonAttributes(context, attributeSet, i, i2);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(C25738R.color.f11884km));
            this.loginText = "Continue with Facebook";
        } else {
            this.accessTokenTracker = new C320082();
        }
        setButtonText();
        setCompoundDrawablesWithIntrinsicBounds(C0589b.m1275g(getContext(), C25738R.drawable.f6619k1), null, null, null);
        AppMethodBeat.m2505o(92673);
    }

    /* Access modifiers changed, original: protected */
    public LoginClickListener getNewLoginClickListener() {
        AppMethodBeat.m2504i(92674);
        LoginClickListener loginClickListener = new LoginClickListener();
        AppMethodBeat.m2505o(92674);
        return loginClickListener;
    }

    public int getDefaultStyleResource() {
        return C25738R.style.f11401zb;
    }

    private void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        AppMethodBeat.m2504i(92675);
        this.toolTipMode = ToolTipMode.DEFAULT;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C32004R.styleable.com_facebook_login_view, i, i2);
        try {
            this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
            this.loginText = obtainStyledAttributes.getString(1);
            this.logoutText = obtainStyledAttributes.getString(2);
            this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(3, ToolTipMode.DEFAULT.getValue()));
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(92675);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int measureButtonWidth;
        AppMethodBeat.m2504i(92676);
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingBottom = getCompoundPaddingBottom() + (((int) Math.ceil((double) (Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top)))) + getCompoundPaddingTop());
        Resources resources = getResources();
        String str = this.loginText;
        if (str == null) {
            str = resources.getString(C25738R.string.f8622a3);
            measureButtonWidth = measureButtonWidth(str);
            if (resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                str = resources.getString(C25738R.string.f8621a2);
            }
        }
        measureButtonWidth = measureButtonWidth(str);
        str = this.logoutText;
        if (str == null) {
            str = resources.getString(C25738R.string.f8624a6);
        }
        setMeasuredDimension(resolveSize(Math.max(measureButtonWidth, measureButtonWidth(str)), i), compoundPaddingBottom);
        AppMethodBeat.m2505o(92676);
    }

    private int measureButtonWidth(String str) {
        AppMethodBeat.m2504i(92677);
        int measureTextWidth = (measureTextWidth(str) + (getCompoundPaddingLeft() + getCompoundDrawablePadding())) + getCompoundPaddingRight();
        AppMethodBeat.m2505o(92677);
        return measureTextWidth;
    }

    private void setButtonText() {
        AppMethodBeat.m2504i(92678);
        Resources resources = getResources();
        CharSequence charSequence;
        if (!isInEditMode() && AccessToken.isCurrentAccessTokenActive()) {
            if (this.logoutText != null) {
                charSequence = this.logoutText;
            } else {
                charSequence = resources.getString(C25738R.string.f8624a6);
            }
            setText(charSequence);
            AppMethodBeat.m2505o(92678);
        } else if (this.loginText != null) {
            setText(this.loginText);
            AppMethodBeat.m2505o(92678);
        } else {
            charSequence = resources.getString(C25738R.string.f8622a3);
            int width = getWidth();
            if (width != 0 && measureButtonWidth(charSequence) > width) {
                charSequence = resources.getString(C25738R.string.f8621a2);
            }
            setText(charSequence);
            AppMethodBeat.m2505o(92678);
        }
    }

    public int getDefaultRequestCode() {
        AppMethodBeat.m2504i(92679);
        int toRequestCode = RequestCodeOffset.Login.toRequestCode();
        AppMethodBeat.m2505o(92679);
        return toRequestCode;
    }

    /* Access modifiers changed, original: 0000 */
    public LoginManager getLoginManager() {
        AppMethodBeat.m2504i(92680);
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        LoginManager loginManager = this.loginManager;
        AppMethodBeat.m2505o(92680);
        return loginManager;
    }

    /* Access modifiers changed, original: 0000 */
    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }
}
