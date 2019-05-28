package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C12536a;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21289g;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C3474h;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI */
public class MMSightRecordViewTestUI extends MMActivity {
    private int gLM = 720;
    private float gLO = 0.67f;
    private MMSightRecordView hGE;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$2 */
    class C213132 implements C12536a {
        C213132() {
        }

        /* renamed from: q */
        public final void mo24462q(byte[] bArr, int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$4 */
    class C213154 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$4$1 */
        class C213161 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$4$1$1 */
            class C213141 implements C3474h {
                C213141() {
                }

                /* renamed from: dX */
                public final void mo7934dX(boolean z) {
                    AppMethodBeat.m2504i(55120);
                    Toast.makeText(MMSightRecordViewTestUI.this, "record finish, error: ".concat(String.valueOf(z)), 0).show();
                    AppMethodBeat.m2505o(55120);
                }
            }

            C213161() {
            }

            public final void run() {
                AppMethodBeat.m2504i(55121);
                MMSightRecordViewTestUI.this.hGE.mo36649a(new C213141());
                AppMethodBeat.m2505o(55121);
            }
        }

        C213154() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55122);
            MMSightRecordViewTestUI.this.hGE.osY.mo36674EL();
            C5004al.m7442n(new C213161(), 5000);
            AppMethodBeat.m2505o(55122);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$3 */
    class C285213 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$3$1 */
        class C285221 implements C21289g {
            C285221() {
            }

            /* renamed from: F */
            public final void mo21838F(Bitmap bitmap) {
                AppMethodBeat.m2504i(55118);
                if (bitmap != null) {
                    ((ImageView) MMSightRecordViewTestUI.this.findViewById(2131822184)).setImageBitmap(bitmap);
                }
                AppMethodBeat.m2505o(55118);
            }

            public final void aDq() {
            }
        }

        C285213() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55119);
            MMSightRecordViewTestUI.this.hGE.mo36648a(new C285221(), true);
            AppMethodBeat.m2505o(55119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$6 */
    class C285246 implements OnClickListener {
        C285246() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(55124);
            MMSightRecordViewTestUI.this.hGE.osY.switchCamera();
            AppMethodBeat.m2505o(55124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI$1 */
    class C285251 implements OnMenuItemClickListener {
        C285251() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55117);
            MMSightRecordViewTestUI.this.finish();
            AppMethodBeat.m2505o(55117);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55125);
        super.onCreate(bundle);
        setBackBtn(new C285251());
        this.hGE = (MMSightRecordView) findViewById(2131826108);
        this.hGE.setDisplayRatio(this.gLO);
        this.hGE.setPreviewSizeLimit(this.gLM);
        this.hGE.setVideoPara$2e715812(100000);
        this.hGE.setVideoFilePath(C6457e.eSn + "mmsighttest.mp4");
        this.hGE.setClipPictureSize(true);
        this.hGE.setClipVideoSize(true);
        this.hGE.osY.ast();
        this.hGE.setFlashMode(3);
        this.hGE.setFrameDataCallback(new C213132());
        this.hGE.osY.startPreview();
        this.hGE.osY.aso();
        findViewById(2131826109).setOnClickListener(new C285213());
        findViewById(2131826110).setOnClickListener(new C213154());
        final TextView textView = (TextView) findViewById(2131826107);
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(55123);
                textView.setText("");
                textView.append(String.format("picture size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.this.hGE.getPictureSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.hGE.getPictureSize().x, MMSightRecordViewTestUI.this.hGE.getPictureSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.hGE.getPictureSize().x, MMSightRecordViewTestUI.this.hGE.getPictureSize().y)))}));
                textView.append(String.format("video size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.this.hGE.getVideoSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.hGE.getVideoSize().x, MMSightRecordViewTestUI.this.hGE.getVideoSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.hGE.getVideoSize().x, MMSightRecordViewTestUI.this.hGE.getVideoSize().y)))}));
                textView.append(String.format("preview size limit: %s\n", new Object[]{Integer.valueOf(MMSightRecordViewTestUI.this.gLM)}));
                textView.append(String.format("display ratio: %s\n", new Object[]{Float.valueOf(MMSightRecordViewTestUI.this.gLO)}));
                textView.append(String.format("view size: %s, ratio: %s\n", new Object[]{new Point(MMSightRecordViewTestUI.this.hGE.getWidth(), MMSightRecordViewTestUI.this.hGE.getHeight()), Float.valueOf(((float) MMSightRecordViewTestUI.this.hGE.getWidth()) / ((float) MMSightRecordViewTestUI.this.hGE.getHeight()))}));
                AppMethodBeat.m2505o(55123);
            }
        }, 1000);
        findViewById(2131826111).setOnClickListener(new C285246());
        AppMethodBeat.m2505o(55125);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55126);
        super.onDestroy();
        this.hGE.osY.release();
        AppMethodBeat.m2505o(55126);
    }

    public final int getLayoutId() {
        return 2130970232;
    }
}
