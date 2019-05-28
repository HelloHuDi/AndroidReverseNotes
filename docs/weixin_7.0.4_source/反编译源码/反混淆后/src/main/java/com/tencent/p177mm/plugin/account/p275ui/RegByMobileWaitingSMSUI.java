package com.tencent.p177mm.plugin.account.p275ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI */
public class RegByMobileWaitingSMSUI extends MMActivity {
    private String cFl;
    private boolean gFY;
    private int gFg = 30;
    private TextView gGU;
    private CountDownTimer gGV;
    private ListView gGW;
    private C9991a gGX;
    private List<Integer> gGY = new ArrayList();
    String[] gGZ = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable gHa;
    private List<Drawable> gHb = new ArrayList();
    private boolean gHc = false;
    private String gsF;
    private ProgressBar progressBar;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$a */
    class C9991a extends ArrayAdapter<String> {
        private final LayoutInflater ezi;
        final /* synthetic */ RegByMobileWaitingSMSUI gHd;
        private final ArrayList<String> gHf;

        public final /* synthetic */ void add(Object obj) {
            AppMethodBeat.m2504i(125484);
            mo21350wy((String) obj);
            AppMethodBeat.m2505o(125484);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C9992b c9992b;
            View inflate;
            AppMethodBeat.m2504i(125478);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                c9992b = new C9992b(this.gHd, (byte) 0);
                switch (itemViewType) {
                    case 0:
                        inflate = this.ezi.inflate(2130968648, null);
                        break;
                    case 1:
                        inflate = this.ezi.inflate(2130968649, null);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("UNIMPLEMENT TYPE");
                        AppMethodBeat.m2505o(125478);
                        throw illegalArgumentException;
                }
                c9992b.gHg = (TextView) inflate.findViewById(2131821103);
                c9992b.gvq = (ImageView) inflate.findViewById(2131821101);
                inflate.setTag(c9992b);
            } else {
                c9992b = (C9992b) view.getTag();
                inflate = view;
            }
            int intValue = ((Integer) this.gHd.gGY.get(i % this.gHd.gGY.size())).intValue();
            switch (itemViewType) {
                case 0:
                    c9992b.gvq.setImageDrawable((Drawable) this.gHd.gHb.get(intValue % this.gHd.gHb.size()));
                    break;
                case 1:
                    c9992b.gvq.setImageDrawable(this.gHd.gHa);
                    break;
            }
            c9992b.gHg.setText(getItem(i));
            AppMethodBeat.m2505o(125478);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(125479);
            int size = this.gHf.size();
            AppMethodBeat.m2505o(125479);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.m2504i(125480);
            String str = (String) this.gHf.get(i);
            AppMethodBeat.m2505o(125480);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(125481);
            if (((Integer) this.gHd.gGY.get(i % this.gHd.gGY.size())).intValue() % 4 == 0) {
                AppMethodBeat.m2505o(125481);
                return 1;
            }
            AppMethodBeat.m2505o(125481);
            return 0;
        }

