package org.xwalk.core.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkExternalExtensionManager;
import org.xwalk.core.XWalkNativeExtensionLoader;
import org.xwalk.core.XWalkView;

public class XWalkExternalExtensionManagerImpl extends XWalkExternalExtensionManager implements XWalkExtensionContextClient {
    private static final String TAG = "XWalkExternalExtensionManagerImpl";
    private final Context mContext;
    private final HashMap<String, XWalkExternalExtensionBridge> mExtensions = new HashMap();
    private boolean mLoadExternalExtensions;
    private final XWalkNativeExtensionLoader mNativeExtensionLoader;
    private final XWalkView mXWalkView;

    public XWalkExternalExtensionManagerImpl(XWalkView xWalkView) {
        super(xWalkView);
        AppMethodBeat.i(86191);
        this.mXWalkView = xWalkView;
        if (getBridge() == null) {
            Log.e(TAG, "Cannot load external extensions due to old version of runtime library");
            this.mContext = null;
            this.mLoadExternalExtensions = false;
            this.mNativeExtensionLoader = null;
            AppMethodBeat.o(86191);
            return;
        }
        this.mContext = getViewContext();
        this.mLoadExternalExtensions = true;
        this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
        loadNativeExtensions();
        AppMethodBeat.o(86191);
    }

    public void registerExtension(XWalkExternalExtension xWalkExternalExtension) {
        AppMethodBeat.i(86192);
        if (this.mExtensions.get(xWalkExternalExtension.getExtensionName()) != null) {
            Log.e(TAG, xWalkExternalExtension.getExtensionName() + "is already registered!");
            AppMethodBeat.o(86192);
            return;
        }
        this.mExtensions.put(xWalkExternalExtension.getExtensionName(), XWalkExternalExtensionBridgeFactory.createInstance(xWalkExternalExtension));
        AppMethodBeat.o(86192);
    }

    public void unregisterExtension(String str) {
        AppMethodBeat.i(86193);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(str);
        if (xWalkExternalExtensionBridge != null) {
            this.mExtensions.remove(str);
            xWalkExternalExtensionBridge.onDestroy();
        }
        AppMethodBeat.o(86193);
    }

    public Context getContext() {
        return this.mContext;
    }

