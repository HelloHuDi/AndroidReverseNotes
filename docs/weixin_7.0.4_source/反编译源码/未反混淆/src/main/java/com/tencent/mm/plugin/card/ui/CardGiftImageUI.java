package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.e.b;
import com.tencent.mm.ui.tools.j;

@com.tencent.mm.ui.base.a(3)
public class CardGiftImageUI extends MMActivity implements com.tencent.mm.plugin.card.d.a.a {
    private j icA;
    private String imgPath;
    private Bundle jWy;
    private boolean jYD = false;
    private e jYE;
    private CardGiftInfo kkk;
    private ImageView kkl;
    private RelativeLayout kkm;
    private MMGestureGallery kkn;
    private ProgressBar kko;
    private ak kkp = new ak(Looper.getMainLooper());
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private a kku;

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(CardGiftImageUI cardGiftImageUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(88402);
            Bitmap vv = x.vv(CardGiftImageUI.this.imgPath);
            if (vv == null) {
                ab.w("MicroMsg.CardGiftImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.layout.j7, null);
                    ((ImageView) view.findViewById(R.id.aga)).setImageResource(R.raw.download_image_icon);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                }
                AppMethodBeat.o(88402);
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, vv.getWidth(), vv.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.bW(vv.getWidth(), vv.getHeight());
                }
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(vv);
                view.setMaxZoomDoubleTab(true);
                AppMethodBeat.o(88402);
            }
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftImageUI() {
        AppMethodBeat.i(88403);
        AppMethodBeat.o(88403);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(88404);
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.jWy = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.kkk = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        String str2 = "MicroMsg.CardGiftImageUI";
        String str3 = "cardGiftInfo:%s";
        Object[] objArr = new Object[1];
        if (this.kkk == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = this.kkk.toString();
        }
        objArr[0] = str;
        ab.d(str2, str3, objArr);
        ab.i("MicroMsg.CardGiftImageUI", "imgPath:%s", this.imgPath);
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        if (this.kkk == null || bo.isNullOrNil(this.kkk.kcn)) {
            ab.e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
            AppMethodBeat.o(88404);
            return;
        }
        com.tencent.mm.plugin.card.d.a.g(this.kkk.kcn, this.kkk.kcq, this.kkk.kcz, 2);
        AppMethodBeat.o(88404);
    }

    public final void initView() {
        AppMethodBeat.i(88405);
        this.kkl = (ImageView) findViewById(R.id.adg);
        this.kkl.setLayerType(2, null);
        this.kko = (ProgressBar) findViewById(R.id.adj);
        this.kkm = (RelativeLayout) findViewById(R.id.adh);
        this.kkn = (MMGestureGallery) findViewById(R.id.adi);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kku = new a(this, (byte) 0);
        this.kkn.setAdapter(this.kku);
        this.kkn.setSingleClickOverListener(new f() {
            public final void bcX() {
                AppMethodBeat.i(88393);
                CardGiftImageUI.this.bcW();
                AppMethodBeat.o(88393);
            }
        });
        this.kkn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(88394);
                h.a(CardGiftImageUI.this, CardGiftImageUI.this.icA.cuu());
                AppMethodBeat.o(88394);
                return true;
            }
        });
        this.jYE = new e(this);
        AppMethodBeat.o(88405);
    }

    public void onStart() {
        AppMethodBeat.i(88406);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT < 12) {
                ab.e("MicroMsg.CardGiftImageUI", "version is %d, no animation", Integer.valueOf(VERSION.SDK_INT));
            } else {
                this.kkq = getIntent().getIntExtra("img_top", 0);
                this.kkr = getIntent().getIntExtra("img_left", 0);
                this.kks = getIntent().getIntExtra("img_width", 0);
                this.kkt = getIntent().getIntExtra("img_height", 0);
                this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.kkm.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(88397);
                            CardGiftImageUI.this.kkm.getViewTreeObserver().removeOnPreDrawListener(this);
                            CardGiftImageUI.this.jYE.a(CardGiftImageUI.this.kkm, CardGiftImageUI.this.kkl, null);
                            AppMethodBeat.o(88397);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(88406);
    }

    public void onResume() {
        AppMethodBeat.i(88407);
        super.onResume();
        if (this.kku != null) {
            this.kku.notifyDataSetChanged();
        }
        AppMethodBeat.o(88407);
    }

    public void onPause() {
        AppMethodBeat.i(88408);
        super.onPause();
        AppMethodBeat.o(88408);
    }

    public void onDestroy() {
        AppMethodBeat.i(88409);
        super.onDestroy();
        com.tencent.mm.plugin.card.d.a.b(this);
        AppMethodBeat.o(88409);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(88410);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.o(88410);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(88410);
        return dispatchKeyEvent;
    }

    public final void bcW() {
        AppMethodBeat.i(88411);
        this.jYE.L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.a(this.kkm, this.kkl, new b() {
            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                AppMethodBeat.i(88399);
                new ak().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(88398);
                        CardGiftImageUI.this.finish();
                        CardGiftImageUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(88398);
                    }
                });
                AppMethodBeat.o(88399);
            }
        }, null);
        AppMethodBeat.o(88411);
    }

    public final int getLayoutId() {
        return R.layout.io;
    }

    public final void bN(String str, int i) {
        AppMethodBeat.i(88412);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88400);
                if (CardGiftImageUI.this.kko.getVisibility() != 0) {
                    CardGiftImageUI.this.kko.setVisibility(0);
                }
                AppMethodBeat.o(88400);
            }
        });
        AppMethodBeat.o(88412);
    }

    public final void GS(String str) {
    }

    public final void dr(String str, final String str2) {
        AppMethodBeat.i(88413);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(88401);
                if (CardGiftImageUI.this.kko.getVisibility() != 8) {
                    CardGiftImageUI.this.kko.setVisibility(8);
                }
                CardGiftImageUI.this.imgPath = str2;
                CardGiftImageUI.g(CardGiftImageUI.this);
                CardGiftImageUI.this.kku.notifyDataSetChanged();
                AppMethodBeat.o(88401);
            }
        });
        AppMethodBeat.o(88413);
    }

    static /* synthetic */ void g(CardGiftImageUI cardGiftImageUI) {
        AppMethodBeat.i(88414);
        cardGiftImageUI.icA = new j(cardGiftImageUI);
        cardGiftImageUI.icA.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(88395);
                lVar.e(0, CardGiftImageUI.this.getString(R.string.dwz));
                AppMethodBeat.o(88395);
            }
        };
        cardGiftImageUI.icA.rBm = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(88396);
                switch (menuItem.getItemId()) {
                    case 0:
                        n.j(CardGiftImageUI.this.imgPath, CardGiftImageUI.this);
                        break;
                }
                AppMethodBeat.o(88396);
            }
        };
        AppMethodBeat.o(88414);
    }
}
