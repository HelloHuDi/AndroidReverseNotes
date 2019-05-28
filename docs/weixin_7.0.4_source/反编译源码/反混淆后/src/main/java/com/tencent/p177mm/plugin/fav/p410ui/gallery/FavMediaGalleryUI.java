package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30744c;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C20679y;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C6894q;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i;
import com.tencent.p177mm.plugin.fav.p410ui.C3104f;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.plugin.fav.p410ui.widget.FavVideoView;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI */
public class FavMediaGalleryUI extends MMActivity implements OnItemSelectedListener, C11855p {
    private boolean cHc = true;
    private ArrayList<C3104f> iLD;
    private C46696j icA;
    private MMGestureGallery kkn;
    private C5279d lcJ = new C207408();
    private int mik = 0;
    private Map<String, C18346nr> mim = new HashMap();
    private long mio;
    private C4884c mip = new C207323();
    private int mnC = -1;
    private FavVideoView mnD = null;
    private C20736a mnE;
    private List<FavVideoView> mnF = new ArrayList();
    abh mnG = new abh();

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$7 */
    class C207297 implements OnCancelListener {
        C207297() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(74514);
            FavMediaGalleryUI.this.icA = null;
            AppMethodBeat.m2505o(74514);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$b */
    class C20730b {
        View miu;
        MultiTouchImageView miv;
        ImageView miw;
        TextView mix;
        LinearLayout miy;
        TextView miz;
        ProgressBar progressBar;

        private C20730b() {
        }

