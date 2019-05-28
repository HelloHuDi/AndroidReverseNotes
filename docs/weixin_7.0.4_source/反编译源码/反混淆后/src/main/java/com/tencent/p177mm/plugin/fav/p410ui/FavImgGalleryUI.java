package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
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
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
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
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C6894q;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.gif.C3266d;
import com.tencent.p177mm.plugin.scanner.C13119a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C46616n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI */
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, C11855p {
    private boolean cHc = true;
    private ArrayList<C3104f> iLD;
    private C46696j icA;
    private MMGestureGallery kkn;
    private C5279d lcJ = new C206917();
    private int mik = 0;
    private C20692a mil;
    private Map<String, C18346nr> mim = new HashMap();
    private long mio;
    private C4884c mip = new C207012();

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$4 */
    class C206904 implements OnMenuItemClickListener {
        C206904() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74005);
            FavImgGalleryUI.this.finish();
            AppMethodBeat.m2505o(74005);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$7 */
    class C206917 implements C5279d {
        C206917() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(74008);
            C3104f vC = FavImgGalleryUI.this.mil.mo35995vC(FavImgGalleryUI.this.mik);
            if (vC == null) {
                AppMethodBeat.m2505o(74008);
                return;
            }
            String b = C39037b.m66370b(vC.cAv);
            if (C5730e.m8628ct(b)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        C27968h.m44531j(FavImgGalleryUI.this.mio, 1, 0);
                        if (C5063r.amo(b)) {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            C25985d.m41466b(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                            AppMethodBeat.m2505o(74008);
                            return;
                        }
                        C39037b.m66381c(b, FavImgGalleryUI.this);
                        AppMethodBeat.m2505o(74008);
                        return;
                    case 1:
                        C39037b.m66385d(b, FavImgGalleryUI.this);
                        C27968h.m44531j(FavImgGalleryUI.this.mio, 0, 0);
                        AppMethodBeat.m2505o(74008);
                        return;
                    case 2:
                        FavImgGalleryUI.m31938a(b, FavImgGalleryUI.this.getString(C25738R.string.bra), FavImgGalleryUI.this);
                        AppMethodBeat.m2505o(74008);
                        return;
                    case 3:
                        C18346nr c18346nr = (C18346nr) FavImgGalleryUI.this.mim.get(b);
                        if (c18346nr != null) {
                            C26102cf c26102cf = new C26102cf();
                            c26102cf.cvm.activity = FavImgGalleryUI.this;
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
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(74008);
                return;
            }
            C4990ab.m7420w("MicroMsg.FavImgGalleryUI", "file not exists");
            AppMethodBeat.m2505o(74008);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$a */
    class C20692a extends BaseAdapter {
        SparseBooleanArray mit;

        private C20692a() {
            AppMethodBeat.m2504i(74012);
            this.mit = new SparseBooleanArray();
            AppMethodBeat.m2505o(74012);
        }

        /* synthetic */ C20692a(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(74019);
            C3104f vC = mo35995vC(i);
            AppMethodBeat.m2505o(74019);
            return vC;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(74013);
            int size = FavImgGalleryUI.this.iLD.size();
            AppMethodBeat.m2505o(74013);
            return size;
        }

        /* renamed from: vC */
        public final C3104f mo35995vC(int i) {
            AppMethodBeat.m2504i(74014);
            if (i >= FavImgGalleryUI.this.iLD.size()) {
                C4990ab.m7421w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", Integer.valueOf(i));
                AppMethodBeat.m2505o(74014);
                return null;
            }
            C3104f c3104f = (C3104f) FavImgGalleryUI.this.iLD.get(i);
            AppMethodBeat.m2505o(74014);
            return c3104f;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C20693b c20693b;
            AppMethodBeat.m2504i(74015);
            if (view == null) {
                c20693b = new C20693b(FavImgGalleryUI.this, (byte) 0);
                view = View.inflate(FavImgGalleryUI.this.mController.ylL, 2130969503, null);
                c20693b.miu = view.findViewById(2131820630);
                c20693b.miv = (MultiTouchImageView) view.findViewById(2131820629);
                c20693b.progressBar = (ProgressBar) view.findViewById(2131822617);
                c20693b.miw = (ImageView) view.findViewById(2131821511);
                c20693b.mix = (TextView) view.findViewById(2131823911);
                c20693b.miy = (LinearLayout) view.findViewById(2131823884);
                c20693b.miz = (TextView) view.findViewById(2131823885);
                c20693b.miz.setText(C25738R.string.bnw);
                view.setTag(c20693b);
            } else {
                c20693b = (C20693b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            C3104f vC = mo35995vC(i);
            boolean z = this.mit.get(i, true);
            this.mit.put(i, false);
            Bitmap a = C45939l.m85276a(vC.cAv, vC.mij, z);
            if (vC.mij != null) {
                C4990ab.m7417i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i), Integer.valueOf(vC.mij.field_id), Long.valueOf(vC.mij.field_localId), Integer.valueOf(vC.mij.field_itemStatus));
            }
            if (vC.cAv != null) {
                C4990ab.m7417i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", vC.cAv.mnd, vC.cAv.wfZ, vC.cAv.wgb, Long.valueOf(vC.cAv.wgu), vC.cAv.fgE, vC.cAv.wfV, Long.valueOf(vC.cAv.wgF));
            }
            if (a == null) {
                String str;
                FavImgGalleryUI.this.enableOptionMenu(false);
                C4990ab.m7420w("MicroMsg.FavImgGalleryUI", "get big image fail");
                C6894q favCdnStorage = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage();
                if (vC.cAv != null) {
                    str = vC.cAv.mnd;
                } else {
                    str = "";
                }
                C45925c LR = favCdnStorage.mo15156LR(str);
                if (LR == null) {
                    c20693b.miy.setVisibility(8);
                    if (vC.mij == null || vC.mij.field_id >= 0) {
                        c20693b.progressBar.setVisibility(8);
                        c20693b.mix.setVisibility(8);
                        c20693b.miw.setVisibility(8);
                        c20693b.miu.setVisibility(0);
                        if (vC.cAv.whh != 0) {
                            c20693b.miy.setVisibility(0);
                        }
                        m31933b(c20693b, m31931a(vC), "");
                    } else {
                        c20693b.progressBar.setVisibility(0);
                        c20693b.mix.setVisibility(0);
                        c20693b.miw.setVisibility(0);
                        c20693b.miu.setVisibility(8);
                        c20693b.miw.setImageBitmap(m31931a(vC));
                        c20693b.progressBar.setProgress(0);
                        c20693b.mix.setText("0%");
                    }
                    AppMethodBeat.m2505o(74015);
                } else {
                    C4990ab.m7417i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", Integer.valueOf(LR.field_status));
                    c20693b.progressBar.setVisibility(0);
                    c20693b.mix.setVisibility(0);
                    c20693b.miw.setVisibility(0);
                    c20693b.miu.setVisibility(8);
                    c20693b.miw.setImageBitmap(m31931a(vC));
                    int i2 = LR.field_totalLen > 0 ? ((LR.field_offset * 100) / LR.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    c20693b.progressBar.setProgress(i2);
                    c20693b.mix.setText(i2 + "%");
                    AppMethodBeat.m2505o(74015);
                }
            } else {
                FavImgGalleryUI.this.enableOptionMenu(true);
                if (C5063r.amo(C39037b.m66370b(vC.cAv))) {
                    m31932a(c20693b, a, C39037b.m66370b(vC.cAv));
                } else {
                    m31932a(c20693b, a, "");
                }
                AppMethodBeat.m2505o(74015);
            }
            return view;
        }

        /* renamed from: a */
        private void m31932a(C20693b c20693b, Bitmap bitmap, String str) {
            AppMethodBeat.m2504i(74016);
            c20693b.progressBar.setVisibility(8);
            c20693b.mix.setVisibility(8);
            c20693b.miw.setVisibility(8);
            c20693b.miu.setVisibility(0);
            c20693b.miy.setVisibility(8);
            m31933b(c20693b, bitmap, str);
            AppMethodBeat.m2505o(74016);
        }

        /* renamed from: a */
        private Bitmap m31931a(C3104f c3104f) {
            Bitmap a;
            AppMethodBeat.m2504i(74017);
            if (c3104f != null) {
                a = C45939l.m85275a(c3104f.cAv, c3104f.mij);
                if (a != null) {
                    AppMethodBeat.m2505o(74017);
                    return a;
                }
            }
            a = C1434a.decodeResource(FavImgGalleryUI.this.getResources(), C1318a.download_image_icon);
            AppMethodBeat.m2505o(74017);
            return a;
        }

        /* renamed from: b */
        private void m31933b(C20693b c20693b, Bitmap bitmap, String str) {
            AppMethodBeat.m2504i(74018);
            C46616n.m88171w(c20693b.miv, bitmap.getWidth(), bitmap.getHeight());
            int width = c20693b.miv.getWidth();
            int height = c20693b.miv.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            C4990ab.m7418v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
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
                    C4990ab.m7410d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(width2)));
                    matrix.postTranslate(0.0f, width2);
                }
            }
            c20693b.miv.setImageMatrix(matrix);
            c20693b.miv.mo71980bW(bitmap.getWidth(), bitmap.getHeight());
            c20693b.miv.setMaxZoomDoubleTab(true);
            if (C5046bo.isNullOrNil(str)) {
                c20693b.miv.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(74018);
                return;
            }
            try {
                C3266d c3266d = new C3266d(str);
                c20693b.miv.setGifDrawable(c3266d);
                c20693b.miv.mo71988hk(C1338a.m2868gd(FavImgGalleryUI.this.mController.ylL), C1338a.m2869ge(FavImgGalleryUI.this.mController.ylL));
                c20693b.miv.mo71980bW(c3266d.getIntrinsicWidth(), c3266d.getIntrinsicHeight());
                c20693b.miv.start();
                c20693b.miv.dAp();
                AppMethodBeat.m2505o(74018);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.FavImgGalleryUI", C5046bo.m7574l(e));
                c20693b.miv.setImageBitmap(bitmap);
                AppMethodBeat.m2505o(74018);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$b */
    class C20693b {
        View miu;
        MultiTouchImageView miv;
        ImageView miw;
        TextView mix;
        LinearLayout miy;
        TextView miz;
        ProgressBar progressBar;

        private C20693b() {
        }

        /* synthetic */ C20693b(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$6 */
    class C206956 implements OnCancelListener {
        C206956() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(74007);
            FavImgGalleryUI.this.icA = null;
            AppMethodBeat.m2505o(74007);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$1 */
    class C206961 implements C30745f {
        C206961() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(74001);
            FavImgGalleryUI.this.finish();
            AppMethodBeat.m2505o(74001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$3 */
    class C206973 implements C30744c {
        C206973() {
        }

        public final void bvE() {
            AppMethodBeat.m2504i(74004);
            if (!(FavImgGalleryUI.this.isFinishing() || FavImgGalleryUI.this.uiu)) {
                C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
                y.mo53356j("key_basescanui_screen_x", Integer.valueOf(FavImgGalleryUI.this.kkn.getXDown()));
                y.mo53356j("key_basescanui_screen_y", Integer.valueOf(FavImgGalleryUI.this.kkn.getYDown()));
                FavImgGalleryUI.m31939b(FavImgGalleryUI.this);
            }
            AppMethodBeat.m2505o(74004);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavImgGalleryUI$2 */
    class C207012 extends C4884c<C18346nr> {
        C207012() {
            AppMethodBeat.m2504i(74002);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(74002);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(74003);
            C18346nr c18346nr = (C18346nr) c4883b;
            FavImgGalleryUI.this.mim.put(c18346nr.cJX.filePath, c18346nr);
            if (FavImgGalleryUI.this.icA != null && FavImgGalleryUI.this.icA.rBk.isShowing()) {
                FavImgGalleryUI.m31939b(FavImgGalleryUI.this);
            }
            AppMethodBeat.m2505o(74003);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavImgGalleryUI() {
        AppMethodBeat.m2504i(74020);
        AppMethodBeat.m2505o(74020);
    }

    public final int getLayoutId() {
        return 2130969504;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74021);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kkn.setOnItemSelectedListener(this);
        this.kkn.setSingleClickOverListener(new C206961());
        if (this.cHc) {
            this.kkn.setLongClickOverListener(new C206973());
        }
        fullScreenNoTitleBar(true);
        this.iLD = new ArrayList();
        this.mil = new C20692a(this, (byte) 0);
        this.kkn.setAdapter(this.mil);
        m31935Km();
        setBackBtn(new C206904());
        C4879a.xxA.mo10052c(this.mip);
        setResult(0, getIntent());
        AppMethodBeat.m2505o(74021);
    }

    /* renamed from: a */
    public static void m31938a(String str, String str2, Context context) {
        AppMethodBeat.m2504i(74022);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
            AppMethodBeat.m2505o(74022);
            return;
        }
        if (!C45477q.m83806a(str, context, C25738R.string.b3r)) {
            Toast.makeText(context, str2, 1).show();
        }
        AppMethodBeat.m2505o(74022);
    }

    /* renamed from: Km */
    private void m31935Km() {
        C27966g c27966g;
        Object c27966g2;
        AppMethodBeat.m2504i(74023);
        this.mio = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        ArrayList arrayList = new ArrayList();
        C27966g iE = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(this.mio);
        String str = "MicroMsg.FavImgGalleryUI";
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
        this.iLD.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            c27966g2 = (C27966g) arrayList.get(i2);
            int size2 = c27966g2.field_favProto.wiv.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                aar aar = (aar) c27966g2.field_favProto.wiv.get(i3);
                if ((aar.dataType != 8 || C5063r.amo(C39037b.m66370b(aar))) && (aar.dataType == 2 || aar.dataType == 8)) {
                    this.iLD.add(new C3104f(c27966g2, aar));
                    if (stringExtra != null && stringExtra.equals(aar.mnd)) {
                        size3 = this.iLD.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && c27966g2.field_localId == this.mio) {
                i = this.iLD.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mil.notifyDataSetChanged();
        this.kkn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74009);
                if (i != -1) {
                    C4990ab.m7411d("MicroMsg.FavImgGalleryUI", "match selection %d", Integer.valueOf(i));
                    FavImgGalleryUI.this.kkn.setSelection(i);
                    FavImgGalleryUI.this.mik = i;
                    AppMethodBeat.m2505o(74009);
                } else if (FavImgGalleryUI.this.mik - 1 >= 0 && FavImgGalleryUI.this.mik - 1 < FavImgGalleryUI.this.iLD.size()) {
                    C4990ab.m7411d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavImgGalleryUI.this.mik - 1), Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.kkn.setSelection(FavImgGalleryUI.this.mik - 1);
                    FavImgGalleryUI.this.mik = FavImgGalleryUI.this.mik - 1;
                    AppMethodBeat.m2505o(74009);
                } else if (FavImgGalleryUI.this.iLD.size() > 0) {
                    C4990ab.m7411d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.kkn.setSelection(0);
                    FavImgGalleryUI.this.mik = 0;
                    AppMethodBeat.m2505o(74009);
                } else {
                    C4990ab.m7421w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.finish();
                    AppMethodBeat.m2505o(74009);
                }
            }
        });
        AppMethodBeat.m2505o(74023);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74024);
        getIntent().putExtra("key_activity_browse_time", dyi());
        C4879a.xxA.mo10053d(this.mip);
        super.onDestroy();
        AppMethodBeat.m2505o(74024);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74025);
        super.onResume();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this);
        C29970o.m47417JV(1);
        AppMethodBeat.m2505o(74025);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74026);
        super.onPause();
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this);
        C29970o.m47417JV(2);
        AppMethodBeat.m2505o(74026);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(74027);
        this.mik = i;
        C4990ab.m7410d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(i)));
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).dzA();
        }
        AppMethodBeat.m2505o(74027);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* renamed from: d */
    public final void mo23673d(final C45925c c45925c) {
        AppMethodBeat.m2504i(74028);
        if (c45925c != null) {
            C4990ab.m7419v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", Integer.valueOf(c45925c.field_status));
            C3104f vC = this.mil.mo35995vC(this.mik);
            if (vC != null && C5046bo.m7532bc(c45925c.field_dataId, "").equals(vC.cAv.mnd)) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.m2504i(74010);
                        View selectedView = FavImgGalleryUI.this.kkn.getSelectedView();
                        if (selectedView == null) {
                            AppMethodBeat.m2505o(74010);
                            return;
                        }
                        C20693b c20693b = (C20693b) selectedView.getTag();
                        int i2 = c45925c.field_totalLen > 0 ? ((c45925c.field_offset * 100) / c45925c.field_totalLen) - 1 : 0;
                        if (i2 >= 0) {
                            i = i2;
                        }
                        c20693b.progressBar.setProgress(i);
                        c20693b.mix.setText(i + "%");
                        if (i >= 100 || c45925c.isFinished()) {
                            FavImgGalleryUI.this.mil.notifyDataSetChanged();
                        }
                        AppMethodBeat.m2505o(74010);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(74028);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74029);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.m2505o(74029);
                return;
            }
            C3104f vC = this.mil.mo35995vC(this.mik);
            if (vC == null) {
                C4990ab.m7416i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                AppMethodBeat.m2505o(74029);
                return;
            }
            C41268k c41268k = new C41268k();
            if (C41268k.m71869u(vC.mij)) {
                C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f8634ah));
                AppMethodBeat.m2505o(74029);
                return;
            }
            C4990ab.m7411d("MicroMsg.FavImgGalleryUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C11909i.m19788a(this.mController.ylL, r1, vC.mij, vC.cAv, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74011);
                    b.dismiss();
                    C5670b.m8523i(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(C25738R.string.bnf));
                    AppMethodBeat.m2505o(74011);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74029);
    }

    /* renamed from: b */
    static /* synthetic */ void m31939b(FavImgGalleryUI favImgGalleryUI) {
        AppMethodBeat.m2504i(74030);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        C3104f vC = favImgGalleryUI.mil.mo35995vC(favImgGalleryUI.mik);
        if (vC == null) {
            AppMethodBeat.m2505o(74030);
            return;
        }
        if (vC.cAv.whh == 0) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(C25738R.string.bri));
            }
            if (vC.mij != null && vC.mij.buu()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(C25738R.string.bq_));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(C25738R.string.brb));
            String b = C39037b.m66370b(vC.cAv);
            C18346nr c18346nr = (C18346nr) favImgGalleryUI.mim.get(b);
            if (c18346nr == null) {
                C45347np c45347np = new C45347np();
                c45347np.cJU.filePath = b;
                C4879a.xxA.mo10055m(c45347np);
            } else if (!C5046bo.isNullOrNil(c18346nr.cJX.result)) {
                arrayList.add(Integer.valueOf(3));
                if (C13119a.m21149BR(c18346nr.cJX.cvn)) {
                    arrayList2.add(favImgGalleryUI.getString(C25738R.string.bqg));
                } else if (C13119a.m21150ba(c18346nr.cJX.cvn, c18346nr.cJX.result)) {
                    arrayList2.add(favImgGalleryUI.getString(C25738R.string.bqh));
                } else if (C13119a.m21148BQ(c18346nr.cJX.cvn)) {
                    arrayList2.add(favImgGalleryUI.getString(C25738R.string.bqf));
                } else {
                    arrayList2.add(favImgGalleryUI.getString(C25738R.string.bqg));
                }
            }
            if (favImgGalleryUI.icA == null) {
                favImgGalleryUI.icA = new C46696j(favImgGalleryUI.mController.ylL);
            }
            favImgGalleryUI.icA.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(74006);
                    c44273l.setHeaderTitle((CharSequence) "");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            c44273l.mo70068e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(74006);
                            return;
                        }
                    }
                }
            };
            favImgGalleryUI.icA.rBm = favImgGalleryUI.lcJ;
            favImgGalleryUI.icA.mo75012e(new C206956());
            C30379h.m48455a(favImgGalleryUI.mController.ylL, favImgGalleryUI.icA.cuu());
        }
        AppMethodBeat.m2505o(74030);
    }
}
