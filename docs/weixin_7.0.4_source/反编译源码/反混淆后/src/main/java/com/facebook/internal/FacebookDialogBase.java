package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.List;

public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    protected static final Object BASE_AUTOMATIC_MODE = new Object();
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private final FragmentWrapper fragmentWrapper;
    private List<ModeHandler> modeHandlers;
    private int requestCode;

    public abstract class ModeHandler {
        public abstract boolean canShow(CONTENT content, boolean z);

        public abstract AppCall createAppCall(CONTENT content);

        protected ModeHandler() {
        }

        public Object getMode() {
            return FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
    }

    public abstract AppCall createBaseAppCall();

    public abstract List<ModeHandler> getOrderedModeHandlers();

    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    protected FacebookDialogBase(Activity activity, int i) {
        Validate.notNull(activity, "activity");
        this.activity = activity;
        this.fragmentWrapper = null;
        this.requestCode = i;
    }

    protected FacebookDialogBase(FragmentWrapper fragmentWrapper, int i) {
        Validate.notNull(fragmentWrapper, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper;
        this.activity = null;
        this.requestCode = i;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
        }
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            registerCallbackImpl((CallbackManagerImpl) callbackManager, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> facebookCallback, int i) {
        setRequestCode(i);
        registerCallback(callbackManager, facebookCallback);
    }

    /* Access modifiers changed, original: protected */
    public void setRequestCode(int i) {
        if (FacebookSdk.isFacebookRequestCode(i)) {
            throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.requestCode = i;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* Access modifiers changed, original: protected */
    public boolean canShowImpl(CONTENT content, Object obj) {
        boolean z = obj == BASE_AUTOMATIC_MODE;
        for (ModeHandler modeHandler : cachedModeHandlers()) {
            if ((z || Utility.areObjectsEqual(modeHandler.getMode(), obj)) && modeHandler.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* Access modifiers changed, original: protected */
    public void showImpl(CONTENT content, Object obj) {
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode == null) {
            String str = "No code path should ever result in a null appCall";
            if (FacebookSdk.isDebugEnabled()) {
                throw new IllegalStateException(str);
            }
        } else if (this.fragmentWrapper != null) {
            DialogPresenter.present(createAppCallForMode, this.fragmentWrapper);
        } else {
            DialogPresenter.present(createAppCallForMode, this.activity);
        }
    }

    public Activity getActivityContext() {
        if (this.activity != null) {
            return this.activity;
        }
        if (this.fragmentWrapper != null) {
            return this.fragmentWrapper.getActivity();
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void startActivityForResult(Intent intent, int i) {
        String str = null;
        if (this.activity != null) {
            this.activity.startActivityForResult(intent, i);
        } else if (this.fragmentWrapper == null) {
            str = "Failed to find Activity or Fragment to startActivityForResult ";
        } else if (this.fragmentWrapper.getNativeFragment() != null) {
            this.fragmentWrapper.getNativeFragment().startActivityForResult(intent, i);
        } else if (this.fragmentWrapper.getSupportFragment() != null) {
            this.fragmentWrapper.getSupportFragment().startActivityForResult(intent, i);
        } else {
            str = "Failed to find Activity or Fragment to startActivityForResult ";
        }
        if (str != null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 6, getClass().getName(), str);
        }
    }

    private AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z;
        AppCall createAppCall;
        if (obj == BASE_AUTOMATIC_MODE) {
            z = true;
        } else {
            z = false;
        }
        for (ModeHandler modeHandler : cachedModeHandlers()) {
            if ((z || Utility.areObjectsEqual(modeHandler.getMode(), obj)) && modeHandler.canShow(content, true)) {
                try {
                    createAppCall = modeHandler.createAppCall(content);
                    break;
                } catch (FacebookException e) {
                    createAppCall = createBaseAppCall();
                    DialogPresenter.setupAppCallForValidationError(createAppCall, e);
                }
            }
        }
        createAppCall = null;
        if (createAppCall != null) {
            return createAppCall;
        }
        createAppCall = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(createAppCall);
        return createAppCall;
    }

    private List<ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        return this.modeHandlers;
    }
}
