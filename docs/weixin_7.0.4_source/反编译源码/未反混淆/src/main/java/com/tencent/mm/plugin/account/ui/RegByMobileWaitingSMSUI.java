package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String cFl;
    private boolean gFY;
    private int gFg = 30;
    private TextView gGU;
    private CountDownTimer gGV;
    private ListView gGW;
    private a gGX;
    private List<Integer> gGY = new ArrayList();
    String[] gGZ = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable gHa;
    private List<Drawable> gHb = new ArrayList();
    private boolean gHc = false;
    private String gsF;
    private ProgressBar progressBar;

    class a extends ArrayAdapter<String> {
        private final LayoutInflater ezi;
        final /* synthetic */ RegByMobileWaitingSMSUI gHd;
        private final ArrayList<String> gHf;

        public final /* synthetic */ void add(Object obj) {
            AppMethodBeat.i(125484);
            wy((String) obj);
            AppMethodBeat.o(125484);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View inflate;
            AppMethodBeat.i(125478);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                bVar = new b(this.gHd, (byte) 0);
                switch (itemViewType) {
                    case 0:
                        inflate = this.ezi.inflate(R.layout.b9, null);
                        break;
                    case 1:
                        inflate = this.ezi.inflate(R.layout.b_, null);
                        break;
                    default:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("UNIMPLEMENT TYPE");
                        AppMethodBeat.o(125478);
                        throw illegalArgumentException;
                }
                bVar.gHg = (TextView) inflate.findViewById(R.id.oe);
                bVar.gvq = (ImageView) inflate.findViewById(R.id.oc);
                inflate.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            int intValue = ((Integer) this.gHd.gGY.get(i % this.gHd.gGY.size())).intValue();
            switch (itemViewType) {
                case 0:
                    bVar.gvq.setImageDrawable((Drawable) this.gHd.gHb.get(intValue % this.gHd.gHb.size()));
                    break;
                case 1:
                    bVar.gvq.setImageDrawable(this.gHd.gHa);
                    break;
            }
            bVar.gHg.setText(getItem(i));
            AppMethodBeat.o(125478);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.i(125479);
            int size = this.gHf.size();
            AppMethodBeat.o(125479);
            return size;
        }

        private String getItem(int i) {
            AppMethodBeat.i(125480);
            String str = (String) this.gHf.get(i);
            AppMethodBeat.o(125480);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(125481);
            if (((Integer) this.gHd.gGY.get(i % this.gHd.gGY.size())).intValue() % 4 == 0) {
                AppMethodBeat.o(125481);
                return 1;
            }
            AppMethodBeat.o(125481);
            return 0;
        }

        public final void wy(String str) {
            AppMethodBeat.i(125482);
            this.gHf.add(str);
            notifyDataSetChanged();
            AppMethodBeat.o(125482);
        }
    }

    class b {
        public TextView gHg;
        public ImageView gvq;

        private b() {
        }

        /* synthetic */ b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegByMobileWaitingSMSUI() {
        AppMethodBeat.i(125485);
        AppMethodBeat.o(125485);
    }

    static /* synthetic */ void a(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.i(125496);
        regByMobileWaitingSMSUI.goBack();
        AppMethodBeat.o(125496);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125486);
        super.onCreate(bundle);
        this.gHb.add(getResources().getDrawable(R.drawable.agv));
        this.gHb.add(getResources().getDrawable(R.drawable.agw));
        this.gHb.add(getResources().getDrawable(R.drawable.agx));
        this.gHb.add(getResources().getDrawable(R.drawable.agy));
        this.gHb.add(getResources().getDrawable(R.drawable.agz));
        this.gHb.add(getResources().getDrawable(R.drawable.ah0));
        initView();
        this.gsF = com.tencent.mm.plugin.b.a.FP();
        AppMethodBeat.o(125486);
    }

    public void onDestroy() {
        AppMethodBeat.i(125487);
        super.onDestroy();
        AppMethodBeat.o(125487);
    }

    public void onResume() {
        AppMethodBeat.i(125488);
        super.onResume();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE200_250,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_250")).append(",1").toString());
        AppMethodBeat.o(125488);
    }

    public void onPause() {
        AppMethodBeat.i(125489);
        super.onPause();
        com.tencent.mm.plugin.b.a.wz("RE200_250");
        if (this.gHc) {
            com.tencent.mm.plugin.b.a.wA(this.gsF);
        } else {
            com.tencent.mm.plugin.b.a.wA("RE200_300");
        }
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",RE200_250,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("RE200_250")).append(",2").toString());
        AppMethodBeat.o(125489);
    }

    public final void initView() {
        AppMethodBeat.i(125490);
        this.gGU = (TextView) findViewById(R.id.dc5);
        this.progressBar = (ProgressBar) findViewById(R.id.dc6);
        this.gGW = (ListView) findViewById(R.id.dc7);
        this.gFY = false;
        arw();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125473);
                RegByMobileWaitingSMSUI.a(RegByMobileWaitingSMSUI.this);
                AppMethodBeat.o(125473);
                return true;
            }
        });
        av avVar = new av();
        String str = "86";
        if (this.cFl.startsWith("+")) {
            this.cFl = this.cFl.replace("+", "");
            str = av.Ps(this.cFl);
            if (str != null) {
                this.cFl = this.cFl.substring(str.length());
            }
        }
        String formatNumber = av.formatNumber(str, this.cFl);
        if (str == null || str.length() <= 0) {
            this.gGU.setText(formatNumber);
        } else {
            this.gGU.setText("+" + str + " " + formatNumber);
        }
        this.gGW.setVisibility(4);
        arh();
        AppMethodBeat.o(125490);
    }

    private void arw() {
        AppMethodBeat.i(125491);
        String string = getString(R.string.a7b);
        if (d.vxr) {
            string = getString(R.string.ru) + getString(R.string.fk);
        }
        setMMTitle(string);
        this.cFl = getIntent().getExtras().getString("bindmcontact_mobile");
        this.cFl = av.amN(this.cFl);
        this.gFg = getIntent().getIntExtra("mobileverify_countdownsec", this.gFg);
        Random random = new Random();
        for (int i = 0; i < this.gFg; i++) {
            this.gGY.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.gHb.size();
        this.gHa = (Drawable) this.gHb.get(nextInt);
        this.gHb.remove(nextInt);
        AppMethodBeat.o(125491);
    }

    public final int getLayoutId() {
        return R.layout.ah6;
    }

    @TargetApi(8)
    private void arh() {
        AppMethodBeat.i(125492);
        if (this.gGV == null) {
            this.gGV = new CountDownTimer((long) (this.gFg * 1000)) {
                public final void onFinish() {
                    AppMethodBeat.i(125475);
                    RegByMobileWaitingSMSUI.b(RegByMobileWaitingSMSUI.this);
                    AppMethodBeat.o(125475);
                }

                public final void onTick(long j) {
                    AppMethodBeat.i(125476);
                    int c = (int) (((long) RegByMobileWaitingSMSUI.this.gFg) - (j / 1000));
                    RegByMobileWaitingSMSUI.this.progressBar.setProgress(c);
                    if (c % 2 == 0 && RegByMobileWaitingSMSUI.this.gGX != null) {
                        RegByMobileWaitingSMSUI.this.gGX.wy(RegByMobileWaitingSMSUI.this.gGZ[(c / 2) % RegByMobileWaitingSMSUI.this.gGZ.length]);
                        RegByMobileWaitingSMSUI.this.gGW.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(125474);
                                if (VERSION.SDK_INT >= 8) {
                                    RegByMobileWaitingSMSUI.this.gGW.smoothScrollToPosition(RegByMobileWaitingSMSUI.this.gGX.getCount() - 1);
                                    AppMethodBeat.o(125474);
                                    return;
                                }
                                RegByMobileWaitingSMSUI.this.gGW.setSelection(RegByMobileWaitingSMSUI.this.gGX.getCount() - 1);
                                AppMethodBeat.o(125474);
                            }
                        });
                    }
                    AppMethodBeat.o(125476);
                }
            };
            this.progressBar.setMax(this.gFg);
            this.gGV.start();
        }
        AppMethodBeat.o(125492);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(125493);
        if (i == 4) {
            goBack();
            AppMethodBeat.o(125493);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(125493);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(125494);
        h.d(this, getString(R.string.d0q), "", getString(R.string.d0r), getString(R.string.d0s), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(125477);
                RegByMobileWaitingSMSUI.this.gHc = true;
                RegByMobileWaitingSMSUI.this.finish();
                AppMethodBeat.o(125477);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(125494);
    }

    private synchronized void arq() {
        AppMethodBeat.i(125495);
        if (!(this.gGV == null || this.gGV == null)) {
            this.gGV.cancel();
            this.gGV = null;
        }
        if (!this.gFY) {
            this.gFY = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            a(MobileVerifyUI.class, intent);
            finish();
        }
        AppMethodBeat.o(125495);
    }

    static /* synthetic */ void b(RegByMobileWaitingSMSUI regByMobileWaitingSMSUI) {
        AppMethodBeat.i(125497);
        regByMobileWaitingSMSUI.arq();
        AppMethodBeat.o(125497);
    }
}
