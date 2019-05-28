package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog extends FacebookDialogBase<ShareContent, Result> implements Sharer {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Share.toRequestCode();
    private static final String FEED_DIALOG = "feed";
    private static final String TAG = ShareDialog.class.getSimpleName();
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private boolean shouldFailOnDataError;

    class ShareStoryHandler extends ModeHandler {
        private ShareStoryHandler() {
            super();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.m2504i(97697);
            if ((shareContent instanceof ShareStoryContent) && ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.m2505o(97697);
                return true;
            }
            AppMethodBeat.m2505o(97697);
            return false;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.m2504i(97698);
            ShareContentValidation.validateForStoryShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    AppMethodBeat.m2504i(97695);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97695);
                    return create;
                }

                public Bundle getLegacyParameters() {
                    AppMethodBeat.m2504i(97696);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97696);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.m2505o(97698);
            return createBaseAppCall;
        }
    }

    class WebShareHandler extends ModeHandler {
        private WebShareHandler() {
            super();
        }

        public Object getMode() {
            return Mode.WEB;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.m2504i(97701);
            if (shareContent == null || !ShareDialog.access$900(shareContent)) {
                AppMethodBeat.m2505o(97701);
                return false;
            }
            AppMethodBeat.m2505o(97701);
            return true;
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle create;
            AppMethodBeat.m2504i(97702);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1000(ShareDialog.this), shareContent, Mode.WEB);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                create = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                create = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId()));
            } else {
                create = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), create);
            AppMethodBeat.m2505o(97702);
            return createBaseAppCall;
        }

        private String getActionName(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return "share";
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return ShareDialog.WEB_OG_SHARE_DIALOG;
            }
            return null;
        }

        private SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            AppMethodBeat.m2504i(97703);
            Builder readFrom = new Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < sharePhotoContent.getPhotos().size()) {
                    Object obj = (SharePhoto) sharePhotoContent.getPhotos().get(i2);
                    Bitmap bitmap = obj.getBitmap();
                    if (bitmap != null) {
                        Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                        obj = new SharePhoto.Builder().readFrom((SharePhoto) obj).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                        arrayList2.add(createAttachment);
                    }
                    arrayList.add(obj);
                    i = i2 + 1;
                } else {
                    readFrom.setPhotos(arrayList);
                    NativeAppCallAttachmentStore.addAttachments(arrayList2);
                    SharePhotoContent build = readFrom.build();
                    AppMethodBeat.m2505o(97703);
                    return build;
                }
            }
        }
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED;

        static {
            AppMethodBeat.m2505o(97688);
        }
    }

    class CameraEffectHandler extends ModeHandler {
        private CameraEffectHandler() {
            super();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.m2504i(97679);
            if ((shareContent instanceof ShareCameraEffectContent) && ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.m2505o(97679);
                return true;
            }
            AppMethodBeat.m2505o(97679);
            return false;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.m2504i(97680);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    AppMethodBeat.m2504i(97677);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97677);
                    return create;
                }

                public Bundle getLegacyParameters() {
                    AppMethodBeat.m2504i(97678);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97678);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.m2505o(97680);
            return createBaseAppCall;
        }
    }

    class FeedHandler extends ModeHandler {
        private FeedHandler() {
            super();
        }

        public Object getMode() {
            return Mode.FEED;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle createForFeed;
            AppMethodBeat.m2504i(97683);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1100(ShareDialog.this), shareContent, Mode.FEED);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.validateForWebShare(shareLinkContent);
                createForFeed = WebDialogParameters.createForFeed(shareLinkContent);
            } else {
                createForFeed = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, ShareDialog.FEED_DIALOG, createForFeed);
            AppMethodBeat.m2505o(97683);
            return createBaseAppCall;
        }
    }

    class NativeHandler extends ModeHandler {
        private NativeHandler() {
            super();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            AppMethodBeat.m2504i(97691);
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                AppMethodBeat.m2505o(97691);
                return false;
            }
            int i;
            if (z) {
                i = 1;
            } else {
                if (shareContent.getShareHashtag() != null) {
                    i = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
                } else {
                    i = 1;
                }
                if ((shareContent instanceof ShareLinkContent) && !Utility.isNullOrEmpty(((ShareLinkContent) shareContent).getQuote())) {
                    i &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            }
            if (i == 0 || !ShareDialog.access$500(shareContent.getClass())) {
                AppMethodBeat.m2505o(97691);
                return false;
            }
            AppMethodBeat.m2505o(97691);
            return true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            AppMethodBeat.m2504i(97692);
            ShareDialog.access$700(ShareDialog.this, ShareDialog.access$600(ShareDialog.this), shareContent, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    AppMethodBeat.m2504i(97689);
                    Bundle create = NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97689);
                    return create;
                }

                public Bundle getLegacyParameters() {
                    AppMethodBeat.m2504i(97690);
                    Bundle create = LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                    AppMethodBeat.m2505o(97690);
                    return create;
                }
            }, ShareDialog.access$800(shareContent.getClass()));
            AppMethodBeat.m2505o(97692);
            return createBaseAppCall;
        }
    }

    static /* synthetic */ Activity access$1000(ShareDialog shareDialog) {
        AppMethodBeat.m2504i(97734);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.m2505o(97734);
        return activityContext;
    }

    static /* synthetic */ Activity access$1100(ShareDialog shareDialog) {
        AppMethodBeat.m2504i(97735);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.m2505o(97735);
        return activityContext;
    }

    static /* synthetic */ boolean access$500(Class cls) {
        AppMethodBeat.m2504i(97729);
        boolean canShowNative = canShowNative(cls);
        AppMethodBeat.m2505o(97729);
        return canShowNative;
    }

    static /* synthetic */ Activity access$600(ShareDialog shareDialog) {
        AppMethodBeat.m2504i(97730);
        Activity activityContext = shareDialog.getActivityContext();
        AppMethodBeat.m2505o(97730);
        return activityContext;
    }

    static /* synthetic */ void access$700(ShareDialog shareDialog, Context context, ShareContent shareContent, Mode mode) {
        AppMethodBeat.m2504i(97731);
        shareDialog.logDialogShare(context, shareContent, mode);
        AppMethodBeat.m2505o(97731);
    }

    static /* synthetic */ DialogFeature access$800(Class cls) {
        AppMethodBeat.m2504i(97732);
        DialogFeature feature = getFeature(cls);
        AppMethodBeat.m2505o(97732);
        return feature;
    }

    static /* synthetic */ boolean access$900(ShareContent shareContent) {
        AppMethodBeat.m2504i(97733);
        boolean canShowWebCheck = canShowWebCheck(shareContent);
        AppMethodBeat.m2505o(97733);
        return canShowWebCheck;
    }

    static {
        AppMethodBeat.m2504i(97736);
        AppMethodBeat.m2505o(97736);
    }

    public static void show(Activity activity, ShareContent shareContent) {
        AppMethodBeat.m2504i(97706);
        new ShareDialog(activity).show(shareContent);
        AppMethodBeat.m2505o(97706);
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        AppMethodBeat.m2504i(97707);
        show(new FragmentWrapper(fragment), shareContent);
        AppMethodBeat.m2505o(97707);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        AppMethodBeat.m2504i(97708);
        show(new FragmentWrapper(fragment), shareContent);
        AppMethodBeat.m2505o(97708);
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        AppMethodBeat.m2504i(97709);
        new ShareDialog(fragmentWrapper).show(shareContent);
        AppMethodBeat.m2505o(97709);
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        AppMethodBeat.m2504i(97710);
        if (canShowWebTypeCheck(cls) || canShowNative(cls)) {
            AppMethodBeat.m2505o(97710);
            return true;
        }
        AppMethodBeat.m2505o(97710);
        return false;
    }

    private static boolean canShowNative(Class<? extends ShareContent> cls) {
        AppMethodBeat.m2504i(97711);
        DialogFeature feature = getFeature(cls);
        if (feature == null || !DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
            AppMethodBeat.m2505o(97711);
            return false;
        }
        AppMethodBeat.m2505o(97711);
        return true;
    }

    private static boolean canShowWebTypeCheck(Class<? extends ShareContent> cls) {
        AppMethodBeat.m2504i(97712);
        if (ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.isCurrentAccessTokenActive())) {
            AppMethodBeat.m2505o(97712);
            return true;
        }
        AppMethodBeat.m2505o(97712);
        return false;
    }

    private static boolean canShowWebCheck(ShareContent shareContent) {
        AppMethodBeat.m2504i(97713);
        if (canShowWebTypeCheck(shareContent.getClass())) {
            if (shareContent instanceof ShareOpenGraphContent) {
                try {
                    ShareInternalUtility.toJSONObjectForWeb((ShareOpenGraphContent) shareContent);
                } catch (Exception e) {
                    Utility.logd(TAG, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e);
                    AppMethodBeat.m2505o(97713);
                    return false;
                }
            }
            AppMethodBeat.m2505o(97713);
            return true;
        }
        AppMethodBeat.m2505o(97713);
        return false;
    }

    public ShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        AppMethodBeat.m2504i(97714);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
        AppMethodBeat.m2505o(97714);
    }

    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.m2504i(97715);
        AppMethodBeat.m2505o(97715);
    }

    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        AppMethodBeat.m2504i(97716);
        AppMethodBeat.m2505o(97716);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
        AppMethodBeat.m2504i(97717);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
        AppMethodBeat.m2505o(97717);
    }

    ShareDialog(Activity activity, int i) {
        super(activity, i);
        AppMethodBeat.m2504i(97718);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i);
        AppMethodBeat.m2505o(97718);
    }

    ShareDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        AppMethodBeat.m2504i(97719);
        AppMethodBeat.m2505o(97719);
    }

    ShareDialog(android.app.Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
        AppMethodBeat.m2504i(97720);
        AppMethodBeat.m2505o(97720);
    }

    private ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        AppMethodBeat.m2504i(97721);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(i);
        AppMethodBeat.m2505o(97721);
    }

    public final void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.m2504i(97722);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
        AppMethodBeat.m2505o(97722);
    }

    public final boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public final void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public final boolean canShow(ShareContent shareContent, Mode mode) {
        Object mode2;
        AppMethodBeat.m2504i(97723);
        if (mode2 == Mode.AUTOMATIC) {
            mode2 = BASE_AUTOMATIC_MODE;
        }
        boolean canShowImpl = canShowImpl(shareContent, mode2);
        AppMethodBeat.m2505o(97723);
        return canShowImpl;
    }

    public final void show(ShareContent shareContent, Mode mode) {
        Object mode2;
        AppMethodBeat.m2504i(97724);
        this.isAutomaticMode = mode2 == Mode.AUTOMATIC;
        if (this.isAutomaticMode) {
            mode2 = BASE_AUTOMATIC_MODE;
        }
        showImpl(shareContent, mode2);
        AppMethodBeat.m2505o(97724);
    }

    public final AppCall createBaseAppCall() {
        AppMethodBeat.m2504i(97725);
        AppCall appCall = new AppCall(getRequestCode());
        AppMethodBeat.m2505o(97725);
        return appCall;
    }

    public final List<ModeHandler> getOrderedModeHandlers() {
        AppMethodBeat.m2504i(97726);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        arrayList.add(new FeedHandler());
        arrayList.add(new WebShareHandler());
        arrayList.add(new CameraEffectHandler());
        arrayList.add(new ShareStoryHandler());
        AppMethodBeat.m2505o(97726);
        return arrayList;
    }

    private static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        AppMethodBeat.m2504i(97727);
        DialogFeature dialogFeature;
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            ShareDialogFeature shareDialogFeature = ShareDialogFeature.SHARE_DIALOG;
            AppMethodBeat.m2505o(97727);
            return shareDialogFeature;
        } else if (SharePhotoContent.class.isAssignableFrom(cls)) {
            dialogFeature = ShareDialogFeature.PHOTOS;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else if (ShareVideoContent.class.isAssignableFrom(cls)) {
            dialogFeature = ShareDialogFeature.VIDEO;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            dialogFeature = OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else if (ShareMediaContent.class.isAssignableFrom(cls)) {
            dialogFeature = ShareDialogFeature.MULTIMEDIA;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            dialogFeature = CameraEffectFeature.SHARE_CAMERA_EFFECT;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else if (ShareStoryContent.class.isAssignableFrom(cls)) {
            dialogFeature = ShareStoryFeature.SHARE_STORY_ASSET;
            AppMethodBeat.m2505o(97727);
            return dialogFeature;
        } else {
            AppMethodBeat.m2505o(97727);
            return null;
        }
    }

    private void logDialogShare(Context context, ShareContent shareContent, Mode mode) {
        String str;
        String str2;
        AppMethodBeat.m2504i(97728);
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        switch (mode) {
            case AUTOMATIC:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;
                break;
            case WEB:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB;
                break;
            case NATIVE:
                str = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE;
                break;
            default:
                str = "unknown";
                break;
        }
        DialogFeature feature = getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str2 = "status";
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str2 = "photo";
        } else if (feature == ShareDialogFeature.VIDEO) {
            str2 = "video";
        } else if (feature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str2 = "open_graph";
        } else {
            str2 = "unknown";
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str2);
        newLogger.logSdkEvent("fb_share_dialog_show", null, bundle);
        AppMethodBeat.m2505o(97728);
    }
}
