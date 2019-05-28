package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Locale;

public class ShareContentValidation {
    private static Validator ApiValidator;
    private static Validator DefaultValidator;
    private static Validator StoryValidator;
    private static Validator WebShareValidator;

    static class WebShareValidator extends Validator {
        private WebShareValidator() {
            super();
        }

        /* synthetic */ WebShareValidator(C372191 c372191) {
            this();
        }

        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.m2504i(97187);
            FacebookException facebookException = new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
            AppMethodBeat.m2505o(97187);
            throw facebookException;
        }

        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.m2504i(97188);
            FacebookException facebookException = new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
            AppMethodBeat.m2505o(97188);
            throw facebookException;
        }

        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97189);
            ShareContentValidation.access$500(sharePhoto, this);
            AppMethodBeat.m2505o(97189);
        }
    }

    static class ApiValidator extends Validator {
        private ApiValidator() {
            super();
        }

        /* synthetic */ ApiValidator(C372191 c372191) {
            this();
        }

        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97166);
            ShareContentValidation.access$600(sharePhoto, this);
            AppMethodBeat.m2505o(97166);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.m2504i(97167);
            FacebookException facebookException;
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                facebookException = new FacebookException("Cannot share video content with place IDs using the share api");
                AppMethodBeat.m2505o(97167);
                throw facebookException;
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                facebookException = new FacebookException("Cannot share video content with people IDs using the share api");
                AppMethodBeat.m2505o(97167);
                throw facebookException;
            } else if (Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                AppMethodBeat.m2505o(97167);
            } else {
                facebookException = new FacebookException("Cannot share video content with referrer URL using the share api");
                AppMethodBeat.m2505o(97167);
                throw facebookException;
            }
        }

        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.m2504i(97168);
            FacebookException facebookException = new FacebookException("Cannot share ShareMediaContent using the share api");
            AppMethodBeat.m2505o(97168);
            throw facebookException;
        }

        public void validate(ShareLinkContent shareLinkContent) {
            AppMethodBeat.m2504i(97169);
            if (Utility.isNullOrEmpty(shareLinkContent.getQuote())) {
                AppMethodBeat.m2505o(97169);
                return;
            }
            FacebookException facebookException = new FacebookException("Cannot share link content with quote using the share api");
            AppMethodBeat.m2505o(97169);
            throw facebookException;
        }
    }

    static class StoryShareValidator extends Validator {
        private StoryShareValidator() {
            super();
        }

        /* synthetic */ StoryShareValidator(C372191 c372191) {
            this();
        }

        public void validate(ShareStoryContent shareStoryContent) {
            AppMethodBeat.m2504i(97170);
            ShareContentValidation.access$400(shareStoryContent, this);
            AppMethodBeat.m2505o(97170);
        }
    }

    static class Validator {
        private boolean isOpenGraphContent;

        private Validator() {
            this.isOpenGraphContent = false;
        }

        /* synthetic */ Validator(C372191 c372191) {
            this();
        }

        public void validate(ShareLinkContent shareLinkContent) {
            AppMethodBeat.m2504i(97171);
            ShareContentValidation.access$700(shareLinkContent, this);
            AppMethodBeat.m2505o(97171);
        }

        public void validate(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.m2504i(97172);
            ShareContentValidation.access$800(sharePhotoContent, this);
            AppMethodBeat.m2505o(97172);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            AppMethodBeat.m2504i(97173);
            ShareContentValidation.access$900(shareVideoContent, this);
            AppMethodBeat.m2505o(97173);
        }

        public void validate(ShareMediaContent shareMediaContent) {
            AppMethodBeat.m2504i(97174);
            ShareContentValidation.access$1000(shareMediaContent, this);
            AppMethodBeat.m2505o(97174);
        }

        public void validate(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.m2504i(97175);
            ShareContentValidation.access$1100(shareCameraEffectContent, this);
            AppMethodBeat.m2505o(97175);
        }

        public void validate(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.m2504i(97176);
            this.isOpenGraphContent = true;
            ShareContentValidation.access$1200(shareOpenGraphContent, this);
            AppMethodBeat.m2505o(97176);
        }

        public void validate(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.m2504i(97177);
            ShareContentValidation.access$1300(shareOpenGraphAction, this);
            AppMethodBeat.m2505o(97177);
        }

        public void validate(ShareOpenGraphObject shareOpenGraphObject) {
            AppMethodBeat.m2504i(97178);
            ShareContentValidation.access$1400(shareOpenGraphObject, this);
            AppMethodBeat.m2505o(97178);
        }

        public void validate(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            AppMethodBeat.m2504i(97179);
            ShareContentValidation.access$1500(shareOpenGraphValueContainer, this, z);
            AppMethodBeat.m2505o(97179);
        }

        public void validate(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(97180);
            ShareContentValidation.access$1600(sharePhoto, this);
            AppMethodBeat.m2505o(97180);
        }

        public void validate(ShareVideo shareVideo) {
            AppMethodBeat.m2504i(97181);
            ShareContentValidation.access$1700(shareVideo, this);
            AppMethodBeat.m2505o(97181);
        }

        public void validate(ShareMedia shareMedia) {
            AppMethodBeat.m2504i(97182);
            ShareContentValidation.validateMedium(shareMedia, this);
            AppMethodBeat.m2505o(97182);
        }

        public void validate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            AppMethodBeat.m2504i(97183);
            ShareContentValidation.access$1800(shareMessengerOpenGraphMusicTemplateContent);
            AppMethodBeat.m2505o(97183);
        }

        public void validate(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.m2504i(97184);
            ShareContentValidation.access$1900(shareMessengerGenericTemplateContent);
            AppMethodBeat.m2505o(97184);
        }

        public void validate(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            AppMethodBeat.m2504i(97185);
            ShareContentValidation.access$2000(shareMessengerMediaTemplateContent);
            AppMethodBeat.m2505o(97185);
        }

        public void validate(ShareStoryContent shareStoryContent) {
            AppMethodBeat.m2504i(97186);
            ShareContentValidation.access$400(shareStoryContent, this);
            AppMethodBeat.m2505o(97186);
        }

        public boolean isOpenGraphContent() {
            return this.isOpenGraphContent;
        }
    }

    static /* synthetic */ void access$1000(ShareMediaContent shareMediaContent, Validator validator) {
        AppMethodBeat.m2504i(97229);
        validateMediaContent(shareMediaContent, validator);
        AppMethodBeat.m2505o(97229);
    }

    static /* synthetic */ void access$1100(ShareCameraEffectContent shareCameraEffectContent, Validator validator) {
        AppMethodBeat.m2504i(97230);
        validateCameraEffectContent(shareCameraEffectContent, validator);
        AppMethodBeat.m2505o(97230);
    }

    static /* synthetic */ void access$1200(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        AppMethodBeat.m2504i(97231);
        validateOpenGraphContent(shareOpenGraphContent, validator);
        AppMethodBeat.m2505o(97231);
    }

    static /* synthetic */ void access$1300(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        AppMethodBeat.m2504i(97232);
        validateOpenGraphAction(shareOpenGraphAction, validator);
        AppMethodBeat.m2505o(97232);
    }

    static /* synthetic */ void access$1400(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        AppMethodBeat.m2504i(97233);
        validateOpenGraphObject(shareOpenGraphObject, validator);
        AppMethodBeat.m2505o(97233);
    }

    static /* synthetic */ void access$1500(ShareOpenGraphValueContainer shareOpenGraphValueContainer, Validator validator, boolean z) {
        AppMethodBeat.m2504i(97234);
        validateOpenGraphValueContainer(shareOpenGraphValueContainer, validator, z);
        AppMethodBeat.m2505o(97234);
    }

    static /* synthetic */ void access$1600(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97235);
        validatePhotoForNativeDialog(sharePhoto, validator);
        AppMethodBeat.m2505o(97235);
    }

    static /* synthetic */ void access$1700(ShareVideo shareVideo, Validator validator) {
        AppMethodBeat.m2504i(97236);
        validateVideo(shareVideo, validator);
        AppMethodBeat.m2505o(97236);
    }

    static /* synthetic */ void access$1800(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97237);
        validateMessengerOpenGraphMusicTemplate(shareMessengerOpenGraphMusicTemplateContent);
        AppMethodBeat.m2505o(97237);
    }

    static /* synthetic */ void access$1900(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.m2504i(97238);
        validateShareMessengerGenericTemplateContent(shareMessengerGenericTemplateContent);
        AppMethodBeat.m2505o(97238);
    }

    static /* synthetic */ void access$2000(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97239);
        validateShareMessengerMediaTemplateContent(shareMessengerMediaTemplateContent);
        AppMethodBeat.m2505o(97239);
    }

    static /* synthetic */ void access$400(ShareStoryContent shareStoryContent, Validator validator) {
        AppMethodBeat.m2504i(97223);
        validateStoryContent(shareStoryContent, validator);
        AppMethodBeat.m2505o(97223);
    }

    static /* synthetic */ void access$500(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97224);
        validatePhotoForWebDialog(sharePhoto, validator);
        AppMethodBeat.m2505o(97224);
    }

    static /* synthetic */ void access$600(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97225);
        validatePhotoForApi(sharePhoto, validator);
        AppMethodBeat.m2505o(97225);
    }

    static /* synthetic */ void access$700(ShareLinkContent shareLinkContent, Validator validator) {
        AppMethodBeat.m2504i(97226);
        validateLinkContent(shareLinkContent, validator);
        AppMethodBeat.m2505o(97226);
    }

    static /* synthetic */ void access$800(SharePhotoContent sharePhotoContent, Validator validator) {
        AppMethodBeat.m2504i(97227);
        validatePhotoContent(sharePhotoContent, validator);
        AppMethodBeat.m2505o(97227);
    }

    static /* synthetic */ void access$900(ShareVideoContent shareVideoContent, Validator validator) {
        AppMethodBeat.m2504i(97228);
        validateVideoContent(shareVideoContent, validator);
        AppMethodBeat.m2505o(97228);
    }

    public static void validateForMessage(ShareContent shareContent) {
        AppMethodBeat.m2504i(97190);
        validate(shareContent, getDefaultValidator());
        AppMethodBeat.m2505o(97190);
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        AppMethodBeat.m2504i(97191);
        validate(shareContent, getDefaultValidator());
        AppMethodBeat.m2505o(97191);
    }

    public static void validateForWebShare(ShareContent shareContent) {
        AppMethodBeat.m2504i(97192);
        validate(shareContent, getWebShareValidator());
        AppMethodBeat.m2505o(97192);
    }

    public static void validateForApiShare(ShareContent shareContent) {
        AppMethodBeat.m2504i(97193);
        validate(shareContent, getApiValidator());
        AppMethodBeat.m2505o(97193);
    }

    public static void validateForStoryShare(ShareContent shareContent) {
        AppMethodBeat.m2504i(97194);
        validate(shareContent, getStoryValidator());
        AppMethodBeat.m2505o(97194);
    }

    private static Validator getStoryValidator() {
        AppMethodBeat.m2504i(97195);
        if (StoryValidator == null) {
            StoryValidator = new StoryShareValidator();
        }
        Validator validator = StoryValidator;
        AppMethodBeat.m2505o(97195);
        return validator;
    }

    private static Validator getDefaultValidator() {
        AppMethodBeat.m2504i(97196);
        if (DefaultValidator == null) {
            DefaultValidator = new Validator();
        }
        Validator validator = DefaultValidator;
        AppMethodBeat.m2505o(97196);
        return validator;
    }

    private static Validator getApiValidator() {
        AppMethodBeat.m2504i(97197);
        if (ApiValidator == null) {
            ApiValidator = new ApiValidator();
        }
        Validator validator = ApiValidator;
        AppMethodBeat.m2505o(97197);
        return validator;
    }

    private static Validator getWebShareValidator() {
        AppMethodBeat.m2504i(97198);
        if (WebShareValidator == null) {
            WebShareValidator = new WebShareValidator();
        }
        Validator validator = WebShareValidator;
        AppMethodBeat.m2505o(97198);
        return validator;
    }

    private static void validate(ShareContent shareContent, Validator validator) {
        AppMethodBeat.m2504i(97199);
        if (shareContent == null) {
            FacebookException facebookException = new FacebookException("Must provide non-null content to share");
            AppMethodBeat.m2505o(97199);
            throw facebookException;
        } else if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            validator.validate((ShareOpenGraphContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            validator.validate((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            validator.validate((ShareMessengerMediaTemplateContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            validator.validate((ShareMessengerGenericTemplateContent) shareContent);
            AppMethodBeat.m2505o(97199);
        } else {
            if (shareContent instanceof ShareStoryContent) {
                validator.validate((ShareStoryContent) shareContent);
            }
            AppMethodBeat.m2505o(97199);
        }
    }

    private static void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        AppMethodBeat.m2504i(97200);
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            FacebookException facebookException = new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
            AppMethodBeat.m2505o(97200);
            throw facebookException;
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
        AppMethodBeat.m2505o(97200);
    }

    private static void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        AppMethodBeat.m2504i(97201);
        Uri imageUrl = shareLinkContent.getImageUrl();
        if (imageUrl == null || Utility.isWebUri(imageUrl)) {
            AppMethodBeat.m2505o(97201);
            return;
        }
        FacebookException facebookException = new FacebookException("Image Url must be an http:// or https:// url");
        AppMethodBeat.m2505o(97201);
        throw facebookException;
    }

    private static void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        AppMethodBeat.m2504i(97202);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        FacebookException facebookException;
        if (photos == null || photos.isEmpty()) {
            facebookException = new FacebookException("Must specify at least one Photo in SharePhotoContent.");
            AppMethodBeat.m2505o(97202);
            throw facebookException;
        } else if (photos.size() > 6) {
            facebookException = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[]{Integer.valueOf(6)}));
            AppMethodBeat.m2505o(97202);
            throw facebookException;
        } else {
            for (SharePhoto validate : photos) {
                validator.validate(validate);
            }
            AppMethodBeat.m2505o(97202);
        }
    }

    private static void validatePhoto(SharePhoto sharePhoto) {
        AppMethodBeat.m2504i(97203);
        FacebookException facebookException;
        if (sharePhoto == null) {
            facebookException = new FacebookException("Cannot share a null SharePhoto");
            AppMethodBeat.m2505o(97203);
            throw facebookException;
        }
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            facebookException = new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            AppMethodBeat.m2505o(97203);
            throw facebookException;
        }
        AppMethodBeat.m2505o(97203);
    }

    private static void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97204);
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(imageUrl) && !validator.isOpenGraphContent()) {
            FacebookException facebookException = new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            AppMethodBeat.m2505o(97204);
            throw facebookException;
        }
        AppMethodBeat.m2505o(97204);
    }

    private static void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97205);
        validatePhotoForApi(sharePhoto, validator);
        if (!(sharePhoto.getBitmap() == null && Utility.isWebUri(sharePhoto.getImageUrl()))) {
            Validate.hasContentProvider(FacebookSdk.getApplicationContext());
        }
        AppMethodBeat.m2505o(97205);
    }

    private static void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        AppMethodBeat.m2504i(97206);
        validatePhoto(sharePhoto);
        AppMethodBeat.m2505o(97206);
    }

    private static void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        AppMethodBeat.m2504i(97207);
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
        AppMethodBeat.m2505o(97207);
    }

    private static void validateVideo(ShareVideo shareVideo, Validator validator) {
        AppMethodBeat.m2504i(97208);
        FacebookException facebookException;
        if (shareVideo == null) {
            facebookException = new FacebookException("Cannot share a null ShareVideo");
            AppMethodBeat.m2505o(97208);
            throw facebookException;
        }
        Uri localUrl = shareVideo.getLocalUrl();
        if (localUrl == null) {
            facebookException = new FacebookException("ShareVideo does not have a LocalUrl specified");
            AppMethodBeat.m2505o(97208);
            throw facebookException;
        } else if (Utility.isContentUri(localUrl) || Utility.isFileUri(localUrl)) {
            AppMethodBeat.m2505o(97208);
        } else {
            facebookException = new FacebookException("ShareVideo must reference a video that is on the device");
            AppMethodBeat.m2505o(97208);
            throw facebookException;
        }
    }

    private static void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        AppMethodBeat.m2504i(97209);
        List<ShareMedia> media = shareMediaContent.getMedia();
        FacebookException facebookException;
        if (media == null || media.isEmpty()) {
            facebookException = new FacebookException("Must specify at least one medium in ShareMediaContent.");
            AppMethodBeat.m2505o(97209);
            throw facebookException;
        } else if (media.size() > 6) {
            facebookException = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[]{Integer.valueOf(6)}));
            AppMethodBeat.m2505o(97209);
            throw facebookException;
        } else {
            for (ShareMedia validate : media) {
                validator.validate(validate);
            }
            AppMethodBeat.m2505o(97209);
        }
    }

    public static void validateMedium(ShareMedia shareMedia, Validator validator) {
        AppMethodBeat.m2504i(97210);
        if (shareMedia instanceof SharePhoto) {
            validator.validate((SharePhoto) shareMedia);
            AppMethodBeat.m2505o(97210);
        } else if (shareMedia instanceof ShareVideo) {
            validator.validate((ShareVideo) shareMedia);
            AppMethodBeat.m2505o(97210);
        } else {
            FacebookException facebookException = new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[]{shareMedia.getClass().getSimpleName()}));
            AppMethodBeat.m2505o(97210);
            throw facebookException;
        }
    }

    private static void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent, Validator validator) {
        AppMethodBeat.m2504i(97211);
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId())) {
            FacebookException facebookException = new FacebookException("Must specify a non-empty effectId");
            AppMethodBeat.m2505o(97211);
            throw facebookException;
        }
        AppMethodBeat.m2505o(97211);
    }

    private static void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        AppMethodBeat.m2504i(97212);
        validator.validate(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        if (Utility.isNullOrEmpty(previewPropertyName)) {
            FacebookException facebookException = new FacebookException("Must specify a previewPropertyName.");
            AppMethodBeat.m2505o(97212);
            throw facebookException;
        } else if (shareOpenGraphContent.getAction().get(previewPropertyName) == null) {
            FacebookException facebookException2 = new FacebookException("Property \"" + previewPropertyName + "\" was not found on the action. The name of the preview property must match the name of an action property.");
            AppMethodBeat.m2505o(97212);
            throw facebookException2;
        } else {
            AppMethodBeat.m2505o(97212);
        }
    }

    private static void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        AppMethodBeat.m2504i(97213);
        FacebookException facebookException;
        if (shareOpenGraphAction == null) {
            facebookException = new FacebookException("Must specify a non-null ShareOpenGraphAction");
            AppMethodBeat.m2505o(97213);
            throw facebookException;
        } else if (Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
            facebookException = new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
            AppMethodBeat.m2505o(97213);
            throw facebookException;
        } else {
            validator.validate(shareOpenGraphAction, false);
            AppMethodBeat.m2505o(97213);
        }
    }

    private static void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        AppMethodBeat.m2504i(97214);
        if (shareOpenGraphObject == null) {
            FacebookException facebookException = new FacebookException("Cannot share a null ShareOpenGraphObject");
            AppMethodBeat.m2505o(97214);
            throw facebookException;
        }
        validator.validate(shareOpenGraphObject, true);
        AppMethodBeat.m2505o(97214);
    }

    private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer shareOpenGraphValueContainer, Validator validator, boolean z) {
        AppMethodBeat.m2504i(97215);
        for (String str : shareOpenGraphValueContainer.keySet()) {
            validateOpenGraphKey(str, z);
            Object obj = shareOpenGraphValueContainer.get(str);
            if (obj instanceof List) {
                for (Object next : (List) obj) {
                    if (next == null) {
                        FacebookException facebookException = new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                        AppMethodBeat.m2505o(97215);
                        throw facebookException;
                    }
                    validateOpenGraphValueContainerObject(next, validator);
                }
                continue;
            } else {
                validateOpenGraphValueContainerObject(obj, validator);
            }
        }
        AppMethodBeat.m2505o(97215);
    }

    private static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        AppMethodBeat.m2504i(97216);
        FacebookException facebookException;
        if (Utility.isNullOrEmpty(shareMessengerOpenGraphMusicTemplateContent.getPageId())) {
            facebookException = new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
            AppMethodBeat.m2505o(97216);
            throw facebookException;
        } else if (shareMessengerOpenGraphMusicTemplateContent.getUrl() == null) {
            facebookException = new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
            AppMethodBeat.m2505o(97216);
            throw facebookException;
        } else {
            validateShareMessengerActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
            AppMethodBeat.m2505o(97216);
        }
    }

    private static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        AppMethodBeat.m2504i(97217);
        FacebookException facebookException;
        if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getPageId())) {
            facebookException = new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
            AppMethodBeat.m2505o(97217);
            throw facebookException;
        } else if (shareMessengerGenericTemplateContent.getGenericTemplateElement() == null) {
            facebookException = new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
            AppMethodBeat.m2505o(97217);
            throw facebookException;
        } else if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle())) {
            facebookException = new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
            AppMethodBeat.m2505o(97217);
            throw facebookException;
        } else {
            validateShareMessengerActionButton(shareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
            AppMethodBeat.m2505o(97217);
        }
    }

    private static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        AppMethodBeat.m2504i(97218);
        FacebookException facebookException;
        if (Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getPageId())) {
            facebookException = new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
            AppMethodBeat.m2505o(97218);
            throw facebookException;
        } else if (shareMessengerMediaTemplateContent.getMediaUrl() == null && Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getAttachmentId())) {
            facebookException = new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            AppMethodBeat.m2505o(97218);
            throw facebookException;
        } else {
            validateShareMessengerActionButton(shareMessengerMediaTemplateContent.getButton());
            AppMethodBeat.m2505o(97218);
        }
    }

    private static void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        AppMethodBeat.m2504i(97219);
        if (shareMessengerActionButton == null) {
            AppMethodBeat.m2505o(97219);
        } else if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
            FacebookException facebookException = new FacebookException("Must specify title for ShareMessengerActionButton");
            AppMethodBeat.m2505o(97219);
            throw facebookException;
        } else {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
            }
            AppMethodBeat.m2505o(97219);
        }
    }

    private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        AppMethodBeat.m2504i(97220);
        if (shareMessengerURLActionButton.getUrl() == null) {
            FacebookException facebookException = new FacebookException("Must specify url for ShareMessengerURLActionButton");
            AppMethodBeat.m2505o(97220);
            throw facebookException;
        }
        AppMethodBeat.m2505o(97220);
    }

    private static void validateOpenGraphKey(String str, boolean z) {
        AppMethodBeat.m2504i(97221);
        if (z) {
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            FacebookException facebookException;
            if (split.length < 2) {
                facebookException = new FacebookException("Open Graph keys must be namespaced: %s", str);
                AppMethodBeat.m2505o(97221);
                throw facebookException;
            }
            for (String isEmpty : split) {
                if (isEmpty.isEmpty()) {
                    facebookException = new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                    AppMethodBeat.m2505o(97221);
                    throw facebookException;
                }
            }
            AppMethodBeat.m2505o(97221);
            return;
        }
        AppMethodBeat.m2505o(97221);
    }

    private static void validateOpenGraphValueContainerObject(Object obj, Validator validator) {
        AppMethodBeat.m2504i(97222);
        if (obj instanceof ShareOpenGraphObject) {
            validator.validate((ShareOpenGraphObject) obj);
            AppMethodBeat.m2505o(97222);
            return;
        }
        if (obj instanceof SharePhoto) {
            validator.validate((SharePhoto) obj);
        }
        AppMethodBeat.m2505o(97222);
    }
}
