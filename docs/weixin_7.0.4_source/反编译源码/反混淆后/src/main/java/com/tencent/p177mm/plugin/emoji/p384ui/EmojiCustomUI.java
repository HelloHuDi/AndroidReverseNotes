package com.tencent.p177mm.plugin.emoji.p384ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.emoji.sync.C26082c;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9284e;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9287a;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9288h;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9289b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.p191a.p193c.C32282l;
import com.tencent.p177mm.p190at.p191a.p193c.C37475d;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.HeaderGridView;
import com.tencent.p177mm.p612ui.tools.p632b.C24046b;
import com.tencent.p177mm.p612ui.tools.p632b.C24046b.C24047a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emoji.C42935b;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p1252c.C27731a;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p726f.C33949c;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.p177mm.plugin.gif.C34325i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI */
public class EmojiCustomUI extends MMActivity implements OnItemClickListener, C1202f {
    private static C32282l fHy = new C3396417();
    private static C37475d kZJ = new C3396316();
    private ProgressDialog gqo;
    private C33961a kZA = C33961a.EMPTY;
    private ArrayList<String> kZB = new ArrayList();
    private int kZC = 0;
    private EmojiSyncManager kZD;
    private OnClickListener kZE = new C277521();
    private OnClickListener kZF = new C1156712();
    private OnClickListener kZG = new C2775113();
    private final C4931a kZH = new C2039014();
    private final C26082c kZI = new C3396715();
    private EmojiInfo kZK;
    private C2944c kZn = C2944c.NORMAL;
    private C11571b kZo;
    private HeaderGridView kZp;
    private View kZq;
    private Button kZr;
    private Button kZs;
    private C9289b kZt = C9289b.Init;
    private View kZu;
    private TextView kZv;
    private Button kZw;
    private boolean kZx = false;
    private boolean kZy = false;
    private boolean kZz = false;
    private C7306ak mHandler = new C3396518();

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$c */
    enum C2944c {
        NORMAL,
        EDIT,
        SYNCING,
        WITH_OUT_ADD;

