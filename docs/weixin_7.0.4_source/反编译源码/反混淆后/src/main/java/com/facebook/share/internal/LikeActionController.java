package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.content.C37116d;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent.Builder;
import com.facebook.share.widget.LikeView.ObjectType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class LikeActionController {
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    @Deprecated
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    @Deprecated
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    @Deprecated
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    @Deprecated
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
    private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static final String TAG = LikeActionController.class.getSimpleName();
    private static AccessTokenTracker accessTokenTracker;
    private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap();
    private static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
    private static Handler handler;
    private static boolean isInitialized;
    private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Bundle facebookDialogAnalyticsBundle;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private ObjectType objectType;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;

    /* renamed from: com.facebook.share.internal.LikeActionController$9 */
    class C08149 implements RequestCompletionCallback {
        C08149() {
        }

        public void onComplete() {
            LikeRequestWrapper getPageLikesRequestWrapper;
            AppMethodBeat.m2504i(96995);
            switch (C861612.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.this.objectType.ordinal()]) {
                case 1:
                    getPageLikesRequestWrapper = new GetPageLikesRequestWrapper(LikeActionController.this.verifiedObjectId);
                    break;
                default:
                    getPageLikesRequestWrapper = new GetOGObjectLikesRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                    break;
            }
            final GetEngagementRequestWrapper getEngagementRequestWrapper = new GetEngagementRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            getPageLikesRequestWrapper.addToBatch(graphRequestBatch);
            getEngagementRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new Callback() {
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AppMethodBeat.m2504i(96994);
                    if (getPageLikesRequestWrapper.getError() == null && getEngagementRequestWrapper.getError() == null) {
                        LikeActionController.access$1300(LikeActionController.this, getPageLikesRequestWrapper.isObjectLiked(), getEngagementRequestWrapper.likeCountStringWithLike, getEngagementRequestWrapper.likeCountStringWithoutLike, getEngagementRequestWrapper.socialSentenceStringWithLike, getEngagementRequestWrapper.socialSentenceStringWithoutLike, getPageLikesRequestWrapper.getUnlikeToken());
                        AppMethodBeat.m2505o(96994);
                        return;
                    }
                    Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", LikeActionController.this.objectId);
                    AppMethodBeat.m2505o(96994);
                }
            });
            graphRequestBatch.executeAsync();
            AppMethodBeat.m2505o(96995);
        }
    }

    class GetPageIdRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsPage;
        String verifiedObjectId;

        GetPageIdRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.m2504i(97007);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
            AppMethodBeat.m2505o(97007);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(97008);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                this.objectIsPage = !Utility.isNullOrEmpty(this.verifiedObjectId);
            }
            AppMethodBeat.m2505o(97008);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97009);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            AppMethodBeat.m2505o(97009);
        }
    }

    static class MRUCacheWorkItem implements Runnable {
        private static ArrayList<String> mruCachedItems = new ArrayList();
        private String cacheItem;
        private boolean shouldTrim;

        static {
            AppMethodBeat.m2504i(97014);
            AppMethodBeat.m2505o(97014);
        }

        MRUCacheWorkItem(String str, boolean z) {
            this.cacheItem = str;
            this.shouldTrim = z;
        }

        public void run() {
            AppMethodBeat.m2504i(97013);
            if (this.cacheItem != null) {
                mruCachedItems.remove(this.cacheItem);
                mruCachedItems.add(0, this.cacheItem);
            }
            if (this.shouldTrim && mruCachedItems.size() >= 128) {
                while (64 < mruCachedItems.size()) {
                    ArrayList arrayList = mruCachedItems;
                    LikeActionController.cache.remove((String) arrayList.remove(arrayList.size() - 1));
                }
            }
            AppMethodBeat.m2505o(97013);
        }
    }

    static class SerializeToDiskWorkItem implements Runnable {
        private String cacheKey;
        private String controllerJson;

        SerializeToDiskWorkItem(String str, String str2) {
            this.cacheKey = str;
            this.controllerJson = str2;
        }

        public void run() {
            AppMethodBeat.m2504i(97020);
            LikeActionController.access$2600(this.cacheKey, this.controllerJson);
            AppMethodBeat.m2505o(97020);
        }
    }

    static class CreateLikeActionControllerWorkItem implements Runnable {
        private CreationCallback callback;
        private String objectId;
        private ObjectType objectType;

        CreateLikeActionControllerWorkItem(String str, ObjectType objectType, CreationCallback creationCallback) {
            this.objectId = str;
            this.objectType = objectType;
            this.callback = creationCallback;
        }

        public void run() {
            AppMethodBeat.m2504i(96997);
            LikeActionController.access$2700(this.objectId, this.objectType, this.callback);
            AppMethodBeat.m2505o(96997);
        }
    }

    interface LikeRequestWrapper extends RequestWrapper {
        String getUnlikeToken();

        boolean isObjectLiked();
    }

    class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
        private String unlikeToken;

        PublishUnlikeRequestWrapper(String str) {
            super(null, null);
            AppMethodBeat.m2504i(97018);
            this.unlikeToken = str;
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
            AppMethodBeat.m2505o(97018);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97019);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "publish_unlike", facebookRequestError);
            AppMethodBeat.m2505o(97019);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$12 */
    static /* synthetic */ class C861612 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$LikeView$ObjectType = new int[ObjectType.values().length];

        static {
            AppMethodBeat.m2504i(96983);
            try {
                $SwitchMap$com$facebook$share$widget$LikeView$ObjectType[ObjectType.PAGE.ordinal()] = 1;
                AppMethodBeat.m2505o(96983);
            } catch (NoSuchFieldError e) {
                AppMethodBeat.m2505o(96983);
            }
        }
    }

    class GetEngagementRequestWrapper extends AbstractRequestWrapper {
        String likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
        String likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
        String socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
        String socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;

        GetEngagementRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.m2504i(96998);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
            AppMethodBeat.m2505o(96998);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(96999);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.likeCountStringWithLike = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.likeCountStringWithLike);
                this.likeCountStringWithoutLike = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
                this.socialSentenceStringWithLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.socialSentenceStringWithLike);
                this.socialSentenceStringWithoutLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.socialSentenceStringWithoutLike);
            }
            AppMethodBeat.m2505o(96999);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97000);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_engagement", facebookRequestError);
            AppMethodBeat.m2505o(97000);
        }
    }

    interface RequestWrapper {
        void addToBatch(GraphRequestBatch graphRequestBatch);

        FacebookRequestError getError();
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$10 */
    class C861710 implements CompletedListener {
        C861710() {
        }

        public void completed(Bundle bundle) {
            AppMethodBeat.m2504i(96981);
            if (bundle == null || !bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
                AppMethodBeat.m2505o(96981);
                return;
            }
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
            if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                string = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
            } else {
                string = LikeActionController.this.likeCountStringWithLike;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                string2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
            } else {
                string2 = LikeActionController.this.likeCountStringWithoutLike;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                string3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
            } else {
                string3 = LikeActionController.this.socialSentenceWithLike;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                string4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
            } else {
                string4 = LikeActionController.this.socialSentenceWithoutLike;
            }
            if (bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
                string5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
            } else {
                string5 = LikeActionController.this.unlikeToken;
            }
            LikeActionController.access$1300(LikeActionController.this, z, string, string2, string3, string4, string5);
            AppMethodBeat.m2505o(96981);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$2 */
    static class C86182 implements Runnable {
        final /* synthetic */ LikeActionController val$controllerToRefresh;

        C86182(LikeActionController likeActionController) {
            this.val$controllerToRefresh = likeActionController;
        }

        public final void run() {
            AppMethodBeat.m2504i(96984);
            LikeActionController.access$200(this.val$controllerToRefresh);
            AppMethodBeat.m2505o(96984);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$5 */
    static class C86195 extends AccessTokenTracker {
        C86195() {
        }

        public final void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
            AppMethodBeat.m2504i(96987);
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (accessToken2 == null) {
                LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
                applicationContext.getSharedPreferences(LikeActionController.LIKE_ACTION_CONTROLLER_STORE, 0).edit().putInt(LikeActionController.LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, LikeActionController.objectSuffix).apply();
                LikeActionController.cache.clear();
                LikeActionController.controllerDiskCache.clearCache();
            }
            LikeActionController.access$600(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
            AppMethodBeat.m2505o(96987);
        }
    }

    @Deprecated
    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    class GetOGObjectIdRequestWrapper extends AbstractRequestWrapper {
        String verifiedObjectId;

        GetOGObjectIdRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.m2504i(97001);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "og_object.fields(id)");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, HttpMethod.GET));
            AppMethodBeat.m2505o(97001);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97002);
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                AppMethodBeat.m2505o(97002);
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            AppMethodBeat.m2505o(97002);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(97003);
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                tryGetJSONObjectFromResponse = tryGetJSONObjectFromResponse.optJSONObject("og_object");
                if (tryGetJSONObjectFromResponse != null) {
                    this.verifiedObjectId = tryGetJSONObjectFromResponse.optString("id");
                }
            }
            AppMethodBeat.m2505o(97003);
        }
    }

    class PublishLikeRequestWrapper extends AbstractRequestWrapper {
        String unlikeToken;

        PublishLikeRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.m2504i(97015);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.POST));
            AppMethodBeat.m2505o(97015);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(97016);
            this.unlikeToken = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), "id");
            AppMethodBeat.m2505o(97016);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97017);
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.error = null;
                AppMethodBeat.m2505o(97017);
                return;
            }
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "publish_like", facebookRequestError);
            AppMethodBeat.m2505o(97017);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController$3 */
    static class C86203 implements CallbackManagerImpl.Callback {
        C86203() {
        }

        public final boolean onActivityResult(int i, Intent intent) {
            AppMethodBeat.m2504i(96985);
            boolean handleOnActivityResult = LikeActionController.handleOnActivityResult(RequestCodeOffset.Like.toRequestCode(), i, intent);
            AppMethodBeat.m2505o(96985);
            return handleOnActivityResult;
        }
    }

    abstract class AbstractRequestWrapper implements RequestWrapper {
        protected FacebookRequestError error;
        protected String objectId;
        protected ObjectType objectType;
        private GraphRequest request;

        /* renamed from: com.facebook.share.internal.LikeActionController$AbstractRequestWrapper$1 */
        class C86211 implements GraphRequest.Callback {
            C86211() {
            }

            public void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.m2504i(96996);
                AbstractRequestWrapper.this.error = graphResponse.getError();
                if (AbstractRequestWrapper.this.error != null) {
                    AbstractRequestWrapper.this.processError(AbstractRequestWrapper.this.error);
                    AppMethodBeat.m2505o(96996);
                    return;
                }
                AbstractRequestWrapper.this.processSuccess(graphResponse);
                AppMethodBeat.m2505o(96996);
            }
        }

        public abstract void processSuccess(GraphResponse graphResponse);

        protected AbstractRequestWrapper(String str, ObjectType objectType) {
            this.objectId = str;
            this.objectType = objectType;
        }

        public void addToBatch(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.request);
        }

        public FacebookRequestError getError() {
            return this.error;
        }

        /* Access modifiers changed, original: protected */
        public void setRequest(GraphRequest graphRequest) {
            this.request = graphRequest;
            graphRequest.setVersion(FacebookSdk.getGraphApiVersion());
            graphRequest.setCallback(new C86211());
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
        }
    }

    class GetOGObjectLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private final String objectId;
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private final ObjectType objectType;
        private String unlikeToken;

        GetOGObjectLikesRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            AppMethodBeat.m2504i(97004);
            this.objectId = str;
            this.objectType = objectType;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,application");
            bundle.putString("object", this.objectId);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
            AppMethodBeat.m2505o(97004);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(97005);
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null) {
                for (int i = 0; i < tryGetJSONArrayFromResponse.length(); i++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.objectIsLiked = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (optJSONObject2 != null && AccessToken.isCurrentAccessTokenActive() && Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString("id"))) {
                            this.unlikeToken = optJSONObject.optString("id");
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(97005);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97006);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", this.objectId, this.objectType, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_og_object_like", facebookRequestError);
            AppMethodBeat.m2505o(97006);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        public String getUnlikeToken() {
            return this.unlikeToken;
        }
    }

    class GetPageLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private boolean objectIsLiked = LikeActionController.this.isObjectLiked;
        private String pageId;

        GetPageLikesRequestWrapper(String str) {
            super(str, ObjectType.PAGE);
            AppMethodBeat.m2504i(97010);
            this.pageId = str;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id");
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/".concat(String.valueOf(str)), bundle, HttpMethod.GET));
            AppMethodBeat.m2505o(97010);
        }

        /* Access modifiers changed, original: protected */
        public void processSuccess(GraphResponse graphResponse) {
            AppMethodBeat.m2504i(97011);
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), "data");
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.objectIsLiked = true;
            }
            AppMethodBeat.m2505o(97011);
        }

        /* Access modifiers changed, original: protected */
        public void processError(FacebookRequestError facebookRequestError) {
            AppMethodBeat.m2504i(97012);
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.pageId, facebookRequestError);
            LikeActionController.access$2400(LikeActionController.this, "get_page_like", facebookRequestError);
            AppMethodBeat.m2505o(97012);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        public String getUnlikeToken() {
            return null;
        }
    }

    interface RequestCompletionCallback {
        void onComplete();
    }

    static /* synthetic */ void access$000(LikeActionController likeActionController, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(97059);
        likeActionController.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(97059);
    }

    static /* synthetic */ AppEventsLogger access$1200(LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97062);
        AppEventsLogger appEventsLogger = likeActionController.getAppEventsLogger();
        AppMethodBeat.m2505o(97062);
        return appEventsLogger;
    }

    static /* synthetic */ void access$1300(LikeActionController likeActionController, boolean z, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(97063);
        likeActionController.updateState(z, str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(97063);
    }

    static /* synthetic */ void access$1400(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.m2504i(97064);
        likeActionController.logAppEventForError(str, bundle);
        AppMethodBeat.m2505o(97064);
    }

    static /* synthetic */ void access$1500(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.m2504i(97065);
        broadcastAction(likeActionController, str, bundle);
        AppMethodBeat.m2505o(97065);
    }

    static /* synthetic */ void access$1900(LikeActionController likeActionController, boolean z) {
        AppMethodBeat.m2504i(97066);
        likeActionController.publishDidError(z);
        AppMethodBeat.m2505o(97066);
    }

    static /* synthetic */ void access$200(LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97060);
        likeActionController.refreshStatusAsync();
        AppMethodBeat.m2505o(97060);
    }

    static /* synthetic */ void access$2100(LikeActionController likeActionController, Bundle bundle) {
        AppMethodBeat.m2504i(97067);
        likeActionController.publishAgainIfNeeded(bundle);
        AppMethodBeat.m2505o(97067);
    }

    static /* synthetic */ void access$2400(LikeActionController likeActionController, String str, FacebookRequestError facebookRequestError) {
        AppMethodBeat.m2504i(97068);
        likeActionController.logAppEventForError(str, facebookRequestError);
        AppMethodBeat.m2505o(97068);
    }

    static /* synthetic */ void access$2600(String str, String str2) {
        AppMethodBeat.m2504i(97069);
        serializeToDiskSynchronously(str, str2);
        AppMethodBeat.m2505o(97069);
    }

    static /* synthetic */ void access$2700(String str, ObjectType objectType, CreationCallback creationCallback) {
        AppMethodBeat.m2504i(97070);
        createControllerForObjectIdAndType(str, objectType, creationCallback);
        AppMethodBeat.m2505o(97070);
    }

    static /* synthetic */ void access$600(LikeActionController likeActionController, String str) {
        AppMethodBeat.m2504i(97061);
        broadcastAction(likeActionController, str);
        AppMethodBeat.m2505o(97061);
    }

    static {
        AppMethodBeat.m2504i(97071);
        AppMethodBeat.m2505o(97071);
    }

    @Deprecated
    public static boolean handleOnActivityResult(final int i, final int i2, final Intent intent) {
        AppMethodBeat.m2504i(97021);
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            AppMethodBeat.m2505o(97021);
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, ObjectType.UNKNOWN, new CreationCallback() {
            public final void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
                AppMethodBeat.m2504i(96980);
                if (facebookException == null) {
                    LikeActionController.access$000(likeActionController, i, i2, intent);
                    AppMethodBeat.m2505o(96980);
                    return;
                }
                Utility.logd(LikeActionController.TAG, (Exception) facebookException);
                AppMethodBeat.m2505o(96980);
            }
        });
        AppMethodBeat.m2505o(97021);
        return true;
    }

    @Deprecated
    public static void getControllerForObjectId(String str, ObjectType objectType, CreationCallback creationCallback) {
        AppMethodBeat.m2504i(97022);
        if (!isInitialized) {
            performFirstInitialize();
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
            AppMethodBeat.m2505o(97022);
            return;
        }
        diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(str, objectType, creationCallback));
        AppMethodBeat.m2505o(97022);
    }

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, ObjectType objectType, CreationCallback creationCallback) {
        FacebookException facebookException;
        AppMethodBeat.m2504i(97023);
        ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", likeActionController.objectId, likeActionController.objectType.toString(), objectType.toString());
            likeActionController = null;
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
        }
        invokeCallbackWithController(creationCallback, likeActionController, facebookException);
        AppMethodBeat.m2505o(97023);
    }

    private static void createControllerForObjectIdAndType(String str, ObjectType objectType, CreationCallback creationCallback) {
        AppMethodBeat.m2504i(97024);
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
            AppMethodBeat.m2505o(97024);
            return;
        }
        controllerFromInMemoryCache = deserializeFromDiskSynchronously(str);
        if (controllerFromInMemoryCache == null) {
            controllerFromInMemoryCache = new LikeActionController(str, objectType);
            serializeToDiskAsync(controllerFromInMemoryCache);
        }
        putControllerInMemoryCache(str, controllerFromInMemoryCache);
        handler.post(new C86182(controllerFromInMemoryCache));
        invokeCallbackWithController(creationCallback, controllerFromInMemoryCache, null);
        AppMethodBeat.m2505o(97024);
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            AppMethodBeat.m2504i(97025);
            if (isInitialized) {
                AppMethodBeat.m2505o(97025);
            } else {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
                controllerDiskCache = new FileLruCache(TAG, new Limits());
                registerAccessTokenTracker();
                CallbackManagerImpl.registerStaticCallback(RequestCodeOffset.Like.toRequestCode(), new C86203());
                isInitialized = true;
                AppMethodBeat.m2505o(97025);
            }
        }
    }

    private static void invokeCallbackWithController(final CreationCallback creationCallback, final LikeActionController likeActionController, final FacebookException facebookException) {
        AppMethodBeat.m2504i(97026);
        if (creationCallback == null) {
            AppMethodBeat.m2505o(97026);
            return;
        }
        handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(96986);
                creationCallback.onComplete(likeActionController, facebookException);
                AppMethodBeat.m2505o(96986);
            }
        });
        AppMethodBeat.m2505o(97026);
    }

    private static void registerAccessTokenTracker() {
        AppMethodBeat.m2504i(97027);
        accessTokenTracker = new C86195();
        AppMethodBeat.m2505o(97027);
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97028);
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
        AppMethodBeat.m2505o(97028);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        AppMethodBeat.m2504i(97029);
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = (LikeActionController) cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, false));
        }
        AppMethodBeat.m2505o(97029);
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97030);
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!(Utility.isNullOrEmpty(serializeToJson) || Utility.isNullOrEmpty(cacheKeyForObjectId))) {
            diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKeyForObjectId, serializeToJson));
        }
        AppMethodBeat.m2505o(97030);
    }

    private static void serializeToDiskSynchronously(String str, String str2) {
        AppMethodBeat.m2504i(97031);
        Closeable closeable = null;
        try {
            closeable = controllerDiskCache.openPutStream(str);
            closeable.write(str2.getBytes());
            if (closeable != null) {
                Utility.closeQuietly(closeable);
                AppMethodBeat.m2505o(97031);
                return;
            }
        } catch (IOException e) {
            if (closeable != null) {
                Utility.closeQuietly(closeable);
                AppMethodBeat.m2505o(97031);
                return;
            }
        } catch (Throwable th) {
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            AppMethodBeat.m2505o(97031);
        }
        AppMethodBeat.m2505o(97031);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static LikeActionController deserializeFromDiskSynchronously(String str) {
        Throwable th;
        Closeable closeable;
        LikeActionController likeActionController = null;
        AppMethodBeat.m2504i(97032);
        Closeable closeable2;
        try {
            closeable2 = controllerDiskCache.get(getCacheKeyForObjectId(str));
            if (closeable2 != null) {
                try {
                    String readStreamToString = Utility.readStreamToString(closeable2);
                    if (!Utility.isNullOrEmpty(readStreamToString)) {
                        likeActionController = deserializeFromJson(readStreamToString);
                    }
                } catch (IOException e) {
                    if (closeable2 != null) {
                        Utility.closeQuietly(closeable2);
                    }
                    AppMethodBeat.m2505o(97032);
                    return likeActionController;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = closeable2;
                    if (closeable != null) {
                    }
                    AppMethodBeat.m2505o(97032);
                    throw th;
                }
            }
            if (closeable2 != null) {
                Utility.closeQuietly(closeable2);
            }
        } catch (IOException e2) {
            closeable2 = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            AppMethodBeat.m2505o(97032);
            throw th;
        }
        AppMethodBeat.m2505o(97032);
        return likeActionController;
    }

    private static LikeActionController deserializeFromJson(String str) {
        AppMethodBeat.m2504i(97033);
        LikeActionController likeActionController;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != 3) {
                AppMethodBeat.m2505o(97033);
                return null;
            }
            likeActionController = new LikeActionController(jSONObject.getString("object_id"), ObjectType.fromInt(jSONObject.optInt("object_type", ObjectType.UNKNOWN.getValue())));
            likeActionController.likeCountStringWithLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, null);
            likeActionController.likeCountStringWithoutLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, null);
            likeActionController.socialSentenceWithLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, null);
            likeActionController.socialSentenceWithoutLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, null);
            likeActionController.isObjectLiked = jSONObject.optBoolean(JSON_BOOL_IS_OBJECT_LIKED_KEY);
            likeActionController.unlikeToken = jSONObject.optString("unlike_token", null);
            jSONObject = jSONObject.optJSONObject(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE);
            if (jSONObject != null) {
                likeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(jSONObject);
            }
            AppMethodBeat.m2505o(97033);
            return likeActionController;
        } catch (JSONException e) {
            likeActionController = null;
        }
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        AppMethodBeat.m2504i(97034);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_INT_VERSION_KEY, 3);
            jSONObject.put("object_id", likeActionController.objectId);
            jSONObject.put("object_type", likeActionController.objectType.getValue());
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, likeActionController.likeCountStringWithLike);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, likeActionController.likeCountStringWithoutLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, likeActionController.socialSentenceWithLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, likeActionController.socialSentenceWithoutLike);
            jSONObject.put(JSON_BOOL_IS_OBJECT_LIKED_KEY, likeActionController.isObjectLiked);
            jSONObject.put("unlike_token", likeActionController.unlikeToken);
            if (likeActionController.facebookDialogAnalyticsBundle != null) {
                JSONObject convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.facebookDialogAnalyticsBundle);
                if (convertToJSON != null) {
                    jSONObject.put(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE, convertToJSON);
                }
            }
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.m2505o(97034);
            return jSONObject2;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(97034);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        AppMethodBeat.m2504i(97035);
        String str2 = null;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (AccessToken.isCurrentAccessTokenActive()) {
            str2 = currentAccessToken.getToken();
        }
        if (str2 != null) {
            str2 = Utility.md5hash(str2);
        }
        str2 = String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[]{str, Utility.coerceValueIfNullOrEmpty(str2, ""), Integer.valueOf(objectSuffix)});
        AppMethodBeat.m2505o(97035);
        return str2;
    }

    private static void broadcastAction(LikeActionController likeActionController, String str) {
        AppMethodBeat.m2504i(97036);
        broadcastAction(likeActionController, str, null);
        AppMethodBeat.m2505o(97036);
    }

    private static void broadcastAction(LikeActionController likeActionController, String str, Bundle bundle) {
        AppMethodBeat.m2504i(97037);
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        C37116d.m62125S(FacebookSdk.getApplicationContext()).mo59172c(intent);
        AppMethodBeat.m2505o(97037);
    }

    private LikeActionController(String str, ObjectType objectType) {
        this.objectId = str;
        this.objectType = objectType;
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    @Deprecated
    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    @Deprecated
    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    @Deprecated
    public boolean shouldEnableView() {
        return false;
    }

    @Deprecated
    public void toggleLike(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(97038);
        boolean z2 = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z2);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                AppMethodBeat.m2505o(97038);
                return;
            }
            if (!publishLikeOrUnlikeAsync(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                updateLikeState(z);
            }
            AppMethodBeat.m2505o(97038);
        }
        presentLikeDialog(activity, fragmentWrapper, bundle);
        AppMethodBeat.m2505o(97038);
    }

    private AppEventsLogger getAppEventsLogger() {
        AppMethodBeat.m2504i(97039);
        if (this.appEventsLogger == null) {
            this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        }
        AppEventsLogger appEventsLogger = this.appEventsLogger;
        AppMethodBeat.m2505o(97039);
        return appEventsLogger;
    }

    private boolean publishLikeOrUnlikeAsync(boolean z, Bundle bundle) {
        boolean z2 = true;
        AppMethodBeat.m2504i(97040);
        if (canUseOGPublish()) {
            if (z) {
                publishLikeAsync(bundle);
            } else if (!Utility.isNullOrEmpty(this.unlikeToken)) {
                publishUnlikeAsync(bundle);
            }
            AppMethodBeat.m2505o(97040);
            return z2;
        }
        z2 = false;
        AppMethodBeat.m2505o(97040);
        return z2;
    }

    private void publishDidError(boolean z) {
        AppMethodBeat.m2504i(97041);
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
        AppMethodBeat.m2505o(97041);
    }

    private void updateLikeState(boolean z) {
        AppMethodBeat.m2504i(97042);
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
        AppMethodBeat.m2505o(97042);
    }

    private void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(97043);
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        Object obj = (z == this.isObjectLiked && Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken)) ? null : 1;
        if (obj == null) {
            AppMethodBeat.m2505o(97043);
            return;
        }
        this.isObjectLiked = z;
        this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
        this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
        this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
        this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
        this.unlikeToken = coerceValueIfNullOrEmpty5;
        serializeToDiskAsync(this);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        AppMethodBeat.m2505o(97043);
    }

    private void presentLikeDialog(Activity activity, FragmentWrapper fragmentWrapper, Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(97044);
        if (LikeDialog.canShowNativeDialog()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG;
        } else if (LikeDialog.canShowWebFallback()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK;
        } else {
            logAppEventForError("present_dialog", bundle);
            Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
            broadcastAction(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
            str = null;
        }
        if (str != null) {
            if (this.objectType != null) {
                str = this.objectType.toString();
            } else {
                str = ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new Builder().setObjectId(this.objectId).setObjectType(str).build();
            if (fragmentWrapper != null) {
                new LikeDialog(fragmentWrapper).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
        }
        AppMethodBeat.m2505o(97044);
    }

    private void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(97045);
        ShareInternalUtility.handleActivityResult(i, i2, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
        AppMethodBeat.m2505o(97045);
    }

    private ResultProcessor getResultProcessor(final Bundle bundle) {
        AppMethodBeat.m2504i(97046);
        C86226 c86226 = new ResultProcessor(null) {
            public void onSuccess(AppCall appCall, Bundle bundle) {
                AppMethodBeat.m2504i(96988);
                if (bundle == null || !bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    AppMethodBeat.m2505o(96988);
                    return;
                }
                String string;
                String string2;
                boolean z = bundle.getBoolean(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY);
                String access$700 = LikeActionController.this.likeCountStringWithLike;
                String access$800 = LikeActionController.this.likeCountStringWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY)) {
                    string = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY);
                    access$800 = string;
                    access$700 = string;
                }
                String access$900 = LikeActionController.this.socialSentenceWithLike;
                String access$1000 = LikeActionController.this.socialSentenceWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY)) {
                    string = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY);
                    access$1000 = string;
                    access$900 = string;
                }
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    string2 = bundle.getString("unlike_token");
                } else {
                    string2 = LikeActionController.this.unlikeToken;
                }
                Bundle bundle2 = bundle == null ? new Bundle() : bundle;
                bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
                LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
                LikeActionController.access$1300(LikeActionController.this, z, access$700, access$800, access$900, access$1000, string2);
                AppMethodBeat.m2505o(96988);
            }

            public void onError(AppCall appCall, FacebookException facebookException) {
                AppMethodBeat.m2504i(96989);
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
                Bundle bundle = bundle == null ? new Bundle() : bundle;
                bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
                LikeActionController.access$1400(LikeActionController.this, "present_dialog", bundle);
                LikeActionController.access$1500(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
                AppMethodBeat.m2505o(96989);
            }

            public void onCancel(AppCall appCall) {
                AppMethodBeat.m2504i(96990);
                onError(appCall, new FacebookOperationCanceledException());
                AppMethodBeat.m2505o(96990);
            }
        };
        AppMethodBeat.m2505o(97046);
        return c86226;
    }

    private void saveState(Bundle bundle) {
        AppMethodBeat.m2504i(97047);
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
        AppMethodBeat.m2505o(97047);
    }

    private void clearState() {
        AppMethodBeat.m2504i(97048);
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
        AppMethodBeat.m2505o(97048);
    }

    private static void storeObjectIdForPendingController(String str) {
        AppMethodBeat.m2504i(97049);
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
        AppMethodBeat.m2505o(97049);
    }

    private boolean canUseOGPublish() {
        AppMethodBeat.m2504i(97050);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (this.objectIsPage || this.verifiedObjectId == null || !AccessToken.isCurrentAccessTokenActive() || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) {
            AppMethodBeat.m2505o(97050);
            return false;
        }
        AppMethodBeat.m2505o(97050);
        return true;
    }

    private void publishLikeAsync(final Bundle bundle) {
        AppMethodBeat.m2504i(97051);
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new RequestCompletionCallback() {
            public void onComplete() {
                AppMethodBeat.m2504i(96992);
                if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
                    LikeActionController.access$1500(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                    AppMethodBeat.m2505o(96992);
                    return;
                }
                GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
                final PublishLikeRequestWrapper publishLikeRequestWrapper = new PublishLikeRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                publishLikeRequestWrapper.addToBatch(graphRequestBatch);
                graphRequestBatch.addCallback(new Callback() {
                    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                        AppMethodBeat.m2504i(96991);
                        LikeActionController.this.isPendingLikeOrUnlike = false;
                        if (publishLikeRequestWrapper.getError() != null) {
                            LikeActionController.access$1900(LikeActionController.this, false);
                            AppMethodBeat.m2505o(96991);
                            return;
                        }
                        LikeActionController.this.unlikeToken = Utility.coerceValueIfNullOrEmpty(publishLikeRequestWrapper.unlikeToken, null);
                        LikeActionController.this.isObjectLikedOnServer = true;
                        LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, bundle);
                        LikeActionController.access$2100(LikeActionController.this, bundle);
                        AppMethodBeat.m2505o(96991);
                    }
                });
                graphRequestBatch.executeAsync();
                AppMethodBeat.m2505o(96992);
            }
        });
        AppMethodBeat.m2505o(97051);
    }

    private void publishUnlikeAsync(final Bundle bundle) {
        AppMethodBeat.m2504i(97052);
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        final PublishUnlikeRequestWrapper publishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
        publishUnlikeRequestWrapper.addToBatch(graphRequestBatch);
        graphRequestBatch.addCallback(new Callback() {
            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                AppMethodBeat.m2504i(96993);
                LikeActionController.this.isPendingLikeOrUnlike = false;
                if (publishUnlikeRequestWrapper.getError() != null) {
                    LikeActionController.access$1900(LikeActionController.this, true);
                    AppMethodBeat.m2505o(96993);
                    return;
                }
                LikeActionController.this.unlikeToken = null;
                LikeActionController.this.isObjectLikedOnServer = false;
                LikeActionController.access$1200(LikeActionController.this).logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, bundle);
                LikeActionController.access$2100(LikeActionController.this, bundle);
                AppMethodBeat.m2505o(96993);
            }
        });
        graphRequestBatch.executeAsync();
        AppMethodBeat.m2505o(97052);
    }

    private void refreshStatusAsync() {
        AppMethodBeat.m2504i(97053);
        if (AccessToken.isCurrentAccessTokenActive()) {
            fetchVerifiedObjectId(new C08149());
            AppMethodBeat.m2505o(97053);
            return;
        }
        refreshStatusViaService();
        AppMethodBeat.m2505o(97053);
    }

    private void refreshStatusViaService() {
        AppMethodBeat.m2504i(97054);
        LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (likeStatusClient.start()) {
            likeStatusClient.setCompletedListener(new C861710());
            AppMethodBeat.m2505o(97054);
            return;
        }
        AppMethodBeat.m2505o(97054);
    }

    private void publishAgainIfNeeded(Bundle bundle) {
        AppMethodBeat.m2504i(97055);
        if (!(this.isObjectLiked == this.isObjectLikedOnServer || publishLikeOrUnlikeAsync(this.isObjectLiked, bundle))) {
            publishDidError(!this.isObjectLiked);
        }
        AppMethodBeat.m2505o(97055);
    }

    private void fetchVerifiedObjectId(final RequestCompletionCallback requestCompletionCallback) {
        AppMethodBeat.m2504i(97056);
        if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
            final GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
            final GetPageIdRequestWrapper getPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId, this.objectType);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            getOGObjectIdRequestWrapper.addToBatch(graphRequestBatch);
            getPageIdRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new Callback() {
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    AppMethodBeat.m2504i(96982);
                    LikeActionController.this.verifiedObjectId = getOGObjectIdRequestWrapper.verifiedObjectId;
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        LikeActionController.this.verifiedObjectId = getPageIdRequestWrapper.verifiedObjectId;
                        LikeActionController.this.objectIsPage = getPageIdRequestWrapper.objectIsPage;
                    }
                    if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                        FacebookRequestError error;
                        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.objectId);
                        LikeActionController likeActionController = LikeActionController.this;
                        String str = "get_verified_id";
                        if (getPageIdRequestWrapper.getError() != null) {
                            error = getPageIdRequestWrapper.getError();
                        } else {
                            error = getOGObjectIdRequestWrapper.getError();
                        }
                        LikeActionController.access$2400(likeActionController, str, error);
                    }
                    if (requestCompletionCallback != null) {
                        requestCompletionCallback.onComplete();
                    }
                    AppMethodBeat.m2505o(96982);
                }
            });
            graphRequestBatch.executeAsync();
            AppMethodBeat.m2505o(97056);
            return;
        }
        if (requestCompletionCallback != null) {
            requestCompletionCallback.onComplete();
        }
        AppMethodBeat.m2505o(97056);
    }

    private void logAppEventForError(String str, Bundle bundle) {
        AppMethodBeat.m2504i(97057);
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.objectId);
        bundle2.putString("object_type", this.objectType.toString());
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
        AppMethodBeat.m2505o(97057);
    }

    private void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        AppMethodBeat.m2504i(97058);
        Bundle bundle = new Bundle();
        if (facebookRequestError != null) {
            JSONObject requestResult = facebookRequestError.getRequestResult();
            if (requestResult != null) {
                bundle.putString("error", requestResult.toString());
            }
        }
        logAppEventForError(str, bundle);
        AppMethodBeat.m2505o(97058);
    }
}
