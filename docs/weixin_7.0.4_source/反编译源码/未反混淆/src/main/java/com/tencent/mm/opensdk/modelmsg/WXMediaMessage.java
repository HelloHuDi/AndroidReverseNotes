package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            AppMethodBeat.i(128329);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
            if (pathOldToNew == null || pathOldToNew.length() <= 0) {
                AppMethodBeat.o(128329);
                return wXMediaMessage;
            }
            try {
                wXMediaMessage.mediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                wXMediaMessage.mediaObject.unserialize(bundle);
                AppMethodBeat.o(128329);
                return wXMediaMessage;
            } catch (Exception e) {
                Log.e(WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
                AppMethodBeat.o(128329);
                return wXMediaMessage;
            }
        }

        private static String pathNewToOld(String str) {
            AppMethodBeat.i(128330);
            if (str == null || str.length() == 0) {
                Log.e(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
                AppMethodBeat.o(128330);
                return str;
            }
            str = str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
            AppMethodBeat.o(128330);
            return str;
        }

        private static String pathOldToNew(String str) {
            AppMethodBeat.i(128331);
            Log.i(WXMediaMessage.TAG, "pathOldToNew, oldPath = ".concat(String.valueOf(str)));
            if (str == null || str.length() == 0) {
                Log.e(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
                AppMethodBeat.o(128331);
                return str;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                Log.e(WXMediaMessage.TAG, "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(str)));
                AppMethodBeat.o(128331);
                return str;
            }
            str = "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
            AppMethodBeat.o(128331);
            return str;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            AppMethodBeat.i(128328);
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            AppMethodBeat.o(128328);
            return bundle;
        }
    }

    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_BUSINESS_CARD = 45;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* Access modifiers changed, original: final */
    public final boolean checkArgs() {
        AppMethodBeat.i(128293);
        if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null when send emoji");
            AppMethodBeat.o(128293);
            return false;
        } else if (d.a(getType()) && (this.thumbData == null || this.thumbData.length > MINI_PROGRAM__THUMB_LENGHT)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null or exceed 128kb");
            AppMethodBeat.o(128293);
            return false;
        } else if (!d.a(getType()) && this.thumbData != null && this.thumbData.length > 65536) {
            Log.e(TAG, "checkArgs fail, thumbData is invalid");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.title != null && this.title.length() > 512) {
            Log.e(TAG, "checkArgs fail, title is invalid");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.description != null && this.description.length() > DESCRIPTION_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, description is invalid");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.mediaObject == null) {
            Log.e(TAG, "checkArgs fail, mediaObject is null");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.mediaTagName != null && this.mediaTagName.length() > 64) {
            Log.e(TAG, "checkArgs fail, mediaTagName is too long");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.messageAction != null && this.messageAction.length() > 2048) {
            Log.e(TAG, "checkArgs fail, messageAction is too long");
            AppMethodBeat.o(128293);
            return false;
        } else if (this.messageExt == null || this.messageExt.length() <= 2048) {
            boolean checkArgs = this.mediaObject.checkArgs();
            AppMethodBeat.o(128293);
            return checkArgs;
        } else {
            Log.e(TAG, "checkArgs fail, messageExt is too long");
            AppMethodBeat.o(128293);
            return false;
        }
    }

    public final int getType() {
        AppMethodBeat.i(128291);
        if (this.mediaObject == null) {
            AppMethodBeat.o(128291);
            return 0;
        }
        int type = this.mediaObject.type();
        AppMethodBeat.o(128291);
        return type;
    }

    public final void setThumbImage(Bitmap bitmap) {
        AppMethodBeat.i(128292);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(128292);
        } catch (Exception e) {
            Log.e(TAG, "setThumbImage exception:" + e.getMessage());
            AppMethodBeat.o(128292);
        }
    }
}
