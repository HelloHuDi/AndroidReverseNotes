package com.tencent.p177mm.plugin.card.p355ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery;
import com.tencent.p177mm.p612ui.tools.MMGestureGallery.C30745f;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.card.model.CardGiftInfo;
import com.tencent.p177mm.plugin.card.p931d.C20130a;
import com.tencent.p177mm.plugin.card.p931d.C20130a.C20132a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI */
public class CardGiftImageUI extends MMActivity implements C20132a {
    private C46696j icA;
    private String imgPath;
    private Bundle jWy;
    private boolean jYD = false;
    private C30759e jYE;
    private CardGiftInfo kkk;
    private ImageView kkl;
    private RelativeLayout kkm;
    private MMGestureGallery kkn;
    private ProgressBar kko;
    private C7306ak kkp = new C7306ak(Looper.getMainLooper());
    private int kkq = 0;
    private int kkr = 0;
    private int kks = 0;
    private int kkt = 0;
    private C2769a kku;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$6 */
    class C27666 implements C24051b {

        /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$6$1 */
        class C27671 implements Runnable {
            C27671() {
            }

            public final void run() {
                AppMethodBeat.m2504i(88398);
                CardGiftImageUI.this.finish();
                CardGiftImageUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(88398);
            }
        }

        C27666() {
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(88399);
            new C7306ak().post(new C27671());
            AppMethodBeat.m2505o(88399);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$7 */
    class C27687 implements Runnable {
        C27687() {
        }

        public final void run() {
            AppMethodBeat.m2504i(88400);
            if (CardGiftImageUI.this.kko.getVisibility() != 0) {
                CardGiftImageUI.this.kko.setVisibility(0);
            }
            AppMethodBeat.m2505o(88400);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$a */
    class C2769a extends BaseAdapter {
        private C2769a() {
        }

        /* synthetic */ C2769a(CardGiftImageUI cardGiftImageUI, byte b) {
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
            AppMethodBeat.m2504i(88402);
            Bitmap vv = C18764x.m29333vv(CardGiftImageUI.this.imgPath);
            if (vv == null) {
                C4990ab.m7420w("MicroMsg.CardGiftImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), 2130968942, null);
                    ((ImageView) view.findViewById(2131822184)).setImageResource(C1318a.download_image_icon);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                }
                AppMethodBeat.m2505o(88402);
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, vv.getWidth(), vv.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.mo71980bW(vv.getWidth(), vv.getHeight());
                }
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(vv);
                view.setMaxZoomDoubleTab(true);
                AppMethodBeat.m2505o(88402);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$5 */
    class C201635 implements OnPreDrawListener {
        C201635() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(88397);
            CardGiftImageUI.this.kkm.getViewTreeObserver().removeOnPreDrawListener(this);
            CardGiftImageUI.this.jYE.mo49166a(CardGiftImageUI.this.kkm, CardGiftImageUI.this.kkl, null);
            AppMethodBeat.m2505o(88397);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$1 */
    class C367481 implements C30745f {
        C367481() {
        }

        public final void bcX() {
            AppMethodBeat.m2504i(88393);
            CardGiftImageUI.this.bcW();
            AppMethodBeat.m2505o(88393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$3 */
    class C387583 implements C36073c {
        C387583() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(88395);
            c44273l.mo70068e(0, CardGiftImageUI.this.getString(C25738R.string.dwz));
            AppMethodBeat.m2505o(88395);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$2 */
    class C457922 implements OnItemLongClickListener {
        C457922() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(88394);
            C30379h.m48455a(CardGiftImageUI.this, CardGiftImageUI.this.icA.cuu());
            AppMethodBeat.m2505o(88394);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardGiftImageUI$4 */
    class C457934 implements C5279d {
        C457934() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(88396);
            switch (menuItem.getItemId()) {
                case 0:
                    C14987n.m23321j(CardGiftImageUI.this.imgPath, CardGiftImageUI.this);
                    break;
            }
            AppMethodBeat.m2505o(88396);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardGiftImageUI() {
        AppMethodBeat.m2504i(88403);
        AppMethodBeat.m2505o(88403);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(88404);
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
        C4990ab.m7411d(str2, str3, objArr);
        C4990ab.m7417i("MicroMsg.CardGiftImageUI", "imgPath:%s", this.imgPath);
        initView();
        C20130a.m31138a(this);
        if (this.kkk == null || C5046bo.isNullOrNil(this.kkk.kcn)) {
            C4990ab.m7412e("MicroMsg.CardGiftImageUI", "fromUserContentPicUrl is null");
            AppMethodBeat.m2505o(88404);
            return;
        }
        C20130a.m31140g(this.kkk.kcn, this.kkk.kcq, this.kkk.kcz, 2);
        AppMethodBeat.m2505o(88404);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88405);
        this.kkl = (ImageView) findViewById(2131822079);
        this.kkl.setLayerType(2, null);
        this.kko = (ProgressBar) findViewById(2131822082);
        this.kkm = (RelativeLayout) findViewById(2131822080);
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.kku = new C2769a(this, (byte) 0);
        this.kkn.setAdapter(this.kku);
        this.kkn.setSingleClickOverListener(new C367481());
        this.kkn.setOnItemLongClickListener(new C457922());
        this.jYE = new C30759e(this);
        AppMethodBeat.m2505o(88405);
    }

    public void onStart() {
        AppMethodBeat.m2504i(88406);
        Bundle bundle = this.jWy;
        if (!this.jYD) {
            this.jYD = true;
            if (VERSION.SDK_INT < 12) {
                C4990ab.m7413e("MicroMsg.CardGiftImageUI", "version is %d, no animation", Integer.valueOf(VERSION.SDK_INT));
            } else {
                this.kkq = getIntent().getIntExtra("img_top", 0);
                this.kkr = getIntent().getIntExtra("img_left", 0);
                this.kks = getIntent().getIntExtra("img_width", 0);
                this.kkt = getIntent().getIntExtra("img_height", 0);
                this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
                if (bundle == null) {
                    this.kkm.getViewTreeObserver().addOnPreDrawListener(new C201635());
                }
            }
        }
        super.onStart();
        AppMethodBeat.m2505o(88406);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88407);
        super.onResume();
        if (this.kku != null) {
            this.kku.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(88407);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88408);
        super.onPause();
        AppMethodBeat.m2505o(88408);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88409);
        super.onDestroy();
        C20130a.m31139b(this);
        AppMethodBeat.m2505o(88409);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88410);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            C4990ab.m7410d("MicroMsg.CardGiftImageUI", "dispatchKeyEvent");
            bcW();
            AppMethodBeat.m2505o(88410);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(88410);
        return dispatchKeyEvent;
    }

    public final void bcW() {
        AppMethodBeat.m2504i(88411);
        this.jYE.mo49164L(this.kkr, this.kkq, this.kks, this.kkt);
        this.jYE.mo49167a(this.kkm, this.kkl, new C27666(), null);
        AppMethodBeat.m2505o(88411);
    }

    public final int getLayoutId() {
        return 2130968923;
    }

    /* renamed from: bN */
    public final void mo23013bN(String str, int i) {
        AppMethodBeat.m2504i(88412);
        this.kkp.post(new C27687());
        AppMethodBeat.m2505o(88412);
    }

    /* renamed from: GS */
    public final void mo23012GS(String str) {
    }

    /* renamed from: dr */
    public final void mo23014dr(String str, final String str2) {
        AppMethodBeat.m2504i(88413);
        this.kkp.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(88401);
                if (CardGiftImageUI.this.kko.getVisibility() != 8) {
                    CardGiftImageUI.this.kko.setVisibility(8);
                }
                CardGiftImageUI.this.imgPath = str2;
                CardGiftImageUI.m84678g(CardGiftImageUI.this);
                CardGiftImageUI.this.kku.notifyDataSetChanged();
                AppMethodBeat.m2505o(88401);
            }
        });
        AppMethodBeat.m2505o(88413);
    }

    /* renamed from: g */
    static /* synthetic */ void m84678g(CardGiftImageUI cardGiftImageUI) {
        AppMethodBeat.m2504i(88414);
        cardGiftImageUI.icA = new C46696j(cardGiftImageUI);
        cardGiftImageUI.icA.rBl = new C387583();
        cardGiftImageUI.icA.rBm = new C457934();
        AppMethodBeat.m2505o(88414);
    }
}
