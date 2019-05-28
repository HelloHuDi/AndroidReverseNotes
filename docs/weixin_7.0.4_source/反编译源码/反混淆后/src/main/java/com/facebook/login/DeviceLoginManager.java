package com.facebook.login;

import android.net.Uri;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        AppMethodBeat.m2504i(92627);
        if (instance == null) {
            synchronized (DeviceLoginManager.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceLoginManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92627);
                    }
                }
            }
        }
        DeviceLoginManager deviceLoginManager = instance;
        AppMethodBeat.m2505o(92627);
        return deviceLoginManager;
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public void setDeviceAuthTargetUserId(String str) {
        this.deviceAuthTargetUserId = str;
    }

    public String getDeviceAuthTargetUserId() {
        return this.deviceAuthTargetUserId;
    }

    /* Access modifiers changed, original: protected */
    public Request createLoginRequest(Collection<String> collection) {
        AppMethodBeat.m2504i(92628);
        Request createLoginRequest = super.createLoginRequest(collection);
        Uri deviceRedirectUri = getDeviceRedirectUri();
        if (deviceRedirectUri != null) {
            createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri.toString());
        }
        String deviceAuthTargetUserId = getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            createLoginRequest.setDeviceAuthTargetUserId(deviceAuthTargetUserId);
        }
        AppMethodBeat.m2505o(92628);
        return createLoginRequest;
    }
}
