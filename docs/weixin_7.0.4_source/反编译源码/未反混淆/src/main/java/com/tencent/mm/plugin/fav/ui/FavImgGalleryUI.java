package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, p {
    private boolean cHc = true;
    private ArrayList<f> iLD;
    private j icA;
    private MMGestureGallery kkn;
    private d lcJ = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(74008);
            f vC = FavImgGalleryUI.this.mil.vC(FavImgGalleryUI.this.mik);
            if (vC == null) {
                AppMethodBeat.o(74008);
                return;
            }
            String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
            if (e.ct(b)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        h.j(FavImgGalleryUI.this.mio, 1, 0);
                        if (r.amo(b)) {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            com.tencent.mm.bp.d.b(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                            AppMethodBeat.o(74008);
                            return;
                        }
                        com.tencent.mm.plugin.fav.a.b.c(b, FavImgGalleryUI.this);
                        AppMethodBeat.o(74008);
                        return;
                    case 1:
                        com.tencent.mm.plugin.fav.a.b.d(b, FavImgGalleryUI.this);
                        h.j(FavImgGalleryUI.this.mio, 0, 0);
                        AppMethodBeat.o(74008);
                        return;
                    case 2:
                        FavImgGalleryUI.a(b, FavImgGalleryUI.this.getString(R.string.bra), FavImgGalleryUI.this);
                        AppMethodBeat.o(74008);
                        return;
                    case 3:
                        nr nrVar = (nr) FavImgGalleryUI.this.mim.get(b);
                        if (nrVar != null) {
                            cf cfVar = new cf();
                            cfVar.cvm.activity = FavImgGalleryUI.this;
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
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(74008);
                return;
            }
            ab.w("MicroMsg.FavImgGalleryUI", "file not exists");
            AppMethodBeat.o(74008);
        }
    };
    private int mik = 0;
    private a mil;
    private Map<String, nr> mim = new HashMap();
    private long mio;
    private c mip = new c<nr>() {
        {
            AppMethodBeat.i(74002);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(74002);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(74003);
            nr nrVar = (nr) bVar;
            FavImgGalleryUI.this.mim.put(nrVar.cJX.filePath, nrVar);
            if (FavImgGalleryUI.this.icA != null && FavImgGalleryUI.this.icA.rBk.isShowing()) {
                FavImgGalleryUI.b(FavImgGalleryUI.this);
            }
            AppMethodBeat.o(74003);
            return true;
        }
    };

    class a extends BaseAdapter {
        SparseBooleanArray mit;

        private a() {
            AppMethodBeat.i(74012);
            this.mit = new SparseBooleanArray();
            AppMethodBeat.o(74012);
        }

        /* synthetic */ a(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(74019);
            f vC = vC(i);
            AppMethodBeat.o(74019);
            return vC;
        }

        public final int getCount() {
            AppMethodBeat.i(74013);
            int size = FavImgGalleryUI.this.iLD.size();
            AppMethodBeat.o(74013);
            return size;
        }

        public final f vC(int i) {
            AppMethodBeat.i(74014);
            if (i >= FavImgGalleryUI.this.iLD.size()) {
                ab.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", Integer.valueOf(i));
                AppMethodBeat.o(74014);
                return null;
            }
            f fVar = (f) FavImgGalleryUI.this.iLD.get(i);
            AppMethodBeat.o(74014);
            return fVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(74015);
            if (view == null) {
                bVar = new b(FavImgGalleryUI.this, (byte) 0);
                view = View.inflate(FavImgGalleryUI.this.mController.ylL, R.layout.ya, null);
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
            f vC = vC(i);
            boolean z = this.mit.get(i, true);
            this.mit.put(i, false);
            Bitmap a = l.a(vC.cAv, vC.mij, z);
            if (vC.mij != null) {
                ab.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i), Integer.valueOf(vC.mij.field_id), Long.valueOf(vC.mij.field_localId), Integer.valueOf(vC.mij.field_itemStatus));
            }
            if (vC.cAv != null) {
                ab.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", vC.cAv.mnd, vC.cAv.wfZ, vC.cAv.wgb, Long.valueOf(vC.cAv.wgu), vC.cAv.fgE, vC.cAv.wfV, Long.valueOf(vC.cAv.wgF));
            }
            if (a == null) {
                String str;
                FavImgGalleryUI.this.enableOptionMenu(false);
                ab.w("MicroMsg.FavImgGalleryUI", "get big image fail");
                q favCdnStorage = ((ae) g.M(ae.class)).getFavCdnStorage();
                if (vC.cAv != null) {
                    str = vC.cAv.mnd;
                } else {
                    str = "";
                }
                com.tencent.mm.plugin.fav.a.c LR = favCdnStorage.LR(str);
                if (LR == null) {
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
                    AppMethodBeat.o(74015);
                } else {
                    ab.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", Integer.valueOf(LR.field_status));
                    bVar.progressBar.setVisibility(0);
                    bVar.mix.setVisibility(0);
                    bVar.miw.setVisibility(0);
                    bVar.miu.setVisibility(8);
                    bVar.miw.setImageBitmap(a(vC));
                    int i2 = LR.field_totalLen > 0 ? ((LR.field_offset * 100) / LR.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    bVar.progressBar.setProgress(i2);
                    bVar.mix.setText(i2 + "%");
                    AppMethodBeat.o(74015);
                }
            } else {
                FavImgGalleryUI.this.enableOptionMenu(true);
                if (r.amo(com.tencent.mm.plugin.fav.a.b.b(vC.cAv))) {
                    a(bVar, a, com.tencent.mm.plugin.fav.a.b.b(vC.cAv));
                } else {
                    a(bVar, a, "");
                }
                AppMethodBeat.o(74015);
            }
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(74016);
            bVar.progressBar.setVisibility(8);
            bVar.mix.setVisibility(8);
            bVar.miw.setVisibility(8);
            bVar.miu.setVisibility(0);
            bVar.miy.setVisibility(8);
            b(bVar, bitmap, str);
            AppMethodBeat.o(74016);
        }

        private Bitmap a(f fVar) {
            Bitmap a;
            AppMethodBeat.i(74017);
            if (fVar != null) {
                a = l.a(fVar.cAv, fVar.mij);
                if (a != null) {
                    AppMethodBeat.o(74017);
                    return a;
                }
            }
            a = com.tencent.mm.compatible.g.a.decodeResource(FavImgGalleryUI.this.getResources(), R.raw.download_image_icon);
            AppMethodBeat.o(74017);
            return a;
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            AppMethodBeat.i(74018);
            n.w(bVar.miv, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.miv.getWidth();
            int height = bVar.miv.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            ab.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
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
                    ab.d("MicroMsg.FavImgGalleryUI", " offsety ".concat(String.valueOf(width2)));
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.miv.setImageMatrix(matrix);
            bVar.miv.bW(bitmap.getWidth(), bitmap.getHeight());
            bVar.miv.setMaxZoomDoubleTab(true);
            if (bo.isNullOrNil(str)) {
                bVar.miv.setImageBitmap(bitmap);
                AppMethodBeat.o(74018);
                return;
            }
            try {
                com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(str);
                bVar.miv.setGifDrawable(dVar);
                bVar.miv.hk(com.tencent.mm.bz.a.gd(FavImgGalleryUI.this.mController.ylL), com.tencent.mm.bz.a.ge(FavImgGalleryUI.this.mController.ylL));
                bVar.miv.bW(dVar.getIntrinsicWidth(), dVar.getIntrinsicHeight());
                bVar.miv.start();
                bVar.miv.dAp();
                AppMethodBeat.o(74018);
            } catch (Exception e) {
                ab.e("MicroMsg.FavImgGalleryUI", bo.l(e));
                bVar.miv.setImageBitmap(bitmap);
                AppMethodBeat.o(74018);
            }
        }
    }

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

        /* synthetic */ b(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavImgGalleryUI() {
        AppMethodBeat.i(74020);
        AppMethodBeat.o(74020);
    }

    public final int getLayoutId() {
        return R.layout.yb;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74021);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            getWindow().addFlags(67108864);
        }
        this.cHc = getIntent().getBooleanExtra("show_share", true);
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kkn.setOnItemSelectedListener(this);
        this.kkn.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(74001);
                FavImgGalleryUI.this.finish();
                AppMethodBeat.o(74001);
            }
        });
        if (this.cHc) {
            this.kkn.setLongClickOverListener(new MMGestureGallery.c() {
                public final void bvE() {
                    AppMethodBeat.i(74004);
                    if (!(FavImgGalleryUI.this.isFinishing() || FavImgGalleryUI.this.uiu)) {
                        com.tencent.mm.model.v.b y = v.Zp().y("basescanui@datacenter", true);
                        y.j("key_basescanui_screen_x", Integer.valueOf(FavImgGalleryUI.this.kkn.getXDown()));
                        y.j("key_basescanui_screen_y", Integer.valueOf(FavImgGalleryUI.this.kkn.getYDown()));
                        FavImgGalleryUI.b(FavImgGalleryUI.this);
                    }
                    AppMethodBeat.o(74004);
                }
            });
        }
        fullScreenNoTitleBar(true);
        this.iLD = new ArrayList();
        this.mil = new a(this, (byte) 0);
        this.kkn.setAdapter(this.mil);
        Km();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74005);
                FavImgGalleryUI.this.finish();
                AppMethodBeat.o(74005);
                return true;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.mip);
        setResult(0, getIntent());
        AppMethodBeat.o(74021);
    }

    public static void a(String str, String str2, Context context) {
        AppMethodBeat.i(74022);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavImgGalleryUI", "save image fail, path is null");
            AppMethodBeat.o(74022);
            return;
        }
        if (!com.tencent.mm.platformtools.q.a(str, context, R.string.b3r)) {
            Toast.makeText(context, str2, 1).show();
        }
        AppMethodBeat.o(74022);
    }

    private void Km() {
        com.tencent.mm.plugin.fav.a.g gVar;
        Object gVar2;
        AppMethodBeat.i(74023);
        this.mio = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.plugin.fav.a.g iE = ((ae) g.M(ae.class)).getFavItemInfoStorage().iE(this.mio);
        String str = "MicroMsg.FavImgGalleryUI";
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
        this.iLD.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            gVar2 = (com.tencent.mm.plugin.fav.a.g) arrayList.get(i2);
            int size2 = gVar2.field_favProto.wiv.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                aar aar = (aar) gVar2.field_favProto.wiv.get(i3);
                if ((aar.dataType != 8 || r.amo(com.tencent.mm.plugin.fav.a.b.b(aar))) && (aar.dataType == 2 || aar.dataType == 8)) {
                    this.iLD.add(new f(gVar2, aar));
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
            if (stringExtra == null && gVar2.field_localId == this.mio) {
                i = this.iLD.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mil.notifyDataSetChanged();
        this.kkn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74009);
                if (i != -1) {
                    ab.d("MicroMsg.FavImgGalleryUI", "match selection %d", Integer.valueOf(i));
                    FavImgGalleryUI.this.kkn.setSelection(i);
                    FavImgGalleryUI.this.mik = i;
                    AppMethodBeat.o(74009);
                } else if (FavImgGalleryUI.this.mik - 1 >= 0 && FavImgGalleryUI.this.mik - 1 < FavImgGalleryUI.this.iLD.size()) {
                    ab.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavImgGalleryUI.this.mik - 1), Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.kkn.setSelection(FavImgGalleryUI.this.mik - 1);
                    FavImgGalleryUI.this.mik = FavImgGalleryUI.this.mik - 1;
                    AppMethodBeat.o(74009);
                } else if (FavImgGalleryUI.this.iLD.size() > 0) {
                    ab.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.kkn.setSelection(0);
                    FavImgGalleryUI.this.mik = 0;
                    AppMethodBeat.o(74009);
                } else {
                    ab.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavImgGalleryUI.this.iLD.size()));
                    FavImgGalleryUI.this.finish();
                    AppMethodBeat.o(74009);
                }
            }
        });
        AppMethodBeat.o(74023);
    }

    public void onDestroy() {
        AppMethodBeat.i(74024);
        getIntent().putExtra("key_activity_browse_time", dyi());
        com.tencent.mm.sdk.b.a.xxA.d(this.mip);
        super.onDestroy();
        AppMethodBeat.o(74024);
    }

    public void onResume() {
        AppMethodBeat.i(74025);
        super.onResume();
        ((ae) g.M(ae.class)).getFavCdnStorage().a(this);
        o.JV(1);
        AppMethodBeat.o(74025);
    }

    public void onPause() {
        AppMethodBeat.i(74026);
        super.onPause();
        ((ae) g.M(ae.class)).getFavCdnStorage().b(this);
        o.JV(2);
        AppMethodBeat.o(74026);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(74027);
        this.mik = i;
        ab.d("MicroMsg.FavImgGalleryUI", "pos:".concat(String.valueOf(i)));
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).dzA();
        }
        AppMethodBeat.o(74027);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void d(final com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(74028);
        if (cVar != null) {
            ab.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", Integer.valueOf(cVar.field_status));
            f vC = this.mil.vC(this.mik);
            if (vC != null && bo.bc(cVar.field_dataId, "").equals(vC.cAv.mnd)) {
                al.d(new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.i(74010);
                        View selectedView = FavImgGalleryUI.this.kkn.getSelectedView();
                        if (selectedView == null) {
                            AppMethodBeat.o(74010);
                            return;
                        }
                        b bVar = (b) selectedView.getTag();
                        int i2 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                        if (i2 >= 0) {
                            i = i2;
                        }
                        bVar.progressBar.setProgress(i);
                        bVar.mix.setText(i + "%");
                        if (i >= 100 || cVar.isFinished()) {
                            FavImgGalleryUI.this.mil.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(74010);
                    }
                });
            }
        }
        AppMethodBeat.o(74028);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(74029);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.o(74029);
                return;
            }
            f vC = this.mil.vC(this.mik);
            if (vC == null) {
                ab.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                AppMethodBeat.o(74029);
                return;
            }
            k kVar = new k();
            if (k.u(vC.mij)) {
                com.tencent.mm.ui.base.h.bQ(this.mController.ylL, getString(R.string.ah));
                AppMethodBeat.o(74029);
                return;
            }
            ab.d("MicroMsg.FavImgGalleryUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
            final com.tencent.mm.ui.base.p b = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.bp2), false, null);
            i.a(this.mController.ylL, r1, vC.mij, vC.cAv, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74011);
                    b.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.i(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(R.string.bnf));
                    AppMethodBeat.o(74011);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(74029);
    }

    static /* synthetic */ void b(FavImgGalleryUI favImgGalleryUI) {
        AppMethodBeat.i(74030);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        f vC = favImgGalleryUI.mil.vC(favImgGalleryUI.mik);
        if (vC == null) {
            AppMethodBeat.o(74030);
            return;
        }
        if (vC.cAv.whh == 0) {
            if (vC.mij != null && vC.mij.but()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(R.string.bri));
            }
            if (vC.mij != null && vC.mij.buu()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(R.string.bq_));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(R.string.brb));
            String b = com.tencent.mm.plugin.fav.a.b.b(vC.cAv);
            nr nrVar = (nr) favImgGalleryUI.mim.get(b);
            if (nrVar == null) {
                np npVar = new np();
                npVar.cJU.filePath = b;
                com.tencent.mm.sdk.b.a.xxA.m(npVar);
            } else if (!bo.isNullOrNil(nrVar.cJX.result)) {
                arrayList.add(Integer.valueOf(3));
                if (com.tencent.mm.plugin.scanner.a.BR(nrVar.cJX.cvn)) {
                    arrayList2.add(favImgGalleryUI.getString(R.string.bqg));
                } else if (com.tencent.mm.plugin.scanner.a.ba(nrVar.cJX.cvn, nrVar.cJX.result)) {
                    arrayList2.add(favImgGalleryUI.getString(R.string.bqh));
                } else if (com.tencent.mm.plugin.scanner.a.BQ(nrVar.cJX.cvn)) {
                    arrayList2.add(favImgGalleryUI.getString(R.string.bqf));
                } else {
                    arrayList2.add(favImgGalleryUI.getString(R.string.bqg));
                }
            }
            if (favImgGalleryUI.icA == null) {
                favImgGalleryUI.icA = new j(favImgGalleryUI.mController.ylL);
            }
            favImgGalleryUI.icA.rBl = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(74006);
                    lVar.setHeaderTitle((CharSequence) "");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(74006);
                            return;
                        }
                    }
                }
            };
            favImgGalleryUI.icA.rBm = favImgGalleryUI.lcJ;
            favImgGalleryUI.icA.e(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(74007);
                    FavImgGalleryUI.this.icA = null;
                    AppMethodBeat.o(74007);
                }
            });
            com.tencent.mm.ui.base.h.a(favImgGalleryUI.mController.ylL, favImgGalleryUI.icA.cuu());
        }
        AppMethodBeat.o(74030);
    }
}
