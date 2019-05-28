package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Environment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public final class g implements a {
    static {
        AppMethodBeat.i(16137);
        b.a(new g(), "//disablesfs", "//exportsfs", "//sfsstat");
        AppMethodBeat.o(16137);
    }

    public static void init() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        int i;
        boolean i2;
        AppMethodBeat.i(16136);
        String str2 = strArr[0];
        switch (str2.hashCode()) {
            case -1024646924:
                if (str2.equals("//sfsstat")) {
                    i2 = 2;
                    break;
                }
            case 1218851436:
                if (str2.equals("//exportsfs")) {
                    i2 = true;
                    break;
                }
            case 1595670136:
                if (str2.equals("//disablesfs")) {
                    i2 = 0;
                    break;
                }
            default:
                i2 = -1;
                break;
        }
        switch (i2) {
            case 0:
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs");
                try {
                    StringBuilder stringBuilder;
                    if (strArr.length <= 0 || strArr[1].equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        file.delete();
                        stringBuilder = new StringBuilder("Use SFS: ");
                        if (file.exists()) {
                            i2 = true;
                        } else {
                            i2 = false;
                        }
                        Toast.makeText(context, stringBuilder.append(Boolean.toString(i2)).toString(), 0).show();
                        AppMethodBeat.o(16136);
                        return true;
                    }
                    file.createNewFile();
                    stringBuilder = new StringBuilder("Use SFS: ");
                    if (file.exists()) {
                    }
                    Toast.makeText(context, stringBuilder.append(Boolean.toString(i2)).toString(), 0).show();
                    AppMethodBeat.o(16136);
                    return true;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SFSCommand", e, "Failed to operate flag file.", new Object[0]);
                }
                break;
            case 1:
                if (strArr.length <= 1) {
                    AppMethodBeat.o(16136);
                    return false;
                }
                str2 = strArr[1];
                FileOp.tc(str2);
                Toast.makeText(context, str2, 0).show();
                AppMethodBeat.o(16136);
                return true;
            case 2:
                long currentTimeMillis = System.currentTimeMillis();
                Map aiP = FileOp.aiP();
                StringBuilder stringBuilder2 = new StringBuilder(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                for (Entry entry : aiP.entrySet()) {
                    stringBuilder2.append("===== ").append((String) entry.getKey()).append(" =====\n").append(((Statistics) entry.getValue()).toString()).append("\n\n");
                }
                stringBuilder2.append("elapsed: ").append(System.currentTimeMillis() - currentTimeMillis).append(" ms");
                View textView = new TextView(context);
                textView.setText(stringBuilder2);
                textView.setGravity(8388627);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(-16744704);
                textView.setTypeface(Typeface.MONOSPACE);
                textView.setMovementMethod(new ScrollingMovementMethod());
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                h.a(context, null, textView, null);
                AppMethodBeat.o(16136);
                return true;
            default:
                AppMethodBeat.o(16136);
                return false;
        }
    }
}
