package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent.ImageAspectRatio;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerShareContentUtility {
    public static final String ATTACHMENT = "attachment";
    public static final String ATTACHMENT_ID = "attachment_id";
    public static final String ATTACHMENT_PAYLOAD = "payload";
    public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
    public static final String ATTACHMENT_TYPE = "type";
    public static final String BUTTONS = "buttons";
    public static final String BUTTON_TYPE = "type";
    public static final String BUTTON_URL_TYPE = "web_url";
    public static final String DEFAULT_ACTION = "default_action";
    public static final String ELEMENTS = "elements";
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    public static final String FALLBACK_URL = "fallback_url";
    public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
    public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
    public static final String IMAGE_RATIO_SQUARE = "square";
    public static final String IMAGE_URL = "image_url";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_VIDEO = "video";
    public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
    public static final String PREVIEW_DEFAULT = "DEFAULT";
    public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
    public static final String SHARABLE = "sharable";
    public static final String SHARE_BUTTON_HIDE = "hide";
    public static final String SUBTITLE = "subtitle";
    public static final String TEMPLATE_GENERIC_TYPE = "generic";
    public static final String TEMPLATE_MEDIA_TYPE = "media";
    public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String WEBVIEW_RATIO = "webview_height_ratio";
    public static final String WEBVIEW_RATIO_COMPACT = "compact";
    public static final String WEBVIEW_RATIO_FULL = "full";
    public static final String WEBVIEW_RATIO_TALL = "tall";
    public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";

    static {
        AppMethodBeat.m2504i(97146);
        AppMethodBeat.m2505o(97146);
    }

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.m2504i(97124);
        addGenericTemplateElementForPreview(bundle, shareMessengerGenericTemplateContent.getGenericTemplateElement());
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeGenericTemplateContent(shareMessengerGenericTemplateContent));
        AppMethodBeat.m2505o(97124);
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97125);
        addOpenGraphMusicTemplateContentForPreview(bundle, shareMessengerOpenGraphMusicTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeOpenGraphMusicTemplateContent(shareMessengerOpenGraphMusicTemplateContent));
        AppMethodBeat.m2505o(97125);
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97126);
        addMediaTemplateContentForPreview(bundle, shareMessengerMediaTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeMediaTemplateContent(shareMessengerMediaTemplateContent));
        AppMethodBeat.m2505o(97126);
    }

    private static void addGenericTemplateElementForPreview(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        AppMethodBeat.m2504i(97127);
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getButton(), false);
        } else if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getDefaultAction(), true);
        }
        Utility.putUri(bundle, ShareConstants.IMAGE_URL, shareMessengerGenericTemplateElement.getImageUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, "DEFAULT");
        Utility.putNonEmptyString(bundle, ShareConstants.TITLE, shareMessengerGenericTemplateElement.getTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle());
        AppMethodBeat.m2505o(97127);
    }

    private static void addOpenGraphMusicTemplateContentForPreview(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97128);
        addActionButton(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_OPEN_GRAPH);
        Utility.putUri(bundle, ShareConstants.OPEN_GRAPH_URL, shareMessengerOpenGraphMusicTemplateContent.getUrl());
        AppMethodBeat.m2505o(97128);
    }

    private static void addMediaTemplateContentForPreview(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97129);
        addActionButton(bundle, shareMessengerMediaTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, "DEFAULT");
        Utility.putNonEmptyString(bundle, ShareConstants.ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId());
        if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
            Utility.putUri(bundle, getMediaUrlKey(shareMessengerMediaTemplateContent.getMediaUrl()), shareMessengerMediaTemplateContent.getMediaUrl());
        }
        Utility.putNonEmptyString(bundle, "type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        AppMethodBeat.m2505o(97129);
    }

    private static void addActionButton(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        AppMethodBeat.m2504i(97130);
        if (shareMessengerActionButton == null) {
            AppMethodBeat.m2505o(97130);
            return;
        }
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            addURLActionButton(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
        AppMethodBeat.m2505o(97130);
    }

    private static void addURLActionButton(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        String uriString;
        AppMethodBeat.m2504i(97131);
        if (z) {
            uriString = Utility.getUriString(shareMessengerURLActionButton.getUrl());
        } else {
            uriString = shareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(shareMessengerURLActionButton.getUrl());
        }
        Utility.putNonEmptyString(bundle, ShareConstants.TARGET_DISPLAY, uriString);
        Utility.putUri(bundle, ShareConstants.ITEM_URL, shareMessengerURLActionButton.getUrl());
        AppMethodBeat.m2505o(97131);
    }

    private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.m2504i(97132);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, TEMPLATE_GENERIC_TYPE).put(SHARABLE, shareMessengerGenericTemplateContent.getIsSharable()).put(IMAGE_ASPECT_RATIO, getImageRatioString(shareMessengerGenericTemplateContent.getImageAspectRatio())).put(ELEMENTS, new JSONArray().put(serializeGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement())))));
        AppMethodBeat.m2505o(97132);
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97133);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "open_graph").put(ELEMENTS, new JSONArray().put(serializeOpenGraphMusicTemplateElement(shareMessengerOpenGraphMusicTemplateContent)))));
        AppMethodBeat.m2505o(97133);
        return put;
    }

    private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97134);
        JSONObject put = new JSONObject().put(ATTACHMENT, new JSONObject().put("type", ATTACHMENT_TEMPLATE_TYPE).put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "media").put(ELEMENTS, new JSONArray().put(serializeMediaTemplateElement(shareMessengerMediaTemplateContent)))));
        AppMethodBeat.m2505o(97134);
        return put;
    }

    private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        AppMethodBeat.m2504i(97135);
        JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.getTitle()).put(SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle()).put(IMAGE_URL, Utility.getUriString(shareMessengerGenericTemplateElement.getImageUrl()));
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerGenericTemplateElement.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            put.put(DEFAULT_ACTION, serializeActionButton(shareMessengerGenericTemplateElement.getDefaultAction(), true));
        }
        AppMethodBeat.m2505o(97135);
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97136);
        JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
        if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        AppMethodBeat.m2505o(97136);
        return put;
    }

    private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97137);
        JSONObject put = new JSONObject().put(ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl())).put(MEDIA_TYPE, getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        if (shareMessengerMediaTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerMediaTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        AppMethodBeat.m2505o(97137);
        return put;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        AppMethodBeat.m2504i(97138);
        JSONObject serializeActionButton = serializeActionButton(shareMessengerActionButton, false);
        AppMethodBeat.m2505o(97138);
        return serializeActionButton;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        AppMethodBeat.m2504i(97139);
        if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
            JSONObject serializeURLActionButton = serializeURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton, z);
            AppMethodBeat.m2505o(97139);
            return serializeURLActionButton;
        }
        AppMethodBeat.m2505o(97139);
        return null;
    }

    private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(97140);
        JSONObject put = new JSONObject().put("type", BUTTON_URL_TYPE);
        String str = "title";
        if (z) {
            obj = null;
        } else {
            obj = shareMessengerURLActionButton.getTitle();
        }
        JSONObject put2 = put.put(str, obj).put("url", Utility.getUriString(shareMessengerURLActionButton.getUrl())).put(WEBVIEW_RATIO, getWebviewHeightRatioString(shareMessengerURLActionButton.getWebviewHeightRatio())).put(MESSENGER_EXTENSIONS, shareMessengerURLActionButton.getIsMessengerExtensionURL()).put(FALLBACK_URL, Utility.getUriString(shareMessengerURLActionButton.getFallbackUrl())).put(WEBVIEW_SHARE_BUTTON, getShouldHideShareButton(shareMessengerURLActionButton));
        AppMethodBeat.m2505o(97140);
        return put2;
    }

    private static String getMediaUrlKey(Uri uri) {
        AppMethodBeat.m2504i(97141);
        String host = uri.getHost();
        if (Utility.isNullOrEmpty(host) || !FACEBOOK_DOMAIN.matcher(host).matches()) {
            host = ShareConstants.IMAGE_URL;
            AppMethodBeat.m2505o(97141);
            return host;
        }
        host = ShareConstants.MEDIA_URI;
        AppMethodBeat.m2505o(97141);
        return host;
    }

    private static String getWebviewHeightRatioString(WebviewHeightRatio webviewHeightRatio) {
        AppMethodBeat.m2504i(97142);
        String str;
        if (webviewHeightRatio == null) {
            str = "full";
            AppMethodBeat.m2505o(97142);
            return str;
        }
        switch (webviewHeightRatio) {
            case WebviewHeightRatioCompact:
                str = WEBVIEW_RATIO_COMPACT;
                AppMethodBeat.m2505o(97142);
                return str;
            case WebviewHeightRatioTall:
                str = WEBVIEW_RATIO_TALL;
                AppMethodBeat.m2505o(97142);
                return str;
            default:
                str = "full";
                AppMethodBeat.m2505o(97142);
                return str;
        }
    }

    private static String getImageRatioString(ImageAspectRatio imageAspectRatio) {
        AppMethodBeat.m2504i(97143);
        String str;
        if (imageAspectRatio == null) {
            str = IMAGE_RATIO_HORIZONTAL;
            AppMethodBeat.m2505o(97143);
            return str;
        }
        switch (imageAspectRatio) {
            case SQUARE:
                str = IMAGE_RATIO_SQUARE;
                AppMethodBeat.m2505o(97143);
                return str;
            default:
                str = IMAGE_RATIO_HORIZONTAL;
                AppMethodBeat.m2505o(97143);
                return str;
        }
    }

    private static String getMediaType(MediaType mediaType) {
        AppMethodBeat.m2504i(97144);
        String str;
        if (mediaType == null) {
            str = "image";
            AppMethodBeat.m2505o(97144);
            return str;
        }
        switch (mediaType) {
            case VIDEO:
                str = "video";
                AppMethodBeat.m2505o(97144);
                return str;
            default:
                str = "image";
                AppMethodBeat.m2505o(97144);
                return str;
        }
    }

    private static String getShouldHideShareButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        AppMethodBeat.m2504i(97145);
        if (shareMessengerURLActionButton.getShouldHideWebviewShareButton()) {
            String str = SHARE_BUTTON_HIDE;
            AppMethodBeat.m2505o(97145);
            return str;
        }
        AppMethodBeat.m2505o(97145);
        return null;
    }
}
