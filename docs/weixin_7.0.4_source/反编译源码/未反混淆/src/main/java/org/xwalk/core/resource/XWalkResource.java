package org.xwalk.core.resource;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class XWalkResource extends Resources {
    private WeakReference<Context> mWeChatContext;

    public XWalkResource(Resources resources, Context context) {
        super(resources.getAssets(), context.getResources().getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.i(86229);
        this.mWeChatContext = new WeakReference(context);
        AppMethodBeat.o(86229);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(86230);
        super.updateConfiguration(configuration, getDisplayMetrics());
        AppMethodBeat.o(86230);
    }

    public DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(86231);
        Context context = (Context) this.mWeChatContext.get();
        DisplayMetrics displayMetrics;
        if (context != null) {
            displayMetrics = context.getResources().getDisplayMetrics();
            AppMethodBeat.o(86231);
            return displayMetrics;
        }
        displayMetrics = super.getDisplayMetrics();
        AppMethodBeat.o(86231);
        return displayMetrics;
    }
}
