package com.tencent.mm.plugin.fav.ui.gallery;

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
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.f;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavMediaGalleryUI extends MMActivity implements OnItemSelectedListener, p {
    private boolean cHc = true;
    private ArrayList<f> iLD;
    private j icA;
    private MMGestureGallery kkn;
    private d lcJ = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(74515);
            f vC = FavMediaGalleryUI.this.mnE.vC(FavMediaGalleryUI.this.mik);
            if (vC == null) {
                AppMethodBeat.o(74515);
                return;
            }
            String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
            if (e.ct(b) || menuItem.getItemId() == 4) {
                switch (menuItem.getItemId()) {
                    case 0:
                        h.j(FavMediaGalleryUI.this.mio, 1, 0);
                        if (vC.cAv.dataType != 2) {
                            b = com.tencent.mm.plugin.fav.a.b.c(vC.cAv);
                            String b2 = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (e.ct(b)) {
                                intent.putExtra("image_path", b);
                            } else {
                                intent.putExtra("image_path", b2);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            com.tencent.mm.bp.d.b(FavMediaGalleryUI.this.mController.ylL, ".ui.transmit.SelectConversationUI", intent, 1);
                            AppMethodBeat.o(74515);
                            return;
                        } else if (r.amo(b)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Conv_Type", 3);
                            intent2.putExtra("select_is_ret", true);
                            com.tencent.mm.bp.d.b(FavMediaGalleryUI.this, ".ui.transmit.SelectConversationUI", intent2, 1);
                            AppMethodBeat.o(74515);
                            return;
                        } else {
                            com.tencent.mm.plugin.fav.a.b.c(b, FavMediaGalleryUI.this);
                            AppMethodBeat.o(74515);
                            return;
                        }
                    case 1:
                        com.tencent.mm.plugin.fav.a.b.d(b, FavMediaGalleryUI.this);
                        h.j(FavMediaGalleryUI.this.mio, 0, 0);
                        AppMethodBeat.o(74515);
                        return;
                    case 2:
                        if (vC.cAv.dataType == 2) {
                            FavMediaGalleryUI.a(FavMediaGalleryUI.this, b);
                            AppMethodBeat.o(74515);
                            return;
                        }
                        FavMediaGalleryUI.b(FavMediaGalleryUI.this, b);
                        AppMethodBeat.o(74515);
                        return;
                    case 3:
                        nr nrVar = (nr) FavMediaGalleryUI.this.mim.get(b);
                        if (nrVar != null) {
                            cf cfVar = new cf();
                            cfVar.cvm.activity = FavMediaGalleryUI.this;
                            cfVar.cvm.ctB = nrVar.cJX.result;
                            cfVar.cvm.cvn = nrVar.cJX.cvn;
                            cfVar.cvm.cvp = 7;
                            if (!(vC == null || vC.cAv == null)) {
                                cfVar.cvm.imagePath = vC.cAv.wfZ;
                                cfVar.cvm.cvr = vC.cAv.wgb;
                            }
                            cfVar.cvm.cvo = nrVar.cJX.cvo;
                            Bundle bundle = new Bundle(1);
                            bundle.putInt("stat_scene", 5);
                            cfVar.cvm.cvs = bundle;
                            com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                            AppMethodBeat.o(74515);
                            return;
                        }
                        break;
                    case 4:
                        FavMediaGalleryUI.this.mnG.index = FavMediaGalleryUI.this.mnE.getCount() - FavMediaGalleryUI.this.mik;
                        ((y) g.K(y.class)).a(FavMediaGalleryUI.this.mController.ylL, vC.mij, FavMediaGalleryUI.this.mnG);
                        FavMediaGalleryUI.this.finish();
                        break;
                }
                AppMethodBeat.o(74515);
                return;
            }
            ab.w("MicroMsg.FavMediaGalleryUI", "file not exists");
            AppMethodBeat.o(74515);
        }
    };
    private int mik = 0;
    private Map<String, nr> mim = new HashMap();
    private long mio;
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(74509);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(74509);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(74510);
            nr nrVar = (nr) bVar;
            FavMediaGalleryUI.this.mim.put(nrVar.cJX.filePath, nrVar);
            if (FavMediaGalleryUI.this.icA != null && FavMediaGalleryUI.this.icA.rBk.isShowing()) {
                FavMediaGalleryUI.a(FavMediaGalleryUI.this);
            }
            AppMethodBeat.o(74510);
            return true;
        }
    };
    private int mnC = -1;
    private FavVideoView mnD = null;
    private a mnE;
    private List<FavVideoView> mnF = new ArrayList();
    abh mnG = new abh();

    class b {
        View miu;
        MultiTouchImageView miv;
        ImageView miw;
        TextView mix;
        LinearLayout miy;
        TextView miz;
        ProgressBar progressBar;

        private b() {
        }

        /* synthetic */ b(FavMediaGalleryUI favMediaGalleryUI, byte b) {
            this();
        }
    }

    class a extends BaseAdapter {
        SparseBooleanArray mit;

        private a() {
            AppMethodBeat.i(74519);
            this.mit = new SparseBooleanArray();
            AppMethodBeat.o(74519);
        }

        /* synthetic */ a(FavMediaGalleryUI favMediaGalleryUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(74527);
            f vC = vC(i);
            AppMethodBeat.o(74527);
            return vC;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(74520);
            if (i > FavMediaGalleryUI.this.iLD.size()) {
                AppMethodBeat.o(74520);
                return 2;
            }
            int i2 = ((f) FavMediaGalleryUI.this.iLD.get(i)).cAv.dataType;
            AppMethodBeat.o(74520);
            return i2;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getCount() {
            AppMethodBeat.i(74521);
            int size = FavMediaGalleryUI.this.iLD.size();
            AppMethodBeat.o(74521);
            return size;
        }

        public final f vC(int i) {
            AppMethodBeat.i(74522);
            if (i >= FavMediaGalleryUI.this.iLD.size()) {
                ab.w("MicroMsg.FavMediaGalleryUI", "get item fail, position %d error", Integer.valueOf(i));
                AppMethodBeat.o(74522);
                return null;
            }
            f fVar = (f) FavMediaGalleryUI.this.iLD.get(i);
            AppMethodBeat.o(74522);
            return fVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(74523);
            f vC = vC(i);
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
                String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
                if (e.ct(b)) {
                    favVideoView2.setVideoData(b);
                } else {
                    String str = vC.cAv.mnd;
                    com.tencent.mm.plugin.fav.a.c LR = ((ae) g.M(ae.class)).getFavCdnStorage().LR(str);
                    if (LR == null || LR.field_status != 1) {
                        if (bo.isNullOrNil(vC.cAv.wfZ) || bo.isNullOrNil(vC.cAv.wgb)) {
                            ab.d("MicroMsg.FavMediaGalleryUI", "getView, no video, cdn data invalid");
                            favVideoView2.a(b, false, str);
                            favVideoView2.mmZ.setVisibility(0);
                        } else {
                            ab.d("MicroMsg.FavMediaGalleryUI", "getView, no video, start download, dataId:%s", str);
                            com.tencent.mm.plugin.fav.a.b.a(vC.mij, vC.cAv, true);
                            favVideoView2.a(b, true, str);
                        }
                    }
                }
                String c = com.tencent.mm.plugin.fav.a.b.c(vC.cAv);
                if (e.ct(c)) {
                    favVideoView2.setThumbView(c);
                } else {
                    ab.i("MicroMsg.FavMediaGalleryUI", "getView, no thumb, start download, path:%s", c);
                    com.tencent.mm.plugin.fav.a.b.a(vC.mij, vC.cAv);
                }
                AppMethodBeat.o(74523);
                return favVideoView;
            }
            b bVar;
            if (view == null) {
                bVar = new b(FavMediaGalleryUI.this, (byte) 0);
                view = View.inflate(FavMediaGalleryUI.this.mController.ylL, R.layout.ya, null);
                bVar.miu = view.findViewById(R.id.bm);
                bVar.miv = (MultiTouchImageView) view.findViewById(R.id.bl);
                bVar.progressBar = (ProgressBar) view.findViewById(R.id.as0);
                bVar.miw = (ImageView) view.findViewById(R.id.z4);
                bVar.mix = (TextView) view.findViewById(R.id.bq0);
                bVar.miy = (LinearLayout) view.findViewById(R.id.bp_);
                bVar.miz = (TextView) view.findViewById(R.id.bpa);
                bVar.miz.setText(R.string.bnw);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            boolean z = this.mit.get(i, true);
            this.mit.put(i, false);
            Bitmap a = l.a(vC.cAv, vC.mij, z);
            if (vC.mij != null) {
                ab.i("MicroMsg.FavMediaGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i), Integer.valueOf(vC.mij.field_id), Long.valueOf(vC.mij.field_localId), Integer.valueOf(vC.mij.field_itemStatus));
            }
            if (vC.cAv != null) {
                ab.i("MicroMsg.FavMediaGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", vC.cAv.mnd, vC.cAv.wfZ, vC.cAv.wgb, Long.valueOf(vC.cAv.wgu), vC.cAv.fgE, vC.cAv.wfV, Long.valueOf(vC.cAv.wgF));
            }
            if (a == null) {
                String str2;
                FavMediaGalleryUI.this.enableOptionMenu(false);
                ab.w("MicroMsg.FavMediaGalleryUI", "get big image fail");
                q favCdnStorage = ((ae) g.M(ae.class)).getFavCdnStorage();
                if (vC.cAv != null) {
                    str2 = vC.cAv.mnd;
                } else {
                    str2 = "";
                }
                com.tencent.mm.plugin.fav.a.c LR2 = favCdnStorage.LR(str2);
                if (LR2 == null) {
                    bVar.miy.setVisibility(8);
                    if (vC.mij == null || vC.mij.field_id >= 0) {
                        bVar.progressBar.setVisibility(8);
                        bVar.mix.setVisibility(8);
                        bVar.miw.setVisibility(8);
                        bVar.miu.setVisibility(0);
                        if (vC.cAv.whh != 0) {
                            bVar.miy.setVisibility(0);
                        }
                        b(bVar, a(vC), "");
                    } else {
                        bVar.progressBar.setVisibility(0);
                        bVar.mix.setVisibility(0);
                        bVar.miw.setVisibility(0);
                        bVar.miu.setVisibility(8);
                        bVar.miw.setImageBitmap(a(vC));
                        bVar.progressBar.setProgress(0);
                        bVar.mix.setText("0%");
                    }
                    AppMethodBeat.o(74523);
                    return view;
                }
                ab.i("MicroMsg.FavMediaGalleryUI", "fav cdnInfo status %d", Integer.valueOf(LR2.field_status));
                bVar.progressBar.setVisibility(0);
                bVar.mix.setVisibility(0);
                bVar.miw.setVisibility(0);
                bVar.miu.setVisibility(8);
                bVar.miw.setImageBitmap(a(vC));
                int i2 = LR2.field_totalLen > 0 ? ((LR2.field_offset * 100) / LR2.field_totalLen) - 1 : 0;
                if (i2 < 0) {
                    i2 = 0;
                }
                bVar.progressBar.setProgress(i2);
                bVar.mix.setText(i2 + "%");
                AppMethodBeat.o(74523);
                return view;
            }
            FavMediaGalleryUI.this.enableOptionMenu(true);
            if (r.amo(com.tencent.mm.plugin.fav.a.b.b(vC.cAv))) {
                a(bVar, a, com.tencent.mm.plugin.fav.a.b.b(vC.cAv));
            } else {
                a(bVar, a, "");
            }
            AppMethodBeat.o(74523);
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(74524);
            bVar.progressBar.setVisibility(8);
            bVar.mix.setVisibility(8);
            bVar.miw.setVisibility(8);
            bVar.miu.setVisibility(0);
            bVar.miy.setVisibility(8);
            b(bVar, bitmap, str);
            AppMethodBeat.o(74524);
        }

        private Bitmap a(f fVar) {
            Bitmap a;
            AppMethodBeat.i(74525);
            if (fVar != null) {
                a = l.a(fVar.cAv, fVar.mij);
                if (a != null) {
                    AppMethodBeat.o(74525);
                    return a;
                }
            }
            a = com.tencent.mm.compatible.g.a.decodeResource(FavMediaGalleryUI.this.getResources(), R.raw.download_image_icon);
            AppMethodBeat.o(74525);
            return a;
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(74526);
            n.w(bVar.miv, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.miv.getWidth();
            int height = bVar.miv.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            ab.v("MicroMsg.FavMediaGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
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
                    ab.d("MicroMsg.FavMediaGalleryUI", " offsety ".concat(String.valueOf(width2)));
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.miv.setImageMatrix(matrix);
            bVar.miv.bW(bitmap.getWidth(), bitmap.getHeight());
            bVar.miv.setMaxZoomDoubleTab(true);
            if (bo.isNullOrNil(str)) {
                bVar.miv.setImageBitmap(bitmap);
                AppMethodBeat.o(74526);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(str);
                bVar.miv.setGifDrawable(dVar);
                bVar.miv.hk(com.tencent.mm.bz.a.gd(FavMediaGalleryUI.this.mController.ylL), com.tencent.mm.bz.a.ge(FavMediaGalleryUI.this.mController.ylL));
                bVar.miv.bW(dVar.getIntrinsicWidth(), dVar.getIntrinsicHeight());
                bVar.miv.start();
                bVar.miv.dAp();
                AppMethodBeat.o(74526);
            } catch (Exception e) {
                ab.e("MicroMsg.FavMediaGalleryUI", bo.l(e));
                bVar.miv.setImageBitmap(bitmap);
                AppMethodBeat.o(74526);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavMediaGalleryUI() {
        AppMethodBeat.i(74528);
        AppMethodBeat.o(74528);
    }

    public final int getLayoutId() {
        return R.layout.yb;
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(74529);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kkn.setOnItemSelectedListener(this);
        this.kkn.setSingleClickOverListener(new MMGestureGallery.f() {
            public final void bcX() {
                AppMethodBeat.i(74507);
                FavMediaGalleryUI.this.finish();
                AppMethodBeat.o(74507);
            }
        });
        if (this.cHc) {
            this.kkn.setLongClickOverListener(new MMGestureGallery.c() {
                public final void bvE() {
                    AppMethodBeat.i(74511);
                    if (!(FavMediaGalleryUI.this.isFinishing() || FavMediaGalleryUI.this.uiu)) {
                        FavMediaGalleryUI.a(FavMediaGalleryUI.this);
                    }
                    AppMethodBeat.o(74511);
                }
            });
        }
        fullScreenNoTitleBar(true);
        this.iLD = new ArrayList();
        this.mnE = new a(this, (byte) 0);
        this.kkn.setAdapter(this.mnE);
        Km();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74512);
                FavMediaGalleryUI.this.finish();
                AppMethodBeat.o(74512);
                return true;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
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
        AppMethodBeat.o(74529);
    }

    private void Km() {
        com.tencent.mm.plugin.fav.a.g gVar;
        int size;
        int i;
        AppMethodBeat.i(74530);
        long[] longArrayExtra = getIntent().getLongArrayExtra("KEY_MEDIA_FAVID_LIST");
        ArrayList arrayList = new ArrayList();
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        this.mio = getIntent().getLongExtra("key_detail_info_id", -1);
        if (longArrayExtra == null) {
            Object gVar2;
            boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
            String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
            com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(this.mio);
            String str = "MicroMsg.FavMediaGalleryUI";
            String str2 = "show one fav info, local id is %d, get from db ok ? %B";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.mio);
            objArr[1] = Boolean.valueOf(iE != null);
            ab.i(str, str2, objArr);
            if (!booleanExtra || bo.isNullOrNil(stringExtra2)) {
                gVar2 = iE;
            } else {
                gVar2 = com.tencent.mm.plugin.fav.a.b.LF(stringExtra2);
            }
            if (gVar2 != null) {
                arrayList.add(gVar2);
            }
        } else {
            for (long iE2 : longArrayExtra) {
                gVar2 = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(iE2);
                if (!(gVar2 == null || arrayList.contains(gVar2))) {
                    arrayList.add(gVar2);
                }
            }
        }
        this.iLD.clear();
        int i2 = -1;
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            gVar2 = (com.tencent.mm.plugin.fav.a.g) arrayList.get(i3);
            int size3 = gVar2.field_favProto.wiv.size();
            i = 0;
            while (i < size3) {
                aar aar = (aar) gVar2.field_favProto.wiv.get(i);
                if ((aar.dataType != 8 || r.amo(com.tencent.mm.plugin.fav.a.b.b(aar))) && (aar.dataType == 2 || aar.dataType == 4 || aar.dataType == 15 || aar.dataType == 8)) {
                    this.iLD.add(new f(gVar2, aar));
                    if (stringExtra != null && stringExtra.equals(aar.mnd) && gVar2.field_localId == this.mio) {
                        size = this.iLD.size() - 1;
                        i++;
                        i2 = size;
                    }
                }
                size = i2;
                i++;
                i2 = size;
            }
            if (stringExtra == null && gVar2.field_localId == this.mio) {
                i2 = this.iLD.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mnE.notifyDataSetChanged();
        this.kkn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74516);
                if (i2 != -1) {
                    ab.d("MicroMsg.FavMediaGalleryUI", "match selection %d", Integer.valueOf(i2));
                    FavMediaGalleryUI.this.kkn.setSelection(i2);
                    FavMediaGalleryUI.this.mik = i2;
                    AppMethodBeat.o(74516);
                } else if (FavMediaGalleryUI.this.mik - 1 >= 0 && FavMediaGalleryUI.this.mik - 1 < FavMediaGalleryUI.this.iLD.size()) {
                    ab.d("MicroMsg.FavMediaGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavMediaGalleryUI.this.mik - 1), Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.kkn.setSelection(FavMediaGalleryUI.this.mik - 1);
                    FavMediaGalleryUI.this.mik = FavMediaGalleryUI.this.mik - 1;
                    AppMethodBeat.o(74516);
                } else if (FavMediaGalleryUI.this.iLD.size() > 0) {
                    ab.d("MicroMsg.FavMediaGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.kkn.setSelection(0);
                    FavMediaGalleryUI.this.mik = 0;
                    AppMethodBeat.o(74516);
                } else {
                    ab.w("MicroMsg.FavMediaGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavMediaGalleryUI.this.iLD.size()));
                    FavMediaGalleryUI.this.finish();
                    AppMethodBeat.o(74516);
                }
            }
        });
        AppMethodBeat.o(74530);
    }

    public void onDestroy() {
        AppMethodBeat.i(74531);
        getIntent().putExtra("key_activity_browse_time", dyi());
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        for (FavVideoView favVideoView : this.mnF) {
            if (favVideoView != null) {
                favVideoView.onDestroy();
            }
        }
        super.onDestroy();
        AppMethodBeat.o(74531);
    }

    public void onResume() {
        AppMethodBeat.i(74532);
        super.onResume();
        ((ae) g.M(ae.class)).getFavCdnStorage().a(this);
        o.JV(1);
        AppMethodBeat.o(74532);
    }

    public void onPause() {
        AppMethodBeat.i(74533);
        super.onPause();
        ((ae) g.M(ae.class)).getFavCdnStorage().b(this);
        o.JV(2);
        AppMethodBeat.o(74533);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(74534);
        this.mik = i;
        ab.d("MicroMsg.FavMediaGalleryUI", "pos:".concat(String.valueOf(i)));
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
        AppMethodBeat.o(74534);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void d(final com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(74535);
        if (cVar != null) {
            f vC = this.mnE.vC(this.mik);
            if (vC != null && bo.bc(cVar.field_dataId, "").equals(vC.cAv.mnd) && vC.cAv.dataType == 2) {
                al.d(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.i(74517);
                        View selectedView = FavMediaGalleryUI.this.kkn.getSelectedView();
                        if (selectedView == null) {
                            AppMethodBeat.o(74517);
                        } else if (selectedView.getTag() == null || !(selectedView.getTag() instanceof b)) {
                            AppMethodBeat.o(74517);
                        } else {
                            b bVar = (b) selectedView.getTag();
                            int i2 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            bVar.progressBar.setProgress(i);
                            bVar.mix.setText(i + "%");
                            if (i >= 100 || cVar.isFinished()) {
                                FavMediaGalleryUI.this.mnE.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(74517);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(74535);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74536);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.o(74536);
                return;
            }
            f vC = this.mnE.vC(this.mik);
            if (vC == null) {
                ab.i("MicroMsg.FavMediaGalleryUI", "dataItem is null.");
                AppMethodBeat.o(74536);
                return;
            }
            String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
            k kVar = new k();
            if (k.u(vC.mij)) {
                com.tencent.mm.ui.base.h.bQ(this.mController.ylL, getString(R.string.ah));
                AppMethodBeat.o(74536);
                return;
            }
            ArrayList<String> P = bo.P(intent.getStringExtra("Select_Conv_User").split(","));
            ab.d("MicroMsg.FavMediaGalleryUI", "select %s for sending", r2);
            final com.tencent.mm.ui.base.p b2 = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            if (r.amo(b)) {
                for (String b3 : P) {
                    i.a(this.mController.ylL, b3, vC.mij, vC.cAv, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74518);
                            b2.dismiss();
                            AppMethodBeat.o(74518);
                        }
                    });
                }
            } else {
                AnonymousClass2 anonymousClass2 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74508);
                        b2.dismiss();
                        AppMethodBeat.o(74508);
                    }
                };
                for (String b32 : P) {
                    i.a(this, b32, vC.cAv, anonymousClass2);
                }
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74536);
    }

    static /* synthetic */ void a(FavMediaGalleryUI favMediaGalleryUI) {
        AppMethodBeat.i(74537);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        f vC = favMediaGalleryUI.mnE.vC(favMediaGalleryUI.mik);
        if (vC == null) {
            AppMethodBeat.o(74537);
            return;
        }
        if (vC.cAv.whh != 0) {
            ab.i("MicroMsg.FavMediaGalleryUI", "showMenu, illegalType");
        } else if (vC.cAv.dataType == 2) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favMediaGalleryUI.getString(R.string.bri));
            }
            if (vC.mij != null && vC.mij.buu()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favMediaGalleryUI.getString(R.string.bq_));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favMediaGalleryUI.getString(R.string.brb));
            String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
            nr nrVar = (nr) favMediaGalleryUI.mim.get(b);
            if (nrVar == null) {
                np npVar = new np();
                npVar.cJU.filePath = b;
                com.tencent.mm.sdk.b.a.xxA.m(npVar);
            } else if (!bo.isNullOrNil(nrVar.cJX.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favMediaGalleryUI.getString(com.tencent.mm.plugin.scanner.a.ba(nrVar.cJX.cvn, nrVar.cJX.result) ? R.string.bqh : R.string.bqg));
            }
        } else if (e.ct(com.tencent.mm.plugin.fav.a.b.b(vC.cAv))) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favMediaGalleryUI.getString(R.string.bri));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favMediaGalleryUI.getString(R.string.dx0));
        }
        arrayList.add(Integer.valueOf(4));
        arrayList2.add(favMediaGalleryUI.getString(R.string.bp6));
        if (favMediaGalleryUI.icA == null) {
            favMediaGalleryUI.icA = new j(favMediaGalleryUI.mController.ylL);
        }
        favMediaGalleryUI.icA.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(74513);
                lVar.setHeaderTitle((CharSequence) "");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(74513);
                        return;
                    }
                }
            }
        };
        favMediaGalleryUI.icA.rBm = favMediaGalleryUI.lcJ;
        favMediaGalleryUI.icA.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74514);
                FavMediaGalleryUI.this.icA = null;
                AppMethodBeat.o(74514);
            }
        });
        com.tencent.mm.ui.base.h.a(favMediaGalleryUI.mController.ylL, favMediaGalleryUI.icA.cuu());
        AppMethodBeat.o(74537);
    }

    static /* synthetic */ void b(FavMediaGalleryUI favMediaGalleryUI, String str) {
        AppMethodBeat.i(74539);
        String uu = u.uu(str);
        ab.i("MicroMsg.FavMediaGalleryUI", "save video now video path %s out path %s", str, uu);
        if (bo.isNullOrNil(uu)) {
            Toast.makeText(favMediaGalleryUI, favMediaGalleryUI.getString(R.string.f1c), 1).show();
            AppMethodBeat.o(74539);
            return;
        }
        Toast.makeText(favMediaGalleryUI, favMediaGalleryUI.getString(R.string.f1d, new Object[]{uu}), 1).show();
        com.tencent.mm.pluginsdk.ui.tools.n.a(uu, favMediaGalleryUI);
        AppMethodBeat.o(74539);
    }
}
