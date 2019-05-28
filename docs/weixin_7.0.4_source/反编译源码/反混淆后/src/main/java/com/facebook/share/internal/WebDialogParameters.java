package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class WebDialogParameters {

    /* renamed from: com.facebook.share.internal.WebDialogParameters$1 */
    static class C254981 implements Mapper<SharePhoto, String> {
        C254981() {
        }

        public final String apply(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97311);
            String uri = sharePhoto.getImageUrl().toString();
            AppMethodBeat.m2505o(97311);
            return uri;
        }
    }

    public static Bundle create(AppGroupCreationContent appGroupCreationContent) {
        AppMethodBeat.m2504i(97313);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        if (appGroupPrivacy != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, appGroupPrivacy.toString().toLowerCase(Locale.ENGLISH));
        }
        AppMethodBeat.m2505o(97313);
        return bundle;
    }

    public static Bundle create(GameRequestContent gameRequestContent) {
        AppMethodBeat.m2504i(97314);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        if (gameRequestContent.getActionType() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, gameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        if (gameRequestContent.getFilters() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_FILTERS, gameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        AppMethodBeat.m2505o(97314);
        return bundle;
    }

    public static Bundle create(ShareLinkContent shareLinkContent) {
        AppMethodBeat.m2504i(97315);
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility.putUri(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_HREF, shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        AppMethodBeat.m2505o(97315);
        return createBaseParameters;
    }

    public static Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
        AppMethodBeat.m2504i(97316);
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        try {
            JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent), false);
            if (removeNamespacesFromOGJsonObject != null) {
                Utility.putNonEmptyString(createBaseParameters, ShareConstants.WEB_DIALOG_PARAM_ACTION_PROPERTIES, removeNamespacesFromOGJsonObject.toString());
            }
            AppMethodBeat.m2505o(97316);
            return createBaseParameters;
        } catch (JSONException e) {
            FacebookException facebookException = new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", e);
            AppMethodBeat.m2505o(97316);
            throw facebookException;
        }
    }

    public static Bundle create(SharePhotoContent sharePhotoContent) {
        AppMethodBeat.m2504i(97317);
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        String[] strArr = new String[sharePhotoContent.getPhotos().size()];
        Utility.map(sharePhotoContent.getPhotos(), new C254981()).toArray(strArr);
        createBaseParameters.putStringArray("media", strArr);
        AppMethodBeat.m2505o(97317);
        return createBaseParameters;
    }

    public static Bundle createBaseParameters(ShareContent shareContent) {
        AppMethodBeat.m2504i(97318);
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag.getHashtag());
        }
        AppMethodBeat.m2505o(97318);
        return bundle;
    }

    public static Bundle createForFeed(ShareLinkContent shareLinkContent) {
        AppMethodBeat.m2504i(97319);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundle, "description", shareLinkContent.getContentDescription());
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, "picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        if (shareLinkContent.getShareHashtag() != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareLinkContent.getShareHashtag().getHashtag());
        }
        AppMethodBeat.m2505o(97319);
        return bundle;
    }

    public static Bundle createForFeed(ShareFeedContent shareFeedContent) {
        AppMethodBeat.m2504i(97320);
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        AppMethodBeat.m2505o(97320);
        return bundle;
    }
}