        static {
            AppMethodBeat.m2505o(53333);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$d */
    static class C2945d {
        ImageView image;
        View iym;
        CheckBox lab;

        public C2945d(View view) {
            AppMethodBeat.m2504i(53334);
            this.iym = view.findViewById(2131821518);
            this.image = (ImageView) view.findViewById(2131820629);
            this.lab = (CheckBox) view.findViewById(2131823450);
            AppMethodBeat.m2505o(53334);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$12 */
    class C1156712 implements OnClickListener {
        C1156712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53310);
            EmojiCustomUI.m55585d(EmojiCustomUI.this);
            AppMethodBeat.m2505o(53310);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$7 */
    class C115687 implements DialogInterface.OnClickListener {
        C115687() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53306);
            EmojiCustomUI.m55593k(EmojiCustomUI.this);
            AppMethodBeat.m2505o(53306);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$8 */
    class C115698 implements DialogInterface.OnClickListener {
        C115698() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53307);
            EmojiCustomUI.this.kZD.mo20718cg(true);
            C7060h.pYm.mo8381e(11595, Integer.valueOf(1), Integer.valueOf(EmojiCustomUI.this.kZC));
            AppMethodBeat.m2505o(53307);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$b */
    class C11571b extends BaseAdapter {
        private int ezx;
        private ArrayList<EmojiInfo> kWs;
        private Animation kZV;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(53330);
            EmojiInfo uf = mo23284uf(i);
            AppMethodBeat.m2505o(53330);
            return uf;
        }

        public C11571b(int i) {
            AppMethodBeat.m2504i(53322);
            this.ezx = i;
            this.kZV = AnimationUtils.loadAnimation(EmojiCustomUI.this, C25738R.anim.f8387ct);
            this.kZV.setInterpolator(new LinearInterpolator());
            AppMethodBeat.m2505o(53322);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(53323);
            int realCount = getRealCount() + blx();
            AppMethodBeat.m2505o(53323);
            return realCount;
        }

        private int blx() {
            AppMethodBeat.m2504i(53324);
            if (getRealCount() <= 0 || (getRealCount() + 1) % 5 != 0) {
                AppMethodBeat.m2505o(53324);
                return 2;
            }
            AppMethodBeat.m2505o(53324);
            return 1;
        }

        public final int getRealCount() {
            AppMethodBeat.m2504i(53325);
            if (this.kWs == null) {
                AppMethodBeat.m2505o(53325);
                return 0;
            }
            int size = this.kWs.size();
            AppMethodBeat.m2505o(53325);
            return size;
        }

        /* renamed from: uf */
        public final EmojiInfo mo23284uf(int i) {
            AppMethodBeat.m2504i(53326);
            if (i >= getRealCount()) {
                AppMethodBeat.m2505o(53326);
                return null;
            } else if (this.kWs == null) {
                AppMethodBeat.m2505o(53326);
                return null;
            } else {
                EmojiInfo emojiInfo = (EmojiInfo) this.kWs.get(i);
                AppMethodBeat.m2505o(53326);
                return emojiInfo;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C2945d c2945d;
            int blx;
            AppMethodBeat.m2504i(53327);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiCustomUI.this.mController.ylL).inflate(2130969333, null);
                view.setVisibility(0);
                C2945d c2945d2 = new C2945d(view);
                view.setTag(c2945d2);
                c2945d = c2945d2;
            } else {
                view.setVisibility(0);
                c2945d = (C2945d) view.getTag();
            }
            if (EmojiCustomUI.this.kZn == C2944c.WITH_OUT_ADD || EmojiCustomUI.this.kZn == C2944c.EDIT) {
                blx = blx();
            } else if (1 == this.ezx) {
                blx = blx();
            } else {
                blx = blx() - 1;
            }
            if (i < getCount() - blx) {
                if (i % 5 == 0) {
                    c2945d.iym.setBackgroundResource(C25738R.drawable.emoji_grid_item_bottom);
                } else {
                    c2945d.iym.setBackgroundResource(C25738R.drawable.emoji_grid_item_middle);
                }
            } else if (i == getCount() - blx) {
                c2945d.iym.setBackgroundResource(C25738R.drawable.emoji_grid_item_left);
            } else {
                c2945d.iym.setBackgroundColor(0);
            }
            c2945d.image.clearAnimation();
            c2945d.image.setScaleType(ScaleType.FIT_CENTER);
            C37682a c37682a;
            switch (C2775011.kZQ[EmojiCustomUI.this.kZn.ordinal()]) {
                case 1:
                    if (i == (getCount() - blx()) + 1) {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    } else if (i == 0) {
                        if (this.ezx == 0) {
                            c37682a = C37682a.exs;
                            C37682a.m63728cf(c2945d.image);
                            c2945d.image.setScaleType(ScaleType.CENTER_INSIDE);
                            c2945d.image.setImageResource(C1318a.emoji_add);
                        } else if (i != getRealCount()) {
                            C11571b.m19388a(c2945d.image, (EmojiInfo) this.kWs.get(i));
                        }
                    } else if (this.ezx == 0) {
                        C11571b.m19388a(c2945d.image, (EmojiInfo) this.kWs.get(i - 1));
                    } else if (i != getRealCount()) {
                        C11571b.m19388a(c2945d.image, (EmojiInfo) this.kWs.get(i));
                    } else {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    }
                    c2945d.lab.setVisibility(8);
                    break;
                case 2:
                    if (i != (getCount() - blx()) + 1) {
                        if (i != getRealCount()) {
                            EmojiInfo emojiInfo = (EmojiInfo) this.kWs.get(i);
                            C11571b.m19388a(c2945d.image, emojiInfo);
                            if (emojiInfo.field_catalog != EmojiGroupInfo.yas) {
                                c2945d.lab.setVisibility(0);
                                c2945d.lab.setChecked(EmojiCustomUI.this.kZB.contains(emojiInfo.mo20410Aq()));
                                break;
                            }
                        }
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    } else {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    }
                case 3:
                    if (i == (getCount() - blx()) + 1) {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    } else if (i == getRealCount()) {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageResource(C25738R.drawable.f6977xe);
                        c2945d.image.startAnimation(this.kZV);
                    } else {
                        C11571b.m19388a(c2945d.image, (EmojiInfo) this.kWs.get(i));
                    }
                    c2945d.lab.setVisibility(8);
                    break;
                case 4:
                    if (i == (getCount() - blx()) + 1) {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    } else if (i == getRealCount()) {
                        c37682a = C37682a.exs;
                        C37682a.m63728cf(c2945d.image);
                        c2945d.image.setImageBitmap(null);
                    } else {
                        C11571b.m19388a(c2945d.image, (EmojiInfo) this.kWs.get(i));
                    }
                    c2945d.lab.setVisibility(8);
                    break;
            }
            c2945d.lab.setVisibility(8);
            AppMethodBeat.m2505o(53327);
            return view;
        }

        public final boolean bly() {
            AppMethodBeat.m2504i(53328);
            if (!C1720g.m3536RP().isSDCardAvailable()) {
                this.kWs = new ArrayList();
            } else if (this.ezx == 0) {
                this.kWs = (ArrayList) C42952j.getEmojiStorageMgr().xYn.mo48590ps(false);
            } else {
                this.kWs = C32497a.m53203OB().mo53137bZ(false);
            }
            if (EmojiCustomUI.this.kZn == C2944c.EDIT) {
                int size = EmojiCustomUI.this.kZB == null ? 0 : EmojiCustomUI.this.kZB.size();
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(C25738R.string.b_w, new Object[]{Integer.valueOf(size)}));
            } else if (this.ezx == 0) {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(C25738R.string.b9y, new Object[]{Integer.valueOf(this.kWs.size())}));
            } else {
                EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(C25738R.string.b9j, new Object[]{Integer.valueOf(this.kWs.size())}));
            }
            AppMethodBeat.m2505o(53328);
            return true;
        }

