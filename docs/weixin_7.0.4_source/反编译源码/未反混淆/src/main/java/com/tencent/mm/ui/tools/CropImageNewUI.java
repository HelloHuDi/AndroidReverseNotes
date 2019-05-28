package com.tencent.mm.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.tools.CropImageView.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.IOException;
import java.lang.reflect.Array;
import junit.framework.Assert;

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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34855);
        boolean dJC = cropImageNewUI.dJC();
        AppMethodBeat.o(34855);
        return dJC;
    }

    public final int getLayoutId() {
        return R.layout.rl;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34838);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(34838);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(34839);
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
        AppMethodBeat.o(34839);
    }

    public void onResume() {
        AppMethodBeat.i(34840);
        super.onResume();
        setRequestedOrientation(1);
        AppMethodBeat.o(34840);
    }

    public void onDestroy() {
        AppMethodBeat.i(34841);
        if (this.zAV != null) {
            CropImageView cropImageView = this.zAV;
            if (!(cropImageView.mQQ == null || cropImageView.mQQ.isRecycled())) {
                ab.i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.mQQ.toString());
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
                ab.i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.zBT.toString());
                filterImageView.zBT.recycle();
            }
            filterImageView.zBT = null;
        }
        super.onDestroy();
        AppMethodBeat.o(34841);
    }

    public final void initView() {
        AppMethodBeat.i(34842);
        setMMTitle("");
        this.zAU = (LinearLayout) findViewById(R.id.b75);
        this.zAW = (ImageView) findViewById(R.id.b71);
        r.ci(this.zAW);
        this.zAX = findViewById(R.id.b70);
        this.zAR = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.zAR != 0);
        this.emC = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            dJD();
        }
        this.zBb = false;
        this.zAV = (CropImageView) findViewById(R.id.b74);
        r.ci(this.zAV);
        this.zAV.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34814);
                if (!CropImageNewUI.a(CropImageNewUI.this)) {
                    AppMethodBeat.o(34814);
                } else if (CropImageNewUI.this.zAZ || CropImageNewUI.this.zBa || !CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    if (1 == CropImageNewUI.this.zAR) {
                        CropImageNewUI.g(CropImageNewUI.this);
                    }
                    AppMethodBeat.o(34814);
                } else {
                    CropImageNewUI.d(CropImageNewUI.this);
                    if (!CropImageNewUI.this.getSharedPreferences(ah.doA(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        CropImageNewUI.this.zAT.findViewById(R.id.b72).setVisibility(4);
                    }
                    AppMethodBeat.o(34814);
                }
            }
        });
        this.zAV.setOnShortClick(new a() {
            public final void dJI() {
                AppMethodBeat.i(34825);
                CropImageNewUI.h(CropImageNewUI.this);
                AppMethodBeat.o(34825);
            }
        });
        dJF();
        switch (this.zAR) {
            case 1:
                dJE();
                this.zAT.setLimitZoomIn(false);
                this.zAT.dJL();
                this.zAT.setCropMaskVisible(0);
                if (this.emC == 1) {
                    this.zAT.setCropMaskBackground(R.drawable.ak3);
                    break;
                }
                break;
            case 2:
                this.zAV.setEnableOprate(false);
                findViewById(R.id.b76).setVisibility(8);
                findViewById(R.id.b7_).setVisibility(8);
                break;
            case 3:
                this.zAU.setVisibility(8);
                break;
            case 5:
                dJG();
                break;
        }
        ab.d("MicroMsg.CropImageUI", "mode is  " + this.zAR);
        AnonymousClass17 anonymousClass17 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34829);
                if (booleanExtra && booleanExtra2) {
                    CropImageNewUI.a(CropImageNewUI.this, true);
                    AppMethodBeat.o(34829);
                } else {
                    switch (CropImageNewUI.this.zAR) {
                        case 1:
                            if (CropImageNewUI.this.zAT == null) {
                                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zAV, CropImageNewUI.this.zAX);
                                break;
                            }
                            CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zAT.getCropImageIV(), CropImageNewUI.this.zAX);
                            break;
                        case 2:
                            CropImageNewUI.k(CropImageNewUI.this);
                            break;
                        case 3:
                            CropImageNewUI.l(CropImageNewUI.this);
                            break;
                        case 4:
                            CropImageNewUI.m(CropImageNewUI.this);
                            break;
                        case 5:
                            CropImageNewUI.n(CropImageNewUI.this);
                            break;
                    }
                    AppMethodBeat.o(34829);
                }
                return true;
            }
        };
        if (this.zAR == 5) {
            addIconOptionMenu(0, R.drawable.uu, anonymousClass17);
        } else if (this.zAR == 4) {
            addIconOptionMenu(0, R.drawable.uu, anonymousClass17);
            findViewById(R.id.b7_).setVisibility(0);
            Button button = (Button) findViewById(R.id.b7a);
            button.setText(R.string.b3p);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(34830);
                    CropImageNewUI.a(CropImageNewUI.this, true);
                    AppMethodBeat.o(34830);
                }
            });
        } else {
            a(0, getString(R.string.b3t), (OnMenuItemClickListener) anonymousClass17, b.GREEN);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(R.string.b3p), (OnMenuItemClickListener) anonymousClass17, b.GREEN);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34831);
                CropImageNewUI.this.finish();
                AppMethodBeat.o(34831);
                return true;
            }
        });
        if (this.zAR == 6) {
            findViewById(R.id.b7_).setVisibility(8);
            a(0, getString(R.string.b3t), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(34834);
                    d dVar = new d(CropImageNewUI.this, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(34832);
                            lVar.hi(0, R.string.b3y);
                            lVar.hi(1, R.string.b42);
                            AppMethodBeat.o(34832);
                        }
                    };
                    dVar.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(34833);
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 1);
                                    CropImageNewUI.this.setResult(-1, intent);
                                    CropImageNewUI.this.finish();
                                    AppMethodBeat.o(34833);
                                    return;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 2);
                                    CropImageNewUI.this.setResult(-1, intent);
                                    CropImageNewUI.this.finish();
                                    break;
                            }
                            AppMethodBeat.o(34833);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(34834);
                    return true;
                }
            }, b.GREEN);
        }
        AppMethodBeat.o(34842);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34843);
        ab.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            ab.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.zAV.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34835);
                    CropImageNewUI.a(CropImageNewUI.this);
                    AppMethodBeat.o(34835);
                }
            });
        }
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(34843);
    }

    private boolean dJC() {
        View findViewById;
        AppMethodBeat.i(34844);
        if (1 != this.zAR) {
            findViewById = findViewById(R.id.b73);
        } else if (this.zAT != null) {
            findViewById = this.zAT.getCropAreaView();
        } else {
            findViewById = findViewById(R.id.b70);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        ab.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (e.ct(this.filePath)) {
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
                ab.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Float.valueOf(f));
                Button button = (Button) findViewById(R.id.b7a);
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
                    ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
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
                com.tencent.mm.sdk.platformtools.d.dnX();
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                    decodeFile3.recycle();
                }
                z = com.tencent.mm.platformtools.ah.cJ(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.zAZ = z;
                z = com.tencent.mm.platformtools.ah.cI(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.zBa = z;
                if (this.zAZ || this.zBa) {
                    i5 = options3.outHeight;
                    i4 = options3.outWidth;
                }
                ab.e("MicroMsg.CropImageUI", "width is " + i4 + " height is " + i5);
                z = false;
                i = i5;
                i2 = i4;
            }
            this.zAY = ExifHelper.bJ(this.filePath);
            if (this.zAY == 90 || this.zAY == 270) {
                i5 = i2;
                i4 = i;
            } else {
                i5 = i;
                i4 = i2;
            }
            Bitmap d = com.tencent.mm.sdk.platformtools.d.d(this.filePath, i5, i4, z);
            byte[] e = e.e(this.filePath, 0, 10);
            if (com.tencent.mm.sdk.platformtools.r.bS(e)) {
                this.zAS = 1;
            } else {
                this.zAS = 0;
            }
            if (d == null) {
                finish();
                AppMethodBeat.o(34844);
                return false;
            }
            float height2;
            float f2;
            ab.d("temBmp crop", "h:" + d.getHeight() + "w: " + d.getWidth());
            Bitmap b = com.tencent.mm.sdk.platformtools.d.b(d, (float) this.zAY);
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
                ab.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
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
                        ab.d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(f)));
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
                if (com.tencent.mm.sdk.platformtools.r.bS(e)) {
                    this.zAS = 1;
                    try {
                        com.tencent.mm.plugin.gif.b eD = com.tencent.mm.plugin.gif.c.bFN().eD(this.filePath, this.filePath);
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
                        ab.e("MicroMsg.CropImageUI", bo.l(e2));
                    }
                } else {
                    this.zAS = 0;
                }
                AppMethodBeat.o(34844);
                return true;
            }
            if (this.zAZ || this.zBa) {
                findViewById(R.id.b77).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(R.id.b7_).setVisibility(8);
            }
            AppMethodBeat.o(34844);
            return true;
        }
        finish();
        AppMethodBeat.o(34844);
        return false;
    }

    private void c(Runnable runnable, Runnable runnable2) {
        AppMethodBeat.i(34845);
        this.zAT = (FilterImageView) findViewById(R.id.b7b);
        r.ci(this.zAT);
        this.zAT.setOnConfirmImp(runnable);
        this.zAT.setOnExitImp(runnable2);
        AppMethodBeat.o(34845);
    }

    private void dJD() {
        AppMethodBeat.i(34846);
        c(new Runnable() {
            public final void run() {
                boolean z = false;
                AppMethodBeat.i(34836);
                if (CropImageNewUI.this.zAT == null) {
                    AppMethodBeat.o(34836);
                    return;
                }
                if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    Editor edit = CropImageNewUI.this.getSharedPreferences(ah.doA(), 0).edit();
                    String str = "CropImage_Filter_Show";
                    if (CropImageNewUI.this.zAT.findViewById(R.id.b72).getVisibility() == 0) {
                        z = true;
                    }
                    edit.putBoolean(str, z);
                    edit.commit();
                }
                String stringExtra = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = com.tencent.mm.compatible.util.e.euR + g.x((CropImageNewUI.this.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
                }
                Intent intent = new Intent();
                intent.putExtra("CropImage_Compress_Img", true);
                if (CropImageNewUI.this.zAT != null) {
                    intent.putExtra("CropImage_filterId", CropImageNewUI.this.zAT.getFilterId());
                }
                if (CropImageNewUI.this.zAT.getFilterId() == 0) {
                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.filePath);
                    CropImageNewUI.this.setResult(-1, intent);
                } else if (CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zAT.getFilterBmp(), stringExtra)) {
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    CropImageNewUI.this.setResult(-1, intent);
                } else {
                    CropImageNewUI.this.setResult(-1);
                }
                CropImageNewUI.this.finish();
                AppMethodBeat.o(34836);
            }
        }, new Runnable() {
            public final void run() {
                AppMethodBeat.i(34837);
                if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.this.finish();
                    AppMethodBeat.o(34837);
                    return;
                }
                CropImageNewUI.this.zAT.setVisibility(8);
                CropImageNewUI.this.zAU.setVisibility(0);
                CropImageNewUI.this.zAW.setVisibility(((Integer) CropImageNewUI.this.zAW.getTag()).intValue());
                CropImageNewUI.this.zAV.setVisibility(0);
                AppMethodBeat.o(34837);
            }
        });
        AppMethodBeat.o(34846);
    }

    private void dJE() {
        AppMethodBeat.i(34847);
        c(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34815);
                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zAT.getCropImageIV(), CropImageNewUI.this.zAT.getCropAreaView());
                CropImageNewUI.this.finish();
                AppMethodBeat.o(34815);
            }
        }, new Runnable() {
            public final void run() {
                AppMethodBeat.i(34816);
                CropImageNewUI.this.finish();
                AppMethodBeat.o(34816);
            }
        });
        AppMethodBeat.o(34847);
    }

    private void dJF() {
        AppMethodBeat.i(34848);
        ((Button) findViewById(R.id.b77)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34817);
                CropImageView j = CropImageNewUI.this.zAV;
                if (j.mQQ == null) {
                    ab.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                    AppMethodBeat.o(34817);
                    return;
                }
                float[] fArr = new float[]{(float) (j.mQQ.getWidth() / 2), (float) (j.mQQ.getHeight() / 2)};
                j.getImageMatrix().mapPoints(fArr);
                j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                j.setImageBitmap(j.mQQ);
                j.invalidate();
                j.cDW++;
                AppMethodBeat.o(34817);
            }
        });
        Button button = (Button) findViewById(R.id.b79);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34818);
                CropImageNewUI.this.zAV.zoomIn();
                AppMethodBeat.o(34818);
            }
        });
        Button button2 = (Button) findViewById(R.id.b78);
        button2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34819);
                CropImageNewUI.this.zAV.zoomOut();
                AppMethodBeat.o(34819);
            }
        });
        final ap apVar = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(34820);
                CropImageNewUI.this.zAV.zoomIn();
                AppMethodBeat.o(34820);
                return true;
            }
        }, true);
        final ap apVar2 = new ap(new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(34821);
                CropImageNewUI.this.zAV.zoomOut();
                AppMethodBeat.o(34821);
                return true;
            }
        }, true);
        button.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34822);
                switch (motionEvent.getAction()) {
                    case 0:
                        apVar.ae(200, 200);
                        break;
                    case 1:
                        apVar.stopTimer();
                        break;
                }
                AppMethodBeat.o(34822);
                return false;
            }
        });
        button2.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34823);
                switch (motionEvent.getAction()) {
                    case 0:
                        apVar2.ae(200, 200);
                        break;
                    case 1:
                        apVar2.stopTimer();
                        break;
                }
                AppMethodBeat.o(34823);
                return false;
            }
        });
        AppMethodBeat.o(34848);
    }

    private void dJG() {
        AppMethodBeat.i(34849);
        int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
        boolean booleanExtra = getIntent().getBooleanExtra("CropImage_BHasHD", false);
        if (intExtra == 1 || !booleanExtra) {
            findViewById(R.id.b7_).setVisibility(8);
            AppMethodBeat.o(34849);
            return;
        }
        findViewById(R.id.b7_).setVisibility(0);
        Button button = (Button) findViewById(R.id.b7a);
        button.setBackgroundResource(R.drawable.fw);
        button.setPadding(25, 8, 25, 8);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34824);
                CropImageNewUI.r(CropImageNewUI.this);
                AppMethodBeat.o(34824);
            }
        });
        AppMethodBeat.o(34849);
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
        AppMethodBeat.i(34850);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        ab.e("MicroMsg.CropImageUI", "window TitleBar.h:".concat(String.valueOf(i5)));
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(com.tencent.mm.platformtools.ah.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                ab.e("MicroMsg.CropImageUI", "sbar:".concat(String.valueOf(i5)));
                i = i5;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
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
            AppMethodBeat.o(34850);
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
        AppMethodBeat.o(34850);
        return iArr;
    }

    private Bitmap hv(int i, int i2) {
        AppMethodBeat.i(34851);
        Bitmap d = com.tencent.mm.sdk.platformtools.d.d(this.filePath, i2, i, true);
        if (this.zAY != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.zAY, (float) (d.getWidth() / 2), (float) (d.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
            if (d != createBitmap) {
                ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", d.toString());
                d.recycle();
            }
            d = createBitmap;
        }
        ab.d("MicroMsg.CropImageUI", "getcrop degree:" + this.zAY);
        AppMethodBeat.o(34851);
        return d;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        AppMethodBeat.i(34852);
        if (cropImageView == null) {
            AppMethodBeat.o(34852);
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] c = l.c(fArr, new float[]{f, f2, 1.0f});
        float[] c2 = l.c(fArr, fArr2);
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
        ab.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bmp.getWidth()), Integer.valueOf(bmp.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        bmp = Bitmap.createBitmap(bmp, min, min2, abs, abs2, matrix, true);
        AppMethodBeat.o(34852);
        return bmp;
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        AppMethodBeat.i(34853);
        if (!(str == null || str.equals(""))) {
            try {
                if (this.emC == 1) {
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 30, CompressFormat.JPEG, str, z);
                } else {
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, str, z);
                }
                AppMethodBeat.o(34853);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                ab.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        AppMethodBeat.o(34853);
        return false;
    }

    private static float[][] c(Matrix matrix) {
        AppMethodBeat.i(34854);
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        AppMethodBeat.o(34854);
        return fArr;
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34856);
        if (cropImageNewUI.zAT.getFilterBmp() == null) {
            cropImageNewUI.zAT.eH(cropImageNewUI.filePath, cropImageNewUI.zAY);
        }
        cropImageNewUI.zAU.setVisibility(8);
        cropImageNewUI.zAT.setVisibility(0);
        cropImageNewUI.zAW.setTag(Integer.valueOf(cropImageNewUI.zAW.getVisibility()));
        cropImageNewUI.zAW.setVisibility(8);
        cropImageNewUI.zAV.setVisibility(8);
        AppMethodBeat.o(34856);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34857);
        cropImageNewUI.zAT.eH(cropImageNewUI.filePath, cropImageNewUI.zAY);
        cropImageNewUI.zAU.setVisibility(8);
        cropImageNewUI.zAT.setVisibility(0);
        cropImageNewUI.zAW.setTag(Integer.valueOf(cropImageNewUI.zAW.getVisibility()));
        cropImageNewUI.zAW.setVisibility(8);
        cropImageNewUI.zAV.setVisibility(8);
        cropImageNewUI.zAT.findViewById(R.id.b72).setVisibility(4);
        AppMethodBeat.o(34857);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34858);
        ab.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.zAU.getVisibility() == 0) {
            cropImageNewUI.zAU.setVisibility(4);
            AppMethodBeat.o(34858);
            return;
        }
        if (cropImageNewUI.zAU.getVisibility() == 4) {
            cropImageNewUI.zAU.setVisibility(0);
        }
        AppMethodBeat.o(34858);
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        AppMethodBeat.i(34859);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (com.tencent.mm.platformtools.ah.isNullOrNil(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] e = e.e(cropImageNewUI.filePath, 0, -1);
            e.b(stringExtra, e, e.length);
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
        AppMethodBeat.o(34859);
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        Bitmap bitmap;
        AppMethodBeat.i(34861);
        int[] dJH = cropImageNewUI.dJH();
        Bitmap hv = cropImageNewUI.hv(dJH[2], dJH[3]);
        Bitmap hv2 = cropImageNewUI.hv(dJH[0], dJH[1]);
        Bitmap bitmap2;
        if (cropImageNewUI.zAY == 0) {
            bitmap2 = hv2;
            bitmap = hv;
        } else {
            bitmap2 = hv;
            bitmap = hv2;
        }
        ab.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.zAY);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(bitmap, stringExtra, true) && cropImageNewUI.a(bitmap2, stringExtra2, true)) {
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
        AppMethodBeat.o(34861);
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34862);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.zAS == 0) {
            try {
                String x = g.x((System.currentTimeMillis()).getBytes());
                com.tencent.mm.sdk.platformtools.d.a(cropImageNewUI.zAV.getBmp(), 100, CompressFormat.PNG, stringExtra + x, false);
                str = g.x(e.e(stringExtra + x, 0, (int) e.asZ(stringExtra + x)));
                if (e.ct(stringExtra + str)) {
                    ab.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    e.deleteFile(stringExtra + x);
                } else {
                    e.h(stringExtra, x, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.zAS == 1) {
            byte[] e2 = e.e(cropImageNewUI.filePath, 0, -1);
            str = g.x(e2);
            if (e.ct(stringExtra + str)) {
                ab.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                e.b(stringExtra + str, e2, e2.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.zAT != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zAT.getFilterId());
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
        AppMethodBeat.o(34862);
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34863);
        String[] strArr = (cropImageNewUI.zAZ || cropImageNewUI.zBa) ? new String[]{cropImageNewUI.getString(R.string.b3s)} : new String[]{cropImageNewUI.getString(R.string.b3s)};
        h.a((Context) cropImageNewUI, "", strArr, "", false, new h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(34827);
                switch (i) {
                    case 0:
                        CropImageNewUI.u(CropImageNewUI.this);
                        break;
                }
                AppMethodBeat.o(34827);
            }
        });
        AppMethodBeat.o(34863);
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34864);
        Context context = cropImageNewUI;
        h.a(context, "", new String[]{cropImageNewUI.getString(R.string.dr8), cropImageNewUI.getString(R.string.dwz)}, "", false, new h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(34826);
                switch (i) {
                    case 0:
                        CropImageNewUI.s(CropImageNewUI.this);
                        AppMethodBeat.o(34826);
                        return;
                    case 1:
                        CropImageNewUI.t(CropImageNewUI.this);
                        break;
                }
                AppMethodBeat.o(34826);
            }
        });
        AppMethodBeat.o(34864);
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34866);
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
        AppMethodBeat.o(34866);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34867);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
        AppMethodBeat.o(34867);
    }

    static /* synthetic */ void t(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34868);
        com.tencent.mm.pluginsdk.ui.tools.n.j(cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath"), cropImageNewUI);
        AppMethodBeat.o(34868);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        AppMethodBeat.i(34869);
        h.a((Context) cropImageNewUI, cropImageNewUI.getString(R.string.b3q, new Object[]{Long.toString(e.asZ(cropImageNewUI.filePath) / 1024)}), cropImageNewUI.getString(R.string.tz), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34828);
                CropImageNewUI.a(CropImageNewUI.this, false);
                AppMethodBeat.o(34828);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(34869);
    }
}
