package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.y;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.q;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private int gLP;
    private ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(21497);
            ab.d("MicroMsg.ImagePreviewUI", "onServiceConnected");
            ImagePreviewUI.this.mOG = com.tencent.mm.plugin.gallery.stub.a.a.B(iBinder);
            AppMethodBeat.o(21497);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(21498);
            ab.d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
            ImagePreviewUI.this.mOG = null;
            AppMethodBeat.o(21498);
        }
    };
    private boolean kvs;
    private com.tencent.mm.plugin.gallery.stub.a mOG = null;
    private ArrayList<MediaItem> mOH;
    private String mOL;
    private int mPA;
    private long mPF = 0;
    private HashMap<String, Integer> mPN = new HashMap();
    private TextView mPo;
    private boolean mPu = true;
    private c mQS;
    private MMViewPager mQT;
    private RecyclerView mQU;
    private ArrayList<String> mQV;
    private ArrayList<String> mQW;
    private Integer mQX;
    private ImageButton mQY;
    private TextView mQZ;
    private boolean mQm;
    private ap mRa;
    private ImageButton mRb;
    private TextView mRc;
    private ViewGroup mRd;
    private ViewGroup mRe;
    private boolean mRf = true;
    private boolean mRg = true;
    private int mRh = 0;
    private int mRi = 10;
    private TextView mRj;
    private TextView mRk;
    private TextView mRl;
    private TextView mRm;
    private View mRn;
    private TextView mRo;
    private ProgressBar mRp;
    boolean mRq = false;
    private int mRr = 300000;
    private String mRs;
    private HashSet<String> mRt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ImagePreviewUI() {
        AppMethodBeat.i(21529);
        AppMethodBeat.o(21529);
    }

    static /* synthetic */ void j(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(21559);
        imagePreviewUI.goBack();
        AppMethodBeat.o(21559);
    }

    static /* synthetic */ ArrayList l(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(21560);
        ArrayList bCK = imagePreviewUI.bCK();
        AppMethodBeat.o(21560);
        return bCK;
    }

    static /* synthetic */ String n(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(21563);
        String bCJ = imagePreviewUI.bCJ();
        AppMethodBeat.o(21563);
        return bCJ;
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21530);
        final long yz = bo.yz();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        new ak().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21510);
                ImagePreviewUI.a(ImagePreviewUI.this, true);
                e.bCa().wp(-8);
                ab.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", Long.valueOf(bo.az(yz)));
                AppMethodBeat.o(21510);
            }
        });
        bindService(new Intent(this.mController.ylL, GalleryStubService.class), this.ktl, 1);
        initView();
        ab.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(21530);
    }

    public void onResume() {
        AppMethodBeat.i(21531);
        super.onResume();
        AppMethodBeat.o(21531);
    }

    public void onPause() {
        AppMethodBeat.i(21532);
        if (this.mRa != null) {
            this.mRa.stopTimer();
        }
        super.onPause();
        AppMethodBeat.o(21532);
    }

    public final int getLayoutId() {
        return R.layout.a7s;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(21533);
        if (b.bD(this)) {
            setContentView(view);
            AppMethodBeat.o(21533);
            return;
        }
        ae.h(ae.a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.o(21533);
    }

    /* JADX WARNING: Missing block: B:14:0x00f2, code skipped:
            if (r11.mQX.intValue() < 0) goto L_0x00f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        AppMethodBeat.i(21534);
        this.mRk = (TextView) findViewById(R.id.cih);
        this.mRl = (TextView) findViewById(R.id.cij);
        this.mRm = (TextView) findViewById(R.id.ci_);
        this.mRn = findViewById(R.id.ci9);
        this.mRn.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21520);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ImagePreviewUI.this.mRn.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((float) x.al(ImagePreviewUI.this)) + ImagePreviewUI.this.getResources().getDimension(R.dimen.fd));
                ImagePreviewUI.this.mRn.setLayoutParams(marginLayoutParams);
                AppMethodBeat.o(21520);
            }
        }, 100);
        this.mRo = (TextView) findViewById(R.id.cii);
        this.mRp = (ProgressBar) findViewById(R.id.cic);
        this.mPA = getIntent().getIntExtra("max_select_count", 9);
        this.mRi = getIntent().getIntExtra("key_edit_video_max_time_length", 10);
        this.mPu = e.bBZ().hOZ == 4;
        Intent intent = getIntent();
        this.mQV = intent.getStringArrayListExtra("preview_image_list");
        this.mQW = new ArrayList();
        if (this.mQV != null) {
            this.mQW.addAll(this.mQV);
        }
        this.mOH = e.bCb();
        boolean booleanExtra = intent.getBooleanExtra("preview_all", false);
        String str = "MicroMsg.ImagePreviewUI";
        String str2 = "preview all[%B] mediaitems is null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(booleanExtra);
        objArr[1] = Boolean.valueOf(this.mOH == null);
        ab.i(str, str2, objArr);
        if (booleanExtra && this.mOH != null) {
            this.mQm = true;
            this.mQX = Integer.valueOf(intent.getIntExtra("preview_position", 0));
            ab.i("MicroMsg.ImagePreviewUI", "start position=%d", this.mQX);
        }
        this.mQX = Integer.valueOf(0);
        e.wk(this.mQX.intValue());
        if (this.mQm || !(this.mQW == null || this.mQW.size() == 0)) {
            final String str3;
            String str4;
            this.mQY = (ImageButton) findViewById(R.id.avr);
            this.mPo = (TextView) findViewById(R.id.avs);
            this.mQZ = (TextView) findViewById(R.id.cib);
            this.kvs = intent.getBooleanExtra("send_raw_img", false);
            this.mRh = intent.getIntExtra("query_source_type", 0);
            if (this.kvs) {
                this.mQY.setImageResource(R.raw.radio_on);
            } else {
                this.mQY.setImageResource(R.raw.radio_off);
            }
            if (this.mQW != null && this.mQW.size() == 1) {
                str3 = (String) this.mQW.get(0);
                if (str3.endsWith(FileUtils.PIC_POSTFIX_JPEG)) {
                    al.d(new Runnable() {
                        public final void run() {
                            boolean z = true;
                            AppMethodBeat.i(21507);
                            try {
                                com.tencent.mm.plugin.gallery.stub.a t = ImagePreviewUI.this.mOG;
                                String str = str3;
                                String stringExtra = ImagePreviewUI.this.getIntent().getStringExtra("GalleryUI_ToUser");
                                if (!ImagePreviewUI.this.mPu) {
                                    if (ImagePreviewUI.this.kvs) {
                                        z = false;
                                    }
                                }
                                t.a(str, stringExtra, z, 0, true);
                                AppMethodBeat.o(21507);
                            } catch (Exception e) {
                                AppMethodBeat.o(21507);
                            }
                        }
                    });
                }
            }
            this.mPo.setText(this.mController.ylL.getString(R.string.c3i));
            this.mQY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21521);
                    ImagePreviewUI.this.kvs = !ImagePreviewUI.this.kvs;
                    if (ImagePreviewUI.this.kvs) {
                        ImagePreviewUI.this.mQY.setImageResource(R.raw.radio_on);
                        if (ImagePreviewUI.this.mQW.size() == 0) {
                            ImagePreviewUI.this.mRb.performClick();
                        }
                    } else {
                        ImagePreviewUI.this.mQY.setImageResource(R.raw.radio_off);
                    }
                    ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(R.string.c3i) + "");
                    ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.mQX.intValue());
                    AppMethodBeat.o(21521);
                }
            });
            this.mQZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21522);
                    String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
                    if (bo.isNullOrNil(item)) {
                        ab.w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                        AppMethodBeat.o(21522);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_video_path", item);
                    intent.putExtra("key_need_clip_video_first", false);
                    if (e.bBZ().hOZ == 14) {
                        intent.putExtra("key_need_remux_video", false);
                    }
                    intent.putExtra("key_max_duration_seconds", ImagePreviewUI.this.mRi);
                    d.b(ImagePreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent, 4370);
                    AppMethodBeat.o(21522);
                }
            });
            this.mRo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21523);
                    String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
                    if (bo.isNullOrNil(item)) {
                        ab.w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                        AppMethodBeat.o(21523);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_video_path", item);
                    intent.putExtra("key_need_clip_video_first", true);
                    if (e.bBZ().hOZ == 14) {
                        intent.putExtra("key_need_remux_video", false);
                    }
                    intent.putExtra("key_max_duration_seconds", ImagePreviewUI.this.mRi);
                    d.b(ImagePreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent, 4370);
                    AppMethodBeat.o(21523);
                }
            });
            this.mPo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21524);
                    ImagePreviewUI.this.mQY.performClick();
                    AppMethodBeat.o(21524);
                }
            });
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(21525);
                    ImagePreviewUI.j(ImagePreviewUI.this);
                    AppMethodBeat.o(21525);
                    return true;
                }
            });
            this.mOL = intent.getStringExtra("album_business_tag");
            this.gLP = intent.getIntExtra("album_video_max_duration", 10);
            a(0, bCJ(), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    int i;
                    boolean z;
                    int i2 = 0;
                    AppMethodBeat.i(21528);
                    if (ImagePreviewUI.this.mRh == 6) {
                        ImagePreviewUI.this.setResult(1);
                        ImagePreviewUI.this.finish();
                    }
                    final Intent intent = new Intent();
                    intent.putExtra("isPreviewPhoto", ImagePreviewUI.this.getIntent().getBooleanExtra("isPreviewPhoto", false));
                    ArrayList l = ImagePreviewUI.l(ImagePreviewUI.this);
                    if (l == null || l.size() != 0) {
                        i = 0;
                    } else {
                        MediaItem wz = ImagePreviewUI.this.mQS.wz(ImagePreviewUI.this.mQX.intValue());
                        if (!ImagePreviewUI.this.mPu || ImagePreviewUI.this.mQS == null || wz == null || wz.getType() != 2) {
                            ImagePreviewUI.this.mRb.performClick();
                            i = 300;
                        } else {
                            ImagePreviewUI.a(ImagePreviewUI.this, wz.fPT);
                            i = 0;
                        }
                    }
                    if (ImagePreviewUI.this.kvs) {
                        z = false;
                    } else {
                        z = true;
                    }
                    final boolean m = ImagePreviewUI.this.mPu;
                    if (i == 0) {
                        ImagePreviewUI.a(ImagePreviewUI.this, intent, m, z);
                        AppMethodBeat.o(21528);
                    } else {
                        g bCa = e.bCa();
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(21526);
                                ImagePreviewUI.a(ImagePreviewUI.this, intent, m, z);
                                AppMethodBeat.o(21526);
                            }

                            public final String toString() {
                                AppMethodBeat.i(21527);
                                String str = super.toString() + "|addTextOptionMenu";
                                AppMethodBeat.o(21527);
                                return str;
                            }
                        };
                        if (i >= 0) {
                            i2 = i;
                        }
                        bCa.bCo().postDelayed(anonymousClass1, (long) i2);
                        AppMethodBeat.o(21528);
                    }
                    return true;
                }
            }, q.b.GREEN);
            this.mRb = (ImageButton) findViewById(R.id.cie);
            this.mRb.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21499);
                    String item = ImagePreviewUI.this.mQS.getItem(ImagePreviewUI.this.mQX.intValue());
                    if (bo.isNullOrNil(item)) {
                        ab.w("MicroMsg.ImagePreviewUI", "get path error, position %d", ImagePreviewUI.this.mQX);
                        AppMethodBeat.o(21499);
                        return;
                    }
                    ImagePreviewUI.a(ImagePreviewUI.this, item);
                    ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.mQX.intValue());
                    ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(R.string.c3i) + "");
                    ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                    AppMethodBeat.o(21499);
                }
            });
            this.mRc = (TextView) findViewById(R.id.cid);
            this.mRc.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21500);
                    ImagePreviewUI.this.mRb.performClick();
                    AppMethodBeat.o(21500);
                }
            });
            if (this.mPA == 1) {
                this.mRb.setVisibility(8);
                this.mRc.setVisibility(8);
            }
            this.mRd = (ViewGroup) findViewById(R.id.b75);
            this.mRe = (ViewGroup) findViewById(R.id.cig);
            if (this.mRd != null) {
                this.mRd.setVisibility(8);
                this.mRd.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
            if (this.mRe != null) {
                this.mRe.setVisibility(8);
                this.mRe.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
            this.mRj = (TextView) findViewById(R.id.cia);
            this.mRj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21501);
                    ImagePreviewUI.o(ImagePreviewUI.this);
                    AppMethodBeat.o(21501);
                }
            });
            this.mQU = (RecyclerView) findViewById(R.id.ci8);
            this.mQU.getItemAnimator().aov = 66;
            this.mQU.b(new h() {
                public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
                    AppMethodBeat.i(21502);
                    int dimension = (int) ah.getContext().getResources().getDimension(R.dimen.l5);
                    rect.left = dimension / 2;
                    rect.bottom = dimension;
                    rect.top = dimension;
                    rect.right = dimension / 2;
                    AppMethodBeat.o(21502);
                }
            });
            g gVar = new g();
            gVar.setOrientation(0);
            this.mQU.setLayoutManager(gVar);
            f fVar = new f(this, this.mQW, getResources().getDisplayMetrics().widthPixels / 7, this.mQm);
            this.mQU.setAdapter(fVar);
            this.mQU.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21503);
                    int i = ImagePreviewUI.this.getResources().getDisplayMetrics().widthPixels / 7;
                    ImagePreviewUI.this.mQU.getLayoutParams().height = (((int) ah.getContext().getResources().getDimension(R.dimen.l5)) * 2) + i;
                    ImagePreviewUI.this.mQU.smoothScrollToPosition(ImagePreviewUI.this.mQX.intValue());
                    AppMethodBeat.o(21503);
                }
            });
            if (this.mQW.size() > 0) {
                this.mQU.setVisibility(0);
            } else {
                this.mQU.setVisibility(8);
            }
            this.mQU.setItemAnimator(new y());
            fVar.mRL.i(this.mQU);
            fVar.mRF = new f.b() {
                public final void wC(int i) {
                    AppMethodBeat.i(21504);
                    ab.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", Integer.valueOf(i), Boolean.valueOf(ImagePreviewUI.this.mQm));
                    ((f) ImagePreviewUI.this.mQU.getAdapter()).el(i, i);
                    ImagePreviewUI.this.mQT.setCurrentItem(i, false);
                    if (ImagePreviewUI.this.mQm) {
                        e.mNQ = true;
                        AppMethodBeat.o(21504);
                        return;
                    }
                    e.mNS = true;
                    AppMethodBeat.o(21504);
                }

                public final void ek(int i, int i2) {
                    AppMethodBeat.i(21505);
                    ab.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), ImagePreviewUI.this.mQX);
                    AppMethodBeat.o(21505);
                }

                public final void X(int i, int i2, int i3) {
                    AppMethodBeat.i(21506);
                    ab.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ImagePreviewUI.this.mQX);
                    if (ImagePreviewUI.this.mQm) {
                        com.tencent.mm.plugin.gallery.a.a.swap(ImagePreviewUI.this.mQW, i, i2);
                        e.mNP = true;
                        AppMethodBeat.o(21506);
                        return;
                    }
                    com.tencent.mm.plugin.gallery.a.a.swap(ImagePreviewUI.this.mQV, i, i2);
                    c h = ImagePreviewUI.this.mQS;
                    ab.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ImagePreviewUI.this.mQX.intValue()), Integer.valueOf(i3));
                    if (!h.mQm) {
                        com.tencent.mm.plugin.gallery.a.a.swap(h.mQl, i, i2);
                        h.mQo = i3;
                        h.mQp = (View) h.yyL.get(r0);
                        h.yyJ.remove(h.mQp);
                        h.yyK.clear();
                        h.yyL.clear();
                        h.mQq = true;
                        h.notifyDataSetChanged();
                    }
                    ImagePreviewUI.this.mQT.setCurrentItem(i3, false);
                    ((f) ImagePreviewUI.this.mQU.getAdapter()).el(i3, i3);
                    e.mNR = true;
                    AppMethodBeat.o(21506);
                }
            };
            this.mQT = (MMViewPager) findViewById(R.id.adi);
            this.mQT.setVerticalFadingEdgeEnabled(false);
            this.mQT.setHorizontalFadingEdgeEnabled(false);
            this.mQT.setOnPageChangeListener(new OnPageChangeListener() {
                public final void onPageSelected(int i) {
                    AppMethodBeat.i(21511);
                    e.wk(i);
                    String item = ImagePreviewUI.this.mQS.getItem(i);
                    ImagePreviewUI.a(ImagePreviewUI.this, i, item);
                    boolean contains = ImagePreviewUI.this.mQW.contains(item);
                    ImagePreviewUI.this.mQX = Integer.valueOf(i);
                    ImagePreviewUI.this.mRb.setImageResource(contains ? R.raw.checkbox_selected : R.raw.checkbox_unselected);
                    if (ImagePreviewUI.this.kvs) {
                        ImagePreviewUI.this.mQY.setImageResource(R.raw.radio_on);
                    } else {
                        ImagePreviewUI.this.mQY.setImageResource(R.raw.radio_off);
                    }
                    ImagePreviewUI.this.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePreviewUI.this.mQS.getCount())}));
                    e eVar = ImagePreviewUI.this.mQS.mQs;
                    if (eVar.aaF == -1) {
                        int i2 = 0;
                        while (true) {
                            if (i2 != 0) {
                                if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                                    break;
                                }
                                if (i + i2 <= i + 3) {
                                    eVar.wB(i + i2);
                                }
                                if (i - i2 >= Math.max(i - 3, 0)) {
                                    eVar.wB(i - i2);
                                }
                            } else {
                                eVar.wB(i);
                            }
                            i2++;
                        }
                    } else if (eVar.aaF > i) {
                        eVar.wB(Math.max(i - 3, 0));
                    } else if (eVar.aaF < i) {
                        eVar.wB(i + 3);
                    }
                    eVar.aaF = i;
                    ab.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = ".concat(String.valueOf(i)));
                    MediaItem NB = e.NB(item);
                    if (ImagePreviewUI.this.mRd.getVisibility() == 0 || ImagePreviewUI.this.mRe.getVisibility() == 0) {
                        ImagePreviewUI.a(ImagePreviewUI.this, item, NB);
                        ImagePreviewUI.a(ImagePreviewUI.this, NB);
                    }
                    AppMethodBeat.o(21511);
                }

                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageScrollStateChanged(int i) {
                    AppMethodBeat.i(21512);
                    if (ImagePreviewUI.this.mQS != null) {
                        ImagePreviewUI.this.mQS.mQt.onPageScrollStateChanged(i);
                    }
                    AppMethodBeat.o(21512);
                }
            });
            this.mQT.setSingleClickOverListener(new MMViewPager.e() {
                public final void bcX() {
                    AppMethodBeat.i(21513);
                    ImagePreviewUI.w(ImagePreviewUI.this);
                    AppMethodBeat.o(21513);
                }

                public final void bCN() {
                }
            });
            this.mQS = new c(this);
            ((f) this.mQU.getAdapter()).mRC = this.mQS;
            str3 = "";
            if (this.mQm) {
                c cVar = this.mQS;
                ArrayList arrayList = this.mOH;
                cVar.mOH.clear();
                cVar.mOH.addAll(arrayList);
                cVar.reset();
                cVar.notifyDataSetChanged();
                this.mQS.mQm = true;
                if (this.mQX.intValue() >= this.mOH.size()) {
                    this.mQX = Integer.valueOf(0);
                }
                if (this.mOH.size() > 0) {
                    str4 = ((MediaItem) this.mOH.get(this.mQX.intValue())).fPT;
                }
                str4 = str3;
            } else {
                this.mQS.E(this.mQV);
                this.mQS.mQm = false;
                if (this.mQV.size() > 0) {
                    str4 = (String) this.mQV.get(this.mQX.intValue());
                }
                str4 = str3;
            }
            this.mQT.setAdapter(this.mQS);
            this.mQT.setCurrentItem(this.mQX.intValue());
            ((f) this.mQU.getAdapter()).el(bCK().indexOf(this.mQS.getItem(this.mQX.intValue())), this.mQX.intValue());
            MediaItem NB = e.NB(str4);
            a(str4, NB);
            b(NB);
            setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(this.mQX.intValue() + 1), Integer.valueOf(this.mQS.getCount())}));
            AppMethodBeat.o(21534);
            return;
        }
        ab.e("MicroMsg.ImagePreviewUI", "not preview all items and imagepaths is null or empty");
        finish();
        AppMethodBeat.o(21534);
    }

    private void NE(String str) {
        AppMethodBeat.i(21535);
        if (this.mQW.contains(str)) {
            this.mRb.setImageResource(R.raw.checkbox_unselected);
            do {
            } while (this.mQW.remove(str));
            b(this.mQW.size(), this.mQX.intValue(), str, 1);
        } else if (this.mQW.size() >= this.mPA) {
            String quantityString = getResources().getQuantityString(R.plurals.m, this.mPA, new Object[]{Integer.valueOf(this.mPA)});
            if (!bo.isNullOrNil(this.mOL) && this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                quantityString = getResources().getQuantityString(R.plurals.n, this.mPA, new Object[]{Integer.valueOf(this.mPA)});
            }
            com.tencent.mm.ui.base.h.bQ(this.mController.ylL, quantityString);
            this.mRb.setImageResource(R.raw.checkbox_unselected);
        } else {
            MediaItem NB = e.NB(str);
            if (NB != null) {
                if (NB.mMimeType.equalsIgnoreCase("image/gif") && !((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().Jq(str)) {
                    com.tencent.mm.ui.base.h.bQ(this, getString(R.string.c3w));
                    AppMethodBeat.o(21535);
                    return;
                } else if (!bo.isNullOrNil(this.mOL) && this.mOL.equals("album_business_bubble_media_by_coordinate") && (NB instanceof VideoMediaItem) && ((VideoMediaItem) NB).fPW >= (this.gLP * 1000) + 500) {
                    com.tencent.mm.ui.base.h.bQ(this.mController.ylL, this.mController.ylL.getResources().getString(R.string.c4d));
                    AppMethodBeat.o(21535);
                    return;
                }
            }
            this.mQW.add(str);
            this.mRb.setImageResource(R.raw.checkbox_selected);
            b(this.mQW.size(), this.mQX.intValue(), str, 0);
        }
        Iterator it = this.mQW.iterator();
        while (it.hasNext()) {
            if (!r.amo((String) it.next())) {
                AppMethodBeat.o(21535);
                return;
            }
        }
        this.kvs = true;
        AppMethodBeat.o(21535);
    }

    public void onActivityResult(int i, int i2, final Intent intent) {
        AppMethodBeat.i(21536);
        ab.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.mQW.size() > 0) {
                NE((String) this.mQW.get(0));
            } else {
                ab.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", Integer.valueOf(this.mQW.size()));
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.mRq = true;
                String stringExtra = intent.getStringExtra("raw_photo_path");
                Iterator it = e.bCd().iterator();
                while (it.hasNext()) {
                    if (stringExtra.equals(((Bundle) it.next()).getString("raw_photo_path"))) {
                        it.remove();
                    }
                }
                e.bCd().add(intent.getBundleExtra("report_info"));
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                ab.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", stringExtra, stringExtra2);
                if (this.mQV != null) {
                    this.mQV.clear();
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.mQV.addAll(stringArrayListExtra);
                    }
                    MediaItem wz = this.mQS.wz(this.mQX.intValue());
                    if (wz == null) {
                        ab.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", this.mQX, stringExtra, stringExtra2);
                        AppMethodBeat.o(21536);
                        return;
                    }
                    wz.mOi = stringExtra;
                    wz.fPT = stringExtra2;
                    wz.lZg = stringExtra2;
                    wz.mOj = stringExtra3;
                    wz.mMimeType = "edit";
                    e.bCc().add(wz);
                    e.bBY().a(new com.tencent.mm.plugin.gallery.model.d.b() {
                        public final void NA(final String str) {
                            AppMethodBeat.i(21509);
                            new ak(ImagePreviewUI.this.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(21508);
                                    ImagePreviewUI.this.mQS.E(ImagePreviewUI.this.mQV);
                                    f fVar = (f) ImagePreviewUI.this.mQU.getAdapter();
                                    ArrayList s = ImagePreviewUI.this.mQV;
                                    fVar.mRE.clear();
                                    fVar.mRE.addAll(s);
                                    fVar.aop.notifyChanged();
                                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_select_image_list");
                                    ImagePreviewUI.this.mQW.clear();
                                    if (stringArrayListExtra != null) {
                                        ImagePreviewUI.this.mQW.addAll(stringArrayListExtra);
                                    }
                                    ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.n(ImagePreviewUI.this));
                                    ImagePreviewUI.this.mPo.setText(ImagePreviewUI.this.mController.ylL.getString(R.string.c3i) + "");
                                    if (!ImagePreviewUI.this.mQW.contains(str)) {
                                        ImagePreviewUI.this.mRb.performClick();
                                    }
                                    AppMethodBeat.o(21508);
                                }
                            });
                            e.bBY().b((com.tencent.mm.plugin.gallery.model.d.b) this);
                            AppMethodBeat.o(21509);
                        }
                    });
                    e.bBY().b(stringExtra2, wz.getType(), stringExtra2, wz.mOk);
                    ab.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
            AppMethodBeat.o(21536);
            return;
        }
        if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
        AppMethodBeat.o(21536);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private String bCJ() {
        AppMethodBeat.i(21537);
        String string;
        switch (e.bBZ().hOZ) {
            case 4:
            case 8:
            case 13:
            case 14:
                if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(R.string.c3k);
                    AppMethodBeat.o(21537);
                    return string;
                }
                string = getString(R.string.c3k) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                AppMethodBeat.o(21537);
                return string;
            case 7:
                if (bo.isNullOrNil(this.mOL) || !this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                    if (this.mQW.size() == 0 || this.mPA <= 1) {
                        string = getString(R.string.c3k);
                        AppMethodBeat.o(21537);
                        return string;
                    }
                    string = getString(R.string.c3k) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                    AppMethodBeat.o(21537);
                    return string;
                } else if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(R.string.s1);
                    AppMethodBeat.o(21537);
                    return string;
                } else {
                    string = getString(R.string.s1) + "(" + this.mQW.size() + "/" + this.mPA + ")";
                    AppMethodBeat.o(21537);
                    return string;
                }
            case 11:
                string = getString(R.string.bcc);
                AppMethodBeat.o(21537);
                return string;
            default:
                if (this.mQW.size() == 0 || this.mPA <= 1) {
                    string = getString(R.string.tf);
                    AppMethodBeat.o(21537);
                    return string;
                }
                string = getString(R.string.c3c, new Object[]{Integer.valueOf(this.mQW.size()), Integer.valueOf(this.mPA)});
                AppMethodBeat.o(21537);
                return string;
        }
    }

    private ArrayList<String> bCK() {
        AppMethodBeat.i(21538);
        if (this.mQm) {
            ArrayList arrayList = this.mQW;
            AppMethodBeat.o(21538);
            return arrayList;
        }
        ArrayList<String> arrayList2 = new ArrayList(this.mQW.size());
        Iterator it = this.mQV.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mQW.contains(str)) {
                arrayList2.add(str);
            }
        }
        AppMethodBeat.o(21538);
        return arrayList2;
    }

    private void hF(boolean z) {
        AppMethodBeat.i(21539);
        if (e.bBZ().hOZ == 4) {
            AppMethodBeat.o(21539);
        } else if (this.mQS == null) {
            ab.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
            AppMethodBeat.o(21539);
        } else {
            final MediaItem wz = this.mQS.wz(this.mQX.intValue());
            if (!z || wz == null) {
                this.mRn.setVisibility(8);
                AppMethodBeat.o(21539);
                return;
            }
            this.mRn.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21515);
                    ImagePreviewUI.a(ImagePreviewUI.this, wz);
                    AppMethodBeat.o(21515);
                }
            }, 400);
            AppMethodBeat.o(21539);
        }
    }

    private void hG(boolean z) {
        View findViewById;
        AppMethodBeat.i(21540);
        ab.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.mRf);
        if (this.mRf) {
            findViewById = findViewById(R.id.b75);
        } else {
            findViewById = findViewById(R.id.cig);
        }
        if (findViewById == null) {
            String str = "MicroMsg.ImagePreviewUI";
            String str2 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            objArr[0] = this.mRf ? "normal" : "edit_tips";
            objArr[1] = Boolean.valueOf(z);
            ab.w(str, str2, objArr);
            AppMethodBeat.o(21540);
        } else if (!(z && findViewById.getVisibility() == 0) && (z || findViewById.getVisibility() != 8)) {
            if (z) {
                findViewById.setVisibility(0);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.b5));
            } else {
                findViewById.setVisibility(8);
                findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.anim.b6));
            }
            if (z && this.mQU.getVisibility() == 8 && this.mQW.size() > 0) {
                this.mQU.setVisibility(0);
                this.mQU.startAnimation(AnimationUtils.loadAnimation(this, R.anim.b5));
                AppMethodBeat.o(21540);
                return;
            }
            if (!z && this.mQU.getVisibility() == 0) {
                this.mQU.setVisibility(8);
                this.mQU.startAnimation(AnimationUtils.loadAnimation(this, R.anim.b6));
            }
            AppMethodBeat.o(21540);
        } else {
            AppMethodBeat.o(21540);
        }
    }

    private void goBack() {
        boolean z = true;
        AppMethodBeat.i(21541);
        Intent intent = new Intent();
        boolean z2 = !this.kvs;
        String str = "CropImage_Compress_Img";
        if (!this.mPu) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", bCK());
        intent.putExtra("show_photo_edit_tip", this.mRq);
        setResult(0, intent);
        finish();
        AppMethodBeat.o(21541);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21542);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(21542);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(21542);
        return onKeyDown;
    }

    public void onDestroy() {
        AppMethodBeat.i(21543);
        super.onDestroy();
        if (e.bBZ().hOZ == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            ab.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            com.tencent.mm.api.s.ccQ.Ae().Ad();
        }
        if (this.mQS != null) {
            this.mQS.release();
        }
        e.B(null);
        unbindService(this.ktl);
        AppMethodBeat.o(21543);
    }

    private void a(String str, MediaItem mediaItem) {
        AppMethodBeat.i(21544);
        if (mediaItem != null && mediaItem.getType() == 2 && (e.bBZ().hOZ == 4 || e.bBZ().hOZ == 14 || e.bBZ().hOZ == 13)) {
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.mRj.setVisibility(8);
            } else {
                this.mRj.setVisibility(0);
            }
            NF(str);
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.mRf = false;
            this.mRd.setVisibility(8);
            this.mRe.setVisibility(0);
            this.mRo.setVisibility(8);
            if (NG(str)) {
                AppMethodBeat.o(21544);
                return;
            } else if (bo.isNullOrNil(videoMediaItem.fPU)) {
                enableOptionMenu(false);
                this.mRf = true;
                this.mRd.setVisibility(0);
                this.mRe.setVisibility(8);
                this.mQZ.setVisibility(8);
                b(str, mediaItem);
                NI(str);
                m mVar = new m(str, this.mQX.intValue(), videoMediaItem, new m.a() {
                    public final void a(m mVar) {
                        AppMethodBeat.i(21516);
                        if (mVar.position != ImagePreviewUI.this.mQX.intValue()) {
                            AppMethodBeat.o(21516);
                            return;
                        }
                        ImagePreviewUI.a(ImagePreviewUI.this, mVar.path, mVar.mOA);
                        AppMethodBeat.o(21516);
                    }
                });
                if (com.tencent.mm.sdk.g.d.xDG.ao(mVar)) {
                    ab.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", str);
                    AppMethodBeat.o(21544);
                    return;
                }
                com.tencent.mm.sdk.g.d.post(mVar, "video_analysis");
                AppMethodBeat.o(21544);
                return;
            } else {
                ab.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.fPT, Integer.valueOf(videoMediaItem.fPW), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                a(str, videoMediaItem);
                AppMethodBeat.o(21544);
                return;
            }
        }
        this.mRf = true;
        this.mRd.setVisibility(0);
        this.mRe.setVisibility(8);
        this.mRp.setVisibility(8);
        b(str, mediaItem);
        NI(str);
        enableOptionMenu(true);
        this.mQZ.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            ab.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", Integer.valueOf(e.bBZ().hOZ), Boolean.valueOf(booleanExtra), str);
            if (mediaItem != null || bo.isNullOrNil(str)) {
                this.mRj.setVisibility(8);
            } else {
                this.mRj.setVisibility(0);
            }
        } else {
            this.mRj.setVisibility(0);
        }
        NF(str);
        AppMethodBeat.o(21544);
    }

    private void NF(String str) {
        AppMethodBeat.i(21545);
        if (this.mQW.size() < 9 || this.mQW.contains(str)) {
            this.mRj.setEnabled(true);
            this.mRj.setTextColor(this.mController.ylL.getResources().getColor(R.color.a6a));
            AppMethodBeat.o(21545);
            return;
        }
        this.mRj.setTextColor(this.mController.ylL.getResources().getColor(R.color.a6b));
        this.mRj.setEnabled(false);
        AppMethodBeat.o(21545);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        AppMethodBeat.i(21546);
        enableOptionMenu(false);
        this.mRf = false;
        this.mRd.setVisibility(8);
        this.mRe.setVisibility(0);
        this.mRo.setVisibility(8);
        if (e.bBZ().hOZ == 13) {
            this.mRe.setVisibility(8);
            this.mRd.setVisibility(8);
            this.mRk.setVisibility(8);
            this.mRl.setVisibility(8);
            enableOptionMenu(true);
            AppMethodBeat.o(21546);
        } else if (b(videoMediaItem)) {
            AppMethodBeat.o(21546);
        } else if (c(videoMediaItem)) {
            AppMethodBeat.o(21546);
        } else if (a(videoMediaItem)) {
            AppMethodBeat.o(21546);
        } else {
            enableOptionMenu(true);
            this.mRf = true;
            this.mRd.setVisibility(0);
            this.mRe.setVisibility(8);
            this.mQZ.setVisibility(0);
            this.mRp.setVisibility(8);
            b(str, (MediaItem) videoMediaItem);
            NI(str);
            AppMethodBeat.o(21546);
        }
    }

    private void b(MediaItem mediaItem) {
        AppMethodBeat.i(21547);
        if (mediaItem == null) {
            ab.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
            AppMethodBeat.o(21547);
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            this.mRr = 300000;
            this.mRs = getString(R.string.c3r);
            if (this.mOL != null && this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                this.mRr = (this.gLP * 1000) + 500;
                this.mRs = getString(R.string.c4d, new Object[]{Integer.valueOf(this.gLP)});
            }
            if (bo.isNullOrNil(videoMediaItem.fPU)) {
                m mVar = new m(mediaItem.fPT, this.mQX.intValue(), videoMediaItem, new m.a() {
                    public final void a(m mVar) {
                        AppMethodBeat.i(21517);
                        if (mVar.position != ImagePreviewUI.this.mQX.intValue()) {
                            AppMethodBeat.o(21517);
                            return;
                        }
                        if (mVar.mOA.fPW >= ImagePreviewUI.this.mRr || (mVar.mOA.fPW > 0 && mVar.mOA.fPW < 1000)) {
                            ImagePreviewUI.this.mRn.setVisibility(0);
                            ImagePreviewUI.this.mRm.setText(mVar.mOA.fPW >= ImagePreviewUI.this.mRr ? ImagePreviewUI.this.mRs : ImagePreviewUI.this.getString(R.string.c3t));
                            ImagePreviewUI.this.mRc.setEnabled(false);
                            ImagePreviewUI.this.mRb.setEnabled(false);
                            ImagePreviewUI.this.mRc.setTextColor(ImagePreviewUI.this.getResources().getColor(R.color.a6b));
                            if (ImagePreviewUI.this.mQW.size() == 0) {
                                ImagePreviewUI.this.enableOptionMenu(false);
                                AppMethodBeat.o(21517);
                                return;
                            }
                        }
                        ImagePreviewUI.this.mRc.setEnabled(true);
                        ImagePreviewUI.this.mRb.setEnabled(true);
                        ImagePreviewUI.this.mRc.setTextColor(ImagePreviewUI.this.getResources().getColor(R.color.a6a));
                        ImagePreviewUI.this.mRn.setVisibility(8);
                        AppMethodBeat.o(21517);
                    }
                });
                if (com.tencent.mm.sdk.g.d.xDG.ao(mVar)) {
                    ab.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", mediaItem.fPT);
                    AppMethodBeat.o(21547);
                    return;
                }
                com.tencent.mm.sdk.g.d.post(mVar, "video_analysis");
            } else {
                ab.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.fPT, Integer.valueOf(videoMediaItem.fPW), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                if (videoMediaItem.fPW >= this.mRr || (videoMediaItem.fPW > 0 && videoMediaItem.fPW < 1000)) {
                    this.mRn.setVisibility(0);
                    this.mRm.setText(videoMediaItem.fPW >= this.mRr ? this.mRs : getString(R.string.c3t));
                    this.mRc.setEnabled(false);
                    this.mRb.setEnabled(false);
                    this.mRc.setTextColor(getResources().getColor(R.color.a6b));
                    if (this.mQW.size() == 0) {
                        enableOptionMenu(false);
                        AppMethodBeat.o(21547);
                        return;
                    }
                }
                this.mRc.setEnabled(true);
                this.mRb.setEnabled(true);
                this.mRc.setTextColor(getResources().getColor(R.color.a6a));
                this.mRn.setVisibility(8);
                AppMethodBeat.o(21547);
                return;
            }
            AppMethodBeat.o(21547);
        } else if (mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                f fVar = new f(mediaItem.fPT);
                long asZ = com.tencent.mm.vfs.e.asZ(mediaItem.fPT);
                try {
                    if ((!this.mQW.contains(mediaItem.fPT) || asZ == 0 || asZ <= ((long) this.mOG.Nb())) && fVar.noD[0] <= this.mOG.Na() && fVar.noD[1] <= this.mOG.Na()) {
                        this.mRc.setTextColor(getResources().getColor(R.color.a6a));
                        this.mRc.setEnabled(true);
                        this.mRb.setEnabled(true);
                        AppMethodBeat.o(21547);
                        return;
                    }
                    this.mRc.setTextColor(getResources().getColor(R.color.a6b));
                    this.mRc.setEnabled(false);
                    this.mRb.setEnabled(false);
                    AppMethodBeat.o(21547);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.ImagePreviewUI", bo.l(e));
                }
            }
            AppMethodBeat.o(21547);
        } else {
            this.mRc.setEnabled(true);
            this.mRb.setEnabled(true);
            this.mRc.setTextColor(getResources().getColor(R.color.a6a));
            if (this.kvs && this.mQW.contains(mediaItem.fPT) && com.tencent.mm.vfs.e.asZ(mediaItem.fPT) > 26214400) {
                this.mRn.setVisibility(0);
                this.mRm.setText(getString(R.string.c3y));
                AppMethodBeat.o(21547);
                return;
            }
            this.mRn.setVisibility(8);
            AppMethodBeat.o(21547);
        }
    }

    private boolean NG(String str) {
        AppMethodBeat.i(21548);
        if (com.tencent.mm.vfs.e.asZ(str) > 1073741824) {
            this.mRk.setText(getString(R.string.c3q));
            this.mRl.setText(getString(R.string.c3p));
            AppMethodBeat.o(21548);
            return true;
        }
        AppMethodBeat.o(21548);
        return false;
    }

    private boolean a(VideoMediaItem videoMediaItem) {
        AppMethodBeat.i(21549);
        ab.d("MicroMsg.ImagePreviewUI", "check duration %d", Integer.valueOf(videoMediaItem.fPW));
        if (e.bBZ().hOZ == 13) {
            AppMethodBeat.o(21549);
            return false;
        } else if (videoMediaItem.fPW <= 1000) {
            this.mRk.setText(getString(R.string.c3u));
            this.mRl.setText(getString(R.string.c3t));
            AppMethodBeat.o(21549);
            return true;
        } else if (videoMediaItem.fPW >= 300000) {
            this.mRk.setText(getString(R.string.c3s));
            this.mRl.setText(getString(R.string.c3r));
            AppMethodBeat.o(21549);
            return true;
        } else if (videoMediaItem.fPW >= (this.mRi * 1000) + 500) {
            this.mRk.setText(getString(R.string.c3h));
            this.mRl.setText(getString(R.string.c3g, new Object[]{Integer.valueOf(this.mRi)}));
            this.mRo.setVisibility(0);
            AppMethodBeat.o(21549);
            return true;
        } else {
            AppMethodBeat.o(21549);
            return false;
        }
    }

    private boolean bCL() {
        AppMethodBeat.i(21550);
        this.mRk.setText(getString(R.string.c3l));
        this.mRl.setText(getString(R.string.c3m));
        AppMethodBeat.o(21550);
        return true;
    }

    private boolean b(VideoMediaItem videoMediaItem) {
        AppMethodBeat.i(21551);
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.3f) {
            if (videoMediaItem != null) {
                ab.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight));
            }
            this.mRk.setText(getString(R.string.c3n));
            this.mRl.setText(getString(R.string.c3o));
            AppMethodBeat.o(21551);
            return true;
        }
        AppMethodBeat.o(21551);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(VideoMediaItem videoMediaItem) {
        int i;
        String str;
        String str2;
        Object[] objArr;
        AppMethodBeat.i(21552);
        ab.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", videoMediaItem);
        if (videoMediaItem != null) {
            if ("video/hevc".equalsIgnoreCase(videoMediaItem.fPU) && com.tencent.mm.plugin.n.e.bOS()) {
                i = 1;
                if (videoMediaItem != null) {
                }
                str = "MicroMsg.ImagePreviewUI";
                str2 = "check video format failed, dst format [video/avc], video format [%s]";
                objArr = new Object[1];
                if (videoMediaItem == null) {
                }
                objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
                ab.d(str, str2, objArr);
                bCL();
                AppMethodBeat.o(21552);
                return true;
            } else if ("video/avc".equalsIgnoreCase(videoMediaItem.fPU)) {
                i = 1;
                if (videoMediaItem != null || bo.isNullOrNil(videoMediaItem.fPT) || NH(videoMediaItem.fPT) || i == 0 || !(bo.isNullOrNil(videoMediaItem.fPV) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.fPV))) {
                    str = "MicroMsg.ImagePreviewUI";
                    str2 = "check video format failed, dst format [video/avc], video format [%s]";
                    objArr = new Object[1];
                    objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
                    ab.d(str, str2, objArr);
                    bCL();
                    AppMethodBeat.o(21552);
                    return true;
                }
                AppMethodBeat.o(21552);
                return false;
            }
        }
        i = 0;
        if (videoMediaItem != null) {
        }
        str = "MicroMsg.ImagePreviewUI";
        str2 = "check video format failed, dst format [video/avc], video format [%s]";
        objArr = new Object[1];
        if (videoMediaItem == null) {
        }
        objArr[0] = videoMediaItem == null ? null : videoMediaItem.fPU;
        ab.d(str, str2, objArr);
        bCL();
        AppMethodBeat.o(21552);
        return true;
    }

    private boolean NH(String str) {
        AppMethodBeat.i(21553);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(21553);
            return true;
        }
        if (this.mRt == null) {
            this.mRt = new HashSet();
            this.mRt.add(".h264");
            this.mRt.add(".h26l");
            this.mRt.add(".264");
            this.mRt.add(".avc");
            this.mRt.add(".mov");
            this.mRt.add(VideoMaterialUtil.MP4_SUFFIX);
            this.mRt.add(MediaConfig.VIDEO_AAC_FILE_POSTFIX);
            this.mRt.add(".3gp");
            this.mRt.add(".3g2");
            this.mRt.add(".mj2");
            this.mRt.add(".m4v");
        }
        String trim = str.trim();
        int lastIndexOf = trim.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= trim.length()) {
            AppMethodBeat.o(21553);
            return true;
        } else if (this.mRt.contains(trim.substring(lastIndexOf))) {
            AppMethodBeat.o(21553);
            return false;
        } else {
            AppMethodBeat.o(21553);
            return true;
        }
    }

    private void b(String str, MediaItem mediaItem) {
        AppMethodBeat.i(21554);
        if (mediaItem != null && mediaItem.getType() == 2 && e.bBZ().hOZ == 4) {
            this.mRb.setVisibility(8);
            this.mRc.setVisibility(8);
            AppMethodBeat.o(21554);
            return;
        }
        if (this.mPA == 1) {
            this.mRb.setVisibility(8);
            this.mRc.setVisibility(8);
        } else {
            this.mRb.setVisibility(0);
            this.mRc.setVisibility(0);
        }
        if (this.mQW.contains(str)) {
            this.mRb.setImageResource(R.raw.checkbox_selected);
            AppMethodBeat.o(21554);
            return;
        }
        this.mRb.setImageResource(R.raw.checkbox_unselected);
        AppMethodBeat.o(21554);
    }

    private void NI(String str) {
        AppMethodBeat.i(21555);
        Boolean bool = Boolean.FALSE;
        switch (e.bBZ().hOZ) {
            case 4:
            case 7:
            case 13:
            case 14:
                bool = Boolean.TRUE;
                break;
            default:
                bool = Boolean.FALSE;
                break;
        }
        MediaItem NB = e.NB(str);
        if (NB != null && NB.getType() == 2) {
            bool = Boolean.TRUE;
        }
        if (NB == null && r.amo(str)) {
            bool = Boolean.TRUE;
        } else if (NB != null && NB.mMimeType.equalsIgnoreCase("image/gif")) {
            bool = Boolean.TRUE;
        }
        if (bool.booleanValue()) {
            this.mQY.setVisibility(8);
            this.mPo.setVisibility(8);
            AppMethodBeat.o(21555);
            return;
        }
        this.mQY.setVisibility(0);
        this.mPo.setVisibility(0);
        AppMethodBeat.o(21555);
    }

    private void b(int i, int i2, String str, int i3) {
        AppMethodBeat.i(21556);
        ab.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (-1 != i2 && !this.mQm) {
            this.mQU.getAdapter().b(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((f) this.mQU.getAdapter()).addItem(str);
                ((f) this.mQU.getAdapter()).el(i - 1, this.mQX.intValue());
                this.mQU.getAdapter().ch(i - 1);
                this.mQU.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((f) this.mQU.getAdapter()).indexOf(str);
                if (-1 != indexOf) {
                    ((f) this.mQU.getAdapter()).remove(indexOf);
                    this.mQU.getAdapter().ci(indexOf);
                }
            }
        }
        int i4;
        if (e.bBZ().hOZ == 13) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        MediaItem wz = this.mQS.wz(this.mQX.intValue());
        if (i == 0 || ((this.mPu || i4 != 0) && this.mQS != null && wz != null && wz.getType() == 2)) {
            this.mQU.setVisibility(8);
            AppMethodBeat.o(21556);
            return;
        }
        this.mQU.setVisibility(0);
        AppMethodBeat.o(21556);
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        AppMethodBeat.i(21562);
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList bCK = imagePreviewUI.bCK();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bCK == null || bCK.size() <= 0) {
            ab.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            AppMethodBeat.o(21562);
            return;
        }
        Iterator it = bCK.iterator();
        while (it.hasNext()) {
            Object obj = (String) it.next();
            MediaItem NB = e.NB(obj);
            if (NB == null || NB.getType() != 2) {
                if (!(NB == null || NB.getType() == 2 || !NB.mMimeType.equals("edit") || bo.isNullOrNil(NB.mOj))) {
                    obj = NB.mOj;
                }
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        int i = e.bBZ().hOZ == 14 ? 1 : 0;
        if ((z || i != 0) && arrayList.size() == 0 && arrayList2.size() == 1) {
            MediaItem NB2 = e.NB((String) arrayList2.get(0));
            if (NB2 == null || !(NB2 instanceof VideoMediaItem) || ((VideoMediaItem) NB2).fPW == -1) {
                ab.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", NB2.fPT);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", NB2.lZg);
                if (z) {
                    d.b((Context) imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                    AppMethodBeat.o(21562);
                    return;
                }
                imagePreviewUI.setResult(-1, intent2);
                imagePreviewUI.finish();
                AppMethodBeat.o(21562);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.bCK().size() > 0) {
            LatLongData ami = ExifHelper.ami((String) imagePreviewUI.bCK().get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            ab.d("MicroMsg.ImagePreviewUI", "findlatlng %s", r0);
            if (ami != null) {
                ab.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", Float.valueOf(ami.cEB), Float.valueOf(ami.fFz));
                intent3.putExtra("KlatLng", ami);
            }
        }
        ab.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", Integer.valueOf(e.bCg()), Boolean.valueOf(imagePreviewUI.mPu), Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            imagePreviewUI.mOG.aK(11610, (imagePreviewUI.mPu ? 3 : 2) + "," + e.bCg());
        } catch (Exception e) {
            ab.e("MicroMsg.ImagePreviewUI", "report error, %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        e.bCf();
        ab.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (bo.isNullOrNil(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
            AppMethodBeat.o(21562);
        } else if (bo.yz() - imagePreviewUI.mPF < 1000) {
            ab.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
            AppMethodBeat.o(21562);
        } else {
            imagePreviewUI.mPF = bo.yz();
            ab.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
            AppMethodBeat.o(21562);
        }
    }

    static /* synthetic */ void o(ImagePreviewUI imagePreviewUI) {
        String str;
        AppMethodBeat.i(21564);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        ab.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", imagePreviewUI.mQS.getItem(imagePreviewUI.mQX.intValue()), imagePreviewUI.mQX);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", e.bBZ().hOZ);
        intent.putExtra("preview_image_list", ((f) imagePreviewUI.mQU.getAdapter()).mRE);
        if (e.bBZ().hOZ == 4) {
            intent.putExtra("from_scene", com.tencent.view.d.MIC_PTU_ZIRAN);
        } else if (e.bBZ().hOZ == 3) {
            intent.putExtra("from_scene", 290);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.mQW);
        MediaItem wz = imagePreviewUI.mQS.wz(imagePreviewUI.mQX.intValue());
        if (wz != null) {
            ab.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", wz.mOi, wz.fPT);
            str = wz.mOi;
            if (bo.isNullOrNil(str)) {
                str = wz.fPT;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", wz.fPT);
            }
        } else {
            ab.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", imagePreviewUI.mQX);
            str = imagePreviewUI.mQS.getItem(imagePreviewUI.mQX.intValue());
            wz = MediaItem.a(1, (long) imagePreviewUI.mQX.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(wz);
            e.B(arrayList);
        }
        intent.putExtra("raw_photo_path", str);
        intent.setClass(imagePreviewUI, MMNewPhotoEditUI.class);
        imagePreviewUI.startActivityForResult(intent, 4372);
        AppMethodBeat.o(21564);
    }

    static /* synthetic */ void w(ImagePreviewUI imagePreviewUI) {
        AppMethodBeat.i(21568);
        if (imagePreviewUI.mRa == null || imagePreviewUI.mRa.doT()) {
            imagePreviewUI.mRa = new ap(new ap.a() {
                public final boolean BI() {
                    boolean z;
                    AppMethodBeat.i(21514);
                    ImagePreviewUI imagePreviewUI = ImagePreviewUI.this;
                    if (ImagePreviewUI.this.mRg) {
                        z = false;
                    } else {
                        z = true;
                    }
                    imagePreviewUI.mRg = z;
                    ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.mRg);
                    AppMethodBeat.o(21514);
                    return false;
                }
            }, false);
            imagePreviewUI.mRa.ae(350, 350);
            AppMethodBeat.o(21568);
            return;
        }
        imagePreviewUI.mRa.stopTimer();
        AppMethodBeat.o(21568);
    }
}
