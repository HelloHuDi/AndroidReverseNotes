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
            AppMethodBeat.i(71851);
            AccessTokenAppIdPair accessTokenAppIdPair = new AccessTokenAppIdPair(this.accessTokenString, this.appId);
            AppMethodBeat.o(71851);
            return accessTokenAppIdPair;
        }
    }

    public AccessTokenAppIdPair(AccessToken accessToken) {
        this(accessToken.getToken(), FacebookSdk.getApplicationId());
        AppMethodBeat.i(71852);
        AppMethodBeat.o(71852);
    }

    public AccessTokenAppIdPair(String str, String str2) {
        AppMethodBeat.i(71853);
        if (Utility.isNullOrEmpty(str)) {
            str = null;
        }
        this.accessTokenString = str;
        this.applicationId = str2;
        AppMethodBeat.o(71853);
    }

    public String getAccessTokenString() {
        return this.accessTokenString;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        int i = 0;
        AppMethodBeat.i(71854);
        int hashCode = this.accessTokenString == null ? 0 : this.accessTokenString.hashCode();
        if (this.applicationId != null) {
            i = this.applicationId.hashCode();
        }
        hashCode ^= i;
        AppMethodBeat.o(71854);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(71855);
        if (obj instanceof AccessTokenAppIdPair) {
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            if (Utility.areObjectsEqual(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
                AppMethodBeat.o(71855);
                return true;
            }
            AppMethodBeat.o(71855);
            return false;
        }
        AppMethodBeat.o(71855);
        return false;
    }

    private Object writeReplace() {
        AppMethodBeat.i(71856);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.accessTokenString, this.applicationId);
        AppMethodBeat.o(71856);
        return serializationProxyV1;
    }
}
