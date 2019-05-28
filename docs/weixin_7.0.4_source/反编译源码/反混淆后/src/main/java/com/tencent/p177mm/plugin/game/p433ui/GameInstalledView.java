package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.model.C20998j.C20997a;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.ui.GameInstalledView */
public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static int njA = 6;
    private static int njB = 7;
    private static Map<String, Integer> njy = new HashMap();
    private int count = 0;
    private Context mContext;
    private int mXC = 0;
    private LinkedList<C40439f> mYj = new LinkedList();
    private C20997a ngQ = new C432012();
    private int njC = 4;
    private int njD = 1;
    private int njE = 999;
    private C12185a njF;
    private LinkedList<C20992c> njG;
    LayoutParams njH = new LayoutParams(-1, -2);
    private LinearLayout nju;
    private ImageView njv;
    private TextView njw;
    private TextView njx;
    private final DisplayMetrics njz = new DisplayMetrics();

    /* renamed from: com.tencent.mm.plugin.game.ui.GameInstalledView$a */
    public static class C12185a {
        public String hAh = "";
        public String iconUrl = "";
        public String title = "";
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameInstalledView$2 */
    class C432012 implements C20997a {
        C432012() {
        }

        /* renamed from: f */
        public final void mo36316f(int i, String str, boolean z) {
            AppMethodBeat.m2504i(111998);
            switch (i) {
                case 1:
                case 2:
                    AppMethodBeat.m2505o(111998);
                    return;
                case 3:
                    ((C43156b) C1720g.m3528K(C43156b.class)).bCV().init(GameInstalledView.this.mContext);
                    GameInstalledView.this.mo68693gO(false);
                    break;
            }
            AppMethodBeat.m2505o(111998);
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m76811b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    static {
        AppMethodBeat.m2504i(112005);
        AppMethodBeat.m2505o(112005);
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111999);
        this.mContext = context;
        AppMethodBeat.m2505o(111999);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112000);
        super.onFinishInflate();
        this.nju = (LinearLayout) findViewById(2131824397);
        C20998j.m32284a(this.ngQ);
        AppMethodBeat.m2505o(112000);
    }

    /* renamed from: gO */
    public final void mo68693gO(boolean z) {
        AppMethodBeat.m2504i(112001);
        if (C5046bo.m7548ek(this.njG)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112001);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.mYj = C20993e.bDQ();
            if (!(C5046bo.m7548ek(this.njG) || C5046bo.m7548ek(this.mYj))) {
                it = this.njG.iterator();
                while (it.hasNext()) {
                    C20992c c20992c = (C20992c) it.next();
                    if (this.mYj.contains(c20992c)) {
                        this.mYj.remove(c20992c);
                        this.mYj.addFirst(c20992c);
                    }
                }
            }
        } else {
            C40439f c40439f;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.mYj);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(C20993e.bDQ());
            LinkedList linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c40439f = (C40439f) it2.next();
                if (!(linkedList2.contains(c40439f) || linkedList3.contains(c40439f))) {
                    linkedList3.add(c40439f);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c40439f = (C40439f) it2.next();
                if (linkedList2.contains(c40439f)) {
                    linkedList2.remove(c40439f);
                } else if (!C46494g.m87726a(this.mContext, c40439f)) {
                    linkedList3.add(c40439f);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    c40439f = (C40439f) it3.next();
                    if (!linkedList.contains(c40439f)) {
                        linkedList.addFirst(c40439f);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(C46494g.m87739bT(((C40439f) it.next()).field_appId, true));
            }
            this.mYj = linkedList2;
        }
        bFp();
        AppMethodBeat.m2505o(112001);
    }

    private void bFp() {
        AppMethodBeat.m2504i(112002);
        if (C5046bo.m7548ek(this.mYj)) {
            setVisibility(8);
            AppMethodBeat.m2505o(112002);
            return;
        }
        setVisibility(0);
        this.nju.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.mYj.size() >= this.njC - 1) {
            njB = 7;
            njA = 6;
            int b = C4977b.m7371b(this.mContext, (float) ((njA << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.njz);
            int i = (int) (((float) (this.njz.widthPixels * 160)) / ((float) this.njz.densityDpi));
            this.njC = ((this.njz.widthPixels - 1) / b) + 1;
            if (this.njC == 3) {
                njB = 3;
            }
            b = (njA << 1) + 84;
            int i2 = (njA + 6) + njB;
            i = (i - 16) % b;
            if (i < i2) {
                njA -= 2;
                C4977b.m7371b(this.mContext, (float) ((njA << 1) + 84));
            } else if (i > b - i2) {
                njA = ((i - (b >> 1)) / this.njC) + njA;
                C4977b.m7371b(this.mContext, (float) ((njA << 1) + 84));
            }
        }
        this.njH.setMargins(C4977b.m7371b(this.mContext, (float) njA), 0, C4977b.m7371b(this.mContext, (float) njA), 0);
        Iterator it = this.mYj.iterator();
        while (it.hasNext()) {
            C40439f c40439f = (C40439f) it.next();
            View inflate = layoutInflater.inflate(2130969867, null);
            this.njv = (ImageView) inflate.findViewById(2131821535);
            this.njw = (TextView) inflate.findViewById(2131821537);
            this.njx = (TextView) inflate.findViewById(2131825016);
            Bitmap b2 = C46494g.m87732b(c40439f.field_appId, 1, C1338a.getDensity(this.mContext));
            if (b2 != null) {
                this.njv.setImageBitmap(b2);
            } else {
                this.njv.setImageResource(C25738R.drawable.aau);
            }
            this.njw.setText(C46494g.m87733b(this.mContext, c40439f, null));
            if (C46494g.m87726a(this.mContext, c40439f)) {
                int Or = C46001c.m85447Or(c40439f.field_packageName);
                if (njy.containsKey(c40439f.field_appId) && ((Integer) njy.get(c40439f.field_appId)).intValue() > Or) {
                    FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(c40439f.field_appId);
                    this.njx.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12045qg));
                    if (Ir.status == 1) {
                        this.njx.setText(C25738R.string.c4n);
                    } else {
                        this.njx.setText(C25738R.string.c4m);
                    }
                } else if (C5046bo.isNullOrNil(c40439f.dne)) {
                    this.njx.setText("");
                } else {
                    this.njx.setText(c40439f.dne);
                    this.njx.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12058qx));
                }
            } else {
                this.njx.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12045qg));
                this.njx.setText(C25738R.string.c6d);
            }
            inflate.setTag(c40439f);
            inflate.setOnClickListener(this);
            this.nju.addView(inflate, this.njH);
        }
        if (!(this.njF == null || this.njF.iconUrl == null || this.njF.title == null)) {
            final View inflate2 = layoutInflater.inflate(2130969867, null);
            this.njv = (ImageView) inflate2.findViewById(2131821535);
            this.njw = (TextView) inflate2.findViewById(2131821537);
            this.njx = (TextView) inflate2.findViewById(2131825016);
            C25815a ahp = C32291o.ahp();
            String str = this.njF.iconUrl;
            ImageView imageView = this.njv;
            C17927a c17927a = new C17927a();
            c17927a.ePG = true;
            ahp.mo43767a(str, imageView, c17927a.ahG(), new C9014g() {

                /* renamed from: com.tencent.mm.plugin.game.ui.GameInstalledView$1$1 */
                class C282501 implements Runnable {
                    C282501() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(111996);
                        if (GameInstalledView.this.count == 0) {
                            GameInstalledView.m76811b(GameInstalledView.this);
                            GameInstalledView.this.nju.addView(inflate2, GameInstalledView.this.njH);
                        }
                        AppMethodBeat.m2505o(111996);
                    }
                }

                /* renamed from: sH */
                public final void mo7596sH(String str) {
                }

                /* renamed from: a */
                public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                    return null;
                }

                /* renamed from: b */
                public final void mo7595b(String str, View view, C37477b c37477b) {
                    AppMethodBeat.m2504i(111997);
                    if (c37477b.status == 0) {
                        C5004al.m7441d(new C282501());
                    }
                    AppMethodBeat.m2505o(111997);
                }
            });
            this.njw.setText(this.njF.title);
            this.njx.setVisibility(8);
            inflate2.setTag(this.njF);
            inflate2.setOnClickListener(this);
        }
        AppMethodBeat.m2505o(112002);
    }

    public void setMoreGameInfo(C12185a c12185a) {
        this.njF = c12185a;
    }

    public void setInstalledGameInfo(LinkedList<C20992c> linkedList) {
        this.njG = linkedList;
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    public void setVersionCodes(Map<String, Integer> map) {
        AppMethodBeat.m2504i(112003);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.m2505o(112003);
            return;
        }
        njy = map;
        AppMethodBeat.m2505o(112003);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112004);
        if (view.getTag() == null) {
            AppMethodBeat.m2505o(112004);
        } else if (view.getTag() instanceof C40439f) {
            C40439f c40439f = (C40439f) view.getTag();
            FileDownloadTaskInfo Ir;
            if (c40439f == null || C5046bo.isNullOrNil(c40439f.field_appId)) {
                C4990ab.m7412e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                AppMethodBeat.m2505o(112004);
            } else if (C46494g.m87726a(this.mContext, c40439f)) {
                int Or = C46001c.m85447Or(c40439f.field_packageName);
                if (!njy.containsKey(c40439f.field_appId) || ((Integer) njy.get(c40439f.field_appId)).intValue() <= Or) {
                    C20993e.m32265ak(this.mContext, c40439f.field_appId);
                    C34277b.m56210a(this.mContext, 10, 1002, this.njD, 3, 0, c40439f.field_appId, this.mXC, 0, null, null, null);
                    this.mYj.remove(c40439f);
                    this.mYj.addFirst(c40439f);
                } else {
                    Ir = C2896d.bij().mo7040Ir(c40439f.field_appId);
                    if (Ir.status == 1) {
                        C2896d.bij().mo7047hl(Ir.f16167id);
                    } else {
                        if (Ir.status == 3) {
                            if (!C5730e.m8628ct(Ir.path) || C46001c.m85448Os(Ir.path) <= Or) {
                                C2896d.bij().mo7047hl(Ir.f16167id);
                            } else {
                                C35800q.m58697a(this.mContext, Uri.fromFile(new File(Ir.path)), null);
                            }
                        }
                        C20998j.m32292n(c40439f.dna, c40439f.dnf, c40439f.field_appId, "");
                        C2901a c2901a = new C2901a();
                        c2901a.mo7055It(c40439f.dna);
                        c2901a.mo7057Iv(C46494g.m87733b(this.mContext, c40439f, null));
                        c2901a.setAppId(c40439f.field_appId);
                        c2901a.mo7058Iw(c40439f.dnf);
                        c2901a.mo7063ga(true);
                        c2901a.mo7069tN(1);
                        C2896d.bij().mo7042a(c2901a.kNl);
                    }
                }
                mo68693gO(false);
                AppMethodBeat.m2505o(112004);
            } else {
                Ir = C2896d.bij().mo7040Ir(c40439f.field_appId);
                if (Ir == null || Ir.status != 3) {
                    C4990ab.m7417i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", c40439f.field_appName);
                    mo68693gO(false);
                    AppMethodBeat.m2505o(112004);
                } else if (C5046bo.isNullOrNil(Ir.path) || !C5730e.m8628ct(Ir.path)) {
                    C4990ab.m7413e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", Ir.path);
                    C2896d.bij().mo7047hl(Ir.f16167id);
                    mo68693gO(false);
                    AppMethodBeat.m2505o(112004);
                } else {
                    C35800q.m58697a(this.mContext, Uri.fromFile(new File(Ir.path)), null);
                    AppMethodBeat.m2505o(112004);
                }
            }
        } else {
            if (view.getTag() instanceof C12185a) {
                C12185a c12185a = (C12185a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (C5046bo.isNullOrNil(c12185a.hAh)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = C46001c.m85464t(this.mContext, c12185a.hAh, "game_center_installed_more");
                }
                C34277b.m56210a(this.mContext, 10, 1002, this.njE, i, 0, null, this.mXC, 0, null, null, null);
            }
            AppMethodBeat.m2505o(112004);
        }
    }
}