        /* renamed from: wy */
        public final void mo21350wy(String str) {
            AppMethodBeat.m2504i(125482);
            this.gHf.add(str);
            notifyDataSetChanged();
            AppMethodBeat.m2505o(125482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$b */
    class C9992b {
        public TextView gHg;
        public ImageView gvq;

        private C9992b() {
        }

        /* synthetic */ C9992b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$3 */
    class C330103 implements OnClickListener {
        C330103() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125477);
            RegByMobileWaitingSMSUI.this.gHc = true;
            RegByMobileWaitingSMSUI.this.finish();
            AppMethodBeat.m2505o(125477);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$4 */
    class C330114 implements OnClickListener {
        C330114() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$1 */
    class C330121 implements OnMenuItemClickListener {
        C330121() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125473);
            RegByMobileWaitingSMSUI.m53948a(RegByMobileWaitingSMSUI.this);
            AppMethodBeat.m2505o(125473);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RegByMobileWaitingSMSUI() {
        AppMethodBeat.m2504i(125485);
        AppMethodBeat.m2505o(125485);
    }

    /* renamed from: a */
    static /* synthetic */ void m53948a(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.m2504i(125496);
        regByMobileWaitingSMSUI.goBack();
        AppMethodBeat.m2505o(125496);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125486);
        super.onCreate(bundle);
        this.gHb.add(getResources().getDrawable(C25738R.drawable.agv));
        this.gHb.add(getResources().getDrawable(C25738R.drawable.agw));
        this.gHb.add(getResources().getDrawable(C25738R.drawable.agx));
        this.gHb.add(getResources().getDrawable(C25738R.drawable.agy));
        this.gHb.add(getResources().getDrawable(C25738R.drawable.agz));
        this.gHb.add(getResources().getDrawable(C25738R.drawable.ah0));
        initView();
        this.gsF = C42756a.m75794FP();
        AppMethodBeat.m2505o(125486);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125487);
        super.onDestroy();
        AppMethodBeat.m2505o(125487);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125488);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE200_250,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("RE200_250")).append(",1").toString());
        AppMethodBeat.m2505o(125488);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125489);
        super.onPause();
        C42756a.m75798wz("RE200_250");
        if (this.gHc) {
            C42756a.m75796wA(this.gsF);
        } else {
            C42756a.m75796wA("RE200_300");
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE200_250,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("RE200_250")).append(",2").toString());
        AppMethodBeat.m2505o(125489);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125490);
        this.gGU = (TextView) findViewById(2131826135);
        this.progressBar = (ProgressBar) findViewById(2131826136);
        this.gGW = (ListView) findViewById(2131826137);
        this.gFY = false;
        arw();
        setBackBtn(new C330121());
        C5025av c5025av = new C5025av();
        String str = "86";
        if (this.cFl.startsWith("+")) {
            this.cFl = this.cFl.replace("+", "");
            str = C5025av.m7481Ps(this.cFl);
            if (str != null) {
                this.cFl = this.cFl.substring(str.length());
            }
        }
        String formatNumber = C5025av.formatNumber(str, this.cFl);
        if (str == null || str.length() <= 0) {
            this.gGU.setText(formatNumber);
        } else {
            this.gGU.setText("+" + str + " " + formatNumber);
        }
        this.gGW.setVisibility(4);
        arh();
        AppMethodBeat.m2505o(125490);
    }

    private void arw() {
        AppMethodBeat.m2504i(125491);
        String string = getString(C25738R.string.a7b);
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.cFl = C5025av.amN(this.cFl);
        this.gFg = getIntent().getIntExtra("mobileverify_countdownsec", this.gFg);
        Random random = new Random();
        for (int i = 0; i < this.gFg; i++) {
            this.gGY.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.gHb.size();
        this.gHa = (Drawable) this.gHb.get(nextInt);
        this.gHb.remove(nextInt);
        AppMethodBeat.m2505o(125491);
    }

    public final int getLayoutId() {
        return 2130970240;
    }

    @TargetApi(8)
    private void arh() {
        AppMethodBeat.m2504i(125492);
        if (this.gGV == null) {
            this.gGV = new CountDownTimer((long) (this.gFg * 1000)) {

                /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI$2$1 */
                class C266421 implements Runnable {
                    C266421() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(125474);
                        if (VERSION.SDK_INT >= 8) {
                            RegByMobileWaitingSMSUI.this.gGW.smoothScrollToPosition(RegByMobileWaitingSMSUI.this.gGX.getCount() - 1);
                            AppMethodBeat.m2505o(125474);
                            return;
                        }
                        RegByMobileWaitingSMSUI.this.gGW.setSelection(RegByMobileWaitingSMSUI.this.gGX.getCount() - 1);
                        AppMethodBeat.m2505o(125474);
                    }
                }

                public final void onFinish() {
                    AppMethodBeat.m2504i(125475);
                    RegByMobileWaitingSMSUI.m53949b(RegByMobileWaitingSMSUI.this);
                    AppMethodBeat.m2505o(125475);
                }

                public final void onTick(long j) {
                    AppMethodBeat.m2504i(125476);
                    int c = (int) (((long) RegByMobileWaitingSMSUI.this.gFg) - (j / 1000));
                    RegByMobileWaitingSMSUI.this.progressBar.setProgress(c);
                    if (c % 2 == 0 && RegByMobileWaitingSMSUI.this.gGX != null) {
                        RegByMobileWaitingSMSUI.this.gGX.mo21350wy(RegByMobileWaitingSMSUI.this.gGZ[(c / 2) % RegByMobileWaitingSMSUI.this.gGZ.length]);
                        RegByMobileWaitingSMSUI.this.gGW.post(new C266421());
                    }
                    AppMethodBeat.m2505o(125476);
                }
            };
            this.progressBar.setMax(this.gFg);
            this.gGV.start();
        }
        AppMethodBeat.m2505o(125492);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125493);
        if (i == 4) {
            goBack();
            AppMethodBeat.m2505o(125493);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125493);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.m2504i(125494);
        C30379h.m48466d(this, getString(C25738R.string.d0q), "", getString(C25738R.string.d0r), getString(C25738R.string.d0s), new C330103(), new C330114());
        AppMethodBeat.m2505o(125494);
    }

    private synchronized void arq() {
        AppMethodBeat.m2504i(125495);
        if (!(this.gGV == null || this.gGV == null)) {
            this.gGV.cancel();
            this.gGV = null;
        }
        if (!this.gFY) {
            this.gFY = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            mo17381a(MobileVerifyUI.class, intent);
            finish();
        }
        AppMethodBeat.m2505o(125495);
    }

    /* renamed from: b */
    static /* synthetic */ void m53949b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.m2504i(125497);
        regByMobileWaitingSMSUI.arq();
        AppMethodBeat.m2505o(125497);
    }
}
