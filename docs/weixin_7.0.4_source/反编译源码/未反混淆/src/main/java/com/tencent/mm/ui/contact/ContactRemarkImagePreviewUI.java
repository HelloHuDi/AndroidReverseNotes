package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.d;
import java.io.File;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery kkn;
    private String username;
    private View zlv;
    private String zlw;
    private boolean zlx;
    private boolean zly;
    private a zlz;

    class a extends BaseAdapter {
        String imagePath;

        a() {
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return this.imagePath;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(33618);
            View inflate = View.inflate(ContactRemarkImagePreviewUI.this, R.layout.r1, null);
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(R.id.bl);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Bitmap i2 = b.i(this.imagePath, com.tencent.mm.bz.a.getDensity(ContactRemarkImagePreviewUI.this));
            if (i2 != null) {
                int width = ContactRemarkImagePreviewUI.this.zlv.getWidth();
                int height = ContactRemarkImagePreviewUI.this.zlv.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                float width2 = ((float) i2.getWidth()) / ((float) i2.getHeight());
                float height2 = ((float) i2.getHeight()) / ((float) i2.getWidth());
                ab.v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
                if (height2 >= 2.0f && i2.getHeight() >= 480) {
                    height2 = ((float) width) / ((float) i2.getWidth());
                    if (((double) (((float) i2.getWidth()) / ((float) width))) > 1.0d) {
                        matrix.postScale(height2, height2);
                        i2.getHeight();
                        matrix.postTranslate((((float) width) - (height2 * ((float) i2.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        matrix.postTranslate((float) ((width - i2.getWidth()) / 2), 0.0f);
                    }
                } else if (width2 < 2.0f || i2.getWidth() < 480) {
                    width2 = ((float) width) / ((float) i2.getWidth());
                    height2 = ((float) height) / ((float) i2.getHeight());
                    if (width2 >= height2) {
                        width2 = height2;
                    }
                    height2 = ((float) i2.getWidth()) / ((float) width);
                    float height3 = ((float) i2.getHeight()) / ((float) height);
                    if (height2 <= height3) {
                        height2 = height3;
                    }
                    if (((double) height2) > 1.0d) {
                        matrix.postScale(width2, width2);
                    } else {
                        width2 = 1.0f;
                    }
                    matrix.postTranslate((((float) width) - (((float) i2.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) i2.getHeight()))) / 2.0f);
                } else {
                    width2 = ((float) i2.getHeight()) / 480.0f;
                    height2 = 480.0f / ((float) i2.getHeight());
                    if (((double) width2) > 1.0d) {
                        matrix.postScale(width2, height2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        width2 = (float) ((height - i2.getHeight()) / 2);
                        ab.d("MicroMsg.ImagePreviewUI", " offsety ".concat(String.valueOf(width2)));
                        matrix.postTranslate(0.0f, width2);
                    }
                }
                multiTouchImageView.setImageMatrix(matrix);
                multiTouchImageView.bW(i2.getWidth(), i2.getHeight());
                multiTouchImageView.setImageBitmap(i2);
            }
            AppMethodBeat.o(33618);
            return inflate;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI, boolean z) {
        AppMethodBeat.i(33626);
        contactRemarkImagePreviewUI.qC(z);
        AppMethodBeat.o(33626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33619);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.zlw = getIntent().getStringExtra("remark_image_path");
        this.zlx = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.zly = getIntent().getBooleanExtra("view_only", false);
        if (bo.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(33619);
            return;
        }
        initView();
        AppMethodBeat.o(33619);
    }

    public void onPause() {
        AppMethodBeat.i(33620);
        super.onPause();
        AppMethodBeat.o(33620);
    }

    public void onDestroy() {
        AppMethodBeat.i(33621);
        super.onDestroy();
        AppMethodBeat.o(33621);
    }

    public final int getLayoutId() {
        return R.layout.r0;
    }

    public final void initView() {
        AppMethodBeat.i(33622);
        this.zlv = findViewById(R.id.ava);
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        setMMTitle((int) R.string.d16);
        dHG();
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33615);
                d dVar = new d(ContactRemarkImagePreviewUI.this, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(33613);
                        lVar.e(0, ContactRemarkImagePreviewUI.this.getString(R.string.dwz));
                        if (com.tencent.mm.bp.d.afj("favorite")) {
                            lVar.e(1, ContactRemarkImagePreviewUI.this.getString(R.string.dcq));
                        }
                        if (!ContactRemarkImagePreviewUI.this.zly) {
                            lVar.e(2, ContactRemarkImagePreviewUI.this.getString(R.string.p4));
                        }
                        AppMethodBeat.o(33613);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(33614);
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.pluginsdk.ui.tools.n.j(ContactRemarkImagePreviewUI.this.zlw, ContactRemarkImagePreviewUI.this);
                                AppMethodBeat.o(33614);
                                return;
                            case 1:
                                ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.this);
                                break;
                            case 2:
                                if (ContactRemarkImagePreviewUI.this.zlx) {
                                    new File(ContactRemarkImagePreviewUI.this.zlw).delete();
                                    ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                                    AppMethodBeat.o(33614);
                                    return;
                                }
                                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                                AppMethodBeat.o(33614);
                                return;
                        }
                        AppMethodBeat.o(33614);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(33615);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33616);
                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, false);
                AppMethodBeat.o(33616);
                return false;
            }
        });
        AppMethodBeat.o(33622);
    }

    private void qC(boolean z) {
        AppMethodBeat.i(33623);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
        AppMethodBeat.o(33623);
    }

    private void dHG() {
        AppMethodBeat.i(33624);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        com.tencent.mm.sdk.platformtools.n.ci(this.kkn);
        this.zlz = new a();
        this.zlz.imagePath = this.zlw;
        this.kkn.setAdapter(this.zlz);
        this.kkn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(33617);
                if (ContactRemarkImagePreviewUI.this.mController.isTitleShowing()) {
                    ContactRemarkImagePreviewUI.this.mController.hideTitleView();
                    AppMethodBeat.o(33617);
                    return;
                }
                ContactRemarkImagePreviewUI.this.mController.showTitleView();
                AppMethodBeat.o(33617);
            }
        });
        AppMethodBeat.o(33624);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(33625);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            qC(false);
            AppMethodBeat.o(33625);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(33625);
        return onKeyDown;
    }

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        AppMethodBeat.i(33627);
        cl clVar = new cl();
        e.a(clVar, 6, contactRemarkImagePreviewUI.zlw);
        clVar.cvA.activity = contactRemarkImagePreviewUI;
        clVar.cvA.cvH = 46;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(33627);
    }
}
