package com.tencent.mm.ah;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class m implements f {
    private Context context;
    private ProgressDialog fsh;
    private Runnable fsi = null;
    private Runnable fsj = null;
    private String path;

    public m(Context context, String str) {
        AppMethodBeat.i(77946);
        this.context = context;
        this.path = str;
        this.fsh = null;
        g.Rg().a(157, (f) this);
        AppMethodBeat.o(77946);
    }

    public final boolean w(Runnable runnable) {
        AppMethodBeat.i(77947);
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.fsi = runnable;
        Context context = this.context;
        this.context.getString(R.string.tz);
        this.fsh = h.b(context, this.context.getString(R.string.ecl), true, null);
        g.Rg().a(new l(this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(77947);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(77948);
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.fsi = runnable;
        this.fsj = runnable2;
        g.Rg().a(new l(this.path), 0);
        ab.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.FALSE);
        AppMethodBeat.o(77948);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(77949);
        ab.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        g.Rg().b(157, (f) this);
        if (this.fsh != null && this.fsh.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.fsh.dismiss();
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, R.string.eck, 0).show();
            if (this.fsi != null) {
                new ak(Looper.getMainLooper()).post(this.fsi);
            }
            AppMethodBeat.o(77949);
            return;
        }
        if (this.fsj != null) {
            new ak(Looper.getMainLooper()).post(this.fsj);
        }
        if (str != null && str.length() > 0) {
            a jY = a.jY(str);
            if (jY != null) {
                jY.a(this.context, null, null);
                AppMethodBeat.o(77949);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, R.string.ay8, 0).show();
            AppMethodBeat.o(77949);
            return;
        }
        Toast.makeText(this.context, R.string.ecj, 0).show();
        AppMethodBeat.o(77949);
    }
}
