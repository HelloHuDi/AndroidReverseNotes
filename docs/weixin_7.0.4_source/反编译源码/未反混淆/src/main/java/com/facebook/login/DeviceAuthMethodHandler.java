package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new Creator() {
        public final DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96749);
            DeviceAuthMethodHandler deviceAuthMethodHandler = new DeviceAuthMethodHandler(parcel);
            AppMethodBeat.o(96749);
            return deviceAuthMethodHandler;
        }

        public final DeviceAuthMethodHandler[] newArray(int i) {
            return new DeviceAuthMethodHandler[i];
        }
    };
    private static ScheduledThreadPoolExecutor backgroundExecutor;

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryAuthorize(Request request) {
        AppMethodBeat.i(96752);
        showDialog(request);
        AppMethodBeat.o(96752);
        return true;
    }

    private void showDialog(Request request) {
        AppMethodBeat.i(96753);
        DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
        createDeviceAuthDialog.show(this.loginClient.getActivity().getSupportFragmentManager(), "login_with_facebook");
        createDeviceAuthDialog.startLogin(request);
        AppMethodBeat.o(96753);
    }

    /* Access modifiers changed, original: protected */
    public DeviceAuthDialog createDeviceAuthDialog() {
        AppMethodBeat.i(96754);
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        AppMethodBeat.o(96754);
        return deviceAuthDialog;
    }

    public void onCancel() {
        AppMethodBeat.i(96755);
        this.loginClient.completeAndValidate(Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in."));
        AppMethodBeat.o(96755);
    }

    public void onError(Exception exception) {
        AppMethodBeat.i(96756);
        this.loginClient.completeAndValidate(Result.createErrorResult(this.loginClient.getPendingRequest(), null, exception.getMessage()));
        AppMethodBeat.o(96756);
    }

    public void onSuccess(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        AppMethodBeat.i(96757);
        this.loginClient.completeAndValidate(Result.createTokenResult(this.loginClient.getPendingRequest(), new AccessToken(str, str2, str3, collection, collection2, accessTokenSource, date, date2, date3)));
        AppMethodBeat.o(96757);
    }

    public static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            AppMethodBeat.i(96758);
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
            AppMethodBeat.o(96758);
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* Access modifiers changed, original: 0000 */
    public String getNameForLogging() {
        return "device_auth";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96759);
        super.writeToParcel(parcel, i);
        AppMethodBeat.o(96759);
    }

    static {
        AppMethodBeat.i(96760);
        AppMethodBeat.o(96760);
    }
}
