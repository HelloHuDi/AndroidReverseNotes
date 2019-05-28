package com.tencent.p177mm.p612ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.SelectContactUI;
import com.tencent.p177mm.p612ui.tools.ShowImageUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI */
public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int zKF = 1;
    private ImageView ikh;
    private View laJ;
    private C7306ak mHandler = new C159682();
    private ListView mListView;
    private String zIs;
    private C15961a zKG;
    private Dialog zKH;
    private OnClickListener zKI = new C159691();
    private int zou = 2;

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$3 */
    class C159603 implements OnMenuItemClickListener {
        C159603() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(35249);
            ShareImageSelectorUI.m24252b(ShareImageSelectorUI.this);
            AppMethodBeat.m2505o(35249);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$a */
    class C15961a extends BaseAdapter {
        public C15962a[] zKK = new C15962a[]{new C15962a(C25738R.string.b41, C1318a.share_to_friend_icon), new C15962a(C25738R.string.b42, C1318a.find_more_friend_photograph_icon), new C15962a(C25738R.string.b40, C1318a.more_my_favorite)};

        /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$a$a */
        class C15962a {
            int zKL;
            int zKM;

            public C15962a(int i, int i2) {
                this.zKL = i;
                this.zKM = i2;
            }
        }

        C15961a() {
            AppMethodBeat.m2504i(35254);
            AppMethodBeat.m2505o(35254);
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C15966b c15966b;
            AppMethodBeat.m2504i(35255);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ShareImageSelectorUI.this.mController.ylL).inflate(2130970665, null);
                c15966b = new C15966b(view);
            } else {
                c15966b = (C15966b) view.getTag();
            }
            C15962a c15962a = this.zKK[i];
            if (c15962a != null) {
                c15966b.zKO.setText(c15962a.zKL);
                c15966b.mlG.setImageResource(c15962a.zKM);
            }
            AppMethodBeat.m2505o(35255);
            return view;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.zKK[i];
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$5 */
    class C159635 implements DialogInterface.OnClickListener {
        C159635() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35251);
            if (ShareImageSelectorUI.zKF == 1) {
                ShareImageSelectorUI.m24253c(ShareImageSelectorUI.this);
            }
            AppMethodBeat.m2505o(35251);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$4 */
    class C159644 implements DialogInterface.OnClickListener {
        C159644() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35250);
            ShareImageSelectorUI.this.finish();
            AppMethodBeat.m2505o(35250);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$6 */
    class C159656 implements C30391c {
        C159656() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(35252);
            switch (i) {
                case 0:
                    ShareImageSelectorUI.m24254d(ShareImageSelectorUI.this);
                    AppMethodBeat.m2505o(35252);
                    return;
                case 1:
                    ShareImageSelectorUI.m24255e(ShareImageSelectorUI.this);
                    AppMethodBeat.m2505o(35252);
                    return;
                case 2:
                    ShareImageSelectorUI.m24256f(ShareImageSelectorUI.this);
                    break;
            }
            AppMethodBeat.m2505o(35252);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$b */
    class C15966b {
        MMImageView mlG;
        TextView zKO;

        public C15966b(View view) {
            AppMethodBeat.m2504i(35256);
            this.mlG = (MMImageView) view.findViewById(2131823474);
            this.zKO = (TextView) view.findViewById(2131827538);
            AppMethodBeat.m2505o(35256);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$7 */
    class C159677 implements OnCancelListener {
        C159677() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(35253);
            ShareImageSelectorUI.m24252b(ShareImageSelectorUI.this);
            AppMethodBeat.m2505o(35253);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$2 */
    class C159682 extends C7306ak {
        C159682() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(35248);
            ShareImageSelectorUI.this.finish();
            AppMethodBeat.m2505o(35248);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.ShareImageSelectorUI$1 */
    class C159691 implements OnClickListener {
        C159691() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(35247);
            ShareImageSelectorUI.m24251a(ShareImageSelectorUI.this);
            AppMethodBeat.m2505o(35247);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShareImageSelectorUI() {
        AppMethodBeat.m2504i(35257);
        AppMethodBeat.m2505o(35257);
    }

    /* renamed from: b */
    static /* synthetic */ void m24252b(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35269);
        shareImageSelectorUI.bKc();
        AppMethodBeat.m2505o(35269);
    }

    /* renamed from: c */
    static /* synthetic */ void m24253c(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35270);
        shareImageSelectorUI.dKr();
        AppMethodBeat.m2505o(35270);
    }

    /* renamed from: d */
    static /* synthetic */ void m24254d(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35271);
        shareImageSelectorUI.dKs();
        AppMethodBeat.m2505o(35271);
    }

    /* renamed from: e */
    static /* synthetic */ void m24255e(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35272);
        shareImageSelectorUI.dKt();
        AppMethodBeat.m2505o(35272);
    }

    /* renamed from: f */
    static /* synthetic */ void m24256f(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35273);
        shareImageSelectorUI.dKu();
        AppMethodBeat.m2505o(35273);
    }

    public final int getLayoutId() {
        return 2130970664;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35258);
        super.onCreate(bundle);
        C9638aw.m17190ZK();
        Object obj = C18628c.m29072Ry().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                zKF = intValue;
            }
        }
        setMMTitle((int) C25738R.string.czi);
        setBackBtn(new C159603());
        this.zou = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.zIs = getIntent().getStringExtra("intent_extra_image_path");
        this.laJ = findViewById(2131824524);
        this.ikh = (ImageView) findViewById(2131820629);
        this.ikh.setOnClickListener(this.zKI);
        this.mListView = (ListView) findViewById(2131820986);
        this.zKG = new C15961a();
        this.mListView.setAdapter(this.zKG);
        this.mListView.setOnItemClickListener(this);
        C4990ab.m7411d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", this.zou, this.zIs);
        if (zKF == 1) {
            setTitleVisibility(8);
            this.mListView.setVisibility(8);
            this.ikh.setLayoutParams(new LayoutParams(-1, -1));
            this.ikh.setPadding(0, 0, 0, 0);
            this.ikh.setOnClickListener(null);
            this.laJ.setBackgroundColor(getResources().getColor(C25738R.color.f11908l_));
            dKr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap vv = C18764x.m29333vv(this.zIs);
        C4990ab.m7411d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", Integer.valueOf(ExifHelper.m7368bJ(this.zIs)));
        vv = C5056d.m7648b(vv, (float) r3);
        if (!(vv == null || vv.isRecycled())) {
            this.ikh.setImageBitmap(vv);
        }
        C4990ab.m7411d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", (System.currentTimeMillis() - currentTimeMillis) + "'");
        AppMethodBeat.m2505o(35258);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(35259);
        super.onResume();
        if (zKF == 1 && (this.zKH == null || !this.zKH.isShowing())) {
            dKr();
        }
        AppMethodBeat.m2505o(35259);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(35260);
        switch (i) {
            case 0:
                dKs();
                AppMethodBeat.m2505o(35260);
                return;
            case 1:
                dKt();
                AppMethodBeat.m2505o(35260);
                return;
            case 2:
                dKu();
                AppMethodBeat.m2505o(35260);
                return;
            default:
                C4990ab.m7412e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                AppMethodBeat.m2505o(35260);
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(35261);
        C4990ab.m7411d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1001:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    AppMethodBeat.m2505o(35261);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.m2505o(35261);
                return;
            case 1002:
                if (i2 == -1) {
                    Toast.makeText(this.mController.ylL, C25738R.string.ate, 0).show();
                    finish();
                    AppMethodBeat.m2505o(35261);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.m2505o(35261);
                return;
            default:
                C4990ab.m7420w("MicroMsg.ShareImageSelectorUI", "unknow result");
                AppMethodBeat.m2505o(35261);
                return;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(35262);
        bKc();
        AppMethodBeat.m2505o(35262);
    }

    private void dKr() {
        AppMethodBeat.m2504i(35264);
        if (this.zKH == null || !this.zKH.isShowing()) {
            this.zKH = C30379h.m48423a(this.mController.ylL, getString(C25738R.string.czi), new String[]{getString(C25738R.string.b41), getString(C25738R.string.b42), getString(C25738R.string.b40)}, null, new C159656(), new C159677());
            AppMethodBeat.m2505o(35264);
            return;
        }
        AppMethodBeat.m2505o(35264);
    }

    private void dKs() {
        AppMethodBeat.m2504i(35265);
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", C15830s.znL);
        intent.putExtra("titile", getString(C25738R.string.f8779eq));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.zIs);
        startActivityForResult(intent, 1001);
        AppMethodBeat.m2505o(35265);
    }

    private void dKt() {
        AppMethodBeat.m2504i(35266);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.zIs);
        intent.putExtra("need_result", true);
        C25985d.m41468b(this.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 1002);
        AppMethodBeat.m2505o(35266);
    }

    private void dKu() {
        AppMethodBeat.m2504i(35267);
        C45316cl c45316cl = new C45316cl();
        C40443e.m69368a(c45316cl, 6, this.zIs);
        c45316cl.cvA.activity = this;
        c45316cl.cvA.cvH = 52;
        C4879a.xxA.mo10055m(c45316cl);
        C7060h.pYm.mo8381e(11048, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
        AppMethodBeat.m2505o(35267);
    }

    private void bKc() {
        AppMethodBeat.m2504i(35263);
        C30379h.m48449a(this.mController.ylL, getString(C25738R.string.b3x), getString(C25738R.string.b3z), true, new C159644(), new C159635());
        AppMethodBeat.m2505o(35263);
    }

    /* renamed from: a */
    static /* synthetic */ void m24251a(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.m2504i(35268);
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.zIs);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
        AppMethodBeat.m2505o(35268);
    }
}
