package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.chatting.ImageDownloadUI;
import com.tencent.p177mm.p612ui.tools.CropImageView.C30738a;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.platformtools.C37987r;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.gif.C12215c;
import com.tencent.p177mm.plugin.gif.C34323b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.IOException;
import java.lang.reflect.Array;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.tools.CropImageNewUI */
public class CropImageNewUI extends MMActivity {
    private int emC = 0;
    private String filePath;
    private final int zAP = 1;
    private final int zAQ = 0;
    private int zAR;
    private int zAS = 0;
    private FilterImageView zAT;
    private LinearLayout zAU;
    private CropImageView zAV;
    private ImageView zAW;
    private View zAX;
    private int zAY = 0;
    private boolean zAZ = false;
    private boolean zBa = false;
    private boolean zBb = false;

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$11 */
    class C556111 implements OnClickListener {
        C556111() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34824);
            CropImageNewUI.m59785r(CropImageNewUI.this);
            AppMethodBeat.m2505o(34824);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$12 */
    class C556212 implements C30738a {
        C556212() {
        }

        public final void dJI() {
            AppMethodBeat.m2504i(34825);
            CropImageNewUI.m59774h(CropImageNewUI.this);
            AppMethodBeat.m2505o(34825);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$15 */
    class C556315 implements DialogInterface.OnClickListener {
        C556315() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34828);
            CropImageNewUI.m59762a(CropImageNewUI.this, false);
            AppMethodBeat.m2505o(34828);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$4 */
    class C159194 implements OnClickListener {
        C159194() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34817);
            CropImageView j = CropImageNewUI.this.zAV;
            if (j.mQQ == null) {
                C4990ab.m7420w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                AppMethodBeat.m2505o(34817);
                return;
            }
            float[] fArr = new float[]{(float) (j.mQQ.getWidth() / 2), (float) (j.mQQ.getHeight() / 2)};
            j.getImageMatrix().mapPoints(fArr);
            j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
            j.setImageBitmap(j.mQQ);
            j.invalidate();
            j.cDW++;
            AppMethodBeat.m2505o(34817);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$5 */
    class C159205 implements OnClickListener {
        C159205() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34818);
            CropImageNewUI.this.zAV.zoomIn();
            AppMethodBeat.m2505o(34818);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$14 */
    class C2402414 implements C30391c {
        C2402414() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(34827);
            switch (i) {
                case 0:
                    CropImageNewUI.m59788u(CropImageNewUI.this);
                    break;
            }
            AppMethodBeat.m2505o(34827);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$7 */
    class C240257 implements C5015a {
        C240257() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(34820);
            CropImageNewUI.this.zAV.zoomIn();
            AppMethodBeat.m2505o(34820);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$6 */
    class C307366 implements OnClickListener {
        C307366() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34819);
            CropImageNewUI.this.zAV.zoomOut();
            AppMethodBeat.m2505o(34819);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$13 */
    class C3631613 implements C30391c {
        C3631613() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(34826);
            switch (i) {
                case 0:
                    CropImageNewUI.m59786s(CropImageNewUI.this);
                    AppMethodBeat.m2505o(34826);
                    return;
                case 1:
                    CropImageNewUI.m59787t(CropImageNewUI.this);
                    break;
            }
            AppMethodBeat.m2505o(34826);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$16 */
    class C3631716 implements DialogInterface.OnClickListener {
        C3631716() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$1 */
    class C363181 implements Runnable {
        C363181() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34814);
            if (!CropImageNewUI.m59764a(CropImageNewUI.this)) {
                AppMethodBeat.m2505o(34814);
            } else if (CropImageNewUI.this.zAZ || CropImageNewUI.this.zBa || !CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                if (1 == CropImageNewUI.this.zAR) {
                    CropImageNewUI.m59773g(CropImageNewUI.this);
                }
                AppMethodBeat.m2505o(34814);
            } else {
                CropImageNewUI.m59770d(CropImageNewUI.this);
                if (!CropImageNewUI.this.getSharedPreferences(C4996ah.doA(), 0).getBoolean("CropImage_Filter_Show", true)) {
                    CropImageNewUI.this.zAT.findViewById(2131823173).setVisibility(4);
                }
                AppMethodBeat.m2505o(34814);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$2 */
    class C363192 implements Runnable {
        C363192() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34815);
            CropImageNewUI.m59761a(CropImageNewUI.this, CropImageNewUI.this.zAT.getCropImageIV(), CropImageNewUI.this.zAT.getCropAreaView());
            CropImageNewUI.this.finish();
            AppMethodBeat.m2505o(34815);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$19 */
    class C3632119 implements OnMenuItemClickListener {
        C3632119() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34831);
            CropImageNewUI.this.finish();
            AppMethodBeat.m2505o(34831);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$20 */
    class C3632220 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$20$1 */
        class C159171 implements C36073c {
            C159171() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(34832);
                c44273l.mo70072hi(0, C25738R.string.b3y);
                c44273l.mo70072hi(1, C25738R.string.b42);
                AppMethodBeat.m2505o(34832);
            }
        }

        /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$20$2 */
        class C159182 implements C5279d {
            C159182() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(34833);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        intent = new Intent();
                        intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                        intent.putExtra("OP_CODE", 1);
                        CropImageNewUI.this.setResult(-1, intent);
                        CropImageNewUI.this.finish();
                        AppMethodBeat.m2505o(34833);
                        return;
                    case 1:
                        intent = new Intent();
                        intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                        intent.putExtra("OP_CODE", 2);
                        CropImageNewUI.this.setResult(-1, intent);
                        CropImageNewUI.this.finish();
                        break;
                }
                AppMethodBeat.m2505o(34833);
            }
        }

        C3632220() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34834);
            C36356d c36356d = new C36356d(CropImageNewUI.this, 1, false);
            c36356d.rBl = new C159171();
            c36356d.rBm = new C159182();
            c36356d.cpD();
            AppMethodBeat.m2505o(34834);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$21 */
    class C3632321 implements Runnable {
        C3632321() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34835);
            CropImageNewUI.m59764a(CropImageNewUI.this);
            AppMethodBeat.m2505o(34835);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$23 */
    class C3632423 implements Runnable {
        C3632423() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34837);
            if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                CropImageNewUI.this.finish();
                AppMethodBeat.m2505o(34837);
                return;
            }
            CropImageNewUI.this.zAT.setVisibility(8);
            CropImageNewUI.this.zAU.setVisibility(0);
            CropImageNewUI.this.zAW.setVisibility(((Integer) CropImageNewUI.this.zAW.getTag()).intValue());
            CropImageNewUI.this.zAV.setVisibility(0);
            AppMethodBeat.m2505o(34837);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$3 */
    class C363253 implements Runnable {
        C363253() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34816);
            CropImageNewUI.this.finish();
            AppMethodBeat.m2505o(34816);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$18 */
    class C3632718 implements OnClickListener {
        C3632718() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34830);
            CropImageNewUI.m59762a(CropImageNewUI.this, true);
            AppMethodBeat.m2505o(34830);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$22 */
    class C3632822 implements Runnable {
        C3632822() {
        }

        public final void run() {
            boolean z = false;
            AppMethodBeat.m2504i(34836);
            if (CropImageNewUI.this.zAT == null) {
                AppMethodBeat.m2505o(34836);
                return;
            }
            if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                Editor edit = CropImageNewUI.this.getSharedPreferences(C4996ah.doA(), 0).edit();
                String str = "CropImage_Filter_Show";
                if (CropImageNewUI.this.zAT.findViewById(2131823173).getVisibility() == 0) {
                    z = true;
                }
                edit.putBoolean(str, z);
                edit.commit();
            }
            String stringExtra = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
            if (stringExtra == null) {
                stringExtra = C6457e.euR + C1178g.m2591x((CropImageNewUI.this.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
            }
            Intent intent = new Intent();
            intent.putExtra("CropImage_Compress_Img", true);
            if (CropImageNewUI.this.zAT != null) {
                intent.putExtra("CropImage_filterId", CropImageNewUI.this.zAT.getFilterId());
            }
            if (CropImageNewUI.this.zAT.getFilterId() == 0) {
                intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.filePath);
                CropImageNewUI.this.setResult(-1, intent);
            } else if (CropImageNewUI.m59765a(CropImageNewUI.this, CropImageNewUI.this.zAT.getFilterBmp(), stringExtra)) {
                intent.putExtra("CropImage_OutputPath", stringExtra);
                CropImageNewUI.this.setResult(-1, intent);
            } else {
                CropImageNewUI.this.setResult(-1);
            }
            CropImageNewUI.this.finish();
            AppMethodBeat.m2505o(34836);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.CropImageNewUI$8 */
    class C363298 implements C5015a {
        C363298() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(34821);
            CropImageNewUI.this.zAV.zoomOut();
            AppMethodBeat.m2505o(34821);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m59764a(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34855);
        boolean dJC = cropImageNewUI.dJC();
        AppMethodBeat.m2505o(34855);
        return dJC;
    }

    public final int getLayoutId() {
        return 2130969255;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34838);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(34838);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(34839);
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
        AppMethodBeat.m2505o(34839);
    }

    public void onResume() {
        AppMethodBeat.m2504i(34840);
        super.onResume();
        setRequestedOrientation(1);
        AppMethodBeat.m2505o(34840);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34841);
        if (this.zAV != null) {
            CropImageView cropImageView = this.zAV;
            if (!(cropImageView.mQQ == null || cropImageView.mQQ.isRecycled())) {
                C4990ab.m7417i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.mQQ.toString());
                cropImageView.mQQ.recycle();
            }
            if (cropImageView.zBy != null) {
                cropImageView.zBy.cancel();
                cropImageView.zBy = null;
            }
            cropImageView.zBz.removeCallbacksAndMessages(null);
            cropImageView.zBB.removeCallbacksAndMessages(null);
        }
        if (this.zAT != null) {
            FilterImageView filterImageView = this.zAT;
            filterImageView.zBP = null;
            if (!(filterImageView.zBT == null || filterImageView.zBT.isRecycled())) {
                C4990ab.m7417i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.zBT.toString());
                filterImageView.zBT.recycle();
            }
            filterImageView.zBT = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(34841);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34842);
        setMMTitle("");
        this.zAU = (LinearLayout) findViewById(2131823176);
        this.zAW = (ImageView) findViewById(2131823172);
        C37987r.m64279ci(this.zAW);
        this.zAX = findViewById(2131823171);
        this.zAR = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.zAR != 0);
        this.emC = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            dJD();
        }
        this.zBb = false;
        this.zAV = (CropImageView) findViewById(2131823175);
        C37987r.m64279ci(this.zAV);
        this.zAV.post(new C363181());
        this.zAV.setOnShortClick(new C556212());
        dJF();
        switch (this.zAR) {
            case 1:
                dJE();
                this.zAT.setLimitZoomIn(false);
                this.zAT.dJL();
                this.zAT.setCropMaskVisible(0);
                if (this.emC == 1) {
                    this.zAT.setCropMaskBackground(C25738R.drawable.ak3);
                    break;
                }
                break;
            case 2:
                this.zAV.setEnableOprate(false);
                findViewById(2131823177).setVisibility(8);
                findViewById(2131823181).setVisibility(8);
                break;
            case 3:
                this.zAU.setVisibility(8);
                break;
            case 5:
                dJG();
                break;
        }
        C4990ab.m7410d("MicroMsg.CropImageUI", "mode is  " + this.zAR);
        C3632017 c3632017 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(34829);
                if (booleanExtra && booleanExtra2) {
                    CropImageNewUI.m59762a(CropImageNewUI.this, true);
                    AppMethodBeat.m2505o(34829);
                } else {
                    switch (CropImageNewUI.this.zAR) {
                        case 1:
                            if (CropImageNewUI.this.zAT == null) {
                                CropImageNewUI.m59761a(CropImageNewUI.this, CropImageNewUI.this.zAV, CropImageNewUI.this.zAX);
                                break;
                            }
                            CropImageNewUI.m59761a(CropImageNewUI.this, CropImageNewUI.this.zAT.getCropImageIV(), CropImageNewUI.this.zAX);
                            break;
                        case 2:
                            CropImageNewUI.m59778k(CropImageNewUI.this);
                            break;
                        case 3:
                            CropImageNewUI.m59779l(CropImageNewUI.this);
                            break;
                        case 4:
                            CropImageNewUI.m59780m(CropImageNewUI.this);
                            break;
                        case 5:
                            CropImageNewUI.m59781n(CropImageNewUI.this);
                            break;
                    }
                    AppMethodBeat.m2505o(34829);
                }
                return true;
            }
        };
        if (this.zAR == 5) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, c3632017);
        } else if (this.zAR == 4) {
            addIconOptionMenu(0, C25738R.drawable.f6899uu, c3632017);
            findViewById(2131823181).setVisibility(0);
            Button button = (Button) findViewById(2131823182);
            button.setText(C25738R.string.b3p);
            button.setOnClickListener(new C3632718());
        } else {
            mo17379a(0, getString(C25738R.string.b3t), (OnMenuItemClickListener) c3632017, C5535b.GREEN);
        }
        if (booleanExtra && booleanExtra2) {
            mo17379a(0, getString(C25738R.string.b3p), (OnMenuItemClickListener) c3632017, C5535b.GREEN);
        }
        setBackBtn(new C3632119());
        if (this.zAR == 6) {
            findViewById(2131823181).setVisibility(8);
            mo17379a(0, getString(C25738R.string.b3t), (OnMenuItemClickListener) new C3632220(), C5535b.GREEN);
        }
        AppMethodBeat.m2505o(34842);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(34843);
        C4990ab.m7410d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            C4990ab.m7418v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.zAV.post(new C3632321());
        }
        super.onConfigurationChanged(configuration);
        AppMethodBeat.m2505o(34843);
    }

    private boolean dJC() {
        View findViewById;
        AppMethodBeat.m2504i(34844);
        if (1 != this.zAR) {
            findViewById = findViewById(2131823174);
        } else if (this.zAT != null) {
            findViewById = this.zAT.getCropAreaView();
        } else {
            findViewById = findViewById(2131823171);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        C4990ab.m7418v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (C5730e.m8628ct(this.filePath)) {
            boolean z;
            int i;
            int i2;
            int i3;
            float f;
            int i4 = VideoFilterUtil.IMAGE_HEIGHT;
            int i5 = VideoFilterUtil.IMAGE_HEIGHT;
            if (this.zAR == 2) {
                z = true;
                i = height;
                i2 = width;
            } else if (this.zAR == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                i = options.outWidth;
                i3 = options.outHeight;
                f = 1.0f;
                if (i <= 640 && i3 <= 640) {
                    i4 = i3;
                    i2 = i;
                } else if (i > i3) {
                    f = ((float) i3) / ((float) i);
                    i2 = 640;
                    i4 = (int) (((float) i3) * f);
                } else {
                    f = ((float) i) / ((float) i3);
                    i4 = 640;
                    i2 = (int) (960.0f * f);
                }
                C4990ab.m7411d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Float.valueOf(f));
                Button button = (Button) findViewById(2131823182);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
                i = i4;
            } else if (this.zAR == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    C4990ab.m7417i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i4 = (int) ((((double) (options2.outWidth * VideoFilterUtil.IMAGE_HEIGHT)) * 1.0d) / ((double) options2.outHeight));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                } else {
                    i5 = (int) ((((double) (options2.outHeight * VideoFilterUtil.IMAGE_HEIGHT)) * 1.0d) / ((double) options2.outWidth));
                    if (i5 > 1920) {
                        i5 = 1920;
                    }
                }
                z = false;
                i = i5;
                i2 = i4;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                C5056d.dnX();
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    C4990ab.m7417i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                    decodeFile3.recycle();
                }
                z = C42252ah.m74613cJ(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.zAZ = z;
                z = C42252ah.m74612cI(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.zBa = z;
                if (this.zAZ || this.zBa) {
                    i5 = options3.outHeight;
                    i4 = options3.outWidth;
                }
                C4990ab.m7412e("MicroMsg.CropImageUI", "width is " + i4 + " height is " + i5);
                z = false;
                i = i5;
                i2 = i4;
            }
            this.zAY = ExifHelper.m7368bJ(this.filePath);
            if (this.zAY == 90 || this.zAY == 270) {
                i5 = i2;
                i4 = i;
            } else {
                i5 = i;
                i4 = i2;
            }
            Bitmap d = C5056d.m7659d(this.filePath, i5, i4, z);
            byte[] e = C5730e.m8632e(this.filePath, 0, 10);
            if (C5063r.m7677bS(e)) {
                this.zAS = 1;
            } else {
                this.zAS = 0;
            }
            if (d == null) {
                finish();
                AppMethodBeat.m2505o(34844);
                return false;
            }
            float height2;
            float f2;
            C4990ab.m7410d("temBmp crop", "h:" + d.getHeight() + "w: " + d.getWidth());
            Bitmap b = C5056d.m7648b(d, (float) this.zAY);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                C4990ab.m7418v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.zAR) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.zAR) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.zAR) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.zAS == 1) {
                        this.zAV.setGifPath(this.filePath);
                        this.zAV.getGifWidth();
                        this.zAV.getGifHeight();
                        f = ((float) this.zAV.getGifWidth()) / ((float) width);
                        height2 = ((float) this.zAV.getGifHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.zAV.getGifWidth()) * f)) / 2.0f, (((float) height) - (f * ((float) this.zAV.getGifHeight()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.zAR) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        C4990ab.m7410d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(f)));
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.zAR) {
                if (this.zAT != null) {
                    this.zAT.setMatrix(matrix);
                    this.zAT.setImage(b);
                }
            } else if (this.zAS != 1) {
                this.zAV.setImageMatrix(matrix);
                this.zAV.setImageBitmap(b);
            }
            if (this.zAR == 3) {
                if (C5063r.m7677bS(e)) {
                    this.zAS = 1;
                    try {
                        C34323b eD = C12215c.bFN().mo24060eD(this.filePath, this.filePath);
                        this.zAV.setImageDrawable(eD);
                        eD.start();
                        matrix.reset();
                        i3 = eD.getIntrinsicWidth();
                        i2 = eD.getIntrinsicHeight();
                        f = ((float) width) / ((float) i3);
                        height2 = ((float) height) / ((float) i2);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i3) / ((float) width);
                        height2 = ((float) i2) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i3) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i2))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i3) / 2), (float) ((height - i2) / 2));
                        }
                        this.zAV.setImageMatrix(matrix);
                    } catch (Exception e2) {
                        C4990ab.m7412e("MicroMsg.CropImageUI", C5046bo.m7574l(e2));
                    }
                } else {
                    this.zAS = 0;
                }
                AppMethodBeat.m2505o(34844);
                return true;
            }
            if (this.zAZ || this.zBa) {
                findViewById(2131823178).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(2131823181).setVisibility(8);
            }
            AppMethodBeat.m2505o(34844);
            return true;
        }
        finish();
        AppMethodBeat.m2505o(34844);
        return false;
    }

    /* renamed from: c */
    private void m59767c(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.m2504i(34845);
        this.zAT = (FilterImageView) findViewById(2131823183);
        C37987r.m64279ci(this.zAT);
        this.zAT.setOnConfirmImp(runnable);
        this.zAT.setOnExitImp(runnable2);
        AppMethodBeat.m2505o(34845);
    }

    private void dJD() {
        AppMethodBeat.m2504i(34846);
        m59767c(new C3632822(), new C3632423());
        AppMethodBeat.m2505o(34846);
    }

    private void dJE() {
        AppMethodBeat.m2504i(34847);
        m59767c(new C363192(), new C363253());
        AppMethodBeat.m2505o(34847);
    }

    private void dJF() {
        AppMethodBeat.m2504i(34848);
        ((Button) findViewById(2131823178)).setOnClickListener(new C159194());
        Button button = (Button) findViewById(2131823180);
        button.setOnClickListener(new C159205());
        Button button2 = (Button) findViewById(2131823179);
        button2.setOnClickListener(new C307366());
        final C7564ap c7564ap = new C7564ap(new C240257(), true);
        final C7564ap c7564ap2 = new C7564ap(new C363298(), true);
        button.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(34822);
                switch (motionEvent.getAction()) {
                    case 0:
                        c7564ap.mo16770ae(200, 200);
                        break;
                    case 1:
                        c7564ap.stopTimer();
                        break;
                }
                AppMethodBeat.m2505o(34822);
                return false;
            }
        });
        button2.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(34823);
                switch (motionEvent.getAction()) {
                    case 0:
                        c7564ap2.mo16770ae(200, 200);
                        break;
                    case 1:
                        c7564ap2.stopTimer();
                        break;
                }
                AppMethodBeat.m2505o(34823);
                return false;
            }
        });
        AppMethodBeat.m2505o(34848);
    }

    private void dJG() {
        AppMethodBeat.m2504i(34849);
        int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
        boolean booleanExtra = getIntent().getBooleanExtra("CropImage_BHasHD", false);
        if (intExtra == 1 || !booleanExtra) {
            findViewById(2131823181).setVisibility(8);
            AppMethodBeat.m2505o(34849);
            return;
        }
        findViewById(2131823181).setVisibility(0);
        Button button = (Button) findViewById(2131823182);
        button.setBackgroundResource(C25738R.drawable.f6491fw);
        button.setPadding(25, 8, 25, 8);
        button.setOnClickListener(new C556111());
        AppMethodBeat.m2505o(34849);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] dJH() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        int[] iArr;
        AppMethodBeat.m2504i(34850);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        C4990ab.m7412e("MicroMsg.CropImageUI", "window TitleBar.h:".concat(String.valueOf(i5)));
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(C42252ah.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                C4990ab.m7412e("MicroMsg.CropImageUI", "sbar:".concat(String.valueOf(i5)));
                i = i5;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.zAX.getWidth(), this.zAX.getHeight());
            max = Math.max(this.zAX.getWidth(), this.zAX.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.zAY != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            iArr = new int[]{i5, i3, i, i4};
            AppMethodBeat.m2505o(34850);
            return iArr;
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.zAX.getWidth(), this.zAX.getHeight());
        max = Math.max(this.zAX.getWidth(), this.zAX.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.zAY != 0) {
        }
        iArr = new int[]{i5, i3, i, i4};
        AppMethodBeat.m2505o(34850);
        return iArr;
    }

    /* renamed from: hv */
    private Bitmap m59775hv(int i, int i2) {
        AppMethodBeat.m2504i(34851);
        Bitmap d = C5056d.m7659d(this.filePath, i2, i, true);
        if (this.zAY != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.zAY, (float) (d.getWidth() / 2), (float) (d.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
            if (d != createBitmap) {
                C4990ab.m7417i("MicroMsg.CropImageUI", "recycle bitmap:%s", d.toString());
                d.recycle();
            }
            d = createBitmap;
        }
        C4990ab.m7410d("MicroMsg.CropImageUI", "getcrop degree:" + this.zAY);
        AppMethodBeat.m2505o(34851);
        return d;
    }

    /* renamed from: a */
    private static Bitmap m59760a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        AppMethodBeat.m2504i(34852);
        if (cropImageView == null) {
            AppMethodBeat.m2505o(34852);
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] c = C46697l.m88467c(fArr, new float[]{f, f2, 1.0f});
        float[] c2 = C46697l.m88467c(fArr, fArr2);
        int min = (int) Math.min(c[0], c2[0]);
        int min2 = (int) Math.min(c[1], c2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(c[0] - c2[0]);
        int abs2 = (int) Math.abs(c[1] - c2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.getRotateCount() % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bmp = cropImageView.getBmp();
        if (min + abs > bmp.getWidth()) {
            abs = bmp.getWidth() - min;
        }
        if (min2 + abs2 > bmp.getHeight()) {
            abs2 = bmp.getHeight() - min2;
        }
        C4990ab.m7417i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bmp.getWidth()), Integer.valueOf(bmp.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        bmp = Bitmap.createBitmap(bmp, min, min2, abs, abs2, matrix, true);
        AppMethodBeat.m2505o(34852);
        return bmp;
    }

    /* renamed from: a */
    private boolean m59763a(Bitmap bitmap, String str, boolean z) {
        AppMethodBeat.m2504i(34853);
        if (!(str == null || str.equals(""))) {
            try {
                if (this.emC == 1) {
                    C5056d.m7625a(bitmap, 30, CompressFormat.JPEG, str, z);
                } else {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, str, z);
                }
                AppMethodBeat.m2505o(34853);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.m2505o(34853);
        return false;
    }

    /* renamed from: c */
    private static float[][] m59769c(Matrix matrix) {
        AppMethodBeat.m2504i(34854);
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        AppMethodBeat.m2505o(34854);
        return fArr;
    }

    /* renamed from: d */
    static /* synthetic */ void m59770d(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34856);
        if (cropImageNewUI.zAT.getFilterBmp() == null) {
            cropImageNewUI.zAT.mo64466eH(cropImageNewUI.filePath, cropImageNewUI.zAY);
        }
        cropImageNewUI.zAU.setVisibility(8);
        cropImageNewUI.zAT.setVisibility(0);
        cropImageNewUI.zAW.setTag(Integer.valueOf(cropImageNewUI.zAW.getVisibility()));
        cropImageNewUI.zAW.setVisibility(8);
        cropImageNewUI.zAV.setVisibility(8);
        AppMethodBeat.m2505o(34856);
    }

    /* renamed from: g */
    static /* synthetic */ void m59773g(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34857);
        cropImageNewUI.zAT.mo64466eH(cropImageNewUI.filePath, cropImageNewUI.zAY);
        cropImageNewUI.zAU.setVisibility(8);
        cropImageNewUI.zAT.setVisibility(0);
        cropImageNewUI.zAW.setTag(Integer.valueOf(cropImageNewUI.zAW.getVisibility()));
        cropImageNewUI.zAW.setVisibility(8);
        cropImageNewUI.zAV.setVisibility(8);
        cropImageNewUI.zAT.findViewById(2131823173).setVisibility(4);
        AppMethodBeat.m2505o(34857);
    }

    /* renamed from: h */
    static /* synthetic */ void m59774h(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34858);
        C4990ab.m7410d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.zAU.getVisibility() == 0) {
            cropImageNewUI.zAU.setVisibility(4);
            AppMethodBeat.m2505o(34858);
            return;
        }
        if (cropImageNewUI.zAU.getVisibility() == 4) {
            cropImageNewUI.zAU.setVisibility(0);
        }
        AppMethodBeat.m2505o(34858);
    }

    /* renamed from: a */
    static /* synthetic */ void m59762a(CropImageNewUI cropImageNewUI, boolean z) {
        AppMethodBeat.m2504i(34859);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (C42252ah.isNullOrNil(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] e = C5730e.m8632e(cropImageNewUI.filePath, 0, -1);
            C5730e.m8624b(stringExtra, e, e.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.zAV.getRotateCount() % 4);
        if (cropImageNewUI.zAT != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zAT.getFilterId());
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
        AppMethodBeat.m2505o(34859);
    }

    /* renamed from: k */
    static /* synthetic */ void m59778k(CropImageNewUI cropImageNewUI) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(34861);
        int[] dJH = cropImageNewUI.dJH();
        Bitmap hv = cropImageNewUI.m59775hv(dJH[2], dJH[3]);
        Bitmap hv2 = cropImageNewUI.m59775hv(dJH[0], dJH[1]);
        Bitmap bitmap2;
        if (cropImageNewUI.zAY == 0) {
            bitmap2 = hv2;
            bitmap = hv;
        } else {
            bitmap2 = hv;
            bitmap = hv2;
        }
        C4990ab.m7410d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.zAY);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.m59763a(bitmap, stringExtra, true) && cropImageNewUI.m59763a(bitmap2, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.zAT != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.zAT.getFilterId());
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
        AppMethodBeat.m2505o(34861);
    }

    /* renamed from: l */
    static /* synthetic */ void m59779l(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34862);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.zAS == 0) {
            try {
                String x = C1178g.m2591x((System.currentTimeMillis()).getBytes());
                C5056d.m7625a(cropImageNewUI.zAV.getBmp(), 100, CompressFormat.PNG, stringExtra + x, false);
                str = C1178g.m2591x(C5730e.m8632e(stringExtra + x, 0, (int) C5730e.asZ(stringExtra + x)));
                if (C5730e.m8628ct(stringExtra + str)) {
                    C4990ab.m7416i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    C5730e.deleteFile(stringExtra + x);
                } else {
                    C5730e.m8633h(stringExtra, x, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.zAS == 1) {
            byte[] e2 = C5730e.m8632e(cropImageNewUI.filePath, 0, -1);
            str = C1178g.m2591x(e2);
            if (C5730e.m8628ct(stringExtra + str)) {
                C4990ab.m7416i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                C5730e.m8624b(stringExtra + str, e2, e2.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.zAT != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zAT.getFilterId());
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
        AppMethodBeat.m2505o(34862);
    }

    /* renamed from: m */
    static /* synthetic */ void m59780m(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34863);
        String[] strArr = (cropImageNewUI.zAZ || cropImageNewUI.zBa) ? new String[]{cropImageNewUI.getString(C25738R.string.b3s)} : new String[]{cropImageNewUI.getString(C25738R.string.b3s)};
        C30379h.m48424a((Context) cropImageNewUI, "", strArr, "", false, new C2402414());
        AppMethodBeat.m2505o(34863);
    }

    /* renamed from: n */
    static /* synthetic */ void m59781n(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34864);
        Context context = cropImageNewUI;
        C30379h.m48424a(context, "", new String[]{cropImageNewUI.getString(C25738R.string.dr8), cropImageNewUI.getString(C25738R.string.dwz)}, "", false, new C3631613());
        AppMethodBeat.m2505o(34864);
    }

    /* renamed from: r */
    static /* synthetic */ void m59785r(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34866);
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
        AppMethodBeat.m2505o(34866);
    }

    /* renamed from: s */
    static /* synthetic */ void m59786s(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34867);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
        AppMethodBeat.m2505o(34867);
    }

    /* renamed from: t */
    static /* synthetic */ void m59787t(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34868);
        C14987n.m23321j(cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath"), cropImageNewUI);
        AppMethodBeat.m2505o(34868);
    }

    /* renamed from: u */
    static /* synthetic */ void m59788u(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.m2504i(34869);
        C30379h.m48440a((Context) cropImageNewUI, cropImageNewUI.getString(C25738R.string.b3q, new Object[]{Long.toString(C5730e.asZ(cropImageNewUI.filePath) / 1024)}), cropImageNewUI.getString(C25738R.string.f9238tz), new C556315(), new C3631716());
        AppMethodBeat.m2505o(34869);
    }
}
