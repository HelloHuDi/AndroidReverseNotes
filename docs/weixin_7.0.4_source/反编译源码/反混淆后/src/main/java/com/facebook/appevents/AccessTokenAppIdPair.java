package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

class AccessTokenAppIdPair implements Serializable {
    private static final long serialVersionUID = 1;
    private final String accessTokenString;
    private final String applicationId;

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final String accessTokenString;
        private final String appId;

        private SerializationProxyV1(String str, String str2) {
            this.accessTokenString = str;
            this.appId = str2;
        }

        private Object readResolve() {
            AppMethodBeat.m2504i(71851);
            AccessTokenAppIdPair accessTokenAppIdPair = new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            AppMethodBeat.m2505o(71851);
            return accessTokenAppIdPair;
        }
    }

    public AccessTokenAppIdPair(AccessToken accessToken) {
        this(accessToken.getToken(), FacebookSdk.getApplicationId());
        AppMethodBeat.m2504i(71852);
        AppMethodBeat.m2505o(71852);
    }

    public AccessTokenAppIdPair(String str, String str2) {
        AppMethodBeat.m2504i(71853);
        if (Utility.isNullOrEmpty(str)) {
            str = null;
        }
        this.accessTokenString = str;
        this.applicationId = str2;
        AppMethodBeat.m2505o(71853);
    }

    public String getAccessTokenString() {
        return this.accessTokenString;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(71854);
        int hashCode = this.accessTokenString == null ? 0 : this.accessTokenString.hashCode();
        if (this.applicationId != null) {
            i = this.applicationId.hashCode();
        }
        hashCode ^= i;
        AppMethodBeat.m2505o(71854);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(71855);
        if (obj instanceof AccessTokenAppIdPair) {
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            if (Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
                AppMethodBeat.m2505o(71855);
                return true;
            }
            AppMethodBeat.m2505o(71855);
            return false;
        }
        AppMethodBeat.m2505o(71855);
        return false;
    }

    private Object writeReplace() {
        AppMethodBeat.m2504i(71856);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.accessTokenString, this.applicationId);
        AppMethodBeat.m2505o(71856);
        return serializationProxyV1;
    }
}
