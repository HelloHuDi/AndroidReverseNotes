package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private OnDismissListener Uf = new OnDismissListener() {
        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(125858);
            AppChooserUI.this.finish();
            AppMethodBeat.o(125858);
        }
    };
    private PackageManager bCX;
    private String mimeType = null;
    private int scene = 0;
    private a vta;
    private Intent vtb = null;
    private int vtc;
    private String vtd = null;
    private Bundle vte = null;
    private r vtf = null;
    private ArrayList<String> vtg = null;
    private c vth = null;
    private c vti = new c();
    private List<c> vtj;
    private boolean vtk = false;
    private String vtl;
    private int vtm;
    private int vtn;
    private boolean vto = false;
    private boolean vtp = false;
    private boolean vtq = false;
    private long vtr;
    private e vts;
    private OnItemClickListener vtt = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(125854);
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vth = AppChooserUI.this.vta.Lq(i);
                AppChooserUI.this.vta.notifyDataSetChanged();
                if (AppChooserUI.this.vts != null && AppChooserUI.this.vts.gLj.isShowing()) {
                    if (AppChooserUI.this.vth == null || !AppChooserUI.this.vth.vtF || (AppChooserUI.this.vth.nue && (AppChooserUI.this.vth.sKP || AppChooserUI.this.vtm >= AppChooserUI.this.vtn))) {
                        AppChooserUI.this.vts.oU(true);
                    } else {
                        AppChooserUI.this.vts.oU(false);
                    }
                }
                if (!((AppChooserUI.this.scene != 6 && AppChooserUI.this.vtc != 2) || AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                    AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, false);
                    h.pYm.e(12809, Integer.valueOf(4), AppChooserUI.this.vth.vtC.activityInfo.packageName);
                }
            }
            AppMethodBeat.o(125854);
        }
    };
    private OnClickListener vtu = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(125855);
            if (!(AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.this.vth.vtC.activityInfo.packageName);
                AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, true);
            }
            AppMethodBeat.o(125855);
        }
    };
    private OnClickListener vtv = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(125856);
            if (!(AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, false);
            }
            AppMethodBeat.o(125856);
        }
    };
    private View.OnClickListener vtw = new View.OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(125857);
            ab.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (AppChooserUI.this.vta != null) {
                f fVar = AppChooserUI.this.vta.vtz;
                if (fVar == f.UNINSTALL) {
                    if (AppChooserUI.this.vts != null && AppChooserUI.this.vts.gLj.isShowing()) {
                        AppChooserUI.this.vta.vtz = f.DOWNLOADING;
                        AppChooserUI.this.vta.notifyDataSetChanged();
                    }
                    com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                    if (AppChooserUI.this.scene == 1) {
                        aVar.It("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
                    } else {
                        aVar.It(AppChooserUI.this.vtf.anK());
                    }
                    aVar.Iv(AppChooserUI.this.vtf.dgX());
                    aVar.tN(1);
                    aVar.ga(true);
                    com.tencent.mm.plugin.downloader.model.d.bij().a(aVar.kNl);
                    s.dhn();
                    s.Ku(AppChooserUI.this.vtc);
                    if (AppChooserUI.this.vtc == 0) {
                        if (AppChooserUI.this.vtp) {
                            h.pYm.e(11168, Integer.valueOf(4), Integer.valueOf(AppChooserUI.this.scene));
                        } else {
                            h.pYm.e(11168, Integer.valueOf(3), Integer.valueOf(AppChooserUI.this.scene));
                        }
                    }
                    if (AppChooserUI.this.vtc == 1) {
                        h.pYm.e(12809, Integer.valueOf(5), "");
                    }
                    AppMethodBeat.o(125857);
                    return;
                } else if (fVar == f.DOWNLOADED) {
                    AppChooserUI appChooserUI = AppChooserUI.this;
                    long j = AppChooserUI.this.vtr;
                    ab.i("MicroMsg.AppChooserUI", "installRecommendApp");
                    ab.d("MicroMsg.AppChooserUI", "filepath:%s", String.valueOf(com.tencent.mm.plugin.downloader.model.d.bij().hm(j).path));
                    q.a(appChooserUI.mController.ylL, Uri.fromFile(new File(r1)), new com.tencent.mm.pluginsdk.permission.a() {
                        public final void dT(boolean z) {
                            AppMethodBeat.i(125864);
                            if (!z) {
                                g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0));
                                if (AppChooserUI.this.vta != null) {
                                    AppChooserUI.this.vta.vtz = f.UNINSTALL;
                                    AppChooserUI.this.vta.notifyDataSetChanged();
                                }
                            } else if (AppChooserUI.this.vta != null) {
                                AppChooserUI.this.vta.vtz = f.DOWNLOADED;
                                AppChooserUI.this.vta.notifyDataSetChanged();
                                AppMethodBeat.o(125864);
                                return;
                            }
                            AppMethodBeat.o(125864);
                        }
                    });
                }
            }
            AppMethodBeat.o(125857);
        }
    };
    private k vtx = new k() {
        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.i(125859);
            AppChooserUI.this.vtr = j;
            g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.vtr));
            ab.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
            AppMethodBeat.o(125859);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.i(125860);
            ab.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
            AppMethodBeat.o(125860);
        }

        public final void b(long j, String str, boolean z) {
            AppMethodBeat.i(125861);
            ab.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!bo.isNullOrNil(str) && com.tencent.mm.a.e.ct(str)) {
                g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.vtr));
                if (AppChooserUI.this.vta != null && AppChooserUI.this.vtr == j) {
                    AppChooserUI.this.vta.vtz = f.DOWNLOADED;
                    AppChooserUI.this.vta.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(125861);
        }

        public final void b(long j, int i, boolean z) {
            AppMethodBeat.i(125862);
            ab.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0));
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vta.vtz = f.UNINSTALL;
                AppChooserUI.this.vta.notifyDataSetChanged();
            }
            AppMethodBeat.o(125862);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.i(125863);
            ab.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            g.RP().Ry().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0));
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vta.vtz = f.UNINSTALL;
                AppChooserUI.this.vta.notifyDataSetChanged();
            }
            AppMethodBeat.o(125863);
        }

        public final void gm(long j) {
        }

        public final void i(long j, String str) {
        }

        public final void gn(long j) {
        }
    };

    class a extends BaseAdapter {
        List<c> kSg = new ArrayList();
        f vtz = f.UNINSTALL;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(125870);
            c Lq = Lq(i);
            AppMethodBeat.o(125870);
            return Lq;
        }

        public a() {
            AppMethodBeat.i(125865);
            AppChooserUI.this.bCX = AppChooserUI.this.getPackageManager();
            AppMethodBeat.o(125865);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            AppMethodBeat.i(125866);
            c Lq = Lq(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(AppChooserUI.this.mController.ylL).inflate(Lq.vtF ? R.layout.e0 : R.layout.dz, null);
                b bVar2 = new b(view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (Lq.vtE == null) {
                new d().execute(new c[]{Lq});
            }
            bVar.nmi.setImageDrawable(Lq.vtE);
            CharSequence charSequence = Lq.vtD;
            if (Lq.vtC == null) {
                AppChooserUI.this.finish();
                AppMethodBeat.o(125866);
            } else {
                if (AppChooserUI.this.vtk && Lq.vtC.activityInfo.packageName.equals(AppChooserUI.this.vtl)) {
                    charSequence = TextUtils.concat(new CharSequence[]{charSequence, AppChooserUI.this.getString(R.string.p3)});
                    if (AppChooserUI.this.vth == null) {
                        AppChooserUI.this.vth = Lq;
                    }
                }
                bVar.nmj.setText(charSequence);
                if (Lq == null || (!(!Lq.vtF || Lq.sKP || (Lq.vtF && Lq.nue && AppChooserUI.this.vtm >= AppChooserUI.this.vtn)) || Lq.vtG)) {
                    bVar.vtA.setVisibility(0);
                    bVar.vtB.setVisibility(8);
                    bVar.vtA.setOnClickListener(AppChooserUI.this.vtw);
                    if (this.vtz == f.UNINSTALL) {
                        if (Lq.vtG) {
                            bVar.vtA.setText(R.string.rz);
                        } else {
                            bVar.vtA.setText(R.string.p_);
                        }
                        bVar.vtA.setEnabled(true);
                    } else if (this.vtz == f.DOWNLOADING) {
                        bVar.vtA.setText(R.string.pf);
                        bVar.vtA.setEnabled(false);
                    } else if (this.vtz == f.DOWNLOADED) {
                        if (Lq.vtG) {
                            bVar.vtA.setText(R.string.u1);
                        } else {
                            bVar.vtA.setText(R.string.u0);
                        }
                        bVar.vtA.setEnabled(true);
                    }
                } else {
                    boolean z;
                    bVar.vtA.setVisibility(8);
                    bVar.vtB.setVisibility(0);
                    RadioButton radioButton = bVar.vtB;
                    c c = AppChooserUI.this.vth;
                    if (c instanceof c) {
                        c = c;
                        if (!(c.vtC == null || Lq.vtC == null || !c.vtC.activityInfo.packageName.equals(Lq.vtC.activityInfo.packageName)) || (c.vtF && Lq.vtF)) {
                            z = true;
                            radioButton.setChecked(z);
                        }
                    }
                    z = false;
                    radioButton.setChecked(z);
                }
                if (Lq.vtF) {
                    if (AppChooserUI.this.scene == 4) {
                        bVar.nml.setText(R.string.df4);
                    } else {
                        bVar.nml.setText(bo.nullAsNil(AppChooserUI.this.vtd));
                    }
                    TextView textView = bVar.nml;
                    if (bo.isNullOrNil(AppChooserUI.this.vtd)) {
                        i2 = 8;
                    }
                    textView.setVisibility(i2);
                } else {
                    bVar.nml.setVisibility(8);
                }
                if (!(AppChooserUI.this.scene == 6 || AppChooserUI.this.vth == null || !AppChooserUI.this.vth.equals(Lq))) {
                    bVar.vtB.setChecked(true);
                }
                AppMethodBeat.o(125866);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final c Lq(int i) {
            AppMethodBeat.i(125867);
            if (this.kSg == null) {
                AppMethodBeat.o(125867);
                return null;
            }
            c cVar = (c) this.kSg.get(i);
            AppMethodBeat.o(125867);
            return cVar;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(125868);
            if (Lq(i).vtF) {
                AppMethodBeat.o(125868);
                return 1;
            }
            AppMethodBeat.o(125868);
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.i(125869);
            if (this.kSg == null) {
                AppMethodBeat.o(125869);
                return 0;
            }
            int size = this.kSg.size();
            AppMethodBeat.o(125869);
            return size;
        }
    }

    class b {
        ImageView nmi;
        TextView nmj;
        TextView nml;
        TextView vtA;
        RadioButton vtB;

        public b(View view) {
            AppMethodBeat.i(125871);
            this.nmi = (ImageView) view.findViewById(R.id.xb);
            this.nmj = (TextView) view.findViewById(R.id.xc);
            this.nml = (TextView) view.findViewById(R.id.xd);
            this.vtA = (TextView) view.findViewById(R.id.xe);
            this.vtB = (RadioButton) view.findViewById(R.id.xf);
            AppMethodBeat.o(125871);
        }
    }

    class c {
        boolean nue;
        boolean sKP;
        ResolveInfo vtC;
        CharSequence vtD;
        Drawable vtE;
        boolean vtF;
        boolean vtG;

        public c(ResolveInfo resolveInfo, CharSequence charSequence) {
            this.vtC = resolveInfo;
            this.vtD = charSequence;
            this.vtF = false;
            this.sKP = true;
            this.vtG = false;
        }
    }

    public enum f {
        UNINSTALL,
        DOWNLOADING,
        DOWNLOADED;

        static {
            AppMethodBeat.o(125878);
        }
    }

    class d extends AsyncTask<c, Void, c> {
        d() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(125873);
            c cVar = ((c[]) objArr)[0];
            if (cVar.vtE == null) {
                cVar.vtE = AppChooserUI.a(AppChooserUI.this, cVar.vtC);
            }
            AppMethodBeat.o(125873);
            return cVar;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(125872);
            AppChooserUI.this.vta.notifyDataSetChanged();
            AppMethodBeat.o(125872);
        }
    }

    class e {
        OnDismissListener Uf;
        public com.tencent.mm.ui.widget.a.c gLj;
        BaseAdapter khG;
        Context mContext;
        String mTitle;
        ListViewInScrollView vtH = ((ListViewInScrollView) View.inflate(this.mContext, R.layout.dy, null));
        OnItemClickListener vtI;
        OnClickListener vtJ;
        OnClickListener vtv;

        public e(Context context) {
            AppMethodBeat.i(125874);
            this.mContext = context;
            AppMethodBeat.o(125874);
        }

        public final void oU(boolean z) {
            AppMethodBeat.i(125875);
            if (this.gLj != null) {
                if (z) {
                    this.gLj.a((int) R.string.ua, this.vtv);
                    this.gLj.b(R.string.u_, this.vtJ);
                } else {
                    this.gLj.a((int) R.string.ua, null);
                    this.gLj.b(R.string.u_, null);
                    AppMethodBeat.o(125875);
                    return;
                }
            }
            AppMethodBeat.o(125875);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppChooserUI() {
        AppMethodBeat.i(125879);
        AppMethodBeat.o(125879);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125880);
        super.onCreate(bundle);
        s.dhn();
        s.Kr(this.vtc);
        ae.a(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.vtb = (Intent) parcelableExtra;
            String stringExtra = intent.getStringExtra("title");
            this.vtc = intent.getIntExtra("type", 0);
            this.vtk = intent.getBooleanExtra("openWay", false);
            this.vte = intent.getBundleExtra("transferback");
            this.vtg = intent.getStringArrayListExtra("targetwhitelist");
            this.vtp = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (g.RK()) {
                boolean z;
                this.vtl = (String) g.RP().Ry().get(Lp(274528), (Object) "");
                if (TextUtils.isEmpty(this.vtl) || !p.u(this.mController.ylL, this.vtl) || (!(this.vtg == null || this.vtg.isEmpty() || this.vtg.contains(this.vtl)) || this.vtk)) {
                    z = false;
                } else {
                    Intent intent2 = new Intent(this.vtb);
                    intent2.setPackage(this.vtl);
                    if (bo.k((Context) this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    int size;
                    this.bCX = getPackageManager();
                    this.vta = new a();
                    s.dhn();
                    this.vtf = s.y(this.vtc, intent.getBundleExtra("key_recommend_params"));
                    this.vto = this.vtf.fE(this.mController.ylL);
                    this.vtm = ((Integer) g.RP().Ry().get(274496 + this.vtc, Integer.valueOf(0))).intValue();
                    s.dhn();
                    this.vtn = s.Kq(this.vtc);
                    ab.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.vto), Integer.valueOf(this.vtm));
                    this.vtq = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.vtm >= this.vtn) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.vtj = a(this.vtb, dlk(), this.vtg);
                    if (!(z2 || this.vto)) {
                        g.RP().Ry().set(274496 + this.vtc, Integer.valueOf(this.vtm + 1));
                    }
                    if (this.vto) {
                        s.dhn();
                        s.Kt(this.vtc);
                    } else if (!z2) {
                        s.dhn();
                        s.Ks(this.vtc);
                    }
                    String str = "MicroMsg.AppChooserUI";
                    String str2 = "mResolveListData size %d";
                    Object[] objArr = new Object[1];
                    if (this.vtj != null) {
                        size = this.vtj.size();
                    } else {
                        size = 0;
                    }
                    objArr[0] = Integer.valueOf(size);
                    ab.i(str, str2, objArr);
                    if (this.vtj == null || this.vtj.size() != 1 || (dlk() && !this.vto)) {
                        setTitleVisibility(8);
                        if (this.vtj == null || this.vtj.isEmpty()) {
                            i(4097, null, false);
                            AppMethodBeat.o(125880);
                            return;
                        }
                        this.vta.kSg = this.vtj;
                        this.vtr = ((Long) g.RP().Ry().get(Lp(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(this.vtr);
                        ab.d("MicroMsg.AppChooserUI", "downloadId:" + this.vtr + ", status:" + hm.status);
                        if (3 == hm.status && com.tencent.mm.a.e.ct(hm.path) && this.vta != null) {
                            this.vta.vtz = f.DOWNLOADED;
                            this.vta.notifyDataSetChanged();
                        }
                        this.vts = new e(this.mController.ylL);
                        e eVar = this.vts;
                        if (stringExtra != null) {
                            eVar.mTitle = stringExtra.toString();
                        } else {
                            eVar.mTitle = null;
                        }
                        this.vts.vtI = this.vtt;
                        this.vts.vtv = this.vtv;
                        this.vts.vtJ = this.vtu;
                        this.vts.khG = this.vta;
                        this.vts.Uf = this.Uf;
                        e eVar2 = this.vts;
                        if (eVar2.vtI != null) {
                            eVar2.vtH.setOnItemClickListener(eVar2.vtI);
                        }
                        if (eVar2.khG != null) {
                            eVar2.vtH.setAdapter(eVar2.khG);
                        }
                        eVar2.gLj = com.tencent.mm.ui.base.h.a(eVar2.mContext, true, eVar2.mTitle, eVar2.vtH, eVar2.mContext.getString(R.string.ua), eVar2.mContext.getString(R.string.u_), eVar2.vtv, eVar2.vtJ, (int) R.color.r8);
                        eVar2.gLj.setOnDismissListener(eVar2.Uf);
                        eVar2.gLj.show();
                        if (!(this.vtp || !this.vto || z2)) {
                            this.vth = this.vti;
                            this.vts.oU(true);
                        }
                        com.tencent.mm.plugin.downloader.model.d.bij();
                        com.tencent.mm.plugin.downloader.model.b.a(this.vtx);
                        AppMethodBeat.o(125880);
                        return;
                    }
                    c cVar = (c) this.vtj.get(0);
                    if (cVar == null) {
                        i(4097, null, false);
                        AppMethodBeat.o(125880);
                        return;
                    } else if (cVar.vtC != null) {
                        i(-1, cVar.vtC.activityInfo.packageName, false);
                        AppMethodBeat.o(125880);
                        return;
                    } else {
                        i(4098, null, false);
                        AppMethodBeat.o(125880);
                        return;
                    }
                }
                i(-1, this.vtl, true);
                AppMethodBeat.o(125880);
                return;
            }
            ab.e("MicroMsg.AppChooserUI", "acc not ready");
            i(4097, null, false);
            AppMethodBeat.o(125880);
            return;
        }
        ab.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(parcelableExtra)));
        i(0, null, false);
        AppMethodBeat.o(125880);
    }

    public void onResume() {
        AppMethodBeat.i(125881);
        super.onResume();
        if (this.vtp && this.vtb != null && this.vtf.F(this, this.vtb)) {
            ab.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.vtp = false;
            this.vti.vtG = false;
        }
        this.vto = this.vtf.fE(this.mController.ylL);
        this.vtj = a(this.vtb, dlk(), this.vtg);
        if (this.vto && this.vth == null && !this.vtk) {
            this.vth = this.vti;
            this.vts.oU(true);
        }
        if (this.vta != null) {
            this.vta.kSg = this.vtj;
            this.vta.notifyDataSetChanged();
        }
        AppMethodBeat.o(125881);
    }

    public void onDestroy() {
        AppMethodBeat.i(125882);
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(this.vtx);
        if (this.vts != null) {
            this.vts.gLj.dismiss();
        }
        AppMethodBeat.o(125882);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        AppMethodBeat.i(125883);
        super.onBackPressed();
        i(0, null, false);
        AppMethodBeat.o(125883);
    }

    private int Lp(int i) {
        AppMethodBeat.i(125884);
        int hashCode;
        if (this.mimeType != null) {
            hashCode = (this.vtc + i) + this.mimeType.hashCode();
            AppMethodBeat.o(125884);
            return hashCode;
        }
        hashCode = this.vtc + i;
        AppMethodBeat.o(125884);
        return hashCode;
    }

    private void i(int i, String str, boolean z) {
        AppMethodBeat.i(125885);
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.vte);
        setResult(i, intent);
        finish();
        AppMethodBeat.o(125885);
    }

    private void dlj() {
        AppMethodBeat.i(125886);
        com.tencent.mm.pluginsdk.model.s.a dgY = this.vtf.dgY();
        if (!bo.isNullOrNil(dgY.vbE)) {
            this.vtd = dgY.vbE;
        } else if (dgY.vbD > 0) {
            this.vtd = getResources().getString(dgY.vbD);
        }
        if (dgY.vbC > 0) {
            this.vti.vtE = getResources().getDrawable(dgY.vbC);
        }
        if (dgY.vbF > 0) {
            this.vti.vtD = getResources().getString(dgY.vbF);
        } else {
            this.vti.vtD = dgY.vbG;
        }
        this.vti.vtF = true;
        this.vti.sKP = this.vto;
        if (this.vto) {
            this.vti.nue = true;
        }
        if (this.vtp) {
            this.vti.vtG = true;
        }
        AppMethodBeat.o(125886);
    }

    private boolean dlk() {
        AppMethodBeat.i(125887);
        ab.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.vtq), Integer.valueOf(this.vtm), Integer.valueOf(this.vtn), Boolean.valueOf(bo.gT(this)));
        if (!this.vtq || this.vtm >= this.vtn || bo.gT(this) || com.tencent.mm.sdk.platformtools.g.cdf == 1) {
            AppMethodBeat.o(125887);
            return false;
        }
        AppMethodBeat.o(125887);
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        AppMethodBeat.i(125888);
        ArrayList arrayList2 = new ArrayList();
        List queryIntentActivities = this.bCX.queryIntentActivities(intent, 65536);
        dlj();
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                ab.i("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.vtf.aix(str)) {
                            this.vti.vtC = resolveInfo;
                            this.vti.nue = true;
                            if ((!z && this.vto) || (!z && this.vti.nue)) {
                                arrayList2.add(0, this.vti);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(resolveInfo, this.vtf.a(this.mController.ylL, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && obj == null) {
            if (this.vtc != 0 || this.mimeType == null) {
                arrayList2.add(0, this.vti);
            } else {
                arrayList2.add(0, this.vti);
                if (this.vtp) {
                    h.pYm.e(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    h.pYm.e(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
                }
            }
        }
        if (this.scene == 4 && this.vti.vtC == null) {
            this.vti.vtC = new ResolveInfo();
            this.vti.vtC.activityInfo = new ActivityInfo();
            this.vti.vtC.activityInfo.packageName = TbsConfig.APP_QB;
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.vtC != null) {
                String str2 = cVar.vtC.activityInfo.packageName;
                if (!(bo.isNullOrNil(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        AppMethodBeat.o(125888);
        return arrayList2;
    }

    private static Drawable c(Resources resources, int i) {
        Drawable d;
        AppMethodBeat.i(125889);
        try {
            d = com.tencent.mm.ca.b.d(resources, i);
        } catch (NotFoundException e) {
            d = null;
        }
        AppMethodBeat.o(125889);
        return d;
    }

    private Drawable c(ResolveInfo resolveInfo) {
        Drawable c;
        AppMethodBeat.i(125890);
        try {
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                c = c(this.bCX.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (c != null) {
                    AppMethodBeat.o(125890);
                    return c;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                c = c(this.bCX.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (c != null) {
                    ab.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", Integer.valueOf(iconResource));
                    AppMethodBeat.o(125890);
                    return c;
                }
            }
        } catch (NameNotFoundException e) {
            ab.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        c = resolveInfo.loadIcon(this.bCX);
        AppMethodBeat.o(125890);
        return c;
    }
}
