package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static int njA = 6;
    private static int njB = 7;
    private static Map<String, Integer> njy = new HashMap();
    private int count = 0;
    private Context mContext;
    private int mXC = 0;
    private LinkedList<f> mYj = new LinkedList();
    private com.tencent.mm.plugin.game.model.j.a ngQ = new com.tencent.mm.plugin.game.model.j.a() {
        public final void f(int i, String str, boolean z) {
            AppMethodBeat.i(111998);
            switch (i) {
                case 1:
                case 2:
                    AppMethodBeat.o(111998);
                    return;
                case 3:
                    ((b) g.K(b.class)).bCV().init(GameInstalledView.this.mContext);
                    GameInstalledView.this.gO(false);
                    break;
            }
            AppMethodBeat.o(111998);
        }
    };
    private int njC = 4;
    private int njD = 1;
    private int njE = 999;
    private a njF;
    private LinkedList<c> njG;
    LayoutParams njH = new LayoutParams(-1, -2);
    private LinearLayout nju;
    private ImageView njv;
    private TextView njw;
    private TextView njx;
    private final DisplayMetrics njz = new DisplayMetrics();

    public static class a {
        public String hAh = "";
        public String iconUrl = "";
        public String title = "";
    }

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    static {
        AppMethodBeat.i(112005);
        AppMethodBeat.o(112005);
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111999);
        this.mContext = context;
        AppMethodBeat.o(111999);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112000);
        super.onFinishInflate();
        this.nju = (LinearLayout) findViewById(R.id.c35);
        j.a(this.ngQ);
        AppMethodBeat.o(112000);
    }

    public final void gO(boolean z) {
        AppMethodBeat.i(112001);
        if (bo.ek(this.njG)) {
            setVisibility(8);
            AppMethodBeat.o(112001);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.mYj = e.bDQ();
            if (!(bo.ek(this.njG) || bo.ek(this.mYj))) {
                it = this.njG.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (this.mYj.contains(cVar)) {
                        this.mYj.remove(cVar);
                        this.mYj.addFirst(cVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.mYj);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(e.bDQ());
            LinkedList linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(com.tencent.mm.pluginsdk.model.app.g.bT(((f) it.next()).field_appId, true));
            }
            this.mYj = linkedList2;
        }
        bFp();
        AppMethodBeat.o(112001);
    }

    private void bFp() {
        AppMethodBeat.i(112002);
        if (bo.ek(this.mYj)) {
            setVisibility(8);
            AppMethodBeat.o(112002);
            return;
        }
        setVisibility(0);
        this.nju.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.mYj.size() >= this.njC - 1) {
            njB = 7;
            njA = 6;
            int b = BackwardSupportUtil.b.b(this.mContext, (float) ((njA << 1) + 84));
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
                BackwardSupportUtil.b.b(this.mContext, (float) ((njA << 1) + 84));
            } else if (i > b - i2) {
                njA = ((i - (b >> 1)) / this.njC) + njA;
                BackwardSupportUtil.b.b(this.mContext, (float) ((njA << 1) + 84));
            }
        }
        this.njH.setMargins(BackwardSupportUtil.b.b(this.mContext, (float) njA), 0, BackwardSupportUtil.b.b(this.mContext, (float) njA), 0);
        Iterator it = this.mYj.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(R.layout.a83, null);
            this.njv = (ImageView) inflate.findViewById(R.id.zr);
            this.njw = (TextView) inflate.findViewById(R.id.zt);
            this.njx = (TextView) inflate.findViewById(R.id.civ);
            Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(fVar.field_appId, 1, com.tencent.mm.bz.a.getDensity(this.mContext));
            if (b2 != null) {
                this.njv.setImageBitmap(b2);
            } else {
                this.njv.setImageResource(R.drawable.aau);
            }
            this.njw.setText(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, fVar, null));
            if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                int Or = com.tencent.mm.plugin.game.f.c.Or(fVar.field_packageName);
                if (njy.containsKey(fVar.field_appId) && ((Integer) njy.get(fVar.field_appId)).intValue() > Or) {
                    FileDownloadTaskInfo Ir = d.bij().Ir(fVar.field_appId);
                    this.njx.setTextColor(this.mContext.getResources().getColor(R.color.qg));
                    if (Ir.status == 1) {
                        this.njx.setText(R.string.c4n);
                    } else {
                        this.njx.setText(R.string.c4m);
                    }
                } else if (bo.isNullOrNil(fVar.dne)) {
                    this.njx.setText("");
                } else {
                    this.njx.setText(fVar.dne);
                    this.njx.setTextColor(this.mContext.getResources().getColor(R.color.qx));
                }
            } else {
                this.njx.setTextColor(this.mContext.getResources().getColor(R.color.qg));
                this.njx.setText(R.string.c6d);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.nju.addView(inflate, this.njH);
        }
        if (!(this.njF == null || this.njF.iconUrl == null || this.njF.title == null)) {
            final View inflate2 = layoutInflater.inflate(R.layout.a83, null);
            this.njv = (ImageView) inflate2.findViewById(R.id.zr);
            this.njw = (TextView) inflate2.findViewById(R.id.zt);
            this.njx = (TextView) inflate2.findViewById(R.id.civ);
            com.tencent.mm.at.a.a ahp = o.ahp();
            String str = this.njF.iconUrl;
            ImageView imageView = this.njv;
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePG = true;
            ahp.a(str, imageView, aVar.ahG(), new com.tencent.mm.at.a.c.g() {
                public final void sH(String str) {
                }

                public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                    return null;
                }

                public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                    AppMethodBeat.i(111997);
                    if (bVar.status == 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(111996);
                                if (GameInstalledView.this.count == 0) {
                                    GameInstalledView.b(GameInstalledView.this);
                                    GameInstalledView.this.nju.addView(inflate2, GameInstalledView.this.njH);
                                }
                                AppMethodBeat.o(111996);
                            }
                        });
                    }
                    AppMethodBeat.o(111997);
                }
            });
            this.njw.setText(this.njF.title);
            this.njx.setVisibility(8);
            inflate2.setTag(this.njF);
            inflate2.setOnClickListener(this);
        }
        AppMethodBeat.o(112002);
    }

    public void setMoreGameInfo(a aVar) {
        this.njF = aVar;
    }

    public void setInstalledGameInfo(LinkedList<c> linkedList) {
        this.njG = linkedList;
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    public void setVersionCodes(Map<String, Integer> map) {
        AppMethodBeat.i(112003);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(112003);
            return;
        }
        njy = map;
        AppMethodBeat.o(112003);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112004);
        if (view.getTag() == null) {
            AppMethodBeat.o(112004);
        } else if (view.getTag() instanceof f) {
            f fVar = (f) view.getTag();
            FileDownloadTaskInfo Ir;
            if (fVar == null || bo.isNullOrNil(fVar.field_appId)) {
                ab.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                AppMethodBeat.o(112004);
            } else if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                int Or = com.tencent.mm.plugin.game.f.c.Or(fVar.field_packageName);
                if (!njy.containsKey(fVar.field_appId) || ((Integer) njy.get(fVar.field_appId)).intValue() <= Or) {
                    e.ak(this.mContext, fVar.field_appId);
                    com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1002, this.njD, 3, 0, fVar.field_appId, this.mXC, 0, null, null, null);
                    this.mYj.remove(fVar);
                    this.mYj.addFirst(fVar);
                } else {
                    Ir = d.bij().Ir(fVar.field_appId);
                    if (Ir.status == 1) {
                        d.bij().hl(Ir.id);
                    } else {
                        if (Ir.status == 3) {
                            if (!com.tencent.mm.vfs.e.ct(Ir.path) || com.tencent.mm.plugin.game.f.c.Os(Ir.path) <= Or) {
                                d.bij().hl(Ir.id);
                            } else {
                                q.a(this.mContext, Uri.fromFile(new File(Ir.path)), null);
                            }
                        }
                        j.n(fVar.dna, fVar.dnf, fVar.field_appId, "");
                        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                        aVar.It(fVar.dna);
                        aVar.Iv(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, fVar, null));
                        aVar.setAppId(fVar.field_appId);
                        aVar.Iw(fVar.dnf);
                        aVar.ga(true);
                        aVar.tN(1);
                        d.bij().a(aVar.kNl);
                    }
                }
                gO(false);
                AppMethodBeat.o(112004);
            } else {
                Ir = d.bij().Ir(fVar.field_appId);
                if (Ir == null || Ir.status != 3) {
                    ab.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", fVar.field_appName);
                    gO(false);
                    AppMethodBeat.o(112004);
                } else if (bo.isNullOrNil(Ir.path) || !com.tencent.mm.vfs.e.ct(Ir.path)) {
                    ab.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", Ir.path);
                    d.bij().hl(Ir.id);
                    gO(false);
                    AppMethodBeat.o(112004);
                } else {
                    q.a(this.mContext, Uri.fromFile(new File(Ir.path)), null);
                    AppMethodBeat.o(112004);
                }
            }
        } else {
            if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (bo.isNullOrNil(aVar2.hAh)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = com.tencent.mm.plugin.game.f.c.t(this.mContext, aVar2.hAh, "game_center_installed_more");
                }
                com.tencent.mm.plugin.game.e.b.a(this.mContext, 10, 1002, this.njE, i, 0, null, this.mXC, 0, null, null, null);
            }
            AppMethodBeat.o(112004);
        }
    }
}
