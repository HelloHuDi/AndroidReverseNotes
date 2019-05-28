package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeDialogParameters {
    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        AppMethodBeat.i(97147);
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        Bundle bundle = null;
        if (shareContent instanceof ShareLinkContent) {
            bundle = create((ShareLinkContent) shareContent, z);
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            bundle = create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            bundle = create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                bundle = create(shareOpenGraphContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), false), z);
            } catch (JSONException e) {
                FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e.getMessage());
                AppMethodBeat.o(97147);
                throw facebookException;
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            bundle = create(shareMediaContent, ShareInternalUtility.getMediaInfos(shareMediaContent, uuid), z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            bundle = create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid), z);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            bundle = create((ShareMessengerGenericTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            bundle = create((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            bundle = create((ShareMessengerMediaTemplateContent) shareContent, z);
        } else if (shareContent instanceof ShareStoryContent) {
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            bundle = create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid), ShareInternalUtility.getStickerUrl(shareStoryContent, uuid), z);
        }
        AppMethodBeat.o(97147);
        return bundle;
    }

    private static Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        AppMethodBeat.i(97148);
        Bundle createBaseParameters = createBaseParameters(shareCameraEffectContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            createBaseParameters.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            JSONObject convertToJSON = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (convertToJSON != null) {
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.EFFECT_ARGS, convertToJSON.toString());
            }
            AppMethodBeat.o(97148);
            return createBaseParameters;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + e.getMessage());
            AppMethodBeat.o(97148);
            throw facebookException;
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        AppMethodBeat.i(97149);
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(createBaseParameters, ShareConstants.IMAGE_URL, shareLinkContent.getImageUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(createBaseParameters, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(createBaseParameters, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        AppMethodBeat.o(97149);
        return createBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        AppMethodBeat.i(97150);
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z);
        createBaseParameters.putStringArrayList(ShareConstants.PHOTOS, new ArrayList(list));
        AppMethodBeat.o(97150);
        return createBaseParameters;
    }

    private static Bundle create(ShareVideoContent shareVideoContent, String str, boolean z) {
        AppMethodBeat.i(97151);
        Bundle createBaseParameters = createBaseParameters(shareVideoContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.VIDEO_URL, str);
        AppMethodBeat.o(97151);
        return createBaseParameters;
    }

    private static Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        AppMethodBeat.i(97152);
        Bundle createBaseParameters = createBaseParameters(shareMediaContent, z);
        createBaseParameters.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList(list));
        AppMethodBeat.o(97152);
        return createBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(97153);
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.PREVIEW_PROPERTY_NAME, (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(shareOpenGraphContent.getPreviewPropertyName()).second);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.ACTION, jSONObject.toString());
        AppMethodBeat.o(97153);
        return createBaseParameters;
    }

    private static Bundle create(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z) {
        AppMethodBeat.i(97154);
        Bundle createBaseParameters = createBaseParameters(shareMessengerGenericTemplateContent, z);
        try {
            MessengerShareContentUtility.addGenericTemplateContent(createBaseParameters, shareMessengerGenericTemplateContent);
            AppMethodBeat.o(97154);
            return createBaseParameters;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e.getMessage());
            AppMethodBeat.o(97154);
            throw facebookException;
        }
    }

    private static Bundle create(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z) {
        AppMethodBeat.i(97155);
        Bundle createBaseParameters = createBaseParameters(shareMessengerOpenGraphMusicTemplateContent, z);
        try {
            MessengerShareContentUtility.addOpenGraphMusicTemplateContent(createBaseParameters, shareMessengerOpenGraphMusicTemplateContent);
            AppMethodBeat.o(97155);
            return createBaseParameters;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e.getMessage());
            AppMethodBeat.o(97155);
            throw facebookException;
        }
    }

    private static Bundle create(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z) {
        AppMethodBeat.i(97156);
        Bundle createBaseParameters = createBaseParameters(shareMessengerMediaTemplateContent, z);
        try {
            MessengerShareContentUtility.addMediaTemplateContent(createBaseParameters, shareMessengerMediaTemplateContent);
            AppMethodBeat.o(97156);
            return createBaseParameters;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e.getMessage());
            AppMethodBeat.o(97156);
            throw facebookException;
        }
    }

    private static Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z) {
        AppMethodBeat.i(97157);
        Bundle createBaseParameters = createBaseParameters(shareStoryContent, z);
        if (bundle != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            createBaseParameters.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        Collection backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (!Utility.isNullOrEmpty(backgroundColorList)) {
            createBaseParameters.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList(backgroundColorList));
        }
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        AppMethodBeat.o(97157);
        return createBaseParameters;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z) {
        AppMethodBeat.i(97158);
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z);
        Collection peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList(peopleIds));
        }
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareHashtag.getHashtag());
        }
        AppMethodBeat.o(97158);
        return bundle;
    }
}
