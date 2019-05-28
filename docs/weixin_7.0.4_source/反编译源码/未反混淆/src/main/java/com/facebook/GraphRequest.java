package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIME_BOUNDARY;
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    public static final String TAG = GraphRequest.class.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    static class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private boolean useUrlEncode = false;

        public Serializer(OutputStream outputStream, Logger logger, boolean z) {
            this.outputStream = outputStream;
            this.logger = logger;
            this.useUrlEncode = z;
        }

        public void writeObject(String str, Object obj, GraphRequest graphRequest) {
            AppMethodBeat.i(71652);
            if (this.outputStream instanceof RequestOutputStream) {
                ((RequestOutputStream) this.outputStream).setCurrentRequest(graphRequest);
            }
            RuntimeException invalidTypeError;
            if (GraphRequest.access$000(obj)) {
                writeString(str, GraphRequest.access$100(obj));
                AppMethodBeat.o(71652);
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
                AppMethodBeat.o(71652);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
                AppMethodBeat.o(71652);
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, null);
                AppMethodBeat.o(71652);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, null);
                AppMethodBeat.o(71652);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, mimeType);
                    AppMethodBeat.o(71652);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, mimeType);
                    AppMethodBeat.o(71652);
                } else {
                    invalidTypeError = getInvalidTypeError();
                    AppMethodBeat.o(71652);
                    throw invalidTypeError;
                }
            } else {
                invalidTypeError = getInvalidTypeError();
                AppMethodBeat.o(71652);
                throw invalidTypeError;
            }
        }

        private RuntimeException getInvalidTypeError() {
            AppMethodBeat.i(71653);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("value is not a supported type.");
            AppMethodBeat.o(71653);
            return illegalArgumentException;
        }

        public void writeRequestsAsJson(String str, JSONArray jSONArray, Collection<GraphRequest> collection) {
            AppMethodBeat.i(71654);
            if (this.outputStream instanceof RequestOutputStream) {
                RequestOutputStream requestOutputStream = (RequestOutputStream) this.outputStream;
                writeContentDisposition(str, null, null);
                write("[", new Object[0]);
                int i = 0;
                for (GraphRequest graphRequest : collection) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    requestOutputStream.setCurrentRequest(graphRequest);
                    if (i > 0) {
                        write(",%s", jSONObject.toString());
                    } else {
                        write("%s", jSONObject.toString());
                    }
                    i++;
                }
                write("]", new Object[0]);
                if (this.logger != null) {
                    this.logger.appendKeyValue("    ".concat(String.valueOf(str)), jSONArray.toString());
                }
                AppMethodBeat.o(71654);
                return;
            }
            writeString(str, jSONArray.toString());
            AppMethodBeat.o(71654);
        }

        public void writeString(String str, String str2) {
            AppMethodBeat.i(71655);
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), str2);
            }
            AppMethodBeat.o(71655);
        }

        public void writeBitmap(String str, Bitmap bitmap) {
            AppMethodBeat.i(71656);
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), "<Image>");
            }
            AppMethodBeat.o(71656);
        }

        public void writeBytes(String str, byte[] bArr) {
            AppMethodBeat.i(71657);
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
            AppMethodBeat.o(71657);
        }

        public void writeContentUri(String str, Uri uri, String str2) {
            int i;
            AppMethodBeat.i(71658);
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
            AppMethodBeat.o(71658);
        }

        public void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i;
            AppMethodBeat.i(71659);
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(new AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            if (this.logger != null) {
                this.logger.appendKeyValue("    ".concat(String.valueOf(str)), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
            AppMethodBeat.o(71659);
        }

        public void writeRecordBoundary() {
            AppMethodBeat.i(71660);
            if (this.useUrlEncode) {
                this.outputStream.write("&".getBytes());
                AppMethodBeat.o(71660);
                return;
            }
            writeLine("--%s", GraphRequest.MIME_BOUNDARY);
            AppMethodBeat.o(71660);
        }

        public void writeContentDisposition(String str, String str2, String str3) {
            AppMethodBeat.i(71661);
            if (this.useUrlEncode) {
                this.outputStream.write(String.format("%s=", new Object[]{str}).getBytes());
                AppMethodBeat.o(71661);
                return;
            }
            write("Content-Disposition: form-data; name=\"%s\"", str);
            if (str2 != null) {
                write("; filename=\"%s\"", str2);
            }
            writeLine("", new Object[0]);
            if (str3 != null) {
                writeLine("%s: %s", GraphRequest.CONTENT_TYPE_HEADER, str3);
            }
            writeLine("", new Object[0]);
            AppMethodBeat.o(71661);
        }

        public void write(String str, Object... objArr) {
            AppMethodBeat.i(71662);
            if (this.useUrlEncode) {
                this.outputStream.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
                AppMethodBeat.o(71662);
                return;
            }
            if (this.firstWrite) {
                this.outputStream.write("--".getBytes());
                this.outputStream.write(GraphRequest.MIME_BOUNDARY.getBytes());
                this.outputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                this.firstWrite = false;
            }
            this.outputStream.write(String.format(str, objArr).getBytes());
            AppMethodBeat.o(71662);
        }

        public void writeLine(String str, Object... objArr) {
            AppMethodBeat.i(71663);
            write(str, objArr);
            if (!this.useUrlEncode) {
                write(IOUtils.LINE_SEPARATOR_WINDOWS, new Object[0]);
            }
            AppMethodBeat.o(71663);
        }
    }

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    static class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            this.request = graphRequest;
            this.value = obj;
        }

        public GraphRequest getRequest() {
            return this.request;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new Creator<ParcelableResourceWithMimeType>() {
            public final ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                AppMethodBeat.i(71646);
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(parcel, null);
                AppMethodBeat.o(71646);
                return parcelableResourceWithMimeType;
            }

            public final ParcelableResourceWithMimeType[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        };
        private final String mimeType;
        private final RESOURCE resource;

        public String getMimeType() {
            return this.mimeType;
        }

        public RESOURCE getResource() {
            return this.resource;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(71649);
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i);
            AppMethodBeat.o(71649);
        }

        static {
            AppMethodBeat.i(71651);
            AppMethodBeat.o(71651);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            AppMethodBeat.i(71650);
            this.mimeType = parcel.readString();
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
            AppMethodBeat.o(71650);
        }
    }

    static /* synthetic */ boolean access$000(Object obj) {
        AppMethodBeat.i(71721);
        boolean isSupportedParameterType = isSupportedParameterType(obj);
        AppMethodBeat.o(71721);
        return isSupportedParameterType;
    }

    static /* synthetic */ String access$100(Object obj) {
        AppMethodBeat.i(71722);
        String parameterToString = parameterToString(obj);
        AppMethodBeat.o(71722);
        return parameterToString;
    }

    static {
        AppMethodBeat.i(71723);
        char[] toCharArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(toCharArray[secureRandom.nextInt(toCharArray.length)]);
        }
        MIME_BOUNDARY = stringBuilder.toString();
        AppMethodBeat.o(71723);
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str) {
        this(accessToken, str, null, null, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        AppMethodBeat.i(71664);
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
        AppMethodBeat.o(71664);
    }

    GraphRequest(AccessToken accessToken, URL url) {
        AppMethodBeat.i(71665);
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
        AppMethodBeat.o(71665);
    }

    public static GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
        AppMethodBeat.i(71666);
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.DELETE, callback);
        AppMethodBeat.o(71666);
        return graphRequest;
    }

    public static GraphRequest newMeRequest(AccessToken accessToken, final GraphJSONObjectCallback graphJSONObjectCallback) {
        AppMethodBeat.i(71667);
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, ME, null, null, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(71640);
                if (graphJSONObjectCallback != null) {
                    graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
                }
                AppMethodBeat.o(71640);
            }
        });
        AppMethodBeat.o(71667);
        return graphRequest;
    }

    public static GraphRequest newPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        AppMethodBeat.i(71668);
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback);
        graphRequest.setGraphObject(jSONObject);
        AppMethodBeat.o(71668);
        return graphRequest;
    }

    public static GraphRequest newMyFriendsRequest(AccessToken accessToken, final GraphJSONArrayCallback graphJSONArrayCallback) {
        AppMethodBeat.i(71669);
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, MY_FRIENDS, null, null, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(71641);
                if (graphJSONArrayCallback != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
                AppMethodBeat.o(71641);
            }
        });
        AppMethodBeat.o(71669);
        return graphRequest;
    }

    public static GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
        AppMethodBeat.i(71670);
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, null, callback);
        AppMethodBeat.o(71670);
        return graphRequest;
    }

    public static GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i, int i2, String str, final GraphJSONArrayCallback graphJSONArrayCallback) {
        AppMethodBeat.i(71671);
        if (location == null && Utility.isNullOrEmpty(str)) {
            FacebookException facebookException = new FacebookException("Either location or searchText must be specified.");
            AppMethodBeat.o(71671);
            throw facebookException;
        }
        Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", i2);
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("q", str);
        }
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, "search", bundle, HttpMethod.GET, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(71642);
                if (graphJSONArrayCallback != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
                AppMethodBeat.o(71642);
            }
        });
        AppMethodBeat.o(71671);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
        AppMethodBeat.i(71672);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (!(str2 == null || str2.isEmpty())) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
        AppMethodBeat.o(71672);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) {
        AppMethodBeat.i(71673);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (!(str2 == null || str2.isEmpty())) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
        AppMethodBeat.o(71673);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) {
        AppMethodBeat.i(71674);
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        GraphRequest newUploadPhotoRequest;
        if (Utility.isFileUri(uri)) {
            newUploadPhotoRequest = newUploadPhotoRequest(accessToken, defaultPhotoPathIfNull, new File(uri.getPath()), str2, bundle, callback);
            AppMethodBeat.o(71674);
            return newUploadPhotoRequest;
        } else if (Utility.isContentUri(uri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", uri);
            if (!(str2 == null || str2.isEmpty())) {
                bundle2.putString("caption", str2);
            }
            newUploadPhotoRequest = new GraphRequest(accessToken, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback);
            AppMethodBeat.o(71674);
            return newUploadPhotoRequest;
        } else {
            FacebookException facebookException = new FacebookException("The photo Uri must be either a file:// or content:// Uri");
            AppMethodBeat.o(71674);
            throw facebookException;
        }
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
        String str2;
        AppMethodBeat.i(71675);
        if (str != null || accessToken == null) {
            str2 = str;
        } else {
            str2 = accessToken.getApplicationId();
        }
        if (str2 == null) {
            str2 = Utility.getMetadataApplicationId(context);
        }
        FacebookException facebookException;
        if (str2 == null) {
            facebookException = new FacebookException("Facebook App ID cannot be determined");
            AppMethodBeat.o(71675);
            throw facebookException;
        }
        String str3 = str2 + "/custom_audience_third_party_id";
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        Bundle bundle = new Bundle();
        if (accessToken == null) {
            if (attributionIdentifiers == null) {
                facebookException = new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                AppMethodBeat.o(71675);
                throw facebookException;
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                str2 = attributionIdentifiers.getAttributionId();
            } else {
                str2 = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                bundle.putString("udid", str2);
            }
        }
        if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
            bundle.putString("limit_event_usage", "1");
        }
        GraphRequest graphRequest = new GraphRequest(accessToken, str3, bundle, HttpMethod.GET, callback);
        AppMethodBeat.o(71675);
        return graphRequest;
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
        AppMethodBeat.i(71676);
        GraphRequest newCustomAudienceThirdPartyIdRequest = newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
        AppMethodBeat.o(71676);
        return newCustomAudienceThirdPartyIdRequest;
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        AppMethodBeat.i(71677);
        if (this.overriddenURL == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.httpMethod = httpMethod;
            AppMethodBeat.o(71677);
            return;
        }
        FacebookException facebookException = new FacebookException("Can't change HTTP method on request with overridden URL.");
        AppMethodBeat.o(71677);
        throw facebookException;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void setSkipClientToken(boolean z) {
        this.skipClientToken = z;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(final Callback callback) {
        AppMethodBeat.i(71678);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    AppMethodBeat.i(71643);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null) {
                        jSONObject = jSONObject.optJSONObject(GraphRequest.DEBUG_KEY);
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        optJSONArray = jSONObject.optJSONArray(GraphRequest.DEBUG_MESSAGES_KEY);
                    } else {
                        optJSONArray = null;
                    }
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString;
                            String optString2;
                            String optString3;
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                optString = optJSONObject.optString("message");
                            } else {
                                optString = null;
                            }
                            if (optJSONObject != null) {
                                optString2 = optJSONObject.optString("type");
                            } else {
                                optString2 = null;
                            }
                            if (optJSONObject != null) {
                                optString3 = optJSONObject.optString("link");
                            } else {
                                optString3 = null;
                            }
                            if (!(optString == null || optString2 == null)) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals(GraphRequest.DEBUG_SEVERITY_WARNING)) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!Utility.isNullOrEmpty(optString3)) {
                                    optString = optString + " Link: " + optString3;
                                }
                                Logger.log(loggingBehavior, GraphRequest.TAG, optString);
                            }
                        }
                    }
                    if (callback != null) {
                        callback.onCompleted(graphResponse);
                    }
                    AppMethodBeat.o(71643);
                }
            };
            AppMethodBeat.o(71678);
            return;
        }
        this.callback = callback;
        AppMethodBeat.o(71678);
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final GraphResponse executeAndWait() {
        AppMethodBeat.i(71679);
        GraphResponse executeAndWait = executeAndWait(this);
        AppMethodBeat.o(71679);
        return executeAndWait;
    }

    public final GraphRequestAsyncTask executeAsync() {
        AppMethodBeat.i(71680);
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(this);
        AppMethodBeat.o(71680);
        return executeBatchAsync;
    }

    public static HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(71681);
        HttpURLConnection toHttpConnection = toHttpConnection(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(71681);
        return toHttpConnection;
    }

    public static HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        AppMethodBeat.i(71682);
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        HttpURLConnection toHttpConnection = toHttpConnection(new GraphRequestBatch((Collection) collection));
        AppMethodBeat.o(71682);
        return toHttpConnection;
    }

    public static HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        FacebookException facebookException;
        AppMethodBeat.i(71683);
        validateFieldsParamForGetRequests(graphRequestBatch);
        try {
            URL url;
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            URLConnection uRLConnection = null;
            try {
                uRLConnection = createConnection(url);
                serializeToUrlConnection(graphRequestBatch, uRLConnection);
                AppMethodBeat.o(71683);
                return uRLConnection;
            } catch (IOException | JSONException e) {
                Utility.disconnectQuietly(uRLConnection);
                facebookException = new FacebookException("could not construct request body", e);
                AppMethodBeat.o(71683);
                throw facebookException;
            }
        } catch (MalformedURLException e2) {
            facebookException = new FacebookException("could not construct URL for request", e2);
            AppMethodBeat.o(71683);
            throw facebookException;
        }
    }

    public static GraphResponse executeAndWait(GraphRequest graphRequest) {
        AppMethodBeat.i(71684);
        List executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait == null || executeBatchAndWait.size() != 1) {
            FacebookException facebookException = new FacebookException("invalid state: expected a single response");
            AppMethodBeat.o(71684);
            throw facebookException;
        }
        GraphResponse graphResponse = (GraphResponse) executeBatchAndWait.get(0);
        AppMethodBeat.o(71684);
        return graphResponse;
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(71685);
        Validate.notNull(graphRequestArr, "requests");
        List executeBatchAndWait = executeBatchAndWait(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(71685);
        return executeBatchAndWait;
    }

    public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        AppMethodBeat.i(71686);
        List executeBatchAndWait = executeBatchAndWait(new GraphRequestBatch((Collection) collection));
        AppMethodBeat.o(71686);
        return executeBatchAndWait;
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> executeConnectionAndWait;
        URLConnection uRLConnection = null;
        AppMethodBeat.i(71687);
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        try {
            uRLConnection = toHttpConnection(graphRequestBatch);
            executeConnectionAndWait = executeConnectionAndWait((HttpURLConnection) uRLConnection, graphRequestBatch);
        } catch (Exception e) {
            executeConnectionAndWait = GraphResponse.constructErrorResponses(graphRequestBatch.getRequests(), null, new FacebookException(e));
            runCallbacks(graphRequestBatch, executeConnectionAndWait);
        } finally {
            Utility.disconnectQuietly(uRLConnection);
            AppMethodBeat.o(71687);
        }
        return executeConnectionAndWait;
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        AppMethodBeat.i(71688);
        Validate.notNull(graphRequestArr, "requests");
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(Arrays.asList(graphRequestArr));
        AppMethodBeat.o(71688);
        return executeBatchAsync;
    }

    public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        AppMethodBeat.i(71689);
        GraphRequestAsyncTask executeBatchAsync = executeBatchAsync(new GraphRequestBatch((Collection) collection));
        AppMethodBeat.o(71689);
        return executeBatchAsync;
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71690);
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        AppMethodBeat.o(71690);
        return graphRequestAsyncTask;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        AppMethodBeat.i(71691);
        List executeConnectionAndWait = executeConnectionAndWait(httpURLConnection, new GraphRequestBatch((Collection) collection));
        AppMethodBeat.o(71691);
        return executeConnectionAndWait;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71692);
        List fromHttpConnection = GraphResponse.fromHttpConnection(httpURLConnection, graphRequestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        if (graphRequestBatch.size() != fromHttpConnection.size()) {
            FacebookException facebookException = new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(graphRequestBatch.size())}));
            AppMethodBeat.o(71692);
            throw facebookException;
        }
        runCallbacks(graphRequestBatch, fromHttpConnection);
        AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
        AppMethodBeat.o(71692);
        return fromHttpConnection;
    }

    public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71693);
        GraphRequestAsyncTask executeConnectionAsync = executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
        AppMethodBeat.o(71693);
        return executeConnectionAsync;
    }

    public static GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71694);
        Validate.notNull(httpURLConnection, "connection");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.setCallbackHandler(handler);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        AppMethodBeat.o(71694);
        return graphRequestAsyncTask;
    }

    public String toString() {
        AppMethodBeat.i(71695);
        String str = "{Request:  accessToken: " + (this.accessToken == null ? BuildConfig.COMMAND : this.accessToken) + ", graphPath: " + this.graphPath + ", graphObject: " + this.graphObject + ", httpMethod: " + this.httpMethod + ", parameters: " + this.parameters + "}";
        AppMethodBeat.o(71695);
        return str;
    }

    static void runCallbacks(final GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        AppMethodBeat.i(71696);
        int size = graphRequestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            GraphRequest graphRequest = graphRequestBatch.get(i);
            if (graphRequest.callback != null) {
                arrayList.add(new Pair(graphRequest.callback, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            AnonymousClass5 anonymousClass5 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(71644);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((GraphResponse) pair.second);
                    }
                    for (com.facebook.GraphRequestBatch.Callback onBatchCompleted : graphRequestBatch.getCallbacks()) {
                        onBatchCompleted.onBatchCompleted(graphRequestBatch);
                    }
                    AppMethodBeat.o(71644);
                }
            };
            Handler callbackHandler = graphRequestBatch.getCallbackHandler();
            if (callbackHandler == null) {
                anonymousClass5.run();
                AppMethodBeat.o(71696);
                return;
            }
            callbackHandler.post(anonymousClass5);
        }
        AppMethodBeat.o(71696);
    }

    private static String getDefaultPhotoPathIfNull(String str) {
        return str == null ? "me/photos" : str;
    }

    private static HttpURLConnection createConnection(URL url) {
        AppMethodBeat.i(71697);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestProperty(USER_AGENT_HEADER, getUserAgent());
        httpURLConnection.setRequestProperty(ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        AppMethodBeat.o(71697);
        return httpURLConnection;
    }

    private void addCommonParameters() {
        AppMethodBeat.i(71698);
        String token;
        if (this.accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                token = this.accessToken.getToken();
                Logger.registerAccessToken(token);
                this.parameters.putString("access_token", token);
            }
        } else if (!(this.skipClientToken || this.parameters.containsKey("access_token"))) {
            token = FacebookSdk.getApplicationId();
            String clientToken = FacebookSdk.getClientToken();
            if (Utility.isNullOrEmpty(token) || Utility.isNullOrEmpty(clientToken)) {
                Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.parameters.putString("access_token", token + "|" + clientToken);
            }
        }
        this.parameters.putString("sdk", "android");
        this.parameters.putString(FORMAT_PARAM, FORMAT_JSON);
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.parameters.putString("debug", DEBUG_SEVERITY_INFO);
            AppMethodBeat.o(71698);
            return;
        }
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.parameters.putString("debug", DEBUG_SEVERITY_WARNING);
        }
        AppMethodBeat.o(71698);
    }

    private String appendParametersToBaseUrl(String str, Boolean bool) {
        AppMethodBeat.i(71699);
        if (bool.booleanValue() || this.httpMethod != HttpMethod.POST) {
            Builder buildUpon = Uri.parse(str).buildUpon();
            for (String str2 : this.parameters.keySet()) {
                Object obj = this.parameters.get(str2);
                if (obj == null) {
                    obj = "";
                }
                if (isSupportedParameterType(obj)) {
                    buildUpon.appendQueryParameter(str2, parameterToString(obj).toString());
                } else if (this.httpMethod == HttpMethod.GET) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
                    AppMethodBeat.o(71699);
                    throw illegalArgumentException;
                }
            }
            str = buildUpon.toString();
            AppMethodBeat.o(71699);
            return str;
        }
        AppMethodBeat.o(71699);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final String getRelativeUrlForBatchedRequest() {
        AppMethodBeat.i(71700);
        if (this.overriddenURL != null) {
            FacebookException facebookException = new FacebookException("Can't override URL for a batch request");
            AppMethodBeat.o(71700);
            throw facebookException;
        }
        String format = String.format(GRAPH_PATH_FORMAT, new Object[]{ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion()});
        addCommonParameters();
        Uri parse = Uri.parse(appendParametersToBaseUrl(format, Boolean.TRUE));
        format = String.format("%s?%s", new Object[]{parse.getPath(), parse.getQuery()});
        AppMethodBeat.o(71700);
        return format;
    }

    /* Access modifiers changed, original: final */
    public final String getUrlForSingleRequest() {
        AppMethodBeat.i(71701);
        String str;
        if (this.overriddenURL != null) {
            str = this.overriddenURL.toString();
            AppMethodBeat.o(71701);
            return str;
        }
        if (getHttpMethod() == HttpMethod.POST && this.graphPath != null && this.graphPath.endsWith(VIDEOS_SUFFIX)) {
            str = ServerProtocol.getGraphVideoUrlBase();
        } else {
            str = ServerProtocol.getGraphUrlBase();
        }
        str = String.format(GRAPH_PATH_FORMAT, new Object[]{str, getGraphPathWithVersion()});
        addCommonParameters();
        str = appendParametersToBaseUrl(str, Boolean.FALSE);
        AppMethodBeat.o(71701);
        return str;
    }

    private String getGraphPathWithVersion() {
        AppMethodBeat.i(71702);
        String str;
        if (versionPattern.matcher(this.graphPath).matches()) {
            str = this.graphPath;
            AppMethodBeat.o(71702);
            return str;
        }
        str = String.format(GRAPH_PATH_FORMAT, new Object[]{this.version, this.graphPath});
        AppMethodBeat.o(71702);
        return str;
    }

    private void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) {
        AppMethodBeat.i(71703);
        JSONObject jSONObject = new JSONObject();
        if (this.batchEntryName != null) {
            jSONObject.put("name", this.batchEntryName);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        if (this.batchEntryDependsOn != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, this.batchEntryDependsOn);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put("method", this.httpMethod);
        if (this.accessToken != null) {
            Logger.registerAccessToken(this.accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.parameters.keySet()) {
            Object obj = this.parameters.get(str);
            if (isSupportedAttachmentType(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", new Object[]{ATTACHMENT_FILENAME_PREFIX, Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            final ArrayList arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, relativeUrlForBatchedRequest, new KeyValueSerializer() {
                public void writeString(String str, String str2) {
                    AppMethodBeat.i(71645);
                    arrayList2.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
                    AppMethodBeat.o(71645);
                }
            });
            jSONObject.put(BATCH_BODY_PARAM, TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
        AppMethodBeat.o(71703);
    }

    private static boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71704);
        for (com.facebook.GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
            if (callback instanceof com.facebook.GraphRequestBatch.OnProgressCallback) {
                AppMethodBeat.o(71704);
                return true;
            }
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).getCallback() instanceof OnProgressCallback) {
                AppMethodBeat.o(71704);
                return true;
            }
        }
        AppMethodBeat.o(71704);
        return false;
    }

    private static void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
        AppMethodBeat.i(71705);
        if (z) {
            httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty(CONTENT_ENCODING_HEADER, "gzip");
            AppMethodBeat.o(71705);
            return;
        }
        httpURLConnection.setRequestProperty(CONTENT_TYPE_HEADER, getMimeContentType());
        AppMethodBeat.o(71705);
    }

    private static boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71706);
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            for (String str : graphRequest.parameters.keySet()) {
                if (isSupportedAttachmentType(graphRequest.parameters.get(str))) {
                    AppMethodBeat.o(71706);
                    return false;
                }
            }
        }
        AppMethodBeat.o(71706);
        return true;
    }

    static final boolean shouldWarnOnMissingFieldsParam(GraphRequest graphRequest) {
        AppMethodBeat.i(71707);
        String version = graphRequest.getVersion();
        if (Utility.isNullOrEmpty(version)) {
            AppMethodBeat.o(71707);
            return true;
        }
        if (version.startsWith("v")) {
            version = version.substring(1);
        }
        String[] split = version.split("\\.");
        if ((split.length < 2 || Integer.parseInt(split[0]) <= 2) && (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4)) {
            AppMethodBeat.o(71707);
            return false;
        }
        AppMethodBeat.o(71707);
        return true;
    }

    static final void validateFieldsParamForGetRequests(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71708);
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            if (HttpMethod.GET.equals(graphRequest.getHttpMethod()) && shouldWarnOnMissingFieldsParam(graphRequest)) {
                Bundle parameters = graphRequest.getParameters();
                if (!parameters.containsKey(FIELDS_PARAM) || Utility.isNullOrEmpty(parameters.getString(FIELDS_PARAM))) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", graphRequest.getGraphPath());
                }
            }
        }
        AppMethodBeat.o(71708);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final void serializeToUrlConnection(GraphRequestBatch graphRequestBatch, HttpURLConnection httpURLConnection) {
        Throwable th;
        AppMethodBeat.i(71709);
        Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        int size = graphRequestBatch.size();
        boolean isGzipCompressible = isGzipCompressible(graphRequestBatch);
        HttpMethod httpMethod = size == 1 ? graphRequestBatch.get(0).httpMethod : HttpMethod.POST;
        httpURLConnection.setRequestMethod(httpMethod.name());
        setConnectionContentType(httpURLConnection, isGzipCompressible);
        URL url = httpURLConnection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", graphRequestBatch.getId());
        logger.appendKeyValue("URL", url);
        logger.appendKeyValue("Method", httpURLConnection.getRequestMethod());
        logger.appendKeyValue(USER_AGENT_HEADER, httpURLConnection.getRequestProperty(USER_AGENT_HEADER));
        logger.appendKeyValue(CONTENT_TYPE_HEADER, httpURLConnection.getRequestProperty(CONTENT_TYPE_HEADER));
        httpURLConnection.setConnectTimeout(graphRequestBatch.getTimeout());
        httpURLConnection.setReadTimeout(graphRequestBatch.getTimeout());
        if (httpMethod == HttpMethod.POST) {
            httpURLConnection.setDoOutput(true);
            OutputStream bufferedOutputStream;
            try {
                OutputStream progressOutputStream;
                bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                if (isGzipCompressible) {
                    try {
                        bufferedOutputStream = new GZIPOutputStream(bufferedOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedOutputStream != null) {
                        }
                        AppMethodBeat.o(71709);
                        throw th;
                    }
                }
                if (hasOnProgressCallbacks(graphRequestBatch)) {
                    ProgressNoopOutputStream progressNoopOutputStream = new ProgressNoopOutputStream(graphRequestBatch.getCallbackHandler());
                    processRequest(graphRequestBatch, null, size, url, progressNoopOutputStream, isGzipCompressible);
                    progressOutputStream = new ProgressOutputStream(bufferedOutputStream, graphRequestBatch, progressNoopOutputStream.getProgressMap(), (long) progressNoopOutputStream.getMaxProgress());
                } else {
                    progressOutputStream = bufferedOutputStream;
                }
                try {
                    processRequest(graphRequestBatch, logger, size, url, progressOutputStream, isGzipCompressible);
                    progressOutputStream.close();
                    logger.log();
                    AppMethodBeat.o(71709);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = progressOutputStream;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    AppMethodBeat.o(71709);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                if (bufferedOutputStream != null) {
                }
                AppMethodBeat.o(71709);
                throw th;
            }
        }
        logger.log();
        AppMethodBeat.o(71709);
    }

    private static void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) {
        AppMethodBeat.i(71710);
        Serializer serializer = new Serializer(outputStream, logger, z);
        String batchAppId;
        if (i == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String batchAppId2 : graphRequest.parameters.keySet()) {
                Object obj = graphRequest.parameters.get(batchAppId2);
                if (isSupportedAttachmentType(obj)) {
                    hashMap.put(batchAppId2, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.parameters, serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap, serializer);
            if (graphRequest.graphObject != null) {
                processGraphObject(graphRequest.graphObject, url.getPath(), serializer);
            }
            AppMethodBeat.o(71710);
            return;
        }
        batchAppId2 = getBatchAppId(graphRequestBatch);
        if (Utility.isNullOrEmpty(batchAppId2)) {
            FacebookException facebookException = new FacebookException("App ID was not specified at the request or Settings.");
            AppMethodBeat.o(71710);
            throw facebookException;
        }
        serializer.writeString(BATCH_APP_ID_PARAM, batchAppId2);
        HashMap hashMap2 = new HashMap();
        serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
        if (logger != null) {
            logger.append("  Attachments:\n");
        }
        serializeAttachments(hashMap2, serializer);
        AppMethodBeat.o(71710);
    }

    private static boolean isMeRequest(String str) {
        AppMethodBeat.i(71711);
        Matcher matcher = versionPattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            AppMethodBeat.o(71711);
            return true;
        }
        AppMethodBeat.o(71711);
        return false;
    }

    private static void processGraphObject(JSONObject jSONObject, String str, KeyValueSerializer keyValueSerializer) {
        Object obj;
        AppMethodBeat.i(71712);
        if (isMeRequest(str)) {
            int indexOf = str.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            int indexOf2 = str.indexOf("?");
            Object obj2 = (indexOf <= 3 || (indexOf2 != -1 && indexOf >= indexOf2)) ? null : 1;
            obj = obj2;
        } else {
            obj = null;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            boolean z;
            String str2 = (String) keys.next();
            Object opt = jSONObject.opt(str2);
            if (obj == null || !str2.equalsIgnoreCase("image")) {
                z = false;
            } else {
                z = true;
            }
            processGraphObjectProperty(str2, opt, keyValueSerializer, z);
        }
        AppMethodBeat.o(71712);
    }

    private static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) {
        AppMethodBeat.i(71713);
        Object obj2 = obj;
        while (true) {
            Class cls = obj2.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj2;
                if (z) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        Object[] objArr = new Object[]{str, (String) keys.next()};
                        processGraphObjectProperty(String.format("%s[%s]", objArr), jSONObject.opt((String) keys.next()), keyValueSerializer, z);
                    }
                    AppMethodBeat.o(71713);
                    return;
                } else if (jSONObject.has("id")) {
                    obj2 = jSONObject.optString("id");
                } else if (jSONObject.has("url")) {
                    obj2 = jSONObject.optString("url");
                } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    obj2 = jSONObject.toString();
                } else {
                    AppMethodBeat.o(71713);
                    return;
                }
            } else if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) obj2;
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), keyValueSerializer, z);
                }
                AppMethodBeat.o(71713);
                return;
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, obj2.toString());
                AppMethodBeat.o(71713);
                return;
            } else {
                if (Date.class.isAssignableFrom(cls)) {
                    keyValueSerializer.writeString(str, new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj2));
                }
                AppMethodBeat.o(71713);
                return;
            }
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
        AppMethodBeat.i(71714);
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                serializer.writeObject(str, obj, graphRequest);
            }
        }
        AppMethodBeat.o(71714);
    }

    private static void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
        AppMethodBeat.i(71715);
        for (String str : map.keySet()) {
            Attachment attachment = (Attachment) map.get(str);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(str, attachment.getValue(), attachment.getRequest());
            }
        }
        AppMethodBeat.o(71715);
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
        AppMethodBeat.i(71716);
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest serializeToBatch : collection) {
            serializeToBatch.serializeToBatch(jSONArray, map);
        }
        serializer.writeRequestsAsJson(BATCH_PARAM, jSONArray, collection);
        AppMethodBeat.o(71716);
    }

    private static String getMimeContentType() {
        AppMethodBeat.i(71717);
        String format = String.format("multipart/form-data; boundary=%s", new Object[]{MIME_BOUNDARY});
        AppMethodBeat.o(71717);
        return format;
    }

    private static String getUserAgent() {
        AppMethodBeat.i(71718);
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{USER_AGENT_BASE, FacebookSdkVersion.BUILD});
            if (!Utility.isNullOrEmpty(InternalSettings.getCustomUserAgent())) {
                userAgent = String.format(Locale.ROOT, GRAPH_PATH_FORMAT, new Object[]{userAgent, r0});
            }
        }
        String str = userAgent;
        AppMethodBeat.o(71718);
        return str;
    }

    private static String getBatchAppId(GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71719);
        String applicationId;
        if (Utility.isNullOrEmpty(graphRequestBatch.getBatchApplicationId())) {
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = ((GraphRequest) it.next()).accessToken;
                if (accessToken != null) {
                    applicationId = accessToken.getApplicationId();
                    if (applicationId != null) {
                        AppMethodBeat.o(71719);
                        return applicationId;
                    }
                }
            }
            if (Utility.isNullOrEmpty(defaultBatchApplicationId)) {
                applicationId = FacebookSdk.getApplicationId();
                AppMethodBeat.o(71719);
                return applicationId;
            }
            applicationId = defaultBatchApplicationId;
            AppMethodBeat.o(71719);
            return applicationId;
        }
        applicationId = graphRequestBatch.getBatchApplicationId();
        AppMethodBeat.o(71719);
        return applicationId;
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    private static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    private static String parameterToString(Object obj) {
        AppMethodBeat.i(71720);
        String str;
        if (obj instanceof String) {
            str = (String) obj;
            AppMethodBeat.o(71720);
            return str;
        } else if ((obj instanceof Boolean) || (obj instanceof Number)) {
            str = obj.toString();
            AppMethodBeat.o(71720);
            return str;
        } else if (obj instanceof Date) {
            str = new SimpleDateFormat(ISO_8601_FORMAT_STRING, Locale.US).format(obj);
            AppMethodBeat.o(71720);
            return str;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported parameter type.");
            AppMethodBeat.o(71720);
            throw illegalArgumentException;
        }
    }
}
