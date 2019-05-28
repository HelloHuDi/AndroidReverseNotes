package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String STAGING_PARAM = "file";

    /* renamed from: com.facebook.share.internal.ShareInternalUtility$10 */
    static class C862710 implements Mapper<Attachment, Bundle> {
        C862710() {
        }

        public final Bundle apply(Attachment attachment) {
            AppMethodBeat.m2504i(97258);
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
            String uriExtension = ShareInternalUtility.getUriExtension(attachment.getOriginalUri());
            if (uriExtension != null) {
                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
            }
            AppMethodBeat.m2505o(97258);
            return bundle;
        }
    }

    /* renamed from: com.facebook.share.internal.ShareInternalUtility$8 */
    static class C312488 implements PhotoJSONProcessor {
        C312488() {
        }

        public final JSONObject toJSONObject(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97271);
            Uri imageUrl = sharePhoto.getImageUrl();
            if (Utility.isWebUri(imageUrl)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", imageUrl.toString());
                    AppMethodBeat.m2505o(97271);
                    return jSONObject;
                } catch (JSONException e) {
                    FacebookException facebookException = new FacebookException("Unable to attach images", e);
                    AppMethodBeat.m2505o(97271);
                    throw facebookException;
                }
            }
            FacebookException facebookException2 = new FacebookException("Only web images may be used in OG objects shared via the web dialog");
            AppMethodBeat.m2505o(97271);
            throw facebookException2;
        }
    }

    /* renamed from: com.facebook.share.internal.ShareInternalUtility$5 */
    static class C415865 implements Mapper<Attachment, String> {
        C415865() {
        }

        public final String apply(Attachment attachment) {
            AppMethodBeat.m2504i(97266);
            String attachmentUrl = attachment.getAttachmentUrl();
            AppMethodBeat.m2505o(97266);
            return attachmentUrl;
        }
    }

    static /* synthetic */ Attachment access$000(UUID uuid, ShareMedia shareMedia) {
        AppMethodBeat.m2504i(97307);
        Attachment attachment = getAttachment(uuid, shareMedia);
        AppMethodBeat.m2505o(97307);
        return attachment;
    }

    public static void invokeCallbackWithException(FacebookCallback<Result> facebookCallback, Exception exception) {
        AppMethodBeat.m2504i(97274);
        if (exception instanceof FacebookException) {
            invokeOnErrorCallback((FacebookCallback) facebookCallback, (FacebookException) exception);
            AppMethodBeat.m2505o(97274);
            return;
        }
        invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exception.getLocalizedMessage());
        AppMethodBeat.m2505o(97274);
    }

    public static void invokeCallbackWithError(FacebookCallback<Result> facebookCallback, String str) {
        AppMethodBeat.m2504i(97275);
        invokeOnErrorCallback((FacebookCallback) facebookCallback, str);
        AppMethodBeat.m2505o(97275);
    }

    public static void invokeCallbackWithResults(FacebookCallback<Result> facebookCallback, String str, GraphResponse graphResponse) {
        AppMethodBeat.m2504i(97276);
        FacebookRequestError error = graphResponse.getError();
        if (error != null) {
            String errorMessage = error.getErrorMessage();
            if (Utility.isNullOrEmpty(errorMessage)) {
                errorMessage = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
            AppMethodBeat.m2505o(97276);
            return;
        }
        invokeOnSuccessCallback(facebookCallback, str);
        AppMethodBeat.m2505o(97276);
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        AppMethodBeat.m2504i(97277);
        String string;
        if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
            string = bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
            AppMethodBeat.m2505o(97277);
            return string;
        }
        string = bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
        AppMethodBeat.m2505o(97277);
        return string;
    }

    public static String getShareDialogPostId(Bundle bundle) {
        AppMethodBeat.m2504i(97278);
        String string;
        if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
            string = bundle.getString(ShareConstants.RESULT_POST_ID);
            AppMethodBeat.m2505o(97278);
            return string;
        } else if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
            string = bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
            AppMethodBeat.m2505o(97278);
            return string;
        } else {
            string = bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
            AppMethodBeat.m2505o(97278);
            return string;
        }
    }

    public static boolean handleActivityResult(int i, int i2, Intent intent, ResultProcessor resultProcessor) {
        AppMethodBeat.m2504i(97279);
        AppCall appCallFromActivityResult = getAppCallFromActivityResult(i, i2, intent);
        if (appCallFromActivityResult == null) {
            AppMethodBeat.m2505o(97279);
            return false;
        }
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
        if (resultProcessor == null) {
            AppMethodBeat.m2505o(97279);
            return true;
        }
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
        if (exceptionFromErrorData == null) {
            resultProcessor.onSuccess(appCallFromActivityResult, NativeProtocol.getSuccessResultsFromIntent(intent));
        } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
            resultProcessor.onCancel(appCallFromActivityResult);
        } else {
            resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
        }
        AppMethodBeat.m2505o(97279);
        return true;
    }

    public static ResultProcessor getShareResultProcessor(final FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.m2504i(97280);
        C176171 c176171 = new ResultProcessor(facebookCallback) {
            public final void onSuccess(AppCall appCall, Bundle bundle) {
                AppMethodBeat.m2504i(97255);
                if (bundle != null) {
                    String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                    if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
                        AppMethodBeat.m2505o(97255);
                        return;
                    } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                        ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                        AppMethodBeat.m2505o(97255);
                        return;
                    } else {
                        ShareInternalUtility.invokeOnErrorCallback(facebookCallback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                    }
                }
                AppMethodBeat.m2505o(97255);
            }

            public final void onCancel(AppCall appCall) {
                AppMethodBeat.m2504i(97256);
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                AppMethodBeat.m2505o(97256);
            }

            public final void onError(AppCall appCall, FacebookException facebookException) {
                AppMethodBeat.m2504i(97257);
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
                AppMethodBeat.m2505o(97257);
            }
        };
        AppMethodBeat.m2505o(97280);
        return c176171;
    }

    private static AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(97281);
        UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            AppMethodBeat.m2505o(97281);
            return null;
        }
        AppCall finishPendingCall = AppCall.finishPendingCall(callIdFromIntent, i);
        AppMethodBeat.m2505o(97281);
        return finishPendingCall;
    }

    public static void registerStaticShareCallback(final int i) {
        AppMethodBeat.m2504i(97282);
        CallbackManagerImpl.registerStaticCallback(i, new Callback() {
            public final boolean onActivityResult(int i, Intent intent) {
                AppMethodBeat.m2504i(97262);
                boolean handleActivityResult = ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor(null));
                AppMethodBeat.m2505o(97262);
                return handleActivityResult;
            }
        });
        AppMethodBeat.m2505o(97282);
    }

    public static void registerSharerCallback(final int i, CallbackManager callbackManager, final FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.m2504i(97283);
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new Callback() {
                public final boolean onActivityResult(int i, Intent intent) {
                    AppMethodBeat.m2504i(97263);
                    boolean handleActivityResult = ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor(facebookCallback));
                    AppMethodBeat.m2505o(97263);
                    return handleActivityResult;
                }
            });
            AppMethodBeat.m2505o(97283);
            return;
        }
        FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        AppMethodBeat.m2505o(97283);
        throw facebookException;
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, final UUID uuid) {
        AppMethodBeat.m2504i(97284);
        if (sharePhotoContent != null) {
            List photos = sharePhotoContent.getPhotos();
            if (photos != null) {
                List map = Utility.map(photos, new Mapper<SharePhoto, Attachment>() {
                    public final Attachment apply(SharePhoto sharePhoto) {
                        AppMethodBeat.m2504i(97264);
                        Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                        AppMethodBeat.m2505o(97264);
                        return access$000;
                    }
                });
                List<String> map2 = Utility.map(map, new C415865());
                NativeAppCallAttachmentStore.addAttachments(map);
                AppMethodBeat.m2505o(97284);
                return map2;
            }
        }
        AppMethodBeat.m2505o(97284);
        return null;
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        AppMethodBeat.m2504i(97285);
        if (shareVideoContent == null || shareVideoContent.getVideo() == null) {
            AppMethodBeat.m2505o(97285);
            return null;
        }
        Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(createAttachment);
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        String attachmentUrl = createAttachment.getAttachmentUrl();
        AppMethodBeat.m2505o(97285);
        return attachmentUrl;
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, final UUID uuid) {
        AppMethodBeat.m2504i(97286);
        if (shareMediaContent != null) {
            List media = shareMediaContent.getMedia();
            if (media != null) {
                final ArrayList arrayList = new ArrayList();
                List<Bundle> map = Utility.map(media, new Mapper<ShareMedia, Bundle>() {
                    public final Bundle apply(ShareMedia shareMedia) {
                        AppMethodBeat.m2504i(97268);
                        Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                        arrayList.add(access$000);
                        Bundle bundle = new Bundle();
                        bundle.putString("type", shareMedia.getMediaType().name());
                        bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                        AppMethodBeat.m2505o(97268);
                        return bundle;
                    }
                });
                NativeAppCallAttachmentStore.addAttachments(arrayList);
                AppMethodBeat.m2505o(97286);
                return map;
            }
        }
        AppMethodBeat.m2505o(97286);
        return null;
    }

    public static Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        AppMethodBeat.m2504i(97287);
        if (shareCameraEffectContent != null) {
            CameraEffectTextures textures = shareCameraEffectContent.getTextures();
            if (textures != null) {
                Bundle bundle = new Bundle();
                ArrayList arrayList = new ArrayList();
                for (String str : textures.keySet()) {
                    Attachment attachment = getAttachment(uuid, textures.getTextureUri(str), textures.getTextureBitmap(str));
                    arrayList.add(attachment);
                    bundle.putString(str, attachment.getAttachmentUrl());
                }
                NativeAppCallAttachmentStore.addAttachments(arrayList);
                AppMethodBeat.m2505o(97287);
                return bundle;
            }
        }
        AppMethodBeat.m2505o(97287);
        return null;
    }

    public static JSONObject toJSONObjectForCall(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) {
        AppMethodBeat.m2504i(97288);
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        final ArrayList arrayList = new ArrayList();
        JSONObject toJSONObject = OpenGraphJSONUtility.toJSONObject(action, new PhotoJSONProcessor() {
            public final JSONObject toJSONObject(SharePhoto sharePhoto) {
                AppMethodBeat.m2504i(97270);
                Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                if (access$000 == null) {
                    AppMethodBeat.m2505o(97270);
                    return null;
                }
                arrayList.add(access$000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", access$000.getAttachmentUrl());
                    if (sharePhoto.getUserGenerated()) {
                        jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                    }
                    AppMethodBeat.m2505o(97270);
                    return jSONObject;
                } catch (JSONException e) {
                    FacebookException facebookException = new FacebookException("Unable to attach images", e);
                    AppMethodBeat.m2505o(97270);
                    throw facebookException;
                }
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(toJSONObject.optString("place"))) {
            toJSONObject.put("place", shareOpenGraphContent.getPlaceId());
        }
        if (shareOpenGraphContent.getPeopleIds() != null) {
            Set hashSet;
            JSONArray optJSONArray = toJSONObject.optJSONArray("tags");
            if (optJSONArray == null) {
                hashSet = new HashSet();
            } else {
                hashSet = Utility.jsonArrayToSet(optJSONArray);
            }
            for (String add : shareOpenGraphContent.getPeopleIds()) {
                hashSet.add(add);
            }
            toJSONObject.put("tags", new JSONArray(hashSet));
        }
        AppMethodBeat.m2505o(97288);
        return toJSONObject;
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) {
        AppMethodBeat.m2504i(97289);
        JSONObject toJSONObject = OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), new C312488());
        AppMethodBeat.m2505o(97289);
        return toJSONObject;
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) {
        AppMethodBeat.m2504i(97290);
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArray.length()) {
                Object obj = jSONArray.get(i2);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
                }
                jSONArray2.put(obj);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(97290);
                return jSONArray2;
            }
        }
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        AppMethodBeat.m2504i(97291);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(97291);
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray names = jSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                Object removeNamespacesFromOGJsonObject;
                String string = names.getString(i);
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    removeNamespacesFromOGJsonObject = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                } else if (obj instanceof JSONArray) {
                    JSONArray removeNamespacesFromOGJsonObject2 = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                } else {
                    removeNamespacesFromOGJsonObject2 = obj;
                }
                Pair fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                String str = (String) fieldNameAndNamespaceFromFullName.first;
                String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                if (z) {
                    if (str != null && str.equals("fbsdk")) {
                        jSONObject2.put(string, removeNamespacesFromOGJsonObject2);
                    } else if (str == null || str.equals("og")) {
                        jSONObject2.put(str2, removeNamespacesFromOGJsonObject2);
                    } else {
                        jSONObject3.put(str2, removeNamespacesFromOGJsonObject2);
                    }
                } else if (str == null || !str.equals("fb")) {
                    jSONObject2.put(str2, removeNamespacesFromOGJsonObject2);
                } else {
                    jSONObject2.put(string, removeNamespacesFromOGJsonObject2);
                }
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("data", jSONObject3);
            }
            AppMethodBeat.m2505o(97291);
            return jSONObject2;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Failed to create json object from share content");
            AppMethodBeat.m2505o(97291);
            throw facebookException;
        }
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        Object str2;
        AppMethodBeat.m2504i(97292);
        Object obj = null;
        int indexOf = str2.indexOf(58);
        if (indexOf != -1 && str2.length() > indexOf + 1) {
            obj = str2.substring(0, indexOf);
            str2 = str2.substring(indexOf + 1);
        }
        Pair pair = new Pair(obj, str2);
        AppMethodBeat.m2505o(97292);
        return pair;
    }

    private static Attachment getAttachment(UUID uuid, ShareMedia shareMedia) {
        Uri imageUrl;
        Bitmap bitmap;
        AppMethodBeat.m2504i(97293);
        if (shareMedia instanceof SharePhoto) {
            SharePhoto sharePhoto = (SharePhoto) shareMedia;
            Bitmap bitmap2 = sharePhoto.getBitmap();
            imageUrl = sharePhoto.getImageUrl();
            bitmap = bitmap2;
        } else if (shareMedia instanceof ShareVideo) {
            imageUrl = ((ShareVideo) shareMedia).getLocalUrl();
            bitmap = null;
        } else {
            imageUrl = null;
            bitmap = null;
        }
        Attachment attachment = getAttachment(uuid, imageUrl, bitmap);
        AppMethodBeat.m2505o(97293);
        return attachment;
    }

    private static Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        AppMethodBeat.m2504i(97294);
        Attachment attachment = null;
        if (bitmap != null) {
            attachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        } else if (uri != null) {
            attachment = NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        AppMethodBeat.m2505o(97294);
        return attachment;
    }

    static void invokeOnCancelCallback(FacebookCallback<Result> facebookCallback) {
        AppMethodBeat.m2504i(97295);
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
        AppMethodBeat.m2505o(97295);
    }

    static void invokeOnSuccessCallback(FacebookCallback<Result> facebookCallback, String str) {
        AppMethodBeat.m2504i(97296);
        logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
        if (facebookCallback != null) {
            facebookCallback.onSuccess(new Result(str));
        }
        AppMethodBeat.m2505o(97296);
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, GraphResponse graphResponse, String str) {
        AppMethodBeat.m2504i(97297);
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
        }
        AppMethodBeat.m2505o(97297);
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, String str) {
        AppMethodBeat.m2504i(97298);
        logShareResult("error", str);
        if (facebookCallback != null) {
            facebookCallback.onError(new FacebookException(str));
        }
        AppMethodBeat.m2505o(97298);
    }

    static void invokeOnErrorCallback(FacebookCallback<Result> facebookCallback, FacebookException facebookException) {
        AppMethodBeat.m2504i(97299);
        logShareResult("error", facebookException.getMessage());
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
        AppMethodBeat.m2505o(97299);
    }

    private static void logShareResult(String str, String str2) {
        AppMethodBeat.m2504i(97300);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
        if (str2 != null) {
            bundle.putString(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        }
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_SHARE_RESULT, null, bundle);
        AppMethodBeat.m2505o(97300);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        AppMethodBeat.m2504i(97301);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, bitmap);
        GraphRequest graphRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        AppMethodBeat.m2505o(97301);
        return graphRequest;
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) {
        AppMethodBeat.m2504i(97302);
        ParcelableResourceWithMimeType parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
        GraphRequest graphRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        AppMethodBeat.m2505o(97302);
        return graphRequest;
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) {
        AppMethodBeat.m2504i(97303);
        GraphRequest newUploadStagingResourceWithImageRequest;
        if (Utility.isFileUri(uri)) {
            newUploadStagingResourceWithImageRequest = newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
            AppMethodBeat.m2505o(97303);
            return newUploadStagingResourceWithImageRequest;
        } else if (Utility.isContentUri(uri)) {
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = new ParcelableResourceWithMimeType((Parcelable) uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            newUploadStagingResourceWithImageRequest = new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
            AppMethodBeat.m2505o(97303);
            return newUploadStagingResourceWithImageRequest;
        } else {
            FacebookException facebookException = new FacebookException("The image Uri must be either a file:// or content:// Uri");
            AppMethodBeat.m2505o(97303);
            throw facebookException;
        }
    }

    public static ObjectType getMostSpecificObjectType(ObjectType objectType, ObjectType objectType2) {
        if (objectType == objectType2) {
            return objectType;
        }
        if (objectType == ObjectType.UNKNOWN) {
            return objectType2;
        }
        return objectType2 != ObjectType.UNKNOWN ? null : objectType;
    }

    public static Bundle getStickerUrl(ShareStoryContent shareStoryContent, final UUID uuid) {
        AppMethodBeat.m2504i(97304);
        if (shareStoryContent == null || shareStoryContent.getStickerAsset() == null) {
            AppMethodBeat.m2505o(97304);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getStickerAsset());
        List map = Utility.map(arrayList, new Mapper<SharePhoto, Attachment>() {
            public final Attachment apply(SharePhoto sharePhoto) {
                AppMethodBeat.m2504i(97272);
                Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                AppMethodBeat.m2505o(97272);
                return access$000;
            }
        });
        List map2 = Utility.map(map, new C862710());
        NativeAppCallAttachmentStore.addAttachments(map);
        Bundle bundle = (Bundle) map2.get(0);
        AppMethodBeat.m2505o(97304);
        return bundle;
    }

    public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, final UUID uuid) {
        AppMethodBeat.m2504i(97305);
        if (shareStoryContent == null || shareStoryContent.getBackgroundAsset() == null) {
            AppMethodBeat.m2505o(97305);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(shareStoryContent.getBackgroundAsset());
        final ArrayList arrayList2 = new ArrayList();
        List map = Utility.map(arrayList, new Mapper<ShareMedia, Bundle>() {
            public final Bundle apply(ShareMedia shareMedia) {
                AppMethodBeat.m2504i(97260);
                Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                arrayList2.add(access$000);
                Bundle bundle = new Bundle();
                bundle.putString("type", shareMedia.getMediaType().name());
                bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                String uriExtension = ShareInternalUtility.getUriExtension(access$000.getOriginalUri());
                if (uriExtension != null) {
                    Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                }
                AppMethodBeat.m2505o(97260);
                return bundle;
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arrayList2);
        Bundle bundle = (Bundle) map.get(0);
        AppMethodBeat.m2505o(97305);
        return bundle;
    }

    public static String getUriExtension(Uri uri) {
        AppMethodBeat.m2504i(97306);
        if (uri == null) {
            AppMethodBeat.m2505o(97306);
            return null;
        }
        String uri2 = uri.toString();
        int lastIndexOf = uri2.lastIndexOf(46);
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(97306);
            return null;
        }
        String substring = uri2.substring(lastIndexOf);
        AppMethodBeat.m2505o(97306);
        return substring;
    }
}
