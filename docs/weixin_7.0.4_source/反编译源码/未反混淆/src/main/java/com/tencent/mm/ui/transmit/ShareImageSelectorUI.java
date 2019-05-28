package com.tencent.mm.ui.transmit;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int zKF = 1;
    private ImageView ikh;
    private View laJ;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(35248);
            ShareImageSelectorUI.this.finish();
            AppMethodBeat.o(35248);
        }
    };
    private ListView mListView;
    private String zIs;
    private a zKG;
    private Dialog zKH;
    private OnClickListener zKI = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(35247);
            ShareImageSelectorUI.a(ShareImageSelectorUI.this);
            AppMethodBeat.o(35247);
        }
    };
    private int zou = 2;

    class a extends BaseAdapter {
        public a[] zKK = new a[]{new a(R.string.b41, R.raw.share_to_friend_icon), new a(R.string.b42, R.raw.find_more_friend_photograph_icon), new a(R.string.b40, R.raw.more_my_favorite)};

        class a {
            int zKL;
            int zKM;

            public a(int i, int i2) {
                this.zKL = i;
                this.zKM = i2;
            }
        }

        a() {
            AppMethodBeat.i(35254);
            AppMethodBeat.o(35254);
        }

        public final int getCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(35255);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ShareImageSelectorUI.this.mController.ylL).inflate(R.layout.asm, null);
                bVar = new b(view);
            } else {
                bVar = (b) view.getTag();
            }
            a aVar = this.zKK[i];
            if (aVar != null) {
                bVar.zKO.setText(aVar.zKL);
                bVar.mlG.setImageResource(aVar.zKM);
            }
            AppMethodBeat.o(35255);
            return view;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.zKK[i];
        }
    }

    class b {
        MMImageView mlG;
        TextView zKO;

        public b(View view) {
            AppMethodBeat.i(35256);
            this.mlG = (MMImageView) view.findViewById(R.id.be7);
            this.zKO = (TextView) view.findViewById(R.id.ed2);
            AppMethodBeat.o(35256);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareImageSelectorUI() {
        AppMethodBeat.i(35257);
        AppMethodBeat.o(35257);
    }

    static /* synthetic */ void b(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35269);
        shareImageSelectorUI.bKc();
        AppMethodBeat.o(35269);
    }

    static /* synthetic */ void c(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35270);
        shareImageSelectorUI.dKr();
        AppMethodBeat.o(35270);
    }

    static /* synthetic */ void d(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35271);
        shareImageSelectorUI.dKs();
        AppMethodBeat.o(35271);
    }

    static /* synthetic */ void e(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35272);
        shareImageSelectorUI.dKt();
        AppMethodBeat.o(35272);
    }

    static /* synthetic */ void f(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35273);
        shareImageSelectorUI.dKu();
        AppMethodBeat.o(35273);
    }

    public final int getLayoutId() {
        return R.layout.asl;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35258);
        super.onCreate(bundle);
        aw.ZK();
        Object obj = c.Ry().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                zKF = intValue;
            }
        }
        setMMTitle((int) R.string.czi);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35249);
                ShareImageSelectorUI.b(ShareImageSelectorUI.this);
                AppMethodBeat.o(35249);
                return false;
            }
        });
        this.zou = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.zIs = getIntent().getStringExtra("intent_extra_image_path");
        this.laJ = findViewById(R.id.c6k);
        this.ikh = (ImageView) findViewById(R.id.bl);
        this.ikh.setOnClickListener(this.zKI);
        this.mListView = (ListView) findViewById(R.id.l9);
        this.zKG = new a();
        this.mListView.setAdapter(this.zKG);
        this.mListView.setOnItemClickListener(this);
        ab.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", this.zou, this.zIs);
        if (zKF == 1) {
            setTitleVisibility(8);
            this.mListView.setVisibility(8);
            this.ikh.setLayoutParams(new LayoutParams(-1, -1));
            this.ikh.setPadding(0, 0, 0, 0);
            this.ikh.setOnClickListener(null);
            this.laJ.setBackgroundColor(getResources().getColor(R.color.l_));
            dKr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap vv = x.vv(this.zIs);
        ab.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", Integer.valueOf(ExifHelper.bJ(this.zIs)));
        vv = d.b(vv, (float) r3);
        if (!(vv == null || vv.isRecycled())) {
            this.ikh.setImageBitmap(vv);
        }
        ab.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", (System.currentTimeMillis() - currentTimeMillis) + "'");
        AppMethodBeat.o(35258);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onResume() {
        AppMethodBeat.i(35259);
        super.onResume();
        if (zKF == 1 && (this.zKH == null || !this.zKH.isShowing())) {
            dKr();
        }
        AppMethodBeat.o(35259);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(35260);
        switch (i) {
            case 0:
                dKs();
                AppMethodBeat.o(35260);
                return;
            case 1:
                dKt();
                AppMethodBeat.o(35260);
                return;
            case 2:
                dKu();
                AppMethodBeat.o(35260);
                return;
            default:
                ab.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                AppMethodBeat.o(35260);
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(35261);
        ab.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
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
                    AppMethodBeat.o(35261);
                    return;
                }
                ab.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.o(35261);
                return;
            case 1002:
                if (i2 == -1) {
                    Toast.makeText(this.mController.ylL, R.string.ate, 0).show();
                    finish();
                    AppMethodBeat.o(35261);
                    return;
                }
                ab.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                AppMethodBeat.o(35261);
                return;
            default:
                ab.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                AppMethodBeat.o(35261);
                return;
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(35262);
        bKc();
        AppMethodBeat.o(35262);
    }

    private void dKr() {
        AppMethodBeat.i(35264);
        if (this.zKH == null || !this.zKH.isShowing()) {
            this.zKH = h.a(this.mController.ylL, getString(R.string.czi), new String[]{getString(R.string.b41), getString(R.string.b42), getString(R.string.b40)}, null, new h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(35252);
                    switch (i) {
                        case 0:
                            ShareImageSelectorUI.d(ShareImageSelectorUI.this);
                            AppMethodBeat.o(35252);
                            return;
                        case 1:
                            ShareImageSelectorUI.e(ShareImageSelectorUI.this);
                            AppMethodBeat.o(35252);
                            return;
                        case 2:
                            ShareImageSelectorUI.f(ShareImageSelectorUI.this);
                            break;
                    }
                    AppMethodBeat.o(35252);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(35253);
                    ShareImageSelectorUI.b(ShareImageSelectorUI.this);
                    AppMethodBeat.o(35253);
                }
            });
            AppMethodBeat.o(35264);
            return;
        }
        AppMethodBeat.o(35264);
    }

    private void dKs() {
        AppMethodBeat.i(35265);
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.znL);
        intent.putExtra("titile", getString(R.string.eq));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.zIs);
        startActivityForResult(intent, 1001);
        AppMethodBeat.o(35265);
    }

    private void dKt() {
        AppMethodBeat.i(35266);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.zIs);
        intent.putExtra("need_result", true);
        com.tencent.mm.bp.d.b(this.mController.ylL, "sns", ".ui.SnsUploadUI", intent, 1002);
        AppMethodBeat.o(35266);
    }

    private void dKu() {
        AppMethodBeat.i(35267);
        cl clVar = new cl();
        e.a(clVar, 6, this.zIs);
        clVar.cvA.activity = this;
        clVar.cvA.cvH = 52;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        com.tencent.mm.plugin.report.service.h.pYm.e(11048, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
        AppMethodBeat.o(35267);
    }

    private void bKc() {
        AppMethodBeat.i(35263);
        h.a(this.mController.ylL, getString(R.string.b3x), getString(R.string.b3z), true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(35250);
                ShareImageSelectorUI.this.finish();
                AppMethodBeat.o(35250);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(35251);
                if (ShareImageSelectorUI.zKF == 1) {
                    ShareImageSelectorUI.c(ShareImageSelectorUI.this);
                }
                AppMethodBeat.o(35251);
            }
        });
        AppMethodBeat.o(35263);
    }

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        AppMethodBeat.i(35268);
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.zIs);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
        AppMethodBeat.o(35268);
    }
}
