package com.tencent.p177mm.p612ui.contact;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI */
public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery kkn;
    private String username;
    private View zlv;
    private String zlw;
    private boolean zlx;
    private boolean zly;
    private C40832a zlz;

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$1 */
    class C54311 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$1$1 */
        class C54301 implements C36073c {
            C54301() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(33613);
                c44273l.mo70068e(0, ContactRemarkImagePreviewUI.this.getString(C25738R.string.dwz));
                if (C25985d.afj("favorite")) {
                    c44273l.mo70068e(1, ContactRemarkImagePreviewUI.this.getString(C25738R.string.dcq));
                }
                if (!ContactRemarkImagePreviewUI.this.zly) {
                    c44273l.mo70068e(2, ContactRemarkImagePreviewUI.this.getString(C25738R.string.f9088p4));
                }
                AppMethodBeat.m2505o(33613);
            }
        }

        /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$1$2 */
        class C54322 implements C5279d {
            C54322() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(33614);
                switch (menuItem.getItemId()) {
                    case 0:
                        C14987n.m23321j(ContactRemarkImagePreviewUI.this.zlw, ContactRemarkImagePreviewUI.this);
                        AppMethodBeat.m2505o(33614);
                        return;
                    case 1:
                        ContactRemarkImagePreviewUI.m88387d(ContactRemarkImagePreviewUI.this);
                        break;
                    case 2:
                        if (ContactRemarkImagePreviewUI.this.zlx) {
                            new File(ContactRemarkImagePreviewUI.this.zlw).delete();
                            ContactRemarkImagePreviewUI.m88383a(ContactRemarkImagePreviewUI.this, true);
                            AppMethodBeat.m2505o(33614);
                            return;
                        }
                        ContactRemarkImagePreviewUI.m88383a(ContactRemarkImagePreviewUI.this, true);
                        AppMethodBeat.m2505o(33614);
                        return;
                }
                AppMethodBeat.m2505o(33614);
            }
        }

        C54311() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33615);
            C36356d c36356d = new C36356d(ContactRemarkImagePreviewUI.this, 1, false);
            c36356d.rBl = new C54301();
            c36356d.rBm = new C54322();
            c36356d.cpD();
            AppMethodBeat.m2505o(33615);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$2 */
    class C157912 implements OnMenuItemClickListener {
        C157912() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(33616);
            ContactRemarkImagePreviewUI.m88383a(ContactRemarkImagePreviewUI.this, false);
            AppMethodBeat.m2505o(33616);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$3 */
    class C408313 implements OnItemClickListener {
        C408313() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(33617);
            if (ContactRemarkImagePreviewUI.this.mController.isTitleShowing()) {
                ContactRemarkImagePreviewUI.this.mController.hideTitleView();
                AppMethodBeat.m2505o(33617);
                return;
            }
            ContactRemarkImagePreviewUI.this.mController.showTitleView();
            AppMethodBeat.m2505o(33617);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI$a */
    class C40832a extends BaseAdapter {
        String imagePath;

        C40832a() {
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
            AppMethodBeat.m2504i(33618);
            View inflate = View.inflate(ContactRemarkImagePreviewUI.this, 2130969234, null);
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(2131820629);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Bitmap i2 = C4977b.m7374i(this.imagePath, C1338a.getDensity(ContactRemarkImagePreviewUI.this));
            if (i2 != null) {
                int width = ContactRemarkImagePreviewUI.this.zlv.getWidth();
                int height = ContactRemarkImagePreviewUI.this.zlv.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                float width2 = ((float) i2.getWidth()) / ((float) i2.getHeight());
                float height2 = ((float) i2.getHeight()) / ((float) i2.getWidth());
                C4990ab.m7418v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
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
                        C4990ab.m7410d("MicroMsg.ImagePreviewUI", " offsety ".concat(String.valueOf(width2)));
                        matrix.postTranslate(0.0f, width2);
                    }
                }
                multiTouchImageView.setImageMatrix(matrix);
                multiTouchImageView.mo71980bW(i2.getWidth(), i2.getHeight());
                multiTouchImageView.setImageBitmap(i2);
            }
            AppMethodBeat.m2505o(33618);
            return inflate;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m88383a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI, boolean z) {
        AppMethodBeat.m2504i(33626);
        contactRemarkImagePreviewUI.m88389qC(z);
        AppMethodBeat.m2505o(33626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33619);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.zlw = getIntent().getStringExtra("remark_image_path");
        this.zlx = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.zly = getIntent().getBooleanExtra("view_only", false);
        if (C5046bo.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.m2505o(33619);
            return;
        }
        initView();
        AppMethodBeat.m2505o(33619);
    }

    public void onPause() {
        AppMethodBeat.m2504i(33620);
        super.onPause();
        AppMethodBeat.m2505o(33620);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33621);
        super.onDestroy();
        AppMethodBeat.m2505o(33621);
    }

    public final int getLayoutId() {
        return 2130969233;
    }

    public final void initView() {
        AppMethodBeat.m2504i(33622);
        this.zlv = findViewById(2131822738);
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        setMMTitle((int) C25738R.string.d16);
        dHG();
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C54311());
        setBackBtn(new C157912());
        AppMethodBeat.m2505o(33622);
    }

    /* renamed from: qC */
    private void m88389qC(boolean z) {
        AppMethodBeat.m2504i(33623);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
        AppMethodBeat.m2505o(33623);
    }

    private void dHG() {
        AppMethodBeat.m2504i(33624);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        C46616n.m88170ci(this.kkn);
        this.zlz = new C40832a();
        this.zlz.imagePath = this.zlw;
        this.kkn.setAdapter(this.zlz);
        this.kkn.setOnItemClickListener(new C408313());
        AppMethodBeat.m2505o(33624);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(33625);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            m88389qC(false);
            AppMethodBeat.m2505o(33625);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(33625);
        return onKeyDown;
    }

    /* renamed from: d */
    static /* synthetic */ void m88387d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        AppMethodBeat.m2504i(33627);
        C45316cl c45316cl = new C45316cl();
        C40443e.m69368a(c45316cl, 6, contactRemarkImagePreviewUI.zlw);
        c45316cl.cvA.activity = contactRemarkImagePreviewUI;
        c45316cl.cvA.cvH = 46;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(33627);
    }
}
