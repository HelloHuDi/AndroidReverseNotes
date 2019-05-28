package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C14893s;
import com.tencent.p177mm.pluginsdk.model.C14893s.C14894a;
import com.tencent.p177mm.pluginsdk.model.C30081r;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.permission.C14900a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@C5271a(7)
/* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI */
public class AppChooserUI extends MMActivity {
    /* renamed from: Uf */
    private OnDismissListener f2136Uf = new C79155();
    private PackageManager bCX;
    private String mimeType = null;
    private int scene = 0;
    private C4761a vta;
    private Intent vtb = null;
    private int vtc;
    private String vtd = null;
    private Bundle vte = null;
    private C30081r vtf = null;
    private ArrayList<String> vtg = null;
    private C7916c vth = null;
    private C7916c vti = new C7916c();
    private List<C7916c> vtj;
    private boolean vtk = false;
    private String vtl;
    private int vtm;
    private int vtn;
    private boolean vto = false;
    private boolean vtp = false;
    private boolean vtq = false;
    private long vtr;
    private C7922e vts;
    private OnItemClickListener vtt = new C79201();
    private OnClickListener vtu = new C79182();
    private OnClickListener vtv = new C79213();
    private View.OnClickListener vtw = new C79134();
    private C11511k vtx = new C47606();

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$6 */
    class C47606 implements C11511k {
        C47606() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(125859);
            AppChooserUI.this.vtr = j;
            C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.vtr));
            C4990ab.m7411d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
            AppMethodBeat.m2505o(125859);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(125860);
            C4990ab.m7411d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
            AppMethodBeat.m2505o(125860);
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(125861);
            C4990ab.m7411d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!C5046bo.isNullOrNil(str) && C1173e.m2561ct(str)) {
                C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.this.vtr));
                if (AppChooserUI.this.vta != null && AppChooserUI.this.vtr == j) {
                    AppChooserUI.this.vta.vtz = C7917f.DOWNLOADED;
                    AppChooserUI.this.vta.notifyDataSetChanged();
                }
            }
            AppMethodBeat.m2505o(125861);
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(125862);
            C4990ab.m7411d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274560), Long.valueOf(0));
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vta.vtz = C7917f.UNINSTALL;
                AppChooserUI.this.vta.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(125862);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(125863);
            C4990ab.m7411d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274560), Long.valueOf(0));
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vta.vtz = C7917f.UNINSTALL;
                AppChooserUI.this.vta.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(125863);
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$a */
    class C4761a extends BaseAdapter {
        List<C7916c> kSg = new ArrayList();
        C7917f vtz = C7917f.UNINSTALL;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(125870);
            C7916c Lq = mo9906Lq(i);
            AppMethodBeat.m2505o(125870);
            return Lq;
        }

        public C4761a() {
            AppMethodBeat.m2504i(125865);
            AppChooserUI.this.bCX = AppChooserUI.this.getPackageManager();
            AppMethodBeat.m2505o(125865);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C4762b c4762b;
            int i2 = 0;
            AppMethodBeat.m2504i(125866);
            C7916c Lq = mo9906Lq(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(AppChooserUI.this.mController.ylL).inflate(Lq.vtF ? 2130968750 : 2130968749, null);
                C4762b c4762b2 = new C4762b(view);
                view.setTag(c4762b2);
                c4762b = c4762b2;
            } else {
                c4762b = (C4762b) view.getTag();
            }
            if (Lq.vtE == null) {
                new C7919d().execute(new C7916c[]{Lq});
            }
            c4762b.nmi.setImageDrawable(Lq.vtE);
            CharSequence charSequence = Lq.vtD;
            if (Lq.vtC == null) {
                AppChooserUI.this.finish();
                AppMethodBeat.m2505o(125866);
            } else {
                if (AppChooserUI.this.vtk && Lq.vtC.activityInfo.packageName.equals(AppChooserUI.this.vtl)) {
                    charSequence = TextUtils.concat(new CharSequence[]{charSequence, AppChooserUI.this.getString(C25738R.string.f9087p3)});
                    if (AppChooserUI.this.vth == null) {
                        AppChooserUI.this.vth = Lq;
                    }
                }
                c4762b.nmj.setText(charSequence);
                if (Lq == null || (!(!Lq.vtF || Lq.sKP || (Lq.vtF && Lq.nue && AppChooserUI.this.vtm >= AppChooserUI.this.vtn)) || Lq.vtG)) {
                    c4762b.vtA.setVisibility(0);
                    c4762b.vtB.setVisibility(8);
                    c4762b.vtA.setOnClickListener(AppChooserUI.this.vtw);
                    if (this.vtz == C7917f.UNINSTALL) {
                        if (Lq.vtG) {
                            c4762b.vtA.setText(C25738R.string.f9180rz);
                        } else {
                            c4762b.vtA.setText(C25738R.string.f9093p_);
                        }
                        c4762b.vtA.setEnabled(true);
                    } else if (this.vtz == C7917f.DOWNLOADING) {
                        c4762b.vtA.setText(C25738R.string.f9098pf);
                        c4762b.vtA.setEnabled(false);
                    } else if (this.vtz == C7917f.DOWNLOADED) {
                        if (Lq.vtG) {
                            c4762b.vtA.setText(C25738R.string.f9240u1);
                        } else {
                            c4762b.vtA.setText(C25738R.string.f9239u0);
                        }
                        c4762b.vtA.setEnabled(true);
                    }
                } else {
                    boolean z;
                    c4762b.vtA.setVisibility(8);
                    c4762b.vtB.setVisibility(0);
                    RadioButton radioButton = c4762b.vtB;
                    C7916c c = AppChooserUI.this.vth;
                    if (c instanceof C7916c) {
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
                        c4762b.nml.setText(C25738R.string.df4);
                    } else {
                        c4762b.nml.setText(C5046bo.nullAsNil(AppChooserUI.this.vtd));
                    }
                    TextView textView = c4762b.nml;
                    if (C5046bo.isNullOrNil(AppChooserUI.this.vtd)) {
                        i2 = 8;
                    }
                    textView.setVisibility(i2);
                } else {
                    c4762b.nml.setVisibility(8);
                }
                if (!(AppChooserUI.this.scene == 6 || AppChooserUI.this.vth == null || !AppChooserUI.this.vth.equals(Lq))) {
                    c4762b.vtB.setChecked(true);
                }
                AppMethodBeat.m2505o(125866);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* renamed from: Lq */
        public final C7916c mo9906Lq(int i) {
            AppMethodBeat.m2504i(125867);
            if (this.kSg == null) {
                AppMethodBeat.m2505o(125867);
                return null;
            }
            C7916c c7916c = (C7916c) this.kSg.get(i);
            AppMethodBeat.m2505o(125867);
            return c7916c;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(125868);
            if (mo9906Lq(i).vtF) {
                AppMethodBeat.m2505o(125868);
                return 1;
            }
            AppMethodBeat.m2505o(125868);
            return 0;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(125869);
            if (this.kSg == null) {
                AppMethodBeat.m2505o(125869);
                return 0;
            }
            int size = this.kSg.size();
            AppMethodBeat.m2505o(125869);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$b */
    class C4762b {
        ImageView nmi;
        TextView nmj;
        TextView nml;
        TextView vtA;
        RadioButton vtB;

        public C4762b(View view) {
            AppMethodBeat.m2504i(125871);
            this.nmi = (ImageView) view.findViewById(2131821433);
            this.nmj = (TextView) view.findViewById(2131821434);
            this.nml = (TextView) view.findViewById(2131821435);
            this.vtA = (TextView) view.findViewById(2131821436);
            this.vtB = (RadioButton) view.findViewById(2131821437);
            AppMethodBeat.m2505o(125871);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$4 */
    class C79134 implements View.OnClickListener {
        C79134() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125857);
            C4990ab.m7416i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (AppChooserUI.this.vta != null) {
                C7917f c7917f = AppChooserUI.this.vta.vtz;
                if (c7917f == C7917f.UNINSTALL) {
                    if (AppChooserUI.this.vts != null && AppChooserUI.this.vts.gLj.isShowing()) {
                        AppChooserUI.this.vta.vtz = C7917f.DOWNLOADING;
                        AppChooserUI.this.vta.notifyDataSetChanged();
                    }
                    C2901a c2901a = new C2901a();
                    if (AppChooserUI.this.scene == 1) {
                        c2901a.mo7055It("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
                    } else {
                        c2901a.mo7055It(AppChooserUI.this.vtf.anK());
                    }
                    c2901a.mo7057Iv(AppChooserUI.this.vtf.dgX());
                    c2901a.mo7069tN(1);
                    c2901a.mo7063ga(true);
                    C2896d.bij().mo7042a(c2901a.kNl);
                    C14893s.dhn();
                    C14893s.m23162Ku(AppChooserUI.this.vtc);
                    if (AppChooserUI.this.vtc == 0) {
                        if (AppChooserUI.this.vtp) {
                            C7060h.pYm.mo8381e(11168, Integer.valueOf(4), Integer.valueOf(AppChooserUI.this.scene));
                        } else {
                            C7060h.pYm.mo8381e(11168, Integer.valueOf(3), Integer.valueOf(AppChooserUI.this.scene));
                        }
                    }
                    if (AppChooserUI.this.vtc == 1) {
                        C7060h.pYm.mo8381e(12809, Integer.valueOf(5), "");
                    }
                    AppMethodBeat.m2505o(125857);
                    return;
                } else if (c7917f == C7917f.DOWNLOADED) {
                    AppChooserUI appChooserUI = AppChooserUI.this;
                    long j = AppChooserUI.this.vtr;
                    C4990ab.m7416i("MicroMsg.AppChooserUI", "installRecommendApp");
                    C4990ab.m7411d("MicroMsg.AppChooserUI", "filepath:%s", String.valueOf(C2896d.bij().mo7048hm(j).path));
                    C35800q.m58697a(appChooserUI.mController.ylL, Uri.fromFile(new File(r1)), new C79147());
                }
            }
            AppMethodBeat.m2505o(125857);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$7 */
    class C79147 implements C14900a {
        C79147() {
        }

        /* renamed from: dT */
        public final void mo9734dT(boolean z) {
            AppMethodBeat.m2504i(125864);
            if (!z) {
                C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274560), Long.valueOf(0));
                if (AppChooserUI.this.vta != null) {
                    AppChooserUI.this.vta.vtz = C7917f.UNINSTALL;
                    AppChooserUI.this.vta.notifyDataSetChanged();
                }
            } else if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vta.vtz = C7917f.DOWNLOADED;
                AppChooserUI.this.vta.notifyDataSetChanged();
                AppMethodBeat.m2505o(125864);
                return;
            }
            AppMethodBeat.m2505o(125864);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$5 */
    class C79155 implements OnDismissListener {
        C79155() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(125858);
            AppChooserUI.this.finish();
            AppMethodBeat.m2505o(125858);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$c */
    class C7916c {
        boolean nue;
        boolean sKP;
        ResolveInfo vtC;
        CharSequence vtD;
        Drawable vtE;
        boolean vtF;
        boolean vtG;

        public C7916c(ResolveInfo resolveInfo, CharSequence charSequence) {
            this.vtC = resolveInfo;
            this.vtD = charSequence;
            this.vtF = false;
            this.sKP = true;
            this.vtG = false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$f */
    public enum C7917f {
        UNINSTALL,
        DOWNLOADING,
        DOWNLOADED;

        static {
            AppMethodBeat.m2505o(125878);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$2 */
    class C79182 implements OnClickListener {
        C79182() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125855);
            if (!(AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                C1720g.m3536RP().mo5239Ry().set(AppChooserUI.m14064a(AppChooserUI.this, 274528), AppChooserUI.this.vth.vtC.activityInfo.packageName);
                AppChooserUI.m14071a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, true);
            }
            AppMethodBeat.m2505o(125855);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$d */
    class C7919d extends AsyncTask<C7916c, Void, C7916c> {
        C7919d() {
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(125873);
            C7916c c7916c = ((C7916c[]) objArr)[0];
            if (c7916c.vtE == null) {
                c7916c.vtE = AppChooserUI.m14067a(AppChooserUI.this, c7916c.vtC);
            }
            AppMethodBeat.m2505o(125873);
            return c7916c;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(125872);
            AppChooserUI.this.vta.notifyDataSetChanged();
            AppMethodBeat.m2505o(125872);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$1 */
    class C79201 implements OnItemClickListener {
        C79201() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(125854);
            if (AppChooserUI.this.vta != null) {
                AppChooserUI.this.vth = AppChooserUI.this.vta.mo9906Lq(i);
                AppChooserUI.this.vta.notifyDataSetChanged();
                if (AppChooserUI.this.vts != null && AppChooserUI.this.vts.gLj.isShowing()) {
                    if (AppChooserUI.this.vth == null || !AppChooserUI.this.vth.vtF || (AppChooserUI.this.vth.nue && (AppChooserUI.this.vth.sKP || AppChooserUI.this.vtm >= AppChooserUI.this.vtn))) {
                        AppChooserUI.this.vts.mo17750oU(true);
                    } else {
                        AppChooserUI.this.vts.mo17750oU(false);
                    }
                }
                if (!((AppChooserUI.this.scene != 6 && AppChooserUI.this.vtc != 2) || AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                    AppChooserUI.m14071a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, false);
                    C7060h.pYm.mo8381e(12809, Integer.valueOf(4), AppChooserUI.this.vth.vtC.activityInfo.packageName);
                }
            }
            AppMethodBeat.m2505o(125854);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$3 */
    class C79213 implements OnClickListener {
        C79213() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125856);
            if (!(AppChooserUI.this.vth == null || AppChooserUI.this.vth.vtC == null)) {
                AppChooserUI.m14071a(AppChooserUI.this, AppChooserUI.this.vth.vtC.activityInfo.packageName, false);
            }
            AppMethodBeat.m2505o(125856);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.AppChooserUI$e */
    class C7922e {
        /* renamed from: Uf */
        OnDismissListener f2137Uf;
        public C5653c gLj;
        BaseAdapter khG;
        Context mContext;
        String mTitle;
        ListViewInScrollView vtH = ((ListViewInScrollView) View.inflate(this.mContext, 2130968748, null));
        OnItemClickListener vtI;
        OnClickListener vtJ;
        OnClickListener vtv;

        public C7922e(Context context) {
            AppMethodBeat.m2504i(125874);
            this.mContext = context;
            AppMethodBeat.m2505o(125874);
        }

        /* renamed from: oU */
        public final void mo17750oU(boolean z) {
            AppMethodBeat.m2504i(125875);
            if (this.gLj != null) {
                if (z) {
                    this.gLj.mo11487a((int) C25738R.string.f9250ua, this.vtv);
                    this.gLj.mo11490b(C25738R.string.f9249u_, this.vtJ);
                } else {
                    this.gLj.mo11487a((int) C25738R.string.f9250ua, null);
                    this.gLj.mo11490b(C25738R.string.f9249u_, null);
                    AppMethodBeat.m2505o(125875);
                    return;
                }
            }
            AppMethodBeat.m2505o(125875);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppChooserUI() {
        AppMethodBeat.m2504i(125879);
        AppMethodBeat.m2505o(125879);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125880);
        super.onCreate(bundle);
        C14893s.dhn();
        C14893s.m23159Kr(this.vtc);
        C5222ae.m7935a(getWindow());
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
            if (C1720g.m3531RK()) {
                boolean z;
                this.vtl = (String) C1720g.m3536RP().mo5239Ry().get(m14063Lp(274528), (Object) "");
                if (TextUtils.isEmpty(this.vtl) || !C35799p.m58695u(this.mController.ylL, this.vtl) || (!(this.vtg == null || this.vtg.isEmpty() || this.vtg.contains(this.vtl)) || this.vtk)) {
                    z = false;
                } else {
                    Intent intent2 = new Intent(this.vtb);
                    intent2.setPackage(this.vtl);
                    if (C5046bo.m7572k((Context) this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    int size;
                    this.bCX = getPackageManager();
                    this.vta = new C4761a();
                    C14893s.dhn();
                    this.vtf = C14893s.m23163y(this.vtc, intent.getBundleExtra("key_recommend_params"));
                    this.vto = this.vtf.mo27192fE(this.mController.ylL);
                    this.vtm = ((Integer) C1720g.m3536RP().mo5239Ry().get(274496 + this.vtc, Integer.valueOf(0))).intValue();
                    C14893s.dhn();
                    this.vtn = C14893s.m23158Kq(this.vtc);
                    C4990ab.m7411d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.vto), Integer.valueOf(this.vtm));
                    this.vtq = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.vtm >= this.vtn) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.vtj = m14070a(this.vtb, dlk(), this.vtg);
                    if (!(z2 || this.vto)) {
                        C1720g.m3536RP().mo5239Ry().set(274496 + this.vtc, Integer.valueOf(this.vtm + 1));
                    }
                    if (this.vto) {
                        C14893s.dhn();
                        C14893s.m23161Kt(this.vtc);
                    } else if (!z2) {
                        C14893s.dhn();
                        C14893s.m23160Ks(this.vtc);
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
                    C4990ab.m7417i(str, str2, objArr);
                    if (this.vtj == null || this.vtj.size() != 1 || (dlk() && !this.vto)) {
                        setTitleVisibility(8);
                        if (this.vtj == null || this.vtj.isEmpty()) {
                            m14081i(4097, null, false);
                            AppMethodBeat.m2505o(125880);
                            return;
                        }
                        this.vta.kSg = this.vtj;
                        this.vtr = ((Long) C1720g.m3536RP().mo5239Ry().get(m14063Lp(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(this.vtr);
                        C4990ab.m7410d("MicroMsg.AppChooserUI", "downloadId:" + this.vtr + ", status:" + hm.status);
                        if (3 == hm.status && C1173e.m2561ct(hm.path) && this.vta != null) {
                            this.vta.vtz = C7917f.DOWNLOADED;
                            this.vta.notifyDataSetChanged();
                        }
                        this.vts = new C7922e(this.mController.ylL);
                        C7922e c7922e = this.vts;
                        if (stringExtra != null) {
                            c7922e.mTitle = stringExtra.toString();
                        } else {
                            c7922e.mTitle = null;
                        }
                        this.vts.vtI = this.vtt;
                        this.vts.vtv = this.vtv;
                        this.vts.vtJ = this.vtu;
                        this.vts.khG = this.vta;
                        this.vts.f2137Uf = this.f2136Uf;
                        C7922e c7922e2 = this.vts;
                        if (c7922e2.vtI != null) {
                            c7922e2.vtH.setOnItemClickListener(c7922e2.vtI);
                        }
                        if (c7922e2.khG != null) {
                            c7922e2.vtH.setAdapter(c7922e2.khG);
                        }
                        c7922e2.gLj = C30379h.m48452a(c7922e2.mContext, true, c7922e2.mTitle, c7922e2.vtH, c7922e2.mContext.getString(C25738R.string.f9250ua), c7922e2.mContext.getString(C25738R.string.f9249u_), c7922e2.vtv, c7922e2.vtJ, (int) C25738R.color.f12069r8);
                        c7922e2.gLj.setOnDismissListener(c7922e2.f2137Uf);
                        c7922e2.gLj.show();
                        if (!(this.vtp || !this.vto || z2)) {
                            this.vth = this.vti;
                            this.vts.mo17750oU(true);
                        }
                        C2896d.bij();
                        C2886b.m5129a(this.vtx);
                        AppMethodBeat.m2505o(125880);
                        return;
                    }
                    C7916c c7916c = (C7916c) this.vtj.get(0);
                    if (c7916c == null) {
                        m14081i(4097, null, false);
                        AppMethodBeat.m2505o(125880);
                        return;
                    } else if (c7916c.vtC != null) {
                        m14081i(-1, c7916c.vtC.activityInfo.packageName, false);
                        AppMethodBeat.m2505o(125880);
                        return;
                    } else {
                        m14081i(4098, null, false);
                        AppMethodBeat.m2505o(125880);
                        return;
                    }
                }
                m14081i(-1, this.vtl, true);
                AppMethodBeat.m2505o(125880);
                return;
            }
            C4990ab.m7412e("MicroMsg.AppChooserUI", "acc not ready");
            m14081i(4097, null, false);
            AppMethodBeat.m2505o(125880);
            return;
        }
        C4990ab.m7420w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(parcelableExtra)));
        m14081i(0, null, false);
        AppMethodBeat.m2505o(125880);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125881);
        super.onResume();
        if (this.vtp && this.vtb != null && this.vtf.mo48338F(this, this.vtb)) {
            C4990ab.m7416i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.vtp = false;
            this.vti.vtG = false;
        }
        this.vto = this.vtf.mo27192fE(this.mController.ylL);
        this.vtj = m14070a(this.vtb, dlk(), this.vtg);
        if (this.vto && this.vth == null && !this.vtk) {
            this.vth = this.vti;
            this.vts.mo17750oU(true);
        }
        if (this.vta != null) {
            this.vta.kSg = this.vtj;
            this.vta.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(125881);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125882);
        super.onDestroy();
        C2896d.bij();
        C2886b.m5130b(this.vtx);
        if (this.vts != null) {
            this.vts.gLj.dismiss();
        }
        AppMethodBeat.m2505o(125882);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(125883);
        super.onBackPressed();
        m14081i(0, null, false);
        AppMethodBeat.m2505o(125883);
    }

    /* renamed from: Lp */
    private int m14063Lp(int i) {
        AppMethodBeat.m2504i(125884);
        int hashCode;
        if (this.mimeType != null) {
            hashCode = (this.vtc + i) + this.mimeType.hashCode();
            AppMethodBeat.m2505o(125884);
            return hashCode;
        }
        hashCode = this.vtc + i;
        AppMethodBeat.m2505o(125884);
        return hashCode;
    }

    /* renamed from: i */
    private void m14081i(int i, String str, boolean z) {
        AppMethodBeat.m2504i(125885);
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.vte);
        setResult(i, intent);
        finish();
        AppMethodBeat.m2505o(125885);
    }

    private void dlj() {
        AppMethodBeat.m2504i(125886);
        C14894a dgY = this.vtf.dgY();
        if (!C5046bo.isNullOrNil(dgY.vbE)) {
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
        AppMethodBeat.m2505o(125886);
    }

    private boolean dlk() {
        AppMethodBeat.m2504i(125887);
        C4990ab.m7411d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.vtq), Integer.valueOf(this.vtm), Integer.valueOf(this.vtn), Boolean.valueOf(C5046bo.m7558gT(this)));
        if (!this.vtq || this.vtm >= this.vtn || C5046bo.m7558gT(this) || C5059g.cdf == 1) {
            AppMethodBeat.m2505o(125887);
            return false;
        }
        AppMethodBeat.m2505o(125887);
        return true;
    }

    /* renamed from: a */
    private List<C7916c> m14070a(Intent intent, boolean z, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(125888);
        ArrayList arrayList2 = new ArrayList();
        List queryIntentActivities = this.bCX.queryIntentActivities(intent, 65536);
        dlj();
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                C4990ab.m7417i("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
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
                            arrayList2.add(new C7916c(resolveInfo, this.vtf.mo27187a(this.mController.ylL, resolveInfo)));
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
                    C7060h.pYm.mo8381e(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    C7060h.pYm.mo8381e(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
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
            C7916c c7916c = (C7916c) arrayList2.get(size2);
            if (c7916c.vtC != null) {
                String str2 = c7916c.vtC.activityInfo.packageName;
                if (!(C5046bo.isNullOrNil(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        AppMethodBeat.m2505o(125888);
        return arrayList2;
    }

    /* renamed from: c */
    private static Drawable m14074c(Resources resources, int i) {
        Drawable d;
        AppMethodBeat.m2504i(125889);
        try {
            d = C18121b.m28549d(resources, i);
        } catch (NotFoundException e) {
            d = null;
        }
        AppMethodBeat.m2505o(125889);
        return d;
    }

    /* renamed from: c */
    private Drawable m14073c(ResolveInfo resolveInfo) {
        Drawable c;
        AppMethodBeat.m2504i(125890);
        try {
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                c = AppChooserUI.m14074c(this.bCX.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (c != null) {
                    AppMethodBeat.m2505o(125890);
                    return c;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                c = AppChooserUI.m14074c(this.bCX.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (c != null) {
                    C4990ab.m7417i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", Integer.valueOf(iconResource));
                    AppMethodBeat.m2505o(125890);
                    return c;
                }
            }
        } catch (NameNotFoundException e) {
            C4990ab.m7413e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        c = resolveInfo.loadIcon(this.bCX);
        AppMethodBeat.m2505o(125890);
        return c;
    }
}
