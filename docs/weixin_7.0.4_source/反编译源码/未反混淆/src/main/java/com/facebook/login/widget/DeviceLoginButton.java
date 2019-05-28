package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceLoginButton extends LoginButton {
    private Uri deviceRedirectUri;

    class DeviceLoginClickListener extends LoginClickListener {
        private DeviceLoginClickListener() {
            super();
        }

        /* Access modifiers changed, original: protected */
        public LoginManager getLoginManager() {
            AppMethodBeat.i(92629);
            DeviceLoginManager instance = DeviceLoginManager.getInstance();
            instance.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
            instance.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
            AppMethodBeat.o(92629);
            return instance;
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    /* Access modifiers changed, original: protected */
    public LoginClickListener getNewLoginClickListener() {
        AppMethodBeat.i(92630);
        DeviceLoginClickListener deviceLoginClickListener = new DeviceLoginClickListener();
        AppMethodBeat.o(92630);
        return deviceLoginClickListener;
    }
}