        /* synthetic */ C20730b(FavMediaGalleryUI favMediaGalleryUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$3 */
    class C207323 extends C4884c<C18346nr> {
        C207323() {
            AppMethodBeat.m2504i(74509);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(74509);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(74510);
            C18346nr c18346nr = (C18346nr) c4883b;
            FavMediaGalleryUI.this.mim.put(c18346nr.cJX.filePath, c18346nr);
            if (FavMediaGalleryUI.this.icA != null && FavMediaGalleryUI.this.icA.rBk.isShowing()) {
                FavMediaGalleryUI.m31958a(FavMediaGalleryUI.this);
            }
            AppMethodBeat.m2505o(74510);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$4 */
    class C207334 implements C30744c {
        C207334() {
        }

        public final void bvE() {
            AppMethodBeat.m2504i(74511);
            if (!(FavMediaGalleryUI.this.isFinishing() || FavMediaGalleryUI.this.uiu)) {
                FavMediaGalleryUI.m31958a(FavMediaGalleryUI.this);
            }
            AppMethodBeat.m2505o(74511);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$5 */
    class C207345 implements OnMenuItemClickListener {
        C207345() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74512);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.m2505o(74512);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$a */
    class C20736a extends BaseAdapter {
        SparseBooleanArray mit;

        private C20736a() {
            AppMethodBeat.m2504i(74519);
            this.mit = new SparseBooleanArray();
            AppMethodBeat.m2505o(74519);
        }

        /* synthetic */ C20736a(FavMediaGalleryUI favMediaGalleryUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(74527);
            C3104f vC = mo36041vC(i);
            AppMethodBeat.m2505o(74527);
            return vC;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(74520);
            if (i > FavMediaGalleryUI.this.iLD.size()) {
                AppMethodBeat.m2505o(74520);
                return 2;
            }
            int i2 = ((C3104f) FavMediaGalleryUI.this.iLD.get(i)).cAv.dataType;
            AppMethodBeat.m2505o(74520);
            return i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(74521);
            int size = FavMediaGalleryUI.this.iLD.size();
            AppMethodBeat.m2505o(74521);
            return size;
        }

        /* renamed from: vC */
        public final C3104f mo36041vC(int i) {
            AppMethodBeat.m2504i(74522);
            if (i >= FavMediaGalleryUI.this.iLD.size()) {
                C4990ab.m7421w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", Integer.valueOf(i));
                AppMethodBeat.m2505o(74522);
                return null;
            }
            C3104f c3104f = (C3104f) FavMediaGalleryUI.this.iLD.get(i);
            AppMethodBeat.m2505o(74522);
            return c3104f;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(74523);
            C3104f vC = mo36041vC(i);
            if (vC.cAv.dataType == 15 || vC.cAv.dataType == 4) {
                View favVideoView;
                if (view == null) {
                    favVideoView = new FavVideoView(FavMediaGalleryUI.this.mController.ylL);
                    FavMediaGalleryUI.this.mnF.add((FavVideoView) favVideoView);
                } else {
                    favVideoView = view;
                }
                FavVideoView favVideoView2 = (FavVideoView) favVideoView;
                favVideoView2.mmZ.setVisibility(8);
                String b = C39037b.m66370b(vC.cAv);
                if (C1173e.m2561ct(b)) {
                    favVideoView2.setVideoData(b);
                } else {
                    String str = vC.cAv.mnd;
                    C45925c LR = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15156LR(str);
                    if (LR == null || LR.field_status != 1) {
                        if (C5046bo.isNullOrNil(vC.cAv.wfZ) || C5046bo.isNullOrNil(vC.cAv.wgb)) {
                            C4990ab.m7410d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
                            favVideoView2.mo73797a(b, false, str);
                            favVideoView2.mmZ.setVisibility(0);
                        } else {
                            C4990ab.m7411d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", str);
                            C39037b.m66360a(vC.mij, vC.cAv, true);
                            favVideoView2.mo73797a(b, true, str);
                        }
                    }
                }
                String c = C39037b.m66379c(vC.cAv);
                if (C1173e.m2561ct(c)) {
                    favVideoView2.setThumbView(c);
                } else {
                    C4990ab.m7417i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", c);
                    C39037b.m66359a(vC.mij, vC.cAv);
                }
                AppMethodBeat.m2505o(74523);
                return favVideoView;
            }
            C20730b c20730b;
            if (view == null) {
                c20730b = new C20730b(FavMediaGalleryUI.this, (byte) 0);
                view = View.inflate(FavMediaGalleryUI.this.mController.ylL, 2130969503, null);
                c20730b.miu = view.findViewById(2131820630);
                c20730b.miv = (MultiTouchImageView) view.findViewById(2131820629);
                c20730b.progressBar = (ProgressBar) view.findViewById(2131822617);
                c20730b.miw = (ImageView) view.findViewById(2131821511);
                c20730b.mix = (TextView) view.findViewById(2131823911);
                c20730b.miy = (LinearLayout) view.findViewById(2131823884);
                c20730b.miz = (TextView) view.findViewById(2131823885);
                c20730b.miz.setText(C25738R.string.bnw);
                view.setTag(c20730b);
            } else {
                c20730b = (C20730b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            boolean z = this.mit.get(i, true);
            this.mit.put(i, false);
            Bitmap a = C45939l.m85276a(vC.cAv, vC.mij, z);
            if (vC.mij != null) {
                C4990ab.m7417i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i), Integer.valueOf(vC.mij.field_id), Long.valueOf(vC.mij.field_localId), Integer.valueOf(vC.mij.field_itemStatus));
            }
            if (vC.cAv != null) {
                C4990ab.m7417i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", vC.cAv.mnd, vC.cAv.wfZ, vC.cAv.wgb, Long.valueOf(vC.cAv.wgu), vC.cAv.fgE, vC.cAv.wfV, Long.valueOf(vC.cAv.wgF));
            }
            if (a == null) {
                String str2;
                FavMediaGalleryUI.this.enableOptionMenu(false);
                C4990ab.m7420w("MicroMsg.FavMediaGalleryUI", "get big image fail");
                C6894q favCdnStorage = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage();
                if (vC.cAv != null) {
                    str2 = vC.cAv.mnd;
                } else {
                    str2 = "";
                }
                C45925c LR2 = favCdnStorage.mo15156LR(str2);
                if (LR2 == null) {
                    c20730b.miy.setVisibility(8);
                    if (vC.mij == null || vC.mij.field_id >= 0) {
                        c20730b.progressBar.setVisibility(8);
                        c20730b.mix.setVisibility(8);
                        c20730b.miw.setVisibility(8);
                        c20730b.miu.setVisibility(0);
                        if (vC.cAv.whh != 0) {
                            c20730b.miy.setVisibility(0);
                        }
                        m31975b(c20730b, m31973a(vC), "");
                    } else {
                        c20730b.progressBar.setVisibility(0);
                        c20730b.mix.setVisibility(0);
                        c20730b.miw.setVisibility(0);
                        c20730b.miu.setVisibility(8);
                        c20730b.miw.setImageBitmap(m31973a(vC));
                        c20730b.progressBar.setProgress(0);
                        c20730b.mix.setText("0%");
                    }
                    AppMethodBeat.m2505o(74523);
                    return view;
                }
                C4990ab.m7417i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", Integer.valueOf(LR2.field_status));
                c20730b.progressBar.setVisibility(0);
                c20730b.mix.setVisibility(0);
                c20730b.miw.setVisibility(0);
                c20730b.miu.setVisibility(8);
                c20730b.miw.setImageBitmap(m31973a(vC));
                int i2 = LR2.field_totalLen > 0 ? ((LR2.field_offset * 100) / LR2.field_totalLen) - 1 : 0;
                if (i2 < 0) {
                    i2 = 0;
                }
                c20730b.progressBar.setProgress(i2);
                c20730b.mix.setText(i2 + "%");
                AppMethodBeat.m2505o(74523);
                return view;
            }
            FavMediaGalleryUI.this.enableOptionMenu(true);
            if (C5063r.amo(C39037b.m66370b(vC.cAv))) {
                m31974a(c20730b, a, C39037b.m66370b(vC.cAv));
            } else {
                m31974a(c20730b, a, "");
            }
            AppMethodBeat.m2505o(74523);
            return view;
        }

        /* renamed from: a */
        private void m31974a(C20730b c20730b, Bitmap bitmap, String str) {
            AppMethodBeat.m2504i(74524);
            c20730b.progressBar.setVisibility(8);
            c20730b.mix.setVisibility(8);
            c20730b.miw.setVisibility(8);
            c20730b.miu.setVisibility(0);
            c20730b.miy.setVisibility(8);
            m31975b(c20730b, bitmap, str);
            AppMethodBeat.m2505o(74524);
        }

        /* renamed from: a */
        private Bitmap m31973a(C3104f c3104f) {
            Bitmap a;
            AppMethodBeat.m2504i(74525);
            if (c3104f != null) {
                a = C45939l.m85275a(c3104f.cAv, c3104f.mij);
                if (a != null) {
                    AppMethodBeat.m2505o(74525);
                    return a;
                }
            }
            a = C1434a.decodeResource(FavMediaGalleryUI.this.getResources(), C1318a.download_image_icon);
            AppMethodBeat.m2505o(74525);
            return a;
        }

        /* renamed from: b */
        private void m31975b(C20730b c20730b, Bitmap bitmap, String str) {
            AppMethodBeat.m2504i(74526);
            C46616n.m88171w(c20730b.miv, bitmap.getWidth(), bitmap.getHeight());
            int width = c20730b.miv.getWidth();
            int height = c20730b.miv.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            C4990ab.m7418v("MicroMsg.FavMediaGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                height2 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                width2 = ((float) width) / ((float) bitmap.getWidth());
                height2 = ((float) height) / ((float) bitmap.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) bitmap.getWidth()) / ((float) width);
                float height3 = ((float) bitmap.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) bitmap.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) bitmap.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - bitmap.getHeight()) / 2);
                    C4990ab.m7410d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(width2)));
                    matrix.postTranslate(0.0f, width2);
                }
            }
            c20730b.miv.setImageMatrix(matrix);
            c20730b.miv.mo71980bW(bitmap.getWidth(), bitmap.getHeight());
            c20730b.miv.setMaxZoomDoubleTab(true);
            if (C5046bo.isNullOrNil(str)) {
                c20730b.miv.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(74526);
                return;
            }
            try {
                C3266d c3266d = new C3266d(str);
                c20730b.miv.setGifDrawable(c3266d);
                c20730b.miv.mo71988hk(C1338a.m2868gd(FavMediaGalleryUI.this.mController.ylL), C1338a.m2869ge(FavMediaGalleryUI.this.mController.ylL));
                c20730b.miv.mo71980bW(c3266d.getIntrinsicWidth(), c3266d.getIntrinsicHeight());
                c20730b.miv.start();
                c20730b.miv.dAp();
                AppMethodBeat.m2505o(74526);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FavMediaGalleryUI", C5046bo.m7574l(e));
                c20730b.miv.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(74526);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$1 */
    class C207391 implements C30745f {
        C207391() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(74507);
            FavMediaGalleryUI.this.finish();
            AppMethodBeat.m2505o(74507);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI$8 */
    class C207408 implements C5279d {
        C207408() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(74515);
            C3104f vC = FavMediaGalleryUI.this.mnE.mo36041vC(FavMediaGalleryUI.this.mik);
            if (vC == null) {
                AppMethodBeat.m2505o(74515);
                return;
            }
            String b = C39037b.m66370b(vC.cAv);
            if (C1173e.m2561ct(b) || menuItem.getItemId() == 4) {
                switch (menuItem.getItemId()) {
                    case 0:
                        C27968h.m44531j(FavMediaGalleryUI.this.mio, 1, 0);
                        if (vC.cAv.dataType != 2) {
                            b = C39037b.m66379c(vC.cAv);
                            String b2 = C39037b.m66370b(vC.cAv);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (C1173e.m2561ct(b)) {
                                intent.putExtra("image_path", b);
                            } else {
                                intent.putExtra("image_path", b2);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            C25985d.m41466b(FavMediaGalleryUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                            AppMethodBeat.m2505o(74515);
                            return;
                        } else if (C5063r.amo(b)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Conv_Type", 3);
                            intent2.putExtra("select_is_ret", true);
                            C25985d.m41466b(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", intent2, 1);
                            AppMethodBeat.m2505o(74515);
                            return;
                        } else {
                            C39037b.m66381c(b, FavMediaGalleryUI.this);
                            AppMethodBeat.m2505o(74515);
                            return;
                        }
                    case 1:
                        C39037b.m66385d(b, FavMediaGalleryUI.this);
                        C27968h.m44531j(FavMediaGalleryUI.this.mio, 0, 0);
                        AppMethodBeat.m2505o(74515);
                        return;
                    case 2:
                        if (vC.cAv.dataType == 2) {
                            FavMediaGalleryUI.m31959a(FavMediaGalleryUI.this, b);
                            AppMethodBeat.m2505o(74515);
                            return;
                        }
                        FavMediaGalleryUI.m31961b(FavMediaGalleryUI.this, b);
                        AppMethodBeat.m2505o(74515);
                        return;
                    case 3:
                        C18346nr c18346nr = (C18346nr) FavMediaGalleryUI.this.mim.get(b);
                        if (c18346nr != null) {
                            C26102cf c26102cf = new C26102cf();
                            c26102cf.cvm.activity = FavMediaGalleryUI.this;
                            c26102cf.cvm.ctB = c18346nr.cJX.result;
                            c26102cf.cvm.cvn = c18346nr.cJX.cvn;
                            c26102cf.cvm.cvp = 7;
                            if (!(vC == null || vC.cAv == null)) {
                                c26102cf.cvm.imagePath = vC.cAv.wfZ;
                                c26102cf.cvm.cvr = vC.cAv.wgb;
                            }
                            c26102cf.cvm.cvo = c18346nr.cJX.cvo;
                            Bundle bundle = new Bundle(1);
                            bundle.putInt("stat_scene", 5);
                            c26102cf.cvm.cvs = bundle;
                            C4879a.xxA.mo10055m(c26102cf);
                            AppMethodBeat.m2505o(74515);
                            return;
                        }
                        break;
                    case 4:
                        FavMediaGalleryUI.this.mnG.index = FavMediaGalleryUI.this.mnE.getCount() - FavMediaGalleryUI.this.mik;
                        ((C20679y) C1720g.m3528K(C20679y.class)).mo35978a(FavMediaGalleryUI.this.mController.ylL, vC.mij, FavMediaGalleryUI.this.mnG);
                        FavMediaGalleryUI.this.finish();
                        break;
                }
                AppMethodBeat.m2505o(74515);
                return;
            }
            C4990ab.m7420w("MicroMsg.FavMediaGalleryUI", "file not exists");
            AppMethodBeat.m2505o(74515);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavMediaGalleryUI() {
        AppMethodBeat.m2504i(74528);
        AppMethodBeat.m2505o(74528);
    }

    public final int getLayoutId() {
        return 2130969504;
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(74529);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kkn.setOnItemSelectedListener(this);
        this.kkn.setSingleClickOverListener(new C207391());
        if (this.cHc) {
            this.kkn.setLongClickOverListener(new C207334());
        }
        fullScreenNoTitleBar(true);
        this.iLD = new ArrayList();
        this.mnE = new C20736a(this, (byte) 0);
        this.kkn.setAdapter(this.mnE);
        m31956Km();
        setBackBtn(new C207345());
        C4879a.xxA.mo10052c(this.mip);
        setResult(0, getIntent());
        this.mnG.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
        this.mnG.jSW = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
        this.mnG.index = getIntent().getIntExtra("key_detail_fav_index", 0);
        this.mnG.query = getIntent().getStringExtra("key_detail_fav_query");
        this.mnG.cvF = getIntent().getStringExtra("key_detail_fav_sessionid");
        this.mnG.mfg = getIntent().getStringExtra("key_detail_fav_tags");
        this.mnG.query = this.mnG.query == null ? "" : this.mnG.query;
        this.mnG.cvF = this.mnG.cvF == null ? "" : this.mnG.cvF;
        abh abh = this.mnG;
        if (this.mnG.mfg == null) {
            str = "";
        } else {
            str = this.mnG.mfg;
        }
        abh.mfg = str;
        AppMethodBeat.m2505o(74529);
    }

    /* renamed from: Km */
    private void m31956Km() {
        C27966g c27966g;
        int size;
        int i;
        AppMethodBeat.m2504i(74530);
        long[] longArrayExtra = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
        ArrayList arrayList = new ArrayList();
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        this.mio = getIntent().getLongExtra("key_detail_info_id", -1);
        if (longArrayExtra == null) {
            Object c27966g2;
            boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
            String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
            C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mio);
            String str = "MicroMsg.FavMediaGalleryUI";
            String str2 = "show one fav info, local id is %d, get from db ok ? %B";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.mio);
            objArr[1] = Boolean.valueOf(iE != null);
            C4990ab.m7417i(str, str2, objArr);
            if (!booleanExtra || C5046bo.isNullOrNil(stringExtra2)) {
                c27966g2 = iE;
            } else {
                c27966g2 = C39037b.m66341LF(stringExtra2);
            }
            if (c27966g2 != null) {
                arrayList.add(c27966g2);
            }
        } else {
            for (long iE2 : longArrayExtra) {
                c27966g2 = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(iE2);
                if (!(c27966g2 == null || arrayList.contains(c27966g2))) {
                    arrayList.add(c27966g2);
                }
            }
        }
        this.iLD.clear();
        int i2 = -1;
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            c27966g2 = (C27966g) arrayList.get(i3);
            int size3 = c27966g2.field_favProto.wiv.size();
            i = 0;
            while (i < size3) {
                aar aar = (aar) c27966g2.field_favProto.wiv.get(i);
                if ((aar.dataType != 8 || C5063r.amo(C39037b.m66370b(aar))) && (aar.dataType == 2 || aar.dataType == 4 || aar.dataType == 15 || aar.dataType == 8)) {
                    this.iLD.add(new C3104f(c27966g2, aar));
                    if (stringExtra != null && stringExtra.equals(aar.mnd) && c27966g2.field_localId == this.mio) {
                        size = this.iLD.size() - 1;
                        i++;
                        i2 = size;
                    }
                }
                size = i2;
                i++;
                i2 = size;
            }
            if (stringExtra == null && c27966g2.field_localId == this.mio) {
                i2 = this.iLD.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mnE.notifyDataSetChanged();
        this.kkn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74516);
                if (i2 != -1) {
                    C4990ab.m7411d("MicroMsg.FavMediaGalleryUI", "match selection %d", Integer.valueOf(i2));
                    FavMediaGalleryUI.this.kkn.setSelection(i2);
                    FavMediaGalleryUI.this.mik = i2;
                    AppMethodBeat.m2505o(74516);
                } else if (FavMediaGalleryUI.this.mik - 1 >= 0 && FavMediaGalleryUI.this.mik - 1 < FavMediaGalleryUI.this.iLD.size()) {
                    C4990ab.m7411d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavMediaGalleryUI.this.mik - 1), Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.kkn.setSelection(FavMediaGalleryUI.this.mik - 1);
                    FavMediaGalleryUI.this.mik = FavMediaGalleryUI.this.mik - 1;
                    AppMethodBeat.m2505o(74516);
                } else if (FavMediaGalleryUI.this.iLD.size() > 0) {
                    C4990ab.m7411d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.kkn.setSelection(0);
                    FavMediaGalleryUI.this.mik = 0;
                    AppMethodBeat.m2505o(74516);
                } else {
                    C4990ab.m7421w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.finish();
                    AppMethodBeat.m2505o(74516);
                }
            }
        });
        AppMethodBeat.m2505o(74530);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74531);
        getIntent().putExtra("key_activity_browse_time", dyi());
        C4879a.xxA.mo10053d(this.mip);
        for (FavVideoView favVideoView : this.mnF) {
            if (favVideoView != null) {
                favVideoView.onDestroy();
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(74531);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74532);
        super.onResume();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this);
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(74532);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74533);
        super.onPause();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this);
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(74533);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(74534);
        this.mik = i;
        C4990ab.m7410d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(i)));
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).dzA();
        }
        if (this.mnD != null) {
            this.mnD.onDestroy();
        }
        if (view instanceof FavVideoView) {
            FavVideoView favVideoView = (FavVideoView) view;
            if ((this.mnE.getItemViewType(i) == 15 || this.mnE.getItemViewType(i) == 4) && favVideoView != null) {
                boolean z;
                if (favVideoView.klq == null) {
                    z = false;
                } else {
                    z = favVideoView.klq.isPlaying();
                }
                if (!z) {
                    favVideoView.onResume();
                    this.mnD = favVideoView;
                    this.mnC = i;
                }
            }
        }
        AppMethodBeat.m2505o(74534);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* renamed from: d */
    public final void mo23673d(final C45925c c45925c) {
        AppMethodBeat.m2504i(74535);
        if (c45925c != null) {
            C3104f vC = this.mnE.mo36041vC(this.mik);
            if (vC != null && C5046bo.m7532bc(c45925c.field_dataId, "").equals(vC.cAv.mnd) && vC.cAv.dataType == 2) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.m2504i(74517);
                        View selectedView = FavMediaGalleryUI.this.kkn.getSelectedView();
                        if (selectedView == null) {
                            AppMethodBeat.m2505o(74517);
                        } else if (selectedView.getTag() == null || !(selectedView.getTag() instanceof C20730b)) {
                            AppMethodBeat.m2505o(74517);
                        } else {
                            C20730b c20730b = (C20730b) selectedView.getTag();
                            int i2 = c45925c.field_totalLen > 0 ? ((c45925c.field_offset * 100) / c45925c.field_totalLen) - 1 : 0;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            c20730b.progressBar.setProgress(i);
                            c20730b.mix.setText(i + "%");
                            if (i >= 100 || c45925c.isFinished()) {
                                FavMediaGalleryUI.this.mnE.notifyDataSetChanged();
                            }
                            AppMethodBeat.m2505o(74517);
                        }
                    }
                });
            }
        }
        AppMethodBeat.m2505o(74535);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74536);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.m2505o(74536);
                return;
            }
            C3104f vC = this.mnE.mo36041vC(this.mik);
            if (vC == null) {
                C4990ab.m7416i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
                AppMethodBeat.m2505o(74536);
                return;
            }
            String b = C39037b.m66370b(vC.cAv);
            C41268k c41268k = new C41268k();
            if (C41268k.m71869u(vC.mij)) {
                C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f8634ah));
                AppMethodBeat.m2505o(74536);
                return;
            }
            ArrayList<String> P = C5046bo.m7508P(intent.getStringExtra("Select_Conv_User").split(","));
            C4990ab.m7411d("MicroMsg.FavMediaGalleryUI", "select %s for sending", r2);
            final C44275p b2 = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            if (C5063r.amo(b)) {
                for (String b3 : P) {
                    C11909i.m19788a(this.mController.ylL, b3, vC.mij, vC.cAv, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74518);
                            b2.dismiss();
                            AppMethodBeat.m2505o(74518);
                        }
                    });
                }
            } else {
                C207372 c207372 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74508);
                        b2.dismiss();
                        AppMethodBeat.m2505o(74508);
                    }
                };
                for (String b32 : P) {
                    C11909i.m19790a(this, b32, vC.cAv, c207372);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74536);
    }

    /* renamed from: a */
    static /* synthetic */ void m31958a(FavMediaGalleryUI favMediaGalleryUI) {
        AppMethodBeat.m2504i(74537);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        C3104f vC = favMediaGalleryUI.mnE.mo36041vC(favMediaGalleryUI.mik);
        if (vC == null) {
            AppMethodBeat.m2505o(74537);
            return;
        }
        if (vC.cAv.whh != 0) {
            C4990ab.m7416i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
        } else if (vC.cAv.dataType == 2) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favMediaGalleryUI.getString(C25738R.string.bri));
            }
            if (vC.mij != null && vC.mij.buu()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favMediaGalleryUI.getString(C25738R.string.bq_));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favMediaGalleryUI.getString(C25738R.string.brb));
            String b = C39037b.m66370b(vC.cAv);
            C18346nr c18346nr = (C18346nr) favMediaGalleryUI.mim.get(b);
            if (c18346nr == null) {
                C45347np c45347np = new C45347np();
                c45347np.cJU.filePath = b;
                C4879a.xxA.mo10055m(c45347np);
            } else if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favMediaGalleryUI.getString(C13119a.m21150ba(c18346nr.cJX.cvn, c18346nr.cJX.result) ? C25738R.string.bqh : C25738R.string.bqg));
            }
        } else if (C1173e.m2561ct(C39037b.m66370b(vC.cAv))) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favMediaGalleryUI.getString(C25738R.string.bri));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favMediaGalleryUI.getString(C25738R.string.dx0));
        }
        arrayList.add(Integer.valueOf(4));
        arrayList2.add(favMediaGalleryUI.getString(C25738R.string.bp6));
        if (favMediaGalleryUI.icA == null) {
            favMediaGalleryUI.icA = new C46696j(favMediaGalleryUI.mController.ylL);
        }
        favMediaGalleryUI.icA.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(74513);
                c44273l.setHeaderTitle((CharSequence) "");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        c44273l.mo70068e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(74513);
                        return;
                    }
                }
            }
        };
        favMediaGalleryUI.icA.rBm = favMediaGalleryUI.lcJ;
        favMediaGalleryUI.icA.mo75012e(new C207297());
        C30379h.m48455a(favMediaGalleryUI.mController.ylL, favMediaGalleryUI.icA.cuu());
        AppMethodBeat.m2505o(74537);
    }

    /* renamed from: b */
    static /* synthetic */ void m31961b(FavMediaGalleryUI favMediaGalleryUI, String str) {
        AppMethodBeat.m2504i(74539);
        String uu = C26494u.m42269uu(str);
        C4990ab.m7417i("MicroMsg.FavMediaGalleryUI", "save video now video path %s out path %s", str, uu);
        if (C5046bo.isNullOrNil(uu)) {
            Toast.makeText(favMediaGalleryUI, favMediaGalleryUI.getString(C25738R.string.f1c), 1).show();
            AppMethodBeat.m2505o(74539);
            return;
        }
        Toast.makeText(favMediaGalleryUI, favMediaGalleryUI.getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
        C14987n.m23300a(uu, favMediaGalleryUI);
        AppMethodBeat.m2505o(74539);
    }
}
