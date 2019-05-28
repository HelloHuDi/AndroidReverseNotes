package com.tencent.p177mm.p182ah;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ah.m */
public final class C37439m implements C1202f {
    private Context context;
    private ProgressDialog fsh;
    private Runnable fsi = null;
    private Runnable fsj = null;
    private String path;

    public C37439m(Context context, String str) {
        AppMethodBeat.m2504i(77946);
        this.context = context;
        this.path = str;
        this.fsh = null;
        C1720g.m3540Rg().mo14539a(157, (C1202f) this);
        AppMethodBeat.m2505o(77946);
    }

    /* renamed from: w */
    public final boolean mo60330w(Runnable runnable) {
        AppMethodBeat.m2504i(77947);
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.fsi = runnable;
        Context context = this.context;
        this.context.getString(C25738R.string.f9238tz);
        this.fsh = C30379h.m48458b(context, this.context.getString(C25738R.string.ecl), true, null);
        C1720g.m3540Rg().mo14541a(new C41735l(this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(77947);
        return true;
    }

    /* renamed from: a */
    public final boolean mo60329a(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.m2504i(77948);
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.fsi = runnable;
        this.fsj = runnable2;
        C1720g.m3540Rg().mo14541a(new C41735l(this.path), 0);
        C4990ab.m7417i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.FALSE);
        AppMethodBeat.m2505o(77948);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(77949);
        C4990ab.m7416i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        C1720g.m3540Rg().mo14546b(157, (C1202f) this);
        if (this.fsh != null && this.fsh.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.fsh.dismiss();
            } catch (IllegalArgumentException e) {
                C4990ab.m7412e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, C25738R.string.eck, 0).show();
            if (this.fsi != null) {
                new C7306ak(Looper.getMainLooper()).post(this.fsi);
            }
            AppMethodBeat.m2505o(77949);
            return;
        }
        if (this.fsj != null) {
            new C7306ak(Looper.getMainLooper()).post(this.fsj);
        }
        if (str != null && str.length() > 0) {
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(this.context, null, null);
                AppMethodBeat.m2505o(77949);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, C25738R.string.ay8, 0).show();
            AppMethodBeat.m2505o(77949);
            return;
        }
        Toast.makeText(this.context, C25738R.string.ecj, 0).show();
        AppMethodBeat.m2505o(77949);
    }
}
