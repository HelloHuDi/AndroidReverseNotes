package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI extends MMActivity implements OnPageChangeListener, f {
    private ak eet = new ak(Looper.getMainLooper());
    private c hAA = new c<ke>() {
        {
            AppMethodBeat.i(105097);
            this.xxI = ke.class.getName().hashCode();
            AppMethodBeat.o(105097);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(105098);
            final ke keVar = (ke) bVar;
            switch (keVar.cFH.action) {
                case 0:
                case 1:
                    MusicMainUI.this.oON.setChecked(false);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105091);
                            if (keVar.cFH.action == 0 && ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() != 2) {
                                MusicMainUI.this.oOR.setAdapter(MusicMainUI.this.oOT);
                                MusicMainUI.this.oOR.setCurrentItem(((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUa() + 100000);
                            }
                            MusicMainUI.k(MusicMainUI.this);
                            AppMethodBeat.o(105091);
                        }
                    });
                    break;
                case 2:
                case 3:
                case 4:
                    MusicMainUI.this.oON.setChecked(true);
                    break;
                case 5:
                    ay.au(MusicMainUI.this.mController.ylL, R.string.ef_);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105093);
                            MusicMainUI musicMainUI = MusicMainUI.this;
                            if (((Boolean) g.RP().Ry().get(82, Boolean.TRUE)).booleanValue()) {
                                g.RP().Ry().set(82, Boolean.FALSE);
                                switch (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_musicType) {
                                    case 0:
                                        d.S(musicMainUI, R.string.eee);
                                        break;
                                    case 1:
                                    case 8:
                                        d.S(musicMainUI, R.string.eeh);
                                        break;
                                    case 4:
                                        d.S(musicMainUI, R.string.eeg);
                                        break;
                                    case 6:
                                        d.S(musicMainUI, R.string.eef);
                                        break;
                                }
                            } else if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() == 2) {
                                Toast.makeText(ah.getContext(), R.string.eu5, 0).show();
                            } else {
                                Toast.makeText(ah.getContext(), R.string.eu6, 0).show();
                            }
                            MusicMainUI.k(MusicMainUI.this);
                            AppMethodBeat.o(105093);
                        }
                    });
                    break;
                case 6:
                    al.d(new Runnable() {
                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(105094);
                            b i = MusicMainUI.this.oOT;
                            String str = keVar.cFH.cFI;
                            boolean z2 = false;
                            Iterator it = i.oOu.entrySet().iterator();
                            while (true) {
                                z = z2;
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) ((View) ((Entry) it.next()).getValue()).getTag();
                                if (aVar.oMw.field_musicId.equals(str)) {
                                    aVar.d(com.tencent.mm.plugin.music.model.e.bUk().Tp(str), true);
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                            }
                            if (!z) {
                                ab.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
                                i.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(105094);
                        }
                    });
                    break;
                case 7:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() != 2) {
                        MusicMainUI.this.oON.setChecked(true);
                        break;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(105092);
                            MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() + 1);
                            AppMethodBeat.o(105092);
                        }
                    });
                    break;
                case 8:
                    MusicMainUI.this.oOQ.jA(false);
                    break;
                case 13:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() == 2) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(105095);
                                MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() - 1);
                                AppMethodBeat.o(105095);
                            }
                        });
                        break;
                    }
                    break;
                case 14:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() == 2) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(105096);
                                MusicMainUI.this.oOR.setCurrentItem(MusicMainUI.this.oOR.getCurrentItem() + 1);
                                AppMethodBeat.o(105096);
                            }
                        });
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(105098);
            return false;
        }
    };
    private long mfT;
    private int mode;
    private com.tencent.mm.plugin.music.f.a.d.a oKa = new com.tencent.mm.plugin.music.f.a.d.a() {
        public final void dN(int i, int i2) {
            AppMethodBeat.i(105103);
            if (MusicMainUI.this.mode == 1 && !MusicMainUI.this.oOU) {
                float floatExtra = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0f);
                floatExtra *= 1000.0f;
                long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    MusicMainUI.this.oOT.T(MusicMainUI.this.oOR.getCurrentItem(), currentTimeMillis + 200);
                }
            } else if (i >= 0 && i2 > 0) {
                MusicMainUI.this.oOT.T(MusicMainUI.this.oOR.getCurrentItem(), (long) i);
            }
            Message message = new Message();
            message.what = 1;
            MusicMainUI.this.oOY.sendMessage(message);
            AppMethodBeat.o(105103);
        }
    };
    private boolean oMH;
    private CheckBox oON;
    private ImageButton oOO;
    private ImageButton oOP;
    private MusicSeekBar oOQ;
    private MusicViewPager oOR;
    private com.tencent.mm.pluginsdk.i.d oOS;
    private b oOT;
    private boolean oOU;
    private int oOV = 0;
    private Timer oOW;
    private int oOX = -1;
    private ak oOY = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(105104);
            if (message.what == 1) {
                MusicMainUI.p(MusicMainUI.this);
            }
            AppMethodBeat.o(105104);
        }
    };
    private int scene;

    class a implements Runnable {
        int position;

        public a(int i) {
            this.position = i;
        }

        public final void run() {
            AppMethodBeat.i(105105);
            ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).zH(this.position);
            com.tencent.mm.plugin.music.model.e.a bTU = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU();
            if (bTU == null) {
                AppMethodBeat.o(105105);
                return;
            }
            if (bTU.bUu()) {
                MusicMainUI.this.i(bTU);
            }
            if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUc()) {
                MusicMainUI.this.oOR.setCanSlide(true);
            }
            MusicMainUI.a(MusicMainUI.this, bTU);
            AppMethodBeat.o(105105);
        }
    }

    class b extends com.tencent.mm.pluginsdk.i.d.a {
        private b() {
        }

        /* synthetic */ b(MusicMainUI musicMainUI, byte b) {
            this();
        }

        public final void bUT() {
            AppMethodBeat.i(105106);
            ab.i("MicroMsg.Music.MusicMainUI", "shake %b", Boolean.TRUE);
            long az = bo.az(MusicMainUI.this.mfT);
            if (az < 1200) {
                ab.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(az)));
                AppMethodBeat.o(105106);
                return;
            }
            ab.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(az)));
            MusicMainUI.this.mfT = bo.yz();
            MusicMainUI.this.oOV = MusicMainUI.this.oOV + 1;
            if (MusicMainUI.this.oOV % 2 == 0) {
                ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).xs(MusicMainUI.this.scene);
            }
            AppMethodBeat.o(105106);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MusicMainUI() {
        AppMethodBeat.i(105107);
        AppMethodBeat.o(105107);
    }

    static /* synthetic */ void a(MusicMainUI musicMainUI) {
        AppMethodBeat.i(105121);
        musicMainUI.bUR();
        AppMethodBeat.o(105121);
    }

    static /* synthetic */ void k(MusicMainUI musicMainUI) {
        AppMethodBeat.i(105122);
        musicMainUI.bUQ();
        AppMethodBeat.o(105122);
    }

    static /* synthetic */ void p(MusicMainUI musicMainUI) {
        AppMethodBeat.i(105124);
        musicMainUI.bUS();
        AppMethodBeat.o(105124);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(105108);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(67109888, 67109888);
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.oMH = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.oOR = (MusicViewPager) findViewById(R.id.dfm);
        this.oOT = new b(this, this.scene, this.oMH);
        this.oOR.setAdapter(this.oOT);
        this.oOR.setOnPageChangeListener(this);
        this.oOR.setSystemUiVisibility(4096);
        this.oOO = (ImageButton) findViewById(R.id.dfp);
        this.oOP = (ImageButton) findViewById(R.id.dfq);
        LayoutParams layoutParams = (LayoutParams) this.oOO.getLayoutParams();
        int i = layoutParams.topMargin;
        if (ae.hD(this.mController.ylL)) {
            i += ae.getStatusBarHeight(this.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.oOO.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.oOP.getLayoutParams();
        i = layoutParams.topMargin;
        if (ae.hD(this.mController.ylL)) {
            i += ae.getStatusBarHeight(this.mController.ylL);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.oOP.setLayoutParams(layoutParams);
        this.oON = (CheckBox) findViewById(R.id.dfn);
        this.oON.setChecked(!k.bUf().bTS().aie());
        this.oOS = new com.tencent.mm.pluginsdk.i.d(this);
        this.oON.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(105089);
                MusicMainUI.a(MusicMainUI.this);
                if (MusicMainUI.this.oON.isChecked()) {
                    com.tencent.mm.aw.a.KX();
                    MusicMainUI.this.oON.setChecked(true);
                    AppMethodBeat.o(105089);
                    return;
                }
                MusicMainUI.this.oOU = true;
                if (k.bUf().bTS().aig()) {
                    k.bUf().bTS().resume();
                } else {
                    k.bUf().p(null);
                }
                MusicMainUI.this.oON.setChecked(false);
                AppMethodBeat.o(105089);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        this.oOQ = (MusicSeekBar) findViewById(R.id.dfo);
        this.oOQ.setOnSeekBarChange(new a() {
            public final void zV(int i) {
                AppMethodBeat.i(105090);
                com.tencent.mm.aw.a.lP(i);
                MusicMainUI.this.oOQ.setProgress(i);
                MusicMainUI.this.oOQ.jA(true);
                AppMethodBeat.o(105090);
            }
        });
        if (!this.oOS.diK()) {
            ab.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        bUQ();
        this.oOR.setCurrentItem(((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUa() + 100000);
        i = this.scene;
        if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU() != null) {
            ab.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", Integer.valueOf(13041), Integer.valueOf(i), ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_musicId, ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_songName, ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_songAlbum, Integer.valueOf(((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_songId), ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_songSinger, ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU().field_appId);
            h.pYm.e(13041, Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), r0.field_songSinger, r0.field_appId);
        }
        h.pYm.a(285, 1, 1, false);
        com.tencent.mm.plugin.music.model.e.a bTU = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU();
        if (bTU == null) {
            finish();
            AppMethodBeat.o(105108);
            return;
        }
        if (this.scene == 4 && ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).getMode() == 2) {
            int i2 = g.RP().Ry().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, R.string.c2c, 0).show();
                g.RP().Ry().set(83, Integer.valueOf(i2 + 1));
            }
        }
        if (this.scene == 5) {
            com.tencent.mm.plugin.music.model.d.d.a(0, bTU);
        }
        h(bTU);
        if (this.mode == 1) {
            if (this.oOW == null) {
                this.oOW = new Timer();
            }
            this.oOW.schedule(new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(105099);
                    MusicMainUI.this.oKa.dN(0, 0);
                    AppMethodBeat.o(105099);
                }
            }, 0, 500);
        }
        AppMethodBeat.o(105108);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    public void onResume() {
        AppMethodBeat.i(105109);
        super.onResume();
        if (!((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTV()) {
            ab.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTX();
        } else if (!this.oMH) {
            if (!(this.oOS == null || !this.oOS.diK() || this.oOS.diI())) {
                this.oOS.a(new b(this, (byte) 0));
            }
            this.mfT = bo.yz();
        }
        k.bUf().bTS().a(this.oKa);
        bUS();
        AppMethodBeat.o(105109);
    }

    public void onPause() {
        AppMethodBeat.i(105110);
        super.onPause();
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        k.bUf().bTS().a(null);
        AppMethodBeat.o(105110);
    }

    private void bUQ() {
        AppMethodBeat.i(105111);
        com.tencent.mm.plugin.music.f.c.b.ar(e.class);
        this.oOT.count = 200000;
        this.oOT.notifyDataSetChanged();
        if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUc()) {
            this.oOR.setCanSlide(true);
            AppMethodBeat.o(105111);
            return;
        }
        this.oOR.setCanSlide(false);
        AppMethodBeat.o(105111);
    }

    private void bUR() {
        AppMethodBeat.i(105112);
        if (this.oOW != null) {
            this.oOW.cancel();
        }
        this.oOW = null;
        AppMethodBeat.o(105112);
    }

    public void onDestroy() {
        AppMethodBeat.i(105113);
        super.onDestroy();
        if (this.oOS != null) {
            this.oOS.bgr();
        }
        if (this.oOT != null) {
            b bVar = this.oOT;
            bVar.oMs.removeCallbacksAndMessages(null);
            com.tencent.mm.plugin.music.model.c cVar = bVar.oOv;
            cVar.oMs.removeCallbacksAndMessages(null);
            cVar.edn.clear();
        }
        if (this.oOQ != null) {
            this.oOQ.jA(false);
        }
        bUR();
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        k.bUf().bTS().a(null);
        if (!k.bUf().bTS().aie()) {
            k.bUf().bTS().stopPlay();
        }
        ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUb();
        AppMethodBeat.o(105113);
    }

    public void onClickBack(View view) {
        AppMethodBeat.i(105114);
        finish();
        AppMethodBeat.o(105114);
    }

    public final int getLayoutId() {
        return R.layout.ai3;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    private void h(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(105116);
        if (!d.a(aVar) || this.oMH) {
            this.oON.setVisibility(8);
            this.oOP.setVisibility(8);
            AppMethodBeat.o(105116);
            return;
        }
        this.oON.setVisibility(0);
        this.oOP.setVisibility(0);
        AppMethodBeat.o(105116);
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(105117);
        ab.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", Integer.valueOf(i));
        if (((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bUc()) {
            this.oOR.setCanSlide(false);
        }
        this.eet.removeCallbacksAndMessages(null);
        this.eet.postDelayed(new a(i), 500);
        if (this.oOX == -1) {
            this.oOX = i;
        }
        if (this.oOX != i) {
            this.oOX = i;
            com.tencent.mm.plugin.music.model.d.d.oNi = true;
            h.pYm.a(285, 3, 1, false);
            com.tencent.mm.plugin.music.model.d.d.eJ(1, this.scene);
        }
        AppMethodBeat.o(105117);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(105118);
        if (-1 == i2 && 1 == i) {
            com.tencent.mm.aw.e bTQ = k.bUf().bTQ();
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            WXMusicObject wXMusicObject = new WXMusicObject();
            wXMusicObject.musicUrl = bTQ.fKc;
            wXMusicObject.musicDataUrl = bTQ.fKa;
            wXMusicObject.musicLowBandUrl = bTQ.fKb;
            wXMusicObject.musicLowBandDataUrl = bTQ.fKb;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXMusicObject;
            wXMediaMessage.title = bTQ.fJW;
            wXMediaMessage.description = bTQ.fJX;
            Bitmap bitmap = null;
            String u = d.u(bTQ);
            if (u != null && com.tencent.mm.vfs.e.ct(u)) {
                int dimension = (int) getResources().getDimension(R.dimen.lw);
                bitmap = com.tencent.mm.sdk.platformtools.d.ap(u, dimension, dimension);
            }
            if (bitmap != null) {
                wXMediaMessage.thumbData = bo.an(bitmap);
            } else {
                wXMediaMessage.thumbData = bo.an(com.tencent.mm.sdk.platformtools.d.LV(R.drawable.b27));
            }
            com.tencent.mm.plugin.music.model.b.gkE.a(this, d.v(bTQ), wXMediaMessage, stringExtra, d.w(bTQ));
            ab.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", stringExtra);
            AppMethodBeat.o(105118);
            return;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(105118);
    }

    private void bUS() {
        AppMethodBeat.i(105119);
        int bTi = k.bUf().bTS().bTi();
        int duration = k.bUf().bTS().getDuration();
        if (bTi > 0 && duration > 0) {
            this.oOQ.setProgress(bTi);
            this.oOQ.setMaxProgress(duration);
        }
        AppMethodBeat.o(105119);
    }

    public final void i(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(105120);
        com.tencent.mm.plugin.music.model.e.a bTU = ((e) com.tencent.mm.plugin.music.f.c.b.ar(e.class)).bTU();
        if (bTU == null) {
            AppMethodBeat.o(105120);
            return;
        }
        if (!(!bTU.g(aVar) || this.oOP == null || this.oOO == null || this.oON == null || this.oOP.getBackground() == null || this.oOO.getBackground() == null || this.oON.getBackground() == null || this.oOQ == null)) {
            if (aVar.bUu()) {
                int i = aVar.field_songLyricColor;
                this.oOP.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oOO.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oON.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oOQ.setColor(i);
                AppMethodBeat.o(105120);
                return;
            }
            this.oOP.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oOO.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oON.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oOQ.setColor(-1);
        }
        AppMethodBeat.o(105120);
    }

    public void onClickSend(View view) {
        AppMethodBeat.i(105115);
        final com.tencent.mm.aw.e bTQ = k.bUf().bTQ();
        ab.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", Integer.valueOf(bTQ.fJS), bTQ.fKc);
        if (bTQ.fJS == 11) {
            gk gkVar = new gk();
            com.tencent.mm.sdk.b.a.xxA.m(gkVar);
            final String str = gkVar.cBa.appId;
            String str2 = gkVar.cBa.cwz;
            final String str3 = gkVar.cBa.cBb;
            final int i = gkVar.cBa.cBc;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            ab.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", str, str2, Integer.valueOf(i), str3);
            str2 = getString(R.string.c9v, new Object[]{str2});
            if (TextUtils.isEmpty(bTQ.fKc)) {
                String[] strArr = new String[]{str2};
                new ArrayList().add(Integer.valueOf(0));
                com.tencent.mm.ui.base.h.a((Context) this, "", strArr, "", new com.tencent.mm.ui.base.h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(105101);
                        switch (i) {
                            case 0:
                                d.H(str, str3, i);
                                break;
                        }
                        AppMethodBeat.o(105101);
                    }
                });
                AppMethodBeat.o(105115);
                return;
            }
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(R.string.d44), getString(R.string.d45), getString(R.string.akj), str2};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr2, "", new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(105100);
                    switch (i) {
                        case 0:
                            d.S(MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zO(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.d.zQ(2);
                            AppMethodBeat.o(105100);
                            return;
                        case 1:
                            d.b(bTQ, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zP(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.d.zQ(1);
                            AppMethodBeat.o(105100);
                            return;
                        case 2:
                            d.a(bTQ, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zQ(3);
                            AppMethodBeat.o(105100);
                            return;
                        case 3:
                            d.H(str, str3, i);
                            break;
                    }
                    AppMethodBeat.o(105100);
                }
            });
            AppMethodBeat.o(105115);
            return;
        }
        if (!TextUtils.isEmpty(bTQ.fKc)) {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(R.string.d44), getString(R.string.d45), getString(R.string.akj), getString(R.string.bnj)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr3, "", new com.tencent.mm.ui.base.h.c() {
                public final void iE(int i) {
                    AppMethodBeat.i(105102);
                    switch (i) {
                        case 0:
                            d.S(MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zO(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.d.zQ(2);
                            AppMethodBeat.o(105102);
                            return;
                        case 1:
                            d.b(bTQ, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zP(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.d.zQ(1);
                            AppMethodBeat.o(105102);
                            return;
                        case 2:
                            d.a(bTQ, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.d.zQ(3);
                            AppMethodBeat.o(105102);
                            return;
                        case 3:
                            com.tencent.mm.aw.e eVar = bTQ;
                            Context context = MusicMainUI.this;
                            h.pYm.X(10910, "4");
                            if (eVar != null) {
                                String str;
                                String str2 = eVar.fKc;
                                int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
                                if (indexOf < 0) {
                                    str = null;
                                } else {
                                    str = str2.substring(indexOf + 3);
                                }
                                if (str == null) {
                                    ab.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", str2);
                                    str = "androidqqmusic://";
                                } else {
                                    ab.i("MicroMsg.Music.MusicUtil", "get qq music data %s", str);
                                    str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
                                }
                                Uri parse = Uri.parse(str);
                                if (parse == null) {
                                    ab.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", str);
                                } else {
                                    com.tencent.mm.aw.a.aic();
                                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                                    intent.addFlags(268435456);
                                    if (bo.k(context, intent)) {
                                        context.startActivity(intent);
                                    } else {
                                        intent = new Intent();
                                        intent.putExtra("rawUrl", str2);
                                        com.tencent.mm.plugin.music.model.b.gkE.i(intent, context);
                                    }
                                }
                            }
                            com.tencent.mm.plugin.music.model.d.d.zQ(4);
                            break;
                    }
                    AppMethodBeat.o(105102);
                }
            });
        }
        AppMethodBeat.o(105115);
    }
}
