package com.tencent.mm.ui.applet;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.a.c;

public class SecurityImage extends LinearLayout {
    private int gCL = 0;
    private c gud = null;
    private String guh = null;
    private String gui = null;
    private ProgressBar yrQ = null;
    private ImageView yrR = null;
    private Button yrS = null;
    private EditText yrT = null;
    private b yrU;

    public static class a {
        public static SecurityImage a(Context context, int i, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
            AppMethodBeat.i(106233);
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, R.layout.aqa, null);
            securityImage.setNetworkModel(bVar);
            securityImage.a(i, bArr, str, str2);
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(context);
            aVar.PV(R.string.dmo);
            aVar.Qc(R.string.ox).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(106232);
                    onClickListener.onClick(dialogInterface, i);
                    AppMethodBeat.o(106232);
                }
            });
            aVar.f(onCancelListener);
            aVar.fn(securityImage);
            aVar.rc(true);
            securityImage.gud = aVar.aMb();
            securityImage.gud.setOnDismissListener(onDismissListener);
            securityImage.gud.show();
            AppMethodBeat.o(106233);
            return securityImage;
        }
    }

    public static abstract class b {
        protected SecurityImage yrX;

        public abstract void apw();

        public final void d(SecurityImage securityImage) {
            this.yrX = securityImage;
        }
    }

    static /* synthetic */ void a(SecurityImage securityImage) {
        AppMethodBeat.i(106242);
        securityImage.qa(false);
        AppMethodBeat.o(106242);
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setNetworkModel(b bVar) {
        AppMethodBeat.i(106234);
        if (this.yrU != null) {
            this.yrU.d(null);
        }
        this.yrU = bVar;
        this.yrU.d(this);
        AppMethodBeat.o(106234);
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(106235);
        this.yrQ = (ProgressBar) findViewById(R.id.e7j);
        this.yrR = (ImageView) findViewById(R.id.e7i);
        this.yrS = (Button) findViewById(R.id.e7k);
        this.yrT = (EditText) findViewById(R.id.e7l);
        this.yrS.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106231);
                SecurityImage.a(SecurityImage.this);
                if (SecurityImage.this.yrU != null) {
                    SecurityImage.this.yrU.apw();
                }
                AppMethodBeat.o(106231);
            }
        });
        b(i, bArr, str, str2);
        AppMethodBeat.o(106235);
    }

    public final void b(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(106236);
        qa(true);
        c(i, bArr, str, str2);
        AppMethodBeat.o(106236);
    }

    public int getSecCodeType() {
        return this.gCL;
    }

    public String getSecImgSid() {
        return this.guh;
    }

    public String getSecImgCode() {
        AppMethodBeat.i(106237);
        String str;
        if (this.yrT == null) {
            str = "";
            AppMethodBeat.o(106237);
            return str;
        }
        str = this.yrT.getText().toString().trim();
        AppMethodBeat.o(106237);
        return str;
    }

    public String getSecImgEncryptKey() {
        return this.gui;
    }

    public final void dismiss() {
        AppMethodBeat.i(106238);
        if (this.gud != null) {
            this.gud.dismiss();
            this.gud = null;
        }
        AppMethodBeat.o(106238);
    }

    private void qa(boolean z) {
        int i = 0;
        AppMethodBeat.i(106239);
        this.yrR.setAlpha(z ? 255 : 40);
        this.yrR.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.yrQ;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
        AppMethodBeat.o(106239);
    }

    private void c(int i, byte[] bArr, String str, String str2) {
        AppMethodBeat.i(106240);
        this.guh = str;
        this.gui = str2;
        this.gCL = i;
        Bitmap bQ = d.bQ(bArr);
        if (bQ != null) {
            ab.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bQ.getWidth()), Integer.valueOf(bQ.getHeight()));
            a(i, bQ, str, str2);
            AppMethodBeat.o(106240);
            return;
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        ab.e(str3, str4, objArr);
        AppMethodBeat.o(106240);
    }

    private void a(int i, Bitmap bitmap, String str, String str2) {
        AppMethodBeat.i(106241);
        this.guh = str;
        this.gui = str2;
        this.gCL = i;
        if (bitmap != null) {
            this.yrR.setImageBitmap(bitmap);
            AppMethodBeat.o(106241);
            return;
        }
        ab.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
        AppMethodBeat.o(106241);
    }
}