        /* renamed from: a */
        private static void m19388a(ImageView imageView, EmojiInfo emojiInfo) {
            AppMethodBeat.m2504i(53329);
            C37682a c37682a = C37682a.exs;
            C37682a.m63721a(emojiInfo, imageView);
            AppMethodBeat.m2505o(53329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$14 */
    class C2039014 implements C4931a {
        C2039014() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(53312);
            if (!C5046bo.isNullOrNil(str) && ((str.length() == 32 || str.equals("event_update_emoji")) && EmojiCustomUI.this.kZo != null)) {
                EmojiCustomUI.this.kZo.bly();
                EmojiCustomUI.this.kZo.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(53312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$19 */
    class C2039119 implements DialogInterface.OnClickListener {
        C2039119() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$10 */
    class C2774910 implements OnCancelListener {
        C2774910() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$13 */
    class C2775113 implements OnClickListener {
        C2775113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53311);
            EmojiCustomUI.m55586e(EmojiCustomUI.this);
            AppMethodBeat.m2505o(53311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$1 */
    class C277521 implements OnClickListener {
        C277521() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(53299);
            switch (EmojiCustomUI.this.kZA) {
                case START:
                    EmojiCustomUI.m55583b(EmojiCustomUI.this);
                    AppMethodBeat.m2505o(53299);
                    return;
                case PAUSE:
                    EmojiCustomUI.this.kZD.stop();
                    break;
            }
            AppMethodBeat.m2505o(53299);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$a */
    enum C33961a {
        START,
        PAUSE,
        EMPTY;

        static {
            AppMethodBeat.m2505o(53321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$3 */
    class C339623 implements OnMenuItemClickListener {
        C339623() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53302);
            EmojiCustomUI.this.finish();
            AppMethodBeat.m2505o(53302);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$16 */
    static class C3396316 implements C37475d {
        C3396316() {
        }

        /* renamed from: i */
        public final byte[] mo54509i(Object... objArr) {
            AppMethodBeat.m2504i(53315);
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    byte[] l = C20362f.bjK().mo35593l((EmojiInfo) obj);
                    AppMethodBeat.m2505o(53315);
                    return l;
                }
            }
            AppMethodBeat.m2505o(53315);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$17 */
    static class C3396417 implements C32282l {
        C3396417() {
        }

        /* renamed from: X */
        public final Bitmap mo52987X(byte[] bArr) {
            AppMethodBeat.m2504i(53316);
            Bitmap aW = C34325i.m56266aW(bArr);
            AppMethodBeat.m2505o(53316);
            return aW;
        }

        /* renamed from: sI */
        public final Bitmap mo52988sI(String str) {
            AppMethodBeat.m2504i(53317);
            Bitmap aW = C34325i.m56266aW(C5730e.m8632e(str, 0, -1));
            AppMethodBeat.m2505o(53317);
            return aW;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$18 */
    class C3396518 extends C7306ak {
        C3396518() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53318);
            switch (message.what) {
                case 1001:
                    EmojiCustomUI.m55590h(EmojiCustomUI.this);
                    AppMethodBeat.m2505o(53318);
                    return;
                case 1002:
                    if (!C5023at.isWifi(EmojiCustomUI.this)) {
                        if (EmojiCustomUI.this.kZD.ezs == C9289b.Syncing) {
                            EmojiCustomUI.m55582a(EmojiCustomUI.this, true);
                            AppMethodBeat.m2505o(53318);
                            return;
                        }
                        EmojiCustomUI.m55582a(EmojiCustomUI.this, false);
                        AppMethodBeat.m2505o(53318);
                        return;
                    }
                    break;
                case 1003:
                    EmojiCustomUI.this.kZu.setVisibility(8);
                    EmojiCustomUI.this.kZo.notifyDataSetChanged();
                    AppMethodBeat.m2505o(53318);
                    return;
                case 1004:
                    if (EmojiCustomUI.this.kZo != null) {
                        EmojiCustomUI.this.kZo.bly();
                        EmojiCustomUI.this.kZo.notifyDataSetChanged();
                    }
                    EmojiCustomUI.blw();
                    AppMethodBeat.m2505o(53318);
                    return;
                default:
                    C4990ab.m7412e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                    break;
            }
            AppMethodBeat.m2505o(53318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$5 */
    class C339665 implements OnMenuItemClickListener {
        C339665() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53304);
            EmojiCustomUI.m55581a(EmojiCustomUI.this, C2944c.NORMAL);
            AppMethodBeat.m2505o(53304);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$15 */
    class C3396715 implements C26082c {
        C3396715() {
        }

        /* renamed from: Pi */
        public final void mo43947Pi() {
            AppMethodBeat.m2504i(53313);
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1002);
            }
            AppMethodBeat.m2505o(53313);
        }

        /* renamed from: a */
        public final void mo43948a(C9289b c9289b) {
            AppMethodBeat.m2504i(53314);
            EmojiCustomUI.this.kZt = c9289b;
            if (EmojiCustomUI.this.mHandler != null) {
                EmojiCustomUI.this.mHandler.sendEmptyMessage(1001);
            }
            AppMethodBeat.m2505o(53314);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$4 */
    class C339684 implements OnMenuItemClickListener {
        C339684() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53303);
            EmojiCustomUI.m55581a(EmojiCustomUI.this, C2944c.EDIT);
            C7060h.pYm.mo8381e(11596, Integer.valueOf(1));
            AppMethodBeat.m2505o(53303);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$6 */
    class C339696 implements OnMenuItemClickListener {
        C339696() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53305);
            EmojiCustomUI.m55581a(EmojiCustomUI.this, C2944c.NORMAL);
            AppMethodBeat.m2505o(53305);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiCustomUI() {
        AppMethodBeat.m2504i(53335);
        AppMethodBeat.m2505o(53335);
    }

    /* renamed from: a */
    private void m55579a(C33961a c33961a) {
        AppMethodBeat.m2504i(53336);
        C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", c33961a.toString());
        this.kZA = c33961a;
        switch (c33961a) {
            case EMPTY:
                this.kZw.setVisibility(4);
                AppMethodBeat.m2505o(53336);
                return;
            case START:
                this.kZw.setVisibility(0);
                this.kZw.setText(C25738R.string.bcm);
                AppMethodBeat.m2505o(53336);
                return;
            case PAUSE:
                this.kZw.setVisibility(0);
                this.kZw.setText(C25738R.string.bcn);
                break;
        }
        AppMethodBeat.m2505o(53336);
    }

    static {
        AppMethodBeat.m2504i(53366);
        AppMethodBeat.m2505o(53366);
    }

    /* renamed from: go */
    private void m55589go(boolean z) {
        AppMethodBeat.m2504i(53337);
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
            this.kZv.setText(String.format(getString(z ? C25738R.string.bcr : C25738R.string.bck), new Object[]{Integer.valueOf(i - size), Integer.valueOf(i)}));
            AppMethodBeat.m2505o(53337);
            return;
        }
        this.kZv.setText(C25738R.string.bcp);
        AppMethodBeat.m2505o(53337);
    }

    public void onCreate(Bundle bundle) {
        boolean booleanValue;
        AppMethodBeat.m2504i(53338);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.kZC = getIntent().getIntExtra("key_emoji_panel_type", this.kZC);
        C9287a c9287a;
        if (this.kZC == 1) {
            c9287a = EmojiSyncManager.ezA;
            this.kZD = C9287a.m16850Ph();
        } else {
            c9287a = EmojiSyncManager.ezA;
            this.kZD = C9287a.m16849Pg();
        }
        this.kZo = new C11571b(this.kZC);
        this.kZo.bly();
        initView();
        m55580a(C2944c.NORMAL);
        if (this.kZC == 1) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        } else {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE)).booleanValue();
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            C1720g.m3535RO().eJo.mo14541a(new C27737e(this.kZC), 0);
        }
        C42952j.getEmojiStorageMgr().xYn.mo10116c(this.kZH);
        C7060h.pYm.mo8378a(406, 9, 1, false);
        C7060h.pYm.mo8378a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
        C7060h.pYm.mo8381e(12740, Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28));
        EmojiSyncManager emojiSyncManager = this.kZD;
        C26082c c26082c = this.kZI;
        C25052j.m39376p(c26082c, "callback");
        C8902b.m16042a(new C9284e(emojiSyncManager, c26082c));
        this.kZD.mo20719ch(true);
        C32498b c32498b = C32498b.eyD;
        C32498b.m53215OG();
        AppMethodBeat.m2505o(53338);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53339);
        super.onResume();
        blt();
        C1720g.m3535RO().eJo.mo14539a(698, (C1202f) this);
        AppMethodBeat.m2505o(53339);
    }

    public void onPause() {
        AppMethodBeat.m2504i(53340);
        super.onPause();
        C1720g.m3535RO().eJo.mo14546b(698, (C1202f) this);
        AppMethodBeat.m2505o(53340);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53341);
        super.onDestroy();
        C42952j.getEmojiStorageMgr().xYn.mo10117d(this.kZH);
        C42952j.bkj().kXj.kXv = false;
        BKGLoaderManager bKGLoaderManager = C42952j.bkj().kXj;
        if (bKGLoaderManager.kXs) {
            bKGLoaderManager.kXs = false;
        }
        EmojiSyncManager emojiSyncManager = this.kZD;
        C26082c c26082c = this.kZI;
        C25052j.m39376p(c26082c, "callback");
        C8902b.m16042a(new C9288h(emojiSyncManager, c26082c));
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(53341);
    }

    public final int getLayoutId() {
        return 2130969332;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void initView() {
        AppMethodBeat.m2504i(53342);
        this.kZu = getLayoutInflater().inflate(2130969334, null);
        this.kZv = (TextView) this.kZu.findViewById(2131823452);
        this.kZw = (Button) this.kZu.findViewById(2131823453);
        this.kZw.setOnClickListener(this.kZE);
        this.kZp = (HeaderGridView) findViewById(2131823446);
        this.kZp.mo39275eE(this.kZu);
        this.kZp.setAdapter$159aa965(this.kZo);
        this.kZp.setOnItemClickListener(this);
        this.kZp.setFocusableInTouchMode(false);
        this.kZq = findViewById(2131823447);
        this.kZr = (Button) findViewById(2131823449);
        this.kZr.setOnClickListener(this.kZF);
        this.kZs = (Button) findViewById(2131823448);
        this.kZs.setOnClickListener(this.kZG);
        AppMethodBeat.m2505o(53342);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(53343);
        if (this.kZo != null) {
            int headerViewCount = i - (this.kZp.getHeaderViewCount() * 5);
            if (this.kZn == C2944c.NORMAL && headerViewCount == 0) {
                if (1 == this.kZC) {
                    AppMethodBeat.m2505o(53343);
                    return;
                } else if (C1720g.m3536RP().isSDCardAvailable()) {
                    if (this.kZo.getRealCount() >= C26072e.m41618OM()) {
                        C30379h.m48438a((Context) this, getString(C25738R.string.bd2), "", new C2039119());
                    } else {
                        C14987n.m23307ak(this);
                    }
                    C7060h.pYm.mo8381e(11596, Integer.valueOf(0));
                } else {
                    C23639t.m36492hO(this);
                    AppMethodBeat.m2505o(53343);
                    return;
                }
            }
            if (this.kZn == C2944c.EDIT && headerViewCount < this.kZo.getRealCount()) {
                EmojiInfo uf = this.kZo.mo23284uf(headerViewCount);
                C2945d c2945d = null;
                if (view != null) {
                    c2945d = (C2945d) view.getTag();
                }
                String Aq;
                if (uf.field_catalog == EmojiGroupInfo.yas) {
                    C30379h.m48467g(this.mController.ylL, C25738R.string.ak9, C25738R.string.ak9).show();
                } else if (this.kZB.contains(uf.mo20410Aq())) {
                    Aq = uf.mo20410Aq();
                    if (this.kZB != null) {
                        this.kZB.remove(Aq);
                    }
                    if (c2945d != null) {
                        c2945d.lab.setChecked(false);
                        this.kZo.notifyDataSetChanged();
                    }
                    C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", uf.mo20410Aq());
                } else {
                    Aq = uf.mo20410Aq();
                    if (this.kZB != null) {
                        this.kZB.add(Aq);
                    }
                    if (c2945d != null) {
                        c2945d.lab.setChecked(true);
                    }
                    C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", uf.mo20410Aq());
                }
                blr();
                if (c2945d == null) {
                    this.kZo.notifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.m2505o(53343);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53344);
        C4990ab.m7411d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 205:
                    if (intent == null) {
                        AppMethodBeat.m2505o(53344);
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 3);
                    intent2.putExtra("CropImage_OutputPath", C2933b.m5221Yb());
                    C42935b.gkE.mo38894a(intent2, 206, (MMActivity) this, intent);
                    AppMethodBeat.m2505o(53344);
                    return;
                case 206:
                    if (intent == null) {
                        C4990ab.m7412e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        AppMethodBeat.m2505o(53344);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra == null || stringExtra.length() <= 0) {
                        AppMethodBeat.m2505o(53344);
                        return;
                    }
                    stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                    String str = C2933b.m5221Yb() + stringExtra;
                    this.kZK = C42952j.getEmojiStorageMgr().xYn.aqi(stringExtra);
                    C24046b asm = C24046b.asm(str);
                    asm.mSize = C42164b.m74338MZ();
                    asm.mo39850PL(C42164b.m74339Na()).mo39851a(new C24047a() {
                        /* renamed from: a */
                        public final void mo15114a(C24046b c24046b) {
                            AppMethodBeat.m2504i(53300);
                            if (EmojiCustomUI.this.kZK == null) {
                                if (intExtra == 0) {
                                    EmojiCustomUI.this.kZK = C42952j.getEmojiStorageMgr().xYn.mo48574d(stringExtra, "", EmojiGroupInfo.yau, EmojiInfo.zYR, c24046b.zIt, "");
                                } else {
                                    EmojiCustomUI.this.kZK = C42952j.getEmojiStorageMgr().xYn.mo48574d(stringExtra, "", EmojiGroupInfo.yau, EmojiInfo.zYS, c24046b.zIt, "");
                                }
                            }
                            C42952j.bki().mo35621a(EmojiCustomUI.this.mController.ylL, EmojiCustomUI.this.kZK, 1, C1853r.m3846Yz());
                            if (EmojiCustomUI.this.kZo != null) {
                                EmojiCustomUI.this.kZo.bly();
                                EmojiCustomUI.this.kZo.notifyDataSetChanged();
                            }
                            AppMethodBeat.m2505o(53300);
                        }

                        public final void bln() {
                            AppMethodBeat.m2504i(53301);
                            C30379h.m48447a(EmojiCustomUI.this.mController.ylL, EmojiCustomUI.this.mController.ylL.getString(C25738R.string.b9w), "", EmojiCustomUI.this.mController.ylL.getString(C25738R.string.cd_), false, null);
                            AppMethodBeat.m2505o(53301);
                        }
                    });
                    AppMethodBeat.m2505o(53344);
                    return;
                case 214:
                    if (this.kZo != null) {
                        this.kZo.bly();
                        this.kZo.notifyDataSetChanged();
                        AppMethodBeat.m2505o(53344);
                        return;
                    }
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    AppMethodBeat.m2505o(53344);
                    return;
            }
        }
        AppMethodBeat.m2505o(53344);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(53345);
        if (this.kZn == C2944c.EDIT) {
            m55580a(C2944c.NORMAL);
            AppMethodBeat.m2505o(53345);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.m2505o(53345);
    }

    /* renamed from: a */
    private void m55580a(C2944c c2944c) {
        AppMethodBeat.m2504i(53346);
        long currentTimeMillis = System.currentTimeMillis();
        this.kZn = c2944c;
        switch (c2944c) {
            case NORMAL:
                setBackBtn(new C339623());
                enableBackMenu(true);
                addTextOptionMenu(0, getString(C25738R.string.bae), new C339684());
                this.kZq.setVisibility(8);
                blt();
                blp();
                break;
            case EDIT:
                setBackBtn(new C339665());
                addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C339696());
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
        C4990ab.m7411d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(53346);
    }

    private void blp() {
        AppMethodBeat.m2504i(53347);
        if (this.kZB != null) {
            this.kZB.clear();
        }
        C4990ab.m7416i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
        AppMethodBeat.m2505o(53347);
    }

    private void blq() {
        AppMethodBeat.m2504i(53348);
        this.kZq.setVisibility(this.kZn == C2944c.EDIT ? 0 : 8);
        AppMethodBeat.m2505o(53348);
    }

    private void blr() {
        AppMethodBeat.m2504i(53349);
        if (this.kZn == C2944c.EDIT) {
            if ((this.kZB == null ? 0 : this.kZB.size()) > 0) {
                this.kZr.setText(getResources().getString(C25738R.string.f9088p4));
                this.kZr.setEnabled(true);
                this.kZs.setEnabled(true);
            } else {
                this.kZr.setText(getResources().getString(C25738R.string.f9088p4));
                this.kZr.setEnabled(false);
                this.kZs.setEnabled(false);
            }
            setMMTitle(getResources().getString(C25738R.string.b_w, new Object[]{Integer.valueOf(r0)}));
        }
        AppMethodBeat.m2505o(53349);
    }

    private void bls() {
        AppMethodBeat.m2504i(53351);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
        AppMethodBeat.m2505o(53351);
    }

    private void blt() {
        AppMethodBeat.m2504i(53352);
        if (!C5023at.isConnected(this)) {
            bls();
            AppMethodBeat.m2505o(53352);
        } else if (blu()) {
            AppMethodBeat.m2505o(53352);
        } else {
            this.kZy = false;
            AppMethodBeat.m2505o(53352);
        }
    }

    private boolean blu() {
        AppMethodBeat.m2504i(53353);
        if (this.kZo == null || this.kZo.getRealCount() <= C26072e.m41618OM()) {
            AppMethodBeat.m2505o(53353);
            return false;
        }
        this.kZx = true;
        this.kZu.setVisibility(0);
        blv();
        this.kZw.setVisibility(8);
        this.kZo.notifyDataSetChanged();
        enableOptionMenu(0, true);
        this.kZy = true;
        AppMethodBeat.m2505o(53353);
        return true;
    }

    private void blv() {
        AppMethodBeat.m2504i(53354);
        this.kZv.setTextColor(getResources().getColor(C25738R.color.f12266xy));
        this.kZv.setText(getString(C25738R.string.bci, new Object[]{Integer.valueOf(C26072e.m41618OM())}));
        AppMethodBeat.m2505o(53354);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53355);
        C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m instanceof C33949c) {
            switch (((C33949c) c1207m).gvO) {
                case 2:
                    blb();
                    if (i == 0 && i2 == 0) {
                        final ArrayList arrayList = new ArrayList(this.kZB);
                        C1720g.m3539RS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(53308);
                                for (int i = 0; i < arrayList.size(); i++) {
                                    C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "delete md5List md5:%s", arrayList.get(i));
                                    EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi((String) arrayList.get(i));
                                    C7060h.pYm.mo8381e(10613, arrayList.get(i), aqi.field_groupId, aqi.field_designerID, aqi.field_activityid);
                                }
                                AppMethodBeat.m2505o(53308);
                            }
                        });
                        C42952j.getEmojiStorageMgr().xYn.mo48591u(this.kZB, this.kZC);
                        blp();
                        blr();
                        C32498b c32498b;
                        if (this.kZC == 0) {
                            C32497a.m53203OB().mo53139cb(true);
                            c32498b = C32498b.eyD;
                            C32498b.m53217ce(false);
                        } else {
                            C32497a.m53203OB().mo53141cd(true);
                            c32498b = C32498b.eyD;
                            C32498b.m53218cf(false);
                        }
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        AppMethodBeat.m2505o(53355);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    m55574JO(getString(C25738R.string.bcy));
                    AppMethodBeat.m2505o(53355);
                    return;
                case 3:
                    blb();
                    if (i != 0 || i2 != 0) {
                        m55574JO(getString(C25738R.string.bcy));
                        break;
                    }
                    C42952j.getEmojiStorageMgr().xYn.mo48585l(this.kZC, this.kZB);
                    blp();
                    blr();
                    if (this.kZC == 0) {
                        C32497a.m53203OB().mo53139cb(true);
                    } else {
                        C32497a.m53203OB().mo53141cd(true);
                    }
                    this.mHandler.sendEmptyMessageDelayed(1004, 100);
                    AppMethodBeat.m2505o(53355);
                    return;
                    break;
            }
            AppMethodBeat.m2505o(53355);
            return;
        }
        C4990ab.m7420w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
        AppMethodBeat.m2505o(53355);
    }

    /* renamed from: JP */
    private void m55575JP(String str) {
        AppMethodBeat.m2504i(53356);
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, str, true, new C2774910());
        AppMethodBeat.m2505o(53356);
    }

    private void blb() {
        AppMethodBeat.m2504i(53357);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(53357);
    }

    /* renamed from: JO */
    private boolean m55574JO(String str) {
        AppMethodBeat.m2504i(53350);
        C30379h.m48466d(this.mController.ylL, str, "", "", getString(C25738R.string.cd_), null, null);
        AppMethodBeat.m2505o(53350);
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ void m55583b(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.m2504i(53358);
        C30379h.m48466d(emojiCustomUI.mController.ylL, emojiCustomUI.getResources().getString(C25738R.string.bco), "", emojiCustomUI.getResources().getString(C25738R.string.bcm), emojiCustomUI.getResources().getString(C25738R.string.f9076or), new C115698(), null);
        AppMethodBeat.m2505o(53358);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m55585d(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.m2504i(53359);
        C30379h.m48444a(emojiCustomUI.mController.ylL, emojiCustomUI.getResources().getString(C25738R.string.b9z), "", emojiCustomUI.getResources().getString(C25738R.string.f9088p4), emojiCustomUI.getResources().getString(C25738R.string.f9076or), new C115687(), null, (int) C25738R.color.a89);
        AppMethodBeat.m2505o(53359);
        return true;
    }

    /* renamed from: e */
    static /* synthetic */ void m55586e(EmojiCustomUI emojiCustomUI) {
        int i;
        AppMethodBeat.m2504i(53360);
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        if (emojiCustomUI.kZB == null) {
            i = 0;
        } else {
            i = emojiCustomUI.kZB.size();
        }
        objArr[0] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr);
        if (emojiCustomUI.kZB == null || emojiCustomUI.kZB.size() <= 0) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.m2505o(53360);
            return;
        }
        emojiCustomUI.m55575JP(emojiCustomUI.getString(C25738R.string.bcz));
        ArrayList arrayList = emojiCustomUI.kZB;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        C4990ab.m7417i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
            AppMethodBeat.m2505o(53360);
            return;
        }
        C1720g.m3535RO().eJo.mo14541a(new C33949c(emojiCustomUI.kZC, 3, emojiCustomUI.kZB), 0);
        AppMethodBeat.m2505o(53360);
    }

    /* renamed from: h */
    static /* synthetic */ void m55590h(EmojiCustomUI emojiCustomUI) {
        AppMethodBeat.m2504i(53361);
        C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", emojiCustomUI.kZt.toString());
        if (emojiCustomUI.kZn == C2944c.EDIT || emojiCustomUI.kZy) {
            AppMethodBeat.m2505o(53361);
            return;
        }
        switch (emojiCustomUI.kZt) {
            case Init:
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.bls();
                emojiCustomUI.m55580a(C2944c.NORMAL);
                AppMethodBeat.m2505o(53361);
                return;
            case Syncing:
                emojiCustomUI.enableOptionMenu(0, false);
                if (!C5023at.isWifi((Context) emojiCustomUI)) {
                    emojiCustomUI.kZz = false;
                    emojiCustomUI.kZu.setVisibility(0);
                    emojiCustomUI.m55579a(C33961a.PAUSE);
                    emojiCustomUI.m55589go(true);
                } else if (C5023at.isWifi((Context) emojiCustomUI) && !emojiCustomUI.kZz) {
                    emojiCustomUI.kZz = true;
                    emojiCustomUI.bls();
                    emojiCustomUI.m55579a(C33961a.EMPTY);
                }
                if (emojiCustomUI.kZn != C2944c.SYNCING) {
                    emojiCustomUI.m55580a(C2944c.SYNCING);
                    AppMethodBeat.m2505o(53361);
                    return;
                }
                break;
            case Wait:
                if (C5023at.isConnected(emojiCustomUI)) {
                    emojiCustomUI.kZz = false;
                    emojiCustomUI.enableOptionMenu(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(1003);
                    }
                    emojiCustomUI.kZu.setVisibility(0);
                    emojiCustomUI.m55589go(false);
                    emojiCustomUI.m55579a(C33961a.START);
                    emojiCustomUI.m55580a(C2944c.WITH_OUT_ADD);
                    AppMethodBeat.m2505o(53361);
                    return;
                }
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, false);
                emojiCustomUI.bls();
                emojiCustomUI.m55580a(C2944c.WITH_OUT_ADD);
                AppMethodBeat.m2505o(53361);
                return;
            case End:
                emojiCustomUI.kZz = false;
                emojiCustomUI.enableOptionMenu(0, true);
                emojiCustomUI.bls();
                emojiCustomUI.m55580a(C2944c.NORMAL);
                break;
        }
        AppMethodBeat.m2505o(53361);
    }

    static /* synthetic */ void blw() {
        AppMethodBeat.m2504i(53363);
        C4879a.xxA.mo10055m(new C45348ny());
        AppMethodBeat.m2505o(53363);
    }

    /* renamed from: k */
    static /* synthetic */ void m55593k(EmojiCustomUI emojiCustomUI) {
        int i;
        AppMethodBeat.m2504i(53365);
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        if (emojiCustomUI.kZB == null) {
            i = 0;
        } else {
            i = emojiCustomUI.kZB.size();
        }
        objArr[0] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr);
        if (emojiCustomUI.kZB == null || emojiCustomUI.kZB.size() <= 0) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            AppMethodBeat.m2505o(53365);
            return;
        }
        emojiCustomUI.m55575JP(emojiCustomUI.getString(C25738R.string.b_2));
        ArrayList arrayList = emojiCustomUI.kZB;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        C4990ab.m7417i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            C1720g.m3535RO().eJo.mo14541a(new C33949c(emojiCustomUI.kZC, 2, emojiCustomUI.kZB), 0);
        }
        C4990ab.m7417i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", Boolean.valueOf(emojiCustomUI.kZx));
        if (emojiCustomUI.kZx) {
            emojiCustomUI.kZx = false;
            C1720g.m3536RP().mo5239Ry().set(348162, Boolean.TRUE);
            C27731a.bjE();
        }
        emojiCustomUI.blt();
        AppMethodBeat.m2505o(53365);
    }
}
