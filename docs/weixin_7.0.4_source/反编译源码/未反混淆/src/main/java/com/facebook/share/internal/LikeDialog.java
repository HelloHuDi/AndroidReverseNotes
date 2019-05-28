package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LikeDialog extends FacebookDialogBase<LikeContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Like.toRequestCode();
    private static final String TAG = "LikeDialog";

    @Deprecated
    public static final class Result {
        private final Bundle bundle;

        public Result(Bundle bundle) {
            this.bundle = bundle;
        }

        public final Bundle getData() {
            return this.bundle;
        }
    }

    class WebFallbackHandler extends ModeHandler {
        private WebFallbackHandler() {
            super();
        }

        /* synthetic */ WebFallbackHandler(LikeDialog likeDialog, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean canShow(LikeContent likeContent, boolean z) {
            return false;
        }

        public AppCall createAppCall(LikeContent likeContent) {
            AppMethodBeat.i(97106);
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebFallbackDialog(createBaseAppCall, LikeDialog.access$200(likeContent), LikeDialog.access$300());
            AppMethodBeat.o(97106);
            return createBaseAppCall;
        }
    }

    class NativeHandler extends ModeHandler {
        private NativeHandler() {
            super();
        }

        /* synthetic */ NativeHandler(LikeDialog likeDialog, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean canShow(LikeContent likeContent, boolean z) {
            return false;
        }

        public AppCall createAppCall(final LikeContent likeContent) {
            AppMethodBeat.i(97103);
            AppCall createBaseAppCall = LikeDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    AppMethodBeat.i(97101);
                    Bundle access$200 = LikeDialog.access$200(likeContent);
                    AppMethodBeat.o(97101);
                    return access$200;
                }

                public Bundle getLegacyParameters() {
                    AppMethodBeat.i(97102);
                    Bundle bundle = new Bundle();
                    AppMethodBeat.o(97102);
                    return bundle;
                }
            }, LikeDialog.access$300());
            AppMethodBeat.o(97103);
            return createBaseAppCall;
        }
    }

    static /* synthetic */ Bundle access$200(LikeContent likeContent) {
        AppMethodBeat.i(97116);
        Bundle createParameters = createParameters(likeContent);
        AppMethodBeat.o(97116);
        return createParameters;
    }

    static /* synthetic */ DialogFeature access$300() {
        AppMethodBeat.i(97117);
        DialogFeature feature = getFeature();
        AppMethodBeat.o(97117);
        return feature;
    }

    static {
        AppMethodBeat.i(97118);
        AppMethodBeat.o(97118);
    }

    @Deprecated
    public static boolean canShowNativeDialog() {
        return false;
    }

    @Deprecated
    public static boolean canShowWebFallback() {
        return false;
    }

    @Deprecated
    public LikeDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public LikeDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(97109);
        AppMethodBeat.o(97109);
    }

    @Deprecated
    public LikeDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.i(97110);
        AppMethodBeat.o(97110);
    }

    @Deprecated
    public LikeDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    @Deprecated
    public void show(LikeContent likeContent) {
    }

    public AppCall createBaseAppCall() {
        AppMethodBeat.i(97111);
        AppCall appCall = new AppCall(getRequestCode());
        AppMethodBeat.o(97111);
        return appCall;
    }

    public List<ModeHandler> getOrderedModeHandlers() {
        AppMethodBeat.i(97112);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler(this, null));
        arrayList.add(new WebFallbackHandler(this, null));
        AppMethodBeat.o(97112);
        return arrayList;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.i(97113);
        final ResultProcessor anonymousClass1 = facebookCallback == null ? null : new ResultProcessor(facebookCallback) {
            public void onSuccess(AppCall appCall, Bundle bundle) {
                AppMethodBeat.i(97099);
                facebookCallback.onSuccess(new Result(bundle));
                AppMethodBeat.o(97099);
            }
        };
        callbackManagerImpl.registerCallback(getRequestCode(), new Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                AppMethodBeat.i(97100);
                boolean handleActivityResult = ShareInternalUtility.handleActivityResult(LikeDialog.this.getRequestCode(), i, intent, anonymousClass1);
                AppMethodBeat.o(97100);
                return handleActivityResult;
            }
        });
        AppMethodBeat.o(97113);
    }

    private static DialogFeature getFeature() {
        return LikeDialogFeature.LIKE_DIALOG;
    }

    private static Bundle createParameters(LikeContent likeContent) {
        AppMethodBeat.i(97114);
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.getObjectId());
        bundle.putString("object_type", likeContent.getObjectType());
        AppMethodBeat.o(97114);
        return bundle;
    }
}