    public Activity getActivity() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        return null;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.i(86194);
        ActivityNotFoundException activityNotFoundException = new ActivityNotFoundException("This method is no longer supported");
        AppMethodBeat.o(86194);
        throw activityNotFoundException;
    }

    public void loadExtension(String str) {
        AppMethodBeat.i(86195);
        if (this.mLoadExternalExtensions) {
            int length = str.length();
            if (str.charAt(length - 1) == File.separatorChar) {
                str = str.substring(0, length - 1);
            }
            String str2 = str + File.separator + str.substring(str.lastIndexOf(File.separatorChar) + 1) + ".json";
            try {
                try {
                    String str3;
                    JSONObject jSONObject = new JSONObject(getFileContent(this.mContext, str2, false));
                    String string = jSONObject.getString("name");
                    String string2 = jSONObject.getString("class");
                    String optString = jSONObject.optString("jsapi");
                    if (optString == null || optString.length() == 0) {
                        str3 = optString;
                    } else {
                        str3 = str + File.separator + optString;
                    }
                    optString = null;
                    if (!(str3 == null || str3.length() == 0)) {
                        try {
                            optString = getFileContent(this.mContext, str3, false);
                        } catch (IOException e) {
                            Log.w(TAG, "Failed to read the file ".concat(String.valueOf(str3)));
                            AppMethodBeat.o(86195);
                            return;
                        }
                    }
                    if (!(string == null || string2 == null)) {
                        Log.i(TAG, "createExternalExtension: name: " + string + " className: " + string2);
                        createExternalExtension(string, string2, optString, this);
                    }
                    AppMethodBeat.o(86195);
                    return;
                } catch (JSONException e2) {
                    Log.w(TAG, "Failed to parse json file: ".concat(String.valueOf(str2)));
                    AppMethodBeat.o(86195);
                    return;
                }
            } catch (IOException e3) {
                Log.w(TAG, "Failed to read json file: ".concat(String.valueOf(str2)));
                AppMethodBeat.o(86195);
                return;
            }
        }
        AppMethodBeat.o(86195);
    }

    public void postMessage(XWalkExternalExtension xWalkExternalExtension, int i, String str) {
        AppMethodBeat.i(86196);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postMessage(i, str);
        }
        AppMethodBeat.o(86196);
    }

    public void postBinaryMessage(XWalkExternalExtension xWalkExternalExtension, int i, byte[] bArr) {
        AppMethodBeat.i(86197);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postBinaryMessage(i, bArr);
        }
        AppMethodBeat.o(86197);
    }

    public void broadcastMessage(XWalkExternalExtension xWalkExternalExtension, String str) {
        AppMethodBeat.i(86198);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.broadcastMessage(str);
        }
        AppMethodBeat.o(86198);
    }

    public void onStart() {
        AppMethodBeat.i(86199);
        for (XWalkExternalExtensionBridge onStart : this.mExtensions.values()) {
            onStart.onStart();
        }
        AppMethodBeat.o(86199);
    }

    public void onResume() {
        AppMethodBeat.i(86200);
        for (XWalkExternalExtensionBridge onResume : this.mExtensions.values()) {
            onResume.onResume();
        }
        AppMethodBeat.o(86200);
    }

    public void onPause() {
        AppMethodBeat.i(86201);
        for (XWalkExternalExtensionBridge onPause : this.mExtensions.values()) {
            onPause.onPause();
        }
        AppMethodBeat.o(86201);
    }

    public void onStop() {
        AppMethodBeat.i(86202);
        for (XWalkExternalExtensionBridge onStop : this.mExtensions.values()) {
            onStop.onStop();
        }
        AppMethodBeat.o(86202);
    }

    public void onDestroy() {
        AppMethodBeat.i(86203);
        for (XWalkExternalExtensionBridge onDestroy : this.mExtensions.values()) {
            onDestroy.onDestroy();
        }
        this.mExtensions.clear();
        AppMethodBeat.o(86203);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(86204);
        for (XWalkExternalExtensionBridge onNewIntent : this.mExtensions.values()) {
            onNewIntent.onNewIntent(intent);
        }
        AppMethodBeat.o(86204);
    }

    public void setAllowExternalExtensions(boolean z) {
        this.mLoadExternalExtensions = z;
    }

    private String getFileContent(Context context, String str, boolean z) {
        String str2;
        AppMethodBeat.i(86205);
        InputStream inputStream = null;
        if (z) {
            try {
                Resources resources = context.getResources();
                str2 = new File(str).getName().split("\\.")[0];
                int identifier = resources.getIdentifier(str2, "raw", context.getPackageName());
                if (identifier > 0) {
                    inputStream = resources.openRawResource(identifier);
                }
            } catch (NotFoundException e) {
                Log.w(TAG, "Inputstream failed to open for R.raw." + str2 + ", try to find it in assets");
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.o(86205);
            }
        }
        if (inputStream == null) {
            inputStream = context.getAssets().open(str);
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        str2 = new String(bArr);
        if (inputStream != null) {
            inputStream.close();
        }
        AppMethodBeat.o(86205);
        return str2;
    }

    private void createExternalExtension(String str, String str2, String str3, XWalkExtensionContextClient xWalkExtensionContextClient) {
        AppMethodBeat.i(86206);
        try {
            xWalkExtensionContextClient.getContext().getClassLoader().loadClass(str2).getConstructor(new Class[]{String.class, String.class, XWalkExtensionContextClient.class}).newInstance(new Object[]{str, str3, this});
            AppMethodBeat.o(86206);
        } catch (ClassNotFoundException e) {
            handleException(e);
            AppMethodBeat.o(86206);
        } catch (IllegalAccessException e2) {
            handleException(e2);
            AppMethodBeat.o(86206);
        } catch (InstantiationException e3) {
            handleException(e3);
            AppMethodBeat.o(86206);
        } catch (InvocationTargetException e4) {
            handleException(e4);
            AppMethodBeat.o(86206);
        } catch (NoSuchMethodException e5) {
            handleException(e5);
            AppMethodBeat.o(86206);
        }
    }

    private void loadNativeExtensions() {
        AppMethodBeat.i(86207);
        String str = null;
        try {
            str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
        } catch (NameNotFoundException e) {
        }
        if (str != null && new File(str).isDirectory()) {
            this.mNativeExtensionLoader.registerNativeExtensionsInPath(str);
        }
        AppMethodBeat.o(86207);
    }

    private static void handleException(Exception exception) {
        AppMethodBeat.i(86208);
        Log.e(TAG, "Error in calling methods of external extensions. " + exception.toString());
        AppMethodBeat.o(86208);
    }
}
