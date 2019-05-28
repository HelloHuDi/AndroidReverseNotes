package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WXAppLaunchData {
    public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
    public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
    public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
    public int launchType;
    public String message;

    public static class Builder {
        public static WXAppLaunchData fromBundle(Bundle bundle) {
            AppMethodBeat.i(128332);
            WXAppLaunchData wXAppLaunchData = new WXAppLaunchData();
            wXAppLaunchData.launchType = bundle.getInt("_wxapplaunchdata_launchType");
            wXAppLaunchData.message = bundle.getString("_wxapplaunchdata_message");
            AppMethodBeat.o(128332);
            return wXAppLaunchData;
        }

        public static Bundle toBundle(WXAppLaunchData wXAppLaunchData) {
            AppMethodBeat.i(128333);
            Bundle bundle = new Bundle();
            bundle.putInt("_wxapplaunchdata_launchType", wXAppLaunchData.launchType);
            bundle.putString("_wxapplaunchdata_message", wXAppLaunchData.message);
            AppMethodBeat.o(128333);
            return bundle;
        }
    }
}
