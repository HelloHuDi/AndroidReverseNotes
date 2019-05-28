package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareGraphRequest {

    /* renamed from: com.facebook.ShareGraphRequest$1 */
    static class C175781 implements PhotoJSONProcessor {
        C175781() {
        }

        public final JSONObject toJSONObject(SharePhoto sharePhoto) {
            AppMethodBeat.m2504i(96595);
            Uri imageUrl = sharePhoto.getImageUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", imageUrl.toString());
                AppMethodBeat.m2505o(96595);
                return jSONObject;
            } catch (Exception e) {
                FacebookException facebookException = new FacebookException("Unable to attach images", e);
                AppMethodBeat.m2505o(96595);
                throw facebookException;
            }
        }
    }

    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) {
        Object string;
        AppMethodBeat.m2504i(96596);
        String string2 = shareOpenGraphObject.getString("type");
        if (string2 == null) {
            string = shareOpenGraphObject.getString("og:type");
        } else {
            String string3 = string2;
        }
        if (string3 == null) {
            FacebookException facebookException = new FacebookException("Open graph object type cannot be null");
            AppMethodBeat.m2505o(96596);
            throw facebookException;
        }
        try {
            JSONObject jSONObject = (JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new C175781());
            Bundle bundle = new Bundle();
            bundle.putString("object", jSONObject.toString());
            GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.ROOT, "%s/%s", new Object[]{"me", "objects/".concat(String.valueOf(string3))}), bundle, HttpMethod.POST);
            AppMethodBeat.m2505o(96596);
            return graphRequest;
        } catch (JSONException e) {
            FacebookException facebookException2 = new FacebookException(e.getMessage());
            AppMethodBeat.m2505o(96596);
            throw facebookException2;
        }
    }
}
