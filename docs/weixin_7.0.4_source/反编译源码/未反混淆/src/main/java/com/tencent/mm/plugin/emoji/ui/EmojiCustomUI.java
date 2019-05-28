package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.at.a.c.l;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;

public class EmojiCustomUI extends MMActivity implements OnItemClickListener, f {
    private static l fHy = new l() {
        public final Bitmap X(byte[] bArr) {
            AppMethodBeat.i(53316);
            Bitmap aW = i.aW(bArr);
            AppMethodBeat.o(53316);
            return aW;
        }

        public final Bitmap sI(String str) {
            AppMethodBeat.i(53317);
            Bitmap aW = i.aW(e.e(str, 0, -1));
            AppMethodBeat.o(53317);
            return aW;
        }
    };
    private static com.tencent.mm.at.a.c.d kZJ = new com.tencent.mm.at.a.c.d() {
        public final byte[] i(Object... objArr) {
            AppMethodBeat.i(53315);
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    byte[] l = com.tencent.mm.plugin.emoji.e.f.bjK().l((EmojiInfo) obj);
                    AppMethodBeat.o(53315);
                    return l;
                }
            }
            AppMethodBeat.o(53315);
            return null;
        }
    };
    private ProgressDialog gqo;
    private a kZA = a.EMPTY;
    private ArrayList<String> kZB = new ArrayList();
    private int kZC = 0;
    private EmojiSyncManager kZD;
    private OnClickListener kZE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53299);
            switch (EmojiCustomUI.this.kZA) {
                case START:
                    EmojiCustomUI.b(EmojiCustomUI.this);
                    AppMethodBeat.o(53299);
                    return;
                case PAUSE:
                    EmojiCustomUI.this.kZD.stop();
                    break;
            }
            AppMethodBeat.o(53299);
        }
    };
    private OnClickListener kZF = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53310);
            EmojiCustomUI.d(EmojiCustomUI.this);
            AppMethodBeat.o(53310);
        }
    };
    private OnClickListener kZG = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(53311);
            EmojiCustomUI.e(EmojiCustomUI.this);
            AppMethodBeat.o(53311);
        }
    };
    private final com.tencent.mm.sdk.e.k.a kZH = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(53312);
            if (!bo.isNullOrNil(str) && ((str.length() == 32 || str.equals("event_update_emoji")) && EmojiCustomUI.this.kZo != null)) {
                EmojiCustomUI.this.kZo.bly();
                EmojiCustomUI.this.kZo.notifyDataSetChanged();
            }
            AppMethodBeat.o(53312);
        }
    };
    private final com.tencent.mm.emoji.sync.c kZI = new com.tencent.mm.emoji.sync.c() {
        public final void Pi() {
            AppMethodBeat.i(53313);
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1002);
            }
            AppMethodBeat.o(53313);
        }

        public final void a(com.tencent.mm.emoji.sync.EmojiSyncManager.b bVar) {
            AppMethodBeat.i(53314);
            EmojiCustomUI.this.kZt = bVar;
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1001);
            }
            AppMethodBeat.o(53314);
        }
    };
    private EmojiInfo kZK;
    private c kZn = c.NORMAL;
    private b kZo;
    private HeaderGridView kZp;
    private View kZq;
    private Button kZr;
    private Button kZs;
    private com.tencent.mm.emoji.sync.EmojiSyncManager.b kZt = com.tencent.mm.emoji.sync.EmojiSyncManager.b.Init;
    private View kZu;
    private TextView kZv;
    private Button kZw;
    private boolean kZx = false;
    private boolean kZy = false;
    private boolean kZz = false;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(53318);
            switch (message.what) {
                case 1001:
                    EmojiCustomUI.h(EmojiCustomUI.this);
                    AppMethodBeat.o(53318);
                    return;
                case 1002:
                    if (!at.isWifi(EmojiCustomUI.this)) {
                        if (EmojiCustomUI.this.kZD.ezs == com.tencent.mm.emoji.sync.EmojiSyncManager.b.Syncing) {
                            EmojiCustomUI.a(EmojiCustomUI.this, true);
                            AppMethodBeat.o(53318);
                            return;
                        }
                        EmojiCustomUI.a(EmojiCustomUI.this, false);
                        AppMethodBeat.o(53318);
                        return;
                    }
                    break;
                case 1003:
                    EmojiCustomUI.this.kZu.setVisibility(8);
                    EmojiCustomUI.this.kZo.notifyDataSetChanged();
                    AppMethodBeat.o(53318);
                    return;
                case 1004:
                    if (EmojiCustomUI.this.kZo != null) {
                        EmojiCustomUI.this.kZo.bly();
                        EmojiCustomUI.this.kZo.notifyDataSetChanged();
                    }
                    EmojiCustomUI.blw();
                    AppMethodBeat.o(53318);
                    return;
                default:
                    ab.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                    break;
            }
            AppMethodBeat.o(53318);
        }
    };

    enum c {
        NORMAL,
        EDIT,
        SYNCING,
        WITH_OUT_ADD;

        static {
            AppMethodBeat.o(53333);
        }
    }

    static class d {
        ImageView image;
        View iym;
        CheckBox lab;

        public d(View view) {
            AppMethodBeat.i(53334);
            this.iym = view.findViewById(R.id.za);
            this.image = (ImageView) view.findViewById(R.id.bl);
            this.lab = (CheckBox) view.findViewById(R.id.bdj);
            AppMethodBeat.o(53334);
        }
    }

    class b extends BaseAdapter {
        private int ezx;
        private ArrayList<EmojiInfo> kWs;
        private Animation kZV;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(53330);
            EmojiInfo uf = uf(i);
            AppMethodBeat.o(53330);
            return uf;
        }

        public b(int i) {
            AppMethodBeat.i(53322);
            this.ezx = i;
            this.kZV = AnimationUtils.loadAnimation(EmojiCustomUI.this, R.anim.ct);
            this.kZV.setInterpolator(new LinearInterpolator());
            AppMethodBeat.o(53322);
        }

        public final int getCount() {
            AppMethodBeat.i(53323);
            int realCount = getRealCount() + blx();
            AppMethodBeat.o(53323);
            return realCount;
        }

        private int blx() {
            AppMethodBeat.i(53324);
            if (getRealCount() <= 0 || (getRealCount() + 1) % 5 != 0) {
                AppMethodBeat.o(53324);
                return 2;
            }
            AppMethodBeat.o(53324);
            return 1;
        }

        public final int getRealCount() {
            AppMethodBeat.i(53325);
            if (this.kWs == null) {
                AppMethodBeat.o(53325);
                return 0;
            }
            int size = this.kWs.size();
            AppMethodBeat.o(53325);
            return size;
        }

        public final EmojiInfo uf(int i) {
            AppMethodBeat.i(53326);
            if (i >= getRealCount()) {
                AppMethodBeat.o(53326);
                return null;
            } else if (this.kWs == null) {
                AppMethodBeat.o(53326);
                return null;
            } else {
                EmojiInfo emojiInfo = (EmojiInfo) this.kWs.get(i);
                AppMethodBeat.o(53326);
                return emojiInfo;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            int blx;
            AppMethodBeat.i(53327);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiCustomUI.this.mController.ylL).inflate(R.layout.tp, null);
                view.setVisibility(0);
                d dVar2 = new d(view);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                view.setVisibility(0);
                dVar = (d) view.getTag();
            }
            if (EmojiCustomUI.this.kZn == c.WITH_OUT_ADD || EmojiCustomUI.this.kZn == c.EDIT) {
                blx = blx();
            } else if (1 == this.ezx) {
                blx = blx();
            } else {
                blx = blx() - 1;
            }
            if (i < getCount() - blx) {
                if (i % 5 == 0) {
                    dVar.iym.setBackgroundResource(R.drawable.emoji_grid_item_bottom);
                } else {
                    dVar.iym.setBackgroundResource(R.drawable.emoji_grid_item_middle);
                }
            } else if (i == getCount() - blx) {
                dVar.iym.setBackgroundResource(R.drawable.emoji_grid_item_left);
            } else {
                dVar.iym.setBackgroundColor(0);
            }
            dVar.image.clearAnimation();
            dVar.image.setScaleType(ScaleType.FIT_CENTER);
            com.tencent.mm.emoji.loader.a aVar;
            switch (AnonymousClass11.kZQ[EmojiCustomUI.this.kZn.ordinal()]) {
                case 1:
                    if (i == (getCount() - blx()) + 1) {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i == 0) {
                        if (this.ezx == 0) {
                            aVar = com.tencent.mm.emoji.loader.a.exs;
                            com.tencent.mm.emoji.loader.a.cf(dVar.image);
                            dVar.image.setScaleType(ScaleType.CENTER_INSIDE);
                            dVar.image.setImageResource(R.raw.emoji_add);
                        } else if (i != getRealCount()) {
                            a(dVar.image, (EmojiInfo) this.kWs.get(i));
                        }
                    } else if (this.ezx == 0) {
                        a(dVar.image, (EmojiInfo) this.kWs.get(i - 1));
                    } else if (i != getRealCount()) {
                        a(dVar.image, (EmojiInfo) this.kWs.get(i));
                    } else {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    }
                    dVar.lab.setVisibility(8);
                    break;
                case 2:
                    if (i != (getCount() - blx()) + 1) {
                        if (i != getRealCount()) {
                            EmojiInfo emojiInfo = (EmojiInfo) this.kWs.get(i);
                            a(dVar.image, emojiInfo);
                            if (emojiInfo.field_catalog != EmojiGroupInfo.yas) {
                                dVar.lab.setVisibility(0);
                                dVar.lab.setChecked(EmojiCustomUI.this.kZB.contains(emojiInfo.Aq()));
                                break;
                            }
                        }
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    }
                case 3:
                    if (i == (getCount() - blx()) + 1) {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i == getRealCount()) {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageResource(R.drawable.xe);
                        dVar.image.startAnimation(this.kZV);
                    } else {
                        a(dVar.image, (EmojiInfo) this.kWs.get(i));
                    }
                    dVar.lab.setVisibility(8);
                    break;
                case 4:
                    if (i == (getCount() - blx()) + 1) {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else if (i == getRealCount()) {
                        aVar = com.tencent.mm.emoji.loader.a.exs;
                        com.tencent.mm.emoji.loader.a.cf(dVar.image);
                        dVar.image.setImageBitmap(null);
                    } else {
                        a(dVar.image, (EmojiInfo) this.kWs.get(i));
                    }
                    dVar.lab.setVisibility(8);
                    break;
            }
            dVar.lab.setVisibility(8);
            AppMethodBeat.o(53327);
            return view;
        }

        public final boolean bly() {
            AppMethodBeat.i(53328);
            if (!g.RP().isSDCardAvailable()) {
                this.kWs = new ArrayList();
            } else if (this.ezx == 0) {
                this.kWs = (ArrayList) j.getEmojiStorageMgr().xYn.ps(false);
            } else {
                this.kWs = com.tencent.mm.emoji.a.a.OB().bZ(false);
            }
            if (EmojiCustomUI.this.kZn == c.EDIT) {
                int size = EmojiCustomUI.this.kZB == null ? 0 : EmojiCustomUI.this.kZB.size();
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.b_w, new Object[]{Integer.valueOf(size)}));
            } else if (this.ezx == 0) {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.b9y, new Object[]{Integer.valueOf(this.kWs.size())}));
            } else {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(R.string.b9j, new Object[]{Integer.valueOf(this.kWs.size())}));
            }
            AppMethodBeat.o(53328);
            return true;
        }

        private static void a(ImageView imageView, EmojiInfo emojiInfo) {
            AppMethodBeat.i(53329);
            com.tencent.mm.emoji.loader.a aVar = com.tencent.mm.emoji.loader.a.exs;
            com.tencent.mm.emoji.loader.a.a(emojiInfo, imageView);
            AppMethodBeat.o(53329);
        }
    }

    enum a {
        START,
        PAUSE,
        EMPTY;

        static {
            AppMethodBeat.o(53321);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiCustomUI() {
        AppMethodBeat.i(53335);
        AppMethodBeat.o(53335);
    }

    private void a(a aVar) {
        AppMethodBeat.i(53336);
        ab.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", aVar.toString());
        this.kZA = aVar;
        switch (aVar) {
            case EMPTY:
                this.kZw.setVisibility(4);
                AppMethodBeat.o(53336);
                return;
            case START:
                this.kZw.setVisibility(0);
                this.kZw.setText(R.string.bcm);
                AppMethodBeat.o(53336);
                return;
            case PAUSE:
                this.kZw.setVisibility(0);
                this.kZw.setText(R.string.bcn);
                break;
        }
        AppMethodBeat.o(53336);
    }

    static {
        AppMethodBeat.i(53366);
        AppMethodBeat.o(53366);
    }

    private void go(boolean z) {
        AppMethodBeat.i(53337);
        int size = this.kZD.ezt.size();
        int i = this.kZD.ezu;
        if (size != i || z) {
            int i2;
            if (i == 0) {
                i2 = size;
            } else {
                i2 = 0;
            }
            i += i2;
            this.kZv.setText(String.format(getString(z ? R.string.bcr : R.string.bck), new Object[]{Integer.valueOf(i - size), Integer.valueOf(i)}));
            AppMethodBeat.o(53337);
            return;
        }
        this.kZv.setText(R.string.bcp);
        AppMethodBeat.o(53337);
    }

    public void onCreate(Bundle bundle) {
        boolean booleanValue;
        AppMethodBeat.i(53338);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.kZC = getIntent().getIntExtra("key_emoji_panel_type", this.kZC);
        com.tencent.mm.emoji.sync.EmojiSyncManager.a aVar;
        if (this.kZC == 1) {
            aVar = EmojiSyncManager.ezA;
            this.kZD = com.tencent.mm.emoji.sync.EmojiSyncManager.a.Ph();
        } else {
            aVar = EmojiSyncManager.ezA;
            this.kZD = com.tencent.mm.emoji.sync.EmojiSyncManager.a.Pg();
        }
        this.kZo = new b(this.kZC);
        this.kZo.bly();
        initView();
        a(c.NORMAL);
        if (this.kZC == 1) {
            booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        } else {
            booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(this.kZC), 0);
        }
        j.getEmojiStorageMgr().xYn.c(this.kZH);
        h.pYm.a(406, 9, 1, false);
        h.pYm.a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
        h.pYm.e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28));
        EmojiSyncManager emojiSyncManager = this.kZD;
        com.tencent.mm.emoji.sync.c cVar = this.kZI;
        a.f.b.j.p(cVar, "callback");
        com.tencent.mm.ab.b.a(new EmojiSyncManager.e(emojiSyncManager, cVar));
        this.kZD.ch(true);
        com.tencent.mm.emoji.a.b bVar = com.tencent.mm.emoji.a.b.eyD;
        com.tencent.mm.emoji.a.b.OG();
        AppMethodBeat.o(53338);
    }

    public void onResume() {
        AppMethodBeat.i(53339);
        super.onResume();
        blt();
        g.RO().eJo.a(698, (f) this);
        AppMethodBeat.o(53339);
    }

    public void onPause() {
        AppMethodBeat.i(53340);
        super.onPause();
        g.RO().eJo.b(698, (f) this);
        AppMethodBeat.o(53340);
    }

    public void onDestroy() {
        AppMethodBeat.i(53341);
        super.onDestroy();
        j.getEmojiStorageMgr().xYn.d(this.kZH);
        j.bkj().kXj.kXv = false;
        BKGLoaderManager bKGLoaderManager = j.bkj().kXj;
        if (bKGLoaderManager.kXs) {
            bKGLoaderManager.kXs = false;
        }
        EmojiSyncManager emojiSyncManager = this.kZD;
        com.tencent.mm.emoji.sync.c cVar = this.kZI;
        a.f.b.j.p(cVar, "callback");
        com.tencent.mm.ab.b.a(new EmojiSyncManager.h(emojiSyncManager, cVar));
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(53341);
    }

    public final int getLayoutId() {
        return R.layout.to;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.i(53342);
        this.kZu = getLayoutInflater().inflate(R.layout.tq, null);
        this.kZv = (TextView) this.kZu.findViewById(R.id.bdl);
        this.kZw = (Button) this.kZu.findViewById(R.id.bdm);
        this.kZw.setOnClickListener(this.kZE);
        this.kZp = (HeaderGridView) findViewById(R.id.bdf);
        this.kZp.eE(this.kZu);
        this.kZp.setAdapter$159aa965(this.kZo);
        this.kZp.setOnItemClickListener(this);
        this.kZp.setFocusableInTouchMode(false);
        this.kZq = findViewById(R.id.bdg);
        this.kZr = (Button) findViewById(R.id.bdi);
        this.kZr.setOnClickListener(this.kZF);
        this.kZs = (Button) findViewById(R.id.bdh);
        this.kZs.setOnClickListener(this.kZG);
        AppMethodBeat.o(53342);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(53343);
        if (this.kZo != null) {
            int headerViewCount = i - (this.kZp.getHeaderViewCount() * 5);
            if (this.kZn == c.NORMAL && headerViewCount == 0) {
                if (1 == this.kZC) {
                    AppMethodBeat.o(53343);
                    return;
                } else if (g.RP().isSDCardAvailable()) {
                    if (this.kZo.getRealCount() >= com.tencent.mm.emoji.a.e.OM()) {
                        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.bd2), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        n.ak(this);
                    }
                    h.pYm.e(11596, Integer.valueOf(0));
                } else {
                    t.hO(this);
                    AppMethodBeat.o(53343);
                    return;
                }
            }
            if (this.kZn == c.EDIT && headerViewCount < this.kZo.getRealCount()) {
                EmojiInfo uf = this.kZo.uf(headerViewCount);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                String Aq;
                if (uf.field_catalog == EmojiGroupInfo.yas) {
                    com.tencent.mm.ui.base.h.g(this.mController.ylL, R.string.ak9, R.string.ak9).show();
                } else if (this.kZB.contains(uf.Aq())) {
                    Aq = uf.Aq();
                    if (this.kZB != null) {
                        this.kZB.remove(Aq);
                    }
                    if (dVar != null) {
                        dVar.lab.setChecked(false);
                        this.kZo.notifyDataSetChanged();
                    }
                    ab.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", uf.Aq());
                } else {
                    Aq = uf.Aq();
                    if (this.kZB != null) {
                        this.kZB.add(Aq);
                    }
                    if (dVar != null) {
                        dVar.lab.setChecked(true);
                    }
                    ab.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", uf.Aq());
                }
                blr();
                if (dVar == null) {
                    this.kZo.notifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.o(53343);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53344);
        ab.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 205:
                    if (intent == null) {
                        AppMethodBeat.o(53344);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 3);
                    intent2.putExtra("CropImage_OutputPath", com.tencent.mm.plugin.emoji.h.b.Yb());
                    com.tencent.mm.plugin.emoji.b.gkE.a(intent2, 206, (MMActivity) this, intent);
                    AppMethodBeat.o(53344);
                    return;
                case 206:
                    if (intent == null) {
                        ab.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        AppMethodBeat.o(53344);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra == null || stringExtra.length() <= 0) {
                        AppMethodBeat.o(53344);
                        return;
                    }
                    stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                    String str = com.tencent.mm.plugin.emoji.h.b.Yb() + stringExtra;
                    this.kZK = j.getEmojiStorageMgr().xYn.aqi(stringExtra);
                    com.tencent.mm.ui.tools.b.b asm = com.tencent.mm.ui.tools.b.b.asm(str);
                    asm.mSize = com.tencent.mm.m.b.MZ();
                    asm.PL(com.tencent.mm.m.b.Na()).a(new com.tencent.mm.ui.tools.b.b.a() {
                        public final void a(com.tencent.mm.ui.tools.b.b bVar) {
                            AppMethodBeat.i(53300);
                            if (EmojiCustomUI.this.kZK == null) {
                                if (intExtra == 0) {
                                    EmojiCustomUI.this.kZK = j.getEmojiStorageMgr().xYn.d(stringExtra, "", EmojiGroupInfo.yau, EmojiInfo.zYR, bVar.zIt, "");
                                } else {
                                    EmojiCustomUI.this.kZK = j.getEmojiStorageMgr().xYn.d(stringExtra, "", EmojiGroupInfo.yau, EmojiInfo.zYS, bVar.zIt, "");
                                }
                            }
                            j.bki().a(EmojiCustomUI.this.mController.ylL, EmojiCustomUI.this.kZK, 1, r.Yz());
                            if (EmojiCustomUI.this.kZo != null) {
                                EmojiCustomUI.this.kZo.bly();
                                EmojiCustomUI.this.kZo.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(53300);
                        }

                        public final void bln() {
                            AppMethodBeat.i(53301);
                            com.tencent.mm.ui.base.h.a(EmojiCustomUI.this.mController.ylL, EmojiCustomUI.this.mController.ylL.getString(R.string.b9w), "", EmojiCustomUI.this.mController.ylL.getString(R.string.cd_), false, null);
                            AppMethodBeat.o(53301);
                        }
                    });
                    AppMethodBeat.o(53344);
                    return;
                case 214:
                    if (this.kZo != null) {
                        this.kZo.bly();
                        this.kZo.notifyDataSetChanged();
                        AppMethodBeat.o(53344);
                        return;
                    }
                    break;
                default:
                    ab.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    AppMethodBeat.o(53344);
                    return;
            }
        }
        AppMethodBeat.o(53344);
    }

    public void onBackPressed() {
        AppMethodBeat.i(53345);
        if (this.kZn == c.EDIT) {
            a(c.NORMAL);
            AppMethodBeat.o(53345);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(53345);
    }

    private void a(c cVar) {
        AppMethodBeat.i(53346);
        long currentTimeMillis = System.currentTimeMillis();
        this.kZn = cVar;
        switch (cVar) {
            case NORMAL:
                setBackBtn(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(53302);
                        EmojiCustomUI.this.finish();
                        AppMethodBeat.o(53302);
                        return true;
                    }
                });
                enableBackMenu(true);
                addTextOptionMenu(0, getString(R.string.bae), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(53303);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.EDIT);
                        h.pYm.e(11596, Integer.valueOf(1));
                        AppMethodBeat.o(53303);
                        return true;
                    }
                });
                this.kZq.setVisibility(8);
                blt();
                blp();
                break;
            case EDIT:
                setBackBtn(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(53304);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.NORMAL);
                        AppMethodBeat.o(53304);
                        return true;
                    }
                });
                addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(53305);
                        EmojiCustomUI.a(EmojiCustomUI.this, c.NORMAL);
                        AppMethodBeat.o(53305);
                        return true;
                    }
                });
                this.kZq.setVisibility(0);
                bls();
                blr();
                break;
            case SYNCING:
                blq();
                break;
            case WITH_OUT_ADD:
                break;
        }
        blq();
        if (this.kZo != null) {
            this.kZo.bly();
            this.kZo.notifyDataSetChanged();
        }
        ab.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(53346);
    }

    private void blp() {
        AppMethodBeat.i(53347);
        if (this.kZB != null) {
            this.kZB.clear();
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
        AppMethodBeat.o(53347);
    }

    private void blq() {
        AppMethodBeat.i(53348);
        this.kZq.setVisibility(this.kZn == c.EDIT ? 0 : 8);
        AppMethodBeat.o(53348);
    }

    private void blr() {
        AppMethodBeat.i(53349);
        if (this.kZn == c.EDIT) {
            if ((this.kZB == null ? 0 : this.kZB.size()) > 0) {
                this.kZr.setText(getResources().getString(R.string.p4));
                this.kZr.setEnabled(true);
                this.kZs.setEnabled(true);
            } else {
                this.kZr.setText(getResources().getString(R.string.p4));
                this.kZr.setEnabled(false);
                this.kZs.setEnabled(false);
            }
            setMMTitle(getResources().getString(R.string.b_w, new Object[]{Integer.valueOf(r0)}));
        }
        AppMethodBeat.o(53349);
    }

    private void bls() {
        AppMethodBeat.i(53351);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
        AppMethodBeat.o(53351);
    }

    private void blt() {
        AppMethodBeat.i(53352);
        if (!at.isConnected(this)) {
            bls();
            AppMethodBeat.o(53352);
        } else if (blu()) {
            AppMethodBeat.o(53352);
        } else {
            this.kZy = false;
            AppMethodBeat.o(53352);
        }
    }

    private boolean blu() {
        AppMethodBeat.i(53353);
        if (this.kZo == null || this.kZo.getRealCount() <= com.tencent.mm.emoji.a.e.OM()) {
            AppMethodBeat.o(53353);
            return false;
        }
        this.kZx = true;
        this.kZu.setVisibility(0);
        blv();
        this.kZw.setVisibility(8);
        this.kZo.notifyDataSetChanged();
        enableOptionMenu(0, true);
        this.kZy = true;
        AppMethodBeat.o(53353);
        return true;
    }

    private void blv() {
        AppMethodBeat.i(53354);
        this.kZv.setTextColor(getResources().getColor(R.color.xy));
        this.kZv.setText(getString(R.string.bci, new Object[]{Integer.valueOf(com.tencent.mm.emoji.a.e.OM())}));
        AppMethodBeat.o(53354);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(53355);
        ab.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar instanceof com.tencent.mm.plugin.emoji.f.c) {
            switch (((com.tencent.mm.plugin.emoji.f.c) mVar).gvO) {
                case 2:
                    blb();
                    if (i == 0 && i2 == 0) {
                        final ArrayList arrayList = new ArrayList(this.kZB);
                        g.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(53308);
                                for (int i = 0; i < arrayList.size(); i++) {
                                    ab.i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", arrayList.get(i));
                                    EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi((String) arrayList.get(i));
                                    h.pYm.e(10613, arrayList.get(i), aqi.field_groupId, aqi.field_designerID, aqi.field_activityid);
                                }
                                AppMethodBeat.o(53308);
                            }
                        });
                        j.getEmojiStorageMgr().xYn.u(this.kZB, this.kZC);
                        blp();
                        blr();
                        com.tencent.mm.emoji.a.b bVar;
                        if (this.kZC == 0) {
                            com.tencent.mm.emoji.a.a.OB().cb(true);
                            bVar = com.tencent.mm.emoji.a.b.eyD;
                            com.tencent.mm.emoji.a.b.ce(false);
                        } else {
                            com.tencent.mm.emoji.a.a.OB().cd(true);
                            bVar = com.tencent.mm.emoji.a.b.eyD;
                            com.tencent.mm.emoji.a.b.cf(false);
                        }
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        AppMethodBeat.o(53355);
                        return;
                    }
                    ab.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    JO(getString(R.string.bcy));
                    AppMethodBeat.o(53355);
                    return;
                case 3:
                    blb();
                    if (i != 0 || i2 != 0) {
                        JO(getString(R.string.bcy));
                        break;
                    }
                    j.getEmojiStorageMgr().xYn.l(this.kZC, this.kZB);
                    blp();
                    blr();
                    if (this.kZC == 0) {
                        com.tencent.mm.emoji.a.a.OB().cb(true);
                    } else {
                        com.tencent.mm.emoji.a.a.OB().cd(true);
                    }
                    this.mHandler.sendEmptyMessageDelayed(1004, 100);
                    AppMethodBeat.o(53355);
                    return;
                    break;
            }
            AppMethodBeat.o(53355);
            return;
        }
        ab.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
        AppMethodBeat.o(53355);
    }

    private void JP(String str) {
        AppMethodBeat.i(53356);
        getString(R.string.tz);
        this.gqo = com.tencent.mm.ui.base.h.b((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(53356);
    }

    private void blb() {
        AppMethodBeat.i(53357);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(53357);
    }

    private boolean JO(String str) {
        AppMethodBeat.i(53350);
        com.tencent.mm.ui.base.h.d(this.mController.ylL, str, "", "", getString(R.string.cd_), null, null);
        AppMethodBeat.o(53350);
        return true;
    }

    static /* synthetic */ void b(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(53358);
        com.tencent.mm.ui.base.h.d(emojiCustomUI.mController.ylL, emojiCustomUI.getResources().getString(R.string.bco), "", emojiCustomUI.getResources().getString(R.string.bcm), emojiCustomUI.getResources().getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(53307);
                EmojiCustomUI.this.kZD.cg(true);
                h.pYm.e(11595, Integer.valueOf(1), Integer.valueOf(EmojiCustomUI.this.kZC));
                AppMethodBeat.o(53307);
            }
        }, null);
        AppMethodBeat.o(53358);
    }

    static /* synthetic */ boolean d(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(53359);
        com.tencent.mm.ui.base.h.a(emojiCustomUI.mController.ylL, emojiCustomUI.getResources().getString(R.string.b9z), "", emojiCustomUI.getResources().getString(R.string.p4), emojiCustomUI.getResources().getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(53306);
                EmojiCustomUI.k(EmojiCustomUI.this);
                AppMethodBeat.o(53306);
            }
        }, null, (int) R.color.a89);
        AppMethodBeat.o(53359);
        return true;
    }

    static /* synthetic */ void e(EmojiCustomUI emojiCustomUI) {
        int i;
        AppMethodBeat.i(53360);
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        if (emojiCustomUI.kZB == null) {
            i = 0;
        } else {
            i = emojiCustomUI.kZB.size();
        }
        objArr[0] = Integer.valueOf(i);
        ab.i(str, str2, objArr);
        if (emojiCustomUI.kZB == null || emojiCustomUI.kZB.size() <= 0) {
            ab.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.o(53360);
            return;
        }
        emojiCustomUI.JP(emojiCustomUI.getString(R.string.bcz));
        ArrayList arrayList = emojiCustomUI.kZB;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        ab.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
            AppMethodBeat.o(53360);
            return;
        }
        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.c(emojiCustomUI.kZC, 3, emojiCustomUI.kZB), 0);
        AppMethodBeat.o(53360);
    }

    static /* synthetic */ void h(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.i(53361);
        ab.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", emojiCustomUI.kZt.toString());
        if (emojiCustomUI.kZn == c.EDIT || emojiCustomUI.kZy) {
            AppMethodBeat.o(53361);
            return;
        }
        switch (emojiCustomUI.kZt) {
            case Init:
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.bls();
                emojiCustomUI.a(c.NORMAL);
                AppMethodBeat.o(53361);
                return;
            case Syncing:
                emojiCustomUI.enableOptionMenu(0, false);
                if (!at.isWifi((Context) emojiCustomUI)) {
                    emojiCustomUI.kZz = false;
                    emojiCustomUI.kZu.setVisibility(0);
                    emojiCustomUI.a(a.PAUSE);
                    emojiCustomUI.go(true);
                } else if (at.isWifi((Context) emojiCustomUI) && !emojiCustomUI.kZz) {
                    emojiCustomUI.kZz = true;
                    emojiCustomUI.bls();
                    emojiCustomUI.a(a.EMPTY);
                }
                if (emojiCustomUI.kZn != c.SYNCING) {
                    emojiCustomUI.a(c.SYNCING);
                    AppMethodBeat.o(53361);
                    return;
                }
                break;
            case Wait:
                if (at.isConnected(emojiCustomUI)) {
                    emojiCustomUI.kZz = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(1003);
                    }
                    emojiCustomUI.kZu.setVisibility(0);
                    emojiCustomUI.go(false);
                    emojiCustomUI.a(a.START);
                    emojiCustomUI.a(c.WITH_OUT_ADD);
                    AppMethodBeat.o(53361);
                    return;
                }
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, false);
                emojiCustomUI.bls();
                emojiCustomUI.a(c.WITH_OUT_ADD);
                AppMethodBeat.o(53361);
                return;
            case End:
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.bls();
                emojiCustomUI.a(c.NORMAL);
                break;
        }
        AppMethodBeat.o(53361);
    }

    static /* synthetic */ void blw() {
        AppMethodBeat.i(53363);
        com.tencent.mm.sdk.b.a.xxA.m(new ny());
        AppMethodBeat.o(53363);
    }

    static /* synthetic */ void k(EmojiCustomUI emojiCustomUI) {
        int i;
        AppMethodBeat.i(53365);
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        if (emojiCustomUI.kZB == null) {
            i = 0;
        } else {
            i = emojiCustomUI.kZB.size();
        }
        objArr[0] = Integer.valueOf(i);
        ab.i(str, str2, objArr);
        if (emojiCustomUI.kZB == null || emojiCustomUI.kZB.size() <= 0) {
            ab.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.o(53365);
            return;
        }
        emojiCustomUI.JP(emojiCustomUI.getString(R.string.b_2));
        ArrayList arrayList = emojiCustomUI.kZB;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        ab.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            ab.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.c(emojiCustomUI.kZC, 2, emojiCustomUI.kZB), 0);
        }
        ab.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", Boolean.valueOf(emojiCustomUI.kZx));
        if (emojiCustomUI.kZx) {
            emojiCustomUI.kZx = false;
            g.RP().Ry().set(348162, Boolean.TRUE);
            com.tencent.mm.plugin.emoji.c.a.bjE();
        }
        emojiCustomUI.blt();
        AppMethodBeat.o(53365);
    }
}
