package com.tencent.p177mm.p612ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.ui.applet.SecurityImage */
public class SecurityImage extends LinearLayout {
    private int gCL = 0;
    private C5653c gud = null;
    private String guh = null;
    private String gui = null;
    private ProgressBar yrQ = null;
    private ImageView yrR = null;
    private Button yrS = null;
    private EditText yrT = null;
    private C15494b yrU;

    /* renamed from: com.tencent.mm.ui.applet.SecurityImage$a */
    public static class C15492a {
        /* renamed from: a */
        public static SecurityImage m23811a(Context context, int i, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, C15494b c15494b) {
            AppMethodBeat.m2504i(106233);
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, 2130970579, null);
            securityImage.setNetworkModel(c15494b);
            securityImage.mo27572a(i, bArr, str, str2);
            C5652a c5652a = new C5652a(context);
            c5652a.mo11446PV(C25738R.string.dmo);
            c5652a.mo11453Qc(C25738R.string.f9081ox).mo11457a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(106232);
                    onClickListener.onClick(dialogInterface, i);
                    AppMethodBeat.m2505o(106232);
                }
            });
            c5652a.mo11478f(onCancelListener);
            c5652a.mo11479fn(securityImage);
            c5652a.mo11482rc(true);
            securityImage.gud = c5652a.aMb();
            securityImage.gud.setOnDismissListener(onDismissListener);
            securityImage.gud.show();
            AppMethodBeat.m2505o(106233);
            return securityImage;
        }
    }

    /* renamed from: com.tencent.mm.ui.applet.SecurityImage$b */
    public static abstract class C15494b {
        protected SecurityImage yrX;

        public abstract void apw();

        /* renamed from: d */
        public final void mo27581d(SecurityImage securityImage) {
            this.yrX = securityImage;
        }
    }

    /* renamed from: com.tencent.mm.ui.applet.SecurityImage$1 */
    class C154951 implements View.OnClickListener {
        C154951() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(106231);
            SecurityImage.m23804a(SecurityImage.this);
            if (SecurityImage.this.yrU != null) {
                SecurityImage.this.yrU.apw();
            }
            AppMethodBeat.m2505o(106231);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23804a(SecurityImage securityImage) {
        AppMethodBeat.m2504i(106242);
        securityImage.m23808qa(false);
        AppMethodBeat.m2505o(106242);
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setNetworkModel(C15494b c15494b) {
        AppMethodBeat.m2504i(106234);
        if (this.yrU != null) {
            this.yrU.mo27581d(null);
        }
        this.yrU = c15494b;
        this.yrU.mo27581d(this);
        AppMethodBeat.m2505o(106234);
    }

    /* renamed from: a */
    public final void mo27572a(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(106235);
        this.yrQ = (ProgressBar) findViewById(2131827297);
        this.yrR = (ImageView) findViewById(2131827296);
        this.yrS = (Button) findViewById(2131827298);
        this.yrT = (EditText) findViewById(2131827299);
        this.yrS.setOnClickListener(new C154951());
        mo27573b(i, bArr, str, str2);
        AppMethodBeat.m2505o(106235);
    }

    /* renamed from: b */
    public final void mo27573b(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(106236);
        m23808qa(true);
        m23807c(i, bArr, str, str2);
        AppMethodBeat.m2505o(106236);
    }

    public int getSecCodeType() {
        return this.gCL;
    }

    public String getSecImgSid() {
        return this.guh;
    }

    public String getSecImgCode() {
        AppMethodBeat.m2504i(106237);
        String str;
        if (this.yrT == null) {
            str = "";
            AppMethodBeat.m2505o(106237);
            return str;
        }
        str = this.yrT.getText().toString().trim();
        AppMethodBeat.m2505o(106237);
        return str;
    }

    public String getSecImgEncryptKey() {
        return this.gui;
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(106238);
        if (this.gud != null) {
            this.gud.dismiss();
            this.gud = null;
        }
        AppMethodBeat.m2505o(106238);
    }

    /* renamed from: qa */
    private void m23808qa(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(106239);
        this.yrR.setAlpha(z ? 255 : 40);
        this.yrR.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.yrQ;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
        AppMethodBeat.m2505o(106239);
    }

    /* renamed from: c */
    private void m23807c(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(106240);
        this.guh = str;
        this.gui = str2;
        this.gCL = i;
        Bitmap bQ = C5056d.m7652bQ(bArr);
        if (bQ != null) {
            C4990ab.m7417i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
            m23803a(i, bQ, str, str2);
            AppMethodBeat.m2505o(106240);
            return;
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        C4990ab.m7413e(str3, str4, objArr);
        AppMethodBeat.m2505o(106240);
    }

    /* renamed from: a */
    private void m23803a(int i, Bitmap bitmap, String str, String str2) {
        AppMethodBeat.m2504i(106241);
        this.guh = str;
        this.gui = str2;
        this.gCL = i;
        if (bitmap != null) {
            this.yrR.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(106241);
            return;
        }
        C4990ab.m7412e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
        AppMethodBeat.m2505o(106241);
    }
}
