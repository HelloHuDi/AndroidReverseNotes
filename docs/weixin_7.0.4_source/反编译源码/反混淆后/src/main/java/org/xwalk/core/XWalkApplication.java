package org.xwalk.core;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkApplication extends Application {
    private static final String TAG = "XWalkLib";
    private static XWalkApplication gApp = null;
    private Resources mRes = null;

    public void onCreate() {
        AppMethodBeat.m2504i(85535);
        super.onCreate();
        gApp = this;
        AppMethodBeat.m2505o(85535);
    }

    public Resources getResources() {
        AppMethodBeat.m2504i(85536);
        Resources resources;
        if (this.mRes == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(85536);
            return resources;
        }
        resources = this.mRes;
        AppMethodBeat.m2505o(85536);
        return resources;
    }

    /* Access modifiers changed, original: 0000 */
    public void addResource(Resources resources) {
        AppMethodBeat.m2504i(85537);
        if (this.mRes != null) {
            AppMethodBeat.m2505o(85537);
            return;
        }
        this.mRes = new XWalkMixedResources(super.getResources(), resources);
        AppMethodBeat.m2505o(85537);
    }

    /* Access modifiers changed, original: 0000 */
    public void addResource(String str) {
        AppMethodBeat.m2504i(85538);
        if (this.mRes != null) {
            AppMethodBeat.m2505o(85538);
            return;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            Resources resources = super.getResources();
            this.mRes = new XWalkMixedResources(super.getResources(), new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration()));
            AppMethodBeat.m2505o(85538);
        } catch (Exception e) {
            Log.m81046e(TAG, e.getMessage());
            AppMethodBeat.m2505o(85538);
        }
    }

    static XWalkApplication getApplication() {
        return gApp;
    }
}
