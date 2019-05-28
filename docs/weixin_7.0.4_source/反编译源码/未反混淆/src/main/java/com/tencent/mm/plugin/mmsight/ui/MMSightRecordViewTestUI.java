package com.tencent.mm.plugin.mmsight.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI extends MMActivity {
    private int gLM = 720;
    private float gLO = 0.67f;
    private MMSightRecordView hGE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55125);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55117);
                MMSightRecordViewTestUI.this.finish();
                AppMethodBeat.o(55117);
                return false;
            }
        });
        this.hGE = (MMSightRecordView) findViewById(R.id.dbe);
        this.hGE.setDisplayRatio(this.gLO);
        this.hGE.setPreviewSizeLimit(this.gLM);
        this.hGE.setVideoPara$2e715812(100000);
        this.hGE.setVideoFilePath(e.eSn + "mmsighttest.mp4");
        this.hGE.setClipPictureSize(true);
        this.hGE.setClipVideoSize(true);
        this.hGE.osY.ast();
        this.hGE.setFlashMode(3);
        this.hGE.setFrameDataCallback(new a() {
            public final void q(byte[] bArr, int i, int i2) {
            }
        });
        this.hGE.osY.startPreview();
        this.hGE.osY.aso();
        findViewById(R.id.dbf).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55119);
                MMSightRecordViewTestUI.this.hGE.a(new g() {
                    public final void F(Bitmap bitmap) {
                        AppMethodBeat.i(55118);
                        if (bitmap != null) {
                            ((ImageView) MMSightRecordViewTestUI.this.findViewById(R.id.aga)).setImageBitmap(bitmap);
                        }
                        AppMethodBeat.o(55118);
                    }

                    public final void aDq() {
                    }
                }, true);
                AppMethodBeat.o(55119);
            }
        });
        findViewById(R.id.dbg).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55122);
                MMSightRecordViewTestUI.this.hGE.osY.EL();
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(55121);
                        MMSightRecordViewTestUI.this.hGE.a(new h() {
                            public final void dX(boolean z) {
                                AppMethodBeat.i(55120);
                                Toast.makeText(MMSightRecordViewTestUI.this, "record finish, error: ".concat(String.valueOf(z)), 0).show();
                                AppMethodBeat.o(55120);
                            }
                        });
                        AppMethodBeat.o(55121);
                    }
                }, 5000);
                AppMethodBeat.o(55122);
            }
        });
        final TextView textView = (TextView) findViewById(R.id.dbd);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55123);
                textView.setText("");
                textView.append(String.format("picture size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.this.hGE.getPictureSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.hGE.getPictureSize().x, MMSightRecordViewTestUI.this.hGE.getPictureSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.hGE.getPictureSize().x, MMSightRecordViewTestUI.this.hGE.getPictureSize().y)))}));
                textView.append(String.format("video size: %s, ratio: %s\n", new Object[]{MMSightRecordViewTestUI.this.hGE.getVideoSize(), Float.valueOf(((float) Math.min(MMSightRecordViewTestUI.this.hGE.getVideoSize().x, MMSightRecordViewTestUI.this.hGE.getVideoSize().y)) / ((float) Math.max(MMSightRecordViewTestUI.this.hGE.getVideoSize().x, MMSightRecordViewTestUI.this.hGE.getVideoSize().y)))}));
                textView.append(String.format("preview size limit: %s\n", new Object[]{Integer.valueOf(MMSightRecordViewTestUI.this.gLM)}));
                textView.append(String.format("display ratio: %s\n", new Object[]{Float.valueOf(MMSightRecordViewTestUI.this.gLO)}));
                textView.append(String.format("view size: %s, ratio: %s\n", new Object[]{new Point(MMSightRecordViewTestUI.this.hGE.getWidth(), MMSightRecordViewTestUI.this.hGE.getHeight()), Float.valueOf(((float) MMSightRecordViewTestUI.this.hGE.getWidth()) / ((float) MMSightRecordViewTestUI.this.hGE.getHeight()))}));
                AppMethodBeat.o(55123);
            }
        }, 1000);
        findViewById(R.id.dbh).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(55124);
                MMSightRecordViewTestUI.this.hGE.osY.switchCamera();
                AppMethodBeat.o(55124);
            }
        });
        AppMethodBeat.o(55125);
    }

    public void onDestroy() {
        AppMethodBeat.i(55126);
        super.onDestroy();
        this.hGE.osY.release();
        AppMethodBeat.o(55126);
    }

    public final int getLayoutId() {
        return R.layout.agy;
    }
}
