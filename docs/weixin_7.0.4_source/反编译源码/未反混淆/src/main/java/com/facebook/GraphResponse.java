package com.facebook;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    private static final String RESPONSE_LOG_TAG = "Response";
    public static final String SUCCESS_KEY = "success";
    private static final String TAG = GraphResponse.class.getSimpleName();
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final String rawResponse;
    private final GraphRequest request;

    public enum PagingDirection {
        NEXT,
        PREVIOUS;

        static {
            AppMethodBeat.o(71761);
        }
    }

    static {
        AppMethodBeat.i(71770);
        AppMethodBeat.o(71770);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, null, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, null, jSONArray, null);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, null, null, null, facebookRequestError);
    }

    GraphResponse(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        this.request = graphRequest;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public GraphRequest getRequest() {
        return this.request;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GraphRequest getRequestForPagedResults(PagingDirection pagingDirection) {
        String optString;
        AppMethodBeat.i(71762);
        if (this.graphObject != null) {
            JSONObject optJSONObject = this.graphObject.optJSONObject("paging");
            if (optJSONObject != null) {
                if (pagingDirection == PagingDirection.NEXT) {
                    optString = optJSONObject.optString("next");
                } else {
                    optString = optJSONObject.optString("previous");
                }
                if (!Utility.isNullOrEmpty(optString)) {
                    AppMethodBeat.o(71762);
                    return null;
                } else if (optString == null || !optString.equals(this.request.getUrlForSingleRequest())) {
                    try {
                        GraphRequest graphRequest = new GraphRequest(this.request.getAccessToken(), new URL(optString));
                        AppMethodBeat.o(71762);
                        return graphRequest;
                    } catch (MalformedURLException e) {
                        AppMethodBeat.o(71762);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(71762);
                    return null;
                }
            }
        }
        optString = null;
        if (!Utility.isNullOrEmpty(optString)) {
        }
    }

    public String toString() {
        String format;
        AppMethodBeat.i(71763);
        try {
            Locale locale = Locale.US;
            String str = "%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.connection != null ? this.connection.getResponseCode() : 200);
            format = String.format(locale, str, objArr);
        } catch (IOException e) {
            format = "unknown";
        }
        format = "{Response:  responseCode: " + format + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        AppMethodBeat.o(71763);
        return format;
    }

    static List<GraphResponse> fromHttpConnection(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> createResponsesFromStream;
        AppMethodBeat.i(71764);
        Closeable closeable = null;
        try {
            if (httpURLConnection.getResponseCode() >= 400) {
                closeable = httpURLConnection.getErrorStream();
            } else {
                closeable = httpURLConnection.getInputStream();
            }
            createResponsesFromStream = createResponsesFromStream(closeable, httpURLConnection, graphRequestBatch);
        } catch (FacebookException e) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e);
            createResponsesFromStream = constructErrorResponses(graphRequestBatch, httpURLConnection, e);
        } catch (Exception e2) {
            Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response <Error>: %s", e2);
            createResponsesFromStream = constructErrorResponses(graphRequestBatch, httpURLConnection, new FacebookException(e2));
        } finally {
            Utility.closeQuietly(closeable);
            AppMethodBeat.o(71764);
        }
        return createResponsesFromStream;
    }

    static List<GraphResponse> createResponsesFromStream(InputStream inputStream, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71765);
        Logger.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(Utility.readStreamToString(inputStream).length()), r0);
        List createResponsesFromString = createResponsesFromString(r0, httpURLConnection, graphRequestBatch);
        AppMethodBeat.o(71765);
        return createResponsesFromString;
    }

    static List<GraphResponse> createResponsesFromString(String str, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        AppMethodBeat.i(71766);
        Logger.log(LoggingBehavior.REQUESTS, RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", graphRequestBatch.getId(), Integer.valueOf(str.length()), createResponsesFromObject(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue()));
        AppMethodBeat.o(71766);
        return createResponsesFromObject(httpURLConnection, graphRequestBatch, new JSONTokener(str).nextValue());
    }

    private static List<GraphResponse> createResponsesFromObject(HttpURLConnection httpURLConnection, List<GraphRequest> list, Object obj) {
        JSONArray jSONArray;
        FacebookException facebookException;
        int i = 0;
        AppMethodBeat.i(71767);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 1) {
            GraphRequest graphRequest = (GraphRequest) list.get(0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BODY_KEY, obj);
                jSONObject.put("code", httpURLConnection != null ? httpURLConnection.getResponseCode() : 200);
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e)));
                jSONArray = obj;
            } catch (IOException e2) {
                arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e2)));
            }
            if ((jSONArray instanceof JSONArray) || jSONArray.length() != size) {
                facebookException = new FacebookException("Unexpected number of results");
                AppMethodBeat.o(71767);
                throw facebookException;
            }
            jSONArray = jSONArray;
            while (i < jSONArray.length()) {
                graphRequest = (GraphRequest) list.get(i);
                try {
                    arrayList.add(createResponseFromObject(graphRequest, httpURLConnection, jSONArray.get(i), obj));
                } catch (JSONException e3) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e3)));
                } catch (FacebookException e32) {
                    arrayList.add(new GraphResponse(graphRequest, httpURLConnection, new FacebookRequestError(httpURLConnection, e32)));
                }
                i++;
            }
            AppMethodBeat.o(71767);
            return arrayList;
        }
        jSONArray = obj;
        if (jSONArray instanceof JSONArray) {
        }
        facebookException = new FacebookException("Unexpected number of results");
        AppMethodBeat.o(71767);
        throw facebookException;
    }

    private static GraphResponse createResponseFromObject(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
        GraphResponse graphResponse;
        AppMethodBeat.i(71768);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            FacebookRequestError checkResponseAndCreateError = FacebookRequestError.checkResponseAndCreateError(jSONObject, obj2, httpURLConnection);
            if (checkResponseAndCreateError != null) {
                if (checkResponseAndCreateError.getErrorCode() == FacebookRequestErrorClassification.EC_INVALID_TOKEN && Utility.isCurrentAccessToken(graphRequest.getAccessToken())) {
                    if (checkResponseAndCreateError.getSubErrorCode() != FacebookRequestErrorClassification.ESC_APP_INACTIVE) {
                        AccessToken.setCurrentAccessToken(null);
                    } else if (!AccessToken.getCurrentAccessToken().isExpired()) {
                        AccessToken.expireCurrentAccessToken();
                    }
                }
                graphResponse = new GraphResponse(graphRequest, httpURLConnection, checkResponseAndCreateError);
                AppMethodBeat.o(71768);
                return graphResponse;
            }
            Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, NON_JSON_RESPONSE_PROPERTY);
            GraphResponse graphResponse2;
            if (stringPropertyAsJSON instanceof JSONObject) {
                graphResponse2 = new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONObject) stringPropertyAsJSON);
                AppMethodBeat.o(71768);
                return graphResponse2;
            } else if (stringPropertyAsJSON instanceof JSONArray) {
                graphResponse2 = new GraphResponse(graphRequest, httpURLConnection, stringPropertyAsJSON.toString(), (JSONArray) stringPropertyAsJSON);
                AppMethodBeat.o(71768);
                return graphResponse2;
            } else {
                obj = JSONObject.NULL;
            }
        }
        if (obj == JSONObject.NULL) {
            graphResponse = new GraphResponse(graphRequest, httpURLConnection, obj.toString(), null);
            AppMethodBeat.o(71768);
            return graphResponse;
        }
        FacebookException facebookException = new FacebookException("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
        AppMethodBeat.o(71768);
        throw facebookException;
    }

    static List<GraphResponse> constructErrorResponses(List<GraphRequest> list, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        AppMethodBeat.i(71769);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new GraphResponse((GraphRequest) list.get(i), httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) facebookException)));
        }
        AppMethodBeat.o(71769);
        return arrayList;
    }
}
